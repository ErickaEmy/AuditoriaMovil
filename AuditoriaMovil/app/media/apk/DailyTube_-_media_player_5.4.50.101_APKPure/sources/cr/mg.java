package cr;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class mg {

    /* renamed from: gv  reason: collision with root package name */
    public static boolean f6771gv;

    /* renamed from: n3  reason: collision with root package name */
    public static boolean f6772n3;
    public static Method y;

    /* renamed from: zn  reason: collision with root package name */
    public static Field f6773zn;

    public void a(@NonNull View view, float f4) {
        throw null;
    }

    public void c5(@NonNull View view, @NonNull Matrix matrix) {
        throw null;
    }

    public void fb(@NonNull View view, int i) {
        if (!f6771gv) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f6773zn = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f6771gv = true;
        }
        Field field = f6773zn;
        if (field != null) {
            try {
                f6773zn.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void gv(@NonNull View view) {
        throw null;
    }

    @SuppressLint({"PrivateApi", "SoonBlockedPrivateApi"})
    public final void n3() {
        if (!f6772n3) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                y = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f6772n3 = true;
        }
    }

    public void s(@NonNull View view, @NonNull Matrix matrix) {
        throw null;
    }

    public void v(@NonNull View view, int i, int i5, int i6, int i8) {
        n3();
        Method method = y;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i8));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void y(@NonNull View view) {
        throw null;
    }

    public float zn(@NonNull View view) {
        throw null;
    }
}
