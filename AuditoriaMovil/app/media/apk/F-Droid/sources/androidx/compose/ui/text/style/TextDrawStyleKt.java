package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextForegroundStyle.kt */
/* loaded from: classes.dex */
public abstract class TextDrawStyleKt {
    public static final TextForegroundStyle lerp(TextForegroundStyle start, TextForegroundStyle stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        boolean z = start instanceof BrushStyle;
        if (!z && !(stop instanceof BrushStyle)) {
            return TextForegroundStyle.Companion.m1843from8_81llA(ColorKt.m869lerpjxsXWHM(start.mo1752getColor0d7_KjU(), stop.mo1752getColor0d7_KjU(), f));
        }
        if (z && (stop instanceof BrushStyle)) {
            return TextForegroundStyle.Companion.from((Brush) SpanStyleKt.lerpDiscrete(((BrushStyle) start).getBrush(), ((BrushStyle) stop).getBrush(), f), MathHelpersKt.lerp(start.getAlpha(), stop.getAlpha(), f));
        }
        return (TextForegroundStyle) SpanStyleKt.lerpDiscrete(start, stop, f);
    }

    /* renamed from: modulate-DxMtmZc */
    public static final long m1842modulateDxMtmZc(long j, float f) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : Color.m849copywmQWz5c$default(j, Color.m852getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final float takeOrElse(float f, Function0 function0) {
        return Float.isNaN(f) ? ((Number) function0.invoke()).floatValue() : f;
    }
}
