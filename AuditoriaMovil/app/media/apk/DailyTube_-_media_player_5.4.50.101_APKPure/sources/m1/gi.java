package m1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class gi {

    /* renamed from: gv  reason: collision with root package name */
    public boolean f10763gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public PowerManager.WakeLock f10764n3;
    @Nullable
    public final PowerManager y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f10765zn;

    public gi(Context context) {
        this.y = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void n3(boolean z2) {
        this.f10763gv = z2;
        zn();
    }

    public void y(boolean z2) {
        if (z2 && this.f10764n3 == null) {
            PowerManager powerManager = this.y;
            if (powerManager == null) {
                v5.r.c5("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
            this.f10764n3 = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.f10765zn = z2;
        zn();
    }

    @SuppressLint({"WakelockTimeout"})
    public final void zn() {
        PowerManager.WakeLock wakeLock = this.f10764n3;
        if (wakeLock == null) {
            return;
        }
        if (this.f10765zn && this.f10763gv) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
