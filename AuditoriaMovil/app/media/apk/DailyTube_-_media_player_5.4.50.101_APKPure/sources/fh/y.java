package fh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import vl.a;
import vl.v;
import z.s;
/* loaded from: classes.dex */
public final class y<T> {
    public final v<ArrayList<T>> y = new a(10);

    /* renamed from: n3  reason: collision with root package name */
    public final s<T, ArrayList<T>> f7920n3 = new s<>();

    /* renamed from: zn  reason: collision with root package name */
    public final ArrayList<T> f7921zn = new ArrayList<>();

    /* renamed from: gv  reason: collision with root package name */
    public final HashSet<T> f7919gv = new HashSet<>();

    @NonNull
    public final ArrayList<T> a() {
        ArrayList<T> n32 = this.y.n3();
        if (n32 == null) {
            return new ArrayList<>();
        }
        return n32;
    }

    @NonNull
    public ArrayList<T> c5() {
        this.f7921zn.clear();
        this.f7919gv.clear();
        int size = this.f7920n3.size();
        for (int i = 0; i < size; i++) {
            v(this.f7920n3.f(i), this.f7921zn, this.f7919gv);
        }
        return this.f7921zn;
    }

    public final void f(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.y.y(arrayList);
    }

    @Nullable
    public List fb(@NonNull T t2) {
        return this.f7920n3.get(t2);
    }

    public boolean gv(@NonNull T t2) {
        return this.f7920n3.containsKey(t2);
    }

    public boolean i9(@NonNull T t2) {
        int size = this.f7920n3.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> xc2 = this.f7920n3.xc(i);
            if (xc2 != null && xc2.contains(t2)) {
                return true;
            }
        }
        return false;
    }

    public void n3(@NonNull T t2) {
        if (!this.f7920n3.containsKey(t2)) {
            this.f7920n3.put(t2, null);
        }
    }

    @Nullable
    public List<T> s(@NonNull T t2) {
        int size = this.f7920n3.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> xc2 = this.f7920n3.xc(i);
            if (xc2 != null && xc2.contains(t2)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f7920n3.f(i));
            }
        }
        return arrayList;
    }

    public final void v(T t2, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t2)) {
            return;
        }
        if (!hashSet.contains(t2)) {
            hashSet.add(t2);
            ArrayList<T> arrayList2 = this.f7920n3.get(t2);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    v(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t2);
            arrayList.add(t2);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    public void y(@NonNull T t2, @NonNull T t3) {
        if (this.f7920n3.containsKey(t2) && this.f7920n3.containsKey(t3)) {
            ArrayList<T> arrayList = this.f7920n3.get(t2);
            if (arrayList == null) {
                arrayList = a();
                this.f7920n3.put(t2, arrayList);
            }
            arrayList.add(t3);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void zn() {
        int size = this.f7920n3.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> xc2 = this.f7920n3.xc(i);
            if (xc2 != null) {
                f(xc2);
            }
        }
        this.f7920n3.clear();
    }
}
