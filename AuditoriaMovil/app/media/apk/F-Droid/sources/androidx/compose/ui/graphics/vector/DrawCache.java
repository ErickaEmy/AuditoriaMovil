package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DrawCache.kt */
/* loaded from: classes.dex */
public final class DrawCache {
    private Canvas cachedCanvas;
    private ImageBitmap mCachedImage;
    private Density scopeDensity;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private long size = IntSize.Companion.m1955getZeroYbymL2g();
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();

    /* renamed from: drawCachedImage-CJJAR-o  reason: not valid java name */
    public final void m1074drawCachedImageCJJARo(long j, Density density, LayoutDirection layoutDirection, Function1 block) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(block, "block");
        this.scopeDensity = density;
        this.layoutDirection = layoutDirection;
        ImageBitmap imageBitmap = this.mCachedImage;
        Canvas canvas = this.cachedCanvas;
        if (imageBitmap == null || canvas == null || IntSize.m1951getWidthimpl(j) > imageBitmap.getWidth() || IntSize.m1950getHeightimpl(j) > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m908ImageBitmapx__hDU$default(IntSize.m1951getWidthimpl(j), IntSize.m1950getHeightimpl(j), 0, false, null, 28, null);
            canvas = CanvasKt.Canvas(imageBitmap);
            this.mCachedImage = imageBitmap;
            this.cachedCanvas = canvas;
        }
        this.size = j;
        CanvasDrawScope canvasDrawScope = this.cacheScope;
        long m1957toSizeozmzZPI = IntSizeKt.m1957toSizeozmzZPI(j);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long m1041component4NHjbRc = drawParams.m1041component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m1043setSizeuvyYCjk(m1957toSizeozmzZPI);
        canvas.save();
        clear(canvasDrawScope);
        block.invoke(canvasDrawScope);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m1043setSizeuvyYCjk(m1041component4NHjbRc);
        imageBitmap.prepareToDraw();
    }

    public final void drawInto(DrawScope target, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(target, "target");
        ImageBitmap imageBitmap = this.mCachedImage;
        if (imageBitmap == null) {
            throw new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination".toString());
        }
        DrawScope.CC.m1057drawImageAZ2fEMs$default(target, imageBitmap, 0L, this.size, 0L, 0L, f, null, colorFilter, 0, 0, 858, null);
    }

    private final void clear(DrawScope drawScope) {
        DrawScope.CC.m1063drawRectnJ9OG0$default(drawScope, Color.Companion.m860getBlack0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.Companion.m801getClear0nO6VwU(), 62, null);
    }
}
