package androidx.compose.ui.text.intl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Locale.kt */
/* loaded from: classes.dex */
public final class Locale {
    public static final Companion Companion = new Companion(null);
    private final PlatformLocale platformLocale;

    public final PlatformLocale getPlatformLocale$ui_text_release() {
        return this.platformLocale;
    }

    public Locale(PlatformLocale platformLocale) {
        Intrinsics.checkNotNullParameter(platformLocale, "platformLocale");
        this.platformLocale = platformLocale;
    }

    /* compiled from: Locale.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Locale getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent().get(0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Locale(String languageTag) {
        this(PlatformLocaleKt.getPlatformLocaleDelegate().parseLanguageTag(languageTag));
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
    }

    public final String toLanguageTag() {
        return this.platformLocale.toLanguageTag();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Locale)) {
            if (this == obj) {
                return true;
            }
            return Intrinsics.areEqual(toLanguageTag(), ((Locale) obj).toLanguageTag());
        }
        return false;
    }

    public int hashCode() {
        return toLanguageTag().hashCode();
    }

    public String toString() {
        return toLanguageTag();
    }
}
