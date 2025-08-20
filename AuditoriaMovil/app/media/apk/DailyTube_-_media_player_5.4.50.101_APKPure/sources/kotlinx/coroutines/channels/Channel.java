package kotlinx.coroutines.channels;

import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.SystemPropsKt;
/* loaded from: classes.dex */
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final Factory Factory = Factory.$$INSTANCE;

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static <E> boolean offer(Channel<E> channel, E e2) {
            return SendChannel.DefaultImpls.offer(channel, e2);
        }
    }

    /* loaded from: classes.dex */
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();
        private static final int CHANNEL_DEFAULT_CAPACITY = SystemPropsKt.systemProp("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private Factory() {
        }

        public final int getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() {
            return CHANNEL_DEFAULT_CAPACITY;
        }
    }
}
