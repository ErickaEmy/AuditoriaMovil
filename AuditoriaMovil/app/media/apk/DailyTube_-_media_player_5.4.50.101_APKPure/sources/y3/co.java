package y3;

import androidx.annotation.Nullable;
import d9.y;
import java.util.Collections;
import m1.m;
import m1.ne;
import y3.ud;
/* loaded from: classes.dex */
public final class co implements tl {

    /* renamed from: a  reason: collision with root package name */
    public m f14990a;

    /* renamed from: c5  reason: collision with root package name */
    public int f14991c5;

    /* renamed from: co  reason: collision with root package name */
    public long f14992co;

    /* renamed from: f  reason: collision with root package name */
    public long f14993f;

    /* renamed from: fb  reason: collision with root package name */
    public int f14994fb;

    /* renamed from: gv  reason: collision with root package name */
    public e4.ta f14995gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f14996i9;

    /* renamed from: mt  reason: collision with root package name */
    public int f14997mt;

    /* renamed from: n3  reason: collision with root package name */
    public final v5.rz f14998n3;

    /* renamed from: p  reason: collision with root package name */
    public long f14999p;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public String f15000r;

    /* renamed from: s  reason: collision with root package name */
    public int f15001s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f15002t;

    /* renamed from: tl  reason: collision with root package name */
    public int f15003tl;

    /* renamed from: v  reason: collision with root package name */
    public String f15004v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f15005w;

    /* renamed from: wz  reason: collision with root package name */
    public int f15006wz;

    /* renamed from: xc  reason: collision with root package name */
    public int f15007xc;
    @Nullable
    public final String y;

    /* renamed from: z  reason: collision with root package name */
    public int f15008z;

    /* renamed from: zn  reason: collision with root package name */
    public final v5.fh f15009zn;

    public co(@Nullable String str) {
        this.y = str;
        v5.rz rzVar = new v5.rz(1024);
        this.f14998n3 = rzVar;
        this.f15009zn = new v5.fh(rzVar.v());
        this.f14993f = -9223372036854775807L;
    }

