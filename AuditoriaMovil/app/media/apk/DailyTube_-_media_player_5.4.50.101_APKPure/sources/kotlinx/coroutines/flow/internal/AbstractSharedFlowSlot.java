package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean allocateLocked(F f4);

    public abstract Continuation<Unit>[] freeLocked(F f4);
}
