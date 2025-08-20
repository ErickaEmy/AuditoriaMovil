package y3;

import androidx.core.app.NotificationCompat;
import v5.j5;
import v5.k5;
import y3.ud;
/* loaded from: classes.dex */
public final class rz implements ud {

    /* renamed from: a  reason: collision with root package name */
    public boolean f15128a;

    /* renamed from: gv  reason: collision with root package name */
    public int f15129gv;

    /* renamed from: n3  reason: collision with root package name */
    public final v5.rz f15130n3 = new v5.rz(32);

    /* renamed from: v  reason: collision with root package name */
    public boolean f15131v;
    public final fh y;

    /* renamed from: zn  reason: collision with root package name */
    public int f15132zn;

    public rz(fh fhVar) {
        this.y = fhVar;
    }

    @Override // y3.ud
    public void n3(v5.rz rzVar, int i) {
        boolean z2;
        int i5;
        boolean z3;
        if ((i & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i5 = rzVar.a() + rzVar.ej();
        } else {
            i5 = -1;
        }
        if (this.f15128a) {
            if (!z2) {
                return;
            }
            this.f15128a = false;
            rzVar.oz(i5);
            this.f15129gv = 0;
        }
        while (rzVar.y() > 0) {
            int i6 = this.f15129gv;
            if (i6 < 3) {
                if (i6 == 0) {
                    int ej2 = rzVar.ej();
                    rzVar.oz(rzVar.a() - 1);
                    if (ej2 == 255) {
                        this.f15128a = true;
                        return;
                    }
                }
                int min = Math.min(rzVar.y(), 3 - this.f15129gv);
                rzVar.t(this.f15130n3.v(), this.f15129gv, min);
                int i8 = this.f15129gv + min;
                this.f15129gv = i8;
                if (i8 == 3) {
                    this.f15130n3.oz(0);
                    this.f15130n3.j(3);
                    this.f15130n3.ut(1);
                    int ej3 = this.f15130n3.ej();
                    int ej4 = this.f15130n3.ej();
                    if ((ej3 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.f15131v = z3;
                    this.f15132zn = (((ej3 & 15) << 8) | ej4) + 3;
                    int n32 = this.f15130n3.n3();
                    int i10 = this.f15132zn;
                    if (n32 < i10) {
                        this.f15130n3.zn(Math.min(4098, Math.max(i10, this.f15130n3.n3() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(rzVar.y(), this.f15132zn - this.f15129gv);
                rzVar.t(this.f15130n3.v(), this.f15129gv, min2);
                int i11 = this.f15129gv + min2;
                this.f15129gv = i11;
                int i12 = this.f15132zn;
                if (i11 != i12) {
                    continue;
                } else {
                    if (this.f15131v) {
                        if (j5.z(this.f15130n3.v(), 0, this.f15132zn, -1) != 0) {
                            this.f15128a = true;
                            return;
                        }
                        this.f15130n3.j(this.f15132zn - 4);
                    } else {
                        this.f15130n3.j(i12);
                    }
                    this.f15130n3.oz(0);
                    this.y.n3(this.f15130n3);
                    this.f15129gv = 0;
                }
            }
        }
    }

    @Override // y3.ud
    public void y(k5 k5Var, e4.wz wzVar, ud.gv gvVar) {
        this.y.y(k5Var, wzVar, gvVar);
        this.f15128a = true;
    }

    @Override // y3.ud
    public void zn() {
        this.f15128a = true;
    }
}
