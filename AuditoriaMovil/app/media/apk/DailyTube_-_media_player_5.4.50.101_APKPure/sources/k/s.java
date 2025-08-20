package k;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class s {
    public static void a(View view, float f4) {
        view.setPaddingRelative(y(f4), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
    }

    public static void fb(View view, float f4) {
        view.setPadding(view.getPaddingLeft(), y(f4), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void gv(View view, float f4) {
        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), y(f4), view.getPaddingBottom());
    }

    public static void n3(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void v(View view, float f4) {
        view.setPadding(y(f4), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static int y(float f4) {
        int i = (int) (0.5f + f4);
        if (i != 0) {
            return i;
        }
        int i5 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
        if (i5 == 0) {
            return 0;
        }
        if (i5 > 0) {
            return 1;
        }
        return -1;
    }

    public static void zn(View view, float f4) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), y(f4));
    }
}
