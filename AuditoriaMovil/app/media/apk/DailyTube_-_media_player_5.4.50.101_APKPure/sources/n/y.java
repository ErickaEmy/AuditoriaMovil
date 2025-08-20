package n;

import n.gv;
import n.v;
/* loaded from: classes.dex */
public class y extends c5 {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f11770ad = true;

    /* renamed from: cy  reason: collision with root package name */
    public int f11771cy;

    /* renamed from: qk  reason: collision with root package name */
    public boolean f11772qk;

    /* renamed from: wf  reason: collision with root package name */
    public int f11773wf;

    public void br(int i) {
        this.f11773wf = i;
    }

    public void bv() {
        for (int i = 0; i < this.f11657xb; i++) {
            v vVar = this.f11656o0[i];
            int i5 = this.f11773wf;
            if (i5 != 0 && i5 != 1) {
                if (i5 == 2 || i5 == 3) {
                    vVar.cr(1, true);
                }
            } else {
                vVar.cr(0, true);
            }
        }
    }

    @Override // n.v
    public boolean ct() {
        return this.f11772qk;
    }

    @Override // n.v
    public boolean dm() {
        return this.f11772qk;
    }

    @Override // n.v
    public void fb(f3.gv gvVar, boolean z2) {
        gv[] gvVarArr;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        int i;
        int i5;
        int i6;
        int i8;
        int i10;
        gv[] gvVarArr2 = this.f11710hw;
        gvVarArr2[0] = this.f11700ej;
        gvVarArr2[2] = this.f11747ud;
        gvVarArr2[1] = this.f11687a8;
        gvVarArr2[3] = this.f11753x;
        int i11 = 0;
        while (true) {
            gvVarArr = this.f11710hw;
            if (i11 >= gvVarArr.length) {
                break;
            }
            gv gvVar2 = gvVarArr[i11];
            gvVar2.f11668c5 = gvVar.p(gvVar2);
            i11++;
        }
        int i12 = this.f11773wf;
        if (i12 >= 0 && i12 < 4) {
            gv gvVar3 = gvVarArr[i12];
            if (!this.f11772qk) {
                ne();
            }
            if (this.f11772qk) {
                this.f11772qk = false;
                int i13 = this.f11773wf;
                if (i13 != 0 && i13 != 1) {
                    if (i13 == 2 || i13 == 3) {
                        gvVar.a(this.f11747ud.f11668c5, this.f11701en);
                        gvVar.a(this.f11753x.f11668c5, this.f11701en);
                        return;
                    }
                    return;
                }
                gvVar.a(this.f11700ej.f11668c5, this.f11704f7);
                gvVar.a(this.f11687a8.f11668c5, this.f11704f7);
                return;
            }
            for (int i14 = 0; i14 < this.f11657xb; i14++) {
                v vVar = this.f11656o0[i14];
                if ((this.f11770ad || vVar.s()) && ((((i8 = this.f11773wf) == 0 || i8 == 1) && vVar.n() == v.n3.MATCH_CONSTRAINT && vVar.f11700ej.f11667a != null && vVar.f11687a8.f11667a != null) || (((i10 = this.f11773wf) == 2 || i10 == 3) && vVar.vl() == v.n3.MATCH_CONSTRAINT && vVar.f11747ud.f11667a != null && vVar.f11753x.f11667a != null))) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
            if (!this.f11700ej.f() && !this.f11687a8.f()) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!this.f11747ud.f() && !this.f11753x.f()) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (!z3 && (((i6 = this.f11773wf) == 0 && z4) || ((i6 == 2 && z5) || ((i6 == 1 && z4) || (i6 == 3 && z5))))) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                i = 4;
            } else {
                i = 5;
            }
            for (int i15 = 0; i15 < this.f11657xb; i15++) {
                v vVar2 = this.f11656o0[i15];
                if (this.f11770ad || vVar2.s()) {
                    f3.c5 p2 = gvVar.p(vVar2.f11710hw[this.f11773wf]);
                    gv[] gvVarArr3 = vVar2.f11710hw;
                    int i16 = this.f11773wf;
                    gv gvVar4 = gvVarArr3[i16];
                    gvVar4.f11668c5 = p2;
                    gv gvVar5 = gvVar4.f11667a;
                    if (gvVar5 != null && gvVar5.f11670gv == this) {
                        i5 = gvVar4.f11669fb;
                    } else {
                        i5 = 0;
                    }
                    if (i16 != 0 && i16 != 2) {
                        gvVar.fb(gvVar3.f11668c5, p2, this.f11771cy + i5, z3);
                    } else {
                        gvVar.c5(gvVar3.f11668c5, p2, this.f11771cy - i5, z3);
                    }
                    gvVar.v(gvVar3.f11668c5, p2, this.f11771cy + i5, i);
                }
            }
            int i17 = this.f11773wf;
            if (i17 == 0) {
                gvVar.v(this.f11687a8.f11668c5, this.f11700ej.f11668c5, 0, 8);
                gvVar.v(this.f11700ej.f11668c5, this.f11713j.f11687a8.f11668c5, 0, 4);
                gvVar.v(this.f11700ej.f11668c5, this.f11713j.f11700ej.f11668c5, 0, 0);
            } else if (i17 == 1) {
                gvVar.v(this.f11700ej.f11668c5, this.f11687a8.f11668c5, 0, 8);
                gvVar.v(this.f11700ej.f11668c5, this.f11713j.f11700ej.f11668c5, 0, 4);
                gvVar.v(this.f11700ej.f11668c5, this.f11713j.f11687a8.f11668c5, 0, 0);
            } else if (i17 == 2) {
                gvVar.v(this.f11753x.f11668c5, this.f11747ud.f11668c5, 0, 8);
                gvVar.v(this.f11747ud.f11668c5, this.f11713j.f11753x.f11668c5, 0, 4);
                gvVar.v(this.f11747ud.f11668c5, this.f11713j.f11747ud.f11668c5, 0, 0);
            } else if (i17 == 3) {
                gvVar.v(this.f11747ud.f11668c5, this.f11753x.f11668c5, 0, 8);
                gvVar.v(this.f11747ud.f11668c5, this.f11713j.f11747ud.f11668c5, 0, 4);
                gvVar.v(this.f11747ud.f11668c5, this.f11713j.f11753x.f11668c5, 0, 0);
            }
        }
    }

    public void fc(boolean z2) {
        this.f11770ad = z2;
    }

    public int gf() {
        int i = this.f11773wf;
        if (i != 0 && i != 1) {
            if (i == 2 || i == 3) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public int nd() {
        return this.f11771cy;
    }

    public boolean ne() {
        int i;
        int i5;
        int i6;
        int i8 = 0;
        boolean z2 = true;
        while (true) {
            i = this.f11657xb;
            if (i8 >= i) {
                break;
            }
            v vVar = this.f11656o0[i8];
            if ((this.f11770ad || vVar.s()) && ((((i5 = this.f11773wf) == 0 || i5 == 1) && !vVar.dm()) || (((i6 = this.f11773wf) == 2 || i6 == 3) && !vVar.ct()))) {
                z2 = false;
            }
            i8++;
        }
        if (!z2 || i <= 0) {
            return false;
        }
        int i10 = 0;
        boolean z3 = false;
        for (int i11 = 0; i11 < this.f11657xb; i11++) {
            v vVar2 = this.f11656o0[i11];
            if (this.f11770ad || vVar2.s()) {
                if (!z3) {
                    int i12 = this.f11773wf;
                    if (i12 == 0) {
                        i10 = vVar2.tl(gv.n3.LEFT).gv();
                    } else if (i12 == 1) {
                        i10 = vVar2.tl(gv.n3.RIGHT).gv();
                    } else if (i12 == 2) {
                        i10 = vVar2.tl(gv.n3.TOP).gv();
                    } else if (i12 == 3) {
                        i10 = vVar2.tl(gv.n3.BOTTOM).gv();
                    }
                    z3 = true;
                }
                int i13 = this.f11773wf;
                if (i13 == 0) {
                    i10 = Math.min(i10, vVar2.tl(gv.n3.LEFT).gv());
                } else if (i13 == 1) {
                    i10 = Math.max(i10, vVar2.tl(gv.n3.RIGHT).gv());
                } else if (i13 == 2) {
                    i10 = Math.min(i10, vVar2.tl(gv.n3.TOP).gv());
                } else if (i13 == 3) {
                    i10 = Math.max(i10, vVar2.tl(gv.n3.BOTTOM).gv());
                }
            }
        }
        int i14 = i10 + this.f11771cy;
        int i15 = this.f11773wf;
        if (i15 != 0 && i15 != 1) {
            rb(i14, i14);
        } else {
            yg(i14, i14);
        }
        this.f11772qk = true;
        return true;
    }

    public boolean q() {
        return this.f11770ad;
    }

    @Override // n.v
    public boolean s() {
        return true;
    }

    @Override // n.v
    public String toString() {
        String str = "[Barrier] " + mt() + " {";
        for (int i = 0; i < this.f11657xb; i++) {
            v vVar = this.f11656o0[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + vVar.mt();
        }
        return str + "}";
    }

    public void uo(int i) {
        this.f11771cy = i;
    }

    public int wm() {
        return this.f11773wf;
    }
}
