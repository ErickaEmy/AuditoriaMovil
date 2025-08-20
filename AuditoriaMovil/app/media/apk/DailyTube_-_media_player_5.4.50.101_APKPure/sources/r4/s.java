package r4;

import androidx.annotation.Nullable;
import java.util.Map;
import m1.m;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: gv  reason: collision with root package name */
    public final z0.f3<String, String> f13098gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f13099n3;

    /* renamed from: v  reason: collision with root package name */
    public final String f13100v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final m f13101zn;

    public s(m mVar, int i, int i5, Map<String, String> map, String str) {
        this.y = i;
        this.f13099n3 = i5;
        this.f13101zn = mVar;
        this.f13098gv = z0.f3.s(map);
        this.f13100v = str;
    }

    public static int n3(String str) {
        boolean z2;
        if (!str.equals("L8") && !str.equals("L16")) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.y(z2);
        if (str.equals("L8")) {
            return 3;
        }
        return 268435456;
    }

    public static String y(String str) {
        String a2 = w0.zn.a(str);
        a2.hashCode();
        char c2 = 65535;
        switch (a2.hashCode()) {
            case -1922091719:
                if (a2.equals("MPEG4-GENERIC")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2412:
                if (a2.equals("L8")) {
                    c2 = 1;
                    break;
                }
                break;
            case 64593:
                if (a2.equals("AC3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 64934:
                if (a2.equals("AMR")) {
                    c2 = 3;
                    break;
                }
                break;
            case 74609:
                if (a2.equals("L16")) {
                    c2 = 4;
                    break;
                }
                break;
            case 85182:
                if (a2.equals("VP8")) {
                    c2 = 5;
                    break;
                }
                break;
            case 85183:
                if (a2.equals("VP9")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2194728:
                if (a2.equals("H264")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2194729:
                if (a2.equals("H265")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 2433087:
                if (a2.equals("OPUS")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 2450119:
                if (a2.equals("PCMA")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 2450139:
                if (a2.equals("PCMU")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1061166827:
                if (a2.equals("MP4A-LATM")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1934494802:
                if (a2.equals("AMR-WB")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1959269366:
                if (a2.equals("MP4V-ES")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2137188397:
                if (a2.equals("H263-1998")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2137209252:
                if (a2.equals("H263-2000")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case '\f':
                return "audio/mp4a-latm";
            case 1:
            case 4:
                return "audio/raw";
            case 2:
                return "audio/ac3";
            case 3:
                return "audio/3gpp";
            case 5:
                return "video/x-vnd.on2.vp8";
            case 6:
                return "video/x-vnd.on2.vp9";
            case 7:
                return "video/avc";
            case '\b':
                return "video/hevc";
            case '\t':
                return "audio/opus";
            case '\n':
                return "audio/g711-alaw";
            case 11:
                return "audio/g711-mlaw";
            case '\r':
                return "audio/amr-wb";
            case 14:
                return "video/mp4v-es";
            case 15:
            case 16:
                return "video/3gpp";
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public static boolean zn(y yVar) {
        String a2 = w0.zn.a(yVar.f13127i9.f13141n3);
        a2.hashCode();
        char c2 = 65535;
        switch (a2.hashCode()) {
            case -1922091719:
                if (a2.equals("MPEG4-GENERIC")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2412:
                if (a2.equals("L8")) {
                    c2 = 1;
                    break;
                }
                break;
            case 64593:
                if (a2.equals("AC3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 64934:
                if (a2.equals("AMR")) {
                    c2 = 3;
                    break;
                }
                break;
            case 74609:
                if (a2.equals("L16")) {
                    c2 = 4;
                    break;
                }
                break;
            case 85182:
                if (a2.equals("VP8")) {
                    c2 = 5;
                    break;
                }
                break;
            case 85183:
                if (a2.equals("VP9")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2194728:
                if (a2.equals("H264")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2194729:
                if (a2.equals("H265")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 2433087:
                if (a2.equals("OPUS")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 2450119:
                if (a2.equals("PCMA")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 2450139:
                if (a2.equals("PCMU")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1061166827:
                if (a2.equals("MP4A-LATM")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1934494802:
                if (a2.equals("AMR-WB")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1959269366:
                if (a2.equals("MP4V-ES")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2137188397:
                if (a2.equals("H263-1998")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2137209252:
                if (a2.equals("H263-2000")) {
                    c2 = 16;
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
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
            case 16:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.y == sVar.y && this.f13099n3 == sVar.f13099n3 && this.f13101zn.equals(sVar.f13101zn) && this.f13098gv.equals(sVar.f13098gv) && this.f13100v.equals(sVar.f13100v)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((217 + this.y) * 31) + this.f13099n3) * 31) + this.f13101zn.hashCode()) * 31) + this.f13098gv.hashCode()) * 31) + this.f13100v.hashCode();
    }
}
