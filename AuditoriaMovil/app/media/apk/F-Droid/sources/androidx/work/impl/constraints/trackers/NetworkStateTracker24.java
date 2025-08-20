package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NetworkStateTracker.kt */
/* loaded from: classes.dex */
public final class NetworkStateTracker24 extends ConstraintTracker {
    private final ConnectivityManager connectivityManager;
    private final NetworkStateTracker24$networkCallback$1 networkCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1] */
    public NetworkStateTracker24(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        Object systemService = getAppContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
                String str;
                ConnectivityManager connectivityManager;
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(capabilities, "capabilities");
                Logger logger = Logger.get();
                str = NetworkStateTrackerKt.TAG;
                logger.debug(str, "Network capabilities changed: " + capabilities);
                NetworkStateTracker24 networkStateTracker24 = NetworkStateTracker24.this;
                connectivityManager = networkStateTracker24.connectivityManager;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(connectivityManager));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                String str;
                ConnectivityManager connectivityManager;
                Intrinsics.checkNotNullParameter(network, "network");
                Logger logger = Logger.get();
                str = NetworkStateTrackerKt.TAG;
                logger.debug(str, "Network connection lost");
                NetworkStateTracker24 networkStateTracker24 = NetworkStateTracker24.this;
                connectivityManager = networkStateTracker24.connectivityManager;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(connectivityManager));
            }
        };
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        String str;
        String str2;
        String str3;
        try {
            Logger logger = Logger.get();
            str3 = NetworkStateTrackerKt.TAG;
            logger.debug(str3, "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e) {
            Logger logger2 = Logger.get();
            str2 = NetworkStateTrackerKt.TAG;
            logger2.error(str2, "Received exception while registering network callback", e);
        } catch (SecurityException e2) {
            Logger logger3 = Logger.get();
            str = NetworkStateTrackerKt.TAG;
            logger3.error(str, "Received exception while registering network callback", e2);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        String str;
        String str2;
        String str3;
        try {
            Logger logger = Logger.get();
            str3 = NetworkStateTrackerKt.TAG;
            logger.debug(str3, "Unregistering network callback");
            NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e) {
            Logger logger2 = Logger.get();
            str2 = NetworkStateTrackerKt.TAG;
            logger2.error(str2, "Received exception while unregistering network callback", e);
        } catch (SecurityException e2) {
            Logger logger3 = Logger.get();
            str = NetworkStateTrackerKt.TAG;
            logger3.error(str, "Received exception while unregistering network callback", e2);
        }
    }
}
