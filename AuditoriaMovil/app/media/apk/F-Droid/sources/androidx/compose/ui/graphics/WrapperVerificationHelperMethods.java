package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidPaint.android.kt */
/* loaded from: classes.dex */
public final class WrapperVerificationHelperMethods {
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    private WrapperVerificationHelperMethods() {
    }

    /* renamed from: setBlendMode-GB0RdKg  reason: not valid java name */
    public final void m993setBlendModeGB0RdKg(android.graphics.Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setBlendMode(AndroidBlendMode_androidKt.m754toAndroidBlendModes9anfk8(i));
    }
}
