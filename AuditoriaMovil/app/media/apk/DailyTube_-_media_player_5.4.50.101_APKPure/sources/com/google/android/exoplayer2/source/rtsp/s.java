package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.v;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m1.ne;
import r4.r;
import v5.j5;
import w0.co;
import z0.en;
import z0.i4;
import z0.x4;
/* loaded from: classes.dex */
public final class s {
    public static final Pattern y = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");

    /* renamed from: n3  reason: collision with root package name */
    public static final Pattern f4646n3 = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");

    /* renamed from: zn  reason: collision with root package name */
    public static final Pattern f4649zn = Pattern.compile("Content-Length:\\s?(\\d+)", 2);

    /* renamed from: gv  reason: collision with root package name */
    public static final Pattern f4645gv = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");

    /* renamed from: v  reason: collision with root package name */
    public static final Pattern f4648v = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f4643a = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");

    /* renamed from: fb  reason: collision with root package name */
    public static final String f4644fb = new String(new byte[]{10});

    /* renamed from: s  reason: collision with root package name */
    public static final String f4647s = new String(new byte[]{13, 10});

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final long f4650n3;
        public final String y;

        public n3(String str, long j2) {
            this.y = str;
            this.f4650n3 = j2;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final String f4651n3;
        public final String y;

        public y(String str, String str2) {
            this.y = str;
            this.f4651n3 = str2;
        }
    }

    public static boolean a(String str) {
        if (!y.matcher(str).matches() && !f4646n3.matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static int c5(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1881579439:
                if (str.equals("RECORD")) {
                    c2 = 0;
                    break;
                }
                break;
            case -880847356:
                if (str.equals("TEARDOWN")) {
                    c2 = 1;
                    break;
                }
                break;
            case -702888512:
                if (str.equals("GET_PARAMETER")) {
                    c2 = 2;
                    break;
                }
                break;
            case -531492226:
                if (str.equals("OPTIONS")) {
                    c2 = 3;
                    break;
                }
                break;
            case -84360524:
                if (str.equals("PLAY_NOTIFY")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2458420:
                if (str.equals("PLAY")) {
                    c2 = 5;
                    break;
                }
                break;
            case 6481884:
                if (str.equals("REDIRECT")) {
                    c2 = 6;
                    break;
                }
                break;
            case 71242700:
                if (str.equals("SET_PARAMETER")) {
                    c2 = 7;
                    break;
                }
                break;
            case 75902422:
                if (str.equals("PAUSE")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 78791261:
                if (str.equals("SETUP")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 133006441:
                if (str.equals("ANNOUNCE")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1800840907:
                if (str.equals("DESCRIBE")) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 8;
            case 1:
                return 12;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 11;
            case '\b':
                return 5;
            case '\t':
                return 10;
            case '\n':
                return 1;
            case 11:
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static String[] co(String str) {
        String str2 = f4647s;
        if (!str.contains(str2)) {
            str2 = f4644fb;
        }
        return j5.ro(str, str2);
    }

    public static r f(List<String> list) {
        boolean z2 = false;
        Matcher matcher = y.matcher(list.get(0));
        v5.y.y(matcher.matches());
        int c52 = c5((String) v5.y.v(matcher.group(1)));
        Uri parse = Uri.parse((String) v5.y.v(matcher.group(2)));
        int indexOf = list.indexOf("");
        if (indexOf > 0) {
            z2 = true;
        }
        v5.y.y(z2);
        return new r(parse, c52, new v.n3().zn(list.subList(1, indexOf)).v(), w0.s.fb(f4647s).gv(list.subList(indexOf + 1, list.size())));
    }

    public static long fb(String str) throws ne {
        try {
            Matcher matcher = f4649zn.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) v5.y.v(matcher.group(1)));
            }
            return -1L;
        } catch (NumberFormatException e2) {
            throw ne.v(str, e2);
        }
    }

    public static byte[] gv(String str) {
        return str.getBytes(fb.f4592w);
    }

    public static x4<Integer> i9(@Nullable String str) {
        if (str == null) {
            return x4.j5();
        }
        x4.y yVar = new x4.y();
        for (String str2 : j5.ro(str, ",\\s?")) {
            yVar.y(Integer.valueOf(c5(str2)));
        }
        return yVar.s();
    }

    public static x4<String> mt(r4.x4 x4Var) {
        boolean z2;
        if (x4Var.f13120n3.gv("CSeq") != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        x4.y yVar = new x4.y();
        yVar.y(j5.rz("%s %s %s", "RTSP/1.0", Integer.valueOf(x4Var.y), zn(x4Var.y)));
        i4<String, String> n32 = x4Var.f13120n3.n3();
        en it = n32.k5().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            x4 j2 = n32.j(str);
            for (int i = 0; i < j2.size(); i++) {
                yVar.y(j5.rz("%s: %s", str, j2.get(i)));
            }
        }
        yVar.y("");
        yVar.y(x4Var.f13121zn);
        return yVar.s();
    }

    public static byte[] n3(List<String> list) {
        return w0.s.fb(f4647s).gv(list).getBytes(fb.f4592w);
    }

    public static x4<String> p(r rVar) {
        boolean z2;
        if (rVar.f13097zn.gv("CSeq") != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        x4.y yVar = new x4.y();
        yVar.y(j5.rz("%s %s %s", z(rVar.f13096n3), rVar.y, "RTSP/1.0"));
        i4<String, String> n32 = rVar.f13097zn.n3();
        en it = n32.k5().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            x4 j2 = n32.j(str);
            for (int i = 0; i < j2.size(); i++) {
                yVar.y(j5.rz("%s: %s", str, j2.get(i)));
            }
        }
        yVar.y("");
        yVar.y(rVar.f13095gv);
        return yVar.s();
    }

    public static int s(String str) throws ne {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            throw ne.v(str, e2);
        }
    }

    public static r4.x4 t(List<String> list) {
        boolean z2 = false;
        Matcher matcher = f4646n3.matcher(list.get(0));
        v5.y.y(matcher.matches());
        int parseInt = Integer.parseInt((String) v5.y.v(matcher.group(1)));
        int indexOf = list.indexOf("");
        if (indexOf > 0) {
            z2 = true;
        }
        v5.y.y(z2);
        return new r4.x4(parseInt, new v.n3().zn(list.subList(1, indexOf)).v(), w0.s.fb(f4647s).gv(list.subList(indexOf + 1, list.size())));
    }

    public static n3 tl(String str) throws ne {
        long parseInt;
        Matcher matcher = f4645gv.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) v5.y.v(matcher.group(1));
            String group = matcher.group(2);
            if (group != null) {
                try {
                    parseInt = Integer.parseInt(group) * 1000;
                } catch (NumberFormatException e2) {
                    throw ne.v(str, e2);
                }
            } else {
                parseInt = 60000;
            }
            return new n3(str2, parseInt);
        }
        throw ne.v(str, null);
    }

    public static boolean v(List<String> list) {
        return f4646n3.matcher(list.get(0)).matches();
    }

    public static Uri w(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) v5.y.v(uri.getAuthority());
        v5.y.y(str.contains("@"));
        return uri.buildUpon().encodedAuthority(j5.ro(str, "@")[1]).build();
    }

