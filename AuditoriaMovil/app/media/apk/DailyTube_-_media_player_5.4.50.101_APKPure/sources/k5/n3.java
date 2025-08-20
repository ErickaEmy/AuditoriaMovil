package k5;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class n3 {
    @NonNull
    public static Handler y() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }
}
