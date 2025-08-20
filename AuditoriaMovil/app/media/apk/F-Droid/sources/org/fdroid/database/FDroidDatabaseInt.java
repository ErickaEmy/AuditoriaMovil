package org.fdroid.database;

import androidx.core.os.LocaleListCompat;
import androidx.room.RoomDatabase;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.LocaleChooser;
/* compiled from: FDroidDatabase.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, d2 = {"Lorg/fdroid/database/FDroidDatabaseInt;", "Landroidx/room/RoomDatabase;", "Lorg/fdroid/database/FDroidDatabase;", "Ljava/io/Closeable;", "()V", "afterLocalesChanged", "", "locales", "Landroidx/core/os/LocaleListCompat;", "afterUpdatingRepo", "repoId", "", "clearAllAppData", "getAppDao", "Lorg/fdroid/database/AppDaoInt;", "getAppPrefsDao", "Lorg/fdroid/database/AppPrefsDaoInt;", "getRepositoryDao", "Lorg/fdroid/database/RepositoryDaoInt;", "getVersionDao", "Lorg/fdroid/database/VersionDaoInt;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FDroidDatabaseInt extends RoomDatabase implements FDroidDatabase, Closeable {
    @Override // org.fdroid.database.FDroidDatabase
    public abstract AppDaoInt getAppDao();

    @Override // org.fdroid.database.FDroidDatabase
    public abstract AppPrefsDaoInt getAppPrefsDao();

    @Override // org.fdroid.database.FDroidDatabase
    public abstract RepositoryDaoInt getRepositoryDao();

    @Override // org.fdroid.database.FDroidDatabase
    public abstract VersionDaoInt getVersionDao();

    @Override // org.fdroid.database.FDroidDatabase
    public void afterLocalesChanged(final LocaleListCompat locales) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        final AppDaoInt appDao = getAppDao();
        runInTransaction(new Runnable() { // from class: org.fdroid.database.FDroidDatabaseInt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FDroidDatabaseInt.afterLocalesChanged$lambda$1(AppDaoInt.this, locales);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void afterLocalesChanged$lambda$1(AppDaoInt appDao, LocaleListCompat locales) {
        Intrinsics.checkNotNullParameter(appDao, "$appDao");
        Intrinsics.checkNotNullParameter(locales, "$locales");
        for (AppMetadata appMetadata : appDao.getAppMetadata()) {
            long repoId = appMetadata.getRepoId();
            String packageName = appMetadata.getPackageName();
            LocaleChooser localeChooser = LocaleChooser.INSTANCE;
            appDao.updateAppMetadata(repoId, packageName, (String) localeChooser.getBestLocale(appMetadata.getName(), locales), (String) localeChooser.getBestLocale(appMetadata.getSummary(), locales));
        }
    }

    public final void afterUpdatingRepo(long j) {
        getAppDao().updateCompatibility(j);
    }

    @Override // org.fdroid.database.FDroidDatabase
    public void clearAllAppData() {
        runInTransaction(new Runnable() { // from class: org.fdroid.database.FDroidDatabaseInt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FDroidDatabaseInt.clearAllAppData$lambda$2(FDroidDatabaseInt.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearAllAppData$lambda$2(FDroidDatabaseInt this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAppDao().clearAll();
        this$0.getRepositoryDao().resetTimestamps();
        this$0.getRepositoryDao().resetETags();
    }
}
