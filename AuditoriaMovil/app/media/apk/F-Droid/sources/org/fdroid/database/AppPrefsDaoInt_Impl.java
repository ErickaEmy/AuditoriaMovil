package org.fdroid.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.fdroid.database.AppPrefsDaoInt;
/* loaded from: classes2.dex */
public final class AppPrefsDaoInt_Impl implements AppPrefsDaoInt {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfAppPrefs;

    public AppPrefsDaoInt_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfAppPrefs = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.AppPrefsDaoInt_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `AppPrefs` (`packageName`,`ignoreVersionCodeUpdate`,`preferredRepoId`,`appPrefReleaseChannels`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AppPrefs appPrefs) {
                if (appPrefs.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, appPrefs.getPackageName());
                }
                supportSQLiteStatement.bindLong(2, appPrefs.getIgnoreVersionCodeUpdate());
                if (appPrefs.getPreferredRepoId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, appPrefs.getPreferredRepoId().longValue());
                }
                String listStringToString = Converters.INSTANCE.listStringToString(appPrefs.getAppPrefReleaseChannels$database_release());
                if (listStringToString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, listStringToString);
                }
            }
        };
    }

    @Override // org.fdroid.database.AppPrefsDaoInt, org.fdroid.database.AppPrefsDao
    public void update(AppPrefs appPrefs) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAppPrefs.insert(appPrefs);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppPrefsDaoInt
    public LiveData getLiveAppPrefs(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AppPrefs WHERE packageName = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{AppPrefs.TABLE}, false, new Callable() { // from class: org.fdroid.database.AppPrefsDaoInt_Impl.2
            @Override // java.util.concurrent.Callable
            public AppPrefs call() {
                AppPrefs appPrefs = null;
                String string = null;
                Cursor query = DBUtil.query(AppPrefsDaoInt_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "packageName");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "ignoreVersionCodeUpdate");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "preferredRepoId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "appPrefReleaseChannels");
                    if (query.moveToFirst()) {
                        String string2 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        long j = query.getLong(columnIndexOrThrow2);
                        Long valueOf = query.isNull(columnIndexOrThrow3) ? null : Long.valueOf(query.getLong(columnIndexOrThrow3));
                        if (!query.isNull(columnIndexOrThrow4)) {
                            string = query.getString(columnIndexOrThrow4);
                        }
                        appPrefs = new AppPrefs(string2, j, valueOf, Converters.INSTANCE.fromStringToListString(string));
                    }
                    return appPrefs;
                } finally {
                    query.close();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppPrefsDaoInt
    public AppPrefs getAppPrefsOrNull(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AppPrefs WHERE packageName = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        AppPrefs appPrefs = null;
        String string = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "packageName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "ignoreVersionCodeUpdate");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "preferredRepoId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "appPrefReleaseChannels");
            if (query.moveToFirst()) {
                String string2 = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                long j = query.getLong(columnIndexOrThrow2);
                Long valueOf = query.isNull(columnIndexOrThrow3) ? null : Long.valueOf(query.getLong(columnIndexOrThrow3));
                if (!query.isNull(columnIndexOrThrow4)) {
                    string = query.getString(columnIndexOrThrow4);
                }
                appPrefs = new AppPrefs(string2, j, valueOf, Converters.INSTANCE.fromStringToListString(string));
            }
            return appPrefs;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.AppPrefsDaoInt
    public Map<String, Long> getPreferredReposInternal(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT packageName, preferredRepoId FROM PreferredRepo ");
        newStringBuilder.append("\n");
        newStringBuilder.append("             WHERE packageName IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "packageName");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "preferredRepoId");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (query.moveToNext()) {
                String string = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    linkedHashMap.put(string, null);
                } else {
                    Long valueOf = query.isNull(columnIndexOrThrow2) ? null : Long.valueOf(query.getLong(columnIndexOrThrow2));
                    if (!linkedHashMap.containsKey(string)) {
                        linkedHashMap.put(string, valueOf);
                    }
                }
            }
            query.close();
            acquire.release();
            return linkedHashMap;
        } catch (Throwable th) {
            query.close();
            acquire.release();
            throw th;
        }
    }

    @Override // org.fdroid.database.AppPrefsDaoInt, org.fdroid.database.AppPrefsDao
    public LiveData getAppPrefs(String str) {
        return AppPrefsDaoInt.DefaultImpls.getAppPrefs(this, str);
    }

    @Override // org.fdroid.database.AppPrefsDaoInt
    public Map<String, Long> getPreferredRepos(List<String> list) {
        return AppPrefsDaoInt.DefaultImpls.getPreferredRepos(this, list);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
