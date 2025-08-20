package lw;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kx.z6;
import lw.fb;
import lw.s;
import m1.m;
import m1.ne;
import v5.j5;
import v5.n;
import v5.r;
import v5.vl;
import z0.d0;
/* loaded from: classes.dex */
public final class i9 implements z6.y<c5> {
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final fb f10481v;
    public final s y;

    /* renamed from: fb  reason: collision with root package name */
    public static final Pattern f10445fb = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f10468s = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f10442f = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: t  reason: collision with root package name */
    public static final Pattern f10470t = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: w  reason: collision with root package name */
    public static final Pattern f10474w = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f10461p = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: co  reason: collision with root package name */
    public static final Pattern f10433co = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: z  reason: collision with root package name */
    public static final Pattern f10480z = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f10464r = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: f3  reason: collision with root package name */
    public static final Pattern f10443f3 = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: n  reason: collision with root package name */
    public static final Pattern f10456n = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f10432c = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: d0  reason: collision with root package name */
    public static final Pattern f10436d0 = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: fh  reason: collision with root package name */
    public static final Pattern f10446fh = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f10435d = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: ej  reason: collision with root package name */
    public static final Pattern f10440ej = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: x  reason: collision with root package name */
    public static final Pattern f10475x = zn("CAN-SKIP-DATERANGES");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f10430b = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: j5  reason: collision with root package name */
    public static final Pattern f10450j5 = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: qn  reason: collision with root package name */
    public static final Pattern f10463qn = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f10458o = zn("CAN-BLOCK-RELOAD");

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f10449j = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: oz  reason: collision with root package name */
    public static final Pattern f10460oz = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: ut  reason: collision with root package name */
    public static final Pattern f10473ut = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* renamed from: q9  reason: collision with root package name */
    public static final Pattern f10462q9 = Pattern.compile("LAST-MSN=(\\d+)\\b");

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f10452k = Pattern.compile("LAST-PART=(\\d+)\\b");

    /* renamed from: f7  reason: collision with root package name */
    public static final Pattern f10444f7 = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* renamed from: en  reason: collision with root package name */
    public static final Pattern f10441en = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: jz  reason: collision with root package name */
    public static final Pattern f10451jz = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* renamed from: u  reason: collision with root package name */
    public static final Pattern f10471u = Pattern.compile("BYTERANGE-START=(\\d+)\\b");

    /* renamed from: y5  reason: collision with root package name */
    public static final Pattern f10477y5 = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");

    /* renamed from: xg  reason: collision with root package name */
    public static final Pattern f10476xg = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");

    /* renamed from: dm  reason: collision with root package name */
    public static final Pattern f10437dm = Pattern.compile("KEYFORMAT=\"(.+?)\"");

    /* renamed from: ct  reason: collision with root package name */
    public static final Pattern f10434ct = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");

    /* renamed from: o4  reason: collision with root package name */
    public static final Pattern f10459o4 = Pattern.compile("URI=\"(.+?)\"");

    /* renamed from: rs  reason: collision with root package name */
    public static final Pattern f10467rs = Pattern.compile("IV=([^,.*]+)");

    /* renamed from: eb  reason: collision with root package name */
    public static final Pattern f10439eb = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");

    /* renamed from: lc  reason: collision with root package name */
    public static final Pattern f10454lc = Pattern.compile("TYPE=(PART|MAP)");

    /* renamed from: nf  reason: collision with root package name */
    public static final Pattern f10457nf = Pattern.compile("LANGUAGE=\"(.+?)\"");

    /* renamed from: ra  reason: collision with root package name */
    public static final Pattern f10465ra = Pattern.compile("NAME=\"(.+?)\"");

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f10438e = Pattern.compile("GROUP-ID=\"(.+?)\"");

    /* renamed from: s8  reason: collision with root package name */
    public static final Pattern f10469s8 = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");

    /* renamed from: ap  reason: collision with root package name */
    public static final Pattern f10429ap = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* renamed from: yg  reason: collision with root package name */
    public static final Pattern f10479yg = zn("AUTOSELECT");

    /* renamed from: yc  reason: collision with root package name */
    public static final Pattern f10478yc = zn("DEFAULT");

    /* renamed from: kp  reason: collision with root package name */
    public static final Pattern f10453kp = zn("FORCED");

    /* renamed from: rb  reason: collision with root package name */
    public static final Pattern f10466rb = zn("INDEPENDENT");

    /* renamed from: g3  reason: collision with root package name */
    public static final Pattern f10448g3 = zn("GAP");

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f10455m = zn("PRECISE");

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f10447g = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: u0  reason: collision with root package name */
    public static final Pattern f10472u0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: bk  reason: collision with root package name */
    public static final Pattern f10431bk = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final Queue<String> f10482n3;
        public final BufferedReader y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public String f10483zn;

        public n3(Queue<String> queue, BufferedReader bufferedReader) {
            this.f10482n3 = queue;
            this.y = bufferedReader;
        }

