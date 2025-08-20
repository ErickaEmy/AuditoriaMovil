package com.google.firebase.crashlytics.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.network.CreateAppSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.UpdateAppSpiCall;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class Onboarding {
    private final FirebaseApp app;
    private String applicationLabel;
    private final Context context;
    private DataCollectionArbiter dataCollectionArbiter;
    private IdManager idManager;
    private String installerPackageName;
    private PackageInfo packageInfo;
    private PackageManager packageManager;
    private String packageName;
    private final HttpRequestFactory requestFactory = new HttpRequestFactory();
    private String targetAndroidSdkVersion;
    private String versionCode;
    private String versionName;

    public Onboarding(FirebaseApp firebaseApp, Context context, IdManager idManager, DataCollectionArbiter dataCollectionArbiter) {
        this.app = firebaseApp;
        this.context = context;
        this.idManager = idManager;
        this.dataCollectionArbiter = dataCollectionArbiter;
    }

    private AppRequestData buildAppRequest(String str, String str2) {
        return new AppRequestData(str, str2, getIdManager().getAppIdentifier(), this.versionName, this.versionCode, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(getContext()), str2, this.versionName, this.versionCode), this.applicationLabel, DeliveryMechanism.determineFrom(this.installerPackageName).getId(), this.targetAndroidSdkVersion, "0");
    }

    private IdManager getIdManager() {
        return this.idManager;
    }

    private static String getVersion() {
        return CrashlyticsCore.getVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAutoConfigure(AppSettingsData appSettingsData, String str, SettingsController settingsController, Executor executor, boolean z2) {
        if ("new".equals(appSettingsData.status)) {
            if (performCreateApp(appSettingsData, str, z2)) {
                settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
            } else {
                Logger.getLogger().e("Failed to create app with Crashlytics service.", null);
            }
        } else if ("configured".equals(appSettingsData.status)) {
            settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
        } else if (appSettingsData.updateRequired) {
            Logger.getLogger().d("Server says an update is required - forcing a full App update.");
            performUpdateApp(appSettingsData, str, z2);
        }
    }

    private boolean performCreateApp(AppSettingsData appSettingsData, String str, boolean z2) {
        return new CreateAppSpiCall(getOverridenSpiEndpoint(), appSettingsData.url, this.requestFactory, getVersion()).invoke(buildAppRequest(appSettingsData.organizationId, str), z2);
    }

    private boolean performUpdateApp(AppSettingsData appSettingsData, String str, boolean z2) {
        return new UpdateAppSpiCall(getOverridenSpiEndpoint(), appSettingsData.url, this.requestFactory, getVersion()).invoke(buildAppRequest(appSettingsData.organizationId, str), z2);
    }

    public void doOnboarding(Executor executor, SettingsController settingsController) {
        this.dataCollectionArbiter.waitForDataCollectionPermission().onSuccessTask(executor, new 2(this, settingsController)).onSuccessTask(executor, new 1(this, this.app.getOptions().getApplicationId(), settingsController, executor));
    }

    public Context getContext() {
        return this.context;
    }

    public String getOverridenSpiEndpoint() {
        return CommonUtils.getStringsFileValue(this.context, "com.crashlytics.ApiEndpoint");
    }

    public boolean onPreExecute() {
        try {
            this.installerPackageName = this.idManager.getInstallerPackageName();
            this.packageManager = this.context.getPackageManager();
            String packageName = this.context.getPackageName();
            this.packageName = packageName;
            PackageInfo packageInfo = this.packageManager.getPackageInfo(packageName, 0);
            this.packageInfo = packageInfo;
            this.versionCode = Integer.toString(packageInfo.versionCode);
            String str = this.packageInfo.versionName;
            if (str == null) {
                str = "0.0";
            }
            this.versionName = str;
            this.applicationLabel = this.packageManager.getApplicationLabel(this.context.getApplicationInfo()).toString();
            this.targetAndroidSdkVersion = Integer.toString(this.context.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.getLogger().e("Failed init", e2);
            return false;
        }
    }

    public SettingsController retrieveSettingsData(Context context, FirebaseApp firebaseApp, Executor executor) {
        SettingsController create = SettingsController.create(context, firebaseApp.getOptions().getApplicationId(), this.idManager, this.requestFactory, this.versionCode, this.versionName, getOverridenSpiEndpoint(), this.dataCollectionArbiter);
        create.loadSettingsData(executor).continueWith(executor, new 3(this));
        return create;
    }
}
