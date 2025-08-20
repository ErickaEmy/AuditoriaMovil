package org.fdroid.database;

import androidx.core.os.LocaleListCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;
import org.fdroid.CompatibilityChecker;
import org.fdroid.index.v2.IndexV2DiffStreamReceiver;
import org.fdroid.index.v2.PackageManifest;
/* compiled from: DbV2DiffStreamReceiver.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J(\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lorg/fdroid/database/DbV2DiffStreamReceiver;", "Lorg/fdroid/index/v2/IndexV2DiffStreamReceiver;", "db", "Lorg/fdroid/database/FDroidDatabaseInt;", "repoId", "", "compatibilityChecker", "Lorg/fdroid/CompatibilityChecker;", "(Lorg/fdroid/database/FDroidDatabaseInt;JLorg/fdroid/CompatibilityChecker;)V", "locales", "Landroidx/core/os/LocaleListCompat;", "onStreamEnded", "", "receivePackageMetadataDiff", "packageName", "", "packageJsonObject", "Lkotlinx/serialization/json/JsonObject;", "receiveRepoDiff", "version", "repoJsonObject", "receiveVersionsDiff", "versionsDiffMap", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DbV2DiffStreamReceiver implements IndexV2DiffStreamReceiver {
    private final CompatibilityChecker compatibilityChecker;
    private final FDroidDatabaseInt db;
    private final LocaleListCompat locales;
    private final long repoId;

    public DbV2DiffStreamReceiver(FDroidDatabaseInt db, long j, CompatibilityChecker compatibilityChecker) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(compatibilityChecker, "compatibilityChecker");
        this.db = db;
        this.repoId = j;
        this.compatibilityChecker = compatibilityChecker;
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        this.locales = localeListCompat;
    }

    @Override // org.fdroid.index.v2.IndexV2DiffStreamReceiver
    public void receiveRepoDiff(long j, JsonObject repoJsonObject) {
        Intrinsics.checkNotNullParameter(repoJsonObject, "repoJsonObject");
        this.db.getRepositoryDao().updateRepository(this.repoId, j, repoJsonObject);
    }

    @Override // org.fdroid.index.v2.IndexV2DiffStreamReceiver
    public void receivePackageMetadataDiff(String packageName, JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.db.getAppDao().updateApp(this.repoId, packageName, jsonObject, this.locales);
    }

    @Override // org.fdroid.index.v2.IndexV2DiffStreamReceiver
    public void receiveVersionsDiff(String packageName, Map<String, JsonObject> map) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.db.getVersionDao().update(this.repoId, packageName, map, new Function1() { // from class: org.fdroid.database.DbV2DiffStreamReceiver$receiveVersionsDiff$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PackageManifest it) {
                CompatibilityChecker compatibilityChecker;
                Intrinsics.checkNotNullParameter(it, "it");
                compatibilityChecker = DbV2DiffStreamReceiver.this.compatibilityChecker;
                return Boolean.valueOf(compatibilityChecker.isCompatible(it));
            }
        });
    }

    @Override // org.fdroid.index.v2.IndexV2DiffStreamReceiver
    public synchronized void onStreamEnded() {
        this.db.afterUpdatingRepo(this.repoId);
    }
}
