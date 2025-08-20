package v5;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import m1.s;
import z0.x4;
/* loaded from: classes.dex */
public final class gv {
    public static <T extends m1.s> ArrayList<Bundle> gv(Collection<T> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (T t2 : collection) {
            arrayList.add(t2.toBundle());
        }
        return arrayList;
    }

    public static <T extends m1.s> z0.x4<T> n3(s.y<T> yVar, List<Bundle> list) {
        x4.y x42 = z0.x4.x4();
        for (int i = 0; i < list.size(); i++) {
            x42.y(yVar.fromBundle((Bundle) y.v(list.get(i))));
        }
        return x42.s();
    }

    public static <T extends m1.s> SparseArray<Bundle> v(SparseArray<T> sparseArray) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i).toBundle());
        }
        return sparseArray2;
    }

    public static void y(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) j5.i9(gv.class.getClassLoader()));
        }
    }

    public static <T extends m1.s> SparseArray<T> zn(s.y<T> yVar, SparseArray<Bundle> sparseArray) {
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), yVar.fromBundle(sparseArray.valueAt(i)));
        }
        return sparseArray2;
    }
}
