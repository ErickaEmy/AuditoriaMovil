package org.fdroid.fdroid.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.fdroid.database.AppPrefs;
import org.fdroid.database.AppPrefsDao;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.fdroid.Preferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ContentProviderMigrator {
    private static final String OLD_DB_NAME = "fdroid";

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needsMigration(Context context) {
        for (String str : context.databaseList()) {
            if (OLD_DB_NAME.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void runMigrations(Context context, FDroidDatabase fDroidDatabase) {
        ContentProviderDbHelper contentProviderDbHelper = new ContentProviderDbHelper(context);
        try {
            SQLiteDatabase readableDatabase = contentProviderDbHelper.getReadableDatabase();
            migrateOldRepos(fDroidDatabase, readableDatabase);
            migrateIgnoredUpdates(fDroidDatabase, readableDatabase);
            contentProviderDbHelper.close();
        } catch (Throwable th) {
            try {
                contentProviderDbHelper.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0105, code lost:
        if (r9.equals(r10.getCertificate()) == false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void migrateOldRepos(org.fdroid.database.FDroidDatabase r20, android.database.sqlite.SQLiteDatabase r21) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.data.ContentProviderMigrator.migrateOldRepos(org.fdroid.database.FDroidDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    private void migrateIgnoredUpdates(FDroidDatabase fDroidDatabase, SQLiteDatabase sQLiteDatabase) {
        AppPrefsDao appPrefsDao = fDroidDatabase.getAppPrefsDao();
        Cursor query = sQLiteDatabase.query("fdroid_appPrefs", new String[]{"packageName", "ignoreThisUpdate", "ignoreAllUpdates"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                String string = query.getString(query.getColumnIndexOrThrow("packageName"));
                long j = query.getLong(query.getColumnIndexOrThrow("ignoreThisUpdate"));
                if (query.getInt(query.getColumnIndexOrThrow("ignoreAllUpdates")) == 1) {
                    j = Preferences.UPDATE_INTERVAL_DISABLED;
                }
                appPrefsDao.update(new AppPrefs(string, j, null, null));
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        query.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeOldDb(Context context) {
        context.deleteDatabase(OLD_DB_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ContentProviderDbHelper extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        ContentProviderDbHelper(Context context) {
            super(context, ContentProviderMigrator.OLD_DB_NAME, (SQLiteDatabase.CursorFactory) null, 85);
        }
    }
}
