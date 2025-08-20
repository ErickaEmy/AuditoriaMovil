package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Font.kt */
/* loaded from: classes.dex */
public abstract class FontKt {
    /* renamed from: Font-YpTlLL0$default  reason: not valid java name */
    public static /* synthetic */ Font m1629FontYpTlLL0$default(int i, FontWeight fontWeight, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i4 & 4) != 0) {
            i2 = FontStyle.Companion.m1646getNormal_LCdwA();
        }
        if ((i4 & 8) != 0) {
            i3 = FontLoadingStrategy.Companion.m1635getBlockingPKNRLFQ();
        }
        return m1628FontYpTlLL0(i, fontWeight, i2, i3);
    }

    /* renamed from: Font-YpTlLL0  reason: not valid java name */
    public static final Font m1628FontYpTlLL0(int i, FontWeight weight, int i2, int i3) {
        Intrinsics.checkNotNullParameter(weight, "weight");
        return new ResourceFont(i, weight, i2, new FontVariation$Settings(new FontVariation$Setting[0]), i3, null);
    }

    public static final FontFamily toFontFamily(Font font) {
        Intrinsics.checkNotNullParameter(font, "<this>");
        return FontFamilyKt.FontFamily(font);
    }
}
