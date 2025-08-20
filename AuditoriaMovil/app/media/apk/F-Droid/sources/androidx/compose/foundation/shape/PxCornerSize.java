package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CornerSize.kt */
/* loaded from: classes.dex */
final class PxCornerSize implements CornerSize {
    private final float size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PxCornerSize) && Float.compare(this.size, ((PxCornerSize) obj).size) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public float mo277toPxTmRCtEA(long j, Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return this.size;
    }

    public PxCornerSize(float f) {
        this.size = f;
    }

    public String toString() {
        return "CornerSize(size = " + this.size + ".px)";
    }
}
