package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;
/* loaded from: classes.dex */
public final class SharedFlowKt {
    public static final Symbol NO_VALUE = new Symbol("NO_VALUE");

    public static final <T> MutableSharedFlow<T> MutableSharedFlow(int i, int i5, BufferOverflow bufferOverflow) {
        if (i >= 0) {
            if (i5 >= 0) {
                if (i <= 0 && i5 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                    throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
                }
                int i6 = i5 + i;
                if (i6 < 0) {
                    i6 = Integer.MAX_VALUE;
                }
                return new SharedFlowImpl(i, i6, bufferOverflow);
            }
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i5).toString());
        }
        throw new IllegalArgumentException(("replay cannot be negative, but was " + i).toString());
    }

    public static /* synthetic */ MutableSharedFlow MutableSharedFlow$default(int i, int i5, BufferOverflow bufferOverflow, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return MutableSharedFlow(i, i5, bufferOverflow);
    }

    public static final /* synthetic */ Object access$getBufferAt(Object[] objArr, long j2) {
        return getBufferAt(objArr, j2);
    }

    public static final /* synthetic */ void access$setBufferAt(Object[] objArr, long j2, Object obj) {
        setBufferAt(objArr, j2, obj);
    }

    public static final <T> Flow<T> fuseSharedFlow(SharedFlow<? extends T> sharedFlow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        if ((i == 0 || i == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return sharedFlow;
        }
        return new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getBufferAt(Object[] objArr, long j2) {
        return objArr[(objArr.length - 1) & ((int) j2)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBufferAt(Object[] objArr, long j2, Object obj) {
        objArr[(objArr.length - 1) & ((int) j2)] = obj;
    }
}
