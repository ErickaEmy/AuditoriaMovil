package org.fdroid.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.room.RoomDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AppPrefsDao.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0016J\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H'¨\u0006\u0012"}, d2 = {"Lorg/fdroid/database/AppPrefsDaoInt;", "Lorg/fdroid/database/AppPrefsDao;", "getAppPrefs", "Landroidx/lifecycle/LiveData;", "Lorg/fdroid/database/AppPrefs;", "packageName", "", "getAppPrefsOrNull", "getLiveAppPrefs", "getPreferredRepos", "", "", "packageNames", "", "getPreferredReposInternal", "update", "", "appPrefs", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AppPrefsDaoInt extends AppPrefsDao {
    @Override // org.fdroid.database.AppPrefsDao
    LiveData getAppPrefs(String str);

    AppPrefs getAppPrefsOrNull(String str);

    LiveData getLiveAppPrefs(String str);

    Map<String, Long> getPreferredRepos(List<String> list);

    Map<String, Long> getPreferredReposInternal(List<String> list);

    @Override // org.fdroid.database.AppPrefsDao
    void update(AppPrefs appPrefs);

    /* compiled from: AppPrefsDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static LiveData getAppPrefs(AppPrefsDaoInt appPrefsDaoInt, final String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return Transformations.map(Transformations.distinctUntilChanged(appPrefsDaoInt.getLiveAppPrefs(packageName)), new Function1() { // from class: org.fdroid.database.AppPrefsDaoInt$getAppPrefs$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AppPrefs invoke(AppPrefs appPrefs) {
                    return appPrefs == null ? new AppPrefs(packageName, 0L, null, null, 14, null) : appPrefs;
                }
            });
        }

        public static Map<String, Long> getPreferredRepos(AppPrefsDaoInt appPrefsDaoInt, List<String> packageNames) {
            List<List<String>> chunked;
            Intrinsics.checkNotNullParameter(packageNames, "packageNames");
            if (packageNames.size() <= 999) {
                return appPrefsDaoInt.getPreferredReposInternal(packageNames);
            }
            HashMap hashMap = new HashMap(packageNames.size());
            chunked = CollectionsKt___CollectionsKt.chunked(packageNames, RoomDatabase.MAX_BIND_PARAMETER_CNT);
            for (List<String> list : chunked) {
                hashMap.putAll(appPrefsDaoInt.getPreferredReposInternal(list));
            }
            return hashMap;
        }
    }
}
