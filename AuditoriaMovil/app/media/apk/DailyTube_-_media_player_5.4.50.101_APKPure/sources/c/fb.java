package c;

import c.a;
/* loaded from: classes.dex */
public class fb extends a {

    /* renamed from: tl  reason: collision with root package name */
    public int f3910tl;

    public fb(w wVar) {
        super(wVar);
        if (wVar instanceof t) {
            this.f3900v = a.y.HORIZONTAL_DIMENSION;
        } else {
            this.f3900v = a.y.VERTICAL_DIMENSION;
        }
    }

    @Override // c.a
    public void gv(int i) {
        if (this.f3896i9) {
            return;
        }
        this.f3896i9 = true;
        this.f3894fb = i;
        for (gv gvVar : this.f3893f) {
            gvVar.y(gvVar);
        }
    }
}
