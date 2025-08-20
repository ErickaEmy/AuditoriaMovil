package h4;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import fj.u0;
import h4.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kx.p;
import lw.fb;
import m1.m;
import v5.k5;
import v5.rz;
import v5.vl;
import z0.x4;
/* loaded from: classes.dex */
public final class i9 extends p7.wz {

    /* renamed from: k5  reason: collision with root package name */
    public static final AtomicInteger f8587k5 = new AtomicInteger();

    /* renamed from: a8  reason: collision with root package name */
    public x4<Integer> f8588a8;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8589b;

    /* renamed from: c  reason: collision with root package name */
    public final rz f8590c;

    /* renamed from: co  reason: collision with root package name */
    public final boolean f8591co;

    /* renamed from: d  reason: collision with root package name */
    public int f8592d;

    /* renamed from: d0  reason: collision with root package name */
    public final boolean f8593d0;

    /* renamed from: ej  reason: collision with root package name */
    public volatile boolean f8594ej;

    /* renamed from: f  reason: collision with root package name */
    public final int f8595f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public final DrmInitData f8596f3;

    /* renamed from: fh  reason: collision with root package name */
    public final boolean f8597fh;
    @Nullable

    /* renamed from: i4  reason: collision with root package name */
    public final List<m> f8598i4;

    /* renamed from: mg  reason: collision with root package name */
    public f f8599mg;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public final f f8600mt;

    /* renamed from: n  reason: collision with root package name */
    public final ho.n3 f8601n;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public final kx.p f8602p;

    /* renamed from: r  reason: collision with root package name */
    public final k5 f8603r;

    /* renamed from: rz  reason: collision with root package name */
    public final u0 f8604rz;

    /* renamed from: t  reason: collision with root package name */
    public final int f8605t;

    /* renamed from: ta  reason: collision with root package name */
    public p f8606ta;

    /* renamed from: tl  reason: collision with root package name */
    public final Uri f8607tl;

    /* renamed from: ud  reason: collision with root package name */
    public boolean f8608ud;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public final kx.tl f8609w;

    /* renamed from: wz  reason: collision with root package name */
    public final boolean f8610wz;

    /* renamed from: x  reason: collision with root package name */
    public boolean f8611x;

    /* renamed from: x4  reason: collision with root package name */
    public final s f8612x4;

    /* renamed from: xc  reason: collision with root package name */
    public final int f8613xc;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f8614z;

    /* renamed from: z6  reason: collision with root package name */
    public boolean f8615z6;

    public i9(s sVar, kx.tl tlVar, kx.p pVar, m mVar, boolean z2, @Nullable kx.tl tlVar2, @Nullable kx.p pVar2, boolean z3, Uri uri, @Nullable List<m> list, int i, @Nullable Object obj, long j2, long j4, long j6, int i5, boolean z4, int i6, boolean z5, boolean z7, k5 k5Var, @Nullable DrmInitData drmInitData, @Nullable f fVar, ho.n3 n3Var, rz rzVar, boolean z8, u0 u0Var) {
        super(tlVar, pVar, mVar, i, obj, j2, j4, j6);
        this.f8593d0 = z2;
        this.f8613xc = i5;
        this.f8589b = z4;
        this.f8605t = i6;
        this.f8602p = pVar2;
        this.f8609w = tlVar2;
        this.f8615z6 = pVar2 != null;
        this.f8597fh = z3;
        this.f8607tl = uri;
        this.f8591co = z7;
        this.f8603r = k5Var;
        this.f8614z = z5;
        this.f8612x4 = sVar;
        this.f8598i4 = list;
        this.f8596f3 = drmInitData;
        this.f8600mt = fVar;
        this.f8601n = n3Var;
        this.f8590c = rzVar;
        this.f8610wz = z8;
        this.f8604rz = u0Var;
        this.f8588a8 = x4.j5();
        this.f8595f = f8587k5.getAndIncrement();
    }

