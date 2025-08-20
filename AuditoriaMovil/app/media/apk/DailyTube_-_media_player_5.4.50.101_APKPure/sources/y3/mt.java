package y3;

import m1.m;
import y3.ud;
/* loaded from: classes.dex */
public final class mt implements tl {

    /* renamed from: a  reason: collision with root package name */
    public int f15084a;

    /* renamed from: n3  reason: collision with root package name */
    public e4.ta f15086n3;

    /* renamed from: v  reason: collision with root package name */
    public int f15087v;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f15088zn;
    public final v5.rz y = new v5.rz(10);

    /* renamed from: gv  reason: collision with root package name */
    public long f15085gv = -9223372036854775807L;

    @Override // y3.tl
    public void a(long j2, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f15088zn = true;
        if (j2 != -9223372036854775807L) {
            this.f15085gv = j2;
        }
        this.f15087v = 0;
        this.f15084a = 0;
    }

    @Override // y3.tl
    public void gv() {
        int i;
        v5.y.c5(this.f15086n3);
        if (this.f15088zn && (i = this.f15087v) != 0 && this.f15084a == i) {
            long j2 = this.f15085gv;
            if (j2 != -9223372036854775807L) {
                this.f15086n3.gv(j2, 1, i, 0, null);
            }
            this.f15088zn = false;
        }
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        v5.y.c5(this.f15086n3);
        if (!this.f15088zn) {
            return;
        }
        int y = rzVar.y();
        int i = this.f15084a;
        if (i < 10) {
            int min = Math.min(y, 10 - i);
            System.arraycopy(rzVar.v(), rzVar.a(), this.y.v(), this.f15084a, min);
            if (this.f15084a + min == 10) {
                this.y.oz(0);
                if (73 == this.y.ej() && 68 == this.y.ej() && 51 == this.y.ej()) {
                    this.y.ut(3);
                    this.f15087v = this.y.z6() + 10;
                } else {
                    v5.r.c5("Id3Reader", "Discarding invalid ID3 tag");
                    this.f15088zn = false;
                    return;
                }
            }
        }
        int min2 = Math.min(y, this.f15087v - this.f15084a);
        this.f15086n3.zn(rzVar, min2);
        this.f15084a += min2;
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        e4.ta a2 = wzVar.a(gvVar.zn(), 5);
        this.f15086n3 = a2;
        a2.v(new m.n3().oz(gvVar.n3()).o4("application/id3").z6());
    }

    @Override // y3.tl
    public void zn() {
        this.f15088zn = false;
        this.f15085gv = -9223372036854775807L;
    }
}
