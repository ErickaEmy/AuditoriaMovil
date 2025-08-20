package v5;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.uv.v7.R;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import m1.m;
import m1.ne;
import m1.uo;
/* loaded from: classes.dex */
public final class j5 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f14357a;

    /* renamed from: c5  reason: collision with root package name */
    public static final Pattern f14358c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f14359f;

    /* renamed from: fb  reason: collision with root package name */
    public static final Pattern f14360fb;

    /* renamed from: gv  reason: collision with root package name */
    public static final String f14361gv;

    /* renamed from: i9  reason: collision with root package name */
    public static final Pattern f14362i9;

    /* renamed from: n3  reason: collision with root package name */
    public static final String f14363n3;

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f14364s;

    /* renamed from: t  reason: collision with root package name */
    public static final String[] f14365t;

    /* renamed from: tl  reason: collision with root package name */
    public static final String[] f14366tl;

    /* renamed from: v  reason: collision with root package name */
    public static final String f14367v;

    /* renamed from: wz  reason: collision with root package name */
    public static final int[] f14368wz;

    /* renamed from: xc  reason: collision with root package name */
    public static final int[] f14369xc;
    public static final int y;

    /* renamed from: zn  reason: collision with root package name */
    public static final String f14370zn;

    /* loaded from: classes.dex */
    public static final class y {
        public static Drawable y(Context context, Resources resources, int i) {
            return resources.getDrawable(i, context.getTheme());
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        y = i;
        String str = Build.DEVICE;
        f14363n3 = str;
        String str2 = Build.MANUFACTURER;
        f14370zn = str2;
        String str3 = Build.MODEL;
        f14361gv = str3;
        f14367v = str + ", " + str3 + ", " + str2 + ", " + i;
        f14357a = new byte[0];
        f14360fb = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f14364s = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f14358c5 = Pattern.compile("%([A-Fa-f0-9]{2})");
        f14362i9 = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f14365t = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f14366tl = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f14368wz = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f14369xc = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, R.styleable.AppCompatTheme_textColorSearchUrl, 104, 97, 102, R.styleable.AppCompatTheme_tooltipFrameBackground, 116, 125, 122, 137, 142, 135, NotificationCompat.FLAG_HIGH_PRIORITY, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, R.styleable.AppCompatTheme_textColorAlertDialogListItem, 103, 96, 117, R.styleable.AppCompatTheme_tooltipForegroundColor, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, R.styleable.AppCompatTheme_toolbarStyle, 120, 127, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static <T extends Comparable<? super T>> int a(List<? extends Comparable<? super T>> list, T t2, boolean z2, boolean z3) {
        int i;
        int i5;
        int binarySearch = Collections.binarySearch(list, t2);
        if (binarySearch < 0) {
            i5 = -(binarySearch + 2);
        } else {
            while (true) {
                i = binarySearch - 1;
                if (i < 0 || list.get(i).compareTo(t2) != 0) {
                    break;
                }
                binarySearch = i;
            }
            if (z2) {
                i5 = binarySearch;
            } else {
                i5 = i;
            }
        }
        if (z3) {
            return Math.max(0, i5);
        }
        return i5;
    }

    public static byte[] a8(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i5 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i5), 16) << 4) + Character.digit(str.charAt(i5 + 1), 16));
        }
        return bArr;
    }

    public static String ad(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String v2 = w0.zn.v(str);
        String str2 = ix(v2, "-")[0];
        if (f14359f == null) {
            f14359f = d0();
        }
        String str3 = f14359f.get(str2);
        if (str3 != null) {
            v2 = str3 + v2.substring(str2.length());
            str2 = str3;
        }
        if ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) {
            return cr(v2);
        }
        return v2;
    }

    public static byte[] ap(String str) {
        return str.getBytes(w0.v.f14523zn);
    }

    @Nullable
    public static String b(@Nullable String str, int i) {
        String[] yk2 = yk(str);
        if (yk2.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : yk2) {
            if (i == n.tl(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() <= 0) {
            return null;
        }
        return sb.toString();
    }

    public static boolean bk(int i) {
        if (i != 10 && i != 13) {
            return false;
        }
        return true;
    }

    public static void bv(Parcel parcel, boolean z2) {
        parcel.writeInt(z2 ? 1 : 0);
    }

    public static Handler c(@Nullable Handler.Callback callback) {
        return x4(j5(), callback);
    }

    public static int c5(long[] jArr, long j2, boolean z2, boolean z3) {
        int i;
        int i5;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i5 = -(binarySearch + 2);
        } else {
            while (true) {
                i = binarySearch - 1;
                if (i < 0 || jArr[i] != j2) {
                    break;
                }
                binarySearch = i;
            }
            if (z2) {
                i5 = binarySearch;
            } else {
                i5 = i;
            }
        }
        if (z3) {
            return Math.max(0, i5);
        }
        return i5;
    }

    public static boolean co(Object[] objArr, @Nullable Object obj) {
        for (Object obj2 : objArr) {
            if (zn(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String cr(String str) {
        int i = 0;
        while (true) {
            String[] strArr = f14366tl;
            if (i < strArr.length) {
                if (str.startsWith(strArr[i])) {
                    return strArr[i + 1] + str.substring(strArr[i].length());
                }
                i += 2;
            } else {
                return str;
            }
        }
    }

    public static int ct(int i, int i5) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 268435456) {
                        if (i != 536870912) {
                            if (i != 805306368) {
                                throw new IllegalArgumentException();
                            }
                        } else {
                            return i5 * 3;
                        }
                    }
                }
                return i5 * 4;
            }
            return i5;
        }
        return i5 * 2;
    }

    public static <T> T[] cy(T[] tArr, T t2) {
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t2;
        return (T[]) f(copyOf);
    }

    public static int d(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static HashMap<String, String> d0() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + f14365t.length);
        int i = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f14365t;
            if (i < strArr.length) {
                hashMap.put(strArr[i], strArr[i + 1]);
                i += 2;
            } else {
                return hashMap;
            }
        }
    }

    public static m dm(int i, int i5, int i6) {
        return new m.n3().o4("audio/raw").a8(i5).rs(i6).jz(i).z6();
    }

    @Nullable
    public static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e2) {
            r.gv("Util", "Failed to read system property " + str, e2);
            return null;
        }
    }

    public static String eb(StringBuilder sb, Formatter formatter, long j2) {
        long j4;
        String str;
        if (j2 == -9223372036854775807L) {
            j4 = 0;
        } else {
            j4 = j2;
        }
        if (j4 < 0) {
            str = "-";
        } else {
            str = "";
        }
        long abs = (Math.abs(j4) + 500) / 1000;
        long j6 = abs % 60;
        long j7 = (abs / 60) % 60;
        long j8 = abs / 3600;
        sb.setLength(0);
        if (j8 > 0) {
            return formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j8), Long.valueOf(j7), Long.valueOf(j6)).toString();
        }
        return formatter.format("%s%02d:%02d", str, Long.valueOf(j7), Long.valueOf(j6)).toString();
    }

    public static uo.n3 ej(uo uoVar, uo.n3 n3Var) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        boolean z8;
        boolean i92 = uoVar.i9();
        boolean ap2 = uoVar.ap();
        boolean y52 = uoVar.y5();
        boolean rz2 = uoVar.rz();
        boolean cr2 = uoVar.cr();
        boolean a82 = uoVar.a8();
        boolean r2 = uoVar.b().r();
        uo.n3.y gv2 = new uo.n3.y().n3(n3Var).gv(4, !i92);
        boolean z9 = false;
        if (ap2 && !i92) {
            z2 = true;
        } else {
            z2 = false;
        }
        uo.n3.y gv3 = gv2.gv(5, z2);
        if (y52 && !i92) {
            z3 = true;
        } else {
            z3 = false;
        }
        uo.n3.y gv4 = gv3.gv(6, z3);
        if (!r2 && ((y52 || !cr2 || ap2) && !i92)) {
            z4 = true;
        } else {
            z4 = false;
        }
        uo.n3.y gv5 = gv4.gv(7, z4);
        if (rz2 && !i92) {
            z5 = true;
        } else {
            z5 = false;
        }
        uo.n3.y gv6 = gv5.gv(8, z5);
        if (!r2 && ((rz2 || (cr2 && a82)) && !i92)) {
            z7 = true;
        } else {
            z7 = false;
        }
        uo.n3.y gv7 = gv6.gv(9, z7).gv(10, !i92);
        if (ap2 && !i92) {
            z8 = true;
        } else {
            z8 = false;
        }
        uo.n3.y gv8 = gv7.gv(11, z8);
        if (ap2 && !i92) {
            z9 = true;
        }
        return gv8.gv(12, z9).v();
    }

    public static String en(Locale locale) {
        if (y >= 21) {
            return jz(locale);
        }
        return locale.toString();
    }

    public static Handler f3(@Nullable Handler.Callback callback) {
        return x4((Looper) v5.y.c5(Looper.myLooper()), callback);
    }

    public static String f7(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return "YES";
                        }
                        throw new IllegalStateException();
                    }
                    return "NO_EXCEEDS_CAPABILITIES";
                }
                return "NO_UNSUPPORTED_DRM";
            }
            return "NO_UNSUPPORTED_TYPE";
        }
        return "NO";
    }

    public static int fb(x4 x4Var, long j2, boolean z2, boolean z3) {
        int i;
        int zn2 = x4Var.zn() - 1;
        int i5 = 0;
        while (i5 <= zn2) {
            int i6 = (i5 + zn2) >>> 1;
            if (x4Var.n3(i6) < j2) {
                i5 = i6 + 1;
            } else {
                zn2 = i6 - 1;
            }
        }
        if (z2 && (i = zn2 + 1) < x4Var.zn() && x4Var.n3(i) == j2) {
            return i;
        }
        if (z3 && zn2 == -1) {
            return 0;
        }
        return zn2;
    }

    public static Uri fh(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = f14362i9.matcher(path);
        if (matcher.matches() && matcher.group(1) == null) {
            return Uri.withAppendedPath(uri, "Manifest");
        }
        return uri;
    }

    public static boolean g(int i) {
        if (i != 536870912 && i != 805306368 && i != 4) {
            return false;
        }
        return true;
    }

    public static String g3(int i) {
        return Integer.toString(i, 36);
    }

    public static long gf(long j2) {
        if (j2 != -9223372036854775807L && j2 != Long.MIN_VALUE) {
            return j2 / 1000;
        }
        return j2;
    }

    public static long gq(String str) throws ne {
        Matcher matcher = f14360fb.matcher(str);
        if (matcher.matches()) {
            int i = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                if ("-".equals(matcher.group(11))) {
                    i *= -1;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if (i != 0) {
                return timeInMillis - (i * 60000);
            }
            return timeInMillis;
        }
        throw ne.y("Invalid date/time format: " + str, null);
    }

    public static <T extends Comparable<? super T>> int gv(List<? extends Comparable<? super T>> list, T t2, boolean z2, boolean z3) {
        int i;
        int i5;
        int binarySearch = Collections.binarySearch(list, t2);
        if (binarySearch < 0) {
            i5 = ~binarySearch;
        } else {
            int size = list.size();
            while (true) {
                i = binarySearch + 1;
                if (i >= size || list.get(i).compareTo(t2) != 0) {
                    break;
                }
                binarySearch = i;
            }
            if (z2) {
                i5 = binarySearch;
            } else {
                i5 = i;
            }
        }
        if (z3) {
            return Math.min(list.size() - 1, i5);
        }
        return i5;
    }

    public static Point hw(Context context, Display display) {
        String e2;
        if (display.getDisplayId() == 0 && tg(context)) {
            if (y < 28) {
                e2 = e("sys.display-size");
            } else {
                e2 = e("vendor.display-size");
            }
            if (!TextUtils.isEmpty(e2)) {
                try {
                    String[] ro2 = ro(e2.trim(), "x");
                    if (ro2.length == 2) {
                        int parseInt = Integer.parseInt(ro2[0]);
                        int parseInt2 = Integer.parseInt(ro2[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                r.zn("Util", "Invalid display size: " + e2);
            }
            if ("Sony".equals(f14370zn) && f14361gv.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i = y;
        if (i >= 23) {
            oz(display, point);
        } else if (i >= 17) {
            j(display, point);
        } else {
            o(display, point);
        }
        return point;
    }

    public static long i2(long j2, long j4, long j6) {
        long j7 = j2 - j4;
        if (((j2 ^ j7) & (j4 ^ j2)) < 0) {
            return j6;
        }
        return j7;
    }

    public static boolean i3(SQLiteDatabase sQLiteDatabase, String str) {
        if (DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public static Handler i4() {
        return f3(null);
    }

    public static String[] ix(String str, String str2) {
        return str.split(str2, 2);
    }

    public static void j(Display display, Point point) {
        display.getRealSize(point);
    }

    public static String j3(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(Character.forDigit((bArr[i] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i] & 15, 16));
        }
        return sb.toString();
    }

    public static Looper j5() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            return Looper.getMainLooper();
        }
        return myLooper;
    }

    public static String jz(Locale locale) {
        return locale.toLanguageTag();
    }

    public static int k(@Nullable String str) {
        String[] ro2;
        int length;
        boolean z2;
        if (str == null || (length = (ro2 = ro(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = ro2[length - 1];
        if (length >= 3 && "neg".equals(ro2[length - 2])) {
            z2 = true;
        } else {
            z2 = false;
        }
        try {
            int parseInt = Integer.parseInt((String) v5.y.v(str2));
            if (z2) {
                return -parseInt;
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static String k5(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static int kp(Uri uri, @Nullable String str) {
        if (str == null) {
            return yg(uri);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -979127466:
                if (str.equals("application/x-mpegURL")) {
                    c2 = 0;
                    break;
                }
                break;
            case -156749520:
                if (str.equals("application/vnd.ms-sstr+xml")) {
                    c2 = 1;
                    break;
                }
                break;
            case 64194685:
                if (str.equals("application/dash+xml")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1154777587:
                if (str.equals("application/x-rtsp")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 0;
            case 3:
                return 3;
            default:
                return 4;
        }
    }

    public static <T> T[] l(T[] tArr, int i, int i5) {
        boolean z2;
        boolean z3 = false;
        if (i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (i5 <= tArr.length) {
            z3 = true;
        }
        v5.y.y(z3);
        return (T[]) Arrays.copyOfRange(tArr, i, i5);
    }

    public static String[] lc() {
        String[] nf2 = nf();
        for (int i = 0; i < nf2.length; i++) {
            nf2[i] = ad(nf2[i]);
        }
        return nf2;
    }

    public static void le(Throwable th) {
        cs(th);
    }

    public static boolean m(Context context) {
        if (y >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return true;
        }
        return false;
    }

    public static String mg(byte[] bArr) {
        return new String(bArr, w0.v.f14523zn);
    }

    public static void mp(long[] jArr, long j2, long j4) {
        int i = 0;
        int i5 = (j4 > j2 ? 1 : (j4 == j2 ? 0 : -1));
        if (i5 >= 0 && j4 % j2 == 0) {
            long j6 = j4 / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j6;
                i++;
            }
        } else if (i5 < 0 && j2 % j4 == 0) {
            long j7 = j2 / j4;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j7;
                i++;
            }
        } else {
            double d2 = j2 / j4;
            while (i < jArr.length) {
                jArr[i] = (long) (jArr[i] * d2);
                i++;
            }
        }
    }

    public static long mt(long j2, long j4, long j6) {
        return Math.max(j4, Math.min(j2, j6));
    }

    public static Handler n() {
        return c(null);
    }

    public static long n3(long j2, long j4, long j6) {
        long j7 = j2 + j4;
        if (((j2 ^ j7) & (j4 ^ j7)) < 0) {
            return j6;
        }
        return j7;
    }

    @Nullable
    public static String nd(String str) {
        int length = str.length();
        int i = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (str.charAt(i6) == '%') {
                i5++;
            }
        }
        if (i5 == 0) {
            return str;
        }
        int i8 = length - (i5 * 2);
        StringBuilder sb = new StringBuilder(i8);
        Matcher matcher = f14358c5.matcher(str);
        while (i5 > 0 && matcher.find()) {
            sb.append((CharSequence) str, i, matcher.start());
            sb.append((char) Integer.parseInt((String) v5.y.v(matcher.group(1)), 16));
            i = matcher.end();
            i5--;
        }
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        if (sb.length() != i8) {
            return null;
        }
        return sb.toString();
    }

    public static long ne(int i, int i5) {
        return q(i5) | (q(i) << 32);
    }

    public static String[] nf() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return y >= 24 ? ra(configuration) : new String[]{en(configuration.locale)};
    }

    public static void o(Display display, Point point) {
        display.getSize(point);
    }

    public static <T> void o0(List<T> list, int i, int i5, int i6) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i8 = (i5 - i) - 1; i8 >= 0; i8--) {
            arrayDeque.addFirst(list.remove(i + i8));
        }
        list.addAll(Math.min(i6, list.size()), arrayDeque);
    }

    public static long o4(long j2, float f4) {
        if (f4 == 1.0f) {
            return j2;
        }
        return Math.round(j2 / f4);
    }

    public static boolean oa(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        return handler.post(runnable);
    }

    public static void oz(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static int p(int i, int i5, int i6) {
        return Math.max(i5, Math.min(i, i6));
    }

    public static int pq(int[] iArr, int i) {
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (iArr[i5] == i) {
                return i5;
            }
        }
        return -1;
    }

    public static /* synthetic */ Thread pz(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static long q(int i) {
        return i & 4294967295L;
    }

    public static long[] q5(List<Long> list, long j2, long j4) {
        int size = list.size();
        long[] jArr = new long[size];
        int i = 0;
        int i5 = (j4 > j2 ? 1 : (j4 == j2 ? 0 : -1));
        if (i5 >= 0 && j4 % j2 == 0) {
            long j6 = j4 / j2;
            while (i < size) {
                jArr[i] = list.get(i).longValue() / j6;
                i++;
            }
        } else if (i5 < 0 && j2 % j4 == 0) {
            long j7 = j2 / j4;
            while (i < size) {
                jArr[i] = list.get(i).longValue() * j7;
                i++;
            }
        } else {
            double d2 = j2 / j4;
            while (i < size) {
                jArr[i] = (long) (list.get(i).longValue() * d2);
                i++;
            }
        }
        return jArr;
    }

    public static int q9(int i) {
        if (i != 2 && i != 4) {
            if (i != 10) {
                if (i != 7) {
                    if (i != 8) {
                        switch (i) {
                            case 15:
                                return 6003;
                            case 16:
                            case 18:
                                return 6005;
                            case 17:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                return 6004;
                            default:
                                switch (i) {
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                        return 6002;
                                    default:
                                        return 6006;
                                }
                        }
                    }
                    return 6003;
                }
                return 6005;
            }
            return 6004;
        }
        return 6005;
    }

    public static <T> T[] qj(T[] tArr, int i) {
        boolean z2;
        if (i <= tArr.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        return (T[]) Arrays.copyOf(tArr, i);
    }

    public static <T> T[] qk(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static Locale qn() {
        if (y >= 24) {
            return Locale.getDefault(Locale.Category.DISPLAY);
        }
        return Locale.getDefault();
    }

    public static int r(byte[] bArr, int i, int i5, int i6) {
        while (i < i5) {
            i6 = f14369xc[i6 ^ (bArr[i] & 255)];
            i++;
        }
        return i6;
    }

    public static String[] ra(Configuration configuration) {
        return ro(configuration.getLocales().toLanguageTags(), ",");
    }

    public static boolean rb(rz rzVar, rz rzVar2, @Nullable Inflater inflater) {
        if (rzVar.y() <= 0) {
            return false;
        }
        if (rzVar2.n3() < rzVar.y()) {
            rzVar2.zn(rzVar.y() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(rzVar.v(), rzVar.a(), rzVar.y());
        int i = 0;
        while (true) {
            try {
                i += inflater.inflate(rzVar2.v(), i, rzVar2.n3() - i);
                if (inflater.finished()) {
                    rzVar2.j(i);
                    inflater.reset();
                    return true;
                } else if (inflater.needsDictionary() || inflater.needsInput()) {
                    break;
                } else if (i == rzVar2.n3()) {
                    rzVar2.zn(rzVar2.n3() * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static String[] ro(String str, String str2) {
        return str.split(str2, -1);
    }

    public static int rs(int i) {
        if (i != 13) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
        return 1;
    }

    public static String rz(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int s(int[] iArr, int i, boolean z2, boolean z3) {
        int i5;
        int i6;
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            i6 = -(binarySearch + 2);
        } else {
            while (true) {
                i5 = binarySearch - 1;
                if (i5 < 0 || iArr[i5] != i) {
                    break;
                }
                binarySearch = i5;
            }
            if (z2) {
                i6 = binarySearch;
            } else {
                i6 = i5;
            }
        }
        if (z3) {
            return Math.max(0, i6);
        }
        return i6;
    }

    public static String s8(int i) {
        switch (i) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i >= 10000) {
                    return "custom (" + i + ")";
                }
                return "?";
        }
    }

    public static int t(int i, int i5) {
        return ((i + i5) - 1) / i5;
    }

    public static String ta(byte[] bArr, int i, int i5) {
        return new String(bArr, i, i5, w0.v.f14523zn);
    }

    public static boolean tg(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
            return true;
        }
        return false;
    }

    public static long tl(long j2, long j4) {
        return ((j2 + j4) - 1) / j4;
    }

    public static long u(long j2, float f4) {
        if (f4 == 1.0f) {
            return j2;
        }
        return Math.round(j2 * f4);
    }

    public static boolean u0(int i) {
        if (i != 3 && i != 2 && i != 268435456 && i != 536870912 && i != 805306368 && i != 4) {
            return false;
        }
        return true;
    }

    public static int ud(ByteBuffer byteBuffer, int i) {
        int i5 = byteBuffer.getInt(i);
        if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
            return Integer.reverseBytes(i5);
        }
        return i5;
    }

    public static Drawable ut(Context context, Resources resources, int i) {
        if (y >= 21) {
            return y.y(context, resources, i);
        }
        return resources.getDrawable(i);
    }

    public static int v(long[] jArr, long j2, boolean z2, boolean z3) {
        int i;
        int i5;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i5 = ~binarySearch;
        } else {
            while (true) {
                i = binarySearch + 1;
                if (i >= jArr.length || jArr[i] != j2) {
                    break;
                }
                binarySearch = i;
            }
            if (z2) {
                i5 = binarySearch;
            } else {
                i5 = i;
            }
        }
        if (z3) {
            return Math.min(jArr.length - 1, i5);
        }
        return i5;
    }

    public static Point vl(Context context) {
        Display display;
        DisplayManager displayManager;
        if (y >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
            display = displayManager.getDisplay(0);
        } else {
            display = null;
        }
        if (display == null) {
            display = ((WindowManager) v5.y.v((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return hw(context, display);
    }

    public static byte[] vn(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static long vp(String str) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        Matcher matcher = f14364s.matcher(str);
        if (matcher.matches()) {
            boolean isEmpty = TextUtils.isEmpty(matcher.group(1));
            String group = matcher.group(3);
            double d7 = 0.0d;
            if (group != null) {
                d2 = Double.parseDouble(group) * 3.1556908E7d;
            } else {
                d2 = 0.0d;
            }
            String group2 = matcher.group(5);
            if (group2 != null) {
                d3 = Double.parseDouble(group2) * 2629739.0d;
            } else {
                d3 = 0.0d;
            }
            double d8 = d2 + d3;
            String group3 = matcher.group(7);
            if (group3 != null) {
                d4 = Double.parseDouble(group3) * 86400.0d;
            } else {
                d4 = 0.0d;
            }
            double d10 = d8 + d4;
            String group4 = matcher.group(10);
            if (group4 != null) {
                d5 = Double.parseDouble(group4) * 3600.0d;
            } else {
                d5 = 0.0d;
            }
            double d11 = d10 + d5;
            String group5 = matcher.group(12);
            if (group5 != null) {
                d6 = Double.parseDouble(group5) * 60.0d;
            } else {
                d6 = 0.0d;
            }
            double d12 = d11 + d6;
            String group6 = matcher.group(14);
            if (group6 != null) {
                d7 = Double.parseDouble(group6);
            }
            long j2 = (long) ((d12 + d7) * 1000.0d);
            if (!isEmpty) {
                return -j2;
            }
            return j2;
        }
        return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
    }

    public static float w(float f4, float f6, float f9) {
        return Math.max(f6, Math.min(f4, f9));
    }

    public static <T> void w2(List<T> list, int i, int i5) {
        if (i >= 0 && i5 <= list.size() && i <= i5) {
            if (i != i5) {
                list.subList(i, i5).clear();
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean w9(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static ExecutorService wf(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: v5.hw
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread pz2;
                pz2 = j5.pz(str, runnable);
                return pz2;
            }
        });
    }

    public static CharSequence wm(CharSequence charSequence, int i) {
        if (charSequence.length() > i) {
            return charSequence.subSequence(0, i);
        }
        return charSequence;
    }

    public static void wz(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int x(@Nullable String str, int i) {
        int i5 = 0;
        for (String str2 : yk(str)) {
            if (i == n.tl(str2)) {
                i5++;
            }
        }
        return i5;
    }

    public static Handler x4(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static long x5(long j2, long j4, long j6) {
        int i = (j6 > j4 ? 1 : (j6 == j4 ? 0 : -1));
        if (i >= 0 && j6 % j4 == 0) {
            return j2 / (j6 / j4);
        }
        if (i < 0 && j4 % j6 == 0) {
            return j2 * (j4 / j6);
        }
        return (long) (j2 * (j4 / j6));
    }

    public static long xb(long j2) {
        if (j2 != -9223372036854775807L && j2 != Long.MIN_VALUE) {
            return j2 * 1000;
        }
        return j2;
    }

    public static int xc(long j2, long j4) {
        int i = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        return 1;
    }

    public static int xg(int i) {
        if (i != 8) {
            if (i != 16) {
                if (i != 24) {
                    if (i != 32) {
                        return 0;
                    }
                    return 805306368;
                }
                return 536870912;
            }
            return 2;
        }
        return 3;
    }

    public static boolean y4(Uri uri) {
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && !"file".equals(scheme)) {
            return false;
        }
        return true;
    }

    public static long y5(long j2) {
        if (j2 == -9223372036854775807L) {
            return System.currentTimeMillis();
        }
        return j2 + SystemClock.elapsedRealtime();
    }

    public static int yc(String str) {
        String v2 = w0.zn.v(str);
        v2.hashCode();
        char c2 = 65535;
        switch (v2.hashCode()) {
            case 104579:
                if (v2.equals("ism")) {
                    c2 = 0;
                    break;
                }
                break;
            case 108321:
                if (v2.equals("mpd")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3242057:
                if (v2.equals("isml")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3299913:
                if (v2.equals("m3u8")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
                return 1;
            case 1:
                return 0;
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    public static int yg(Uri uri) {
        int yc2;
        String scheme = uri.getScheme();
        if (scheme != null && w0.zn.y("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int lastIndexOf = lastPathSegment.lastIndexOf(46);
        if (lastIndexOf >= 0 && (yc2 = yc(lastPathSegment.substring(lastIndexOf + 1))) != 4) {
            return yc2;
        }
        Matcher matcher = f14362i9.matcher((CharSequence) v5.y.v(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String group = matcher.group(2);
        if (group != null) {
            if (group.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (group.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static String[] yk(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        return ro(str.trim(), "(\\s*,\\s*)");
    }

    public static String yt(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return w0.zn.a(networkCountryIso);
            }
        }
        return w0.zn.a(Locale.getDefault().getCountry());
    }

    public static int z(byte[] bArr, int i, int i5, int i6) {
        while (i < i5) {
            i6 = f14368wz[((i6 >>> 24) ^ (bArr[i] & 255)) & 255] ^ (i6 << 8);
            i++;
        }
        return i6;
    }

    @SuppressLint({"InlinedApi"})
    public static int z6(int i) {
        if (i != 12) {
            switch (i) {
                case 1:
                    return 4;
                case 2:
                    return 12;
                case 3:
                    return 28;
                case 4:
                    return 204;
                case 5:
                    return 220;
                case 6:
                    return 252;
                case 7:
                    return 1276;
                case 8:
                    return 6396;
                default:
                    return 0;
            }
        }
        return 743676;
    }

    public static boolean zn(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static <T extends Throwable> void cs(Throwable th) throws Throwable {
        throw th;
    }

    public static <T> T[] f(T[] tArr) {
        return tArr;
    }

    public static <T> T i9(@Nullable T t2) {
        return t2;
    }
}
