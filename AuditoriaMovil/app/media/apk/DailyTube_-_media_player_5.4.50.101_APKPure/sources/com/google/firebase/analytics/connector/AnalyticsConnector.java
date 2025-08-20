package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public interface AnalyticsConnector {

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface AnalyticsConnectorHandle {
        @KeepForSdk
        void registerEventNames(Set<String> set);

        @KeepForSdk
        void unregister();

        @KeepForSdk
        void unregisterEventNames();
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface AnalyticsConnectorListener {
        @KeepForSdk
        void onMessageTriggered(int i, @Nullable Bundle bundle);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class ConditionalUserProperty {
        @KeepForSdk
        public boolean active;
        @KeepForSdk
        public long creationTimestamp;
        @KeepForSdk
        public String expiredEventName;
        @KeepForSdk
        public Bundle expiredEventParams;
        @KeepForSdk
        public String name;
        @KeepForSdk
        public String origin;
        @KeepForSdk
        public long timeToLive;
        @KeepForSdk
        public String timedOutEventName;
        @KeepForSdk
        public Bundle timedOutEventParams;
        @KeepForSdk
        public String triggerEventName;
        @KeepForSdk
        public long triggerTimeout;
        @KeepForSdk
        public String triggeredEventName;
        @KeepForSdk
        public Bundle triggeredEventParams;
        @KeepForSdk
        public long triggeredTimestamp;
        @KeepForSdk
        public Object value;
    }

    @KeepForSdk
    void clearConditionalUserProperty(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle);

    @KeepForSdk
    List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Nullable String str2);

    @KeepForSdk
    int getMaxUserProperties(@NonNull String str);

    @KeepForSdk
    Map<String, Object> getUserProperties(boolean z2);

    @KeepForSdk
    void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle);

    @KeepForSdk
    AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnectorListener analyticsConnectorListener);

    @KeepForSdk
    void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty);

    @KeepForSdk
    void setUserProperty(@NonNull String str, @NonNull String str2, Object obj);
}
