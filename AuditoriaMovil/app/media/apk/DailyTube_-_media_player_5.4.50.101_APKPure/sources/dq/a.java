package dq;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import dq.wz;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kx.z6;
import m1.m;
import m1.ne;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import v5.j5;
import v5.n;
import v5.qn;
import v5.r;
import v5.vl;
import z0.mg;
import z0.x4;
/* loaded from: classes.dex */
public class a extends DefaultHandler implements z6.y<zn> {
    public final XmlPullParserFactory y;

    /* renamed from: v  reason: collision with root package name */
    public static final Pattern f7345v = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: fb  reason: collision with root package name */
    public static final Pattern f7343fb = Pattern.compile("CC([1-4])=.*");

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f7344s = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f7342f = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<fb> f7346a;

        /* renamed from: c5  reason: collision with root package name */
        public final List<fb> f7347c5;

        /* renamed from: fb  reason: collision with root package name */
        public final long f7348fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final String f7349gv;

        /* renamed from: n3  reason: collision with root package name */
        public final x4<n3> f7350n3;

        /* renamed from: s  reason: collision with root package name */
        public final List<fb> f7351s;

        /* renamed from: v  reason: collision with root package name */
        public final ArrayList<DrmInitData.SchemeData> f7352v;
        public final m y;

        /* renamed from: zn  reason: collision with root package name */
        public final wz f7353zn;

