package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.LegacyConfigsHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@KeepForSdk
/* loaded from: classes.dex */
public class RemoteConfigComponent {
    private static final Clock DEFAULT_CLOCK = DefaultClock.getInstance();
    private static final Random DEFAULT_RANDOM = new Random();
    @Nullable
    private final AnalyticsConnector analyticsConnector;
    private final String appId;
    private final Context context;
    private Map<String, String> customHeaders;
    private final ExecutorService executorService;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Map<String, FirebaseRemoteConfig> frcNamespaceInstances;

    public RemoteConfigComponent(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, @Nullable AnalyticsConnector analyticsConnector) {
        this(context, Executors.newCachedThreadPool(), firebaseApp, firebaseInstallationsApi, firebaseABTesting, analyticsConnector, new LegacyConfigsHandler(context, firebaseApp.getOptions().getApplicationId()), true);
    }

    private ConfigCacheClient getCacheClient(String str, String str2) {
        return getCacheClient(this.context, this.appId, str, str2);
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(configCacheClient, configCacheClient2);
    }

    public static ConfigMetadataClient getMetadataClient(Context context, String str, String str2) {
        return new ConfigMetadataClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, "settings"), 0));
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp, String str) {
        if (str.equals("firebase") && isPrimaryApp(firebaseApp)) {
            return true;
        }
        return false;
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp) {
        return firebaseApp.getName().equals("[DEFAULT]");
    }

    @KeepForSdk
    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient cacheClient;
        ConfigCacheClient cacheClient2;
        ConfigCacheClient cacheClient3;
        ConfigMetadataClient metadataClient;
        cacheClient = getCacheClient(str, "fetch");
        cacheClient2 = getCacheClient(str, "activate");
        cacheClient3 = getCacheClient(str, "defaults");
        metadataClient = getMetadataClient(this.context, this.appId, str);
        return get(this.firebaseApp, str, this.firebaseInstallations, this.firebaseAbt, this.executorService, cacheClient, cacheClient2, cacheClient3, getFetchHandler(str, cacheClient, metadataClient), getGetHandler(cacheClient2, cacheClient3), metadataClient);
    }

    public FirebaseRemoteConfig getDefault() {
        return get("firebase");
    }

    public synchronized ConfigFetchHandler getFetchHandler(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        FirebaseInstallationsApi firebaseInstallationsApi;
        AnalyticsConnector analyticsConnector;
        try {
            firebaseInstallationsApi = this.firebaseInstallations;
            if (isPrimaryApp(this.firebaseApp)) {
                analyticsConnector = this.analyticsConnector;
            } else {
                analyticsConnector = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new ConfigFetchHandler(firebaseInstallationsApi, analyticsConnector, this.executorService, DEFAULT_CLOCK, DEFAULT_RANDOM, configCacheClient, getFrcBackendApiClient(this.firebaseApp.getOptions().getApiKey(), str, configMetadataClient), configMetadataClient, this.customHeaders);
    }

    public ConfigFetchHttpClient getFrcBackendApiClient(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.context, this.firebaseApp.getOptions().getApplicationId(), str, str2, configMetadataClient.getFetchTimeoutInSeconds(), configMetadataClient.getFetchTimeoutInSeconds());
    }

    public synchronized void setCustomHeaders(Map<String, String> map) {
        this.customHeaders = map;
    }

    public static ConfigCacheClient getCacheClient(Context context, String str, String str2, String str3) {
        return ConfigCacheClient.getInstance(Executors.newCachedThreadPool(), ConfigStorageClient.getInstance(context, String.format("%s_%s_%s_%s.json", "frc", str, str2, str3)));
    }

    public RemoteConfigComponent(Context context, ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, @Nullable AnalyticsConnector analyticsConnector, LegacyConfigsHandler legacyConfigsHandler, boolean z2) {
        this.frcNamespaceInstances = new HashMap();
        this.customHeaders = new HashMap();
        this.context = context;
        this.executorService = executorService;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = analyticsConnector;
        this.appId = firebaseApp.getOptions().getApplicationId();
        if (z2) {
            Tasks.call(executorService, RemoteConfigComponent$$Lambda$1.lambdaFactory$(this));
            legacyConfigsHandler.getClass();
            Tasks.call(executorService, RemoteConfigComponent$$Lambda$4.lambdaFactory$(legacyConfigsHandler));
        }
    }

    public synchronized FirebaseRemoteConfig get(FirebaseApp firebaseApp, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        try {
            if (!this.frcNamespaceInstances.containsKey(str)) {
                FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(this.context, firebaseApp, firebaseInstallationsApi, isAbtSupported(firebaseApp, str) ? firebaseABTesting : null, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient);
                firebaseRemoteConfig.startLoadingConfigsFromDisk();
                this.frcNamespaceInstances.put(str, firebaseRemoteConfig);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.frcNamespaceInstances.get(str);
    }
}
