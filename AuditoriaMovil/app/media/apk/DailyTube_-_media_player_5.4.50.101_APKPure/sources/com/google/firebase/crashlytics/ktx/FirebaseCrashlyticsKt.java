package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class FirebaseCrashlyticsKt {
    public static final FirebaseCrashlytics getCrashlytics(Firebase receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(firebaseCrashlytics, "FirebaseCrashlytics.getInstance()");
        return firebaseCrashlytics;
    }

    public static final void setCustomKeys(FirebaseCrashlytics receiver$0, Function1<? super KeyValueBuilder, Unit> init) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(init, "init");
        init.invoke(new KeyValueBuilder(receiver$0));
    }
}
