package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FirebaseRemoteConfig {
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    private final ConfigCacheClient activatedConfigsCache;
    private final Context context;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final ConfigFetchHandler fetchHandler;
    private final ConfigCacheClient fetchedConfigsCache;
    @Nullable
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigMetadataClient frcMetadata;
    private final ConfigGetParameterHandler getHandler;

    public FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        this.context = context;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.executor = executor;
        this.fetchedConfigsCache = configCacheClient;
        this.activatedConfigsCache = configCacheClient2;
        this.defaultConfigsCache = configCacheClient3;
        this.fetchHandler = configFetchHandler;
        this.getHandler = configGetParameterHandler;
        this.frcMetadata = configMetadataClient;
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private static boolean isFetchedFresh(ConfigContainer configContainer, @Nullable ConfigContainer configContainer2) {
        if (configContainer2 != null && configContainer.getFetchTime().equals(configContainer2.getFetchTime())) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ Task lambda$activate$3(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2, Task task3) throws Exception {
        if (task.isSuccessful() && task.getResult() != null) {
            ConfigContainer configContainer = (ConfigContainer) task.getResult();
            if (task2.isSuccessful() && !isFetchedFresh(configContainer, (ConfigContainer) task2.getResult())) {
                return Tasks.forResult(Boolean.FALSE);
            }
            return firebaseRemoteConfig.activatedConfigsCache.put(configContainer).continueWith(firebaseRemoteConfig.executor, FirebaseRemoteConfig$$Lambda$11.lambdaFactory$(firebaseRemoteConfig));
        }
        return Tasks.forResult(Boolean.FALSE);
    }

    public static /* synthetic */ void lambda$activateFetched$2(FirebaseRemoteConfig firebaseRemoteConfig, ConfigContainer configContainer) {
        firebaseRemoteConfig.fetchedConfigsCache.clear();
        firebaseRemoteConfig.updateAbtWithActivatedExperiments(configContainer.getAbtExperiments());
    }

    public static /* synthetic */ FirebaseRemoteConfigInfo lambda$ensureInitialized$0(Task task, Task task2) throws Exception {
        return (FirebaseRemoteConfigInfo) task.getResult();
    }

    public static /* synthetic */ Void lambda$reset$7(FirebaseRemoteConfig firebaseRemoteConfig) throws Exception {
        firebaseRemoteConfig.activatedConfigsCache.clear();
        firebaseRemoteConfig.fetchedConfigsCache.clear();
        firebaseRemoteConfig.defaultConfigsCache.clear();
        firebaseRemoteConfig.frcMetadata.clear();
        return null;
    }

    public static /* synthetic */ Void lambda$setConfigSettingsAsync$6(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) throws Exception {
        firebaseRemoteConfig.frcMetadata.setConfigSettings(firebaseRemoteConfigSettings);
        return null;
    }

    public boolean processActivatePutTask(Task<ConfigContainer> task) {
        if (task.isSuccessful()) {
            this.fetchedConfigsCache.clear();
            if (task.getResult() != null) {
                updateAbtWithActivatedExperiments(task.getResult().getAbtExperiments());
                return true;
            }
            Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            return true;
        }
        return false;
    }

    private void setDefaultsWithStringsMap(Map<String, String> map) {
        try {
            this.defaultConfigsCache.putWithoutWaitingForDiskWrite(ConfigContainer.newBuilder().replaceConfigsWith(map).build());
        } catch (JSONException e2) {
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", e2);
        }
    }

    private Task<Void> setDefaultsWithStringsMapAsync(Map<String, String> map) {
        SuccessContinuation<ConfigContainer, TContinuationResult> successContinuation;
        try {
            Task<ConfigContainer> put = this.defaultConfigsCache.put(ConfigContainer.newBuilder().replaceConfigsWith(map).build());
            successContinuation = FirebaseRemoteConfig$$Lambda$10.instance;
            return put.onSuccessTask(successContinuation);
        } catch (JSONException e2) {
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", e2);
            return Tasks.forResult(null);
        }
    }

    public static List<Map<String, String>> toExperimentInfoMaps(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @NonNull
    public Task<Boolean> activate() {
        Task<ConfigContainer> task = this.fetchedConfigsCache.get();
        Task<ConfigContainer> task2 = this.activatedConfigsCache.get();
        return Tasks.whenAllComplete(task, task2).continueWithTask(this.executor, FirebaseRemoteConfig$$Lambda$5.lambdaFactory$(this, task, task2));
    }

    @Deprecated
    public boolean activateFetched() {
        ConfigContainer blocking = this.fetchedConfigsCache.getBlocking();
        if (blocking == null || !isFetchedFresh(blocking, this.activatedConfigsCache.getBlocking())) {
            return false;
        }
        this.activatedConfigsCache.putWithoutWaitingForDiskWrite(blocking).addOnSuccessListener(this.executor, FirebaseRemoteConfig$$Lambda$4.lambdaFactory$(this));
        return true;
    }

    @NonNull
    public Task<FirebaseRemoteConfigInfo> ensureInitialized() {
        Task<ConfigContainer> task = this.activatedConfigsCache.get();
        Task<ConfigContainer> task2 = this.defaultConfigsCache.get();
        Task<ConfigContainer> task3 = this.fetchedConfigsCache.get();
        Task call = Tasks.call(this.executor, FirebaseRemoteConfig$$Lambda$1.lambdaFactory$(this));
        return Tasks.whenAllComplete(task, task2, task3, call, this.firebaseInstallations.getId(), this.firebaseInstallations.getToken(false)).continueWith(this.executor, FirebaseRemoteConfig$$Lambda$2.lambdaFactory$(call));
    }

    @NonNull
    public Task<Void> fetch() {
        SuccessContinuation<ConfigFetchHandler.FetchResponse, TContinuationResult> successContinuation;
        Task<ConfigFetchHandler.FetchResponse> fetch = this.fetchHandler.fetch();
        successContinuation = FirebaseRemoteConfig$$Lambda$6.instance;
        return fetch.onSuccessTask(successContinuation);
    }

    @NonNull
    public Task<Boolean> fetchAndActivate() {
        return fetch().onSuccessTask(this.executor, FirebaseRemoteConfig$$Lambda$3.lambdaFactory$(this));
    }

    @NonNull
    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.getHandler.getAll();
    }

    public boolean getBoolean(@NonNull String str) {
        return this.getHandler.getBoolean(str);
    }

    @NonNull
    @Deprecated
    public byte[] getByteArray(@NonNull String str) {
        return this.getHandler.getByteArray(str);
    }

    public double getDouble(@NonNull String str) {
        return this.getHandler.getDouble(str);
    }

    @NonNull
    public FirebaseRemoteConfigInfo getInfo() {
        return this.frcMetadata.getInfo();
    }

    @NonNull
    public Set<String> getKeysByPrefix(@NonNull String str) {
        return this.getHandler.getKeysByPrefix(str);
    }

    public long getLong(@NonNull String str) {
        return this.getHandler.getLong(str);
    }

    @NonNull
    public String getString(@NonNull String str) {
        return this.getHandler.getString(str);
    }

    @NonNull
    public FirebaseRemoteConfigValue getValue(@NonNull String str) {
        return this.getHandler.getValue(str);
    }

    @NonNull
    public Task<Void> reset() {
        return Tasks.call(this.executor, FirebaseRemoteConfig$$Lambda$9.lambdaFactory$(this));
    }

    @Deprecated
    public void setConfigSettings(@NonNull FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.frcMetadata.setConfigSettingsWithoutWaitingOnDiskWrite(firebaseRemoteConfigSettings);
    }

    @NonNull
    public Task<Void> setConfigSettingsAsync(@NonNull FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return Tasks.call(this.executor, FirebaseRemoteConfig$$Lambda$8.lambdaFactory$(this, firebaseRemoteConfigSettings));
    }

    @Deprecated
    public void setDefaults(@NonNull Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                hashMap.put(entry.getKey(), new String((byte[]) value));
            } else {
                hashMap.put(entry.getKey(), value.toString());
            }
        }
        setDefaultsWithStringsMap(hashMap);
    }

    @NonNull
    public Task<Void> setDefaultsAsync(@NonNull Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                hashMap.put(entry.getKey(), new String((byte[]) value));
            } else {
                hashMap.put(entry.getKey(), value.toString());
            }
        }
        return setDefaultsWithStringsMapAsync(hashMap);
    }

    public void startLoadingConfigsFromDisk() {
        this.activatedConfigsCache.get();
        this.defaultConfigsCache.get();
        this.fetchedConfigsCache.get();
    }

    public void updateAbtWithActivatedExperiments(@NonNull JSONArray jSONArray) {
        if (this.firebaseAbt == null) {
            return;
        }
        try {
            this.firebaseAbt.replaceAllExperiments(toExperimentInfoMaps(jSONArray));
        } catch (AbtException e2) {
            Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e2);
        } catch (JSONException e3) {
            Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e3);
        }
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance(@NonNull FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.get(RemoteConfigComponent.class)).getDefault();
    }

    @NonNull
    public Task<Void> fetch(long j2) {
        SuccessContinuation<ConfigFetchHandler.FetchResponse, TContinuationResult> successContinuation;
        Task<ConfigFetchHandler.FetchResponse> fetch = this.fetchHandler.fetch(j2);
        successContinuation = FirebaseRemoteConfig$$Lambda$7.instance;
        return fetch.onSuccessTask(successContinuation);
    }

    @Deprecated
    public void setDefaults(int i) {
        setDefaultsWithStringsMap(DefaultsXmlParser.getDefaultsFromXml(this.context, i));
    }

    @NonNull
    public Task<Void> setDefaultsAsync(int i) {
        return setDefaultsWithStringsMapAsync(DefaultsXmlParser.getDefaultsFromXml(this.context, i));
    }
}
