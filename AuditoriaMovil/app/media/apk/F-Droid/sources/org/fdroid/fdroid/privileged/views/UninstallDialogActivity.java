package org.fdroid.fdroid.privileged.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.installer.Installer;
/* loaded from: classes2.dex */
public class UninstallDialogActivity extends FragmentActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = getIntent();
        final App app = (App) intent.getParcelableExtra(Installer.EXTRA_APP);
        final Apk apk = (Apk) intent.getParcelableExtra(Installer.EXTRA_APK);
        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(apk.packageName, 8192);
            int i = applicationInfo.flags;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 128) != 0;
            if (z && !z2) {
                throw new RuntimeException("Cannot remove system apps unless we're uninstalling updates");
            }
            int i2 = z2 ? R.string.uninstall_update_confirm : R.string.uninstall_confirm;
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App);
            builder.setTitle(applicationInfo.loadLabel(packageManager));
            builder.setIcon(applicationInfo.loadIcon(packageManager));
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.privileged.views.UninstallDialogActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    UninstallDialogActivity.this.lambda$onCreate$0(app, apk, intent, dialogInterface, i3);
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.privileged.views.UninstallDialogActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    UninstallDialogActivity.this.lambda$onCreate$1(dialogInterface, i3);
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.fdroid.fdroid.privileged.views.UninstallDialogActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    UninstallDialogActivity.this.lambda$onCreate$2(dialogInterface);
                }
            });
            builder.setMessage(i2);
            builder.create().show();
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("UninstallDialogActivity", "Package to uninstall not found: " + apk.packageName, e);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(App app, Apk apk, Intent intent, DialogInterface dialogInterface, int i) {
        Intent intent2 = new Intent();
        intent2.putExtra(Installer.EXTRA_APP, app);
        intent2.putExtra(Installer.EXTRA_APK, apk);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(DialogInterface dialogInterface, int i) {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(DialogInterface dialogInterface) {
        setResult(0);
        finish();
    }
}
