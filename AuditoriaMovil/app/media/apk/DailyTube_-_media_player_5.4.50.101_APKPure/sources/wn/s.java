package wn;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.video.PlaceholderSurface;
import h3.t;
import h3.x4;
import java.nio.ByteBuffer;
import java.util.List;
import m1.g;
import m1.hk;
import m1.m;
import v5.j5;
import v5.yt;
import wn.n;
/* loaded from: classes.dex */
public class s extends h3.xc {
    public static final int[] jb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean sw;
    public static boolean v1;
    @Nullable

    /* renamed from: br  reason: collision with root package name */
    public PlaceholderSurface f14596br;

    /* renamed from: bv  reason: collision with root package name */
    public boolean f14597bv;
    public boolean c8;
    @Nullable
    public d0 cx;
    public int dp;
    @Nullable
    public Surface fc;
    public boolean gf;
    public long gn;
    public long h;
    public int hk;
    public float hr;
    public int hy;
    public int i;

    /* renamed from: i3  reason: collision with root package name */
    public final Context f14598i3;
    public long ia;
    public long ic;
    public int im;

    /* renamed from: j3  reason: collision with root package name */
    public final n.y f14599j3;
    public int jr;
    @Nullable
    public f jt;
    public long k3;
    public boolean mh;
    public boolean n7;

    /* renamed from: nd  reason: collision with root package name */
    public n3 f14600nd;

    /* renamed from: ne  reason: collision with root package name */
    public final long f14601ne;
    public long p1;

    /* renamed from: q  reason: collision with root package name */
    public final int f14602q;
    public long r6;
    public int rv;

    /* renamed from: uo  reason: collision with root package name */
    public boolean f14603uo;
    public int vc;
    public boolean vh;

    /* renamed from: vn  reason: collision with root package name */
    public final tl f14604vn;

    /* renamed from: wm  reason: collision with root package name */
    public final boolean f14605wm;
    @Nullable
    public zn xq;
    public int zq;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final int f14606n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f14607zn;

