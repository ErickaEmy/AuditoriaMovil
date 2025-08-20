package ek;

import androidx.annotation.Nullable;
import e4.d0;
import e4.fh;
import e4.i9;
import e4.t;
import e4.ta;
import e4.tl;
import e4.wz;
import java.io.IOException;
import java.util.ArrayList;
import m1.m;
import m1.ne;
import v5.n;
import v5.r;
import v5.rz;
import z0.en;
/* loaded from: classes.dex */
public final class n3 implements t {
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public v f7628c5;

    /* renamed from: s  reason: collision with root package name */
    public long f7634s;

    /* renamed from: tl  reason: collision with root package name */
    public int f7636tl;

    /* renamed from: v  reason: collision with root package name */
    public ek.zn f7637v;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f7638wz;

    /* renamed from: zn  reason: collision with root package name */
    public int f7639zn;
    public final rz y = new rz(12);

    /* renamed from: n3  reason: collision with root package name */
    public final zn f7633n3 = new zn();

    /* renamed from: gv  reason: collision with root package name */
    public wz f7631gv = new i9();

    /* renamed from: fb  reason: collision with root package name */
    public v[] f7630fb = new v[0];

    /* renamed from: f  reason: collision with root package name */
    public long f7629f = -1;

    /* renamed from: t  reason: collision with root package name */
    public long f7635t = -1;

    /* renamed from: i9  reason: collision with root package name */
    public int f7632i9 = -1;

    /* renamed from: a  reason: collision with root package name */
    public long f7627a = -9223372036854775807L;

    /* renamed from: ek.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0092n3 implements fh {
        public final long y;

        public C0092n3(long j2) {
            this.y = j2;
        }

        @Override // e4.fh
        public long c5() {
            return this.y;
        }

        @Override // e4.fh
        public fh.y gv(long j2) {
            fh.y c52 = n3.this.f7630fb[0].c5(j2);
            for (int i = 1; i < n3.this.f7630fb.length; i++) {
                fh.y c53 = n3.this.f7630fb[i].c5(j2);
                if (c53.y.f7512n3 < c52.y.f7512n3) {
                    c52 = c53;
                }
            }
            return c52;
        }

        @Override // e4.fh
        public boolean s() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: n3  reason: collision with root package name */
        public int f7641n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f7642zn;

        public zn() {
        }

        public void n3(rz rzVar) throws ne {
            y(rzVar);
            if (this.y == 1414744396) {
                this.f7642zn = rzVar.r();
                return;
            }
            throw ne.y("LIST expected, found: " + this.y, null);
        }

