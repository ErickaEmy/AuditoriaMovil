package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BufferedChannel.kt */
/* loaded from: classes2.dex */
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel bufferedChannel, Continuation continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m2267receiveCatchingOnNoWaiterSuspendGKJJFZk;
        Object coroutine_suspended;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m2267receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m2267receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return m2267receiveCatchingOnNoWaiterSuspendGKJJFZk == coroutine_suspended ? m2267receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m2271boximpl(m2267receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
