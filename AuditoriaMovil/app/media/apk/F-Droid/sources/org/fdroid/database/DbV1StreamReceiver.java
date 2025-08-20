package org.fdroid.database;

import androidx.core.os.LocaleListCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.CompatibilityChecker;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.v1.IndexV1StreamReceiver;
import org.fdroid.index.v2.AntiFeatureV2;
import org.fdroid.index.v2.CategoryV2;
import org.fdroid.index.v2.MetadataV2;
import org.fdroid.index.v2.PackageVersionV2;
import org.fdroid.index.v2.ReleaseChannelV2;
import org.fdroid.index.v2.RepoV2;
/* compiled from: DbV1StreamReceiver.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0016JD\u0010\u0019\u001a\u00020\f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u00102\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001d0\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f0\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lorg/fdroid/database/DbV1StreamReceiver;", "Lorg/fdroid/index/v1/IndexV1StreamReceiver;", "db", "Lorg/fdroid/database/FDroidDatabaseInt;", "repoId", "", "compatibilityChecker", "Lorg/fdroid/CompatibilityChecker;", "(Lorg/fdroid/database/FDroidDatabaseInt;JLorg/fdroid/CompatibilityChecker;)V", "locales", "Landroidx/core/os/LocaleListCompat;", "receive", "", "packageName", "", "v", "", "Lorg/fdroid/index/v2/PackageVersionV2;", "m", "Lorg/fdroid/index/v2/MetadataV2;", "repo", "Lorg/fdroid/index/v2/RepoV2;", "version", "updateAppMetadata", "preferredSigner", "updateRepo", "antiFeatures", "Lorg/fdroid/index/v2/AntiFeatureV2;", "categories", "Lorg/fdroid/index/v2/CategoryV2;", "releaseChannels", "Lorg/fdroid/index/v2/ReleaseChannelV2;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DbV1StreamReceiver implements IndexV1StreamReceiver {
    private final CompatibilityChecker compatibilityChecker;
    private final FDroidDatabaseInt db;
    private final LocaleListCompat locales;
    private final long repoId;

    public DbV1StreamReceiver(FDroidDatabaseInt db, long j, CompatibilityChecker compatibilityChecker) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(compatibilityChecker, "compatibilityChecker");
        this.db = db;
        this.repoId = j;
        this.compatibilityChecker = compatibilityChecker;
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        this.locales = localeListCompat;
    }

    @Override // org.fdroid.index.v1.IndexV1StreamReceiver
    public void receive(RepoV2 repo, long j) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.db.getRepositoryDao().clear(this.repoId);
        this.db.getRepositoryDao().update(this.repoId, repo, j, IndexFormatVersion.ONE);
    }

    @Override // org.fdroid.index.v1.IndexV1StreamReceiver
    public void receive(String packageName, MetadataV2 m) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(m, "m");
        this.db.getAppDao().insert(this.repoId, packageName, m, this.locales);
    }

    @Override // org.fdroid.index.v1.IndexV1StreamReceiver
    public void receive(String packageName, Map<String, PackageVersionV2> v) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(v, "v");
        this.db.getVersionDao().insert(this.repoId, packageName, v, new Function1() { // from class: org.fdroid.database.DbV1StreamReceiver$receive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PackageVersionV2 it) {
                CompatibilityChecker compatibilityChecker;
                Intrinsics.checkNotNullParameter(it, "it");
                compatibilityChecker = DbV1StreamReceiver.this.compatibilityChecker;
                return Boolean.valueOf(compatibilityChecker.isCompatible(it.getManifest()));
            }
        });
    }

    @Override // org.fdroid.index.v1.IndexV1StreamReceiver
    public void updateRepo(Map<String, AntiFeatureV2> antiFeatures, Map<String, CategoryV2> categories, Map<String, ReleaseChannelV2> releaseChannels) {
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        RepositoryDaoInt repositoryDao = this.db.getRepositoryDao();
        repositoryDao.insertAntiFeatures(RepositoryKt.toRepoAntiFeatures(antiFeatures, this.repoId));
        repositoryDao.insertCategories(RepositoryKt.toRepoCategories(categories, this.repoId));
        repositoryDao.insertReleaseChannels(RepositoryKt.toRepoReleaseChannel(releaseChannels, this.repoId));
        this.db.afterUpdatingRepo(this.repoId);
    }

    @Override // org.fdroid.index.v1.IndexV1StreamReceiver
    public void updateAppMetadata(String packageName, String str) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.db.getAppDao().updatePreferredSigner(this.repoId, packageName, str);
    }
}
