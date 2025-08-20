package hw;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class c {

    /* loaded from: classes.dex */
    public static class y {
        public static boolean n3(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        public static int y(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        public static void zn(ViewGroup viewGroup, boolean z2) {
            viewGroup.setTransitionGroup(z2);
        }
    }

    public static boolean y(@NonNull ViewGroup viewGroup) {
        return y.n3(viewGroup);
    }
}
