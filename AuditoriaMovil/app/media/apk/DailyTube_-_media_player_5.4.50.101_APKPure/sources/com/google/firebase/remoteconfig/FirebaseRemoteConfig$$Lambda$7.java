package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
/* loaded from: classes.dex */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$7 implements SuccessContinuation {
    private static final FirebaseRemoteConfig$$Lambda$7 instance = new FirebaseRemoteConfig$$Lambda$7();

    private FirebaseRemoteConfig$$Lambda$7() {
    }

    public static SuccessContinuation lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task forResult;
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) obj;
        forResult = Tasks.forResult(null);
        return forResult;
    }
}
