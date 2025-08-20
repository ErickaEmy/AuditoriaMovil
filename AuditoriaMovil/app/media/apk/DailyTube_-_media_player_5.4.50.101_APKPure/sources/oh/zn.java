package oh;

import android.text.Layout;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import qh.c5;
import qh.f;
import v5.j5;
import v5.qn;
import v5.r;
/* loaded from: classes.dex */
public final class zn extends qh.s {

    /* renamed from: xc  reason: collision with root package name */
    public final XmlPullParserFactory f12328xc;

    /* renamed from: w  reason: collision with root package name */
    public static final Pattern f12325w = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f12323p = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: mt  reason: collision with root package name */
    public static final Pattern f12322mt = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: co  reason: collision with root package name */
    public static final Pattern f12319co = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: z  reason: collision with root package name */
    public static final Pattern f12327z = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f12324r = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: x4  reason: collision with root package name */
    public static final Pattern f12326x4 = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: i4  reason: collision with root package name */
    public static final n3 f12321i4 = new n3(30.0f, 1, 1);

    /* renamed from: f3  reason: collision with root package name */
    public static final y f12320f3 = new y(32, 15);

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final int f12329n3;
        public final float y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f12330zn;

        public n3(float f4, int i, int i5) {
            this.y = f4;
            this.f12329n3 = i;
            this.f12330zn = i5;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final int f12331n3;
        public final int y;

        public y(int i, int i5) {
            this.y = i;
            this.f12331n3 = i5;
        }
    }

    /* renamed from: oh.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0176zn {

        /* renamed from: n3  reason: collision with root package name */
        public final int f12332n3;
        public final int y;

