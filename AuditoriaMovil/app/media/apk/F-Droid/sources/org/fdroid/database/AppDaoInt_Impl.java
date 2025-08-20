package org.fdroid.database;

import android.content.pm.PackageManager;
import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.core.os.LocaleListCompat;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.JsonObject;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.database.AppDaoInt;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.index.v2.MetadataV2;
/* loaded from: classes2.dex */
public final class AppDaoInt_Impl implements AppDaoInt {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfAppMetadata;
    private final EntityInsertionAdapter __insertionAdapterOfLocalizedFile;
    private final EntityInsertionAdapter __insertionAdapterOfLocalizedFileList;
    private final SharedSQLiteStatement __preparedStmtOfClearAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAppMetadata;
    private final SharedSQLiteStatement __preparedStmtOfDeleteLocalizedFile;
    private final SharedSQLiteStatement __preparedStmtOfDeleteLocalizedFileList;
    private final SharedSQLiteStatement __preparedStmtOfDeleteLocalizedFileLists;
    private final SharedSQLiteStatement __preparedStmtOfDeleteLocalizedFileLists_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteLocalizedFiles;
    private final SharedSQLiteStatement __preparedStmtOfUpdateAppMetadata;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCompatibility;
    private final SharedSQLiteStatement __preparedStmtOfUpdatePreferredSigner;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfAppMetadata;

