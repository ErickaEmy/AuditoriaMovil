package androidx.compose.ui.text.intl;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidLocaleDelegate.android.kt */
/* loaded from: classes.dex */
public final class AndroidLocale implements PlatformLocale {
    private final java.util.Locale javaLocale;

    public final java.util.Locale getJavaLocale() {
        return this.javaLocale;
    }

    public AndroidLocale(java.util.Locale javaLocale) {
        Intrinsics.checkNotNullParameter(javaLocale, "javaLocale");
        this.javaLocale = javaLocale;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    public String toLanguageTag() {
        String languageTag = this.javaLocale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "javaLocale.toLanguageTag()");
        return languageTag;
    }
}
