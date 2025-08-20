package org.fdroid.fdroid.compat;

import android.os.Build;
import java.util.Locale;
/* loaded from: classes2.dex */
public class LocaleCompat {
    public static Locale getDefault() {
        Locale.Category category;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            category = Locale.Category.DISPLAY;
            locale = Locale.getDefault(category);
            return locale;
        }
        return Locale.getDefault();
    }
}