    @Nullable
    public static y wz(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(":")) {
            return null;
        }
        String[] ix2 = j5.ix(userInfo, ":");
        return new y(ix2[0], ix2[1]);
    }

    public static zn xc(String str) throws ne {
        Matcher matcher = f4648v.matcher(str);
        if (matcher.find()) {
            return new zn(2, (String) v5.y.v(matcher.group(1)), (String) v5.y.v(matcher.group(3)), co.gv(matcher.group(4)));
        }
        Matcher matcher2 = f4643a.matcher(str);
        if (matcher2.matches()) {
            return new zn(1, (String) v5.y.v(matcher2.group(1)), "", "");
        }
        throw ne.v("Invalid WWW-Authenticate header " + str, null);
    }

    public static void y(boolean z2, @Nullable String str) throws ne {
        if (z2) {
            return;
        }
        throw ne.v(str, null);
    }

    public static String z(int i) {
        switch (i) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return "REDIRECT";
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                throw new IllegalStateException();
        }
    }

    public static String zn(int i) {
        if (i != 200) {
            if (i != 461) {
                if (i != 500) {
                    if (i != 505) {
                        if (i != 301) {
                            if (i != 302) {
                                if (i != 400) {
                                    if (i != 401) {
                                        if (i != 404) {
                                            if (i != 405) {
                                                switch (i) {
                                                    case 454:
                                                        return "Session Not Found";
                                                    case 455:
                                                        return "Method Not Valid In This State";
                                                    case 456:
                                                        return "Header Field Not Valid";
                                                    case 457:
                                                        return "Invalid Range";
                                                    default:
                                                        throw new IllegalArgumentException();
                                                }
                                            }
                                            return "Method Not Allowed";
                                        }
                                        return "Not Found";
                                    }
                                    return "Unauthorized";
                                }
                                return "Bad Request";
                            }
                            return "Move Temporarily";
                        }
                        return "Move Permanently";
                    }
                    return "RTSP Version Not Supported";
                }
                return "Internal Server Error";
            }
            return "Unsupported Transport";
        }
        return "OK";
    }
}
