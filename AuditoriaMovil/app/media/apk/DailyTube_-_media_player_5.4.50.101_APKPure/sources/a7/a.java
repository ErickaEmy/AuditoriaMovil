package a7;

import a7.f;
import a7.y;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.gv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public class a<VH extends f> extends RecyclerView.s<VH> implements fb {

    /* renamed from: co  reason: collision with root package name */
    public final GridLayoutManager.zn f16co;

    /* renamed from: fb  reason: collision with root package name */
    public xc f17fb;

    /* renamed from: p  reason: collision with root package name */
    public a7.y f18p;

    /* renamed from: t  reason: collision with root package name */
    public t f20t;

    /* renamed from: v  reason: collision with root package name */
    public wz f21v;

    /* renamed from: w  reason: collision with root package name */
    public y.InterfaceC0000y f22w;
    public final List<v> y = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public int f19s = 1;

    /* loaded from: classes.dex */
    public class n3 extends GridLayoutManager.zn {
        public n3() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.zn
        public int a(int i) {
            try {
                return a.this.mt(i).oz(a.this.f19s, i);
            } catch (IndexOutOfBoundsException unused) {
                return a.this.f19s;
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements y.InterfaceC0000y {
        public y() {
        }

        @Override // kp.n3
        public void gv(int i, int i5) {
            a.this.notifyItemMoved(i, i5);
        }

        @Override // kp.n3
        public void n3(int i, int i5) {
            a.this.notifyItemRangeRemoved(i, i5);
        }

        @Override // kp.n3
        public void y(int i, int i5) {
            a.this.notifyItemRangeInserted(i, i5);
        }

        @Override // kp.n3
        public void zn(int i, int i5, Object obj) {
            a.this.notifyItemRangeChanged(i, i5, obj);
        }
    }

    public a() {
        y yVar = new y();
        this.f22w = yVar;
        this.f18p = new a7.y(yVar);
        this.f16co = new n3();
    }

    private int z(int i) {
        int i5 = 0;
        for (v vVar : this.y.subList(0, i)) {
            i5 += vVar.r();
        }
        return i5;
    }

    @Override // a7.fb
    public void a(@NonNull v vVar, int i) {
        notifyItemChanged(t(vVar) + i);
    }

    public void a8(@Nullable wz wzVar) {
        this.f21v = wzVar;
    }

    public void b(int i) {
        this.f19s = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: c */
    public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
        mt(i).yt(vh, i, list, this.f21v, this.f17fb);
    }

    @Override // a7.fb
    public void c5() {
        notifyDataSetChanged();
    }

    @NonNull
    public t co(@NonNull VH vh) {
        return vh.gv();
    }

    public final void d(int i, @NonNull v vVar) {
        int z2 = z(i);
        vVar.co(this);
        this.y.remove(i);
        notifyItemRangeRemoved(z2, vVar.r());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    @NonNull
    /* renamed from: d0 */
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        t<VH> r2 = r(i);
        return r2.vl(from.inflate(r2.j(), viewGroup, false));
    }

    public void ej(@NonNull Collection<? extends v> collection) {
        ud(collection);
        notifyDataSetChanged();
    }

    @Override // a7.fb
    public void f(@NonNull v vVar, int i, int i5) {
        notifyItemRangeRemoved(t(vVar) + i, i5);
    }

    @NonNull
    public v f3(int i) {
        return this.y.get(i);
    }

    public void fb() {
        for (v vVar : this.y) {
            vVar.co(this);
        }
        this.y.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: fh */
    public boolean onFailedToRecycleView(@NonNull VH vh) {
        return vh.gv().y5();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public int getItemCount() {
        return s.n3(this.y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public long getItemId(int i) {
        return mt(i).o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public int getItemViewType(int i) {
        t mt2 = mt(i);
        this.f20t = mt2;
        if (mt2 != null) {
            return mt2.q9();
        }
        throw new RuntimeException("Invalid position " + i);
    }

    public void gv(@NonNull v vVar) {
        if (vVar != null) {
            int itemCount = getItemCount();
            vVar.n3(this);
            this.y.add(vVar);
            notifyItemRangeInserted(itemCount, vVar.r());
            return;
        }
        throw new RuntimeException("Group cannot be null");
    }

    @NonNull
    public GridLayoutManager.zn i4() {
        return this.f16co;
    }

    @Override // a7.fb
    public void i9(@NonNull v vVar, int i, int i5, Object obj) {
        notifyItemRangeChanged(t(vVar) + i, i5, obj);
    }

    public void k5(@NonNull Collection<? extends v> collection) {
        yt(collection, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: mg */
    public void onViewDetachedFromWindow(@NonNull VH vh) {
        super.onViewDetachedFromWindow(vh);
        co(vh).o4(vh);
    }

    @NonNull
    public t mt(int i) {
        return s.y(this.y, i);
    }

    public int p() {
        return this.y.size();
    }

    public final t<VH> r(int i) {
        t tVar = this.f20t;
        if (tVar != null && tVar.q9() == i) {
            return this.f20t;
        }
        for (int i5 = 0; i5 < getItemCount(); i5++) {
            t<VH> mt2 = mt(i5);
            if (mt2.q9() == i) {
                return mt2;
            }
        }
        throw new IllegalStateException("Could not find model for view type: " + i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: rz */
    public void onViewAttachedToWindow(@NonNull VH vh) {
        super.onViewAttachedToWindow(vh);
        co(vh).ct(vh);
    }

    @Override // a7.fb
    public void s(@NonNull v vVar, int i, int i5) {
        int t2 = t(vVar);
        notifyItemMoved(i + t2, t2 + i5);
    }

    public int t(@NonNull v vVar) {
        int indexOf = this.y.indexOf(vVar);
        if (indexOf == -1) {
            return -1;
        }
        int i = 0;
        for (int i5 = 0; i5 < indexOf; i5++) {
            i += this.y.get(i5).r();
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: ta */
    public void onViewRecycled(@NonNull VH vh) {
        vh.gv().rs(vh);
    }

    public int tl(@NonNull t tVar) {
        int i = 0;
        for (v vVar : this.y) {
            int ej2 = vVar.ej(tVar);
            if (ej2 >= 0) {
                return ej2 + i;
            }
            i += vVar.r();
        }
        return -1;
    }

    public final void ud(@NonNull Collection<? extends v> collection) {
        for (v vVar : this.y) {
            vVar.co(this);
        }
        this.y.clear();
        this.y.addAll(collection);
        for (v vVar2 : collection) {
            vVar2.n3(this);
        }
    }

    public void v(@NonNull Collection<? extends v> collection) {
        if (!collection.contains(null)) {
            int itemCount = getItemCount();
            int i = 0;
            for (v vVar : collection) {
                i += vVar.r();
                vVar.n3(this);
            }
            this.y.addAll(collection);
            notifyItemRangeInserted(itemCount, i);
            return;
        }
        throw new RuntimeException("List of groups can't contain null!");
    }

    @NonNull
    public v w(int i) {
        int i5 = 0;
        for (v vVar : this.y) {
            if (i - i5 < vVar.r()) {
                return vVar;
            }
            i5 += vVar.r();
        }
        throw new IndexOutOfBoundsException("Requested position " + i + " in group adapter but there are only " + i5 + " items");
    }

    @Override // a7.fb
    public void wz(@NonNull v vVar, int i, int i5) {
        notifyItemRangeInserted(t(vVar) + i, i5);
    }

    public void x(@Nullable xc xcVar) {
        this.f17fb = xcVar;
    }

    public int x4() {
        return this.f19s;
    }

    @Override // a7.fb
    public void xc(@NonNull v vVar, int i, Object obj) {
        notifyItemChanged(t(vVar) + i, obj);
    }

    public void yt(@NonNull Collection<? extends v> collection, boolean z2) {
        gv.v zn2 = androidx.recyclerview.widget.gv.zn(new a7.n3(new ArrayList(this.y), collection), z2);
        ud(collection);
        zn2.n3(this.f22w);
    }

    public void z6(@NonNull v vVar) {
        if (vVar != null) {
            d(this.y.indexOf(vVar), vVar);
            return;
        }
        throw new RuntimeException("Group cannot be null");
    }

    public void zn(int i, @NonNull v vVar) {
        if (vVar != null) {
            vVar.n3(this);
            this.y.add(i, vVar);
            notifyItemRangeInserted(z(i), vVar.r());
            return;
        }
        throw new RuntimeException("Group cannot be null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    /* renamed from: n */
    public void onBindViewHolder(@NonNull VH vh, int i) {
    }
}
