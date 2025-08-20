package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserAgent.kt */
/* loaded from: classes.dex */
public final class UserAgent$Plugin$install$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ UserAgent $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAgent$Plugin$install$1(UserAgent userAgent, Continuation continuation) {
        super(3, continuation);
        this.$plugin = userAgent;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext pipelineContext, Object obj, Continuation continuation) {
        UserAgent$Plugin$install$1 userAgent$Plugin$install$1 = new UserAgent$Plugin$install$1(this.$plugin, continuation);
        userAgent$Plugin$install$1.L$0 = pipelineContext;
        return userAgent$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Logger logger;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            logger = UserAgentKt.LOGGER;
            logger.trace("Adding User-Agent header: " + this.$plugin.getAgent() + " for " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl());
            UtilsKt.header((HttpMessageBuilder) pipelineContext.getContext(), HttpHeaders.INSTANCE.getUserAgent(), this.$plugin.getAgent());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
