package j;

import android.widget.ListView;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes.dex */
    public static class y {
        public static void n3(ListView listView, int i) {
            listView.scrollListBy(i);
        }

        public static boolean y(ListView listView, int i) {
            return listView.canScrollList(i);
        }
    }

    public static void n3(@NonNull ListView listView, int i) {
        y.n3(listView, i);
    }

    public static boolean y(@NonNull ListView listView, int i) {
        return y.y(listView, i);
    }
}
