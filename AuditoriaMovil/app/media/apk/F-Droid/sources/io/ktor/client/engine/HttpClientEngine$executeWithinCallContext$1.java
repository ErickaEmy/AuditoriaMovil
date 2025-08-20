package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngine;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientEngine.kt */
/* loaded from: classes.dex */
public final class HttpClientEngine$executeWithinCallContext$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpClientEngine$executeWithinCallContext$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeWithinCallContext;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeWithinCallContext = HttpClientEngine.DefaultImpls.executeWithinCallContext(null, null, this);
        return executeWithinCallContext;
    }
}
