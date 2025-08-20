package org.fdroid.database;

import android.database.Cursor;
import androidx.collection.ArrayMap;
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
import org.fdroid.database.VersionDaoInt;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.v2.FileV1;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.PackageVersionV2;
import org.fdroid.index.v2.SignerV2;
import org.fdroid.index.v2.UsesSdkV2;
/* loaded from: classes2.dex */
public final class VersionDaoInt_Impl implements VersionDaoInt {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfVersion;
    private final EntityInsertionAdapter __insertionAdapterOfVersionedString;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAppVersion;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAppVersion_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteVersionedStrings;
    private final SharedSQLiteStatement __preparedStmtOfDeleteVersionedStrings_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfVersion;

    public VersionDaoInt_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfVersion = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.VersionDaoInt_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `Version` (`repoId`,`packageName`,`versionId`,`added`,`releaseChannels`,`antiFeatures`,`whatsNew`,`isCompatible`,`file_name`,`file_sha256`,`file_size`,`file_ipfsCidV1`,`src_name`,`src_sha256`,`src_size`,`src_ipfsCidV1`,`manifest_versionName`,`manifest_versionCode`,`manifest_maxSdkVersion`,`manifest_nativecode`,`manifest_features`,`manifest_usesSdk_minSdkVersion`,`manifest_usesSdk_targetSdkVersion`,`manifest_signer_sha256`,`manifest_signer_hasMultipleSigners`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Version version) {
                supportSQLiteStatement.bindLong(1, version.getRepoId());
                if (version.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, version.getPackageName());
                }
                if (version.getVersionId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, version.getVersionId());
                }
                supportSQLiteStatement.bindLong(4, version.getAdded());
                Converters converters = Converters.INSTANCE;
                String listStringToString = converters.listStringToString(version.getReleaseChannels());
                if (listStringToString == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, listStringToString);
                }
                String mapOfLocalizedTextV2toString = converters.mapOfLocalizedTextV2toString(version.getAntiFeatures());
                if (mapOfLocalizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, mapOfLocalizedTextV2toString);
                }
                String localizedTextV2toString = converters.localizedTextV2toString(version.getWhatsNew());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, localizedTextV2toString);
                }
                supportSQLiteStatement.bindLong(8, version.isCompatible() ? 1L : 0L);
                FileV1 file = version.getFile();
                if (file.getName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, file.getName());
                }
                if (file.getSha256() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, file.getSha256());
                }
                if (file.getSize() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, file.getSize().longValue());
                }
                if (file.getIpfsCidV1() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, file.getIpfsCidV1());
                }
                FileV2 src = version.getSrc();
                if (src != null) {
                    if (src.getName() == null) {
                        supportSQLiteStatement.bindNull(13);
                    } else {
                        supportSQLiteStatement.bindString(13, src.getName());
                    }
                    if (src.getSha256() == null) {
                        supportSQLiteStatement.bindNull(14);
                    } else {
                        supportSQLiteStatement.bindString(14, src.getSha256());
                    }
                    if (src.getSize() == null) {
                        supportSQLiteStatement.bindNull(15);
                    } else {
                        supportSQLiteStatement.bindLong(15, src.getSize().longValue());
                    }
                    if (src.getIpfsCidV1() == null) {
                        supportSQLiteStatement.bindNull(16);
                    } else {
                        supportSQLiteStatement.bindString(16, src.getIpfsCidV1());
                    }
                } else {
                    supportSQLiteStatement.bindNull(13);
                    supportSQLiteStatement.bindNull(14);
                    supportSQLiteStatement.bindNull(15);
                    supportSQLiteStatement.bindNull(16);
                }
                AppManifest manifest = version.getManifest();
                if (manifest.getVersionName() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, manifest.getVersionName());
                }
                supportSQLiteStatement.bindLong(18, manifest.getVersionCode());
                if (manifest.getMaxSdkVersion() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindLong(19, manifest.getMaxSdkVersion().intValue());
                }
                String listStringToString2 = converters.listStringToString(manifest.getNativecode());
                if (listStringToString2 == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, listStringToString2);
                }
                String listStringToString3 = converters.listStringToString(manifest.getFeatures());
                if (listStringToString3 == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, listStringToString3);
                }
                UsesSdkV2 usesSdk = manifest.getUsesSdk();
                if (usesSdk != null) {
                    supportSQLiteStatement.bindLong(22, usesSdk.getMinSdkVersion());
                    supportSQLiteStatement.bindLong(23, usesSdk.getTargetSdkVersion());
                } else {
                    supportSQLiteStatement.bindNull(22);
                    supportSQLiteStatement.bindNull(23);
                }
                SignerV2 signer = manifest.getSigner();
                if (signer != null) {
                    String listStringToString4 = converters.listStringToString(signer.getSha256());
                    if (listStringToString4 == null) {
                        supportSQLiteStatement.bindNull(24);
                    } else {
                        supportSQLiteStatement.bindString(24, listStringToString4);
                    }
                    supportSQLiteStatement.bindLong(25, signer.getHasMultipleSigners() ? 1L : 0L);
                    return;
                }
                supportSQLiteStatement.bindNull(24);
                supportSQLiteStatement.bindNull(25);
            }
        };
        this.__insertionAdapterOfVersionedString = new EntityInsertionAdapter(roomDatabase) { // from class: org.fdroid.database.VersionDaoInt_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `VersionedString` (`repoId`,`packageName`,`versionId`,`type`,`name`,`version`) VALUES (?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, VersionedString versionedString) {
                supportSQLiteStatement.bindLong(1, versionedString.getRepoId());
                if (versionedString.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, versionedString.getPackageName());
                }
                if (versionedString.getVersionId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, versionedString.getVersionId());
                }
                supportSQLiteStatement.bindString(4, VersionDaoInt_Impl.this.__VersionedStringType_enumToString(versionedString.getType()));
                if (versionedString.getName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, versionedString.getName());
                }
                if (versionedString.getVersion() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, versionedString.getVersion().intValue());
                }
            }
        };
        this.__updateAdapterOfVersion = new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: org.fdroid.database.VersionDaoInt_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `Version` SET `repoId` = ?,`packageName` = ?,`versionId` = ?,`added` = ?,`releaseChannels` = ?,`antiFeatures` = ?,`whatsNew` = ?,`isCompatible` = ?,`file_name` = ?,`file_sha256` = ?,`file_size` = ?,`file_ipfsCidV1` = ?,`src_name` = ?,`src_sha256` = ?,`src_size` = ?,`src_ipfsCidV1` = ?,`manifest_versionName` = ?,`manifest_versionCode` = ?,`manifest_maxSdkVersion` = ?,`manifest_nativecode` = ?,`manifest_features` = ?,`manifest_usesSdk_minSdkVersion` = ?,`manifest_usesSdk_targetSdkVersion` = ?,`manifest_signer_sha256` = ?,`manifest_signer_hasMultipleSigners` = ? WHERE `repoId` = ? AND `packageName` = ? AND `versionId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Version version) {
                supportSQLiteStatement.bindLong(1, version.getRepoId());
                if (version.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, version.getPackageName());
                }
                if (version.getVersionId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, version.getVersionId());
                }
                supportSQLiteStatement.bindLong(4, version.getAdded());
                Converters converters = Converters.INSTANCE;
                String listStringToString = converters.listStringToString(version.getReleaseChannels());
                if (listStringToString == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, listStringToString);
                }
                String mapOfLocalizedTextV2toString = converters.mapOfLocalizedTextV2toString(version.getAntiFeatures());
                if (mapOfLocalizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, mapOfLocalizedTextV2toString);
                }
                String localizedTextV2toString = converters.localizedTextV2toString(version.getWhatsNew());
                if (localizedTextV2toString == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, localizedTextV2toString);
                }
                supportSQLiteStatement.bindLong(8, version.isCompatible() ? 1L : 0L);
                FileV1 file = version.getFile();
                if (file.getName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, file.getName());
                }
                if (file.getSha256() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, file.getSha256());
                }
                if (file.getSize() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, file.getSize().longValue());
                }
                if (file.getIpfsCidV1() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, file.getIpfsCidV1());
                }
                FileV2 src = version.getSrc();
                if (src != null) {
                    if (src.getName() == null) {
                        supportSQLiteStatement.bindNull(13);
                    } else {
                        supportSQLiteStatement.bindString(13, src.getName());
                    }
                    if (src.getSha256() == null) {
                        supportSQLiteStatement.bindNull(14);
                    } else {
                        supportSQLiteStatement.bindString(14, src.getSha256());
                    }
                    if (src.getSize() == null) {
                        supportSQLiteStatement.bindNull(15);
                    } else {
                        supportSQLiteStatement.bindLong(15, src.getSize().longValue());
                    }
                    if (src.getIpfsCidV1() == null) {
                        supportSQLiteStatement.bindNull(16);
                    } else {
                        supportSQLiteStatement.bindString(16, src.getIpfsCidV1());
                    }
                } else {
                    supportSQLiteStatement.bindNull(13);
                    supportSQLiteStatement.bindNull(14);
                    supportSQLiteStatement.bindNull(15);
                    supportSQLiteStatement.bindNull(16);
                }
                AppManifest manifest = version.getManifest();
                if (manifest.getVersionName() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, manifest.getVersionName());
                }
                supportSQLiteStatement.bindLong(18, manifest.getVersionCode());
                if (manifest.getMaxSdkVersion() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindLong(19, manifest.getMaxSdkVersion().intValue());
                }
                String listStringToString2 = converters.listStringToString(manifest.getNativecode());
                if (listStringToString2 == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, listStringToString2);
                }
                String listStringToString3 = converters.listStringToString(manifest.getFeatures());
                if (listStringToString3 == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, listStringToString3);
                }
                UsesSdkV2 usesSdk = manifest.getUsesSdk();
                if (usesSdk != null) {
                    supportSQLiteStatement.bindLong(22, usesSdk.getMinSdkVersion());
                    supportSQLiteStatement.bindLong(23, usesSdk.getTargetSdkVersion());
                } else {
                    supportSQLiteStatement.bindNull(22);
                    supportSQLiteStatement.bindNull(23);
                }
                SignerV2 signer = manifest.getSigner();
                if (signer != null) {
                    String listStringToString4 = converters.listStringToString(signer.getSha256());
                    if (listStringToString4 == null) {
                        supportSQLiteStatement.bindNull(24);
                    } else {
                        supportSQLiteStatement.bindString(24, listStringToString4);
                    }
                    supportSQLiteStatement.bindLong(25, signer.getHasMultipleSigners() ? 1L : 0L);
                } else {
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                }
                supportSQLiteStatement.bindLong(26, version.getRepoId());
                if (version.getPackageName() == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindString(27, version.getPackageName());
                }
                if (version.getVersionId() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, version.getVersionId());
                }
            }
        };
        this.__preparedStmtOfDeleteAppVersion = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.VersionDaoInt_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM Version WHERE repoId = ? AND packageName = ?";
            }
        };
        this.__preparedStmtOfDeleteAppVersion_1 = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.VersionDaoInt_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM Version\n        WHERE repoId = ? AND packageName = ? AND versionId = ?";
            }
        };
        this.__preparedStmtOfDeleteVersionedStrings = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.VersionDaoInt_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM VersionedString\n        WHERE repoId = ? AND packageName = ? AND versionId = ?";
            }
        };
        this.__preparedStmtOfDeleteVersionedStrings_1 = new SharedSQLiteStatement(roomDatabase) { // from class: org.fdroid.database.VersionDaoInt_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM VersionedString WHERE repoId = ?\n        AND packageName = ? AND versionId = ? AND type = ?";
            }
        };
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void insert(Version version) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfVersion.insert(version);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void insert(List<VersionedString> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfVersionedString.insert((Iterable) list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void update(Version version) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfVersion.handle(version);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt, org.fdroid.database.VersionDao
    public void insert(long j, String str, Map<String, PackageVersionV2> map, Function1 function1) {
        this.__db.beginTransaction();
        try {
            VersionDaoInt.DefaultImpls.insert(this, j, str, map, function1);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void insert(long j, String str, String str2, PackageVersionV2 packageVersionV2, boolean z) {
        this.__db.beginTransaction();
        try {
            VersionDaoInt.DefaultImpls.insert(this, j, str, str2, packageVersionV2, z);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void deleteAppVersion(long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAppVersion.acquire();
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
            this.__preparedStmtOfDeleteAppVersion.release(acquire);
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void deleteAppVersion(long j, String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAppVersion_1.acquire();
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
            this.__preparedStmtOfDeleteAppVersion_1.release(acquire);
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void deleteVersionedStrings(long j, String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteVersionedStrings.acquire();
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
            this.__preparedStmtOfDeleteVersionedStrings.release(acquire);
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void deleteVersionedStrings(long j, String str, String str2, VersionedStringType versionedStringType) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteVersionedStrings_1.acquire();
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
        acquire.bindString(4, __VersionedStringType_enumToString(versionedStringType));
        try {
            this.__db.beginTransaction();
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
        } finally {
            this.__preparedStmtOfDeleteVersionedStrings_1.release(acquire);
        }
    }

    @Override // org.fdroid.database.VersionDaoInt, org.fdroid.database.VersionDao
    public LiveData getAppVersions(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `repoId`, `packageName`, `versionId`, `added`, `releaseChannels`, `antiFeatures`, `whatsNew`, `isCompatible`, `file_name`, `file_sha256`, `file_size`, `file_ipfsCidV1`, `src_name`, `src_sha256`, `src_size`, `src_ipfsCidV1`, `manifest_versionName`, `manifest_versionCode`, `manifest_maxSdkVersion`, `manifest_nativecode`, `manifest_features`, `manifest_usesSdk_minSdkVersion`, `manifest_usesSdk_targetSdkVersion`, `manifest_signer_sha256`, `manifest_signer_hasMultipleSigners` FROM (SELECT * FROM Version\n        JOIN RepositoryPreferences AS pref USING (repoId)\n        WHERE pref.enabled = 1 AND packageName = ?\n        ORDER BY manifest_versionCode DESC, pref.weight DESC, manifest_nativecode ASC)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{VersionedString.TABLE, Version.TABLE, RepositoryPreferences.TABLE}, true, new Callable() { // from class: org.fdroid.database.VersionDaoInt_Impl.8
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:122:0x01f3  */
            /* JADX WARN: Removed duplicated region for block: B:123:0x01f5 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:21:0x005e, B:25:0x006f, B:29:0x007c, B:33:0x008e, B:37:0x00a1, B:41:0x00b2, B:45:0x00c2, B:49:0x00d0, B:53:0x00de, B:57:0x00f0, B:61:0x00fe, B:89:0x0161, B:93:0x0172, B:97:0x018d, B:101:0x019b, B:105:0x01ad, B:107:0x01bb, B:114:0x01d9, B:116:0x01e1, B:129:0x020f, B:134:0x022e, B:136:0x023a, B:135:0x0235, B:132:0x0228, B:120:0x01ed, B:124:0x01f9, B:128:0x0208, B:123:0x01f5, B:113:0x01ca, B:104:0x01a9, B:100:0x0197, B:96:0x0183, B:92:0x016c, B:72:0x0128, B:76:0x0134, B:80:0x0140, B:84:0x0150, B:88:0x015c, B:87:0x0158, B:83:0x0148, B:79:0x013c, B:75:0x0130, B:60:0x00fa, B:56:0x00e8, B:52:0x00da, B:48:0x00cc, B:40:0x00ae, B:36:0x009d, B:32:0x008a, B:28:0x0077, B:24:0x006a), top: B:150:0x005e }] */
            /* JADX WARN: Removed duplicated region for block: B:126:0x0205  */
            /* JADX WARN: Removed duplicated region for block: B:127:0x0207  */
            /* JADX WARN: Removed duplicated region for block: B:131:0x0226  */
            /* JADX WARN: Removed duplicated region for block: B:132:0x0228 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:21:0x005e, B:25:0x006f, B:29:0x007c, B:33:0x008e, B:37:0x00a1, B:41:0x00b2, B:45:0x00c2, B:49:0x00d0, B:53:0x00de, B:57:0x00f0, B:61:0x00fe, B:89:0x0161, B:93:0x0172, B:97:0x018d, B:101:0x019b, B:105:0x01ad, B:107:0x01bb, B:114:0x01d9, B:116:0x01e1, B:129:0x020f, B:134:0x022e, B:136:0x023a, B:135:0x0235, B:132:0x0228, B:120:0x01ed, B:124:0x01f9, B:128:0x0208, B:123:0x01f5, B:113:0x01ca, B:104:0x01a9, B:100:0x0197, B:96:0x0183, B:92:0x016c, B:72:0x0128, B:76:0x0134, B:80:0x0140, B:84:0x0150, B:88:0x015c, B:87:0x0158, B:83:0x0148, B:79:0x013c, B:75:0x0130, B:60:0x00fa, B:56:0x00e8, B:52:0x00da, B:48:0x00cc, B:40:0x00ae, B:36:0x009d, B:32:0x008a, B:28:0x0077, B:24:0x006a), top: B:150:0x005e }] */
            /* JADX WARN: Removed duplicated region for block: B:134:0x022e A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:21:0x005e, B:25:0x006f, B:29:0x007c, B:33:0x008e, B:37:0x00a1, B:41:0x00b2, B:45:0x00c2, B:49:0x00d0, B:53:0x00de, B:57:0x00f0, B:61:0x00fe, B:89:0x0161, B:93:0x0172, B:97:0x018d, B:101:0x019b, B:105:0x01ad, B:107:0x01bb, B:114:0x01d9, B:116:0x01e1, B:129:0x020f, B:134:0x022e, B:136:0x023a, B:135:0x0235, B:132:0x0228, B:120:0x01ed, B:124:0x01f9, B:128:0x0208, B:123:0x01f5, B:113:0x01ca, B:104:0x01a9, B:100:0x0197, B:96:0x0183, B:92:0x016c, B:72:0x0128, B:76:0x0134, B:80:0x0140, B:84:0x0150, B:88:0x015c, B:87:0x0158, B:83:0x0148, B:79:0x013c, B:75:0x0130, B:60:0x00fa, B:56:0x00e8, B:52:0x00da, B:48:0x00cc, B:40:0x00ae, B:36:0x009d, B:32:0x008a, B:28:0x0077, B:24:0x006a), top: B:150:0x005e }] */
            /* JADX WARN: Removed duplicated region for block: B:135:0x0235 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:21:0x005e, B:25:0x006f, B:29:0x007c, B:33:0x008e, B:37:0x00a1, B:41:0x00b2, B:45:0x00c2, B:49:0x00d0, B:53:0x00de, B:57:0x00f0, B:61:0x00fe, B:89:0x0161, B:93:0x0172, B:97:0x018d, B:101:0x019b, B:105:0x01ad, B:107:0x01bb, B:114:0x01d9, B:116:0x01e1, B:129:0x020f, B:134:0x022e, B:136:0x023a, B:135:0x0235, B:132:0x0228, B:120:0x01ed, B:124:0x01f9, B:128:0x0208, B:123:0x01f5, B:113:0x01ca, B:104:0x01a9, B:100:0x0197, B:96:0x0183, B:92:0x016c, B:72:0x0128, B:76:0x0134, B:80:0x0140, B:84:0x0150, B:88:0x015c, B:87:0x0158, B:83:0x0148, B:79:0x013c, B:75:0x0130, B:60:0x00fa, B:56:0x00e8, B:52:0x00da, B:48:0x00cc, B:40:0x00ae, B:36:0x009d, B:32:0x008a, B:28:0x0077, B:24:0x006a), top: B:150:0x005e }] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.util.List call() {
                /*
                    Method dump skipped, instructions count: 623
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.VersionDaoInt_Impl.AnonymousClass8.call():java.util.List");
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // org.fdroid.database.VersionDaoInt, org.fdroid.database.VersionDao
    public LiveData getAppVersions(long j, String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Version\n        WHERE repoId = ? AND packageName = ?\n        ORDER BY manifest_versionCode DESC, manifest_nativecode ASC", 2);
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{VersionedString.TABLE, Version.TABLE}, true, new Callable() { // from class: org.fdroid.database.VersionDaoInt_Impl.9
            /* JADX WARN: Removed duplicated region for block: B:100:0x0293 A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:103:0x02a5  */
            /* JADX WARN: Removed duplicated region for block: B:104:0x02a7 A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:107:0x02b7  */
            /* JADX WARN: Removed duplicated region for block: B:108:0x02bb A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:111:0x02cf A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:115:0x02e7  */
            /* JADX WARN: Removed duplicated region for block: B:119:0x0307 A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:123:0x0315  */
            /* JADX WARN: Removed duplicated region for block: B:126:0x031d  */
            /* JADX WARN: Removed duplicated region for block: B:127:0x031f A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:130:0x032f  */
            /* JADX WARN: Removed duplicated region for block: B:131:0x0331  */
            /* JADX WARN: Removed duplicated region for block: B:135:0x0350  */
            /* JADX WARN: Removed duplicated region for block: B:136:0x0352 A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:138:0x0358 A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:139:0x035f A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x021c  */
            /* JADX WARN: Removed duplicated region for block: B:79:0x0220 A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:82:0x022e  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x0232 A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:86:0x0240  */
            /* JADX WARN: Removed duplicated region for block: B:87:0x0244 A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:90:0x0256  */
            /* JADX WARN: Removed duplicated region for block: B:91:0x025c A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:95:0x0275  */
            /* JADX WARN: Removed duplicated region for block: B:96:0x027a A[Catch: all -> 0x00f7, TryCatch #2 {all -> 0x03a6, blocks: (B:3:0x000b, B:142:0x0399, B:4:0x0019, B:5:0x00cc, B:7:0x00d2, B:12:0x00e6, B:14:0x00ec, B:10:0x00dc, B:19:0x0101, B:20:0x0117, B:22:0x011d, B:26:0x0130, B:30:0x013f, B:34:0x0153, B:38:0x0165, B:42:0x0175, B:46:0x0186, B:50:0x0192, B:54:0x01a4, B:59:0x01c1, B:63:0x01d7, B:65:0x01e4, B:67:0x01ec, B:69:0x01f4, B:76:0x0216, B:80:0x0228, B:84:0x023a, B:88:0x0250, B:92:0x0266, B:93:0x026f, B:97:0x0282, B:101:0x029f, B:105:0x02ab, B:109:0x02c3, B:111:0x02cf, B:116:0x02ec, B:117:0x0301, B:119:0x0307, B:124:0x0317, B:128:0x0323, B:132:0x0333, B:133:0x033a, B:138:0x0358, B:140:0x0364, B:139:0x035f, B:136:0x0352, B:127:0x031f, B:108:0x02bb, B:104:0x02a7, B:100:0x0293, B:96:0x027a, B:91:0x025c, B:87:0x0244, B:83:0x0232, B:79:0x0220, B:62:0x01cd, B:58:0x01b4, B:53:0x019c, B:49:0x018e, B:41:0x0171, B:37:0x0161, B:33:0x014d, B:29:0x0139, B:25:0x012a, B:141:0x0390), top: B:151:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:99:0x028e  */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.util.List call() {
                /*
                    Method dump skipped, instructions count: 950
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.VersionDaoInt_Impl.AnonymousClass9.call():java.util.List");
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0233 A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0243 A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026a A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x027c A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b4 A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c0 A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01cc A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01dc A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f4 A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020d A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0221 A[Catch: all -> 0x01a3, TryCatch #0 {all -> 0x01a3, blocks: (B:12:0x0089, B:14:0x00e5, B:18:0x00f8, B:22:0x0107, B:26:0x0117, B:30:0x0129, B:34:0x0139, B:38:0x0148, B:42:0x0154, B:46:0x0160, B:50:0x0170, B:54:0x017c, B:56:0x0187, B:58:0x018d, B:60:0x0195, B:68:0x01ac, B:72:0x01b8, B:76:0x01c4, B:80:0x01d4, B:84:0x01e0, B:85:0x01e9, B:89:0x01fc, B:93:0x0219, B:97:0x0225, B:101:0x0237, B:103:0x0243, B:108:0x0253, B:109:0x0264, B:111:0x026a, B:124:0x0294, B:115:0x0274, B:119:0x0280, B:123:0x028d, B:118:0x027c, B:100:0x0233, B:96:0x0221, B:92:0x020d, B:88:0x01f4, B:83:0x01dc, B:79:0x01cc, B:75:0x01c0, B:71:0x01b4, B:53:0x0178, B:49:0x0168, B:45:0x015c, B:41:0x0150, B:33:0x0135, B:29:0x0125, B:25:0x0113, B:21:0x0101, B:17:0x00f2), top: B:133:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0231  */
    @Override // org.fdroid.database.VersionDaoInt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.fdroid.database.Version getVersion(long r50, java.lang.String r52, java.lang.String r53) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.VersionDaoInt_Impl.getVersion(long, java.lang.String, java.lang.String):org.fdroid.database.Version");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0226 A[Catch: all -> 0x0157, TryCatch #0 {all -> 0x0157, blocks: (B:11:0x007c, B:12:0x0085, B:14:0x008b, B:18:0x009c, B:22:0x00aa, B:26:0x00bc, B:30:0x00cf, B:34:0x00e0, B:38:0x00f0, B:42:0x00fe, B:46:0x010c, B:50:0x011e, B:54:0x012c, B:56:0x013f, B:58:0x0145, B:60:0x014b, B:83:0x0195, B:87:0x01a6, B:91:0x01c1, B:95:0x01cf, B:99:0x01e1, B:101:0x01ed, B:106:0x020a, B:108:0x0212, B:121:0x0240, B:112:0x021e, B:116:0x022a, B:120:0x0239, B:115:0x0226, B:105:0x01f9, B:98:0x01dd, B:94:0x01cb, B:90:0x01b7, B:86:0x01a0, B:66:0x015a, B:70:0x0166, B:74:0x0172, B:78:0x0182, B:82:0x018e, B:81:0x018a, B:77:0x017a, B:73:0x016e, B:69:0x0162, B:53:0x0128, B:49:0x0116, B:45:0x0108, B:41:0x00fa, B:33:0x00dc, B:29:0x00cb, B:25:0x00b8, B:21:0x00a5, B:17:0x0097), top: B:127:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0238  */
    @Override // org.fdroid.database.VersionDaoInt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<org.fdroid.database.Version> getVersionsInternal(java.util.List<java.lang.String> r32) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.VersionDaoInt_Impl.getVersionsInternal(java.util.List):java.util.List");
    }

    @Override // org.fdroid.database.VersionDaoInt
    public List<VersionedString> getVersionedStrings(long j, String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM VersionedString\n        WHERE repoId = ? AND packageName = ?", 2);
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
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "versionId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, BonjourPeer.TYPE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "version");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new VersionedString(query.getLong(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), __VersionedStringType_stringToEnum(query.getString(columnIndexOrThrow4)), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public List<VersionedString> getVersionedStrings(long j, String str, String str2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM VersionedString\n        WHERE repoId = ? AND packageName = ? AND versionId = ?", 3);
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
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "repoId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "packageName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "versionId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, BonjourPeer.TYPE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "version");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new VersionedString(query.getLong(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), __VersionedStringType_stringToEnum(query.getString(columnIndexOrThrow4)), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public int countAppVersions() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM Version", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public int countVersionedStrings() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM VersionedString", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // org.fdroid.database.VersionDaoInt
    public void update(long j, String str, Map<String, JsonObject> map, Function1 function1) {
        VersionDaoInt.DefaultImpls.update(this, j, str, map, function1);
    }

    @Override // org.fdroid.database.VersionDaoInt
    public List<Version> getVersions(List<String> list) {
        return VersionDaoInt.DefaultImpls.getVersions(this, list);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.fdroid.database.VersionDaoInt_Impl$10  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$org$fdroid$database$VersionedStringType;

        static {
            int[] iArr = new int[VersionedStringType.values().length];
            $SwitchMap$org$fdroid$database$VersionedStringType = iArr;
            try {
                iArr[VersionedStringType.PERMISSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$fdroid$database$VersionedStringType[VersionedStringType.PERMISSION_SDK_23.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String __VersionedStringType_enumToString(VersionedStringType versionedStringType) {
        int i = AnonymousClass10.$SwitchMap$org$fdroid$database$VersionedStringType[versionedStringType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "PERMISSION_SDK_23";
            }
            throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + versionedStringType);
        }
        return "PERMISSION";
    }

    private VersionedStringType __VersionedStringType_stringToEnum(String str) {
        str.hashCode();
        if (str.equals("PERMISSION_SDK_23")) {
            return VersionedStringType.PERMISSION_SDK_23;
        }
        if (str.equals("PERMISSION")) {
            return VersionedStringType.PERMISSION;
        }
        throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipVersionedStringAsorgFdroidDatabaseVersionedString(ArrayMap arrayMap) {
        ArrayList arrayList;
        Set<String> keySet = arrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, true, new Function1() { // from class: org.fdroid.database.VersionDaoInt_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipVersionedStringAsorgFdroidDatabaseVersionedString$0;
                    lambda$__fetchRelationshipVersionedStringAsorgFdroidDatabaseVersionedString$0 = VersionDaoInt_Impl.this.lambda$__fetchRelationshipVersionedStringAsorgFdroidDatabaseVersionedString$0((ArrayMap) obj);
                    return lambda$__fetchRelationshipVersionedStringAsorgFdroidDatabaseVersionedString$0;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `repoId`,`packageName`,`versionId`,`type`,`name`,`version` FROM `VersionedString` WHERE `versionId` IN (");
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
            int columnIndex = CursorUtil.getColumnIndex(query, "versionId");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                String string = query.isNull(columnIndex) ? null : query.getString(columnIndex);
                if (string != null && (arrayList = (ArrayList) arrayMap.get(string)) != null) {
                    arrayList.add(new VersionedString(query.getLong(0), query.isNull(1) ? null : query.getString(1), query.isNull(2) ? null : query.getString(2), __VersionedStringType_stringToEnum(query.getString(3)), query.isNull(4) ? null : query.getString(4), query.isNull(5) ? null : Integer.valueOf(query.getInt(5))));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipVersionedStringAsorgFdroidDatabaseVersionedString$0(ArrayMap arrayMap) {
        __fetchRelationshipVersionedStringAsorgFdroidDatabaseVersionedString(arrayMap);
        return Unit.INSTANCE;
    }
}
