package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.PackagePreference;
import org.fdroid.fdroid.Preferences;
/* compiled from: AppPrefs.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÀ\u0003¢\u0006\u0002\b\u001dJ@\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\u000e\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0005J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0006\u0010(\u001a\u00020\u0000J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0003R\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000b¨\u0006-"}, d2 = {"Lorg/fdroid/database/AppPrefs;", "Lorg/fdroid/PackagePreference;", "packageName", "", "ignoreVersionCodeUpdate", "", "preferredRepoId", "appPrefReleaseChannels", "", "(Ljava/lang/String;JLjava/lang/Long;Ljava/util/List;)V", "getAppPrefReleaseChannels$database_release", "()Ljava/util/List;", "ignoreAllUpdates", "", "getIgnoreAllUpdates", "()Z", "getIgnoreVersionCodeUpdate", "()J", "getPackageName", "()Ljava/lang/String;", "getPreferredRepoId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "releaseChannels", "getReleaseChannels", "component1", "component2", "component3", "component4", "component4$database_release", "copy", "(Ljava/lang/String;JLjava/lang/Long;Ljava/util/List;)Lorg/fdroid/database/AppPrefs;", "equals", "other", "", "hashCode", "", "shouldIgnoreUpdate", "versionCode", "toString", "toggleIgnoreAllUpdates", "toggleIgnoreVersionCodeUpdate", "toggleReleaseChannel", "releaseChannel", "Companion", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppPrefs implements PackagePreference {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE = "AppPrefs";
    private final List<String> appPrefReleaseChannels;
    private final long ignoreVersionCodeUpdate;
    private final String packageName;
    private final Long preferredRepoId;

    /* compiled from: AppPrefs.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/AppPrefs$Companion;", "", "()V", "TABLE", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ AppPrefs copy$default(AppPrefs appPrefs, String str, long j, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appPrefs.packageName;
        }
        if ((i & 2) != 0) {
            j = appPrefs.ignoreVersionCodeUpdate;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            l = appPrefs.preferredRepoId;
        }
        Long l2 = l;
        List<String> list2 = list;
        if ((i & 8) != 0) {
            list2 = appPrefs.appPrefReleaseChannels;
        }
        return appPrefs.copy(str, j2, l2, list2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final long component2() {
        return this.ignoreVersionCodeUpdate;
    }

    public final Long component3() {
        return this.preferredRepoId;
    }

    public final List<String> component4$database_release() {
        return this.appPrefReleaseChannels;
    }

    public final AppPrefs copy(String packageName, long j, Long l, List<String> list) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new AppPrefs(packageName, j, l, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppPrefs) {
            AppPrefs appPrefs = (AppPrefs) obj;
            return Intrinsics.areEqual(this.packageName, appPrefs.packageName) && this.ignoreVersionCodeUpdate == appPrefs.ignoreVersionCodeUpdate && Intrinsics.areEqual(this.preferredRepoId, appPrefs.preferredRepoId) && Intrinsics.areEqual(this.appPrefReleaseChannels, appPrefs.appPrefReleaseChannels);
        }
        return false;
    }

    public final List<String> getAppPrefReleaseChannels$database_release() {
        return this.appPrefReleaseChannels;
    }

    @Override // org.fdroid.PackagePreference
    public long getIgnoreVersionCodeUpdate() {
        return this.ignoreVersionCodeUpdate;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Long getPreferredRepoId() {
        return this.preferredRepoId;
    }

    public int hashCode() {
        int hashCode = ((this.packageName.hashCode() * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.ignoreVersionCodeUpdate)) * 31;
        Long l = this.preferredRepoId;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        List<String> list = this.appPrefReleaseChannels;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.packageName;
        long j = this.ignoreVersionCodeUpdate;
        Long l = this.preferredRepoId;
        List<String> list = this.appPrefReleaseChannels;
        return "AppPrefs(packageName=" + str + ", ignoreVersionCodeUpdate=" + j + ", preferredRepoId=" + l + ", appPrefReleaseChannels=" + list + ")";
    }

    public AppPrefs(String packageName, long j, Long l, List<String> list) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.ignoreVersionCodeUpdate = j;
        this.preferredRepoId = l;
        this.appPrefReleaseChannels = list;
    }

    public /* synthetic */ AppPrefs(String str, long j, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : list);
    }

    public final boolean getIgnoreAllUpdates() {
        return getIgnoreVersionCodeUpdate() == Preferences.UPDATE_INTERVAL_DISABLED;
    }

    @Override // org.fdroid.PackagePreference
    public List<String> getReleaseChannels() {
        List<String> emptyList;
        List<String> list = this.appPrefReleaseChannels;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public final boolean shouldIgnoreUpdate(long j) {
        return getIgnoreVersionCodeUpdate() >= j;
    }

    public final AppPrefs toggleIgnoreAllUpdates() {
        return copy$default(this, null, getIgnoreAllUpdates() ? 0L : Preferences.UPDATE_INTERVAL_DISABLED, null, null, 13, null);
    }

    public final AppPrefs toggleIgnoreVersionCodeUpdate(long j) {
        if (shouldIgnoreUpdate(j)) {
            j = 0;
        }
        return copy$default(this, null, j, null, null, 13, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.fdroid.database.AppPrefs toggleReleaseChannel(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "releaseChannel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r2 = 0
            r3 = 0
            r5 = 0
            java.util.List<java.lang.String> r0 = r9.appPrefReleaseChannels
            if (r0 == 0) goto L21
            boolean r0 = r0.contains(r10)
            r1 = 1
            if (r0 != r1) goto L21
            java.util.List<java.lang.String> r0 = r9.appPrefReleaseChannels
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            r0.remove(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L1f:
            r6 = r0
            goto L36
        L21:
            java.util.List<java.lang.String> r0 = r9.appPrefReleaseChannels
            if (r0 == 0) goto L2b
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            if (r0 != 0) goto L30
        L2b:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L30:
            r0.add(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L1f
        L36:
            r7 = 7
            r8 = 0
            r1 = r9
            org.fdroid.database.AppPrefs r10 = copy$default(r1, r2, r3, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.AppPrefs.toggleReleaseChannel(java.lang.String):org.fdroid.database.AppPrefs");
    }
}
