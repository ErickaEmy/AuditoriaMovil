package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PermissionUtils {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    public static boolean areActivityIntent(@NonNull Context context, @NonNull Intent intent) {
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static <T> ArrayList<T> asArrayList(@Nullable T... tArr) {
        int i;
        if (tArr != null) {
            i = tArr.length;
        } else {
            i = 0;
        }
        ArrayList<T> arrayList = new ArrayList<>(i);
        if (tArr != null && tArr.length != 0) {
            for (T t2 : tArr) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    @NonNull
    @SafeVarargs
    public static <T> ArrayList<T> asArrayLists(@Nullable T[]... tArr) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (tArr != null && tArr.length != 0) {
            for (T[] tArr2 : tArr) {
                arrayList.addAll(asArrayList(tArr2));
            }
        }
        return arrayList;
    }

    public static boolean checkSelfPermission(@NonNull Context context, @NonNull String str) {
        if (context.checkSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static boolean containsPermission(@NonNull Collection<String> collection, @NonNull String str) {
        if (collection.isEmpty()) {
            return false;
        }
        for (String str2 : collection) {
            if (equalsPermission(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean equalsPermission(@NonNull String str, @NonNull String str2) {
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0007  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.app.Activity findActivity(@androidx.annotation.NonNull android.content.Context r2) {
        /*
        L0:
            boolean r0 = r2 instanceof android.app.Activity
            if (r0 == 0) goto L7
            android.app.Activity r2 = (android.app.Activity) r2
            return r2
        L7:
            boolean r0 = r2 instanceof android.content.ContextWrapper
            r1 = 0
            if (r0 == 0) goto L14
            android.content.ContextWrapper r2 = (android.content.ContextWrapper) r2
            android.content.Context r2 = r2.getBaseContext()
            if (r2 != 0) goto L0
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hjq.permissions.PermissionUtils.findActivity(android.content.Context):android.app.Activity");
    }

    @SuppressLint({"PrivateApi"})
    public static int findApkPathCookie(@NonNull Context context, @NonNull String str) {
        AssetManager assets = context.getAssets();
        try {
            if (AndroidVersion.getTargetSdkVersionCode(context) >= 28 && AndroidVersion.getAndroidVersionCode() >= 28 && AndroidVersion.getAndroidVersionCode() < 30) {
                Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                declaredMethod.setAccessible(true);
                Method method = (Method) declaredMethod.invoke(AssetManager.class, "findCookieForPath", new Class[]{String.class});
                if (method != null) {
                    method.setAccessible(true);
                    Integer num = (Integer) method.invoke(context.getAssets(), str);
                    if (num != null) {
                        return num.intValue();
                    }
                }
            }
            Integer num2 = (Integer) assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, str);
            if (num2 != null) {
                return num2.intValue();
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return 0;
    }

    @Nullable
    public static AndroidManifestInfo getAndroidManifestInfo(Context context) {
        AndroidManifestInfo parseAndroidManifest;
        int findApkPathCookie = findApkPathCookie(context, context.getApplicationInfo().sourceDir);
        AndroidManifestInfo androidManifestInfo = null;
        if (findApkPathCookie == 0) {
            return null;
        }
        try {
            parseAndroidManifest = AndroidManifestParser.parseAndroidManifest(context, findApkPathCookie);
        } catch (IOException e2) {
            e = e2;
        } catch (XmlPullParserException unused) {
        }
        try {
            if (!TextUtils.equals(context.getPackageName(), parseAndroidManifest.packageName)) {
                return null;
            }
            return parseAndroidManifest;
        } catch (IOException e3) {
            e = e3;
            androidManifestInfo = parseAndroidManifest;
            e.printStackTrace();
            return androidManifestInfo;
        } catch (XmlPullParserException unused2) {
            androidManifestInfo = parseAndroidManifest;
            return androidManifestInfo;
        }
    }

    public static Intent getApplicationDetailsIntent(@NonNull Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(getPackageNameUri(context));
        if (!areActivityIntent(context, intent)) {
            Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
            if (!areActivityIntent(context, intent2)) {
                return new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            }
            return intent2;
        }
        return intent;
    }

    public static Uri getPackageNameUri(@NonNull Context context) {
        return Uri.parse("package:" + context.getPackageName());
    }

    public static Intent getSmartPermissionIntent(@NonNull Context context, @Nullable List<String> list) {
        if (list != null && !list.isEmpty() && PermissionApi.containsSpecialPermission(list)) {
            int size = list.size();
            if (size != 1) {
                if (size != 2) {
                    if (size == 3 && AndroidVersion.isAndroid11() && containsPermission(list, Permission.MANAGE_EXTERNAL_STORAGE) && containsPermission(list, Permission.READ_EXTERNAL_STORAGE) && containsPermission(list, Permission.WRITE_EXTERNAL_STORAGE)) {
                        return PermissionApi.getPermissionIntent(context, Permission.MANAGE_EXTERNAL_STORAGE);
                    }
                } else if (!AndroidVersion.isAndroid13() && containsPermission(list, Permission.NOTIFICATION_SERVICE) && containsPermission(list, Permission.POST_NOTIFICATIONS)) {
                    return PermissionApi.getPermissionIntent(context, Permission.NOTIFICATION_SERVICE);
                }
                return getApplicationDetailsIntent(context);
            }
            return PermissionApi.getPermissionIntent(context, list.get(0));
        }
        return getApplicationDetailsIntent(context);
    }

    public static boolean isActivityReverse(@NonNull Activity activity) {
        int rotation;
        if (AndroidVersion.isAndroid11()) {
            rotation = activity.getDisplay().getRotation();
        } else {
            rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        }
        if (rotation != 2 && rotation != 3) {
            return false;
        }
        return true;
    }

    public static boolean isDebugMode(@NonNull Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isScopedStorage(@NonNull Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
            if (bundle != null && bundle.containsKey("ScopedStorage")) {
                return Boolean.parseBoolean(String.valueOf(bundle.get("ScopedStorage")));
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isSpecialPermission(@NonNull String str) {
        if (!equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE) && !equalsPermission(str, Permission.REQUEST_INSTALL_PACKAGES) && !equalsPermission(str, Permission.SYSTEM_ALERT_WINDOW) && !equalsPermission(str, Permission.WRITE_SETTINGS) && !equalsPermission(str, Permission.NOTIFICATION_SERVICE) && !equalsPermission(str, Permission.PACKAGE_USAGE_STATS) && !equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM) && !equalsPermission(str, Permission.BIND_NOTIFICATION_LISTENER_SERVICE) && !equalsPermission(str, Permission.ACCESS_NOTIFICATION_POLICY) && !equalsPermission(str, Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS) && !equalsPermission(str, Permission.BIND_VPN_SERVICE) && !equalsPermission(str, Permission.PICTURE_IN_PICTURE)) {
            return false;
        }
        return true;
    }

    @SuppressLint({"SwitchIntDef"})
    public static void lockActivityOrientation(@NonNull Activity activity) {
        int i;
        try {
            int i5 = activity.getResources().getConfiguration().orientation;
            int i6 = 1;
            if (i5 != 1) {
                if (i5 == 2) {
                    if (isActivityReverse(activity)) {
                        i = 8;
                    } else {
                        i = 0;
                    }
                    activity.setRequestedOrientation(i);
                }
            } else {
                if (isActivityReverse(activity)) {
                    i6 = 9;
                }
                activity.setRequestedOrientation(i6);
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public static void optimizePermissionResults(Activity activity, String[] strArr, int[] iArr) {
        int i;
        for (int i5 = 0; i5 < strArr.length; i5++) {
            String str = strArr[i5];
            boolean isSpecialPermission = PermissionApi.isSpecialPermission(str);
            boolean z2 = true;
            if (!AndroidVersion.isAndroid13() && (equalsPermission(str, Permission.POST_NOTIFICATIONS) || equalsPermission(str, Permission.NEARBY_WIFI_DEVICES) || equalsPermission(str, Permission.BODY_SENSORS_BACKGROUND) || equalsPermission(str, Permission.READ_MEDIA_IMAGES) || equalsPermission(str, Permission.READ_MEDIA_VIDEO) || equalsPermission(str, Permission.READ_MEDIA_AUDIO))) {
                isSpecialPermission = true;
            }
            if (!AndroidVersion.isAndroid12() && (equalsPermission(str, Permission.BLUETOOTH_SCAN) || equalsPermission(str, Permission.BLUETOOTH_CONNECT) || equalsPermission(str, Permission.BLUETOOTH_ADVERTISE))) {
                isSpecialPermission = true;
            }
            if (!AndroidVersion.isAndroid10() && (equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION) || equalsPermission(str, Permission.ACTIVITY_RECOGNITION) || equalsPermission(str, Permission.ACCESS_MEDIA_LOCATION))) {
                isSpecialPermission = true;
            }
            if (!AndroidVersion.isAndroid9() && equalsPermission(str, Permission.ACCEPT_HANDOVER)) {
                isSpecialPermission = true;
            }
            if (!AndroidVersion.isAndroid8() && (equalsPermission(str, Permission.ANSWER_PHONE_CALLS) || equalsPermission(str, Permission.READ_PHONE_NUMBERS))) {
                isSpecialPermission = true;
            }
            if (!equalsPermission(str, Permission.GET_INSTALLED_APPS)) {
                z2 = isSpecialPermission;
            }
            if (z2) {
                if (PermissionApi.isGrantedPermission(activity, str)) {
                    i = 0;
                } else {
                    i = -1;
                }
                iArr[i5] = i;
            }
        }
    }

    public static void postActivityResult(@NonNull List<String> list, @NonNull Runnable runnable) {
        long j2;
        long j4 = 300;
        if (AndroidVersion.isAndroid11()) {
            j2 = 200;
        } else {
            j2 = 300;
        }
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains("huawei")) {
            if (!AndroidVersion.isAndroid8()) {
                j4 = 500;
            }
        } else if (lowerCase.contains("xiaomi") && AndroidVersion.isAndroid11() && containsPermission(list, Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)) {
            j4 = 1000;
        } else {
            j4 = j2;
        }
        HANDLER.postDelayed(runnable, j4);
    }

    public static void postDelayed(@NonNull Runnable runnable, long j2) {
        HANDLER.postDelayed(runnable, j2);
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String str) {
        if (AndroidVersion.getAndroidVersionCode() == 31) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
