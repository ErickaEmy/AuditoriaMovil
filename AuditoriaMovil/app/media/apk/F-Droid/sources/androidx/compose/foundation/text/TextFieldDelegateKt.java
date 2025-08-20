package androidx.compose.foundation.text;

import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: TextFieldDelegate.kt */
/* loaded from: classes.dex */
public abstract class TextFieldDelegateKt {
    private static final String EmptyTextReplacement;

    public static final String getEmptyTextReplacement() {
        return EmptyTextReplacement;
    }

    static {
        String repeat;
        repeat = StringsKt__StringsJVMKt.repeat("H", 10);
        EmptyTextReplacement = repeat;
    }

    public static /* synthetic */ long computeSizeForDefaultText$default(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = EmptyTextReplacement;
        }
        if ((i2 & 16) != 0) {
            i = 1;
        }
        return computeSizeForDefaultText(textStyle, density, resolver, str, i);
    }

    public static final long computeSizeForDefaultText(TextStyle style, Density density, FontFamily.Resolver fontFamilyResolver, String text, int i) {
        List emptyList;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(text, "text");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Paragraph m1532ParagraphUdtVg6A$default = ParagraphKt.m1532ParagraphUdtVg6A$default(text, style, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), density, fontFamilyResolver, emptyList, null, i, false, 64, null);
        return IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(m1532ParagraphUdtVg6A$default.getMinIntrinsicWidth()), TextDelegateKt.ceilToIntPx(m1532ParagraphUdtVg6A$default.getHeight()));
    }
}
