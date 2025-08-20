package org.fdroid.fdroid.work;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.NotificationManager;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.RepoUpdateManager;
import org.fdroid.fdroid.net.ConnectivityMonitorService;
/* compiled from: RepoUpdateWorker.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lorg/fdroid/fdroid/work/RepoUpdateWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "nm", "Lorg/fdroid/fdroid/NotificationManager;", "repoUpdateManager", "Lorg/fdroid/fdroid/RepoUpdateManager;", "kotlin.jvm.PlatformType", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForegroundInfo", "Landroidx/work/ForegroundInfo;", "Companion", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoUpdateWorker extends CoroutineWorker {
    private static final String UNIQUE_WORK_NAME_AUTO_UPDATE = "autoUpdate";
    private final NotificationManager nm;
    private final RepoUpdateManager repoUpdateManager;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static final void scheduleOrCancel(Context context) {
        Companion.scheduleOrCancel(context);
    }

    public static final void updateNow(Context context) {
        Companion.updateNow(context);
    }

    public static final void updateNow(Context context, long j) {
        Companion.updateNow(context, j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoUpdateWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.nm = new NotificationManager(appContext);
        this.repoUpdateManager = FDroidApp.getRepoUpdateManager(appContext);
    }

    /* compiled from: RepoUpdateWorker.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lorg/fdroid/fdroid/work/RepoUpdateWorker$Companion;", "", "()V", "UNIQUE_WORK_NAME_AUTO_UPDATE", "", "getAutoUpdateWorkInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/work/WorkInfo;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "scheduleOrCancel", "", "updateNow", "repoId", "", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void updateNow(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            updateNow$default(this, context, 0L, 2, null);
        }

        public static /* synthetic */ void updateNow$default(Companion companion, Context context, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = -1;
            }
            companion.updateNow(context, j);
        }

        public final void updateNow(Context context, long j) {
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            str = RepoUpdateWorkerKt.TAG;
            Log.i(str, "Update repo with ID " + j + " now!");
            if (FDroidApp.networkState > 0 && !Preferences.get().isOnDemandDownloadAllowed()) {
                Toast.makeText(context, R.string.updates_disabled_by_settings, 1).show();
            } else if (ConnectivityMonitorService.getNetworkState(context) == 0) {
                Toast.makeText(context, R.string.warning_no_internet, 1).show();
            } else {
                OneTimeWorkRequest.Builder builder = (OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(RepoUpdateWorker.class).setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST);
                if (j >= 0) {
                    Pair[] pairArr = {TuplesKt.to("repoId", Long.valueOf(j))};
                    Data.Builder builder2 = new Data.Builder();
                    Pair pair = pairArr[0];
                    builder2.put((String) pair.getFirst(), pair.getSecond());
                    Data build = builder2.build();
                    Intrinsics.checkNotNullExpressionValue(build, "dataBuilder.build()");
                    builder.setInputData(build);
                }
                WorkManager.getInstance(context).enqueue((OneTimeWorkRequest) builder.build());
            }
        }

        public final void scheduleOrCancel(Context context) {
            String str;
            NetworkType networkType;
            Intrinsics.checkNotNullParameter(context, "context");
            Preferences preferences = Preferences.get();
            WorkManager workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(...)");
            if (preferences.getUpdateInterval() != Preferences.UPDATE_INTERVAL_DISABLED && (preferences.getOverData() != 0 || preferences.getOverWifi() != 0)) {
                if (preferences.getOverData() == 2 && preferences.getOverWifi() == 2) {
                    networkType = NetworkType.CONNECTED;
                } else {
                    networkType = NetworkType.UNMETERED;
                }
                Constraints build = new Constraints.Builder().setRequiresBatteryNotLow(true).setRequiresStorageNotLow(true).setRequiredNetworkType(networkType).build();
                workManager.enqueueUniquePeriodicWork(RepoUpdateWorker.UNIQUE_WORK_NAME_AUTO_UPDATE, ExistingPeriodicWorkPolicy.UPDATE, (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(RepoUpdateWorker.class, preferences.getUpdateInterval(), TimeUnit.MILLISECONDS, 15L, TimeUnit.MINUTES).setConstraints(build)).build());
                return;
            }
            str = RepoUpdateWorkerKt.TAG;
            Log.w(str, "Not scheduling job due to settings!");
            workManager.cancelUniqueWork(RepoUpdateWorker.UNIQUE_WORK_NAME_AUTO_UPDATE);
        }

        public final Flow getAutoUpdateWorkInfo(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            final Flow workInfosForUniqueWorkFlow = WorkManager.getInstance(context).getWorkInfosForUniqueWorkFlow(RepoUpdateWorker.UNIQUE_WORK_NAME_AUTO_UPDATE);
            Intrinsics.checkNotNullExpressionValue(workInfosForUniqueWorkFlow, "getWorkInfosForUniqueWorkFlow(...)");
            return new Flow() { // from class: org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector flowCollector, Continuation continuation) {
                    Object coroutine_suspended;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    return collect == coroutine_suspended ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", Action.VALUE_ATTRIBUTE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
                /* renamed from: org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1$2", f = "RepoUpdateWorker.kt", l = {223}, m = "emit")
                    /* renamed from: org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1$2$1 r0 = (org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1$2$1 r0 = new org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L49
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                            java.util.List r5 = (java.util.List) r5
                            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                            r2 = 0
                            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r5, r2)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L49
                            return r1
                        L49:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.work.RepoUpdateWorker$Companion$getAutoUpdateWorkInfo$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a A[Catch: Exception -> 0x0090, TRY_ENTER, TryCatch #0 {Exception -> 0x0090, blocks: (B:38:0x008a, B:42:0x0097, B:41:0x0092), top: B:46:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092 A[Catch: Exception -> 0x0090, TryCatch #0 {Exception -> 0x0090, blocks: (B:38:0x008a, B:42:0x0097, B:41:0x0092), top: B:46:0x0088 }] */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof org.fdroid.fdroid.work.RepoUpdateWorker$doWork$1
            if (r0 == 0) goto L13
            r0 = r7
            org.fdroid.fdroid.work.RepoUpdateWorker$doWork$1 r0 = (org.fdroid.fdroid.work.RepoUpdateWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            org.fdroid.fdroid.work.RepoUpdateWorker$doWork$1 r0 = new org.fdroid.fdroid.work.RepoUpdateWorker$doWork$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r0 = r0.L$0
            org.fdroid.fdroid.work.RepoUpdateWorker r0 = (org.fdroid.fdroid.work.RepoUpdateWorker) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L30
            goto L78
        L30:
            r7 = move-exception
            goto L6f
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3a:
            java.lang.Object r2 = r0.L$1
            org.fdroid.fdroid.work.RepoUpdateWorker r2 = (org.fdroid.fdroid.work.RepoUpdateWorker) r2
            java.lang.Object r4 = r0.L$0
            org.fdroid.fdroid.work.RepoUpdateWorker r4 = (org.fdroid.fdroid.work.RepoUpdateWorker) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L46
            goto L5b
        L46:
            r7 = move-exception
            r0 = r4
            goto L6f
        L49:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6     // Catch: java.lang.Exception -> L6d
            r0.L$1 = r6     // Catch: java.lang.Exception -> L6d
            r0.label = r4     // Catch: java.lang.Exception -> L6d
            java.lang.Object r7 = r6.getForegroundInfo(r0)     // Catch: java.lang.Exception -> L6d
            if (r7 != r1) goto L59
            return r1
        L59:
            r2 = r6
            r4 = r2
        L5b:
            androidx.work.ForegroundInfo r7 = (androidx.work.ForegroundInfo) r7     // Catch: java.lang.Exception -> L46
            r0.L$0 = r4     // Catch: java.lang.Exception -> L46
            r5 = 0
            r0.L$1 = r5     // Catch: java.lang.Exception -> L46
            r0.label = r3     // Catch: java.lang.Exception -> L46
            java.lang.Object r7 = r2.setForeground(r7, r0)     // Catch: java.lang.Exception -> L46
            if (r7 != r1) goto L6b
            return r1
        L6b:
            r0 = r4
            goto L78
        L6d:
            r7 = move-exception
            r0 = r6
        L6f:
            java.lang.String r1 = org.fdroid.fdroid.work.RepoUpdateWorkerKt.access$getTAG$p()
            java.lang.String r2 = "Error while running setForeground"
            android.util.Log.e(r1, r2, r7)
        L78:
            androidx.work.Data r7 = r0.getInputData()
            java.lang.String r1 = "repoId"
            r2 = -1
            long r1 = r7.getLong(r1, r2)
            r3 = 0
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 < 0) goto L92
            org.fdroid.fdroid.RepoUpdateManager r7 = r0.repoUpdateManager     // Catch: java.lang.Exception -> L90
            r7.updateRepo(r1)     // Catch: java.lang.Exception -> L90
            goto L97
        L90:
            r7 = move-exception
            goto L9f
        L92:
            org.fdroid.fdroid.RepoUpdateManager r7 = r0.repoUpdateManager     // Catch: java.lang.Exception -> L90
            r7.updateRepos()     // Catch: java.lang.Exception -> L90
        L97:
            androidx.work.ListenableWorker$Result r7 = androidx.work.ListenableWorker.Result.success()     // Catch: java.lang.Exception -> L90
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.Exception -> L90
            goto Laf
        L9f:
            java.lang.String r0 = org.fdroid.fdroid.work.RepoUpdateWorkerKt.access$getTAG$p()
            java.lang.String r1 = "Error updating repos"
            android.util.Log.e(r0, r1, r7)
            androidx.work.ListenableWorker$Result r7 = androidx.work.ListenableWorker.Result.failure()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
        Laf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.work.RepoUpdateWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.work.CoroutineWorker
    public Object getForegroundInfo(Continuation continuation) {
        Notification build = NotificationManager.getRepoUpdateNotification$default(this.nm, null, null, 3, null).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        if (Build.VERSION.SDK_INT >= 29) {
            return new ForegroundInfo(0, build, 1);
        }
        return new ForegroundInfo(0, build);
    }
}
