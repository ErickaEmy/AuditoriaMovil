package pv;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class n3 {
    public static int gv(@NonNull View view, int i) {
        return zn(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static boolean n3(@NonNull Context context, int i, boolean z2) {
        TypedValue y = y(context, i);
        if (y != null && y.type == 18) {
            if (y.data != 0) {
                return true;
            }
            return false;
        }
        return z2;
    }

    @Nullable
    public static TypedValue y(@NonNull Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int zn(@NonNull Context context, int i, @NonNull String str) {
        TypedValue y = y(context, i);
        if (y != null) {
            return y.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }
}
