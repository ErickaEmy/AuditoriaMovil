package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
/* loaded from: classes.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$1 implements Continuation {
    private final ConfigFetchHandler arg$1;
    private final long arg$2;

    private ConfigFetchHandler$$Lambda$1(ConfigFetchHandler configFetchHandler, long j2) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = j2;
    }

    public static Continuation lambdaFactory$(ConfigFetchHandler configFetchHandler, long j2) {
        return new ConfigFetchHandler$$Lambda$1(configFetchHandler, j2);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Task fetchIfCacheExpiredAndNotThrottled;
        fetchIfCacheExpiredAndNotThrottled = this.arg$1.fetchIfCacheExpiredAndNotThrottled(task, this.arg$2);
        return fetchIfCacheExpiredAndNotThrottled;
    }
}
