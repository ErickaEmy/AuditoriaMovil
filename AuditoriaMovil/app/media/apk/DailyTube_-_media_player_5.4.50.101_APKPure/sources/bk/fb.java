package bk;

import android.database.sqlite.SQLiteProgram;
import kotlin.jvm.internal.Intrinsics;
import u0.c5;
/* loaded from: classes.dex */
public class fb implements c5 {
    public final SQLiteProgram y;

    public fb(SQLiteProgram delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.y = delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.y.close();
    }

    @Override // u0.c5
    public void e(int i, long j2) {
        this.y.bindLong(i, j2);
    }

    @Override // u0.c5
    public void pz(int i) {
        this.y.bindNull(i);
    }

    @Override // u0.c5
    public void t(int i, double d2) {
        this.y.bindDouble(i, d2);
    }

    @Override // u0.c5
    public void xg(int i, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.y.bindString(i, value);
    }

    @Override // u0.c5
    public void yg(int i, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.y.bindBlob(i, value);
    }
}
