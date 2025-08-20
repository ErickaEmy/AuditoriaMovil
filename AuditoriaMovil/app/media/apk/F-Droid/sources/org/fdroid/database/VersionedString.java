package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
/* compiled from: Version.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0001%B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015JL\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006&"}, d2 = {"Lorg/fdroid/database/VersionedString;", "", "repoId", "", "packageName", "", "versionId", BonjourPeer.TYPE, "Lorg/fdroid/database/VersionedStringType;", "name", "version", "", "(JLjava/lang/String;Ljava/lang/String;Lorg/fdroid/database/VersionedStringType;Ljava/lang/String;Ljava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "getPackageName", "getRepoId", "()J", "getType", "()Lorg/fdroid/database/VersionedStringType;", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVersionId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLjava/lang/String;Ljava/lang/String;Lorg/fdroid/database/VersionedStringType;Ljava/lang/String;Ljava/lang/Integer;)Lorg/fdroid/database/VersionedString;", "equals", "", "other", "hashCode", "toString", "Companion", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VersionedString {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE = "VersionedString";
    private final String name;
    private final String packageName;
    private final long repoId;
    private final VersionedStringType type;
    private final Integer version;
    private final String versionId;

    /* compiled from: Version.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/VersionedString$Companion;", "", "()V", "TABLE", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final long component1() {
        return this.repoId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.versionId;
    }

    public final VersionedStringType component4() {
        return this.type;
    }

    public final String component5() {
        return this.name;
    }

    public final Integer component6() {
        return this.version;
    }

    public final VersionedString copy(long j, String packageName, String versionId, VersionedStringType type, String name, Integer num) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        return new VersionedString(j, packageName, versionId, type, name, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VersionedString) {
            VersionedString versionedString = (VersionedString) obj;
            return this.repoId == versionedString.repoId && Intrinsics.areEqual(this.packageName, versionedString.packageName) && Intrinsics.areEqual(this.versionId, versionedString.versionId) && this.type == versionedString.type && Intrinsics.areEqual(this.name, versionedString.name) && Intrinsics.areEqual(this.version, versionedString.version);
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getRepoId() {
        return this.repoId;
    }

    public final VersionedStringType getType() {
        return this.type;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    public int hashCode() {
        int m = ((((((((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.packageName.hashCode()) * 31) + this.versionId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31;
        Integer num = this.version;
        return m + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        long j = this.repoId;
        String str = this.packageName;
        String str2 = this.versionId;
        VersionedStringType versionedStringType = this.type;
        String str3 = this.name;
        Integer num = this.version;
        return "VersionedString(repoId=" + j + ", packageName=" + str + ", versionId=" + str2 + ", type=" + versionedStringType + ", name=" + str3 + ", version=" + num + ")";
    }

    public VersionedString(long j, String packageName, String versionId, VersionedStringType type, String name, Integer num) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        this.repoId = j;
        this.packageName = packageName;
        this.versionId = versionId;
        this.type = type;
        this.name = name;
        this.version = num;
    }

    public /* synthetic */ VersionedString(long j, String str, String str2, VersionedStringType versionedStringType, String str3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, versionedStringType, str3, (i & 32) != 0 ? null : num);
    }
}
