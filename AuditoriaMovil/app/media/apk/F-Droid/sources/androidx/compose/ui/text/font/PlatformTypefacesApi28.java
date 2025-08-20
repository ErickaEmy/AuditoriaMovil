package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontStyle;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlatformTypefaces.kt */
/* loaded from: classes.dex */
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createDefault-FO1MlWM */
    public Typeface mo1663createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m1667createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createNamed-RetOiIg */
    public Typeface mo1664createNamedRetOiIg(GenericFontFamily name, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m1667createAndroidTypefaceApi28RetOiIg(name.getName(), fontWeight, i);
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg  reason: not valid java name */
    private final Typeface m1667createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
        Typeface create;
        Typeface create2;
        FontStyle.Companion companion = FontStyle.Companion;
        if (FontStyle.m1641equalsimpl0(i, companion.m1646getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal()) && (str == null || str.length() == 0)) {
            Typeface DEFAULT = Typeface.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
            return DEFAULT;
        }
        if (str == null) {
            create = Typeface.DEFAULT;
        } else {
            create = Typeface.create(str, 0);
        }
        create2 = Typeface.create(create, fontWeight.getWeight(), FontStyle.m1641equalsimpl0(i, companion.m1645getItalic_LCdwA()));
        Intrinsics.checkNotNullExpressionValue(create2, "create(\n            fami…ontStyle.Italic\n        )");
        return create2;
    }
}