        public C0176zn(int i, int i5) {
            this.y = i;
            this.f12332n3 = i5;
        }
    }

    public zn() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f12328xc = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static gv a8(XmlPullParser xmlPullParser, @Nullable gv gvVar, Map<String, v> map, n3 n3Var) throws f {
        long j2;
        long j4;
        char c2;
        int attributeCount = xmlPullParser.getAttributeCount();
        fb k52 = k5(xmlPullParser, null);
        String str = null;
        String str2 = "";
        long j6 = -9223372036854775807L;
        long j7 = -9223372036854775807L;
        long j8 = -9223372036854775807L;
        String[] strArr = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c2 = 5;
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
                    if (map.containsKey(attributeValue)) {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j8 = vl(attributeValue, n3Var);
                    break;
                case 2:
                    j7 = vl(attributeValue, n3Var);
                    break;
                case 3:
                    j6 = vl(attributeValue, n3Var);
                    break;
                case 4:
                    String[] yt2 = yt(attributeValue);
                    if (yt2.length > 0) {
                        strArr = yt2;
                        continue;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (gvVar != null) {
            long j9 = gvVar.f12291gv;
            j2 = -9223372036854775807L;
            if (j9 != -9223372036854775807L) {
                if (j6 != -9223372036854775807L) {
                    j6 += j9;
                }
                if (j7 != -9223372036854775807L) {
                    j7 += j9;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        long j10 = j6;
        if (j7 == j2) {
            if (j8 != j2) {
                j4 = j10 + j8;
            } else if (gvVar != null) {
                long j11 = gvVar.f12297v;
                if (j11 != j2) {
                    j4 = j11;
                }
            }
            return gv.zn(xmlPullParser.getName(), j10, j4, k52, strArr, str2, str, gvVar);
        }
        j4 = j7;
        return gv.zn(xmlPullParser.getName(), j10, j4, k52, strArr, str2, str, gvVar);
    }

    public static float b(String str) {
        Matcher matcher = f12319co.matcher(str);
        if (!matcher.matches()) {
            r.c5("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) v5.y.v(matcher.group(1)))));
        } catch (NumberFormatException e2) {
            r.i9("TtmlDecoder", "Failed to parse shear: " + str, e2);
            return Float.MAX_VALUE;
        }
    }

    public static void d(String str, fb fbVar) throws f {
        Matcher matcher;
        String[] ro2 = j5.ro(str, "\\s+");
        if (ro2.length == 1) {
            matcher = f12322mt.matcher(str);
        } else if (ro2.length == 2) {
            matcher = f12322mt.matcher(ro2[1]);
            r.c5("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new f("Invalid number of entries for fontSize: " + ro2.length + ".");
        }
        if (matcher.matches()) {
            String str2 = (String) v5.y.v(matcher.group(3));
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
                    fbVar.c(3);
                    break;
                case 1:
                    fbVar.c(2);
                    break;
                case 2:
                    fbVar.c(1);
                    break;
                default:
                    throw new f("Invalid unit for fontSize: '" + str2 + "'.");
            }
            fbVar.n(Float.parseFloat((String) v5.y.v(matcher.group(1))));
            return;
        }
        throw new f("Invalid expression for fontSize: '" + str + "'.");
    }

    public static Map<String, fb> ej(XmlPullParser xmlPullParser, Map<String, fb> map, y yVar, @Nullable C0176zn c0176zn, Map<String, v> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "style")) {
                String y2 = qn.y(xmlPullParser, "style");
                fb k52 = k5(xmlPullParser, new fb());
                if (y2 != null) {
                    for (String str : yt(y2)) {
                        k52.y(map.get(str));
                    }
                }
                String fb2 = k52.fb();
                if (fb2 != null) {
                    map.put(fb2, k52);
                }
            } else if (qn.a(xmlPullParser, "region")) {
                v x2 = x(xmlPullParser, yVar, c0176zn);
                if (x2 != null) {
                    map2.put(x2.y, x2);
                }
            } else if (qn.a(xmlPullParser, "metadata")) {
                ud(xmlPullParser, map3);
            }
        } while (!qn.gv(xmlPullParser, "head"));
        return map;
    }

    public static fb fh(@Nullable fb fbVar) {
        if (fbVar == null) {
            return new fb();
        }
        return fbVar;
    }

    @Nullable
    public static C0176zn hw(XmlPullParser xmlPullParser) {
        String y2 = qn.y(xmlPullParser, "extent");
        if (y2 == null) {
            return null;
        }
        Matcher matcher = f12324r.matcher(y2);
        if (!matcher.matches()) {
            r.c5("TtmlDecoder", "Ignoring non-pixel tts extent: " + y2);
            return null;
        }
        try {
            return new C0176zn(Integer.parseInt((String) v5.y.v(matcher.group(1))), Integer.parseInt((String) v5.y.v(matcher.group(2))));
        } catch (NumberFormatException unused) {
            r.c5("TtmlDecoder", "Ignoring malformed tts extent: " + y2);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static fb k5(XmlPullParser xmlPullParser, fb fbVar) {
        char c2;
        char c4;
        char c6;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        c2 = 14;
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
                    fbVar = fh(fbVar).fh("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    fbVar = fh(fbVar).f3(attributeValue);
                    break;
                case 2:
                    fbVar = fh(fbVar).ej(mg(attributeValue));
                    break;
                case 3:
                    String v2 = w0.zn.v(attributeValue);
                    v2.hashCode();
                    switch (v2.hashCode()) {
                        case -1461280213:
                            if (v2.equals("nounderline")) {
                                c4 = 0;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -1026963764:
                            if (v2.equals("underline")) {
                                c4 = 1;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 913457136:
                            if (v2.equals("nolinethrough")) {
                                c4 = 2;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 1679736913:
                            if (v2.equals("linethrough")) {
                                c4 = 3;
                                break;
                            }
                            c4 = 65535;
                            break;
                        default:
                            c4 = 65535;
                            break;
                    }
                    switch (c4) {
                        case 0:
                            fbVar = fh(fbVar).x(false);
                            continue;
                        case 1:
                            fbVar = fh(fbVar).x(true);
                            continue;
                        case 2:
                            fbVar = fh(fbVar).rz(false);
                            continue;
                        case 3:
                            fbVar = fh(fbVar).rz(true);
                            continue;
                    }
                case 4:
                    fbVar = fh(fbVar).x4("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        fbVar = fh(fbVar).d0(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    String v3 = w0.zn.v(attributeValue);
                    v3.hashCode();
                    switch (v3.hashCode()) {
                        case -618561360:
                            if (v3.equals("baseContainer")) {
                                c6 = 0;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -410956671:
                            if (v3.equals("container")) {
                                c6 = 1;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -250518009:
                            if (v3.equals("delimiter")) {
                                c6 = 2;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -136074796:
                            if (v3.equals("textContainer")) {
                                c6 = 3;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 3016401:
                            if (v3.equals("base")) {
                                c6 = 4;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 3556653:
                            if (v3.equals("text")) {
                                c6 = 5;
                                break;
                            }
                            c6 = 65535;
                            break;
                        default:
                            c6 = 65535;
                            break;
                    }
                    switch (c6) {
                        case 0:
                        case 4:
                            fbVar = fh(fbVar).d(2);
                            continue;
                        case 1:
                            fbVar = fh(fbVar).d(1);
                            continue;
                        case 2:
                            fbVar = fh(fbVar).d(4);
                            continue;
                        case 3:
                        case 5:
                            fbVar = fh(fbVar).d(3);
                            continue;
                    }
                case 7:
                    fbVar = fh(fbVar);
                    try {
                        fbVar.i4(v5.fb.zn(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        r.c5("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case '\b':
                    fbVar = fh(fbVar).z6(b(attributeValue));
                    break;
                case '\t':
                    String v4 = w0.zn.v(attributeValue);
                    v4.hashCode();
                    if (!v4.equals("all")) {
                        if (v4.equals("none")) {
                            fbVar = fh(fbVar).ud(false);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        fbVar = fh(fbVar).ud(true);
                        break;
                    }
                case '\n':
                    try {
                        fbVar = fh(fbVar);
                        d(attributeValue, fbVar);
                        break;
                    } catch (f unused2) {
                        r.c5("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case 11:
                    fbVar = fh(fbVar).a8(oh.n3.y(attributeValue));
                    break;
                case '\f':
                    String v6 = w0.zn.v(attributeValue);
                    v6.hashCode();
                    if (!v6.equals("before")) {
                        if (v6.equals("after")) {
                            fbVar = fh(fbVar).ta(2);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        fbVar = fh(fbVar).ta(1);
                        break;
                    }
                case '\r':
                    fbVar = fh(fbVar);
                    try {
                        fbVar.r(v5.fb.zn(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        r.c5("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                case 14:
                    fbVar = fh(fbVar).mg(mg(attributeValue));
                    break;
            }
        }
        return fbVar;
    }

    @Nullable
    public static Layout.Alignment mg(String str) {
        String v2 = w0.zn.v(str);
        v2.hashCode();
        char c2 = 65535;
        switch (v2.hashCode()) {
            case -1364013995:
                if (v2.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case 100571:
                if (v2.equals("end")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3317767:
                if (v2.equals("left")) {
                    c2 = 2;
                    break;
                }
                break;
            case 108511772:
                if (v2.equals("right")) {
                    c2 = 3;
                    break;
                }
                break;
            case 109757538:
                if (v2.equals("start")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    public static boolean rz(String str) {
        if (!str.equals("tt") && !str.equals("head") && !str.equals("body") && !str.equals("div") && !str.equals("p") && !str.equals("span") && !str.equals("br") && !str.equals("style") && !str.equals("styling") && !str.equals("layout") && !str.equals("region") && !str.equals("metadata") && !str.equals("image") && !str.equals("data") && !str.equals("information")) {
            return false;
        }
        return true;
    }

    public static y ta(XmlPullParser xmlPullParser, y yVar) throws f {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return yVar;
        }
        Matcher matcher = f12326x4.matcher(attributeValue);
        if (!matcher.matches()) {
            r.c5("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return yVar;
        }
        try {
            int parseInt = Integer.parseInt((String) v5.y.v(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) v5.y.v(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new y(parseInt, parseInt2);
            }
            throw new f("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            r.c5("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return yVar;
        }
    }

    public static void ud(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String y2;
        do {
            xmlPullParser.next();
            if (qn.a(xmlPullParser, "image") && (y2 = qn.y(xmlPullParser, "id")) != null) {
                map.put(y2, xmlPullParser.nextText());
            }
        } while (!qn.gv(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00be, code lost:
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long vl(java.lang.String r13, oh.zn.n3 r14) throws qh.f {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.zn.vl(java.lang.String, oh.zn$n3):long");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01ad, code lost:
        if (r0.equals("tb") == false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0180  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static oh.v x(org.xmlpull.v1.XmlPullParser r18, oh.zn.y r19, @androidx.annotation.Nullable oh.zn.C0176zn r20) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.zn.x(org.xmlpull.v1.XmlPullParser, oh.zn$y, oh.zn$zn):oh.v");
    }

    public static String[] yt(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return new String[0];
        }
        return j5.ro(trim, "\\s+");
    }

    public static n3 z6(XmlPullParser xmlPullParser) throws f {
        int i;
        float f4;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i = Integer.parseInt(attributeValue);
        } else {
            i = 30;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] ro2 = j5.ro(attributeValue2, " ");
            if (ro2.length == 2) {
                f4 = Integer.parseInt(ro2[0]) / Integer.parseInt(ro2[1]);
            } else {
                throw new f("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f4 = 1.0f;
        }
        n3 n3Var = f12321i4;
        int i5 = n3Var.f12329n3;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i5 = Integer.parseInt(attributeValue3);
        }
        int i6 = n3Var.f12330zn;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i6 = Integer.parseInt(attributeValue4);
        }
        return new n3(i * f4, i5, i6);
    }

    @Override // qh.s
    public c5 c(byte[] bArr, int i, boolean z2) throws f {
        n3 n3Var;
        try {
            XmlPullParser newPullParser = this.f12328xc.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new v(""));
            C0176zn c0176zn = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            n3 n3Var2 = f12321i4;
            y yVar = f12320f3;
            s sVar = null;
            int i5 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                gv gvVar = (gv) arrayDeque.peek();
                if (i5 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            n3Var2 = z6(newPullParser);
                            yVar = ta(newPullParser, f12320f3);
                            c0176zn = hw(newPullParser);
                        }
                        C0176zn c0176zn2 = c0176zn;
                        n3 n3Var3 = n3Var2;
                        y yVar2 = yVar;
                        if (!rz(name)) {
                            r.a("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i5++;
                            n3Var2 = n3Var3;
                        } else {
                            if ("head".equals(name)) {
                                n3Var = n3Var3;
                                ej(newPullParser, hashMap, yVar2, c0176zn2, hashMap2, hashMap3);
                            } else {
                                n3Var = n3Var3;
                                try {
                                    gv a82 = a8(newPullParser, gvVar, hashMap2, n3Var);
                                    arrayDeque.push(a82);
                                    if (gvVar != null) {
                                        gvVar.y(a82);
                                    }
                                } catch (f e2) {
                                    r.i9("TtmlDecoder", "Suppressing parser error", e2);
                                    i5++;
                                }
                            }
                            n3Var2 = n3Var;
                        }
                        c0176zn = c0176zn2;
                        yVar = yVar2;
                    } else if (eventType == 4) {
                        ((gv) v5.y.v(gvVar)).y(gv.gv(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            sVar = new s((gv) v5.y.v((gv) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i5++;
                } else if (eventType == 3) {
                    i5--;
                }
                newPullParser.next();
            }
            if (sVar != null) {
                return sVar;
            }
            throw new f("No TTML subtitles found");
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        } catch (XmlPullParserException e5) {
            throw new f("Unable to decode source", e5);
        }
    }
}
