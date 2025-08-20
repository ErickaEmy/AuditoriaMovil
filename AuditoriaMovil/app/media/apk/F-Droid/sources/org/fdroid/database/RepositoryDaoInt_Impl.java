package org.fdroid.database;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
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
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.JsonObject;
import org.fdroid.database.RepositoryDaoInt;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.v2.RepoV2;
/* loaded from: classes2.dex */
public final class RepositoryDaoInt_Impl implements RepositoryDaoInt {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfAntiFeature;
    private final EntityInsertionAdapter __insertionAdapterOfCategory;
    private final EntityInsertionAdapter __insertionAdapterOfCoreRepository;
    private final EntityInsertionAdapter __insertionAdapterOfMirror;
    private final EntityInsertionAdapter __insertionAdapterOfReleaseChannel;
    private final EntityInsertionAdapter __insertionAdapterOfRepositoryPreferences;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllCoreRepositories;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllRepositoryPreferences;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAntiFeature;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAntiFeatures;
    private final SharedSQLiteStatement __preparedStmtOfDeleteCategories;
    private final SharedSQLiteStatement __preparedStmtOfDeleteCategory;
    private final SharedSQLiteStatement __preparedStmtOfDeleteCoreRepository;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMirrors;
    private final SharedSQLiteStatement __preparedStmtOfDeleteReleaseChannel;
    private final SharedSQLiteStatement __preparedStmtOfDeleteReleaseChannels;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRepositoryPreferences;
    private final SharedSQLiteStatement __preparedStmtOfResetETags;
    private final SharedSQLiteStatement __preparedStmtOfResetPreferredRepoInAppPrefs;
    private final SharedSQLiteStatement __preparedStmtOfResetTimestamps;
    private final SharedSQLiteStatement __preparedStmtOfSetRepositoryEnabledInternal;
    private final SharedSQLiteStatement __preparedStmtOfSetWeight;
    private final SharedSQLiteStatement __preparedStmtOfShiftRepoWeights;
    private final SharedSQLiteStatement __preparedStmtOfUpdateDisabledMirrors;
    private final SharedSQLiteStatement __preparedStmtOfUpdateUserMirrors;
    private final SharedSQLiteStatement __preparedStmtOfUpdateUsernameAndPassword;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfCoreRepository;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfRepositoryPreferences;

