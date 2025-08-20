package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CornerBasedShape.kt */
/* loaded from: classes.dex */
public abstract class CornerBasedShape implements Shape {
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    public abstract CornerBasedShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4);

    /* renamed from: createOutline-LjSzlW0  reason: not valid java name */
    public abstract Outline mo276createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection);

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }

    public CornerBasedShape(CornerSize topStart, CornerSize topEnd, CornerSize bottomEnd, CornerSize bottomStart) {
        Intrinsics.checkNotNullParameter(topStart, "topStart");
        Intrinsics.checkNotNullParameter(topEnd, "topEnd");
        Intrinsics.checkNotNullParameter(bottomEnd, "bottomEnd");
        Intrinsics.checkNotNullParameter(bottomStart, "bottomStart");
        this.topStart = topStart;
        this.topEnd = topEnd;
        this.bottomEnd = bottomEnd;
        this.bottomStart = bottomStart;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI */
    public final Outline mo104createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float mo277toPxTmRCtEA = this.topStart.mo277toPxTmRCtEA(j, density);
        float mo277toPxTmRCtEA2 = this.topEnd.mo277toPxTmRCtEA(j, density);
        float mo277toPxTmRCtEA3 = this.bottomEnd.mo277toPxTmRCtEA(j, density);
        float mo277toPxTmRCtEA4 = this.bottomStart.mo277toPxTmRCtEA(j, density);
        float m744getMinDimensionimpl = Size.m744getMinDimensionimpl(j);
        float f = mo277toPxTmRCtEA + mo277toPxTmRCtEA4;
        if (f > m744getMinDimensionimpl) {
            float f2 = m744getMinDimensionimpl / f;
            mo277toPxTmRCtEA *= f2;
            mo277toPxTmRCtEA4 *= f2;
        }
        float f3 = mo277toPxTmRCtEA4;
        float f4 = mo277toPxTmRCtEA2 + mo277toPxTmRCtEA3;
        if (f4 > m744getMinDimensionimpl) {
            float f5 = m744getMinDimensionimpl / f4;
            mo277toPxTmRCtEA2 *= f5;
            mo277toPxTmRCtEA3 *= f5;
        }
        if (mo277toPxTmRCtEA < 0.0f || mo277toPxTmRCtEA2 < 0.0f || mo277toPxTmRCtEA3 < 0.0f || f3 < 0.0f) {
            throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + mo277toPxTmRCtEA + ", topEnd = " + mo277toPxTmRCtEA2 + ", bottomEnd = " + mo277toPxTmRCtEA3 + ", bottomStart = " + f3 + ")!").toString());
        }
        return mo276createOutlineLjSzlW0(j, mo277toPxTmRCtEA, mo277toPxTmRCtEA2, mo277toPxTmRCtEA3, f3, layoutDirection);
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                cornerSize = cornerBasedShape.topStart;
            }
            if ((i & 2) != 0) {
                cornerSize2 = cornerBasedShape.topEnd;
            }
            if ((i & 4) != 0) {
                cornerSize3 = cornerBasedShape.bottomEnd;
            }
            if ((i & 8) != 0) {
                cornerSize4 = cornerBasedShape.bottomStart;
            }
            return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final CornerBasedShape copy(CornerSize all) {
        Intrinsics.checkNotNullParameter(all, "all");
        return copy(all, all, all, all);
    }
}
