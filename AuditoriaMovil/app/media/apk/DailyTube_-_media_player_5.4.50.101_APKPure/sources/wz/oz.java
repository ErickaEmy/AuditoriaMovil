package wz;

import android.graphics.Rect;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class oz {
    public static Method y;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            y = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                y.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public static boolean n3(View view) {
        if (hw.i4.ta(view) == 1) {
            return true;
        }
        return false;
    }

    public static void y(View view, Rect rect, Rect rect2) {
        Method method = y;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception unused) {
            }
        }
    }

    public static void zn(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }
}
