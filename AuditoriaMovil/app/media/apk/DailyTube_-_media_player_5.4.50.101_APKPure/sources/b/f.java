package b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
/* loaded from: classes.dex */
public final class f implements t {
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final String f3822n3;
    public final Locale[] y;

    /* renamed from: zn  reason: collision with root package name */
    public static final Locale[] f3821zn = new Locale[0];

    /* renamed from: gv  reason: collision with root package name */
    public static final Locale f3819gv = new Locale("en", "XA");

    /* renamed from: v  reason: collision with root package name */
    public static final Locale f3820v = new Locale("ar", "XB");

    /* renamed from: a  reason: collision with root package name */
    public static final Locale f3818a = i9.n3("en-Latn");

    public f(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.y = f3821zn;
            this.f3822n3 = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    n3(sb, locale2);
                    if (i < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException("list[" + i + "] is null");
            }
        }
        this.y = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f3822n3 = sb.toString();
    }

    public static void n3(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        Locale[] localeArr = ((f) obj).y;
        if (this.y.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.y;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @Override // b.t
    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.y;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i = 1;
        for (Locale locale : this.y) {
            i = (i * 31) + locale.hashCode();
        }
        return i;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.y;
            if (i < localeArr.length) {
                sb.append(localeArr[i]);
                if (i < this.y.length - 1) {
                    sb.append(',');
                }
                i++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }

    @Override // b.t
    @Nullable
    public Object y() {
        return null;
    }
}
