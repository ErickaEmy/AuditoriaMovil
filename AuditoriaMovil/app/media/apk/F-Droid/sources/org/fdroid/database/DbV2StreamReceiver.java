package org.fdroid.database;

import androidx.core.os.LocaleListCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.SerializationException;
import org.fdroid.CompatibilityChecker;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.IndexV2StreamReceiver;
import org.fdroid.index.v2.PackageV2;
import org.fdroid.index.v2.PackageVersionV2;
import org.fdroid.index.v2.RepoV2;
/* compiled from: DbV2StreamReceiver.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lorg/fdroid/database/DbV2StreamReceiver;", "Lorg/fdroid/index/v2/IndexV2StreamReceiver;", "db", "Lorg/fdroid/database/FDroidDatabaseInt;", "repoId", "", "compatibilityChecker", "Lorg/fdroid/CompatibilityChecker;", "(Lorg/fdroid/database/FDroidDatabaseInt;JLorg/fdroid/CompatibilityChecker;)V", "clearedRepoData", "", "locales", "Landroidx/core/os/LocaleListCompat;", "nonNullFileV2", "Lkotlin/Function1;", "Lorg/fdroid/index/v2/FileV2;", "", "clearRepoDataIfNeeded", "onStreamEnded", "receive", "packageName", "", "p", "Lorg/fdroid/index/v2/PackageV2;", "repo", "Lorg/fdroid/index/v2/RepoV2;", "version", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DbV2StreamReceiver implements IndexV2StreamReceiver {
    private boolean clearedRepoData;
    private final CompatibilityChecker compatibilityChecker;
    private final FDroidDatabaseInt db;
    private final LocaleListCompat locales;
    private final Function1 nonNullFileV2;
    private final long repoId;

    public DbV2StreamReceiver(FDroidDatabaseInt db, long j, CompatibilityChecker compatibilityChecker) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(compatibilityChecker, "compatibilityChecker");
        this.db = db;
        this.repoId = j;
        this.compatibilityChecker = compatibilityChecker;
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        this.locales = localeListCompat;
        this.nonNullFileV2 = new Function1() { // from class: org.fdroid.database.DbV2StreamReceiver$nonNullFileV2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FileV2) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FileV2 fileV2) {
                boolean startsWith$default;
                if (fileV2 != null) {
                    if (fileV2.getSha256() == null) {
                        String name = fileV2.getName();
                        throw new SerializationException(name + " has no sha256");
                    } else if (fileV2.getSize() == null) {
                        String name2 = fileV2.getName();
                        throw new SerializationException(name2 + " has no size");
                    } else {
                        startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) fileV2.getName(), '/', false, 2, (Object) null);
                        if (startsWith$default) {
                            return;
                        }
                        String name3 = fileV2.getName();
                        throw new SerializationException(name3 + " does not start with /");
                    }
                }
            }
        };
    }

    @Override // org.fdroid.index.v2.IndexV2StreamReceiver
    public synchronized void receive(RepoV2 repo, long j) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        repo.walkFiles(this.nonNullFileV2);
        clearRepoDataIfNeeded();
        this.db.getRepositoryDao().update(this.repoId, repo, j, IndexFormatVersion.TWO);
    }

    @Override // org.fdroid.index.v2.IndexV2StreamReceiver
    public synchronized void receive(String packageName, PackageV2 p) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(p, "p");
        p.walkFiles(this.nonNullFileV2);
        clearRepoDataIfNeeded();
        this.db.getAppDao().insert(this.repoId, packageName, p.getMetadata(), this.locales);
        this.db.getVersionDao().insert(this.repoId, packageName, p.getVersions(), new Function1() { // from class: org.fdroid.database.DbV2StreamReceiver$receive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PackageVersionV2 it) {
                CompatibilityChecker compatibilityChecker;
                Intrinsics.checkNotNullParameter(it, "it");
                compatibilityChecker = DbV2StreamReceiver.this.compatibilityChecker;
                return Boolean.valueOf(compatibilityChecker.isCompatible(it.getManifest()));
            }
        });
    }

    @Override // org.fdroid.index.v2.IndexV2StreamReceiver
    public synchronized void onStreamEnded() {
        this.db.afterUpdatingRepo(this.repoId);
    }

    private final void clearRepoDataIfNeeded() {
        if (this.clearedRepoData) {
            return;
        }
        this.db.getRepositoryDao().clear(this.repoId);
        this.clearedRepoData = true;
    }
}
