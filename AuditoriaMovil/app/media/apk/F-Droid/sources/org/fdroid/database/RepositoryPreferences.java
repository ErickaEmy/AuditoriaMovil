package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.views.apps.AppListActivity;
/* compiled from: Repository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b(\b\u0081\b\u0018\u0000 32\u00020\u0001:\u00013Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\u000e\u0010#\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b$J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0080\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\nHÖ\u0001R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lorg/fdroid/database/RepositoryPreferences;", "", "repoId", "", "weight", "", "enabled", "", AppListActivity.SortClause.LAST_UPDATED, "lastETag", "", "userMirrors", "", "disabledMirrors", "username", "password", "(JIZLjava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getDisabledMirrors", "()Ljava/util/List;", "getEnabled", "()Z", "getLastETag$annotations", "()V", "getLastETag", "()Ljava/lang/String;", "getLastUpdated", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPassword", "getRepoId$database_release", "()J", "getUserMirrors", "getUsername", "getWeight", "()I", "component1", "component1$database_release", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JIZLjava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lorg/fdroid/database/RepositoryPreferences;", "equals", "other", "hashCode", "toString", "Companion", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepositoryPreferences {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE = "RepositoryPreferences";
    private final List<String> disabledMirrors;
    private final boolean enabled;
    private final String lastETag;
    private final Long lastUpdated;
    private final String password;
    private final long repoId;
    private final List<String> userMirrors;
    private final String username;
    private final int weight;

    /* compiled from: Repository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/RepositoryPreferences$Companion;", "", "()V", "TABLE", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void getLastETag$annotations() {
    }

    public final long component1$database_release() {
        return this.repoId;
    }

    public final int component2() {
        return this.weight;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final Long component4() {
        return this.lastUpdated;
    }

    public final String component5() {
        return this.lastETag;
    }

    public final List<String> component6() {
        return this.userMirrors;
    }

    public final List<String> component7() {
        return this.disabledMirrors;
    }

    public final String component8() {
        return this.username;
    }

    public final String component9() {
        return this.password;
    }

    public final RepositoryPreferences copy(long j, int i, boolean z, Long l, String str, List<String> list, List<String> list2, String str2, String str3) {
        return new RepositoryPreferences(j, i, z, l, str, list, list2, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RepositoryPreferences) {
            RepositoryPreferences repositoryPreferences = (RepositoryPreferences) obj;
            return this.repoId == repositoryPreferences.repoId && this.weight == repositoryPreferences.weight && this.enabled == repositoryPreferences.enabled && Intrinsics.areEqual(this.lastUpdated, repositoryPreferences.lastUpdated) && Intrinsics.areEqual(this.lastETag, repositoryPreferences.lastETag) && Intrinsics.areEqual(this.userMirrors, repositoryPreferences.userMirrors) && Intrinsics.areEqual(this.disabledMirrors, repositoryPreferences.disabledMirrors) && Intrinsics.areEqual(this.username, repositoryPreferences.username) && Intrinsics.areEqual(this.password, repositoryPreferences.password);
        }
        return false;
    }

    public final List<String> getDisabledMirrors() {
        return this.disabledMirrors;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getLastETag() {
        return this.lastETag;
    }

    public final Long getLastUpdated() {
        return this.lastUpdated;
    }

    public final String getPassword() {
        return this.password;
    }

    public final long getRepoId$database_release() {
        return this.repoId;
    }

    public final List<String> getUserMirrors() {
        return this.userMirrors;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int m = ((((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.weight) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.enabled)) * 31;
        Long l = this.lastUpdated;
        int hashCode = (m + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.lastETag;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.userMirrors;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.disabledMirrors;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.username;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.password;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        long j = this.repoId;
        int i = this.weight;
        boolean z = this.enabled;
        Long l = this.lastUpdated;
        String str = this.lastETag;
        List<String> list = this.userMirrors;
        List<String> list2 = this.disabledMirrors;
        String str2 = this.username;
        String str3 = this.password;
        return "RepositoryPreferences(repoId=" + j + ", weight=" + i + ", enabled=" + z + ", lastUpdated=" + l + ", lastETag=" + str + ", userMirrors=" + list + ", disabledMirrors=" + list2 + ", username=" + str2 + ", password=" + str3 + ")";
    }

    public RepositoryPreferences(long j, int i, boolean z, Long l, String str, List<String> list, List<String> list2, String str2, String str3) {
        this.repoId = j;
        this.weight = i;
        this.enabled = z;
        this.lastUpdated = l;
        this.lastETag = str;
        this.userMirrors = list;
        this.disabledMirrors = list2;
        this.username = str2;
        this.password = str3;
    }

    public /* synthetic */ RepositoryPreferences(long j, int i, boolean z, Long l, String str, List list, List list2, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? Long.valueOf(System.currentTimeMillis()) : l, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : list, (i2 & 64) != 0 ? null : list2, (i2 & 128) != 0 ? null : str2, (i2 & 256) != 0 ? null : str3);
    }
}
