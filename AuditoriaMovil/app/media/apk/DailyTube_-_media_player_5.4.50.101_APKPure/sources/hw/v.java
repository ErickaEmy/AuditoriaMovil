package hw;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class v {

    /* loaded from: classes.dex */
    public static class y {
        public static void n3(int i, int i5, int i6, Rect rect, Rect rect2, int i8) {
            Gravity.apply(i, i5, i6, rect, rect2, i8);
        }

        public static void y(int i, int i5, int i6, Rect rect, int i8, int i10, Rect rect2, int i11) {
            Gravity.apply(i, i5, i6, rect, i8, i10, rect2, i11);
        }

        public static void zn(int i, Rect rect, Rect rect2, int i5) {
            Gravity.applyDisplay(i, rect, rect2, i5);
        }
    }

    public static int n3(int i, int i5) {
        return Gravity.getAbsoluteGravity(i, i5);
    }

    public static void y(int i, int i5, int i6, @NonNull Rect rect, @NonNull Rect rect2, int i8) {
        y.n3(i, i5, i6, rect, rect2, i8);
    }
}
