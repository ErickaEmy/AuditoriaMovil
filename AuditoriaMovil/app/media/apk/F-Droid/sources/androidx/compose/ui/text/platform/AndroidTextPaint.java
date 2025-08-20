package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: AndroidTextPaint.android.kt */
/* loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    private final Paint composePaint;
    private DrawStyle drawStyle;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public AndroidTextPaint(int i, float f) {
        super(i);
        ((TextPaint) this).density = f;
        this.composePaint = AndroidPaint_androidKt.asComposePaint(this);
        this.textDecoration = TextDecoration.Companion.getNone();
        this.shadow = Shadow.Companion.getNone();
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        TextDecoration.Companion companion = TextDecoration.Companion;
        setUnderlineText(textDecoration.contains(companion.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(companion.getLineThrough()));
    }

    public final void setShadow(Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (Intrinsics.areEqual(shadow, Shadow.Companion.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m709getXimpl(this.shadow.m953getOffsetF1C5BW0()), Offset.m710getYimpl(this.shadow.m953getOffsetF1C5BW0()), ColorKt.m871toArgb8_81llA(this.shadow.m952getColor0d7_KjU()));
        }
    }

    /* renamed from: setBrush-12SF9DM  reason: not valid java name */
    public final void m1729setBrush12SF9DM(Brush brush, long j, float f) {
        if (((brush instanceof SolidColor) && ((SolidColor) brush).m962getValue0d7_KjU() != Color.Companion.m864getUnspecified0d7_KjU()) || ((brush instanceof ShaderBrush) && j != Size.Companion.m750getUnspecifiedNHjbRc())) {
            brush.mo831applyToPq9zytI(j, this.composePaint, Float.isNaN(f) ? this.composePaint.getAlpha() : RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f));
        } else if (brush == null) {
            this.composePaint.setShader(null);
        }
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            this.composePaint.mo781setStylek9PVt8s(PaintingStyle.Companion.m930getFillTiuSbCo());
        } else if (drawStyle instanceof Stroke) {
            this.composePaint.mo781setStylek9PVt8s(PaintingStyle.Companion.m931getStrokeTiuSbCo());
            Stroke stroke = (Stroke) drawStyle;
            this.composePaint.setStrokeWidth(stroke.getWidth());
            this.composePaint.setStrokeMiterLimit(stroke.getMiter());
            this.composePaint.mo780setStrokeJoinWw9F2mQ(stroke.m1069getJoinLxFBmk8());
            this.composePaint.mo779setStrokeCapBeK7IIE(stroke.m1068getCapKaPHkGw());
            Paint paint = this.composePaint;
            stroke.getPathEffect();
            paint.setPathEffect(null);
        }
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public final int m1727getBlendMode0nO6VwU() {
        return this.composePaint.mo771getBlendMode0nO6VwU();
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public final void m1728setBlendModes9anfk8(int i) {
        this.composePaint.mo776setBlendModes9anfk8(i);
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m1730setColor8_81llA(long j) {
        if (j != Color.Companion.m864getUnspecified0d7_KjU()) {
            this.composePaint.mo777setColor8_81llA(j);
            this.composePaint.setShader(null);
        }
    }
}
