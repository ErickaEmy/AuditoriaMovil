package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EntityInsertionAdapter.kt */
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter extends SharedSQLiteStatement {
    protected abstract void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase database) {
        super(database);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    public final void insert(Object obj) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, obj);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (Object obj : entities) {
                bind(acquire, obj);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(Object obj) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, obj);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }
}
