package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRedirect;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRedirect.kt */
/* loaded from: classes.dex */
public final class HttpRedirect$Plugin$handleCall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpRedirect.Plugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirect$Plugin$handleCall$1(HttpRedirect.Plugin plugin, Continuation continuation) {
        super(continuation);
        this.this$0 = plugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleCall;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleCall = this.this$0.handleCall(null, null, null, false, null, this);
        return handleCall;
    }
}
