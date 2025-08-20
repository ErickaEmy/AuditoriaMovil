package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;
/* loaded from: classes.dex */
public class ConfigMetadataClient {
    static final Date LAST_FETCH_TIME_NO_FETCH_YET = new Date(-1);
    static final Date NO_BACKOFF_TIME = new Date(-1);
    private final SharedPreferences frcMetadata;
    private final Object frcInfoLock = new Object();
    private final Object backoffMetadataLock = new Object();

    /* loaded from: classes.dex */
    public static class BackoffMetadata {
        private Date backoffEndTime;
        private int numFailedFetches;

        public BackoffMetadata(int i, Date date) {
            this.numFailedFetches = i;
            this.backoffEndTime = date;
        }

        public Date getBackoffEndTime() {
            return this.backoffEndTime;
        }

        public int getNumFailedFetches() {
            return this.numFailedFetches;
        }
    }

    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        this.frcMetadata = sharedPreferences;
    }

    public void clear() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().clear().commit();
        }
    }

    public BackoffMetadata getBackoffMetadata() {
        BackoffMetadata backoffMetadata;
        synchronized (this.backoffMetadataLock) {
            backoffMetadata = new BackoffMetadata(this.frcMetadata.getInt("num_failed_fetches", 0), new Date(this.frcMetadata.getLong("backoff_end_time_in_millis", -1L)));
        }
        return backoffMetadata;
    }

    public long getFetchTimeoutInSeconds() {
        return this.frcMetadata.getLong("fetch_timeout_in_seconds", 60L);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfoImpl build;
        synchronized (this.frcInfoLock) {
            long j2 = this.frcMetadata.getLong("last_fetch_time_in_millis", -1L);
            int i = this.frcMetadata.getInt("last_fetch_status", 0);
            build = FirebaseRemoteConfigInfoImpl.newBuilder().withLastFetchStatus(i).withLastSuccessfulFetchTimeInMillis(j2).withConfigSettings(new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(this.frcMetadata.getBoolean("is_developer_mode_enabled", false)).setFetchTimeoutInSeconds(this.frcMetadata.getLong("fetch_timeout_in_seconds", 60L)).setMinimumFetchIntervalInSeconds(this.frcMetadata.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build()).build();
        }
        return build;
    }

    @Nullable
    public String getLastFetchETag() {
        return this.frcMetadata.getString("last_fetch_etag", null);
    }

    public int getLastFetchStatus() {
        return this.frcMetadata.getInt("last_fetch_status", 0);
    }

    public Date getLastSuccessfulFetchTime() {
        return new Date(this.frcMetadata.getLong("last_fetch_time_in_millis", -1L));
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.frcMetadata.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
    }

    public boolean isDeveloperModeEnabled() {
        return this.frcMetadata.getBoolean("is_developer_mode_enabled", false);
    }

    public void resetBackoff() {
        setBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    public void setBackoffMetadata(int i, Date date) {
        synchronized (this.backoffMetadataLock) {
            this.frcMetadata.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putBoolean("is_developer_mode_enabled", firebaseRemoteConfigSettings.isDeveloperModeEnabled()).putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).commit();
        }
    }

    public void setConfigSettingsWithoutWaitingOnDiskWrite(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putBoolean("is_developer_mode_enabled", firebaseRemoteConfigSettings.isDeveloperModeEnabled()).putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).apply();
        }
    }

    public void setLastFetchETag(String str) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putString("last_fetch_etag", str).apply();
        }
    }

    public void updateLastFetchAsFailed() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    public void updateLastFetchAsSuccessfulAt(Date date) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    public void updateLastFetchAsThrottled() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}
