package mc;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import mc.fb;
import mc.n3;
import mc.v;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public s f11411a;

    /* renamed from: c5  reason: collision with root package name */
    public StringBuilder f11412c5;

    /* renamed from: fb  reason: collision with root package name */
    public StringBuilder f11413fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f11414gv;

    /* renamed from: n3  reason: collision with root package name */
    public fb.a8 f11415n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f11416s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f11417v;
    public fb y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f11418zn;

    public static fb.ta.a ad(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return fb.ta.a.v;
            case 1:
                return fb.ta.a.fb;
            case 2:
                return fb.ta.a.y;
            default:
                return null;
        }
    }

    public static fb.w ap(String str) throws i9 {
        if (str.length() != 0) {
            int length = str.length();
            fb.xg xgVar = fb.xg.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                xgVar = fb.xg.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    xgVar = fb.xg.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new i9("Invalid length unit specifier: " + str);
                }
            }
            try {
                return new fb.w(o4(str, 0, length), xgVar);
            } catch (NumberFormatException e2) {
                throw new i9("Invalid length value: " + str, e2);
            }
        }
        throw new i9("Invalid length value (empty string)");
    }

    public static int co(float f4, float f6, float f9) {
        float f10;
        float f11 = 0.0f;
        int i = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
        float f12 = f4 % 360.0f;
        if (i < 0) {
            f12 += 360.0f;
        }
        float f13 = f12 / 60.0f;
        float f14 = f6 / 100.0f;
        float f15 = f9 / 100.0f;
        if (f14 < 0.0f) {
            f14 = 0.0f;
        } else if (f14 > 1.0f) {
            f14 = 1.0f;
        }
        if (f15 >= 0.0f) {
            if (f15 > 1.0f) {
                f11 = 1.0f;
            } else {
                f11 = f15;
            }
        }
        if (f11 <= 0.5f) {
            f10 = (f14 + 1.0f) * f11;
        } else {
            f10 = (f11 + f14) - (f14 * f11);
        }
        float f16 = (f11 * 2.0f) - f10;
        float z2 = z(f16, f10, f13 + 2.0f);
        float z3 = z(f16, f10, f13);
        return i9(z(f16, f10, f13 - 2.0f) * 256.0f) | (i9(z2 * 256.0f) << 16) | (i9(z3 * 256.0f) << 8);
    }

    public static fb.ta.zn cr(String str) {
        if ("butt".equals(str)) {
            return fb.ta.zn.y;
        }
        if ("round".equals(str)) {
            return fb.ta.zn.v;
        }
        if ("square".equals(str)) {
            return fb.ta.zn.fb;
        }
        return null;
    }

    public static float ct(String str) throws i9 {
        int length = str.length();
        if (length != 0) {
            return o4(str, 0, length);
        }
        throw new i9("Invalid float value (empty string)");
    }

    public static fb.ta.fb cy(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1171789332:
                if (str.equals("line-through")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals("underline")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c2 = 2;
                    break;
                }
                break;
            case 93826908:
                if (str.equals("blink")) {
                    c2 = 3;
                    break;
                }
                break;
            case 529818312:
                if (str.equals("overline")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return fb.ta.fb.s;
            case 1:
                return fb.ta.fb.v;
            case 2:
                return fb.ta.fb.y;
            case 3:
                return fb.ta.fb.f;
            case 4:
                return fb.ta.fb.fb;
            default:
                return null;
        }
    }

    public static fb.ta.y dm(String str) {
        if ("nonzero".equals(str)) {
            return fb.ta.y.y;
        }
        if ("evenodd".equals(str)) {
            return fb.ta.y.v;
        }
        return null;
    }

    public static String e(String str, String str2) {
        if (str.equals("none") || !str.startsWith("url(")) {
            return null;
        }
        if (str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        return str.substring(4).trim();
    }

    public static List<String> eb(String str) {
        c5 c5Var = new c5(str);
        ArrayList arrayList = null;
        do {
            String p2 = c5Var.p();
            if (p2 == null) {
                p2 = c5Var.r(',');
            }
            if (p2 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(p2);
            c5Var.c();
        } while (!c5Var.s());
        return arrayList;
    }

    public static v g(String str) throws i9 {
        v.n3 n3Var;
        c5 c5Var = new c5(str);
        c5Var.d0();
        String mt2 = c5Var.mt();
        if ("defer".equals(mt2)) {
            c5Var.d0();
            mt2 = c5Var.mt();
        }
        v.y y = n3.y(mt2);
        c5Var.d0();
        if (!c5Var.s()) {
            String mt3 = c5Var.mt();
            mt3.hashCode();
            if (!mt3.equals("meet")) {
                if (mt3.equals("slice")) {
                    n3Var = v.n3.v;
                } else {
                    throw new i9("Invalid preserveAspectRatio definition: " + str);
                }
            } else {
                n3Var = v.n3.y;
            }
        } else {
            n3Var = null;
        }
        return new v(y, n3Var);
    }

    public static fb.vl g3(String str) {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            fb.vl vlVar = null;
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                if (trim2.length() > 0) {
                    vlVar = xg(trim2);
                }
                return new fb.r(trim, vlVar);
            }
            return new fb.r(str.substring(4).trim(), (fb.vl) null);
        }
        return xg(str);
    }

    public static int i9(float f4) {
        if (f4 < 0.0f) {
            return 0;
        }
        if (f4 > 255.0f) {
            return 255;
        }
        return Math.round(f4);
    }

    public static fb.zn jz(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        c5 c5Var = new c5(str.substring(5));
        c5Var.d0();
        fb.w yc2 = yc(c5Var);
        c5Var.c();
        fb.w yc3 = yc(c5Var);
        c5Var.c();
        fb.w yc4 = yc(c5Var);
        c5Var.c();
        fb.w yc5 = yc(c5Var);
        c5Var.d0();
        if (!c5Var.a(')') && !c5Var.s()) {
            return null;
        }
        return new fb.zn(yc2, yc3, yc4, yc5);
    }

    public static Float kp(String str) {
        try {
            float ct2 = ct(str);
            if (ct2 < 0.0f) {
                ct2 = 0.0f;
            } else if (ct2 > 1.0f) {
                ct2 = 1.0f;
            }
            return Float.valueOf(ct2);
        } catch (i9 unused) {
            return null;
        }
    }

    public static fb.w lc(String str) {
        try {
            fb.w y = gv.y(str);
            if (y == null) {
                return ap(str);
            }
            return y;
        } catch (i9 unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a6, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static mc.fb.i4 m(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.f.m(java.lang.String):mc.fb$i4");
    }

    public static void mp(fb.ta taVar, String str, String str2) {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            switch (y.n3[fb.y(str).ordinal()]) {
                case 47:
                    fb.vl g32 = g3(str2);
                    taVar.v = g32;
                    if (g32 != null) {
                        taVar.y |= 1;
                        return;
                    }
                    return;
                case 48:
                    fb.ta.y dm2 = dm(str2);
                    taVar.fb = dm2;
                    if (dm2 != null) {
                        taVar.y |= 2;
                        return;
                    }
                    return;
                case 49:
                    Float kp2 = kp(str2);
                    taVar.s = kp2;
                    if (kp2 != null) {
                        taVar.y |= 4;
                        return;
                    }
                    return;
                case 50:
                    fb.vl g33 = g3(str2);
                    taVar.f = g33;
                    if (g33 != null) {
                        taVar.y |= 8;
                        return;
                    }
                    return;
                case 51:
                    Float kp3 = kp(str2);
                    taVar.t = kp3;
                    if (kp3 != null) {
                        taVar.y |= 16;
                        return;
                    }
                    return;
                case 52:
                    taVar.w = ap(str2);
                    taVar.y |= 32;
                    break;
                case 53:
                    fb.ta.zn cr2 = cr(str2);
                    taVar.p = cr2;
                    if (cr2 != null) {
                        taVar.y |= 64;
                        return;
                    }
                    return;
                case 54:
                    fb.ta.gv o02 = o0(str2);
                    taVar.co = o02;
                    if (o02 != null) {
                        taVar.y |= 128;
                        return;
                    }
                    return;
                case 55:
                    taVar.z = Float.valueOf(ct(str2));
                    taVar.y |= 256;
                    break;
                case 56:
                    if ("none".equals(str2)) {
                        taVar.r = null;
                        taVar.y |= 512;
                        return;
                    }
                    fb.w[] pq2 = pq(str2);
                    taVar.r = pq2;
                    if (pq2 != null) {
                        taVar.y |= 512;
                        return;
                    }
                    return;
                case 57:
                    taVar.f3 = ap(str2);
                    taVar.y |= 1024;
                    break;
                case 58:
                    taVar.n = kp(str2);
                    taVar.y |= 2048;
                    return;
                case 59:
                    taVar.c = u(str2);
                    taVar.y |= 4096;
                    break;
                case 60:
                    rs(taVar, str2);
                    return;
                case 61:
                    List<String> eb2 = eb(str2);
                    taVar.d0 = eb2;
                    if (eb2 != null) {
                        taVar.y |= 8192;
                        return;
                    }
                    return;
                case 62:
                    fb.w lc2 = lc(str2);
                    taVar.fh = lc2;
                    if (lc2 != null) {
                        taVar.y |= 16384;
                        return;
                    }
                    return;
                case 63:
                    Integer ra2 = ra(str2);
                    taVar.d = ra2;
                    if (ra2 != null) {
                        taVar.y |= 32768;
                        return;
                    }
                    return;
                case 64:
                    fb.ta.n3 nf2 = nf(str2);
                    taVar.ej = nf2;
                    if (nf2 != null) {
                        taVar.y |= 65536;
                        return;
                    }
                    return;
                case 65:
                    fb.ta.fb cy2 = cy(str2);
                    taVar.x = cy2;
                    if (cy2 != null) {
                        taVar.y |= 131072;
                        return;
                    }
                    return;
                case 66:
                    fb.ta.s qk2 = qk(str2);
                    taVar.b = qk2;
                    if (qk2 != null) {
                        taVar.y |= 68719476736L;
                        return;
                    }
                    return;
                case 67:
                    fb.ta.a ad2 = ad(str2);
                    taVar.j5 = ad2;
                    if (ad2 != null) {
                        taVar.y |= 262144;
                        return;
                    }
                    return;
                case 68:
                    Boolean rb2 = rb(str2);
                    taVar.qn = rb2;
                    if (rb2 != null) {
                        taVar.y |= 524288;
                        return;
                    }
                    return;
                case 69:
                    String e2 = e(str2, str);
                    taVar.j = e2;
                    taVar.oz = e2;
                    taVar.ut = e2;
                    taVar.y |= 14680064;
                    return;
                case 70:
                    taVar.j = e(str2, str);
                    taVar.y |= 2097152;
                    return;
                case 71:
                    taVar.oz = e(str2, str);
                    taVar.y |= 4194304;
                    return;
                case 72:
                    taVar.ut = e(str2, str);
                    taVar.y |= 8388608;
                    return;
                case 73:
                    if (str2.indexOf(124) < 0) {
                        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains('|' + str2 + '|')) {
                            taVar.q9 = Boolean.valueOf(!str2.equals("none"));
                            taVar.y |= 16777216;
                            return;
                        }
                        return;
                    }
                    return;
                case 74:
                    if (str2.indexOf(124) < 0) {
                        if ("|visible|hidden|collapse|".contains('|' + str2 + '|')) {
                            taVar.k = Boolean.valueOf(str2.equals("visible"));
                            taVar.y |= 33554432;
                            return;
                        }
                        return;
                    }
                    return;
                case 75:
                    if (str2.equals("currentColor")) {
                        taVar.f7 = fb.fb.n3();
                    } else {
                        try {
                            taVar.f7 = u(str2);
                        } catch (i9 e3) {
                            Log.w("SVGParser", e3.getMessage());
                            return;
                        }
                    }
                    taVar.y |= 67108864;
                    return;
                case 76:
                    taVar.en = kp(str2);
                    taVar.y |= 134217728;
                    return;
                case 77:
                    fb.zn jz2 = jz(str2);
                    taVar.o = jz2;
                    if (jz2 != null) {
                        taVar.y |= 1048576;
                        return;
                    }
                    return;
                case 78:
                    taVar.jz = e(str2, str);
                    taVar.y |= 268435456;
                    return;
                case 79:
                    taVar.u = dm(str2);
                    taVar.y |= 536870912;
                    return;
                case 80:
                    taVar.y5 = e(str2, str);
                    taVar.y |= 1073741824;
                    return;
                case 81:
                    if (str2.equals("currentColor")) {
                        taVar.xg = fb.fb.n3();
                    } else {
                        try {
                            taVar.xg = u(str2);
                        } catch (i9 e5) {
                            Log.w("SVGParser", e5.getMessage());
                            return;
                        }
                    }
                    taVar.y |= 2147483648L;
                    return;
                case 82:
                    taVar.dm = kp(str2);
                    taVar.y |= 4294967296L;
                    return;
                case 83:
                    if (str2.equals("currentColor")) {
                        taVar.ct = fb.fb.n3();
                    } else {
                        try {
                            taVar.ct = u(str2);
                        } catch (i9 e6) {
                            Log.w("SVGParser", e6.getMessage());
                            return;
                        }
                    }
                    taVar.y |= 8589934592L;
                    return;
                case 84:
                    taVar.o4 = kp(str2);
                    taVar.y |= 17179869184L;
                    return;
                case 85:
                    fb.ta.c5 vp2 = vp(str2);
                    taVar.rs = vp2;
                    if (vp2 != null) {
                        taVar.y |= 34359738368L;
                        return;
                    }
                    return;
                case 86:
                    fb.ta.v y42 = y4(str2);
                    taVar.eb = y42;
                    if (y42 != null) {
                        taVar.y |= 137438953472L;
                        return;
                    }
                    return;
                default:
            }
        } catch (i9 unused) {
        }
    }

    public static fb.ta.n3 nf(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return fb.ta.n3.fb;
            case 1:
                return fb.ta.n3.v;
            case 2:
                return fb.ta.n3.y;
            default:
                return null;
        }
    }

    public static fb.ta.gv o0(String str) {
        if ("miter".equals(str)) {
            return fb.ta.gv.y;
        }
        if ("round".equals(str)) {
            return fb.ta.gv.v;
        }
        if ("bevel".equals(str)) {
            return fb.ta.gv.fb;
        }
        return null;
    }

    public static float o4(String str, int i, int i5) throws i9 {
        float n32 = new gv().n3(str, i, i5);
        if (!Float.isNaN(n32)) {
            return n32;
        }
        throw new i9("Invalid float value: " + str);
    }

    public static fb.n3 oa(String str) throws i9 {
        c5 c5Var = new c5(str);
        c5Var.d0();
        float wz2 = c5Var.wz();
        c5Var.c();
        float wz3 = c5Var.wz();
        c5Var.c();
        float wz4 = c5Var.wz();
        c5Var.c();
        float wz5 = c5Var.wz();
        if (!Float.isNaN(wz2) && !Float.isNaN(wz3) && !Float.isNaN(wz4) && !Float.isNaN(wz5)) {
            if (wz4 >= 0.0f) {
                if (wz5 >= 0.0f) {
                    return new fb.n3(wz2, wz3, wz4, wz5);
                }
                throw new i9("Invalid viewBox. height cannot be negative");
            }
            throw new i9("Invalid viewBox. width cannot be negative");
        }
        throw new i9("Invalid viewBox definition - should have four numbers");
    }

    public static fb.w[] pq(String str) {
        fb.w w4;
        c5 c5Var = new c5(str);
        c5Var.d0();
        if (c5Var.s() || (w4 = c5Var.w()) == null || w4.c5()) {
            return null;
        }
        float n32 = w4.n3();
        ArrayList arrayList = new ArrayList();
        arrayList.add(w4);
        while (!c5Var.s()) {
            c5Var.c();
            fb.w w5 = c5Var.w();
            if (w5 == null || w5.c5()) {
                return null;
            }
            arrayList.add(w5);
            n32 += w5.n3();
        }
        if (n32 == 0.0f) {
            return null;
        }
        return (fb.w[]) arrayList.toArray(new fb.w[arrayList.size()]);
    }

    public static Set<String> pz(String str) {
        c5 c5Var = new c5(str);
        HashSet hashSet = new HashSet();
        while (!c5Var.s()) {
            hashSet.add(c5Var.mt());
            c5Var.d0();
        }
        return hashSet;
    }

    public static fb.ta.s qk(String str) {
        str.hashCode();
        if (!str.equals("ltr")) {
            if (!str.equals("rtl")) {
                return null;
            }
            return fb.ta.s.v;
        }
        return fb.ta.s.y;
    }

    public static Integer ra(String str) {
        return v.y(str);
    }

    public static Boolean rb(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals("hidden")) {
                    c2 = 0;
                    break;
                }
                break;
            case -907680051:
                if (str.equals("scroll")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 2;
                    break;
                }
                break;
            case 466743410:
                if (str.equals("visible")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return Boolean.FALSE;
            case 2:
            case 3:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static void rs(fb.ta taVar, String str) {
        String co2;
        int intValue;
        if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            return;
        }
        c5 c5Var = new c5(str);
        Integer num = null;
        fb.ta.n3 n3Var = null;
        String str2 = null;
        while (true) {
            co2 = c5Var.co('/');
            c5Var.d0();
            if (co2 == null) {
                return;
            }
            if (num != null && n3Var != null) {
                break;
            } else if (!co2.equals("normal") && (num != null || (num = v.y(co2)) == null)) {
                if (n3Var != null || (n3Var = nf(co2)) == null) {
                    if (str2 != null || !co2.equals("small-caps")) {
                        break;
                    }
                    str2 = co2;
                }
            }
        }
        fb.w lc2 = lc(co2);
        if (c5Var.a('/')) {
            c5Var.d0();
            String mt2 = c5Var.mt();
            if (mt2 != null) {
                try {
                    ap(mt2);
                } catch (i9 unused) {
                    return;
                }
            }
            c5Var.d0();
        }
        taVar.d0 = eb(c5Var.n());
        taVar.fh = lc2;
        if (num == null) {
            intValue = 400;
        } else {
            intValue = num.intValue();
        }
        taVar.d = Integer.valueOf(intValue);
        if (n3Var == null) {
            n3Var = fb.ta.n3.y;
        }
        taVar.ej = n3Var;
        taVar.y |= 122880;
    }

    public static Set<String> tg(String str) {
        c5 c5Var = new c5(str);
        HashSet hashSet = new HashSet();
        while (!c5Var.s()) {
            String mt2 = c5Var.mt();
            if (mt2.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(mt2.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            c5Var.d0();
        }
        return hashSet;
    }

    public static fb.a u(String str) throws i9 {
        int i = 5;
        if (str.charAt(0) == '#') {
            zn n32 = zn.n3(str, 1, str.length());
            if (n32 != null) {
                int y = n32.y();
                if (y != 4) {
                    if (y != 5) {
                        if (y != 7) {
                            if (y == 9) {
                                return new fb.a((n32.gv() >>> 8) | (n32.gv() << 24));
                            }
                            throw new i9("Bad hex colour value: " + str);
                        }
                        return new fb.a(n32.gv() | (-16777216));
                    }
                    int gv2 = n32.gv();
                    int i5 = 61440 & gv2;
                    int i6 = gv2 & 3840;
                    int i8 = gv2 & 240;
                    int i10 = gv2 & 15;
                    return new fb.a((i10 << 24) | (i10 << 28) | (i5 << 8) | (i5 << 4) | (i6 << 4) | i6 | i8 | (i8 >> 4));
                }
                int gv3 = n32.gv();
                int i11 = gv3 & 3840;
                int i12 = gv3 & 240;
                int i13 = gv3 & 15;
                return new fb.a(i13 | (i11 << 8) | (-16777216) | (i11 << 12) | (i12 << 8) | (i12 << 4) | (i13 << 4));
            }
            throw new i9("Bad hex colour value: " + str);
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean startsWith = lowerCase.startsWith("rgba(");
        if (!startsWith && !lowerCase.startsWith("rgb(")) {
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (!startsWith2 && !lowerCase.startsWith("hsl(")) {
                return y5(lowerCase);
            }
            if (!startsWith2) {
                i = 4;
            }
            c5 c5Var = new c5(str.substring(i));
            c5Var.d0();
            float wz2 = c5Var.wz();
            float gv4 = c5Var.gv(wz2);
            if (!Float.isNaN(gv4)) {
                c5Var.a('%');
            }
            float gv5 = c5Var.gv(gv4);
            if (!Float.isNaN(gv5)) {
                c5Var.a('%');
            }
            if (startsWith2) {
                float gv6 = c5Var.gv(gv5);
                c5Var.d0();
                if (!Float.isNaN(gv6) && c5Var.a(')')) {
                    return new fb.a((i9(gv6 * 256.0f) << 24) | co(wz2, gv4, gv5));
                }
                throw new i9("Bad hsla() colour value: " + str);
            }
            c5Var.d0();
            if (!Float.isNaN(gv5) && c5Var.a(')')) {
                return new fb.a(co(wz2, gv4, gv5) | (-16777216));
            }
            throw new i9("Bad hsl() colour value: " + str);
        }
        if (!startsWith) {
            i = 4;
        }
        c5 c5Var2 = new c5(str.substring(i));
        c5Var2.d0();
        float wz3 = c5Var2.wz();
        if (!Float.isNaN(wz3) && c5Var2.a('%')) {
            wz3 = (wz3 * 256.0f) / 100.0f;
        }
        float gv7 = c5Var2.gv(wz3);
        if (!Float.isNaN(gv7) && c5Var2.a('%')) {
            gv7 = (gv7 * 256.0f) / 100.0f;
        }
        float gv8 = c5Var2.gv(gv7);
        if (!Float.isNaN(gv8) && c5Var2.a('%')) {
            gv8 = (gv8 * 256.0f) / 100.0f;
        }
        if (startsWith) {
            float gv9 = c5Var2.gv(gv8);
            c5Var2.d0();
            if (!Float.isNaN(gv9) && c5Var2.a(')')) {
                return new fb.a((i9(gv9 * 256.0f) << 24) | (i9(wz3) << 16) | (i9(gv7) << 8) | i9(gv8));
            }
            throw new i9("Bad rgba() colour value: " + str);
        }
        c5Var2.d0();
        if (!Float.isNaN(gv8) && c5Var2.a(')')) {
            return new fb.a((i9(wz3) << 16) | (-16777216) | (i9(gv7) << 8) | i9(gv8));
        }
        throw new i9("Bad rgb() colour value: " + str);
    }

    public static void u0(fb.hw hwVar, String str) throws i9 {
        hwVar.f11441xc = g(str);
    }

    public static fb.ta.c5 vp(String str) {
        str.hashCode();
        if (!str.equals("none")) {
            if (!str.equals("non-scaling-stroke")) {
                return null;
            }
            return fb.ta.c5.v;
        }
        return fb.ta.c5.y;
    }

    public static Set<String> wf(String str) {
        c5 c5Var = new c5(str);
        HashSet hashSet = new HashSet();
        while (!c5Var.s()) {
            String mt2 = c5Var.mt();
            int indexOf = mt2.indexOf(45);
            if (indexOf != -1) {
                mt2 = mt2.substring(0, indexOf);
            }
            hashSet.add(new Locale(mt2, "", "").getLanguage());
            c5Var.d0();
        }
        return hashSet;
    }

    public static void xb(fb.b bVar, String str) {
        c5 c5Var = new c5(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String co2 = c5Var.co(':');
            c5Var.d0();
            if (c5Var.a(':')) {
                c5Var.d0();
                String r2 = c5Var.r(';');
                if (r2 == null) {
                    return;
                }
                c5Var.d0();
                if (c5Var.s() || c5Var.a(';')) {
                    if (bVar.f11425a == null) {
                        bVar.f11425a = new fb.ta();
                    }
                    mp(bVar.f11425a, co2, r2);
                    c5Var.d0();
                }
            } else {
                return;
            }
        }
    }

    public static fb.vl xg(String str) {
        str.hashCode();
        if (!str.equals("none")) {
            if (!str.equals("currentColor")) {
                try {
                    return u(str);
                } catch (i9 unused) {
                    return null;
                }
            }
            return fb.fb.n3();
        }
        return fb.a.fb;
    }

    public static fb.ta.v y4(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -933002398:
                if (str.equals("optimizeQuality")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 1;
                    break;
                }
                break;
            case 362741610:
                if (str.equals("optimizeSpeed")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return fb.ta.v.v;
            case 1:
                return fb.ta.v.y;
            case 2:
                return fb.ta.v.fb;
            default:
                return null;
        }
    }

    public static fb.a y5(String str) throws i9 {
        Integer y = zn.y(str);
        if (y != null) {
            return new fb.a(y.intValue());
        }
        throw new i9("Invalid colour keyword: " + str);
    }

    public static fb.w yc(c5 c5Var) {
        if (c5Var.fb("auto")) {
            return new fb.w(0.0f);
        }
        return c5Var.w();
    }

    public static List<fb.w> yg(String str) throws i9 {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            c5 c5Var = new c5(str);
            c5Var.d0();
            while (!c5Var.s()) {
                float wz2 = c5Var.wz();
                if (!Float.isNaN(wz2)) {
                    fb.xg x42 = c5Var.x4();
                    if (x42 == null) {
                        x42 = fb.xg.px;
                    }
                    arrayList.add(new fb.w(wz2, x42));
                    c5Var.c();
                } else {
                    throw new i9("Invalid length list value: " + c5Var.n3());
                }
            }
            return arrayList;
        }
        throw new i9("Invalid length list (empty string)");
    }

    public static float z(float f4, float f6, float f9) {
        float f10;
        if (f9 < 0.0f) {
            f9 += 6.0f;
        }
        if (f9 >= 6.0f) {
            f9 -= 6.0f;
        }
        if (f9 < 1.0f) {
            f10 = (f6 - f4) * f9;
        } else if (f9 < 3.0f) {
            return f6;
        } else {
            if (f9 < 4.0f) {
                f10 = (f6 - f4) * (4.0f - f9);
            } else {
                return f4;
            }
        }
        return f10 + f4;
    }

    public final void a8(fb.mt mtVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (y.n3[fb.y(attributes.getLocalName(i)).ordinal()]) {
                case 26:
                    mtVar.mt = ap(trim);
                    break;
                case 27:
                    mtVar.co = ap(trim);
                    break;
                case 28:
                    fb.w ap2 = ap(trim);
                    mtVar.z = ap2;
                    if (ap2.c5()) {
                        throw new i9("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case 29:
                    fb.w ap3 = ap(trim);
                    mtVar.r = ap3;
                    if (ap3.c5()) {
                        throw new i9("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case 30:
                    if ("strokeWidth".equals(trim)) {
                        mtVar.p = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        mtVar.p = true;
                        break;
                    } else {
                        throw new i9("Invalid value for attribute markerUnits");
                    }
                case 31:
                    if ("auto".equals(trim)) {
                        mtVar.x4 = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        mtVar.x4 = Float.valueOf(ct(trim));
                        break;
                    }
            }
        }
    }

    public final void b(fb.x4 x4Var, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 8) {
                if (i5 != 9) {
                    continue;
                } else {
                    Float valueOf = Float.valueOf(ct(trim));
                    x4Var.w = valueOf;
                    if (valueOf.floatValue() < 0.0f) {
                        throw new i9("Invalid <path> element. pathLength cannot be negative");
                    }
                }
            } else {
                x4Var.xc = m(trim);
            }
        }
    }

    public final Map<String, String> bk(c5 c5Var) {
        HashMap hashMap = new HashMap();
        c5Var.d0();
        String co2 = c5Var.co('=');
        while (co2 != null) {
            c5Var.a('=');
            hashMap.put(co2, c5Var.p());
            c5Var.d0();
            co2 = c5Var.co('=');
        }
        return hashMap;
    }

    public final void br(Attributes attributes) throws i9 {
        t("<view>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.qn ctVar = new fb.ct();
            ctVar.y = this.y;
            ctVar.f11457n3 = this.f11415n3;
            mg(ctVar, attributes);
            rz(ctVar, attributes);
            f7(ctVar, attributes);
            this.f11415n3.s(ctVar);
            this.f11415n3 = ctVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void bv(Attributes attributes) throws i9 {
        t("<tspan>", new Object[0]);
        fb.a8 a8Var = this.f11415n3;
        if (a8Var != null) {
            if (a8Var instanceof fb.f7) {
                fb.jz utVar = new fb.ut();
                utVar.y = this.y;
                utVar.f11457n3 = this.f11415n3;
                mg(utVar, attributes);
                o(utVar, attributes);
                rz(utVar, attributes);
                ut(utVar, attributes);
                this.f11415n3.s(utVar);
                this.f11415n3 = utVar;
                fb.u uVar = utVar.f11457n3;
                if (uVar instanceof fb.u) {
                    utVar.xc(uVar);
                    return;
                } else {
                    utVar.xc(((fb.k) uVar).v());
                    return;
                }
            }
            throw new i9("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public fb c(InputStream inputStream, boolean z2) throws i9 {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            gq(inputStream, z2);
            return this.y;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
        }
    }

    public final void c5(Attributes attributes) throws i9 {
        t("<circle>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz gvVar = new fb.gv();
            gvVar.y = this.y;
            gvVar.f11457n3 = this.f11415n3;
            mg(gvVar, attributes);
            o(gvVar, attributes);
            q9(gvVar, attributes);
            rz(gvVar, attributes);
            d0(gvVar, attributes);
            this.f11415n3.s(gvVar);
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void cs(Attributes attributes) throws i9 {
        t("<rect>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz fhVar = new fb.fh();
            fhVar.y = this.y;
            fhVar.f11457n3 = this.f11415n3;
            mg(fhVar, attributes);
            o(fhVar, attributes);
            q9(fhVar, attributes);
            rz(fhVar, attributes);
            hw(fhVar, attributes);
            this.f11415n3.s(fhVar);
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(mc.fb.i9 r5, org.xml.sax.Attributes r6) throws mc.i9 {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L90
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = mc.f.y.n3
            java.lang.String r3 = r6.getLocalName(r0)
            mc.f$fb r3 = mc.f.fb.y(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 6
            if (r2 == r3) goto L72
            switch(r2) {
                case 32: goto L50;
                case 33: goto L49;
                case 34: goto L26;
                default: goto L25;
            }
        L25:
            goto L8c
        L26:
            mc.fb$f r2 = mc.fb.f.valueOf(r1)     // Catch: java.lang.IllegalArgumentException -> L2d
            r5.f = r2     // Catch: java.lang.IllegalArgumentException -> L2d
            goto L8c
        L2d:
            mc.i9 r5 = new mc.i9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Invalid spreadMethod attribute. \""
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "\" is not a valid value."
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L49:
            android.graphics.Matrix r1 = r4.qj(r1)
            r5.i9 = r1
            goto L8c
        L50:
            java.lang.String r2 = "objectBoundingBox"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L5d
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r5.c5 = r1
            goto L8c
        L5d:
            java.lang.String r2 = "userSpaceOnUse"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L6a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r5.c5 = r1
            goto L8c
        L6a:
            mc.i9 r5 = new mc.i9
            java.lang.String r6 = "Invalid value for attribute gradientUnits"
            r5.<init>(r6)
            throw r5
        L72:
            java.lang.String r2 = ""
            java.lang.String r3 = r6.getURI(r0)
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L8a
            java.lang.String r2 = "http://www.w3.org/1999/xlink"
            java.lang.String r3 = r6.getURI(r0)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L8c
        L8a:
            r5.t = r1
        L8c:
            int r0 = r0 + 1
            goto L1
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.f.d(mc.fb$i9, org.xml.sax.Attributes):void");
    }

    public final void d0(fb.gv gvVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (y.n3[fb.y(attributes.getLocalName(i)).ordinal()]) {
                case 12:
                    gvVar.xc = ap(trim);
                    break;
                case 13:
                    gvVar.w = ap(trim);
                    break;
                case 14:
                    fb.w ap2 = ap(trim);
                    gvVar.p = ap2;
                    if (ap2.c5()) {
                        throw new i9("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    public final void ej(fb.p pVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (y.n3[fb.y(attributes.getLocalName(i)).ordinal()]) {
                case 15:
                    pVar.xc = ap(trim);
                    break;
                case 16:
                    pVar.w = ap(trim);
                    break;
                case 17:
                    pVar.p = ap(trim);
                    break;
                case 18:
                    pVar.mt = ap(trim);
                    break;
            }
        }
    }

    public final void en(String str) {
        this.y.y(new n3(n3.a.p, n3$r.Document).gv(str));
    }

    public final void f(Attributes attributes) throws i9 {
        t("<clipPath>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz vVar = new fb.v();
            vVar.y = this.y;
            vVar.f11457n3 = this.f11415n3;
            mg(vVar, attributes);
            o(vVar, attributes);
            q9(vVar, attributes);
            rz(vVar, attributes);
            fh(vVar, attributes);
            this.f11415n3.s(vVar);
            this.f11415n3 = vVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void f3(Attributes attributes) throws i9 {
        t("<marker>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.qn mtVar = new fb.mt();
            mtVar.y = this.y;
            mtVar.f11457n3 = this.f11415n3;
            mg(mtVar, attributes);
            o(mtVar, attributes);
            rz(mtVar, attributes);
            f7(mtVar, attributes);
            a8(mtVar, attributes);
            this.f11415n3.s(mtVar);
            this.f11415n3 = mtVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void f7(fb.qn qnVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 7) {
                if (i5 == 87) {
                    qnVar.f11445w = oa(trim);
                }
            } else {
                u0(qnVar, trim);
            }
        }
    }

    public final void fc(Attributes attributes) throws i9 {
        t("<use>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz dmVar = new fb.dm();
            dmVar.y = this.y;
            dmVar.f11457n3 = this.f11415n3;
            mg(dmVar, attributes);
            o(dmVar, attributes);
            q9(dmVar, attributes);
            rz(dmVar, attributes);
            k(dmVar, attributes);
            this.f11415n3.s(dmVar);
            this.f11415n3 = dmVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void fh(fb.v vVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (y.n3[fb.y(attributes.getLocalName(i)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    vVar.w = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    vVar.w = Boolean.TRUE;
                } else {
                    throw new i9("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    public final void gf(Attributes attributes) throws i9 {
        t("<tref>", new Object[0]);
        fb.a8 a8Var = this.f11415n3;
        if (a8Var != null) {
            if (a8Var instanceof fb.f7) {
                fb.oz ozVar = new fb.oz();
                ozVar.y = this.y;
                ozVar.f11457n3 = this.f11415n3;
                mg(ozVar, attributes);
                o(ozVar, attributes);
                rz(ozVar, attributes);
                j(ozVar, attributes);
                this.f11415n3.s(ozVar);
                fb.u uVar = ozVar.f11457n3;
                if (uVar instanceof fb.u) {
                    ozVar.xc(uVar);
                    return;
                } else {
                    ozVar.xc(((fb.k) uVar).v());
                    return;
                }
            }
            throw new i9("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void gq(InputStream inputStream, boolean z2) throws i9 {
        try {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                i9 i9Var = new i9(this, newPullParser);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                newPullParser.setInput(inputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                    if (eventType != 0) {
                        if (eventType != 8) {
                            if (eventType != 10) {
                                if (eventType != 2) {
                                    if (eventType != 3) {
                                        if (eventType != 4) {
                                            if (eventType == 5) {
                                                ne(newPullParser.getText());
                                            }
                                        } else {
                                            int[] iArr = new int[2];
                                            wm(newPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                                        }
                                    } else {
                                        String name = newPullParser.getName();
                                        if (newPullParser.getPrefix() != null) {
                                            name = newPullParser.getPrefix() + ':' + name;
                                        }
                                        w(newPullParser.getNamespace(), newPullParser.getName(), name);
                                    }
                                } else {
                                    String name2 = newPullParser.getName();
                                    if (newPullParser.getPrefix() != null) {
                                        name2 = newPullParser.getPrefix() + ':' + name2;
                                    }
                                    yk(newPullParser.getNamespace(), newPullParser.getName(), name2, i9Var);
                                }
                            } else if (z2 && this.y.c5() == null && newPullParser.getText().contains("<!ENTITY ")) {
                                try {
                                    inputStream.reset();
                                    l(inputStream);
                                    return;
                                } catch (IOException unused) {
                                    Log.w("SVGParser", "Detected internal entity definitions, but could not parse them.");
                                    return;
                                }
                            }
                        } else {
                            c5 c5Var = new c5(newPullParser.getText());
                            mt(c5Var.mt(), bk(c5Var));
                        }
                    } else {
                        ix();
                    }
                }
                xc();
            } catch (IOException e2) {
                throw new i9("Stream error", e2);
            }
        } catch (XmlPullParserException e3) {
            throw new i9("XML parser problem", e3);
        }
    }

    public final void hw(fb.fh fhVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 != 10) {
                                if (i5 != 11) {
                                    continue;
                                } else {
                                    fb.w ap2 = ap(trim);
                                    fhVar.z = ap2;
                                    if (ap2.c5()) {
                                        throw new i9("Invalid <rect> element. ry cannot be negative");
                                    }
                                }
                            } else {
                                fb.w ap3 = ap(trim);
                                fhVar.co = ap3;
                                if (ap3.c5()) {
                                    throw new i9("Invalid <rect> element. rx cannot be negative");
                                }
                            }
                        } else {
                            fb.w ap4 = ap(trim);
                            fhVar.mt = ap4;
                            if (ap4.c5()) {
                                throw new i9("Invalid <rect> element. height cannot be negative");
                            }
                        }
                    } else {
                        fb.w ap5 = ap(trim);
                        fhVar.p = ap5;
                        if (ap5.c5()) {
                            throw new i9("Invalid <rect> element. width cannot be negative");
                        }
                    }
                } else {
                    fhVar.w = ap(trim);
                }
            } else {
                fhVar.xc = ap(trim);
            }
        }
    }

    public final void i2(Attributes attributes) throws i9 {
        t("<stop>", new Object[0]);
        fb.a8 a8Var = this.f11415n3;
        if (a8Var != null) {
            if (a8Var instanceof fb.i9) {
                fb.mg mgVar = new fb.mg();
                mgVar.y = this.y;
                mgVar.f11457n3 = this.f11415n3;
                mg(mgVar, attributes);
                o(mgVar, attributes);
                qn(mgVar, attributes);
                this.f11415n3.s(mgVar);
                this.f11415n3 = mgVar;
                return;
            }
            throw new i9("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void i3(Attributes attributes) throws i9 {
        t("<style>", new Object[0]);
        if (this.f11415n3 != null) {
            String str = "all";
            boolean z2 = true;
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
                if (i5 != 88) {
                    if (i5 == 89) {
                        str = trim;
                    }
                } else {
                    z2 = trim.equals("text/css");
                }
            }
            if (z2 && n3.n3(str, n3.a.p)) {
                this.f11416s = true;
                return;
            }
            this.f11418zn = true;
            this.f11414gv = 1;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void i4(Attributes attributes) throws i9 {
        t("<linearGradient>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.i9 k5Var = new fb.k5();
            k5Var.y = this.y;
            k5Var.f11457n3 = this.f11415n3;
            mg(k5Var, attributes);
            o(k5Var, attributes);
            d(k5Var, attributes);
            ud(k5Var, attributes);
            this.f11415n3.s(k5Var);
            this.f11415n3 = k5Var;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void ix() {
        this.y = new fb();
    }

    public final void j(fb.oz ozVar, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (y.n3[fb.y(attributes.getLocalName(i)).ordinal()] == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                ozVar.xc = trim;
            }
        }
    }

    public final void j3(Attributes attributes) throws i9 {
        t("<symbol>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.qn jVar = new fb.j();
            jVar.y = this.y;
            jVar.f11457n3 = this.f11415n3;
            mg(jVar, attributes);
            o(jVar, attributes);
            rz(jVar, attributes);
            f7(jVar, attributes);
            this.f11415n3.s(jVar);
            this.f11415n3 = jVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void j5(fb.d dVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 == 5) {
                                dVar.f11433r = trim;
                            }
                        } else {
                            fb.w ap2 = ap(trim);
                            dVar.f11434z = ap2;
                            if (ap2.c5()) {
                                throw new i9("Invalid <svg> element. height cannot be negative");
                            }
                        }
                    } else {
                        fb.w ap3 = ap(trim);
                        dVar.f11430co = ap3;
                        if (ap3.c5()) {
                            throw new i9("Invalid <svg> element. width cannot be negative");
                        }
                    }
                } else {
                    dVar.f11431mt = ap(trim);
                }
            } else {
                dVar.f11432p = ap(trim);
            }
        }
    }

    public final void k(fb.dm dmVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                                dmVar.w = trim;
                            }
                        } else {
                            fb.w ap2 = ap(trim);
                            dmVar.z = ap2;
                            if (ap2.c5()) {
                                throw new i9("Invalid <use> element. height cannot be negative");
                            }
                        }
                    } else {
                        fb.w ap3 = ap(trim);
                        dmVar.co = ap3;
                        if (ap3.c5()) {
                            throw new i9("Invalid <use> element. width cannot be negative");
                        }
                    }
                } else {
                    dmVar.mt = ap(trim);
                }
            } else {
                dmVar.p = ap(trim);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cf, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k5(mc.fb.n r6, org.xml.sax.Attributes r7) throws mc.i9 {
        /*
            r5 = this;
            r0 = 0
        L1:
            int r1 = r7.getLength()
            if (r0 >= r1) goto Ld3
            java.lang.String r1 = r7.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = mc.f.y.n3
            java.lang.String r3 = r7.getLocalName(r0)
            mc.f$fb r3 = mc.f.fb.y(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto Lc9
            r3 = 2
            if (r2 == r3) goto Lc2
            r3 = 3
            if (r2 == r3) goto Lad
            r3 = 4
            if (r2 == r3) goto L98
            r3 = 6
            if (r2 == r3) goto L7d
            java.lang.String r3 = "userSpaceOnUse"
            java.lang.String r4 = "objectBoundingBox"
            switch(r2) {
                case 40: goto L5f;
                case 41: goto L3f;
                case 42: goto L37;
                default: goto L35;
            }
        L35:
            goto Lcf
        L37:
            android.graphics.Matrix r1 = r5.qj(r1)
            r6.co = r1
            goto Lcf
        L3f:
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L4b
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r6.mt = r1
            goto Lcf
        L4b:
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L57
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r6.mt = r1
            goto Lcf
        L57:
            mc.i9 r6 = new mc.i9
            java.lang.String r7 = "Invalid value for attribute patternContentUnits"
            r6.<init>(r7)
            throw r6
        L5f:
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L6a
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r6.p = r1
            goto Lcf
        L6a:
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L75
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r6.p = r1
            goto Lcf
        L75:
            mc.i9 r6 = new mc.i9
            java.lang.String r7 = "Invalid value for attribute patternUnits"
            r6.<init>(r7)
            throw r6
        L7d:
            java.lang.String r2 = ""
            java.lang.String r3 = r7.getURI(r0)
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L95
            java.lang.String r2 = "http://www.w3.org/1999/xlink"
            java.lang.String r3 = r7.getURI(r0)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto Lcf
        L95:
            r6.f3 = r1
            goto Lcf
        L98:
            mc.fb$w r1 = ap(r1)
            r6.i4 = r1
            boolean r1 = r1.c5()
            if (r1 != 0) goto La5
            goto Lcf
        La5:
            mc.i9 r6 = new mc.i9
            java.lang.String r7 = "Invalid <pattern> element. height cannot be negative"
            r6.<init>(r7)
            throw r6
        Lad:
            mc.fb$w r1 = ap(r1)
            r6.x4 = r1
            boolean r1 = r1.c5()
            if (r1 != 0) goto Lba
            goto Lcf
        Lba:
            mc.i9 r6 = new mc.i9
            java.lang.String r7 = "Invalid <pattern> element. width cannot be negative"
            r6.<init>(r7)
            throw r6
        Lc2:
            mc.fb$w r1 = ap(r1)
            r6.r = r1
            goto Lcf
        Lc9:
            mc.fb$w r1 = ap(r1)
            r6.z = r1
        Lcf:
            int r0 = r0 + 1
            goto L1
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.f.k5(mc.fb$n, org.xml.sax.Attributes):void");
    }

    public final void l(InputStream inputStream) throws i9 {
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            a aVar = new a(this, (y) null);
            xMLReader.setContentHandler(aVar);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", aVar);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e2) {
            throw new i9("Stream error", e2);
        } catch (ParserConfigurationException e3) {
            throw new i9("XML parser problem", e3);
        } catch (SAXException e5) {
            throw new i9("SVG parse error", e5);
        }
    }

    public final void le(Attributes attributes) throws i9 {
        t("<radialGradient>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.i9 j5Var = new fb.j5();
            j5Var.y = this.y;
            j5Var.f11457n3 = this.f11415n3;
            mg(j5Var, attributes);
            o(j5Var, attributes);
            d(j5Var, attributes);
            vl(j5Var, attributes);
            this.f11415n3.s(j5Var);
            this.f11415n3 = j5Var;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void mg(fb.b bVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qName = attributes.getQName(i);
            if (!qName.equals("id") && !qName.equals("xml:id")) {
                if (qName.equals("xml:space")) {
                    String trim = attributes.getValue(i).trim();
                    if ("default".equals(trim)) {
                        bVar.f11427gv = Boolean.FALSE;
                        return;
                    } else if ("preserve".equals(trim)) {
                        bVar.f11427gv = Boolean.TRUE;
                        return;
                    } else {
                        throw new i9("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                }
            } else {
                bVar.f11429zn = attributes.getValue(i).trim();
                return;
            }
        }
    }

    public final void mt(String str, Map<String, String> map) {
        if (str.equals("xml-stylesheet")) {
            fb.fb();
        }
    }

    public final void n(Attributes attributes) throws i9 {
        t("<mask>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.co coVar = new fb.co();
            coVar.y = this.y;
            coVar.f11457n3 = this.f11415n3;
            mg(coVar, attributes);
            o(coVar, attributes);
            rz(coVar, attributes);
            x(coVar, attributes);
            this.f11415n3.s(coVar);
            this.f11415n3 = coVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void nd(Attributes attributes) throws i9 {
        t("<textPath>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.en enVar = new fb.en();
            enVar.y = this.y;
            enVar.f11457n3 = this.f11415n3;
            mg(enVar, attributes);
            o(enVar, attributes);
            rz(enVar, attributes);
            oz(enVar, attributes);
            this.f11415n3.s(enVar);
            this.f11415n3 = enVar;
            fb.u uVar = enVar.f11457n3;
            if (uVar instanceof fb.u) {
                enVar.xc(uVar);
                return;
            } else {
                enVar.xc(((fb.k) uVar).v());
                return;
            }
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void ne(String str) throws i9 {
        if (this.f11418zn) {
            return;
        }
        if (this.f11417v) {
            if (this.f11413fb == null) {
                this.f11413fb = new StringBuilder(str.length());
            }
            this.f11413fb.append(str);
        } else if (this.f11416s) {
            if (this.f11412c5 == null) {
                this.f11412c5 = new StringBuilder(str.length());
            }
            this.f11412c5.append(str);
        } else if (this.f11415n3 instanceof fb.f7) {
            s(str);
        }
    }

    public final void o(fb.b bVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (trim.length() != 0) {
                int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
                if (i5 != 45) {
                    if (i5 != 46) {
                        if (bVar.f11428v == null) {
                            bVar.f11428v = new fb.ta();
                        }
                        mp(bVar.f11428v, attributes.getLocalName(i), attributes.getValue(i).trim());
                    } else {
                        bVar.f11426fb = n3.a(trim);
                    }
                } else {
                    xb(bVar, trim);
                }
            }
        }
    }

    public final void oz(fb.en enVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 6) {
                if (i5 == 39) {
                    enVar.w = ap(trim);
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                enVar.xc = trim;
            }
        }
    }

    public final void p(Attributes attributes) throws i9 {
        t("<g>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz tlVar = new fb.tl();
            tlVar.y = this.y;
            tlVar.f11457n3 = this.f11415n3;
            mg(tlVar, attributes);
            o(tlVar, attributes);
            q9(tlVar, attributes);
            rz(tlVar, attributes);
            this.f11415n3.s(tlVar);
            this.f11415n3 = tlVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void q(Attributes attributes) throws i9 {
        t("<text>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz q9Var = new fb.q9();
            q9Var.y = this.y;
            q9Var.f11457n3 = this.f11415n3;
            mg(q9Var, attributes);
            o(q9Var, attributes);
            q9(q9Var, attributes);
            rz(q9Var, attributes);
            ut(q9Var, attributes);
            this.f11415n3.s(q9Var);
            this.f11415n3 = q9Var;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void q5(Attributes attributes) throws i9 {
        t("<polyline>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz cVar = new fb.c();
            cVar.y = this.y;
            cVar.f11457n3 = this.f11415n3;
            mg(cVar, attributes);
            o(cVar, attributes);
            q9(cVar, attributes);
            rz(cVar, attributes);
            yt(cVar, attributes, "polyline");
            this.f11415n3.s(cVar);
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void q9(fb.wz wzVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (fb.y(attributes.getLocalName(i)) == fb.cs) {
                wzVar.f(qj(attributes.getValue(i)));
            }
        }
    }

    public final Matrix qj(String str) throws i9 {
        Matrix matrix = new Matrix();
        c5 c5Var = new c5(str);
        c5Var.d0();
        while (!c5Var.s()) {
            String xc2 = c5Var.xc();
            if (xc2 != null) {
                char c2 = 65535;
                switch (xc2.hashCode()) {
                    case -1081239615:
                        if (xc2.equals("matrix")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -925180581:
                        if (xc2.equals("rotate")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 109250890:
                        if (xc2.equals("scale")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 109493390:
                        if (xc2.equals("skewX")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 109493391:
                        if (xc2.equals("skewY")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (xc2.equals("translate")) {
                            c2 = 5;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        c5Var.d0();
                        float wz2 = c5Var.wz();
                        c5Var.c();
                        float wz3 = c5Var.wz();
                        c5Var.c();
                        float wz4 = c5Var.wz();
                        c5Var.c();
                        float wz5 = c5Var.wz();
                        c5Var.c();
                        float wz6 = c5Var.wz();
                        c5Var.c();
                        float wz7 = c5Var.wz();
                        c5Var.d0();
                        if (!Float.isNaN(wz7) && c5Var.a(')')) {
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(new float[]{wz2, wz4, wz6, wz3, wz5, wz7, 0.0f, 0.0f, 1.0f});
                            matrix.preConcat(matrix2);
                            break;
                        } else {
                            throw new i9("Invalid transform list: " + str);
                        }
                        break;
                    case 1:
                        c5Var.d0();
                        float wz8 = c5Var.wz();
                        float f32 = c5Var.f3();
                        float f33 = c5Var.f3();
                        c5Var.d0();
                        if (!Float.isNaN(wz8) && c5Var.a(')')) {
                            if (Float.isNaN(f32)) {
                                matrix.preRotate(wz8);
                                break;
                            } else if (!Float.isNaN(f33)) {
                                matrix.preRotate(wz8, f32, f33);
                                break;
                            } else {
                                throw new i9("Invalid transform list: " + str);
                            }
                        } else {
                            throw new i9("Invalid transform list: " + str);
                        }
                    case 2:
                        c5Var.d0();
                        float wz9 = c5Var.wz();
                        float f34 = c5Var.f3();
                        c5Var.d0();
                        if (!Float.isNaN(wz9) && c5Var.a(')')) {
                            if (Float.isNaN(f34)) {
                                matrix.preScale(wz9, wz9);
                                break;
                            } else {
                                matrix.preScale(wz9, f34);
                                break;
                            }
                        } else {
                            throw new i9("Invalid transform list: " + str);
                        }
                        break;
                    case 3:
                        c5Var.d0();
                        float wz10 = c5Var.wz();
                        c5Var.d0();
                        if (!Float.isNaN(wz10) && c5Var.a(')')) {
                            matrix.preSkew((float) Math.tan(Math.toRadians(wz10)), 0.0f);
                            break;
                        } else {
                            throw new i9("Invalid transform list: " + str);
                        }
                        break;
                    case 4:
                        c5Var.d0();
                        float wz11 = c5Var.wz();
                        c5Var.d0();
                        if (!Float.isNaN(wz11) && c5Var.a(')')) {
                            matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(wz11)));
                            break;
                        } else {
                            throw new i9("Invalid transform list: " + str);
                        }
                    case 5:
                        c5Var.d0();
                        float wz12 = c5Var.wz();
                        float f35 = c5Var.f3();
                        c5Var.d0();
                        if (!Float.isNaN(wz12) && c5Var.a(')')) {
                            if (Float.isNaN(f35)) {
                                matrix.preTranslate(wz12, 0.0f);
                                break;
                            } else {
                                matrix.preTranslate(wz12, f35);
                                break;
                            }
                        } else {
                            throw new i9("Invalid transform list: " + str);
                        }
                        break;
                    default:
                        throw new i9("Invalid transform list fn: " + xc2 + ")");
                }
                if (!c5Var.s()) {
                    c5Var.c();
                } else {
                    return matrix;
                }
            } else {
                throw new i9("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    public final void qn(fb.mg mgVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (y.n3[fb.y(attributes.getLocalName(i)).ordinal()] == 37) {
                mgVar.s = s8(trim);
            }
        }
    }

    public final void r(Attributes attributes) throws i9 {
        t("<image>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz xcVar = new fb.xc();
            xcVar.y = this.y;
            xcVar.f11457n3 = this.f11415n3;
            mg(xcVar, attributes);
            o(xcVar, attributes);
            q9(xcVar, attributes);
            rz(xcVar, attributes);
            z6(xcVar, attributes);
            this.f11415n3.s(xcVar);
            this.f11415n3 = xcVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void ro(Attributes attributes) throws i9 {
        t("<solidColor>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.rz rzVar = new fb.rz();
            rzVar.y = this.y;
            rzVar.f11457n3 = this.f11415n3;
            mg(rzVar, attributes);
            o(rzVar, attributes);
            this.f11415n3.s(rzVar);
            this.f11415n3 = rzVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void rz(fb.z6 z6Var, Attributes attributes) throws i9 {
        HashSet hashSet;
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (y.n3[fb.y(attributes.getLocalName(i)).ordinal()]) {
                case 21:
                    z6Var.a(tg(trim));
                    break;
                case 22:
                    z6Var.i9(trim);
                    break;
                case 23:
                    z6Var.fb(wf(trim));
                    break;
                case 24:
                    z6Var.c5(pz(trim));
                    break;
                case 25:
                    List<String> eb2 = eb(trim);
                    if (eb2 != null) {
                        hashSet = new HashSet(eb2);
                    } else {
                        hashSet = new HashSet(0);
                    }
                    z6Var.gv(hashSet);
                    break;
            }
        }
    }

    public final void s(String str) throws i9 {
        fb.yt ytVar;
        fb.ej ejVar = (fb.ej) this.f11415n3;
        int size = ejVar.f11435c5.size();
        if (size == 0) {
            ytVar = null;
        } else {
            ytVar = ejVar.f11435c5.get(size - 1);
        }
        if (ytVar instanceof fb.y5) {
            StringBuilder sb = new StringBuilder();
            fb.y5 y5Var = (fb.y5) ytVar;
            sb.append(y5Var.zn);
            sb.append(str);
            y5Var.zn = sb.toString();
            return;
        }
        this.f11415n3.s(new fb.y5(str));
    }

    public final Float s8(String str) throws i9 {
        if (str.length() != 0) {
            int length = str.length();
            boolean z2 = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z2 = false;
            }
            try {
                float o42 = o4(str, 0, length);
                float f4 = 100.0f;
                if (z2) {
                    o42 /= 100.0f;
                }
                if (o42 < 0.0f) {
                    f4 = 0.0f;
                } else if (o42 <= 100.0f) {
                    f4 = o42;
                }
                return Float.valueOf(f4);
            } catch (NumberFormatException e2) {
                throw new i9("Invalid offset value in <stop>: " + str, e2);
            }
        }
        throw new i9("Invalid offset value in <stop> (empty string)");
    }

    public final void ta(fb.c5 c5Var, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (y.n3[fb.y(attributes.getLocalName(i)).ordinal()]) {
                case 10:
                    fb.w ap2 = ap(trim);
                    c5Var.p = ap2;
                    if (ap2.c5()) {
                        throw new i9("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case 11:
                    fb.w ap3 = ap(trim);
                    c5Var.mt = ap3;
                    if (ap3.c5()) {
                        throw new i9("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case 12:
                    c5Var.xc = ap(trim);
                    break;
                case 13:
                    c5Var.w = ap(trim);
                    break;
            }
        }
    }

    public final void tl(Attributes attributes) throws i9 {
        t("<defs>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz sVar = new fb.s();
            sVar.y = this.y;
            sVar.f11457n3 = this.f11415n3;
            mg(sVar, attributes);
            o(sVar, attributes);
            q9(sVar, attributes);
            this.f11415n3.s(sVar);
            this.f11415n3 = sVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void ud(fb.k5 k5Var, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (y.n3[fb.y(attributes.getLocalName(i)).ordinal()]) {
                case 15:
                    k5Var.tl = ap(trim);
                    break;
                case 16:
                    k5Var.wz = ap(trim);
                    break;
                case 17:
                    k5Var.xc = ap(trim);
                    break;
                case 18:
                    k5Var.w = ap(trim);
                    break;
            }
        }
    }

    public final void uo(Attributes attributes) throws i9 {
        t("<switch>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz oVar = new fb.o();
            oVar.y = this.y;
            oVar.f11457n3 = this.f11415n3;
            mg(oVar, attributes);
            o(oVar, attributes);
            q9(oVar, attributes);
            rz(oVar, attributes);
            this.f11415n3.s(oVar);
            this.f11415n3 = oVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void ut(fb.jz jzVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 19) {
                        if (i5 == 20) {
                            jzVar.mt = yg(trim);
                        }
                    } else {
                        jzVar.p = yg(trim);
                    }
                } else {
                    jzVar.w = yg(trim);
                }
            } else {
                jzVar.xc = yg(trim);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void vl(mc.fb.j5 r5, org.xml.sax.Attributes r6) throws mc.i9 {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L5e
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = mc.f.y.n3
            java.lang.String r3 = r6.getLocalName(r0)
            mc.f$fb r3 = mc.f.fb.y(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 35
            if (r2 == r3) goto L55
            r3 = 36
            if (r2 == r3) goto L4e
            switch(r2) {
                case 12: goto L47;
                case 13: goto L40;
                case 14: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L5b
        L2b:
            mc.fb$w r1 = ap(r1)
            r5.xc = r1
            boolean r1 = r1.c5()
            if (r1 != 0) goto L38
            goto L5b
        L38:
            mc.i9 r5 = new mc.i9
            java.lang.String r6 = "Invalid <radialGradient> element. r cannot be negative"
            r5.<init>(r6)
            throw r5
        L40:
            mc.fb$w r1 = ap(r1)
            r5.wz = r1
            goto L5b
        L47:
            mc.fb$w r1 = ap(r1)
            r5.tl = r1
            goto L5b
        L4e:
            mc.fb$w r1 = ap(r1)
            r5.p = r1
            goto L5b
        L55:
            mc.fb$w r1 = ap(r1)
            r5.w = r1
        L5b:
            int r0 = r0 + 1
            goto L1
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.f.vl(mc.fb$j5, org.xml.sax.Attributes):void");
    }

    public final void vn(Attributes attributes) throws i9 {
        t("<svg>", new Object[0]);
        fb.d dVar = new fb.d();
        dVar.y = this.y;
        dVar.f11457n3 = this.f11415n3;
        mg(dVar, attributes);
        o(dVar, attributes);
        rz(dVar, attributes);
        f7(dVar, attributes);
        j5(dVar, attributes);
        fb.a8 a8Var = this.f11415n3;
        if (a8Var == null) {
            this.y.w(dVar);
        } else {
            a8Var.s(dVar);
        }
        this.f11415n3 = dVar;
    }

    public final void w(String str, String str2, String str3) throws i9 {
        if (this.f11418zn) {
            int i = this.f11414gv - 1;
            this.f11414gv = i;
            if (i == 0) {
                this.f11418zn = false;
                return;
            }
        }
        if (!"http://www.w3.org/2000/svg".equals(str) && !"".equals(str)) {
            return;
        }
        if (str2.length() <= 0) {
            str2 = str3;
        }
        int i5 = y.y[s.y(str2).ordinal()];
        if (i5 != 1 && i5 != 2 && i5 != 4 && i5 != 5 && i5 != 13 && i5 != 14) {
            switch (i5) {
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 31:
                    break;
                case 22:
                case 23:
                    this.f11417v = false;
                    StringBuilder sb = this.f11413fb;
                    if (sb != null) {
                        s sVar = this.f11411a;
                        if (sVar == s.q9) {
                            this.y.p(sb.toString());
                        } else if (sVar == s.t) {
                            this.y.xc(sb.toString());
                        }
                        this.f11413fb.setLength(0);
                        return;
                    }
                    return;
                case 30:
                    StringBuilder sb2 = this.f11412c5;
                    if (sb2 != null) {
                        this.f11416s = false;
                        en(sb2.toString());
                        this.f11412c5.setLength(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        this.f11415n3 = ((fb.yt) this.f11415n3).f11457n3;
    }

    public final void w2(Attributes attributes) throws i9 {
        t("<pattern>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.qn nVar = new fb.n();
            nVar.y = this.y;
            nVar.f11457n3 = this.f11415n3;
            mg(nVar, attributes);
            o(nVar, attributes);
            rz(nVar, attributes);
            f7(nVar, attributes);
            k5(nVar, attributes);
            this.f11415n3.s(nVar);
            this.f11415n3 = nVar;
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void w9(Attributes attributes) throws i9 {
        t("<path>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz x4Var = new fb.x4();
            x4Var.y = this.y;
            x4Var.f11457n3 = this.f11415n3;
            mg(x4Var, attributes);
            o(x4Var, attributes);
            q9(x4Var, attributes);
            rz(x4Var, attributes);
            b(x4Var, attributes);
            this.f11415n3.s(x4Var);
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void wm(char[] cArr, int i, int i5) throws i9 {
        if (this.f11418zn) {
            return;
        }
        if (this.f11417v) {
            if (this.f11413fb == null) {
                this.f11413fb = new StringBuilder(i5);
            }
            this.f11413fb.append(cArr, i, i5);
        } else if (this.f11416s) {
            if (this.f11412c5 == null) {
                this.f11412c5 = new StringBuilder(i5);
            }
            this.f11412c5.append(cArr, i, i5);
        } else if (this.f11415n3 instanceof fb.f7) {
            s(new String(cArr, i, i5));
        }
    }

    public final void wz(Attributes attributes) throws i9 {
        t("<ellipse>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz c5Var = new fb.c5();
            c5Var.y = this.y;
            c5Var.f11457n3 = this.f11415n3;
            mg(c5Var, attributes);
            o(c5Var, attributes);
            q9(c5Var, attributes);
            rz(c5Var, attributes);
            ta(c5Var, attributes);
            this.f11415n3.s(c5Var);
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void x(fb.co coVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 != 43) {
                                if (i5 != 44) {
                                    continue;
                                } else if ("objectBoundingBox".equals(trim)) {
                                    coVar.w = Boolean.FALSE;
                                } else if ("userSpaceOnUse".equals(trim)) {
                                    coVar.w = Boolean.TRUE;
                                } else {
                                    throw new i9("Invalid value for attribute maskContentUnits");
                                }
                            } else if ("objectBoundingBox".equals(trim)) {
                                coVar.xc = Boolean.FALSE;
                            } else if ("userSpaceOnUse".equals(trim)) {
                                coVar.xc = Boolean.TRUE;
                            } else {
                                throw new i9("Invalid value for attribute maskUnits");
                            }
                        } else {
                            fb.w ap2 = ap(trim);
                            coVar.z = ap2;
                            if (ap2.c5()) {
                                throw new i9("Invalid <mask> element. height cannot be negative");
                            }
                        }
                    } else {
                        fb.w ap3 = ap(trim);
                        coVar.co = ap3;
                        if (ap3.c5()) {
                            throw new i9("Invalid <mask> element. width cannot be negative");
                        }
                    }
                } else {
                    coVar.mt = ap(trim);
                }
            } else {
                coVar.p = ap(trim);
            }
        }
    }

    public final void x4(Attributes attributes) throws i9 {
        t("<line>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz pVar = new fb.p();
            pVar.y = this.y;
            pVar.f11457n3 = this.f11415n3;
            mg(pVar, attributes);
            o(pVar, attributes);
            q9(pVar, attributes);
            rz(pVar, attributes);
            ej(pVar, attributes);
            this.f11415n3.s(pVar);
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void x5(Attributes attributes) throws i9 {
        t("<polygon>", new Object[0]);
        if (this.f11415n3 != null) {
            fb.wz d0Var = new fb.d0();
            d0Var.y = this.y;
            d0Var.f11457n3 = this.f11415n3;
            mg(d0Var, attributes);
            o(d0Var, attributes);
            q9(d0Var, attributes);
            rz(d0Var, attributes);
            yt(d0Var, attributes, "polygon");
            this.f11415n3.s(d0Var);
            return;
        }
        throw new i9("Invalid document. Root element must be <svg>");
    }

    public final void yk(String str, String str2, String str3, Attributes attributes) throws i9 {
        if (this.f11418zn) {
            this.f11414gv++;
        } else if (!"http://www.w3.org/2000/svg".equals(str) && !"".equals(str)) {
        } else {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            s y = s.y(str2);
            switch (y.y[y.ordinal()]) {
                case 1:
                    vn(attributes);
                    return;
                case 2:
                case 3:
                    p(attributes);
                    return;
                case 4:
                    tl(attributes);
                    return;
                case 5:
                    fc(attributes);
                    return;
                case 6:
                    w9(attributes);
                    return;
                case 7:
                    cs(attributes);
                    return;
                case 8:
                    c5(attributes);
                    return;
                case 9:
                    wz(attributes);
                    return;
                case 10:
                    x4(attributes);
                    return;
                case 11:
                    q5(attributes);
                    return;
                case 12:
                    x5(attributes);
                    return;
                case 13:
                    q(attributes);
                    return;
                case 14:
                    bv(attributes);
                    return;
                case 15:
                    gf(attributes);
                    return;
                case 16:
                    uo(attributes);
                    return;
                case 17:
                    j3(attributes);
                    return;
                case 18:
                    f3(attributes);
                    return;
                case 19:
                    i4(attributes);
                    return;
                case 20:
                    le(attributes);
                    return;
                case 21:
                    i2(attributes);
                    return;
                case 22:
                case 23:
                    this.f11417v = true;
                    this.f11411a = y;
                    return;
                case 24:
                    f(attributes);
                    return;
                case 25:
                    nd(attributes);
                    return;
                case 26:
                    w2(attributes);
                    return;
                case 27:
                    r(attributes);
                    return;
                case 28:
                    br(attributes);
                    return;
                case 29:
                    n(attributes);
                    return;
                case 30:
                    i3(attributes);
                    return;
                case 31:
                    ro(attributes);
                    return;
                default:
                    this.f11418zn = true;
                    this.f11414gv = 1;
                    return;
            }
        }
    }

    public final void yt(fb.c cVar, Attributes attributes, String str) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (fb.y(attributes.getLocalName(i)) == fb.kp) {
                c5 c5Var = new c5(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList();
                c5Var.d0();
                while (!c5Var.s()) {
                    float wz2 = c5Var.wz();
                    if (!Float.isNaN(wz2)) {
                        c5Var.c();
                        float wz3 = c5Var.wz();
                        if (!Float.isNaN(wz3)) {
                            c5Var.c();
                            arrayList.add(Float.valueOf(wz2));
                            arrayList.add(Float.valueOf(wz3));
                        } else {
                            throw new i9("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new i9("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                cVar.xc = new float[arrayList.size()];
                int i5 = 0;
                for (Float f4 : arrayList) {
                    cVar.xc[i5] = f4.floatValue();
                    i5++;
                }
            }
        }
    }

    public final void z6(fb.xc xcVar, Attributes attributes) throws i9 {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            int i5 = y.n3[fb.y(attributes.getLocalName(i)).ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 != 6) {
                                if (i5 == 7) {
                                    u0(xcVar, trim);
                                }
                            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                                xcVar.w = trim;
                            }
                        } else {
                            fb.w ap2 = ap(trim);
                            xcVar.z = ap2;
                            if (ap2.c5()) {
                                throw new i9("Invalid <use> element. height cannot be negative");
                            }
                        }
                    } else {
                        fb.w ap3 = ap(trim);
                        xcVar.co = ap3;
                        if (ap3.c5()) {
                            throw new i9("Invalid <use> element. width cannot be negative");
                        }
                    }
                } else {
                    xcVar.mt = ap(trim);
                }
            } else {
                xcVar.p = ap(trim);
            }
        }
    }

    public final void xc() {
    }

    public final void t(String str, Object... objArr) {
    }
}
