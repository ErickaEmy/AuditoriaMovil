package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TypefaceSpan.kt */
/* loaded from: classes.dex */
public final class TypefaceSpan extends MetricAffectingSpan {
    private final Typeface typeface;

    public TypefaceSpan(Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        updateTypeface(ds);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        updateTypeface(paint);
    }

    private final void updateTypeface(Paint paint) {
        paint.setTypeface(this.typeface);
    }
}
