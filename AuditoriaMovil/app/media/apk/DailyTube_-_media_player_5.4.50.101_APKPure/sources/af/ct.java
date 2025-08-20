package af;

import android.util.SparseArray;
/* loaded from: classes.dex */
public final class ct<V> {

    /* renamed from: n3  reason: collision with root package name */
    public final SparseArray<V> f138n3 = new SparseArray<>();
    public int y = -1;

    /* renamed from: zn  reason: collision with root package name */
    public final v5.c5<V> f139zn;

    public ct(v5.c5<V> c5Var) {
        this.f139zn = c5Var;
    }

    public V a() {
        SparseArray<V> sparseArray = this.f138n3;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public boolean fb() {
        if (this.f138n3.size() == 0) {
            return true;
        }
        return false;
    }

    public void gv(int i) {
        int i5 = 0;
        while (i5 < this.f138n3.size() - 1) {
            int i6 = i5 + 1;
            if (i >= this.f138n3.keyAt(i6)) {
                this.f139zn.accept(this.f138n3.valueAt(i5));
                this.f138n3.removeAt(i5);
                int i8 = this.y;
                if (i8 > 0) {
                    this.y = i8 - 1;
                }
                i5 = i6;
            } else {
                return;
            }
        }
    }

    public void n3() {
        for (int i = 0; i < this.f138n3.size(); i++) {
            this.f139zn.accept(this.f138n3.valueAt(i));
        }
        this.y = -1;
        this.f138n3.clear();
    }

    public V v(int i) {
        if (this.y == -1) {
            this.y = 0;
        }
        while (true) {
            int i5 = this.y;
            if (i5 <= 0 || i >= this.f138n3.keyAt(i5)) {
                break;
            }
            this.y--;
        }
        while (this.y < this.f138n3.size() - 1 && i >= this.f138n3.keyAt(this.y + 1)) {
            this.y++;
        }
        return this.f138n3.valueAt(this.y);
    }

    public void y(int i, V v2) {
        boolean z2;
        boolean z3 = false;
        if (this.y == -1) {
            if (this.f138n3.size() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            this.y = 0;
        }
        if (this.f138n3.size() > 0) {
            SparseArray<V> sparseArray = this.f138n3;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i >= keyAt) {
                z3 = true;
            }
            v5.y.y(z3);
            if (keyAt == i) {
                SparseArray<V> sparseArray2 = this.f138n3;
                this.f139zn.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f138n3.append(i, v2);
    }

    public void zn(int i) {
        int i5;
        for (int size = this.f138n3.size() - 1; size >= 0 && i < this.f138n3.keyAt(size); size--) {
            this.f139zn.accept(this.f138n3.valueAt(size));
            this.f138n3.removeAt(size);
        }
        if (this.f138n3.size() > 0) {
            i5 = Math.min(this.y, this.f138n3.size() - 1);
        } else {
            i5 = -1;
        }
        this.y = i5;
    }
}
