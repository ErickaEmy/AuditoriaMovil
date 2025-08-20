package org.fdroid.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
/* loaded from: classes2.dex */
final class FDroidDatabaseInt_AutoMigration_4_5_Impl extends Migration {
    public FDroidDatabaseInt_AutoMigration_4_5_Impl() {
        super(4, 5);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("DROP VIEW LocalizedIcon");
        supportSQLiteDatabase.execSQL("DROP VIEW HighestVersion");
        supportSQLiteDatabase.execSQL("DROP VIEW PreferredRepo");
        supportSQLiteDatabase.execSQL("CREATE VIEW `LocalizedIcon` AS SELECT * FROM LocalizedFile WHERE type='icon'");
        supportSQLiteDatabase.execSQL("CREATE VIEW `HighestVersion` AS SELECT repoId, packageName, antiFeatures FROM Version\n    GROUP BY repoId, packageName HAVING MAX(manifest_versionCode)");
        supportSQLiteDatabase.execSQL("CREATE VIEW `PreferredRepo` AS SELECT packageName, repoId AS preferredRepoId FROM AppMetadata\n    JOIN RepositoryPreferences AS pref USING (repoId)\n    LEFT JOIN AppPrefs USING (packageName)\n    WHERE repoId = COALESCE(preferredRepoId, repoId) AND pref.enabled = 1\n    GROUP BY packageName HAVING MAX(pref.weight)");
    }
}
