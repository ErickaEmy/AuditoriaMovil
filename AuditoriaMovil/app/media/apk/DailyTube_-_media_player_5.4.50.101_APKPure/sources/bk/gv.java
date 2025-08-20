package bk;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import bk.gv;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import u0.s;
/* loaded from: classes.dex */
public final class gv implements u0.s {

    /* renamed from: p  reason: collision with root package name */
    public static final y f3840p = new y(null);

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3841f;

    /* renamed from: fb  reason: collision with root package name */
    public final s.y f3842fb;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f3843s;

    /* renamed from: t  reason: collision with root package name */
    public final Lazy<zn> f3844t;

    /* renamed from: v  reason: collision with root package name */
    public final String f3845v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3846w;
    public final Context y;

    /* renamed from: bk.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0037gv extends Lambda implements Function0<zn> {
        public C0037gv() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: y */
        public final zn invoke() {
            zn znVar;
            if (Build.VERSION.SDK_INT >= 23 && gv.this.f3845v != null && gv.this.f3843s) {
                znVar = new zn(gv.this.y, new File(u0.gv.y(gv.this.y), gv.this.f3845v).getAbsolutePath(), new n3(null), gv.this.f3842fb, gv.this.f3841f);
            } else {
                znVar = new zn(gv.this.y, gv.this.f3845v, new n3(null), gv.this.f3842fb, gv.this.f3841f);
            }
            u0.n3.gv(znVar, gv.this.f3846w);
            return znVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public bk.zn y;

        public n3(bk.zn znVar) {
            this.y = znVar;
        }

        public final void n3(bk.zn znVar) {
            this.y = znVar;
        }

        public final bk.zn y() {
            return this.y;
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

    /* loaded from: classes.dex */
    public static final class zn extends SQLiteOpenHelper {

        /* renamed from: p  reason: collision with root package name */
        public static final C0039zn f3847p = new C0039zn(null);

        /* renamed from: f  reason: collision with root package name */
        public boolean f3848f;

        /* renamed from: fb  reason: collision with root package name */
        public final s.y f3849fb;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f3850s;

        /* renamed from: t  reason: collision with root package name */
        public final y4.y f3851t;

        /* renamed from: v  reason: collision with root package name */
        public final n3 f3852v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f3853w;
        public final Context y;

        /* renamed from: bk.gv$zn$gv  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public /* synthetic */ class C0038gv {
            public static final /* synthetic */ int[] y;

            static {
                int[] iArr = new int[n3.values().length];
                try {
                    iArr[n3.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[n3.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[n3.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[n3.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[n3.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                y = iArr;
            }
        }

        /* loaded from: classes.dex */
        public enum n3 {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* loaded from: classes.dex */
        public static final class y extends RuntimeException {
            private final n3 callbackName;
            private final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public y(n3 callbackName, Throwable cause) {
                super(cause);
                Intrinsics.checkNotNullParameter(callbackName, "callbackName");
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.callbackName = callbackName;
                this.cause = cause;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }

            public final n3 y() {
                return this.callbackName;
            }
        }

        /* renamed from: bk.gv$zn$zn  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0039zn {
            public /* synthetic */ C0039zn(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final bk.zn y(n3 refHolder, SQLiteDatabase sqLiteDatabase) {
                Intrinsics.checkNotNullParameter(refHolder, "refHolder");
                Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
                bk.zn y = refHolder.y();
                if (y == null || !y.s(sqLiteDatabase)) {
                    bk.zn znVar = new bk.zn(sqLiteDatabase);
                    refHolder.n3(znVar);
                    return znVar;
                }
                return y;
            }

            public C0039zn() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public zn(Context context, String str, final n3 dbRef, final s.y callback, boolean z2) {
            super(context, str, null, callback.y, new DatabaseErrorHandler() { // from class: bk.v
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    gv.zn.v(s.y.this, dbRef, sQLiteDatabase);
                }
            });
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dbRef, "dbRef");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.y = context;
            this.f3852v = dbRef;
            this.f3849fb = callback;
            this.f3850s = z2;
            if (str == null) {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            File cacheDir = context.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
            this.f3851t = new y4.y(str, cacheDir, false);
        }

        public static final void v(s.y callback, n3 dbRef, SQLiteDatabase dbObj) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(dbRef, "$dbRef");
            C0039zn c0039zn = f3847p;
            Intrinsics.checkNotNullExpressionValue(dbObj, "dbObj");
            callback.zn(c0039zn.y(dbRef, dbObj));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                y4.y.zn(this.f3851t, false, 1, null);
                super.close();
                this.f3852v.n3(null);
                this.f3853w = false;
            } finally {
                this.f3851t.gv();
            }
        }

        public final SQLiteDatabase co(boolean z2) {
            File parentFile;
            String databaseName = getDatabaseName();
            if (databaseName != null && (parentFile = this.y.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return mt(z2);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return mt(z2);
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof y) {
                        y yVar = th;
                        Throwable cause = yVar.getCause();
                        int i = C0038gv.y[yVar.y().ordinal()];
                        if (i != 1 && i != 2 && i != 3 && i != 4) {
                            if (!(cause instanceof SQLiteException)) {
                                throw cause;
                            }
                        } else {
                            throw cause;
                        }
                    } else if (th instanceof SQLiteException) {
                        if (databaseName == null || !this.f3850s) {
                            throw th;
                        }
                    } else {
                        throw th;
                    }
                    this.y.deleteDatabase(databaseName);
                    try {
                        return mt(z2);
                    } catch (y e2) {
                        throw e2.getCause();
                    }
                }
            }
        }

        public final SQLiteDatabase mt(boolean z2) {
            if (z2) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                Intrinsics.checkNotNullExpressionValue(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            Intrinsics.checkNotNullExpressionValue(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            try {
                this.f3849fb.n3(p(db));
            } catch (Throwable th) {
                throw new y(n3.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.f3849fb.gv(p(sqLiteDatabase));
            } catch (Throwable th) {
                throw new y(n3.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db, int i, int i5) {
            Intrinsics.checkNotNullParameter(db, "db");
            this.f3848f = true;
            try {
                this.f3849fb.v(p(db), i, i5);
            } catch (Throwable th) {
                throw new y(n3.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (!this.f3848f) {
                try {
                    this.f3849fb.a(p(db));
                } catch (Throwable th) {
                    throw new y(n3.ON_OPEN, th);
                }
            }
            this.f3853w = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i5) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            this.f3848f = true;
            try {
                this.f3849fb.fb(p(sqLiteDatabase), i, i5);
            } catch (Throwable th) {
                throw new y(n3.ON_UPGRADE, th);
            }
        }

        public final bk.zn p(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            return f3847p.y(this.f3852v, sqLiteDatabase);
        }

        public final u0.fb s(boolean z2) {
            boolean z3;
            try {
                y4.y yVar = this.f3851t;
                if (!this.f3853w && getDatabaseName() != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                yVar.n3(z3);
                this.f3848f = false;
                SQLiteDatabase co2 = co(z2);
                if (this.f3848f) {
                    close();
                    u0.fb s2 = s(z2);
                    this.f3851t.gv();
                    return s2;
                }
                bk.zn p2 = p(co2);
                this.f3851t.gv();
                return p2;
            } catch (Throwable th) {
                this.f3851t.gv();
                throw th;
            }
        }
    }

    public gv(Context context, String str, s.y callback, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.y = context;
        this.f3845v = str;
        this.f3842fb = callback;
        this.f3843s = z2;
        this.f3841f = z3;
        this.f3844t = LazyKt.lazy(new C0037gv());
    }

    @Override // u0.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f3844t.isInitialized()) {
            r().close();
        }
    }

    @Override // u0.s
    public String getDatabaseName() {
        return this.f3845v;
    }

    @Override // u0.s
    public u0.fb getReadableDatabase() {
        return r().s(false);
    }

    @Override // u0.s
    public u0.fb getWritableDatabase() {
        return r().s(true);
    }

    public final zn r() {
        return this.f3844t.getValue();
    }

    @Override // u0.s
    public void setWriteAheadLoggingEnabled(boolean z2) {
        if (this.f3844t.isInitialized()) {
            u0.n3.gv(r(), z2);
        }
        this.f3846w = z2;
    }
}
