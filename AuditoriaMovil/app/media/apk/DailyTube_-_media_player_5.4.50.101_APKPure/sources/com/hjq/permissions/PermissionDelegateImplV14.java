package com.hjq.permissions;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PermissionDelegateImplV14 implements PermissionDelegate {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.Intent getNotificationListenerIntent(@androidx.annotation.NonNull android.content.Context r6) {
        /*
            boolean r0 = com.hjq.permissions.AndroidVersion.isAndroid11()
            r1 = 0
            if (r0 == 0) goto L52
            com.hjq.permissions.AndroidManifestInfo r0 = com.hjq.permissions.PermissionUtils.getAndroidManifestInfo(r6)
            if (r0 == 0) goto L2d
            java.util.List<com.hjq.permissions.AndroidManifestInfo$ServiceInfo> r0 = r0.serviceInfoList
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L14:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L31
            java.lang.Object r3 = r0.next()
            com.hjq.permissions.AndroidManifestInfo$ServiceInfo r3 = (com.hjq.permissions.AndroidManifestInfo.ServiceInfo) r3
            java.lang.String r4 = r3.permission
            java.lang.String r5 = "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE"
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 != 0) goto L2b
            goto L14
        L2b:
            if (r2 == 0) goto L2f
        L2d:
            r2 = r1
            goto L31
        L2f:
            r2 = r3
            goto L14
        L31:
            if (r2 == 0) goto L52
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS"
            r0.<init>(r3)
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r2 = r2.name
            r3.<init>(r6, r2)
            java.lang.String r2 = r3.flattenToString()
            java.lang.String r3 = "android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME"
            r0.putExtra(r3, r2)
            boolean r2 = com.hjq.permissions.PermissionUtils.areActivityIntent(r6, r0)
            if (r2 != 0) goto L51
            goto L52
        L51:
            r1 = r0
        L52:
            if (r1 != 0) goto L69
            boolean r0 = com.hjq.permissions.AndroidVersion.isAndroid5_1()
            java.lang.String r1 = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            if (r0 == 0) goto L63
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r1)
        L61:
            r1 = r0
            goto L69
        L63:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r1)
            goto L61
        L69:
            boolean r0 = com.hjq.permissions.PermissionUtils.areActivityIntent(r6, r1)
            if (r0 != 0) goto L73
            android.content.Intent r1 = com.hjq.permissions.PermissionUtils.getApplicationDetailsIntent(r6)
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hjq.permissions.PermissionDelegateImplV14.getNotificationListenerIntent(android.content.Context):android.content.Intent");
    }

    private static Intent getNotifyPermissionIntent(@NonNull Context context) {
        Intent intent;
        if (AndroidVersion.isAndroid8()) {
            intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else {
            intent = null;
        }
        if (intent == null || !PermissionUtils.areActivityIntent(context, intent)) {
            return PermissionUtils.getApplicationDetailsIntent(context);
        }
        return intent;
    }

    private static Intent getPackagePermissionIntent(@NonNull Context context) {
        Intent intent;
        if (AndroidVersion.isAndroid5()) {
            intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
            if (AndroidVersion.isAndroid10()) {
                intent.setData(PermissionUtils.getPackageNameUri(context));
            }
        } else {
            intent = null;
        }
        if (intent == null || !PermissionUtils.areActivityIntent(context, intent)) {
            return PermissionUtils.getApplicationDetailsIntent(context);
        }
        return intent;
    }

    private static Intent getVpnPermissionIntent(@NonNull Context context) {
        Intent prepare = VpnService.prepare(context);
        if (prepare == null || !PermissionUtils.areActivityIntent(context, prepare)) {
            return PermissionUtils.getApplicationDetailsIntent(context);
        }
        return prepare;
    }

    private static boolean isGrantedNotificationListenerPermission(@NonNull Context context) {
        if (AndroidVersion.isAndroid4_3()) {
            return NotificationManagerCompat.zn(context).contains(context.getPackageName());
        }
        return true;
    }

    private static boolean isGrantedNotifyPermission(@NonNull Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    private static boolean isGrantedPackagePermission(@NonNull Context context) {
        int checkOpNoThrow;
        if (!AndroidVersion.isAndroid5()) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        if (AndroidVersion.isAndroid10()) {
            checkOpNoThrow = appOpsManager.unsafeCheckOpNoThrow("android:get_usage_stats", context.getApplicationInfo().uid, context.getPackageName());
        } else {
            checkOpNoThrow = appOpsManager.checkOpNoThrow("android:get_usage_stats", context.getApplicationInfo().uid, context.getPackageName());
        }
        if (checkOpNoThrow == 0) {
            return true;
        }
        return false;
    }

    private static boolean isGrantedVpnPermission(@NonNull Context context) {
        if (VpnService.prepare(context) == null) {
            return true;
        }
        return false;
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.NOTIFICATION_SERVICE)) {
            return getNotifyPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.PACKAGE_USAGE_STATS)) {
            return getPackagePermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
            return getNotificationListenerIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.BIND_VPN_SERVICE)) {
            return getVpnPermissionIntent(context);
        }
        if (!AndroidVersion.isAndroid13() && PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS)) {
            return getNotifyPermissionIntent(context);
        }
        return PermissionUtils.getApplicationDetailsIntent(context);
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.NOTIFICATION_SERVICE)) {
            return isGrantedNotifyPermission(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.PACKAGE_USAGE_STATS)) {
            return isGrantedPackagePermission(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
            return isGrantedNotificationListenerPermission(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.BIND_VPN_SERVICE)) {
            return isGrantedVpnPermission(context);
        }
        if (!AndroidVersion.isAndroid13() && PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS)) {
            return isGrantedNotifyPermission(context);
        }
        return true;
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(@NonNull Activity activity, @NonNull String str) {
        return false;
    }
}
