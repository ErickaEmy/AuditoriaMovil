package r4;

import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import d9.y;
import m1.m;
import m1.ne;
import r4.y;
import v5.c;
import v5.fh;
import v5.j5;
/* loaded from: classes.dex */
public final class xc {

    /* renamed from: n3  reason: collision with root package name */
    public final Uri f13122n3;
    public final s y;

    public xc(y yVar, Uri uri) {
        v5.y.n3(yVar.f13124c5.containsKey("control"), "missing attribute control");
        this.y = n3(yVar);
        this.f13122n3 = y(uri, (String) j5.i9(yVar.f13124c5.get("control")));
    }

    public static void a(m.n3 n3Var, z0.f3<String, String> f3Var, int i, int i5) {
        v5.y.n3(f3Var.containsKey("profile-level-id"), "missing profile-level-id param");
        n3Var.x("mp4a.40." + ((String) v5.y.v(f3Var.get("profile-level-id"))));
        n3Var.ut(z0.x4.o(d9.y.y(i5, i)));
    }

    public static void c5(m.n3 n3Var, z0.f3<String, String> f3Var) {
        String str = f3Var.get("config");
        if (str != null) {
            byte[] a82 = j5.a8(str);
            n3Var.ut(z0.x4.o(a82));
            Pair<Integer, Integer> a2 = v5.a.a(a82);
            n3Var.s8(((Integer) a2.first).intValue()).o(((Integer) a2.second).intValue());
        } else {
            n3Var.s8(352).o(288);
        }
        String str2 = f3Var.get("profile-level-id");
        StringBuilder sb = new StringBuilder();
        sb.append("mp4v.");
        if (str2 == null) {
            str2 = "1";
        }
        sb.append(str2);
        n3Var.x(sb.toString());
    }