        public y(m mVar, List<n3> list, wz wzVar, @Nullable String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<fb> arrayList2, List<fb> list2, List<fb> list3, long j2) {
            this.y = mVar;
            this.f7350n3 = x4.d(list);
            this.f7353zn = wzVar;
            this.f7349gv = str;
            this.f7352v = arrayList;
            this.f7346a = arrayList2;
            this.f7351s = list2;
            this.f7347c5 = list3;
            this.f7348fb = j2;
        }
    }

    public a() {
        try {
            this.y = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a8(XmlPullParser xmlPullParser) {
        char c2;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null) {
            return -1;
        }
        String v2 = w0.zn.v(attributeValue);
        v2.hashCode();
        switch (v2.hashCode()) {
            case 1596796:
                if (v2.equals("4000")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 2937391:
                if (v2.equals("a000")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3094035:
                if (v2.equals("f801")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3133436:
                if (v2.equals("fa01")) {
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
                return 1;
            case 1:
                return 2;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return -1;
        }
    }

    public static int b(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    public static void co(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.zn()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i).y(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public static long ej(XmlPullParser xmlPullParser, String str, long j2) throws ne {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j2;
        }
        return j5.gq(attributeValue);
    }

    public static int en(XmlPullParser xmlPullParser) {
        int oz2 = oz(xmlPullParser, "value", -1);
        if (oz2 < 0) {
            return -1;
        }
        int[] iArr = f7342f;
        if (oz2 >= iArr.length) {
            return -1;
        }
        return iArr[oz2];
    }

    public static void i4(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (!qn.v(xmlPullParser)) {
            return;
        }
        int i = 1;
        while (i != 0) {
            xmlPullParser.next();
            if (qn.v(xmlPullParser)) {
                i++;
            } else if (qn.zn(xmlPullParser)) {
                i--;
            }
        }
    }

    public static long k(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Long.parseLong(attributeValue);
        }
        return j2;
    }

    public static long k5(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j2;
        }
        return j5.vp(attributeValue);
    }

    public static String kp(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return attributeValue;
        }
        return str2;
    }

    public static int mg(List<fb> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            fb fbVar = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(fbVar.y) && (str = fbVar.f7361n3) != null) {
                Matcher matcher = f7343fb.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                r.c5("MpdParser", "Unable to parse CEA-608 channel number from: " + fbVar.f7361n3);
            }
        }
        return -1;
    }

    public static void mt(ArrayList<DrmInitData.SchemeData> arrayList) {
        String str;
        int i = 0;
        while (true) {
            if (i < arrayList.size()) {
                DrmInitData.SchemeData schemeData = arrayList.get(i);
                if (m1.c5.f10607zn.equals(schemeData.f4120v) && (str = schemeData.f4118fb) != null) {
                    arrayList.remove(i);
                    break;
                }
                i++;
            } else {
                str = null;
                break;
            }
        }
        if (str == null) {
            return;
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            DrmInitData.SchemeData schemeData2 = arrayList.get(i5);
            if (m1.c5.f10605n3.equals(schemeData2.f4120v) && schemeData2.f4118fb == null) {
                arrayList.set(i5, new DrmInitData.SchemeData(m1.c5.f10607zn, str, schemeData2.f4119s, schemeData2.f4117f));
            }
        }
    }

    private long n3(List<wz.gv> list, long j2, long j4, int i, long j6) {
        int tl2;
        if (i >= 0) {
            tl2 = i + 1;
        } else {
            tl2 = (int) j5.tl(j6 - j2, j4);
        }
        for (int i5 = 0; i5 < tl2; i5++) {
            list.add(tl(j2, j4));
            j2 += j4;
        }
        return j2;
    }

    public static float o(XmlPullParser xmlPullParser, float f4) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = f7345v.matcher(attributeValue);
            if (matcher.matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                String group = matcher.group(2);
                if (!TextUtils.isEmpty(group)) {
                    return parseInt / Integer.parseInt(group);
                }
                return parseInt;
            }
            return f4;
        }
        return f4;
    }

    public static int oz(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Integer.parseInt(attributeValue);
        }
        return i;
    }

    @Nullable
    public static String p(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        v5.y.fb(str.equals(str2));
        return str;
    }

    public static long q9(List<fb> list) {
        for (int i = 0; i < list.size(); i++) {
            fb fbVar = list.get(i);
            if (w0.zn.y("http://dashif.org/guidelines/last-segment-number", fbVar.y)) {
                return Long.parseLong(fbVar.f7361n3);
            }
        }
        return -1L;
    }

    public static float qn(XmlPullParser xmlPullParser, String str, float f4) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Float.parseFloat(attributeValue);
        }
        return f4;
    }

    @Nullable
    public static String r(@Nullable String str, @Nullable String str2) {
        if (n.xc(str)) {
            return n.zn(str2);
        }
        if (n.co(str)) {
            return n.wz(str2);
        }
        if (n.mt(str)) {
            return str;
        }
        if (n.w(str)) {
            return str;
        }
        if ("application/mp4".equals(str)) {
            String fb2 = n.fb(str2);
            if ("text/vtt".equals(fb2)) {
                return "application/x-mp4-vtt";
            }
            return fb2;
        }
        return null;
    }

    public static String rb(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                i4(xmlPullParser);
            }
        } while (!qn.gv(xmlPullParser, str));
        return str2;
    }

    public static int ta(List<fb> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            fb fbVar = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(fbVar.y) && (str = fbVar.f7361n3) != null) {
                Matcher matcher = f7344s.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                r.c5("MpdParser", "Unable to parse CEA-708 service block number from: " + fbVar.f7361n3);
            }
        }
        return -1;
    }

    public static fb ud(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String kp2 = kp(xmlPullParser, "schemeIdUri", "");
        String kp3 = kp(xmlPullParser, "value", null);
        String kp4 = kp(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!qn.gv(xmlPullParser, str));
        return new fb(kp2, kp3, kp4);
    }

    public static int w(int i, int i5) {
        boolean z2;
        if (i == -1) {
            return i5;
        }
        if (i5 == -1) {
            return i;
        }
        if (i == i5) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        return i;
    }

    public static int x(XmlPullParser xmlPullParser) {
        int oz2 = oz(xmlPullParser, "value", -1);
        if (oz2 <= 0 || oz2 >= 33) {
            return -1;
        }
        return oz2;
    }

    private boolean x4(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    public static String yt(List<fb> list) {
        for (int i = 0; i < list.size(); i++) {
            fb fbVar = list.get(i);
            String str = fbVar.y;
            if (!"tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) || !"JOC".equals(fbVar.f7361n3)) {
                if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(fbVar.f7361n3)) {
                    return "audio/eac3-joc";
                }
            } else {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    public static long z(long j2, long j4) {
        if (j4 != -9223372036854775807L) {
            j2 = j4;
        }
        if (j2 == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j2;
    }

    public m a(@Nullable String str, @Nullable String str2, int i, int i5, float f4, int i6, int i8, int i10, @Nullable String str3, List<fb> list, List<fb> list2, @Nullable String str4, List<fb> list3, List<fb> list4) {
        int i11;
        int i12;
        String str5 = str4;
        String r2 = r(str2, str5);
        if ("audio/eac3".equals(r2)) {
            r2 = yt(list4);
            if ("audio/eac3-joc".equals(r2)) {
                str5 = "ec+3";
            }
        }
        int yg2 = yg(list);
        int eb2 = eb(list) | ct(list2) | rs(list3) | rs(list4);
        Pair<Integer, Integer> g32 = g3(list3);
        m.n3 k2 = new m.n3().oz(str).k5(str2).o4(r2).x(str5).u(i10).eb(yg2).dm(eb2).k(str3);
        int i13 = -1;
        if (g32 != null) {
            i11 = ((Integer) g32.first).intValue();
        } else {
            i11 = -1;
        }
        m.n3 ra2 = k2.ra(i11);
        if (g32 != null) {
            i12 = ((Integer) g32.second).intValue();
        } else {
            i12 = -1;
        }
        m.n3 e2 = ra2.e(i12);
        if (n.co(r2)) {
            e2.s8(i).o(i5).qn(f4);
        } else if (n.xc(r2)) {
            e2.a8(i6).rs(i8);
        } else if (n.mt(r2)) {
            if ("application/cea-608".equals(r2)) {
                i13 = mg(list2);
            } else if ("application/cea-708".equals(r2)) {
                i13 = ta(list2);
            }
            e2.ej(i13);
        } else if (n.w(r2)) {
            e2.s8(i).o(i5);
        }
        return e2.z6();
    }

    public int ap(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        if (!str.equals("forced_subtitle") && !str.equals("forced-subtitle")) {
            return 0;
        }
        return 2;
    }

    public void c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        i4(xmlPullParser);
    }

    public t c5(String str, long j2, long j4) {
        return new t(str, j2, j4);
    }

    public int ct(List<fb> list) {
        int m2;
        int i = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            fb fbVar = list.get(i5);
            if (w0.zn.y("urn:mpeg:dash:role:2011", fbVar.y)) {
                m2 = o4(fbVar.f7361n3);
            } else if (w0.zn.y("urn:tva:metadata:cs:AudioPurposeCS:2007", fbVar.y)) {
                m2 = m(fbVar.f7361n3);
            }
            i |= m2;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011a  */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> d(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dq.a.d(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int d0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        char c2;
        String kp2 = kp(xmlPullParser, "schemeIdUri", null);
        kp2.hashCode();
        int i = -1;
        switch (kp2.hashCode()) {
            case -2128649360:
                if (kp2.equals("urn:dts:dash:audio_channel_configuration:2012")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1352850286:
                if (kp2.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1138141449:
                if (kp2.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -986633423:
                if (kp2.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -79006963:
                if (kp2.equals("tag:dts.com,2014:dash:audio_channel_configuration:2012")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 312179081:
                if (kp2.equals("tag:dts.com,2018:uhd:audio_channel_configuration")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 2036691300:
                if (kp2.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                    c2 = 6;
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
            case 4:
                i = x(xmlPullParser);
                break;
            case 1:
                i = oz(xmlPullParser, "value", -1);
                break;
            case 2:
            case 6:
                i = a8(xmlPullParser);
                break;
            case 3:
                i = en(xmlPullParser);
                break;
            case 5:
                i = b(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!qn.gv(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x01ee A[LOOP:0: B:3:0x006a->B:57:0x01ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0198 A[EDGE_INSN: B:58:0x0198->B:47:0x0198 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public dq.a.y dm(org.xmlpull.v1.XmlPullParser r36, java.util.List<dq.n3> r37, @androidx.annotation.Nullable java.lang.String r38, @androidx.annotation.Nullable java.lang.String r39, int r40, int r41, float r42, int r43, int r44, @androidx.annotation.Nullable java.lang.String r45, java.util.List<dq.fb> r46, java.util.List<dq.fb> r47, java.util.List<dq.fb> r48, java.util.List<dq.fb> r49, @androidx.annotation.Nullable dq.wz r50, long r51, long r53, long r55, long r57, long r59, boolean r61) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dq.a.dm(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, dq.wz, long, long, long, long, long, boolean):dq.a$y");
    }

    public List<wz.gv> e(XmlPullParser xmlPullParser, long j2, long j4) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j6 = 0;
        long j7 = -9223372036854775807L;
        boolean z2 = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "S")) {
                long k2 = k(xmlPullParser, "t", -9223372036854775807L);
                if (z2) {
                    j6 = n3(arrayList, j6, j7, i, k2);
                }
                if (k2 == -9223372036854775807L) {
                    k2 = j6;
                }
                j7 = k(xmlPullParser, "d", -9223372036854775807L);
                i = oz(xmlPullParser, "r", 0);
                j6 = k2;
                z2 = true;
            } else {
                i4(xmlPullParser);
            }
        } while (!qn.gv(xmlPullParser, "SegmentTimeline"));
        if (z2) {
            n3(arrayList, j6, j7, i, j5.x5(j4, j2, 1000L));
        }
        return arrayList;
    }

    public int eb(List<fb> list) {
        int i = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            fb fbVar = list.get(i5);
            if (w0.zn.y("urn:mpeg:dash:role:2011", fbVar.y)) {
                i |= o4(fbVar.f7361n3);
            }
        }
        return i;
    }

    public wz.n3 f(t tVar, long j2, long j4, long j6, long j7, @Nullable List<wz.gv> list, long j8, @Nullable List<t> list2, long j9, long j10) {
        return new wz.n3(tVar, j2, j4, j6, j7, list, j8, list2, j5.xb(j9), j5.xb(j10));
    }

    @Override // kx.z6.y
    /* renamed from: f3 */
    public zn y(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.y.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return f7(newPullParser, uri);
            }
            throw ne.v("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e2) {
            throw ne.v(null, e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01dc A[LOOP:0: B:24:0x00a0->B:80:0x01dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0197 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public dq.zn f7(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dq.a.f7(org.xmlpull.v1.XmlPullParser, android.net.Uri):dq.zn");
    }

    public zn fb(long j2, long j4, long j6, boolean z2, long j7, long j8, long j9, long j10, @Nullable f fVar, @Nullable mt mtVar, @Nullable xc xcVar, @Nullable Uri uri, List<i9> list) {
        return new zn(j2, j4, j6, z2, j7, j8, j9, j10, fVar, mtVar, xcVar, uri, list);
    }

    public long fh(XmlPullParser xmlPullParser, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j2;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return Float.parseFloat(attributeValue) * 1000000.0f;
    }

    @Nullable
    public p g(XmlPullParser xmlPullParser, String str, @Nullable p pVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return p.n3(attributeValue);
        }
        return pVar;
    }

    @Nullable
    public Pair<Integer, Integer> g3(List<fb> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            fb fbVar = list.get(i);
            if ((w0.zn.y("http://dashif.org/thumbnail_tile", fbVar.y) || w0.zn.y("http://dashif.org/guidelines/thumbnail_tile", fbVar.y)) && (str = fbVar.f7361n3) != null) {
                String[] ro2 = j5.ro(str, "x");
                if (ro2.length == 2) {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(ro2[0])), Integer.valueOf(Integer.parseInt(ro2[1])));
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public EventMessage gv(String str, String str2, long j2, long j4, byte[] bArr) {
        return new EventMessage(str, str2, j4, j2, bArr);
    }

    public byte[] hw(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, w0.v.f14523zn.name());
        xmlPullParser.nextToken();
        while (!qn.gv(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public tl i9(y yVar, @Nullable String str, @Nullable String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<fb> arrayList2) {
        m.n3 n32 = yVar.y.n3();
        if (str != null) {
            n32.q9(str);
        }
        String str3 = yVar.f7349gv;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = yVar.f7352v;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            mt(arrayList3);
            co(arrayList3);
            n32.vl(new DrmInitData(str2, arrayList3));
        }
        ArrayList<fb> arrayList4 = yVar.f7346a;
        arrayList4.addAll(arrayList2);
        return tl.w(yVar.f7348fb, n32.z6(), yVar.f7350n3, yVar.f7353zn, arrayList4, yVar.f7351s, yVar.f7347c5, null);
    }

    public t j(XmlPullParser xmlPullParser) {
        return xg(xmlPullParser, "sourceURL", "range");
    }

    public s j5(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        long j2;
        ArrayList arrayList;
        String kp2 = kp(xmlPullParser, "schemeIdUri", "");
        String kp3 = kp(xmlPullParser, "value", "");
        long k2 = k(xmlPullParser, "timescale", 1L);
        long k3 = k(xmlPullParser, "presentationTimeOffset", 0L);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j4 = k3;
                j2 = k3;
                arrayList = arrayList2;
                arrayList.add(vl(xmlPullParser, kp2, kp3, k2, j4, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                j2 = k3;
                arrayList = arrayList2;
                i4(xmlPullParser);
            }
            if (qn.gv(xmlPullParser, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            k3 = j2;
        }
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return v(kp2, kp3, k2, jArr, eventMessageArr);
    }

    public Pair<i9, Long> jz(XmlPullParser xmlPullParser, List<n3> list, long j2, long j4, long j6, long j7, boolean z2) throws XmlPullParserException, IOException {
        long j8;
        long j9;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        long j10;
        wz ra2;
        ArrayList arrayList4;
        a aVar = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long k52 = k5(xmlPullParser2, "start", j2);
        long j11 = -9223372036854775807L;
        if (j6 != -9223372036854775807L) {
            j8 = j6 + k52;
        } else {
            j8 = -9223372036854775807L;
        }
        long k53 = k5(xmlPullParser2, "duration", -9223372036854775807L);
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        long j12 = j4;
        long j13 = -9223372036854775807L;
        wz.v vVar = null;
        fb fbVar = null;
        boolean z3 = false;
        while (true) {
            xmlPullParser.next();
            if (qn.a(xmlPullParser2, "BaseURL")) {
                if (!z3) {
                    j12 = aVar.fh(xmlPullParser2, j12);
                    z3 = true;
                }
                arrayList7.addAll(aVar.rz(xmlPullParser2, list, z2));
                arrayList3 = arrayList6;
                arrayList = arrayList7;
                j10 = j11;
                obj = obj2;
                arrayList2 = arrayList5;
            } else {
                if (qn.a(xmlPullParser2, "AdaptationSet")) {
                    if (!arrayList7.isEmpty()) {
                        arrayList4 = arrayList7;
                    } else {
                        arrayList4 = list;
                    }
                    j9 = j12;
                    arrayList = arrayList7;
                    arrayList2 = arrayList5;
                    arrayList2.add(n(xmlPullParser, arrayList4, vVar, k53, j12, j13, j8, j7, z2));
                    xmlPullParser2 = xmlPullParser;
                    arrayList3 = arrayList6;
                } else {
                    j9 = j12;
                    ArrayList arrayList8 = arrayList6;
                    arrayList = arrayList7;
                    arrayList2 = arrayList5;
                    xmlPullParser2 = xmlPullParser;
                    if (qn.a(xmlPullParser2, "EventStream")) {
                        arrayList8.add(j5(xmlPullParser));
                        arrayList3 = arrayList8;
                    } else if (qn.a(xmlPullParser2, "SegmentBase")) {
                        arrayList3 = arrayList8;
                        vVar = lc(xmlPullParser2, null);
                        obj = null;
                        j12 = j9;
                        j10 = -9223372036854775807L;
                    } else {
                        arrayList3 = arrayList8;
                        if (qn.a(xmlPullParser2, "SegmentList")) {
                            long fh2 = fh(xmlPullParser2, -9223372036854775807L);
                            obj = null;
                            ra2 = nf(xmlPullParser, null, j8, k53, j9, fh2, j7);
                            j13 = fh2;
                            j12 = j9;
                            j10 = -9223372036854775807L;
                        } else {
                            obj = null;
                            if (qn.a(xmlPullParser2, "SegmentTemplate")) {
                                long fh3 = fh(xmlPullParser2, -9223372036854775807L);
                                j10 = -9223372036854775807L;
                                ra2 = ra(xmlPullParser, null, x4.j5(), j8, k53, j9, fh3, j7);
                                j13 = fh3;
                                j12 = j9;
                            } else {
                                j10 = -9223372036854775807L;
                                if (qn.a(xmlPullParser2, "AssetIdentifier")) {
                                    fbVar = ud(xmlPullParser2, "AssetIdentifier");
                                } else {
                                    i4(xmlPullParser);
                                }
                                j12 = j9;
                            }
                        }
                        vVar = ra2;
                    }
                }
                obj = null;
                j10 = -9223372036854775807L;
                j12 = j9;
            }
            if (qn.gv(xmlPullParser2, "Period")) {
                return Pair.create(s(attributeValue, k52, arrayList2, arrayList3, fbVar), Long.valueOf(k53));
            }
            arrayList5 = arrayList2;
            arrayList7 = arrayList;
            obj2 = obj;
            arrayList6 = arrayList3;
            j11 = j10;
            aVar = this;
        }
    }

    public wz.v lc(XmlPullParser xmlPullParser, @Nullable wz.v vVar) throws XmlPullParserException, IOException {
        long j2;
        long j4;
        long j6;
        long j7;
        long j8;
        if (vVar != null) {
            j2 = vVar.f7395n3;
        } else {
            j2 = 1;
        }
        long k2 = k(xmlPullParser, "timescale", j2);
        long j9 = 0;
        if (vVar != null) {
            j4 = vVar.f7396zn;
        } else {
            j4 = 0;
        }
        long k3 = k(xmlPullParser, "presentationTimeOffset", j4);
        if (vVar != null) {
            j6 = vVar.f7399gv;
        } else {
            j6 = 0;
        }
        if (vVar != null) {
            j9 = vVar.f7400v;
        }
        t tVar = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j8 = Long.parseLong(split[0]);
            j7 = (Long.parseLong(split[1]) - j8) + 1;
        } else {
            j7 = j9;
            j8 = j6;
        }
        if (vVar != null) {
            tVar = vVar.y;
        }
        do {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "Initialization")) {
                tVar = j(xmlPullParser);
            } else {
                i4(xmlPullParser);
            }
        } while (!qn.gv(xmlPullParser, "SegmentBase"));
        return wz(tVar, k2, k3, j8, j7);
    }

    public int m(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c2 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x030d A[LOOP:0: B:3:0x007c->B:71:0x030d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ce A[EDGE_INSN: B:72:0x02ce->B:65:0x02ce ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public dq.y n(org.xmlpull.v1.XmlPullParser r55, java.util.List<dq.n3> r56, @androidx.annotation.Nullable dq.wz r57, long r58, long r60, long r62, long r64, long r66, boolean r68) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dq.a.n(org.xmlpull.v1.XmlPullParser, java.util.List, dq.wz, long, long, long, long, long, boolean):dq.y");
    }

    public wz.n3 nf(XmlPullParser xmlPullParser, @Nullable wz.n3 n3Var, long j2, long j4, long j6, long j7, long j8) throws XmlPullParserException, IOException {
        long j9;
        long j10;
        long j11;
        long j12 = 1;
        if (n3Var != null) {
            j9 = n3Var.f7395n3;
        } else {
            j9 = 1;
        }
        long k2 = k(xmlPullParser, "timescale", j9);
        if (n3Var != null) {
            j10 = n3Var.f7396zn;
        } else {
            j10 = 0;
        }
        long k3 = k(xmlPullParser, "presentationTimeOffset", j10);
        if (n3Var != null) {
            j11 = n3Var.f7406v;
        } else {
            j11 = -9223372036854775807L;
        }
        long k4 = k(xmlPullParser, "duration", j11);
        if (n3Var != null) {
            j12 = n3Var.f7404gv;
        }
        long k6 = k(xmlPullParser, "startNumber", j12);
        long z2 = z(j6, j7);
        List<wz.gv> list = null;
        List<t> list2 = null;
        t tVar = null;
        do {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "Initialization")) {
                tVar = j(xmlPullParser);
            } else if (qn.a(xmlPullParser, "SegmentTimeline")) {
                list = e(xmlPullParser, k2, j4);
            } else if (qn.a(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(s8(xmlPullParser));
            } else {
                i4(xmlPullParser);
            }
        } while (!qn.gv(xmlPullParser, "SegmentList"));
        if (n3Var != null) {
            if (tVar == null) {
                tVar = n3Var.y;
            }
            if (list == null) {
                list = n3Var.f7401a;
            }
            if (list2 == null) {
                list2 = n3Var.f7398i9;
            }
        }
        return f(tVar, k2, k3, k6, k4, list, z2, list2, j8, j2);
    }

    public int o4(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals("forced_subtitle")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1396432756:
                if (str.equals("forced-subtitle")) {
                    c2 = 5;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c2 = 7;
                    break;
                }
                break;
            case 3530173:
                if (str.equals("sign")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c2 = '\f';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 3:
            case 5:
                return NotificationCompat.FLAG_HIGH_PRIORITY;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 6:
                return 16;
            case 7:
                return 1;
            case '\b':
                return 256;
            case '\t':
                return 64;
            case '\n':
                return 8;
            case 11:
                return 32;
            case '\f':
                return 4;
            default:
                return 0;
        }
    }

    public wz.zn ra(XmlPullParser xmlPullParser, @Nullable wz.zn znVar, List<fb> list, long j2, long j4, long j6, long j7, long j8) throws XmlPullParserException, IOException {
        long j9;
        long j10;
        long j11;
        p pVar;
        p pVar2;
        long j12 = 1;
        if (znVar != null) {
            j9 = znVar.f7395n3;
        } else {
            j9 = 1;
        }
        long k2 = k(xmlPullParser, "timescale", j9);
        if (znVar != null) {
            j10 = znVar.f7396zn;
        } else {
            j10 = 0;
        }
        long k3 = k(xmlPullParser, "presentationTimeOffset", j10);
        if (znVar != null) {
            j11 = znVar.f7406v;
        } else {
            j11 = -9223372036854775807L;
        }
        long k4 = k(xmlPullParser, "duration", j11);
        if (znVar != null) {
            j12 = znVar.f7404gv;
        }
        long k6 = k(xmlPullParser, "startNumber", j12);
        long q92 = q9(list);
        long z2 = z(j6, j7);
        List<wz.gv> list2 = null;
        if (znVar != null) {
            pVar = znVar.f7407f;
        } else {
            pVar = null;
        }
        p g2 = g(xmlPullParser, "media", pVar);
        if (znVar != null) {
            pVar2 = znVar.f7408i9;
        } else {
            pVar2 = null;
        }
        p g4 = g(xmlPullParser, "initialization", pVar2);
        t tVar = null;
        while (true) {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "Initialization")) {
                tVar = j(xmlPullParser);
            } else if (qn.a(xmlPullParser, "SegmentTimeline")) {
                list2 = e(xmlPullParser, k2, j4);
            } else {
                i4(xmlPullParser);
            }
            if (qn.gv(xmlPullParser, "SegmentTemplate")) {
                break;
            }
        }
        if (znVar != null) {
            if (tVar == null) {
                tVar = znVar.y;
            }
            if (list2 == null) {
                list2 = znVar.f7401a;
            }
        }
        return t(tVar, k2, k3, k6, q92, k4, list2, z2, g4, g2, j8, j2);
    }

    public int rs(List<fb> list) {
        int i = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (w0.zn.y("http://dashif.org/guidelines/trickmode", list.get(i5).y)) {
                i = 16384;
            }
        }
        return i;
    }

    public List<n3> rz(XmlPullParser xmlPullParser, List<n3> list, boolean z2) throws XmlPullParserException, IOException {
        int i;
        int i5;
        String str;
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        } else if (z2) {
            i = 1;
        } else {
            i = Integer.MIN_VALUE;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        if (attributeValue2 != null) {
            i5 = Integer.parseInt(attributeValue2);
        } else {
            i5 = 1;
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String rb2 = rb(xmlPullParser, "BaseURL");
        if (vl.n3(rb2)) {
            if (attributeValue3 == null) {
                attributeValue3 = rb2;
            }
            return mg.i9(new n3(rb2, attributeValue3, i, i5));
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            n3 n3Var = list.get(i6);
            String gv2 = vl.gv(n3Var.y, rb2);
            if (attributeValue3 == null) {
                str = gv2;
            } else {
                str = attributeValue3;
            }
            if (z2) {
                i = n3Var.f7371zn;
                i5 = n3Var.f7369gv;
                str = n3Var.f7370n3;
            }
            arrayList.add(new n3(gv2, str, i, i5));
        }
        return arrayList;
    }

    public i9 s(@Nullable String str, long j2, List<dq.y> list, List<s> list2, @Nullable fb fbVar) {
        return new i9(str, j2, list, list2, fbVar);
    }

    public t s8(XmlPullParser xmlPullParser) {
        return xg(xmlPullParser, "media", "mediaRange");
    }

    public wz.zn t(t tVar, long j2, long j4, long j6, long j7, long j8, List<wz.gv> list, long j9, @Nullable p pVar, @Nullable p pVar2, long j10, long j11) {
        return new wz.zn(tVar, j2, j4, j6, j7, j8, list, j9, pVar, pVar2, j5.xb(j10), j5.xb(j11));
    }

    public wz.gv tl(long j2, long j4) {
        return new wz.gv(j2, j4);
    }

    public String[] u(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return strArr;
        }
        return attributeValue.split(",");
    }

    public mt u0(XmlPullParser xmlPullParser) {
        return xc(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    public String ut(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return rb(xmlPullParser, "Label");
    }

    public s v(String str, String str2, long j2, long[] jArr, EventMessage[] eventMessageArr) {
        return new s(str, str2, j2, jArr, eventMessageArr);
    }

    public Pair<Long, EventMessage> vl(XmlPullParser xmlPullParser, String str, String str2, long j2, long j4, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        long k2 = k(xmlPullParser, "id", 0L);
        long k3 = k(xmlPullParser, "duration", -9223372036854775807L);
        long k4 = k(xmlPullParser, "presentationTime", 0L);
        long x52 = j5.x5(k3, 1000L, j2);
        long x53 = j5.x5(k4 - j4, 1000000L, j2);
        String kp2 = kp(xmlPullParser, "messageData", null);
        byte[] hw2 = hw(xmlPullParser, byteArrayOutputStream);
        Long valueOf = Long.valueOf(x53);
        if (kp2 != null) {
            hw2 = j5.ap(kp2);
        }
        return Pair.create(valueOf, gv(str, str2, k2, x52, hw2));
    }

    public wz.v wz(t tVar, long j2, long j4, long j6, long j7) {
        return new wz.v(tVar, j2, j4, j6, j7);
    }

    public mt xc(String str, String str2) {
        return new mt(str, str2);
    }

    public t xg(XmlPullParser xmlPullParser, String str, String str2) {
        long j2;
        long j4;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j2 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j4 = (Long.parseLong(split[1]) - j2) + 1;
                return c5(attributeValue, j2, j4);
            }
        } else {
            j2 = 0;
        }
        j4 = -1;
        return c5(attributeValue, j2, j4);
    }

    public f y5(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String kp2 = kp(xmlPullParser, "moreInformationURL", null);
        String kp3 = kp(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (qn.a(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (qn.a(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                i4(xmlPullParser);
            }
            String str4 = str3;
            if (qn.gv(xmlPullParser, "ProgramInformation")) {
                return new f(str, str2, str4, kp2, kp3);
            }
            str3 = str4;
        }
    }

    public xc yc(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long j2 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        long j6 = -9223372036854775807L;
        float f4 = -3.4028235E38f;
        float f6 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "Latency")) {
                j2 = k(xmlPullParser, "target", -9223372036854775807L);
                j4 = k(xmlPullParser, "min", -9223372036854775807L);
                j6 = k(xmlPullParser, "max", -9223372036854775807L);
            } else if (qn.a(xmlPullParser, "PlaybackRate")) {
                f4 = qn(xmlPullParser, "min", -3.4028235E38f);
                f6 = qn(xmlPullParser, "max", -3.4028235E38f);
            }
            long j7 = j2;
            long j8 = j4;
            long j9 = j6;
            float f9 = f4;
            float f10 = f6;
            if (qn.gv(xmlPullParser, "ServiceDescription")) {
                return new xc(j7, j8, j9, f9, f10);
            }
            j2 = j7;
            j4 = j8;
            j6 = j9;
            f4 = f9;
            f6 = f10;
        }
    }

    public int yg(List<fb> list) {
        int i = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            fb fbVar = list.get(i5);
            if (w0.zn.y("urn:mpeg:dash:role:2011", fbVar.y)) {
                i |= ap(fbVar.f7361n3);
            }
        }
        return i;
    }

    public int z6(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        if (!"image".equals(attributeValue)) {
            return -1;
        }
        return 4;
    }

    public dq.y zn(int i, int i5, List<tl> list, List<fb> list2, List<fb> list3, List<fb> list4) {
        return new dq.y(i, i5, list, list2, list3, list4);
    }
}
