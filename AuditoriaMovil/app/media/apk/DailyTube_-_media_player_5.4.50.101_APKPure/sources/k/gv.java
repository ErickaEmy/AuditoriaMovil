package k;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class gv {
    public static final SparseArray<WeakHashMap<View, WeakReference<?>>> y = new SparseArray<>();

    public static <T> T y(View view, T t2, int i) {
        T t3 = (T) view.getTag(i);
        view.setTag(i, t2);
        return t3;
    }
}
