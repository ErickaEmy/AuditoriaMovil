package org.fdroid.database;

import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FDroidDatabase.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J!\u0010\u000f\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0013H&¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lorg/fdroid/database/FDroidDatabase;", "", "afterLocalesChanged", "", "locales", "Landroidx/core/os/LocaleListCompat;", "clearAllAppData", "getAppDao", "Lorg/fdroid/database/AppDao;", "getAppPrefsDao", "Lorg/fdroid/database/AppPrefsDao;", "getRepositoryDao", "Lorg/fdroid/database/RepositoryDao;", "getVersionDao", "Lorg/fdroid/database/VersionDao;", "runInTransaction", "body", "Ljava/lang/Runnable;", "V", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FDroidDatabase {
    void afterLocalesChanged(LocaleListCompat localeListCompat);

    void clearAllAppData();

    AppDao getAppDao();

    AppPrefsDao getAppPrefsDao();

    RepositoryDao getRepositoryDao();

    VersionDao getVersionDao();

    <V> V runInTransaction(Callable<V> callable);

    void runInTransaction(Runnable runnable);

    /* compiled from: FDroidDatabase.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void afterLocalesChanged$default(FDroidDatabase fDroidDatabase, LocaleListCompat localeListCompat, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: afterLocalesChanged");
            }
            if ((i & 1) != 0) {
                localeListCompat = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                Intrinsics.checkNotNullExpressionValue(localeListCompat, "getLocales(...)");
            }
            fDroidDatabase.afterLocalesChanged(localeListCompat);
        }
    }
}
