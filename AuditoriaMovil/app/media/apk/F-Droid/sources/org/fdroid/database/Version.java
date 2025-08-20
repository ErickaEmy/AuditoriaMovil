package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import ch.qos.logback.core.joran.action.Action;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.v2.FileV1;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.PackageManifest;
import org.fdroid.index.v2.PackageV2Kt;
import org.fdroid.index.v2.PackageVersion;
import org.fdroid.index.v2.SignerV2;
/* compiled from: Version.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 L2\u00020\u0001:\u0001LB¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012&\b\u0002\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u0012\u0018\u00010\u0011\u0012\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u001d\u00106\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0015HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fHÆ\u0003J'\u0010?\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u0012\u0018\u00010\u0011HÆ\u0003J³\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2&\b\u0002\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u0012\u0018\u00010\u00112\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\u0004\u0018\u0001`\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010A\u001a\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\u001b\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u000fH\u0000¢\u0006\u0002\bJJ\t\u0010K\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u001fR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0016\u0010+\u001a\u0004\u0018\u00010,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R%\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001a¨\u0006M"}, d2 = {"Lorg/fdroid/database/Version;", "Lorg/fdroid/index/v2/PackageVersion;", "repoId", "", "packageName", "", "versionId", "added", Action.FILE_ATTRIBUTE, "Lorg/fdroid/index/v2/FileV1;", "src", "Lorg/fdroid/index/v2/FileV2;", "manifest", "Lorg/fdroid/database/AppManifest;", "releaseChannels", "", "antiFeatures", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "whatsNew", "isCompatible", "", "(JLjava/lang/String;Ljava/lang/String;JLorg/fdroid/index/v2/FileV1;Lorg/fdroid/index/v2/FileV2;Lorg/fdroid/database/AppManifest;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Z)V", "getAdded", "()J", "getAntiFeatures", "()Ljava/util/Map;", "getFile", "()Lorg/fdroid/index/v2/FileV1;", "hasKnownVulnerability", "getHasKnownVulnerability", "()Z", "getManifest", "()Lorg/fdroid/database/AppManifest;", "packageManifest", "Lorg/fdroid/index/v2/PackageManifest;", "getPackageManifest", "()Lorg/fdroid/index/v2/PackageManifest;", "getPackageName", "()Ljava/lang/String;", "getReleaseChannels", "()Ljava/util/List;", "getRepoId", "signer", "Lorg/fdroid/index/v2/SignerV2;", "getSigner", "()Lorg/fdroid/index/v2/SignerV2;", "getSrc", "()Lorg/fdroid/index/v2/FileV2;", "versionCode", "getVersionCode", "getVersionId", "getWhatsNew", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toAppVersion", "Lorg/fdroid/database/AppVersion;", "versionedStrings", "Lorg/fdroid/database/VersionedString;", "toAppVersion$database_release", "toString", "Companion", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Version implements PackageVersion {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE = "Version";
    private final long added;
    private final Map<String, Map<String, String>> antiFeatures;
    private final FileV1 file;
    private final boolean isCompatible;
    private final AppManifest manifest;
    private final String packageName;
    private final List<String> releaseChannels;
    private final long repoId;
    private final FileV2 src;
    private final String versionId;
    private final Map<String, String> whatsNew;

    /* compiled from: Version.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/Version$Companion;", "", "()V", "TABLE", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Version copy$default(Version version, long j, String str, String str2, long j2, FileV1 fileV1, FileV2 fileV2, AppManifest appManifest, List list, Map map, Map map2, boolean z, int i, Object obj) {
        return version.copy((i & 1) != 0 ? version.repoId : j, (i & 2) != 0 ? version.packageName : str, (i & 4) != 0 ? version.versionId : str2, (i & 8) != 0 ? version.added : j2, (i & 16) != 0 ? version.file : fileV1, (i & 32) != 0 ? version.src : fileV2, (i & 64) != 0 ? version.manifest : appManifest, (i & 128) != 0 ? version.releaseChannels : list, (i & 256) != 0 ? version.antiFeatures : map, (i & 512) != 0 ? version.whatsNew : map2, (i & 1024) != 0 ? version.isCompatible : z);
    }

    public final long component1() {
        return this.repoId;
    }

    public final Map<String, String> component10() {
        return this.whatsNew;
    }

    public final boolean component11() {
        return this.isCompatible;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.versionId;
    }

    public final long component4() {
        return this.added;
    }

    public final FileV1 component5() {
        return this.file;
    }

    public final FileV2 component6() {
        return this.src;
    }

    public final AppManifest component7() {
        return this.manifest;
    }

    public final List<String> component8() {
        return this.releaseChannels;
    }

    public final Map<String, Map<String, String>> component9() {
        return this.antiFeatures;
    }

    public final Version copy(long j, String packageName, String versionId, long j2, FileV1 file, FileV2 fileV2, AppManifest manifest, List<String> list, Map<String, ? extends Map<String, String>> map, Map<String, String> map2, boolean z) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        return new Version(j, packageName, versionId, j2, file, fileV2, manifest, list, map, map2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Version) {
            Version version = (Version) obj;
            return this.repoId == version.repoId && Intrinsics.areEqual(this.packageName, version.packageName) && Intrinsics.areEqual(this.versionId, version.versionId) && this.added == version.added && Intrinsics.areEqual(this.file, version.file) && Intrinsics.areEqual(this.src, version.src) && Intrinsics.areEqual(this.manifest, version.manifest) && Intrinsics.areEqual(this.releaseChannels, version.releaseChannels) && Intrinsics.areEqual(this.antiFeatures, version.antiFeatures) && Intrinsics.areEqual(this.whatsNew, version.whatsNew) && this.isCompatible == version.isCompatible;
        }
        return false;
    }

    public final long getAdded() {
        return this.added;
    }

    public final Map<String, Map<String, String>> getAntiFeatures() {
        return this.antiFeatures;
    }

    public final FileV1 getFile() {
        return this.file;
    }

    public final AppManifest getManifest() {
        return this.manifest;
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public PackageManifest getPackageManifest() {
        return this.manifest;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public List<String> getReleaseChannels() {
        return this.releaseChannels;
    }

    public final long getRepoId() {
        return this.repoId;
    }

    public final FileV2 getSrc() {
        return this.src;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    public final Map<String, String> getWhatsNew() {
        return this.whatsNew;
    }

    public int hashCode() {
        int m = ((((((((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.packageName.hashCode()) * 31) + this.versionId.hashCode()) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.added)) * 31) + this.file.hashCode()) * 31;
        FileV2 fileV2 = this.src;
        int hashCode = (((m + (fileV2 == null ? 0 : fileV2.hashCode())) * 31) + this.manifest.hashCode()) * 31;
        List<String> list = this.releaseChannels;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, Map<String, String>> map = this.antiFeatures;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String> map2 = this.whatsNew;
        return ((hashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.isCompatible);
    }

    public final boolean isCompatible() {
        return this.isCompatible;
    }

    public String toString() {
        long j = this.repoId;
        String str = this.packageName;
        String str2 = this.versionId;
        long j2 = this.added;
        FileV1 fileV1 = this.file;
        FileV2 fileV2 = this.src;
        AppManifest appManifest = this.manifest;
        List<String> list = this.releaseChannels;
        Map<String, Map<String, String>> map = this.antiFeatures;
        Map<String, String> map2 = this.whatsNew;
        boolean z = this.isCompatible;
        return "Version(repoId=" + j + ", packageName=" + str + ", versionId=" + str2 + ", added=" + j2 + ", file=" + fileV1 + ", src=" + fileV2 + ", manifest=" + appManifest + ", releaseChannels=" + list + ", antiFeatures=" + map + ", whatsNew=" + map2 + ", isCompatible=" + z + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Version(long j, String packageName, String versionId, long j2, FileV1 file, FileV2 fileV2, AppManifest manifest, List<String> list, Map<String, ? extends Map<String, String>> map, Map<String, String> map2, boolean z) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        this.repoId = j;
        this.packageName = packageName;
        this.versionId = versionId;
        this.added = j2;
        this.file = file;
        this.src = fileV2;
        this.manifest = manifest;
        this.releaseChannels = list;
        this.antiFeatures = map;
        this.whatsNew = map2;
        this.isCompatible = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Version(long r18, java.lang.String r20, java.lang.String r21, long r22, org.fdroid.index.v2.FileV1 r24, org.fdroid.index.v2.FileV2 r25, org.fdroid.database.AppManifest r26, java.util.List r27, java.util.Map r28, java.util.Map r29, boolean r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L9
            r11 = r2
            goto Lb
        L9:
            r11 = r25
        Lb:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L15
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r13 = r1
            goto L17
        L15:
            r13 = r27
        L17:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L1d
            r14 = r2
            goto L1f
        L1d:
            r14 = r28
        L1f:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L25
            r15 = r2
            goto L27
        L25:
            r15 = r29
        L27:
            r3 = r17
            r4 = r18
            r6 = r20
            r7 = r21
            r8 = r22
            r10 = r24
            r12 = r26
            r16 = r30
            r3.<init>(r4, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.Version.<init>(long, java.lang.String, java.lang.String, long, org.fdroid.index.v2.FileV1, org.fdroid.index.v2.FileV2, org.fdroid.database.AppManifest, java.util.List, java.util.Map, java.util.Map, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public long getVersionCode() {
        return this.manifest.getVersionCode();
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public SignerV2 getSigner() {
        return this.manifest.getSigner();
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public boolean getHasKnownVulnerability() {
        Map<String, Map<String, String>> map = this.antiFeatures;
        return map != null && map.containsKey(PackageV2Kt.ANTI_FEATURE_KNOWN_VULNERABILITY);
    }

    public final AppVersion toAppVersion$database_release(List<VersionedString> versionedStrings) {
        Intrinsics.checkNotNullParameter(versionedStrings, "versionedStrings");
        return new AppVersion(this, versionedStrings);
    }
}
