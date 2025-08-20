package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.style.TextForegroundStyle;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextForegroundStyle.kt */
/* loaded from: classes.dex */
public final class BrushStyle implements TextForegroundStyle {
    private final float alpha;
    private final ShaderBrush value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrushStyle) {
            BrushStyle brushStyle = (BrushStyle) obj;
            return Intrinsics.areEqual(this.value, brushStyle.value) && Float.compare(this.alpha, brushStyle.alpha) == 0;
        }
        return false;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public Brush getBrush() {
        return this.value;
    }

    public final ShaderBrush getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + Float.floatToIntBits(this.alpha);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
        return TextForegroundStyle.CC.$default$merge(this, textForegroundStyle);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
        return TextForegroundStyle.CC.$default$takeOrElse(this, function0);
    }

    public String toString() {
        return "BrushStyle(value=" + this.value + ", alpha=" + this.alpha + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public BrushStyle(ShaderBrush value, float f) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.alpha = f;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public long mo1752getColor0d7_KjU() {
        return Color.Companion.m864getUnspecified0d7_KjU();
    }
}
