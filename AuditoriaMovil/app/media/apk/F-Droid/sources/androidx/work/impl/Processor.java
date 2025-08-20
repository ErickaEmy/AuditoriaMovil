package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes.dex */
public class Processor implements ForegroundProcessor {
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Configuration mConfiguration;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;
    private Map mEnqueuedWorkMap = new HashMap();
    private Map mForegroundWorkMap = new HashMap();
    private Set mCancelledIds = new HashSet();
    private final List mOuterListeners = new ArrayList();
    private PowerManager.WakeLock mForegroundLock = null;
    private final Object mLock = new Object();
    private Map mWorkRuns = new HashMap();

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
    }

    public boolean startWork(StartStopToken startStopToken) {
        return startWork(startStopToken, null);
    }

    public boolean startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        WorkGenerationalId id = startStopToken.getId();
        final String workSpecId = id.getWorkSpecId();
        final ArrayList arrayList = new ArrayList();
        WorkSpec workSpec = (WorkSpec) this.mWorkDatabase.runInTransaction(new Callable() { // from class: androidx.work.impl.Processor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkSpec lambda$startWork$0;
                lambda$startWork$0 = Processor.this.lambda$startWork$0(arrayList, workSpecId);
                return lambda$startWork$0;
            }
        });
        if (workSpec == null) {
            Logger logger = Logger.get();
            String str = TAG;
            logger.warning(str, "Didn't find WorkSpec for id " + id);
            runOnExecuted(id, false);
            return false;
        }
        synchronized (this.mLock) {
            try {
                if (isEnqueued(workSpecId)) {
                    Set set = (Set) this.mWorkRuns.get(workSpecId);
                    if (((StartStopToken) set.iterator().next()).getId().getGeneration() == id.getGeneration()) {
                        set.add(startStopToken);
                        Logger logger2 = Logger.get();
                        String str2 = TAG;
                        logger2.debug(str2, "Work " + id + " is already enqueued for processing");
                    } else {
                        runOnExecuted(id, false);
                    }
                    return false;
                } else if (workSpec.getGeneration() != id.getGeneration()) {
                    runOnExecuted(id, false);
                    return false;
                } else {
                    final WorkerWrapper build = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, workSpec, arrayList).withRuntimeExtras(runtimeExtras).build();
                    final ListenableFuture future = build.getFuture();
                    future.addListener(new Runnable() { // from class: androidx.work.impl.Processor$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Processor.this.lambda$startWork$1(future, build);
                        }
                    }, this.mWorkTaskExecutor.getMainThreadExecutor());
                    this.mEnqueuedWorkMap.put(workSpecId, build);
                    HashSet hashSet = new HashSet();
                    hashSet.add(startStopToken);
                    this.mWorkRuns.put(workSpecId, hashSet);
                    this.mWorkTaskExecutor.getSerialTaskExecutor().execute(build);
                    Logger logger3 = Logger.get();
                    String str3 = TAG;
                    logger3.debug(str3, getClass().getSimpleName() + ": processing " + id);
                    return true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WorkSpec lambda$startWork$0(ArrayList arrayList, String str) {
        arrayList.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(str));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startWork$1(ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        boolean z;
        try {
            z = ((Boolean) listenableFuture.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            z = true;
        }
        onExecuted(workerWrapper, z);
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger logger = Logger.get();
                String str2 = TAG;
                logger.info(str2, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapper = (WorkerWrapper) this.mEnqueuedWorkMap.remove(str);
                if (workerWrapper != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, "ProcessorForegroundLck");
                        this.mForegroundLock = newWakeLock;
                        newWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, workerWrapper);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, workerWrapper.getWorkGenerationalId(), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean stopForegroundWork(StartStopToken startStopToken, int i) {
        WorkerWrapper cleanUpWorkerUnsafe;
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(workSpecId);
        }
        return interrupt(workSpecId, cleanUpWorkerUnsafe, i);
    }

    public boolean stopWork(StartStopToken startStopToken, int i) {
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.get(workSpecId) != null) {
                    Logger logger = Logger.get();
                    String str = TAG;
                    logger.debug(str, "Ignored stopWork. WorkerWrapper " + workSpecId + " is in foreground");
                    return false;
                }
                Set set = (Set) this.mWorkRuns.get(workSpecId);
                if (set != null && set.contains(startStopToken)) {
                    return interrupt(workSpecId, cleanUpWorkerUnsafe(workSpecId), i);
                }
                return false;
            } finally {
            }
        }
    }

    public boolean stopAndCancelWork(String str, int i) {
        WorkerWrapper cleanUpWorkerUnsafe;
        synchronized (this.mLock) {
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "Processor cancelling " + str);
            this.mCancelledIds.add(str);
            cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(str);
        }
        return interrupt(str, cleanUpWorkerUnsafe, i);
    }

    public boolean isCancelled(String str) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mCancelledIds.contains(str);
        }
        return contains;
    }

    public boolean isEnqueued(String str) {
        boolean z;
        synchronized (this.mLock) {
            z = getWorkerWrapperUnsafe(str) != null;
        }
        return z;
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    private void onExecuted(WorkerWrapper workerWrapper, boolean z) {
        synchronized (this.mLock) {
            try {
                WorkGenerationalId workGenerationalId = workerWrapper.getWorkGenerationalId();
                String workSpecId = workGenerationalId.getWorkSpecId();
                if (getWorkerWrapperUnsafe(workSpecId) == workerWrapper) {
                    cleanUpWorkerUnsafe(workSpecId);
                }
                Logger logger = Logger.get();
                String str = TAG;
                logger.debug(str, getClass().getSimpleName() + " " + workSpecId + " executed; reschedule = " + z);
                for (ExecutionListener executionListener : this.mOuterListeners) {
                    executionListener.onExecuted(workGenerationalId, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private WorkerWrapper getWorkerWrapperUnsafe(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.mForegroundWorkMap.get(str);
        return workerWrapper == null ? (WorkerWrapper) this.mEnqueuedWorkMap.get(str) : workerWrapper;
    }

    public WorkSpec getRunningWorkSpec(String str) {
        synchronized (this.mLock) {
            try {
                WorkerWrapper workerWrapperUnsafe = getWorkerWrapperUnsafe(str);
                if (workerWrapperUnsafe != null) {
                    return workerWrapperUnsafe.getWorkSpec();
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runOnExecuted(final WorkGenerationalId workGenerationalId, final boolean z) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new Runnable() { // from class: androidx.work.impl.Processor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Processor.this.lambda$runOnExecuted$2(workGenerationalId, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runOnExecuted$2(WorkGenerationalId workGenerationalId, boolean z) {
        synchronized (this.mLock) {
            try {
                for (ExecutionListener executionListener : this.mOuterListeners) {
                    executionListener.onExecuted(workGenerationalId, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (!(!this.mForegroundWorkMap.isEmpty())) {
                    this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private WorkerWrapper cleanUpWorkerUnsafe(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.mForegroundWorkMap.remove(str);
        boolean z = workerWrapper != null;
        if (!z) {
            workerWrapper = (WorkerWrapper) this.mEnqueuedWorkMap.remove(str);
        }
        this.mWorkRuns.remove(str);
        if (z) {
            stopForegroundService();
        }
        return workerWrapper;
    }

    private static boolean interrupt(String str, WorkerWrapper workerWrapper, int i) {
        if (workerWrapper != null) {
            workerWrapper.interrupt(i);
            Logger logger = Logger.get();
            String str2 = TAG;
            logger.debug(str2, "WorkerWrapper interrupted for " + str);
            return true;
        }
        Logger logger2 = Logger.get();
        String str3 = TAG;
        logger2.debug(str3, "WorkerWrapper could not be found for " + str);
        return false;
    }
}
