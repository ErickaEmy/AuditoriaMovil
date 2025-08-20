package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface FirebaseRemoteConfigInfo {
    @NonNull
    FirebaseRemoteConfigSettings getConfigSettings();

    long getFetchTimeMillis();

    int getLastFetchStatus();
}
