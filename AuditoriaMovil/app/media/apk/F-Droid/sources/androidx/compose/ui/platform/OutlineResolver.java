package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: OutlineResolver.android.kt */
/* loaded from: classes.dex */
public final class OutlineResolver {
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private androidx.compose.ui.graphics.Outline calculatedOutline;
    private Density density;
    private boolean isSupportedOutline;
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Shape shape;
    private long size;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    public OutlineResolver(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.density = density;
        this.isSupportedOutline = true;
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        Size.Companion companion = Size.Companion;
        this.size = companion.m751getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.Companion.m721getZeroF1C5BW0();
        this.rectSize = companion.m751getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    public final Outline getOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final boolean update(Shape shape, float f, boolean z, float f2, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.cachedOutline.setAlpha(f);
        boolean z2 = !Intrinsics.areEqual(this.shape, shape);
        if (z2) {
            this.shape = shape;
            this.cacheIsDirty = true;
        }
        boolean z3 = z || f2 > 0.0f;
        if (this.outlineNeeded != z3) {
            this.outlineNeeded = z3;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            this.cacheIsDirty = true;
        }
        if (!Intrinsics.areEqual(this.density, density)) {
            this.density = density;
            this.cacheIsDirty = true;
        }
        return z2;
    }

    /* renamed from: isInOutline-k-4lQ0M  reason: not valid java name */
    public final boolean m1455isInOutlinek4lQ0M(long j) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m709getXimpl(j), Offset.m710getYimpl(j), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    public final void clipToOutline(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Path clipPath = getClipPath();
        if (clipPath != null) {
            Canvas.CC.m834clipPathmtrdDE$default(canvas, clipPath, 0, 2, null);
            return;
        }
        float f = this.roundedCornerRadius;
        if (f > 0.0f) {
            Path path = this.tmpPath;
            RoundRect roundRect = this.tmpRoundRect;
            if (path == null || !m1454isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, f)) {
                RoundRect m738RoundRectgG7oq9Y = RoundRectKt.m738RoundRectgG7oq9Y(Offset.m709getXimpl(this.rectTopLeft), Offset.m710getYimpl(this.rectTopLeft), Offset.m709getXimpl(this.rectTopLeft) + Size.m745getWidthimpl(this.rectSize), Offset.m710getYimpl(this.rectTopLeft) + Size.m743getHeightimpl(this.rectSize), CornerRadiusKt.CornerRadius$default(this.roundedCornerRadius, 0.0f, 2, null));
                if (path == null) {
                    path = AndroidPath_androidKt.Path();
                } else {
                    path.reset();
                }
                path.addRoundRect(m738RoundRectgG7oq9Y);
                this.tmpRoundRect = m738RoundRectgG7oq9Y;
                this.tmpPath = path;
            }
            Canvas.CC.m834clipPathmtrdDE$default(canvas, path, 0, 2, null);
            return;
        }
        Canvas.CC.m835clipRectN_I0leg$default(canvas, Offset.m709getXimpl(this.rectTopLeft), Offset.m710getYimpl(this.rectTopLeft), Offset.m709getXimpl(this.rectTopLeft) + Size.m745getWidthimpl(this.rectSize), Offset.m710getYimpl(this.rectTopLeft) + Size.m743getHeightimpl(this.rectSize), 0, 16, null);
    }

    /* renamed from: update-uvyYCjk  reason: not valid java name */
    public final void m1456updateuvyYCjk(long j) {
        if (Size.m742equalsimpl0(this.size, j)) {
            return;
        }
        this.size = j;
        this.cacheIsDirty = true;
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m721getZeroF1C5BW0();
            long j = this.size;
            this.rectSize = j;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (this.outlineNeeded && Size.m745getWidthimpl(j) > 0.0f && Size.m743getHeightimpl(this.size) > 0.0f) {
                this.isSupportedOutline = true;
                androidx.compose.ui.graphics.Outline mo104createOutlinePq9zytI = this.shape.mo104createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
                this.calculatedOutline = mo104createOutlinePq9zytI;
                if (mo104createOutlinePq9zytI instanceof Outline.Rectangle) {
                    updateCacheWithRect(((Outline.Rectangle) mo104createOutlinePq9zytI).getRect());
                    return;
                } else if (mo104createOutlinePq9zytI instanceof Outline.Rounded) {
                    updateCacheWithRoundRect(((Outline.Rounded) mo104createOutlinePq9zytI).getRoundRect());
                    return;
                } else if (mo104createOutlinePq9zytI instanceof Outline.Generic) {
                    updateCacheWithPath(((Outline.Generic) mo104createOutlinePq9zytI).getPath());
                    return;
                } else {
                    return;
                }
            }
            this.cachedOutline.setEmpty();
        }
    }

    private final void updateCacheWithRect(Rect rect) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        android.graphics.Outline outline = this.cachedOutline;
        roundToInt = MathKt__MathJVMKt.roundToInt(rect.getLeft());
        roundToInt2 = MathKt__MathJVMKt.roundToInt(rect.getTop());
        roundToInt3 = MathKt__MathJVMKt.roundToInt(rect.getRight());
        roundToInt4 = MathKt__MathJVMKt.roundToInt(rect.getBottom());
        outline.setRect(roundToInt, roundToInt2, roundToInt3, roundToInt4);
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        float m693getXimpl = CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            android.graphics.Outline outline = this.cachedOutline;
            roundToInt = MathKt__MathJVMKt.roundToInt(roundRect.getLeft());
            roundToInt2 = MathKt__MathJVMKt.roundToInt(roundRect.getTop());
            roundToInt3 = MathKt__MathJVMKt.roundToInt(roundRect.getRight());
            roundToInt4 = MathKt__MathJVMKt.roundToInt(roundRect.getBottom());
            outline.setRoundRect(roundToInt, roundToInt2, roundToInt3, roundToInt4, m693getXimpl);
            this.roundedCornerRadius = m693getXimpl;
            return;
        }
        Path path = this.cachedRrectPath;
        if (path == null) {
            path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = path;
        }
        path.reset();
        path.addRoundRect(roundRect);
        updateCacheWithPath(path);
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            android.graphics.Outline outline = this.cachedOutline;
            if (!(path instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            outline.setConvexPath(((AndroidPath) path).getInternalPath());
            this.usePathForClip = !this.cachedOutline.canClip();
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    /* renamed from: isSameBounds-4L21HEs  reason: not valid java name */
    private final boolean m1454isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        return roundRect != null && RoundRectKt.isSimple(roundRect) && roundRect.getLeft() == Offset.m709getXimpl(j) && roundRect.getTop() == Offset.m710getYimpl(j) && roundRect.getRight() == Offset.m709getXimpl(j) + Size.m745getWidthimpl(j2) && roundRect.getBottom() == Offset.m710getYimpl(j) + Size.m743getHeightimpl(j2) && CornerRadius.m693getXimpl(roundRect.m735getTopLeftCornerRadiuskKHJgLs()) == f;
    }
}
