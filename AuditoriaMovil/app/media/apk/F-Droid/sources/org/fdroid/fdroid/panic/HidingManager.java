package org.fdroid.fdroid.panic;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationManagerCompat;
import org.fdroid.fdroid.BuildConfig;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.views.main.MainActivity;
/* loaded from: classes2.dex */
public class HidingManager {
    private static final ComponentName LAUNCHER_NAME = new ComponentName(BuildConfig.APPLICATION_ID, MainActivity.class.getName());
    private static final ComponentName CALCULATOR_NAME = new ComponentName(BuildConfig.APPLICATION_ID, CalculatorActivity.class.getName());

    public static int getUnhidePin(Context context) {
        return context.getResources().getInteger(R.integer.unhidePin);
    }

    public static boolean isHidden(Context context) {
        return context.getPackageManager().getComponentEnabledSetting(LAUNCHER_NAME) == 2;
    }

    public static void showHideDialog(final Context context) {
        String string = context.getString(R.string.app_name);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.hiding_dialog_title, string));
        builder.setMessage(context.getString(R.string.hiding_dialog_message, string, Integer.valueOf(getUnhidePin(context)), context.getString(R.string.hiding_calculator)));
        builder.setPositiveButton(context.getString(R.string.panic_hide_title, string), new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.panic.HidingManager$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                HidingManager.hide(context);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.panic.HidingManager$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setView(R.layout.dialog_app_hiding);
        builder.create().show();
    }

    public static void hide(Context context) {
        stopServices(context);
        removeNotifications(context);
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(LAUNCHER_NAME, 2, 1);
        packageManager.setComponentEnabledSetting(CALCULATOR_NAME, 1, 0);
    }

    public static void show(Context context) {
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(LAUNCHER_NAME, 1, 1);
        packageManager.setComponentEnabledSetting(CALCULATOR_NAME, 2, 0);
    }

    private static void removeNotifications(Context context) {
        NotificationManagerCompat.from(context).cancelAll();
    }

    private static void stopServices(Context context) {
        ServiceInfo[] serviceInfoArr;
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, serviceInfo.name));
                context.stopService(intent);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
