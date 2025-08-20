package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
/* loaded from: classes.dex */
public final class SharedFlowSlot extends AbstractSharedFlowSlot<SharedFlowImpl<?>> {
    public Continuation<? super Unit> cont;
    public long index = -1;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(SharedFlowImpl<?> sharedFlowImpl) {
        if (this.index >= 0) {
            return false;
        }
        this.index = sharedFlowImpl.updateNewCollectorIndexLocked$kotlinx_coroutines_core();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation<Unit>[] freeLocked(SharedFlowImpl<?> sharedFlowImpl) {
        if (!DebugKt.getASSERTIONS_ENABLED() || this.index >= 0) {
            long j2 = this.index;
            this.index = -1L;
            this.cont = null;
            return sharedFlowImpl.updateCollectorIndexLocked$kotlinx_coroutines_core(j2);
        }
        throw new AssertionError();
    }
}
