package com.bumptech.glide.integration.ktx;

import com.bumptech.glide.GlideIntegrationKt;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Flows.kt */
/* loaded from: classes.dex */
public final class FlowsKt$flow$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ RequestBuilder $requestBuilder;
    final /* synthetic */ RequestManager $requestManager;
    final /* synthetic */ ResolvableGlideSize $size;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowsKt$flow$2(ResolvableGlideSize resolvableGlideSize, RequestBuilder requestBuilder, RequestManager requestManager, Continuation continuation) {
        super(2, continuation);
        this.$size = resolvableGlideSize;
        this.$requestBuilder = requestBuilder;
        this.$requestManager = requestManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowsKt$flow$2 flowsKt$flow$2 = new FlowsKt$flow$2(this.$size, this.$requestBuilder, this.$requestManager, continuation);
        flowsKt$flow$2.L$0 = obj;
        return flowsKt$flow$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((FlowsKt$flow$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final FlowTarget flowTarget = new FlowTarget(producerScope, this.$size);
            GlideIntegrationKt.intoDirect(this.$requestBuilder, flowTarget);
            final RequestManager requestManager = this.$requestManager;
            Function0 function0 = new Function0() { // from class: com.bumptech.glide.integration.ktx.FlowsKt$flow$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2030invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2030invoke() {
                    RequestManager.this.clear(flowTarget);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