    public RepositoryDaoInt_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRepositoryPreferences = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `RepositoryPreferences` (`repoId`,`weight`,`enabled`,`lastUpdated`,`lastETag`,`userMirrors`,`disabledMirrors`,`username`,`password`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RepositoryPreferences repositoryPreferences) {
                supportSQLiteStatement.bindLong(1, repositoryPreferences.getRepoId$database_release());
                supportSQLiteStatement.bindLong(2, repositoryPreferences.getWeight());
                supportSQLiteStatement.bindLong(3, repositoryPreferences.getEnabled() ? 1L : 0L);
                if (repositoryPreferences.getLastUpdated() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, repositoryPreferences.getLastUpdated().longValue());
                }
                if (repositoryPreferences.getLastETag() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, repositoryPreferences.getLastETag());
                }
                Converters converters = Converters.INSTANCE;
                String listStringToString = converters.listStringToString(repositoryPreferences.getUserMirrors());
                if (listStringToString == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, listStringToString);
                }
                String listStringToString2 = converters.listStringToString(repositoryPreferences.getDisabledMirrors());
                if (listStringToString2 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, listStringToString2);
                }
                if (repositoryPreferences.getUsername() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, repositoryPreferences.getUsername());
                }
                if (repositoryPreferences.getPassword() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, repositoryPreferences.getPassword());
                }
            }
        };
        this.__insertionAdapterOfCoreRepository = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `CoreRepository` (`repoId`,`name`,`icon`,`address`,`webBaseUrl`,`timestamp`,`version`,`formatVersion`,`maxAge`,`description`,`certificate`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CoreRepository coreRepository) {
                supportSQLiteStatement.bindLong(1, coreRepository.getRepoId());
                Converters converters = Converters.INSTANCE;
                String localizedTextV2toString = converters.localizedTextV2toString(coreRepository.getName());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, localizedTextV2toString);
                }
                String localizedFileV2toString = converters.localizedFileV2toString(coreRepository.getIcon());
                if (localizedFileV2toString == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, localizedFileV2toString);
                }
                if (coreRepository.getAddress() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, coreRepository.getAddress());
                }
                if (coreRepository.getWebBaseUrl() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, coreRepository.getWebBaseUrl());
                }
                supportSQLiteStatement.bindLong(6, coreRepository.getTimestamp());
                if (coreRepository.getVersion() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, coreRepository.getVersion().longValue());
                }
                if (coreRepository.getFormatVersion() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, RepositoryDaoInt_Impl.this.__IndexFormatVersion_enumToString(coreRepository.getFormatVersion()));
                }
                if (coreRepository.getMaxAge() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, coreRepository.getMaxAge().intValue());
                }
                String localizedTextV2toString2 = converters.localizedTextV2toString(coreRepository.getDescription());
                if (localizedTextV2toString2 == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, localizedTextV2toString2);
                }
                if (coreRepository.getCertificate() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, coreRepository.getCertificate());
                }
            }
        };
        this.__insertionAdapterOfMirror = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `Mirror` (`repoId`,`url`,`location`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Mirror mirror) {
                supportSQLiteStatement.bindLong(1, mirror.getRepoId());
                if (mirror.getUrl() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, mirror.getUrl());
                }
                if (mirror.getLocation() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, mirror.getLocation());
                }
            }
        };
        this.__insertionAdapterOfAntiFeature = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `AntiFeature` (`repoId`,`id`,`icon`,`name`,`description`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AntiFeature antiFeature) {
                supportSQLiteStatement.bindLong(1, antiFeature.getRepoId$database_release());
                if (antiFeature.getId$database_release() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, antiFeature.getId$database_release());
                }
                Converters converters = Converters.INSTANCE;
                String localizedFileV2toString = converters.localizedFileV2toString(antiFeature.getIcon());
                if (localizedFileV2toString == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, localizedFileV2toString);
                }
                String localizedTextV2toString = converters.localizedTextV2toString(antiFeature.getName$database_release());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, localizedTextV2toString);
                }
                String localizedTextV2toString2 = converters.localizedTextV2toString(antiFeature.getDescription$database_release());
                if (localizedTextV2toString2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, localizedTextV2toString2);
                }
            }
        };
        this.__insertionAdapterOfCategory = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `Category` (`repoId`,`id`,`icon`,`name`,`description`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Category category) {
                supportSQLiteStatement.bindLong(1, category.getRepoId());
                if (category.getId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, category.getId());
                }
                Converters converters = Converters.INSTANCE;
                String localizedFileV2toString = converters.localizedFileV2toString(category.getIcon());
                if (localizedFileV2toString == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, localizedFileV2toString);
                }
                String localizedTextV2toString = converters.localizedTextV2toString(category.getName$database_release());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, localizedTextV2toString);
                }
                String localizedTextV2toString2 = converters.localizedTextV2toString(category.getDescription$database_release());
                if (localizedTextV2toString2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, localizedTextV2toString2);
                }
            }
        };
        this.__insertionAdapterOfReleaseChannel = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ReleaseChannel` (`repoId`,`id`,`icon`,`name`,`description`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ReleaseChannel releaseChannel) {
                supportSQLiteStatement.bindLong(1, releaseChannel.getRepoId$database_release());
                if (releaseChannel.getId$database_release() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, releaseChannel.getId$database_release());
                }
                Converters converters = Converters.INSTANCE;
                String localizedFileV2toString = converters.localizedFileV2toString(releaseChannel.getIcon());
                if (localizedFileV2toString == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, localizedFileV2toString);
                }
                String localizedTextV2toString = converters.localizedTextV2toString(releaseChannel.getName$database_release());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, localizedTextV2toString);
                }
                String localizedTextV2toString2 = converters.localizedTextV2toString(releaseChannel.getDescription$database_release());
                if (localizedTextV2toString2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, localizedTextV2toString2);
                }
            }
        };
        this.__updateAdapterOfCoreRepository = new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `CoreRepository` SET `repoId` = ?,`name` = ?,`icon` = ?,`address` = ?,`webBaseUrl` = ?,`timestamp` = ?,`version` = ?,`formatVersion` = ?,`maxAge` = ?,`description` = ?,`certificate` = ? WHERE `repoId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CoreRepository coreRepository) {
                supportSQLiteStatement.bindLong(1, coreRepository.getRepoId());
                Converters converters = Converters.INSTANCE;
                String localizedTextV2toString = converters.localizedTextV2toString(coreRepository.getName());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, localizedTextV2toString);
                }
                String localizedFileV2toString = converters.localizedFileV2toString(coreRepository.getIcon());
                if (localizedFileV2toString == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, localizedFileV2toString);
                }
                if (coreRepository.getAddress() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, coreRepository.getAddress());
                }
                if (coreRepository.getWebBaseUrl() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, coreRepository.getWebBaseUrl());
                }
                supportSQLiteStatement.bindLong(6, coreRepository.getTimestamp());
                if (coreRepository.getVersion() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, coreRepository.getVersion().longValue());
                }
                if (coreRepository.getFormatVersion() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, RepositoryDaoInt_Impl.this.__IndexFormatVersion_enumToString(coreRepository.getFormatVersion()));
                }
                if (coreRepository.getMaxAge() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, coreRepository.getMaxAge().intValue());
                }
                String localizedTextV2toString2 = converters.localizedTextV2toString(coreRepository.getDescription());
                if (localizedTextV2toString2 == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, localizedTextV2toString2);
                }
                if (coreRepository.getCertificate() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, coreRepository.getCertificate());
                }
                supportSQLiteStatement.bindLong(12, coreRepository.getRepoId());
            }
        };
        this.__updateAdapterOfRepositoryPreferences = new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `RepositoryPreferences` SET `repoId` = ?,`weight` = ?,`enabled` = ?,`lastUpdated` = ?,`lastETag` = ?,`userMirrors` = ?,`disabledMirrors` = ?,`username` = ?,`password` = ? WHERE `repoId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RepositoryPreferences repositoryPreferences) {
                supportSQLiteStatement.bindLong(1, repositoryPreferences.getRepoId$database_release());
                supportSQLiteStatement.bindLong(2, repositoryPreferences.getWeight());
                supportSQLiteStatement.bindLong(3, repositoryPreferences.getEnabled() ? 1L : 0L);
                if (repositoryPreferences.getLastUpdated() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, repositoryPreferences.getLastUpdated().longValue());
                }
                if (repositoryPreferences.getLastETag() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, repositoryPreferences.getLastETag());
                }
                Converters converters = Converters.INSTANCE;
                String listStringToString = converters.listStringToString(repositoryPreferences.getUserMirrors());
                if (listStringToString == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, listStringToString);
                }
                String listStringToString2 = converters.listStringToString(repositoryPreferences.getDisabledMirrors());
                if (listStringToString2 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, listStringToString2);
                }
                if (repositoryPreferences.getUsername() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, repositoryPreferences.getUsername());
                }
                if (repositoryPreferences.getPassword() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, repositoryPreferences.getPassword());
                }
                supportSQLiteStatement.bindLong(10, repositoryPreferences.getRepoId$database_release());
            }
        };
        this.__preparedStmtOfUpdateUserMirrors = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE RepositoryPreferences SET userMirrors = ?\n        WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfUpdateUsernameAndPassword = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE RepositoryPreferences SET username = ?, password = ?\n        WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfUpdateDisabledMirrors = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE RepositoryPreferences SET disabledMirrors = ?\n        WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfSetRepositoryEnabledInternal = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE RepositoryPreferences SET enabled = ? WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfResetPreferredRepoInAppPrefs = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE AppPrefs SET preferredRepoId = NULL WHERE preferredRepoId = ?";
            }
        };
        this.__preparedStmtOfSetWeight = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE RepositoryPreferences SET weight = ? WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfShiftRepoWeights = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE RepositoryPreferences SET weight = weight + ?\n        WHERE weight >= ? AND weight <= ?";
            }
        };
        this.__preparedStmtOfDeleteCoreRepository = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM CoreRepository WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfDeleteRepositoryPreferences = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM RepositoryPreferences WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfDeleteAllCoreRepositories = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.18
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM CoreRepository";
            }
        };
        this.__preparedStmtOfDeleteAllRepositoryPreferences = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.19
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM RepositoryPreferences";
            }
        };
        this.__preparedStmtOfDeleteMirrors = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.20
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM Mirror WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfDeleteAntiFeatures = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.21
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM AntiFeature WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfDeleteAntiFeature = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.22
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM AntiFeature WHERE repoId = ? AND id = ?";
            }
        };
        this.__preparedStmtOfDeleteCategories = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.23
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM Category WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfDeleteCategory = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.24
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM Category WHERE repoId = ? AND id = ?";
            }
        };
        this.__preparedStmtOfDeleteReleaseChannels = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.25
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ReleaseChannel WHERE repoId = ?";
            }
        };
        this.__preparedStmtOfDeleteReleaseChannel = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.26
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ReleaseChannel WHERE repoId = ? AND id = ?";
            }
        };
        this.__preparedStmtOfResetTimestamps = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.27
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE CoreRepository SET timestamp = -1";
            }
        };
        this.__preparedStmtOfResetETags = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.RepositoryDaoInt_Impl.28
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE RepositoryPreferences SET lastETag = NULL";
            }
        };
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void insert(RepositoryPreferences repositoryPreferences) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRepositoryPreferences.insert(repositoryPreferences);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public long insertOrReplace(CoreRepository coreRepository) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfCoreRepository.insertAndReturnId(coreRepository);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void insertMirrors(List<Mirror> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMirror.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void insertAntiFeatures(List<AntiFeature> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAntiFeature.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void insertCategories(List<Category> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCategory.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void insertReleaseChannels(List<ReleaseChannel> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfReleaseChannel.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void update(CoreRepository coreRepository) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfCoreRepository.handle(coreRepository);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public int updateRepository(CoreRepository coreRepository) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handle = this.__updateAdapterOfCoreRepository.handle(coreRepository);
            this.__db.setTransactionSuccessful();
            return handle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void updateRepositoryPreferences(RepositoryPreferences repositoryPreferences) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRepositoryPreferences.handle(repositoryPreferences);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public long insert(InitialRepository initialRepository) {
        this.__db.beginTransaction();
        try {
            long insert = RepositoryDaoInt.DefaultImpls.insert(this, initialRepository);
            this.__db.setTransactionSuccessful();
            return insert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public long insert(NewRepository newRepository) {
        this.__db.beginTransaction();
        try {
            long insert = RepositoryDaoInt.DefaultImpls.insert(this, newRepository);
            this.__db.setTransactionSuccessful();
            return insert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public void setRepositoryEnabled(long j, boolean z) {
        this.__db.beginTransaction();
        try {
            RepositoryDaoInt.DefaultImpls.setRepositoryEnabled(this, j, z);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public void deleteRepository(long j) {
        this.__db.beginTransaction();
        try {
            RepositoryDaoInt.DefaultImpls.deleteRepository(this, j);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public void clearAll() {
        this.__db.beginTransaction();
        try {
            RepositoryDaoInt.DefaultImpls.clearAll(this);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public long insertOrReplace(RepoV2 repoV2, long j) {
        this.__db.beginTransaction();
        try {
            long insertOrReplace = RepositoryDaoInt.DefaultImpls.insertOrReplace(this, repoV2, j);
            this.__db.setTransactionSuccessful();
            return insertOrReplace;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void update(long j, RepoV2 repoV2, long j2, IndexFormatVersion indexFormatVersion) {
        this.__db.beginTransaction();
        try {
            RepositoryDaoInt.DefaultImpls.update(this, j, repoV2, j2, indexFormatVersion);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public long insertEmptyRepo(String str, String str2, String str3, String str4) {
        this.__db.beginTransaction();
        try {
            long insertEmptyRepo = RepositoryDaoInt.DefaultImpls.insertEmptyRepo(this, str, str2, str3, str4);
            this.__db.setTransactionSuccessful();
            return insertEmptyRepo;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void updateRepository(long j, long j2, JsonObject jsonObject) {
        this.__db.beginTransaction();
        try {
            RepositoryDaoInt.DefaultImpls.updateRepository(this, j, j2, jsonObject);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void reorderRepositories(Repository repository, Repository repository2) {
        this.__db.beginTransaction();
        try {
            RepositoryDaoInt.DefaultImpls.reorderRepositories(this, repository, repository2);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void clear(long j) {
        this.__db.beginTransaction();
        try {
            RepositoryDaoInt.DefaultImpls.clear(this, j);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public void updateUserMirrors(long j, List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateUserMirrors.acquire();
        String listStringToString = Converters.INSTANCE.listStringToString(list);
        if (listStringToString == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, listStringToString);
        }
        acquire.bindLong(2, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfUpdateUserMirrors.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public void updateUsernameAndPassword(long j, String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateUsernameAndPassword.acquire();
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
        acquire.bindLong(3, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfUpdateUsernameAndPassword.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public void updateDisabledMirrors(long j, List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateDisabledMirrors.acquire();
        String listStringToString = Converters.INSTANCE.listStringToString(list);
        if (listStringToString == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, listStringToString);
        }
        acquire.bindLong(2, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfUpdateDisabledMirrors.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void setRepositoryEnabledInternal(long j, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetRepositoryEnabledInternal.acquire();
        acquire.bindLong(1, z ? 1L : 0L);
        acquire.bindLong(2, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfSetRepositoryEnabledInternal.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void resetPreferredRepoInAppPrefs(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetPreferredRepoInAppPrefs.acquire();
        acquire.bindLong(1, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfResetPreferredRepoInAppPrefs.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void setWeight(long j, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetWeight.acquire();
        acquire.bindLong(1, i);
        acquire.bindLong(2, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfSetWeight.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void shiftRepoWeights(int i, int i2, int i3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfShiftRepoWeights.acquire();
        acquire.bindLong(1, i3);
        acquire.bindLong(2, i);
        acquire.bindLong(3, i2);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfShiftRepoWeights.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteCoreRepository(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteCoreRepository.acquire();
        acquire.bindLong(1, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteCoreRepository.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteRepositoryPreferences(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteRepositoryPreferences.acquire();
        acquire.bindLong(1, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteRepositoryPreferences.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteAllCoreRepositories() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllCoreRepositories.acquire();
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteAllCoreRepositories.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteAllRepositoryPreferences() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllRepositoryPreferences.acquire();
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteAllRepositoryPreferences.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteMirrors(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteMirrors.acquire();
        acquire.bindLong(1, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteMirrors.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteAntiFeatures(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAntiFeatures.acquire();
        acquire.bindLong(1, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteAntiFeatures.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteAntiFeature(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAntiFeature.acquire();
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
            this.__preparedStmtOfDeleteAntiFeature.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteCategories(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteCategories.acquire();
        acquire.bindLong(1, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteCategories.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteCategory(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteCategory.acquire();
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
            this.__preparedStmtOfDeleteCategory.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteReleaseChannels(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteReleaseChannels.acquire();
        acquire.bindLong(1, j);
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteReleaseChannels.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void deleteReleaseChannel(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteReleaseChannel.acquire();
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
            this.__preparedStmtOfDeleteReleaseChannel.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void resetTimestamps() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetTimestamps.acquire();
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfResetTimestamps.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public void resetETags() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetETags.acquire();
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfResetETags.release(acquire);
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public Repository getRepository(long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        Repository repository;
        int i;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM CoreRepository WHERE repoId = ?", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "icon");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "address");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "webBaseUrl");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "version");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "formatVersion");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "maxAge");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "description");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "certificate");
                LongSparseArray longSparseArray = new LongSparseArray();
                LongSparseArray longSparseArray2 = new LongSparseArray();
                roomSQLiteQuery = acquire;
                try {
                    LongSparseArray longSparseArray3 = new LongSparseArray();
                    LongSparseArray longSparseArray4 = new LongSparseArray();
                    LongSparseArray longSparseArray5 = new LongSparseArray();
                    while (query.moveToNext()) {
                        int i2 = columnIndexOrThrow8;
                        int i3 = columnIndexOrThrow9;
                        long j2 = query.getLong(columnIndexOrThrow);
                        if (longSparseArray.containsKey(j2)) {
                            i = columnIndexOrThrow7;
                        } else {
                            i = columnIndexOrThrow7;
                            longSparseArray.put(j2, new ArrayList());
                        }
                        long j3 = query.getLong(columnIndexOrThrow);
                        if (!longSparseArray2.containsKey(j3)) {
                            longSparseArray2.put(j3, new ArrayList());
                        }
                        long j4 = query.getLong(columnIndexOrThrow);
                        if (!longSparseArray3.containsKey(j4)) {
                            longSparseArray3.put(j4, new ArrayList());
                        }
                        long j5 = query.getLong(columnIndexOrThrow);
                        if (!longSparseArray4.containsKey(j5)) {
                            longSparseArray4.put(j5, new ArrayList());
                        }
                        longSparseArray5.put(query.getLong(columnIndexOrThrow), null);
                        columnIndexOrThrow8 = i2;
                        columnIndexOrThrow9 = i3;
                        columnIndexOrThrow7 = i;
                    }
                    int i4 = columnIndexOrThrow7;
                    int i5 = columnIndexOrThrow8;
                    int i6 = columnIndexOrThrow9;
                    query.moveToPosition(-1);
                    __fetchRelationshipMirrorAsorgFdroidDatabaseMirror(longSparseArray);
                    __fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature(longSparseArray2);
                    __fetchRelationshipCategoryAsorgFdroidDatabaseCategory(longSparseArray3);
                    __fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel(longSparseArray4);
                    __fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences(longSparseArray5);
                    if (query.moveToFirst()) {
                        long j6 = query.getLong(columnIndexOrThrow);
                        String string = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        Converters converters = Converters.INSTANCE;
                        repository = new Repository(new CoreRepository(j6, converters.fromStringToLocalizedTextV2(string), converters.fromStringToLocalizedFileV2(query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3)), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), query.isNull(i4) ? null : Long.valueOf(query.getLong(i4)), query.isNull(i5) ? null : __IndexFormatVersion_stringToEnum(query.getString(i5)), query.isNull(i6) ? null : Integer.valueOf(query.getInt(i6)), converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10)), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11)), (ArrayList) longSparseArray.get(query.getLong(columnIndexOrThrow)), (ArrayList) longSparseArray2.get(query.getLong(columnIndexOrThrow)), (ArrayList) longSparseArray3.get(query.getLong(columnIndexOrThrow)), (ArrayList) longSparseArray4.get(query.getLong(columnIndexOrThrow)), (RepositoryPreferences) longSparseArray5.get(query.getLong(columnIndexOrThrow)));
                    } else {
                        repository = null;
                    }
                    this.__db.setTransactionSuccessful();
                    query.close();
                    roomSQLiteQuery.release();
                    return repository;
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

    @Override // org.fdroid.database.RepositoryDaoInt
    public Repository getRepository(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        Repository repository;
        int i;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM CoreRepository\n        WHERE certificate = ? AND address NOT LIKE \"%/archive\" COLLATE NOCASE\n        LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "icon");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "address");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "webBaseUrl");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "version");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "formatVersion");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "maxAge");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "description");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "certificate");
                LongSparseArray longSparseArray = new LongSparseArray();
                LongSparseArray longSparseArray2 = new LongSparseArray();
                roomSQLiteQuery = acquire;
                try {
                    LongSparseArray longSparseArray3 = new LongSparseArray();
                    LongSparseArray longSparseArray4 = new LongSparseArray();
                    LongSparseArray longSparseArray5 = new LongSparseArray();
                    while (query.moveToNext()) {
                        int i2 = columnIndexOrThrow8;
                        int i3 = columnIndexOrThrow9;
                        long j = query.getLong(columnIndexOrThrow);
                        if (longSparseArray.containsKey(j)) {
                            i = columnIndexOrThrow7;
                        } else {
                            i = columnIndexOrThrow7;
                            longSparseArray.put(j, new ArrayList());
                        }
                        long j2 = query.getLong(columnIndexOrThrow);
                        if (!longSparseArray2.containsKey(j2)) {
                            longSparseArray2.put(j2, new ArrayList());
                        }
                        long j3 = query.getLong(columnIndexOrThrow);
                        if (!longSparseArray3.containsKey(j3)) {
                            longSparseArray3.put(j3, new ArrayList());
                        }
                        long j4 = query.getLong(columnIndexOrThrow);
                        if (!longSparseArray4.containsKey(j4)) {
                            longSparseArray4.put(j4, new ArrayList());
                        }
                        longSparseArray5.put(query.getLong(columnIndexOrThrow), null);
                        columnIndexOrThrow8 = i2;
                        columnIndexOrThrow9 = i3;
                        columnIndexOrThrow7 = i;
                    }
                    int i4 = columnIndexOrThrow7;
                    int i5 = columnIndexOrThrow8;
                    int i6 = columnIndexOrThrow9;
                    query.moveToPosition(-1);
                    __fetchRelationshipMirrorAsorgFdroidDatabaseMirror(longSparseArray);
                    __fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature(longSparseArray2);
                    __fetchRelationshipCategoryAsorgFdroidDatabaseCategory(longSparseArray3);
                    __fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel(longSparseArray4);
                    __fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences(longSparseArray5);
                    if (query.moveToFirst()) {
                        long j5 = query.getLong(columnIndexOrThrow);
                        String string = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        Converters converters = Converters.INSTANCE;
                        repository = new Repository(new CoreRepository(j5, converters.fromStringToLocalizedTextV2(string), converters.fromStringToLocalizedFileV2(query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3)), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.getLong(columnIndexOrThrow6), query.isNull(i4) ? null : Long.valueOf(query.getLong(i4)), query.isNull(i5) ? null : __IndexFormatVersion_stringToEnum(query.getString(i5)), query.isNull(i6) ? null : Integer.valueOf(query.getInt(i6)), converters.fromStringToLocalizedTextV2(query.isNull(columnIndexOrThrow10) ? null : query.getString(columnIndexOrThrow10)), query.isNull(columnIndexOrThrow11) ? null : query.getString(columnIndexOrThrow11)), (ArrayList) longSparseArray.get(query.getLong(columnIndexOrThrow)), (ArrayList) longSparseArray2.get(query.getLong(columnIndexOrThrow)), (ArrayList) longSparseArray3.get(query.getLong(columnIndexOrThrow)), (ArrayList) longSparseArray4.get(query.getLong(columnIndexOrThrow)), (RepositoryPreferences) longSparseArray5.get(query.getLong(columnIndexOrThrow)));
                    } else {
                        repository = null;
                    }
                    this.__db.setTransactionSuccessful();
                    query.close();
                    roomSQLiteQuery.release();
                    return repository;
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

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public List<Repository> getRepositories() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `repoId`, `name`, `icon`, `address`, `webBaseUrl`, `timestamp`, `version`, `formatVersion`, `maxAge`, `description`, `certificate` FROM (SELECT * FROM CoreRepository\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        ORDER BY pref.weight DESC)", 0);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            LongSparseArray longSparseArray = new LongSparseArray();
            LongSparseArray longSparseArray2 = new LongSparseArray();
            LongSparseArray longSparseArray3 = new LongSparseArray();
            LongSparseArray longSparseArray4 = new LongSparseArray();
            LongSparseArray longSparseArray5 = new LongSparseArray();
            while (query.moveToNext()) {
                long j = query.getLong(0);
                if (!longSparseArray.containsKey(j)) {
                    longSparseArray.put(j, new ArrayList());
                }
                long j2 = query.getLong(0);
                if (!longSparseArray2.containsKey(j2)) {
                    longSparseArray2.put(j2, new ArrayList());
                }
                long j3 = query.getLong(0);
                if (!longSparseArray3.containsKey(j3)) {
                    longSparseArray3.put(j3, new ArrayList());
                }
                long j4 = query.getLong(0);
                if (!longSparseArray4.containsKey(j4)) {
                    longSparseArray4.put(j4, new ArrayList());
                }
                longSparseArray5.put(query.getLong(0), null);
            }
            query.moveToPosition(-1);
            __fetchRelationshipMirrorAsorgFdroidDatabaseMirror(longSparseArray);
            __fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature(longSparseArray2);
            __fetchRelationshipCategoryAsorgFdroidDatabaseCategory(longSparseArray3);
            __fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel(longSparseArray4);
            __fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences(longSparseArray5);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j5 = query.getLong(0);
                String string = query.isNull(1) ? null : query.getString(1);
                Converters converters = Converters.INSTANCE;
                arrayList.add(new Repository(new CoreRepository(j5, converters.fromStringToLocalizedTextV2(string), converters.fromStringToLocalizedFileV2(query.isNull(2) ? null : query.getString(2)), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.getLong(5), query.isNull(6) ? null : Long.valueOf(query.getLong(6)), query.isNull(7) ? null : __IndexFormatVersion_stringToEnum(query.getString(7)), query.isNull(8) ? null : Integer.valueOf(query.getInt(8)), converters.fromStringToLocalizedTextV2(query.isNull(9) ? null : query.getString(9)), query.isNull(10) ? null : query.getString(10)), (ArrayList) longSparseArray.get(query.getLong(0)), (ArrayList) longSparseArray2.get(query.getLong(0)), (ArrayList) longSparseArray3.get(query.getLong(0)), (ArrayList) longSparseArray4.get(query.getLong(0)), (RepositoryPreferences) longSparseArray5.get(query.getLong(0))));
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            return arrayList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public LiveData getLiveRepositories() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `repoId`, `name`, `icon`, `address`, `webBaseUrl`, `timestamp`, `version`, `formatVersion`, `maxAge`, `description`, `certificate` FROM (SELECT * FROM CoreRepository\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        ORDER BY pref.weight DESC)", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{Mirror.TABLE, AntiFeature.TABLE, Category.TABLE, ReleaseChannel.TABLE, RepositoryPreferences.TABLE, CoreRepository.TABLE}, true, new Callable() { // from class: org.fdroid.database.RepositoryDaoInt_Impl.29
            @Override // java.util.concurrent.Callable
            public List call() {
                RepositoryDaoInt_Impl.this.__db.beginTransaction();
                try {
                    int i = 1;
                    Cursor query = DBUtil.query(RepositoryDaoInt_Impl.this.__db, acquire, true, null);
                    LongSparseArray longSparseArray = new LongSparseArray();
                    LongSparseArray longSparseArray2 = new LongSparseArray();
                    LongSparseArray longSparseArray3 = new LongSparseArray();
                    LongSparseArray longSparseArray4 = new LongSparseArray();
                    LongSparseArray longSparseArray5 = new LongSparseArray();
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        if (!longSparseArray.containsKey(j)) {
                            longSparseArray.put(j, new ArrayList());
                        }
                        long j2 = query.getLong(0);
                        if (!longSparseArray2.containsKey(j2)) {
                            longSparseArray2.put(j2, new ArrayList());
                        }
                        long j3 = query.getLong(0);
                        if (!longSparseArray3.containsKey(j3)) {
                            longSparseArray3.put(j3, new ArrayList());
                        }
                        long j4 = query.getLong(0);
                        if (!longSparseArray4.containsKey(j4)) {
                            longSparseArray4.put(j4, new ArrayList());
                        }
                        longSparseArray5.put(query.getLong(0), null);
                    }
                    query.moveToPosition(-1);
                    RepositoryDaoInt_Impl.this.__fetchRelationshipMirrorAsorgFdroidDatabaseMirror(longSparseArray);
                    RepositoryDaoInt_Impl.this.__fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature(longSparseArray2);
                    RepositoryDaoInt_Impl.this.__fetchRelationshipCategoryAsorgFdroidDatabaseCategory(longSparseArray3);
                    RepositoryDaoInt_Impl.this.__fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel(longSparseArray4);
                    RepositoryDaoInt_Impl.this.__fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences(longSparseArray5);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j5 = query.getLong(0);
                        String string = query.isNull(i) ? null : query.getString(i);
                        Converters converters = Converters.INSTANCE;
                        arrayList.add(new Repository(new CoreRepository(j5, converters.fromStringToLocalizedTextV2(string), converters.fromStringToLocalizedFileV2(query.isNull(2) ? null : query.getString(2)), query.isNull(3) ? null : query.getString(3), query.isNull(4) ? null : query.getString(4), query.getLong(5), query.isNull(6) ? null : Long.valueOf(query.getLong(6)), query.isNull(7) ? null : RepositoryDaoInt_Impl.this.__IndexFormatVersion_stringToEnum(query.getString(7)), query.isNull(8) ? null : Integer.valueOf(query.getInt(8)), converters.fromStringToLocalizedTextV2(query.isNull(9) ? null : query.getString(9)), query.isNull(10) ? null : query.getString(10)), (ArrayList) longSparseArray.get(query.getLong(0)), (ArrayList) longSparseArray2.get(query.getLong(0)), (ArrayList) longSparseArray3.get(query.getLong(0)), (ArrayList) longSparseArray4.get(query.getLong(0)), (RepositoryPreferences) longSparseArray5.get(query.getLong(0))));
                        i = 1;
                    }
                    RepositoryDaoInt_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    return arrayList;
                } finally {
                    RepositoryDaoInt_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.RepositoryDaoInt, org.fdroid.database.RepositoryDao
    public LiveData getLiveCategories() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `repoId`, `id`, `icon`, `name`, `description` FROM (SELECT * FROM Category\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        WHERE pref.enabled = 1 GROUP BY id HAVING MAX(pref.weight))", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{Category.TABLE, RepositoryPreferences.TABLE}, false, new Callable() { // from class: org.fdroid.database.RepositoryDaoInt_Impl.30
            @Override // java.util.concurrent.Callable
            public List call() {
                Cursor query = DBUtil.query(RepositoryDaoInt_Impl.this.__db, acquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        long j = query.getLong(0);
                        String string = query.isNull(1) ? null : query.getString(1);
                        String string2 = query.isNull(2) ? null : query.getString(2);
                        Converters converters = Converters.INSTANCE;
                        arrayList.add(new Category(j, string, converters.fromStringToLocalizedFileV2(string2), converters.fromStringToLocalizedTextV2(query.isNull(3) ? null : query.getString(3)), converters.fromStringToLocalizedTextV2(query.isNull(4) ? null : query.getString(4))));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public int getMinRepositoryWeight() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COALESCE(MIN(weight), 2147483647) FROM RepositoryPreferences", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public RepositoryPreferences getRepositoryPreferences(long j) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM RepositoryPreferences WHERE repoId = ?", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        RepositoryPreferences repositoryPreferences = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "weight");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "enabled");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, AppListActivity.SortClause.LAST_UPDATED);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "lastETag");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "userMirrors");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "disabledMirrors");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "username");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "password");
            if (query.moveToFirst()) {
                long j2 = query.getLong(columnIndexOrThrow);
                int i = query.getInt(columnIndexOrThrow2);
                boolean z = query.getInt(columnIndexOrThrow3) != 0;
                Long valueOf = query.isNull(columnIndexOrThrow4) ? null : Long.valueOf(query.getLong(columnIndexOrThrow4));
                String string = query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5);
                String string2 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                Converters converters = Converters.INSTANCE;
                repositoryPreferences = new RepositoryPreferences(j2, i, z, valueOf, string, converters.fromStringToListString(string2), converters.fromStringToListString(query.isNull(columnIndexOrThrow7) ? null : query.getString(columnIndexOrThrow7)), query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8), query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9));
            }
            return repositoryPreferences;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public Long getArchiveRepoId(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT repoId FROM CoreRepository\n        WHERE certificate = ? AND address LIKE '%/archive' COLLATE NOCASE", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Long l = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst() && !query.isNull(0)) {
                l = Long.valueOf(query.getLong(0));
            }
            return l;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public int countMirrors() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM Mirror", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public int countAntiFeatures() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AntiFeature", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public int countCategories() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM Category", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.RepositoryDaoInt
    public int countReleaseChannels() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM ReleaseChannel", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.fdroid.database.RepositoryDaoInt_Impl$31  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass31 {
        static final /* synthetic */ int[] $SwitchMap$org$fdroid$index$IndexFormatVersion;

        static {
            int[] iArr = new int[IndexFormatVersion.values().length];
            $SwitchMap$org$fdroid$index$IndexFormatVersion = iArr;
            try {
                iArr[IndexFormatVersion.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$fdroid$index$IndexFormatVersion[IndexFormatVersion.TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String __IndexFormatVersion_enumToString(IndexFormatVersion indexFormatVersion) {
        int i = AnonymousClass31.$SwitchMap$org$fdroid$index$IndexFormatVersion[indexFormatVersion.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "TWO";
            }
            throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + indexFormatVersion);
        }
        return "ONE";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipMirrorAsorgFdroidDatabaseMirror(LongSparseArray longSparseArray) {
        if (longSparseArray.isEmpty()) {
            return;
        }
        if (longSparseArray.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(longSparseArray, true, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipMirrorAsorgFdroidDatabaseMirror$0;
                    lambda$__fetchRelationshipMirrorAsorgFdroidDatabaseMirror$0 = RepositoryDaoInt_Impl.this.lambda$__fetchRelationshipMirrorAsorgFdroidDatabaseMirror$0((LongSparseArray) obj);
                    return lambda$__fetchRelationshipMirrorAsorgFdroidDatabaseMirror$0;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`url`,`location` FROM `Mirror` WHERE `repoId` IN (");
        int size = longSparseArray.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
            acquire.bindLong(i, longSparseArray.keyAt(i2));
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "repoId");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList arrayList = (ArrayList) longSparseArray.get(query.getLong(columnIndex));
                if (arrayList != null) {
                    arrayList.add(new Mirror(query.getLong(0), query.isNull(1) ? null : query.getString(1), query.isNull(2) ? null : query.getString(2)));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipMirrorAsorgFdroidDatabaseMirror$0(LongSparseArray longSparseArray) {
        __fetchRelationshipMirrorAsorgFdroidDatabaseMirror(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature(LongSparseArray longSparseArray) {
        if (longSparseArray.isEmpty()) {
            return;
        }
        if (longSparseArray.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(longSparseArray, true, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt_Impl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature$1;
                    lambda$__fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature$1 = RepositoryDaoInt_Impl.this.lambda$__fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature$1((LongSparseArray) obj);
                    return lambda$__fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature$1;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`id`,`icon`,`name`,`description` FROM `AntiFeature` WHERE `repoId` IN (");
        int size = longSparseArray.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 0;
        int i2 = 1;
        for (int i3 = 0; i3 < longSparseArray.size(); i3++) {
            acquire.bindLong(i2, longSparseArray.keyAt(i3));
            i2++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "repoId");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList arrayList = (ArrayList) longSparseArray.get(query.getLong(columnIndex));
                if (arrayList != null) {
                    long j = query.getLong(i);
                    String string = query.isNull(1) ? null : query.getString(1);
                    String string2 = query.isNull(2) ? null : query.getString(2);
                    Converters converters = Converters.INSTANCE;
                    arrayList.add(new AntiFeature(j, string, converters.fromStringToLocalizedFileV2(string2), converters.fromStringToLocalizedTextV2(query.isNull(3) ? null : query.getString(3)), converters.fromStringToLocalizedTextV2(query.isNull(4) ? null : query.getString(4))));
                }
                i = 0;
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature$1(LongSparseArray longSparseArray) {
        __fetchRelationshipAntiFeatureAsorgFdroidDatabaseAntiFeature(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipCategoryAsorgFdroidDatabaseCategory(LongSparseArray longSparseArray) {
        if (longSparseArray.isEmpty()) {
            return;
        }
        if (longSparseArray.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(longSparseArray, true, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt_Impl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipCategoryAsorgFdroidDatabaseCategory$2;
                    lambda$__fetchRelationshipCategoryAsorgFdroidDatabaseCategory$2 = RepositoryDaoInt_Impl.this.lambda$__fetchRelationshipCategoryAsorgFdroidDatabaseCategory$2((LongSparseArray) obj);
                    return lambda$__fetchRelationshipCategoryAsorgFdroidDatabaseCategory$2;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`id`,`icon`,`name`,`description` FROM `Category` WHERE `repoId` IN (");
        int size = longSparseArray.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 0;
        int i2 = 1;
        for (int i3 = 0; i3 < longSparseArray.size(); i3++) {
            acquire.bindLong(i2, longSparseArray.keyAt(i3));
            i2++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "repoId");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList arrayList = (ArrayList) longSparseArray.get(query.getLong(columnIndex));
                if (arrayList != null) {
                    long j = query.getLong(i);
                    String string = query.isNull(1) ? null : query.getString(1);
                    String string2 = query.isNull(2) ? null : query.getString(2);
                    Converters converters = Converters.INSTANCE;
                    arrayList.add(new Category(j, string, converters.fromStringToLocalizedFileV2(string2), converters.fromStringToLocalizedTextV2(query.isNull(3) ? null : query.getString(3)), converters.fromStringToLocalizedTextV2(query.isNull(4) ? null : query.getString(4))));
                }
                i = 0;
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipCategoryAsorgFdroidDatabaseCategory$2(LongSparseArray longSparseArray) {
        __fetchRelationshipCategoryAsorgFdroidDatabaseCategory(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel(LongSparseArray longSparseArray) {
        if (longSparseArray.isEmpty()) {
            return;
        }
        if (longSparseArray.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(longSparseArray, true, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt_Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel$3;
                    lambda$__fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel$3 = RepositoryDaoInt_Impl.this.lambda$__fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel$3((LongSparseArray) obj);
                    return lambda$__fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel$3;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`id`,`icon`,`name`,`description` FROM `ReleaseChannel` WHERE `repoId` IN (");
        int size = longSparseArray.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 0;
        int i2 = 1;
        for (int i3 = 0; i3 < longSparseArray.size(); i3++) {
            acquire.bindLong(i2, longSparseArray.keyAt(i3));
            i2++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "repoId");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList arrayList = (ArrayList) longSparseArray.get(query.getLong(columnIndex));
                if (arrayList != null) {
                    long j = query.getLong(i);
                    String string = query.isNull(1) ? null : query.getString(1);
                    String string2 = query.isNull(2) ? null : query.getString(2);
                    Converters converters = Converters.INSTANCE;
                    arrayList.add(new ReleaseChannel(j, string, converters.fromStringToLocalizedFileV2(string2), converters.fromStringToLocalizedTextV2(query.isNull(3) ? null : query.getString(3)), converters.fromStringToLocalizedTextV2(query.isNull(4) ? null : query.getString(4))));
                }
                i = 0;
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel$3(LongSparseArray longSparseArray) {
        __fetchRelationshipReleaseChannelAsorgFdroidDatabaseReleaseChannel(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences(LongSparseArray longSparseArray) {
        if (longSparseArray.isEmpty()) {
            return;
        }
        if (longSparseArray.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(longSparseArray, false, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt_Impl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences$4;
                    lambda$__fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences$4 = RepositoryDaoInt_Impl.this.lambda$__fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences$4((LongSparseArray) obj);
                    return lambda$__fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences$4;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`weight`,`enabled`,`lastUpdated`,`lastETag`,`userMirrors`,`disabledMirrors`,`username`,`password` FROM `RepositoryPreferences` WHERE `repoId` IN (");
        int size = longSparseArray.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
            acquire.bindLong(i, longSparseArray.keyAt(i2));
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "repoId");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                long j = query.getLong(columnIndex);
                if (longSparseArray.containsKey(j)) {
                    long j2 = query.getLong(0);
                    int i3 = query.getInt(1);
                    boolean z = query.getInt(2) != 0;
                    Long valueOf = query.isNull(3) ? null : Long.valueOf(query.getLong(3));
                    String string = query.isNull(4) ? null : query.getString(4);
                    String string2 = query.isNull(5) ? null : query.getString(5);
                    Converters converters = Converters.INSTANCE;
                    longSparseArray.put(j, new RepositoryPreferences(j2, i3, z, valueOf, string, converters.fromStringToListString(string2), converters.fromStringToListString(query.isNull(6) ? null : query.getString(6)), query.isNull(7) ? null : query.getString(7), query.isNull(8) ? null : query.getString(8)));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences$4(LongSparseArray longSparseArray) {
        __fetchRelationshipRepositoryPreferencesAsorgFdroidDatabaseRepositoryPreferences(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IndexFormatVersion __IndexFormatVersion_stringToEnum(String str) {
        str.hashCode();
        if (str.equals("ONE")) {
            return IndexFormatVersion.ONE;
        }
        if (str.equals("TWO")) {
            return IndexFormatVersion.TWO;
        }
        throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + str);
    }
}
