package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LineHeightSpan.kt */
/* loaded from: classes.dex */
public final class LineHeightSpan implements android.text.style.LineHeightSpan {
    private final float lineHeight;

    public LineHeightSpan(float f) {
        this.lineHeight = f;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        int lineHeight = LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        if (lineHeight <= 0) {
            return;
        }
        int ceil = (int) Math.ceil(this.lineHeight);
        int ceil2 = (int) Math.ceil(fontMetricsInt.descent * ((ceil * 1.0f) / lineHeight));
        fontMetricsInt.descent = ceil2;
        fontMetricsInt.ascent = ceil2 - ceil;
    }
}
