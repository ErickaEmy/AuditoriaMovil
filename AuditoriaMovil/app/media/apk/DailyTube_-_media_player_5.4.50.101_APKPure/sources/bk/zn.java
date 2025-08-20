package bk;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import u0.f;
import u0.i9;
/* loaded from: classes.dex */
public final class zn implements u0.fb {

    /* renamed from: v  reason: collision with root package name */
    public final List<Pair<String, String>> f3864v;
    public final SQLiteDatabase y;

    /* renamed from: fb  reason: collision with root package name */
    public static final y f3862fb = new y(null);

    /* renamed from: s  reason: collision with root package name */
    public static final String[] f3863s = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f3861f = new String[0];

    /* loaded from: classes.dex */
    public static final class n3 extends Lambda implements Function4<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> {
        final /* synthetic */ i9 $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(i9 i9Var) {
            super(4);
            this.$query = i9Var;
        }

        @Override // kotlin.jvm.functions.Function4
        /* renamed from: y */
        public final SQLiteCursor invoke(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            i9 i9Var = this.$query;
            Intrinsics.checkNotNull(sQLiteQuery);
            i9Var.v(new fb(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public y() {
        }
    }

    public zn(SQLiteDatabase delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.y = delegate;
        this.f3864v = delegate.getAttachedDbs();
    }

    public static final Cursor mt(i9 query, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNullParameter(query, "$query");
        Intrinsics.checkNotNull(sQLiteQuery);
        query.v(new fb(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static final Cursor p(Function4 tmp0, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Cursor) tmp0.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.y.close();
    }

    @Override // u0.fb
    public void d0() {
        this.y.setTransactionSuccessful();
    }

    @Override // u0.fb
    public void execSQL(String sql) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        this.y.execSQL(sql);
    }

    @Override // u0.fb
    public void fb() {
        this.y.beginTransaction();
    }

    @Override // u0.fb
    public void fh(String sql, Object[] bindArgs) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        this.y.execSQL(sql, bindArgs);
    }

    @Override // u0.fb
    public String getPath() {
        return this.y.getPath();
    }

    @Override // u0.fb
    public int getVersion() {
        return this.y.getVersion();
    }

    @Override // u0.fb
    public boolean gq() {
        return u0.n3.n3(this.y);
    }

    @Override // u0.fb
    public boolean isOpen() {
        return this.y.isOpen();
    }

    @Override // u0.fb
    public Cursor ra(final i9 query, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        SQLiteDatabase sQLiteDatabase = this.y;
        String y2 = query.y();
        String[] strArr = f3861f;
        Intrinsics.checkNotNull(cancellationSignal);
        return u0.n3.zn(sQLiteDatabase, y2, strArr, null, cancellationSignal, new SQLiteDatabase.CursorFactory() { // from class: bk.y
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase2, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                Cursor mt2;
                mt2 = zn.mt(i9.this, sQLiteDatabase2, sQLiteCursorDriver, str, sQLiteQuery);
                return mt2;
            }
        });
    }

    @Override // u0.fb
    public Cursor rb(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return y4(new u0.y(query));
    }

    @Override // u0.fb
    public f rs(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        SQLiteStatement compileStatement = this.y.compileStatement(sql);
        Intrinsics.checkNotNullExpressionValue(compileStatement, "delegate.compileStatement(sql)");
        return new s(compileStatement);
    }

    @Override // u0.fb
    public void rz() {
        this.y.beginTransactionNonExclusive();
    }

    public final boolean s(SQLiteDatabase sqLiteDatabase) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        return Intrinsics.areEqual(this.y, sqLiteDatabase);
    }

    @Override // u0.fb
    public List<Pair<String, String>> tl() {
        return this.f3864v;
    }

    @Override // u0.fb
    public boolean xb() {
        return this.y.inTransaction();
    }

    @Override // u0.fb
    public Cursor y4(i9 query) {
        Intrinsics.checkNotNullParameter(query, "query");
        final n3 n3Var = new n3(query);
        Cursor rawQueryWithFactory = this.y.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: bk.n3
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                Cursor p2;
                p2 = zn.p(Function4.this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                return p2;
            }
        }, query.y(), f3861f, null);
        Intrinsics.checkNotNullExpressionValue(rawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return rawQueryWithFactory;
    }

    @Override // u0.fb
    public void z6() {
        this.y.endTransaction();
    }
}
