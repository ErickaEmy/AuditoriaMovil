package org.fdroid.database;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.content.pm.PackageInfoCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.CompatibilityChecker;
import org.fdroid.CompatibilityCheckerImpl;
import org.fdroid.UpdateChecker;
/* compiled from: DbUpdateChecker.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ:\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0002J4\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00172\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007JN\u0010#\u001a\u0004\u0018\u00010\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00172\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lorg/fdroid/database/DbUpdateChecker;", "", "db", "Lorg/fdroid/database/FDroidDatabase;", "packageManager", "Landroid/content/pm/PackageManager;", "compatibilityChecker", "Lorg/fdroid/CompatibilityChecker;", "(Lorg/fdroid/database/FDroidDatabase;Landroid/content/pm/PackageManager;Lorg/fdroid/CompatibilityChecker;)V", "appDao", "Lorg/fdroid/database/AppDaoInt;", "appPrefsDao", "Lorg/fdroid/database/AppPrefsDaoInt;", "updateChecker", "Lorg/fdroid/UpdateChecker;", "versionDao", "Lorg/fdroid/database/VersionDaoInt;", "getSuggestedVersion", "Lorg/fdroid/database/AppVersion;", "packageName", "", "preferredSigner", "releaseChannels", "", "onlyFromPreferredRepo", "", "getUpdatableApp", "Lorg/fdroid/database/UpdatableApp;", "version", "Lorg/fdroid/database/Version;", "installedVersionCode", "", "isFromPreferredRepo", "getUpdatableApps", "includeKnownVulnerabilities", "getVersion", "versions", "packageInfo", "Landroid/content/pm/PackageInfo;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DbUpdateChecker {
    private final AppDaoInt appDao;
    private final AppPrefsDaoInt appPrefsDao;
    private final PackageManager packageManager;
    private final UpdateChecker updateChecker;
    private final VersionDaoInt versionDao;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DbUpdateChecker(FDroidDatabase db, PackageManager packageManager) {
        this(db, packageManager, null, 4, null);
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
    }

    public final List<UpdatableApp> getUpdatableApps() {
        return getUpdatableApps$default(this, null, false, false, 7, null);
    }

    public final List<UpdatableApp> getUpdatableApps(List<String> list) {
        return getUpdatableApps$default(this, list, false, false, 6, null);
    }

    public final List<UpdatableApp> getUpdatableApps(List<String> list, boolean z) {
        return getUpdatableApps$default(this, list, z, false, 4, null);
    }

    public DbUpdateChecker(FDroidDatabase db, PackageManager packageManager, CompatibilityChecker compatibilityChecker) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(compatibilityChecker, "compatibilityChecker");
        this.packageManager = packageManager;
        AppDao appDao = db.getAppDao();
        Intrinsics.checkNotNull(appDao, "null cannot be cast to non-null type org.fdroid.database.AppDaoInt");
        this.appDao = (AppDaoInt) appDao;
        VersionDao versionDao = db.getVersionDao();
        Intrinsics.checkNotNull(versionDao, "null cannot be cast to non-null type org.fdroid.database.VersionDaoInt");
        this.versionDao = (VersionDaoInt) versionDao;
        AppPrefsDao appPrefsDao = db.getAppPrefsDao();
        Intrinsics.checkNotNull(appPrefsDao, "null cannot be cast to non-null type org.fdroid.database.AppPrefsDaoInt");
        this.appPrefsDao = (AppPrefsDaoInt) appPrefsDao;
        this.updateChecker = new UpdateChecker(compatibilityChecker);
    }

    public /* synthetic */ DbUpdateChecker(FDroidDatabase fDroidDatabase, PackageManager packageManager, CompatibilityChecker compatibilityChecker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fDroidDatabase, packageManager, (i & 4) != 0 ? new CompatibilityCheckerImpl(packageManager, false, 0, null, 14, null) : compatibilityChecker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List getUpdatableApps$default(DbUpdateChecker dbUpdateChecker, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return dbUpdateChecker.getUpdatableApps(list, z, z2);
    }

    public final List<UpdatableApp> getUpdatableApps(List<String> list, boolean z, boolean z2) {
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        List<PackageInfo> installedPackages = this.packageManager.getInstalledPackages(64);
        Intrinsics.checkNotNullExpressionValue(installedPackages, "getInstalledPackages(...)");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(installedPackages, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (PackageInfo packageInfo : installedPackages) {
            arrayList2.add(packageInfo.packageName);
        }
        Map<String, Long> preferredRepos = this.appPrefsDao.getPreferredRepos(arrayList2);
        HashMap hashMap = new HashMap(arrayList2.size());
        for (Version version : this.versionDao.getVersions(arrayList2)) {
            Long l = preferredRepos.get(version.getPackageName());
            if (l == null) {
                String packageName = version.getPackageName();
                long repoId = version.getRepoId();
                throw new IllegalStateException(("No preferred repo for " + packageName + " in repo " + repoId).toString());
            }
            long longValue = l.longValue();
            if (!z || longValue == version.getRepoId()) {
                String packageName2 = version.getPackageName();
                Object obj = hashMap.get(packageName2);
                if (obj == null) {
                    obj = new ArrayList();
                    hashMap.put(packageName2, obj);
                }
                ((ArrayList) obj).add(version);
            }
        }
        for (PackageInfo packageInfo2 : installedPackages) {
            String str = packageInfo2.packageName;
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null) {
                Intrinsics.checkNotNull(arrayList3);
                Intrinsics.checkNotNull(str);
                Version version2 = getVersion(arrayList3, str, packageInfo2, null, list, z2);
                if (version2 == null) {
                    continue;
                } else {
                    Long l2 = preferredRepos.get(str);
                    if (l2 == null) {
                        throw new IllegalStateException(("No preferred repo for " + str).toString());
                    }
                    UpdatableApp updatableApp = getUpdatableApp(version2, PackageInfoCompat.getLongVersionCode(packageInfo2), l2.longValue() == version2.getRepoId());
                    if (updatableApp != null) {
                        arrayList.add(updatableApp);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppVersion getSuggestedVersion$default(DbUpdateChecker dbUpdateChecker, String str, String str2, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return dbUpdateChecker.getSuggestedVersion(str, str2, list, z);
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final AppVersion getSuggestedVersion(String packageName, String str, List<String> list, boolean z) {
        long j;
        List<String> listOf;
        ArrayList versions;
        PackageInfo packageInfo;
        List<String> listOf2;
        List<String> listOf3;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (z) {
            AppPrefsDaoInt appPrefsDaoInt = this.appPrefsDao;
            listOf3 = CollectionsKt__CollectionsJVMKt.listOf(packageName);
            Long l = appPrefsDaoInt.getPreferredRepos(listOf3).get(packageName);
            if (l == null) {
                throw new IllegalStateException(("No preferred repo for " + packageName).toString());
            }
            j = l.longValue();
        } else {
            j = 0;
        }
        if (z) {
            VersionDaoInt versionDaoInt = this.versionDao;
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(packageName);
            List<Version> versions2 = versionDaoInt.getVersions(listOf2);
            ArrayList arrayList = new ArrayList();
            for (Object obj : versions2) {
                if (((Version) obj).getRepoId() == j) {
                    arrayList.add(obj);
                }
            }
            versions = arrayList;
        } else {
            VersionDaoInt versionDaoInt2 = this.versionDao;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(packageName);
            versions = versionDaoInt2.getVersions(listOf);
        }
        if (versions.isEmpty()) {
            return null;
        }
        try {
            packageInfo = this.packageManager.getPackageInfo(packageName, 64);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        Version version$default = getVersion$default(this, versions, packageName, packageInfo, str, list, false, 32, null);
        if (version$default == null) {
            return null;
        }
        return version$default.toAppVersion$database_release(this.versionDao.getVersionedStrings(version$default.getRepoId(), version$default.getPackageName(), version$default.getVersionId()));
    }

    static /* synthetic */ Version getVersion$default(DbUpdateChecker dbUpdateChecker, List list, String str, PackageInfo packageInfo, String str2, List list2, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        return dbUpdateChecker.getVersion(list, str, packageInfo, str2, list2, z);
    }

    private final Version getVersion(List<Version> list, final String str, PackageInfo packageInfo, String str2, List<String> list2, boolean z) {
        Function0 function0 = new Function0() { // from class: org.fdroid.database.DbUpdateChecker$getVersion$preferencesGetter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AppPrefs invoke() {
                AppPrefsDaoInt appPrefsDaoInt;
                appPrefsDaoInt = DbUpdateChecker.this.appPrefsDao;
                return appPrefsDaoInt.getAppPrefsOrNull(str);
            }
        };
        if (packageInfo == null) {
            return (Version) this.updateChecker.getSuggestedVersion(list, str2, list2, function0);
        }
        return (Version) this.updateChecker.getUpdate(list, packageInfo, list2, z, function0);
    }

    private final UpdatableApp getUpdatableApp(Version version, long j, boolean z) {
        List<VersionedString> versionedStrings = this.versionDao.getVersionedStrings(version.getRepoId(), version.getPackageName(), version.getVersionId());
        AppOverviewItem appOverviewItem = this.appDao.getAppOverviewItem(version.getRepoId(), version.getPackageName());
        if (appOverviewItem == null) {
            return null;
        }
        return new UpdatableApp(version.getRepoId(), version.getPackageName(), j, version.toAppVersion$database_release(versionedStrings), z, version.getHasKnownVulnerability(), appOverviewItem.getName(), appOverviewItem.getSummary(), appOverviewItem.getLocalizedIcon$database_release());
    }
}
