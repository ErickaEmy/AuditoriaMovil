package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
/* loaded from: classes.dex */
public interface SendChannel<E> {

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return sendChannel.close(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <E> boolean offer(SendChannel<? super E> sendChannel, E e2) {
            Object mo85trySendJP2dKIU = sendChannel.mo85trySendJP2dKIU(e2);
            if (ChannelResult.m93isSuccessimpl(mo85trySendJP2dKIU)) {
                return true;
            }
            Throwable m89exceptionOrNullimpl = ChannelResult.m89exceptionOrNullimpl(mo85trySendJP2dKIU);
            if (m89exceptionOrNullimpl == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(m89exceptionOrNullimpl);
        }
    }

    boolean close(Throwable th);

    void invokeOnClose(Function1<? super Throwable, Unit> function1);

    boolean isClosedForSend();

    boolean offer(E e2);

    Object send(E e2, Continuation<? super Unit> continuation);

    /* renamed from: trySend-JP2dKIU */
    Object mo85trySendJP2dKIU(E e2);
}
