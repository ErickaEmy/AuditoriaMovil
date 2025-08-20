package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectionAdjustment.kt */
/* loaded from: classes.dex */
public abstract class SelectionAdjustmentKt {
    public static final long ensureAtLeastOneChar(String text, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (i2 == 0) {
            return TextRangeKt.TextRange(i, i);
        }
        if (i == 0) {
            if (z) {
                return TextRangeKt.TextRange(StringHelpers_androidKt.findFollowingBreak(text, 0), 0);
            }
            return TextRangeKt.TextRange(0, StringHelpers_androidKt.findFollowingBreak(text, 0));
        } else if (i == i2) {
            if (z) {
                return TextRangeKt.TextRange(StringHelpers_androidKt.findPrecedingBreak(text, i2), i2);
            }
            return TextRangeKt.TextRange(i2, StringHelpers_androidKt.findPrecedingBreak(text, i2));
        } else if (z) {
            if (!z2) {
                return TextRangeKt.TextRange(StringHelpers_androidKt.findPrecedingBreak(text, i), i);
            }
            return TextRangeKt.TextRange(StringHelpers_androidKt.findFollowingBreak(text, i), i);
        } else if (!z2) {
            return TextRangeKt.TextRange(i, StringHelpers_androidKt.findFollowingBreak(text, i));
        } else {
            return TextRangeKt.TextRange(i, StringHelpers_androidKt.findPrecedingBreak(text, i));
        }
    }
}
