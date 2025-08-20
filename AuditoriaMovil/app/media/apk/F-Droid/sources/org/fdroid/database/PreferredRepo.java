package org.fdroid.database;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AppPrefs.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lorg/fdroid/database/PreferredRepo;", "", "packageName", "", "preferredRepoId", "", "(Ljava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getPreferredRepoId", "()J", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferredRepo {
    private final String packageName;
    private final long preferredRepoId;

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getPreferredRepoId() {
        return this.preferredRepoId;
    }

    public PreferredRepo(String packageName, long j) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.preferredRepoId = j;
    }
}
