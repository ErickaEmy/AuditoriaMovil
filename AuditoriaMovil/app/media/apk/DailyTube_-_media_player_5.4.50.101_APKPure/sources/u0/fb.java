package u0;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;
/* loaded from: classes.dex */
public interface fb extends Closeable {
    void d0();

    void execSQL(String str) throws SQLException;

    void fb();

    void fh(String str, Object[] objArr) throws SQLException;

    String getPath();

    int getVersion();

    boolean gq();

    boolean isOpen();

    Cursor ra(i9 i9Var, CancellationSignal cancellationSignal);

    Cursor rb(String str);

    f rs(String str);

    void rz();

    List<Pair<String, String>> tl();

    boolean xb();

    Cursor y4(i9 i9Var);

    void z6();
}
