package c;

import c.a;
import c.w;
import n.gv;
import n.v;
/* loaded from: classes.dex */
public class t extends w {

    /* renamed from: f  reason: collision with root package name */
    public static int[] f3925f = new int[2];

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

    public t(n.v vVar) {
        super(vVar);
        this.f3946s.f3900v = a.y.LEFT;
        this.f3941c5.f3900v = a.y.RIGHT;
    }

    @Override // c.w
    public void a() {
        this.f3948zn = null;
        this.f3946s.zn();
        this.f3941c5.zn();
        this.f3947v.zn();
        this.f3942fb = false;
    }

    @Override // c.w
    public void gv() {
        n.v ud2;
        n.v ud3;
        n.v vVar = this.f3945n3;
        if (vVar.y) {
            this.f3947v.gv(vVar.qn());
        }
        if (!this.f3947v.f3896i9) {
            v.n3 n2 = this.f3945n3.n();
            this.f3943gv = n2;
            if (n2 != v.n3.MATCH_CONSTRAINT) {
                v.n3 n3Var = v.n3.MATCH_PARENT;
                if (n2 == n3Var && (((ud3 = this.f3945n3.ud()) != null && ud3.n() == v.n3.FIXED) || ud3.n() == n3Var)) {
                    int qn2 = (ud3.qn() - this.f3945n3.f11700ej.v()) - this.f3945n3.f11687a8.v();
                    n3(this.f3946s, ud3.f11749v.f3946s, this.f3945n3.f11700ej.v());
                    n3(this.f3941c5, ud3.f11749v.f3941c5, -this.f3945n3.f11687a8.v());
                    this.f3947v.gv(qn2);
                    return;
                } else if (this.f3943gv == v.n3.FIXED) {
                    this.f3947v.gv(this.f3945n3.qn());
                }
            }
        } else {
            v.n3 n3Var2 = this.f3943gv;
            v.n3 n3Var3 = v.n3.MATCH_PARENT;
            if (n3Var2 == n3Var3 && (((ud2 = this.f3945n3.ud()) != null && ud2.n() == v.n3.FIXED) || ud2.n() == n3Var3)) {
                n3(this.f3946s, ud2.f11749v.f3946s, this.f3945n3.f11700ej.v());
                n3(this.f3941c5, ud2.f11749v.f3941c5, -this.f3945n3.f11687a8.v());
                return;
            }
        }
        fb fbVar = this.f3947v;
        if (fbVar.f3896i9) {
            n.v vVar2 = this.f3945n3;
            if (vVar2.y) {
                n.gv[] gvVarArr = vVar2.f11710hw;
                n.gv gvVar = gvVarArr[0];
                n.gv gvVar2 = gvVar.f11667a;
                if (gvVar2 != null && gvVarArr[1].f11667a != null) {
                    if (vVar2.en()) {
                        this.f3946s.f3891a = this.f3945n3.f11710hw[0].v();
                        this.f3941c5.f3891a = -this.f3945n3.f11710hw[1].v();
                        return;
                    }
                    a s2 = s(this.f3945n3.f11710hw[0]);
                    if (s2 != null) {
                        n3(this.f3946s, s2, this.f3945n3.f11710hw[0].v());
                    }
                    a s3 = s(this.f3945n3.f11710hw[1]);
                    if (s3 != null) {
                        n3(this.f3941c5, s3, -this.f3945n3.f11710hw[1].v());
                    }
                    this.f3946s.f3897n3 = true;
                    this.f3941c5.f3897n3 = true;
                    return;
                } else if (gvVar2 != null) {
                    a s4 = s(gvVar);
                    if (s4 != null) {
                        n3(this.f3946s, s4, this.f3945n3.f11710hw[0].v());
                        n3(this.f3941c5, this.f3946s, this.f3947v.f3894fb);
                        return;
                    }
                    return;
                } else {
                    n.gv gvVar3 = gvVarArr[1];
                    if (gvVar3.f11667a != null) {
                        a s5 = s(gvVar3);
                        if (s5 != null) {
                            n3(this.f3941c5, s5, -this.f3945n3.f11710hw[1].v());
                            n3(this.f3946s, this.f3941c5, -this.f3947v.f3894fb);
                            return;
                        }
                        return;
                    } else if (!(vVar2 instanceof n.s) && vVar2.ud() != null && this.f3945n3.tl(gv.n3.CENTER).f11667a == null) {
                        n3(this.f3946s, this.f3945n3.ud().f11749v.f3946s, this.f3945n3.o());
                        n3(this.f3941c5, this.f3946s, this.f3947v.f3894fb);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (this.f3943gv == v.n3.MATCH_CONSTRAINT) {
            n.v vVar3 = this.f3945n3;
            int i = vVar3.f11751w;
            if (i != 2) {
                if (i == 3) {
                    if (vVar3.f11729p == 3) {
                        this.f3946s.y = this;
                        this.f3941c5.y = this;
                        wz wzVar = vVar3.f11686a;
                        wzVar.f3946s.y = this;
                        wzVar.f3941c5.y = this;
                        fbVar.y = this;
                        if (vVar3.u()) {
                            this.f3947v.f3899t.add(this.f3945n3.f11686a.f3947v);
                            this.f3945n3.f11686a.f3947v.f3893f.add(this.f3947v);
                            wz wzVar2 = this.f3945n3.f11686a;
                            wzVar2.f3947v.y = this;
                            this.f3947v.f3899t.add(wzVar2.f3946s);
                            this.f3947v.f3899t.add(this.f3945n3.f11686a.f3941c5);
                            this.f3945n3.f11686a.f3946s.f3893f.add(this.f3947v);
                            this.f3945n3.f11686a.f3941c5.f3893f.add(this.f3947v);
                        } else if (this.f3945n3.en()) {
                            this.f3945n3.f11686a.f3947v.f3899t.add(this.f3947v);
                            this.f3947v.f3893f.add(this.f3945n3.f11686a.f3947v);
                        } else {
                            this.f3945n3.f11686a.f3947v.f3899t.add(this.f3947v);
                        }
                    } else {
                        fb fbVar2 = vVar3.f11686a.f3947v;
                        fbVar.f3899t.add(fbVar2);
                        fbVar2.f3893f.add(this.f3947v);
                        this.f3945n3.f11686a.f3946s.f3893f.add(this.f3947v);
                        this.f3945n3.f11686a.f3941c5.f3893f.add(this.f3947v);
                        fb fbVar3 = this.f3947v;
                        fbVar3.f3897n3 = true;
                        fbVar3.f3893f.add(this.f3946s);
                        this.f3947v.f3893f.add(this.f3941c5);
                        this.f3946s.f3899t.add(this.f3947v);
                        this.f3941c5.f3899t.add(this.f3947v);
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
        }
        n.v vVar4 = this.f3945n3;
        n.gv[] gvVarArr2 = vVar4.f11710hw;
        n.gv gvVar4 = gvVarArr2[0];
        n.gv gvVar5 = gvVar4.f11667a;
        if (gvVar5 != null && gvVarArr2[1].f11667a != null) {
            if (vVar4.en()) {
                this.f3946s.f3891a = this.f3945n3.f11710hw[0].v();
                this.f3941c5.f3891a = -this.f3945n3.f11710hw[1].v();
                return;
            }
            a s7 = s(this.f3945n3.f11710hw[0]);
            a s9 = s(this.f3945n3.f11710hw[1]);
            s7.n3(this);
            s9.n3(this);
            this.f3944i9 = w.n3.CENTER;
        } else if (gvVar5 != null) {
            a s10 = s(gvVar4);
            if (s10 != null) {
                n3(this.f3946s, s10, this.f3945n3.f11710hw[0].v());
                zn(this.f3941c5, this.f3946s, 1, this.f3947v);
            }
        } else {
            n.gv gvVar6 = gvVarArr2[1];
            if (gvVar6.f11667a != null) {
                a s11 = s(gvVar6);
                if (s11 != null) {
                    n3(this.f3941c5, s11, -this.f3945n3.f11710hw[1].v());
                    zn(this.f3946s, this.f3941c5, -1, this.f3947v);
                }
            } else if (!(vVar4 instanceof n.s) && vVar4.ud() != null) {
                n3(this.f3946s, this.f3945n3.ud().f11749v.f3946s, this.f3945n3.o());
                zn(this.f3941c5, this.f3946s, 1, this.f3947v);
            }
        }
    }

    public void mt() {
        this.f3942fb = false;
        this.f3946s.zn();
        this.f3946s.f3896i9 = false;
        this.f3941c5.zn();
        this.f3941c5.f3896i9 = false;
        this.f3947v.f3896i9 = false;
    }

    public final void p(int[] iArr, int i, int i5, int i6, int i8, float f4, int i10) {
        int i11 = i5 - i;
        int i12 = i8 - i6;
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 == 1) {
                    iArr[0] = i11;
                    iArr[1] = (int) ((i11 * f4) + 0.5f);
                    return;
                }
                return;
            }
            iArr[0] = (int) ((i12 * f4) + 0.5f);
            iArr[1] = i12;
            return;
        }
        int i13 = (int) ((i12 * f4) + 0.5f);
        int i14 = (int) ((i11 / f4) + 0.5f);
        if (i13 <= i11) {
            iArr[0] = i13;
            iArr[1] = i12;
        } else if (i14 <= i12) {
            iArr[0] = i11;
            iArr[1] = i14;
        }
    }

    @Override // c.w
    public boolean tl() {
        if (this.f3943gv != v.n3.MATCH_CONSTRAINT || this.f3945n3.f11751w == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "HorizontalRun " + this.f3945n3.mt();
    }

    @Override // c.w
    public void v() {
        a aVar = this.f3946s;
        if (aVar.f3896i9) {
            this.f3945n3.ro(aVar.f3894fb);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x02bd, code lost:
        if (r14 != 1) goto L131;
     */
    @Override // c.w, c.gv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(c.gv r17) {
        /*
            Method dump skipped, instructions count: 1096
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.y(c.gv):void");
    }
}
