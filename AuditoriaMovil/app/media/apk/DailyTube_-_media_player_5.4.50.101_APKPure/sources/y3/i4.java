package y3;

import androidx.annotation.Nullable;
import m1.ne;
import v5.k5;
import y3.ud;
/* loaded from: classes.dex */
public final class i4 implements ud {

    /* renamed from: a  reason: collision with root package name */
    public boolean f15071a;

    /* renamed from: c5  reason: collision with root package name */
    public int f15072c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15073f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f15074fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f15075gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f15076i9;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15078s;

    /* renamed from: t  reason: collision with root package name */
    public long f15079t;

    /* renamed from: v  reason: collision with root package name */
    public k5 f15080v;
    public final tl y;

    /* renamed from: n3  reason: collision with root package name */
    public final v5.fh f15077n3 = new v5.fh(new byte[10]);

    /* renamed from: zn  reason: collision with root package name */
    public int f15081zn = 0;

    public i4(tl tlVar) {
        this.y = tlVar;
    }

    public final void a() {
        this.f15077n3.w(0);
        this.f15079t = -9223372036854775807L;
        if (this.f15071a) {
            this.f15077n3.mt(4);
            this.f15077n3.mt(1);
            this.f15077n3.mt(1);
            long s2 = (this.f15077n3.s(3) << 30) | (this.f15077n3.s(15) << 15) | this.f15077n3.s(15);
            this.f15077n3.mt(1);
            if (!this.f15078s && this.f15074fb) {
                this.f15077n3.mt(4);
                this.f15077n3.mt(1);
                this.f15077n3.mt(1);
                this.f15077n3.mt(1);
                this.f15080v.n3((this.f15077n3.s(3) << 30) | (this.f15077n3.s(15) << 15) | this.f15077n3.s(15));
                this.f15078s = true;
            }
            this.f15079t = this.f15080v.n3(s2);
        }
    }

    public final void fb(int i) {
        this.f15081zn = i;
        this.f15075gv = 0;
    }

    public final boolean gv(v5.rz rzVar, @Nullable byte[] bArr, int i) {
        int min = Math.min(rzVar.y(), i - this.f15075gv);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            rzVar.ut(min);
        } else {
            rzVar.t(bArr, this.f15075gv, min);
        }
        int i5 = this.f15075gv + min;
        this.f15075gv = i5;
        if (i5 == i) {
            return true;
        }
        return false;
    }

    @Override // y3.ud
    public final void n3(v5.rz rzVar, int i) throws ne {
        v5.y.c5(this.f15080v);
        if ((i & 1) != 0) {
            int i5 = this.f15081zn;
            if (i5 != 0 && i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        if (this.f15076i9 != -1) {
                            v5.r.c5("PesReader", "Unexpected start indicator: expected " + this.f15076i9 + " more bytes");
                        }
                        this.y.gv();
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    v5.r.c5("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            fb(1);
        }
        while (rzVar.y() > 0) {
            int i6 = this.f15081zn;
            if (i6 != 0) {
                int i8 = 0;
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            int y = rzVar.y();
                            int i10 = this.f15076i9;
                            if (i10 != -1) {
                                i8 = y - i10;
                            }
                            if (i8 > 0) {
                                y -= i8;
                                rzVar.j(rzVar.a() + y);
                            }
                            this.y.n3(rzVar);
                            int i11 = this.f15076i9;
                            if (i11 != -1) {
                                int i12 = i11 - y;
                                this.f15076i9 = i12;
                                if (i12 == 0) {
                                    this.y.gv();
                                    fb(1);
                                }
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        if (gv(rzVar, this.f15077n3.y, Math.min(10, this.f15072c5)) && gv(rzVar, null, this.f15072c5)) {
                            a();
                            if (this.f15073f) {
                                i8 = 4;
                            }
                            i |= i8;
                            this.y.a(this.f15079t, i);
                            fb(3);
                        }
                    }
                } else if (gv(rzVar, this.f15077n3.y, 9)) {
                    if (v()) {
                        i8 = 2;
                    }
                    fb(i8);
                }
            } else {
                rzVar.ut(rzVar.y());
            }
        }
    }

    public final boolean v() {
        this.f15077n3.w(0);
        int s2 = this.f15077n3.s(24);
        if (s2 != 1) {
            v5.r.c5("PesReader", "Unexpected start code prefix: " + s2);
            this.f15076i9 = -1;
            return false;
        }
        this.f15077n3.mt(8);
        int s3 = this.f15077n3.s(16);
        this.f15077n3.mt(5);
        this.f15073f = this.f15077n3.fb();
        this.f15077n3.mt(2);
        this.f15071a = this.f15077n3.fb();
        this.f15074fb = this.f15077n3.fb();
        this.f15077n3.mt(6);
        int s4 = this.f15077n3.s(8);
        this.f15072c5 = s4;
        if (s3 == 0) {
            this.f15076i9 = -1;
        } else {
            int i = (s3 - 3) - s4;
            this.f15076i9 = i;
            if (i < 0) {
                v5.r.c5("PesReader", "Found negative packet payload size: " + this.f15076i9);
                this.f15076i9 = -1;
            }
        }
        return true;
    }

    @Override // y3.ud
    public void y(k5 k5Var, e4.wz wzVar, ud.gv gvVar) {
        this.f15080v = k5Var;
        this.y.v(wzVar, gvVar);
    }

    @Override // y3.ud
    public final void zn() {
        this.f15081zn = 0;
        this.f15075gv = 0;
        this.f15078s = false;
        this.y.zn();
    }
}
