package cr;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class r {
    public static boolean y = true;

    @SuppressLint({"NewApi"})
    public static void n3(@NonNull ViewGroup viewGroup, boolean z2) {
        if (y) {
            try {
                viewGroup.suppressLayout(z2);
            } catch (NoSuchMethodError unused) {
                y = false;
            }
        }
    }

    public static z y(@NonNull ViewGroup viewGroup) {
        return new co(viewGroup);
    }

    public static void zn(@NonNull ViewGroup viewGroup, boolean z2) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z2);
        } else {
            n3(viewGroup, z2);
        }
    }
}
