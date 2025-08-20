package x;

import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: x.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0246y {
        public static boolean y(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    public static boolean y(@NonNull ConnectivityManager connectivityManager) {
        return C0246y.y(connectivityManager);
    }
}
