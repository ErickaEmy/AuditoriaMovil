package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ActualParagraph.android.kt.kt */
/* loaded from: classes.dex */
public abstract class AndroidParagraph_androidKt {
    /* renamed from: ActualParagraph-O3s9Psw  reason: not valid java name */
    public static final Paragraph m1726ActualParagraphO3s9Psw(String text, TextStyle style, List spanStyles, List placeholders, int i, boolean z, long j, Density density, FontFamily.Resolver fontFamilyResolver) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        return new AndroidParagraph(new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, fontFamilyResolver, density), i, z, j, null);
    }

    /* renamed from: ActualParagraph--hBUhpc  reason: not valid java name */
    public static final Paragraph m1725ActualParagraphhBUhpc(ParagraphIntrinsics paragraphIntrinsics, int i, boolean z, long j) {
        Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
        return new AndroidParagraph((AndroidParagraphIntrinsics) paragraphIntrinsics, i, z, j, null);
    }
}
