package rz;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class s {

    /* loaded from: classes.dex */
    public static class y {
        public static boolean n3(Activity activity, Intent intent) {
            return activity.navigateUpTo(intent);
        }

        public static Intent y(Activity activity) {
            return activity.getParentActivityIntent();
        }

        public static boolean zn(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }
    }

    public static boolean a(@NonNull Activity activity, @NonNull Intent intent) {
        return y.zn(activity, intent);
    }

    @Nullable
    public static String gv(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        int i;
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            i = 269222528;
        } else if (i5 >= 24) {
            i = 787072;
        } else {
            i = 640;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        return string;
    }

    @Nullable
    public static Intent n3(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String gv2 = gv(context, componentName);
        if (gv2 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), gv2);
        if (gv(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static void v(@NonNull Activity activity, @NonNull Intent intent) {
        y.n3(activity, intent);
    }

    @Nullable
    public static Intent y(@NonNull Activity activity) {
        Intent y2 = y.y(activity);
        if (y2 != null) {
            return y2;
        }
        String zn2 = zn(activity);
        if (zn2 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, zn2);
        try {
            if (gv(activity, componentName) == null) {
                return Intent.makeMainActivity(componentName);
            }
            return new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + zn2 + "' in manifest");
            return null;
        }
    }

    @Nullable
    public static String zn(@NonNull Activity activity) {
        try {
            return gv(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
