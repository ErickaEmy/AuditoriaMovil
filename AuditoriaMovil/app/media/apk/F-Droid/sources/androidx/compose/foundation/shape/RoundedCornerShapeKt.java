package androidx.compose.foundation.shape;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: RoundedCornerShape.kt */
/* loaded from: classes.dex */
public abstract class RoundedCornerShapeKt {
    private static final RoundedCornerShape CircleShape = RoundedCornerShape(50);

    public static final RoundedCornerShape getCircleShape() {
        return CircleShape;
    }

    public static final RoundedCornerShape RoundedCornerShape(CornerSize corner) {
        Intrinsics.checkNotNullParameter(corner, "corner");
        return new RoundedCornerShape(corner, corner, corner, corner);
    }

    /* renamed from: RoundedCornerShape-0680j_4  reason: not valid java name */
    public static final RoundedCornerShape m279RoundedCornerShape0680j_4(float f) {
        return RoundedCornerShape(CornerSizeKt.m278CornerSize0680j_4(f));
    }

    public static final RoundedCornerShape RoundedCornerShape(int i) {
        return RoundedCornerShape(CornerSizeKt.CornerSize(i));
    }
}
