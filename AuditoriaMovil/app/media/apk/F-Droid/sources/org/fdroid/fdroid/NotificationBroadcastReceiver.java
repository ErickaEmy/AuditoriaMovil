package org.fdroid.fdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.fdroid.fdroid.AppUpdateStatusManager;
import org.fdroid.fdroid.net.DownloaderService;
/* loaded from: classes2.dex */
public class NotificationBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AppUpdateStatusManager appUpdateStatusManager = AppUpdateStatusManager.getInstance(context);
        String stringExtra = intent.getStringExtra(DownloaderService.EXTRA_CANONICAL_URL);
        String action = intent.getAction();
        action.hashCode();
        char c = 65535;
        switch (action.hashCode()) {
            case -296486547:
                if (action.equals("org.fdroid.fdroid.installer.notifications.allinstalled.cleared")) {
                    c = 0;
                    break;
                }
                break;
            case -136277694:
                if (action.equals("org.fdroid.fdroid.installer.notifications.installed.cleared")) {
                    c = 1;
                    break;
                }
                break;
            case 855628797:
                if (action.equals("org.fdroid.fdroid.installer.notifications.allupdates.cleared")) {
                    c = 2;
                    break;
                }
                break;
            case 1238359997:
                if (action.equals("org.fdroid.fdroid.installer.notifications.update.cleared")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                appUpdateStatusManager.clearAllInstalled();
                return;
            case 1:
                appUpdateStatusManager.removeApk(stringExtra);
                return;
            case 2:
                appUpdateStatusManager.clearAllUpdates();
                return;
            case 3:
                AppUpdateStatusManager.AppUpdateStatus appUpdateStatus = appUpdateStatusManager.get(stringExtra);
                if (appUpdateStatus == null || appUpdateStatus.status != AppUpdateStatusManager.Status.InstallError) {
                    return;
                }
                appUpdateStatusManager.removeApk(stringExtra);
                return;
            default:
                return;
        }
    }
}
