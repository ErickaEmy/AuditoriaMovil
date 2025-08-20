package org.fdroid.database;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.v2.MetadataV2;
/* compiled from: AppDao.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u0006\u001a\u00020\u0007H&J6\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J6\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J.\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001e\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n0\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&J&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n0\b2\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006!"}, d2 = {"Lorg/fdroid/database/AppDao;", "", "getApp", "Lorg/fdroid/database/App;", "repoId", "", "packageName", "", "Landroidx/lifecycle/LiveData;", "getAppListItems", "", "Lorg/fdroid/database/AppListItem;", "packageManager", "Landroid/content/pm/PackageManager;", "searchQuery", "sortOrder", "Lorg/fdroid/database/AppListSortOrder;", "category", "getAppOverviewItems", "Lorg/fdroid/database/AppOverviewItem;", "limit", "", "getInstalledAppListItems", "getNumberOfAppsInCategory", "getNumberOfAppsInRepository", "getRepositoryIdsForApp", "insert", "", "app", "Lorg/fdroid/index/v2/MetadataV2;", "locales", "Landroidx/core/os/LocaleListCompat;", "updateCompatibility", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AppDao {
    LiveData getApp(String str);

    App getApp(long j, String str);

    LiveData getAppListItems(PackageManager packageManager, long j, String str, AppListSortOrder appListSortOrder);

    LiveData getAppListItems(PackageManager packageManager, String str, String str2, AppListSortOrder appListSortOrder);

    LiveData getAppListItems(PackageManager packageManager, String str, AppListSortOrder appListSortOrder);

    LiveData getAppOverviewItems(int i);

    LiveData getAppOverviewItems(String str, int i);

    LiveData getInstalledAppListItems(PackageManager packageManager);

    int getNumberOfAppsInCategory(String str);

    int getNumberOfAppsInRepository(long j);

    List<Long> getRepositoryIdsForApp(String str);

    void insert(long j, String str, MetadataV2 metadataV2, LocaleListCompat localeListCompat);

    void updateCompatibility(long j);

    /* compiled from: AppDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void insert$default(AppDao appDao, long j, String str, MetadataV2 metadataV2, LocaleListCompat localeListCompat, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insert");
            }
            if ((i & 8) != 0) {
                localeListCompat = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                Intrinsics.checkNotNullExpressionValue(localeListCompat, "getLocales(...)");
            }
            appDao.insert(j, str, metadataV2, localeListCompat);
        }

        public static /* synthetic */ LiveData getAppOverviewItems$default(AppDao appDao, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 200;
                }
                return appDao.getAppOverviewItems(i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAppOverviewItems");
        }

        public static /* synthetic */ LiveData getAppOverviewItems$default(AppDao appDao, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 50;
                }
                return appDao.getAppOverviewItems(str, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAppOverviewItems");
        }
    }
}
