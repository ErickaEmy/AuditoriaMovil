package org.fdroid.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.v2.FeatureV2;
import org.fdroid.index.v2.ManifestV2;
import org.fdroid.index.v2.PackageVersionV2;
import org.fdroid.index.v2.PermissionV2;
import org.fdroid.index.v2.SignerV2;
import org.fdroid.index.v2.UsesSdkV2;
/* compiled from: Version.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a7\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0002¢\u0006\u0002\u0010\u0010\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\bH\u0000\u001a,\u0010\u0013\u001a\u00020\u0005*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u001a(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\rH\u0000¨\u0006\u001e"}, d2 = {"getPermissions", "", "Lorg/fdroid/index/v2/PermissionV2;", "Lorg/fdroid/database/VersionedString;", "version", "Lorg/fdroid/database/Version;", "getPermissionsSdk23", "getVersionedStrings", "Lorg/fdroid/index/v2/ManifestV2;", "map", "T", "v", "wantedType", "Lorg/fdroid/database/VersionedStringType;", "factory", "Lkotlin/Function0;", "(Lorg/fdroid/database/VersionedString;Lorg/fdroid/database/Version;Lorg/fdroid/database/VersionedStringType;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toManifest", "Lorg/fdroid/database/AppManifest;", "toVersion", "Lorg/fdroid/index/v2/PackageVersionV2;", "repoId", "", "packageName", "", "versionId", "isCompatible", "", "toVersionedString", BonjourPeer.TYPE, "database_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VersionKt {
    public static final Version toVersion(PackageVersionV2 packageVersionV2, long j, String packageName, String versionId, boolean z) {
        Intrinsics.checkNotNullParameter(packageVersionV2, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        return new Version(j, packageName, versionId, packageVersionV2.getAdded(), packageVersionV2.getFile(), packageVersionV2.getSrc(), toManifest(packageVersionV2.getManifest()), packageVersionV2.getReleaseChannels(), packageVersionV2.getAntiFeatures(), packageVersionV2.getWhatsNew(), z);
    }

    public static final AppManifest toManifest(ManifestV2 manifestV2) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(manifestV2, "<this>");
        String versionName = manifestV2.getVersionName();
        long versionCode = manifestV2.getVersionCode();
        UsesSdkV2 usesSdk = manifestV2.getUsesSdk();
        Integer maxSdkVersion = manifestV2.getMaxSdkVersion();
        SignerV2 signer = manifestV2.getSigner();
        List<String> nativecode = manifestV2.getNativecode();
        List<FeatureV2> features = manifestV2.getFeatures();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(features, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (FeatureV2 featureV2 : features) {
            arrayList.add(featureV2.getName());
        }
        return new AppManifest(versionName, versionCode, usesSdk, maxSdkVersion, signer, nativecode, arrayList);
    }

    public static final List<VersionedString> getVersionedStrings(ManifestV2 manifestV2, Version version) {
        List<VersionedString> plus;
        Intrinsics.checkNotNullParameter(manifestV2, "<this>");
        Intrinsics.checkNotNullParameter(version, "version");
        plus = CollectionsKt___CollectionsKt.plus((Collection) toVersionedString(manifestV2.getUsesPermission(), version, VersionedStringType.PERMISSION), (Iterable) toVersionedString(manifestV2.getUsesPermissionSdk23(), version, VersionedStringType.PERMISSION_SDK_23));
        return plus;
    }

    private static final <T> T map(VersionedString versionedString, Version version, VersionedStringType versionedStringType, Function0 function0) {
        if (versionedString.getRepoId() == version.getRepoId() && Intrinsics.areEqual(versionedString.getPackageName(), version.getPackageName()) && Intrinsics.areEqual(versionedString.getVersionId(), version.getVersionId()) && versionedString.getType() == versionedStringType) {
            return (T) function0.invoke();
        }
        return null;
    }

    public static final List<VersionedString> toVersionedString(List<PermissionV2> list, Version version, VersionedStringType type) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(type, "type");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (PermissionV2 permissionV2 : list) {
            arrayList.add(new VersionedString(version.getRepoId(), version.getPackageName(), version.getVersionId(), type, permissionV2.getName(), permissionV2.getMaxSdkVersion()));
        }
        return arrayList;
    }

    public static final List<PermissionV2> getPermissions(List<VersionedString> list, Version version) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(version, "version");
        ArrayList arrayList = new ArrayList();
        for (final VersionedString versionedString : list) {
            PermissionV2 permissionV2 = (PermissionV2) map(versionedString, version, VersionedStringType.PERMISSION, new Function0() { // from class: org.fdroid.database.VersionKt$getPermissions$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final PermissionV2 invoke() {
                    return new PermissionV2(VersionedString.this.getName(), VersionedString.this.getVersion());
                }
            });
            if (permissionV2 != null) {
                arrayList.add(permissionV2);
            }
        }
        return arrayList;
    }

    public static final List<PermissionV2> getPermissionsSdk23(List<VersionedString> list, Version version) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(version, "version");
        ArrayList arrayList = new ArrayList();
        for (final VersionedString versionedString : list) {
            PermissionV2 permissionV2 = (PermissionV2) map(versionedString, version, VersionedStringType.PERMISSION_SDK_23, new Function0() { // from class: org.fdroid.database.VersionKt$getPermissionsSdk23$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final PermissionV2 invoke() {
                    return new PermissionV2(VersionedString.this.getName(), VersionedString.this.getVersion());
                }
            });
            if (permissionV2 != null) {
                arrayList.add(permissionV2);
            }
        }
        return arrayList;
    }
}
