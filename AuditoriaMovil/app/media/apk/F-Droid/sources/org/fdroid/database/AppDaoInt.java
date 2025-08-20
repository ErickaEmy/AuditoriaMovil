package org.fdroid.database;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.content.pm.PackageInfoCompat;
import androidx.core.os.LocaleListCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Regex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.LocaleChooser;
import org.fdroid.database.AppDao;
import org.fdroid.database.AppDaoInt;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.IndexParser;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.MetadataV2;
import org.fdroid.index.v2.ReflectionDiffer;
import org.fdroid.index.v2.Screenshots;
/* compiled from: AppDao.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001JJ\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0005H'J\b\u0010\u0007\u001a\u00020\u0005H'J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'J(\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH'J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH'J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH'J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH'J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'J\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001a2\u0006\u0010\u000b\u001a\u00020\fH'J6\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020!H\u0016J6\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020!H\u0016J.\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020!H\u0016J$\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH'J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\u0017\u001a\u00020\fH'J$\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH'J\"\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH'J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001aH'J\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\t\u001a\u00020\nH'J\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\"\u001a\u00020\fH'J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001aH'J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\t\u001a\u00020\nH'J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\"\u001a\u00020\fH'J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001cH'J\u001a\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'J\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'J\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u001c0\u001a2\u0006\u0010+\u001a\u00020\u0005H'J$\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u001c0\u001a2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0005H'J\u001c\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u001c2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\fH'J\u0010\u00100\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH'J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010\u000b\u001a\u00020\fH'J(\u00102\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0017J\u0016\u00102\u001a\u00020\u00032\f\u00107\u001a\b\u0012\u0004\u0012\u00020.0\u001cH'J\u0010\u00102\u001a\u00020\u00032\u0006\u00108\u001a\u00020'H'J\u0016\u00109\u001a\u00020\u00032\f\u00107\u001a\b\u0012\u0004\u0012\u00020:0\u001cH'J*\u0010;\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u00105\u001a\u000206H\u0017J,\u0010<\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010\f2\b\u0010>\u001a\u0004\u0018\u00010\fH'J\u0010\u0010<\u001a\u00020\u00052\u0006\u00108\u001a\u00020'H'J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH'J\"\u0010@\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010\fH'J2\u0010B\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020.0\u001c2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J>\u00102\u001a\u00020\u0003*\u001c\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u001c\u0018\u00010Cj\u0004\u0018\u0001`E2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0003J8\u00102\u001a\u00020\u0003*\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020D\u0018\u00010Cj\u0004\u0018\u0001`F2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002JB\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0014\b\u0002\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020I0CH\u0002¨\u0006K"}, d2 = {"Lorg/fdroid/database/AppDaoInt;", "Lorg/fdroid/database/AppDao;", "clearAll", "", "countApps", "", "countLocalizedFileLists", "countLocalizedFiles", "deleteAppMetadata", "repoId", "", "packageName", "", "deleteLocalizedFile", BonjourPeer.TYPE, "locale", "deleteLocalizedFileList", "deleteLocalizedFileLists", "deleteLocalizedFiles", "diffAndUpdateLocalizedFileList", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "escapeQuery", "searchQuery", "getApp", "Lorg/fdroid/database/App;", "Landroidx/lifecycle/LiveData;", "getAppListItems", "", "Lorg/fdroid/database/AppListItem;", "packageManager", "Landroid/content/pm/PackageManager;", "sortOrder", "Lorg/fdroid/database/AppListSortOrder;", "category", "packageNames", "getAppListItemsByLastUpdated", "getAppListItemsByName", "getAppMetadata", "Lorg/fdroid/database/AppMetadata;", "getAppOverviewItem", "Lorg/fdroid/database/AppOverviewItem;", "getAppOverviewItems", "limit", "getInstalledAppListItems", "getLocalizedFiles", "Lorg/fdroid/database/LocalizedFile;", "getNumberOfAppsInCategory", "getNumberOfAppsInRepository", "getRepositoryIdsForApp", "insert", "app", "Lorg/fdroid/index/v2/MetadataV2;", "locales", "Landroidx/core/os/LocaleListCompat;", "localizedFiles", "appMetadata", "insertLocalizedFileLists", "Lorg/fdroid/database/LocalizedFileList;", "updateApp", "updateAppMetadata", "name", ErrorBundle.SUMMARY_ENTRY, "updateCompatibility", "updatePreferredSigner", "preferredSigner", "diffAndUpdate", "", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileListV2;", "Lorg/fdroid/index/v2/LocalizedFileV2;", "map", "installedPackages", "Landroid/content/pm/PackageInfo;", "AppListLiveData", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AppDaoInt extends AppDao {

    /* compiled from: AppDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppListSortOrder.values().length];
            try {
                iArr[AppListSortOrder.LAST_UPDATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppListSortOrder.NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    void clearAll();

    int countApps();

    int countLocalizedFileLists();

    int countLocalizedFiles();

    void deleteAppMetadata(long j, String str);

    void deleteLocalizedFile(long j, String str, String str2, String str3);

    void deleteLocalizedFileList(long j, String str, String str2, String str3);

    void deleteLocalizedFileLists(long j, String str);

    void deleteLocalizedFileLists(long j, String str, String str2);

    void deleteLocalizedFiles(long j, String str, String str2);

    @Override // org.fdroid.database.AppDao
    LiveData getApp(String str);

    @Override // org.fdroid.database.AppDao
    App getApp(long j, String str);

    LiveData getAppListItems(long j, String str);

    @Override // org.fdroid.database.AppDao
    LiveData getAppListItems(PackageManager packageManager, long j, String str, AppListSortOrder appListSortOrder);

    @Override // org.fdroid.database.AppDao
    LiveData getAppListItems(PackageManager packageManager, String str, String str2, AppListSortOrder appListSortOrder);

    @Override // org.fdroid.database.AppDao
    LiveData getAppListItems(PackageManager packageManager, String str, AppListSortOrder appListSortOrder);

    LiveData getAppListItems(String str);

    LiveData getAppListItems(String str, String str2);

    LiveData getAppListItems(List<String> list);

    LiveData getAppListItemsByLastUpdated();

    LiveData getAppListItemsByLastUpdated(long j);

    LiveData getAppListItemsByLastUpdated(String str);

    LiveData getAppListItemsByName();

    LiveData getAppListItemsByName(long j);

    LiveData getAppListItemsByName(String str);

    List<AppMetadata> getAppMetadata();

    AppMetadata getAppMetadata(long j, String str);

    AppOverviewItem getAppOverviewItem(long j, String str);

    @Override // org.fdroid.database.AppDao
    LiveData getAppOverviewItems(int i);

    @Override // org.fdroid.database.AppDao
    LiveData getAppOverviewItems(String str, int i);

    @Override // org.fdroid.database.AppDao
    LiveData getInstalledAppListItems(PackageManager packageManager);

    List<LocalizedFile> getLocalizedFiles(long j, String str);

    @Override // org.fdroid.database.AppDao
    int getNumberOfAppsInCategory(String str);

    @Override // org.fdroid.database.AppDao
    int getNumberOfAppsInRepository(long j);

    @Override // org.fdroid.database.AppDao
    List<Long> getRepositoryIdsForApp(String str);

    @Override // org.fdroid.database.AppDao
    void insert(long j, String str, MetadataV2 metadataV2, LocaleListCompat localeListCompat);

    void insert(List<LocalizedFile> list);

    void insert(AppMetadata appMetadata);

    void insertLocalizedFileLists(List<LocalizedFileList> list);

    void updateApp(long j, String str, JsonObject jsonObject, LocaleListCompat localeListCompat);

    int updateAppMetadata(AppMetadata appMetadata);

    void updateAppMetadata(long j, String str, String str2, String str3);

    @Override // org.fdroid.database.AppDao
    void updateCompatibility(long j);

    void updatePreferredSigner(long j, String str, String str2);

    /* compiled from: AppDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static void insert(AppDaoInt appDaoInt, long j, String packageName, MetadataV2 app, LocaleListCompat locales) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(locales, "locales");
            appDaoInt.insert(AppKt.toAppMetadata(app, j, packageName, false, locales));
            insert(appDaoInt, app.getIcon(), j, packageName, "icon");
            insert(appDaoInt, app.getFeatureGraphic(), j, packageName, "featureGraphic");
            insert(appDaoInt, app.getPromoGraphic(), j, packageName, "promoGraphic");
            insert(appDaoInt, app.getTvBanner(), j, packageName, "tvBanner");
            Screenshots screenshots = app.getScreenshots();
            if (screenshots != null) {
                insertLocalizedFileListV2(appDaoInt, screenshots.getPhone(), j, packageName, "phone");
                insertLocalizedFileListV2(appDaoInt, screenshots.getSevenInch(), j, packageName, "sevenInch");
                insertLocalizedFileListV2(appDaoInt, screenshots.getTenInch(), j, packageName, "tenInch");
                insertLocalizedFileListV2(appDaoInt, screenshots.getWear(), j, packageName, "wear");
                insertLocalizedFileListV2(appDaoInt, screenshots.getTv(), j, packageName, "tv");
            }
        }

        private static void insert(AppDaoInt appDaoInt, Map<String, FileV2> map, long j, String str, String str2) {
            List<LocalizedFile> localizedFile;
            if (map == null || (localizedFile = AppKt.toLocalizedFile(map, j, str, str2)) == null) {
                return;
            }
            appDaoInt.insert(localizedFile);
        }

        private static void insertLocalizedFileListV2(AppDaoInt appDaoInt, Map<String, ? extends List<FileV2>> map, long j, String str, String str2) {
            List<LocalizedFileList> localizedFileList;
            if (map == null || (localizedFileList = AppKt.toLocalizedFileList(map, j, str, str2)) == null) {
                return;
            }
            appDaoInt.insertLocalizedFileLists(localizedFileList);
        }

        public static void updateApp(AppDaoInt appDaoInt, long j, String packageName, JsonObject jsonObject, LocaleListCompat locales) {
            List<String> list;
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(locales, "locales");
            if (jsonObject == null) {
                appDaoInt.deleteAppMetadata(j, packageName);
                return;
            }
            AppMetadata appMetadata = appDaoInt.getAppMetadata(j, packageName);
            if (appMetadata == null) {
                Json json = IndexParser.getJson();
                KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(MetadataV2.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                AppDao.DefaultImpls.insert$default(appDaoInt, j, packageName, (MetadataV2) json.decodeFromJsonElement(serializer, jsonObject), null, 8, null);
                return;
            }
            list = AppDaoKt.DENY_LIST;
            for (String str : list) {
                if (jsonObject.containsKey((Object) str)) {
                    throw new SerializationException(str);
                }
            }
            AppMetadata appMetadata2 = (AppMetadata) ReflectionDiffer.INSTANCE.applyDiff(appMetadata, jsonObject);
            if (jsonObject.containsKey("name") || jsonObject.containsKey(ErrorBundle.SUMMARY_ENTRY)) {
                LocaleChooser localeChooser = LocaleChooser.INSTANCE;
                appMetadata2 = appMetadata2.copy((r51 & 1) != 0 ? appMetadata2.repoId : 0L, (r51 & 2) != 0 ? appMetadata2.packageName : null, (r51 & 4) != 0 ? appMetadata2.added : 0L, (r51 & 8) != 0 ? appMetadata2.lastUpdated : 0L, (r51 & 16) != 0 ? appMetadata2.name : null, (r51 & 32) != 0 ? appMetadata2.summary : null, (r51 & 64) != 0 ? appMetadata2.description : null, (r51 & 128) != 0 ? appMetadata2.localizedName : (String) localeChooser.getBestLocale(appMetadata2.getName(), locales), (r51 & 256) != 0 ? appMetadata2.localizedSummary : (String) localeChooser.getBestLocale(appMetadata2.getSummary(), locales), (r51 & 512) != 0 ? appMetadata2.webSite : null, (r51 & 1024) != 0 ? appMetadata2.changelog : null, (r51 & 2048) != 0 ? appMetadata2.license : null, (r51 & PKIFailureInfo.certConfirmed) != 0 ? appMetadata2.sourceCode : null, (r51 & 8192) != 0 ? appMetadata2.issueTracker : null, (r51 & 16384) != 0 ? appMetadata2.translation : null, (r51 & 32768) != 0 ? appMetadata2.preferredSigner : null, (r51 & PKIFailureInfo.notAuthorized) != 0 ? appMetadata2.video : null, (r51 & PKIFailureInfo.unsupportedVersion) != 0 ? appMetadata2.authorName : null, (r51 & PKIFailureInfo.transactionIdInUse) != 0 ? appMetadata2.authorEmail : null, (r51 & PKIFailureInfo.signerNotTrusted) != 0 ? appMetadata2.authorWebSite : null, (r51 & PKIFailureInfo.badCertTemplate) != 0 ? appMetadata2.authorPhone : null, (r51 & PKIFailureInfo.badSenderNonce) != 0 ? appMetadata2.donate : null, (r51 & 4194304) != 0 ? appMetadata2.liberapayID : null, (r51 & 8388608) != 0 ? appMetadata2.liberapay : null, (r51 & 16777216) != 0 ? appMetadata2.openCollective : null, (r51 & 33554432) != 0 ? appMetadata2.bitcoin : null, (r51 & 67108864) != 0 ? appMetadata2.litecoin : null, (r51 & 134217728) != 0 ? appMetadata2.flattrID : null, (r51 & 268435456) != 0 ? appMetadata2.categories : null, (r51 & PKIFailureInfo.duplicateCertReq) != 0 ? appMetadata2.isCompatible : false);
            }
            appDaoInt.updateAppMetadata(appMetadata2);
            List<LocalizedFile> localizedFiles = appDaoInt.getLocalizedFiles(j, packageName);
            diffAndUpdate(appDaoInt, localizedFiles, j, packageName, "icon", jsonObject);
            diffAndUpdate(appDaoInt, localizedFiles, j, packageName, "featureGraphic", jsonObject);
            diffAndUpdate(appDaoInt, localizedFiles, j, packageName, "promoGraphic", jsonObject);
            diffAndUpdate(appDaoInt, localizedFiles, j, packageName, "tvBanner", jsonObject);
            JsonElement jsonElement = (JsonElement) jsonObject.get("screenshots");
            if (jsonElement instanceof JsonNull) {
                appDaoInt.deleteLocalizedFileLists(j, packageName);
            } else if (jsonElement instanceof JsonObject) {
                JsonObject jsonObject2 = (JsonObject) jsonElement;
                diffAndUpdateLocalizedFileList(appDaoInt, j, packageName, "phone", jsonObject2);
                diffAndUpdateLocalizedFileList(appDaoInt, j, packageName, "sevenInch", jsonObject2);
                diffAndUpdateLocalizedFileList(appDaoInt, j, packageName, "tenInch", jsonObject2);
                diffAndUpdateLocalizedFileList(appDaoInt, j, packageName, "wear", jsonObject2);
                diffAndUpdateLocalizedFileList(appDaoInt, j, packageName, "tv", jsonObject2);
            }
        }

        private static void diffAndUpdate(final AppDaoInt appDaoInt, List<LocalizedFile> list, final long j, final String str, final String str2, JsonObject jsonObject) {
            List<String> list2;
            DbDiffUtils dbDiffUtils = DbDiffUtils.INSTANCE;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (Intrinsics.areEqual(((LocalizedFile) obj).getType(), str2)) {
                    arrayList.add(obj);
                }
            }
            AppDaoInt$diffAndUpdate$2 appDaoInt$diffAndUpdate$2 = new Function2() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdate$2
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(String locale, LocalizedFile item) {
                    Intrinsics.checkNotNullParameter(locale, "locale");
                    Intrinsics.checkNotNullParameter(item, "item");
                    return Boolean.valueOf(Intrinsics.areEqual(item.getLocale(), locale));
                }
            };
            Function1 function1 = new Function1() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdate$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final LocalizedFile invoke(String locale) {
                    Intrinsics.checkNotNullParameter(locale, "locale");
                    return new LocalizedFile(j, str, str2, locale, "", null, null, null, BERTags.FLAGS, null);
                }
            };
            Function0 function0 = new Function0() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdate$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2344invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2344invoke() {
                    AppDaoInt.this.deleteLocalizedFiles(j, str, str2);
                }
            };
            Function1 function12 = new Function1() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdate$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(String locale) {
                    Intrinsics.checkNotNullParameter(locale, "locale");
                    AppDaoInt.this.deleteLocalizedFile(j, str, str2, locale);
                }
            };
            Function1 function13 = new Function1() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdate$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((List) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(List list3) {
                    Intrinsics.checkNotNullParameter(list3, "list");
                    AppDaoInt.this.insert(list3);
                }
            };
            AppDaoInt$diffAndUpdate$7 appDaoInt$diffAndUpdate$7 = new Function1() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdate$7
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LocalizedFile it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getName().length() > 0);
                }
            };
            list2 = AppDaoKt.DENY_FILE_LIST;
            dbDiffUtils.diffAndUpdateTable(jsonObject, str2, arrayList, appDaoInt$diffAndUpdate$2, function1, function0, function12, function13, appDaoInt$diffAndUpdate$7, list2);
        }

        private static void diffAndUpdateLocalizedFileList(final AppDaoInt appDaoInt, final long j, final String str, final String str2, JsonObject jsonObject) {
            DbDiffUtils.INSTANCE.diffAndUpdateListTable(jsonObject, str2, new Function2() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdateLocalizedFileList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final List invoke(String locale, JsonArray jsonArray) {
                    int collectionSizeOrDefault;
                    Intrinsics.checkNotNullParameter(locale, "locale");
                    Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                    Json json = IndexParser.getJson();
                    KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(FileV2.class))));
                    Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    Iterable<FileV2> iterable = (Iterable) json.decodeFromJsonElement(serializer, jsonArray);
                    long j2 = j;
                    String str3 = str;
                    String str4 = str2;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (FileV2 fileV2 : iterable) {
                        arrayList.add(AppKt.toLocalizedFileList(fileV2, j2, str3, str4, locale));
                    }
                    return arrayList;
                }
            }, new Function0() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdateLocalizedFileList$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2345invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2345invoke() {
                    AppDaoInt.this.deleteLocalizedFileLists(j, str, str2);
                }
            }, new Function1() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdateLocalizedFileList$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(String locale) {
                    Intrinsics.checkNotNullParameter(locale, "locale");
                    AppDaoInt.this.deleteLocalizedFileList(j, str, str2, locale);
                }
            }, new Function2() { // from class: org.fdroid.database.AppDaoInt$diffAndUpdateLocalizedFileList$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (List) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(String str3, List fileLists) {
                    Intrinsics.checkNotNullParameter(str3, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(fileLists, "fileLists");
                    AppDaoInt.this.insertLocalizedFileLists(fileLists);
                }
            });
        }

        public static LiveData getAppListItems(AppDaoInt appDaoInt, PackageManager packageManager, String str, AppListSortOrder sortOrder) {
            Intrinsics.checkNotNullParameter(packageManager, "packageManager");
            Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
            if (str == null || str.length() == 0) {
                int i = WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        return map$default(appDaoInt, appDaoInt.getAppListItemsByName(), packageManager, null, 2, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return map$default(appDaoInt, appDaoInt.getAppListItemsByLastUpdated(), packageManager, null, 2, null);
            }
            return map$default(appDaoInt, appDaoInt.getAppListItems(escapeQuery(appDaoInt, str)), packageManager, null, 2, null);
        }

        public static LiveData getAppListItems(AppDaoInt appDaoInt, PackageManager packageManager, String category, String str, AppListSortOrder sortOrder) {
            Intrinsics.checkNotNullParameter(packageManager, "packageManager");
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
            if (str == null || str.length() == 0) {
                int i = WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        return map$default(appDaoInt, appDaoInt.getAppListItemsByName(category), packageManager, null, 2, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return map$default(appDaoInt, appDaoInt.getAppListItemsByLastUpdated(category), packageManager, null, 2, null);
            }
            return map$default(appDaoInt, appDaoInt.getAppListItems(category, escapeQuery(appDaoInt, str)), packageManager, null, 2, null);
        }

        public static LiveData getAppListItems(AppDaoInt appDaoInt, PackageManager packageManager, long j, String str, AppListSortOrder sortOrder) {
            Intrinsics.checkNotNullParameter(packageManager, "packageManager");
            Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
            if (str == null || str.length() == 0) {
                int i = WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        return map$default(appDaoInt, appDaoInt.getAppListItemsByName(j), packageManager, null, 2, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return map$default(appDaoInt, appDaoInt.getAppListItemsByLastUpdated(j), packageManager, null, 2, null);
            }
            return map$default(appDaoInt, appDaoInt.getAppListItems(j, escapeQuery(appDaoInt, str)), packageManager, null, 2, null);
        }

        private static String escapeQuery(AppDaoInt appDaoInt, String str) {
            String replace = Regex.Companion.fromLiteral("\"").replace(str, "\"\"");
            return "\"*" + replace + "*\"";
        }

        public static /* synthetic */ LiveData map$default(AppDaoInt appDaoInt, LiveData liveData, PackageManager packageManager, Map map, int i, Object obj) {
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            if (obj == null) {
                if ((i & 2) != 0) {
                    List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
                    Intrinsics.checkNotNullExpressionValue(installedPackages, "getInstalledPackages(...)");
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(installedPackages, 10);
                    mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                    for (Object obj2 : installedPackages) {
                        String packageName = ((PackageInfo) obj2).packageName;
                        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                        linkedHashMap.put(packageName, obj2);
                    }
                    map = linkedHashMap;
                }
                return map(appDaoInt, liveData, packageManager, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: map");
        }

        private static LiveData map(AppDaoInt appDaoInt, LiveData liveData, PackageManager packageManager, final Map<String, ? extends PackageInfo> map) {
            return Transformations.map(liveData, new Function1() { // from class: org.fdroid.database.AppDaoInt$map$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List invoke(List items) {
                    int collectionSizeOrDefault;
                    Intrinsics.checkNotNullParameter(items, "items");
                    Map map2 = map;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = items.iterator();
                    while (it.hasNext()) {
                        AppListItem appListItem = (AppListItem) it.next();
                        PackageInfo packageInfo = (PackageInfo) map2.get(appListItem.getPackageName());
                        if (packageInfo != null) {
                            appListItem = appListItem.copy((r28 & 1) != 0 ? appListItem.repoId : 0L, (r28 & 2) != 0 ? appListItem.packageName : null, (r28 & 4) != 0 ? appListItem.name : null, (r28 & 8) != 0 ? appListItem.summary : null, (r28 & 16) != 0 ? appListItem.lastUpdated : 0L, (r28 & 32) != 0 ? appListItem.antiFeatures : null, (r28 & 64) != 0 ? appListItem.localizedIcon : null, (r28 & 128) != 0 ? appListItem.isCompatible : false, (r28 & 256) != 0 ? appListItem.preferredSigner : null, (r28 & 512) != 0 ? appListItem.installedVersionName : packageInfo.versionName, (r28 & 1024) != 0 ? appListItem.installedVersionCode : Long.valueOf(PackageInfoCompat.getLongVersionCode(packageInfo)));
                        }
                        arrayList.add(appListItem);
                    }
                    return arrayList;
                }
            });
        }

        public static LiveData getInstalledAppListItems(final AppDaoInt appDaoInt, PackageManager packageManager) {
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            List<String> list;
            Intrinsics.checkNotNullParameter(packageManager, "packageManager");
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            Intrinsics.checkNotNullExpressionValue(installedPackages, "getInstalledPackages(...)");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(installedPackages, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : installedPackages) {
                linkedHashMap.put(((PackageInfo) obj).packageName, obj);
            }
            list = CollectionsKt___CollectionsKt.toList(linkedHashMap.keySet());
            if (list.size() <= 999) {
                return map(appDaoInt, appDaoInt.getAppListItems(list), packageManager, linkedHashMap);
            }
            final AppListLiveData appListLiveData = new AppListLiveData();
            CollectionsKt___CollectionsKt.chunked(list, RoomDatabase.MAX_BIND_PARAMETER_CNT, new Function1() { // from class: org.fdroid.database.AppDaoInt$getInstalledAppListItems$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((List) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(List it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AppDaoInt.AppListLiveData.this.addSource(appDaoInt.getAppListItems(it));
                }
            });
            return map(appDaoInt, appListLiveData, packageManager, linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppDao.kt */
    /* loaded from: classes2.dex */
    public static final class AppListLiveData extends MediatorLiveData {
        private final ArrayList list = new ArrayList();

        public final void addSource(LiveData liveData) {
            Intrinsics.checkNotNullParameter(liveData, "liveData");
            this.list.add(liveData);
            addSource(liveData, new AppDaoKt$sam$androidx_lifecycle_Observer$0(new AppDaoInt$AppListLiveData$addSource$1(this)));
        }
    }
}
