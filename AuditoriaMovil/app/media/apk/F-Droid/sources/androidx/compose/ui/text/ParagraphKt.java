package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Paragraph.kt */
/* loaded from: classes.dex */
public abstract class ParagraphKt {
    /* renamed from: Paragraph-UdtVg6A$default  reason: not valid java name */
    public static /* synthetic */ Paragraph m1532ParagraphUdtVg6A$default(String str, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, List list2, int i, boolean z, int i2, Object obj) {
        List list3;
        List list4;
        List emptyList;
        List emptyList2;
        if ((i2 & 32) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list3 = emptyList2;
        } else {
            list3 = list;
        }
        if ((i2 & 64) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
        return m1531ParagraphUdtVg6A(str, textStyle, j, density, resolver, list3, list4, (i2 & 128) != 0 ? Integer.MAX_VALUE : i, (i2 & 256) != 0 ? false : z);
    }

    /* renamed from: Paragraph-UdtVg6A  reason: not valid java name */
    public static final Paragraph m1531ParagraphUdtVg6A(String text, TextStyle style, long j, Density density, FontFamily.Resolver fontFamilyResolver, List spanStyles, List placeholders, int i, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m1726ActualParagraphO3s9Psw(text, style, spanStyles, placeholders, i, z, j, density, fontFamilyResolver);
    }

    /* renamed from: Paragraph-_EkL_-Y  reason: not valid java name */
    public static final Paragraph m1533Paragraph_EkL_Y(ParagraphIntrinsics paragraphIntrinsics, long j, int i, boolean z) {
        Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m1725ActualParagraphhBUhpc(paragraphIntrinsics, i, z, j);
    }

    public static final int ceilToInt(float f) {
        return (int) Math.ceil(f);
    }
}
