package v5;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class n {
    public static final ArrayList<y> y = new ArrayList<>();

    /* renamed from: n3  reason: collision with root package name */
    public static final Pattern f14379n3 = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final int f14380n3;
        public final int y;

        public n3(int i, int i5) {
            this.y = i;
            this.f14380n3 = i5;
        }

        public int y() {
            int i = this.f14380n3;
            if (i != 2) {
                if (i != 5) {
                    if (i != 29) {
                        if (i != 42) {
                            if (i != 22) {
                                if (i != 23) {
                                    return 0;
                                }
                                return 15;
                            }
                            return 1073741824;
                        }
                        return 16;
                    }
                    return 12;
                }
                return 11;
            }
            return 10;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final String f14381n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f14382zn;
    }

    public static int a(String str, @Nullable String str2) {
        n3 c52;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c2 = 1;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c2 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 3;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c2 = '\t';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 18;
            case 1:
                return 7;
            case 2:
                if (str2 == null || (c52 = c5(str2)) == null) {
                    return 0;
                }
                return c52.y();
            case 3:
                return 5;
            case 4:
                return 17;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 20;
            case '\b':
                return 8;
            case '\t':
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    public static n3 c5(String str) {
        int i;
        Matcher matcher = f14379n3.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) v5.y.v(matcher.group(1));
        String group = matcher.group(2);
        try {
            int parseInt = Integer.parseInt(str2, 16);
            if (group != null) {
                i = Integer.parseInt(group);
            } else {
                i = 0;
            }
            return new n3(parseInt, i);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static boolean co(@Nullable String str) {
        return "video".equals(i9(str));
    }

    public static int f(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (xc(str)) {
            return 1;
        }
        if (co(str)) {
            return 2;
        }
        if (mt(str)) {
            return 3;
        }
        if (w(str)) {
            return 4;
        }
        if (!"application/id3".equals(str) && !"application/x-emsg".equals(str) && !"application/x-scte35".equals(str)) {
            if ("application/x-camera-motion".equals(str)) {
                return 6;
            }
            return t(str);
        }
        return 5;
    }

    @Nullable
    public static String fb(@Nullable String str) {
        n3 c52;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String v2 = w0.zn.v(str.trim());
        if (!v2.startsWith("avc1") && !v2.startsWith("avc3")) {
            if (!v2.startsWith("hev1") && !v2.startsWith("hvc1")) {
                if (!v2.startsWith("dvav") && !v2.startsWith("dva1") && !v2.startsWith("dvhe") && !v2.startsWith("dvh1")) {
                    if (v2.startsWith("av01")) {
                        return "video/av01";
                    }
                    if (!v2.startsWith("vp9") && !v2.startsWith("vp09")) {
                        if (!v2.startsWith("vp8") && !v2.startsWith("vp08")) {
                            if (v2.startsWith("mp4a")) {
                                if (v2.startsWith("mp4a.") && (c52 = c5(v2)) != null) {
                                    str2 = s(c52.y);
                                }
                                if (str2 == null) {
                                    return "audio/mp4a-latm";
                                }
                                return str2;
                            } else if (v2.startsWith("mha1")) {
                                return "audio/mha1";
                            } else {
                                if (v2.startsWith("mhm1")) {
                                    return "audio/mhm1";
                                }
                                if (!v2.startsWith("ac-3") && !v2.startsWith("dac3")) {
                                    if (!v2.startsWith("ec-3") && !v2.startsWith("dec3")) {
                                        if (v2.startsWith("ec+3")) {
                                            return "audio/eac3-joc";
                                        }
                                        if (!v2.startsWith("ac-4") && !v2.startsWith("dac4")) {
                                            if (v2.startsWith("dtsc")) {
                                                return "audio/vnd.dts";
                                            }
                                            if (v2.startsWith("dtse")) {
                                                return "audio/vnd.dts.hd;profile=lbr";
                                            }
                                            if (!v2.startsWith("dtsh") && !v2.startsWith("dtsl")) {
                                                if (v2.startsWith("dtsx")) {
                                                    return "audio/vnd.dts.uhd;profile=p2";
                                                }
                                                if (v2.startsWith("opus")) {
                                                    return "audio/opus";
                                                }
                                                if (v2.startsWith("vorbis")) {
                                                    return "audio/vorbis";
                                                }
                                                if (v2.startsWith("flac")) {
                                                    return "audio/flac";
                                                }
                                                if (v2.startsWith("stpp")) {
                                                    return "application/ttml+xml";
                                                }
                                                if (v2.startsWith("wvtt")) {
                                                    return "text/vtt";
                                                }
                                                if (v2.contains("cea708")) {
                                                    return "application/cea-708";
                                                }
                                                if (!v2.contains("eia608") && !v2.contains("cea608")) {
                                                    return v(v2);
                                                }
                                                return "application/cea-608";
                                            }
                                            return "audio/vnd.dts.hd";
                                        }
                                        return "audio/ac4";
                                    }
                                    return "audio/eac3";
                                }
                                return "audio/ac3";
                            }
                        }
                        return "video/x-vnd.on2.vp8";
                    }
                    return "video/x-vnd.on2.vp9";
                }
                return "video/dolby-vision";
            }
            return "video/hevc";
        }
        return "video/avc";
    }

    @Nullable
    public static String gv(@Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] yk2 = j5.yk(str);
        StringBuilder sb = new StringBuilder();
        for (String str3 : yk2) {
            if (str2.equals(fb(str3))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str3);
            }
        }
        if (sb.length() <= 0) {
            return null;
        }
        return sb.toString();
    }

    @Nullable
    public static String i9(@Nullable String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static boolean mt(@Nullable String str) {
        if (!"text".equals(i9(str)) && !"application/cea-608".equals(str) && !"application/cea-708".equals(str) && !"application/x-mp4-cea-608".equals(str) && !"application/x-subrip".equals(str) && !"application/ttml+xml".equals(str) && !"application/x-quicktime-tx3g".equals(str) && !"application/x-mp4-vtt".equals(str) && !"application/x-rawcc".equals(str) && !"application/vobsub".equals(str) && !"application/pgs".equals(str) && !"application/dvbsubs".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean n3(@Nullable String str, String str2) {
        if (gv(str, str2) != null) {
            return true;
        }
        return false;
    }

    public static boolean p(@Nullable String str) {
        if (str == null) {
            return false;
        }
        if (!str.startsWith("video/webm") && !str.startsWith("audio/webm") && !str.startsWith("application/webm") && !str.startsWith("video/x-matroska") && !str.startsWith("audio/x-matroska") && !str.startsWith("application/x-matroska")) {
            return false;
        }
        return true;
    }

    @Nullable
    public static String s(int i) {
        if (i != 32) {
            if (i != 33) {
                if (i != 35) {
                    if (i != 64) {
                        if (i != 163) {
                            if (i != 177) {
                                if (i != 165) {
                                    if (i != 166) {
                                        switch (i) {
                                            case 96:
                                            case 97:
                                            case 98:
                                            case 99:
                                            case 100:
                                            case 101:
                                                return "video/mpeg2";
                                            case 102:
                                            case 103:
                                            case 104:
                                                return "audio/mp4a-latm";
                                            case 105:
                                            case 107:
                                                return "audio/mpeg";
                                            case R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /* 106 */:
                                                return "video/mpeg";
                                            default:
                                                switch (i) {
                                                    case 169:
                                                    case 172:
                                                        return "audio/vnd.dts";
                                                    case 170:
                                                    case 171:
                                                        return "audio/vnd.dts.hd";
                                                    case 173:
                                                        return "audio/opus";
                                                    case 174:
                                                        return "audio/ac4";
                                                    default:
                                                        return null;
                                                }
                                        }
                                    }
                                    return "audio/eac3";
                                }
                                return "audio/ac3";
                            }
                            return "video/x-vnd.on2.vp9";
                        }
                        return "video/wvc1";
                    }
                    return "audio/mp4a-latm";
                }
                return "video/hevc";
            }
            return "video/avc";
        }
        return "video/mp4v-es";
    }

    public static int t(String str) {
        int size = y.size();
        for (int i = 0; i < size; i++) {
            y yVar = y.get(i);
            if (str.equals(yVar.y)) {
                return yVar.f14382zn;
            }
        }
        return -1;
    }

    public static int tl(String str) {
        return f(fb(str));
    }

    @Nullable
    public static String v(String str) {
        int size = y.size();
        for (int i = 0; i < size; i++) {
            y yVar = y.get(i);
            if (str.startsWith(yVar.f14381n3)) {
                return yVar.y;
            }
        }
        return null;
    }

    public static boolean w(@Nullable String str) {
        return "image".equals(i9(str));
    }

    @Nullable
    public static String wz(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : j5.yk(str)) {
            String fb2 = fb(str2);
            if (fb2 != null && co(fb2)) {
                return fb2;
            }
        }
        return null;
    }

    public static boolean xc(@Nullable String str) {
        return "audio".equals(i9(str));
    }

    public static boolean y(@Nullable String str, @Nullable String str2) {
        n3 c52;
        int y2;
        if (str == null) {
            return false;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c2 = 0;
                    break;
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c2 = 1;
                    break;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c2 = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c2 = 3;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 4;
                    break;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c2 = '\n';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                return true;
            case 3:
                if (str2 != null && (c52 = c5(str2)) != null && (y2 = c52.y()) != 0 && y2 != 16) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static String z(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1007807498:
                if (str.equals("audio/x-flac")) {
                    c2 = 0;
                    break;
                }
                break;
            case -586683234:
                if (str.equals("audio/x-wav")) {
                    c2 = 1;
                    break;
                }
                break;
            case 187090231:
                if (str.equals("audio/mp3")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "audio/flac";
            case 1:
                return "audio/wav";
            case 2:
                return "audio/mpeg";
            default:
                return str;
        }
    }

    @Nullable
    public static String zn(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : j5.yk(str)) {
            String fb2 = fb(str2);
            if (fb2 != null && xc(fb2)) {
                return fb2;
            }
        }
        return null;
    }
}
