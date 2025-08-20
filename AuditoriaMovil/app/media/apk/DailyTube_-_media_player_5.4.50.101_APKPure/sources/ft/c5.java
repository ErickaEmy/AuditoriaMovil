package ft;

import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m1.ne;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class c5 {
    public static final Pattern y = Pattern.compile("^NOTE([ \t].*)?$");

    public static long gv(String str) throws NumberFormatException {
        String[] ix2 = j5.ix(str, "\\.");
        long j2 = 0;
        for (String str2 : j5.ro(ix2[0], ":")) {
            j2 = (j2 * 60) + Long.parseLong(str2);
        }
        long j4 = j2 * 1000;
        if (ix2.length == 2) {
            j4 += Long.parseLong(ix2[1]);
        }
        return j4 * 1000;
    }

    public static boolean n3(rz rzVar) {
        String co2 = rzVar.co();
        if (co2 != null && co2.startsWith("WEBVTT")) {
            return true;
        }
        return false;
    }

    public static void v(rz rzVar) throws ne {
        int a2 = rzVar.a();
        if (n3(rzVar)) {
            return;
        }
        rzVar.oz(a2);
        throw ne.y("Expected WEBVTT. Got " + rzVar.co(), null);
    }

    @Nullable
    public static Matcher y(rz rzVar) {
        String co2;
        while (true) {
            String co3 = rzVar.co();
            if (co3 != null) {
                if (y.matcher(co3).matches()) {
                    do {
                        co2 = rzVar.co();
                        if (co2 != null) {
                        }
                    } while (!co2.isEmpty());
                } else {
                    Matcher matcher = a.y.matcher(co3);
                    if (matcher.matches()) {
                        return matcher;
                    }
                }
            } else {
                return null;
            }
        }
    }

    public static float zn(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