    public static i9 c5(s sVar, kx.tl tlVar, m mVar, long j2, lw.fb fbVar, a.v vVar, Uri uri, @Nullable List<m> list, int i, @Nullable Object obj, boolean z2, co coVar, @Nullable i9 i9Var, @Nullable byte[] bArr, @Nullable byte[] bArr2, boolean z3, u0 u0Var) {
        boolean z4;
        kx.tl tlVar2;
        kx.p pVar;
        boolean z5;
        ho.n3 n3Var;
        rz rzVar;
        f fVar;
        fb.v vVar2 = vVar.y;
        kx.p y = new p.n3().c5(vl.v(fbVar.y, vVar2.y)).s(vVar2.f10416co).fb(vVar2.f10425z).n3(vVar.f8575gv ? 8 : 0).y();
        boolean z7 = bArr != null;
        kx.tl s2 = s(tlVar, bArr, z7 ? f((String) v5.y.v(vVar2.f10419p)) : null);
        fb.gv gvVar = vVar2.f10423v;
        if (gvVar != null) {
            boolean z8 = bArr2 != null;
            byte[] f4 = z8 ? f((String) v5.y.v(gvVar.f10419p)) : null;
            z4 = z7;
            pVar = new kx.p(vl.v(fbVar.y, gvVar.y), gvVar.f10416co, gvVar.f10425z);
            tlVar2 = s(tlVar, bArr2, f4);
            z5 = z8;
        } else {
            z4 = z7;
            tlVar2 = null;
            pVar = null;
            z5 = false;
        }
        long j4 = j2 + vVar2.f10417f;
        long j6 = j4 + vVar2.f10418fb;
        int i5 = fbVar.f10395i9 + vVar2.f10421s;
        if (i9Var != null) {
            kx.p pVar2 = i9Var.f8602p;
            boolean z9 = pVar == pVar2 || (pVar != null && pVar2 != null && pVar.y.equals(pVar2.y) && pVar.f10071fb == i9Var.f8602p.f10071fb);
            boolean z10 = uri.equals(i9Var.f8607tl) && i9Var.f8608ud;
            ho.n3 n3Var2 = i9Var.f8601n;
            n3Var = n3Var2;
            rzVar = i9Var.f8590c;
            fVar = (z9 && z10 && !i9Var.f8611x && i9Var.f8605t == i5) ? i9Var.f8599mg : null;
        } else {
            n3Var = new ho.n3();
            rzVar = new rz(10);
            fVar = null;
        }
        return new i9(sVar, s2, y, mVar, z4, tlVar2, pVar, z5, uri, list, i, obj, j4, j6, vVar.f8576n3, vVar.f8577zn, !vVar.f8575gv, i5, vVar2.f10420r, z2, coVar.y(i5), vVar2.f10422t, fVar, n3Var, rzVar, z3, u0Var);
    }

