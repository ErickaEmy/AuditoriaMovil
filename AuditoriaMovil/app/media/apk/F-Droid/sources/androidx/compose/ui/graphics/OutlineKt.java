package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Outline.kt */
/* loaded from: classes.dex */
public abstract class OutlineKt {
    public static final /* synthetic */ boolean access$hasSameCornerRadius(RoundRect roundRect) {
        return hasSameCornerRadius(roundRect);
    }

    /* renamed from: drawOutline-hn5TExg$default */
    public static /* synthetic */ void m925drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = DrawScope.Companion.m1065getDefaultBlendMode0nO6VwU();
        }
        m924drawOutlinehn5TExg(drawScope, outline, brush, f2, drawStyle2, colorFilter2, i);
    }

    private static final long topLeft(Rect rect) {
        return OffsetKt.Offset(rect.getLeft(), rect.getTop());
    }

    private static final long size(Rect rect) {
        return SizeKt.Size(rect.getWidth(), rect.getHeight());
    }

    private static final long topLeft(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
    }

    private static final long size(RoundRect roundRect) {
        return SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
    }

    /* renamed from: drawOutline-hn5TExg */
    public static final void m924drawOutlinehn5TExg(DrawScope drawOutline, Outline outline, Brush brush, float f, DrawStyle style, ColorFilter colorFilter, int i) {
        Path path;
        Intrinsics.checkNotNullParameter(drawOutline, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawOutline.mo1035drawRectAsUm42w(brush, topLeft(rect), size(rect), f, style, colorFilter, i);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                drawOutline.mo1037drawRoundRectZuiqVtQ(brush, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m693getXimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, null), f, style, colorFilter, i);
                return;
            }
        } else if (!(outline instanceof Outline.Generic)) {
            throw new NoWhenBranchMatchedException();
        } else {
            path = ((Outline.Generic) outline).getPath();
        }
        drawOutline.mo1033drawPathGBMwjPU(path, brush, f, style, colorFilter, i);
    }

    /* renamed from: drawOutline-wDX37Ww */
    public static final void m926drawOutlinewDX37Ww(DrawScope drawOutline, Outline outline, long j, float f, DrawStyle style, ColorFilter colorFilter, int i) {
        Path path;
        Intrinsics.checkNotNullParameter(drawOutline, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(style, "style");
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawOutline.mo1036drawRectnJ9OG0(j, topLeft(rect), size(rect), f, style, colorFilter, i);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                drawOutline.mo1038drawRoundRectuAw5IA(j, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m693getXimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, null), style, f, colorFilter, i);
                return;
            }
        } else if (!(outline instanceof Outline.Generic)) {
            throw new NoWhenBranchMatchedException();
        } else {
            path = ((Outline.Generic) outline).getPath();
        }
        drawOutline.mo1034drawPathLG529CI(path, j, f, style, colorFilter, i);
    }

    public static final boolean hasSameCornerRadius(RoundRect roundRect) {
        return ((CornerRadius.m693getXimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()) > CornerRadius.m693getXimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m693getXimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()) == CornerRadius.m693getXimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) ? 0 : -1)) == 0 && (CornerRadius.m693getXimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) > CornerRadius.m693getXimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m693getXimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m693getXimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) ? 0 : -1)) == 0 && (CornerRadius.m693getXimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) > CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m693getXimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) ? 0 : -1)) == 0) && ((CornerRadius.m694getYimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()) > CornerRadius.m694getYimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m694getYimpl(roundRect.m733getBottomLeftCornerRadiuskKHJgLs()) == CornerRadius.m694getYimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) ? 0 : -1)) == 0 && (CornerRadius.m694getYimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) > CornerRadius.m694getYimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m694getYimpl(roundRect.m734getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m694getYimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) ? 0 : -1)) == 0 && (CornerRadius.m694getYimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) > CornerRadius.m694getYimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) ? 1 : (CornerRadius.m694getYimpl(roundRect.m736getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m694getYimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) ? 0 : -1)) == 0);
    }
}
