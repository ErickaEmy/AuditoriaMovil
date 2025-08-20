package sc;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.drm.DrmInitData;
import d9.y;
import e4.d;
import e4.d0;
import e4.fh;
import e4.mt;
import e4.p;
import e4.t;
import e4.ta;
import e4.tl;
import e4.wz;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import m1.c5;
import m1.m;
import m1.ne;
import v5.c;
import v5.j5;
import v5.n;
import v5.r;
import v5.rz;
import v5.x4;
/* loaded from: classes.dex */
public class v implements t {

    /* renamed from: eb  reason: collision with root package name */
    public static final Map<String, Integer> f13530eb;

    /* renamed from: a  reason: collision with root package name */
    public final rz f13535a;

    /* renamed from: a8  reason: collision with root package name */
    public int f13536a8;

    /* renamed from: b  reason: collision with root package name */
    public int[] f13537b;

    /* renamed from: c  reason: collision with root package name */
    public long f13538c;

    /* renamed from: c5  reason: collision with root package name */
    public final rz f13539c5;

    /* renamed from: co  reason: collision with root package name */
    public long f13540co;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13541d;

    /* renamed from: d0  reason: collision with root package name */
    public long f13542d0;

    /* renamed from: ej  reason: collision with root package name */
    public long f13543ej;

    /* renamed from: en  reason: collision with root package name */
    public byte f13544en;

    /* renamed from: f  reason: collision with root package name */
    public final rz f13545f;

    /* renamed from: f3  reason: collision with root package name */
    public long f13546f3;

    /* renamed from: f7  reason: collision with root package name */
    public int f13547f7;

    /* renamed from: fb  reason: collision with root package name */
    public final rz f13548fb;

    /* renamed from: fh  reason: collision with root package name */
    public long f13549fh;

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f13550gv;

    /* renamed from: hw  reason: collision with root package name */
    public int f13551hw;

    /* renamed from: i4  reason: collision with root package name */
    public int f13552i4;

    /* renamed from: i9  reason: collision with root package name */
    public final rz f13553i9;

    /* renamed from: j  reason: collision with root package name */
    public int f13554j;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f13555j5;

    /* renamed from: jz  reason: collision with root package name */
    public boolean f13556jz;

    /* renamed from: k  reason: collision with root package name */
    public boolean f13557k;

    /* renamed from: k5  reason: collision with root package name */
    public int f13558k5;
    @Nullable

    /* renamed from: mg  reason: collision with root package name */
    public x4 f13559mg;

    /* renamed from: mt  reason: collision with root package name */
    public long f13560mt;

    /* renamed from: n  reason: collision with root package name */
    public boolean f13561n;

    /* renamed from: n3  reason: collision with root package name */
    public final fb f13562n3;

    /* renamed from: o  reason: collision with root package name */
    public int f13563o;

    /* renamed from: oz  reason: collision with root package name */
    public int f13564oz;

    /* renamed from: p  reason: collision with root package name */
    public long f13565p;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f13566q9;

    /* renamed from: qn  reason: collision with root package name */
    public long f13567qn;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public zn f13568r;
    @Nullable

    /* renamed from: rz  reason: collision with root package name */
    public x4 f13569rz;

    /* renamed from: s  reason: collision with root package name */
    public final rz f13570s;

    /* renamed from: t  reason: collision with root package name */
    public final rz f13571t;

    /* renamed from: ta  reason: collision with root package name */
    public boolean f13572ta;

    /* renamed from: tl  reason: collision with root package name */
    public final rz f13573tl;

    /* renamed from: u  reason: collision with root package name */
    public wz f13574u;

    /* renamed from: ud  reason: collision with root package name */
    public long f13575ud;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f13576ut;

    /* renamed from: v  reason: collision with root package name */
    public final rz f13577v;

    /* renamed from: vl  reason: collision with root package name */
    public int f13578vl;

    /* renamed from: w  reason: collision with root package name */
    public long f13579w;

    /* renamed from: wz  reason: collision with root package name */
    public final rz f13580wz;

    /* renamed from: x  reason: collision with root package name */
    public int f13581x;

    /* renamed from: x4  reason: collision with root package name */
    public boolean f13582x4;

    /* renamed from: xc  reason: collision with root package name */
    public ByteBuffer f13583xc;
    public final sc.zn y;

    /* renamed from: yt  reason: collision with root package name */
    public int f13584yt;

    /* renamed from: z  reason: collision with root package name */
    public long f13585z;

    /* renamed from: z6  reason: collision with root package name */
    public int f13586z6;

    /* renamed from: zn  reason: collision with root package name */
    public final SparseArray<zn> f13587zn;

    /* renamed from: y5  reason: collision with root package name */
    public static final mt f13534y5 = new mt() { // from class: sc.gv
        @Override // e4.mt
        public final t[] createExtractors() {
            t[] d02;
            d02 = v.d0();
            return d02;
        }

        @Override // e4.mt
        public /* synthetic */ t[] y(Uri uri, Map map) {
            return p.y(this, uri, map);
        }
    };

