package c;

import c.a;
/* loaded from: classes.dex */
public class f extends w {
    public f(n.v vVar) {
        super(vVar);
    }

    private void p(a aVar) {
        this.f3946s.f3893f.add(aVar);
        aVar.f3899t.add(this.f3946s);
    }

    @Override // c.w
    public void a() {
        this.f3948zn = null;
        this.f3946s.zn();
    }

    @Override // c.w
    public void gv() {
        n.v vVar = this.f3945n3;
        if (vVar instanceof n.y) {
            this.f3946s.f3897n3 = true;
            n.y yVar = (n.y) vVar;
            int wm2 = yVar.wm();
            boolean q2 = yVar.q();
            int i = 0;
            if (wm2 != 0) {
                if (wm2 != 1) {
                    if (wm2 != 2) {
                        if (wm2 == 3) {
                            this.f3946s.f3900v = a.y.BOTTOM;
                            while (i < yVar.f11657xb) {
                                n.v vVar2 = yVar.f11656o0[i];
                                if (q2 || vVar2.j5() != 8) {
                                    a aVar = vVar2.f11686a.f3941c5;
                                    aVar.f3893f.add(this.f3946s);
                                    this.f3946s.f3899t.add(aVar);
                                }
                                i++;
                            }
                            p(this.f3945n3.f11686a.f3946s);
                            p(this.f3945n3.f11686a.f3941c5);
                            return;
                        }
                        return;
                    }
                    this.f3946s.f3900v = a.y.TOP;
                    while (i < yVar.f11657xb) {
                        n.v vVar3 = yVar.f11656o0[i];
                        if (q2 || vVar3.j5() != 8) {
                            a aVar2 = vVar3.f11686a.f3946s;
                            aVar2.f3893f.add(this.f3946s);
                            this.f3946s.f3899t.add(aVar2);
                        }
                        i++;
                    }
                    p(this.f3945n3.f11686a.f3946s);
                    p(this.f3945n3.f11686a.f3941c5);
                    return;
                }
                this.f3946s.f3900v = a.y.RIGHT;
                while (i < yVar.f11657xb) {
                    n.v vVar4 = yVar.f11656o0[i];
                    if (q2 || vVar4.j5() != 8) {
                        a aVar3 = vVar4.f11749v.f3941c5;
                        aVar3.f3893f.add(this.f3946s);
                        this.f3946s.f3899t.add(aVar3);
                    }
                    i++;
                }
                p(this.f3945n3.f11749v.f3946s);
                p(this.f3945n3.f11749v.f3941c5);
                return;
            }
            this.f3946s.f3900v = a.y.LEFT;
            while (i < yVar.f11657xb) {
                n.v vVar5 = yVar.f11656o0[i];
                if (q2 || vVar5.j5() != 8) {
                    a aVar4 = vVar5.f11749v.f3946s;
                    aVar4.f3893f.add(this.f3946s);
                    this.f3946s.f3899t.add(aVar4);
                }
                i++;
            }
            p(this.f3945n3.f11749v.f3946s);
            p(this.f3945n3.f11749v.f3941c5);
        }
    }

    @Override // c.w
    public boolean tl() {
        return false;
    }

    @Override // c.w
    public void v() {
        n.v vVar = this.f3945n3;
        if (vVar instanceof n.y) {
            int wm2 = ((n.y) vVar).wm();
            if (wm2 != 0 && wm2 != 1) {
                this.f3945n3.ix(this.f3946s.f3894fb);
            } else {
                this.f3945n3.ro(this.f3946s.f3894fb);
            }
        }
    }

    @Override // c.w, c.gv
    public void y(gv gvVar) {
        n.y yVar = (n.y) this.f3945n3;
        int wm2 = yVar.wm();
        int i = 0;
        int i5 = -1;
        for (a aVar : this.f3946s.f3899t) {
            int i6 = aVar.f3894fb;
            if (i5 == -1 || i6 < i5) {
                i5 = i6;
            }
            if (i < i6) {
                i = i6;
            }
        }
        if (wm2 != 0 && wm2 != 2) {
            this.f3946s.gv(i + yVar.nd());
        } else {
            this.f3946s.gv(i5 + yVar.nd());
        }
    }
}
