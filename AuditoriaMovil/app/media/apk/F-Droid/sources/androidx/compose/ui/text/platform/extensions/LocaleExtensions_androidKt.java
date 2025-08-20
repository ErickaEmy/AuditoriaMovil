package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.PlatformLocale;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LocaleExtensions.android.kt */
/* loaded from: classes.dex */
public abstract class LocaleExtensions_androidKt {
    public static final Locale toJavaLocale(androidx.compose.ui.text.intl.Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        PlatformLocale platformLocale$ui_text_release = locale.getPlatformLocale$ui_text_release();
        Intrinsics.checkNotNull(platformLocale$ui_text_release, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
        return ((AndroidLocale) platformLocale$ui_text_release).getJavaLocale();
    }
}
