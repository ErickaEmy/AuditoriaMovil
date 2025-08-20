package yt;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {
    public static final Locale y = new Locale("", "");

    /* loaded from: classes.dex */
    public static class y {
        public static int y(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    public static int y(@Nullable Locale locale) {
        return y.y(locale);
    }
}
