package com.google.firebase.crashlytics.internal.settings.model;
/* loaded from: classes.dex */
public class SessionSettingsData {
    public final int maxCompleteSessionsCount;
    public final int maxCustomExceptionEvents;

    public SessionSettingsData(int i, int i5) {
        this.maxCustomExceptionEvents = i;
        this.maxCompleteSessionsCount = i5;
    }
}
