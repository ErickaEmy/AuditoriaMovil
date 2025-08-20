package v5;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public interface v {
    public static final v y = new a8();

    long elapsedRealtime();

    p n3(Looper looper, @Nullable Handler.Callback callback);

    long y();

    void zn();
}
