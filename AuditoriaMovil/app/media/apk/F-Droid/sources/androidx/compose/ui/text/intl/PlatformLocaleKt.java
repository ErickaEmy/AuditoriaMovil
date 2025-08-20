package androidx.compose.ui.text.intl;
/* compiled from: PlatformLocale.kt */
/* loaded from: classes.dex */
public abstract class PlatformLocaleKt {
    private static final PlatformLocaleDelegate platformLocaleDelegate = AndroidPlatformLocale_androidKt.createPlatformLocaleDelegate();

    public static final PlatformLocaleDelegate getPlatformLocaleDelegate() {
        return platformLocaleDelegate;
    }
}
