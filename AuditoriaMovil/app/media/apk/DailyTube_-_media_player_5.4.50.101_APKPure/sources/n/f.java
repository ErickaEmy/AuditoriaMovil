package n;

import c.n3;
/* loaded from: classes.dex */
public class f extends c5 {

    /* renamed from: ad  reason: collision with root package name */
    public n3.y f11658ad = new n3.y();

    /* renamed from: cy  reason: collision with root package name */
    public n3.InterfaceC0040n3 f11659cy = null;

    /* renamed from: wf  reason: collision with root package name */
    public boolean f11660wf;

    public void ne() {
        for (int i = 0; i < this.f11657xb; i++) {
            v vVar = this.f11656o0[i];
            if (vVar != null) {
                vVar.xb(true);
            }
        }
    }

    public boolean q() {
        return this.f11660wf;
    }

    @Override // n.c5, n.s
    public void y(a aVar) {
        ne();
    }
}
