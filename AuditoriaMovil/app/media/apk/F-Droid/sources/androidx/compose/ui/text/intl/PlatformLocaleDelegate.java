package androidx.compose.ui.text.intl;
/* compiled from: PlatformLocale.kt */
/* loaded from: classes.dex */
public interface PlatformLocaleDelegate {
    LocaleList getCurrent();

    PlatformLocale parseLanguageTag(String str);
}
