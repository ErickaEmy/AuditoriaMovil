package org.fdroid.database;

import androidx.core.os.LocaleListCompat;
import ch.qos.logback.core.joran.action.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.LocaleChooser;
import org.fdroid.index.v2.FileV1;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.PermissionV2;
/* compiled from: Version.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000e\u00102\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b3J\u0016\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b5J%\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0018\u00109\u001a\u0004\u0018\u00010\r2\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u0004\u0018\u00010\r2\u0006\u0010;\u001a\u00020<J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\rHÖ\u0001R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000fR\u0011\u0010\u001f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u000fR\u0011\u0010$\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b%\u0010\u000bR\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010\u000fR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000f¨\u0006A"}, d2 = {"Lorg/fdroid/database/AppVersion;", "", "version", "Lorg/fdroid/database/Version;", "versionedStrings", "", "Lorg/fdroid/database/VersionedString;", "(Lorg/fdroid/database/Version;Ljava/util/List;)V", "added", "", "getAdded", "()J", "antiFeatureKeys", "", "getAntiFeatureKeys", "()Ljava/util/List;", "featureNames", "getFeatureNames", Action.FILE_ATTRIBUTE, "Lorg/fdroid/index/v2/FileV1;", "getFile", "()Lorg/fdroid/index/v2/FileV1;", "isCompatible", "", "()Z", "manifest", "Lorg/fdroid/database/AppManifest;", "getManifest", "()Lorg/fdroid/database/AppManifest;", "nativeCode", "getNativeCode", "packageName", "getPackageName", "()Ljava/lang/String;", "releaseChannels", "getReleaseChannels", "repoId", "getRepoId", "src", "Lorg/fdroid/index/v2/FileV2;", "getSrc", "()Lorg/fdroid/index/v2/FileV2;", "usesPermission", "Lorg/fdroid/index/v2/PermissionV2;", "getUsesPermission", "usesPermissionSdk23", "getUsesPermissionSdk23", "getVersion$database_release", "()Lorg/fdroid/database/Version;", "getVersionedStrings$database_release", "component1", "component1$database_release", "component2", "component2$database_release", "copy", "equals", "other", "getAntiFeatureReason", "antiFeatureKey", "localeList", "Landroidx/core/os/LocaleListCompat;", "getWhatsNew", "hashCode", "", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppVersion {
    private final Version version;
    private final List<VersionedString> versionedStrings;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppVersion copy$default(AppVersion appVersion, Version version, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            version = appVersion.version;
        }
        if ((i & 2) != 0) {
            list = appVersion.versionedStrings;
        }
        return appVersion.copy(version, list);
    }

    public final Version component1$database_release() {
        return this.version;
    }

    public final List<VersionedString> component2$database_release() {
        return this.versionedStrings;
    }

    public final AppVersion copy(Version version, List<VersionedString> list) {
        Intrinsics.checkNotNullParameter(version, "version");
        return new AppVersion(version, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppVersion) {
            AppVersion appVersion = (AppVersion) obj;
            return Intrinsics.areEqual(this.version, appVersion.version) && Intrinsics.areEqual(this.versionedStrings, appVersion.versionedStrings);
        }
        return false;
    }

    public final Version getVersion$database_release() {
        return this.version;
    }

    public final List<VersionedString> getVersionedStrings$database_release() {
        return this.versionedStrings;
    }

    public int hashCode() {
        int hashCode = this.version.hashCode() * 31;
        List<VersionedString> list = this.versionedStrings;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        Version version = this.version;
        List<VersionedString> list = this.versionedStrings;
        return "AppVersion(version=" + version + ", versionedStrings=" + list + ")";
    }

    public AppVersion(Version version, List<VersionedString> list) {
        Intrinsics.checkNotNullParameter(version, "version");
        this.version = version;
        this.versionedStrings = list;
    }

    public final long getRepoId() {
        return this.version.getRepoId();
    }

    public final String getPackageName() {
        return this.version.getPackageName();
    }

    public final long getAdded() {
        return this.version.getAdded();
    }

    public final boolean isCompatible() {
        return this.version.isCompatible();
    }

    public final AppManifest getManifest() {
        return this.version.getManifest();
    }

    public final FileV1 getFile() {
        return this.version.getFile();
    }

    public final FileV2 getSrc() {
        return this.version.getSrc();
    }

    public final List<PermissionV2> getUsesPermission() {
        List<PermissionV2> emptyList;
        List<PermissionV2> permissions;
        List<VersionedString> list = this.versionedStrings;
        if (list == null || (permissions = VersionKt.getPermissions(list, this.version)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return permissions;
    }

    public final List<PermissionV2> getUsesPermissionSdk23() {
        List<PermissionV2> emptyList;
        List<PermissionV2> permissionsSdk23;
        List<VersionedString> list = this.versionedStrings;
        if (list == null || (permissionsSdk23 = VersionKt.getPermissionsSdk23(list, this.version)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return permissionsSdk23;
    }

    public final List<String> getFeatureNames() {
        List<String> emptyList;
        List<String> features = this.version.getManifest().getFeatures();
        if (features == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return features;
    }

    public final List<String> getNativeCode() {
        List<String> emptyList;
        List<String> nativecode = this.version.getManifest().getNativecode();
        if (nativecode == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return nativecode;
    }

    public final List<String> getReleaseChannels() {
        List<String> emptyList;
        List<String> releaseChannels = this.version.getReleaseChannels();
        if (releaseChannels == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return releaseChannels;
    }

    public final List<String> getAntiFeatureKeys() {
        List<String> emptyList;
        Map<String, Map<String, String>> antiFeatures = this.version.getAntiFeatures();
        if (antiFeatures == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList(antiFeatures.size());
        for (Map.Entry<String, Map<String, String>> entry : antiFeatures.entrySet()) {
            arrayList.add(entry.getKey());
        }
        return arrayList;
    }

    public final String getWhatsNew(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (String) LocaleChooser.INSTANCE.getBestLocale(this.version.getWhatsNew(), localeList);
    }

    public final String getAntiFeatureReason(String antiFeatureKey, LocaleListCompat localeList) {
        Map<String, String> map;
        Intrinsics.checkNotNullParameter(antiFeatureKey, "antiFeatureKey");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        Map<String, Map<String, String>> antiFeatures = this.version.getAntiFeatures();
        if (antiFeatures == null || (map = antiFeatures.get(antiFeatureKey)) == null) {
            return null;
        }
        return (String) LocaleChooser.INSTANCE.getBestLocale(map, localeList);
    }
}
