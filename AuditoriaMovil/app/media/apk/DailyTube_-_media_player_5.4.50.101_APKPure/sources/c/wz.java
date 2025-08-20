package c;

import c.a;
import c.w;
import n.gv;
import n.v;
/* loaded from: classes.dex */
public class wz extends w {

    /* renamed from: f  reason: collision with root package name */
    public a f3953f;

    /* renamed from: t  reason: collision with root package name */
    public fb f3954t;

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[w.n3.values().length];
            y = iArr;
            try {
                iArr[w.n3.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[w.n3.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[w.n3.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public wz(n.v vVar) {
        super(vVar);
        a aVar = new a(this);
        this.f3953f = aVar;
        this.f3954t = null;
        this.f3946s.f3900v = a.y.TOP;
        this.f3941c5.f3900v = a.y.BOTTOM;
        aVar.f3900v = a.y.BASELINE;
        this.f3940a = 1;
    }

    @Override // c.w
    public void a() {
        this.f3948zn = null;
        this.f3946s.zn();
        this.f3941c5.zn();
        this.f3953f.zn();
        this.f3947v.zn();
        this.f3942fb = false;
    }

    @Override // c.w
    public void gv() {
        n.v ud2;
        n.v ud3;
        n.v vVar = this.f3945n3;
        if (vVar.y) {
            this.f3947v.gv(vVar.x4());
        }
        if (!this.f3947v.f3896i9) {
            this.f3943gv = this.f3945n3.vl();
            if (this.f3945n3.oz()) {
                this.f3954t = new c.y(this);
            }
            v.n3 n3Var = this.f3943gv;
            if (n3Var != v.n3.MATCH_CONSTRAINT) {
                if (n3Var == v.n3.MATCH_PARENT && (ud3 = this.f3945n3.ud()) != null && ud3.vl() == v.n3.FIXED) {
                    int x42 = (ud3.x4() - this.f3945n3.f11747ud.v()) - this.f3945n3.f11753x.v();
                    n3(this.f3946s, ud3.f11686a.f3946s, this.f3945n3.f11747ud.v());
                    n3(this.f3941c5, ud3.f11686a.f3941c5, -this.f3945n3.f11753x.v());
                    this.f3947v.gv(x42);
                    return;
                } else if (this.f3943gv == v.n3.FIXED) {
                    this.f3947v.gv(this.f3945n3.x4());
                }
            }
        } else if (this.f3943gv == v.n3.MATCH_PARENT && (ud2 = this.f3945n3.ud()) != null && ud2.vl() == v.n3.FIXED) {
            n3(this.f3946s, ud2.f11686a.f3946s, this.f3945n3.f11747ud.v());
            n3(this.f3941c5, ud2.f11686a.f3941c5, -this.f3945n3.f11753x.v());
            return;
        }
        fb fbVar = this.f3947v;
        boolean z2 = fbVar.f3896i9;
        if (z2) {
            n.v vVar2 = this.f3945n3;
            if (vVar2.y) {
                n.gv[] gvVarArr = vVar2.f11710hw;
                n.gv gvVar = gvVarArr[2];
                n.gv gvVar2 = gvVar.f11667a;
                if (gvVar2 != null && gvVarArr[3].f11667a != null) {
                    if (vVar2.u()) {
                        this.f3946s.f3891a = this.f3945n3.f11710hw[2].v();
                        this.f3941c5.f3891a = -this.f3945n3.f11710hw[3].v();
                    } else {
                        a s2 = s(this.f3945n3.f11710hw[2]);
                        if (s2 != null) {
                            n3(this.f3946s, s2, this.f3945n3.f11710hw[2].v());
                        }
                        a s3 = s(this.f3945n3.f11710hw[3]);
                        if (s3 != null) {
                            n3(this.f3941c5, s3, -this.f3945n3.f11710hw[3].v());
                        }
                        this.f3946s.f3897n3 = true;
                        this.f3941c5.f3897n3 = true;
                    }
                    if (this.f3945n3.oz()) {
                        n3(this.f3953f, this.f3946s, this.f3945n3.wz());
                        return;
                    }
                    return;
                } else if (gvVar2 != null) {
                    a s4 = s(gvVar);
                    if (s4 != null) {
                        n3(this.f3946s, s4, this.f3945n3.f11710hw[2].v());
                        n3(this.f3941c5, this.f3946s, this.f3947v.f3894fb);
                        if (this.f3945n3.oz()) {
                            n3(this.f3953f, this.f3946s, this.f3945n3.wz());
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    n.gv gvVar3 = gvVarArr[3];
                    if (gvVar3.f11667a != null) {
                        a s5 = s(gvVar3);
                        if (s5 != null) {
                            n3(this.f3941c5, s5, -this.f3945n3.f11710hw[3].v());
                            n3(this.f3946s, this.f3941c5, -this.f3947v.f3894fb);
                        }
                        if (this.f3945n3.oz()) {
                            n3(this.f3953f, this.f3946s, this.f3945n3.wz());
                            return;
                        }
                        return;
                    }
                    n.gv gvVar4 = gvVarArr[4];
                    if (gvVar4.f11667a != null) {
                        a s7 = s(gvVar4);
                        if (s7 != null) {
                            n3(this.f3953f, s7, 0);
                            n3(this.f3946s, this.f3953f, -this.f3945n3.wz());
                            n3(this.f3941c5, this.f3946s, this.f3947v.f3894fb);
                            return;
                        }
                        return;
                    } else if (!(vVar2 instanceof n.s) && vVar2.ud() != null && this.f3945n3.tl(gv.n3.CENTER).f11667a == null) {
                        n3(this.f3946s, this.f3945n3.ud().f11686a.f3946s, this.f3945n3.j());
                        n3(this.f3941c5, this.f3946s, this.f3947v.f3894fb);
                        if (this.f3945n3.oz()) {
                            n3(this.f3953f, this.f3946s, this.f3945n3.wz());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (!z2 && this.f3943gv == v.n3.MATCH_CONSTRAINT) {
            n.v vVar3 = this.f3945n3;
            int i = vVar3.f11729p;
            if (i != 2) {
                if (i == 3 && !vVar3.u()) {
                    n.v vVar4 = this.f3945n3;
                    if (vVar4.f11751w != 3) {
                        fb fbVar2 = vVar4.f11749v.f3947v;
                        this.f3947v.f3899t.add(fbVar2);
                        fbVar2.f3893f.add(this.f3947v);
                        fb fbVar3 = this.f3947v;
                        fbVar3.f3897n3 = true;
                        fbVar3.f3893f.add(this.f3946s);
                        this.f3947v.f3893f.add(this.f3941c5);
                    }
                }
            } else {
                n.v ud4 = vVar3.ud();
                if (ud4 != null) {
                    fb fbVar4 = ud4.f11686a.f3947v;
                    this.f3947v.f3899t.add(fbVar4);
                    fbVar4.f3893f.add(this.f3947v);
                    fb fbVar5 = this.f3947v;
                    fbVar5.f3897n3 = true;
                    fbVar5.f3893f.add(this.f3946s);
                    this.f3947v.f3893f.add(this.f3941c5);
                }
            }
        } else {
            fbVar.n3(this);
        }
        n.v vVar5 = this.f3945n3;
        n.gv[] gvVarArr2 = vVar5.f11710hw;
        n.gv gvVar5 = gvVarArr2[2];
        n.gv gvVar6 = gvVar5.f11667a;
        if (gvVar6 != null && gvVarArr2[3].f11667a != null) {
            if (vVar5.u()) {
                this.f3946s.f3891a = this.f3945n3.f11710hw[2].v();
                this.f3941c5.f3891a = -this.f3945n3.f11710hw[3].v();
            } else {
                a s9 = s(this.f3945n3.f11710hw[2]);
                a s10 = s(this.f3945n3.f11710hw[3]);
                s9.n3(this);
                s10.n3(this);
                this.f3944i9 = w.n3.CENTER;
            }
            if (this.f3945n3.oz()) {
                zn(this.f3953f, this.f3946s, 1, this.f3954t);
            }
        } else if (gvVar6 != null) {
            a s11 = s(gvVar5);
            if (s11 != null) {
                n3(this.f3946s, s11, this.f3945n3.f11710hw[2].v());
                zn(this.f3941c5, this.f3946s, 1, this.f3947v);
                if (this.f3945n3.oz()) {
                    zn(this.f3953f, this.f3946s, 1, this.f3954t);
                }
                v.n3 n3Var2 = this.f3943gv;
                v.n3 n3Var3 = v.n3.MATCH_CONSTRAINT;
                if (n3Var2 == n3Var3 && this.f3945n3.z() > 0.0f) {
                    t tVar = this.f3945n3.f11749v;
                    if (tVar.f3943gv == n3Var3) {
                        tVar.f3947v.f3893f.add(this.f3947v);
                        this.f3947v.f3899t.add(this.f3945n3.f11749v.f3947v);
                        this.f3947v.y = this;
                    }
                }
            }
        } else {
            n.gv gvVar7 = gvVarArr2[3];
            if (gvVar7.f11667a != null) {
                a s12 = s(gvVar7);
                if (s12 != null) {
                    n3(this.f3941c5, s12, -this.f3945n3.f11710hw[3].v());
                    zn(this.f3946s, this.f3941c5, -1, this.f3947v);
                    if (this.f3945n3.oz()) {
                        zn(this.f3953f, this.f3946s, 1, this.f3954t);
                    }
                }
            } else {
                n.gv gvVar8 = gvVarArr2[4];
                if (gvVar8.f11667a != null) {
                    a s13 = s(gvVar8);
                    if (s13 != null) {
                        n3(this.f3953f, s13, 0);
                        zn(this.f3946s, this.f3953f, -1, this.f3954t);
                        zn(this.f3941c5, this.f3946s, 1, this.f3947v);
                    }
                } else if (!(vVar5 instanceof n.s) && vVar5.ud() != null) {
                    n3(this.f3946s, this.f3945n3.ud().f11686a.f3946s, this.f3945n3.j());
                    zn(this.f3941c5, this.f3946s, 1, this.f3947v);
                    if (this.f3945n3.oz()) {
                        zn(this.f3953f, this.f3946s, 1, this.f3954t);
                    }
                    v.n3 n3Var4 = this.f3943gv;
                    v.n3 n3Var5 = v.n3.MATCH_CONSTRAINT;
                    if (n3Var4 == n3Var5 && this.f3945n3.z() > 0.0f) {
                        t tVar2 = this.f3945n3.f11749v;
                        if (tVar2.f3943gv == n3Var5) {
                            tVar2.f3947v.f3893f.add(this.f3947v);
                            this.f3947v.f3899t.add(this.f3945n3.f11749v.f3947v);
                            this.f3947v.y = this;
                        }
                    }
                }
            }
        }
        if (this.f3947v.f3899t.size() == 0) {
            this.f3947v.f3901zn = true;
        }
    }

    public void p() {
        this.f3942fb = false;
        this.f3946s.zn();
        this.f3946s.f3896i9 = false;
        this.f3941c5.zn();
        this.f3941c5.f3896i9 = false;
        this.f3953f.zn();
        this.f3953f.f3896i9 = false;
        this.f3947v.f3896i9 = false;
    }

    @Override // c.w
    public boolean tl() {
        if (this.f3943gv != v.n3.MATCH_CONSTRAINT || this.f3945n3.f11729p == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "VerticalRun " + this.f3945n3.mt();
    }

    @Override // c.w
    public void v() {
        a aVar = this.f3946s;
        if (aVar.f3896i9) {
            this.f3945n3.ix(aVar.f3894fb);
        }
    }

    @Override // c.w, c.gv
    public void y(gv gvVar) {
        fb fbVar;
        float f4;
        float z2;
        float f6;
        int i;
        n.v vVar;
        int i5 = y.y[this.f3944i9.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    n.v vVar2 = this.f3945n3;
                    wz(gvVar, vVar2.f11747ud, vVar2.f11753x, 1);
                    return;
                }
            } else {
                xc(gvVar);
            }
        } else {
            w(gvVar);
        }
        fb fbVar2 = this.f3947v;
        if (fbVar2.f3901zn && !fbVar2.f3896i9 && this.f3943gv == v.n3.MATCH_CONSTRAINT) {
            n.v vVar3 = this.f3945n3;
            int i6 = vVar3.f11729p;
            if (i6 != 2) {
                if (i6 == 3 && vVar3.f11749v.f3947v.f3896i9) {
                    int r2 = vVar3.r();
                    if (r2 != -1) {
                        if (r2 != 0) {
                            if (r2 != 1) {
                                i = 0;
                                this.f3947v.gv(i);
                            } else {
                                n.v vVar4 = this.f3945n3;
                                f4 = vVar4.f11749v.f3947v.f3894fb;
                                z2 = vVar4.z();
                            }
                        } else {
                            f6 = vVar.f11749v.f3947v.f3894fb * this.f3945n3.z();
                            i = (int) (f6 + 0.5f);
                            this.f3947v.gv(i);
                        }
                    } else {
                        n.v vVar5 = this.f3945n3;
                        f4 = vVar5.f11749v.f3947v.f3894fb;
                        z2 = vVar5.z();
                    }
                    f6 = f4 / z2;
                    i = (int) (f6 + 0.5f);
                    this.f3947v.gv(i);
                }
            } else {
                n.v ud2 = vVar3.ud();
                if (ud2 != null) {
                    if (ud2.f11686a.f3947v.f3896i9) {
                        this.f3947v.gv((int) ((fbVar.f3894fb * this.f3945n3.f11703f3) + 0.5f));
                    }
                }
            }
        }
        a aVar = this.f3946s;
        if (aVar.f3901zn) {
            a aVar2 = this.f3941c5;
            if (aVar2.f3901zn) {
                if (aVar.f3896i9 && aVar2.f3896i9 && this.f3947v.f3896i9) {
                    return;
                }
                if (!this.f3947v.f3896i9 && this.f3943gv == v.n3.MATCH_CONSTRAINT) {
                    n.v vVar6 = this.f3945n3;
                    if (vVar6.f11751w == 0 && !vVar6.u()) {
                        int i8 = this.f3946s.f3899t.get(0).f3894fb;
                        a aVar3 = this.f3946s;
                        int i10 = i8 + aVar3.f3891a;
                        int i11 = this.f3941c5.f3899t.get(0).f3894fb + this.f3941c5.f3891a;
                        aVar3.gv(i10);
                        this.f3941c5.gv(i11);
                        this.f3947v.gv(i11 - i10);
                        return;
                    }
                }
                if (!this.f3947v.f3896i9 && this.f3943gv == v.n3.MATCH_CONSTRAINT && this.y == 1 && this.f3946s.f3899t.size() > 0 && this.f3941c5.f3899t.size() > 0) {
                    int i12 = (this.f3941c5.f3899t.get(0).f3894fb + this.f3941c5.f3891a) - (this.f3946s.f3899t.get(0).f3894fb + this.f3946s.f3891a);
                    fb fbVar3 = this.f3947v;
                    int i13 = fbVar3.f3910tl;
                    if (i12 < i13) {
                        fbVar3.gv(i12);
                    } else {
                        fbVar3.gv(i13);
                    }
                }
                if (this.f3947v.f3896i9 && this.f3946s.f3899t.size() > 0 && this.f3941c5.f3899t.size() > 0) {
                    a aVar4 = this.f3946s.f3899t.get(0);
                    a aVar5 = this.f3941c5.f3899t.get(0);
                    int i14 = aVar4.f3894fb + this.f3946s.f3891a;
                    int i15 = aVar5.f3894fb + this.f3941c5.f3891a;
                    float k52 = this.f3945n3.k5();
                    if (aVar4 == aVar5) {
                        i14 = aVar4.f3894fb;
                        i15 = aVar5.f3894fb;
                        k52 = 0.5f;
                    }
                    this.f3946s.gv((int) (i14 + 0.5f + (((i15 - i14) - this.f3947v.f3894fb) * k52)));
                    this.f3941c5.gv(this.f3946s.f3894fb + this.f3947v.f3894fb);
                }
            }
        }
    }
}
