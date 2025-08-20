package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
/* loaded from: classes.dex */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$3 implements SuccessContinuation {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$3(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static SuccessContinuation lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$3(firebaseRemoteConfig);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task activate;
        Void r2 = (Void) obj;
        activate = this.arg$1.activate();
        return activate;
    }
}
