package androidx.core.net;

import android.net.ConnectivityManager;
/* loaded from: classes.dex */
public abstract class ConnectivityManagerCompat {
    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return Api16Impl.isActiveNetworkMetered(connectivityManager);
    }

    /* loaded from: classes.dex */
    static class Api16Impl {
        static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }
}
