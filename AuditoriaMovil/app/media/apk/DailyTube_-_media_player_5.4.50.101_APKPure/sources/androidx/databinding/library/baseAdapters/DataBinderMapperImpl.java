package androidx.databinding.library.baseAdapters;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import q9.n3;
import q9.zn;
/* loaded from: classes.dex */
public class DataBinderMapperImpl extends n3 {
    public static final SparseIntArray y = new SparseIntArray(0);

    /* loaded from: classes.dex */
    public static class y {
        public static final HashMap<String, Integer> y = new HashMap<>(0);
    }

    @Override // q9.n3
    public int gv(String str) {
        Integer num;
        if (str == null || (num = y.y.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // q9.n3
    public ViewDataBinding n3(zn znVar, View view, int i) {
        if (y.get(i) > 0 && view.getTag() == null) {
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // q9.n3
    public List<n3> y() {
        return new ArrayList(0);
    }

    @Override // q9.n3
    public ViewDataBinding zn(zn znVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || y.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
