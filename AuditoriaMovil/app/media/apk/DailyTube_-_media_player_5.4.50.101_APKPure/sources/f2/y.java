package f2;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hjq.permissions.IPermissionInterceptor;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.PermissionFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final /* synthetic */ class y {
    public static void gv(IPermissionInterceptor iPermissionInterceptor, @NonNull Activity activity, @NonNull List list, @Nullable OnPermissionCallback onPermissionCallback) {
        PermissionFragment.launch(activity, new ArrayList(list), iPermissionInterceptor, onPermissionCallback);
    }

    public static void y(IPermissionInterceptor iPermissionInterceptor, @NonNull Activity activity, @NonNull List list, @NonNull List list2, boolean z2, @Nullable OnPermissionCallback onPermissionCallback) {
        if (onPermissionCallback == null) {
            return;
        }
        onPermissionCallback.onDenied(list2, z2);
    }

    public static void zn(IPermissionInterceptor iPermissionInterceptor, @NonNull Activity activity, @NonNull List list, @NonNull List list2, boolean z2, @Nullable OnPermissionCallback onPermissionCallback) {
        if (onPermissionCallback == null) {
            return;
        }
        onPermissionCallback.onGranted(list2, z2);
    }

    public static void n3(IPermissionInterceptor iPermissionInterceptor, @NonNull Activity activity, @NonNull List list, boolean z2, @Nullable OnPermissionCallback onPermissionCallback) {
    }
}
