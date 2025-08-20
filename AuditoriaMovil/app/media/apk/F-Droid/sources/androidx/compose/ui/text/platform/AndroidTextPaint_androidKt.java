package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
/* compiled from: AndroidTextPaint.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint textPaint, float f) {
        float coerceIn;
        int roundToInt;
        Intrinsics.checkNotNullParameter(textPaint, "<this>");
        if (Float.isNaN(f)) {
            return;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f);
        roundToInt = MathKt__MathJVMKt.roundToInt(coerceIn * ((float) GF2Field.MASK));
        textPaint.setAlpha(roundToInt);
    }
}
