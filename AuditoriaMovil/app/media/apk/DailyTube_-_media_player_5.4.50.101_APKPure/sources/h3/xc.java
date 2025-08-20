package h3;

import a9.fb;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.gv;
import fj.u0;
import h3.t;
import h3.x4;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import m1.g;
import m1.m;
import v5.b;
import v5.c;
import v5.j5;
import v5.yt;
/* loaded from: classes.dex */
public abstract class xc extends m1.a {

    /* renamed from: i2  reason: collision with root package name */
    public static final byte[] f8481i2 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};

    /* renamed from: ad  reason: collision with root package name */
    public boolean f8482ad;

    /* renamed from: ap  reason: collision with root package name */
    public boolean f8483ap;

    /* renamed from: b  reason: collision with root package name */
    public final a9.fb f8484b;

    /* renamed from: bk  reason: collision with root package name */
    public long f8485bk;

    /* renamed from: c  reason: collision with root package name */
    public final t.n3 f8486c;

    /* renamed from: cr  reason: collision with root package name */
    public boolean f8487cr;

    /* renamed from: cs  reason: collision with root package name */
    public a9.v f8488cs;
    @Nullable

    /* renamed from: ct  reason: collision with root package name */
    public MediaFormat f8489ct;

    /* renamed from: cy  reason: collision with root package name */
    public int f8490cy;

    /* renamed from: d  reason: collision with root package name */
    public final float f8491d;

    /* renamed from: d0  reason: collision with root package name */
    public final p f8492d0;
    @Nullable

    /* renamed from: dm  reason: collision with root package name */
    public m f8493dm;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8494e;
    @Nullable

    /* renamed from: eb  reason: collision with root package name */
    public ArrayDeque<wz> f8495eb;

    /* renamed from: ej  reason: collision with root package name */
    public final a9.fb f8496ej;

    /* renamed from: en  reason: collision with root package name */
    public boolean f8497en;
    @Nullable

    /* renamed from: f7  reason: collision with root package name */
    public MediaCrypto f8498f7;

    /* renamed from: fh  reason: collision with root package name */
    public final boolean f8499fh;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8500g;

    /* renamed from: g3  reason: collision with root package name */
    public boolean f8501g3;

    /* renamed from: gq  reason: collision with root package name */
    public boolean f8502gq;

    /* renamed from: ix  reason: collision with root package name */
    public long f8503ix;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayDeque<zn> f8504j;

    /* renamed from: j5  reason: collision with root package name */
    public final s f8505j5;

    /* renamed from: jz  reason: collision with root package name */
    public long f8506jz;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public com.google.android.exoplayer2.drm.gv f8507k;

    /* renamed from: kp  reason: collision with root package name */
    public boolean f8508kp;

    /* renamed from: l  reason: collision with root package name */
    public boolean f8509l;
    @Nullable

    /* renamed from: lc  reason: collision with root package name */
    public n3 f8510lc;
    @Nullable

    /* renamed from: le  reason: collision with root package name */
    public m1.p f8511le;

    /* renamed from: m  reason: collision with root package name */
    public boolean f8512m;

    /* renamed from: mp  reason: collision with root package name */
    public boolean f8513mp;
    @Nullable

    /* renamed from: nf  reason: collision with root package name */
    public wz f8514nf;

    /* renamed from: o  reason: collision with root package name */
    public final MediaCodec.BufferInfo f8515o;

    /* renamed from: o0  reason: collision with root package name */
    public boolean f8516o0;

    /* renamed from: o4  reason: collision with root package name */
    public boolean f8517o4;

    /* renamed from: oa  reason: collision with root package name */
    public long f8518oa;
    @Nullable

    /* renamed from: oz  reason: collision with root package name */
    public m f8519oz;

    /* renamed from: pq  reason: collision with root package name */
    public boolean f8520pq;
    @Nullable

    /* renamed from: pz  reason: collision with root package name */
    public ByteBuffer f8521pz;

    /* renamed from: q5  reason: collision with root package name */
    public boolean f8522q5;
    @Nullable

    /* renamed from: q9  reason: collision with root package name */
    public com.google.android.exoplayer2.drm.gv f8523q9;

    /* renamed from: qj  reason: collision with root package name */
    public int f8524qj;

    /* renamed from: qk  reason: collision with root package name */
    public int f8525qk;

    /* renamed from: qn  reason: collision with root package name */
    public final ArrayList<Long> f8526qn;

    /* renamed from: ra  reason: collision with root package name */
    public int f8527ra;

    /* renamed from: rb  reason: collision with root package name */
    public boolean f8528rb;

    /* renamed from: ro  reason: collision with root package name */
    public zn f8529ro;

    /* renamed from: rs  reason: collision with root package name */
    public float f8530rs;

    /* renamed from: s8  reason: collision with root package name */
    public boolean f8531s8;

    /* renamed from: tg  reason: collision with root package name */
    public int f8532tg;

    /* renamed from: u  reason: collision with root package name */
    public float f8533u;
    @Nullable

    /* renamed from: u0  reason: collision with root package name */
    public c5 f8534u0;
    @Nullable

    /* renamed from: ut  reason: collision with root package name */
    public m f8535ut;

    /* renamed from: vp  reason: collision with root package name */
    public boolean f8536vp;

    /* renamed from: w2  reason: collision with root package name */
    public boolean f8537w2;

    /* renamed from: w9  reason: collision with root package name */
    public long f8538w9;

    /* renamed from: wf  reason: collision with root package name */
    public boolean f8539wf;

    /* renamed from: x  reason: collision with root package name */
    public final a9.fb f8540x;

    /* renamed from: x5  reason: collision with root package name */
    public boolean f8541x5;

    /* renamed from: xb  reason: collision with root package name */
    public boolean f8542xb;
    @Nullable

    /* renamed from: xg  reason: collision with root package name */
    public t f8543xg;

    /* renamed from: y4  reason: collision with root package name */
    public int f8544y4;

    /* renamed from: y5  reason: collision with root package name */
    public float f8545y5;

    /* renamed from: yc  reason: collision with root package name */
    public boolean f8546yc;

    /* renamed from: yg  reason: collision with root package name */
    public boolean f8547yg;

    /* renamed from: yk  reason: collision with root package name */
    public boolean f8548yk;

    /* loaded from: classes.dex */
    public static final class y {
        public static void y(t.y yVar, u0 u0Var) {
            LogSessionId y = u0Var.y();
            if (!y.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                yVar.f8451n3.setString("log-session-id", y.getStringId());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: v  reason: collision with root package name */
        public static final zn f8549v = new zn(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);

        /* renamed from: gv  reason: collision with root package name */
        public final b<m> f8550gv = new b<>();

        /* renamed from: n3  reason: collision with root package name */
        public final long f8551n3;
        public final long y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f8552zn;

        public zn(long j2, long j4, long j6) {
            this.y = j2;
            this.f8551n3 = j4;
            this.f8552zn = j6;
        }
    }

    public xc(int i, t.n3 n3Var, p pVar, boolean z2, float f4) {
        super(i);
        this.f8486c = n3Var;
        this.f8492d0 = (p) v5.y.v(pVar);
        this.f8499fh = z2;
        this.f8491d = f4;
        this.f8496ej = a9.fb.r();
        this.f8540x = new a9.fb(0);
        this.f8484b = new a9.fb(2);
        s sVar = new s();
        this.f8505j5 = sVar;
        this.f8526qn = new ArrayList<>();
        this.f8515o = new MediaCodec.BufferInfo();
        this.f8533u = 1.0f;
        this.f8545y5 = 1.0f;
        this.f8506jz = -9223372036854775807L;
        this.f8504j = new ArrayDeque<>();
        ne(zn.f8549v);
        sVar.mt(0);
        sVar.f56fb.order(ByteOrder.nativeOrder());
        this.f8530rs = -1.0f;
        this.f8527ra = 0;
        this.f8490cy = 0;
        this.f8544y4 = -1;
        this.f8532tg = -1;
        this.f8485bk = -9223372036854775807L;
        this.f8518oa = -9223372036854775807L;
        this.f8538w9 = -9223372036854775807L;
        this.f8503ix = -9223372036854775807L;
        this.f8525qk = 0;
        this.f8524qj = 0;
    }

    public static boolean cr(IllegalStateException illegalStateException) {
        if (j5.y >= 21 && o0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        if (stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
            return true;
        }
        return false;
    }

    public static boolean en(String str, m mVar) {
        if (j5.y <= 18 && mVar.f10958oz == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean f7(String str) {
        int i = j5.y;
        if (i >= 18 && ((i != 18 || (!"OMX.SEC.avc.dec".equals(str) && !"OMX.SEC.avc.dec.secure".equals(str))) && (i != 19 || !j5.f14361gv.startsWith("SM-G800") || (!"OMX.Exynos.avc.dec".equals(str) && !"OMX.Exynos.avc.dec.secure".equals(str))))) {
            return false;
        }
        return true;
    }

    public static boolean im(m mVar) {
        int i = mVar.f10971y5;
        if (i != 0 && i != 2) {
            return false;
        }
        return true;
    }

    public static boolean j(String str, m mVar) {
        if (j5.y < 21 && mVar.f10941c.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean jz(String str) {
        if (j5.y == 29 && "c2.android.aac.decoder".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean k(wz wzVar) {
        String str = wzVar.y;
        int i = j5.y;
        if ((i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || ((i <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) || ("Amazon".equals(j5.f14370zn) && "AFTS".equals(j5.f14361gv) && wzVar.f8469fb)))) {
            return true;
        }
        return false;
    }

    public static boolean o0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    public static boolean oz(String str) {
        if (j5.y < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(j5.f14370zn)) {
            String str2 = j5.f14363n3;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean q9(String str) {
        if (j5.y == 21 && "OMX.google.aac.decoder".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean ut(String str) {
        int i = j5.y;
        if (i > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i <= 19) {
                String str2 = j5.f14363n3;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean xb(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    @Override // m1.zq
    public boolean a() {
        return this.f8541x5;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ad(android.media.MediaCrypto r8, boolean r9) throws h3.xc.n3 {
        /*
            r7 = this;
            java.util.ArrayDeque<h3.wz> r0 = r7.f8495eb
            r1 = 0
            if (r0 != 0) goto L3a
            java.util.List r0 = r7.e(r9)     // Catch: h3.x4.zn -> L18
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch: h3.x4.zn -> L18
            r2.<init>()     // Catch: h3.x4.zn -> L18
            r7.f8495eb = r2     // Catch: h3.x4.zn -> L18
            boolean r3 = r7.f8499fh     // Catch: h3.x4.zn -> L18
            if (r3 == 0) goto L1a
            r2.addAll(r0)     // Catch: h3.x4.zn -> L18
            goto L2c
        L18:
            r8 = move-exception
            goto L2f
        L1a:
            boolean r2 = r0.isEmpty()     // Catch: h3.x4.zn -> L18
            if (r2 != 0) goto L2c
            java.util.ArrayDeque<h3.wz> r2 = r7.f8495eb     // Catch: h3.x4.zn -> L18
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch: h3.x4.zn -> L18
            h3.wz r0 = (h3.wz) r0     // Catch: h3.x4.zn -> L18
            r2.add(r0)     // Catch: h3.x4.zn -> L18
        L2c:
            r7.f8510lc = r1     // Catch: h3.x4.zn -> L18
            goto L3a
        L2f:
            h3.xc$n3 r0 = new h3.xc$n3
            m1.m r1 = r7.f8519oz
            r2 = -49998(0xffffffffffff3cb2, float:NaN)
            r0.<init>(r1, r8, r9, r2)
            throw r0
        L3a:
            java.util.ArrayDeque<h3.wz> r0 = r7.f8495eb
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb6
            java.util.ArrayDeque<h3.wz> r0 = r7.f8495eb
            java.lang.Object r0 = r0.peekFirst()
            h3.wz r0 = (h3.wz) r0
        L4a:
            h3.t r2 = r7.f8543xg
            if (r2 != 0) goto Lb3
            java.util.ArrayDeque<h3.wz> r2 = r7.f8495eb
            java.lang.Object r2 = r2.peekFirst()
            h3.wz r2 = (h3.wz) r2
            boolean r3 = r7.bv(r2)
            if (r3 != 0) goto L5d
            return
        L5d:
            r7.pz(r2, r8)     // Catch: java.lang.Exception -> L61
            goto L4a
        L61:
            r3 = move-exception
            java.lang.String r4 = "MediaCodecRenderer"
            if (r2 != r0) goto L76
            java.lang.String r3 = "Preferred decoder instantiation failed. Sleeping for 50ms then retrying."
            v5.r.c5(r4, r3)     // Catch: java.lang.Exception -> L74
            r5 = 50
            java.lang.Thread.sleep(r5)     // Catch: java.lang.Exception -> L74
            r7.pz(r2, r8)     // Catch: java.lang.Exception -> L74
            goto L4a
        L74:
            r3 = move-exception
            goto L77
        L76:
            throw r3     // Catch: java.lang.Exception -> L74
        L77:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to initialize decoder: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            v5.r.i9(r4, r5, r3)
            java.util.ArrayDeque<h3.wz> r4 = r7.f8495eb
            r4.removeFirst()
            h3.xc$n3 r4 = new h3.xc$n3
            m1.m r5 = r7.f8519oz
            r4.<init>(r5, r3, r9, r2)
            r7.cy(r4)
            h3.xc$n3 r2 = r7.f8510lc
            if (r2 != 0) goto La1
            r7.f8510lc = r4
            goto La7
        La1:
            h3.xc$n3 r2 = h3.xc.n3.y(r2, r4)
            r7.f8510lc = r2
        La7:
            java.util.ArrayDeque<h3.wz> r2 = r7.f8495eb
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lb0
            goto L4a
        Lb0:
            h3.xc$n3 r8 = r7.f8510lc
            throw r8
        Lb3:
            r7.f8495eb = r1
            return
        Lb6:
            h3.xc$n3 r8 = new h3.xc$n3
            m1.m r0 = r7.f8519oz
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r8.<init>(r0, r1, r9, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.xc.ad(android.media.MediaCrypto, boolean):void");
    }

    @Nullable
    public final wz ap() {
        return this.f8514nf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r5 >= r1) goto L14;
     */
    @Override // m1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(m1.m[] r16, long r17, long r19) throws m1.p {
        /*
            r15 = this;
            r0 = r15
            h3.xc$zn r1 = r0.f8529ro
            long r1 = r1.f8552zn
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L21
            h3.xc$zn r1 = new h3.xc$zn
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r1
            r9 = r17
            r11 = r19
            r6.<init>(r7, r9, r11)
            r15.ne(r1)
            goto L68
        L21:
            java.util.ArrayDeque<h3.xc$zn> r1 = r0.f8504j
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L57
            long r1 = r0.f8518oa
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L39
            long r5 = r0.f8503ix
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L57
        L39:
            h3.xc$zn r1 = new h3.xc$zn
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r1
            r11 = r17
            r13 = r19
            r8.<init>(r9, r11, r13)
            r15.ne(r1)
            h3.xc$zn r1 = r0.f8529ro
            long r1 = r1.f8552zn
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L68
            r15.w9()
            goto L68
        L57:
            java.util.ArrayDeque<h3.xc$zn> r1 = r0.f8504j
            h3.xc$zn r9 = new h3.xc$zn
            long r3 = r0.f8518oa
            r2 = r9
            r5 = r17
            r7 = r19
            r2.<init>(r3, r5, r7)
            r1.add(r9)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.xc.b(m1.m[], long, long):void");
    }

    public boolean br(m mVar) {
        return false;
    }

    public boolean bv(wz wzVar) {
        return true;
    }

    public final void c8(long j2) throws m1.p {
        m i92 = this.f8529ro.f8550gv.i9(j2);
        if (i92 == null && this.f8548yk && this.f8489ct != null) {
            i92 = this.f8529ro.f8550gv.c5();
        }
        if (i92 != null) {
            this.f8535ut = i92;
        } else if (!this.f8517o4 || this.f8535ut == null) {
            return;
        }
        gq(this.f8535ut, this.f8489ct);
        this.f8517o4 = false;
        this.f8548yk = false;
    }

    @Override // m1.a, m1.k3
    public final int co() {
        return 8;
    }

    public final void cs() throws m1.p {
        ro();
        wf();
    }

    @TargetApi(23)
    public final boolean ct() throws m1.p {
        if (this.f8509l) {
            this.f8525qk = 1;
            if (!this.f8531s8 && !this.f8547yg) {
                this.f8524qj = 2;
            } else {
                this.f8524qj = 3;
                return false;
            }
        } else {
            n7();
        }
        return true;
    }

    public abstract void cy(Exception exc);

    @Override // m1.a
    public void d() {
        this.f8519oz = null;
        ne(zn.f8549v);
        this.f8504j.clear();
        ra();
    }

    public final void dm() throws m1.p {
        if (this.f8509l) {
            this.f8525qk = 1;
            this.f8524qj = 3;
            return;
        }
        cs();
    }

    public final List<wz> e(boolean z2) throws x4.zn {
        List<wz> rb2 = rb(this.f8492d0, this.f8519oz, z2);
        if (rb2.isEmpty() && z2) {
            rb2 = rb(this.f8492d0, this.f8519oz, false);
            if (!rb2.isEmpty()) {
                v5.r.c5("MediaCodecRenderer", "Drm session requires secure decoder for " + this.f8519oz.f10948f3 + ", but no secure decoder available. Trying to proceed with " + rb2 + ".");
            }
        }
        return rb2;
    }

    public final boolean eb() throws m1.p {
        int i;
        if (this.f8543xg == null || (i = this.f8525qk) == 2 || this.f8537w2) {
            return false;
        }
        if (i == 0 && fc()) {
            dm();
        }
        if (this.f8544y4 < 0) {
            int f4 = this.f8543xg.f();
            this.f8544y4 = f4;
            if (f4 < 0) {
                return false;
            }
            this.f8540x.f56fb = this.f8543xg.gv(f4);
            this.f8540x.a();
        }
        if (this.f8525qk == 1) {
            if (!this.f8500g) {
                this.f8502gq = true;
                this.f8543xg.a(this.f8544y4, 0, 0, 0L, 4);
                i3();
            }
            this.f8525qk = 2;
            return false;
        } else if (this.f8501g3) {
            this.f8501g3 = false;
            ByteBuffer byteBuffer = this.f8540x.f56fb;
            byte[] bArr = f8481i2;
            byteBuffer.put(bArr);
            this.f8543xg.a(this.f8544y4, 0, bArr.length, 0L, 0);
            i3();
            this.f8509l = true;
            return true;
        } else {
            if (this.f8490cy == 1) {
                for (int i5 = 0; i5 < this.f8493dm.f10941c.size(); i5++) {
                    this.f8540x.f56fb.put(this.f8493dm.f10941c.get(i5));
                }
                this.f8490cy = 2;
            }
            int position = this.f8540x.f56fb.position();
            g d02 = d0();
            try {
                int k52 = k5(d02, this.f8540x, 0);
                if (c5() || this.f8540x.xc()) {
                    this.f8538w9 = this.f8518oa;
                }
                if (k52 == -3) {
                    return false;
                }
                if (k52 == -5) {
                    if (this.f8490cy == 2) {
                        this.f8540x.a();
                        this.f8490cy = 1;
                    }
                    l(d02);
                    return true;
                } else if (this.f8540x.t()) {
                    if (this.f8490cy == 2) {
                        this.f8540x.a();
                        this.f8490cy = 1;
                    }
                    this.f8537w2 = true;
                    if (!this.f8509l) {
                        x5();
                        return false;
                    }
                    try {
                        if (!this.f8500g) {
                            this.f8502gq = true;
                            this.f8543xg.a(this.f8544y4, 0, 0, 0L, 4);
                            i3();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e2) {
                        throw f3(e2, this.f8519oz, j5.q9(e2.getErrorCode()));
                    }
                } else if (!this.f8509l && !this.f8540x.wz()) {
                    this.f8540x.a();
                    if (this.f8490cy == 2) {
                        this.f8490cy = 1;
                    }
                    return true;
                } else {
                    boolean z2 = this.f8540x.z();
                    if (z2) {
                        this.f8540x.f60v.n3(position);
                    }
                    if (this.f8494e && !z2) {
                        c.n3(this.f8540x.f56fb);
                        if (this.f8540x.f56fb.position() == 0) {
                            return true;
                        }
                        this.f8494e = false;
                    }
                    a9.fb fbVar = this.f8540x;
                    long j2 = fbVar.f55f;
                    c5 c5Var = this.f8534u0;
                    if (c5Var != null) {
                        j2 = c5Var.gv(this.f8519oz, fbVar);
                        this.f8518oa = Math.max(this.f8518oa, this.f8534u0.n3(this.f8519oz));
                    }
                    long j4 = j2;
                    if (this.f8540x.f()) {
                        this.f8526qn.add(Long.valueOf(j4));
                    }
                    if (this.f8522q5) {
                        if (!this.f8504j.isEmpty()) {
                            this.f8504j.peekLast().f8550gv.y(j4, this.f8519oz);
                        } else {
                            this.f8529ro.f8550gv.y(j4, this.f8519oz);
                        }
                        this.f8522q5 = false;
                    }
                    this.f8518oa = Math.max(this.f8518oa, j4);
                    this.f8540x.co();
                    if (this.f8540x.c5()) {
                        bk(this.f8540x);
                    }
                    w2(this.f8540x);
                    try {
                        if (z2) {
                            this.f8543xg.fb(this.f8544y4, 0, this.f8540x.f60v, j4, 0);
                        } else {
                            this.f8543xg.a(this.f8544y4, 0, this.f8540x.f56fb.limit(), j4, 0);
                        }
                        i3();
                        this.f8509l = true;
                        this.f8490cy = 0;
                        this.f8488cs.f86zn++;
                        return true;
                    } catch (MediaCodec.CryptoException e3) {
                        throw f3(e3, this.f8519oz, j5.q9(e3.getErrorCode()));
                    }
                }
            } catch (fb.y e5) {
                cy(e5);
                le(0);
                lc();
                return true;
            }
        }
    }

    @Override // m1.a
    public void ej(long j2, boolean z2) throws m1.p {
        this.f8537w2 = false;
        this.f8541x5 = false;
        this.f8513mp = false;
        if (this.f8516o0) {
            this.f8505j5.a();
            this.f8484b.a();
            this.f8542xb = false;
        } else {
            nf();
        }
        if (this.f8529ro.f8550gv.t() > 0) {
            this.f8522q5 = true;
        }
        this.f8529ro.f8550gv.zn();
        this.f8504j.clear();
    }

    public boolean fc() {
        return false;
    }

    public final long g() {
        return this.f8529ro.f8552zn;
    }

    @Nullable
    public final f8.i4 g3(com.google.android.exoplayer2.drm.gv gvVar) throws m1.p {
        a9.n3 v2 = gvVar.v();
        if (v2 != null && !(v2 instanceof f8.i4)) {
            throw f3(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + v2), this.f8519oz, 6001);
        }
        return (f8.i4) v2;
    }

    public final boolean gf(long j2) {
        if (this.f8506jz != -9223372036854775807L && SystemClock.elapsedRealtime() - j2 >= this.f8506jz) {
            return false;
        }
        return true;
    }

    public abstract void gq(m mVar, @Nullable MediaFormat mediaFormat) throws m1.p;

    public final void hw() throws m1.p {
        v5.y.fb(!this.f8537w2);
        g d02 = d0();
        this.f8484b.a();
        do {
            this.f8484b.a();
            int k52 = k5(d02, this.f8484b, 0);
            if (k52 != -5) {
                if (k52 != -4) {
                    if (k52 == -3) {
                        return;
                    }
                    throw new IllegalStateException();
                } else if (this.f8484b.t()) {
                    this.f8537w2 = true;
                    return;
                } else {
                    if (this.f8522q5) {
                        m mVar = (m) v5.y.v(this.f8519oz);
                        this.f8535ut = mVar;
                        gq(mVar, null);
                        this.f8522q5 = false;
                    }
                    this.f8484b.co();
                }
            } else {
                l(d02);
                return;
            }
        } while (this.f8505j5.i4(this.f8484b));
        this.f8542xb = true;
    }

    public void i2() {
        yk();
        this.f8511le = null;
        this.f8534u0 = null;
        this.f8495eb = null;
        this.f8514nf = null;
        this.f8493dm = null;
        this.f8489ct = null;
        this.f8517o4 = false;
        this.f8536vp = false;
        this.f8530rs = -1.0f;
        this.f8527ra = 0;
        this.f8494e = false;
        this.f8531s8 = false;
        this.f8483ap = false;
        this.f8547yg = false;
        this.f8546yc = false;
        this.f8508kp = false;
        this.f8528rb = false;
        this.f8500g = false;
        this.f8482ad = false;
        this.f8490cy = 0;
        this.f8497en = false;
    }

    public final void i3() {
        this.f8544y4 = -1;
        this.f8540x.f56fb = null;
    }

    @Override // m1.zq
    public boolean isReady() {
        if (this.f8519oz != null && (ta() || y4() || (this.f8485bk != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f8485bk))) {
            return true;
        }
        return false;
    }

    public final void j3(@Nullable com.google.android.exoplayer2.drm.gv gvVar) {
        f8.i9.y(this.f8523q9, gvVar);
        this.f8523q9 = gvVar;
    }

    public final boolean j5(long j2, long j4) throws m1.p {
        v5.y.fb(!this.f8541x5);
        if (this.f8505j5.fh()) {
            s sVar = this.f8505j5;
            if (q5(j2, j4, null, sVar.f56fb, this.f8532tg, 0, sVar.d0(), this.f8505j5.n(), this.f8505j5.f(), this.f8505j5.t(), this.f8535ut)) {
                oa(this.f8505j5.c());
                this.f8505j5.a();
            } else {
                return false;
            }
        }
        if (this.f8537w2) {
            this.f8541x5 = true;
            return false;
        }
        if (this.f8542xb) {
            v5.y.fb(this.f8505j5.i4(this.f8484b));
            this.f8542xb = false;
        }
        if (this.f8539wf) {
            if (this.f8505j5.fh()) {
                return true;
            }
            y5();
            this.f8539wf = false;
            wf();
            if (!this.f8516o0) {
                return false;
            }
        }
        hw();
        if (this.f8505j5.fh()) {
            this.f8505j5.co();
        }
        if (!this.f8505j5.fh() && !this.f8537w2 && !this.f8539wf) {
            return false;
        }
        return true;
    }

    @Nullable
    public final MediaFormat kp() {
        return this.f8489ct;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
        if (ct() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b5, code lost:
        if (ct() == false) goto L45;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a9.c5 l(m1.g r12) throws m1.p {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.xc.l(m1.g):a9.c5");
    }

    public final void lc() {
        try {
            this.f8543xg.flush();
        } finally {
            yk();
        }
    }

    public final boolean le(int i) throws m1.p {
        g d02 = d0();
        this.f8496ej.a();
        int k52 = k5(d02, this.f8496ej, i | 4);
        if (k52 == -5) {
            l(d02);
            return true;
        } else if (k52 == -4 && this.f8496ej.t()) {
            this.f8537w2 = true;
            x5();
            return false;
        } else {
            return false;
        }
    }

    public abstract t.y m(wz wzVar, m mVar, @Nullable MediaCrypto mediaCrypto, float f4);

    public final boolean mh(m mVar) throws m1.p {
        if (j5.y >= 23 && this.f8543xg != null && this.f8524qj != 3 && getState() != 0) {
            float yc2 = yc(this.f8545y5, mVar, mg());
            float f4 = this.f8530rs;
            if (f4 == yc2) {
                return true;
            }
            if (yc2 == -1.0f) {
                dm();
                return false;
            } else if (f4 == -1.0f && yc2 <= this.f8491d) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", yc2);
                this.f8543xg.c5(bundle);
                this.f8530rs = yc2;
            }
        }
        return true;
    }

    public final void mp() {
        this.f8536vp = true;
        MediaFormat y2 = this.f8543xg.y();
        if (this.f8527ra != 0 && y2.getInteger("width") == 32 && y2.getInteger("height") == 32) {
            this.f8512m = true;
            return;
        }
        if (this.f8528rb) {
            y2.setInteger("channel-count", 1);
        }
        this.f8489ct = y2;
        this.f8517o4 = true;
    }

    @Override // m1.k3
    public final int n3(m mVar) throws m1.p {
        try {
            return uo(this.f8492d0, mVar);
        } catch (x4.zn e2) {
            throw f3(e2, mVar, 4002);
        }
    }

    public final void n7() throws m1.p {
        try {
            this.f8498f7.setMediaDrmSession(g3(this.f8507k).f7906n3);
            j3(this.f8507k);
            this.f8525qk = 0;
            this.f8524qj = 0;
        } catch (MediaCryptoException e2) {
            throw f3(e2, this.f8519oz, 6006);
        }
    }

    public final void nd(@Nullable com.google.android.exoplayer2.drm.gv gvVar) {
        f8.i9.y(this.f8507k, gvVar);
        this.f8507k = gvVar;
    }

    public final void ne(zn znVar) {
        this.f8529ro = znVar;
        long j2 = znVar.f8552zn;
        if (j2 != -9223372036854775807L) {
            this.f8548yk = true;
            vp(j2);
        }
    }

    public final boolean nf() throws m1.p {
        boolean ra2 = ra();
        if (ra2) {
            wf();
        }
        return ra2;
    }

    public final int o(String str) {
        int i = j5.y;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = j5.f14361gv;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i < 24) {
            if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
                String str3 = j5.f14363n3;
                if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    public final boolean o4(long j2, long j4) throws m1.p {
        boolean z2;
        boolean q52;
        boolean z3;
        int t2;
        boolean z4;
        if (!y4()) {
            if (this.f8546yc && this.f8502gq) {
                try {
                    t2 = this.f8543xg.t(this.f8515o);
                } catch (IllegalStateException unused) {
                    x5();
                    if (this.f8541x5) {
                        ro();
                    }
                    return false;
                }
            } else {
                t2 = this.f8543xg.t(this.f8515o);
            }
            if (t2 < 0) {
                if (t2 == -2) {
                    mp();
                    return true;
                }
                if (this.f8500g && (this.f8537w2 || this.f8525qk == 2)) {
                    x5();
                }
                return false;
            } else if (this.f8512m) {
                this.f8512m = false;
                this.f8543xg.tl(t2, false);
                return true;
            } else {
                MediaCodec.BufferInfo bufferInfo = this.f8515o;
                if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                    x5();
                    return false;
                }
                this.f8532tg = t2;
                ByteBuffer wz2 = this.f8543xg.wz(t2);
                this.f8521pz = wz2;
                if (wz2 != null) {
                    wz2.position(this.f8515o.offset);
                    ByteBuffer byteBuffer = this.f8521pz;
                    MediaCodec.BufferInfo bufferInfo2 = this.f8515o;
                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                }
                if (this.f8508kp) {
                    MediaCodec.BufferInfo bufferInfo3 = this.f8515o;
                    if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0) {
                        long j6 = this.f8518oa;
                        if (j6 != -9223372036854775807L) {
                            bufferInfo3.presentationTimeUs = j6;
                        }
                    }
                }
                this.f8520pq = pq(this.f8515o.presentationTimeUs);
                long j7 = this.f8538w9;
                long j8 = this.f8515o.presentationTimeUs;
                if (j7 == j8) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.f8487cr = z4;
                c8(j8);
            }
        }
        if (this.f8546yc && this.f8502gq) {
            try {
                t tVar = this.f8543xg;
                ByteBuffer byteBuffer2 = this.f8521pz;
                int i = this.f8532tg;
                MediaCodec.BufferInfo bufferInfo4 = this.f8515o;
                z2 = false;
                try {
                    q52 = q5(j2, j4, tVar, byteBuffer2, i, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.f8520pq, this.f8487cr, this.f8535ut);
                } catch (IllegalStateException unused2) {
                    x5();
                    if (this.f8541x5) {
                        ro();
                    }
                    return z2;
                }
            } catch (IllegalStateException unused3) {
                z2 = false;
            }
        } else {
            z2 = false;
            t tVar2 = this.f8543xg;
            ByteBuffer byteBuffer3 = this.f8521pz;
            int i5 = this.f8532tg;
            MediaCodec.BufferInfo bufferInfo5 = this.f8515o;
            q52 = q5(j2, j4, tVar2, byteBuffer3, i5, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f8520pq, this.f8487cr, this.f8535ut);
        }
        if (q52) {
            oa(this.f8515o.presentationTimeUs);
            if ((this.f8515o.flags & 4) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            vn();
            if (!z3) {
                return true;
            }
            x5();
        }
        return z2;
    }

    public void oa(long j2) {
        this.f8503ix = j2;
        while (!this.f8504j.isEmpty() && j2 >= this.f8504j.peek().y) {
            ne(this.f8504j.poll());
            w9();
        }
    }

    @Override // m1.a, m1.zq
    public void p(float f4, float f6) throws m1.p {
        this.f8533u = f4;
        this.f8545y5 = f6;
        mh(this.f8493dm);
    }

    public final boolean pq(long j2) {
        int size = this.f8526qn.size();
        for (int i = 0; i < size; i++) {
            if (this.f8526qn.get(i).longValue() == j2) {
                this.f8526qn.remove(i);
                return true;
            }
        }
        return false;
    }

    public final void pz(wz wzVar, MediaCrypto mediaCrypto) throws Exception {
        float yc2;
        boolean z2;
        boolean z3 = false;
        String str = wzVar.y;
        int i = j5.y;
        float f4 = -1.0f;
        if (i < 23) {
            yc2 = -1.0f;
        } else {
            yc2 = yc(this.f8545y5, this.f8519oz, mg());
        }
        if (yc2 > this.f8491d) {
            f4 = yc2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        t.y m2 = m(wzVar, this.f8519oz, mediaCrypto, f4);
        if (i >= 31) {
            y.y(m2, rz());
        }
        try {
            yt.y("createCodec:" + str);
            this.f8543xg = this.f8486c.y(m2);
            yt.zn();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!wzVar.p(this.f8519oz)) {
                v5.r.c5("MediaCodecRenderer", j5.rz("Format exceeds selected codec's capabilities [%s, %s]", m.i9(this.f8519oz), str));
            }
            this.f8514nf = wzVar;
            this.f8530rs = f4;
            this.f8493dm = this.f8519oz;
            this.f8527ra = o(str);
            this.f8494e = j(str, this.f8493dm);
            this.f8531s8 = f7(str);
            this.f8483ap = jz(str);
            this.f8547yg = ut(str);
            this.f8546yc = q9(str);
            this.f8508kp = oz(str);
            this.f8528rb = en(str, this.f8493dm);
            if (!k(wzVar) && !yg()) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f8500g = z2;
            if (this.f8543xg.s()) {
                this.f8482ad = true;
                this.f8490cy = 1;
                if (this.f8527ra != 0) {
                    z3 = true;
                }
                this.f8501g3 = z3;
            }
            if ("c2.android.mp3.decoder".equals(wzVar.y)) {
                this.f8534u0 = new c5();
            }
            if (getState() == 2) {
                this.f8485bk = SystemClock.elapsedRealtime() + 1000;
            }
            this.f8488cs.y++;
            qk(str, m2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            yt.zn();
            throw th;
        }
    }

    public final void q() {
        this.f8513mp = true;
    }

    public abstract boolean q5(long j2, long j4, @Nullable t tVar, @Nullable ByteBuffer byteBuffer, int i, int i5, int i6, long j6, boolean z2, boolean z3, m mVar) throws m1.p;

    public abstract void qj(String str);

    public abstract void qk(String str, t.y yVar, long j2, long j4);

    public abstract a9.c5 qn(wz wzVar, m mVar, m mVar2);

    public boolean ra() {
        boolean z2;
        if (this.f8543xg == null) {
            return false;
        }
        int i = this.f8524qj;
        if (i != 3 && !this.f8531s8 && ((!this.f8483ap || this.f8536vp) && (!this.f8547yg || !this.f8502gq))) {
            if (i == 2) {
                int i5 = j5.y;
                if (i5 >= 23) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v5.y.fb(z2);
                if (i5 >= 23) {
                    try {
                        n7();
                    } catch (m1.p e2) {
                        v5.r.i9("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e2);
                        ro();
                        return true;
                    }
                }
            }
            lc();
            return false;
        }
        ro();
        return true;
    }

    public abstract List<wz> rb(p pVar, m mVar, boolean z2) throws x4.zn;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.drm.gv, android.media.MediaCrypto] */
    public void ro() {
        try {
            t tVar = this.f8543xg;
            if (tVar != null) {
                tVar.release();
                this.f8488cs.f82n3++;
                qj(this.f8514nf.y);
            }
            this.f8543xg = null;
            try {
                MediaCrypto mediaCrypto = this.f8498f7;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.f8543xg = null;
            try {
                MediaCrypto mediaCrypto2 = this.f8498f7;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    public final boolean rs(wz wzVar, m mVar, @Nullable com.google.android.exoplayer2.drm.gv gvVar, @Nullable com.google.android.exoplayer2.drm.gv gvVar2) throws m1.p {
        f8.i4 g32;
        boolean fb2;
        if (gvVar == gvVar2) {
            return false;
        }
        if (gvVar2 == null || gvVar == null || !gvVar2.zn().equals(gvVar.zn()) || j5.y < 23) {
            return true;
        }
        UUID uuid = m1.c5.f10606v;
        if (uuid.equals(gvVar.zn()) || uuid.equals(gvVar2.zn()) || (g32 = g3(gvVar2)) == null) {
            return true;
        }
        if (g32.f7907zn) {
            fb2 = false;
        } else {
            fb2 = gvVar2.fb(mVar.f10948f3);
        }
        if (wzVar.f8469fb || !fb2) {
            return false;
        }
        return true;
    }

    @Nullable
    public final t s8() {
        return this.f8543xg;
    }

    public final void tg(m mVar) {
        y5();
        String str = mVar.f10948f3;
        if (!"audio/mp4a-latm".equals(str) && !"audio/mpeg".equals(str) && !"audio/opus".equals(str)) {
            this.f8505j5.rz(1);
        } else {
            this.f8505j5.rz(32);
        }
        this.f8516o0 = true;
    }

    public tl u(Throwable th, @Nullable wz wzVar) {
        return new tl(th, wzVar);
    }

    public float u0() {
        return this.f8533u;
    }

    @Override // m1.a
    public void ud() {
        try {
            y5();
            ro();
        } finally {
            nd(null);
        }
    }

    public abstract int uo(p pVar, m mVar) throws x4.zn;

    public final void vn() {
        this.f8532tg = -1;
        this.f8521pz = null;
    }

    public abstract void w2(a9.fb fbVar) throws m1.p;

    public final void wf() throws m1.p {
        m mVar;
        boolean z2;
        if (this.f8543xg == null && !this.f8516o0 && (mVar = this.f8519oz) != null) {
            if (this.f8507k == null && br(mVar)) {
                tg(this.f8519oz);
                return;
            }
            j3(this.f8507k);
            String str = this.f8519oz.f10948f3;
            com.google.android.exoplayer2.drm.gv gvVar = this.f8523q9;
            if (gvVar != null) {
                if (this.f8498f7 == null) {
                    f8.i4 g32 = g3(gvVar);
                    if (g32 == null) {
                        if (this.f8523q9.getError() == null) {
                            return;
                        }
                    } else {
                        try {
                            MediaCrypto mediaCrypto = new MediaCrypto(g32.y, g32.f7906n3);
                            this.f8498f7 = mediaCrypto;
                            if (!g32.f7907zn && mediaCrypto.requiresSecureDecoderComponent(str)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            this.f8497en = z2;
                        } catch (MediaCryptoException e2) {
                            throw f3(e2, this.f8519oz, 6006);
                        }
                    }
                }
                if (f8.i4.f7905gv) {
                    int state = this.f8523q9.getState();
                    if (state != 1) {
                        if (state != 4) {
                            return;
                        }
                    } else {
                        gv.y yVar = (gv.y) v5.y.v(this.f8523q9.getError());
                        throw f3(yVar, this.f8519oz, yVar.errorCode);
                    }
                }
            }
            try {
                ad(this.f8498f7, this.f8497en);
            } catch (n3 e3) {
                throw f3(e3, this.f8519oz, 4001);
            }
        }
    }

    public final void wm(m1.p pVar) {
        this.f8511le = pVar;
    }

    @TargetApi(23)
    public final void x5() throws m1.p {
        int i = this.f8524qj;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    this.f8541x5 = true;
                    ix();
                    return;
                }
                cs();
                return;
            }
            lc();
            n7();
            return;
        }
        lc();
    }

    public final boolean xg() {
        if (this.f8509l) {
            this.f8525qk = 1;
            if (!this.f8531s8 && !this.f8547yg) {
                this.f8524qj = 1;
            } else {
                this.f8524qj = 3;
                return false;
            }
        }
        return true;
    }

    public final boolean y4() {
        if (this.f8532tg >= 0) {
            return true;
        }
        return false;
    }

    public final void y5() {
        this.f8539wf = false;
        this.f8505j5.a();
        this.f8484b.a();
        this.f8542xb = false;
        this.f8516o0 = false;
    }

    public abstract float yc(float f4, m mVar, m[] mVarArr);

    public boolean yg() {
        return false;
    }

    public void yk() {
        i3();
        vn();
        this.f8485bk = -9223372036854775807L;
        this.f8502gq = false;
        this.f8509l = false;
        this.f8501g3 = false;
        this.f8512m = false;
        this.f8520pq = false;
        this.f8487cr = false;
        this.f8526qn.clear();
        this.f8518oa = -9223372036854775807L;
        this.f8538w9 = -9223372036854775807L;
        this.f8503ix = -9223372036854775807L;
        c5 c5Var = this.f8534u0;
        if (c5Var != null) {
            c5Var.zn();
        }
        this.f8525qk = 0;
        this.f8524qj = 0;
        this.f8490cy = this.f8482ad ? 1 : 0;
    }

    @Override // m1.zq
    public void z(long j2, long j4) throws m1.p {
        boolean z2 = false;
        if (this.f8513mp) {
            this.f8513mp = false;
            x5();
        }
        m1.p pVar = this.f8511le;
        if (pVar == null) {
            try {
                if (this.f8541x5) {
                    ix();
                    return;
                } else if (this.f8519oz == null && !le(2)) {
                    return;
                } else {
                    wf();
                    if (this.f8516o0) {
                        yt.y("bypassRender");
                        while (j5(j2, j4)) {
                        }
                        yt.zn();
                    } else if (this.f8543xg != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        yt.y("drainAndFeed");
                        while (o4(j2, j4) && gf(elapsedRealtime)) {
                        }
                        while (eb() && gf(elapsedRealtime)) {
                        }
                        yt.zn();
                    } else {
                        this.f8488cs.f80gv += vl(j2);
                        le(1);
                    }
                    this.f8488cs.zn();
                    return;
                }
            } catch (IllegalStateException e2) {
                if (cr(e2)) {
                    cy(e2);
                    if (j5.y >= 21 && xb(e2)) {
                        z2 = true;
                    }
                    if (z2) {
                        ro();
                    }
                    throw n(u(e2, ap()), this.f8519oz, z2, 4003);
                }
                throw e2;
            }
        }
        this.f8511le = null;
        throw pVar;
    }

    @Override // m1.a
    public void z6(boolean z2, boolean z3) throws m1.p {
        this.f8488cs = new a9.v();
    }

    /* loaded from: classes.dex */
    public static class n3 extends Exception {
        @Nullable
        public final wz codecInfo;
        @Nullable
        public final String diagnosticInfo;
        @Nullable
        public final n3 fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public n3(m mVar, @Nullable Throwable th, boolean z2, int i) {
            this("Decoder init failed: [" + i + "], " + mVar, th, mVar.f10948f3, z2, null, gv(i), null);
        }

        @Nullable
        public static String a(@Nullable Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public static String gv(int i) {
            String str;
            if (i < 0) {
                str = "neg_";
            } else {
                str = "";
            }
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + str + Math.abs(i);
        }

        @CheckResult
        public final n3 v(n3 n3Var) {
            return new n3(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, n3Var);
        }

        public n3(m mVar, @Nullable Throwable th, boolean z2, wz wzVar) {
            this("Decoder init failed: " + wzVar.y + ", " + mVar, th, mVar.f10948f3, z2, wzVar, j5.y >= 21 ? a(th) : null, null);
        }

        public n3(String str, @Nullable Throwable th, String str2, boolean z2, @Nullable wz wzVar, @Nullable String str3, @Nullable n3 n3Var) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z2;
            this.codecInfo = wzVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = n3Var;
        }
    }

    @Override // m1.a
    public void a8() {
    }

    public void ix() throws m1.p {
    }

    public void w9() {
    }

    @Override // m1.a
    public void x() {
    }

    public void bk(a9.fb fbVar) throws m1.p {
    }

    public void vp(long j2) {
    }
}
