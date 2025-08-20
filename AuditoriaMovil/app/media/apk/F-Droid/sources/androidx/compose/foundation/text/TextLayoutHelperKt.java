package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextLayoutHelper.kt */
/* loaded from: classes.dex */
public abstract class TextLayoutHelperKt {
    /* renamed from: canReuse-7_7YC6M  reason: not valid java name */
    public static final boolean m355canReuse7_7YC6M(TextLayoutResult canReuse, AnnotatedString text, TextStyle style, List placeholders, int i, boolean z, int i2, Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long j) {
        Intrinsics.checkNotNullParameter(canReuse, "$this$canReuse");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        TextLayoutInput layoutInput = canReuse.getLayoutInput();
        if (!canReuse.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() && Intrinsics.areEqual(layoutInput.getText(), text) && layoutInput.getStyle().hasSameLayoutAffectingAttributes(style) && Intrinsics.areEqual(layoutInput.getPlaceholders(), placeholders) && layoutInput.getMaxLines() == i && layoutInput.getSoftWrap() == z && TextOverflow.m1854equalsimpl0(layoutInput.m1568getOverflowgIe3tQ8(), i2) && Intrinsics.areEqual(layoutInput.getDensity(), density) && layoutInput.getLayoutDirection() == layoutDirection && Intrinsics.areEqual(layoutInput.getFontFamilyResolver(), fontFamilyResolver) && Constraints.m1874getMinWidthimpl(j) == Constraints.m1874getMinWidthimpl(layoutInput.m1567getConstraintsmsEJaDk())) {
            if (z || TextOverflow.m1854equalsimpl0(i2, TextOverflow.Companion.m1858getEllipsisgIe3tQ8())) {
                return Constraints.m1872getMaxWidthimpl(j) == Constraints.m1872getMaxWidthimpl(layoutInput.m1567getConstraintsmsEJaDk()) && Constraints.m1871getMaxHeightimpl(j) == Constraints.m1871getMaxHeightimpl(layoutInput.m1567getConstraintsmsEJaDk());
            }
            return true;
        }
        return false;
    }
}
