package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CornerSize.kt */
/* loaded from: classes.dex */
final class PercentCornerSize implements CornerSize {
    private final float percent;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PercentCornerSize) && Float.compare(this.percent, ((PercentCornerSize) obj).percent) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.percent);
    }

    public PercentCornerSize(float f) {
        this.percent = f;
        if (f < 0.0f || f > 100.0f) {
            throw new IllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public float mo277toPxTmRCtEA(long j, Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return Size.m744getMinDimensionimpl(j) * (this.percent / 100.0f);
    }

    public String toString() {
        return "CornerSize(size = " + this.percent + "%)";
    }
}
