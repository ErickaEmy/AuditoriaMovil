package b;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class gv {

    /* loaded from: classes.dex */
    public static class y {
        public static void n3(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }

        public static IBinder y(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }
    }

    public static void n3(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        y.n3(bundle, str, iBinder);
    }

    @Nullable
    public static IBinder y(@NonNull Bundle bundle, @Nullable String str) {
        return y.y(bundle, str);
    }
}
