package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RippleAnimation.kt */
/* loaded from: classes.dex */
public abstract class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = Dp.m1897constructorimpl(10);

    /* renamed from: getRippleStartRadius-uvyYCjk  reason: not valid java name */
    public static final float m589getRippleStartRadiusuvyYCjk(long j) {
        return Math.max(Size.m745getWidthimpl(j), Size.m743getHeightimpl(j)) * 0.3f;
    }

    /* renamed from: getRippleEndRadius-cSwnlzA  reason: not valid java name */
    public static final float m588getRippleEndRadiuscSwnlzA(Density getRippleEndRadius, boolean z, long j) {
        Intrinsics.checkNotNullParameter(getRippleEndRadius, "$this$getRippleEndRadius");
        float m707getDistanceimpl = Offset.m707getDistanceimpl(OffsetKt.Offset(Size.m745getWidthimpl(j), Size.m743getHeightimpl(j))) / 2.0f;
        return z ? m707getDistanceimpl + getRippleEndRadius.mo155toPx0680j_4(BoundedRippleExtraRadius) : m707getDistanceimpl;
    }
}