    /* renamed from: xg  reason: collision with root package name */
    public static final byte[] f13533xg = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: dm  reason: collision with root package name */
    public static final byte[] f13529dm = j5.ap("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: ct  reason: collision with root package name */
    public static final byte[] f13528ct = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: o4  reason: collision with root package name */
    public static final byte[] f13531o4 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* renamed from: rs  reason: collision with root package name */
    public static final UUID f13532rs = new UUID(72057594037932032L, -9223371306706625679L);

    /* loaded from: classes.dex */
    public final class n3 implements sc.n3 {
        public n3() {
        }

        @Override // sc.n3
        public boolean a(int i) {
            return v.this.c(i);
        }

        @Override // sc.n3
        public void fb(int i, String str) throws ne {
            v.this.ej(i, str);
        }

        @Override // sc.n3
        public void gv(int i, long j2) throws ne {
            v.this.f3(i, j2);
        }

        @Override // sc.n3
        public void n3(int i, double d2) throws ne {
            v.this.mt(i, d2);
        }

        @Override // sc.n3
        public void s(int i, long j2, long j4) throws ne {
            v.this.z6(i, j2, j4);
        }

        @Override // sc.n3
        public int v(int i) {
            return v.this.r(i);
        }

        @Override // sc.n3
        public void y(int i) throws ne {
            v.this.xc(i);
        }

        @Override // sc.n3
        public void zn(int i, int i5, tl tlVar) throws IOException {
            v.this.t(i, i5, tlVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: a  reason: collision with root package name */
        public int f13588a;

        /* renamed from: c5  reason: collision with root package name */
        public byte[] f13592c5;

        /* renamed from: co  reason: collision with root package name */
        public float f13593co;

        /* renamed from: f  reason: collision with root package name */
        public byte[] f13597f;

        /* renamed from: f3  reason: collision with root package name */
        public boolean f13598f3;

        /* renamed from: f7  reason: collision with root package name */
        public int f13599f7;

        /* renamed from: fb  reason: collision with root package name */
        public int f13600fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f13602gv;

        /* renamed from: i9  reason: collision with root package name */
        public ta.y f13605i9;

        /* renamed from: j  reason: collision with root package name */
        public d f13606j;

        /* renamed from: k  reason: collision with root package name */
        public ta f13608k;

        /* renamed from: n3  reason: collision with root package name */
        public String f13613n3;

        /* renamed from: o  reason: collision with root package name */
        public long f13614o;

        /* renamed from: oz  reason: collision with root package name */
        public boolean f13615oz;

        /* renamed from: p  reason: collision with root package name */
        public int f13616p;

        /* renamed from: qn  reason: collision with root package name */
        public long f13618qn;

        /* renamed from: r  reason: collision with root package name */
        public float f13619r;

        /* renamed from: s  reason: collision with root package name */
        public boolean f13621s;

        /* renamed from: t  reason: collision with root package name */
        public DrmInitData f13622t;

        /* renamed from: v  reason: collision with root package name */
        public int f13627v;

        /* renamed from: x4  reason: collision with root package name */
        public byte[] f13632x4;
        public String y;

        /* renamed from: yt  reason: collision with root package name */
        public byte[] f13634yt;

        /* renamed from: z  reason: collision with root package name */
        public float f13635z;

        /* renamed from: zn  reason: collision with root package name */
        public int f13637zn;

        /* renamed from: tl  reason: collision with root package name */
        public int f13624tl = -1;

        /* renamed from: wz  reason: collision with root package name */
        public int f13630wz = -1;

        /* renamed from: xc  reason: collision with root package name */
        public int f13633xc = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f13629w = -1;

        /* renamed from: mt  reason: collision with root package name */
        public int f13611mt = -1;

        /* renamed from: i4  reason: collision with root package name */
        public int f13604i4 = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f13612n = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f13591c = -1;

        /* renamed from: d0  reason: collision with root package name */
        public int f13595d0 = -1;

        /* renamed from: fh  reason: collision with root package name */
        public int f13601fh = 1000;

        /* renamed from: rz  reason: collision with root package name */
        public int f13620rz = 200;

        /* renamed from: mg  reason: collision with root package name */
        public float f13610mg = -1.0f;

        /* renamed from: ta  reason: collision with root package name */
        public float f13623ta = -1.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f13594d = -1.0f;

        /* renamed from: z6  reason: collision with root package name */
        public float f13636z6 = -1.0f;

        /* renamed from: ej  reason: collision with root package name */
        public float f13596ej = -1.0f;

        /* renamed from: ud  reason: collision with root package name */
        public float f13625ud = -1.0f;

        /* renamed from: a8  reason: collision with root package name */
        public float f13589a8 = -1.0f;

        /* renamed from: x  reason: collision with root package name */
        public float f13631x = -1.0f;

        /* renamed from: b  reason: collision with root package name */
        public float f13590b = -1.0f;

        /* renamed from: k5  reason: collision with root package name */
        public float f13609k5 = -1.0f;

        /* renamed from: vl  reason: collision with root package name */
        public int f13628vl = 1;

        /* renamed from: hw  reason: collision with root package name */
        public int f13603hw = -1;

        /* renamed from: j5  reason: collision with root package name */
        public int f13607j5 = 8000;

        /* renamed from: ut  reason: collision with root package name */
        public boolean f13626ut = true;

        /* renamed from: q9  reason: collision with root package name */
        public String f13617q9 = "eng";

        public static Pair<String, List<byte[]>> f(rz rzVar) throws ne {
            try {
                rzVar.ut(16);
                long f32 = rzVar.f3();
                if (f32 == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (f32 == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (f32 == 826496599) {
                    byte[] v2 = rzVar.v();
                    for (int a2 = rzVar.a() + 20; a2 < v2.length - 4; a2++) {
                        if (v2[a2] == 0 && v2[a2 + 1] == 0 && v2[a2 + 2] == 1 && v2[a2 + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(v2, a2, v2.length)));
                        }
                    }
                    throw ne.y("Failed to find FourCC VC1 initialization data", null);
                }
                r.c5("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ne.y("Error parsing FourCC private data", null);
            }
        }

        public static boolean t(rz rzVar) throws ne {
            try {
                int c2 = rzVar.c();
                if (c2 == 1) {
                    return true;
                }
                if (c2 != 65534) {
                    return false;
                }
                rzVar.oz(24);
                if (rzVar.d0() == v.f13532rs.getMostSignificantBits()) {
                    if (rzVar.d0() == v.f13532rs.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ne.y("Error parsing MS/ACM codec private", null);
            }
        }

        public static List<byte[]> tl(byte[] bArr) throws ne {
            int i;
            int i5;
            try {
                if (bArr[0] == 2) {
                    int i6 = 1;
                    int i8 = 0;
                    while (true) {
                        i = bArr[i6];
                        if ((i & 255) != 255) {
                            break;
                        }
                        i8 += 255;
                        i6++;
                    }
                    int i10 = i6 + 1;
                    int i11 = i8 + (i & 255);
                    int i12 = 0;
                    while (true) {
                        i5 = bArr[i10];
                        if ((i5 & 255) != 255) {
                            break;
                        }
                        i12 += 255;
                        i10++;
                    }
                    int i13 = i10 + 1;
                    int i14 = i12 + (i5 & 255);
                    if (bArr[i13] == 1) {
                        byte[] bArr2 = new byte[i11];
                        System.arraycopy(bArr, i13, bArr2, 0, i11);
                        int i15 = i13 + i11;
                        if (bArr[i15] == 3) {
                            int i16 = i15 + i14;
                            if (bArr[i16] == 5) {
                                byte[] bArr3 = new byte[bArr.length - i16];
                                System.arraycopy(bArr, i16, bArr3, 0, bArr.length - i16);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw ne.y("Error parsing vorbis codec private", null);
                        }
                        throw ne.y("Error parsing vorbis codec private", null);
                    }
                    throw ne.y("Error parsing vorbis codec private", null);
                }
                throw ne.y("Error parsing vorbis codec private", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ne.y("Error parsing vorbis codec private", null);
            }
        }

        public final void a() {
            v5.y.v(this.f13608k);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void c5(wz wzVar, int i) throws ne {
            char c2;
            List<byte[]> singletonList;
            int i5;
            String str;
            int i6;
            List<byte[]> list;
            String str2;
            int i8;
            int i10;
            int i11;
            int i12;
            wn.gv y;
            String str3 = this.f13613n3;
            str3.hashCode();
            String str4 = "audio/raw";
            switch (str3.hashCode()) {
                case -2095576542:
                    if (str3.equals("V_MPEG4/ISO/AP")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2095575984:
                    if (str3.equals("V_MPEG4/ISO/SP")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1985379776:
                    if (str3.equals("A_MS/ACM")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1784763192:
                    if (str3.equals("A_TRUEHD")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1730367663:
                    if (str3.equals("A_VORBIS")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1482641358:
                    if (str3.equals("A_MPEG/L2")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1482641357:
                    if (str3.equals("A_MPEG/L3")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1373388978:
                    if (str3.equals("V_MS/VFW/FOURCC")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -933872740:
                    if (str3.equals("S_DVBSUB")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -538363189:
                    if (str3.equals("V_MPEG4/ISO/ASP")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -538363109:
                    if (str3.equals("V_MPEG4/ISO/AVC")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -425012669:
                    if (str3.equals("S_VOBSUB")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -356037306:
                    if (str3.equals("A_DTS/LOSSLESS")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 62923557:
                    if (str3.equals("A_AAC")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 62923603:
                    if (str3.equals("A_AC3")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 62927045:
                    if (str3.equals("A_DTS")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 82318131:
                    if (str3.equals("V_AV1")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 82338133:
                    if (str3.equals("V_VP8")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 82338134:
                    if (str3.equals("V_VP9")) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 99146302:
                    if (str3.equals("S_HDMV/PGS")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 444813526:
                    if (str3.equals("V_THEORA")) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 542569478:
                    if (str3.equals("A_DTS/EXPRESS")) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 635596514:
                    if (str3.equals("A_PCM/FLOAT/IEEE")) {
                        c2 = 22;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 725948237:
                    if (str3.equals("A_PCM/INT/BIG")) {
                        c2 = 23;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 725957860:
                    if (str3.equals("A_PCM/INT/LIT")) {
                        c2 = 24;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 738597099:
                    if (str3.equals("S_TEXT/ASS")) {
                        c2 = 25;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 855502857:
                    if (str3.equals("V_MPEGH/ISO/HEVC")) {
                        c2 = 26;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1045209816:
                    if (str3.equals("S_TEXT/WEBVTT")) {
                        c2 = 27;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1422270023:
                    if (str3.equals("S_TEXT/UTF8")) {
                        c2 = 28;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1809237540:
                    if (str3.equals("V_MPEG2")) {
                        c2 = 29;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1950749482:
                    if (str3.equals("A_EAC3")) {
                        c2 = 30;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1950789798:
                    if (str3.equals("A_FLAC")) {
                        c2 = 31;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1951062397:
                    if (str3.equals("A_OPUS")) {
                        c2 = ' ';
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
                case 1:
                case '\t':
                    byte[] bArr = this.f13597f;
                    singletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str4 = "video/mp4v-es";
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 2:
                    if (t(new rz(fb(this.f13613n3)))) {
                        int xg2 = j5.xg(this.f13603hw);
                        if (xg2 != 0) {
                            i5 = xg2;
                            singletonList = null;
                            str = null;
                            i6 = -1;
                            break;
                        } else {
                            r.c5("MatroskaExtractor", "Unsupported PCM bit depth: " + this.f13603hw + ". Setting mimeType to audio/x-unknown");
                        }
                    } else {
                        r.c5("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    }
                    str4 = "audio/x-unknown";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                case 3:
                    this.f13606j = new d();
                    str4 = "audio/true-hd";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 4:
                    singletonList = tl(fb(this.f13613n3));
                    str4 = "audio/vorbis";
                    i6 = 8192;
                    str = null;
                    i5 = -1;
                    break;
                case 5:
                    str4 = "audio/mpeg-L2";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = 4096;
                    break;
                case 6:
                    str4 = "audio/mpeg";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = 4096;
                    break;
                case 7:
                    Pair<String, List<byte[]>> f4 = f(new rz(fb(this.f13613n3)));
                    str4 = (String) f4.first;
                    singletonList = (List) f4.second;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case '\b':
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(fb(this.f13613n3), 0, bArr2, 0, 4);
                    singletonList = z0.x4.o(bArr2);
                    str4 = "application/dvbsubs";
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case '\n':
                    wn.y n32 = wn.y.n3(new rz(fb(this.f13613n3)));
                    list = n32.y;
                    this.f13599f7 = n32.f14649n3;
                    str2 = n32.f14647a;
                    str4 = "video/avc";
                    i5 = -1;
                    i6 = -1;
                    List<byte[]> list2 = list;
                    str = str2;
                    singletonList = list2;
                    break;
                case 11:
                    singletonList = z0.x4.o(fb(this.f13613n3));
                    str4 = "application/vobsub";
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case '\f':
                    str4 = "audio/vnd.dts.hd";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case '\r':
                    singletonList = Collections.singletonList(fb(this.f13613n3));
                    y.n3 a2 = d9.y.a(this.f13597f);
                    this.f13607j5 = a2.y;
                    this.f13628vl = a2.f7226n3;
                    str = a2.f7227zn;
                    str4 = "audio/mp4a-latm";
                    i5 = -1;
                    i6 = -1;
                    break;
                case 14:
                    str4 = "audio/ac3";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 15:
                case 21:
                    str4 = "audio/vnd.dts";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 16:
                    str4 = "video/av01";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 17:
                    str4 = "video/x-vnd.on2.vp8";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 18:
                    str4 = "video/x-vnd.on2.vp9";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 19:
                    str4 = "application/pgs";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 20:
                    str4 = "video/x-unknown";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 22:
                    if (this.f13603hw == 32) {
                        singletonList = null;
                        str = null;
                        i5 = 4;
                        i6 = -1;
                        break;
                    } else {
                        r.c5("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.f13603hw + ". Setting mimeType to audio/x-unknown");
                        str4 = "audio/x-unknown";
                        singletonList = null;
                        str = null;
                        i5 = -1;
                        i6 = -1;
                    }
                case 23:
                    int i13 = this.f13603hw;
                    if (i13 == 8) {
                        singletonList = null;
                        str = null;
                        i5 = 3;
                    } else if (i13 == 16) {
                        singletonList = null;
                        str = null;
                        i5 = 268435456;
                    } else {
                        r.c5("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.f13603hw + ". Setting mimeType to audio/x-unknown");
                        str4 = "audio/x-unknown";
                        singletonList = null;
                        str = null;
                        i5 = -1;
                    }
                    i6 = -1;
                    break;
                case 24:
                    int xg3 = j5.xg(this.f13603hw);
                    if (xg3 == 0) {
                        r.c5("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.f13603hw + ". Setting mimeType to audio/x-unknown");
                        str4 = "audio/x-unknown";
                        singletonList = null;
                        str = null;
                        i5 = -1;
                        i6 = -1;
                        break;
                    } else {
                        i5 = xg3;
                        singletonList = null;
                        str = null;
                        i6 = -1;
                    }
                case 25:
                    singletonList = z0.x4.j(v.f13529dm, fb(this.f13613n3));
                    str4 = "text/x-ssa";
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 26:
                    wn.a y2 = wn.a.y(new rz(fb(this.f13613n3)));
                    list = y2.y;
                    this.f13599f7 = y2.f14555n3;
                    str2 = y2.f14552c5;
                    str4 = "video/hevc";
                    i5 = -1;
                    i6 = -1;
                    List<byte[]> list22 = list;
                    str = str2;
                    singletonList = list22;
                    break;
                case 27:
                    str4 = "text/vtt";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 28:
                    str4 = "application/x-subrip";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 29:
                    str4 = "video/mpeg2";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 30:
                    str4 = "audio/eac3";
                    singletonList = null;
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case 31:
                    singletonList = Collections.singletonList(fb(this.f13613n3));
                    str4 = "audio/flac";
                    str = null;
                    i5 = -1;
                    i6 = -1;
                    break;
                case ' ':
                    singletonList = new ArrayList<>(3);
                    singletonList.add(fb(this.f13613n3));
                    ByteBuffer allocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    singletonList.add(allocate.order(byteOrder).putLong(this.f13618qn).array());
                    singletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.f13614o).array());
                    str4 = "audio/opus";
                    i6 = 5760;
                    str = null;
                    i5 = -1;
                    break;
                default:
                    throw ne.y("Unrecognized codec identifier.", null);
            }
            if (this.f13634yt != null && (y = wn.gv.y(new rz(this.f13634yt))) != null) {
                str = y.f14586zn;
                str4 = "video/dolby-vision";
            }
            String str5 = str4;
            int i14 = (this.f13615oz ? 2 : 0) | (this.f13626ut ? 1 : 0);
            m.n3 n3Var = new m.n3();
            if (n.xc(str5)) {
                n3Var.a8(this.f13628vl).rs(this.f13607j5).jz(i5);
                i8 = 1;
            } else if (n.co(str5)) {
                if (this.f13616p == 0) {
                    int i15 = this.f13633xc;
                    i10 = -1;
                    if (i15 == -1) {
                        i15 = this.f13624tl;
                    }
                    this.f13633xc = i15;
                    int i16 = this.f13629w;
                    if (i16 == -1) {
                        i16 = this.f13630wz;
                    }
                    this.f13629w = i16;
                } else {
                    i10 = -1;
                }
                float f6 = (this.f13633xc == i10 || (i12 = this.f13629w) == i10) ? -1.0f : (this.f13630wz * i11) / (this.f13624tl * i12);
                wn.zn znVar = this.f13598f3 ? new wn.zn(this.f13612n, this.f13595d0, this.f13591c, s()) : null;
                if (this.y != null && v.f13530eb.containsKey(this.y)) {
                    i10 = ((Integer) v.f13530eb.get(this.y)).intValue();
                }
                if (this.f13611mt == 0 && Float.compare(this.f13593co, 0.0f) == 0 && Float.compare(this.f13635z, 0.0f) == 0) {
                    if (Float.compare(this.f13619r, 0.0f) == 0) {
                        i10 = 0;
                    } else if (Float.compare(this.f13635z, 90.0f) == 0) {
                        i10 = 90;
                    } else if (Float.compare(this.f13635z, -180.0f) == 0 || Float.compare(this.f13635z, 180.0f) == 0) {
                        i10 = 180;
                    } else if (Float.compare(this.f13635z, -90.0f) == 0) {
                        i10 = 270;
                    }
                }
                n3Var.s8(this.f13624tl).o(this.f13630wz).y5(f6).ct(i10).xg(this.f13632x4).lc(this.f13604i4).b(znVar);
                i8 = 2;
            } else if (!"application/x-subrip".equals(str5) && !"text/x-ssa".equals(str5) && !"text/vtt".equals(str5) && !"application/vobsub".equals(str5) && !"application/pgs".equals(str5) && !"application/dvbsubs".equals(str5)) {
                throw ne.y("Unexpected MIME type.", null);
            } else {
                i8 = 3;
            }
            if (this.y != null && !v.f13530eb.containsKey(this.y)) {
                n3Var.q9(this.y);
            }
            m z62 = n3Var.j(i).o4(str5).f7(i6).k(this.f13617q9).eb(i14).ut(singletonList).x(str).vl(this.f13622t).z6();
            ta a3 = wzVar.a(this.f13637zn, i8);
            this.f13608k = a3;
            a3.v(z62);
        }

        public final byte[] fb(String str) throws ne {
            byte[] bArr = this.f13597f;
            if (bArr != null) {
                return bArr;
            }
            throw ne.y("Missing CodecPrivate for codec " + str, null);
        }

        public void i9() {
            d dVar = this.f13606j;
            if (dVar != null) {
                dVar.y(this.f13608k, this.f13605i9);
            }
        }

        @Nullable
        public final byte[] s() {
            if (this.f13610mg != -1.0f && this.f13623ta != -1.0f && this.f13594d != -1.0f && this.f13636z6 != -1.0f && this.f13596ej != -1.0f && this.f13625ud != -1.0f && this.f13589a8 != -1.0f && this.f13631x != -1.0f && this.f13590b != -1.0f && this.f13609k5 != -1.0f) {
                byte[] bArr = new byte[25];
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                order.put((byte) 0);
                order.putShort((short) ((this.f13610mg * 50000.0f) + 0.5f));
                order.putShort((short) ((this.f13623ta * 50000.0f) + 0.5f));
                order.putShort((short) ((this.f13594d * 50000.0f) + 0.5f));
                order.putShort((short) ((this.f13636z6 * 50000.0f) + 0.5f));
                order.putShort((short) ((this.f13596ej * 50000.0f) + 0.5f));
                order.putShort((short) ((this.f13625ud * 50000.0f) + 0.5f));
                order.putShort((short) ((this.f13589a8 * 50000.0f) + 0.5f));
                order.putShort((short) ((this.f13631x * 50000.0f) + 0.5f));
                order.putShort((short) (this.f13590b + 0.5f));
                order.putShort((short) (this.f13609k5 + 0.5f));
                order.putShort((short) this.f13601fh);
                order.putShort((short) this.f13620rz);
                return bArr;
            }
            return null;
        }

        public void wz() {
            d dVar = this.f13606j;
            if (dVar != null) {
                dVar.n3();
            }
        }

        public final boolean xc(boolean z2) {
            if ("A_OPUS".equals(this.f13613n3)) {
                return z2;
            }
            if (this.f13588a > 0) {
                return true;
            }
            return false;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f13530eb = Collections.unmodifiableMap(hashMap);
    }

    public v() {
        this(0);
    }

    public static byte[] co(long j2, String str, long j4) {
        boolean z2;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        int i = (int) (j2 / 3600000000L);
        long j6 = j2 - (i * 3600000000L);
        int i5 = (int) (j6 / 60000000);
        long j7 = j6 - (i5 * 60000000);
        int i6 = (int) (j7 / 1000000);
        return j5.ap(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf((int) ((j7 - (i6 * 1000000)) / j4))));
    }

    public static void d(String str, long j2, byte[] bArr) {
        byte[] co2;
        int i;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                co2 = co(j2, "%01d:%02d:%02d:%02d", 10000L);
                i = 21;
                break;
            case 1:
                co2 = co(j2, "%02d:%02d:%02d.%03d", 1000L);
                i = 25;
                break;
            case 2:
                co2 = co(j2, "%02d:%02d:%02d,%03d", 1000L);
                i = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(co2, 0, bArr, i, co2.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t[] d0() {
        return new t[]{new v()};
    }

    private void f() {
        v5.y.c5(this.f13574u);
    }

    public static boolean n(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    c2 = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    c2 = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    c2 = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    c2 = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    c2 = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    c2 = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    c2 = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    c2 = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    c2 = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    c2 = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    c2 = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    c2 = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    c2 = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    c2 = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c2 = 25;
                    break;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    c2 = 26;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    c2 = 27;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c2 = 28;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    c2 = 29;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    c2 = 30;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    c2 = 31;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    c2 = ' ';
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
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case ' ':
                return true;
            default:
                return false;
        }
    }

    public static int[] w(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i)];
    }

    @Override // e4.t
    public final boolean a(tl tlVar) throws IOException {
        return new a().n3(tlVar);
    }

    public final void a8(tl tlVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        if (this.f13545f.n3() < length) {
            this.f13545f.qn(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.f13545f.v(), 0, bArr.length);
        }
        tlVar.readFully(this.f13545f.v(), bArr.length, i);
        this.f13545f.oz(0);
        this.f13545f.j(length);
    }

    public final void b(tl tlVar, byte[] bArr, int i, int i5) throws IOException {
        int min = Math.min(i5, this.f13553i9.y());
        tlVar.readFully(bArr, i + min, i5 - min);
        if (min > 0) {
            this.f13553i9.t(bArr, i, min);
        }
    }

    public boolean c(int i) {
        if (i != 357149030 && i != 524531317 && i != 475249515 && i != 374648427) {
            return false;
        }
        return true;
    }

    public final void c5(int i) throws ne {
        if (this.f13569rz != null && this.f13559mg != null) {
            return;
        }
        throw ne.y("Element " + i + " must be in a Cues", null);
    }

    public void ej(int i, String str) throws ne {
        if (i != 134) {
            if (i != 17026) {
                if (i != 21358) {
                    if (i == 2274716) {
                        z(i).f13617q9 = str;
                        return;
                    }
                    return;
                }
                z(i).y = str;
                return;
            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                throw ne.y("DocType " + str + " not supported", null);
            } else {
                return;
            }
        }
        z(i).f13613n3 = str;
    }

    public void f3(int i, long j2) throws ne {
        if (i != 20529) {
            if (i != 20530) {
                boolean z2 = false;
                switch (i) {
                    case 131:
                        z(i).f13602gv = (int) j2;
                        return;
                    case 136:
                        zn z3 = z(i);
                        if (j2 == 1) {
                            z2 = true;
                        }
                        z3.f13626ut = z2;
                        return;
                    case 155:
                        this.f13575ud = ta(j2);
                        return;
                    case 159:
                        z(i).f13628vl = (int) j2;
                        return;
                    case 176:
                        z(i).f13624tl = (int) j2;
                        return;
                    case 179:
                        c5(i);
                        this.f13569rz.y(ta(j2));
                        return;
                    case 186:
                        z(i).f13630wz = (int) j2;
                        return;
                    case 215:
                        z(i).f13637zn = (int) j2;
                        return;
                    case 231:
                        this.f13549fh = ta(j2);
                        return;
                    case 238:
                        this.f13551hw = (int) j2;
                        return;
                    case 241:
                        if (!this.f13572ta) {
                            c5(i);
                            this.f13559mg.y(j2);
                            this.f13572ta = true;
                            return;
                        }
                        return;
                    case 251:
                        this.f13555j5 = true;
                        return;
                    case 16871:
                        z(i).f13600fb = (int) j2;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            throw ne.y("ContentCompAlgo " + j2 + " not supported", null);
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            throw ne.y("DocTypeReadVersion " + j2 + " not supported", null);
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            throw ne.y("EBMLReadVersion " + j2 + " not supported", null);
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            throw ne.y("ContentEncAlgo " + j2 + " not supported", null);
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            throw ne.y("AESSettingsCipherMode " + j2 + " not supported", null);
                        }
                        return;
                    case 21420:
                        this.f13546f3 = j2 + this.f13565p;
                        return;
                    case 21432:
                        int i5 = (int) j2;
                        i9(i);
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 3) {
                                    if (i5 == 15) {
                                        this.f13568r.f13604i4 = 3;
                                        return;
                                    }
                                    return;
                                }
                                this.f13568r.f13604i4 = 1;
                                return;
                            }
                            this.f13568r.f13604i4 = 2;
                            return;
                        }
                        this.f13568r.f13604i4 = 0;
                        return;
                    case 21680:
                        z(i).f13633xc = (int) j2;
                        return;
                    case 21682:
                        z(i).f13616p = (int) j2;
                        return;
                    case 21690:
                        z(i).f13629w = (int) j2;
                        return;
                    case 21930:
                        zn z4 = z(i);
                        if (j2 == 1) {
                            z2 = true;
                        }
                        z4.f13615oz = z2;
                        return;
                    case 21998:
                        z(i).f13588a = (int) j2;
                        return;
                    case 22186:
                        z(i).f13618qn = j2;
                        return;
                    case 22203:
                        z(i).f13614o = j2;
                        return;
                    case 25188:
                        z(i).f13603hw = (int) j2;
                        return;
                    case 30114:
                        this.f13567qn = j2;
                        return;
                    case 30321:
                        i9(i);
                        int i6 = (int) j2;
                        if (i6 != 0) {
                            if (i6 != 1) {
                                if (i6 != 2) {
                                    if (i6 == 3) {
                                        this.f13568r.f13611mt = 3;
                                        return;
                                    }
                                    return;
                                }
                                this.f13568r.f13611mt = 2;
                                return;
                            }
                            this.f13568r.f13611mt = 1;
                            return;
                        }
                        this.f13568r.f13611mt = 0;
                        return;
                    case 2352003:
                        z(i).f13627v = (int) j2;
                        return;
                    case 2807729:
                        this.f13560mt = j2;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                i9(i);
                                int i8 = (int) j2;
                                if (i8 != 1) {
                                    if (i8 == 2) {
                                        this.f13568r.f13595d0 = 1;
                                        return;
                                    }
                                    return;
                                }
                                this.f13568r.f13595d0 = 2;
                                return;
                            case 21946:
                                i9(i);
                                int zn2 = wn.zn.zn((int) j2);
                                if (zn2 != -1) {
                                    this.f13568r.f13591c = zn2;
                                    return;
                                }
                                return;
                            case 21947:
                                i9(i);
                                this.f13568r.f13598f3 = true;
                                int n32 = wn.zn.n3((int) j2);
                                if (n32 != -1) {
                                    this.f13568r.f13612n = n32;
                                    return;
                                }
                                return;
                            case 21948:
                                z(i).f13601fh = (int) j2;
                                return;
                            case 21949:
                                z(i).f13620rz = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                throw ne.y("ContentEncodingScope " + j2 + " not supported", null);
            }
        } else if (j2 == 0) {
        } else {
            throw ne.y("ContentEncodingOrder " + j2 + " not supported", null);
        }
    }

    public final boolean fh(d0 d0Var, long j2) {
        if (this.f13561n) {
            this.f13542d0 = j2;
            d0Var.y = this.f13538c;
            this.f13561n = false;
            return true;
        }
        if (this.f13582x4) {
            long j4 = this.f13542d0;
            if (j4 != -1) {
                d0Var.y = j4;
                this.f13542d0 = -1L;
                return true;
            }
        }
        return false;
    }

    public void i4(zn znVar, int i, tl tlVar, int i5) throws IOException {
        if (i == 4 && "V_VP9".equals(znVar.f13613n3)) {
            this.f13580wz.j5(i5);
            tlVar.readFully(this.f13580wz.v(), 0, i5);
            return;
        }
        tlVar.p(i5);
    }

    public final void i9(int i) throws ne {
        if (this.f13568r != null) {
            return;
        }
        throw ne.y("Element " + i + " must be in a TrackEntry", null);
    }

    public final void mg() {
        this.f13563o = 0;
        this.f13554j = 0;
        this.f13564oz = 0;
        this.f13576ut = false;
        this.f13566q9 = false;
        this.f13557k = false;
        this.f13547f7 = 0;
        this.f13544en = (byte) 0;
        this.f13556jz = false;
        this.f13553i9.j5(0);
    }

    public void mt(int i, double d2) throws ne {
        if (i != 181) {
            if (i != 17545) {
                switch (i) {
                    case 21969:
                        z(i).f13610mg = (float) d2;
                        return;
                    case 21970:
                        z(i).f13623ta = (float) d2;
                        return;
                    case 21971:
                        z(i).f13594d = (float) d2;
                        return;
                    case 21972:
                        z(i).f13636z6 = (float) d2;
                        return;
                    case 21973:
                        z(i).f13596ej = (float) d2;
                        return;
                    case 21974:
                        z(i).f13625ud = (float) d2;
                        return;
                    case 21975:
                        z(i).f13589a8 = (float) d2;
                        return;
                    case 21976:
                        z(i).f13631x = (float) d2;
                        return;
                    case 21977:
                        z(i).f13590b = (float) d2;
                        return;
                    case 21978:
                        z(i).f13609k5 = (float) d2;
                        return;
                    default:
                        switch (i) {
                            case 30323:
                                z(i).f13593co = (float) d2;
                                return;
                            case 30324:
                                z(i).f13635z = (float) d2;
                                return;
                            case 30325:
                                z(i).f13619r = (float) d2;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.f13540co = (long) d2;
            return;
        }
        z(i).f13607j5 = (int) d2;
    }

    public final int p() {
        int i = this.f13554j;
        mg();
        return i;
    }

    public int r(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public final void rz(tl tlVar, int i) throws IOException {
        if (this.f13548fb.fb() >= i) {
            return;
        }
        if (this.f13548fb.n3() < i) {
            rz rzVar = this.f13548fb;
            rzVar.zn(Math.max(rzVar.n3() * 2, i));
        }
        tlVar.readFully(this.f13548fb.v(), this.f13548fb.fb(), i - this.f13548fb.fb());
        this.f13548fb.j(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0231, code lost:
        throw m1.ne.y("EBML lacing sample size out of range.", null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(int r22, int r23, e4.tl r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sc.v.t(int, int, e4.tl):void");
    }

    public final long ta(long j2) throws ne {
        long j4 = this.f13560mt;
        if (j4 != -9223372036854775807L) {
            return j5.x5(j2, j4, 1000L);
        }
        throw ne.y("Can't scale timecode prior to timecodeScale being set.", null);
    }

    public final fh tl(@Nullable x4 x4Var, @Nullable x4 x4Var2) {
        int i;
        if (this.f13565p != -1 && this.f13585z != -9223372036854775807L && x4Var != null && x4Var.zn() != 0 && x4Var2 != null && x4Var2.zn() == x4Var.zn()) {
            int zn2 = x4Var.zn();
            int[] iArr = new int[zn2];
            long[] jArr = new long[zn2];
            long[] jArr2 = new long[zn2];
            long[] jArr3 = new long[zn2];
            int i5 = 0;
            for (int i6 = 0; i6 < zn2; i6++) {
                jArr3[i6] = x4Var.n3(i6);
                jArr[i6] = this.f13565p + x4Var2.n3(i6);
            }
            while (true) {
                i = zn2 - 1;
                if (i5 >= i) {
                    break;
                }
                int i8 = i5 + 1;
                iArr[i5] = (int) (jArr[i8] - jArr[i5]);
                jArr2[i5] = jArr3[i8] - jArr3[i5];
                i5 = i8;
            }
            iArr[i] = (int) ((this.f13565p + this.f13579w) - jArr[i]);
            long j2 = this.f13585z - jArr3[i];
            jArr2[i] = j2;
            if (j2 <= 0) {
                r.c5("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j2);
                iArr = Arrays.copyOf(iArr, i);
                jArr = Arrays.copyOf(jArr, i);
                jArr2 = Arrays.copyOf(jArr2, i);
                jArr3 = Arrays.copyOf(jArr3, i);
            }
            return new e4.gv(iArr, jArr, jArr2, jArr3);
        }
        return new fh.n3(this.f13585z);
    }

    public final int ud(tl tlVar, zn znVar, int i, boolean z2) throws IOException {
        boolean z3;
        int i5;
        if ("S_TEXT/UTF8".equals(znVar.f13613n3)) {
            a8(tlVar, f13533xg, i);
            return p();
        } else if ("S_TEXT/ASS".equals(znVar.f13613n3)) {
            a8(tlVar, f13528ct, i);
            return p();
        } else if ("S_TEXT/WEBVTT".equals(znVar.f13613n3)) {
            a8(tlVar, f13531o4, i);
            return p();
        } else {
            ta taVar = znVar.f13608k;
            boolean z4 = true;
            if (!this.f13576ut) {
                if (znVar.f13621s) {
                    this.f13578vl &= -1073741825;
                    boolean z5 = this.f13566q9;
                    int i6 = NotificationCompat.FLAG_HIGH_PRIORITY;
                    if (!z5) {
                        tlVar.readFully(this.f13548fb.v(), 0, 1);
                        this.f13563o++;
                        if ((this.f13548fb.v()[0] & 128) != 128) {
                            this.f13544en = this.f13548fb.v()[0];
                            this.f13566q9 = true;
                        } else {
                            throw ne.y("Extension bit is set in signal byte", null);
                        }
                    }
                    byte b2 = this.f13544en;
                    if ((b2 & 1) == 1) {
                        if ((b2 & 2) == 2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.f13578vl |= 1073741824;
                        if (!this.f13556jz) {
                            tlVar.readFully(this.f13571t.v(), 0, 8);
                            this.f13563o += 8;
                            this.f13556jz = true;
                            byte[] v2 = this.f13548fb.v();
                            if (!z3) {
                                i6 = 0;
                            }
                            v2[0] = (byte) (i6 | 8);
                            this.f13548fb.oz(0);
                            taVar.a(this.f13548fb, 1, 1);
                            this.f13554j++;
                            this.f13571t.oz(0);
                            taVar.a(this.f13571t, 8, 1);
                            this.f13554j += 8;
                        }
                        if (z3) {
                            if (!this.f13557k) {
                                tlVar.readFully(this.f13548fb.v(), 0, 1);
                                this.f13563o++;
                                this.f13548fb.oz(0);
                                this.f13547f7 = this.f13548fb.ej();
                                this.f13557k = true;
                            }
                            int i8 = this.f13547f7 * 4;
                            this.f13548fb.j5(i8);
                            tlVar.readFully(this.f13548fb.v(), 0, i8);
                            this.f13563o += i8;
                            short s2 = (short) ((this.f13547f7 / 2) + 1);
                            int i10 = (s2 * 6) + 2;
                            ByteBuffer byteBuffer = this.f13583xc;
                            if (byteBuffer == null || byteBuffer.capacity() < i10) {
                                this.f13583xc = ByteBuffer.allocate(i10);
                            }
                            this.f13583xc.position(0);
                            this.f13583xc.putShort(s2);
                            int i11 = 0;
                            int i12 = 0;
                            while (true) {
                                i5 = this.f13547f7;
                                if (i11 >= i5) {
                                    break;
                                }
                                int b3 = this.f13548fb.b();
                                if (i11 % 2 == 0) {
                                    this.f13583xc.putShort((short) (b3 - i12));
                                } else {
                                    this.f13583xc.putInt(b3 - i12);
                                }
                                i11++;
                                i12 = b3;
                            }
                            int i13 = (i - this.f13563o) - i12;
                            if (i5 % 2 == 1) {
                                this.f13583xc.putInt(i13);
                            } else {
                                this.f13583xc.putShort((short) i13);
                                this.f13583xc.putInt(0);
                            }
                            this.f13573tl.o(this.f13583xc.array(), i10);
                            taVar.a(this.f13573tl, i10, 1);
                            this.f13554j += i10;
                        }
                    }
                } else {
                    byte[] bArr = znVar.f13592c5;
                    if (bArr != null) {
                        this.f13553i9.o(bArr, bArr.length);
                    }
                }
                if (znVar.xc(z2)) {
                    this.f13578vl |= 268435456;
                    this.f13580wz.j5(0);
                    int fb2 = (this.f13553i9.fb() + i) - this.f13563o;
                    this.f13548fb.j5(4);
                    this.f13548fb.v()[0] = (byte) ((fb2 >> 24) & 255);
                    this.f13548fb.v()[1] = (byte) ((fb2 >> 16) & 255);
                    this.f13548fb.v()[2] = (byte) ((fb2 >> 8) & 255);
                    this.f13548fb.v()[3] = (byte) (fb2 & 255);
                    taVar.a(this.f13548fb, 4, 2);
                    this.f13554j += 4;
                }
                this.f13576ut = true;
            }
            int fb3 = i + this.f13553i9.fb();
            if (!"V_MPEG4/ISO/AVC".equals(znVar.f13613n3) && !"V_MPEGH/ISO/HEVC".equals(znVar.f13613n3)) {
                if (znVar.f13606j != null) {
                    if (this.f13553i9.fb() != 0) {
                        z4 = false;
                    }
                    v5.y.fb(z4);
                    znVar.f13606j.gv(tlVar);
                }
                while (true) {
                    int i14 = this.f13563o;
                    if (i14 >= fb3) {
                        break;
                    }
                    int x2 = x(tlVar, taVar, fb3 - i14);
                    this.f13563o += x2;
                    this.f13554j += x2;
                }
            } else {
                byte[] v3 = this.f13535a.v();
                v3[0] = 0;
                v3[1] = 0;
                v3[2] = 0;
                int i15 = znVar.f13599f7;
                int i16 = 4 - i15;
                while (this.f13563o < fb3) {
                    int i17 = this.f13564oz;
                    if (i17 == 0) {
                        b(tlVar, v3, i16, i15);
                        this.f13563o += i15;
                        this.f13535a.oz(0);
                        this.f13564oz = this.f13535a.b();
                        this.f13577v.oz(0);
                        taVar.zn(this.f13577v, 4);
                        this.f13554j += 4;
                    } else {
                        int x3 = x(tlVar, taVar, i17);
                        this.f13563o += x3;
                        this.f13554j += x3;
                        this.f13564oz -= x3;
                    }
                }
            }
            if ("A_VORBIS".equals(znVar.f13613n3)) {
                this.f13570s.oz(0);
                taVar.zn(this.f13570s, 4);
                this.f13554j += 4;
            }
            return p();
        }
    }

    @Override // e4.t
    public final int v(tl tlVar, d0 d0Var) throws IOException {
        this.f13541d = false;
        boolean z2 = true;
        while (z2 && !this.f13541d) {
            z2 = this.y.n3(tlVar);
            if (z2 && fh(d0Var, tlVar.getPosition())) {
                return 1;
            }
        }
        if (z2) {
            return 0;
        }
        for (int i = 0; i < this.f13587zn.size(); i++) {
            zn valueAt = this.f13587zn.valueAt(i);
            valueAt.a();
            valueAt.i9();
        }
        return -1;
    }

    public final void wz(zn znVar, long j2, int i, int i5, int i6) {
        d dVar = znVar.f13606j;
        if (dVar != null) {
            dVar.zn(znVar.f13608k, j2, i, i5, i6, znVar.f13605i9);
        } else {
            if ("S_TEXT/UTF8".equals(znVar.f13613n3) || "S_TEXT/ASS".equals(znVar.f13613n3) || "S_TEXT/WEBVTT".equals(znVar.f13613n3)) {
                if (this.f13581x > 1) {
                    r.c5("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j4 = this.f13575ud;
                    if (j4 == -9223372036854775807L) {
                        r.c5("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        d(znVar.f13613n3, j4, this.f13545f.v());
                        int a2 = this.f13545f.a();
                        while (true) {
                            if (a2 >= this.f13545f.fb()) {
                                break;
                            } else if (this.f13545f.v()[a2] == 0) {
                                this.f13545f.j(a2);
                                break;
                            } else {
                                a2++;
                            }
                        }
                        ta taVar = znVar.f13608k;
                        rz rzVar = this.f13545f;
                        taVar.zn(rzVar, rzVar.fb());
                        i5 += this.f13545f.fb();
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.f13581x > 1) {
                    this.f13580wz.j5(0);
                } else {
                    int fb2 = this.f13580wz.fb();
                    znVar.f13608k.a(this.f13580wz, fb2, 2);
                    i5 += fb2;
                }
            }
            znVar.f13608k.gv(j2, i, i5, i6, znVar.f13605i9);
        }
        this.f13541d = true;
    }

    public final int x(tl tlVar, ta taVar, int i) throws IOException {
        int y2 = this.f13553i9.y();
        if (y2 > 0) {
            int min = Math.min(i, y2);
            taVar.zn(this.f13553i9, min);
            return min;
        }
        return taVar.n3(tlVar, i, false);
    }

    public void x4(zn znVar, tl tlVar, int i) throws IOException {
        if (znVar.f13600fb != 1685485123 && znVar.f13600fb != 1685480259) {
            tlVar.p(i);
            return;
        }
        byte[] bArr = new byte[i];
        znVar.f13634yt = bArr;
        tlVar.readFully(bArr, 0, i);
    }

    public void xc(int i) throws ne {
        f();
        if (i != 160) {
            if (i != 174) {
                if (i != 19899) {
                    if (i != 25152) {
                        if (i != 28032) {
                            if (i != 357149030) {
                                if (i != 374648427) {
                                    if (i == 475249515) {
                                        if (!this.f13582x4) {
                                            this.f13574u.t(tl(this.f13569rz, this.f13559mg));
                                            this.f13582x4 = true;
                                        }
                                        this.f13569rz = null;
                                        this.f13559mg = null;
                                        return;
                                    }
                                    return;
                                } else if (this.f13587zn.size() != 0) {
                                    this.f13574u.xc();
                                    return;
                                } else {
                                    throw ne.y("No valid tracks were found", null);
                                }
                            }
                            if (this.f13560mt == -9223372036854775807L) {
                                this.f13560mt = 1000000L;
                            }
                            long j2 = this.f13540co;
                            if (j2 != -9223372036854775807L) {
                                this.f13585z = ta(j2);
                                return;
                            }
                            return;
                        }
                        i9(i);
                        zn znVar = this.f13568r;
                        if (znVar.f13621s && znVar.f13592c5 != null) {
                            throw ne.y("Combining encryption and compression is not supported", null);
                        }
                        return;
                    }
                    i9(i);
                    zn znVar2 = this.f13568r;
                    if (znVar2.f13621s) {
                        if (znVar2.f13605i9 != null) {
                            znVar2.f13622t = new DrmInitData(new DrmInitData.SchemeData(c5.y, "video/webm", this.f13568r.f13605i9.f7514n3));
                            return;
                        }
                        throw ne.y("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    return;
                }
                int i5 = this.f13552i4;
                if (i5 != -1) {
                    long j4 = this.f13546f3;
                    if (j4 != -1) {
                        if (i5 == 475249515) {
                            this.f13538c = j4;
                            return;
                        }
                        return;
                    }
                }
                throw ne.y("Mandatory element SeekID or SeekPosition not found", null);
            }
            zn znVar3 = (zn) v5.y.c5(this.f13568r);
            String str = znVar3.f13613n3;
            if (str != null) {
                if (n(str)) {
                    znVar3.c5(this.f13574u, znVar3.f13637zn);
                    this.f13587zn.put(znVar3.f13637zn, znVar3);
                }
                this.f13568r = null;
                return;
            }
            throw ne.y("CodecId is missing in TrackEntry element", null);
        } else if (this.f13586z6 == 2) {
            zn znVar4 = this.f13587zn.get(this.f13558k5);
            znVar4.a();
            if (this.f13567qn > 0 && "A_OPUS".equals(znVar4.f13613n3)) {
                this.f13580wz.qn(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f13567qn).array());
            }
            int i6 = 0;
            for (int i8 = 0; i8 < this.f13581x; i8++) {
                i6 += this.f13537b[i8];
            }
            int i10 = 0;
            while (i10 < this.f13581x) {
                long j6 = this.f13543ej + ((znVar4.f13627v * i10) / 1000);
                int i11 = this.f13578vl;
                if (i10 == 0 && !this.f13555j5) {
                    i11 |= 1;
                }
                int i12 = this.f13537b[i10];
                int i13 = i6 - i12;
                wz(znVar4, j6, i11, i12, i13);
                i10++;
                i6 = i13;
            }
            this.f13586z6 = 0;
        }
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        this.f13549fh = -9223372036854775807L;
        this.f13586z6 = 0;
        this.y.y();
        this.f13562n3.v();
        mg();
        for (int i = 0; i < this.f13587zn.size(); i++) {
            this.f13587zn.valueAt(i).wz();
        }
    }

    public zn z(int i) throws ne {
        i9(i);
        return this.f13568r;
    }

    public void z6(int i, long j2, long j4) throws ne {
        f();
        if (i != 160) {
            if (i != 174) {
                if (i != 187) {
                    if (i != 19899) {
                        if (i != 20533) {
                            if (i != 21968) {
                                if (i != 408125543) {
                                    if (i != 475249515) {
                                        if (i == 524531317 && !this.f13582x4) {
                                            if (this.f13550gv && this.f13538c != -1) {
                                                this.f13561n = true;
                                                return;
                                            }
                                            this.f13574u.t(new fh.n3(this.f13585z));
                                            this.f13582x4 = true;
                                            return;
                                        }
                                        return;
                                    }
                                    this.f13569rz = new x4();
                                    this.f13559mg = new x4();
                                    return;
                                }
                                long j6 = this.f13565p;
                                if (j6 != -1 && j6 != j2) {
                                    throw ne.y("Multiple Segment elements not supported", null);
                                }
                                this.f13565p = j2;
                                this.f13579w = j4;
                                return;
                            }
                            z(i).f13598f3 = true;
                            return;
                        }
                        z(i).f13621s = true;
                        return;
                    }
                    this.f13552i4 = -1;
                    this.f13546f3 = -1L;
                    return;
                }
                this.f13572ta = false;
                return;
            }
            this.f13568r = new zn();
            return;
        }
        this.f13555j5 = false;
        this.f13567qn = 0L;
    }

    @Override // e4.t
    public final void zn(wz wzVar) {
        this.f13574u = wzVar;
    }

    public v(int i) {
        this(new sc.y(), i);
    }

    public v(sc.zn znVar, int i) {
        this.f13565p = -1L;
        this.f13560mt = -9223372036854775807L;
        this.f13540co = -9223372036854775807L;
        this.f13585z = -9223372036854775807L;
        this.f13538c = -1L;
        this.f13542d0 = -1L;
        this.f13549fh = -9223372036854775807L;
        this.y = znVar;
        znVar.zn(new n3());
        this.f13550gv = (i & 1) == 0;
        this.f13562n3 = new fb();
        this.f13587zn = new SparseArray<>();
        this.f13548fb = new rz(4);
        this.f13570s = new rz(ByteBuffer.allocate(4).putInt(-1).array());
        this.f13539c5 = new rz(4);
        this.f13577v = new rz(c.y);
        this.f13535a = new rz(4);
        this.f13553i9 = new rz();
        this.f13545f = new rz();
        this.f13571t = new rz(8);
        this.f13573tl = new rz();
        this.f13580wz = new rz();
        this.f13537b = new int[1];
    }

    @Override // e4.t
    public final void release() {
    }
}
