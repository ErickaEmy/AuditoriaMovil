package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.proto.ConfigPersistence;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import g7.gv;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LegacyConfigsHandler {
    private static final Charset PROTO_BYTE_ARRAY_ENCODING = Charset.forName("UTF-8");
    static final ThreadLocal<DateFormat> protoTimestampStringParser = new 1();
    private final String appId;
    private final Context context;
    private final SharedPreferences legacySettings;

    public LegacyConfigsHandler(Context context, String str) {
        this.context = context;
        this.appId = str;
        this.legacySettings = context.getSharedPreferences("com.google.firebase.remoteconfig_legacy_settings", 0);
    }

    private Map<String, ConfigContainer> convertConfigHolder(ConfigPersistence.ConfigHolder configHolder) {
        HashMap hashMap = new HashMap();
        Date date = new Date(configHolder.getTimestamp());
        JSONArray convertLegacyAbtExperiments = convertLegacyAbtExperiments(configHolder.getExperimentPayloadList());
        for (ConfigPersistence.NamespaceKeyValue namespaceKeyValue : configHolder.getNamespaceKeyValueList()) {
            String namespace = namespaceKeyValue.getNamespace();
            if (namespace.startsWith("configns:")) {
                namespace = namespace.substring(9);
            }
            ConfigContainer.Builder withFetchTime = ConfigContainer.newBuilder().replaceConfigsWith(convertKeyValueList(namespaceKeyValue.getKeyValueList())).withFetchTime(date);
            if (namespace.equals("firebase")) {
                withFetchTime.withAbtExperiments(convertLegacyAbtExperiments);
            }
            try {
                hashMap.put(namespace, withFetchTime.build());
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    private Map<String, String> convertKeyValueList(List<ConfigPersistence.KeyValue> list) {
        HashMap hashMap = new HashMap();
        for (ConfigPersistence.KeyValue keyValue : list) {
            hashMap.put(keyValue.getKey(), keyValue.getValue().toString(PROTO_BYTE_ARRAY_ENCODING));
        }
        return hashMap;
    }

    private JSONObject convertLegacyAbtExperiment(gv gvVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("experimentId", gvVar.getExperimentId());
        jSONObject.put("variantId", gvVar.getVariantId());
        jSONObject.put("experimentStartTime", protoTimestampStringParser.get().format(new Date(gvVar.getExperimentStartTimeMillis())));
        jSONObject.put("triggerEvent", gvVar.getTriggerEvent());
        jSONObject.put("triggerTimeoutMillis", gvVar.getTriggerTimeoutMillis());
        jSONObject.put("timeToLiveMillis", gvVar.getTimeToLiveMillis());
        return jSONObject;
    }

    private JSONArray convertLegacyAbtExperiments(List<ByteString> list) {
        JSONArray jSONArray = new JSONArray();
        for (ByteString byteString : list) {
            gv deserializePayload = deserializePayload(byteString);
            if (deserializePayload != null) {
                try {
                    jSONArray.put(convertLegacyAbtExperiment(deserializePayload));
                } catch (JSONException unused) {
                }
            }
        }
        return jSONArray;
    }

    @Nullable
    private gv deserializePayload(ByteString byteString) {
        try {
            Iterator<Byte> iterator2 = byteString.iterator2();
            int size = byteString.size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = iterator2.next().byteValue();
            }
            return gv.parseFrom(bArr);
        } catch (InvalidProtocolBufferException unused) {
            return null;
        }
    }

    private Map<String, NamespaceLegacyConfigs> getConvertedLegacyConfigs() {
        ConfigPersistence.PersistedConfig readPersistedConfig = readPersistedConfig();
        HashMap hashMap = new HashMap();
        if (readPersistedConfig == null) {
            return hashMap;
        }
        Map<String, ConfigContainer> convertConfigHolder = convertConfigHolder(readPersistedConfig.getActiveConfigHolder());
        Map<String, ConfigContainer> convertConfigHolder2 = convertConfigHolder(readPersistedConfig.getFetchedConfigHolder());
        Map<String, ConfigContainer> convertConfigHolder3 = convertConfigHolder(readPersistedConfig.getDefaultsConfigHolder());
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(convertConfigHolder.keySet());
        hashSet.addAll(convertConfigHolder2.keySet());
        hashSet.addAll(convertConfigHolder3.keySet());
        for (String str : hashSet) {
            NamespaceLegacyConfigs namespaceLegacyConfigs = new NamespaceLegacyConfigs((1) null);
            if (convertConfigHolder.containsKey(str)) {
                NamespaceLegacyConfigs.access$400(namespaceLegacyConfigs, convertConfigHolder.get(str));
            }
            if (convertConfigHolder2.containsKey(str)) {
                NamespaceLegacyConfigs.access$500(namespaceLegacyConfigs, convertConfigHolder2.get(str));
            }
            if (convertConfigHolder3.containsKey(str)) {
                NamespaceLegacyConfigs.access$600(namespaceLegacyConfigs, convertConfigHolder3.get(str));
            }
            hashMap.put(str, namespaceLegacyConfigs);
        }
        return hashMap;
    }

    private ConfigPersistence.PersistedConfig readPersistedConfig() {
        Throwable th;
        FileInputStream fileInputStream;
        Context context = this.context;
        if (context == null) {
            return null;
        }
        try {
            fileInputStream = context.openFileInput("persisted_config");
        } catch (FileNotFoundException unused) {
            fileInputStream = null;
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            ConfigPersistence.PersistedConfig parseFrom = ConfigPersistence.PersistedConfig.parseFrom(fileInputStream);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
            }
            return parseFrom;
        } catch (FileNotFoundException unused4) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused5) {
                }
            }
            return null;
        } catch (IOException unused6) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused7) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused8) {
                }
            }
            throw th;
        }
    }

    private void saveLegacyConfigs(Map<String, NamespaceLegacyConfigs> map) {
        for (Map.Entry<String, NamespaceLegacyConfigs> entry : map.entrySet()) {
            String key = entry.getKey();
            NamespaceLegacyConfigs value = entry.getValue();
            ConfigCacheClient cacheClient = getCacheClient(key, "fetch");
            ConfigCacheClient cacheClient2 = getCacheClient(key, "activate");
            ConfigCacheClient cacheClient3 = getCacheClient(key, "defaults");
            if (NamespaceLegacyConfigs.access$000(value) != null) {
                cacheClient.put(NamespaceLegacyConfigs.access$000(value));
            }
            if (NamespaceLegacyConfigs.access$100(value) != null) {
                cacheClient2.put(NamespaceLegacyConfigs.access$100(value));
            }
            if (NamespaceLegacyConfigs.access$200(value) != null) {
                cacheClient3.put(NamespaceLegacyConfigs.access$200(value));
            }
        }
    }

    public ConfigCacheClient getCacheClient(String str, String str2) {
        return RemoteConfigComponent.getCacheClient(this.context, this.appId, str, str2);
    }

    public boolean saveLegacyConfigsIfNecessary() {
        if (!this.legacySettings.getBoolean("save_legacy_configs", true)) {
            return false;
        }
        saveLegacyConfigs(getConvertedLegacyConfigs());
        this.legacySettings.edit().putBoolean("save_legacy_configs", false).commit();
        return true;
    }
}
