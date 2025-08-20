package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StartWorkRunnable.kt */
/* loaded from: classes.dex */
public final class StartWorkRunnable implements Runnable {
    private final Processor processor;
    private final WorkerParameters.RuntimeExtras runtimeExtras;
    private final StartStopToken startStopToken;

    public StartWorkRunnable(Processor processor, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(startStopToken, "startStopToken");
        this.processor = processor;
        this.startStopToken = startStopToken;
        this.runtimeExtras = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.processor.startWork(this.startStopToken, this.runtimeExtras);
    }
}
