package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
/* loaded from: classes.dex */
public class FirebaseRemoteConfigSettings {
    private final boolean enableDeveloperMode;
    private final long fetchTimeoutInSeconds;
    private final long minimumFetchInterval;

    /* loaded from: classes.dex */
    public static class Builder {
        private boolean enableDeveloperMode;
        private long fetchTimeoutInSeconds = 60;
        private long minimumFetchInterval = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;

        @NonNull
        public FirebaseRemoteConfigSettings build() {
            return new FirebaseRemoteConfigSettings(this);
        }

        public long getFetchTimeoutInSeconds() {
            return this.fetchTimeoutInSeconds;
        }

        public long getMinimumFetchIntervalInSeconds() {
            return this.minimumFetchInterval;
        }

        @NonNull
        @Deprecated
        public Builder setDeveloperModeEnabled(boolean z2) {
            this.enableDeveloperMode = z2;
            return this;
        }

        @NonNull
        public Builder setFetchTimeoutInSeconds(long j2) throws IllegalArgumentException {
            if (j2 >= 0) {
                this.fetchTimeoutInSeconds = j2;
                return this;
            }
            throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j2)));
        }

        @NonNull
        public Builder setMinimumFetchIntervalInSeconds(long j2) {
            if (j2 >= 0) {
                this.minimumFetchInterval = j2;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j2 + " is an invalid argument");
        }
    }

    public long getFetchTimeoutInSeconds() {
        return this.fetchTimeoutInSeconds;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.minimumFetchInterval;
    }

    @Deprecated
    public boolean isDeveloperModeEnabled() {
        return this.enableDeveloperMode;
    }

    @NonNull
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setDeveloperModeEnabled(isDeveloperModeEnabled());
        builder.setFetchTimeoutInSeconds(getFetchTimeoutInSeconds());
        builder.setMinimumFetchIntervalInSeconds(getMinimumFetchIntervalInSeconds());
        return builder;
    }

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.enableDeveloperMode = builder.enableDeveloperMode;
        this.fetchTimeoutInSeconds = builder.fetchTimeoutInSeconds;
        this.minimumFetchInterval = builder.minimumFetchInterval;
    }
}
