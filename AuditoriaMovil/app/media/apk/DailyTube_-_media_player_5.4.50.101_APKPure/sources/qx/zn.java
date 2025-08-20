package qx;

import android.net.Uri;
import e4.d0;
import e4.fh;
import e4.mt;
import e4.p;
import e4.t;
import e4.tl;
import e4.wz;
import java.io.IOException;
import java.util.Map;
import v5.rz;
/* loaded from: classes.dex */
public final class zn implements t {

    /* renamed from: p  reason: collision with root package name */
    public static final mt f13004p = new mt() { // from class: qx.n3
        @Override // e4.mt
        public final t[] createExtractors() {
            t[] s2;
            s2 = zn.s();
            return s2;
        }

        @Override // e4.mt
        public /* synthetic */ t[] y(Uri uri, Map map) {
            return p.y(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public wz f13005a;

    /* renamed from: c5  reason: collision with root package name */
    public long f13006c5;

    /* renamed from: f  reason: collision with root package name */
    public int f13007f;

    /* renamed from: i9  reason: collision with root package name */
    public int f13010i9;

    /* renamed from: s  reason: collision with root package name */
    public boolean f13012s;

    /* renamed from: t  reason: collision with root package name */
    public int f13013t;

    /* renamed from: tl  reason: collision with root package name */
    public long f13014tl;

    /* renamed from: w  reason: collision with root package name */
    public a f13016w;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f13017wz;

    /* renamed from: xc  reason: collision with root package name */
    public y f13018xc;
    public final rz y = new rz(4);

    /* renamed from: n3  reason: collision with root package name */
    public final rz f13011n3 = new rz(9);

    /* renamed from: zn  reason: collision with root package name */
    public final rz f13019zn = new rz(11);

    /* renamed from: gv  reason: collision with root package name */
    public final rz f13009gv = new rz();

    /* renamed from: v  reason: collision with root package name */
    public final gv f13015v = new gv();

    /* renamed from: fb  reason: collision with root package name */
    public int f13008fb = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t[] s() {
        return new t[]{new zn()};
    }

    @Override // e4.t
    public boolean a(tl tlVar) throws IOException {
        tlVar.z(this.y.v(), 0, 3);
        this.y.oz(0);
        if (this.y.x() != 4607062) {
            return false;
        }
        tlVar.z(this.y.v(), 0, 2);
        this.y.oz(0);
        if ((this.y.yt() & 250) != 0) {
            return false;
        }
        tlVar.z(this.y.v(), 0, 4);
        this.y.oz(0);
        int p2 = this.y.p();
        tlVar.s();
        tlVar.wz(p2);
        tlVar.z(this.y.v(), 0, 4);
        this.y.oz(0);
        if (this.y.p() != 0) {
            return false;
        }
        return true;
    }

    public final rz c5(tl tlVar) throws IOException {
        if (this.f13013t > this.f13009gv.n3()) {
            rz rzVar = this.f13009gv;
            rzVar.o(new byte[Math.max(rzVar.n3() * 2, this.f13013t)], 0);
        } else {
            this.f13009gv.oz(0);
        }
        this.f13009gv.j(this.f13013t);
        tlVar.readFully(this.f13009gv.v(), 0, this.f13013t);
        return this.f13009gv;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(e4.tl r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.fb()
            int r2 = r9.f13007f
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            qx.y r3 = r9.f13018xc
            if (r3 == 0) goto L23
            r9.gv()
            qx.y r2 = r9.f13018xc
            v5.rz r10 = r9.c5(r10)
            boolean r10 = r2.y(r10, r0)
        L21:
            r0 = 1
            goto L75
        L23:
            r3 = 9
            if (r2 != r3) goto L39
            qx.a r3 = r9.f13016w
            if (r3 == 0) goto L39
            r9.gv()
            qx.a r2 = r9.f13016w
            v5.rz r10 = r9.c5(r10)
            boolean r10 = r2.y(r10, r0)
            goto L21
        L39:
            r3 = 18
            if (r2 != r3) goto L6e
            boolean r2 = r9.f13017wz
            if (r2 != 0) goto L6e
            qx.gv r2 = r9.f13015v
            v5.rz r10 = r9.c5(r10)
            boolean r10 = r2.y(r10, r0)
            qx.gv r0 = r9.f13015v
            long r0 = r0.gv()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            e4.wz r2 = r9.f13005a
            e4.c r3 = new e4.c
            qx.gv r7 = r9.f13015v
            long[] r7 = r7.v()
            qx.gv r8 = r9.f13015v
            long[] r8 = r8.a()
            r3.<init>(r7, r8, r0)
            r2.t(r3)
            r9.f13017wz = r6
            goto L21
        L6e:
            int r0 = r9.f13013t
            r10.p(r0)
            r10 = 0
            r0 = 0
        L75:
            boolean r1 = r9.f13012s
            if (r1 != 0) goto L8f
            if (r10 == 0) goto L8f
            r9.f13012s = r6
            qx.gv r10 = r9.f13015v
            long r1 = r10.gv()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L8b
            long r1 = r9.f13014tl
            long r1 = -r1
            goto L8d
        L8b:
            r1 = 0
        L8d:
            r9.f13006c5 = r1
        L8f:
            r10 = 4
            r9.f13010i9 = r10
            r10 = 2
            r9.f13008fb = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: qx.zn.f(e4.tl):boolean");
    }

    public final long fb() {
        if (this.f13012s) {
            return this.f13006c5 + this.f13014tl;
        }
        if (this.f13015v.gv() == -9223372036854775807L) {
            return 0L;
        }
        return this.f13014tl;
    }

    public final void gv() {
        if (!this.f13017wz) {
            this.f13005a.t(new fh.n3(-9223372036854775807L));
            this.f13017wz = true;
        }
    }

    public final boolean i9(tl tlVar) throws IOException {
        boolean z2;
        boolean z3 = false;
        if (!tlVar.f(this.f13011n3.v(), 0, 9, true)) {
            return false;
        }
        this.f13011n3.oz(0);
        this.f13011n3.ut(4);
        int ej2 = this.f13011n3.ej();
        if ((ej2 & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((ej2 & 1) != 0) {
            z3 = true;
        }
        if (z2 && this.f13018xc == null) {
            this.f13018xc = new y(this.f13005a.a(8, 1));
        }
        if (z3 && this.f13016w == null) {
            this.f13016w = new a(this.f13005a.a(9, 2));
        }
        this.f13005a.xc();
        this.f13010i9 = this.f13011n3.p() - 5;
        this.f13008fb = 2;
        return true;
    }

    public final boolean t(tl tlVar) throws IOException {
        if (!tlVar.f(this.f13019zn.v(), 0, 11, true)) {
            return false;
        }
        this.f13019zn.oz(0);
        this.f13007f = this.f13019zn.ej();
        this.f13013t = this.f13019zn.x();
        this.f13014tl = this.f13019zn.x();
        this.f13014tl = ((this.f13019zn.ej() << 24) | this.f13014tl) * 1000;
        this.f13019zn.ut(3);
        this.f13008fb = 4;
        return true;
    }

    public final void tl(tl tlVar) throws IOException {
        tlVar.p(this.f13010i9);
        this.f13010i9 = 0;
        this.f13008fb = 3;
    }

    @Override // e4.t
    public int v(tl tlVar, d0 d0Var) throws IOException {
        v5.y.c5(this.f13005a);
        while (true) {
            int i = this.f13008fb;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (f(tlVar)) {
                                return 0;
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (!t(tlVar)) {
                        return -1;
                    }
                } else {
                    tl(tlVar);
                }
            } else if (!i9(tlVar)) {
                return -1;
            }
        }
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        if (j2 == 0) {
            this.f13008fb = 1;
            this.f13012s = false;
        } else {
            this.f13008fb = 3;
        }
        this.f13010i9 = 0;
    }

    @Override // e4.t
    public void zn(wz wzVar) {
        this.f13005a = wzVar;
    }

    @Override // e4.t
    public void release() {
    }
}
