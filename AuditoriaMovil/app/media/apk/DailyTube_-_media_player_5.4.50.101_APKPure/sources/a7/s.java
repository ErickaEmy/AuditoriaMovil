package a7;

import androidx.annotation.NonNull;
import java.util.Collection;
/* loaded from: classes.dex */
public class s {
    public static int n3(@NonNull Collection<? extends v> collection) {
        int i = 0;
        for (v vVar : collection) {
            i += vVar.r();
        }
        return i;
    }

    @NonNull
    public static t y(Collection<? extends v> collection, int i) {
        int i5 = 0;
        for (v vVar : collection) {
            int r2 = vVar.r() + i5;
            if (r2 > i) {
                return vVar.getItem(i - i5);
            }
            i5 = r2;
        }
        throw new IndexOutOfBoundsException("Wanted item at " + i + " but there are only " + i5 + " items");
    }
}
