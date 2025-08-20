package com.google.firebase.platforminfo;

import com.google.auto.value.AutoValue;
/* JADX INFO: Access modifiers changed from: package-private */
@AutoValue
/* loaded from: classes.dex */
public abstract class LibraryVersion {
    public static LibraryVersion create(String str, String str2) {
        return new AutoValue_LibraryVersion(str, str2);
    }

    public abstract String getLibraryName();

    public abstract String getVersion();
}
