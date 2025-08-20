package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BodyProgress.kt */
/* loaded from: classes.dex */
public final class BodyProgress$handle$2 extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyProgress$handle$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext pipelineContext, HttpResponse httpResponse, Continuation continuation) {
        BodyProgress$handle$2 bodyProgress$handle$2 = new BodyProgress$handle$2(continuation);
        bodyProgress$handle$2.L$0 = pipelineContext;
        bodyProgress$handle$2.L$1 = httpResponse;
        return bodyProgress$handle$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        AttributeKey attributeKey;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            HttpResponse httpResponse = (HttpResponse) this.L$1;
            Attributes attributes = httpResponse.getCall().getRequest().getAttributes();
            attributeKey = BodyProgressKt.DownloadProgressListenerAttributeKey;
            Function3 function3 = (Function3) attributes.getOrNull(attributeKey);
            if (function3 == null) {
                return Unit.INSTANCE;
            }
            HttpResponse withObservableDownload = BodyProgressKt.withObservableDownload(httpResponse, function3);
            this.L$0 = null;
            this.label = 1;
            if (pipelineContext.proceedWith(withObservableDownload, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
