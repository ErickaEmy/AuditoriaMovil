package d9;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import d9.x4;
import d9.z;
import h3.t;
import h3.x4;
import java.nio.ByteBuffer;
import java.util.List;
import m1.br;
import m1.g;
import m1.hk;
import m1.m;
import m1.zq;
import v5.j5;
/* loaded from: classes.dex */
public class ej extends h3.xc implements v5.i4 {

    /* renamed from: br  reason: collision with root package name */
    public boolean f6991br;

    /* renamed from: bv  reason: collision with root package name */
    public boolean f6992bv;
    public boolean fc;
    public long gf;

    /* renamed from: i3  reason: collision with root package name */
    public final Context f6993i3;
    @Nullable
    public zq.y im;

    /* renamed from: j3  reason: collision with root package name */
    public final x4 f6994j3;
    @Nullable

    /* renamed from: nd  reason: collision with root package name */
    public m f6995nd;

    /* renamed from: ne  reason: collision with root package name */
    public int f6996ne;

    /* renamed from: q  reason: collision with root package name */
    public boolean f6997q;

    /* renamed from: uo  reason: collision with root package name */
    public boolean f6998uo;

    /* renamed from: vn  reason: collision with root package name */
    public final z.y f6999vn;
    @Nullable

    /* renamed from: wm  reason: collision with root package name */
    public m f7000wm;

