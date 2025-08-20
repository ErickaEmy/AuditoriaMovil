package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Repository.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lorg/fdroid/database/Mirror;", "", "repoId", "", "url", "", "location", "(JLjava/lang/String;Ljava/lang/String;)V", "getLocation", "()Ljava/lang/String;", "getRepoId", "()J", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toDownloadMirror", "Lorg/fdroid/download/Mirror;", "toString", "Companion", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Mirror {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE = "Mirror";
    private final String location;
    private final long repoId;
    private final String url;

    /* compiled from: Repository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/Mirror$Companion;", "", "()V", "TABLE", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ Mirror copy$default(Mirror mirror, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mirror.repoId;
        }
        if ((i & 2) != 0) {
            str = mirror.url;
        }
        if ((i & 4) != 0) {
            str2 = mirror.location;
        }
        return mirror.copy(j, str, str2);
    }

    public final long component1() {
        return this.repoId;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.location;
    }

    public final Mirror copy(long j, String url, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new Mirror(j, url, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Mirror) {
            Mirror mirror = (Mirror) obj;
            return this.repoId == mirror.repoId && Intrinsics.areEqual(this.url, mirror.url) && Intrinsics.areEqual(this.location, mirror.location);
        }
        return false;
    }

    public final String getLocation() {
        return this.location;
    }

    public final long getRepoId() {
        return this.repoId;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int m = ((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.url.hashCode()) * 31;
        String str = this.location;
        return m + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        long j = this.repoId;
        String str = this.url;
        String str2 = this.location;
        return "Mirror(repoId=" + j + ", url=" + str + ", location=" + str2 + ")";
    }

    public Mirror(long j, String url, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.repoId = j;
        this.url = url;
        this.location = str;
    }

    public /* synthetic */ Mirror(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i & 4) != 0 ? null : str2);
    }

    public final org.fdroid.download.Mirror toDownloadMirror() {
        return new org.fdroid.download.Mirror(this.url, this.location, false, 4, null);
    }
}
