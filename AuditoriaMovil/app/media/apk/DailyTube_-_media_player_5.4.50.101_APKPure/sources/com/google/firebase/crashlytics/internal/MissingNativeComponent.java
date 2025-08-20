package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class MissingNativeComponent implements CrashlyticsNativeComponent {
    private static final NativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER = new MissingNativeSessionFileProvider((1) null);

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean finalizeSession(@NonNull String str) {
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    @NonNull
    public NativeSessionFileProvider getSessionFileProvider(@NonNull String str) {
        return MISSING_NATIVE_SESSION_FILE_PROVIDER;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean hasCrashDataForSession(@NonNull String str) {
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean openSession(@NonNull String str) {
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void writeBeginSession(@NonNull String str, @NonNull String str2, long j2) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void writeSessionApp(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void writeSessionDevice(@NonNull String str, int i, @NonNull String str2, int i5, long j2, long j4, boolean z2, int i6, @NonNull String str3, @NonNull String str4) {
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void writeSessionOs(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) {
    }
}
