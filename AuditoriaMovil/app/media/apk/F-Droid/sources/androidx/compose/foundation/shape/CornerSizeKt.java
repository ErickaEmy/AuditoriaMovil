package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CornerSize.kt */
/* loaded from: classes.dex */
public abstract class CornerSizeKt {
    private static final CornerSize ZeroCornerSize = new CornerSize() { // from class: androidx.compose.foundation.shape.CornerSizeKt$ZeroCornerSize$1
        @Override // androidx.compose.foundation.shape.CornerSize
        /* renamed from: toPx-TmRCtEA */
        public float mo277toPxTmRCtEA(long j, Density density) {
            Intrinsics.checkNotNullParameter(density, "density");
            return 0.0f;
        }

        public String toString() {
            return "ZeroCornerSize";
        }
    };

    public static final CornerSize getZeroCornerSize() {
        return ZeroCornerSize;
    }

    /* renamed from: CornerSize-0680j_4  reason: not valid java name */
    public static final CornerSize m278CornerSize0680j_4(float f) {
        return new DpCornerSize(f, null);
    }

    public static final CornerSize CornerSize(float f) {
        return new PxCornerSize(f);
    }

    public static final CornerSize CornerSize(int i) {
        return new PercentCornerSize(i);
    }
}
