package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
/* loaded from: classes.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$10 implements SuccessContinuation {
    private static final FirebaseRemoteConfig$$Lambda$10 instance = new FirebaseRemoteConfig$$Lambda$10();

    private FirebaseRemoteConfig$$Lambda$10() {
    }

    public static SuccessContinuation lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task forResult;
        ConfigContainer configContainer = (ConfigContainer) obj;
        forResult = Tasks.forResult(null);
        return forResult;
    }
}