    /* loaded from: classes.dex */
    public static final class n3 {
        public static void y(x4 x4Var, @Nullable Object obj) {
            x4Var.c5((AudioDeviceInfo) obj);
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements x4.zn {
        public zn() {
        }

        @Override // d9.x4.zn
        public void fb(long j2) {
            ej.this.f6999vn.fh(j2);
        }

        @Override // d9.x4.zn
        public void fh() {
            ej.this.gn();
        }

        @Override // d9.x4.zn
        public void gv(Exception exc) {
            v5.r.gv("MediaCodecAudioRenderer", "Audio sink error", exc);
            ej.this.f6999vn.t(exc);
        }

        @Override // d9.x4.zn
        public void n(int i, long j2, long j4) {
            ej.this.f6999vn.mg(i, j2, j4);
        }

        @Override // d9.x4.zn
        public void onSkipSilenceEnabledChanged(boolean z2) {
            ej.this.f6999vn.rz(z2);
        }

        @Override // d9.x4.zn
        public void rz() {
            if (ej.this.im != null) {
                ej.this.im.n3();
            }
        }

        @Override // d9.x4.zn
        public void t() {
            if (ej.this.im != null) {
                ej.this.im.y();
            }
        }
    }

    public ej(Context context, t.n3 n3Var, h3.p pVar, boolean z2, @Nullable Handler handler, @Nullable z zVar, x4 x4Var) {
        super(1, n3Var, pVar, z2, 44100.0f);
        this.f6993i3 = context.getApplicationContext();
        this.f6994j3 = x4Var;
        this.f6999vn = new z.y(handler, zVar);
        x4Var.d0(new zn());
    }

    public static boolean jr() {
        if (j5.y == 23) {
            String str = j5.f14361gv;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<h3.wz> k3(h3.p pVar, m mVar, boolean z2, x4 x4Var) throws x4.zn {
        h3.wz x42;
        String str = mVar.f10948f3;
        if (str == null) {
            return z0.x4.j5();
        }
        if (x4Var.n3(mVar) && (x42 = h3.x4.x4()) != null) {
            return z0.x4.o(x42);
        }
        List<h3.wz> decoderInfos = pVar.getDecoderInfos(str, z2, false);
        String tl2 = h3.x4.tl(mVar);
        if (tl2 == null) {
            return z0.x4.d(decoderInfos);
        }
        return z0.x4.x4().fb(decoderInfos).fb(pVar.getDecoderInfos(tl2, z2, false)).s();
    }

    public static boolean r6(String str) {
        if (j5.y < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(j5.f14370zn)) {
            String str2 = j5.f14363n3;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private int zq(h3.wz wzVar, m mVar) {
        int i;
        if ("OMX.google.raw.decoder".equals(wzVar.y) && (i = j5.y) < 24 && (i != 23 || !j5.tg(this.f6993i3))) {
            return -1;
        }
        return mVar.f10956n;
    }

    @Override // h3.xc, m1.zq
    public boolean a() {
        if (super.a() && this.f6994j3.a()) {
            return true;
        }
        return false;
    }

    @Override // h3.xc, m1.a
    public void a8() {
        super.a8();
        this.f6994j3.play();
    }

    @Override // h3.xc
    public boolean br(m mVar) {
        return this.f6994j3.n3(mVar);
    }

    @Override // h3.xc
    public void cy(Exception exc) {
        v5.r.gv("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.f6999vn.f(exc);
    }

    @Override // h3.xc, m1.a
    public void d() {
        this.f6991br = true;
        this.f7000wm = null;
        try {
            this.f6994j3.flush();
            try {
                super.d();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.d();
                throw th;
            } finally {
            }
        }
    }

    @Override // h3.xc, m1.a
    public void ej(long j2, boolean z2) throws m1.p {
        super.ej(j2, z2);
        if (this.f6998uo) {
            this.f6994j3.mt();
        } else {
            this.f6994j3.flush();
        }
        this.gf = j2;
        this.f6992bv = true;
        this.fc = true;
    }

    @Override // m1.zq, m1.k3
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    public void gn() {
        this.fc = true;
    }

    @Override // h3.xc
    public void gq(m mVar, @Nullable MediaFormat mediaFormat) throws m1.p {
        int i;
        int i5;
        m mVar2 = this.f6995nd;
        int[] iArr = null;
        if (mVar2 != null) {
            mVar = mVar2;
        } else if (s8() != null) {
            if ("audio/raw".equals(mVar.f10948f3)) {
                i = mVar.f10960q9;
            } else if (j5.y >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i = j5.xg(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i = 2;
            }
            m z62 = new m.n3().o4("audio/raw").jz(i).hw(mVar.f10955k).j5(mVar.f10949f7).a8(mediaFormat.getInteger("channel-count")).rs(mediaFormat.getInteger("sample-rate")).z6();
            if (this.f6997q && z62.f10958oz == 6 && (i5 = mVar.f10958oz) < 6) {
                iArr = new int[i5];
                for (int i6 = 0; i6 < mVar.f10958oz; i6++) {
                    iArr[i6] = i6;
                }
            }
            mVar = z62;
        }
        try {
            this.f6994j3.x4(mVar, 0, iArr);
        } catch (x4.y e2) {
            throw f3(e2, e2.format, 5001);
        }
    }

    public int hk(h3.wz wzVar, m mVar, m[] mVarArr) {
        int zq = zq(wzVar, mVar);
        if (mVarArr.length == 1) {
            return zq;
        }
        for (m mVar2 : mVarArr) {
            if (wzVar.a(mVar, mVar2).f45gv != 0) {
                zq = Math.max(zq, zq(wzVar, mVar2));
            }
        }
        return zq;
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat ic(m mVar, String str, int i, float f4) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", mVar.f10958oz);
        mediaFormat.setInteger("sample-rate", mVar.f10966ut);
        v5.f3.v(mediaFormat, mVar.f10941c);
        v5.f3.gv(mediaFormat, "max-input-size", i);
        int i5 = j5.y;
        if (i5 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f4 != -1.0f && !jr()) {
                mediaFormat.setFloat("operating-rate", f4);
            }
        }
        if (i5 <= 28 && "audio/ac4".equals(mVar.f10948f3)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i5 >= 24 && this.f6994j3.wz(j5.dm(4, mVar.f10958oz, mVar.f10966ut)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i5 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    @Override // h3.xc, m1.zq
    public boolean isReady() {
        if (!this.f6994j3.i9() && !super.isReady()) {
            return false;
        }
        return true;
    }

    @Override // h3.xc
    public void ix() throws m1.p {
        try {
            this.f6994j3.co();
        } catch (x4.v e2) {
            throw n(e2, e2.format, e2.isRecoverable, 5002);
        }
    }

    @Override // h3.xc
    @Nullable
    public a9.c5 l(g gVar) throws m1.p {
        this.f7000wm = (m) v5.y.v(gVar.f10757n3);
        a9.c5 l2 = super.l(gVar);
        this.f6999vn.p(this.f7000wm, l2);
        return l2;
    }

    @Override // h3.xc
    public t.y m(h3.wz wzVar, m mVar, @Nullable MediaCrypto mediaCrypto, float f4) {
        m mVar2;
        this.f6996ne = hk(wzVar, mVar, mg());
        this.f6997q = r6(wzVar.y);
        MediaFormat ic = ic(mVar, wzVar.f8475zn, this.f6996ne, f4);
        if ("audio/raw".equals(wzVar.f8472n3) && !"audio/raw".equals(mVar.f10948f3)) {
            mVar2 = mVar;
        } else {
            mVar2 = null;
        }
        this.f6995nd = mVar2;
        return t.y.y(wzVar, ic, mVar, mediaCrypto);
    }

    @Override // h3.xc
    public boolean q5(long j2, long j4, @Nullable h3.t tVar, @Nullable ByteBuffer byteBuffer, int i, int i5, int i6, long j6, boolean z2, boolean z3, m mVar) throws m1.p {
        v5.y.v(byteBuffer);
        if (this.f6995nd != null && (i5 & 2) != 0) {
            ((h3.t) v5.y.v(tVar)).tl(i, false);
            return true;
        } else if (z2) {
            if (tVar != null) {
                tVar.tl(i, false);
            }
            this.f8488cs.f76a += i6;
            this.f6994j3.f3();
            return true;
        } else {
            try {
                if (!this.f6994j3.w(byteBuffer, j6, i6)) {
                    return false;
                }
                if (tVar != null) {
                    tVar.tl(i, false);
                }
                this.f8488cs.f85v += i6;
                return true;
            } catch (x4.n3 e2) {
                throw n(e2, this.f7000wm, e2.isRecoverable, 5001);
            } catch (x4.v e3) {
                throw n(e3, mVar, e3.isRecoverable, 5002);
            }
        }
    }

    @Override // h3.xc
    public void qj(String str) {
        this.f6999vn.wz(str);
    }

    @Override // h3.xc
    public void qk(String str, t.y yVar, long j2, long j4) {
        this.f6999vn.tl(str, j2, j4);
    }

    @Override // h3.xc
    public a9.c5 qn(h3.wz wzVar, m mVar, m mVar2) {
        int i;
        a9.c5 a2 = wzVar.a(mVar, mVar2);
        int i5 = a2.f47v;
        if (zq(wzVar, mVar2) > this.f6996ne) {
            i5 |= 64;
        }
        int i6 = i5;
        String str = wzVar.y;
        if (i6 != 0) {
            i = 0;
        } else {
            i = a2.f45gv;
        }
        return new a9.c5(str, mVar, mVar2, i, i6);
    }

    @Override // h3.xc
    public List<h3.wz> rb(h3.p pVar, m mVar, boolean z2) throws x4.zn {
        return h3.x4.r(k3(pVar, mVar, z2, this.f6994j3), mVar);
    }

    @Override // m1.a, m1.c8.n3
    public void tl(int i, @Nullable Object obj) throws m1.p {
        if (i != 2) {
            if (i != 3) {
                if (i != 6) {
                    switch (i) {
                        case 9:
                            this.f6994j3.s(((Boolean) obj).booleanValue());
                            return;
                        case 10:
                            this.f6994j3.f(((Integer) obj).intValue());
                            return;
                        case 11:
                            this.im = (zq.y) obj;
                            return;
                        case 12:
                            if (j5.y >= 23) {
                                n3.y(this.f6994j3, obj);
                                return;
                            }
                            return;
                        default:
                            super.tl(i, obj);
                            return;
                    }
                }
                this.f6994j3.z((n) obj);
                return;
            }
            this.f6994j3.p((v) obj);
            return;
        }
        this.f6994j3.setVolume(((Float) obj).floatValue());
    }

    @Override // h3.xc, m1.a
    public void ud() {
        try {
            super.ud();
        } finally {
            if (this.f6991br) {
                this.f6991br = false;
                this.f6994j3.y();
            }
        }
    }

    @Override // h3.xc
    public int uo(h3.p pVar, m mVar) throws x4.zn {
        int i;
        boolean z2;
        boolean z3;
        int i5;
        int i6 = 0;
        if (!v5.n.xc(mVar.f10948f3)) {
            return hk.y(0);
        }
        if (j5.y >= 21) {
            i = 32;
        } else {
            i = 0;
        }
        boolean z4 = true;
        if (mVar.f10971y5 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean im = h3.xc.im(mVar);
        int i8 = 8;
        int i10 = 4;
        if (im && this.f6994j3.n3(mVar) && (!z2 || h3.x4.x4() != null)) {
            return hk.n3(4, 8, i);
        }
        if ("audio/raw".equals(mVar.f10948f3) && !this.f6994j3.n3(mVar)) {
            return hk.y(1);
        }
        if (!this.f6994j3.n3(j5.dm(2, mVar.f10958oz, mVar.f10966ut))) {
            return hk.y(1);
        }
        List<h3.wz> k3 = k3(pVar, mVar, false, this.f6994j3);
        if (k3.isEmpty()) {
            return hk.y(1);
        }
        if (!im) {
            return hk.y(2);
        }
        h3.wz wzVar = k3.get(0);
        boolean p2 = wzVar.p(mVar);
        if (!p2) {
            for (int i11 = 1; i11 < k3.size(); i11++) {
                h3.wz wzVar2 = k3.get(i11);
                if (wzVar2.p(mVar)) {
                    wzVar = wzVar2;
                    z3 = false;
                    break;
                }
            }
        }
        z4 = p2;
        z3 = true;
        if (!z4) {
            i10 = 3;
        }
        if (z4 && wzVar.z(mVar)) {
            i8 = 16;
        }
        if (wzVar.f8473s) {
            i5 = 64;
        } else {
            i5 = 0;
        }
        if (z3) {
            i6 = NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        return hk.zn(i10, i8, i, i5, i6);
    }

    @Override // v5.i4
    public br v() {
        return this.f6994j3.v();
    }

    public final void vc() {
        long r2 = this.f6994j3.r(a());
        if (r2 != Long.MIN_VALUE) {
            if (!this.fc) {
                r2 = Math.max(this.gf, r2);
            }
            this.gf = r2;
            this.fc = false;
        }
    }

    @Override // h3.xc
    public void vp(long j2) {
        this.f6994j3.i4(j2);
    }

    @Override // v5.i4
    public long w() {
        if (getState() == 2) {
            vc();
        }
        return this.gf;
    }

    @Override // h3.xc
    public void w2(a9.fb fbVar) {
        if (this.f6992bv && !fbVar.f()) {
            if (Math.abs(fbVar.f55f - this.gf) > 500000) {
                this.gf = fbVar.f55f;
            }
            this.f6992bv = false;
        }
    }

    @Override // h3.xc
    public void w9() {
        super.w9();
        this.f6994j3.f3();
    }

    @Override // h3.xc, m1.a
    public void x() {
        vc();
        this.f6994j3.pause();
        super.x();
    }

    @Override // h3.xc
    public float yc(float f4, m mVar, m[] mVarArr) {
        int i = -1;
        for (m mVar2 : mVarArr) {
            int i5 = mVar2.f10966ut;
            if (i5 != -1) {
                i = Math.max(i, i5);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f4 * i;
    }

    @Override // h3.xc, m1.a
    public void z6(boolean z2, boolean z3) throws m1.p {
        super.z6(z2, z3);
        this.f6999vn.w(this.f8488cs);
        if (c().y) {
            this.f6994j3.c();
        } else {
            this.f6994j3.tl();
        }
        this.f6994j3.xc(rz());
    }

    @Override // v5.i4
    public void zn(br brVar) {
        this.f6994j3.zn(brVar);
    }

    @Override // m1.a, m1.zq
    @Nullable
    public v5.i4 i4() {
        return this;
    }
}
