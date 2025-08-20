package b;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
/* loaded from: classes.dex */
public final class i9 {

    /* renamed from: n3  reason: collision with root package name */
    public static final i9 f3823n3 = y(new Locale[0]);
    public final t y;

    /* loaded from: classes.dex */
    public static class y {
        public static LocaleList n3() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList y(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList zn() {
            return LocaleList.getDefault();
        }
    }

    public i9(t tVar) {
        this.y = tVar;
    }

    @NonNull
    public static i9 a(@NonNull LocaleList localeList) {
        return new i9(new tl(localeList));
    }

    @NonNull
    public static i9 gv() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a(y.zn());
        }
        return y(Locale.getDefault());
    }

    public static Locale n3(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (str.contains("_")) {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        } else {
            return new Locale(str);
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static i9 y(@NonNull Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a(y.y(localeArr));
        }
        return new i9(new f(localeArr));
    }

    public boolean equals(Object obj) {
        if ((obj instanceof i9) && this.y.equals(((i9) obj).y)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    @NonNull
    public String toString() {
        return this.y.toString();
    }

    @Nullable
    public Object v() {
        return this.y.y();
    }

    @Nullable
    public Locale zn(int i) {
        return this.y.get(i);
    }
}
