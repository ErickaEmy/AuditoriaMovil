package f3;

import f3.c5;
import f3.gv;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n3 implements gv.y {

    /* renamed from: n3  reason: collision with root package name */
    public float f7832n3;

    /* renamed from: v  reason: collision with root package name */
    public y f7833v;
    public c5 y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f7834zn;

    /* renamed from: gv  reason: collision with root package name */
    public ArrayList<c5> f7831gv = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public boolean f7830a = false;

    /* loaded from: classes.dex */
    public interface y {
        boolean a(c5 c5Var);

        float c5(int i);

        void clear();

        void f(c5 c5Var, float f4);

        void fb();

        int gv();

        void i9(c5 c5Var, float f4, boolean z2);

        float s(n3 n3Var, boolean z2);

        float t(c5 c5Var, boolean z2);

        float tl(c5 c5Var);

        c5 v(int i);

        void wz(float f4);
    }

    public n3() {
    }

    public boolean a(gv gvVar) {
        boolean z2;
        c5 fb2 = fb(gvVar);
        if (fb2 == null) {
            z2 = true;
        } else {
            f3(fb2);
            z2 = false;
        }
        if (this.f7833v.gv() == 0) {
            this.f7830a = true;
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String c() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.n3.c():java.lang.String");
    }

    public n3 c5(c5 c5Var, int i) {
        this.y = c5Var;
        float f4 = i;
        c5Var.f7771a = f4;
        this.f7832n3 = f4;
        this.f7830a = true;
        return this;
    }

    @Override // f3.gv.y
    public void clear() {
        this.f7833v.clear();
        this.y = null;
        this.f7832n3 = 0.0f;
    }

    public boolean co() {
        c5 c5Var = this.y;
        if (c5Var != null && (c5Var.f7776i9 == c5.y.UNRESTRICTED || this.f7832n3 >= 0.0f)) {
            return true;
        }
        return false;
    }

    public void d0(gv gvVar, c5 c5Var, boolean z2) {
        if (!c5Var.f7774fb) {
            return;
        }
        this.f7832n3 += c5Var.f7771a * this.f7833v.tl(c5Var);
        this.f7833v.t(c5Var, z2);
        if (z2) {
            c5Var.zn(this);
        }
        if (gv.f7799z && this.f7833v.gv() == 0) {
            this.f7830a = true;
            gvVar.y = true;
        }
    }

    public n3 f(c5 c5Var, c5 c5Var2, c5 c5Var3, c5 c5Var4, float f4) {
        this.f7833v.f(c5Var, -1.0f);
        this.f7833v.f(c5Var2, 1.0f);
        this.f7833v.f(c5Var3, f4);
        this.f7833v.f(c5Var4, -f4);
        return this;
    }

    public void f3(c5 c5Var) {
        c5 c5Var2 = this.y;
        if (c5Var2 != null) {
            this.f7833v.f(c5Var2, -1.0f);
            this.y.f7775gv = -1;
            this.y = null;
        }
        float t2 = this.f7833v.t(c5Var, true) * (-1.0f);
        this.y = c5Var;
        if (t2 == 1.0f) {
            return;
        }
        this.f7832n3 /= t2;
        this.f7833v.wz(t2);
    }

    public c5 fb(gv gvVar) {
        boolean r2;
        boolean r3;
        int gv2 = this.f7833v.gv();
        c5 c5Var = null;
        c5 c5Var2 = null;
        boolean z2 = false;
        boolean z3 = false;
        float f4 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < gv2; i++) {
            float c52 = this.f7833v.c5(i);
            c5 v2 = this.f7833v.v(i);
            if (v2.f7776i9 == c5.y.UNRESTRICTED) {
                if (c5Var == null) {
                    r3 = r(v2, gvVar);
                } else if (f4 > c52) {
                    r3 = r(v2, gvVar);
                } else if (!z2 && r(v2, gvVar)) {
                    f4 = c52;
                    c5Var = v2;
                    z2 = true;
                }
                z2 = r3;
                f4 = c52;
                c5Var = v2;
            } else if (c5Var == null && c52 < 0.0f) {
                if (c5Var2 == null) {
                    r2 = r(v2, gvVar);
                } else if (f6 > c52) {
                    r2 = r(v2, gvVar);
                } else if (!z3 && r(v2, gvVar)) {
                    f6 = c52;
                    c5Var2 = v2;
                    z3 = true;
                }
                z3 = r2;
                f6 = c52;
                c5Var2 = v2;
            }
        }
        if (c5Var != null) {
            return c5Var;
        }
        return c5Var2;
    }

    public void fh(gv gvVar, n3 n3Var, boolean z2) {
        this.f7832n3 += n3Var.f7832n3 * this.f7833v.s(n3Var, z2);
        if (z2) {
            n3Var.y.zn(this);
        }
        if (gv.f7799z && this.y != null && this.f7833v.gv() == 0) {
            this.f7830a = true;
            gvVar.y = true;
        }
    }

    @Override // f3.gv.y
    public c5 getKey() {
        return this.y;
    }

    public n3 gv(gv gvVar, int i) {
        this.f7833v.f(gvVar.xc(i, "ep"), 1.0f);
        this.f7833v.f(gvVar.xc(i, "em"), -1.0f);
        return this;
    }

    public final c5 i4(boolean[] zArr, c5 c5Var) {
        c5.y yVar;
        int gv2 = this.f7833v.gv();
        c5 c5Var2 = null;
        float f4 = 0.0f;
        for (int i = 0; i < gv2; i++) {
            float c52 = this.f7833v.c5(i);
            if (c52 < 0.0f) {
                c5 v2 = this.f7833v.v(i);
                if ((zArr == null || !zArr[v2.f7785zn]) && v2 != c5Var && (((yVar = v2.f7776i9) == c5.y.SLACK || yVar == c5.y.ERROR) && c52 < f4)) {
                    f4 = c52;
                    c5Var2 = v2;
                }
            }
        }
        return c5Var2;
    }

    public n3 i9(c5 c5Var, c5 c5Var2, float f4) {
        this.f7833v.f(c5Var, -1.0f);
        this.f7833v.f(c5Var2, f4);
        return this;
    }

    @Override // f3.gv.y
    public boolean isEmpty() {
        if (this.y == null && this.f7832n3 == 0.0f && this.f7833v.gv() == 0) {
            return true;
        }
        return false;
    }

    public void mg(gv gvVar) {
        if (gvVar.f7803fb.length == 0) {
            return;
        }
        boolean z2 = false;
        while (!z2) {
            int gv2 = this.f7833v.gv();
            for (int i = 0; i < gv2; i++) {
                c5 v2 = this.f7833v.v(i);
                if (v2.f7775gv != -1 || v2.f7774fb || v2.f7783wz) {
                    this.f7831gv.add(v2);
                }
            }
            int size = this.f7831gv.size();
            if (size > 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    c5 c5Var = this.f7831gv.get(i5);
                    if (c5Var.f7774fb) {
                        d0(gvVar, c5Var, true);
                    } else if (c5Var.f7783wz) {
                        rz(gvVar, c5Var, true);
                    } else {
                        fh(gvVar, gvVar.f7803fb[c5Var.f7775gv], true);
                    }
                }
                this.f7831gv.clear();
            } else {
                z2 = true;
            }
        }
        if (gv.f7799z && this.y != null && this.f7833v.gv() == 0) {
            this.f7830a = true;
            gvVar.y = true;
        }
    }

    public void mt() {
        float f4 = this.f7832n3;
        if (f4 < 0.0f) {
            this.f7832n3 = f4 * (-1.0f);
            this.f7833v.fb();
        }
    }

    public void n() {
        this.y = null;
        this.f7833v.clear();
        this.f7832n3 = 0.0f;
        this.f7830a = false;
    }

    @Override // f3.gv.y
    public void n3(c5 c5Var) {
        int i = c5Var.f7781v;
        float f4 = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f4 = 1000.0f;
            } else if (i == 3) {
                f4 = 1000000.0f;
            } else if (i == 4) {
                f4 = 1.0E9f;
            } else if (i == 5) {
                f4 = 1.0E12f;
            }
        }
        this.f7833v.f(c5Var, f4);
    }

    public n3 p(c5 c5Var, c5 c5Var2, c5 c5Var3, c5 c5Var4, float f4) {
        this.f7833v.f(c5Var3, 0.5f);
        this.f7833v.f(c5Var4, 0.5f);
        this.f7833v.f(c5Var, -0.5f);
        this.f7833v.f(c5Var2, -0.5f);
        this.f7832n3 = -f4;
        return this;
    }

    public final boolean r(c5 c5Var, gv gvVar) {
        if (c5Var.f7780tl <= 1) {
            return true;
        }
        return false;
    }

    public void rz(gv gvVar, c5 c5Var, boolean z2) {
        if (!c5Var.f7783wz) {
            return;
        }
        float tl2 = this.f7833v.tl(c5Var);
        this.f7832n3 += c5Var.f7782w * tl2;
        this.f7833v.t(c5Var, z2);
        if (z2) {
            c5Var.zn(this);
        }
        this.f7833v.i9(gvVar.f7813wz.f7854gv[c5Var.f7784xc], tl2, z2);
        if (gv.f7799z && this.f7833v.gv() == 0) {
            this.f7830a = true;
            gvVar.y = true;
        }
    }

    public n3 s(c5 c5Var, c5 c5Var2, int i, float f4, c5 c5Var3, c5 c5Var4, int i5) {
        if (c5Var2 == c5Var3) {
            this.f7833v.f(c5Var, 1.0f);
            this.f7833v.f(c5Var4, 1.0f);
            this.f7833v.f(c5Var2, -2.0f);
            return this;
        }
        if (f4 == 0.5f) {
            this.f7833v.f(c5Var, 1.0f);
            this.f7833v.f(c5Var2, -1.0f);
            this.f7833v.f(c5Var3, -1.0f);
            this.f7833v.f(c5Var4, 1.0f);
            if (i > 0 || i5 > 0) {
                this.f7832n3 = (-i) + i5;
            }
        } else if (f4 <= 0.0f) {
            this.f7833v.f(c5Var, -1.0f);
            this.f7833v.f(c5Var2, 1.0f);
            this.f7832n3 = i;
        } else if (f4 >= 1.0f) {
            this.f7833v.f(c5Var4, -1.0f);
            this.f7833v.f(c5Var3, 1.0f);
            this.f7832n3 = -i5;
        } else {
            float f6 = 1.0f - f4;
            this.f7833v.f(c5Var, f6 * 1.0f);
            this.f7833v.f(c5Var2, f6 * (-1.0f));
            this.f7833v.f(c5Var3, (-1.0f) * f4);
            this.f7833v.f(c5Var4, 1.0f * f4);
            if (i > 0 || i5 > 0) {
                this.f7832n3 = ((-i) * f6) + (i5 * f4);
            }
        }
        return this;
    }

    public n3 t(float f4, float f6, float f9, c5 c5Var, c5 c5Var2, c5 c5Var3, c5 c5Var4) {
        this.f7832n3 = 0.0f;
        if (f6 != 0.0f && f4 != f9) {
            if (f4 == 0.0f) {
                this.f7833v.f(c5Var, 1.0f);
                this.f7833v.f(c5Var2, -1.0f);
            } else if (f9 == 0.0f) {
                this.f7833v.f(c5Var3, 1.0f);
                this.f7833v.f(c5Var4, -1.0f);
            } else {
                float f10 = (f4 / f6) / (f9 / f6);
                this.f7833v.f(c5Var, 1.0f);
                this.f7833v.f(c5Var2, -1.0f);
                this.f7833v.f(c5Var4, f10);
                this.f7833v.f(c5Var3, -f10);
            }
        } else {
            this.f7833v.f(c5Var, 1.0f);
            this.f7833v.f(c5Var2, -1.0f);
            this.f7833v.f(c5Var4, 1.0f);
            this.f7833v.f(c5Var3, -1.0f);
        }
        return this;
    }

    public n3 tl(c5 c5Var, int i) {
        if (i < 0) {
            this.f7832n3 = i * (-1);
            this.f7833v.f(c5Var, 1.0f);
        } else {
            this.f7832n3 = i;
            this.f7833v.f(c5Var, -1.0f);
        }
        return this;
    }

    public String toString() {
        return c();
    }

    public n3 v(c5 c5Var, int i) {
        this.f7833v.f(c5Var, i);
        return this;
    }

    public n3 w(c5 c5Var, c5 c5Var2, c5 c5Var3, int i) {
        boolean z2 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z2 = true;
            }
            this.f7832n3 = i;
        }
        if (!z2) {
            this.f7833v.f(c5Var, -1.0f);
            this.f7833v.f(c5Var2, 1.0f);
            this.f7833v.f(c5Var3, -1.0f);
        } else {
            this.f7833v.f(c5Var, 1.0f);
            this.f7833v.f(c5Var2, -1.0f);
            this.f7833v.f(c5Var3, 1.0f);
        }
        return this;
    }

    public n3 wz(c5 c5Var, c5 c5Var2, int i) {
        boolean z2 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z2 = true;
            }
            this.f7832n3 = i;
        }
        if (!z2) {
            this.f7833v.f(c5Var, -1.0f);
            this.f7833v.f(c5Var2, 1.0f);
        } else {
            this.f7833v.f(c5Var, 1.0f);
            this.f7833v.f(c5Var2, -1.0f);
        }
        return this;
    }

    public c5 x4(c5 c5Var) {
        return i4(null, c5Var);
    }

    public n3 xc(c5 c5Var, c5 c5Var2, c5 c5Var3, int i) {
        boolean z2 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z2 = true;
            }
            this.f7832n3 = i;
        }
        if (!z2) {
            this.f7833v.f(c5Var, -1.0f);
            this.f7833v.f(c5Var2, 1.0f);
            this.f7833v.f(c5Var3, 1.0f);
        } else {
            this.f7833v.f(c5Var, 1.0f);
            this.f7833v.f(c5Var2, -1.0f);
            this.f7833v.f(c5Var3, -1.0f);
        }
        return this;
    }

    @Override // f3.gv.y
    public void y(gv.y yVar) {
        if (yVar instanceof n3) {
            n3 n3Var = (n3) yVar;
            this.y = null;
            this.f7833v.clear();
            for (int i = 0; i < n3Var.f7833v.gv(); i++) {
                this.f7833v.i9(n3Var.f7833v.v(i), n3Var.f7833v.c5(i), true);
            }
        }
    }

    public boolean z(c5 c5Var) {
        return this.f7833v.a(c5Var);
    }

    @Override // f3.gv.y
    public c5 zn(gv gvVar, boolean[] zArr) {
        return i4(zArr, null);
    }

    public n3(zn znVar) {
        this.f7833v = new f3.y(this, znVar);
    }
}
