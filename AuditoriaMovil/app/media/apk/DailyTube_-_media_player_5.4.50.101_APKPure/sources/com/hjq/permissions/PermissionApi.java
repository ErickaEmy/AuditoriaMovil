package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
final class PermissionApi {
    @NonNull
    private static final PermissionDelegate DELEGATE;

    static {
        if (AndroidVersion.isAndroid13()) {
            DELEGATE = new PermissionDelegateImplV33();
        } else if (AndroidVersion.isAndroid12()) {
            DELEGATE = new PermissionDelegateImplV31();
        } else if (AndroidVersion.isAndroid11()) {
            DELEGATE = new PermissionDelegateImplV30();
        } else if (AndroidVersion.isAndroid10()) {
            DELEGATE = new PermissionDelegateImplV29();
        } else if (AndroidVersion.isAndroid9()) {
            DELEGATE = new PermissionDelegateImplV28();
        } else if (AndroidVersion.isAndroid8()) {
            DELEGATE = new PermissionDelegateImplV26();
        } else if (AndroidVersion.isAndroid6()) {
            DELEGATE = new PermissionDelegateImplV23();
        } else {
            DELEGATE = new PermissionDelegateImplV14();
        }
    }

    public static boolean containsSpecialPermission(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (isSpecialPermission(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> getDeniedPermissions(@NonNull Context context, @NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (!isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static List<String> getGrantedPermissions(@NonNull Context context, @NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        return DELEGATE.getPermissionIntent(context, str);
    }

    public static boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        return DELEGATE.isGrantedPermission(context, str);
    }

    public static boolean isGrantedPermissions(@NonNull Context context, @NonNull List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            if (!isGrantedPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str) {
        return DELEGATE.isPermissionPermanentDenied(activity, str);
    }

    public static boolean isSpecialPermission(@NonNull String str) {
        return PermissionUtils.isSpecialPermission(str);
    }

    public static boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull List<String> list) {
        for (String str : list) {
            if (isPermissionPermanentDenied(activity, str)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getDeniedPermissions(@NonNull List<String> list, @NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == -1) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public static List<String> getGrantedPermissions(@NonNull List<String> list, @NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }
}
