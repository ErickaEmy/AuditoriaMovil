package rb;

import android.database.Cursor;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u0.s;
/* loaded from: classes.dex */
public class n extends s.y {

    /* renamed from: fb  reason: collision with root package name */
    public static final y f13197fb = new y(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f13198a;

    /* renamed from: gv  reason: collision with root package name */
    public final n3 f13199gv;

    /* renamed from: v  reason: collision with root package name */
    public final String f13200v;

    /* renamed from: zn  reason: collision with root package name */
    public s f13201zn;

    /* loaded from: classes.dex */
    public static abstract class n3 {
        public final int version;

        public n3(int i) {
            this.version = i;
        }

        public abstract void createAllTables(u0.fb fbVar);

        public abstract void dropAllTables(u0.fb fbVar);

        public abstract void onCreate(u0.fb fbVar);

        public abstract void onOpen(u0.fb fbVar);

        public void onPostMigrate(u0.fb database) {
            Intrinsics.checkNotNullParameter(database, "database");
        }

        public void onPreMigrate(u0.fb database) {
            Intrinsics.checkNotNullParameter(database, "database");
        }

        public zn onValidateSchema(u0.fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
            validateMigration(db);
            return new zn(true, null);
        }

        public void validateMigration(u0.fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean n3(u0.fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Cursor rb2 = db.rb("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                Cursor cursor = rb2;
                boolean z2 = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) != 0) {
                        z2 = true;
                    }
                }
                CloseableKt.closeFinally(rb2, null);
                return z2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(rb2, th);
                    throw th2;
                }
            }
        }

        public final boolean y(u0.fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Cursor rb2 = db.rb("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                Cursor cursor = rb2;
                boolean z2 = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) == 0) {
                        z2 = true;
                    }
                }
                CloseableKt.closeFinally(rb2, null);
                return z2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(rb2, th);
                    throw th2;
                }
            }
        }

        public y() {
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final String f13202n3;
        public final boolean y;

        public zn(boolean z2, String str) {
            this.y = z2;
            this.f13202n3 = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(s configuration, n3 delegate, String identityHash, String legacyHash) {
        super(delegate.version);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(identityHash, "identityHash");
        Intrinsics.checkNotNullParameter(legacyHash, "legacyHash");
        this.f13201zn = configuration;
        this.f13199gv = delegate;
        this.f13200v = identityHash;
        this.f13198a = legacyHash;
    }

    @Override // u0.s.y
    public void a(u0.fb db) {
        Intrinsics.checkNotNullParameter(db, "db");
        super.a(db);
        s(db);
        this.f13199gv.onOpen(db);
        this.f13201zn = null;
    }

    public final void c5(u0.fb fbVar) {
        fbVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    @Override // u0.s.y
    public void fb(u0.fb db, int i, int i5) {
        List<g3.y> gv2;
        Intrinsics.checkNotNullParameter(db, "db");
        s sVar = this.f13201zn;
        if (sVar != null && (gv2 = sVar.f13246gv.gv(i, i5)) != null) {
            this.f13199gv.onPreMigrate(db);
            for (g3.y yVar : gv2) {
                yVar.migrate(db);
            }
            zn onValidateSchema = this.f13199gv.onValidateSchema(db);
            if (onValidateSchema.y) {
                this.f13199gv.onPostMigrate(db);
                i9(db);
                return;
            }
            throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.f13202n3);
        }
        s sVar2 = this.f13201zn;
        if (sVar2 != null && !sVar2.y(i, i5)) {
            this.f13199gv.dropAllTables(db);
            this.f13199gv.createAllTables(db);
            return;
        }
        throw new IllegalStateException("A migration from " + i + " to " + i5 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    @Override // u0.s.y
    public void gv(u0.fb db) {
        Intrinsics.checkNotNullParameter(db, "db");
        boolean y2 = f13197fb.y(db);
        this.f13199gv.createAllTables(db);
        if (!y2) {
            zn onValidateSchema = this.f13199gv.onValidateSchema(db);
            if (!onValidateSchema.y) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.f13202n3);
            }
        }
        i9(db);
        this.f13199gv.onCreate(db);
    }

    public final void i9(u0.fb fbVar) {
        c5(fbVar);
        fbVar.execSQL(f3.y(this.f13200v));
    }

    @Override // u0.s.y
    public void n3(u0.fb db) {
        Intrinsics.checkNotNullParameter(db, "db");
        super.n3(db);
    }

    public final void s(u0.fb fbVar) {
        zn onValidateSchema;
        String str;
        if (f13197fb.n3(fbVar)) {
            Cursor y42 = fbVar.y4(new u0.y("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                Cursor cursor = y42;
                if (cursor.moveToFirst()) {
                    str = cursor.getString(0);
                } else {
                    str = null;
                }
                CloseableKt.closeFinally(y42, null);
                if (!Intrinsics.areEqual(this.f13200v, str) && !Intrinsics.areEqual(this.f13198a, str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.f13200v + ", found: " + str);
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(y42, th);
                    throw th2;
                }
            }
        }
        if (this.f13199gv.onValidateSchema(fbVar).y) {
            this.f13199gv.onPostMigrate(fbVar);
            i9(fbVar);
            return;
        }
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.f13202n3);
    }

    @Override // u0.s.y
    public void v(u0.fb db, int i, int i5) {
        Intrinsics.checkNotNullParameter(db, "db");
        fb(db, i, i5);
    }
}
