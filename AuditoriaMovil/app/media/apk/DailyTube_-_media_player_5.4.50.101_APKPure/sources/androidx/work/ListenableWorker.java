package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import f1.zn;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import l.a;
import l.i4;
/* loaded from: classes.dex */
public abstract class ListenableWorker {
    @NonNull
    private Context mAppContext;
    private boolean mRunInForeground;
    private volatile boolean mStopped;
    private boolean mUsed;
    @NonNull
    private WorkerParameters mWorkerParams;

    /* loaded from: classes.dex */
    public static abstract class y {

        /* loaded from: classes.dex */
        public static final class n3 extends y {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && n3.class == obj.getClass()) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return n3.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        /* renamed from: androidx.work.ListenableWorker$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0028y extends y {
            public final androidx.work.n3 y;

            public C0028y() {
                this(androidx.work.n3.f3773zn);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && C0028y.class == obj.getClass()) {
                    return this.y.equals(((C0028y) obj).y);
                }
                return false;
            }

            public int hashCode() {
                return (C0028y.class.getName().hashCode() * 31) + this.y.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.y + '}';
            }

            @NonNull
            public androidx.work.n3 v() {
                return this.y;
            }

            public C0028y(@NonNull androidx.work.n3 n3Var) {
                this.y = n3Var;
            }
        }

        /* loaded from: classes.dex */
        public static final class zn extends y {
            public final androidx.work.n3 y;

            public zn() {
                this(androidx.work.n3.f3773zn);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && zn.class == obj.getClass()) {
                    return this.y.equals(((zn) obj).y);
                }
                return false;
            }

            public int hashCode() {
                return (zn.class.getName().hashCode() * 31) + this.y.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.y + '}';
            }

            @NonNull
            public androidx.work.n3 v() {
                return this.y;
            }

            public zn(@NonNull androidx.work.n3 n3Var) {
                this.y = n3Var;
            }
        }

        @NonNull
        public static y gv(@NonNull androidx.work.n3 n3Var) {
            return new zn(n3Var);
        }

        @NonNull
        public static y n3() {
            return new n3();
        }

        @NonNull
        public static y y() {
            return new C0028y();
        }

        @NonNull
        public static y zn() {
            return new zn();
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        if (context != null) {
            if (workerParameters != null) {
                this.mAppContext = context;
                this.mWorkerParams = workerParameters;
                return;
            }
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        throw new IllegalArgumentException("Application Context is null");
    }

    @NonNull
    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    @NonNull
    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.y();
    }

    @NonNull
    public zn<a> getForegroundInfoAsync() {
        ro.zn co2 = ro.zn.co();
        co2.w(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return co2;
    }

    @NonNull
    public final UUID getId() {
        return this.mWorkerParams.zn();
    }

    @NonNull
    public final n3 getInputData() {
        return this.mWorkerParams.gv();
    }

    @Nullable
    public final Network getNetwork() {
        return this.mWorkerParams.v();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.fb();
    }

    @NonNull
    public final Set<String> getTags() {
        return this.mWorkerParams.s();
    }

    @NonNull
    public ix.y getTaskExecutor() {
        return this.mWorkerParams.c5();
    }

    @NonNull
    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.i9();
    }

    @NonNull
    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.f();
    }

    @NonNull
    public i4 getWorkerFactory() {
        return this.mWorkerParams.t();
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    @NonNull
    public final zn<Void> setForegroundAsync(@NonNull a aVar) {
        this.mRunInForeground = true;
        return this.mWorkerParams.n3().y(getApplicationContext(), getId(), aVar);
    }

    @NonNull
    public zn<Void> setProgressAsync(@NonNull n3 n3Var) {
        return this.mWorkerParams.a().y(getApplicationContext(), getId(), n3Var);
    }

    public void setRunInForeground(boolean z2) {
        this.mRunInForeground = z2;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    @NonNull
    public abstract zn<y> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }
}
