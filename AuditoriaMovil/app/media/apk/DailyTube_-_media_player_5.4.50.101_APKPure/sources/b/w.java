package b;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class w {

    /* loaded from: classes.dex */
    public static class y {
        public static boolean y(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    public static boolean y(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return y.y(context);
        }
        return true;
    }
}
