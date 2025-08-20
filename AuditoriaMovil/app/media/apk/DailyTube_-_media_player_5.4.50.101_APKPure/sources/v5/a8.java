package v5;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class a8 implements v {
    @Override // v5.v
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // v5.v
    public p n3(Looper looper, @Nullable Handler.Callback callback) {
        return new x(new Handler(looper, callback));
    }

    @Override // v5.v
    public long y() {
        return SystemClock.uptimeMillis();
    }

    @Override // v5.v
    public void zn() {
    }
}
