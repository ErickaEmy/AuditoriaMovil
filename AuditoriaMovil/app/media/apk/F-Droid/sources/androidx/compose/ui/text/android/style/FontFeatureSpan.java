package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FontFeatureSpan.kt */
/* loaded from: classes.dex */
public final class FontFeatureSpan extends MetricAffectingSpan {
    private final String fontFeatureSettings;

    public FontFeatureSpan(String fontFeatureSettings) {
        Intrinsics.checkNotNullParameter(fontFeatureSettings, "fontFeatureSettings");
        this.fontFeatureSettings = fontFeatureSettings;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setFontFeatureSettings(this.fontFeatureSettings);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setFontFeatureSettings(this.fontFeatureSettings);
    }
}
