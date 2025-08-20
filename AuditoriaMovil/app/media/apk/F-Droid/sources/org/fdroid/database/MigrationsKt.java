package org.fdroid.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Migrations.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"MIGRATION_2_3", "Landroidx/room/migration/Migration;", "getMIGRATION_2_3", "()Landroidx/room/migration/Migration;", "MIGRATION_5_6", "getMIGRATION_5_6", "REPO_WEIGHT", "", "database_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MigrationsKt {
    private static final Migration MIGRATION_2_3 = new Migration() { // from class: org.fdroid.database.MigrationsKt$MIGRATION_2_3$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.delete(CoreRepository.TABLE, "certificate IS NULL", null);
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration() { // from class: org.fdroid.database.MigrationsKt$MIGRATION_5_6$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("DROP TABLE `AppMetadataFts`");
            db.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `AppMetadataFts`USING FTS4(`repoId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `localizedName` TEXT, `localizedSummary` TEXT, tokenize=unicode61 \"remove_diacritics=0\", content=`AppMetadata`)");
            db.execSQL("INSERT INTO AppMetadataFts(AppMetadataFts) VALUES('rebuild')");
        }
    };
    private static final int REPO_WEIGHT = 1000000000;

    public static final Migration getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public static final Migration getMIGRATION_5_6() {
        return MIGRATION_5_6;
    }
}
