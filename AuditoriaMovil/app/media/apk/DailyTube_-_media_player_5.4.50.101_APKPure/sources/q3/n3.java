package q3;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import ha.t;
import ha.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kx.z6;
import m1.m;
import m1.ne;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import q3.y;
import v5.j5;
/* loaded from: classes.dex */
public class n3 implements z6.y<q3.y> {
    public final XmlPullParserFactory y;

    /* loaded from: classes.dex */
    public static class a extends y {

        /* renamed from: a  reason: collision with root package name */
        public final List<m> f12701a;

        /* renamed from: c5  reason: collision with root package name */
        public long f12702c5;

        /* renamed from: f  reason: collision with root package name */
        public String f12703f;

        /* renamed from: fb  reason: collision with root package name */
        public int f12704fb;

        /* renamed from: i9  reason: collision with root package name */
        public String f12705i9;

        /* renamed from: mt  reason: collision with root package name */
        public long f12706mt;

        /* renamed from: p  reason: collision with root package name */
        public ArrayList<Long> f12707p;

        /* renamed from: s  reason: collision with root package name */
        public String f12708s;

        /* renamed from: t  reason: collision with root package name */
        public int f12709t;

        /* renamed from: tl  reason: collision with root package name */
        public int f12710tl;

        /* renamed from: v  reason: collision with root package name */
        public final String f12711v;

        /* renamed from: w  reason: collision with root package name */
        public String f12712w;

        /* renamed from: wz  reason: collision with root package name */
        public int f12713wz;

        /* renamed from: xc  reason: collision with root package name */
        public int f12714xc;

        public a(y yVar, String str) {
            super(yVar, str, "StreamIndex");
            this.f12711v = str;
            this.f12701a = new LinkedList();
        }

        public final int co(XmlPullParser xmlPullParser) throws ne {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue != null) {
                if ("audio".equalsIgnoreCase(attributeValue)) {
                    return 1;
                }
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw ne.v("Invalid key value[" + attributeValue + "]", null);
            }
            throw new C0184n3("Type");
        }

        @Override // q3.n3.y
        public boolean gv(String str) {
            return "c".equals(str);
        }

