package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* loaded from: classes.dex */
public final class ChannelKt {
    public static final <E> Channel<E> Channel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        Channel<E> bufferedChannel;
        if (i == -2) {
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), function1) : new ConflatedBufferedChannel<>(1, bufferOverflow, function1);
        } else if (i == -1) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, function1);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        } else if (i != 0) {
            if (i != Integer.MAX_VALUE) {
                return bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(i, function1) : new ConflatedBufferedChannel(i, bufferOverflow, function1);
            }
            return new BufferedChannel(Integer.MAX_VALUE, function1);
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            bufferedChannel = new BufferedChannel<>(0, function1);
        } else {
            bufferedChannel = new ConflatedBufferedChannel<>(1, bufferOverflow, function1);
        }
        return bufferedChannel;
    }

    public static /* synthetic */ Channel Channel$default(int i, BufferOverflow bufferOverflow, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i5 & 4) != 0) {
            function1 = null;
        }
        return Channel(i, bufferOverflow, function1);
    }
}
