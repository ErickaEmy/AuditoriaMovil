package y3;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import d9.n3;
import m1.m;
import v5.j5;
import y3.ud;
/* loaded from: classes.dex */
public final class zn implements tl {

    /* renamed from: a  reason: collision with root package name */
    public int f15268a;

    /* renamed from: c5  reason: collision with root package name */
    public long f15269c5;

    /* renamed from: f  reason: collision with root package name */
    public int f15270f;

    /* renamed from: fb  reason: collision with root package name */
    public int f15271fb;

    /* renamed from: gv  reason: collision with root package name */
    public String f15272gv;

    /* renamed from: i9  reason: collision with root package name */
    public m f15273i9;

    /* renamed from: n3  reason: collision with root package name */
    public final v5.rz f15274n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15275s;

    /* renamed from: t  reason: collision with root package name */
    public long f15276t;

    /* renamed from: v  reason: collision with root package name */
    public e4.ta f15277v;
    public final v5.fh y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final String f15278zn;

    public zn() {
        this(null);
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f15276t = j2;
        }
    }

    public final void fb() {
        this.y.w(0);
        n3.C0080n3 a2 = d9.n3.a(this.y);
        m mVar = this.f15273i9;
        if (mVar == null || a2.f7093gv != mVar.f10958oz || a2.f7096zn != mVar.f10966ut || !j5.zn(a2.y, mVar.f10948f3)) {
            m.n3 u2 = new m.n3().oz(this.f15272gv).o4(a2.y).a8(a2.f7093gv).rs(a2.f7096zn).k(this.f15278zn).u(a2.f7092fb);
            if ("audio/ac3".equals(a2.y)) {
                u2.ud(a2.f7092fb);
            }
            m z62 = u2.z6();
            this.f15273i9 = z62;
            this.f15277v.v(z62);
        }
        this.f15270f = a2.f7095v;
        this.f15269c5 = (a2.f7091a * 1000000) / this.f15273i9.f10966ut;
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        v5.y.c5(this.f15277v);
        while (rzVar.y() > 0) {
            int i = this.f15268a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(rzVar.y(), this.f15270f - this.f15271fb);
                        this.f15277v.zn(rzVar, min);
                        int i5 = this.f15271fb + min;
                        this.f15271fb = i5;
                        int i6 = this.f15270f;
                        if (i5 == i6) {
                            long j2 = this.f15276t;
                            if (j2 != -9223372036854775807L) {
                                this.f15277v.gv(j2, 1, i6, 0, null);
                                this.f15276t += this.f15269c5;
                            }
                            this.f15268a = 0;
                        }
                    }
                } else if (y(rzVar, this.f15274n3.v(), NotificationCompat.FLAG_HIGH_PRIORITY)) {
                    fb();
                    this.f15274n3.oz(0);
                    this.f15277v.zn(this.f15274n3, NotificationCompat.FLAG_HIGH_PRIORITY);
                    this.f15268a = 2;
                }
            } else if (s(rzVar)) {
                this.f15268a = 1;
                this.f15274n3.v()[0] = 11;
                this.f15274n3.v()[1] = 119;
                this.f15271fb = 2;
            }
        }
    }

    public final boolean s(v5.rz rzVar) {
        while (true) {
            boolean z2 = false;
            if (rzVar.y() <= 0) {
                return false;
            }
            if (!this.f15275s) {
                if (rzVar.ej() == 11) {
                    z2 = true;
                }
                this.f15275s = z2;
            } else {
                int ej2 = rzVar.ej();
                if (ej2 == 119) {
                    this.f15275s = false;
                    return true;
                }
                if (ej2 == 11) {
                    z2 = true;
                }
                this.f15275s = z2;
            }
        }
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f15272gv = gvVar.n3();
        this.f15277v = wzVar.a(gvVar.zn(), 1);
    }

    public final boolean y(v5.rz rzVar, byte[] bArr, int i) {
        int min = Math.min(rzVar.y(), i - this.f15271fb);
        rzVar.t(bArr, this.f15271fb, min);
        int i5 = this.f15271fb + min;
        this.f15271fb = i5;
        if (i5 == i) {
            return true;
        }
        return false;
    }

    @Override // y3.tl
    public void zn() {
        this.f15268a = 0;
        this.f15271fb = 0;
        this.f15275s = false;
        this.f15276t = -9223372036854775807L;
    }

    public zn(@Nullable String str) {
        v5.fh fhVar = new v5.fh(new byte[NotificationCompat.FLAG_HIGH_PRIORITY]);
        this.y = fhVar;
        this.f15274n3 = new v5.rz(fhVar.y);
        this.f15268a = 0;
        this.f15276t = -9223372036854775807L;
        this.f15278zn = str;
    }

    @Override // y3.tl
    public void gv() {
    }
}
