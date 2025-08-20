package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import f2.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class XXPermissions {
    private static Boolean sCheckMode;
    private static IPermissionInterceptor sInterceptor;
    @Nullable
    private Boolean mCheckMode;
    @Nullable
    private final Context mContext;
    @Nullable
    private IPermissionInterceptor mInterceptor;
    @NonNull
    private List<String> mPermissions = new ArrayList();

    private XXPermissions(@Nullable Context context) {
        this.mContext = context;
    }

    public static boolean containsSpecial(@NonNull String... strArr) {
        return containsSpecial(PermissionUtils.asArrayList(strArr));
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull String... strArr) {
        return getDenied(context, PermissionUtils.asArrayList(strArr));
    }

    public static IPermissionInterceptor getInterceptor() {
        if (sInterceptor == null) {
            sInterceptor = new IPermissionInterceptor() { // from class: com.hjq.permissions.XXPermissions.1
                @Override // com.hjq.permissions.IPermissionInterceptor
                public /* synthetic */ void deniedPermissionRequest(Activity activity, List list, List list2, boolean z2, OnPermissionCallback onPermissionCallback) {
                    y.y(this, activity, list, list2, z2, onPermissionCallback);
                }

                @Override // com.hjq.permissions.IPermissionInterceptor
                public /* synthetic */ void finishPermissionRequest(Activity activity, List list, boolean z2, OnPermissionCallback onPermissionCallback) {
                    y.n3(this, activity, list, z2, onPermissionCallback);
                }

                @Override // com.hjq.permissions.IPermissionInterceptor
                public /* synthetic */ void grantedPermissionRequest(Activity activity, List list, List list2, boolean z2, OnPermissionCallback onPermissionCallback) {
                    y.zn(this, activity, list, list2, z2, onPermissionCallback);
                }

                @Override // com.hjq.permissions.IPermissionInterceptor
                public /* synthetic */ void launchPermissionRequest(Activity activity, List list, OnPermissionCallback onPermissionCallback) {
                    y.gv(this, activity, list, onPermissionCallback);
                }
            };
        }
        return sInterceptor;
    }

    private boolean isCheckMode(@NonNull Context context) {
        if (this.mCheckMode == null) {
            if (sCheckMode == null) {
                sCheckMode = Boolean.valueOf(PermissionUtils.isDebugMode(context));
            }
            this.mCheckMode = sCheckMode;
        }
        return this.mCheckMode.booleanValue();
    }

    public static boolean isGranted(@NonNull Context context, @NonNull String... strArr) {
        return isGranted(context, PermissionUtils.asArrayList(strArr));
    }

    public static boolean isPermanentDenied(@NonNull Activity activity, @NonNull String... strArr) {
        return isPermanentDenied(activity, PermissionUtils.asArrayList(strArr));
    }

    public static boolean isSpecial(@NonNull String str) {
        return PermissionApi.isSpecialPermission(str);
    }

    public static void setCheckMode(boolean z2) {
        sCheckMode = Boolean.valueOf(z2);
    }

    public static void setInterceptor(IPermissionInterceptor iPermissionInterceptor) {
        sInterceptor = iPermissionInterceptor;
    }

    public static void startPermissionActivity(@NonNull Context context) {
        startPermissionActivity(context, new ArrayList(0));
    }

    public static XXPermissions with(@NonNull Context context) {
        return new XXPermissions(context);
    }

    public XXPermissions interceptor(@Nullable IPermissionInterceptor iPermissionInterceptor) {
        this.mInterceptor = iPermissionInterceptor;
        return this;
    }

    public XXPermissions permission(@Nullable String... strArr) {
        return permission(PermissionUtils.asArrayList(strArr));
    }

    public void request(@Nullable OnPermissionCallback onPermissionCallback) {
        if (this.mContext == null) {
            return;
        }
        if (this.mInterceptor == null) {
            this.mInterceptor = getInterceptor();
        }
        Context context = this.mContext;
        IPermissionInterceptor iPermissionInterceptor = this.mInterceptor;
        ArrayList arrayList = new ArrayList(this.mPermissions);
        boolean isCheckMode = isCheckMode(context);
        Activity findActivity = PermissionUtils.findActivity(context);
        if (!PermissionChecker.checkActivityStatus(findActivity, isCheckMode) || !PermissionChecker.checkPermissionArgument(arrayList, isCheckMode)) {
            return;
        }
        if (isCheckMode) {
            AndroidManifestInfo androidManifestInfo = PermissionUtils.getAndroidManifestInfo(context);
            PermissionChecker.checkMediaLocationPermission(context, arrayList);
            PermissionChecker.checkStoragePermission(context, arrayList, androidManifestInfo);
            PermissionChecker.checkBodySensorsPermission(arrayList);
            PermissionChecker.checkLocationPermission(arrayList);
            PermissionChecker.checkPictureInPicturePermission(findActivity, arrayList, androidManifestInfo);
            PermissionChecker.checkNotificationListenerPermission(arrayList, androidManifestInfo);
            PermissionChecker.checkNearbyDevicesPermission(arrayList, androidManifestInfo);
            PermissionChecker.checkTargetSdkVersion(context, arrayList);
            PermissionChecker.checkManifestPermissions(context, arrayList, androidManifestInfo);
        }
        PermissionChecker.optimizeDeprecatedPermission(arrayList);
        if (PermissionApi.isGrantedPermissions(context, arrayList)) {
            if (onPermissionCallback != null) {
                iPermissionInterceptor.grantedPermissionRequest(findActivity, arrayList, arrayList, true, onPermissionCallback);
                iPermissionInterceptor.finishPermissionRequest(findActivity, arrayList, true, onPermissionCallback);
                return;
            }
            return;
        }
        iPermissionInterceptor.launchPermissionRequest(findActivity, arrayList, onPermissionCallback);
    }

    public boolean revokeOnKill() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        List<String> list = this.mPermissions;
        if (list.isEmpty() || !AndroidVersion.isAndroid13()) {
            return false;
        }
        try {
            if (list.size() == 1) {
                context.revokeSelfPermissionOnKill(list.get(0));
            } else {
                context.revokeSelfPermissionsOnKill(list);
            }
            return true;
        } catch (IllegalArgumentException e2) {
            if (!isCheckMode(context)) {
                e2.printStackTrace();
                return false;
            }
            throw e2;
        }
    }

    public XXPermissions unchecked() {
        this.mCheckMode = Boolean.FALSE;
        return this;
    }

    public static boolean containsSpecial(@NonNull List<String> list) {
        return PermissionApi.containsSpecialPermission(list);
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull String[]... strArr) {
        return getDenied(context, PermissionUtils.asArrayLists(strArr));
    }

    public static boolean isGranted(@NonNull Context context, @NonNull String[]... strArr) {
        return isGranted(context, PermissionUtils.asArrayLists(strArr));
    }

    public static boolean isPermanentDenied(@NonNull Activity activity, @NonNull String[]... strArr) {
        return isPermanentDenied(activity, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull String... strArr) {
        startPermissionActivity(context, PermissionUtils.asArrayList(strArr));
    }

    public static XXPermissions with(@NonNull Fragment fragment) {
        return with(fragment.getActivity());
    }

    public XXPermissions permission(@Nullable String[]... strArr) {
        return permission(PermissionUtils.asArrayLists(strArr));
    }

    public static List<String> getDenied(@NonNull Context context, @NonNull List<String> list) {
        return PermissionApi.getDeniedPermissions(context, list);
    }

    public static boolean isGranted(@NonNull Context context, @NonNull List<String> list) {
        return PermissionApi.isGrantedPermissions(context, list);
    }

    public static boolean isPermanentDenied(@NonNull Activity activity, @NonNull List<String> list) {
        return PermissionApi.isPermissionPermanentDenied(activity, list);
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull String[]... strArr) {
        startPermissionActivity(context, PermissionUtils.asArrayLists(strArr));
    }

    public static XXPermissions with(@NonNull androidx.fragment.app.Fragment fragment) {
        return with(fragment.getActivity());
    }

    public XXPermissions permission(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!PermissionUtils.containsPermission(this.mPermissions, str)) {
                    this.mPermissions.add(str);
                }
            }
        }
        return this;
    }

    public static void startPermissionActivity(@NonNull Context context, @NonNull List<String> list) {
        Activity findActivity = PermissionUtils.findActivity(context);
        if (findActivity != null) {
            startPermissionActivity(findActivity, list);
            return;
        }
        Intent smartPermissionIntent = PermissionUtils.getSmartPermissionIntent(context, list);
        if (!(context instanceof Activity)) {
            smartPermissionIntent.addFlags(268435456);
        }
        context.startActivity(smartPermissionIntent);
    }

    public static void startPermissionActivity(@NonNull Activity activity) {
        startPermissionActivity(activity, (List<String>) new ArrayList(0));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String... strArr) {
        startPermissionActivity(activity, (List<String>) PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String[]... strArr) {
        startPermissionActivity(activity, (List<String>) PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list) {
        startPermissionActivity(activity, list, 1025);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list, int i) {
        activity.startActivityForResult(PermissionUtils.getSmartPermissionIntent(activity, list), i);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String str, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(activity, PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull String[] strArr, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(activity, PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull Activity activity, @NonNull List<String> list, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        if (list.isEmpty()) {
            activity.startActivity(PermissionUtils.getApplicationDetailsIntent(activity));
        } else {
            PermissionPageFragment.beginRequest(activity, (ArrayList) list, onPermissionPageCallback);
        }
    }

    public static void startPermissionActivity(@NonNull Fragment fragment) {
        startPermissionActivity(fragment, new ArrayList(0));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String[]... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list) {
        startPermissionActivity(fragment, list, 1025);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list, int i) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (list.isEmpty()) {
            fragment.startActivity(PermissionUtils.getApplicationDetailsIntent(activity));
        } else {
            fragment.startActivityForResult(PermissionUtils.getSmartPermissionIntent(activity, list), i);
        }
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String str, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull String[] strArr, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull Fragment fragment, @NonNull List<String> list, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        Activity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (AndroidVersion.isAndroid4_2() && activity.isDestroyed()) {
            return;
        }
        if (list.isEmpty()) {
            fragment.startActivity(PermissionUtils.getApplicationDetailsIntent(activity));
        } else {
            PermissionPageFragment.beginRequest(activity, (ArrayList) list, onPermissionPageCallback);
        }
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment) {
        startPermissionActivity(fragment, new ArrayList());
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String[]... strArr) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list) {
        startPermissionActivity(fragment, list, 1025);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list, int i) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (list.isEmpty()) {
            fragment.startActivity(PermissionUtils.getApplicationDetailsIntent(activity));
        } else {
            fragment.startActivityForResult(PermissionUtils.getSmartPermissionIntent(activity, list), i);
        }
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String str, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull String[] strArr, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(@NonNull androidx.fragment.app.Fragment fragment, @NonNull List<String> list, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (AndroidVersion.isAndroid4_2() && activity.isDestroyed()) {
            return;
        }
        if (list.isEmpty()) {
            fragment.startActivity(PermissionUtils.getApplicationDetailsIntent(activity));
        } else {
            PermissionPageFragment.beginRequest(activity, (ArrayList) list, onPermissionPageCallback);
        }
    }
}
