package b;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class fb {

    /* loaded from: classes.dex */
    public static class y {
        public static void n3(@NonNull Configuration configuration, @NonNull i9 i9Var) {
            configuration.setLocales((LocaleList) i9Var.v());
        }

        public static LocaleList y(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    @NonNull
    public static i9 y(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return i9.a(y.y(configuration));
        }
        return i9.y(configuration.locale);
    }
}
