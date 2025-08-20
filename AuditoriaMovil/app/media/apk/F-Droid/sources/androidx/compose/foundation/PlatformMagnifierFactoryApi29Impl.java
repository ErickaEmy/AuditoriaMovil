package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: PlatformMagnifier.kt */
/* loaded from: classes.dex */
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();
    private static final boolean canUpdateZoom = true;

    private PlatformMagnifierFactoryApi29Impl() {
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public PlatformMagnifierImpl create(MagnifierStyle style, View view, Density density, float f) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(density, "density");
        if (Intrinsics.areEqual(style, MagnifierStyle.Companion.getTextDefault())) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long mo156toSizeXkaWNTQ = density.mo156toSizeXkaWNTQ(style.m113getSizeMYxV2XQ$foundation_release());
        float mo155toPx0680j_4 = density.mo155toPx0680j_4(style.m111getCornerRadiusD9Ej5fM$foundation_release());
        float mo155toPx0680j_42 = density.mo155toPx0680j_4(style.m112getElevationD9Ej5fM$foundation_release());
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (mo156toSizeXkaWNTQ != Size.Companion.m750getUnspecifiedNHjbRc()) {
            roundToInt = MathKt__MathJVMKt.roundToInt(Size.m745getWidthimpl(mo156toSizeXkaWNTQ));
            roundToInt2 = MathKt__MathJVMKt.roundToInt(Size.m743getHeightimpl(mo156toSizeXkaWNTQ));
            builder.setSize(roundToInt, roundToInt2);
        }
        if (!Float.isNaN(mo155toPx0680j_4)) {
            builder.setCornerRadius(mo155toPx0680j_4);
        }
        if (!Float.isNaN(mo155toPx0680j_42)) {
            builder.setElevation(mo155toPx0680j_42);
        }
        if (!Float.isNaN(f)) {
            builder.setInitialZoom(f);
        }
        builder.setClippingEnabled(style.getClippingEnabled$foundation_release());
        Magnifier build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(view).run {\n    …    build()\n            }");
        return new PlatformMagnifierImpl(build);
    }

    /* compiled from: PlatformMagnifier.kt */
    /* loaded from: classes.dex */
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformMagnifierImpl(Magnifier magnifier) {
            super(magnifier);
            Intrinsics.checkNotNullParameter(magnifier, "magnifier");
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* renamed from: update-Wko1d7g */
        public void mo116updateWko1d7g(long j, long j2, float f) {
            if (!Float.isNaN(f)) {
                getMagnifier().setZoom(f);
            }
            if (OffsetKt.m723isSpecifiedk4lQ0M(j2)) {
                getMagnifier().show(Offset.m709getXimpl(j), Offset.m710getYimpl(j), Offset.m709getXimpl(j2), Offset.m710getYimpl(j2));
            } else {
                getMagnifier().show(Offset.m709getXimpl(j), Offset.m710getYimpl(j));
            }
        }
    }
}
