package androidx.work.impl;

import androidx.work.WorkerParameters;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WorkLauncher.kt */
/* loaded from: classes.dex */
public interface WorkLauncher {
    void startWork(StartStopToken startStopToken);

    void startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras);

    void stopWork(StartStopToken startStopToken);

    void stopWork(StartStopToken startStopToken, int i);

    void stopWorkWithReason(StartStopToken startStopToken, int i);

    /* compiled from: WorkLauncher.kt */
    /* renamed from: androidx.work.impl.WorkLauncher$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static void $default$startWork(WorkLauncher workLauncher, StartStopToken workSpecId) {
            Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
            workLauncher.startWork(workSpecId, null);
        }

        public static void $default$stopWork(WorkLauncher workLauncher, StartStopToken workSpecId) {
            Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
            workLauncher.stopWork(workSpecId, -512);
        }

        public static void $default$stopWorkWithReason(WorkLauncher workLauncher, StartStopToken workSpecId, int i) {
            Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
            workLauncher.stopWork(workSpecId, i);
        }
    }
}
