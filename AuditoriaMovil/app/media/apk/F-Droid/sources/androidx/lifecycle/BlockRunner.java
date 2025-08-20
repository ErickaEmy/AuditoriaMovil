package androidx.lifecycle;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
/* compiled from: CoroutineLiveData.kt */
/* loaded from: classes.dex */
public final class BlockRunner {
    private final Function2 block;
    private Job cancellationJob;
    private final CoroutineLiveData liveData;
    private final Function0 onDone;
    private Job runningJob;
    private final CoroutineScope scope;
    private final long timeoutInMs;

    public BlockRunner(CoroutineLiveData liveData, Function2 block, long j, CoroutineScope scope, Function0 onDone) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        this.liveData = liveData;
        this.block = block;
        this.timeoutInMs = j;
        this.scope = scope;
        this.onDone = onDone;
    }

    public final void maybeRun() {
        Job launch$default;
        Job job = this.cancellationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
        this.runningJob = launch$default;
    }

    public final void cancel() {
        Job launch$default;
        if (this.cancellationJob == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getMain().getImmediate(), null, new BlockRunner$cancel$1(this, null), 2, null);
            this.cancellationJob = launch$default;
            return;
        }
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
    }
}
