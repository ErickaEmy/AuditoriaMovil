package ft;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import ft.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import qh.n3;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: gv  reason: collision with root package name */
    public static final Map<String, Integer> f8224gv;

    /* renamed from: zn  reason: collision with root package name */
    public static final Map<String, Integer> f8226zn;
    public static final Pattern y = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: n3  reason: collision with root package name */
    public static final Pattern f8225n3 = Pattern.compile("(\\S+?):(\\S+)");

    /* loaded from: classes.dex */
    public static final class gv implements Comparable<gv> {

        /* renamed from: v  reason: collision with root package name */
        public final ft.gv f8227v;
        public final int y;

        public gv(int i, ft.gv gvVar) {
            this.y = i;
            this.f8227v = gvVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(gv gvVar) {
            return Integer.compare(this.y, gvVar.y);
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: zn  reason: collision with root package name */
        public static final Comparator<n3> f8228zn = new Comparator() { // from class: ft.fb
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int v2;
                v2 = a.n3.v((a.n3) obj, (a.n3) obj2);
                return v2;
            }
        };

        /* renamed from: n3  reason: collision with root package name */
        public final int f8229n3;
        public final zn y;

        public static /* synthetic */ int v(n3 n3Var, n3 n3Var2) {
            return Integer.compare(n3Var.y.f8241n3, n3Var2.y.f8241n3);
        }

        public n3(zn znVar, int i) {
            this.y = znVar;
            this.f8229n3 = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: fb  reason: collision with root package name */
        public int f8233fb;

        /* renamed from: n3  reason: collision with root package name */
        public long f8236n3;
        public long y;

        /* renamed from: zn  reason: collision with root package name */
        public CharSequence f8239zn;

        /* renamed from: gv  reason: collision with root package name */
        public int f8234gv = 2;

        /* renamed from: v  reason: collision with root package name */
        public float f8238v = -3.4028235E38f;

        /* renamed from: a  reason: collision with root package name */
        public int f8230a = 1;

        /* renamed from: s  reason: collision with root package name */
        public float f8237s = -3.4028235E38f;

        /* renamed from: c5  reason: collision with root package name */
        public int f8231c5 = Integer.MIN_VALUE;

        /* renamed from: i9  reason: collision with root package name */
        public float f8235i9 = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public int f8232f = Integer.MIN_VALUE;

        public static int a(int i) {
            if (i != 1) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return 1;
                        }
                        return 2;
                    }
                    return 0;
                }
                return 2;
            }
            return 0;
        }

        public static float gv(int i, float f4) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return f4;
                    }
                    throw new IllegalStateException(String.valueOf(i));
                } else if (f4 <= 0.5f) {
                    return f4 * 2.0f;
                } else {
                    return (1.0f - f4) * 2.0f;
                }
            }
            return 1.0f - f4;
        }

        public static float n3(float f4, int i) {
            int i5 = (f4 > (-3.4028235E38f) ? 1 : (f4 == (-3.4028235E38f) ? 0 : -1));
            if (i5 != 0 && i == 0 && (f4 < 0.0f || f4 > 1.0f)) {
                return 1.0f;
            }
            if (i5 != 0) {
                return f4;
            }
            if (i == 0) {
                return 1.0f;
            }
            return -3.4028235E38f;
        }

        public static float v(int i) {
            if (i != 4) {
                if (i != 5) {
                    return 0.5f;
                }
                return 1.0f;
            }
            return 0.0f;
        }

        @Nullable
        public static Layout.Alignment zn(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                r.c5("WebvttCueParser", "Unknown textAlignment: " + i);
                                return null;
                            }
                        }
                    }
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        public n3.C0187n3 fb() {
            float f4 = this.f8237s;
            if (f4 == -3.4028235E38f) {
                f4 = v(this.f8234gv);
            }
            int i = this.f8231c5;
            if (i == Integer.MIN_VALUE) {
                i = a(this.f8234gv);
            }
            n3.C0187n3 mt2 = new n3.C0187n3().w(zn(this.f8234gv)).s(n3(this.f8238v, this.f8230a), this.f8230a).c5(this.f8233fb).f(f4).t(i).wz(Math.min(this.f8235i9, gv(i, f4))).mt(this.f8232f);
            CharSequence charSequence = this.f8239zn;
            if (charSequence != null) {
                mt2.xc(charSequence);
            }
            return mt2;
        }

        public ft.v y() {
            return new ft.v(fb().y(), this.y, this.f8236n3);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final Set<String> f8240gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f8241n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f8242zn;

        public zn(String str, int i, String str2, Set<String> set) {
            this.f8241n3 = i;
            this.y = str;
            this.f8242zn = str2;
            this.f8240gv = set;
        }

        public static zn n3() {
            return new zn("", 0, "", Collections.emptySet());
        }

        public static zn y(String str, int i) {
            String str2;
            String trim = str.trim();
            v5.y.y(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] ro2 = j5.ro(trim, "\\.");
            String str3 = ro2[0];
            HashSet hashSet = new HashSet();
            for (int i5 = 1; i5 < ro2.length; i5++) {
                hashSet.add(ro2[i5]);
            }
            return new zn(str3, i, str2, hashSet);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f8226zn = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f8224gv = Collections.unmodifiableMap(hashMap2);
    }

    public static int a(String str, int i) {
        int indexOf = str.indexOf(62, i);
        if (indexOf == -1) {
            return str.length();
        }
        return indexOf + 1;
    }

    public static int c5(List<ft.gv> list, @Nullable String str, zn znVar) {
        List<gv> s2 = s(list, str, znVar);
        for (int i = 0; i < s2.size(); i++) {
            ft.gv gvVar = s2.get(i).f8227v;
            if (gvVar.fb() != -1) {
                return gvVar.fb();
            }
        }
        return -1;
    }

    public static void co(String str, v vVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            vVar.f8233fb = mt(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            vVar.f8238v = c5.zn(str);
            vVar.f8230a = 0;
            return;
        }
        vVar.f8238v = Integer.parseInt(str);
        vVar.f8230a = 1;
    }

    public static boolean f(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c2 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c2 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c2 = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    c2 = 3;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3650:
                if (str.equals("rt")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str.equals("ruby")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public static int fb(int i, int i5, int i6) {
        if (i != -1) {
            return i;
        }
        if (i5 != -1) {
            return i5;
        }
        if (i6 != -1) {
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public static void gv(@Nullable String str, zn znVar, List<n3> list, SpannableStringBuilder spannableStringBuilder, List<ft.gv> list2) {
        int i = znVar.f8241n3;
        int length = spannableStringBuilder.length();
        String str2 = znVar.y;
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c2 = 0;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    c2 = 1;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    c2 = 2;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    c2 = 3;
                    break;
                }
                break;
            case 117:
                if (str2.equals("u")) {
                    c2 = 4;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 2:
                y(spannableStringBuilder, znVar.f8240gv, i, length);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 7:
                zn(spannableStringBuilder, str, znVar, list, list2);
                break;
            default:
                return;
        }
        List<gv> s2 = s(list2, str, znVar);
        for (int i5 = 0; i5 < s2.size(); i5++) {
            v(spannableStringBuilder, s2.get(i5).f8227v, i, length);
        }
    }

    public static int i4(String str) {
        str.hashCode();
        if (!str.equals("lr")) {
            if (!str.equals("rl")) {
                r.c5("WebvttCueParser", "Invalid 'vertical' value: " + str);
                return Integer.MIN_VALUE;
            }
            return 1;
        }
        return 2;
    }

    public static String i9(String str) {
        String trim = str.trim();
        v5.y.y(!trim.isEmpty());
        return j5.ix(trim, "[ \\.]")[0];
    }

    public static int mt(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                r.c5("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void n3(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    c2 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                spannableStringBuilder.append('>');
                return;
            case 1:
                spannableStringBuilder.append('<');
                return;
            case 2:
                spannableStringBuilder.append('&');
                return;
            case 3:
                spannableStringBuilder.append(' ');
                return;
            default:
                r.c5("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    public static SpannedString p(@Nullable String str, String str2, List<ft.gv> list) {
        boolean z2;
        boolean z3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            if (charAt != '&') {
                if (charAt != '<') {
                    spannableStringBuilder.append(charAt);
                    i++;
                } else {
                    int i5 = i + 1;
                    if (i5 < str2.length()) {
                        int i6 = 1;
                        if (str2.charAt(i5) == '/') {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        i5 = a(str2, i5);
                        int i8 = i5 - 2;
                        if (str2.charAt(i8) == '/') {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2) {
                            i6 = 2;
                        }
                        int i10 = i + i6;
                        if (!z3) {
                            i8 = i5 - 1;
                        }
                        String substring = str2.substring(i10, i8);
                        if (!substring.trim().isEmpty()) {
                            String i92 = i9(substring);
                            if (f(i92)) {
                                if (z2) {
                                    while (!arrayDeque.isEmpty()) {
                                        zn znVar = (zn) arrayDeque.pop();
                                        gv(str, znVar, arrayList, spannableStringBuilder, list);
                                        if (!arrayDeque.isEmpty()) {
                                            arrayList.add(new n3(znVar, spannableStringBuilder.length()));
                                        } else {
                                            arrayList.clear();
                                        }
                                        if (znVar.y.equals(i92)) {
                                            break;
                                        }
                                    }
                                } else if (!z3) {
                                    arrayDeque.push(zn.y(substring, spannableStringBuilder.length()));
                                }
                            }
                        }
                    }
                    i = i5;
                }
            } else {
                i++;
                int indexOf = str2.indexOf(59, i);
                int indexOf2 = str2.indexOf(32, i);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    n3(str2.substring(i, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            }
        }
        while (!arrayDeque.isEmpty()) {
            gv(str, (zn) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        gv(str, zn.n3(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static void r(String str, v vVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            vVar.f8231c5 = z(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        vVar.f8237s = c5.zn(str);
    }

    public static List<gv> s(List<ft.gv> list, @Nullable String str, zn znVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ft.gv gvVar = list.get(i);
            int s2 = gvVar.s(str, znVar.y, znVar.f8240gv, znVar.f8242zn);
            if (s2 > 0) {
                arrayList.add(new gv(s2, gvVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static qh.n3 t(CharSequence charSequence) {
        v vVar = new v();
        vVar.f8239zn = charSequence;
        return vVar.fb().y();
    }

    @Nullable
    public static ft.v tl(@Nullable String str, Matcher matcher, rz rzVar, List<ft.gv> list) {
        v vVar = new v();
        try {
            vVar.y = c5.gv((String) v5.y.v(matcher.group(1)));
            vVar.f8236n3 = c5.gv((String) v5.y.v(matcher.group(2)));
            w((String) v5.y.v(matcher.group(3)), vVar);
            StringBuilder sb = new StringBuilder();
            String co2 = rzVar.co();
            while (!TextUtils.isEmpty(co2)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(co2.trim());
                co2 = rzVar.co();
            }
            vVar.f8239zn = p(str, sb.toString(), list);
            return vVar.y();
        } catch (NumberFormatException unused) {
            r.c5("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    public static void v(SpannableStringBuilder spannableStringBuilder, ft.gv gvVar, int i, int i5) {
        if (gvVar == null) {
            return;
        }
        if (gvVar.c5() != -1) {
            xp.gv.y(spannableStringBuilder, new StyleSpan(gvVar.c5()), i, i5, 33);
        }
        if (gvVar.t()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i5, 33);
        }
        if (gvVar.tl()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i5, 33);
        }
        if (gvVar.f()) {
            xp.gv.y(spannableStringBuilder, new ForegroundColorSpan(gvVar.zn()), i, i5, 33);
        }
        if (gvVar.i9()) {
            xp.gv.y(spannableStringBuilder, new BackgroundColorSpan(gvVar.y()), i, i5, 33);
        }
        if (gvVar.gv() != null) {
            xp.gv.y(spannableStringBuilder, new TypefaceSpan(gvVar.gv()), i, i5, 33);
        }
        int a2 = gvVar.a();
        if (a2 != 1) {
            if (a2 != 2) {
                if (a2 == 3) {
                    xp.gv.y(spannableStringBuilder, new RelativeSizeSpan(gvVar.v() / 100.0f), i, i5, 33);
                }
            } else {
                xp.gv.y(spannableStringBuilder, new RelativeSizeSpan(gvVar.v()), i, i5, 33);
            }
        } else {
            xp.gv.y(spannableStringBuilder, new AbsoluteSizeSpan((int) gvVar.v(), true), i, i5, 33);
        }
        if (gvVar.n3()) {
            spannableStringBuilder.setSpan(new xp.y(), i, i5, 33);
        }
    }

    public static void w(String str, v vVar) {
        Matcher matcher = f8225n3.matcher(str);
        while (matcher.find()) {
            String str2 = (String) v5.y.v(matcher.group(1));
            String str3 = (String) v5.y.v(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    co(str3, vVar);
                } else if ("align".equals(str2)) {
                    vVar.f8234gv = x4(str3);
                } else if ("position".equals(str2)) {
                    r(str3, vVar);
                } else if ("size".equals(str2)) {
                    vVar.f8235i9 = c5.zn(str3);
                } else if ("vertical".equals(str2)) {
                    vVar.f8232f = i4(str3);
                } else {
                    r.c5("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                r.c5("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    @Nullable
    public static ft.v wz(rz rzVar, List<ft.gv> list) {
        String co2 = rzVar.co();
        if (co2 == null) {
            return null;
        }
        Pattern pattern = y;
        Matcher matcher = pattern.matcher(co2);
        if (matcher.matches()) {
            return tl(null, matcher, rzVar, list);
        }
        String co3 = rzVar.co();
        if (co3 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(co3);
        if (!matcher2.matches()) {
            return null;
        }
        return tl(co2.trim(), matcher2, rzVar, list);
    }

    public static int x4(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c2 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c2 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                r.c5("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    public static n3.C0187n3 xc(String str) {
        v vVar = new v();
        w(str, vVar);
        return vVar.fb();
    }

    public static void y(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i, int i5) {
        for (String str : set) {
            Map<String, Integer> map = f8226zn;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str).intValue()), i, i5, 33);
            } else {
                Map<String, Integer> map2 = f8224gv;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(str).intValue()), i, i5, 33);
                }
            }
        }
    }

    public static int z(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1842484672:
                if (str.equals("line-left")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1276788989:
                if (str.equals("line-right")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 5:
                return 0;
            case 1:
            case 3:
                return 1;
            case 2:
            case 4:
                return 2;
            default:
                r.c5("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void zn(SpannableStringBuilder spannableStringBuilder, @Nullable String str, zn znVar, List<n3> list, List<ft.gv> list2) {
        int c52 = c5(list2, str, znVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, n3.f8228zn);
        int i = znVar.f8241n3;
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            if ("rt".equals(((n3) arrayList.get(i6)).y.y)) {
                n3 n3Var = (n3) arrayList.get(i6);
                int fb2 = fb(c5(list2, str, n3Var.y), c52, 1);
                int i8 = n3Var.y.f8241n3 - i5;
                int i10 = n3Var.f8229n3 - i5;
                CharSequence subSequence = spannableStringBuilder.subSequence(i8, i10);
                spannableStringBuilder.delete(i8, i10);
                spannableStringBuilder.setSpan(new xp.zn(subSequence.toString(), fb2), i, i8, 33);
                i5 += subSequence.length();
                i = i8;
            }
        }
    }
}
