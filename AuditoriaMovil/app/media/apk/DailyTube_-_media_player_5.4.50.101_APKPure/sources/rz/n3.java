package rz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hjq.permissions.Permission;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes.dex */
public class n3 extends mg.y {

    /* loaded from: classes.dex */
    public static class a {
        @SuppressLint({"BanUncheckedReflection"})
        public static boolean n3(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }

        public static boolean y(@NonNull Activity activity) {
            return activity.isLaunchedFromBubble();
        }
    }

    /* loaded from: classes.dex */
    public interface c5 {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* loaded from: classes.dex */
    public static class fb {
        public static boolean y(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: classes.dex */
    public static class gv {
        public static void n3(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        public static void y(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static boolean zn(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* renamed from: rz.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0209n3 {
        public static void n3(Activity activity, Intent intent, int i, Bundle bundle) {
            activity.startActivityForResult(intent, i, bundle);
        }

        public static void y(Activity activity) {
            activity.finishAffinity();
        }

        public static void zn(Activity activity, IntentSender intentSender, int i, Intent intent, int i5, int i6, int i8, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i, intent, i5, i6, i8, bundle);
        }
    }

    /* loaded from: classes.dex */
    public interface s {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes.dex */
    public static class v {
        public static <T> T y(Activity activity, int i) {
            return (T) activity.requireViewById(i);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ int f13362fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Activity f13363v;
        public final /* synthetic */ String[] y;

        public y(String[] strArr, Activity activity, int i) {
            this.y = strArr;
            this.f13363v = activity;
            this.f13362fb = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.y.length];
            PackageManager packageManager = this.f13363v.getPackageManager();
            String packageName = this.f13363v.getPackageName();
            int length = this.y.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.y[i], packageName);
            }
            ((s) this.f13363v).onRequestPermissionsResult(this.f13362fb, this.y, iArr);
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static void gv(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void n3(Activity activity) {
            activity.postponeEnterTransition();
        }

        public static void v(Activity activity) {
            activity.startPostponedEnterTransition();
        }

        public static void y(Activity activity) {
            activity.finishAfterTransition();
        }

        public static void zn(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    public static void c(@NonNull Activity activity, @Nullable tl tlVar) {
        zn.gv(activity, null);
    }

    public static void co(@NonNull Activity activity) {
        zn.y(activity);
    }

    public static boolean d0(@NonNull Activity activity, @NonNull String str) {
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && TextUtils.equals(Permission.POST_NOTIFICATIONS, str)) {
            return false;
        }
        if (i >= 32) {
            return fb.y(activity, str);
        }
        if (i == 31) {
            return a.n3(activity, str);
        }
        if (i < 23) {
            return false;
        }
        return gv.zn(activity, str);
    }

    @NonNull
    public static <T extends View> T f3(@NonNull Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) v.y(activity, i);
        }
        T t2 = (T) activity.findViewById(i);
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void fh(@NonNull Activity activity, @NonNull Intent intent, int i, @Nullable Bundle bundle) {
        C0209n3.n3(activity, intent, i, bundle);
    }

    public static void i4(@NonNull Activity activity, @NonNull String[] strArr, int i) {
        String[] strArr2;
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (!TextUtils.isEmpty(strArr[i5])) {
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i5], Permission.POST_NOTIFICATIONS)) {
                    hashSet.add(Integer.valueOf(i5));
                }
            } else {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            strArr2 = new String[strArr.length - size];
        } else {
            strArr2 = strArr;
        }
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i6 = 0;
            for (int i8 = 0; i8 < strArr.length; i8++) {
                if (!hashSet.contains(Integer.valueOf(i8))) {
                    strArr2[i6] = strArr[i8];
                    i6++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof c5) {
                ((c5) activity).validateRequestPermissionsRequestCode(i);
            }
            gv.n3(activity, strArr, i);
        } else if (activity instanceof s) {
            new Handler(Looper.getMainLooper()).post(new y(strArr2, activity, i));
        }
    }

    public static void mg(@NonNull Activity activity) {
        zn.v(activity);
    }

    public static void mt(@NonNull Activity activity) {
        C0209n3.y(activity);
    }

    public static void n(@NonNull Activity activity, @Nullable tl tlVar) {
        zn.zn(activity, null);
    }

    public static void r(@NonNull Activity activity) {
        zn.n3(activity);
    }

    public static void rz(@NonNull Activity activity, @NonNull IntentSender intentSender, int i, @Nullable Intent intent, int i5, int i6, int i8, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        C0209n3.zn(activity, intentSender, i, intent, i5, i6, i8, bundle);
    }

    public static void x4(@NonNull final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: rz.y
                @Override // java.lang.Runnable
                public final void run() {
                    n3.z(activity);
                }
            });
        }
    }

    public static /* synthetic */ void z(Activity activity) {
        if (!activity.isFinishing() && !rz.gv.c5(activity)) {
            activity.recreate();
        }
    }
}
