package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BufferedChannel.kt */
/* loaded from: classes2.dex */
public final class BufferedChannel$receiveCatching$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel bufferedChannel, Continuation continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m2266receiveCatchingJP2dKIU$suspendImpl = BufferedChannel.m2266receiveCatchingJP2dKIU$suspendImpl(this.this$0, this);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return m2266receiveCatchingJP2dKIU$suspendImpl == coroutine_suspended ? m2266receiveCatchingJP2dKIU$suspendImpl : ChannelResult.m2271boximpl(m2266receiveCatchingJP2dKIU$suspendImpl);
    }
}