        public void y(rz rzVar) {
            this.y = rzVar.r();
            this.f7641n3 = rzVar.r();
            this.f7642zn = 0;
        }
    }

    public static void gv(tl tlVar) throws IOException {
        if ((tlVar.getPosition() & 1) == 1) {
            tlVar.p(1);
        }
    }

    @Override // e4.t
    public boolean a(tl tlVar) throws IOException {
        tlVar.z(this.y.v(), 0, 12);
        this.y.oz(0);
        if (this.y.r() != 1179011410) {
            return false;
        }
        this.y.ut(4);
        if (this.y.r() != 541677121) {
            return false;
        }
        return true;
    }

    public final void c5(rz rzVar) {
        long i92 = i9(rzVar);
        while (rzVar.y() >= 16) {
            int r2 = rzVar.r();
            int r3 = rzVar.r();
            long r5 = rzVar.r() + i92;
            rzVar.r();
            v fb2 = fb(r2);
            if (fb2 != null) {
                if ((r3 & 16) == 16) {
                    fb2.n3(r5);
                }
                fb2.f();
            }
        }
        for (v vVar : this.f7630fb) {
            vVar.zn();
        }
        this.f7638wz = true;
        this.f7631gv.t(new C0092n3(this.f7627a));
    }

    @Nullable
    public final v f(a aVar, int i) {
        gv gvVar = (gv) aVar.n3(gv.class);
        fb fbVar = (fb) aVar.n3(fb.class);
        if (gvVar == null) {
            r.c5("AviExtractor", "Missing Stream Header");
            return null;
        } else if (fbVar == null) {
            r.c5("AviExtractor", "Missing Stream Format");
            return null;
        } else {
            long y2 = gvVar.y();
            m mVar = fbVar.y;
            m.n3 n32 = mVar.n3();
            n32.j(i);
            int i5 = gvVar.f7622a;
            if (i5 != 0) {
                n32.f7(i5);
            }
            s sVar = (s) aVar.n3(s.class);
            if (sVar != null) {
                n32.q9(sVar.y);
            }
            int f4 = n.f(mVar.f10948f3);
            if (f4 != 1 && f4 != 2) {
                return null;
            }
            ta a2 = this.f7631gv.a(i, f4);
            a2.v(n32.z6());
            v vVar = new v(i, f4, y2, gvVar.f7625v, a2);
            this.f7627a = y2;
            return vVar;
        }
    }

    @Nullable
    public final v fb(int i) {
        v[] vVarArr;
        for (v vVar : this.f7630fb) {
            if (vVar.i9(i)) {
                return vVar;
            }
        }
        return null;
    }

    public final long i9(rz rzVar) {
        long j2 = 0;
        if (rzVar.y() < 16) {
            return 0L;
        }
        int a2 = rzVar.a();
        rzVar.ut(8);
        long j4 = this.f7629f;
        if (rzVar.r() <= j4) {
            j2 = j4 + 8;
        }
        rzVar.oz(a2);
        return j2;
    }

    public final void s(rz rzVar) throws IOException {
        a zn2 = a.zn(1819436136, rzVar);
        if (zn2.getType() == 1819436136) {
            ek.zn znVar = (ek.zn) zn2.n3(ek.zn.class);
            if (znVar != null) {
                this.f7637v = znVar;
                this.f7627a = znVar.f7656zn * znVar.y;
                ArrayList arrayList = new ArrayList();
                en<ek.y> it = zn2.y.iterator();
                int i = 0;
                while (it.hasNext()) {
                    ek.y next = it.next();
                    if (next.getType() == 1819440243) {
                        int i5 = i + 1;
                        v f4 = f((a) next, i);
                        if (f4 != null) {
                            arrayList.add(f4);
                        }
                        i = i5;
                    }
                }
                this.f7630fb = (v[]) arrayList.toArray(new v[0]);
                this.f7631gv.xc();
                return;
            }
            throw ne.y("AviHeader not found", null);
        }
        throw ne.y("Unexpected header list type " + zn2.getType(), null);
    }

    public final int t(tl tlVar) throws IOException {
        if (tlVar.getPosition() >= this.f7635t) {
            return -1;
        }
        v vVar = this.f7628c5;
        if (vVar != null) {
            if (vVar.tl(tlVar)) {
                this.f7628c5 = null;
            }
        } else {
            gv(tlVar);
            int i = 12;
            tlVar.z(this.y.v(), 0, 12);
            this.y.oz(0);
            int r2 = this.y.r();
            if (r2 == 1414744396) {
                this.y.oz(8);
                if (this.y.r() != 1769369453) {
                    i = 8;
                }
                tlVar.p(i);
                tlVar.s();
                return 0;
            }
            int r3 = this.y.r();
            if (r2 == 1263424842) {
                this.f7634s = tlVar.getPosition() + r3 + 8;
                return 0;
            }
            tlVar.p(8);
            tlVar.s();
            v fb2 = fb(r2);
            if (fb2 == null) {
                this.f7634s = tlVar.getPosition() + r3;
                return 0;
            }
            fb2.wz(r3);
            this.f7628c5 = fb2;
        }
        return 0;
    }

    public final boolean tl(tl tlVar, d0 d0Var) throws IOException {
        boolean z2;
        if (this.f7634s != -1) {
            long position = tlVar.getPosition();
            long j2 = this.f7634s;
            if (j2 >= position && j2 <= 262144 + position) {
                tlVar.p((int) (j2 - position));
            } else {
                d0Var.y = j2;
                z2 = true;
                this.f7634s = -1L;
                return z2;
            }
        }
        z2 = false;
        this.f7634s = -1L;
        return z2;
    }

    @Override // e4.t
    public int v(tl tlVar, d0 d0Var) throws IOException {
        if (tl(tlVar, d0Var)) {
            return 1;
        }
        switch (this.f7639zn) {
            case 0:
                if (a(tlVar)) {
                    tlVar.p(12);
                    this.f7639zn = 1;
                    return 0;
                }
                throw ne.y("AVI Header List not found", null);
            case 1:
                tlVar.readFully(this.y.v(), 0, 12);
                this.y.oz(0);
                this.f7633n3.n3(this.y);
                zn znVar = this.f7633n3;
                if (znVar.f7642zn == 1819436136) {
                    this.f7632i9 = znVar.f7641n3;
                    this.f7639zn = 2;
                    return 0;
                }
                throw ne.y("hdrl expected, found: " + this.f7633n3.f7642zn, null);
            case 2:
                int i = this.f7632i9 - 4;
                rz rzVar = new rz(i);
                tlVar.readFully(rzVar.v(), 0, i);
                s(rzVar);
                this.f7639zn = 3;
                return 0;
            case 3:
                if (this.f7629f != -1) {
                    long position = tlVar.getPosition();
                    long j2 = this.f7629f;
                    if (position != j2) {
                        this.f7634s = j2;
                        return 0;
                    }
                }
                tlVar.z(this.y.v(), 0, 12);
                tlVar.s();
                this.y.oz(0);
                this.f7633n3.y(this.y);
                int r2 = this.y.r();
                int i5 = this.f7633n3.y;
                if (i5 == 1179011410) {
                    tlVar.p(12);
                    return 0;
                } else if (i5 == 1414744396 && r2 == 1769369453) {
                    long position2 = tlVar.getPosition();
                    this.f7629f = position2;
                    this.f7635t = position2 + this.f7633n3.f7641n3 + 8;
                    if (!this.f7638wz) {
                        if (((ek.zn) v5.y.v(this.f7637v)).y()) {
                            this.f7639zn = 4;
                            this.f7634s = this.f7635t;
                            return 0;
                        }
                        this.f7631gv.t(new fh.n3(this.f7627a));
                        this.f7638wz = true;
                    }
                    this.f7634s = tlVar.getPosition() + 12;
                    this.f7639zn = 6;
                    return 0;
                } else {
                    this.f7634s = tlVar.getPosition() + this.f7633n3.f7641n3 + 8;
                    return 0;
                }
            case 4:
                tlVar.readFully(this.y.v(), 0, 8);
                this.y.oz(0);
                int r3 = this.y.r();
                int r5 = this.y.r();
                if (r3 == 829973609) {
                    this.f7639zn = 5;
                    this.f7636tl = r5;
                } else {
                    this.f7634s = tlVar.getPosition() + r5;
                }
                return 0;
            case 5:
                rz rzVar2 = new rz(this.f7636tl);
                tlVar.readFully(rzVar2.v(), 0, this.f7636tl);
                c5(rzVar2);
                this.f7639zn = 6;
                this.f7634s = this.f7629f;
                return 0;
            case 6:
                return t(tlVar);
            default:
                throw new AssertionError();
        }
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        this.f7634s = -1L;
        this.f7628c5 = null;
        for (v vVar : this.f7630fb) {
            vVar.xc(j2);
        }
        if (j2 == 0) {
            if (this.f7630fb.length == 0) {
                this.f7639zn = 0;
                return;
            } else {
                this.f7639zn = 3;
                return;
            }
        }
        this.f7639zn = 6;
    }

    @Override // e4.t
    public void zn(wz wzVar) {
        this.f7639zn = 0;
        this.f7631gv = wzVar;
        this.f7634s = -1L;
    }

    @Override // e4.t
    public void release() {
    }
}
