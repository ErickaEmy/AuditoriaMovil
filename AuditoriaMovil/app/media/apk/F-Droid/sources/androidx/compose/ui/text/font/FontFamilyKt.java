package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FontFamily.kt */
/* loaded from: classes.dex */
public abstract class FontFamilyKt {
    public static final FontFamily FontFamily(List fonts) {
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        return new FontListFontFamily(fonts);
    }

    public static final FontFamily FontFamily(Font... fonts) {
        List asList;
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        asList = ArraysKt___ArraysJvmKt.asList(fonts);
        return new FontListFontFamily(asList);
    }
}
