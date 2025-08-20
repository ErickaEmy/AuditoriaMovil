package kp;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class y implements n3 {

    /* renamed from: n3  reason: collision with root package name */
    public int f9990n3;

    /* renamed from: v  reason: collision with root package name */
    public Object f9991v;
    public final n3 y;

    /* renamed from: zn  reason: collision with root package name */
    public int f9992zn = -1;

    /* renamed from: gv  reason: collision with root package name */
    public int f9989gv = -1;

    public y(@NonNull n3 n3Var) {
        this.y = n3Var;
    }

    @Override // kp.n3
    public void gv(int i, int i5) {
        v();
        this.y.gv(i, i5);
    }

    @Override // kp.n3
    public void n3(int i, int i5) {
        int i6;
        if (this.f9990n3 == 2 && (i6 = this.f9992zn) >= i && i6 <= i + i5) {
            this.f9989gv += i5;
            this.f9992zn = i;
            return;
        }
        v();
        this.f9992zn = i;
        this.f9989gv = i5;
        this.f9990n3 = 2;
    }

    public void v() {
        int i = this.f9990n3;
        if (i == 0) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.y.zn(this.f9992zn, this.f9989gv, this.f9991v);
                }
            } else {
                this.y.n3(this.f9992zn, this.f9989gv);
            }
        } else {
            this.y.y(this.f9992zn, this.f9989gv);
        }
        this.f9991v = null;
        this.f9990n3 = 0;
    }

    @Override // kp.n3
    public void y(int i, int i5) {
        int i6;
        if (this.f9990n3 == 1 && i >= (i6 = this.f9992zn)) {
            int i8 = this.f9989gv;
            if (i <= i6 + i8) {
                this.f9989gv = i8 + i5;
                this.f9992zn = Math.min(i, i6);
                return;
            }
        }
        v();
        this.f9992zn = i;
        this.f9989gv = i5;
        this.f9990n3 = 1;
    }

    @Override // kp.n3
    public void zn(int i, int i5, Object obj) {
        int i6;
        if (this.f9990n3 == 3) {
            int i8 = this.f9992zn;
            int i10 = this.f9989gv;
            if (i <= i8 + i10 && (i6 = i + i5) >= i8 && this.f9991v == obj) {
                this.f9992zn = Math.min(i, i8);
                this.f9989gv = Math.max(i10 + i8, i6) - this.f9992zn;
                return;
            }
        }
        v();
        this.f9992zn = i;
        this.f9989gv = i5;
        this.f9991v = obj;
        this.f9990n3 = 3;
    }
}
