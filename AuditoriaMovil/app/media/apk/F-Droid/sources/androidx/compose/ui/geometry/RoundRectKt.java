package androidx.compose.ui.geometry;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: RoundRect.kt */
/* loaded from: classes.dex */
public abstract class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long CornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, CornerRadius, CornerRadius, CornerRadius, CornerRadius, null);
    }

    /* renamed from: RoundRect-gG7oq9Y  reason: not valid java name */
    public static final RoundRect m738RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m693getXimpl(j), CornerRadius.m694getYimpl(j));
    }

    /* renamed from: RoundRect-ZAM2FJo  reason: not valid java name */
    public static final RoundRect m737RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    public static final boolean isSimple(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m694getYimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) && CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m693getXimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m694getYimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m693getXimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m694getYimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m693getXimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m694getYimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs());
    }
}
