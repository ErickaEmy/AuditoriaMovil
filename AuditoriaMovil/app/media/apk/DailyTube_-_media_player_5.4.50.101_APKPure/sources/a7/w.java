package a7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.gv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public class w extends tl {

    /* renamed from: co  reason: collision with root package name */
    public kp.n3 f34co;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<v> f35f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public v f36fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f37p;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public v f38s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f39t;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public v f40v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f41w;

    /* loaded from: classes.dex */
    public class y implements kp.n3 {
        public y() {
        }

        @Override // kp.n3
        public void gv(int i, int i5) {
            int j2 = w.this.j();
            w.this.rz(i + j2, j2 + i5);
        }

        @Override // kp.n3
        public void n3(int i, int i5) {
            w wVar = w.this;
            wVar.ud(wVar.j() + i, i5);
        }

        @Override // kp.n3
        public void y(int i, int i5) {
            w wVar = w.this;
            wVar.z6(wVar.j() + i, i5);
        }

        @Override // kp.n3
        public void zn(int i, int i5, Object obj) {
            w wVar = w.this;
            wVar.d(wVar.j() + i, i5, obj);
        }
    }

    public w() {
        this(null, new ArrayList());
    }

    @Override // a7.tl
    public void a8(@NonNull v vVar) {
        super.a8(vVar);
        int c2 = c(vVar);
        this.f35f.remove(vVar);
        ud(c2, vVar.r());
        dm();
    }

    @Override // a7.tl
    public void b(@NonNull Collection<? extends v> collection) {
        if (collection.isEmpty()) {
            return;
        }
        super.b(collection);
        this.f35f.clear();
        this.f35f.addAll(collection);
        fh();
        dm();
    }

    public void ct() {
        v vVar = this.f40v;
        if (vVar == null) {
            return;
        }
        vVar.co(this);
        int j2 = j();
        this.f40v = null;
        xg(j2);
    }

    @Override // a7.tl
    public int d0(@NonNull v vVar) {
        if (u() && vVar == this.f40v) {
            return 0;
        }
        int o2 = o();
        if (y5() && vVar == this.f38s) {
            return o2;
        }
        int ut2 = o2 + ut();
        int indexOf = this.f35f.indexOf(vVar);
        if (indexOf >= 0) {
            return ut2 + indexOf;
        }
        int size = ut2 + this.f35f.size();
        if (jz() && this.f36fb == vVar) {
            return size;
        }
        return -1;
    }

    public void dm() {
        if (en()) {
            if (this.f39t) {
                k();
                return;
            }
            nf();
            lc();
            return;
        }
        f7();
        lc();
    }

    public void e(@NonNull Collection<? extends v> collection, gv.v vVar) {
        super.x(this.f35f);
        this.f35f.clear();
        this.f35f.addAll(collection);
        super.mt(collection);
        vVar.n3(this.f34co);
        dm();
    }

    public void eb(@NonNull v vVar) {
        if (vVar != null) {
            if (this.f38s != null) {
                o4();
            }
            this.f38s = vVar;
            dm();
            return;
        }
        throw new NullPointerException("Placeholder can't be null.  Please use removePlaceholder() instead!");
    }

    public boolean en() {
        if (!this.f35f.isEmpty() && s.n3(this.f35f) != 0) {
            return false;
        }
        return true;
    }

    @Override // a7.tl, a7.fb
    public void f(@NonNull v vVar, int i, int i5) {
        super.f(vVar, i, i5);
        dm();
    }

    public final void f7() {
        if (this.f37p && this.f38s != null) {
            this.f37p = false;
            ud(j(), this.f38s.r());
        }
    }

    public final int hw() {
        if (this.f36fb != null && this.f41w) {
            return 1;
        }
        return 0;
    }

    @Override // a7.tl
    public int i4() {
        return o() + hw() + ut() + this.f35f.size();
    }

    public final int j() {
        if (o() == 0) {
            return 0;
        }
        return this.f40v.r();
    }

    public final int j5() {
        if (hw() == 0) {
            return 0;
        }
        return this.f36fb.r();
    }

    public final boolean jz() {
        if (hw() > 0) {
            return true;
        }
        return false;
    }

    public final void k() {
        if (!this.f41w && !this.f37p) {
            return;
        }
        this.f41w = false;
        this.f37p = false;
        ud(0, j() + q9() + j5());
    }

    public final void lc() {
        if (this.f41w) {
            return;
        }
        this.f41w = true;
        z6(0, j());
        z6(oz(), j5());
    }

    @Override // a7.tl
    public void mt(@NonNull Collection<? extends v> collection) {
        if (collection.isEmpty()) {
            return;
        }
        super.mt(collection);
        int oz2 = oz();
        this.f35f.addAll(collection);
        z6(oz2, s.n3(collection));
        dm();
    }

    public final void nf() {
        if (!this.f37p && this.f38s != null) {
            this.f37p = true;
            z6(j(), this.f38s.r());
        }
    }

    public final int o() {
        if (this.f40v != null && this.f41w) {
            return 1;
        }
        return 0;
    }

    public void o4() {
        f7();
        this.f38s = null;
    }

    public final int oz() {
        return vl() + j();
    }

    @Override // a7.tl
    public void p(@NonNull v vVar) {
        super.p(vVar);
        int oz2 = oz();
        this.f35f.add(vVar);
        z6(oz2, vVar.r());
        dm();
    }

    public final int q9() {
        v vVar;
        if (this.f37p && (vVar = this.f38s) != null) {
            return vVar.r();
        }
        return 0;
    }

    public List<v> qn() {
        return new ArrayList(this.f35f);
    }

    public void ra(@NonNull Collection<? extends v> collection) {
        s8(collection, true);
    }

    public void rs(@NonNull v vVar) {
        if (vVar != null) {
            v vVar2 = this.f40v;
            if (vVar2 != null) {
                vVar2.co(this);
            }
            int j2 = j();
            this.f40v = vVar;
            vVar.n3(this);
            xg(j2);
            return;
        }
        throw new NullPointerException("Header can't be null.  Please use removeHeader() instead!");
    }

    public void s8(@NonNull Collection<? extends v> collection, boolean z2) {
        e(collection, androidx.recyclerview.widget.gv.zn(new n3(new ArrayList(this.f35f), collection), z2));
    }

    public final boolean u() {
        if (o() > 0) {
            return true;
        }
        return false;
    }

    public final int ut() {
        return this.f37p ? 1 : 0;
    }

    public final int vl() {
        if (this.f37p) {
            return q9();
        }
        return s.n3(this.f35f);
    }

    @Override // a7.tl, a7.fb
    public void wz(@NonNull v vVar, int i, int i5) {
        super.wz(vVar, i, i5);
        dm();
    }

    @Override // a7.tl
    public void x(@NonNull Collection<? extends v> collection) {
        if (collection.isEmpty()) {
            return;
        }
        super.x(collection);
        for (v vVar : collection) {
            int c2 = c(vVar);
            this.f35f.remove(vVar);
            ud(c2, vVar.r());
        }
        dm();
    }

    public final void xg(int i) {
        int j2 = j();
        if (i > 0) {
            ud(0, i);
        }
        if (j2 > 0) {
            z6(0, j2);
        }
    }

    public final boolean y5() {
        if (ut() > 0) {
            return true;
        }
        return false;
    }

    public void yt() {
        if (this.f35f.isEmpty()) {
            return;
        }
        x(new ArrayList(this.f35f));
    }

    @Override // a7.tl
    @NonNull
    public v z(int i) {
        if (u() && i == 0) {
            return this.f40v;
        }
        int o2 = i - o();
        if (y5() && o2 == 0) {
            return this.f38s;
        }
        int ut2 = o2 - ut();
        if (ut2 == this.f35f.size()) {
            if (jz()) {
                return this.f36fb;
            }
            throw new IndexOutOfBoundsException("Wanted group at position " + ut2 + " but there are only " + i4() + " groups");
        }
        return this.f35f.get(ut2);
    }

    public w(@Nullable v vVar) {
        this(vVar, new ArrayList());
    }

    public w(@NonNull Collection<? extends v> collection) {
        this(null, collection);
    }

    public w(@Nullable v vVar, @NonNull Collection<? extends v> collection) {
        this.f35f = new ArrayList<>();
        this.f39t = false;
        this.f41w = true;
        this.f37p = false;
        this.f34co = new y();
        this.f40v = vVar;
        if (vVar != null) {
            vVar.n3(this);
        }
        mt(collection);
    }
}
