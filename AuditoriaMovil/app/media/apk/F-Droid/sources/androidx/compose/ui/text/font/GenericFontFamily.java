package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: FontFamily.kt */
/* loaded from: classes.dex */
public final class GenericFontFamily extends SystemFontFamily {
    private final String fontFamilyName;
    private final String name;

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.fontFamilyName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericFontFamily(String name, String fontFamilyName) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        this.name = name;
        this.fontFamilyName = fontFamilyName;
    }
}
