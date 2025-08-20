package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LetterSpacingSpanEm.kt */
/* loaded from: classes.dex */
public final class LetterSpacingSpanEm extends MetricAffectingSpan {
    private final float letterSpacing;

    public LetterSpacingSpanEm(float f) {
        this.letterSpacing = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setLetterSpacing(this.letterSpacing);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setLetterSpacing(this.letterSpacing);
    }
}
