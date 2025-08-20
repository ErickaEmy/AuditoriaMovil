package com.bumptech.glide.integration.compose;

import androidx.compose.ui.unit.Constraints;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.ktx.FlowsKt;
import com.bumptech.glide.integration.ktx.Size;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Sizes.kt */
/* loaded from: classes.dex */
public abstract class SizesKt {
    public static final Size overrideSize(RequestBuilder requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        if (isOverrideSizeSet(requestBuilder)) {
            return new Size(requestBuilder.getOverrideWidth(), requestBuilder.getOverrideHeight());
        }
        return null;
    }

    public static final boolean isOverrideSizeSet(RequestBuilder requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        return FlowsKt.isValidGlideDimension(requestBuilder.getOverrideWidth()) && FlowsKt.isValidGlideDimension(requestBuilder.getOverrideHeight());
    }

    /* renamed from: inferredGlideSize-BRTryo0  reason: not valid java name */
    public static final Size m2029inferredGlideSizeBRTryo0(long j) {
        int m1872getMaxWidthimpl = Constraints.m1868getHasBoundedWidthimpl(j) ? Constraints.m1872getMaxWidthimpl(j) : Integer.MIN_VALUE;
        int m1871getMaxHeightimpl = Constraints.m1867getHasBoundedHeightimpl(j) ? Constraints.m1871getMaxHeightimpl(j) : Integer.MIN_VALUE;
        if (FlowsKt.isValidGlideDimension(m1872getMaxWidthimpl) && FlowsKt.isValidGlideDimension(m1871getMaxHeightimpl)) {
            return new Size(m1872getMaxWidthimpl, m1871getMaxHeightimpl);
        }
        return null;
    }
}
