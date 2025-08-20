package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NetworkApi24.kt */
/* loaded from: classes.dex */
public abstract class NetworkApi24 {
    public static final void registerDefaultNetworkCallbackCompat(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        Intrinsics.checkNotNullParameter(connectivityManager, "<this>");
        Intrinsics.checkNotNullParameter(networkCallback, "networkCallback");
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
