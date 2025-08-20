package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StopWorkRunnable.kt */
/* loaded from: classes.dex */
public final class StopWorkRunnable implements Runnable {
    private final Processor processor;
    private final int reason;
    private final boolean stopInForeground;
    private final StartStopToken token;

    public StopWorkRunnable(Processor processor, StartStopToken token, boolean z, int i) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(token, "token");
        this.processor = processor;
        this.token = token;
        this.stopInForeground = z;
        this.reason = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(Processor processor, StartStopToken token, boolean z) {
        this(processor, token, z, -512);
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(token, "token");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean stopWork;
        if (this.stopInForeground) {
            stopWork = this.processor.stopForegroundWork(this.token, this.reason);
        } else {
            stopWork = this.processor.stopWork(this.token, this.reason);
        }
        Logger logger = Logger.get();
        String tagWithPrefix = Logger.tagWithPrefix("StopWorkRunnable");
        logger.debug(tagWithPrefix, "StopWorkRunnable for " + this.token.getId().getWorkSpecId() + "; Processor.stopWork = " + stopWork);
    }
}
