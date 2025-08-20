package hw;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class s {

    /* loaded from: classes.dex */
    public static class y {
        public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setLayoutDirection(i);
        }

        public static void fb(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setMarginEnd(i);
        }

        public static boolean gv(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        public static int n3(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        public static void s(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setMarginStart(i);
        }

        public static void v(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.resolveLayoutDirection(i);
        }

        public static int y(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        public static int zn(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }
    }

    public static void gv(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        y.s(marginLayoutParams, i);
    }

    public static int n3(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return y.zn(marginLayoutParams);
    }

    public static int y(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return y.n3(marginLayoutParams);
    }

    public static void zn(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        y.fb(marginLayoutParams, i);
    }
}
