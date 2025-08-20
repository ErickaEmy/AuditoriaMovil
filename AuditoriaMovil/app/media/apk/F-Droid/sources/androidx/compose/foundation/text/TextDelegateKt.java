package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: TextDelegate.kt */
/* loaded from: classes.dex */
public abstract class TextDelegateKt {
    public static final int ceilToIntPx(float f) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt((float) Math.ceil(f));
        return roundToInt;
    }

    /* renamed from: updateTextDelegate-rm0N8CA  reason: not valid java name */
    public static final TextDelegate m328updateTextDelegaterm0N8CA(TextDelegate current, AnnotatedString text, TextStyle style, Density density, FontFamily.Resolver fontFamilyResolver, boolean z, int i, int i2, int i3, List placeholders) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        if (Intrinsics.areEqual(current.getText(), text) && Intrinsics.areEqual(current.getStyle(), style)) {
            if (current.getSoftWrap() == z) {
                if (TextOverflow.m1854equalsimpl0(current.m326getOverflowgIe3tQ8(), i)) {
                    if (current.getMaxLines() == i2) {
                        if (current.getMinLines() == i3 && Intrinsics.areEqual(current.getDensity(), density) && Intrinsics.areEqual(current.getPlaceholders(), placeholders) && current.getFontFamilyResolver() == fontFamilyResolver) {
                            return current;
                        }
                        return new TextDelegate(text, style, i2, i3, z, i, density, fontFamilyResolver, placeholders, null);
                    }
                    return new TextDelegate(text, style, i2, i3, z, i, density, fontFamilyResolver, placeholders, null);
                }
                return new TextDelegate(text, style, i2, i3, z, i, density, fontFamilyResolver, placeholders, null);
            }
        }
        return new TextDelegate(text, style, i2, i3, z, i, density, fontFamilyResolver, placeholders, null);
    }
}
