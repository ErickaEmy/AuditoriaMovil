package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
/* loaded from: classes.dex */
public final class ByteBufferChannel$awaitFreeSpaceOrDelegate$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$awaitFreeSpaceOrDelegate$1(ByteBufferChannel byteBufferChannel, Continuation continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object awaitFreeSpaceOrDelegate;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitFreeSpaceOrDelegate = this.this$0.awaitFreeSpaceOrDelegate(0, null, this);
        return awaitFreeSpaceOrDelegate;
    }
}