        public n3(int i, int i5, int i6) {
            this.y = i;
            this.f14606n3 = i5;
            this.f14607zn = i6;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public static boolean y(Context context) {
            Display display;
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                display = displayManager.getDisplay(0);
            } else {
                display = null;
            }
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements t.zn, Handler.Callback {
        public final Handler y;

        public zn(h3.t tVar) {
            Handler f32 = j5.f3(this);
            this.y = f32;
            tVar.n3(this, f32);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            n3(j5.ne(message.arg1, message.arg2));
            return true;
        }

        public final void n3(long j2) {
            s sVar = s.this;
            if (this == sVar.xq && sVar.s8() != null) {
                if (j2 == Long.MAX_VALUE) {
                    s.this.hb();
                    return;
                }
                try {
                    s.this.zh(j2);
                } catch (m1.p e2) {
                    s.this.wm(e2);
                }
            }
        }

        @Override // h3.t.zn
        public void y(h3.t tVar, long j2, long j4) {
            if (j5.y < 30) {
                this.y.sendMessageAtFrontOfQueue(Message.obtain(this.y, 0, (int) (j2 >> 32), (int) j2));
                return;
            }
            n3(j2);
        }
    }

    public s(Context context, h3.p pVar, long j2, boolean z2, @Nullable Handler handler, @Nullable n nVar, int i) {
        this(context, t.n3.y, pVar, j2, z2, handler, nVar, i, 30.0f);
    }

    public static int cx(int i, int i5) {
        return (i * 3) / (i5 * 2);
    }

    public static List<h3.wz> dp(Context context, h3.p pVar, m mVar, boolean z2, boolean z3) throws x4.zn {
        String str = mVar.f10948f3;
        if (str == null) {
            return z0.x4.j5();
        }
        List<h3.wz> decoderInfos = pVar.getDecoderInfos(str, z2, z3);
        String tl2 = h3.x4.tl(mVar);
        if (tl2 == null) {
            return z0.x4.d(decoderInfos);
        }
        List<h3.wz> decoderInfos2 = pVar.getDecoderInfos(tl2, z2, z3);
        if (j5.y >= 26 && "video/dolby-vision".equals(mVar.f10948f3) && !decoderInfos2.isEmpty() && !y.y(context)) {
            return z0.x4.d(decoderInfos2);
        }
        return z0.x4.x4().fb(decoderInfos).fb(decoderInfos2).s();
    }

    public static int hr(h3.wz wzVar, m mVar) {
        if (mVar.f10956n != -1) {
            int size = mVar.f10941c.size();
            int i = 0;
            for (int i5 = 0; i5 < size; i5++) {
                i += mVar.f10941c.get(i5).length;
            }
            return mVar.f10956n + i;
        }
        return p1(wzVar, mVar);
    }

    public static boolean hy(long j2) {
        if (j2 < -30000) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Point i(h3.wz wzVar, m mVar) {
        boolean z2;
        int i;
        int[] iArr;
        int i5;
        int i6;
        int i8 = mVar.f10945ej;
        int i10 = mVar.f10943d;
        if (i8 > i10) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i = i8;
        } else {
            i = i10;
        }
        if (z2) {
            i8 = i10;
        }
        float f4 = i8 / i;
        for (int i11 : jb) {
            int i12 = (int) (i11 * f4);
            if (i11 <= i || i12 <= i8) {
                break;
            }
            if (j5.y >= 21) {
                if (z2) {
                    i6 = i12;
                } else {
                    i6 = i11;
                }
                if (!z2) {
                    i11 = i12;
                }
                Point zn2 = wzVar.zn(i6, i11);
                if (wzVar.n(zn2.x, zn2.y, mVar.f10969x)) {
                    return zn2;
                }
            } else {
                try {
                    int t2 = j5.t(i11, 16) * 16;
                    int t3 = j5.t(i12, 16) * 16;
                    if (t2 * t3 <= h3.x4.yt()) {
                        if (z2) {
                            i5 = t3;
                        } else {
                            i5 = t2;
                        }
                        if (!z2) {
                            t2 = t3;
                        }
                        return new Point(i5, t2);
                    }
                } catch (x4.zn unused) {
                }
            }
        }
        return null;
    }

    public static boolean ic() {
        return "NVIDIA".equals(j5.f14370zn);
    }

    public static void k3(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
        if (r8.equals("video/av01") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int p1(h3.wz r10, m1.m r11) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: wn.s.p1(h3.wz, m1.m):int");
    }

    public static void sx(h3.t tVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        tVar.c5(bundle);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x073f, code lost:
        if (r11.equals("A10-70L") == false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean vc() {
        /*
            Method dump skipped, instructions count: 3184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: wn.s.vc():boolean");
    }

    public static boolean xq(long j2) {
        if (j2 < -500000) {
            return true;
        }
        return false;
    }

    @Override // h3.xc, m1.a
    public void a8() {
        super.a8();
        this.jr = 0;
        this.r6 = SystemClock.elapsedRealtime();
        this.ic = SystemClock.elapsedRealtime() * 1000;
        this.gn = 0L;
        this.vc = 0;
        this.f14604vn.f();
    }

    @Override // h3.xc
    @TargetApi(29)
    public void bk(a9.fb fbVar) throws m1.p {
        if (!this.f14597bv) {
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) v5.y.v(fbVar.f59t);
        if (byteBuffer.remaining() >= 7) {
            byte b2 = byteBuffer.get();
            short s2 = byteBuffer.getShort();
            short s3 = byteBuffer.getShort();
            byte b3 = byteBuffer.get();
            byte b4 = byteBuffer.get();
            byteBuffer.position(0);
            if (b2 == -75 && s2 == 60 && s3 == 1 && b3 == 4) {
                if (b4 == 0 || b4 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    sx(s8(), bArr);
                }
            }
        }
    }

    @Override // h3.xc
    public boolean bv(h3.wz wzVar) {
        if (this.fc == null && !hj(wzVar)) {
            return false;
        }
        return true;
    }

    @Override // h3.xc
    public void cy(Exception exc) {
        v5.r.gv("MediaCodecVideoRenderer", "Video codec error", exc);
        this.f14599j3.rz(exc);
    }

    @Override // h3.xc, m1.a
    public void d() {
        zq();
        jr();
        this.f14603uo = false;
        this.xq = null;
        try {
            super.d();
        } finally {
            this.f14599j3.tl(this.f8488cs);
        }
    }

    @Override // h3.xc, m1.a
    public void ej(long j2, boolean z2) throws m1.p {
        super.ej(j2, z2);
        jr();
        this.f14604vn.i9();
        this.k3 = -9223372036854775807L;
        this.h = -9223372036854775807L;
        this.zq = 0;
        if (z2) {
            ux();
        } else {
            this.ia = -9223372036854775807L;
        }
    }

    public boolean fp(long j2, long j4) {
        if (hy(j2) && j4 > 100000) {
            return true;
        }
        return false;
    }

    public void fq(h3.t tVar, int i, long j2, long j4) {
        gi();
        yt.y("releaseOutputBuffer");
        tVar.i9(i, j4);
        yt.zn();
        this.ic = SystemClock.elapsedRealtime() * 1000;
        this.f8488cs.f85v++;
        this.zq = 0;
        sw();
    }

    @Override // m1.zq, m1.k3
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public final void gi() {
        int i = this.i;
        if (i != -1 || this.rv != -1) {
            d0 d0Var = this.cx;
            if (d0Var == null || d0Var.y != i || d0Var.f14582v != this.rv || d0Var.f14580fb != this.dp || d0Var.f14581s != this.hr) {
                d0 d0Var2 = new d0(this.i, this.rv, this.dp, this.hr);
                this.cx = d0Var2;
                this.f14599j3.mg(d0Var2);
            }
        }
    }

    public void gn(h3.t tVar, int i, long j2) {
        yt.y("dropVideoBuffer");
        tVar.tl(i, false);
        yt.zn();
        hf(0, 1);
    }

    @Override // h3.xc
    public void gq(m mVar, @Nullable MediaFormat mediaFormat) {
        boolean z2;
        int integer;
        int integer2;
        h3.t s82 = s8();
        if (s82 != null) {
            s82.zn(this.im);
        }
        if (this.vh) {
            this.i = mVar.f10943d;
            this.rv = mVar.f10945ej;
        } else {
            v5.y.v(mediaFormat);
            if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            this.i = integer;
            if (z2) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            this.rv = integer2;
        }
        float f4 = mVar.f10953j5;
        this.hr = f4;
        if (j5.y >= 21) {
            int i = mVar.f10940b;
            if (i == 90 || i == 270) {
                int i5 = this.i;
                this.i = this.rv;
                this.rv = i5;
                this.hr = 1.0f / f4;
            }
        } else {
            this.dp = mVar.f10940b;
        }
        this.f14604vn.fb(mVar.f10969x);
    }

    public final void hb() {
        q();
    }

    public void hf(int i, int i5) {
        a9.v vVar = this.f8488cs;
        vVar.f83s += i;
        int i6 = i + i5;
        vVar.f79fb += i6;
        this.jr += i6;
        int i8 = this.zq + i6;
        this.zq = i8;
        vVar.f77c5 = Math.max(i8, vVar.f77c5);
        int i10 = this.f14602q;
        if (i10 > 0 && this.jr >= i10) {
            jb();
        }
    }

    public final boolean hj(h3.wz wzVar) {
        if (j5.y >= 23 && !this.vh && !hk(wzVar.y) && (!wzVar.f8469fb || PlaceholderSurface.n3(this.f14598i3))) {
            return true;
        }
        return false;
    }

    public boolean hk(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (s.class) {
            try {
                if (!sw) {
                    v1 = vc();
                    sw = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return v1;
    }

    @Override // h3.xc, m1.zq
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        if (super.isReady() && (this.mh || (((placeholderSurface = this.f14596br) != null && this.fc == placeholderSurface) || s8() == null || this.vh))) {
            this.ia = -9223372036854775807L;
            return true;
        } else if (this.ia == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.ia) {
                return true;
            }
            this.ia = -9223372036854775807L;
            return false;
        }
    }

    public final void jb() {
        if (this.jr > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f14599j3.wz(this.jr, elapsedRealtime - this.r6);
            this.jr = 0;
            this.r6 = elapsedRealtime;
        }
    }

    public final void jr() {
        h3.t s82;
        this.mh = false;
        if (j5.y >= 23 && this.vh && (s82 = s8()) != null) {
            this.xq = new zn(s82);
        }
    }

    public boolean jt(long j2, boolean z2) throws m1.p {
        int vl2 = vl(j2);
        if (vl2 == 0) {
            return false;
        }
        if (z2) {
            a9.v vVar = this.f8488cs;
            vVar.f80gv += vl2;
            vVar.f76a += this.hk;
        } else {
            this.f8488cs.f81i9++;
            hf(vl2, this.hk);
        }
        nf();
        return true;
    }

    public boolean ks(long j2, long j4, boolean z2) {
        if (hy(j2) && !z2) {
            return true;
        }
        return false;
    }

    @Override // h3.xc
    @Nullable
    public a9.c5 l(g gVar) throws m1.p {
        a9.c5 l2 = super.l(gVar);
        this.f14599j3.w(gVar.f10757n3, l2);
        return l2;
    }

    public final void l0() {
        d0 d0Var = this.cx;
        if (d0Var != null) {
            this.f14599j3.mg(d0Var);
        }
    }

    @Override // h3.xc
    @TargetApi(17)
    public t.y m(h3.wz wzVar, m mVar, @Nullable MediaCrypto mediaCrypto, float f4) {
        int i;
        PlaceholderSurface placeholderSurface = this.f14596br;
        if (placeholderSurface != null && placeholderSurface.y != wzVar.f8469fb) {
            ob();
        }
        String str = wzVar.f8475zn;
        n3 rv = rv(wzVar, mVar, mg());
        this.f14600nd = rv;
        boolean z2 = this.f14605wm;
        if (this.vh) {
            i = this.hy;
        } else {
            i = 0;
        }
        MediaFormat vh = vh(mVar, str, rv, f4, z2, i);
        if (this.fc == null) {
            if (hj(wzVar)) {
                if (this.f14596br == null) {
                    this.f14596br = PlaceholderSurface.zn(this.f14598i3, wzVar.f8469fb);
                }
                this.fc = this.f14596br;
            } else {
                throw new IllegalStateException();
            }
        }
        return t.y.n3(wzVar, vh, mVar, this.fc, mediaCrypto);
    }

    @Override // h3.xc
    public void oa(long j2) {
        super.oa(j2);
        if (!this.vh) {
            this.hk--;
        }
    }

    public final void ob() {
        Surface surface = this.fc;
        PlaceholderSurface placeholderSurface = this.f14596br;
        if (surface == placeholderSurface) {
            this.fc = null;
        }
        placeholderSurface.release();
        this.f14596br = null;
    }

    @Override // h3.xc, m1.a, m1.zq
    public void p(float f4, float f6) throws m1.p {
        super.p(f4, f6);
        this.f14604vn.c5(f4);
    }

    @Override // h3.xc
    public boolean q5(long j2, long j4, @Nullable h3.t tVar, @Nullable ByteBuffer byteBuffer, int i, int i5, int i6, long j6, boolean z2, boolean z3, m mVar) throws m1.p {
        long j7;
        boolean z4;
        v5.y.v(tVar);
        if (this.h == -9223372036854775807L) {
            this.h = j2;
        }
        if (j6 != this.k3) {
            this.f14604vn.s(j6);
            this.k3 = j6;
        }
        long g2 = g();
        long j8 = j6 - g2;
        if (z2 && !z3) {
            sh(tVar, i, j8);
            return true;
        }
        double u02 = u0();
        boolean z5 = getState() == 2;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j9 = (long) ((j6 - j2) / u02);
        if (z5) {
            j9 -= elapsedRealtime - j4;
        }
        if (this.fc == this.f14596br) {
            if (hy(j9)) {
                sh(tVar, i, j8);
                w7(j9);
                return true;
            }
            return false;
        }
        long j10 = elapsedRealtime - this.ic;
        if (this.c8 ? this.mh : !(z5 || this.n7)) {
            j7 = j10;
            z4 = false;
        } else {
            j7 = j10;
            z4 = true;
        }
        if (this.ia == -9223372036854775807L && j2 >= g2 && (z4 || (z5 && fp(j9, j7)))) {
            long nanoTime = System.nanoTime();
            wo(j8, nanoTime, mVar);
            if (j5.y >= 21) {
                fq(tVar, i, j8, nanoTime);
            } else {
                vb(tVar, i, j8);
            }
            w7(j9);
            return true;
        }
        if (z5 && j2 != this.h) {
            long nanoTime2 = System.nanoTime();
            long n32 = this.f14604vn.n3((j9 * 1000) + nanoTime2);
            long j11 = (n32 - nanoTime2) / 1000;
            boolean z7 = this.ia != -9223372036854775807L;
            if (rt(j11, j4, z3) && jt(j2, z7)) {
                return false;
            }
            if (ks(j11, j4, z3)) {
                if (z7) {
                    sh(tVar, i, j8);
                } else {
                    gn(tVar, i, j8);
                }
                w7(j11);
                return true;
            } else if (j5.y >= 21) {
                if (j11 < 50000) {
                    if (n32 == this.p1) {
                        sh(tVar, i, j8);
                    } else {
                        wo(j8, n32, mVar);
                        fq(tVar, i, j8, n32);
                    }
                    w7(j11);
                    this.p1 = n32;
                    return true;
                }
            } else if (j11 < 30000) {
                if (j11 > 11000) {
                    try {
                        Thread.sleep((j11 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                wo(j8, n32, mVar);
                vb(tVar, i, j8);
                w7(j11);
                return true;
            }
        }
        return false;
    }

    @Override // h3.xc
    public void qj(String str) {
        this.f14599j3.t(str);
    }

    @Override // h3.xc
    public void qk(String str, t.y yVar, long j2, long j4) {
        this.f14599j3.f(str, j2, j4);
        this.gf = hk(str);
        this.f14597bv = ((h3.wz) v5.y.v(ap())).mt();
        if (j5.y >= 23 && this.vh) {
            this.xq = new zn((h3.t) v5.y.v(s8()));
        }
    }

    @Override // h3.xc
    public a9.c5 qn(h3.wz wzVar, m mVar, m mVar2) {
        int i;
        a9.c5 a2 = wzVar.a(mVar, mVar2);
        int i5 = a2.f47v;
        int i6 = mVar2.f10943d;
        n3 n3Var = this.f14600nd;
        if (i6 > n3Var.y || mVar2.f10945ej > n3Var.f14606n3) {
            i5 |= 256;
        }
        if (hr(wzVar, mVar2) > this.f14600nd.f14607zn) {
            i5 |= 64;
        }
        int i8 = i5;
        String str = wzVar.y;
        if (i8 != 0) {
            i = 0;
        } else {
            i = a2.f45gv;
        }
        return new a9.c5(str, mVar, mVar2, i, i8);
    }

    @Override // h3.xc
    public List<h3.wz> rb(h3.p pVar, m mVar, boolean z2) throws x4.zn {
        return h3.x4.r(dp(this.f14598i3, pVar, mVar, z2, this.vh), mVar);
    }

    public boolean rt(long j2, long j4, boolean z2) {
        if (xq(j2) && !z2) {
            return true;
        }
        return false;
    }

    public n3 rv(h3.wz wzVar, m mVar, m[] mVarArr) {
        boolean z2;
        int p1;
        int i = mVar.f10943d;
        int i5 = mVar.f10945ej;
        int hr = hr(wzVar, mVar);
        if (mVarArr.length == 1) {
            if (hr != -1 && (p1 = p1(wzVar, mVar)) != -1) {
                hr = Math.min((int) (hr * 1.5f), p1);
            }
            return new n3(i, i5, hr);
        }
        int length = mVarArr.length;
        boolean z3 = false;
        for (int i6 = 0; i6 < length; i6++) {
            m mVar2 = mVarArr[i6];
            if (mVar.f10952j != null && mVar2.f10952j == null) {
                mVar2 = mVar2.n3().b(mVar.f10952j).z6();
            }
            if (wzVar.a(mVar, mVar2).f45gv != 0) {
                int i8 = mVar2.f10943d;
                if (i8 != -1 && mVar2.f10945ej != -1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                z3 |= z2;
                i = Math.max(i, i8);
                i5 = Math.max(i5, mVar2.f10945ej);
                hr = Math.max(hr, hr(wzVar, mVar2));
            }
        }
        if (z3) {
            v5.r.c5("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i + "x" + i5);
            Point i10 = i(wzVar, mVar);
            if (i10 != null) {
                i = Math.max(i, i10.x);
                i5 = Math.max(i5, i10.y);
                hr = Math.max(hr, p1(wzVar, mVar.n3().s8(i).o(i5).z6()));
                v5.r.c5("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i + "x" + i5);
            }
        }
        return new n3(i, i5, hr);
    }

    public void sh(h3.t tVar, int i, long j2) {
        yt.y("skipVideoBuffer");
        tVar.tl(i, false);
        yt.zn();
        this.f8488cs.f76a++;
    }

    public void sw() {
        this.c8 = true;
        if (!this.mh) {
            this.mh = true;
            this.f14599j3.d0(this.fc);
            this.f14603uo = true;
        }
    }

    public void t5(h3.t tVar, Surface surface) {
        tVar.v(surface);
    }

    @Override // m1.a, m1.c8.n3
    public void tl(int i, @Nullable Object obj) throws m1.p {
        if (i != 1) {
            if (i != 7) {
                if (i != 10) {
                    if (i != 4) {
                        if (i != 5) {
                            super.tl(i, obj);
                            return;
                        } else {
                            this.f14604vn.xc(((Integer) obj).intValue());
                            return;
                        }
                    }
                    this.im = ((Integer) obj).intValue();
                    h3.t s82 = s8();
                    if (s82 != null) {
                        s82.zn(this.im);
                        return;
                    }
                    return;
                }
                int intValue = ((Integer) obj).intValue();
                if (this.hy != intValue) {
                    this.hy = intValue;
                    if (this.vh) {
                        ro();
                        return;
                    }
                    return;
                }
                return;
            }
            this.jt = (f) obj;
            return;
        }
        vd(obj);
    }

    @Override // h3.xc
    public h3.tl u(Throwable th, @Nullable h3.wz wzVar) {
        return new fb(th, wzVar, this.fc);
    }

    @Override // h3.xc, m1.a
    @TargetApi(17)
    public void ud() {
        try {
            super.ud();
        } finally {
            if (this.f14596br != null) {
                ob();
            }
        }
    }

    @Override // h3.xc
    public int uo(h3.p pVar, m mVar) throws x4.zn {
        boolean z2;
        boolean z3;
        int i;
        int i5;
        int i6;
        int i8;
        int i10 = 0;
        if (!v5.n.co(mVar.f10948f3)) {
            return hk.y(0);
        }
        if (mVar.f10944d0 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        List<h3.wz> dp = dp(this.f14598i3, pVar, mVar, z2, false);
        if (z2 && dp.isEmpty()) {
            dp = dp(this.f14598i3, pVar, mVar, false, false);
        }
        if (dp.isEmpty()) {
            return hk.y(1);
        }
        if (!h3.xc.im(mVar)) {
            return hk.y(2);
        }
        h3.wz wzVar = dp.get(0);
        boolean p2 = wzVar.p(mVar);
        if (!p2) {
            for (int i11 = 1; i11 < dp.size(); i11++) {
                h3.wz wzVar2 = dp.get(i11);
                if (wzVar2.p(mVar)) {
                    wzVar = wzVar2;
                    z3 = false;
                    p2 = true;
                    break;
                }
            }
        }
        z3 = true;
        if (p2) {
            i = 4;
        } else {
            i = 3;
        }
        if (wzVar.z(mVar)) {
            i5 = 16;
        } else {
            i5 = 8;
        }
        if (wzVar.f8473s) {
            i6 = 64;
        } else {
            i6 = 0;
        }
        if (z3) {
            i8 = NotificationCompat.FLAG_HIGH_PRIORITY;
        } else {
            i8 = 0;
        }
        if (j5.y >= 26 && "video/dolby-vision".equals(mVar.f10948f3) && !y.y(this.f14598i3)) {
            i8 = 256;
        }
        if (p2) {
            List<h3.wz> dp2 = dp(this.f14598i3, pVar, mVar, z2, true);
            if (!dp2.isEmpty()) {
                h3.wz wzVar3 = h3.x4.r(dp2, mVar).get(0);
                if (wzVar3.p(mVar) && wzVar3.z(mVar)) {
                    i10 = 32;
                }
            }
        }
        return hk.zn(i, i5, i10, i6, i8);
    }

    public final void ux() {
        long j2;
        if (this.f14601ne > 0) {
            j2 = SystemClock.elapsedRealtime() + this.f14601ne;
        } else {
            j2 = -9223372036854775807L;
        }
        this.ia = j2;
    }

    public final void v1() {
        int i = this.vc;
        if (i != 0) {
            this.f14599j3.fh(this.gn, i);
            this.gn = 0L;
            this.vc = 0;
        }
    }

    public void vb(h3.t tVar, int i, long j2) {
        gi();
        yt.y("releaseOutputBuffer");
        tVar.tl(i, true);
        yt.zn();
        this.ic = SystemClock.elapsedRealtime() * 1000;
        this.f8488cs.f85v++;
        this.zq = 0;
        sw();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [m1.a, wn.s, h3.xc] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.Surface] */
    public final void vd(@Nullable Object obj) throws m1.p {
        PlaceholderSurface placeholderSurface;
        if (obj instanceof Surface) {
            placeholderSurface = (Surface) obj;
        } else {
            placeholderSurface = null;
        }
        if (placeholderSurface == null) {
            PlaceholderSurface placeholderSurface2 = this.f14596br;
            if (placeholderSurface2 != null) {
                placeholderSurface = placeholderSurface2;
            } else {
                h3.wz ap2 = ap();
                if (ap2 != null && hj(ap2)) {
                    placeholderSurface = PlaceholderSurface.zn(this.f14598i3, ap2.f8469fb);
                    this.f14596br = placeholderSurface;
                }
            }
        }
        if (this.fc != placeholderSurface) {
            this.fc = placeholderSurface;
            this.f14604vn.tl(placeholderSurface);
            this.f14603uo = false;
            int state = getState();
            h3.t s82 = s8();
            if (s82 != null) {
                if (j5.y >= 23 && placeholderSurface != null && !this.gf) {
                    t5(s82, placeholderSurface);
                } else {
                    ro();
                    wf();
                }
            }
            if (placeholderSurface != null && placeholderSurface != this.f14596br) {
                l0();
                jr();
                if (state == 2) {
                    ux();
                    return;
                }
                return;
            }
            zq();
            jr();
        } else if (placeholderSurface != null && placeholderSurface != this.f14596br) {
            l0();
            zx();
        }
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat vh(m mVar, String str, n3 n3Var, float f4, boolean z2, int i) {
        Pair<Integer, Integer> p2;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", mVar.f10943d);
        mediaFormat.setInteger("height", mVar.f10945ej);
        v5.f3.v(mediaFormat, mVar.f10941c);
        v5.f3.zn(mediaFormat, "frame-rate", mVar.f10969x);
        v5.f3.gv(mediaFormat, "rotation-degrees", mVar.f10940b);
        v5.f3.n3(mediaFormat, mVar.f10952j);
        if ("video/dolby-vision".equals(mVar.f10948f3) && (p2 = h3.x4.p(mVar)) != null) {
            v5.f3.gv(mediaFormat, "profile", ((Integer) p2.first).intValue());
        }
        mediaFormat.setInteger("max-width", n3Var.y);
        mediaFormat.setInteger("max-height", n3Var.f14606n3);
        v5.f3.gv(mediaFormat, "max-input-size", n3Var.f14607zn);
        if (j5.y >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f4 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f4);
            }
        }
        if (z2) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            k3(mediaFormat, i);
        }
        return mediaFormat;
    }

    @Override // h3.xc
    public void w2(a9.fb fbVar) throws m1.p {
        boolean z2 = this.vh;
        if (!z2) {
            this.hk++;
        }
        if (j5.y < 23 && z2) {
            zh(fbVar.f55f);
        }
    }

    public void w7(long j2) {
        this.f8488cs.y(j2);
        this.gn += j2;
        this.vc++;
    }

    @Override // h3.xc
    public void w9() {
        super.w9();
        jr();
    }

    public final void wo(long j2, long j4, m mVar) {
        f fVar = this.jt;
        if (fVar != null) {
            fVar.v(j2, j4, mVar, kp());
        }
    }

    @Override // h3.xc, m1.a
    public void x() {
        this.ia = -9223372036854775807L;
        jb();
        v1();
        this.f14604vn.t();
        super.x();
    }

    @Override // h3.xc
    public float yc(float f4, m mVar, m[] mVarArr) {
        float f6 = -1.0f;
        for (m mVar2 : mVarArr) {
            float f9 = mVar2.f10969x;
            if (f9 != -1.0f) {
                f6 = Math.max(f6, f9);
            }
        }
        if (f6 == -1.0f) {
            return -1.0f;
        }
        return f6 * f4;
    }

    @Override // h3.xc
    public boolean yg() {
        if (this.vh && j5.y < 23) {
            return true;
        }
        return false;
    }

    @Override // h3.xc
    public void yk() {
        super.yk();
        this.hk = 0;
    }

    @Override // h3.xc, m1.a
    public void z6(boolean z2, boolean z3) throws m1.p {
        boolean z4;
        super.z6(z2, z3);
        boolean z5 = c().y;
        if (z5 && this.hy == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        v5.y.fb(z4);
        if (this.vh != z5) {
            this.vh = z5;
            ro();
        }
        this.f14599j3.xc(this.f8488cs);
        this.n7 = z3;
        this.c8 = false;
    }

    public void zh(long j2) throws m1.p {
        c8(j2);
        gi();
        this.f8488cs.f85v++;
        sw();
        oa(j2);
    }

    public final void zq() {
        this.cx = null;
    }

    public final void zx() {
        if (this.f14603uo) {
            this.f14599j3.d0(this.fc);
        }
    }

    public s(Context context, t.n3 n3Var, h3.p pVar, long j2, boolean z2, @Nullable Handler handler, @Nullable n nVar, int i) {
        this(context, n3Var, pVar, j2, z2, handler, nVar, i, 30.0f);
    }

    public s(Context context, t.n3 n3Var, h3.p pVar, long j2, boolean z2, @Nullable Handler handler, @Nullable n nVar, int i, float f4) {
        super(2, n3Var, pVar, z2, f4);
        this.f14601ne = j2;
        this.f14602q = i;
        Context applicationContext = context.getApplicationContext();
        this.f14598i3 = applicationContext;
        this.f14604vn = new tl(applicationContext);
        this.f14599j3 = new n.y(handler, nVar);
        this.f14605wm = ic();
        this.ia = -9223372036854775807L;
        this.i = -1;
        this.rv = -1;
        this.hr = -1.0f;
        this.im = 1;
        this.hy = 0;
        zq();
    }
}
