package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class KeyValueBuilder {
    private final FirebaseCrashlytics crashlytics;

    public KeyValueBuilder(FirebaseCrashlytics crashlytics) {
        Intrinsics.checkParameterIsNotNull(crashlytics, "crashlytics");
        this.crashlytics = crashlytics;
    }

    public final void key(String key, boolean z2) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.crashlytics.setCustomKey(key, z2);
    }

    public final void key(String key, double d2) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.crashlytics.setCustomKey(key, d2);
    }

    public final void key(String key, float f4) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.crashlytics.setCustomKey(key, f4);
    }

    public final void key(String key, int i) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.crashlytics.setCustomKey(key, i);
    }

    public final void key(String key, long j2) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.crashlytics.setCustomKey(key, j2);
    }

    public final void key(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.crashlytics.setCustomKey(key, value);
    }
}
