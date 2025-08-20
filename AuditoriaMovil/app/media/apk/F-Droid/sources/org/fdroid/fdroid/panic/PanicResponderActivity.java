package org.fdroid.fdroid.panic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import info.guardianproject.panic.Panic;
import info.guardianproject.panic.PanicResponder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.data.DBHelper;
import org.fdroid.fdroid.installer.Installer;
import org.fdroid.fdroid.installer.InstallerService;
import org.fdroid.fdroid.installer.PrivilegedInstaller;
/* loaded from: classes2.dex */
public class PanicResponderActivity extends AppCompatActivity {
    private static final String TAG = "PanicResponderActivity";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!Panic.isTriggerIntent(getIntent())) {
            finish();
            return;
        }
        String str = TAG;
        Log.i(str, "Received Panic Trigger...");
        final Preferences preferences = Preferences.get();
        boolean receivedTriggerFromConnectedApp = PanicResponder.receivedTriggerFromConnectedApp(this);
        boolean isDefault = PrivilegedInstaller.isDefault(this);
        ArrayList arrayList = new ArrayList(preferences.getPanicWipeSet());
        preferences.setPanicWipeSet(Collections.emptySet());
        preferences.setPanicTmpSelectedSet(Collections.emptySet());
        if (receivedTriggerFromConnectedApp && isDefault && arrayList.size() > 0) {
            if (arrayList.contains(getPackageName())) {
                arrayList.remove(getPackageName());
                arrayList.add(getPackageName());
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
            final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: org.fdroid.fdroid.panic.PanicResponderActivity.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    action.hashCode();
                    if (action.equals(Installer.ACTION_UNINSTALL_COMPLETE) || action.equals(Installer.ACTION_UNINSTALL_INTERRUPTED)) {
                        countDownLatch.countDown();
                    }
                }
            };
            localBroadcastManager.registerReceiver(broadcastReceiver, Installer.getUninstallIntentFilter((String) arrayList.get(arrayList.size() - 1)));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                App app = new App();
                Apk apk = new Apk();
                app.packageName = str2;
                apk.packageName = str2;
                InstallerService.uninstall(this, app, apk);
            }
            new Thread() { // from class: org.fdroid.fdroid.panic.PanicResponderActivity.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        countDownLatch.await(10L, TimeUnit.MINUTES);
                    } catch (InterruptedException unused) {
                    }
                    localBroadcastManager.unregisterReceiver(broadcastReceiver);
                    if (preferences.panicResetRepos()) {
                        PanicResponderActivity.resetRepos(this);
                    }
                    if (preferences.panicHide()) {
                        HidingManager.hide(this);
                    }
                    if (preferences.panicExit()) {
                        PanicResponderActivity.this.exitAndClear();
                    }
                }
            }.start();
        } else if (receivedTriggerFromConnectedApp) {
            if (preferences.panicResetRepos()) {
                resetRepos(this);
            }
            if (preferences.panicHide()) {
                Log.i(str, "Hiding app...");
                HidingManager.hide(this);
            }
        }
        if (!isDefault && preferences.panicExit()) {
            exitAndClear();
        }
        finish();
    }

    static void resetRepos(Context context) {
        DBHelper.resetRepos(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitAndClear() {
        ExitActivity.exitAndRemoveFromRecentApps(this);
        finishAndRemoveTask();
    }
}
