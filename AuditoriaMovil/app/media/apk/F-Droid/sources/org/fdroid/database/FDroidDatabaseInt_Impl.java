package org.fdroid.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.FtsTableInfo;
import androidx.room.util.TableInfo;
import androidx.room.util.ViewInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.fdroid.views.apps.AppListActivity;
/* loaded from: classes2.dex */
public final class FDroidDatabaseInt_Impl extends FDroidDatabaseInt {
    private volatile AppDaoInt _appDaoInt;
    private volatile AppPrefsDaoInt _appPrefsDaoInt;
    private volatile RepositoryDaoInt _repositoryDaoInt;
    private volatile VersionDaoInt _versionDaoInt;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(6) { // from class: org.fdroid.database.FDroidDatabaseInt_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `CoreRepository` (`repoId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `icon` TEXT, `address` TEXT NOT NULL, `webBaseUrl` TEXT, `timestamp` INTEGER NOT NULL, `version` INTEGER, `formatVersion` TEXT, `maxAge` INTEGER, `description` TEXT NOT NULL, `certificate` TEXT NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Mirror` (`repoId` INTEGER NOT NULL, `url` TEXT NOT NULL, `location` TEXT, PRIMARY KEY(`repoId`, `url`), FOREIGN KEY(`repoId`) REFERENCES `CoreRepository`(`repoId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AntiFeature` (`repoId` INTEGER NOT NULL, `id` TEXT NOT NULL, `icon` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`repoId`, `id`), FOREIGN KEY(`repoId`) REFERENCES `CoreRepository`(`repoId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Category` (`repoId` INTEGER NOT NULL, `id` TEXT NOT NULL, `icon` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`repoId`, `id`), FOREIGN KEY(`repoId`) REFERENCES `CoreRepository`(`repoId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ReleaseChannel` (`repoId` INTEGER NOT NULL, `id` TEXT NOT NULL, `icon` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`repoId`, `id`), FOREIGN KEY(`repoId`) REFERENCES `CoreRepository`(`repoId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RepositoryPreferences` (`repoId` INTEGER NOT NULL, `weight` INTEGER NOT NULL, `enabled` INTEGER NOT NULL, `lastUpdated` INTEGER, `lastETag` TEXT, `userMirrors` TEXT, `disabledMirrors` TEXT, `username` TEXT, `password` TEXT, PRIMARY KEY(`repoId`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AppMetadata` (`repoId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `added` INTEGER NOT NULL, `lastUpdated` INTEGER NOT NULL, `name` TEXT, `summary` TEXT, `description` TEXT, `localizedName` TEXT, `localizedSummary` TEXT, `webSite` TEXT, `changelog` TEXT, `license` TEXT, `sourceCode` TEXT, `issueTracker` TEXT, `translation` TEXT, `preferredSigner` TEXT, `video` TEXT, `authorName` TEXT, `authorEmail` TEXT, `authorWebSite` TEXT, `authorPhone` TEXT, `donate` TEXT, `liberapayID` TEXT, `liberapay` TEXT, `openCollective` TEXT, `bitcoin` TEXT, `litecoin` TEXT, `flattrID` TEXT, `categories` TEXT, `isCompatible` INTEGER NOT NULL, PRIMARY KEY(`repoId`, `packageName`), FOREIGN KEY(`repoId`) REFERENCES `CoreRepository`(`repoId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `AppMetadataFts` USING FTS4(`repoId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `localizedName` TEXT, `localizedSummary` TEXT, tokenize=unicode61 \"remove_diacritics=0\", content=`AppMetadata`)");
                supportSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_AppMetadataFts_BEFORE_UPDATE BEFORE UPDATE ON `AppMetadata` BEGIN DELETE FROM `AppMetadataFts` WHERE `docid`=OLD.`rowid`; END");
                supportSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_AppMetadataFts_BEFORE_DELETE BEFORE DELETE ON `AppMetadata` BEGIN DELETE FROM `AppMetadataFts` WHERE `docid`=OLD.`rowid`; END");
                supportSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_AppMetadataFts_AFTER_UPDATE AFTER UPDATE ON `AppMetadata` BEGIN INSERT INTO `AppMetadataFts`(`docid`, `repoId`, `packageName`, `localizedName`, `localizedSummary`) VALUES (NEW.`rowid`, NEW.`repoId`, NEW.`packageName`, NEW.`localizedName`, NEW.`localizedSummary`); END");
                supportSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_AppMetadataFts_AFTER_INSERT AFTER INSERT ON `AppMetadata` BEGIN INSERT INTO `AppMetadataFts`(`docid`, `repoId`, `packageName`, `localizedName`, `localizedSummary`) VALUES (NEW.`rowid`, NEW.`repoId`, NEW.`packageName`, NEW.`localizedName`, NEW.`localizedSummary`); END");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `LocalizedFile` (`repoId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `type` TEXT NOT NULL, `locale` TEXT NOT NULL, `name` TEXT NOT NULL, `sha256` TEXT, `size` INTEGER, `ipfsCidV1` TEXT, PRIMARY KEY(`repoId`, `packageName`, `type`, `locale`), FOREIGN KEY(`repoId`, `packageName`) REFERENCES `AppMetadata`(`repoId`, `packageName`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `LocalizedFileList` (`repoId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `type` TEXT NOT NULL, `locale` TEXT NOT NULL, `name` TEXT NOT NULL, `sha256` TEXT, `size` INTEGER, `ipfsCidV1` TEXT, PRIMARY KEY(`repoId`, `packageName`, `type`, `locale`, `name`), FOREIGN KEY(`repoId`, `packageName`) REFERENCES `AppMetadata`(`repoId`, `packageName`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Version` (`repoId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `versionId` TEXT NOT NULL, `added` INTEGER NOT NULL, `releaseChannels` TEXT, `antiFeatures` TEXT, `whatsNew` TEXT, `isCompatible` INTEGER NOT NULL, `file_name` TEXT NOT NULL, `file_sha256` TEXT NOT NULL, `file_size` INTEGER, `file_ipfsCidV1` TEXT, `src_name` TEXT, `src_sha256` TEXT, `src_size` INTEGER, `src_ipfsCidV1` TEXT, `manifest_versionName` TEXT NOT NULL, `manifest_versionCode` INTEGER NOT NULL, `manifest_maxSdkVersion` INTEGER, `manifest_nativecode` TEXT, `manifest_features` TEXT, `manifest_usesSdk_minSdkVersion` INTEGER, `manifest_usesSdk_targetSdkVersion` INTEGER, `manifest_signer_sha256` TEXT, `manifest_signer_hasMultipleSigners` INTEGER, PRIMARY KEY(`repoId`, `packageName`, `versionId`), FOREIGN KEY(`repoId`, `packageName`) REFERENCES `AppMetadata`(`repoId`, `packageName`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `VersionedString` (`repoId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `versionId` TEXT NOT NULL, `type` TEXT NOT NULL, `name` TEXT NOT NULL, `version` INTEGER, PRIMARY KEY(`repoId`, `packageName`, `versionId`, `type`, `name`), FOREIGN KEY(`repoId`, `packageName`, `versionId`) REFERENCES `Version`(`repoId`, `packageName`, `versionId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AppPrefs` (`packageName` TEXT NOT NULL, `ignoreVersionCodeUpdate` INTEGER NOT NULL, `preferredRepoId` INTEGER, `appPrefReleaseChannels` TEXT, PRIMARY KEY(`packageName`))");
                supportSQLiteDatabase.execSQL("CREATE VIEW `LocalizedIcon` AS SELECT * FROM LocalizedFile WHERE type='icon'");
                supportSQLiteDatabase.execSQL("CREATE VIEW `HighestVersion` AS SELECT repoId, packageName, antiFeatures FROM Version\n    GROUP BY repoId, packageName HAVING MAX(manifest_versionCode)");
                supportSQLiteDatabase.execSQL("CREATE VIEW `PreferredRepo` AS SELECT packageName, repoId AS preferredRepoId FROM AppMetadata\n    JOIN RepositoryPreferences AS pref USING (repoId)\n    LEFT JOIN AppPrefs USING (packageName)\n    WHERE repoId = COALESCE(preferredRepoId, repoId) AND pref.enabled = 1\n    GROUP BY packageName HAVING MAX(pref.weight)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6ac1d35b688d1875f864d1586821f381')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `CoreRepository`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Mirror`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AntiFeature`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Category`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ReleaseChannel`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `RepositoryPreferences`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AppMetadata`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AppMetadataFts`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `LocalizedFile`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `LocalizedFileList`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Version`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `VersionedString`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AppPrefs`");
                supportSQLiteDatabase.execSQL("DROP VIEW IF EXISTS `LocalizedIcon`");
                supportSQLiteDatabase.execSQL("DROP VIEW IF EXISTS `HighestVersion`");
                supportSQLiteDatabase.execSQL("DROP VIEW IF EXISTS `PreferredRepo`");
                List<RoomDatabase.Callback> list = ((RoomDatabase) FDroidDatabaseInt_Impl.this).mCallbacks;
                if (list != null) {
                    for (RoomDatabase.Callback callback : list) {
                        callback.onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List<RoomDatabase.Callback> list = ((RoomDatabase) FDroidDatabaseInt_Impl.this).mCallbacks;
                if (list != null) {
                    for (RoomDatabase.Callback callback : list) {
                        callback.onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) FDroidDatabaseInt_Impl.this).mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                FDroidDatabaseInt_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List<RoomDatabase.Callback> list = ((RoomDatabase) FDroidDatabaseInt_Impl.this).mCallbacks;
                if (list != null) {
                    for (RoomDatabase.Callback callback : list) {
                        callback.onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_AppMetadataFts_BEFORE_UPDATE BEFORE UPDATE ON `AppMetadata` BEGIN DELETE FROM `AppMetadataFts` WHERE `docid`=OLD.`rowid`; END");
                supportSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_AppMetadataFts_BEFORE_DELETE BEFORE DELETE ON `AppMetadata` BEGIN DELETE FROM `AppMetadataFts` WHERE `docid`=OLD.`rowid`; END");
                supportSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_AppMetadataFts_AFTER_UPDATE AFTER UPDATE ON `AppMetadata` BEGIN INSERT INTO `AppMetadataFts`(`docid`, `repoId`, `packageName`, `localizedName`, `localizedSummary`) VALUES (NEW.`rowid`, NEW.`repoId`, NEW.`packageName`, NEW.`localizedName`, NEW.`localizedSummary`); END");
                supportSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_AppMetadataFts_AFTER_INSERT AFTER INSERT ON `AppMetadata` BEGIN INSERT INTO `AppMetadataFts`(`docid`, `repoId`, `packageName`, `localizedName`, `localizedSummary`) VALUES (NEW.`rowid`, NEW.`repoId`, NEW.`packageName`, NEW.`localizedName`, NEW.`localizedSummary`); END");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(11);
                hashMap.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                hashMap.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
                hashMap.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, 1));
                hashMap.put("webBaseUrl", new TableInfo.Column("webBaseUrl", "TEXT", false, 0, null, 1));
                hashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                hashMap.put("version", new TableInfo.Column("version", "INTEGER", false, 0, null, 1));
                hashMap.put("formatVersion", new TableInfo.Column("formatVersion", "TEXT", false, 0, null, 1));
                hashMap.put("maxAge", new TableInfo.Column("maxAge", "INTEGER", false, 0, null, 1));
                hashMap.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                hashMap.put("certificate", new TableInfo.Column("certificate", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo(CoreRepository.TABLE, hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, CoreRepository.TABLE);
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "CoreRepository(org.fdroid.database.CoreRepository).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(3);
                hashMap2.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap2.put("url", new TableInfo.Column("url", "TEXT", true, 2, null, 1));
                hashMap2.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, 1));
                HashSet hashSet = new HashSet(1);
                hashSet.add(new TableInfo.ForeignKey(CoreRepository.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId"), Arrays.asList("repoId")));
                TableInfo tableInfo2 = new TableInfo(Mirror.TABLE, hashMap2, hashSet, new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase, Mirror.TABLE);
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "Mirror(org.fdroid.database.Mirror).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(5);
                hashMap3.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap3.put("id", new TableInfo.Column("id", "TEXT", true, 2, null, 1));
                hashMap3.put("icon", new TableInfo.Column("icon", "TEXT", true, 0, null, 1));
                hashMap3.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                hashMap3.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.ForeignKey(CoreRepository.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId"), Arrays.asList("repoId")));
                TableInfo tableInfo3 = new TableInfo(AntiFeature.TABLE, hashMap3, hashSet2, new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase, AntiFeature.TABLE);
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "AntiFeature(org.fdroid.database.AntiFeature).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(5);
                hashMap4.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap4.put("id", new TableInfo.Column("id", "TEXT", true, 2, null, 1));
                hashMap4.put("icon", new TableInfo.Column("icon", "TEXT", true, 0, null, 1));
                hashMap4.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                hashMap4.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                HashSet hashSet3 = new HashSet(1);
                hashSet3.add(new TableInfo.ForeignKey(CoreRepository.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId"), Arrays.asList("repoId")));
                TableInfo tableInfo4 = new TableInfo(Category.TABLE, hashMap4, hashSet3, new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase, Category.TABLE);
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "Category(org.fdroid.database.Category).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(5);
                hashMap5.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap5.put("id", new TableInfo.Column("id", "TEXT", true, 2, null, 1));
                hashMap5.put("icon", new TableInfo.Column("icon", "TEXT", true, 0, null, 1));
                hashMap5.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                hashMap5.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.ForeignKey(CoreRepository.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId"), Arrays.asList("repoId")));
                TableInfo tableInfo5 = new TableInfo(ReleaseChannel.TABLE, hashMap5, hashSet4, new HashSet(0));
                TableInfo read5 = TableInfo.read(supportSQLiteDatabase, ReleaseChannel.TABLE);
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "ReleaseChannel(org.fdroid.database.ReleaseChannel).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(9);
                hashMap6.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap6.put("weight", new TableInfo.Column("weight", "INTEGER", true, 0, null, 1));
                hashMap6.put("enabled", new TableInfo.Column("enabled", "INTEGER", true, 0, null, 1));
                hashMap6.put(AppListActivity.SortClause.LAST_UPDATED, new TableInfo.Column(AppListActivity.SortClause.LAST_UPDATED, "INTEGER", false, 0, null, 1));
                hashMap6.put("lastETag", new TableInfo.Column("lastETag", "TEXT", false, 0, null, 1));
                hashMap6.put("userMirrors", new TableInfo.Column("userMirrors", "TEXT", false, 0, null, 1));
                hashMap6.put("disabledMirrors", new TableInfo.Column("disabledMirrors", "TEXT", false, 0, null, 1));
                hashMap6.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, 1));
                hashMap6.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, 1));
                TableInfo tableInfo6 = new TableInfo(RepositoryPreferences.TABLE, hashMap6, new HashSet(0), new HashSet(0));
                TableInfo read6 = TableInfo.read(supportSQLiteDatabase, RepositoryPreferences.TABLE);
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "RepositoryPreferences(org.fdroid.database.RepositoryPreferences).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(30);
                hashMap7.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap7.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 2, null, 1));
                hashMap7.put("added", new TableInfo.Column("added", "INTEGER", true, 0, null, 1));
                hashMap7.put(AppListActivity.SortClause.LAST_UPDATED, new TableInfo.Column(AppListActivity.SortClause.LAST_UPDATED, "INTEGER", true, 0, null, 1));
                hashMap7.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                hashMap7.put(ErrorBundle.SUMMARY_ENTRY, new TableInfo.Column(ErrorBundle.SUMMARY_ENTRY, "TEXT", false, 0, null, 1));
                hashMap7.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                hashMap7.put("localizedName", new TableInfo.Column("localizedName", "TEXT", false, 0, null, 1));
                hashMap7.put("localizedSummary", new TableInfo.Column("localizedSummary", "TEXT", false, 0, null, 1));
                hashMap7.put("webSite", new TableInfo.Column("webSite", "TEXT", false, 0, null, 1));
                hashMap7.put("changelog", new TableInfo.Column("changelog", "TEXT", false, 0, null, 1));
                hashMap7.put("license", new TableInfo.Column("license", "TEXT", false, 0, null, 1));
                hashMap7.put("sourceCode", new TableInfo.Column("sourceCode", "TEXT", false, 0, null, 1));
                hashMap7.put("issueTracker", new TableInfo.Column("issueTracker", "TEXT", false, 0, null, 1));
                hashMap7.put("translation", new TableInfo.Column("translation", "TEXT", false, 0, null, 1));
                hashMap7.put("preferredSigner", new TableInfo.Column("preferredSigner", "TEXT", false, 0, null, 1));
                hashMap7.put("video", new TableInfo.Column("video", "TEXT", false, 0, null, 1));
                hashMap7.put("authorName", new TableInfo.Column("authorName", "TEXT", false, 0, null, 1));
                hashMap7.put("authorEmail", new TableInfo.Column("authorEmail", "TEXT", false, 0, null, 1));
                hashMap7.put("authorWebSite", new TableInfo.Column("authorWebSite", "TEXT", false, 0, null, 1));
                hashMap7.put("authorPhone", new TableInfo.Column("authorPhone", "TEXT", false, 0, null, 1));
                hashMap7.put("donate", new TableInfo.Column("donate", "TEXT", false, 0, null, 1));
                hashMap7.put("liberapayID", new TableInfo.Column("liberapayID", "TEXT", false, 0, null, 1));
                hashMap7.put("liberapay", new TableInfo.Column("liberapay", "TEXT", false, 0, null, 1));
                hashMap7.put("openCollective", new TableInfo.Column("openCollective", "TEXT", false, 0, null, 1));
                hashMap7.put("bitcoin", new TableInfo.Column("bitcoin", "TEXT", false, 0, null, 1));
                hashMap7.put("litecoin", new TableInfo.Column("litecoin", "TEXT", false, 0, null, 1));
                hashMap7.put("flattrID", new TableInfo.Column("flattrID", "TEXT", false, 0, null, 1));
                hashMap7.put("categories", new TableInfo.Column("categories", "TEXT", false, 0, null, 1));
                hashMap7.put("isCompatible", new TableInfo.Column("isCompatible", "INTEGER", true, 0, null, 1));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new TableInfo.ForeignKey(CoreRepository.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId"), Arrays.asList("repoId")));
                TableInfo tableInfo7 = new TableInfo(AppMetadata.TABLE, hashMap7, hashSet5, new HashSet(0));
                TableInfo read7 = TableInfo.read(supportSQLiteDatabase, AppMetadata.TABLE);
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "AppMetadata(org.fdroid.database.AppMetadata).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                HashSet hashSet6 = new HashSet(4);
                hashSet6.add("repoId");
                hashSet6.add("packageName");
                hashSet6.add("localizedName");
                hashSet6.add("localizedSummary");
                FtsTableInfo ftsTableInfo = new FtsTableInfo(AppMetadataFts.TABLE, hashSet6, "CREATE VIRTUAL TABLE IF NOT EXISTS `AppMetadataFts` USING FTS4(`repoId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `localizedName` TEXT, `localizedSummary` TEXT, tokenize=unicode61 \"remove_diacritics=0\", content=`AppMetadata`)");
                FtsTableInfo read8 = FtsTableInfo.read(supportSQLiteDatabase, AppMetadataFts.TABLE);
                if (!ftsTableInfo.equals(read8)) {
                    return new RoomOpenHelper.ValidationResult(false, "AppMetadataFts(org.fdroid.database.AppMetadataFts).\n Expected:\n" + ftsTableInfo + "\n Found:\n" + read8);
                }
                HashMap hashMap8 = new HashMap(8);
                hashMap8.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap8.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 2, null, 1));
                hashMap8.put(BonjourPeer.TYPE, new TableInfo.Column(BonjourPeer.TYPE, "TEXT", true, 3, null, 1));
                hashMap8.put("locale", new TableInfo.Column("locale", "TEXT", true, 4, null, 1));
                hashMap8.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                hashMap8.put("sha256", new TableInfo.Column("sha256", "TEXT", false, 0, null, 1));
                hashMap8.put("size", new TableInfo.Column("size", "INTEGER", false, 0, null, 1));
                hashMap8.put("ipfsCidV1", new TableInfo.Column("ipfsCidV1", "TEXT", false, 0, null, 1));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.ForeignKey(AppMetadata.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId", "packageName"), Arrays.asList("repoId", "packageName")));
                TableInfo tableInfo8 = new TableInfo(LocalizedFile.TABLE, hashMap8, hashSet7, new HashSet(0));
                TableInfo read9 = TableInfo.read(supportSQLiteDatabase, LocalizedFile.TABLE);
                if (!tableInfo8.equals(read9)) {
                    return new RoomOpenHelper.ValidationResult(false, "LocalizedFile(org.fdroid.database.LocalizedFile).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read9);
                }
                HashMap hashMap9 = new HashMap(8);
                hashMap9.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap9.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 2, null, 1));
                hashMap9.put(BonjourPeer.TYPE, new TableInfo.Column(BonjourPeer.TYPE, "TEXT", true, 3, null, 1));
                hashMap9.put("locale", new TableInfo.Column("locale", "TEXT", true, 4, null, 1));
                hashMap9.put("name", new TableInfo.Column("name", "TEXT", true, 5, null, 1));
                hashMap9.put("sha256", new TableInfo.Column("sha256", "TEXT", false, 0, null, 1));
                hashMap9.put("size", new TableInfo.Column("size", "INTEGER", false, 0, null, 1));
                hashMap9.put("ipfsCidV1", new TableInfo.Column("ipfsCidV1", "TEXT", false, 0, null, 1));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.ForeignKey(AppMetadata.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId", "packageName"), Arrays.asList("repoId", "packageName")));
                TableInfo tableInfo9 = new TableInfo(LocalizedFileList.TABLE, hashMap9, hashSet8, new HashSet(0));
                TableInfo read10 = TableInfo.read(supportSQLiteDatabase, LocalizedFileList.TABLE);
                if (!tableInfo9.equals(read10)) {
                    return new RoomOpenHelper.ValidationResult(false, "LocalizedFileList(org.fdroid.database.LocalizedFileList).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read10);
                }
                HashMap hashMap10 = new HashMap(25);
                hashMap10.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap10.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 2, null, 1));
                hashMap10.put("versionId", new TableInfo.Column("versionId", "TEXT", true, 3, null, 1));
                hashMap10.put("added", new TableInfo.Column("added", "INTEGER", true, 0, null, 1));
                hashMap10.put("releaseChannels", new TableInfo.Column("releaseChannels", "TEXT", false, 0, null, 1));
                hashMap10.put("antiFeatures", new TableInfo.Column("antiFeatures", "TEXT", false, 0, null, 1));
                hashMap10.put("whatsNew", new TableInfo.Column("whatsNew", "TEXT", false, 0, null, 1));
                hashMap10.put("isCompatible", new TableInfo.Column("isCompatible", "INTEGER", true, 0, null, 1));
                hashMap10.put("file_name", new TableInfo.Column("file_name", "TEXT", true, 0, null, 1));
                hashMap10.put("file_sha256", new TableInfo.Column("file_sha256", "TEXT", true, 0, null, 1));
                hashMap10.put("file_size", new TableInfo.Column("file_size", "INTEGER", false, 0, null, 1));
                hashMap10.put("file_ipfsCidV1", new TableInfo.Column("file_ipfsCidV1", "TEXT", false, 0, null, 1));
                hashMap10.put("src_name", new TableInfo.Column("src_name", "TEXT", false, 0, null, 1));
                hashMap10.put("src_sha256", new TableInfo.Column("src_sha256", "TEXT", false, 0, null, 1));
                hashMap10.put("src_size", new TableInfo.Column("src_size", "INTEGER", false, 0, null, 1));
                hashMap10.put("src_ipfsCidV1", new TableInfo.Column("src_ipfsCidV1", "TEXT", false, 0, null, 1));
                hashMap10.put("manifest_versionName", new TableInfo.Column("manifest_versionName", "TEXT", true, 0, null, 1));
                hashMap10.put("manifest_versionCode", new TableInfo.Column("manifest_versionCode", "INTEGER", true, 0, null, 1));
                hashMap10.put("manifest_maxSdkVersion", new TableInfo.Column("manifest_maxSdkVersion", "INTEGER", false, 0, null, 1));
                hashMap10.put("manifest_nativecode", new TableInfo.Column("manifest_nativecode", "TEXT", false, 0, null, 1));
                hashMap10.put("manifest_features", new TableInfo.Column("manifest_features", "TEXT", false, 0, null, 1));
                hashMap10.put("manifest_usesSdk_minSdkVersion", new TableInfo.Column("manifest_usesSdk_minSdkVersion", "INTEGER", false, 0, null, 1));
                hashMap10.put("manifest_usesSdk_targetSdkVersion", new TableInfo.Column("manifest_usesSdk_targetSdkVersion", "INTEGER", false, 0, null, 1));
                hashMap10.put("manifest_signer_sha256", new TableInfo.Column("manifest_signer_sha256", "TEXT", false, 0, null, 1));
                hashMap10.put("manifest_signer_hasMultipleSigners", new TableInfo.Column("manifest_signer_hasMultipleSigners", "INTEGER", false, 0, null, 1));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.ForeignKey(AppMetadata.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId", "packageName"), Arrays.asList("repoId", "packageName")));
                TableInfo tableInfo10 = new TableInfo(Version.TABLE, hashMap10, hashSet9, new HashSet(0));
                TableInfo read11 = TableInfo.read(supportSQLiteDatabase, Version.TABLE);
                if (!tableInfo10.equals(read11)) {
                    return new RoomOpenHelper.ValidationResult(false, "Version(org.fdroid.database.Version).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read11);
                }
                HashMap hashMap11 = new HashMap(6);
                hashMap11.put("repoId", new TableInfo.Column("repoId", "INTEGER", true, 1, null, 1));
                hashMap11.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 2, null, 1));
                hashMap11.put("versionId", new TableInfo.Column("versionId", "TEXT", true, 3, null, 1));
                hashMap11.put(BonjourPeer.TYPE, new TableInfo.Column(BonjourPeer.TYPE, "TEXT", true, 4, null, 1));
                hashMap11.put("name", new TableInfo.Column("name", "TEXT", true, 5, null, 1));
                hashMap11.put("version", new TableInfo.Column("version", "INTEGER", false, 0, null, 1));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.ForeignKey(Version.TABLE, "CASCADE", "NO ACTION", Arrays.asList("repoId", "packageName", "versionId"), Arrays.asList("repoId", "packageName", "versionId")));
                TableInfo tableInfo11 = new TableInfo(VersionedString.TABLE, hashMap11, hashSet10, new HashSet(0));
                TableInfo read12 = TableInfo.read(supportSQLiteDatabase, VersionedString.TABLE);
                if (!tableInfo11.equals(read12)) {
                    return new RoomOpenHelper.ValidationResult(false, "VersionedString(org.fdroid.database.VersionedString).\n Expected:\n" + tableInfo11 + "\n Found:\n" + read12);
                }
                HashMap hashMap12 = new HashMap(4);
                hashMap12.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 1, null, 1));
                hashMap12.put("ignoreVersionCodeUpdate", new TableInfo.Column("ignoreVersionCodeUpdate", "INTEGER", true, 0, null, 1));
                hashMap12.put("preferredRepoId", new TableInfo.Column("preferredRepoId", "INTEGER", false, 0, null, 1));
                hashMap12.put("appPrefReleaseChannels", new TableInfo.Column("appPrefReleaseChannels", "TEXT", false, 0, null, 1));
                TableInfo tableInfo12 = new TableInfo(AppPrefs.TABLE, hashMap12, new HashSet(0), new HashSet(0));
                TableInfo read13 = TableInfo.read(supportSQLiteDatabase, AppPrefs.TABLE);
                if (!tableInfo12.equals(read13)) {
                    return new RoomOpenHelper.ValidationResult(false, "AppPrefs(org.fdroid.database.AppPrefs).\n Expected:\n" + tableInfo12 + "\n Found:\n" + read13);
                }
                ViewInfo viewInfo = new ViewInfo(LocalizedIcon.TABLE, "CREATE VIEW `LocalizedIcon` AS SELECT * FROM LocalizedFile WHERE type='icon'");
                ViewInfo read14 = ViewInfo.read(supportSQLiteDatabase, LocalizedIcon.TABLE);
                if (!viewInfo.equals(read14)) {
                    return new RoomOpenHelper.ValidationResult(false, "LocalizedIcon(org.fdroid.database.LocalizedIcon).\n Expected:\n" + viewInfo + "\n Found:\n" + read14);
                }
                ViewInfo viewInfo2 = new ViewInfo(HighestVersion.TABLE, "CREATE VIEW `HighestVersion` AS SELECT repoId, packageName, antiFeatures FROM Version\n    GROUP BY repoId, packageName HAVING MAX(manifest_versionCode)");
                ViewInfo read15 = ViewInfo.read(supportSQLiteDatabase, HighestVersion.TABLE);
                if (!viewInfo2.equals(read15)) {
                    return new RoomOpenHelper.ValidationResult(false, "HighestVersion(org.fdroid.database.HighestVersion).\n Expected:\n" + viewInfo2 + "\n Found:\n" + read15);
                }
                ViewInfo viewInfo3 = new ViewInfo("PreferredRepo", "CREATE VIEW `PreferredRepo` AS SELECT packageName, repoId AS preferredRepoId FROM AppMetadata\n    JOIN RepositoryPreferences AS pref USING (repoId)\n    LEFT JOIN AppPrefs USING (packageName)\n    WHERE repoId = COALESCE(preferredRepoId, repoId) AND pref.enabled = 1\n    GROUP BY packageName HAVING MAX(pref.weight)");
                ViewInfo read16 = ViewInfo.read(supportSQLiteDatabase, "PreferredRepo");
                if (!viewInfo3.equals(read16)) {
                    return new RoomOpenHelper.ValidationResult(false, "PreferredRepo(org.fdroid.database.PreferredRepo).\n Expected:\n" + viewInfo3 + "\n Found:\n" + read16);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "6ac1d35b688d1875f864d1586821f381", "17a33f8b59a82cd5682b4eae6b07ea50")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        HashMap hashMap = new HashMap(1);
        hashMap.put(AppMetadataFts.TABLE, AppMetadata.TABLE);
        HashMap hashMap2 = new HashMap(3);
        HashSet hashSet = new HashSet(1);
        hashSet.add(LocalizedFile.TABLE);
        hashMap2.put("localizedicon", hashSet);
        HashSet hashSet2 = new HashSet(1);
        hashSet2.add(Version.TABLE);
        hashMap2.put("highestversion", hashSet2);
        HashSet hashSet3 = new HashSet(3);
        hashSet3.add(AppMetadata.TABLE);
        hashSet3.add(RepositoryPreferences.TABLE);
        hashSet3.add(AppPrefs.TABLE);
        hashMap2.put("preferredrepo", hashSet3);
        return new InvalidationTracker(this, hashMap, hashMap2, CoreRepository.TABLE, Mirror.TABLE, AntiFeature.TABLE, Category.TABLE, ReleaseChannel.TABLE, RepositoryPreferences.TABLE, AppMetadata.TABLE, AppMetadataFts.TABLE, LocalizedFile.TABLE, LocalizedFileList.TABLE, Version.TABLE, VersionedString.TABLE, AppPrefs.TABLE);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.execSQL("DELETE FROM `CoreRepository`");
            writableDatabase.execSQL("DELETE FROM `Mirror`");
            writableDatabase.execSQL("DELETE FROM `AntiFeature`");
            writableDatabase.execSQL("DELETE FROM `Category`");
            writableDatabase.execSQL("DELETE FROM `ReleaseChannel`");
            writableDatabase.execSQL("DELETE FROM `RepositoryPreferences`");
            writableDatabase.execSQL("DELETE FROM `AppMetadata`");
            writableDatabase.execSQL("DELETE FROM `AppMetadataFts`");
            writableDatabase.execSQL("DELETE FROM `LocalizedFile`");
            writableDatabase.execSQL("DELETE FROM `LocalizedFileList`");
            writableDatabase.execSQL("DELETE FROM `Version`");
            writableDatabase.execSQL("DELETE FROM `VersionedString`");
            writableDatabase.execSQL("DELETE FROM `AppPrefs`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(RepositoryDaoInt.class, RepositoryDaoInt_Impl.getRequiredConverters());
        hashMap.put(AppDaoInt.class, AppDaoInt_Impl.getRequiredConverters());
        hashMap.put(VersionDaoInt.class, VersionDaoInt_Impl.getRequiredConverters());
        hashMap.put(AppPrefsDaoInt.class, AppPrefsDaoInt_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FDroidDatabaseInt_AutoMigration_1_2_Impl());
        arrayList.add(new FDroidDatabaseInt_AutoMigration_3_4_Impl());
        arrayList.add(new FDroidDatabaseInt_AutoMigration_4_5_Impl());
        return arrayList;
    }

    @Override // org.fdroid.database.FDroidDatabase
    public RepositoryDaoInt getRepositoryDao() {
        RepositoryDaoInt repositoryDaoInt;
        if (this._repositoryDaoInt != null) {
            return this._repositoryDaoInt;
        }
        synchronized (this) {
            try {
                if (this._repositoryDaoInt == null) {
                    this._repositoryDaoInt = new RepositoryDaoInt_Impl(this);
                }
                repositoryDaoInt = this._repositoryDaoInt;
            } catch (Throwable th) {
                throw th;
            }
        }
        return repositoryDaoInt;
    }

    @Override // org.fdroid.database.FDroidDatabase
    public AppDaoInt getAppDao() {
        AppDaoInt appDaoInt;
        if (this._appDaoInt != null) {
            return this._appDaoInt;
        }
        synchronized (this) {
            try {
                if (this._appDaoInt == null) {
                    this._appDaoInt = new AppDaoInt_Impl(this);
                }
                appDaoInt = this._appDaoInt;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appDaoInt;
    }

    @Override // org.fdroid.database.FDroidDatabase
    public VersionDaoInt getVersionDao() {
        VersionDaoInt versionDaoInt;
        if (this._versionDaoInt != null) {
            return this._versionDaoInt;
        }
        synchronized (this) {
            try {
                if (this._versionDaoInt == null) {
                    this._versionDaoInt = new VersionDaoInt_Impl(this);
                }
                versionDaoInt = this._versionDaoInt;
            } catch (Throwable th) {
                throw th;
            }
        }
        return versionDaoInt;
    }

    @Override // org.fdroid.database.FDroidDatabase
    public AppPrefsDaoInt getAppPrefsDao() {
        AppPrefsDaoInt appPrefsDaoInt;
        if (this._appPrefsDaoInt != null) {
            return this._appPrefsDaoInt;
        }
        synchronized (this) {
            try {
                if (this._appPrefsDaoInt == null) {
                    this._appPrefsDaoInt = new AppPrefsDaoInt_Impl(this);
                }
                appPrefsDaoInt = this._appPrefsDaoInt;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appPrefsDaoInt;
    }
}
