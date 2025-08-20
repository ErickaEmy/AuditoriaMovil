package c;
/* loaded from: classes.dex */
public class i9 extends w {
    public i9(n.v vVar) {
        super(vVar);
        vVar.f11749v.a();
        vVar.f11686a.a();
        this.f3940a = ((n.fb) vVar).j3();
    }

    @Override // c.w
    public void a() {
        this.f3946s.zn();
    }

    @Override // c.w
    public void gv() {
        n.fb fbVar = (n.fb) this.f3945n3;
        int ne2 = fbVar.ne();
        int q2 = fbVar.q();
        fbVar.wm();
        if (fbVar.j3() == 1) {
            if (ne2 != -1) {
                this.f3946s.f3899t.add(this.f3945n3.f11713j.f11749v.f3946s);
                this.f3945n3.f11713j.f11749v.f3946s.f3893f.add(this.f3946s);
                this.f3946s.f3891a = ne2;
            } else if (q2 != -1) {
                this.f3946s.f3899t.add(this.f3945n3.f11713j.f11749v.f3941c5);
                this.f3945n3.f11713j.f11749v.f3941c5.f3893f.add(this.f3946s);
                this.f3946s.f3891a = -q2;
            } else {
                a aVar = this.f3946s;
                aVar.f3897n3 = true;
                aVar.f3899t.add(this.f3945n3.f11713j.f11749v.f3941c5);
                this.f3945n3.f11713j.f11749v.f3941c5.f3893f.add(this.f3946s);
            }
            p(this.f3945n3.f11749v.f3946s);
            p(this.f3945n3.f11749v.f3941c5);
            return;
        }
        if (ne2 != -1) {
            this.f3946s.f3899t.add(this.f3945n3.f11713j.f11686a.f3946s);
            this.f3945n3.f11713j.f11686a.f3946s.f3893f.add(this.f3946s);
            this.f3946s.f3891a = ne2;
        } else if (q2 != -1) {
            this.f3946s.f3899t.add(this.f3945n3.f11713j.f11686a.f3941c5);
            this.f3945n3.f11713j.f11686a.f3941c5.f3893f.add(this.f3946s);
            this.f3946s.f3891a = -q2;
        } else {
            a aVar2 = this.f3946s;
            aVar2.f3897n3 = true;
            aVar2.f3899t.add(this.f3945n3.f11713j.f11686a.f3941c5);
            this.f3945n3.f11713j.f11686a.f3941c5.f3893f.add(this.f3946s);
        }
        p(this.f3945n3.f11686a.f3946s);
        p(this.f3945n3.f11686a.f3941c5);
    }

    public final void p(a aVar) {
        this.f3946s.f3893f.add(aVar);
        aVar.f3899t.add(this.f3946s);
    }

    @Override // c.w
    public boolean tl() {
        return false;
    }

    @Override // c.w
    public void v() {
        if (((n.fb) this.f3945n3).j3() == 1) {
            this.f3945n3.ro(this.f3946s.f3894fb);
        } else {
            this.f3945n3.ix(this.f3946s.f3894fb);
        }
    }

    @Override // c.w, c.gv
    public void y(gv gvVar) {
        a aVar = this.f3946s;
        if (!aVar.f3901zn || aVar.f3896i9) {
            return;
        }
        this.f3946s.gv((int) ((aVar.f3899t.get(0).f3894fb * ((n.fb) this.f3945n3).wm()) + 0.5f));
    }
}
