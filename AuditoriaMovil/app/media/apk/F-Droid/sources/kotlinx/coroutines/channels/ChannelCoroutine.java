package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
/* compiled from: ChannelCoroutine.kt */
/* loaded from: classes2.dex */
public abstract class ChannelCoroutine extends AbstractCoroutine implements Channel {
    private final Channel _channel;

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return this._channel.close(th);
    }

    public final Channel getChannel() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Channel get_channel() {
        return this._channel;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1 function1) {
        this._channel.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator iterator() {
        return this._channel.iterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation continuation) {
        return this._channel.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU */
    public Object mo2268receiveCatchingJP2dKIU(Continuation continuation) {
        Object mo2268receiveCatchingJP2dKIU = this._channel.mo2268receiveCatchingJP2dKIU(continuation);
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return mo2268receiveCatchingJP2dKIU;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(Object obj, Continuation continuation) {
        return this._channel.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk */
    public Object mo2269tryReceivePtdJZtk() {
        return this._channel.mo2269tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo2270trySendJP2dKIU(Object obj) {
        return this._channel.mo2270trySendJP2dKIU(obj);
    }

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this._channel = channel;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, null, 1, null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }
}
