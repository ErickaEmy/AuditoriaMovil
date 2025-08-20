package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
/* compiled from: Actor.kt */
/* loaded from: classes2.dex */
final class LazyActorCoroutine extends ActorCoroutine {
    private Continuation continuation;

    public LazyActorCoroutine(CoroutineContext coroutineContext, Channel channel, Function2 function2) {
        super(coroutineContext, channel, false);
        Continuation createCoroutineUnintercepted;
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
        this.continuation = createCoroutineUnintercepted;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void onStart() {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public Object send(Object obj, Continuation continuation) {
        Object coroutine_suspended;
        start();
        Object send = super.send(obj, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return send == coroutine_suspended ? send : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo2270trySendJP2dKIU(Object obj) {
        start();
        return super.mo2270trySendJP2dKIU(obj);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        boolean close = super.close(th);
        start();
        return close;
    }
}
