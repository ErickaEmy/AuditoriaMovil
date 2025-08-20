package lc;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.R$id;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class t {
    @Nullable
    public static NavController gv(@NonNull View view) {
        Object tag = view.getTag(R$id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    @NonNull
    public static NavController n3(@NonNull View view) {
        NavController zn2 = zn(view);
        if (zn2 != null) {
            return zn2;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static void v(@NonNull View view, @Nullable NavController navController) {
        view.setTag(R$id.nav_controller_view_tag, navController);
    }

    @NonNull
    public static NavController y(@NonNull Activity activity, int i) {
        NavController zn2 = zn(rz.n3.f3(activity, i));
        if (zn2 != null) {
            return zn2;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i);
    }

    @Nullable
    public static NavController zn(@NonNull View view) {
        while (view != null) {
            NavController gv2 = gv(view);
            if (gv2 != null) {
                return gv2;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }
}
