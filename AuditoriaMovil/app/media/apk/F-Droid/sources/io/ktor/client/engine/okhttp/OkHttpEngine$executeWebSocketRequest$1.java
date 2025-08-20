package io.ktor.client.engine.okhttp;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpEngine.kt */
/* loaded from: classes.dex */
public final class OkHttpEngine$executeWebSocketRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkHttpEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine$executeWebSocketRequest$1(OkHttpEngine okHttpEngine, Continuation continuation) {
        super(continuation);
        this.this$0 = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeWebSocketRequest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeWebSocketRequest = this.this$0.executeWebSocketRequest(null, null, null, this);
        return executeWebSocketRequest;
    }
}
