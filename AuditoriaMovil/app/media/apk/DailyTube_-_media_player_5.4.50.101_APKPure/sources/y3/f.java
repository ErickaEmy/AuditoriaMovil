package y3;

import androidx.annotation.Nullable;
import m1.m;
import y3.ud;
/* loaded from: classes.dex */
public final class f implements tl {

    /* renamed from: a  reason: collision with root package name */
    public int f15060a;

    /* renamed from: c5  reason: collision with root package name */
    public m f15061c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f15063fb;

    /* renamed from: gv  reason: collision with root package name */
    public e4.ta f15064gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f15065i9;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final String f15066n3;

    /* renamed from: s  reason: collision with root package name */
    public long f15067s;

    /* renamed from: zn  reason: collision with root package name */
    public String f15069zn;
    public final v5.rz y = new v5.rz(new byte[18]);

    /* renamed from: v  reason: collision with root package name */
    public int f15068v = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f15062f = -9223372036854775807L;

    public f(@Nullable String str) {
        this.f15066n3 = str;
    }

    private void fb() {
        byte[] v2 = this.y.v();
        if (this.f15061c5 == null) {
            m fb2 = d9.ta.fb(v2, this.f15069zn, this.f15066n3, null);
            this.f15061c5 = fb2;
            this.f15064gv.v(fb2);
        }
        this.f15065i9 = d9.ta.y(v2);
        this.f15067s = (int) ((d9.ta.a(v2) * 1000000) / this.f15061c5.f10966ut);
    }

    private boolean s(v5.rz rzVar) {
        while (rzVar.y() > 0) {
            int i = this.f15063fb << 8;
            this.f15063fb = i;
            int ej2 = i | rzVar.ej();
            this.f15063fb = ej2;
            if (d9.ta.gv(ej2)) {
                byte[] v2 = this.y.v();
                int i5 = this.f15063fb;
                v2[0] = (byte) ((i5 >> 24) & 255);
                v2[1] = (byte) ((i5 >> 16) & 255);
                v2[2] = (byte) ((i5 >> 8) & 255);
                v2[3] = (byte) (i5 & 255);
                this.f15060a = 4;
                this.f15063fb = 0;
                return true;
            }
        }
        return false;
    }

    private boolean y(v5.rz rzVar, byte[] bArr, int i) {
        int min = Math.min(rzVar.y(), i - this.f15060a);
        rzVar.t(bArr, this.f15060a, min);
        int i5 = this.f15060a + min;
        this.f15060a = i5;
        if (i5 == i) {
            return true;
        }
        return false;
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f15062f = j2;
        }
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        v5.y.c5(this.f15064gv);
        while (rzVar.y() > 0) {
            int i = this.f15068v;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(rzVar.y(), this.f15065i9 - this.f15060a);
                        this.f15064gv.zn(rzVar, min);
                        int i5 = this.f15060a + min;
                        this.f15060a = i5;
                        int i6 = this.f15065i9;
                        if (i5 == i6) {
                            long j2 = this.f15062f;
                            if (j2 != -9223372036854775807L) {
                                this.f15064gv.gv(j2, 1, i6, 0, null);
                                this.f15062f += this.f15067s;
                            }
                            this.f15068v = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (y(rzVar, this.y.v(), 18)) {
                    fb();
                    this.y.oz(0);
                    this.f15064gv.zn(this.y, 18);
                    this.f15068v = 2;
                }
            } else if (s(rzVar)) {
                this.f15068v = 1;
            }
        }
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f15069zn = gvVar.n3();
        this.f15064gv = wzVar.a(gvVar.zn(), 1);
    }

    @Override // y3.tl
    public void zn() {
        this.f15068v = 0;
        this.f15060a = 0;
        this.f15063fb = 0;
        this.f15062f = -9223372036854775807L;
    }

    @Override // y3.tl
    public void gv() {
    }
}
