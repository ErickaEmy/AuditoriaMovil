package a7;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public class zn extends tl {

    /* renamed from: fb  reason: collision with root package name */
    public final v f42fb;

    /* renamed from: s  reason: collision with root package name */
    public final List<v> f43s = new ArrayList();

    /* renamed from: v  reason: collision with root package name */
    public boolean f44v;

    public zn(v vVar) {
        this.f42fb = vVar;
        ((gv) vVar).f3(this);
    }

    @Override // a7.tl, a7.fb
    public void a(@NonNull v vVar, int i) {
        if (k5(vVar)) {
            super.a(vVar, i);
        }
    }

    @Override // a7.tl, a7.fb
    public void c5() {
        if (this.f44v) {
            super.c5();
        }
    }

    @Override // a7.tl
    public int d0(@NonNull v vVar) {
        if (vVar == this.f42fb) {
            return 0;
        }
        int indexOf = this.f43s.indexOf(vVar);
        if (indexOf >= 0) {
            return indexOf + 1;
        }
        return -1;
    }

    @Override // a7.tl, a7.fb
    public void f(@NonNull v vVar, int i, int i5) {
        if (k5(vVar)) {
            super.f(vVar, i, i5);
        }
    }

    public void hw() {
        int r2 = r();
        this.f44v = !this.f44v;
        int r3 = r();
        if (r2 > r3) {
            ud(r3, r2 - r3);
        } else {
            z6(r2, r3 - r2);
        }
    }

    @Override // a7.tl
    public int i4() {
        int i;
        if (this.f44v) {
            i = this.f43s.size();
        } else {
            i = 0;
        }
        return i + 1;
    }

    @Override // a7.tl, a7.fb
    public void i9(@NonNull v vVar, int i, int i5, Object obj) {
        if (k5(vVar)) {
            super.i9(vVar, i, i5, obj);
        }
    }

    public void j5(boolean z2) {
        if (this.f44v != z2) {
            hw();
        }
    }

    public final boolean k5(v vVar) {
        if (!this.f44v && vVar != this.f42fb) {
            return false;
        }
        return true;
    }

    @Override // a7.tl
    public void mt(@NonNull Collection<? extends v> collection) {
        if (collection.isEmpty()) {
            return;
        }
        super.mt(collection);
        if (this.f44v) {
            int r2 = r();
            this.f43s.addAll(collection);
            z6(r2, s.n3(collection));
            return;
        }
        this.f43s.addAll(collection);
    }

    @Override // a7.tl
    public void p(@NonNull v vVar) {
        super.p(vVar);
        if (this.f44v) {
            int r2 = r();
            this.f43s.add(vVar);
            z6(r2, vVar.r());
            return;
        }
        this.f43s.add(vVar);
    }

    @Override // a7.tl, a7.fb
    public void s(@NonNull v vVar, int i, int i5) {
        if (k5(vVar)) {
            super.s(vVar, i, i5);
        }
    }

    public boolean vl() {
        return this.f44v;
    }

    @Override // a7.tl, a7.fb
    public void wz(@NonNull v vVar, int i, int i5) {
        if (k5(vVar)) {
            super.wz(vVar, i, i5);
        }
    }

    @Override // a7.tl, a7.fb
    public void xc(@NonNull v vVar, int i, Object obj) {
        if (k5(vVar)) {
            super.xc(vVar, i, obj);
        }
    }

    public int yt() {
        return this.f43s.size();
    }

    @Override // a7.tl
    @NonNull
    public v z(int i) {
        if (i == 0) {
            return this.f42fb;
        }
        return this.f43s.get(i - 1);
    }

    public zn(v vVar, boolean z2) {
        this.f42fb = vVar;
        ((gv) vVar).f3(this);
        this.f44v = z2;
    }
}
