package v5;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class zn {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public static Method f14429n3;
    @Nullable
    public static Method y;

    public static void gv(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        Method method = f14429n3;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                f14429n3 = method2;
                method2.setAccessible(true);
                method = f14429n3;
            } catch (NoSuchMethodException e2) {
                r.fb("BundleUtil", "Failed to retrieve putIBinder method", e2);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            r.fb("BundleUtil", "Failed to invoke putIBinder via reflection", e3);
        }
    }

    @Nullable
    public static IBinder n3(Bundle bundle, @Nullable String str) {
        Method method = y;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                y = method2;
                method2.setAccessible(true);
                method = y;
            } catch (NoSuchMethodException e2) {
                r.fb("BundleUtil", "Failed to retrieve getIBinder method", e2);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            r.fb("BundleUtil", "Failed to invoke getIBinder via reflection", e3);
            return null;
        }
    }

    @Nullable
    public static IBinder y(Bundle bundle, @Nullable String str) {
        if (j5.y >= 18) {
            return bundle.getBinder(str);
        }
        return n3(bundle, str);
    }

    public static void zn(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (j5.y >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            gv(bundle, str, iBinder);
        }
    }
}
