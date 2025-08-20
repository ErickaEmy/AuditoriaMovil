package qg;

import android.annotation.TargetApi;
import android.icu.util.TimeZone;
import androidx.annotation.Nullable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class f {
    public static AtomicReference<i9> y = new AtomicReference<>();

    public static DateFormat a(Locale locale) {
        return v(0, locale);
    }

    public static Calendar c5() {
        Calendar y2 = fb().y();
        y2.set(11, 0);
        y2.set(12, 0);
        y2.set(13, 0);
        y2.set(14, 0);
        y2.setTimeZone(s());
        return y2;
    }

    public static Calendar f() {
        return t(null);
    }

    public static i9 fb() {
        i9 i9Var = y.get();
        if (i9Var == null) {
            return i9.zn();
        }
        return i9Var;
    }

    public static Calendar gv(Calendar calendar) {
        Calendar t2 = t(calendar);
        Calendar f4 = f();
        f4.set(t2.get(1), t2.get(2), t2.get(5));
        return f4;
    }

    @TargetApi(24)
    public static TimeZone i9() {
        return TimeZone.getTimeZone("UTC");
    }

    @TargetApi(24)
    public static android.icu.text.DateFormat n3(Locale locale) {
        return zn("MMMEd", locale);
    }

    public static java.util.TimeZone s() {
        return java.util.TimeZone.getTimeZone("UTC");
    }

    public static Calendar t(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(s());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @TargetApi(24)
    public static android.icu.text.DateFormat tl(Locale locale) {
        return zn("yMMMEd", locale);
    }

    public static DateFormat v(int i, Locale locale) {
        DateFormat dateInstance = DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(s());
        return dateInstance;
    }

    public static long y(long j2) {
        Calendar f4 = f();
        f4.setTimeInMillis(j2);
        return gv(f4).getTimeInMillis();
    }

    @TargetApi(24)
    public static android.icu.text.DateFormat zn(String str, Locale locale) {
        android.icu.text.DateFormat instanceForSkeleton = android.icu.text.DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(i9());
        return instanceForSkeleton;
    }
}
