package hw;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class n {
    public static Method y;

    /* loaded from: classes.dex */
    public static class n3 {
        public static boolean n3(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }

        public static int y(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static float n3(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }

        public static float y(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                y = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", null);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return n3.n3(viewConfiguration);
        }
        Resources resources = context.getResources();
        int n32 = n3(resources, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        if (n32 != 0 && resources.getBoolean(n32)) {
            return true;
        }
        return false;
    }

    public static int gv(@NonNull ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return n3.y(viewConfiguration);
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int n3(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    public static float v(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return y.n3(viewConfiguration);
        }
        return y(viewConfiguration, context);
    }

    public static float y(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = y) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, null)).intValue();
            } catch (Exception unused) {
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float zn(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return y.y(viewConfiguration);
        }
        return y(viewConfiguration, context);
    }
}
