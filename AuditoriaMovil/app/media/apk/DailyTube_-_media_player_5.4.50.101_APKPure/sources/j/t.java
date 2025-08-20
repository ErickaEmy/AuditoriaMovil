package j;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: gv  reason: collision with root package name */
    public static boolean f9316gv;

    /* renamed from: n3  reason: collision with root package name */
    public static boolean f9317n3;
    public static Method y;

    /* renamed from: zn  reason: collision with root package name */
    public static Field f9318zn;

    /* loaded from: classes.dex */
    public static class n3 {
        public static void gv(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }

        public static int n3(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        public static boolean y(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        public static void zn(PopupWindow popupWindow, boolean z2) {
            popupWindow.setOverlapAnchor(z2);
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static void y(PopupWindow popupWindow, View view, int i, int i5, int i6) {
            popupWindow.showAsDropDown(view, i, i5, i6);
        }
    }

    public static void n3(@NonNull PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            n3.gv(popupWindow, i);
            return;
        }
        if (!f9317n3) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                y = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f9317n3 = true;
        }
        Method method = y;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception unused2) {
            }
        }
    }

    public static void y(@NonNull PopupWindow popupWindow, boolean z2) {
        if (Build.VERSION.SDK_INT >= 23) {
            n3.zn(popupWindow, z2);
            return;
        }
        if (!f9316gv) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f9318zn = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f9316gv = true;
        }
        Field field = f9318zn;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z2));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static void zn(@NonNull PopupWindow popupWindow, @NonNull View view, int i, int i5, int i6) {
        y.y(popupWindow, view, i, i5, i6);
    }
}
