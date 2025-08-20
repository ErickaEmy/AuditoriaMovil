package org.fdroid.database;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.fdroid.database.MultiRepoMigration;
/* compiled from: Migrations.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\n*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lorg/fdroid/database/MultiRepoMigration;", "Landroidx/room/migration/AutoMigrationSpec;", "()V", "log", "Lmu/KLogger;", "getRepo", "Lorg/fdroid/database/MultiRepoMigration$Repo;", "c", "Landroid/database/Cursor;", "migrateWeights", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onPostMigrate", "updateRepoWeight", "repo", "newWeight", "", "Repo", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRepoMigration implements AutoMigrationSpec {
    private final KLogger log = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.database.MultiRepoMigration$log$1
        /* renamed from: invoke  reason: collision with other method in class */
        public final void m2355invoke() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2355invoke();
            return Unit.INSTANCE;
        }
    });

    @Override // androidx.room.migration.AutoMigrationSpec
    public void onPostMigrate(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(db, "db");
        db.beginTransaction();
        try {
            migrateWeights(db);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    private final void migrateWeights(SupportSQLiteDatabase supportSQLiteDatabase) {
        ArrayList<Repo> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        Cursor query = supportSQLiteDatabase.query("\n            SELECT repoId, address, certificate, weight FROM CoreRepository\n            JOIN RepositoryPreferences USING (repoId)\n            ORDER BY weight DESC");
        while (query.moveToNext()) {
            try {
                final Repo repo = getRepo(query);
                this.log.error(new Function0() { // from class: org.fdroid.database.MultiRepoMigration$migrateWeights$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MultiRepoMigration.Repo.this.toString();
                    }
                });
                if (repo.isArchive() && repo.getCertificate() != null) {
                    if (hashMap.containsKey(repo.getCertificate())) {
                        this.log.error(new Function0() { // from class: org.fdroid.database.MultiRepoMigration$migrateWeights$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                String address = MultiRepoMigration.Repo.this.getAddress();
                                return "More than two repos with certificate of " + address;
                            }
                        });
                        arrayList.add(repo);
                    } else {
                        hashMap.put(repo.getCertificate(), repo);
                    }
                } else {
                    arrayList.add(repo);
                }
            } finally {
            }
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(query, null);
        int i = 1000000000;
        for (Repo repo2 : arrayList) {
            Repo repo3 = (Repo) hashMap.get(repo2.getCertificate());
            if (repo3 == null) {
                updateRepoWeight(supportSQLiteDatabase, repo2, i);
            } else {
                updateRepoWeight(supportSQLiteDatabase, repo2, i);
                updateRepoWeight(supportSQLiteDatabase, repo3, i - 1);
                TypeIntrinsics.asMutableMap(hashMap).remove(repo2.getCertificate());
            }
            i -= 2;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            updateRepoWeight(supportSQLiteDatabase, (Repo) entry.getValue(), i);
            i--;
        }
    }

    private final void updateRepoWeight(SupportSQLiteDatabase supportSQLiteDatabase, Repo repo, int i) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("weight", Integer.valueOf(i));
        Unit unit = Unit.INSTANCE;
        if (supportSQLiteDatabase.update(RepositoryPreferences.TABLE, 3, contentValues, "repoId = ?", new Long[]{Long.valueOf(repo.getRepoId())}) <= 1) {
            return;
        }
        String address = repo.getAddress();
        throw new IllegalStateException(("repo " + address + " had more than one preference").toString());
    }

    private final Repo getRepo(Cursor cursor) {
        long j = cursor.getLong(0);
        String string = cursor.getString(1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new Repo(j, string, cursor.getString(2), cursor.getInt(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Migrations.kt */
    /* loaded from: classes2.dex */
    public static final class Repo {
        private final String address;
        private final String certificate;
        private final long repoId;
        private final int weight;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Repo) {
                Repo repo = (Repo) obj;
                return this.repoId == repo.repoId && Intrinsics.areEqual(this.address, repo.address) && Intrinsics.areEqual(this.certificate, repo.certificate) && this.weight == repo.weight;
            }
            return false;
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getCertificate() {
            return this.certificate;
        }

        public final long getRepoId() {
            return this.repoId;
        }

        public int hashCode() {
            int m = ((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.address.hashCode()) * 31;
            String str = this.certificate;
            return ((m + (str == null ? 0 : str.hashCode())) * 31) + this.weight;
        }

        public String toString() {
            long j = this.repoId;
            String str = this.address;
            String str2 = this.certificate;
            int i = this.weight;
            return "Repo(repoId=" + j + ", address=" + str + ", certificate=" + str2 + ", weight=" + i + ")";
        }

        public Repo(long j, String address, String str, int i) {
            Intrinsics.checkNotNullParameter(address, "address");
            this.repoId = j;
            this.address = address;
            this.certificate = str;
            this.weight = i;
        }

        public final boolean isArchive() {
            String trimEnd;
            boolean endsWith$default;
            trimEnd = StringsKt__StringsKt.trimEnd(this.address, '/');
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(trimEnd, "/archive", false, 2, null);
            return endsWith$default;
        }
    }
}
