package y3;

import androidx.annotation.Nullable;
import d9.zn;
import m1.m;
import y3.ud;
/* loaded from: classes.dex */
public final class a implements tl {

    /* renamed from: a  reason: collision with root package name */
    public int f14957a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f14958c5;

    /* renamed from: f  reason: collision with root package name */
    public m f14959f;

    /* renamed from: fb  reason: collision with root package name */
    public int f14960fb;

    /* renamed from: gv  reason: collision with root package name */
    public String f14961gv;

    /* renamed from: i9  reason: collision with root package name */
    public long f14962i9;

    /* renamed from: n3  reason: collision with root package name */
    public final v5.rz f14963n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f14964s;

    /* renamed from: t  reason: collision with root package name */
    public int f14965t;

    /* renamed from: tl  reason: collision with root package name */
    public long f14966tl;

    /* renamed from: v  reason: collision with root package name */
    public e4.ta f14967v;
    public final v5.fh y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final String f14968zn;

    public a() {
        this(null);
    }

    private void fb() {
        this.y.w(0);
        zn.n3 gv2 = d9.zn.gv(this.y);
        m mVar = this.f14959f;
        if (mVar == null || gv2.f7247zn != mVar.f10958oz || gv2.f7245n3 != mVar.f10966ut || !"audio/ac4".equals(mVar.f10948f3)) {
            m z62 = new m.n3().oz(this.f14961gv).o4("audio/ac4").a8(gv2.f7247zn).rs(gv2.f7245n3).k(this.f14968zn).z6();
            this.f14959f = z62;
            this.f14967v.v(z62);
        }
        this.f14965t = gv2.f7244gv;
        this.f14962i9 = (gv2.f7246v * 1000000) / this.f14959f.f10966ut;
    }

    private boolean s(v5.rz rzVar) {
        boolean z2;
        int ej2;
        boolean z3;
        while (true) {
            z2 = false;
            if (rzVar.y() <= 0) {
                return false;
            }
            if (!this.f14964s) {
                if (rzVar.ej() == 172) {
                    z2 = true;
                }
                this.f14964s = z2;
            } else {
                ej2 = rzVar.ej();
                if (ej2 == 172) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f14964s = z3;
                if (ej2 == 64 || ej2 == 65) {
                    break;
                }
            }
        }
        if (ej2 == 65) {
            z2 = true;
        }
        this.f14958c5 = z2;
        return true;
    }

    private boolean y(v5.rz rzVar, byte[] bArr, int i) {
        int min = Math.min(rzVar.y(), i - this.f14960fb);
        rzVar.t(bArr, this.f14960fb, min);
        int i5 = this.f14960fb + min;
        this.f14960fb = i5;
        if (i5 == i) {
            return true;
        }
        return false;
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f14966tl = j2;
        }
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        int i;
        v5.y.c5(this.f14967v);
        while (rzVar.y() > 0) {
            int i5 = this.f14957a;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        int min = Math.min(rzVar.y(), this.f14965t - this.f14960fb);
                        this.f14967v.zn(rzVar, min);
                        int i6 = this.f14960fb + min;
                        this.f14960fb = i6;
                        int i8 = this.f14965t;
                        if (i6 == i8) {
                            long j2 = this.f14966tl;
                            if (j2 != -9223372036854775807L) {
                                this.f14967v.gv(j2, 1, i8, 0, null);
                                this.f14966tl += this.f14962i9;
                            }
                            this.f14957a = 0;
                        }
                    }
                } else if (y(rzVar, this.f14963n3.v(), 16)) {
                    fb();
                    this.f14963n3.oz(0);
                    this.f14967v.zn(this.f14963n3, 16);
                    this.f14957a = 2;
                }
            } else if (s(rzVar)) {
                this.f14957a = 1;
                this.f14963n3.v()[0] = -84;
                byte[] v2 = this.f14963n3.v();
                if (this.f14958c5) {
                    i = 65;
                } else {
                    i = 64;
                }
                v2[1] = (byte) i;
                this.f14960fb = 2;
            }
        }
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f14961gv = gvVar.n3();
        this.f14967v = wzVar.a(gvVar.zn(), 1);
    }

    @Override // y3.tl
    public void zn() {
        this.f14957a = 0;
        this.f14960fb = 0;
        this.f14964s = false;
        this.f14958c5 = false;
        this.f14966tl = -9223372036854775807L;
    }

    public a(@Nullable String str) {
        v5.fh fhVar = new v5.fh(new byte[16]);
        this.y = fhVar;
        this.f14963n3 = new v5.rz(fhVar.y);
        this.f14957a = 0;
        this.f14960fb = 0;
        this.f14964s = false;
        this.f14958c5 = false;
        this.f14966tl = -9223372036854775807L;
        this.f14968zn = str;
    }

    @Override // y3.tl
    public void gv() {
    }
}
