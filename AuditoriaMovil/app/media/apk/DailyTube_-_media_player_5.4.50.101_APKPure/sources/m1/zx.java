package m1;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class zx {

    /* renamed from: gv  reason: collision with root package name */
    public boolean f11403gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public WifiManager.WifiLock f11404n3;
    @Nullable
    public final WifiManager y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f11405zn;

    public zx(Context context) {
        this.y = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public void n3(boolean z2) {
        this.f11403gv = z2;
        zn();
    }

    public void y(boolean z2) {
        if (z2 && this.f11404n3 == null) {
            WifiManager wifiManager = this.y;
            if (wifiManager == null) {
                v5.r.c5("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
            this.f11404n3 = createWifiLock;
            createWifiLock.setReferenceCounted(false);
        }
        this.f11405zn = z2;
        zn();
    }

    public final void zn() {
        WifiManager.WifiLock wifiLock = this.f11404n3;
        if (wifiLock == null) {
            return;
        }
        if (this.f11405zn && this.f11403gv) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