    public static void fb(m.n3 n3Var, z0.f3<String, String> f3Var) {
        boolean z2;
        v5.y.n3(f3Var.containsKey("sprop-parameter-sets"), "missing sprop parameter");
        String[] ro2 = j5.ro((String) v5.y.v(f3Var.get("sprop-parameter-sets")), ",");
        if (ro2.length == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.n3(z2, "empty sprop value");
        z0.x4 j2 = z0.x4.j(zn(ro2[0]), zn(ro2[1]));
        n3Var.ut(j2);
        byte[] bArr = j2.get(0);
        c.zn t2 = v5.c.t(bArr, v5.c.y.length, bArr.length);
        n3Var.y5(t2.f14331s);
        n3Var.o(t2.f14327fb);
        n3Var.s8(t2.f14324a);
        String str = f3Var.get("profile-level-id");
        if (str != null) {
            n3Var.x("avc1." + str);
            return;
        }
        n3Var.x(v5.a.y(t2.y, t2.f14330n3, t2.f14336zn));
    }

    public static int gv(int i, String str) {
        if (i != -1) {
            return i;
        }
        if (str.equals("audio/ac3")) {
            return 6;
        }
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static s n3(y yVar) {
        int i;
        char c2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        boolean z8;
        m.n3 n3Var = new m.n3();
        int i5 = yVar.f13130v;
        if (i5 > 0) {
            n3Var.ud(i5);
        }
        y.zn znVar = yVar.f13127i9;
        int i6 = znVar.y;
        String str = znVar.f13141n3;
        String y = s.y(str);
        n3Var.o4(y);
        int i8 = yVar.f13127i9.f13142zn;
        if ("audio".equals(yVar.y)) {
            i = gv(yVar.f13127i9.f13140gv, y);
            n3Var.rs(i8).a8(i);
        } else {
            i = -1;
        }
        z0.f3<String, String> y2 = yVar.y();
        boolean z9 = false;
        switch (y.hashCode()) {
            case -1664118616:
                if (y.equals("video/3gpp")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (y.equals("video/hevc")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -1606874997:
                if (y.equals("audio/amr-wb")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -53558318:
                if (y.equals("audio/mp4a-latm")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 187078296:
                if (y.equals("audio/ac3")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 187094639:
                if (y.equals("audio/raw")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (y.equals("video/mp4v-es")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (y.equals("video/avc")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1503095341:
                if (y.equals("audio/3gpp")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1504891608:
                if (y.equals("audio/opus")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (y.equals("video/x-vnd.on2.vp8")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (y.equals("video/x-vnd.on2.vp9")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1903231877:
                if (y.equals("audio/g711-alaw")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 1903589369:
                if (y.equals("audio/g711-mlaw")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                if (i != -1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v5.y.y(z2);
                v5.y.n3(!y2.isEmpty(), "missing attribute fmtp");
                if (str.equals("MP4A-LATM")) {
                    if (y2.containsKey("cpresent") && y2.get("cpresent").equals("0")) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    v5.y.n3(z3, "Only supports cpresent=0 in AAC audio.");
                    String str2 = y2.get("config");
                    v5.y.a(str2, "AAC audio stream must include config fmtp parameter");
                    if (str2.length() % 2 == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    v5.y.n3(z4, "Malformat MPEG4 config: " + str2);
                    y.n3 v2 = v(str2);
                    n3Var.rs(v2.y).a8(v2.f7226n3).x(v2.f7227zn);
                }
                a(n3Var, y2, i, i8);
                break;
            case 1:
            case 2:
                if (i == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                v5.y.n3(z5, "Multi channel AMR is not currently supported.");
                v5.y.n3(!y2.isEmpty(), "fmtp parameters must include octet-align.");
                v5.y.n3(y2.containsKey("octet-align"), "Only octet aligned mode is currently supported.");
                v5.y.n3(!y2.containsKey("interleaving"), "Interleaving mode is not currently supported.");
                break;
            case 3:
                if (i != -1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                v5.y.y(z7);
                if (i8 == 48000) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                v5.y.n3(z8, "Invalid OPUS clock rate.");
                break;
            case 4:
                v5.y.y(!y2.isEmpty());
                c5(n3Var, y2);
                break;
            case 5:
                n3Var.s8(352).o(288);
                break;
            case 6:
                v5.y.n3(!y2.isEmpty(), "missing attribute fmtp");
                fb(n3Var, y2);
                break;
            case 7:
                v5.y.n3(!y2.isEmpty(), "missing attribute fmtp");
                s(n3Var, y2);
                break;
            case '\b':
                n3Var.s8(320).o(240);
                break;
            case '\t':
                n3Var.s8(320).o(240);
                break;
            case '\n':
                n3Var.jz(s.n3(str));
                break;
        }
        if (i8 > 0) {
            z9 = true;
        }
        v5.y.y(z9);
        return new s(n3Var.z6(), i6, i8, y2, str);
    }

    public static void s(m.n3 n3Var, z0.f3<String, String> f3Var) {
        boolean z2;
        if (f3Var.containsKey("sprop-max-don-diff")) {
            int parseInt = Integer.parseInt((String) v5.y.v(f3Var.get("sprop-max-don-diff")));
            if (parseInt == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.n3(z2, "non-zero sprop-max-don-diff " + parseInt + " is not supported");
        }
        v5.y.n3(f3Var.containsKey("sprop-vps"), "missing sprop-vps parameter");
        v5.y.n3(f3Var.containsKey("sprop-sps"), "missing sprop-sps parameter");
        v5.y.n3(f3Var.containsKey("sprop-pps"), "missing sprop-pps parameter");
        z0.x4 k2 = z0.x4.k(zn((String) v5.y.v(f3Var.get("sprop-vps"))), zn((String) v5.y.v(f3Var.get("sprop-sps"))), zn((String) v5.y.v(f3Var.get("sprop-pps"))));
        n3Var.ut(k2);
        byte[] bArr = k2.get(1);
        c.y s2 = v5.c.s(bArr, v5.c.y.length, bArr.length);
        n3Var.y5(s2.f14317i9);
        n3Var.o(s2.f14313c5).s8(s2.f14319s);
        n3Var.x(v5.a.zn(s2.y, s2.f14318n3, s2.f14323zn, s2.f14316gv, s2.f14322v, s2.f14312a));
    }

    public static y.n3 v(String str) {
        boolean z2;
        boolean z3;
        boolean z4;
        fh fhVar = new fh(j5.a8(str));
        boolean z5 = true;
        if (fhVar.s(1) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.n3(z2, "Only supports audio mux version 0.");
        if (fhVar.s(1) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        v5.y.n3(z3, "Only supports allStreamsSameTimeFraming.");
        fhVar.mt(6);
        if (fhVar.s(4) == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        v5.y.n3(z4, "Only supports one program.");
        if (fhVar.s(3) != 0) {
            z5 = false;
        }
        v5.y.n3(z5, "Only supports one numLayer.");
        try {
            return d9.y.v(fhVar, false);
        } catch (ne e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Uri y(Uri uri, String str) {
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        if (str.equals("*")) {
            return uri;
        }
        return uri.buildUpon().appendEncodedPath(str).build();
    }

    public static byte[] zn(String str) {
        byte[] decode = Base64.decode(str, 0);
        int length = decode.length;
        byte[] bArr = v5.c.y;
        byte[] bArr2 = new byte[length + bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(decode, 0, bArr2, bArr.length, decode.length);
        return bArr2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xc.class != obj.getClass()) {
            return false;
        }
        xc xcVar = (xc) obj;
        if (this.y.equals(xcVar.y) && this.f13122n3.equals(xcVar.f13122n3)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((217 + this.y.hashCode()) * 31) + this.f13122n3.hashCode();
    }
}
