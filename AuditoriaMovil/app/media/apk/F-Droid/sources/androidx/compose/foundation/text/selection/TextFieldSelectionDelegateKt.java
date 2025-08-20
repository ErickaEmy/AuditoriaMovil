package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextFieldSelectionDelegate.kt */
/* loaded from: classes.dex */
public abstract class TextFieldSelectionDelegateKt {
    /* renamed from: getTextFieldSelection-bb3KNj8  reason: not valid java name */
    public static final long m406getTextFieldSelectionbb3KNj8(TextLayoutResult textLayoutResult, int i, int i2, TextRange textRange, boolean z, SelectionAdjustment adjustment) {
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        if (textLayoutResult != null) {
            long TextRange = TextRangeKt.TextRange(i, i2);
            return (textRange == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.Companion.getCharacter())) ? TextRange : adjustment.mo394adjustZXO7KMw(textLayoutResult, TextRange, -1, z, textRange);
        }
        return TextRangeKt.TextRange(0, 0);
    }
}