    public AppDaoInt_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfAppMetadata = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `AppMetadata` (`repoId`,`packageName`,`added`,`lastUpdated`,`name`,`summary`,`description`,`localizedName`,`localizedSummary`,`webSite`,`changelog`,`license`,`sourceCode`,`issueTracker`,`translation`,`preferredSigner`,`video`,`authorName`,`authorEmail`,`authorWebSite`,`authorPhone`,`donate`,`liberapayID`,`liberapay`,`openCollective`,`bitcoin`,`litecoin`,`flattrID`,`categories`,`isCompatible`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AppMetadata appMetadata) {
                supportSQLiteStatement.bindLong(1, appMetadata.getRepoId());
                if (appMetadata.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, appMetadata.getPackageName());
                }
                supportSQLiteStatement.bindLong(3, appMetadata.getAdded());
                supportSQLiteStatement.bindLong(4, appMetadata.getLastUpdated());
                Converters converters = Converters.INSTANCE;
                String localizedTextV2toString = converters.localizedTextV2toString(appMetadata.getName());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, localizedTextV2toString);
                }
                String localizedTextV2toString2 = converters.localizedTextV2toString(appMetadata.getSummary());
                if (localizedTextV2toString2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, localizedTextV2toString2);
                }
                String localizedTextV2toString3 = converters.localizedTextV2toString(appMetadata.getDescription());
                if (localizedTextV2toString3 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, localizedTextV2toString3);
                }
                if (appMetadata.getLocalizedName() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, appMetadata.getLocalizedName());
                }
                if (appMetadata.getLocalizedSummary() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, appMetadata.getLocalizedSummary());
                }
                if (appMetadata.getWebSite() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, appMetadata.getWebSite());
                }
                if (appMetadata.getChangelog() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, appMetadata.getChangelog());
                }
                if (appMetadata.getLicense() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, appMetadata.getLicense());
                }
                if (appMetadata.getSourceCode() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, appMetadata.getSourceCode());
                }
                if (appMetadata.getIssueTracker() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, appMetadata.getIssueTracker());
                }
                if (appMetadata.getTranslation() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, appMetadata.getTranslation());
                }
                if (appMetadata.getPreferredSigner() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, appMetadata.getPreferredSigner());
                }
                String localizedTextV2toString4 = converters.localizedTextV2toString(appMetadata.getVideo());
                if (localizedTextV2toString4 == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, localizedTextV2toString4);
                }
                if (appMetadata.getAuthorName() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, appMetadata.getAuthorName());
                }
                if (appMetadata.getAuthorEmail() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, appMetadata.getAuthorEmail());
                }
                if (appMetadata.getAuthorWebSite() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, appMetadata.getAuthorWebSite());
                }
                if (appMetadata.getAuthorPhone() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, appMetadata.getAuthorPhone());
                }
                String listStringToString = converters.listStringToString(appMetadata.getDonate());
                if (listStringToString == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, listStringToString);
                }
                if (appMetadata.getLiberapayID() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, appMetadata.getLiberapayID());
                }
                if (appMetadata.getLiberapay() == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindString(24, appMetadata.getLiberapay());
                }
                if (appMetadata.getOpenCollective() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindString(25, appMetadata.getOpenCollective());
                }
                if (appMetadata.getBitcoin() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindString(26, appMetadata.getBitcoin());
                }
                if (appMetadata.getLitecoin() == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindString(27, appMetadata.getLitecoin());
                }
                if (appMetadata.getFlattrID() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, appMetadata.getFlattrID());
                }
                String listStringToString2 = converters.listStringToString(appMetadata.getCategories());
                if (listStringToString2 == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindString(29, listStringToString2);
                }
                supportSQLiteStatement.bindLong(30, appMetadata.isCompatible() ? 1L : 0L);
            }
        };
        this.__insertionAdapterOfLocalizedFile = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `LocalizedFile` (`repoId`,`packageName`,`type`,`locale`,`name`,`sha256`,`size`,`ipfsCidV1`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, LocalizedFile localizedFile) {
                supportSQLiteStatement.bindLong(1, localizedFile.getRepoId());
                if (localizedFile.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, localizedFile.getPackageName());
                }
                if (localizedFile.getType() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, localizedFile.getType());
                }
                if (localizedFile.getLocale() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, localizedFile.getLocale());
                }
                if (localizedFile.getName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, localizedFile.getName());
                }
                if (localizedFile.getSha256() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, localizedFile.getSha256());
                }
                if (localizedFile.getSize() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, localizedFile.getSize().longValue());
                }
                if (localizedFile.getIpfsCidV1() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, localizedFile.getIpfsCidV1());
                }
            }
        };
        this.__insertionAdapterOfLocalizedFileList = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `LocalizedFileList` (`repoId`,`packageName`,`type`,`locale`,`name`,`sha256`,`size`,`ipfsCidV1`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, LocalizedFileList localizedFileList) {
                supportSQLiteStatement.bindLong(1, localizedFileList.getRepoId());
                if (localizedFileList.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, localizedFileList.getPackageName());
                }
                if (localizedFileList.getType() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, localizedFileList.getType());
                }
                if (localizedFileList.getLocale() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, localizedFileList.getLocale());
                }
                if (localizedFileList.getName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, localizedFileList.getName());
                }
                if (localizedFileList.getSha256() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, localizedFileList.getSha256());
                }
                if (localizedFileList.getSize() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, localizedFileList.getSize().longValue());
                }
                if (localizedFileList.getIpfsCidV1() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, localizedFileList.getIpfsCidV1());
                }
            }
        };
        this.__updateAdapterOfAppMetadata = new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `AppMetadata` SET `repoId` = ?,`packageName` = ?,`added` = ?,`lastUpdated` = ?,`name` = ?,`summary` = ?,`description` = ?,`localizedName` = ?,`localizedSummary` = ?,`webSite` = ?,`changelog` = ?,`license` = ?,`sourceCode` = ?,`issueTracker` = ?,`translation` = ?,`preferredSigner` = ?,`video` = ?,`authorName` = ?,`authorEmail` = ?,`authorWebSite` = ?,`authorPhone` = ?,`donate` = ?,`liberapayID` = ?,`liberapay` = ?,`openCollective` = ?,`bitcoin` = ?,`litecoin` = ?,`flattrID` = ?,`categories` = ?,`isCompatible` = ? WHERE `repoId` = ? AND `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AppMetadata appMetadata) {
                supportSQLiteStatement.bindLong(1, appMetadata.getRepoId());
                if (appMetadata.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, appMetadata.getPackageName());
                }
                supportSQLiteStatement.bindLong(3, appMetadata.getAdded());
                supportSQLiteStatement.bindLong(4, appMetadata.getLastUpdated());
                Converters converters = Converters.INSTANCE;
                String localizedTextV2toString = converters.localizedTextV2toString(appMetadata.getName());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, localizedTextV2toString);
                }
                String localizedTextV2toString2 = converters.localizedTextV2toString(appMetadata.getSummary());
                if (localizedTextV2toString2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, localizedTextV2toString2);
                }
                String localizedTextV2toString3 = converters.localizedTextV2toString(appMetadata.getDescription());
                if (localizedTextV2toString3 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, localizedTextV2toString3);
                }
                if (appMetadata.getLocalizedName() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, appMetadata.getLocalizedName());
                }
                if (appMetadata.getLocalizedSummary() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, appMetadata.getLocalizedSummary());
                }
                if (appMetadata.getWebSite() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, appMetadata.getWebSite());
                }
                if (appMetadata.getChangelog() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, appMetadata.getChangelog());
                }
                if (appMetadata.getLicense() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, appMetadata.getLicense());
                }
                if (appMetadata.getSourceCode() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, appMetadata.getSourceCode());
                }
                if (appMetadata.getIssueTracker() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, appMetadata.getIssueTracker());
                }
                if (appMetadata.getTranslation() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, appMetadata.getTranslation());
                }
                if (appMetadata.getPreferredSigner() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, appMetadata.getPreferredSigner());
                }
                String localizedTextV2toString4 = converters.localizedTextV2toString(appMetadata.getVideo());
                if (localizedTextV2toString4 == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, localizedTextV2toString4);
                }
                if (appMetadata.getAuthorName() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, appMetadata.getAuthorName());
                }
                if (appMetadata.getAuthorEmail() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, appMetadata.getAuthorEmail());
                }
                if (appMetadata.getAuthorWebSite() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, appMetadata.getAuthorWebSite());
                }
                if (appMetadata.getAuthorPhone() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, appMetadata.getAuthorPhone());
                }
                String listStringToString = converters.listStringToString(appMetadata.getDonate());
                if (listStringToString == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, listStringToString);
                }
                if (appMetadata.getLiberapayID() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, appMetadata.getLiberapayID());
                }
                if (appMetadata.getLiberapay() == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindString(24, appMetadata.getLiberapay());
                }
                if (appMetadata.getOpenCollective() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindString(25, appMetadata.getOpenCollective());
                }
                if (appMetadata.getBitcoin() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindString(26, appMetadata.getBitcoin());
                }
                if (appMetadata.getLitecoin() == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindString(27, appMetadata.getLitecoin());
                }
                if (appMetadata.getFlattrID() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, appMetadata.getFlattrID());
                }
                String listStringToString2 = converters.listStringToString(appMetadata.getCategories());
                if (listStringToString2 == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindString(29, listStringToString2);
                }
                supportSQLiteStatement.bindLong(30, appMetadata.isCompatible() ? 1L : 0L);
                supportSQLiteStatement.bindLong(31, appMetadata.getRepoId());
                if (appMetadata.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(32);
                } else {
                    supportSQLiteStatement.bindString(32, appMetadata.getPackageName());
                }
            }
        };
        this.__preparedStmtOfUpdateCompatibility = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE AppMetadata \n        SET isCompatible = (\n            SELECT TOTAL(isCompatible) > 0 FROM Version\n            WHERE repoId = ? AND AppMetadata.packageName = Version.packageName\n        )\n        WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfUpdatePreferredSigner = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE AppMetadata SET preferredSigner = ?\n        WHERE repoId = ? AND packageName = ?";
            }
        };
        this.__preparedStmtOfUpdateAppMetadata = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE AppMetadata SET localizedName = ?, localizedSummary = ?\n        WHERE repoId = ? AND packageName = ?";
            }
        };
        this.__preparedStmtOfDeleteAppMetadata = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM AppMetadata WHERE repoId = ? AND packageName = ?";
            }
        };
        this.__preparedStmtOfDeleteLocalizedFiles = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LocalizedFile\n        WHERE repoId = ? AND packageName = ? AND type = ?";
            }
        };
        this.__preparedStmtOfDeleteLocalizedFile = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LocalizedFile\n        WHERE repoId = ? AND packageName = ? AND type = ?\n        AND locale = ?";
            }
        };
        this.__preparedStmtOfDeleteLocalizedFileLists = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LocalizedFileList\n        WHERE repoId = ? AND packageName = ?";
            }
        };
        this.__preparedStmtOfDeleteLocalizedFileLists_1 = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LocalizedFileList\n        WHERE repoId = ? AND packageName = ? AND type = ?";
            }
        };
        this.__preparedStmtOfDeleteLocalizedFileList = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LocalizedFileList\n        WHERE repoId = ? AND packageName = ? AND type = ?\n        AND locale = ?";
            }
        };
        this.__preparedStmtOfClearAll = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.AppDaoInt_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM AppMetadata";
            }
        };
    }

    @Override // org.fdroid.database.AppDaoInt
    public void insert(AppMetadata appMetadata) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAppMetadata.insert(appMetadata);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void insert(List<LocalizedFile> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfLocalizedFile.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void insertLocalizedFileLists(List<LocalizedFileList> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfLocalizedFileList.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public int updateAppMetadata(AppMetadata appMetadata) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handle = this.__updateAdapterOfAppMetadata.handle(appMetadata);
            this.__db.setTransactionSuccessful();
            return handle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public void insert(long j, String str, MetadataV2 metadataV2, LocaleListCompat localeListCompat) {
        this.__db.beginTransaction();
        try {
            AppDaoInt.DefaultImpls.insert(this, j, str, metadataV2, localeListCompat);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void updateApp(long j, String str, JsonObject jsonObject, LocaleListCompat localeListCompat) {
        this.__db.beginTransaction();
        try {
            AppDaoInt.DefaultImpls.updateApp(this, j, str, jsonObject, localeListCompat);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public void updateCompatibility(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateCompatibility.acquire();
        acquire.bindLong(1, j);
        acquire.bindLong(2, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfUpdateCompatibility.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void updatePreferredSigner(long j, String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdatePreferredSigner.acquire();
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        acquire.bindLong(2, j);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfUpdatePreferredSigner.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void updateAppMetadata(long j, String str, String str2, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateAppMetadata.acquire();
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        if (str3 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str3);
        }
        acquire.bindLong(3, j);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfUpdateAppMetadata.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void deleteAppMetadata(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAppMetadata.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteAppMetadata.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void deleteLocalizedFiles(long j, String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteLocalizedFiles.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteLocalizedFiles.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void deleteLocalizedFile(long j, String str, String str2, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteLocalizedFile.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        if (str3 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str3);
        }
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteLocalizedFile.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void deleteLocalizedFileLists(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteLocalizedFileLists.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteLocalizedFileLists.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void deleteLocalizedFileLists(long j, String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteLocalizedFileLists_1.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteLocalizedFileLists_1.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void deleteLocalizedFileList(long j, String str, String str2, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteLocalizedFileList.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        if (str3 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str3);
        }
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteLocalizedFileList.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public void clearAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearAll.acquire();
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfClearAll.release(acquire);
        }
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public LiveData getApp(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT AppMetadata.* FROM AppMetadata\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        LEFT JOIN AppPrefs USING (packageName)\n        WHERE packageName = ? AND pref.enabled = 1 AND\n            COALESCE(preferredRepoId, repoId) = repoId\n        ORDER BY pref.weight DESC LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedFile.TABLE, LocalizedFileList.TABLE, AppMetadata.TABLE, RepositoryPreferences.TABLE, AppPrefs.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.15
            @Override // java.util.concurrent.Callable
            public App call() {
                App app;
                String string;
                int i;
                String string2;
                int i2;
                String string3;
                int i3;
                String string4;
                int i4;
                String string5;
                int i5;
                String string6;
                int i6;
                String string7;
                int i7;
                String string8;
                int i8;
                String string9;
                int i9;
                String string10;
                int i10;
                String string11;
                int i11;
                String string12;
                int i12;
                String string13;
                int i13;
                String string14;
                int i14;
                String string15;
                int i15;
                String string16;
                int i16;
                String string17;
                int i17;
                ArrayList arrayList;
                ArrayList arrayList2;
                int i18;
                String string18;
                int i19;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "packageName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "added");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, AppListActivity.SortClause.LAST_UPDATED);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ErrorBundle.SUMMARY_ENTRY);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "localizedName");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "localizedSummary");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "webSite");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "changelog");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "license");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "sourceCode");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "issueTracker");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "translation");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "preferredSigner");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "video");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "authorName");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "authorEmail");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "authorWebSite");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "authorPhone");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "donate");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "liberapayID");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "liberapay");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "openCollective");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "bitcoin");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "litecoin");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "flattrID");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "categories");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "isCompatible");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query.moveToNext()) {
                        if (query.isNull(columnIndexOrThrow2)) {
                            i18 = columnIndexOrThrow12;
                            string18 = null;
                        } else {
                            i18 = columnIndexOrThrow12;
                            string18 = query.getString(columnIndexOrThrow2);
                        }
                        if (string18 == null || arrayMap.containsKey(string18)) {
                            i19 = columnIndexOrThrow11;
                        } else {
                            i19 = columnIndexOrThrow11;
                            arrayMap.put(string18, new ArrayList());
                        }
                        String string19 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        if (string19 != null && !arrayMap2.containsKey(string19)) {
                            arrayMap2.put(string19, new ArrayList());
                        }
                        columnIndexOrThrow11 = i19;
                        columnIndexOrThrow12 = i18;
                    }
                    int i20 = columnIndexOrThrow11;
                    int i21 = columnIndexOrThrow12;
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile(arrayMap);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList(arrayMap2);
                    if (query.moveToFirst()) {
                        long j = query.getLong(columnIndexOrThrow);
                        String string20 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        long j2 = query.getLong(columnIndexOrThrow3);
                        long j3 = query.getLong(columnIndexOrThrow4);
                        String string21 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        Converters converters = Converters.INSTANCE;
                        Map<String, String> fromStringToLocalizedTextV2 = converters.fromStringToLocalizedTextV2(string21);
                        Map<String, String> fromStringToLocalizedTextV22 = converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6));
                        Map<String, String> fromStringToLocalizedTextV23 = converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7));
                        String string22 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string23 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        if (query.isNull(columnIndexOrThrow10)) {
                            i = i20;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow10);
                            i = i20;
                        }
                        if (query.isNull(i)) {
                            i2 = i21;
                            string2 = null;
                        } else {
                            string2 = query.getString(i);
                            i2 = i21;
                        }
                        if (query.isNull(i2)) {
                            i3 = columnIndexOrThrow13;
                            string3 = null;
                        } else {
                            string3 = query.getString(i2);
                            i3 = columnIndexOrThrow13;
                        }
                        if (query.isNull(i3)) {
                            i4 = columnIndexOrThrow14;
                            string4 = null;
                        } else {
                            string4 = query.getString(i3);
                            i4 = columnIndexOrThrow14;
                        }
                        if (query.isNull(i4)) {
                            i5 = columnIndexOrThrow15;
                            string5 = null;
                        } else {
                            string5 = query.getString(i4);
                            i5 = columnIndexOrThrow15;
                        }
                        if (query.isNull(i5)) {
                            i6 = columnIndexOrThrow16;
                            string6 = null;
                        } else {
                            string6 = query.getString(i5);
                            i6 = columnIndexOrThrow16;
                        }
                        if (query.isNull(i6)) {
                            i7 = columnIndexOrThrow17;
                            string7 = null;
                        } else {
                            string7 = query.getString(i6);
                            i7 = columnIndexOrThrow17;
                        }
                        Map<String, String> fromStringToLocalizedTextV24 = converters.fromStringToLocalizedTextV2(query.isNull(i7) ? null : query.getString(i7));
                        if (query.isNull(columnIndexOrThrow18)) {
                            i8 = columnIndexOrThrow19;
                            string8 = null;
                        } else {
                            string8 = query.getString(columnIndexOrThrow18);
                            i8 = columnIndexOrThrow19;
                        }
                        if (query.isNull(i8)) {
                            i9 = columnIndexOrThrow20;
                            string9 = null;
                        } else {
                            string9 = query.getString(i8);
                            i9 = columnIndexOrThrow20;
                        }
                        if (query.isNull(i9)) {
                            i10 = columnIndexOrThrow21;
                            string10 = null;
                        } else {
                            string10 = query.getString(i9);
                            i10 = columnIndexOrThrow21;
                        }
                        if (query.isNull(i10)) {
                            i11 = columnIndexOrThrow22;
                            string11 = null;
                        } else {
                            string11 = query.getString(i10);
                            i11 = columnIndexOrThrow22;
                        }
                        List<String> fromStringToListString = converters.fromStringToListString(query.isNull(i11) ? null : query.getString(i11));
                        if (query.isNull(columnIndexOrThrow23)) {
                            i12 = columnIndexOrThrow24;
                            string12 = null;
                        } else {
                            string12 = query.getString(columnIndexOrThrow23);
                            i12 = columnIndexOrThrow24;
                        }
                        if (query.isNull(i12)) {
                            i13 = columnIndexOrThrow25;
                            string13 = null;
                        } else {
                            string13 = query.getString(i12);
                            i13 = columnIndexOrThrow25;
                        }
                        if (query.isNull(i13)) {
                            i14 = columnIndexOrThrow26;
                            string14 = null;
                        } else {
                            string14 = query.getString(i13);
                            i14 = columnIndexOrThrow26;
                        }
                        if (query.isNull(i14)) {
                            i15 = columnIndexOrThrow27;
                            string15 = null;
                        } else {
                            string15 = query.getString(i14);
                            i15 = columnIndexOrThrow27;
                        }
                        if (query.isNull(i15)) {
                            i16 = columnIndexOrThrow28;
                            string16 = null;
                        } else {
                            string16 = query.getString(i15);
                            i16 = columnIndexOrThrow28;
                        }
                        if (query.isNull(i16)) {
                            i17 = columnIndexOrThrow29;
                            string17 = null;
                        } else {
                            string17 = query.getString(i16);
                            i17 = columnIndexOrThrow29;
                        }
                        AppMetadata appMetadata = new AppMetadata(j, string20, j2, j3, fromStringToLocalizedTextV2, fromStringToLocalizedTextV22, fromStringToLocalizedTextV23, string22, string23, string, string2, string3, string4, string5, string6, string7, fromStringToLocalizedTextV24, string8, string9, string10, string11, fromStringToListString, string12, string13, string14, string15, string16, string17, converters.fromStringToListString(query.isNull(i17) ? null : query.getString(i17)), query.getInt(columnIndexOrThrow30) != 0);
                        String string24 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        if (string24 != null) {
                            arrayList = (ArrayList) arrayMap.get(string24);
                        } else {
                            arrayList = new ArrayList();
                        }
                        String string25 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        if (string25 != null) {
                            arrayList2 = (ArrayList) arrayMap2.get(string25);
                        } else {
                            arrayList2 = new ArrayList();
                        }
                        app = new App(appMetadata, arrayList, arrayList2);
                    } else {
                        app = null;
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return app;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public App getApp(long j, String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        App app;
        String string;
        int i;
        String string2;
        int i2;
        String string3;
        int i3;
        String string4;
        int i4;
        String string5;
        int i5;
        String string6;
        int i6;
        String string7;
        int i7;
        String string8;
        int i8;
        String string9;
        int i9;
        String string10;
        int i10;
        String string11;
        int i11;
        String string12;
        int i12;
        String string13;
        int i13;
        String string14;
        int i14;
        String string15;
        int i15;
        String string16;
        int i16;
        String string17;
        int i17;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i18;
        String string18;
        int i19;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AppMetadata\n        WHERE repoId = ? AND packageName = ?", 2);
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "packageName");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "added");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, AppListActivity.SortClause.LAST_UPDATED);
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ErrorBundle.SUMMARY_ENTRY);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "description");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "localizedName");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "localizedSummary");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "webSite");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "changelog");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "license");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "sourceCode");
                roomSQLiteQuery = acquire;
                try {
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "issueTracker");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "translation");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "preferredSigner");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "video");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "authorName");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "authorEmail");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "authorWebSite");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "authorPhone");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "donate");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "liberapayID");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "liberapay");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "openCollective");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "bitcoin");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "litecoin");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "flattrID");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "categories");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "isCompatible");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query.moveToNext()) {
                        if (query.isNull(columnIndexOrThrow2)) {
                            i18 = columnIndexOrThrow12;
                            string18 = null;
                        } else {
                            i18 = columnIndexOrThrow12;
                            string18 = query.getString(columnIndexOrThrow2);
                        }
                        if (string18 == null || arrayMap.containsKey(string18)) {
                            i19 = columnIndexOrThrow11;
                        } else {
                            i19 = columnIndexOrThrow11;
                            arrayMap.put(string18, new ArrayList());
                        }
                        String string19 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        if (string19 != null && !arrayMap2.containsKey(string19)) {
                            arrayMap2.put(string19, new ArrayList());
                        }
                        columnIndexOrThrow11 = i19;
                        columnIndexOrThrow12 = i18;
                    }
                    int i20 = columnIndexOrThrow12;
                    int i21 = columnIndexOrThrow11;
                    query.moveToPosition(-1);
                    __fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile(arrayMap);
                    __fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList(arrayMap2);
                    if (query.moveToFirst()) {
                        long j2 = query.getLong(columnIndexOrThrow);
                        String string20 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        long j3 = query.getLong(columnIndexOrThrow3);
                        long j4 = query.getLong(columnIndexOrThrow4);
                        String string21 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                        Converters converters = Converters.INSTANCE;
                        Map<String, String> fromStringToLocalizedTextV2 = converters.fromStringToLocalizedTextV2(string21);
                        Map<String, String> fromStringToLocalizedTextV22 = converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6));
                        Map<String, String> fromStringToLocalizedTextV23 = converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7));
                        String string22 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string23 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        if (query.isNull(columnIndexOrThrow10)) {
                            i = i21;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow10);
                            i = i21;
                        }
                        if (query.isNull(i)) {
                            i2 = i20;
                            string2 = null;
                        } else {
                            string2 = query.getString(i);
                            i2 = i20;
                        }
                        if (query.isNull(i2)) {
                            i3 = columnIndexOrThrow13;
                            string3 = null;
                        } else {
                            string3 = query.getString(i2);
                            i3 = columnIndexOrThrow13;
                        }
                        if (query.isNull(i3)) {
                            i4 = columnIndexOrThrow14;
                            string4 = null;
                        } else {
                            string4 = query.getString(i3);
                            i4 = columnIndexOrThrow14;
                        }
                        if (query.isNull(i4)) {
                            i5 = columnIndexOrThrow15;
                            string5 = null;
                        } else {
                            string5 = query.getString(i4);
                            i5 = columnIndexOrThrow15;
                        }
                        if (query.isNull(i5)) {
                            i6 = columnIndexOrThrow16;
                            string6 = null;
                        } else {
                            string6 = query.getString(i5);
                            i6 = columnIndexOrThrow16;
                        }
                        if (query.isNull(i6)) {
                            i7 = columnIndexOrThrow17;
                            string7 = null;
                        } else {
                            string7 = query.getString(i6);
                            i7 = columnIndexOrThrow17;
                        }
                        Map<String, String> fromStringToLocalizedTextV24 = converters.fromStringToLocalizedTextV2(query.isNull(i7) ? null : query.getString(i7));
                        if (query.isNull(columnIndexOrThrow18)) {
                            i8 = columnIndexOrThrow19;
                            string8 = null;
                        } else {
                            string8 = query.getString(columnIndexOrThrow18);
                            i8 = columnIndexOrThrow19;
                        }
                        if (query.isNull(i8)) {
                            i9 = columnIndexOrThrow20;
                            string9 = null;
                        } else {
                            string9 = query.getString(i8);
                            i9 = columnIndexOrThrow20;
                        }
                        if (query.isNull(i9)) {
                            i10 = columnIndexOrThrow21;
                            string10 = null;
                        } else {
                            string10 = query.getString(i9);
                            i10 = columnIndexOrThrow21;
                        }
                        if (query.isNull(i10)) {
                            i11 = columnIndexOrThrow22;
                            string11 = null;
                        } else {
                            string11 = query.getString(i10);
                            i11 = columnIndexOrThrow22;
                        }
                        List<String> fromStringToListString = converters.fromStringToListString(query.isNull(i11) ? null : query.getString(i11));
                        if (query.isNull(columnIndexOrThrow23)) {
                            i12 = columnIndexOrThrow24;
                            string12 = null;
                        } else {
                            string12 = query.getString(columnIndexOrThrow23);
                            i12 = columnIndexOrThrow24;
                        }
                        if (query.isNull(i12)) {
                            i13 = columnIndexOrThrow25;
                            string13 = null;
                        } else {
                            string13 = query.getString(i12);
                            i13 = columnIndexOrThrow25;
                        }
                        if (query.isNull(i13)) {
                            i14 = columnIndexOrThrow26;
                            string14 = null;
                        } else {
                            string14 = query.getString(i13);
                            i14 = columnIndexOrThrow26;
                        }
                        if (query.isNull(i14)) {
                            i15 = columnIndexOrThrow27;
                            string15 = null;
                        } else {
                            string15 = query.getString(i14);
                            i15 = columnIndexOrThrow27;
                        }
                        if (query.isNull(i15)) {
                            i16 = columnIndexOrThrow28;
                            string16 = null;
                        } else {
                            string16 = query.getString(i15);
                            i16 = columnIndexOrThrow28;
                        }
                        if (query.isNull(i16)) {
                            i17 = columnIndexOrThrow29;
                            string17 = null;
                        } else {
                            string17 = query.getString(i16);
                            i17 = columnIndexOrThrow29;
                        }
                        AppMetadata appMetadata = new AppMetadata(j2, string20, j3, j4, fromStringToLocalizedTextV2, fromStringToLocalizedTextV22, fromStringToLocalizedTextV23, string22, string23, string, string2, string3, string4, string5, string6, string7, fromStringToLocalizedTextV24, string8, string9, string10, string11, fromStringToListString, string12, string13, string14, string15, string16, string17, converters.fromStringToListString(query.isNull(i17) ? null : query.getString(i17)), query.getInt(columnIndexOrThrow30) != 0);
                        String string24 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        if (string24 != null) {
                            arrayList = (ArrayList) arrayMap.get(string24);
                        } else {
                            arrayList = new ArrayList();
                        }
                        String string25 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        if (string25 != null) {
                            arrayList2 = (ArrayList) arrayMap2.get(string25);
                        } else {
                            arrayList2 = new ArrayList();
                        }
                        app = new App(appMetadata, arrayList, arrayList2);
                    } else {
                        app = null;
                    }
                    this.__db.setTransactionSuccessful();
                    query.close();
                    roomSQLiteQuery.release();
                    return app;
                } catch (Throwable th) {
                    th = th;
                    query.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                roomSQLiteQuery = acquire;
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public List<Long> getRepositoryIdsForApp(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT repoId FROM AppMetadata\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        WHERE pref.enabled = 1 AND packageName = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.isNull(0) ? null : Long.valueOf(query.getLong(0)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public LiveData getAppOverviewItems(int i) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT repoId, packageName, app.added, app.lastUpdated, localizedName,\n            localizedSummary, version.antiFeatures, app.isCompatible\n        FROM AppMetadata AS app\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        LEFT JOIN LocalizedIcon AS icon USING (repoId, packageName)\n        LEFT JOIN AppPrefs USING (packageName)\n        WHERE pref.enabled = 1 AND COALESCE(preferredRepoId, repoId) = repoId\n        GROUP BY packageName HAVING MAX(pref.weight)\n        ORDER BY localizedName IS NULL ASC, icon.packageName IS NULL ASC,\n            localizedSummary IS NULL ASC, app.lastUpdated DESC\n        LIMIT ?", 1);
        acquire.bindLong(1, i);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, RepositoryPreferences.TABLE, HighestVersion.TABLE, AppPrefs.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.16
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    String str = null;
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? str : query.getString(1);
                        long j2 = query.getLong(2);
                        long j3 = query.getLong(3);
                        String string3 = query.isNull(4) ? str : query.getString(4);
                        String string4 = query.isNull(5) ? str : query.getString(5);
                        Map<String, Map<String, String>> fromStringToMapOfLocalizedTextV2 = Converters.INSTANCE.fromStringToMapOfLocalizedTextV2(query.isNull(6) ? str : query.getString(6));
                        boolean z = query.getInt(7) != 0;
                        String string5 = query.isNull(1) ? null : query.getString(1);
                        if (string5 != null) {
                            arrayList = (ArrayList) arrayMap.get(string5);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppOverviewItem(j, string2, j2, j3, string3, string4, fromStringToMapOfLocalizedTextV2, arrayList, z));
                        str = null;
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public LiveData getAppOverviewItems(String str, int i) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT repoId, packageName, app.added, app.lastUpdated, localizedName,\n             localizedSummary, version.antiFeatures, app.isCompatible\n        FROM AppMetadata AS app\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        LEFT JOIN LocalizedIcon AS icon USING (repoId, packageName)\n        LEFT JOIN AppPrefs USING (packageName)\n        WHERE pref.enabled = 1 AND categories  LIKE '%,' || ? || ',%' AND\n           COALESCE(preferredRepoId, repoId) = repoId\n        GROUP BY packageName HAVING MAX(pref.weight)\n        ORDER BY localizedName IS NULL ASC, icon.packageName IS NULL ASC,\n            localizedSummary IS NULL ASC, app.lastUpdated DESC\n        LIMIT ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, i);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, RepositoryPreferences.TABLE, HighestVersion.TABLE, AppPrefs.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.17
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    String str2 = null;
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? str2 : query.getString(1);
                        long j2 = query.getLong(2);
                        long j3 = query.getLong(3);
                        String string3 = query.isNull(4) ? str2 : query.getString(4);
                        String string4 = query.isNull(5) ? str2 : query.getString(5);
                        Map<String, Map<String, String>> fromStringToMapOfLocalizedTextV2 = Converters.INSTANCE.fromStringToMapOfLocalizedTextV2(query.isNull(6) ? str2 : query.getString(6));
                        boolean z = query.getInt(7) != 0;
                        String string5 = query.isNull(1) ? null : query.getString(1);
                        if (string5 != null) {
                            arrayList = (ArrayList) arrayMap.get(string5);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppOverviewItem(j, string2, j2, j3, string3, string4, fromStringToMapOfLocalizedTextV2, arrayList, z));
                        str2 = null;
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItems(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, app.localizedName, app.localizedSummary, app.lastUpdated, \n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        JOIN AppMetadataFts USING (repoId, packageName)\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        LEFT JOIN AppPrefs USING (packageName)\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        WHERE pref.enabled = 1 AND AppMetadataFts MATCH ? AND\n           COALESCE(preferredRepoId, repoId) = repoId\n        GROUP BY packageName HAVING MAX(pref.weight)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, AppMetadataFts.TABLE, HighestVersion.TABLE, AppPrefs.TABLE, RepositoryPreferences.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.18
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j2 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j, string2, string3, string4, j2, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItems(String str, String str2) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, app.localizedName, app.localizedSummary, app.lastUpdated, \n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        JOIN AppMetadataFts USING (repoId, packageName)\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        LEFT JOIN AppPrefs USING (packageName)\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        WHERE pref.enabled = 1 AND categories LIKE '%,' || ? || ',%' AND\n           AppMetadataFts MATCH ? AND\n           COALESCE(preferredRepoId, repoId) = repoId\n        GROUP BY packageName HAVING MAX(pref.weight)", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, AppMetadataFts.TABLE, HighestVersion.TABLE, AppPrefs.TABLE, RepositoryPreferences.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.19
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j2 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j, string2, string3, string4, j2, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItems(long j, String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, app.localizedName, app.localizedSummary, app.lastUpdated, \n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        WHERE repoId = ? AND app.rowid IN (\n            SELECT rowid FROM AppMetadataFts\n            WHERE repoId = ? AND AppMetadataFts MATCH ?\n        )", 3);
        acquire.bindLong(1, j);
        acquire.bindLong(2, j);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, HighestVersion.TABLE, AppMetadataFts.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.20
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j2 = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j3 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j2, string2, string3, string4, j3, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItems(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT repoId, packageName, localizedName, localizedSummary, app.lastUpdated, ");
        newStringBuilder.append("\n");
        newStringBuilder.append("                     app.isCompatible, app.preferredSigner");
        newStringBuilder.append("\n");
        newStringBuilder.append("        FROM AppMetadata AS app");
        newStringBuilder.append("\n");
        newStringBuilder.append("        JOIN RepositoryPreferences AS pref USING (repoId)");
        newStringBuilder.append("\n");
        newStringBuilder.append("        LEFT JOIN AppPrefs USING (packageName)");
        newStringBuilder.append("\n");
        newStringBuilder.append("        WHERE pref.enabled = 1 AND packageName IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") AND");
        newStringBuilder.append("\n");
        newStringBuilder.append("           COALESCE(preferredRepoId, repoId) = repoId");
        newStringBuilder.append("\n");
        newStringBuilder.append("        GROUP BY packageName HAVING MAX(pref.weight)");
        newStringBuilder.append("\n");
        newStringBuilder.append("        ORDER BY localizedName COLLATE NOCASE ASC");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, RepositoryPreferences.TABLE, AppPrefs.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.21
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j2 = query.getLong(4);
                        boolean z = query.getInt(5) != 0;
                        String string5 = query.isNull(6) ? null : query.getString(6);
                        String string6 = query.isNull(1) ? null : query.getString(1);
                        if (string6 != null) {
                            arrayList = (ArrayList) arrayMap.get(string6);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j, string2, string3, string4, j2, null, arrayList, z, string5, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public int getNumberOfAppsInCategory(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(DISTINCT packageName) FROM AppMetadata\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        WHERE pref.enabled = 1 AND categories LIKE '%,' || ? || ',%'", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public int getNumberOfAppsInRepository(long j) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AppMetadata WHERE repoId = ?", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public AppMetadata getAppMetadata(long j, String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        AppMetadata appMetadata;
        String string;
        int i;
        String string2;
        int i2;
        String string3;
        int i3;
        String string4;
        int i4;
        String string5;
        int i5;
        String string6;
        int i6;
        String string7;
        int i7;
        String string8;
        int i8;
        String string9;
        int i9;
        String string10;
        int i10;
        String string11;
        int i11;
        String string12;
        int i12;
        String string13;
        int i13;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AppMetadata\n        WHERE repoId = ? AND packageName = ?", 2);
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "packageName");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "added");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, AppListActivity.SortClause.LAST_UPDATED);
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "name");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ErrorBundle.SUMMARY_ENTRY);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "description");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "localizedName");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "localizedSummary");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "webSite");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "changelog");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "license");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "sourceCode");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "issueTracker");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "translation");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "preferredSigner");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "video");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "authorName");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "authorEmail");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "authorWebSite");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "authorPhone");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "donate");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "liberapayID");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "liberapay");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "openCollective");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "bitcoin");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "litecoin");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "flattrID");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "categories");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "isCompatible");
            if (query.moveToFirst()) {
                long j2 = query.getLong(columnIndexOrThrow);
                String string14 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                long j3 = query.getLong(columnIndexOrThrow3);
                long j4 = query.getLong(columnIndexOrThrow4);
                String string15 = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                Converters converters = Converters.INSTANCE;
                Map<String, String> fromStringToLocalizedTextV2 = converters.fromStringToLocalizedTextV2(string15);
                Map<String, String> fromStringToLocalizedTextV22 = converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6));
                Map<String, String> fromStringToLocalizedTextV23 = converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7));
                String string16 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                String string17 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                String string18 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                String string19 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                String string20 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                String string21 = query.isNull(columnIndexOrThrow13) ? null : query.getString(columnIndexOrThrow13);
                if (query.isNull(columnIndexOrThrow14)) {
                    i = columnIndexOrThrow15;
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow14);
                    i = columnIndexOrThrow15;
                }
                if (query.isNull(i)) {
                    i2 = columnIndexOrThrow16;
                    string2 = null;
                } else {
                    string2 = query.getString(i);
                    i2 = columnIndexOrThrow16;
                }
                if (query.isNull(i2)) {
                    i3 = columnIndexOrThrow17;
                    string3 = null;
                } else {
                    string3 = query.getString(i2);
                    i3 = columnIndexOrThrow17;
                }
                Map<String, String> fromStringToLocalizedTextV24 = converters.fromStringToLocalizedTextV2(query.isNull(i3) ? null : query.getString(i3));
                if (query.isNull(columnIndexOrThrow18)) {
                    i4 = columnIndexOrThrow19;
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow18);
                    i4 = columnIndexOrThrow19;
                }
                if (query.isNull(i4)) {
                    i5 = columnIndexOrThrow20;
                    string5 = null;
                } else {
                    string5 = query.getString(i4);
                    i5 = columnIndexOrThrow20;
                }
                if (query.isNull(i5)) {
                    i6 = columnIndexOrThrow21;
                    string6 = null;
                } else {
                    string6 = query.getString(i5);
                    i6 = columnIndexOrThrow21;
                }
                if (query.isNull(i6)) {
                    i7 = columnIndexOrThrow22;
                    string7 = null;
                } else {
                    string7 = query.getString(i6);
                    i7 = columnIndexOrThrow22;
                }
                List<String> fromStringToListString = converters.fromStringToListString(query.isNull(i7) ? null : query.getString(i7));
                if (query.isNull(columnIndexOrThrow23)) {
                    i8 = columnIndexOrThrow24;
                    string8 = null;
                } else {
                    string8 = query.getString(columnIndexOrThrow23);
                    i8 = columnIndexOrThrow24;
                }
                if (query.isNull(i8)) {
                    i9 = columnIndexOrThrow25;
                    string9 = null;
                } else {
                    string9 = query.getString(i8);
                    i9 = columnIndexOrThrow25;
                }
                if (query.isNull(i9)) {
                    i10 = columnIndexOrThrow26;
                    string10 = null;
                } else {
                    string10 = query.getString(i9);
                    i10 = columnIndexOrThrow26;
                }
                if (query.isNull(i10)) {
                    i11 = columnIndexOrThrow27;
                    string11 = null;
                } else {
                    string11 = query.getString(i10);
                    i11 = columnIndexOrThrow27;
                }
                if (query.isNull(i11)) {
                    i12 = columnIndexOrThrow28;
                    string12 = null;
                } else {
                    string12 = query.getString(i11);
                    i12 = columnIndexOrThrow28;
                }
                if (query.isNull(i12)) {
                    i13 = columnIndexOrThrow29;
                    string13 = null;
                } else {
                    string13 = query.getString(i12);
                    i13 = columnIndexOrThrow29;
                }
                appMetadata = new AppMetadata(j2, string14, j3, j4, fromStringToLocalizedTextV2, fromStringToLocalizedTextV22, fromStringToLocalizedTextV23, string16, string17, string18, string19, string20, string21, string, string2, string3, fromStringToLocalizedTextV24, string4, string5, string6, string7, fromStringToListString, string8, string9, string10, string11, string12, string13, converters.fromStringToListString(query.isNull(i13) ? null : query.getString(i13)), query.getInt(columnIndexOrThrow30) != 0);
            } else {
                appMetadata = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return appMetadata;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public List<AppMetadata> getAppMetadata() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        String string;
        int i;
        String string2;
        int i2;
        String string3;
        int i3;
        String string4;
        int i4;
        String string5;
        int i5;
        int i6;
        String string6;
        String string7;
        int i7;
        String string8;
        int i8;
        String string9;
        int i9;
        String string10;
        int i10;
        String string11;
        String string12;
        int i11;
        String string13;
        int i12;
        String string14;
        int i13;
        String string15;
        int i14;
        String string16;
        int i15;
        String string17;
        int i16;
        String string18;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AppMetadata", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "packageName");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "added");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, AppListActivity.SortClause.LAST_UPDATED);
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "name");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ErrorBundle.SUMMARY_ENTRY);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "description");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "localizedName");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "localizedSummary");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "webSite");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "changelog");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "license");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "sourceCode");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "issueTracker");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "translation");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "preferredSigner");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "video");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "authorName");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "authorEmail");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "authorWebSite");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "authorPhone");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "donate");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "liberapayID");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "liberapay");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "openCollective");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "bitcoin");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "litecoin");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "flattrID");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "categories");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "isCompatible");
            int i17 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j = query.getLong(columnIndexOrThrow);
                String string19 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                long j2 = query.getLong(columnIndexOrThrow3);
                long j3 = query.getLong(columnIndexOrThrow4);
                if (query.isNull(columnIndexOrThrow5)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow5);
                    i = columnIndexOrThrow;
                }
                Converters converters = Converters.INSTANCE;
                Map<String, String> fromStringToLocalizedTextV2 = converters.fromStringToLocalizedTextV2(string);
                Map<String, String> fromStringToLocalizedTextV22 = converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6));
                Map<String, String> fromStringToLocalizedTextV23 = converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7));
                String string20 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                String string21 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                String string22 = query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10);
                String string23 = query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11);
                String string24 = query.isNull(columnIndexOrThrow12) ? null : query.getString(columnIndexOrThrow12);
                if (query.isNull(columnIndexOrThrow13)) {
                    i2 = i17;
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow13);
                    i2 = i17;
                }
                if (query.isNull(i2)) {
                    i17 = i2;
                    i3 = columnIndexOrThrow15;
                    string3 = null;
                } else {
                    string3 = query.getString(i2);
                    i17 = i2;
                    i3 = columnIndexOrThrow15;
                }
                if (query.isNull(i3)) {
                    columnIndexOrThrow15 = i3;
                    i4 = columnIndexOrThrow16;
                    string4 = null;
                } else {
                    string4 = query.getString(i3);
                    columnIndexOrThrow15 = i3;
                    i4 = columnIndexOrThrow16;
                }
                if (query.isNull(i4)) {
                    columnIndexOrThrow16 = i4;
                    i5 = columnIndexOrThrow17;
                    string5 = null;
                } else {
                    string5 = query.getString(i4);
                    columnIndexOrThrow16 = i4;
                    i5 = columnIndexOrThrow17;
                }
                if (query.isNull(i5)) {
                    i6 = i5;
                    string6 = null;
                } else {
                    i6 = i5;
                    string6 = query.getString(i5);
                }
                Map<String, String> fromStringToLocalizedTextV24 = converters.fromStringToLocalizedTextV2(string6);
                int i18 = columnIndexOrThrow18;
                if (query.isNull(i18)) {
                    columnIndexOrThrow18 = i18;
                    i7 = columnIndexOrThrow19;
                    string7 = null;
                } else {
                    columnIndexOrThrow18 = i18;
                    string7 = query.getString(i18);
                    i7 = columnIndexOrThrow19;
                }
                if (query.isNull(i7)) {
                    columnIndexOrThrow19 = i7;
                    i8 = columnIndexOrThrow20;
                    string8 = null;
                } else {
                    columnIndexOrThrow19 = i7;
                    string8 = query.getString(i7);
                    i8 = columnIndexOrThrow20;
                }
                if (query.isNull(i8)) {
                    columnIndexOrThrow20 = i8;
                    i9 = columnIndexOrThrow21;
                    string9 = null;
                } else {
                    columnIndexOrThrow20 = i8;
                    string9 = query.getString(i8);
                    i9 = columnIndexOrThrow21;
                }
                if (query.isNull(i9)) {
                    columnIndexOrThrow21 = i9;
                    i10 = columnIndexOrThrow22;
                    string10 = null;
                } else {
                    columnIndexOrThrow21 = i9;
                    string10 = query.getString(i9);
                    i10 = columnIndexOrThrow22;
                }
                if (query.isNull(i10)) {
                    columnIndexOrThrow22 = i10;
                    string11 = null;
                } else {
                    columnIndexOrThrow22 = i10;
                    string11 = query.getString(i10);
                }
                List<String> fromStringToListString = converters.fromStringToListString(string11);
                int i19 = columnIndexOrThrow23;
                if (query.isNull(i19)) {
                    columnIndexOrThrow23 = i19;
                    i11 = columnIndexOrThrow24;
                    string12 = null;
                } else {
                    columnIndexOrThrow23 = i19;
                    string12 = query.getString(i19);
                    i11 = columnIndexOrThrow24;
                }
                if (query.isNull(i11)) {
                    columnIndexOrThrow24 = i11;
                    i12 = columnIndexOrThrow25;
                    string13 = null;
                } else {
                    columnIndexOrThrow24 = i11;
                    string13 = query.getString(i11);
                    i12 = columnIndexOrThrow25;
                }
                if (query.isNull(i12)) {
                    columnIndexOrThrow25 = i12;
                    i13 = columnIndexOrThrow26;
                    string14 = null;
                } else {
                    columnIndexOrThrow25 = i12;
                    string14 = query.getString(i12);
                    i13 = columnIndexOrThrow26;
                }
                if (query.isNull(i13)) {
                    columnIndexOrThrow26 = i13;
                    i14 = columnIndexOrThrow27;
                    string15 = null;
                } else {
                    columnIndexOrThrow26 = i13;
                    string15 = query.getString(i13);
                    i14 = columnIndexOrThrow27;
                }
                if (query.isNull(i14)) {
                    columnIndexOrThrow27 = i14;
                    i15 = columnIndexOrThrow28;
                    string16 = null;
                } else {
                    columnIndexOrThrow27 = i14;
                    string16 = query.getString(i14);
                    i15 = columnIndexOrThrow28;
                }
                if (query.isNull(i15)) {
                    columnIndexOrThrow28 = i15;
                    i16 = columnIndexOrThrow29;
                    string17 = null;
                } else {
                    columnIndexOrThrow28 = i15;
                    string17 = query.getString(i15);
                    i16 = columnIndexOrThrow29;
                }
                if (query.isNull(i16)) {
                    columnIndexOrThrow29 = i16;
                    string18 = null;
                } else {
                    columnIndexOrThrow29 = i16;
                    string18 = query.getString(i16);
                }
                List<String> fromStringToListString2 = converters.fromStringToListString(string18);
                int i20 = columnIndexOrThrow30;
                arrayList.add(new AppMetadata(j, string19, j2, j3, fromStringToLocalizedTextV2, fromStringToLocalizedTextV22, fromStringToLocalizedTextV23, string20, string21, string22, string23, string24, string2, string3, string4, string5, fromStringToLocalizedTextV24, string7, string8, string9, string10, fromStringToListString, string12, string13, string14, string15, string16, string17, fromStringToListString2, query.getInt(i20) != 0));
                columnIndexOrThrow30 = i20;
                columnIndexOrThrow = i;
                columnIndexOrThrow17 = i6;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public List<LocalizedFile> getLocalizedFiles(long j, String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM LocalizedFile\n        WHERE repoId = ? AND packageName = ?", 2);
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "packageName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, BonjourPeer.TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "locale");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "sha256");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "size");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "ipfsCidV1");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new LocalizedFile(query.getLong(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6), query.isNull(columnIndexOrThrow7) ? null : Long.valueOf(query.getLong(columnIndexOrThrow7)), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public AppOverviewItem getAppOverviewItem(long j, String str) {
        ArrayList arrayList;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT repoId, packageName, added, app.lastUpdated, localizedName,\n             localizedSummary, app.isCompatible\n        FROM AppMetadata AS app WHERE repoId = ? AND packageName = ?", 2);
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            AppOverviewItem appOverviewItem = null;
            String string = null;
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            ArrayMap arrayMap = new ArrayMap();
            while (query.moveToNext()) {
                String string2 = query.isNull(1) ? null : query.getString(1);
                if (string2 != null && !arrayMap.containsKey(string2)) {
                    arrayMap.put(string2, new ArrayList());
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
            if (query.moveToFirst()) {
                long j2 = query.getLong(0);
                String string3 = query.isNull(1) ? null : query.getString(1);
                long j3 = query.getLong(2);
                long j4 = query.getLong(3);
                String string4 = query.isNull(4) ? null : query.getString(4);
                String string5 = query.isNull(5) ? null : query.getString(5);
                boolean z = query.getInt(6) != 0;
                if (!query.isNull(1)) {
                    string = query.getString(1);
                }
                if (string != null) {
                    arrayList = (ArrayList) arrayMap.get(string);
                } else {
                    arrayList = new ArrayList();
                }
                appOverviewItem = new AppOverviewItem(j2, string3, j3, j4, string4, string5, null, arrayList, z);
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            return appOverviewItem;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItemsByName() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, localizedName, localizedSummary, app.lastUpdated, \n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        LEFT JOIN AppPrefs USING (packageName)\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        WHERE pref.enabled = 1 AND COALESCE(preferredRepoId, repoId) = repoId\n        GROUP BY packageName HAVING MAX(pref.weight)\n        ORDER BY localizedName COLLATE NOCASE ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, HighestVersion.TABLE, AppPrefs.TABLE, RepositoryPreferences.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.22
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j2 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j, string2, string3, string4, j2, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItemsByName(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, localizedName, localizedSummary, app.lastUpdated,\n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        LEFT JOIN AppPrefs USING (packageName)\n        WHERE pref.enabled = 1 AND categories LIKE '%,' || ? || ',%' AND\n           COALESCE(preferredRepoId, repoId) = repoId\n        GROUP BY packageName HAVING MAX(pref.weight)\n        ORDER BY localizedName COLLATE NOCASE ASC", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, RepositoryPreferences.TABLE, HighestVersion.TABLE, AppPrefs.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.23
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j2 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j, string2, string3, string4, j2, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItemsByName(long j) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, localizedName, localizedSummary, app.lastUpdated,\n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        WHERE repoId = ?\n        ORDER BY localizedName COLLATE NOCASE ASC", 1);
        acquire.bindLong(1, j);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, HighestVersion.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.24
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j2 = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j3 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j2, string2, string3, string4, j3, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItemsByLastUpdated() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, localizedName, localizedSummary, app.lastUpdated,\n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        LEFT JOIN AppPrefs USING (packageName)\n        WHERE pref.enabled = 1 AND COALESCE(preferredRepoId, repoId) = repoId\n        GROUP BY packageName HAVING MAX(pref.weight)\n        ORDER BY app.lastUpdated DESC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, RepositoryPreferences.TABLE, HighestVersion.TABLE, AppPrefs.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.25
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j2 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j, string2, string3, string4, j2, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItemsByLastUpdated(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, localizedName, localizedSummary, app.lastUpdated, \n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        LEFT JOIN AppPrefs USING (packageName)\n        WHERE pref.enabled = 1 AND categories LIKE '%,' || ? || ',%' AND\n           COALESCE(preferredRepoId, repoId) = repoId\n        GROUP BY packageName HAVING MAX(pref.weight)\n        ORDER BY app.lastUpdated DESC", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, RepositoryPreferences.TABLE, HighestVersion.TABLE, AppPrefs.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.26
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j2 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j, string2, string3, string4, j2, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public LiveData getAppListItemsByLastUpdated(long j) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("\n        SELECT repoId, packageName, localizedName, localizedSummary, app.lastUpdated, \n               version.antiFeatures, app.isCompatible, app.preferredSigner\n        FROM AppMetadata AS app\n        LEFT JOIN HighestVersion AS version USING (repoId, packageName)\n        WHERE repoId = ?\n        ORDER BY app.lastUpdated DESC", 1);
        acquire.bindLong(1, j);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{LocalizedIcon.TABLE, AppMetadata.TABLE, HighestVersion.TABLE}, true, new Callable() { // from class: org.fdroid.database.AppDaoInt_Impl.27
            @Override // java.util.concurrent.Callable
            public List call() {
                ArrayList arrayList;
                AppDaoInt_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(AppDaoInt_Impl.this.__db, acquire, true, null);
                    ArrayMap arrayMap = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.isNull(1) ? null : query.getString(1);
                        if (string != null && !arrayMap.containsKey(string)) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    AppDaoInt_Impl.this.__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
                    ArrayList arrayList2 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j2 = query.getLong(0);
                        String string2 = query.isNull(1) ? null : query.getString(1);
                        String string3 = query.isNull(2) ? null : query.getString(2);
                        String string4 = query.isNull(3) ? null : query.getString(3);
                        long j3 = query.getLong(4);
                        String string5 = query.isNull(5) ? null : query.getString(5);
                        boolean z = query.getInt(6) != 0;
                        String string6 = query.isNull(7) ? null : query.getString(7);
                        String string7 = query.isNull(1) ? null : query.getString(1);
                        if (string7 != null) {
                            arrayList = (ArrayList) arrayMap.get(string7);
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList2.add(new AppListItem(j2, string2, string3, string4, j3, string5, arrayList, z, string6, null, null));
                    }
                    AppDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList2;
                } finally {
                    AppDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.AppDaoInt
    public int countApps() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AppMetadata", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public int countLocalizedFiles() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM LocalizedFile", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.AppDaoInt
    public int countLocalizedFileLists() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM LocalizedFileList", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public LiveData getAppListItems(PackageManager packageManager, String str, AppListSortOrder appListSortOrder) {
        return AppDaoInt.DefaultImpls.getAppListItems(this, packageManager, str, appListSortOrder);
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public LiveData getAppListItems(PackageManager packageManager, String str, String str2, AppListSortOrder appListSortOrder) {
        return AppDaoInt.DefaultImpls.getAppListItems(this, packageManager, str, str2, appListSortOrder);
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public LiveData getAppListItems(PackageManager packageManager, long j, String str, AppListSortOrder appListSortOrder) {
        return AppDaoInt.DefaultImpls.getAppListItems(this, packageManager, j, str, appListSortOrder);
    }

    @Override // org.fdroid.database.AppDaoInt, org.fdroid.database.AppDao
    public LiveData getInstalledAppListItems(PackageManager packageManager) {
        return AppDaoInt.DefaultImpls.getInstalledAppListItems(this, packageManager);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile(ArrayMap arrayMap) {
        ArrayList arrayList;
        Set<String> keySet = arrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new Function1() { // from class: org.fdroid.database.AppDaoInt_Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile$0;
                    lambda$__fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile$0 = AppDaoInt_Impl.this.lambda$__fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile$0((ArrayMap) obj);
                    return lambda$__fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile$0;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`packageName`,`type`,`locale`,`name`,`sha256`,`size`,`ipfsCidV1` FROM `LocalizedFile` WHERE `packageName` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (String str : keySet) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "packageName");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                String string = query.isNull(columnIndex) ? null : query.getString(columnIndex);
                if (string != null && (arrayList = (ArrayList) arrayMap.get(string)) != null) {
                    arrayList.add(new LocalizedFile(query.getLong(0), query.isNull(1) ? null : query.getString(1), query.isNull(2) ? null : query.getString(2), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : query.getString(5), query.isNull(6) ? null : Long.valueOf(query.getLong(6)), query.isNull(7) ? null : query.getString(7)));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile$0(ArrayMap arrayMap) {
        __fetchRelationshipLocalizedFileAsorgFdroidDatabaseLocalizedFile(arrayMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList(ArrayMap arrayMap) {
        ArrayList arrayList;
        Set<String> keySet = arrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new Function1() { // from class: org.fdroid.database.AppDaoInt_Impl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList$1;
                    lambda$__fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList$1 = AppDaoInt_Impl.this.lambda$__fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList$1((ArrayMap) obj);
                    return lambda$__fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList$1;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`packageName`,`type`,`locale`,`name`,`sha256`,`size`,`ipfsCidV1` FROM `LocalizedFileList` WHERE `packageName` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (String str : keySet) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "packageName");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                String string = query.isNull(columnIndex) ? null : query.getString(columnIndex);
                if (string != null && (arrayList = (ArrayList) arrayMap.get(string)) != null) {
                    arrayList.add(new LocalizedFileList(query.getLong(0), query.isNull(1) ? null : query.getString(1), query.isNull(2) ? null : query.getString(2), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : query.getString(5), query.isNull(6) ? null : Long.valueOf(query.getLong(6)), query.isNull(7) ? null : query.getString(7)));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList$1(ArrayMap arrayMap) {
        __fetchRelationshipLocalizedFileListAsorgFdroidDatabaseLocalizedFileList(arrayMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(ArrayMap arrayMap) {
        ArrayList arrayList;
        Set<String> keySet = arrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new Function1() { // from class: org.fdroid.database.AppDaoInt_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon$2;
                    lambda$__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon$2 = AppDaoInt_Impl.this.lambda$__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon$2((ArrayMap) obj);
                    return lambda$__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon$2;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`packageName`,`type`,`locale`,`name`,`sha256`,`size`,`ipfsCidV1` FROM `LocalizedIcon` WHERE `packageName` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (String str : keySet) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "packageName");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                String string = query.isNull(columnIndex) ? null : query.getString(columnIndex);
                if (string != null && (arrayList = (ArrayList) arrayMap.get(string)) != null) {
                    arrayList.add(new LocalizedIcon(query.getLong(0), query.isNull(1) ? null : query.getString(1), query.isNull(2) ? null : query.getString(2), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : query.getString(5), query.isNull(6) ? null : Long.valueOf(query.getLong(6)), query.isNull(7) ? null : query.getString(7)));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon$2(ArrayMap arrayMap) {
        __fetchRelationshipLocalizedIconAsorgFdroidDatabaseLocalizedIcon(arrayMap);
        return Unit.INSTANCE;
    }
}
