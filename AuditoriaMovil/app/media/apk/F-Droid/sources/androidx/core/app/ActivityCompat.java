package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class ActivityCompat extends ContextCompat {

    /* loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        Api16Impl.startActivityForResult(activity, intent, i, bundle);
    }

    public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Api16Impl.startIntentSenderForResult(activity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void finishAffinity(Activity activity) {
        Api16Impl.finishAffinity(activity);
    }

    public static void finishAfterTransition(Activity activity) {
        Api21Impl.finishAfterTransition(activity);
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        Api21Impl.setEnterSharedElementCallback(activity, null);
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        Api21Impl.setExitSharedElementCallback(activity, null);
    }

    public static void postponeEnterTransition(Activity activity) {
        Api21Impl.postponeEnterTransition(activity);
    }

    public static void startPostponedEnterTransition(Activity activity) {
        Api21Impl.startPostponedEnterTransition(activity);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        }
        Api23Impl.requestPermissions(activity, strArr, i);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            if (i >= 32) {
                return Api32Impl.shouldShowRequestPermissionRationale(activity, str);
            }
            if (i == 31) {
                return Api31Impl.shouldShowRequestPermissionRationale(activity, str);
            }
            return Api23Impl.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }

    public static void recreate(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityCompat.lambda$recreate$0(activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$recreate$0(Activity activity) {
        if (activity.isFinishing() || ActivityRecreator.recreate(activity)) {
            return;
        }
        activity.recreate();
    }

    /* loaded from: classes.dex */
    static class Api31Impl {
        static boolean isLaunchedFromBubble(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @SuppressLint({"BanUncheckedReflection"})
        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    /* loaded from: classes.dex */
    static class Api32Impl {
        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: classes.dex */
    static class Api16Impl {
        static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
            activity.startActivityForResult(intent, i, bundle);
        }

        static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }

        static void finishAffinity(Activity activity) {
            activity.finishAffinity();
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        static void finishAfterTransition(Activity activity) {
            activity.finishAfterTransition();
        }

        static void setEnterSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void setExitSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void postponeEnterTransition(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void startPostponedEnterTransition(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        static void requestPermissions(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }

        static void onSharedElementsReady(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }
    }
}
