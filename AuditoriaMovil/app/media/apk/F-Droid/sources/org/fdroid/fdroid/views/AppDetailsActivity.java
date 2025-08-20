package org.fdroid.fdroid.views;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.ObjectsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.MaterialToolbar;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.fdroid.database.AppPrefs;
import org.fdroid.database.AppVersion;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.AppUpdateStatusManager;
import org.fdroid.fdroid.CompatibilityChecker;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.data.Apk;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.installer.ErrorDialogActivity;
import org.fdroid.fdroid.installer.InstallManagerService;
import org.fdroid.fdroid.installer.Installer;
import org.fdroid.fdroid.installer.InstallerFactory;
import org.fdroid.fdroid.installer.InstallerService;
import org.fdroid.fdroid.nearby.PublicSourceDirProvider;
import org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter;
import org.fdroid.fdroid.views.appdetails.AppData;
import org.fdroid.fdroid.views.appdetails.AppDetailsViewModel;
import org.fdroid.fdroid.views.apps.FeatureImage;
/* loaded from: classes2.dex */
public class AppDetailsActivity extends AppCompatActivity implements AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks {
    public static final String EXTRA_APPID = "appid";
    private static final int REQUEST_ENABLE_BLUETOOTH = 2;
    private static final int REQUEST_PERMISSION_DIALOG = 3;
    private static final int REQUEST_UNINSTALL_DIALOG = 4;
    private static final String TAG = "AppDetailsActivity";
    private static String visiblePackageName;
    private AppDetailsRecyclerViewAdapter adapter;
    private volatile App app;
    private volatile AppPrefs appPrefs;
    private CompatibilityChecker checker;
    private AppUpdateStatusManager.AppUpdateStatus currentStatus;
    private FDroidApp fdroidApp;
    private LocalBroadcastManager localBroadcastManager;
    private AppDetailsViewModel model;
    private String packageName;
    private RecyclerView recyclerView;
    private volatile List<Apk> versions;
    private final BroadcastReceiver appStatusReceiver = new BroadcastReceiver() { // from class: org.fdroid.fdroid.views.AppDetailsActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AppUpdateStatusManager.AppUpdateStatus appUpdateStatus = (AppUpdateStatusManager.AppUpdateStatus) intent.getParcelableExtra(AppUpdateStatusManager.EXTRA_STATUS);
            boolean equals = TextUtils.equals(intent.getAction(), AppUpdateStatusManager.BROADCAST_APPSTATUS_REMOVED);
            if (AppDetailsActivity.this.currentStatus != null && equals && !TextUtils.equals(appUpdateStatus.getCanonicalUrl(), AppDetailsActivity.this.currentStatus.getCanonicalUrl())) {
                Utils.debugLog(AppDetailsActivity.TAG, "Ignoring app status change because it belongs to " + appUpdateStatus.getCanonicalUrl() + " not " + AppDetailsActivity.this.currentStatus.getCanonicalUrl());
            } else if (appUpdateStatus != null && AppDetailsActivity.this.app != null && !TextUtils.equals(appUpdateStatus.apk.packageName, AppDetailsActivity.this.app.packageName)) {
                Utils.debugLog(AppDetailsActivity.TAG, "Ignoring app status change because it belongs to " + appUpdateStatus.apk.packageName + " not " + AppDetailsActivity.this.app.packageName);
            } else {
                AppDetailsActivity.this.updateAppStatus(appUpdateStatus, true);
            }
        }
    };
    private final BroadcastReceiver installReceiver = new BroadcastReceiver() { // from class: org.fdroid.fdroid.views.AppDetailsActivity.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Apk apk;
            String action = intent.getAction();
            action.hashCode();
            char c = 65535;
            switch (action.hashCode()) {
                case -1212871076:
                    if (action.equals(Installer.ACTION_INSTALL_INTERRUPTED)) {
                        c = 0;
                        break;
                    }
                    break;
                case -364080252:
                    if (action.equals(Installer.ACTION_INSTALL_USER_INTERACTION)) {
                        c = 1;
                        break;
                    }
                    break;
                case 107103643:
                    if (action.equals(Installer.ACTION_INSTALL_STARTED)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1403965247:
                    if (action.equals(Installer.ACTION_INSTALL_COMPLETE)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    AppDetailsActivity.this.adapter.clearProgress();
                    if (AppDetailsActivity.this.app != null) {
                        AppDetailsActivity appDetailsActivity = AppDetailsActivity.this;
                        appDetailsActivity.onAppChanged(appDetailsActivity.app);
                    }
                    String stringExtra = intent.getStringExtra(Installer.EXTRA_ERROR_MESSAGE);
                    if (!TextUtils.isEmpty(stringExtra) && !AppDetailsActivity.this.isFinishing()) {
                        Log.e(AppDetailsActivity.TAG, "install aborted with errorMessage: " + stringExtra);
                        AppDetailsActivity appDetailsActivity2 = AppDetailsActivity.this;
                        int i = R.string.install_error_notify_title;
                        Object[] objArr = new Object[1];
                        objArr[0] = appDetailsActivity2.app == null ? "" : AppDetailsActivity.this.app.name;
                        AppDetailsActivity.this.startActivity(new Intent(context, ErrorDialogActivity.class).putExtra("title", appDetailsActivity2.getString(i, objArr)).putExtra(ErrorDialogActivity.EXTRA_MESSAGE, stringExtra));
                    }
                    AppDetailsActivity.this.unregisterInstallReceiver();
                    return;
                case 1:
                    if (!AppDetailsActivity.isAppVisible(((Apk) intent.getParcelableExtra(Installer.EXTRA_APK)).packageName)) {
                        Utils.debugLog(AppDetailsActivity.TAG, "Ignore request for user interaction from installer, because " + apk.packageName + " is no longer showing.");
                        return;
                    }
                    Utils.debugLog(AppDetailsActivity.TAG, "Automatically showing package manager for " + apk.packageName + " as it is being viewed by the user.");
                    try {
                        ((PendingIntent) intent.getParcelableExtra(Installer.EXTRA_USER_INTERACTION_PI)).send();
                        return;
                    } catch (PendingIntent.CanceledException e) {
                        Log.e(AppDetailsActivity.TAG, "PI canceled", e);
                        return;
                    }
                case 2:
                    AppDetailsActivity.this.adapter.setIndeterminateProgress(R.string.installing);
                    return;
                case 3:
                    AppDetailsActivity.this.adapter.clearProgress();
                    AppDetailsActivity.this.unregisterInstallReceiver();
                    if (AppDetailsActivity.this.app != null) {
                        AppDetailsActivity appDetailsActivity3 = AppDetailsActivity.this;
                        AppDetailsActivity.this.app.setInstalled(appDetailsActivity3.getPackageInfo(appDetailsActivity3.app.packageName));
                        AppDetailsActivity appDetailsActivity4 = AppDetailsActivity.this;
                        appDetailsActivity4.onAppChanged(appDetailsActivity4.app);
                        return;
                    }
                    return;
                default:
                    throw new RuntimeException("intent action not handled!");
            }
        }
    };
    private final BroadcastReceiver uninstallReceiver = new BroadcastReceiver() { // from class: org.fdroid.fdroid.views.AppDetailsActivity.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            char c = 65535;
            switch (action.hashCode()) {
                case -1879601566:
                    if (action.equals(Installer.ACTION_UNINSTALL_STARTED)) {
                        c = 0;
                        break;
                    }
                    break;
                case -448841059:
                    if (action.equals(Installer.ACTION_UNINSTALL_USER_INTERACTION)) {
                        c = 1;
                        break;
                    }
                    break;
                case -54354088:
                    if (action.equals(Installer.ACTION_UNINSTALL_COMPLETE)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1884986275:
                    if (action.equals(Installer.ACTION_UNINSTALL_INTERRUPTED)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    AppDetailsActivity.this.adapter.setIndeterminateProgress(R.string.uninstalling);
                    return;
                case 1:
                    try {
                        ((PendingIntent) intent.getParcelableExtra(Installer.EXTRA_USER_INTERACTION_PI)).send();
                        return;
                    } catch (PendingIntent.CanceledException e) {
                        Log.e(AppDetailsActivity.TAG, "PI canceled", e);
                        return;
                    }
                case 2:
                    AppDetailsActivity.this.adapter.clearProgress();
                    if (AppDetailsActivity.this.app != null) {
                        AppDetailsActivity.this.app.installedSigner = null;
                        AppDetailsActivity.this.app.installedVersionCode = 0L;
                        AppDetailsActivity.this.app.installedVersionName = null;
                        AppDetailsActivity appDetailsActivity = AppDetailsActivity.this;
                        appDetailsActivity.onAppChanged(appDetailsActivity.app);
                    }
                    AppUpdateStatusManager.getInstance(context).checkForUpdates();
                    AppDetailsActivity.this.unregisterUninstallReceiver();
                    return;
                case 3:
                    AppDetailsActivity.this.adapter.clearProgress();
                    String stringExtra = intent.getStringExtra(Installer.EXTRA_ERROR_MESSAGE);
                    if (!TextUtils.isEmpty(stringExtra) && !AppDetailsActivity.this.isFinishing()) {
                        Log.e(AppDetailsActivity.TAG, "uninstall aborted with errorMessage: " + stringExtra);
                        AlertDialog.Builder builder = new AlertDialog.Builder(AppDetailsActivity.this);
                        Uri data = intent.getData();
                        if (data == null) {
                            builder.setTitle(AppDetailsActivity.this.getString(R.string.uninstall_error_notify_title, ""));
                        } else {
                            builder.setTitle(AppDetailsActivity.this.getString(R.string.uninstall_error_notify_title, data.getSchemeSpecificPart()));
                        }
                        builder.setMessage(stringExtra);
                        builder.setNeutralButton(17039370, null);
                        builder.create().show();
                    }
                    AppDetailsActivity.this.unregisterUninstallReceiver();
                    return;
                default:
                    throw new RuntimeException("intent action not handled!");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$installApk$2(DialogInterface dialogInterface, int i) {
    }

    public static boolean isAppVisible(String str) {
        return str != null && str.equals(visiblePackageName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FDroidApp fDroidApp = (FDroidApp) getApplication();
        this.fdroidApp = fDroidApp;
        fDroidApp.setSecureWindow(this);
        this.fdroidApp.applyPureBlackBackgroundInDarkTheme(this);
        super.onCreate(bundle);
        setContentView(R.layout.app_details2);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        supportPostponeEnterTransition();
        materialToolbar.setNavigationIcon(R.drawable.ic_arrow_back_with_background);
        materialToolbar.setOverflowIcon(AppCompatResources.getDrawable(materialToolbar.getContext(), R.drawable.ic_more_with_background));
        this.model = (AppDetailsViewModel) new ViewModelProvider(this).get(AppDetailsViewModel.class);
        this.localBroadcastManager = LocalBroadcastManager.getInstance(this);
        this.recyclerView = (RecyclerView) findViewById(R.id.rvDetails);
        this.adapter = new AppDetailsRecyclerViewAdapter(this, this.app, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.setStackFromEnd(false);
        String packageNameFromIntent = getPackageNameFromIntent(getIntent());
        this.packageName = packageNameFromIntent;
        if (TextUtils.isEmpty(packageNameFromIntent)) {
            finish();
            return;
        }
        this.model.loadApp(this.packageName);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.fdroid.fdroid.views.AppDetailsActivity$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                boolean lambda$onCreate$0;
                lambda$onCreate$0 = AppDetailsActivity.this.lambda$onCreate$0();
                return lambda$onCreate$0;
            }
        });
        this.checker = new CompatibilityChecker(this);
        this.model.getApp().observe(this, new Observer() { // from class: org.fdroid.fdroid.views.AppDetailsActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AppDetailsActivity.this.onAppChanged((org.fdroid.database.App) obj);
            }
        });
        this.model.getAppData().observe(this, new Observer() { // from class: org.fdroid.fdroid.views.AppDetailsActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AppDetailsActivity.this.onAppDataChanged((AppData) obj);
            }
        });
        this.model.getVersions().observe(this, new Observer() { // from class: org.fdroid.fdroid.views.AppDetailsActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AppDetailsActivity.this.onVersionsChanged((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$0() {
        supportStartPostponedEnterTransition();
        return true;
    }

    private String getPackageNameFromIntent(Intent intent) {
        if (!intent.hasExtra(EXTRA_APPID)) {
            Log.e(TAG, "No package name found in the intent!");
            return null;
        }
        return intent.getStringExtra(EXTRA_APPID);
    }

    private void updateNotificationsForApp() {
        AppUpdateStatusManager appUpdateStatusManager = AppUpdateStatusManager.getInstance(this);
        for (AppUpdateStatusManager.AppUpdateStatus appUpdateStatus : appUpdateStatusManager.getByPackageName(this.packageName)) {
            if (appUpdateStatus.status == AppUpdateStatusManager.Status.Installed) {
                appUpdateStatusManager.removeApk(appUpdateStatus.getCanonicalUrl());
            } else {
                appUpdateStatusManager.refreshApk(appUpdateStatus.getCanonicalUrl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        visiblePackageName = this.packageName;
        updateNotificationsForApp();
        refreshStatus();
        registerAppStatusReceiver();
        Glide.with((FragmentActivity) this).applyDefaultRequestOptions((RequestOptions) new RequestOptions().onlyRetrieveFromCache(!Preferences.get().isBackgroundDownloadAllowed()));
    }

    private void refreshStatus() {
        Iterator<AppUpdateStatusManager.AppUpdateStatus> it = AppUpdateStatusManager.getInstance(this).getByPackageName(this.packageName).iterator();
        if (it.hasNext()) {
            updateAppStatus(it.next(), false);
        } else {
            updateAppStatus(null, false);
        }
        this.currentStatus = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        visiblePackageName = null;
        unregisterAppStatusReceiver();
        updateNotificationsForApp();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.appPrefs == null || this.app == null) {
            return false;
        }
        getMenuInflater().inflate(R.menu.details2, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        AppPrefs appPrefs = this.appPrefs;
        if (appPrefs == null || this.app == null) {
            return false;
        }
        MenuItem findItem = menu.findItem(R.id.action_ignore_all);
        findItem.setChecked(appPrefs.getIgnoreAllUpdates());
        MenuItem findItem2 = menu.findItem(R.id.action_ignore_this);
        MenuItem findItem3 = menu.findItem(R.id.action_release_channel_beta);
        if (findItem.isChecked()) {
            findItem2.setEnabled(false);
            findItem3.setEnabled(false);
        } else if (this.app != null && this.versions != null) {
            findItem2.setVisible(this.app.hasUpdates(this.versions, this.appPrefs));
            findItem2.setChecked(appPrefs.shouldIgnoreUpdate(this.app.autoInstallVersionCode));
        }
        findItem3.setChecked(appPrefs.getReleaseChannels().contains("Beta"));
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_share) {
            String format = String.format("%s (%s)\nhttps://f-droid.org/packages/%s/", this.app.name, this.app.summary, this.app.packageName);
            Intent intent = new Intent("android.intent.action.SEND");
            Uri shareUri = this.app.getShareUri(this);
            if (shareUri != null) {
                intent.setData(shareUri);
            }
            intent.putExtra("android.intent.extra.TITLE", this.app.name);
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType(NanoHTTPD.MIME_PLAINTEXT);
            intent2.putExtra("android.intent.extra.SUBJECT", this.app.name);
            intent2.putExtra("android.intent.extra.TITLE", this.app.name);
            intent2.putExtra("android.intent.extra.TEXT", format);
            if (this.app.isInstalled(getApplicationContext())) {
                Intent apkShareIntent = PublicSourceDirProvider.getApkShareIntent(this, this.app.packageName);
                apkShareIntent.putExtra("android.intent.extra.SUBJECT", "Shared from F-Droid: " + this.app.name + ".apk");
                StringBuilder sb = new StringBuilder();
                sb.append(this.app.name);
                sb.append(".apk");
                apkShareIntent.putExtra("android.intent.extra.TITLE", sb.toString());
                apkShareIntent.putExtra("android.intent.extra.TEXT", format);
                Intent createChooser = Intent.createChooser(apkShareIntent, getString(R.string.menu_share));
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent2, intent});
                startActivity(createChooser);
            } else {
                Intent createChooser2 = Intent.createChooser(intent2, getString(R.string.menu_share));
                createChooser2.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent});
                startActivity(createChooser2);
            }
            return true;
        } else if (menuItem.getItemId() == R.id.action_ignore_all) {
            this.model.ignoreAllUpdates();
            return true;
        } else if (menuItem.getItemId() == R.id.action_ignore_this) {
            this.model.ignoreVersionCodeUpdate(this.app.autoInstallVersionCode);
            return true;
        } else if (menuItem.getItemId() == R.id.action_release_channel_beta) {
            this.model.toggleBetaReleaseChannel();
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            this.fdroidApp.sendViaBluetooth(this, i2, this.app.packageName);
        } else if (i == 3) {
            if (i2 == -1) {
                InstallManagerService.queue(this, (App) intent.getParcelableExtra(Installer.EXTRA_APP), (Apk) intent.getParcelableExtra(Installer.EXTRA_APK));
            }
        } else if (i == 4 && i2 == -1) {
            startUninstall();
        }
    }

    @Override // org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks
    public void installApk(final Apk apk) {
        String str;
        if (isFinishing()) {
            return;
        }
        if (!apk.compatible) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.installIncompatible);
            builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.AppDetailsActivity$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppDetailsActivity.this.lambda$installApk$1(apk, dialogInterface, i);
                }
            });
            builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.AppDetailsActivity$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppDetailsActivity.lambda$installApk$2(dialogInterface, i);
                }
            });
            builder.create().show();
        } else if (this.app.installedSigner != null && (str = apk.signer) != null && !str.equals(this.app.installedSigner)) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setMessage(R.string.SignatureMismatch).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.views.AppDetailsActivity$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder2.create().show();
        } else {
            initiateInstall(apk);
            ((LinearLayoutManager) this.recyclerView.getLayoutManager()).scrollToPositionWithOffset(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$installApk$1(Apk apk, DialogInterface dialogInterface, int i) {
        initiateInstall(apk);
    }

    private void initiateInstall(Apk apk) {
        Intent permissionScreen = InstallerFactory.create(this, this.app, apk).getPermissionScreen();
        if (permissionScreen != null) {
            Utils.debugLog(TAG, "permission screen required");
            startActivityForResult(permissionScreen, 3);
            return;
        }
        InstallManagerService.queue(this, this.app, apk);
    }

    private void startUninstall() {
        registerUninstallReceiver();
        InstallerService.uninstall(this, this.app, this.app.installedApk);
    }

    private void registerUninstallReceiver() {
        this.localBroadcastManager.registerReceiver(this.uninstallReceiver, Installer.getUninstallIntentFilter(this.app.packageName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterUninstallReceiver() {
        this.localBroadcastManager.unregisterReceiver(this.uninstallReceiver);
    }

    private void registerAppStatusReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AppUpdateStatusManager.BROADCAST_APPSTATUS_REMOVED);
        intentFilter.addAction(AppUpdateStatusManager.BROADCAST_APPSTATUS_ADDED);
        intentFilter.addAction(AppUpdateStatusManager.BROADCAST_APPSTATUS_CHANGED);
        this.localBroadcastManager.registerReceiver(this.appStatusReceiver, intentFilter);
    }

    private void unregisterAppStatusReceiver() {
        this.localBroadcastManager.unregisterReceiver(this.appStatusReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterInstallReceiver() {
        this.localBroadcastManager.unregisterReceiver(this.installReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAppStatus(AppUpdateStatusManager.AppUpdateStatus appUpdateStatus, boolean z) {
        if (!z && appUpdateStatus == null && this.currentStatus != null) {
            this.adapter.clearProgress();
        }
        if (this.currentStatus == appUpdateStatus) {
            Utils.debugLog(TAG, "Same app status, not updating.");
            return;
        }
        this.currentStatus = appUpdateStatus;
        if (appUpdateStatus == null) {
            return;
        }
        int i = AnonymousClass4.$SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status[appUpdateStatus.status.ordinal()];
        if (i == 1 || i == 2) {
            long j = appUpdateStatus.progressMax;
            if (j == 0) {
                this.adapter.notifyAboutDownloadedApk(appUpdateStatus.apk);
                this.adapter.setIndeterminateProgress(R.string.download_pending);
                return;
            }
            this.adapter.setProgress(appUpdateStatus.progressCurrent, j);
        } else if (i == 3) {
            if (z) {
                this.adapter.setIndeterminateProgress(R.string.installing);
                this.localBroadcastManager.registerReceiver(this.installReceiver, Installer.getInstallIntentFilter(appUpdateStatus.getCanonicalUrl()));
                return;
            }
            this.adapter.clearProgress();
        } else if (i != 4) {
            if (i != 5) {
                return;
            }
            this.adapter.setIndeterminateProgress(R.string.installing);
        } else {
            if (z) {
                String string = getString(R.string.download_error);
                if (!TextUtils.isEmpty(appUpdateStatus.errorText)) {
                    string = string + "\n" + appUpdateStatus.errorText;
                }
                Toast.makeText(this, string, 1).show();
            }
            this.adapter.clearProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.fdroid.fdroid.views.AppDetailsActivity$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status;

        static {
            int[] iArr = new int[AppUpdateStatusManager.Status.values().length];
            $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status = iArr;
            try {
                iArr[AppUpdateStatusManager.Status.PendingInstall.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status[AppUpdateStatusManager.Status.Downloading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status[AppUpdateStatusManager.Status.ReadyToInstall.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status[AppUpdateStatusManager.Status.DownloadInterrupted.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status[AppUpdateStatusManager.Status.Installing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status[AppUpdateStatusManager.Status.Installed.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status[AppUpdateStatusManager.Status.UpdateAvailable.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$fdroid$fdroid$AppUpdateStatusManager$Status[AppUpdateStatusManager.Status.InstallError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppChanged(org.fdroid.database.App app) {
        if (app == null) {
            Toast.makeText(this, R.string.no_such_app, 1).show();
            finish();
            return;
        }
        this.app = new App(app, getPackageInfo(app.getPackageName()));
        onAppChanged(this.app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppChanged(App app) {
        if (isDestroyed()) {
            return;
        }
        if (this.appPrefs != null) {
            updateAppInfo(app, this.versions, this.appPrefs);
        }
        ((FeatureImage) findViewById(R.id.feature_graphic)).loadImageAndDisplay(app);
        AppUpdateStatusManager appUpdateStatusManager = AppUpdateStatusManager.getInstance(this);
        for (AppUpdateStatusManager.AppUpdateStatus appUpdateStatus : appUpdateStatusManager.getByPackageName(app.packageName)) {
            if (appUpdateStatus.status == AppUpdateStatusManager.Status.Installed) {
                appUpdateStatusManager.removeApk(appUpdateStatus.getCanonicalUrl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVersionsChanged(List<AppVersion> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (AppVersion appVersion : list) {
            Apk apk = new Apk(appVersion, (Repository) ObjectsCompat.requireNonNull(FDroidApp.getRepoManager(this).getRepository(appVersion.getRepoId())));
            apk.setCompatibility(this.checker);
            arrayList.add(apk);
        }
        this.versions = arrayList;
        if (this.app == null || this.appPrefs == null) {
            return;
        }
        updateAppInfo(this.app, arrayList, this.appPrefs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppDataChanged(AppData appData) {
        this.appPrefs = appData.getAppPrefs();
        if (appData.getRepos().size() > 0) {
            this.adapter.setRepos(appData.getRepos(), appData.getPreferredRepoId());
        }
        if (this.app != null) {
            updateAppInfo(this.app, this.versions, this.appPrefs);
        }
    }

    private void updateAppInfo(App app, List<Apk> list, AppPrefs appPrefs) {
        app.update(this, list == null ? new ArrayList<>() : list, appPrefs);
        this.adapter.updateItems(app, list, appPrefs);
        refreshStatus();
        supportInvalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public PackageInfo getPackageInfo(String str) {
        try {
            return getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks
    public boolean isAppDownloading() {
        AppUpdateStatusManager.Status status;
        AppUpdateStatusManager.AppUpdateStatus appUpdateStatus = this.currentStatus;
        return appUpdateStatus != null && ((status = appUpdateStatus.status) == AppUpdateStatusManager.Status.PendingInstall || status == AppUpdateStatusManager.Status.Downloading);
    }

    @Override // org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks
    public void openUrl(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, getString(R.string.no_handler_app, intent.getDataString()), 1).show();
        } else {
            startActivity(intent);
        }
    }

    @Override // org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks
    public void installCancel() {
        AppUpdateStatusManager.AppUpdateStatus appUpdateStatus = this.currentStatus;
        if (appUpdateStatus != null) {
            InstallManagerService.cancel(this, appUpdateStatus.getCanonicalUrl());
        }
    }

    @Override // org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks
    public void launchApk() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.app.packageName);
        if (launchIntentForPackage != null) {
            try {
                startActivity(launchIntentForPackage);
                return;
            } catch (SecurityException e) {
                Log.e(TAG, "Error launching app: ", e);
                Toast.makeText(this, R.string.app_error_open, 1).show();
                return;
            }
        }
        Toast.makeText(this, R.string.app_not_installed, 1).show();
    }

    @Override // org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks
    public void onRepoChanged(long j) {
        this.model.selectRepo(j);
    }

    @Override // org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks
    public void onPreferredRepoChanged(long j) {
        this.model.setPreferredRepo(j);
    }

    @Override // org.fdroid.fdroid.views.AppDetailsRecyclerViewAdapter.AppDetailsRecyclerViewAdapterCallbacks
    public void uninstallApk() {
        Apk apk = this.app.installedApk;
        if (apk == null) {
            apk = this.app.getMediaApkifInstalled(getApplicationContext());
            if (apk == null) {
                List<Apk> list = this.versions;
                if (list != null) {
                    apk = this.app.getInstalledApk(this, list);
                }
                if (apk == null) {
                    Log.d(TAG, "Couldn't find installed apk for " + this.app.packageName);
                    Toast.makeText(this, R.string.uninstall_error_unknown, 0).show();
                    this.uninstallReceiver.onReceive(this, new Intent(Installer.ACTION_UNINSTALL_INTERRUPTED));
                    return;
                }
            }
            this.app.installedApk = apk;
        }
        Intent uninstallScreen = InstallerFactory.create(this, this.app, apk).getUninstallScreen();
        if (uninstallScreen != null) {
            Utils.debugLog(TAG, "screen screen required");
            startActivityForResult(uninstallScreen, 4);
            return;
        }
        startUninstall();
    }
}
