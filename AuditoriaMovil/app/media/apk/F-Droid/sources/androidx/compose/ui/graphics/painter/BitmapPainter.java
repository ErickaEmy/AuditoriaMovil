package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: BitmapPainter.kt */
/* loaded from: classes.dex */
public final class BitmapPainter extends Painter {
    private float alpha;
    private ColorFilter colorFilter;
    private int filterQuality;
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, j, j2);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, (i & 2) != 0 ? IntOffset.Companion.m1942getZeronOccac() : j, (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2, null);
    }

    private BitmapPainter(ImageBitmap image, long j, long j2) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.image = image;
        this.srcOffset = j;
        this.srcSize = j2;
        this.filterQuality = FilterQuality.Companion.m883getLowfv9h1I();
        this.size = m1071validateSizeN5eqBDc(j, j2);
        this.alpha = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        ImageBitmap imageBitmap = this.image;
        long j = this.srcOffset;
        long j2 = this.srcSize;
        roundToInt = MathKt__MathJVMKt.roundToInt(Size.m745getWidthimpl(drawScope.mo1040getSizeNHjbRc()));
        roundToInt2 = MathKt__MathJVMKt.roundToInt(Size.m743getHeightimpl(drawScope.mo1040getSizeNHjbRc()));
        DrawScope.CC.m1057drawImageAZ2fEMs$default(drawScope, imageBitmap, j, j2, 0L, IntSizeKt.IntSize(roundToInt, roundToInt2), this.alpha, null, this.colorFilter, 0, this.filterQuality, 328, null);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long mo1072getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m1957toSizeozmzZPI(this.size);
    }

    /* renamed from: validateSize-N5eqBDc  reason: not valid java name */
    private final long m1071validateSizeN5eqBDc(long j, long j2) {
        if (IntOffset.m1937getXimpl(j) < 0 || IntOffset.m1938getYimpl(j) < 0 || IntSize.m1951getWidthimpl(j2) < 0 || IntSize.m1950getHeightimpl(j2) < 0 || IntSize.m1951getWidthimpl(j2) > this.image.getWidth() || IntSize.m1950getHeightimpl(j2) > this.image.getHeight()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BitmapPainter) {
            BitmapPainter bitmapPainter = (BitmapPainter) obj;
            return Intrinsics.areEqual(this.image, bitmapPainter.image) && IntOffset.m1936equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) && IntSize.m1949equalsimpl0(this.srcSize, bitmapPainter.srcSize) && FilterQuality.m880equalsimpl0(this.filterQuality, bitmapPainter.filterQuality);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m1939hashCodeimpl(this.srcOffset)) * 31) + IntSize.m1952hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m881hashCodeimpl(this.filterQuality);
    }

    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + ((Object) IntOffset.m1940toStringimpl(this.srcOffset)) + ", srcSize=" + ((Object) IntSize.m1953toStringimpl(this.srcSize)) + ", filterQuality=" + ((Object) FilterQuality.m882toStringimpl(this.filterQuality)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
