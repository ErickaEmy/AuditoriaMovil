package n;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends v {

    /* renamed from: o0  reason: collision with root package name */
    public ArrayList<v> f11684o0 = new ArrayList<>();

    public void j3() {
        ArrayList<v> arrayList = this.f11684o0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            v vVar = this.f11684o0.get(i);
            if (vVar instanceof t) {
                ((t) vVar).j3();
            }
        }
    }

    @Override // n.v
    public void lc(f3.zn znVar) {
        super.lc(znVar);
        int size = this.f11684o0.size();
        for (int i = 0; i < size; i++) {
            this.f11684o0.get(i).lc(znVar);
        }
    }

    public void n3(v vVar) {
        this.f11684o0.add(vVar);
        if (vVar.ud() != null) {
            ((t) vVar.ud()).ne(vVar);
        }
        vVar.vp(this);
    }

    public void ne(v vVar) {
        this.f11684o0.remove(vVar);
        vVar.rs();
    }

    public void q() {
        this.f11684o0.clear();
    }

    @Override // n.v
    public void rs() {
        this.f11684o0.clear();
        super.rs();
    }

    public ArrayList<v> vn() {
        return this.f11684o0;
    }
}