        public String n3() throws IOException {
            if (y()) {
                String str = this.f10483zn;
                this.f10483zn = null;
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean y() throws IOException {
            String trim;
            if (this.f10483zn != null) {
                return true;
            }
            if (!this.f10482n3.isEmpty()) {
                this.f10483zn = (String) v5.y.v(this.f10482n3.poll());
                return true;
            }
            do {
                String readLine = this.y.readLine();
                this.f10483zn = readLine;
                if (readLine != null) {
                    trim = readLine.trim();
                    this.f10483zn = trim;
                } else {
                    return false;
                }
            } while (trim.isEmpty());
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends IOException {
    }

    public i9() {
        this(s.f10484wz, null);
    }

    @Nullable
    public static s.n3 a(ArrayList<s.n3> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            s.n3 n3Var = arrayList.get(i);
            if (str.equals(n3Var.f10496gv)) {
                return n3Var;
            }
        }
        return null;
    }

    public static String c(String str, Pattern pattern, Map<String, String> map) throws ne {
        String x42 = x4(str, pattern, map);
        if (x42 != null) {
            return x42;
        }
        throw ne.v("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    public static int co(String str, Pattern pattern, int i) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt((String) v5.y.v(matcher.group(1)));
        }
        return i;
    }

    public static long d0(String str, Pattern pattern) throws ne {
        return new BigDecimal(c(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    @Nullable
    public static DrmInitData.SchemeData f(String str, String str2, Map<String, String> map) throws ne {
        String r2 = r(str, f10434ct, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String c2 = c(str, f10459o4, map);
            return new DrmInitData.SchemeData(m1.c5.f10604gv, "video/mp4", Base64.decode(c2.substring(c2.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(m1.c5.f10604gv, "hls", j5.ap(str));
        } else {
            if ("com.microsoft.playready".equals(str2) && "1".equals(r2)) {
                String c4 = c(str, f10459o4, map);
                byte[] decode = Base64.decode(c4.substring(c4.indexOf(44)), 0);
                UUID uuid = m1.c5.f10606v;
                return new DrmInitData.SchemeData(uuid, "video/mp4", ha.t.y(uuid, decode));
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int f3(String str) {
        boolean p2 = p(str, f10478yc, false);
        ?? r0 = p2;
        if (p(str, f10453kp, false)) {
            r0 = (p2 ? 1 : 0) | true;
        }
        if (p(str, f10479yg, false)) {
            return r0 | 4;
        }
        return r0;
    }

    @Nullable
    public static s.n3 fb(ArrayList<s.n3> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            s.n3 n3Var = arrayList.get(i);
            if (str.equals(n3Var.f10498v)) {
                return n3Var;
            }
        }
        return null;
    }

    public static String fh(String str, Map<String, String> map) {
        Matcher matcher = f10431bk.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static DrmInitData gv(@Nullable String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i = 0; i < schemeDataArr.length; i++) {
            schemeDataArr2[i] = schemeDataArr[i].n3(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    public static int i4(String str, Map<String, String> map) {
        String x42 = x4(str, f10469s8, map);
        int i = 0;
        if (TextUtils.isEmpty(x42)) {
            return 0;
        }
        String[] ro2 = j5.ro(x42, ",");
        if (j5.co(ro2, "public.accessibility.describes-video")) {
            i = 512;
        }
        if (j5.co(ro2, "public.accessibility.transcribes-spoken-dialog")) {
            i |= 4096;
        }
        if (j5.co(ro2, "public.accessibility.describes-music-and-sound")) {
            i |= 1024;
        }
        if (j5.co(ro2, "public.easy-to-read")) {
            return i | 8192;
        }
        return i;
    }

    public static double i9(String str, Pattern pattern) throws ne {
        return Double.parseDouble(c(str, pattern, Collections.emptyMap()));
    }

    public static double mt(String str, Pattern pattern, double d2) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Double.parseDouble((String) v5.y.v(matcher.group(1)));
        }
        return d2;
    }

    public static fb.a n(String str) {
        long j2;
        long j4;
        double mt2 = mt(str, f10440ej, -9.223372036854776E18d);
        long j6 = -9223372036854775807L;
        if (mt2 == -9.223372036854776E18d) {
            j2 = -9223372036854775807L;
        } else {
            j2 = (long) (mt2 * 1000000.0d);
        }
        boolean p2 = p(str, f10475x, false);
        double mt3 = mt(str, f10450j5, -9.223372036854776E18d);
        if (mt3 == -9.223372036854776E18d) {
            j4 = -9223372036854775807L;
        } else {
            j4 = (long) (mt3 * 1000000.0d);
        }
        double mt4 = mt(str, f10463qn, -9.223372036854776E18d);
        if (mt4 != -9.223372036854776E18d) {
            j6 = (long) (mt4 * 1000000.0d);
        }
        return new fb.a(j2, p2, j4, j6, p(str, f10458o, false));
    }

    public static boolean n3(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int rz2 = rz(bufferedReader, true, read);
        for (int i = 0; i < 7; i++) {
            if (rz2 != "#EXTM3U".charAt(i)) {
                return false;
            }
            rz2 = bufferedReader.read();
        }
        return j5.bk(rz(bufferedReader, false, rz2));
    }

    public static boolean p(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return z2;
    }

    public static String r(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) v5.y.v(matcher.group(1));
        }
        if (!map.isEmpty() && str2 != null) {
            return fh(str2, map);
        }
        return str2;
    }

    public static int rz(BufferedReader bufferedReader, boolean z2, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z2 || !j5.bk(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    @Nullable
    public static s.n3 s(ArrayList<s.n3> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            s.n3 n3Var = arrayList.get(i);
            if (str.equals(n3Var.f10499zn)) {
                return n3Var;
            }
        }
        return null;
    }

    public static String t(String str) {
        if (!"SAMPLE-AES-CENC".equals(str) && !"SAMPLE-AES-CTR".equals(str)) {
            return "cbcs";
        }
        return "cenc";
    }

    public static int tl(String str, Pattern pattern) throws ne {
        return Integer.parseInt(c(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    public static String v(long j2, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null) {
            return str2;
        }
        return Long.toHexString(j2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    public static s w(n3 n3Var, String str) throws IOException {
        char c2;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        ArrayList arrayList3;
        int parseInt;
        String str3;
        int i;
        String str4;
        int i5;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        int i6;
        int i8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        Uri v2;
        HashMap hashMap;
        String str5 = str;
        int i10 = 1;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            String str6 = "application/x-mpegURL";
            if (n3Var.y()) {
                String n32 = n3Var.n3();
                if (n32.startsWith("#EXT")) {
                    arrayList18.add(n32);
                }
                boolean startsWith = n32.startsWith("#EXT-X-I-FRAME-STREAM-INF");
                if (n32.startsWith("#EXT-X-DEFINE")) {
                    hashMap3.put(c(n32, f10465ra, hashMap3), c(n32, f10447g, hashMap3));
                } else {
                    if (n32.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        hashMap = hashMap2;
                        arrayList9 = arrayList12;
                        arrayList8 = arrayList13;
                        arrayList7 = arrayList14;
                        arrayList5 = arrayList15;
                        arrayList10 = arrayList16;
                        arrayList4 = arrayList17;
                        arrayList6 = arrayList18;
                        z2 = true;
                    } else if (n32.startsWith("#EXT-X-MEDIA")) {
                        arrayList16.add(n32);
                    } else if (n32.startsWith("#EXT-X-SESSION-KEY")) {
                        DrmInitData.SchemeData f4 = f(n32, r(n32, f10437dm, "identity", hashMap3), hashMap3);
                        if (f4 != null) {
                            String t2 = t(c(n32, f10476xg, hashMap3));
                            DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[i10];
                            schemeDataArr[0] = f4;
                            arrayList17.add(new DrmInitData(t2, schemeDataArr));
                        }
                    } else if (n32.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                        z3 |= n32.contains("CLOSED-CAPTIONS=NONE");
                        int i11 = startsWith ? 16384 : 0;
                        int tl2 = tl(n32, f10461p);
                        arrayList4 = arrayList17;
                        arrayList5 = arrayList15;
                        int co2 = co(n32, f10445fb, -1);
                        String x42 = x4(n32, f10480z, hashMap3);
                        arrayList6 = arrayList18;
                        String x43 = x4(n32, f10464r, hashMap3);
                        if (x43 != null) {
                            arrayList7 = arrayList14;
                            String[] ro2 = j5.ro(x43, "x");
                            i8 = Integer.parseInt(ro2[0]);
                            i6 = Integer.parseInt(ro2[1]);
                            if (i8 <= 0 || i6 <= 0) {
                                i6 = -1;
                                i8 = -1;
                            }
                            arrayList8 = arrayList13;
                        } else {
                            arrayList7 = arrayList14;
                            arrayList8 = arrayList13;
                            i6 = -1;
                            i8 = -1;
                        }
                        String x44 = x4(n32, f10443f3, hashMap3);
                        float parseFloat = x44 != null ? Float.parseFloat(x44) : -1.0f;
                        arrayList9 = arrayList12;
                        String x45 = x4(n32, f10468s, hashMap3);
                        arrayList10 = arrayList16;
                        String x46 = x4(n32, f10442f, hashMap3);
                        HashMap hashMap4 = hashMap2;
                        String x47 = x4(n32, f10470t, hashMap3);
                        String x48 = x4(n32, f10474w, hashMap3);
                        if (startsWith) {
                            v2 = vl.v(str5, c(n32, f10459o4, hashMap3));
                        } else if (n3Var.y()) {
                            v2 = vl.v(str5, fh(n3Var.n3(), hashMap3));
                        } else {
                            throw ne.v("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        arrayList11.add(new s.n3(v2, new m.n3().j(arrayList11.size()).k5("application/x-mpegURL").x(x42).ud(co2).u(tl2).s8(i8).o(i6).qn(parseFloat).dm(i11).z6(), x45, x46, x47, x48));
                        hashMap = hashMap4;
                        ArrayList arrayList19 = (ArrayList) hashMap.get(v2);
                        if (arrayList19 == null) {
                            arrayList19 = new ArrayList();
                            hashMap.put(v2, arrayList19);
                        }
                        arrayList19.add(new HlsTrackMetadataEntry.VariantInfo(co2, tl2, x45, x46, x47, x48));
                    }
                    hashMap2 = hashMap;
                    arrayList17 = arrayList4;
                    arrayList15 = arrayList5;
                    arrayList18 = arrayList6;
                    arrayList14 = arrayList7;
                    arrayList13 = arrayList8;
                    arrayList12 = arrayList9;
                    arrayList16 = arrayList10;
                    i10 = 1;
                    str5 = str;
                }
                hashMap = hashMap2;
                arrayList9 = arrayList12;
                arrayList8 = arrayList13;
                arrayList7 = arrayList14;
                arrayList5 = arrayList15;
                arrayList10 = arrayList16;
                arrayList4 = arrayList17;
                arrayList6 = arrayList18;
                hashMap2 = hashMap;
                arrayList17 = arrayList4;
                arrayList15 = arrayList5;
                arrayList18 = arrayList6;
                arrayList14 = arrayList7;
                arrayList13 = arrayList8;
                arrayList12 = arrayList9;
                arrayList16 = arrayList10;
                i10 = 1;
                str5 = str;
            } else {
                HashMap hashMap5 = hashMap2;
                ArrayList arrayList20 = arrayList12;
                ArrayList arrayList21 = arrayList13;
                ArrayList arrayList22 = arrayList14;
                ArrayList arrayList23 = arrayList15;
                ArrayList arrayList24 = arrayList16;
                ArrayList arrayList25 = arrayList17;
                ArrayList arrayList26 = arrayList18;
                ArrayList arrayList27 = new ArrayList();
                HashSet hashSet = new HashSet();
                int i12 = 0;
                while (i12 < arrayList11.size()) {
                    s.n3 n3Var2 = (s.n3) arrayList11.get(i12);
                    if (hashSet.add(n3Var2.y)) {
                        v5.y.fb(n3Var2.f10497n3.f10972z == null);
                        i5 = 1;
                        arrayList27.add(n3Var2.y(n3Var2.f10497n3.n3().en(new Metadata(new HlsTrackMetadataEntry(null, null, (List) v5.y.v((ArrayList) hashMap5.get(n3Var2.y))))).z6()));
                    } else {
                        i5 = 1;
                    }
                    i12 += i5;
                }
                Uri uri = null;
                ArrayList arrayList28 = null;
                m mVar = null;
                int i13 = 0;
                while (i13 < arrayList24.size()) {
                    ArrayList arrayList29 = arrayList24;
                    String str7 = (String) arrayList29.get(i13);
                    String c4 = c(str7, f10438e, hashMap3);
                    String c6 = c(str7, f10465ra, hashMap3);
                    m.n3 k2 = new m.n3().oz(c4 + ":" + c6).q9(c6).k5(str6).eb(f3(str7)).dm(i4(str7, hashMap3)).k(x4(str7, f10457nf, hashMap3));
                    String x49 = x4(str7, f10459o4, hashMap3);
                    Uri v3 = x49 == null ? uri : vl.v(str, x49);
                    String str8 = str6;
                    arrayList24 = arrayList29;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(c4, c6, Collections.emptyList()));
                    String c7 = c(str7, f10439eb, hashMap3);
                    c7.hashCode();
                    switch (c7.hashCode()) {
                        case -959297733:
                            if (c7.equals("SUBTITLES")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -333210994:
                            if (c7.equals("CLOSED-CAPTIONS")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 62628790:
                            if (c7.equals("AUDIO")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 81665115:
                            if (c7.equals("VIDEO")) {
                                c2 = 3;
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
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            s.n3 fb2 = fb(arrayList11, c4);
                            if (fb2 != null) {
                                String b2 = j5.b(fb2.f10497n3.f10942co, 3);
                                k2.x(b2);
                                str2 = n.fb(b2);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "text/vtt";
                            }
                            k2.o4(str2).en(metadata);
                            if (v3 != null) {
                                s.y yVar = new s.y(v3, k2.z6(), c4, c6);
                                arrayList3 = arrayList22;
                                arrayList3.add(yVar);
                            } else {
                                arrayList3 = arrayList22;
                                r.c5("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                            }
                            i = 1;
                            i13 += i;
                            arrayList20 = arrayList2;
                            arrayList22 = arrayList3;
                            arrayList21 = arrayList;
                            str6 = str8;
                            uri = null;
                        case 1:
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            String c8 = c(str7, f10429ap, hashMap3);
                            if (c8.startsWith("CC")) {
                                parseInt = Integer.parseInt(c8.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                parseInt = Integer.parseInt(c8.substring(7));
                                str3 = "application/cea-708";
                            }
                            if (arrayList28 == null) {
                                arrayList28 = new ArrayList();
                            }
                            k2.o4(str3).ej(parseInt);
                            arrayList28.add(k2.z6());
                            arrayList3 = arrayList22;
                            i = 1;
                            i13 += i;
                            arrayList20 = arrayList2;
                            arrayList22 = arrayList3;
                            arrayList21 = arrayList;
                            str6 = str8;
                            uri = null;
                        case 2:
                            arrayList2 = arrayList20;
                            s.n3 a2 = a(arrayList11, c4);
                            if (a2 != null) {
                                String b3 = j5.b(a2.f10497n3.f10942co, 1);
                                k2.x(b3);
                                str4 = n.fb(b3);
                            } else {
                                str4 = null;
                            }
                            String x410 = x4(str7, f10433co, hashMap3);
                            if (x410 != null) {
                                k2.a8(Integer.parseInt(j5.ix(x410, "/")[0]));
                                if ("audio/eac3".equals(str4) && x410.endsWith("/JOC")) {
                                    k2.x("ec+3");
                                    str4 = "audio/eac3-joc";
                                }
                            }
                            k2.o4(str4);
                            if (v3 != null) {
                                k2.en(metadata);
                                arrayList = arrayList21;
                                arrayList.add(new s.y(v3, k2.z6(), c4, c6));
                            } else {
                                arrayList = arrayList21;
                                if (a2 != null) {
                                    mVar = k2.z6();
                                    arrayList3 = arrayList22;
                                    i = 1;
                                    i13 += i;
                                    arrayList20 = arrayList2;
                                    arrayList22 = arrayList3;
                                    arrayList21 = arrayList;
                                    str6 = str8;
                                    uri = null;
                                }
                            }
                            arrayList3 = arrayList22;
                            i = 1;
                            i13 += i;
                            arrayList20 = arrayList2;
                            arrayList22 = arrayList3;
                            arrayList21 = arrayList;
                            str6 = str8;
                            uri = null;
                            break;
                        case 3:
                            s.n3 s2 = s(arrayList11, c4);
                            if (s2 != null) {
                                m mVar2 = s2.f10497n3;
                                String b4 = j5.b(mVar2.f10942co, 2);
                                k2.x(b4).o4(n.fb(b4)).s8(mVar2.f10943d).o(mVar2.f10945ej).qn(mVar2.f10969x);
                            }
                            if (v3 != null) {
                                k2.en(metadata);
                                arrayList2 = arrayList20;
                                arrayList2.add(new s.y(v3, k2.z6(), c4, c6));
                                arrayList3 = arrayList22;
                                arrayList = arrayList21;
                                i = 1;
                                i13 += i;
                                arrayList20 = arrayList2;
                                arrayList22 = arrayList3;
                                arrayList21 = arrayList;
                                str6 = str8;
                                uri = null;
                            }
                            arrayList3 = arrayList22;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            i = 1;
                            i13 += i;
                            arrayList20 = arrayList2;
                            arrayList22 = arrayList3;
                            arrayList21 = arrayList;
                            str6 = str8;
                            uri = null;
                        default:
                            arrayList3 = arrayList22;
                            arrayList = arrayList21;
                            arrayList2 = arrayList20;
                            i = 1;
                            i13 += i;
                            arrayList20 = arrayList2;
                            arrayList22 = arrayList3;
                            arrayList21 = arrayList;
                            str6 = str8;
                            uri = null;
                    }
                }
                return new s(str, arrayList26, arrayList27, arrayList20, arrayList21, arrayList22, arrayList23, mVar, z3 ? Collections.emptyList() : arrayList28, z2, hashMap3, arrayList25);
            }
        }
    }

    public static long wz(String str, Pattern pattern) throws ne {
        return Long.parseLong(c(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    public static String x4(String str, Pattern pattern, Map<String, String> map) {
        return r(str, pattern, null, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static fb xc(s sVar, @Nullable fb fbVar, n3 n3Var, String str) throws IOException {
        boolean z2;
        List<fb.n3> list;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        long j2;
        int i;
        fb.n3 n3Var2;
        boolean z3;
        int i5;
        String x42;
        long j4;
        long j6;
        Object obj;
        fb.gv gvVar;
        boolean z4;
        long j7;
        long j8;
        long j9;
        s sVar2 = sVar;
        fb fbVar2 = fbVar;
        boolean z5 = sVar2.f10388zn;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        fb.a aVar = new fb.a(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        boolean z7 = false;
        String str3 = "";
        boolean z8 = z5;
        fb.a aVar2 = aVar;
        String str4 = str3;
        int i6 = 0;
        String str5 = null;
        long j10 = -9223372036854775807L;
        boolean z9 = false;
        long j11 = 0;
        boolean z10 = false;
        int i8 = 0;
        long j12 = 0;
        int i10 = 1;
        long j13 = -9223372036854775807L;
        long j14 = -9223372036854775807L;
        boolean z11 = false;
        DrmInitData drmInitData = null;
        long j15 = 0;
        Object obj2 = null;
        long j16 = 0;
        boolean z12 = false;
        long j17 = -1;
        String str6 = null;
        String str7 = null;
        int i11 = 0;
        long j18 = 0;
        long j19 = 0;
        boolean z13 = false;
        fb.gv gvVar2 = null;
        long j20 = 0;
        long j21 = 0;
        ArrayList arrayList7 = arrayList4;
        fb.n3 n3Var3 = null;
        while (n3Var.y()) {
            String n32 = n3Var.n3();
            if (n32.startsWith("#EXT")) {
                arrayList6.add(n32);
            }
            if (n32.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String c2 = c(n32, f10435d, hashMap);
                if ("VOD".equals(c2)) {
                    i6 = 1;
                } else if ("EVENT".equals(c2)) {
                    i6 = 2;
                }
            } else if (n32.equals("#EXT-X-I-FRAMES-ONLY")) {
                z13 = true;
            } else if (n32.startsWith("#EXT-X-START")) {
                j10 = (long) (i9(n32, f10444f7) * 1000000.0d);
                z9 = p(n32, f10455m, z7);
            } else if (n32.startsWith("#EXT-X-SERVER-CONTROL")) {
                aVar2 = n(n32);
            } else if (n32.startsWith("#EXT-X-PART-INF")) {
                j14 = (long) (i9(n32, f10436d0) * 1000000.0d);
            } else if (n32.startsWith("#EXT-X-MAP")) {
                String c4 = c(n32, f10459o4, hashMap);
                String x43 = x4(n32, f10451jz, hashMap);
                if (x43 != null) {
                    String[] ro2 = j5.ro(x43, "@");
                    j17 = Long.parseLong(ro2[z7 ? 1 : 0]);
                    if (ro2.length > 1) {
                        j15 = Long.parseLong(ro2[1]);
                    }
                }
                int i12 = (j17 > (-1L) ? 1 : (j17 == (-1L) ? 0 : -1));
                if (i12 == 0) {
                    j15 = 0;
                }
                String str8 = str6;
                if (str5 != null && str8 == null) {
                    throw ne.v("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                gvVar2 = new fb.gv(c4, j15, j17, str5, str8);
                if (i12 != 0) {
                    j15 += j17;
                }
                str6 = str8;
                j17 = -1;
            } else {
                String str9 = str6;
                if (n32.startsWith("#EXT-X-TARGETDURATION")) {
                    j13 = 1000000 * tl(n32, f10456n);
                } else {
                    if (n32.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        j19 = wz(n32, f10449j);
                        str6 = str9;
                        j12 = j19;
                    } else if (n32.startsWith("#EXT-X-VERSION")) {
                        i10 = tl(n32, f10446fh);
                    } else {
                        if (n32.startsWith("#EXT-X-DEFINE")) {
                            String x44 = x4(n32, f10472u0, hashMap);
                            if (x44 != null) {
                                String str10 = sVar2.f10492t.get(x44);
                                if (str10 != null) {
                                    hashMap.put(x44, str10);
                                }
                            } else {
                                hashMap.put(c(n32, f10465ra, hashMap), c(n32, f10447g, hashMap));
                            }
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            str2 = str7;
                            j2 = j19;
                            i = i6;
                        } else if (n32.startsWith("#EXTINF")) {
                            j20 = d0(n32, f10460oz);
                            str4 = r(n32, f10473ut, str3, hashMap);
                        } else {
                            String str11 = str3;
                            if (n32.startsWith("#EXT-X-SKIP")) {
                                int tl2 = tl(n32, f10430b);
                                if (fbVar2 != null && arrayList3.isEmpty()) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                v5.y.fb(z3);
                                int i13 = (int) (j12 - ((fb) j5.i9(fbVar)).f10392f);
                                int i14 = tl2 + i13;
                                if (i13 >= 0 && i14 <= fbVar2.f10396mt.size()) {
                                    str3 = str11;
                                    String str12 = str9;
                                    long j22 = j18;
                                    while (i13 < i14) {
                                        fb.gv gvVar3 = fbVar2.f10396mt.get(i13);
                                        ArrayList arrayList8 = arrayList7;
                                        ArrayList arrayList9 = arrayList6;
                                        if (j12 != fbVar2.f10392f) {
                                            gvVar3 = gvVar3.n3(j22, (fbVar2.f10395i9 - i8) + gvVar3.f10421s);
                                        }
                                        arrayList3.add(gvVar3);
                                        j22 += gvVar3.f10418fb;
                                        long j23 = gvVar3.f10425z;
                                        if (j23 != -1) {
                                            i5 = i14;
                                            j15 = gvVar3.f10416co + j23;
                                        } else {
                                            i5 = i14;
                                        }
                                        int i15 = gvVar3.f10421s;
                                        fb.gv gvVar4 = gvVar3.f10423v;
                                        Object obj3 = gvVar3.f10422t;
                                        String str13 = gvVar3.f10424w;
                                        String str14 = gvVar3.f10419p;
                                        if (str14 == null || !str14.equals(Long.toHexString(j19))) {
                                            str12 = gvVar3.f10419p;
                                        }
                                        j19++;
                                        i13++;
                                        fbVar2 = fbVar;
                                        obj2 = obj3;
                                        str5 = str13;
                                        j16 = j22;
                                        i14 = i5;
                                        i11 = i15;
                                        gvVar2 = gvVar4;
                                        arrayList7 = arrayList8;
                                        arrayList6 = arrayList9;
                                    }
                                    sVar2 = sVar;
                                    fbVar2 = fbVar;
                                    j18 = j22;
                                    str6 = str12;
                                } else {
                                    throw new y();
                                }
                            } else {
                                ArrayList arrayList10 = arrayList7;
                                arrayList2 = arrayList6;
                                str3 = str11;
                                if (n32.startsWith("#EXT-X-KEY")) {
                                    String c6 = c(n32, f10476xg, hashMap);
                                    String r2 = r(n32, f10437dm, "identity", hashMap);
                                    if ("NONE".equals(c6)) {
                                        treeMap.clear();
                                        x42 = null;
                                        str5 = null;
                                    } else {
                                        x42 = x4(n32, f10467rs, hashMap);
                                        if ("identity".equals(r2)) {
                                            if ("AES-128".equals(c6)) {
                                                str5 = c(n32, f10459o4, hashMap);
                                                sVar2 = sVar;
                                                fbVar2 = fbVar;
                                                str6 = x42;
                                            }
                                        } else {
                                            String str15 = str7;
                                            if (str15 == null) {
                                                str7 = t(c6);
                                            } else {
                                                str7 = str15;
                                            }
                                            DrmInitData.SchemeData f4 = f(n32, r2, hashMap);
                                            if (f4 != null) {
                                                treeMap.put(r2, f4);
                                                str5 = null;
                                            }
                                        }
                                        str5 = null;
                                        sVar2 = sVar;
                                        fbVar2 = fbVar;
                                        str6 = x42;
                                    }
                                    obj2 = str5;
                                    sVar2 = sVar;
                                    fbVar2 = fbVar;
                                    str6 = x42;
                                } else {
                                    String str16 = str7;
                                    if (n32.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] ro3 = j5.ro(c(n32, f10441en, hashMap), "@");
                                        j17 = Long.parseLong(ro3[0]);
                                        if (ro3.length > 1) {
                                            j15 = Long.parseLong(ro3[1]);
                                        }
                                    } else if (n32.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i8 = Integer.parseInt(n32.substring(n32.indexOf(58) + 1));
                                        sVar2 = sVar;
                                        fbVar2 = fbVar;
                                        str7 = str16;
                                        str6 = str9;
                                        arrayList7 = arrayList10;
                                        arrayList6 = arrayList2;
                                        z7 = false;
                                        z10 = true;
                                    } else if (n32.equals("#EXT-X-DISCONTINUITY")) {
                                        i11++;
                                    } else {
                                        if (n32.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                            if (j11 == 0) {
                                                j11 = j5.xb(j5.gq(n32.substring(n32.indexOf(58) + 1))) - j18;
                                            } else {
                                                i = i6;
                                                str2 = str16;
                                            }
                                        } else if (n32.equals("#EXT-X-GAP")) {
                                            sVar2 = sVar;
                                            fbVar2 = fbVar;
                                            str7 = str16;
                                            str6 = str9;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z7 = false;
                                            z12 = true;
                                        } else if (n32.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            sVar2 = sVar;
                                            fbVar2 = fbVar;
                                            str7 = str16;
                                            str6 = str9;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z7 = false;
                                            z8 = true;
                                        } else if (n32.equals("#EXT-X-ENDLIST")) {
                                            sVar2 = sVar;
                                            fbVar2 = fbVar;
                                            str7 = str16;
                                            str6 = str9;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z7 = false;
                                            z11 = true;
                                        } else if (n32.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            i = i6;
                                            str2 = str16;
                                            arrayList5.add(new fb.zn(Uri.parse(vl.gv(str, c(n32, f10459o4, hashMap))), z(n32, f10462q9, -1L), co(n32, f10452k, -1)));
                                        } else {
                                            i = i6;
                                            str2 = str16;
                                            if (n32.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                if (n3Var3 == null && "PART".equals(c(n32, f10454lc, hashMap))) {
                                                    String c7 = c(n32, f10459o4, hashMap);
                                                    long z14 = z(n32, f10471u, -1L);
                                                    long z15 = z(n32, f10477y5, -1L);
                                                    long j24 = j19;
                                                    String v2 = v(j24, str5, str9);
                                                    if (obj2 == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        Object drmInitData2 = new DrmInitData(str2, schemeDataArr);
                                                        if (drmInitData == null) {
                                                            drmInitData = gv(str2, schemeDataArr);
                                                        }
                                                        obj2 = drmInitData2;
                                                    }
                                                    int i16 = (z14 > (-1L) ? 1 : (z14 == (-1L) ? 0 : -1));
                                                    if (i16 == 0 || z15 != -1) {
                                                        if (i16 != 0) {
                                                            j9 = z14;
                                                        } else {
                                                            j9 = 0;
                                                        }
                                                        n3Var3 = new fb.n3(c7, gvVar2, 0L, i11, j16, obj2, str5, v2, j9, z15, false, false, true);
                                                    }
                                                    sVar2 = sVar;
                                                    fbVar2 = fbVar;
                                                    j19 = j24;
                                                    str6 = str9;
                                                    arrayList7 = arrayList10;
                                                    i6 = i;
                                                    arrayList6 = arrayList2;
                                                    str7 = str2;
                                                }
                                            } else {
                                                j2 = j19;
                                                if (n32.startsWith("#EXT-X-PART")) {
                                                    String v3 = v(j2, str5, str9);
                                                    String c8 = c(n32, f10459o4, hashMap);
                                                    long i92 = (long) (i9(n32, f10432c) * 1000000.0d);
                                                    n3Var2 = n3Var3;
                                                    boolean p2 = p(n32, f10466rb, false);
                                                    if (z8 && arrayList10.isEmpty()) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    boolean z16 = p2 | z4;
                                                    boolean p3 = p(n32, f10448g3, false);
                                                    String x45 = x4(n32, f10451jz, hashMap);
                                                    if (x45 != null) {
                                                        String[] ro4 = j5.ro(x45, "@");
                                                        j8 = Long.parseLong(ro4[0]);
                                                        if (ro4.length > 1) {
                                                            j21 = Long.parseLong(ro4[1]);
                                                        }
                                                        j7 = -1;
                                                    } else {
                                                        j7 = -1;
                                                        j8 = -1;
                                                    }
                                                    int i17 = (j8 > j7 ? 1 : (j8 == j7 ? 0 : -1));
                                                    if (i17 == 0) {
                                                        j21 = 0;
                                                    }
                                                    if (obj2 == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        Object drmInitData3 = new DrmInitData(str2, schemeDataArr2);
                                                        if (drmInitData == null) {
                                                            drmInitData = gv(str2, schemeDataArr2);
                                                        }
                                                        obj2 = drmInitData3;
                                                    }
                                                    arrayList = arrayList10;
                                                    arrayList.add(new fb.n3(c8, gvVar2, i92, i11, j16, obj2, str5, v3, j21, j8, p3, z16, false));
                                                    j16 += i92;
                                                    if (i17 != 0) {
                                                        j21 += j8;
                                                    }
                                                } else {
                                                    n3Var2 = n3Var3;
                                                    arrayList = arrayList10;
                                                    if (!n32.startsWith("#")) {
                                                        String v4 = v(j2, str5, str9);
                                                        long j25 = j2 + 1;
                                                        String fh2 = fh(n32, hashMap);
                                                        fb.gv gvVar5 = (fb.gv) hashMap2.get(fh2);
                                                        int i18 = (j17 > (-1L) ? 1 : (j17 == (-1L) ? 0 : -1));
                                                        if (i18 == 0) {
                                                            j4 = 0;
                                                        } else {
                                                            if (z13 && gvVar2 == null && gvVar5 == null) {
                                                                gvVar5 = new fb.gv(fh2, 0L, j15, null, null);
                                                                hashMap2.put(fh2, gvVar5);
                                                            }
                                                            j4 = j15;
                                                        }
                                                        if (obj2 == null && !treeMap.isEmpty()) {
                                                            j6 = j25;
                                                            DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            Object drmInitData4 = new DrmInitData(str2, schemeDataArr3);
                                                            obj = drmInitData4;
                                                            if (drmInitData == null) {
                                                                drmInitData = gv(str2, schemeDataArr3);
                                                                obj = drmInitData4;
                                                            }
                                                        } else {
                                                            j6 = j25;
                                                            obj = obj2;
                                                        }
                                                        if (gvVar2 != null) {
                                                            gvVar = gvVar2;
                                                        } else {
                                                            gvVar = gvVar5;
                                                        }
                                                        arrayList3.add(new fb.gv(fh2, gvVar, str4, j20, i11, j18, obj, str5, v4, j4, j17, z12, arrayList));
                                                        j16 = j18 + j20;
                                                        arrayList7 = new ArrayList();
                                                        if (i18 != 0) {
                                                            j4 += j17;
                                                        }
                                                        j15 = j4;
                                                        sVar2 = sVar;
                                                        fbVar2 = fbVar;
                                                        str6 = str9;
                                                        obj2 = obj;
                                                        str4 = str3;
                                                        j18 = j16;
                                                        i6 = i;
                                                        n3Var3 = n3Var2;
                                                        arrayList6 = arrayList2;
                                                        z12 = false;
                                                        j17 = -1;
                                                        j20 = 0;
                                                        str7 = str2;
                                                        j19 = j6;
                                                    }
                                                }
                                                sVar2 = sVar;
                                                fbVar2 = fbVar;
                                                str6 = str9;
                                                i6 = i;
                                                n3Var3 = n3Var2;
                                                j19 = j2;
                                                str7 = str2;
                                                arrayList7 = arrayList;
                                                arrayList6 = arrayList2;
                                            }
                                        }
                                        arrayList = arrayList10;
                                        j2 = j19;
                                    }
                                    sVar2 = sVar;
                                    fbVar2 = fbVar;
                                    str7 = str16;
                                    str6 = str9;
                                }
                                arrayList7 = arrayList10;
                                arrayList6 = arrayList2;
                            }
                        }
                        n3Var2 = n3Var3;
                        sVar2 = sVar;
                        fbVar2 = fbVar;
                        str6 = str9;
                        i6 = i;
                        n3Var3 = n3Var2;
                        j19 = j2;
                        str7 = str2;
                        arrayList7 = arrayList;
                        arrayList6 = arrayList2;
                    }
                    z7 = false;
                }
                str6 = str9;
                z7 = false;
            }
        }
        int i19 = i6;
        fb.n3 n3Var4 = n3Var3;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList6;
        HashMap hashMap3 = new HashMap();
        for (int i20 = 0; i20 < arrayList5.size(); i20++) {
            fb.zn znVar = (fb.zn) arrayList5.get(i20);
            long j26 = znVar.f10426n3;
            if (j26 == -1) {
                j26 = (j12 + arrayList3.size()) - (arrayList11.isEmpty() ? 1L : 0L);
            }
            int i21 = znVar.f10427zn;
            if (i21 == -1 && j14 != -9223372036854775807L) {
                if (arrayList11.isEmpty()) {
                    list = ((fb.gv) d0.v(arrayList3)).f10413n;
                } else {
                    list = arrayList11;
                }
                i21 = list.size() - 1;
            }
            Uri uri = znVar.y;
            hashMap3.put(uri, new fb.zn(uri, j26, i21));
        }
        if (n3Var4 != null) {
            arrayList11.add(n3Var4);
        }
        if (j11 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        return new fb(i19, str, arrayList12, j10, z9, j11, z10, i8, j12, i10, j13, j14, z8, z11, z2, drmInitData, arrayList3, arrayList11, aVar2, hashMap3);
    }

    public static long z(String str, Pattern pattern, long j2) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Long.parseLong((String) v5.y.v(matcher.group(1)));
        }
        return j2;
    }

    public static Pattern zn(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    @Override // kx.z6.y
    /* renamed from: c5 */
    public c5 y(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (n3(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (trim.startsWith("#EXT-X-STREAM-INF")) {
                                arrayDeque.add(trim);
                                return w(new n3(arrayDeque, bufferedReader), uri.toString());
                            } else if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                break;
                            } else {
                                arrayDeque.add(trim);
                            }
                        }
                    } else {
                        j5.wz(bufferedReader);
                        throw ne.v("Failed to parse the playlist, could not identify any tags.", null);
                    }
                }
                arrayDeque.add(trim);
                return xc(this.y, this.f10481v, new n3(arrayDeque, bufferedReader), uri.toString());
            }
            throw ne.v("Input does not start with the #EXTM3U header.", null);
        } finally {
            j5.wz(bufferedReader);
        }
    }

    public i9(s sVar, @Nullable fb fbVar) {
        this.y = sVar;
        this.f10481v = fbVar;
    }
}
