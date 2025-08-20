package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutIntrinsics.kt */
/* loaded from: classes.dex */
public final class LayoutIntrinsics {
    private BoringLayout.Metrics _boringMetrics;
    private float _maxIntrinsicWidth;
    private float _minIntrinsicWidth;
    private boolean boringMetricsIsInit;
    private final CharSequence charSequence;
    private final int textDirectionHeuristic;
    private final TextPaint textPaint;

    public LayoutIntrinsics(CharSequence charSequence, TextPaint textPaint, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        this.charSequence = charSequence;
        this.textPaint = textPaint;
        this.textDirectionHeuristic = i;
        this._maxIntrinsicWidth = Float.NaN;
        this._minIntrinsicWidth = Float.NaN;
    }

    public final BoringLayout.Metrics getBoringMetrics() {
        if (!this.boringMetricsIsInit) {
            this._boringMetrics = BoringLayoutFactory.INSTANCE.measure(this.charSequence, this.textPaint, TextLayoutKt.getTextDirectionHeuristic(this.textDirectionHeuristic));
            this.boringMetricsIsInit = true;
        }
        return this._boringMetrics;
    }

    public final float getMinIntrinsicWidth() {
        if (Float.isNaN(this._minIntrinsicWidth)) {
            float minIntrinsicWidth = LayoutIntrinsicsKt.minIntrinsicWidth(this.charSequence, this.textPaint);
            this._minIntrinsicWidth = minIntrinsicWidth;
            return minIntrinsicWidth;
        }
        return this._minIntrinsicWidth;
    }

    public final float getMaxIntrinsicWidth() {
        boolean shouldIncreaseMaxIntrinsic;
        if (Float.isNaN(this._maxIntrinsicWidth)) {
            BoringLayout.Metrics boringMetrics = getBoringMetrics();
            Float valueOf = boringMetrics != null ? Float.valueOf(boringMetrics.width) : null;
            if (valueOf == null) {
                CharSequence charSequence = this.charSequence;
                valueOf = Float.valueOf((float) Math.ceil(Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.textPaint)));
            }
            shouldIncreaseMaxIntrinsic = LayoutIntrinsicsKt.shouldIncreaseMaxIntrinsic(valueOf.floatValue(), this.charSequence, this.textPaint);
            if (shouldIncreaseMaxIntrinsic) {
                valueOf = Float.valueOf(valueOf.floatValue() + 0.5f);
            }
            float floatValue = valueOf.floatValue();
            this._maxIntrinsicWidth = floatValue;
            return floatValue;
        }
        return this._maxIntrinsicWidth;
    }
}
