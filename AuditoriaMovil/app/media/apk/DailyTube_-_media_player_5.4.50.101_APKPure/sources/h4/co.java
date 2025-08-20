package h4;

import android.util.SparseArray;
import v5.k5;
/* loaded from: classes.dex */
public final class co {
    public final SparseArray<k5> y = new SparseArray<>();

    public void n3() {
        this.y.clear();
    }

    public k5 y(int i) {
        k5 k5Var = this.y.get(i);
        if (k5Var == null) {
            k5 k5Var2 = new k5(9223372036854775806L);
            this.y.put(i, k5Var2);
            return k5Var2;
        }
        return k5Var;
    }
}
