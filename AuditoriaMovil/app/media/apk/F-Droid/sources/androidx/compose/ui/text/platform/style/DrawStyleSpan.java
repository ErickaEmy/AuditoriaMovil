package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DrawStyleSpan.android.kt */
/* loaded from: classes.dex */
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {
    private final DrawStyle drawStyle;

    public DrawStyleSpan(DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(drawStyle, "drawStyle");
        this.drawStyle = drawStyle;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            DrawStyle drawStyle = this.drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                textPaint.setStyle(Paint.Style.FILL);
            } else if (drawStyle instanceof Stroke) {
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(((Stroke) this.drawStyle).getWidth());
                textPaint.setStrokeMiter(((Stroke) this.drawStyle).getMiter());
                textPaint.setStrokeJoin(m1741toAndroidJoinWw9F2mQ(((Stroke) this.drawStyle).m1069getJoinLxFBmk8()));
                textPaint.setStrokeCap(m1740toAndroidCapBeK7IIE(((Stroke) this.drawStyle).m1068getCapKaPHkGw()));
                ((Stroke) this.drawStyle).getPathEffect();
                textPaint.setPathEffect(null);
            }
        }
    }

    /* renamed from: toAndroidJoin-Ww9F2mQ  reason: not valid java name */
    private final Paint.Join m1741toAndroidJoinWw9F2mQ(int i) {
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        return StrokeJoin.m976equalsimpl0(i, companion.m981getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m976equalsimpl0(i, companion.m982getRoundLxFBmk8()) ? Paint.Join.ROUND : StrokeJoin.m976equalsimpl0(i, companion.m980getBevelLxFBmk8()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    /* renamed from: toAndroidCap-BeK7IIE  reason: not valid java name */
    private final Paint.Cap m1740toAndroidCapBeK7IIE(int i) {
        StrokeCap.Companion companion = StrokeCap.Companion;
        return StrokeCap.m966equalsimpl0(i, companion.m970getButtKaPHkGw()) ? Paint.Cap.BUTT : StrokeCap.m966equalsimpl0(i, companion.m971getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m966equalsimpl0(i, companion.m972getSquareKaPHkGw()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }
}
