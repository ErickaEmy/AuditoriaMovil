package a7;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.gv;
import java.util.Collection;
/* loaded from: classes.dex */
public class n3 extends gv.n3 {

    /* renamed from: gv  reason: collision with root package name */
    public final Collection<? extends v> f28gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f29n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final Collection<? extends v> f30zn;

    public n3(Collection<? extends v> collection, Collection<? extends v> collection2) {
        this.y = s.n3(collection);
        this.f29n3 = s.n3(collection2);
        this.f30zn = collection;
        this.f28gv = collection2;
    }

    @Override // androidx.recyclerview.widget.gv.n3
    public int gv() {
        return this.f29n3;
    }

    @Override // androidx.recyclerview.widget.gv.n3
    public boolean n3(int i, int i5) {
        return s.y(this.f28gv, i5).xg(s.y(this.f30zn, i));
    }

    @Override // androidx.recyclerview.widget.gv.n3
    public int v() {
        return this.y;
    }

    @Override // androidx.recyclerview.widget.gv.n3
    public boolean y(int i, int i5) {
        return s.y(this.f28gv, i5).k(s.y(this.f30zn, i));
    }

    @Override // androidx.recyclerview.widget.gv.n3
    @Nullable
    public Object zn(int i, int i5) {
        return s.y(this.f30zn, i).j5(s.y(this.f28gv, i5));
    }
}
