package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;
import r.n3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    private volatile Object _state;

    public final Object awaitPending(Continuation<? super Unit> continuation) {
        Symbol symbol;
        Symbol symbol2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (!DebugKt.getASSERTIONS_ENABLED() || !(_state$FU.get(this) instanceof CancellableContinuationImpl)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            symbol = StateFlowKt.NONE;
            if (!n3.y(atomicReferenceFieldUpdater, this, symbol, cancellableContinuationImpl)) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    Object obj = _state$FU.get(this);
                    symbol2 = StateFlowKt.PENDING;
                    if (obj != symbol2) {
                        throw new AssertionError();
                    }
                }
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }
        throw new AssertionError();
    }

    public final void makePending() {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                symbol = StateFlowKt.PENDING;
                if (obj != symbol) {
                    symbol2 = StateFlowKt.NONE;
                    if (obj == symbol2) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                        symbol3 = StateFlowKt.PENDING;
                        if (n3.y(atomicReferenceFieldUpdater2, this, obj, symbol3)) {
                            return;
                        }
                    } else {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = _state$FU;
                        symbol4 = StateFlowKt.NONE;
                        if (n3.y(atomicReferenceFieldUpdater3, this, obj, symbol4)) {
                            Result.Companion companion = Result.Companion;
                            ((CancellableContinuationImpl) obj).resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean takePending() {
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        symbol = StateFlowKt.NONE;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, symbol);
        Intrinsics.checkNotNull(andSet);
        if (!DebugKt.getASSERTIONS_ENABLED() || !(andSet instanceof CancellableContinuationImpl)) {
            symbol2 = StateFlowKt.PENDING;
            if (andSet == symbol2) {
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(StateFlowImpl<?> stateFlowImpl) {
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        symbol = StateFlowKt.NONE;
        atomicReferenceFieldUpdater.set(this, symbol);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation<Unit>[] freeLocked(StateFlowImpl<?> stateFlowImpl) {
        _state$FU.set(this, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }
}