        public final void mt(XmlPullParser xmlPullParser) throws ne {
            int size = this.f12707p.size();
            long i92 = i9(xmlPullParser, "t", -9223372036854775807L);
            int i = 1;
            if (i92 == -9223372036854775807L) {
                if (size == 0) {
                    i92 = 0;
                } else if (this.f12706mt != -1) {
                    i92 = this.f12707p.get(size - 1).longValue() + this.f12706mt;
                } else {
                    throw ne.v("Unable to infer start time", null);
                }
            }
            this.f12707p.add(Long.valueOf(i92));
            this.f12706mt = i9(xmlPullParser, "d", -9223372036854775807L);
            long i93 = i9(xmlPullParser, "r", 1L);
            if (i93 > 1 && this.f12706mt == -9223372036854775807L) {
                throw ne.v("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j2 = i;
                if (j2 < i93) {
                    this.f12707p.add(Long.valueOf((this.f12706mt * j2) + i92));
                    i++;
                } else {
                    return;
                }
            }
        }

        @Override // q3.n3.y
        public Object n3() {
            m[] mVarArr = new m[this.f12701a.size()];
            this.f12701a.toArray(mVarArr);
            return new y.n3(this.f12711v, this.f12703f, this.f12704fb, this.f12708s, this.f12702c5, this.f12705i9, this.f12709t, this.f12710tl, this.f12713wz, this.f12714xc, this.f12712w, mVarArr, this.f12707p, this.f12706mt);
        }

        public final void p(XmlPullParser xmlPullParser) throws ne {
            int co2 = co(xmlPullParser);
            this.f12704fb = co2;
            w("Type", Integer.valueOf(co2));
            if (this.f12704fb == 3) {
                this.f12708s = tl(xmlPullParser, "Subtype");
            } else {
                this.f12708s = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            w("Subtype", this.f12708s);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Name");
            this.f12705i9 = attributeValue;
            w("Name", attributeValue);
            this.f12703f = tl(xmlPullParser, "Url");
            this.f12709t = c5(xmlPullParser, "MaxWidth", -1);
            this.f12710tl = c5(xmlPullParser, "MaxHeight", -1);
            this.f12713wz = c5(xmlPullParser, "DisplayWidth", -1);
            this.f12714xc = c5(xmlPullParser, "DisplayHeight", -1);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "Language");
            this.f12712w = attributeValue2;
            w("Language", attributeValue2);
            long c52 = c5(xmlPullParser, "TimeScale", -1);
            this.f12702c5 = c52;
            if (c52 == -1) {
                this.f12702c5 = ((Long) zn("TimeScale")).longValue();
            }
            this.f12707p = new ArrayList<>();
        }

        @Override // q3.n3.y
        public void wz(XmlPullParser xmlPullParser) throws ne {
            if ("c".equals(xmlPullParser.getName())) {
                mt(xmlPullParser);
            } else {
                p(xmlPullParser);
            }
        }

        @Override // q3.n3.y
        public void y(Object obj) {
            if (obj instanceof m) {
                this.f12701a.add((m) obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class gv extends y {

        /* renamed from: v  reason: collision with root package name */
        public m f12715v;

        public gv(y yVar, String str) {
            super(yVar, str, "QualityLevel");
        }

        @Nullable
        public static String mt(String str) {
            if (!str.equalsIgnoreCase("H264") && !str.equalsIgnoreCase("X264") && !str.equalsIgnoreCase("AVC1") && !str.equalsIgnoreCase("DAVC")) {
                if (!str.equalsIgnoreCase("AAC") && !str.equalsIgnoreCase("AACL") && !str.equalsIgnoreCase("AACH") && !str.equalsIgnoreCase("AACP")) {
                    if (!str.equalsIgnoreCase("TTML") && !str.equalsIgnoreCase("DFXP")) {
                        if (!str.equalsIgnoreCase("ac-3") && !str.equalsIgnoreCase("dac3")) {
                            if (!str.equalsIgnoreCase("ec-3") && !str.equalsIgnoreCase("dec3")) {
                                if (str.equalsIgnoreCase("dtsc")) {
                                    return "audio/vnd.dts";
                                }
                                if (!str.equalsIgnoreCase("dtsh") && !str.equalsIgnoreCase("dtsl")) {
                                    if (str.equalsIgnoreCase("dtse")) {
                                        return "audio/vnd.dts.hd;profile=lbr";
                                    }
                                    if (str.equalsIgnoreCase("opus")) {
                                        return "audio/opus";
                                    }
                                    return null;
                                }
                                return "audio/vnd.dts.hd";
                            }
                            return "audio/eac3";
                        }
                        return "audio/ac3";
                    }
                    return "application/ttml+xml";
                }
                return "audio/mp4a-latm";
            }
            return "video/avc";
        }

        public static List<byte[]> p(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] a82 = j5.a8(str);
                byte[][] i92 = v5.a.i9(a82);
                if (i92 == null) {
                    arrayList.add(a82);
                } else {
                    Collections.addAll(arrayList, i92);
                }
            }
            return arrayList;
        }

        @Override // q3.n3.y
        public Object n3() {
            return this.f12715v;
        }

        @Override // q3.n3.y
        public void wz(XmlPullParser xmlPullParser) throws ne {
            int i;
            m.n3 n3Var = new m.n3();
            String mt2 = mt(tl(xmlPullParser, "FourCC"));
            int intValue = ((Integer) zn("Type")).intValue();
            if (intValue == 2) {
                n3Var.k5("video/mp4").s8(f(xmlPullParser, "MaxWidth")).o(f(xmlPullParser, "MaxHeight")).ut(p(xmlPullParser.getAttributeValue(null, "CodecPrivateData")));
            } else if (intValue == 1) {
                if (mt2 == null) {
                    mt2 = "audio/mp4a-latm";
                }
                int f4 = f(xmlPullParser, "Channels");
                int f6 = f(xmlPullParser, "SamplingRate");
                List<byte[]> p2 = p(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (p2.isEmpty() && "audio/mp4a-latm".equals(mt2)) {
                    p2 = Collections.singletonList(d9.y.y(f6, f4));
                }
                n3Var.k5("audio/mp4").a8(f4).rs(f6).ut(p2);
            } else if (intValue == 3) {
                String str = (String) zn("Subtype");
                if (str != null) {
                    if (!str.equals("CAPT")) {
                        if (str.equals("DESC")) {
                            i = 1024;
                        }
                    } else {
                        i = 64;
                    }
                    n3Var.k5("application/mp4").dm(i);
                }
                i = 0;
                n3Var.k5("application/mp4").dm(i);
            } else {
                n3Var.k5("application/mp4");
            }
            this.f12715v = n3Var.oz(xmlPullParser.getAttributeValue(null, "Index")).q9((String) zn("Name")).o4(mt2).ud(f(xmlPullParser, "Bitrate")).k((String) zn("Language")).z6();
        }
    }

    /* renamed from: q3.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0184n3 extends ne {
        public C0184n3(String str) {
            super("Missing required field: " + str, null, true, 4);
        }
    }

    /* loaded from: classes.dex */
    public static class v extends y {

        /* renamed from: a  reason: collision with root package name */
        public int f12716a;

        /* renamed from: c5  reason: collision with root package name */
        public long f12717c5;

        /* renamed from: f  reason: collision with root package name */
        public int f12718f;

        /* renamed from: fb  reason: collision with root package name */
        public int f12719fb;

        /* renamed from: i9  reason: collision with root package name */
        public long f12720i9;

        /* renamed from: s  reason: collision with root package name */
        public long f12721s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f12722t;
        @Nullable

        /* renamed from: tl  reason: collision with root package name */
        public y.C0185y f12723tl;

        /* renamed from: v  reason: collision with root package name */
        public final List<y.n3> f12724v;

        public v(y yVar, String str) {
            super(yVar, str, "SmoothStreamingMedia");
            this.f12718f = -1;
            this.f12724v = new LinkedList();
        }

        @Override // q3.n3.y
        public Object n3() {
            int size = this.f12724v.size();
            y.n3[] n3VarArr = new y.n3[size];
            this.f12724v.toArray(n3VarArr);
            if (this.f12723tl != null) {
                y.C0185y c0185y = this.f12723tl;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(c0185y.y, "video/mp4", c0185y.f12753n3));
                for (int i = 0; i < size; i++) {
                    y.n3 n3Var = n3VarArr[i];
                    int i5 = n3Var.y;
                    if (i5 == 2 || i5 == 1) {
                        m[] mVarArr = n3Var.f12743i9;
                        for (int i6 = 0; i6 < mVarArr.length; i6++) {
                            mVarArr[i6] = mVarArr[i6].n3().vl(drmInitData).z6();
                        }
                    }
                }
            }
            return new q3.y(this.f12716a, this.f12719fb, this.f12721s, this.f12717c5, this.f12720i9, this.f12718f, this.f12722t, this.f12723tl, n3VarArr);
        }

        @Override // q3.n3.y
        public void wz(XmlPullParser xmlPullParser) throws ne {
            this.f12716a = f(xmlPullParser, "MajorVersion");
            this.f12719fb = f(xmlPullParser, "MinorVersion");
            this.f12721s = i9(xmlPullParser, "TimeScale", 10000000L);
            this.f12717c5 = t(xmlPullParser, "Duration");
            this.f12720i9 = i9(xmlPullParser, "DVRWindowLength", 0L);
            this.f12718f = c5(xmlPullParser, "LookaheadCount", -1);
            this.f12722t = fb(xmlPullParser, "IsLive", false);
            w("TimeScale", Long.valueOf(this.f12721s));
        }

        @Override // q3.n3.y
        public void y(Object obj) {
            boolean z2;
            if (obj instanceof y.n3) {
                this.f12724v.add((y.n3) obj);
            } else if (obj instanceof y.C0185y) {
                if (this.f12723tl == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v5.y.fb(z2);
                this.f12723tl = (y.C0185y) obj;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends y {

        /* renamed from: a  reason: collision with root package name */
        public UUID f12728a;

        /* renamed from: fb  reason: collision with root package name */
        public byte[] f12729fb;

        /* renamed from: v  reason: collision with root package name */
        public boolean f12730v;

        public zn(y yVar, String str) {
            super(yVar, str, "Protection");
        }

        public static String co(String str) {
            if (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }

        public static byte[] mt(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bArr.length; i += 2) {
                sb.append((char) bArr[i]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            z(decode, 0, 3);
            z(decode, 1, 2);
            z(decode, 4, 5);
            z(decode, 6, 7);
            return decode;
        }

        public static w[] p(byte[] bArr) {
            return new w[]{new w(true, null, 8, mt(bArr), 0, 0, null)};
        }

        public static void z(byte[] bArr, int i, int i5) {
            byte b2 = bArr[i];
            bArr[i] = bArr[i5];
            bArr[i5] = b2;
        }

        @Override // q3.n3.y
        public boolean gv(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // q3.n3.y
        public Object n3() {
            UUID uuid = this.f12728a;
            return new y.C0185y(uuid, t.y(uuid, this.f12729fb), p(this.f12729fb));
        }

        @Override // q3.n3.y
        public void s(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f12730v = false;
            }
        }

        @Override // q3.n3.y
        public void wz(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f12730v = true;
                this.f12728a = UUID.fromString(co(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // q3.n3.y
        public void xc(XmlPullParser xmlPullParser) {
            if (this.f12730v) {
                this.f12729fb = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public n3() {
        try {
            this.y = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    @Override // kx.z6.y
    /* renamed from: n3 */
    public q3.y y(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.y.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (q3.y) new v(null, uri.toString()).a(newPullParser);
        } catch (XmlPullParserException e2) {
            throw ne.v(null, e2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class y {

        /* renamed from: gv  reason: collision with root package name */
        public final List<Pair<String, Object>> f12725gv = new LinkedList();

        /* renamed from: n3  reason: collision with root package name */
        public final String f12726n3;
        public final String y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final y f12727zn;

        public y(@Nullable y yVar, String str, String str2) {
            this.f12727zn = yVar;
            this.y = str;
            this.f12726n3 = str2;
        }

        public final Object a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z2 = false;
            int i = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType != 1) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            if (eventType == 4 && z2 && i == 0) {
                                xc(xmlPullParser);
                            }
                        } else if (!z2) {
                            continue;
                        } else if (i > 0) {
                            i--;
                        } else {
                            String name = xmlPullParser.getName();
                            s(xmlPullParser);
                            if (!gv(name)) {
                                return n3();
                            }
                        }
                    } else {
                        String name2 = xmlPullParser.getName();
                        if (this.f12726n3.equals(name2)) {
                            wz(xmlPullParser);
                            z2 = true;
                        } else if (z2) {
                            if (i > 0) {
                                i++;
                            } else if (gv(name2)) {
                                wz(xmlPullParser);
                            } else {
                                y v2 = v(this, name2, this.y);
                                if (v2 == null) {
                                    i = 1;
                                } else {
                                    y(v2.a(xmlPullParser));
                                }
                            }
                        }
                    }
                    xmlPullParser.next();
                } else {
                    return null;
                }
            }
        }

        public final int c5(XmlPullParser xmlPullParser, String str, int i) throws ne {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ne.v(null, e2);
                }
            }
            return i;
        }

        public final int f(XmlPullParser xmlPullParser, String str) throws ne {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ne.v(null, e2);
                }
            }
            throw new C0184n3(str);
        }

        public final boolean fb(XmlPullParser xmlPullParser, String str, boolean z2) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return Boolean.parseBoolean(attributeValue);
            }
            return z2;
        }

        public boolean gv(String str) {
            return false;
        }

        public final long i9(XmlPullParser xmlPullParser, String str, long j2) throws ne {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ne.v(null, e2);
                }
            }
            return j2;
        }

        public abstract Object n3();

        public final long t(XmlPullParser xmlPullParser, String str) throws ne {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ne.v(null, e2);
                }
            }
            throw new C0184n3(str);
        }

        public final String tl(XmlPullParser xmlPullParser, String str) throws C0184n3 {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new C0184n3(str);
        }

        public final y v(y yVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new gv(yVar, str2);
            }
            if ("Protection".equals(str)) {
                return new zn(yVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new a(yVar, str2);
            }
            return null;
        }

        public final void w(String str, @Nullable Object obj) {
            this.f12725gv.add(Pair.create(str, obj));
        }

        public abstract void wz(XmlPullParser xmlPullParser) throws ne;

        @Nullable
        public final Object zn(String str) {
            for (int i = 0; i < this.f12725gv.size(); i++) {
                Pair<String, Object> pair = this.f12725gv.get(i);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            y yVar = this.f12727zn;
            if (yVar == null) {
                return null;
            }
            return yVar.zn(str);
        }

        public void s(XmlPullParser xmlPullParser) {
        }

        public void xc(XmlPullParser xmlPullParser) {
        }

        public void y(Object obj) {
        }
    }
}
