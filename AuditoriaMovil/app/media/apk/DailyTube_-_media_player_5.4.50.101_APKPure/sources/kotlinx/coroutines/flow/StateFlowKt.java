package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
/* loaded from: classes.dex */
public final class StateFlowKt {
    private static final Symbol NONE = new Symbol("NONE");
    private static final Symbol PENDING = new Symbol("PENDING");

    public static final <T> MutableStateFlow<T> MutableStateFlow(T t2) {
        if (t2 == null) {
            t2 = (T) NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(t2);
    }

    public static final <T> Flow<T> fuseStateFlow(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        if (DebugKt.getASSERTIONS_ENABLED() && i == -1) {
            throw new AssertionError();
        }
        if (((i >= 0 && i < 2) || i == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return stateFlow;
        }
        return SharedFlowKt.fuseSharedFlow(stateFlow, coroutineContext, i, bufferOverflow);
    }
}
