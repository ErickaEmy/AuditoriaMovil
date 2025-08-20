package qg;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class zn {
    public static String gv(long j2) {
        return v(j2, Locale.getDefault());
    }

    public static String n3(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return f.n3(locale).format(new Date(j2));
        }
        return f.a(locale).format(new Date(j2));
    }

    public static String v(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return f.tl(locale).format(new Date(j2));
        }
        return f.a(locale).format(new Date(j2));
    }

    public static String y(long j2) {
        return n3(j2, Locale.getDefault());
    }

    public static String zn(Context context, long j2) {
        return DateUtils.formatDateTime(context, j2 - TimeZone.getDefault().getOffset(j2), 36);
    }
}
