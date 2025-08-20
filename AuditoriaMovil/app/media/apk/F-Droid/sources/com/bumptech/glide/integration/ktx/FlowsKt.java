package com.bumptech.glide.integration.ktx;

import com.bumptech.glide.GlideIntegrationKt;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.util.Util;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: Flows.kt */
/* loaded from: classes.dex */
public abstract class FlowsKt {
    public static final Flow flowResolvable(RequestBuilder requestBuilder, ResolvableGlideSize size) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        return flow(requestBuilder, size);
    }

    private static final Flow flow(RequestBuilder requestBuilder, ResolvableGlideSize resolvableGlideSize) {
        return FlowKt.callbackFlow(new FlowsKt$flow$2(resolvableGlideSize, requestBuilder, GlideIntegrationKt.requestManager(requestBuilder), null));
    }

    public static final boolean isValidGlideDimension(int i) {
        return Util.isValidDimension(i);
    }
}
