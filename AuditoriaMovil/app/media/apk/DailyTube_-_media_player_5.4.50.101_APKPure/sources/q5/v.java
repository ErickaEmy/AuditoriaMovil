package q5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import l.f;
/* loaded from: classes.dex */
public class v extends gv<w2.n3> {

    /* renamed from: i9  reason: collision with root package name */
    public static final String f12767i9 = f.a("NetworkStateTracker");

    /* renamed from: c5  reason: collision with root package name */
    public y f12768c5;

    /* renamed from: fb  reason: collision with root package name */
    public final ConnectivityManager f12769fb;

    /* renamed from: s  reason: collision with root package name */
    public n3 f12770s;

    /* loaded from: classes.dex */
    public class n3 extends ConnectivityManager.NetworkCallback {
        public n3() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            f.zn().y(v.f12767i9, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            v vVar = v.this;
            vVar.gv(vVar.fb());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            f.zn().y(v.f12767i9, "Network connection lost", new Throwable[0]);
            v vVar = v.this;
            vVar.gv(vVar.fb());
        }
    }

    /* loaded from: classes.dex */
    public class y extends BroadcastReceiver {
        public y() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                f.zn().y(v.f12767i9, "Network broadcast received", new Throwable[0]);
                v vVar = v.this;
                vVar.gv(vVar.fb());
            }
        }
    }

    public v(@NonNull Context context, @NonNull ix.y yVar) {
        super(context, yVar);
        this.f12769fb = (ConnectivityManager) this.f12762n3.getSystemService("connectivity");
        if (i9()) {
            this.f12770s = new n3();
        } else {
            this.f12768c5 = new y();
        }
    }

    public static boolean i9() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    @Override // q5.gv
    public void a() {
        if (i9()) {
            try {
                f.zn().y(f12767i9, "Unregistering network callback", new Throwable[0]);
                this.f12769fb.unregisterNetworkCallback(this.f12770s);
                return;
            } catch (IllegalArgumentException | SecurityException e2) {
                f.zn().n3(f12767i9, "Received exception while unregistering network callback", e2);
                return;
            }
        }
        f.zn().y(f12767i9, "Unregistering broadcast receiver", new Throwable[0]);
        this.f12762n3.unregisterReceiver(this.f12768c5);
    }

    public boolean c5() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = this.f12769fb.getNetworkCapabilities(this.f12769fb.getActiveNetwork());
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e2) {
            f.zn().n3(f12767i9, "Unable to validate active network", e2);
            return false;
        }
    }

    public w2.n3 fb() {
        boolean z2;
        NetworkInfo activeNetworkInfo = this.f12769fb.getActiveNetworkInfo();
        boolean z3 = false;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean c52 = c5();
        boolean y2 = x.y.y(this.f12769fb);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z3 = true;
        }
        return new w2.n3(z2, c52, y2, z3);
    }

    @Override // q5.gv
    /* renamed from: s */
    public w2.n3 n3() {
        return fb();
    }

    @Override // q5.gv
    public void v() {
        if (i9()) {
            try {
                f.zn().y(f12767i9, "Registering network callback", new Throwable[0]);
                this.f12769fb.registerDefaultNetworkCallback(this.f12770s);
                return;
            } catch (IllegalArgumentException | SecurityException e2) {
                f.zn().n3(f12767i9, "Received exception while registering network callback", e2);
                return;
            }
        }
        f.zn().y(f12767i9, "Registering broadcast receiver", new Throwable[0]);
        this.f12762n3.registerReceiver(this.f12768c5, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
