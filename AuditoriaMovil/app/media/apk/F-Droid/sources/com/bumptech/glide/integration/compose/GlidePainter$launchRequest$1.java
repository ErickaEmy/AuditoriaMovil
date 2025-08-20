package com.bumptech.glide.integration.compose;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.ktx.FlowsKt;
import com.bumptech.glide.integration.ktx.GlideFlowInstant;
import com.bumptech.glide.integration.ktx.ResolvableGlideSize;
import com.bumptech.glide.integration.ktx.Resource;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlidePainter.kt */
/* loaded from: classes.dex */
public final class GlidePainter$launchRequest$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ GlidePainter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlidePainter$launchRequest$1(GlidePainter glidePainter, Continuation continuation) {
        super(2, continuation);
        this.this$0 = glidePainter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GlidePainter$launchRequest$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GlidePainter$launchRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        RequestBuilder requestBuilder;
        ResolvableGlideSize resolvableGlideSize;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            requestBuilder = this.this$0.requestBuilder;
            resolvableGlideSize = this.this$0.size;
            Flow flowResolvable = FlowsKt.flowResolvable(requestBuilder, resolvableGlideSize);
            final GlidePainter glidePainter = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.bumptech.glide.integration.compose.GlidePainter$launchRequest$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(GlideFlowInstant glideFlowInstant, Continuation continuation) {
                    Drawable placeholder;
                    GlidePainter glidePainter2 = GlidePainter.this;
                    if (glideFlowInstant instanceof Resource) {
                        placeholder = (Drawable) ((Resource) glideFlowInstant).getResource();
                    } else if (!(glideFlowInstant instanceof com.bumptech.glide.integration.ktx.Placeholder)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        placeholder = ((com.bumptech.glide.integration.ktx.Placeholder) glideFlowInstant).getPlaceholder();
                    }
                    glidePainter2.updateDelegate(placeholder);
                    GlidePainter.this.setStatus$compose_release(glideFlowInstant.getStatus());
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flowResolvable.collect(flowCollector, this) == coroutine_suspended) {
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
