package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ShapeContainingUtil.kt */
/* loaded from: classes.dex */
public abstract class ShapeContainingUtilKt {
    public static final boolean isInOutline(Outline outline, float f, float f2, Path path, Path path2) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f, f2);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f, f2, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f, f2, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean isInRectangle(Rect rect, float f, float f2) {
        return rect.getLeft() <= f && f < rect.getRight() && rect.getTop() <= f2 && f2 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f, float f2, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f < roundRect.getLeft() || f >= roundRect.getRight() || f2 < roundRect.getTop() || f2 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect(roundRect);
            return isInPath(Path, f, f2, path, path2);
        }
        float m693getXimpl = CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float m694getYimpl = CornerRadius.m694getYimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m693getXimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs());
        float m694getYimpl2 = CornerRadius.m694getYimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.m693getXimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.m694getYimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.m694getYimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs());
        float m693getXimpl2 = CornerRadius.m693getXimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        if (f >= m693getXimpl || f2 >= m694getYimpl) {
            if (f >= m693getXimpl2 || f2 <= bottom2) {
                if (f <= right || f2 >= m694getYimpl2) {
                    if (f <= right2 || f2 <= bottom) {
                        return true;
                    }
                    return m1457isWithinEllipseVE1yxkc(f, f2, roundRect.m734getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
                }
                return m1457isWithinEllipseVE1yxkc(f, f2, roundRect.m736getTopRightCornerRadiuskKHJgLs(), right, m694getYimpl2);
            }
            return m1457isWithinEllipseVE1yxkc(f, f2, roundRect.m733getBottomLeftCornerRadiuskKHJgLs(), m693getXimpl2, bottom2);
        }
        return m1457isWithinEllipseVE1yxkc(f, f2, roundRect.m735getTopLeftCornerRadiuskKHJgLs(), m693getXimpl, m694getYimpl);
    }

    private static final boolean cornersFit(RoundRect roundRect) {
        return CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m693getXimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m693getXimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m693getXimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m694getYimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m694getYimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()) <= roundRect.getHeight() && CornerRadius.m694getYimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m694getYimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getHeight();
    }

    /* renamed from: isWithinEllipse-VE1yxkc  reason: not valid java name */
    private static final boolean m1457isWithinEllipseVE1yxkc(float f, float f2, long j, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float m693getXimpl = CornerRadius.m693getXimpl(j);
        float m694getYimpl = CornerRadius.m694getYimpl(j);
        return ((f5 * f5) / (m693getXimpl * m693getXimpl)) + ((f6 * f6) / (m694getYimpl * m694getYimpl)) <= 1.0f;
    }

    private static final boolean isInPath(Path path, float f, float f2, Path path2, Path path3) {
        Rect rect = new Rect(f - 0.005f, f2 - 0.005f, f + 0.005f, f2 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        path2.addRect(rect);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.mo790opN5in7k0(path, path2, PathOperation.Companion.m945getIntersectb3I0S0c());
        boolean isEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !isEmpty;
    }
}