    public static long y(v5.fh fhVar) {
        return fhVar.s((fhVar.s(2) + 1) * 8);
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f14993f = j2;
        }
    }

    public final void c5(v5.fh fhVar) {
        int s2 = fhVar.s(3);
        this.f15007xc = s2;
        if (s2 != 0) {
            if (s2 != 1) {
                if (s2 != 3 && s2 != 4 && s2 != 5) {
                    if (s2 != 6 && s2 != 7) {
                        throw new IllegalStateException();
                    }
                    fhVar.mt(1);
                    return;
                }
                fhVar.mt(6);
                return;
            }
            fhVar.mt(9);
            return;
        }
        fhVar.mt(8);
    }

    public final void f(v5.fh fhVar, int i) {
        int v2 = fhVar.v();
        if ((v2 & 7) == 0) {
            this.f14998n3.oz(v2 >> 3);
        } else {
            fhVar.c5(this.f14998n3.v(), 0, i * 8);
            this.f14998n3.oz(0);
        }
        this.f14995gv.zn(this.f14998n3, i);
        long j2 = this.f14993f;
        if (j2 != -9223372036854775807L) {
            this.f14995gv.gv(j2, 1, i, 0, null);
            this.f14993f += this.f14992co;
        }
    }

    public final void fb(v5.fh fhVar) throws ne {
        if (!fhVar.fb()) {
            this.f15002t = true;
            t(fhVar);
        } else if (!this.f15002t) {
            return;
        }
        if (this.f15003tl == 0) {
            if (this.f15006wz == 0) {
                f(fhVar, i9(fhVar));
                if (this.f15005w) {
                    fhVar.mt((int) this.f14999p);
                    return;
                }
                return;
            }
            throw ne.y(null, null);
        }
        throw ne.y(null, null);
    }

    public final int i9(v5.fh fhVar) throws ne {
        int s2;
        if (this.f15007xc == 0) {
            int i = 0;
            do {
                s2 = fhVar.s(8);
                i += s2;
            } while (s2 == 255);
            return i;
        }
        throw ne.y(null, null);
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) throws ne {
        v5.y.c5(this.f14995gv);
        while (rzVar.y() > 0) {
            int i = this.f14994fb;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            int min = Math.min(rzVar.y(), this.f14991c5 - this.f15001s);
                            rzVar.t(this.f15009zn.y, this.f15001s, min);
                            int i5 = this.f15001s + min;
                            this.f15001s = i5;
                            if (i5 == this.f14991c5) {
                                this.f15009zn.w(0);
                                fb(this.f15009zn);
                                this.f14994fb = 0;
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        int ej2 = ((this.f14996i9 & (-225)) << 8) | rzVar.ej();
                        this.f14991c5 = ej2;
                        if (ej2 > this.f14998n3.v().length) {
                            tl(this.f14991c5);
                        }
                        this.f15001s = 0;
                        this.f14994fb = 3;
                    }
                } else {
                    int ej3 = rzVar.ej();
                    if ((ej3 & 224) == 224) {
                        this.f14996i9 = ej3;
                        this.f14994fb = 2;
                    } else if (ej3 != 86) {
                        this.f14994fb = 0;
                    }
                }
            } else if (rzVar.ej() == 86) {
                this.f14994fb = 1;
            }
        }
    }

    public final int s(v5.fh fhVar) throws ne {
        int n32 = fhVar.n3();
        y.n3 v2 = d9.y.v(fhVar, true);
        this.f15000r = v2.f7227zn;
        this.f14997mt = v2.y;
        this.f15008z = v2.f7226n3;
        return n32 - fhVar.n3();
    }

    public final void t(v5.fh fhVar) throws ne {
        int i;
        boolean fb2;
        int s2 = fhVar.s(1);
        if (s2 == 1) {
            i = fhVar.s(1);
        } else {
            i = 0;
        }
        this.f15003tl = i;
        if (i == 0) {
            if (s2 == 1) {
                y(fhVar);
            }
            if (fhVar.fb()) {
                this.f15006wz = fhVar.s(6);
                int s3 = fhVar.s(4);
                int s4 = fhVar.s(3);
                if (s3 == 0 && s4 == 0) {
                    if (s2 == 0) {
                        int v2 = fhVar.v();
                        int s5 = s(fhVar);
                        fhVar.w(v2);
                        byte[] bArr = new byte[(s5 + 7) / 8];
                        fhVar.c5(bArr, 0, s5);
                        m z62 = new m.n3().oz(this.f15004v).o4("audio/mp4a-latm").x(this.f15000r).a8(this.f15008z).rs(this.f14997mt).ut(Collections.singletonList(bArr)).k(this.y).z6();
                        if (!z62.equals(this.f14990a)) {
                            this.f14990a = z62;
                            this.f14992co = 1024000000 / z62.f10966ut;
                            this.f14995gv.v(z62);
                        }
                    } else {
                        fhVar.mt(((int) y(fhVar)) - s(fhVar));
                    }
                    c5(fhVar);
                    boolean fb3 = fhVar.fb();
                    this.f15005w = fb3;
                    this.f14999p = 0L;
                    if (fb3) {
                        if (s2 == 1) {
                            this.f14999p = y(fhVar);
                        } else {
                            do {
                                fb2 = fhVar.fb();
                                this.f14999p = (this.f14999p << 8) + fhVar.s(8);
                            } while (fb2);
                        }
                    }
                    if (fhVar.fb()) {
                        fhVar.mt(8);
                        return;
                    }
                    return;
                }
                throw ne.y(null, null);
            }
            throw ne.y(null, null);
        }
        throw ne.y(null, null);
    }

    public final void tl(int i) {
        this.f14998n3.j5(i);
        this.f15009zn.wz(this.f14998n3.v());
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f14995gv = wzVar.a(gvVar.zn(), 1);
        this.f15004v = gvVar.n3();
    }

    @Override // y3.tl
    public void zn() {
        this.f14994fb = 0;
        this.f14993f = -9223372036854775807L;
        this.f15002t = false;
    }

    @Override // y3.tl
    public void gv() {
    }
}
