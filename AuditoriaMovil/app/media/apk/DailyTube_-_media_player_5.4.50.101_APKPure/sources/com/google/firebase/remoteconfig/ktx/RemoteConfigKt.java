package com.google.firebase.remoteconfig.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class RemoteConfigKt {
    public static final FirebaseRemoteConfigValue get(FirebaseRemoteConfig receiver$0, String key) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(key, "key");
        FirebaseRemoteConfigValue value = receiver$0.getValue(key);
        Intrinsics.checkExpressionValueIsNotNull(value, "this.getValue(key)");
        return value;
    }

    public static final FirebaseRemoteConfig getRemoteConfig(Firebase receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(firebaseRemoteConfig, "FirebaseRemoteConfig.getInstance()");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfig remoteConfig(Firebase receiver$0, FirebaseApp app) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(app, "app");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance(app);
        Intrinsics.checkExpressionValueIsNotNull(firebaseRemoteConfig, "FirebaseRemoteConfig.getInstance(app)");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfigSettings remoteConfigSettings(Function1<? super FirebaseRemoteConfigSettings.Builder, Unit> init) {
        Intrinsics.checkParameterIsNotNull(init, "init");
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        init.invoke(builder);
        FirebaseRemoteConfigSettings build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.build()");
        return build;
    }
}
