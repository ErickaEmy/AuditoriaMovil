package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
/* compiled from: App.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u0000 *2\u00020\u0001:\u0001*BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003Jd\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006+"}, d2 = {"Lorg/fdroid/database/LocalizedIcon;", "Lorg/fdroid/database/IFile;", "repoId", "", "packageName", "", BonjourPeer.TYPE, "locale", "name", "sha256", "size", "ipfsCidV1", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getIpfsCidV1", "()Ljava/lang/String;", "getLocale", "getName", "getPackageName", "getRepoId", "()J", "getSha256", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lorg/fdroid/database/LocalizedIcon;", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalizedIcon implements IFile {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE = "LocalizedIcon";
    private final String ipfsCidV1;
    private final String locale;
    private final String name;
    private final String packageName;
    private final long repoId;
    private final String sha256;
    private final Long size;
    private final String type;

    /* compiled from: App.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/LocalizedIcon$Companion;", "", "()V", "TABLE", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        return this.type;
    }

    public final String component4() {
        return this.locale;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.sha256;
    }

    public final Long component7() {
        return this.size;
    }

    public final String component8() {
        return this.ipfsCidV1;
    }

    public final LocalizedIcon copy(long j, String packageName, String type, String locale, String name, String str, Long l, String str2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(name, "name");
        return new LocalizedIcon(j, packageName, type, locale, name, str, l, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalizedIcon) {
            LocalizedIcon localizedIcon = (LocalizedIcon) obj;
            return this.repoId == localizedIcon.repoId && Intrinsics.areEqual(this.packageName, localizedIcon.packageName) && Intrinsics.areEqual(this.type, localizedIcon.type) && Intrinsics.areEqual(this.locale, localizedIcon.locale) && Intrinsics.areEqual(this.name, localizedIcon.name) && Intrinsics.areEqual(this.sha256, localizedIcon.sha256) && Intrinsics.areEqual(this.size, localizedIcon.size) && Intrinsics.areEqual(this.ipfsCidV1, localizedIcon.ipfsCidV1);
        }
        return false;
    }

    @Override // org.fdroid.database.IFile
    public String getIpfsCidV1() {
        return this.ipfsCidV1;
    }

    @Override // org.fdroid.database.IFile
    public String getLocale() {
        return this.locale;
    }

    @Override // org.fdroid.database.IFile
    public String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getRepoId() {
        return this.repoId;
    }

    @Override // org.fdroid.database.IFile
    public String getSha256() {
        return this.sha256;
    }

    @Override // org.fdroid.database.IFile
    public Long getSize() {
        return this.size;
    }

    @Override // org.fdroid.database.IFile
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int m = ((((((((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.packageName.hashCode()) * 31) + this.type.hashCode()) * 31) + this.locale.hashCode()) * 31) + this.name.hashCode()) * 31;
        String str = this.sha256;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.size;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.ipfsCidV1;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        long j = this.repoId;
        String str = this.packageName;
        String str2 = this.type;
        String str3 = this.locale;
        String str4 = this.name;
        String str5 = this.sha256;
        Long l = this.size;
        String str6 = this.ipfsCidV1;
        return "LocalizedIcon(repoId=" + j + ", packageName=" + str + ", type=" + str2 + ", locale=" + str3 + ", name=" + str4 + ", sha256=" + str5 + ", size=" + l + ", ipfsCidV1=" + str6 + ")";
    }

    public LocalizedIcon(long j, String packageName, String type, String locale, String name, String str, Long l, String str2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(name, "name");
        this.repoId = j;
        this.packageName = packageName;
        this.type = type;
        this.locale = locale;
        this.name = name;
        this.sha256 = str;
        this.size = l;
        this.ipfsCidV1 = str2;
    }

    public /* synthetic */ LocalizedIcon(long j, String str, String str2, String str3, String str4, String str5, Long l, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, str3, str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str6);
    }
}
