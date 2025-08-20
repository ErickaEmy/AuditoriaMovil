package com.bumptech.glide.integration.compose;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: GlideImage.kt */
/* loaded from: classes.dex */
/* synthetic */ class GlideImageKt$rememberSizeAndModifier$1$1 extends FunctionReferenceImpl implements Function1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GlideImageKt$rememberSizeAndModifier$1$1(Object obj) {
        super(1, obj, SizeObserver.class, "getSize", "getSize(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SizeObserver) this.receiver).getSize(continuation);
    }
}
