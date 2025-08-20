package n;

import n.gv;
import n.v;
/* loaded from: classes.dex */
public class fb extends v {

    /* renamed from: cy  reason: collision with root package name */
    public int f11662cy;

    /* renamed from: qk  reason: collision with root package name */
    public boolean f11664qk;

    /* renamed from: o0  reason: collision with root package name */
    public float f11663o0 = -1.0f;

    /* renamed from: xb  reason: collision with root package name */
    public int f11666xb = -1;

    /* renamed from: wf  reason: collision with root package name */
    public int f11665wf = -1;

    /* renamed from: ad  reason: collision with root package name */
    public gv f11661ad = this.f11747ud;

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[gv.n3.values().length];
            y = iArr;
            try {
                iArr[gv.n3.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[gv.n3.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[gv.n3.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[gv.n3.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[gv.n3.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[gv.n3.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[gv.n3.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                y[gv.n3.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                y[gv.n3.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public fb() {
        this.f11714j5.clear();
        this.f11714j5.add(this.f11661ad);
        int length = this.f11710hw.length;
        for (int i = 0; i < length; i++) {
            this.f11710hw[i] = this.f11661ad;
        }
    }

    public void br(int i) {
        if (this.f11662cy == i) {
            return;
        }
        this.f11662cy = i;
        this.f11714j5.clear();
        if (this.f11662cy == 1) {
            this.f11661ad = this.f11700ej;
        } else {
            this.f11661ad = this.f11747ud;
        }
        this.f11714j5.add(this.f11661ad);
        int length = this.f11710hw.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.f11710hw[i5] = this.f11661ad;
        }
    }

    public void bv(int i) {
        if (i > -1) {
            this.f11663o0 = -1.0f;
            this.f11666xb = -1;
            this.f11665wf = i;
        }
    }

    @Override // n.v
    public boolean ct() {
        return this.f11664qk;
    }

    @Override // n.v
    public boolean dm() {
        return this.f11664qk;
    }

    @Override // n.v
    public void fb(f3.gv gvVar, boolean z2) {
        boolean z3;
        a aVar = (a) ud();
        if (aVar == null) {
            return;
        }
        gv tl2 = aVar.tl(gv.n3.LEFT);
        gv tl3 = aVar.tl(gv.n3.RIGHT);
        v vVar = this.f11713j;
        boolean z4 = true;
        if (vVar != null && vVar.f11726o[0] == v.n3.WRAP_CONTENT) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f11662cy == 0) {
            tl2 = aVar.tl(gv.n3.TOP);
            tl3 = aVar.tl(gv.n3.BOTTOM);
            v vVar2 = this.f11713j;
            z3 = (vVar2 == null || vVar2.f11726o[1] != v.n3.WRAP_CONTENT) ? false : false;
        }
        if (this.f11664qk && this.f11661ad.tl()) {
            f3.c5 p2 = gvVar.p(this.f11661ad);
            gvVar.a(p2, this.f11661ad.gv());
            if (this.f11666xb != -1) {
                if (z3) {
                    gvVar.s(gvVar.p(tl3), p2, 0, 5);
                }
            } else if (this.f11665wf != -1 && z3) {
                f3.c5 p3 = gvVar.p(tl3);
                gvVar.s(p2, gvVar.p(tl2), 0, 5);
                gvVar.s(p3, p2, 0, 5);
            }
            this.f11664qk = false;
        } else if (this.f11666xb != -1) {
            f3.c5 p4 = gvVar.p(this.f11661ad);
            gvVar.v(p4, gvVar.p(tl2), this.f11666xb, 8);
            if (z3) {
                gvVar.s(gvVar.p(tl3), p4, 0, 5);
            }
        } else if (this.f11665wf != -1) {
            f3.c5 p8 = gvVar.p(this.f11661ad);
            f3.c5 p9 = gvVar.p(tl3);
            gvVar.v(p8, p9, -this.f11665wf, 8);
            if (z3) {
                gvVar.s(p8, gvVar.p(tl2), 0, 5);
                gvVar.s(p9, p8, 0, 5);
            }
        } else if (this.f11663o0 != -1.0f) {
            gvVar.gv(f3.gv.co(gvVar, gvVar.p(this.f11661ad), gvVar.p(tl3), this.f11663o0));
        }
    }

    public void fc(float f4) {
        if (f4 > -1.0f) {
            this.f11663o0 = f4;
            this.f11666xb = -1;
            this.f11665wf = -1;
        }
    }

    public void gf(int i) {
        if (i > -1) {
            this.f11663o0 = -1.0f;
            this.f11666xb = i;
            this.f11665wf = -1;
        }
    }

    @Override // n.v
    public void i3(f3.gv gvVar, boolean z2) {
        if (ud() == null) {
            return;
        }
        int f32 = gvVar.f3(this.f11661ad);
        if (this.f11662cy == 1) {
            ro(f32);
            ix(0);
            g(ud().x4());
            cs(0);
            return;
        }
        ro(0);
        ix(f32);
        cs(ud().qn());
        g(0);
    }

    public int j3() {
        return this.f11662cy;
    }

    public void nd(int i) {
        this.f11661ad.co(i);
        this.f11664qk = true;
    }

    public int ne() {
        return this.f11666xb;
    }

    public int q() {
        return this.f11665wf;
    }

    @Override // n.v
    public boolean s() {
        return true;
    }

    @Override // n.v
    public gv tl(gv.n3 n3Var) {
        switch (y.y[n3Var.ordinal()]) {
            case 1:
            case 2:
                if (this.f11662cy == 1) {
                    return this.f11661ad;
                }
                break;
            case 3:
            case 4:
                if (this.f11662cy == 0) {
                    return this.f11661ad;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(n3Var.name());
    }

    public gv vn() {
        return this.f11661ad;
    }

    public float wm() {
        return this.f11663o0;
    }
}
