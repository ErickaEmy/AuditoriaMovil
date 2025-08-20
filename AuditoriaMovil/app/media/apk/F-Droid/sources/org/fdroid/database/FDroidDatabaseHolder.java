package org.fdroid.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
/* compiled from: FDroidDatabaseHolder.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\b\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lorg/fdroid/database/FDroidDatabaseHolder;", "", "()V", "INSTANCE", "Lorg/fdroid/database/FDroidDatabaseInt;", "INSTANCE$1", "TAG", "", "getTAG$database_release", "()Ljava/lang/String;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher$database_release", "()Lkotlinx/coroutines/CoroutineDispatcher;", "lock", "Ljava/lang/Object;", "getDb", "Lorg/fdroid/database/FDroidDatabase;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "name", "fixture", "Lorg/fdroid/database/FDroidFixture;", "FixtureCallback", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FDroidDatabaseHolder {
    private static volatile FDroidDatabaseInt INSTANCE$1;
    public static final FDroidDatabaseHolder INSTANCE = new FDroidDatabaseHolder();
    private static final Object lock = new Object();
    private static final String TAG = Reflection.getOrCreateKotlinClass(FDroidDatabase.class).getSimpleName();

    private FDroidDatabaseHolder() {
    }

    public static final FDroidDatabase getDb(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getDb$default(context, null, null, 6, null);
    }

    public static final FDroidDatabase getDb(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return getDb$default(context, name, null, 4, null);
    }

    public final String getTAG$database_release() {
        return TAG;
    }

    public final CoroutineDispatcher getDispatcher$database_release() {
        return Dispatchers.getIO();
    }

    public static /* synthetic */ FDroidDatabase getDb$default(Context context, String str, FDroidFixture fDroidFixture, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "fdroid_db";
        }
        if ((i & 4) != 0) {
            fDroidFixture = null;
        }
        return getDb(context, str, fDroidFixture);
    }

    public static final FDroidDatabase getDb(Context context, String name, FDroidFixture fDroidFixture) {
        FDroidDatabaseInt fDroidDatabaseInt;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        FDroidDatabaseInt fDroidDatabaseInt2 = INSTANCE$1;
        if (fDroidDatabaseInt2 != null) {
            return fDroidDatabaseInt2;
        }
        synchronized (lock) {
            try {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                RoomDatabase.Builder databaseBuilder = Room.databaseBuilder(applicationContext, FDroidDatabaseInt.class, name);
                databaseBuilder.addMigrations(MigrationsKt.getMIGRATION_2_3(), MigrationsKt.getMIGRATION_5_6());
                databaseBuilder.fallbackToDestructiveMigration();
                if (fDroidFixture != null) {
                    databaseBuilder.addCallback(new FixtureCallback(fDroidFixture));
                }
                fDroidDatabaseInt = (FDroidDatabaseInt) databaseBuilder.build();
                INSTANCE$1 = fDroidDatabaseInt;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fDroidDatabaseInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FDroidDatabaseHolder.kt */
    /* loaded from: classes2.dex */
    public static final class FixtureCallback extends RoomDatabase.Callback {
        private final FDroidFixture fixture;

        public FixtureCallback(FDroidFixture fixture) {
            Intrinsics.checkNotNullParameter(fixture, "fixture");
            this.fixture = fixture;
        }

        @Override // androidx.room.RoomDatabase.Callback
        public void onCreate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            super.onCreate(db);
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, FDroidDatabaseHolder.INSTANCE.getDispatcher$database_release(), null, new FDroidDatabaseHolder$FixtureCallback$onCreate$1(this, null), 2, null);
        }

        @Override // androidx.room.RoomDatabase.Callback
        public void onDestructiveMigration(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            onCreate(db);
        }
    }
}
