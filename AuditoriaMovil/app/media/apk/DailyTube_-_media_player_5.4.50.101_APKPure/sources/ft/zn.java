package ft;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: zn  reason: collision with root package name */
    public static final Pattern f8267zn = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: gv  reason: collision with root package name */
    public static final Pattern f8266gv = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    public final rz y = new rz();

    /* renamed from: n3  reason: collision with root package name */
    public final StringBuilder f8268n3 = new StringBuilder();

    public static String a(rz rzVar, StringBuilder sb) {
        boolean z2 = false;
        sb.setLength(0);
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        while (a2 < fb2 && !z2) {
            char c2 = (char) rzVar.v()[a2];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && ((c2 < '0' || c2 > '9') && c2 != '#' && c2 != '-' && c2 != '.' && c2 != '_'))) {
                z2 = true;
            } else {
                a2++;
                sb.append(c2);
            }
        }
        rzVar.ut(a2 - rzVar.a());
        return sb.toString();
    }

    @Nullable
    public static String c5(rz rzVar, StringBuilder sb) {
        String str;
        wz(rzVar);
        if (rzVar.y() < 5 || !"::cue".equals(rzVar.ta(5))) {
            return null;
        }
        int a2 = rzVar.a();
        String fb2 = fb(rzVar, sb);
        if (fb2 == null) {
            return null;
        }
        if ("{".equals(fb2)) {
            rzVar.oz(a2);
            return "";
        }
        if ("(".equals(fb2)) {
            str = t(rzVar);
        } else {
            str = null;
        }
        if (!")".equals(fb(rzVar, sb))) {
            return null;
        }
        return str;
    }

    public static char f(rz rzVar, int i) {
        return (char) rzVar.v()[i];
    }

    @Nullable
    public static String fb(rz rzVar, StringBuilder sb) {
        wz(rzVar);
        if (rzVar.y() == 0) {
            return null;
        }
        String a2 = a(rzVar, sb);
        if (!"".equals(a2)) {
            return a2;
        }
        return "" + ((char) rzVar.ej());
    }

    public static void i9(rz rzVar, gv gvVar, StringBuilder sb) {
        wz(rzVar);
        String a2 = a(rzVar, sb);
        if ("".equals(a2) || !":".equals(fb(rzVar, sb))) {
            return;
        }
        wz(rzVar);
        String s2 = s(rzVar, sb);
        if (s2 != null && !"".equals(s2)) {
            int a3 = rzVar.a();
            String fb2 = fb(rzVar, sb);
            if (!";".equals(fb2)) {
                if ("}".equals(fb2)) {
                    rzVar.oz(a3);
                } else {
                    return;
                }
            }
            if ("color".equals(a2)) {
                gvVar.p(v5.fb.n3(s2));
            } else if ("background-color".equals(a2)) {
                gvVar.wz(v5.fb.n3(s2));
            } else {
                boolean z2 = true;
                if ("ruby-position".equals(a2)) {
                    if ("over".equals(s2)) {
                        gvVar.x4(1);
                    } else if ("under".equals(s2)) {
                        gvVar.x4(2);
                    }
                } else if ("text-combine-upright".equals(a2)) {
                    if (!"all".equals(s2) && !s2.startsWith("digits")) {
                        z2 = false;
                    }
                    gvVar.w(z2);
                } else if ("text-decoration".equals(a2)) {
                    if ("underline".equals(s2)) {
                        gvVar.d0(true);
                    }
                } else if ("font-family".equals(a2)) {
                    gvVar.mt(s2);
                } else if ("font-weight".equals(a2)) {
                    if ("bold".equals(s2)) {
                        gvVar.xc(true);
                    }
                } else if ("font-style".equals(a2)) {
                    if ("italic".equals(s2)) {
                        gvVar.r(true);
                    }
                } else if ("font-size".equals(a2)) {
                    v(s2, gvVar);
                }
            }
        }
    }

    public static boolean n3(rz rzVar) {
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        byte[] v2 = rzVar.v();
        if (a2 + 2 <= fb2) {
            int i = a2 + 1;
            if (v2[a2] == 47) {
                int i5 = a2 + 2;
                if (v2[i] != 42) {
                    return false;
                }
                while (true) {
                    int i6 = i5 + 1;
                    if (i6 < fb2) {
                        if (((char) v2[i5]) == '*' && ((char) v2[i6]) == '/') {
                            i5 += 2;
                            fb2 = i5;
                        } else {
                            i5 = i6;
                        }
                    } else {
                        rzVar.ut(fb2 - rzVar.a());
                        return true;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Nullable
    public static String s(rz rzVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        while (!z2) {
            int a2 = rzVar.a();
            String fb2 = fb(rzVar, sb);
            if (fb2 == null) {
                return null;
            }
            if (!"}".equals(fb2) && !";".equals(fb2)) {
                sb2.append(fb2);
            } else {
                rzVar.oz(a2);
                z2 = true;
            }
        }
        return sb2.toString();
    }

    public static String t(rz rzVar) {
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        boolean z2 = false;
        while (a2 < fb2 && !z2) {
            int i = a2 + 1;
            if (((char) rzVar.v()[a2]) == ')') {
                z2 = true;
            } else {
                z2 = false;
            }
            a2 = i;
        }
        return rzVar.ta((a2 - 1) - rzVar.a()).trim();
    }

    public static void tl(rz rzVar) {
        do {
        } while (!TextUtils.isEmpty(rzVar.co()));
    }

    public static void v(String str, gv gvVar) {
        Matcher matcher = f8266gv.matcher(w0.zn.v(str));
        if (!matcher.matches()) {
            r.c5("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) v5.y.v(matcher.group(2));
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                gvVar.z(3);
                break;
            case 1:
                gvVar.z(2);
                break;
            case 2:
                gvVar.z(1);
                break;
            default:
                throw new IllegalStateException();
        }
        gvVar.co(Float.parseFloat((String) v5.y.v(matcher.group(1))));
    }

    public static void wz(rz rzVar) {
        while (true) {
            for (boolean z2 = true; rzVar.y() > 0 && z2; z2 = false) {
                if (!zn(rzVar) && !n3(rzVar)) {
                }
            }
            return;
        }
    }

    public static boolean zn(rz rzVar) {
        char f4 = f(rzVar, rzVar.a());
        if (f4 != '\t' && f4 != '\n' && f4 != '\f' && f4 != '\r' && f4 != ' ') {
            return false;
        }
        rzVar.ut(1);
        return true;
    }

    public List<gv> gv(rz rzVar) {
        boolean z2;
        this.f8268n3.setLength(0);
        int a2 = rzVar.a();
        tl(rzVar);
        this.y.o(rzVar.v(), rzVar.a());
        this.y.oz(a2);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String c52 = c5(this.y, this.f8268n3);
            if (c52 != null) {
                if (!"{".equals(fb(this.y, this.f8268n3))) {
                    return arrayList;
                }
                gv gvVar = new gv();
                y(gvVar, c52);
                String str = null;
                boolean z3 = false;
                while (!z3) {
                    int a3 = this.y.a();
                    String fb2 = fb(this.y, this.f8268n3);
                    if (fb2 != null && !"}".equals(fb2)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        this.y.oz(a3);
                        i9(this.y, gvVar, this.f8268n3);
                    }
                    str = fb2;
                    z3 = z2;
                }
                if ("}".equals(str)) {
                    arrayList.add(gvVar);
                }
            } else {
                return arrayList;
            }
        }
    }

    public final void y(gv gvVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = f8267zn.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                gvVar.c((String) v5.y.v(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        String[] ro2 = j5.ro(str, "\\.");
        String str2 = ro2[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            gvVar.n(str2.substring(0, indexOf2));
            gvVar.f3(str2.substring(indexOf2 + 1));
        } else {
            gvVar.n(str2);
        }
        if (ro2.length > 1) {
            gvVar.i4((String[]) j5.l(ro2, 1, ro2.length));
        }
    }
}
