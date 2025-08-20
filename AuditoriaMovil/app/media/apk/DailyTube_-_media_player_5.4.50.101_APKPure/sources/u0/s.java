package u0;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public interface s extends Closeable {

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public static final C0223n3 f14018a = new C0223n3(null);

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f14019gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String f14020n3;

        /* renamed from: v  reason: collision with root package name */
        public final boolean f14021v;
        public final Context y;

        /* renamed from: zn  reason: collision with root package name */
        public final y f14022zn;

        /* renamed from: u0.s$n3$n3  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0223n3 {
            public /* synthetic */ C0223n3(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final y y(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new y(context);
            }

            public C0223n3() {
            }
        }

        /* loaded from: classes.dex */
        public static class y {

            /* renamed from: gv  reason: collision with root package name */
            public boolean f14023gv;

            /* renamed from: n3  reason: collision with root package name */
            public String f14024n3;

            /* renamed from: v  reason: collision with root package name */
            public boolean f14025v;
            public final Context y;

            /* renamed from: zn  reason: collision with root package name */
            public y f14026zn;

            public y(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.y = context;
            }

            public y gv(boolean z2) {
                this.f14023gv = z2;
                return this;
            }

            public y n3(y callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.f14026zn = callback;
                return this;
            }

            public n3 y() {
                String str;
                y yVar = this.f14026zn;
                if (yVar != null) {
                    if (this.f14023gv && ((str = this.f14024n3) == null || str.length() == 0)) {
                        throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                    }
                    return new n3(this.y, this.f14024n3, yVar, this.f14023gv, this.f14025v);
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public y zn(String str) {
                this.f14024n3 = str;
                return this;
            }
        }

        public n3(Context context, String str, y callback, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.y = context;
            this.f14020n3 = str;
            this.f14022zn = callback;
            this.f14019gv = z2;
            this.f14021v = z3;
        }

        public static final y y(Context context) {
            return f14018a.y(context);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class y {

        /* renamed from: n3  reason: collision with root package name */
        public static final C0224y f14027n3 = new C0224y(null);
        public final int y;

        /* renamed from: u0.s$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0224y {
            public /* synthetic */ C0224y(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0224y() {
            }
        }

        public y(int i) {
            this.y = i;
        }

        public void a(fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public abstract void fb(fb fbVar, int i, int i5);

        public abstract void gv(fb fbVar);

        public void n3(fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public abstract void v(fb fbVar, int i, int i5);

        public final void y(String str) {
            int i;
            boolean z2;
            if (!StringsKt.equals(str, ":memory:", true)) {
                int length = str.length() - 1;
                int i5 = 0;
                boolean z3 = false;
                while (i5 <= length) {
                    if (!z3) {
                        i = i5;
                    } else {
                        i = length;
                    }
                    if (Intrinsics.compare((int) str.charAt(i), 32) <= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z3) {
                        if (!z2) {
                            z3 = true;
                        } else {
                            i5++;
                        }
                    } else if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                }
                if (str.subSequence(i5, length + 1).toString().length() != 0) {
                    Log.w("SupportSQLite", "deleting the database file: " + str);
                    try {
                        u0.n3.y(new File(str));
                    } catch (Exception e2) {
                        Log.w("SupportSQLite", "delete failed: ", e2);
                    }
                }
            }
        }

        public void zn(fb db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + db + ".path");
            if (!db.isOpen()) {
                String path = db.getPath();
                if (path != null) {
                    y(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = db.tl();
                } catch (SQLiteException unused) {
                }
                try {
                    db.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        Intrinsics.checkNotNullExpressionValue(obj, "p.second");
                        y((String) obj);
                    }
                } else {
                    String path2 = db.getPath();
                    if (path2 != null) {
                        y(path2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        s y(n3 n3Var);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    fb getReadableDatabase();

    fb getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z2);
}
