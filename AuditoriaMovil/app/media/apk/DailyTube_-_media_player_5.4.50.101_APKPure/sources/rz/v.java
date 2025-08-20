package rz;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class v {

    /* loaded from: classes.dex */
    public static class n3 {
        @NonNull
        public static String n3(@NonNull Context context) {
            return context.getOpPackageName();
        }

        public static int y(@Nullable AppOpsManager appOpsManager, @NonNull String str, int i, @NonNull String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i, str2);
        }

        @Nullable
        public static AppOpsManager zn(@NonNull Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static String gv(String str) {
            return AppOpsManager.permissionToOp(str);
        }

        public static int n3(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        public static <T> T y(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        public static int zn(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }
    }

    public static int n3(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return y.zn((AppOpsManager) y.y(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    public static int y(@NonNull Context context, int i, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            AppOpsManager zn2 = n3.zn(context);
            int y2 = n3.y(zn2, str, Binder.getCallingUid(), str2);
            if (y2 != 0) {
                return y2;
            }
            return n3.y(zn2, str, i, n3.n3(context));
        }
        return n3(context, str, str2);
    }

    @Nullable
    public static String zn(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return y.gv(str);
        }
        return null;
    }
}