    public static byte[] f(String str) {
        int i;
        if (w0.zn.v(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        if (byteArray.length > 16) {
            i = byteArray.length - 16;
        } else {
            i = 0;
        }
        System.arraycopy(byteArray, i, bArr, (16 - byteArray.length) + i, byteArray.length - i);
        return bArr;
    }

    public static kx.tl s(kx.tl tlVar, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr != null) {
            v5.y.v(bArr2);
            return new y(tlVar, bArr, bArr2);
        }
        return tlVar;
    }

    public static boolean x4(@Nullable i9 i9Var, Uri uri, lw.fb fbVar, a.v vVar, long j2) {
        if (i9Var == null) {
            return false;
        }
        if (uri.equals(i9Var.f8607tl) && i9Var.f8608ud) {
            return false;
        }
        long j4 = j2 + vVar.y.f10417f;
        if (xc(vVar, fbVar) && j4 >= i9Var.f12446s) {
            return false;
        }
        return true;
    }

    public static boolean xc(a.v vVar, lw.fb fbVar) {
        fb.v vVar2 = vVar.y;
        if (vVar2 instanceof fb.n3) {
            if (!((fb.n3) vVar2).f10414f3 && (vVar.f8577zn != 0 || !fbVar.f10388zn)) {
                return false;
            }
            return true;
        }
        return fbVar.f10388zn;
    }

    public final long co(e4.tl tlVar) throws IOException {
        tlVar.s();
        try {
            this.f8590c.j5(10);
            tlVar.z(this.f8590c.v(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.f8590c.x() != 4801587) {
            return -9223372036854775807L;
        }
        this.f8590c.ut(3);
        int z62 = this.f8590c.z6();
        int i = z62 + 10;
        if (i > this.f8590c.n3()) {
            byte[] v2 = this.f8590c.v();
            this.f8590c.j5(i);
            System.arraycopy(v2, 0, this.f8590c.v(), 0, 10);
        }
        tlVar.z(this.f8590c.v(), 10, z62);
        Metadata v3 = this.f8601n.v(this.f8590c.v(), z62);
        if (v3 == null) {
            return -9223372036854775807L;
        }
        int v4 = v3.v();
        for (int i5 = 0; i5 < v4; i5++) {
            Metadata.Entry gv2 = v3.gv(i5);
            if (gv2 instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) gv2;
                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f4274v)) {
                    System.arraycopy(privFrame.f4273fb, 0, this.f8590c.v(), 0, 8);
                    this.f8590c.oz(0);
                    this.f8590c.j(8);
                    return this.f8590c.d0() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // p7.wz
    public boolean fb() {
        return this.f8608ud;
    }

    public final void i9(kx.tl tlVar, kx.p pVar, boolean z2, boolean z3) throws IOException {
        kx.p v2;
        long position;
        long j2;
        boolean z4 = false;
        if (z2) {
            if (this.f8592d != 0) {
                z4 = true;
            }
            v2 = pVar;
        } else {
            v2 = pVar.v(this.f8592d);
        }
        try {
            e4.a z5 = z(tlVar, v2, z3);
            if (z4) {
                z5.p(this.f8592d);
            }
            do {
                try {
                    if (this.f8594ej) {
                        break;
                    }
                } catch (EOFException e2) {
                    if ((this.f12444gv.f10947f & 16384) != 0) {
                        this.f8599mg.gv();
                        position = z5.getPosition();
                        j2 = pVar.f10071fb;
                    } else {
                        throw e2;
                    }
                }
            } while (this.f8599mg.n3(z5));
            position = z5.getPosition();
            j2 = pVar.f10071fb;
            this.f8592d = (int) (position - j2);
        } finally {
            kx.w.y(tlVar);
        }
    }

    @Override // kx.ta.v
    public void load() throws IOException {
        f fVar;
        v5.y.v(this.f8606ta);
        if (this.f8599mg == null && (fVar = this.f8600mt) != null && fVar.v()) {
            this.f8599mg = this.f8600mt;
            this.f8615z6 = false;
        }
        mt();
        if (!this.f8594ej) {
            if (!this.f8614z) {
                p();
            }
            this.f8608ud = !this.f8594ej;
        }
    }

    public final void mt() throws IOException {
        if (!this.f8615z6) {
            return;
        }
        v5.y.v(this.f8609w);
        v5.y.v(this.f8602p);
        i9(this.f8609w, this.f8602p, this.f8597fh, false);
        this.f8592d = 0;
        this.f8615z6 = false;
    }

    @Override // kx.ta.v
    public void n3() {
        this.f8594ej = true;
    }

    public final void p() throws IOException {
        i9(this.f12442c5, this.f12445n3, this.f8593d0, true);
    }

    public void r() {
        this.f8589b = true;
    }

    public int t(int i) {
        v5.y.fb(!this.f8610wz);
        if (i >= this.f8588a8.size()) {
            return 0;
        }
        return this.f8588a8.get(i).intValue();
    }

    public void tl(p pVar, x4<Integer> x4Var) {
        this.f8606ta = pVar;
        this.f8588a8 = x4Var;
    }

    public boolean w() {
        return this.f8589b;
    }

    public void wz() {
        this.f8611x = true;
    }

    public final e4.a z(kx.tl tlVar, kx.p pVar, boolean z2) throws IOException {
        f y;
        long j2;
        long y2 = tlVar.y(pVar);
        if (z2) {
            try {
                this.f8603r.s(this.f8591co, this.f12443fb);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        e4.a aVar = new e4.a(tlVar, pVar.f10071fb, y2);
        if (this.f8599mg == null) {
            long co2 = co(aVar);
            aVar.s();
            f fVar = this.f8600mt;
            if (fVar != null) {
                y = fVar.fb();
            } else {
                y = this.f8612x4.y(pVar.y, this.f12444gv, this.f8598i4, this.f8603r, tlVar.fb(), aVar, this.f8604rz);
            }
            this.f8599mg = y;
            if (y.a()) {
                p pVar2 = this.f8606ta;
                if (co2 != -9223372036854775807L) {
                    j2 = this.f8603r.n3(co2);
                } else {
                    j2 = this.f12443fb;
                }
                pVar2.s8(j2);
            } else {
                this.f8606ta.s8(0L);
            }
            this.f8606ta.en();
            this.f8599mg.zn(this.f8606ta);
        }
        this.f8606ta.nf(this.f8596f3);
        return aVar;
    }
}
