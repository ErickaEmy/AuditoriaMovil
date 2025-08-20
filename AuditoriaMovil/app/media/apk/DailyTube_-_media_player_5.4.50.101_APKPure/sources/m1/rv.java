package m1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class rv {

    /* renamed from: a  reason: collision with root package name */
    public int f11238a;

    /* renamed from: fb  reason: collision with root package name */
    public int f11239fb;

    /* renamed from: gv  reason: collision with root package name */
    public final AudioManager f11240gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Handler f11241n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f11242s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public zn f11243v;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final n3 f11244zn;

    /* loaded from: classes.dex */
    public interface n3 {
        void mt(int i, boolean z2);

        void zn(int i);
    }

    /* loaded from: classes.dex */
    public final class zn extends BroadcastReceiver {
        public zn() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = rv.this.f11241n3;
            final rv rvVar = rv.this;
            handler.post(new Runnable() { // from class: m1.dp
                @Override // java.lang.Runnable
                public final void run() {
                    rv.this.c5();
                }
            });
        }
    }

    public rv(Context context, Handler handler, n3 n3Var) {
        Context applicationContext = context.getApplicationContext();
        this.y = applicationContext;
        this.f11241n3 = handler;
        this.f11244zn = n3Var;
        AudioManager audioManager = (AudioManager) v5.y.c5((AudioManager) applicationContext.getSystemService("audio"));
        this.f11240gv = audioManager;
        this.f11238a = 3;
        this.f11239fb = a(audioManager, 3);
        this.f11242s = v(audioManager, this.f11238a);
        zn znVar = new zn();
        try {
            applicationContext.registerReceiver(znVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f11243v = znVar;
        } catch (RuntimeException e2) {
            v5.r.i9("StreamVolumeManager", "Error registering stream volume receiver", e2);
        }
    }

    public static int a(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e2) {
            v5.r.i9("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e2);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public static boolean v(AudioManager audioManager, int i) {
        if (v5.j5.y >= 23) {
            return audioManager.isStreamMute(i);
        }
        if (a(audioManager, i) == 0) {
            return true;
        }
        return false;
    }

    public final void c5() {
        int a2 = a(this.f11240gv, this.f11238a);
        boolean v2 = v(this.f11240gv, this.f11238a);
        if (this.f11239fb != a2 || this.f11242s != v2) {
            this.f11239fb = a2;
            this.f11242s = v2;
            this.f11244zn.mt(a2, v2);
        }
    }

    public void fb() {
        zn znVar = this.f11243v;
        if (znVar != null) {
            try {
                this.y.unregisterReceiver(znVar);
            } catch (RuntimeException e2) {
                v5.r.i9("StreamVolumeManager", "Error unregistering stream volume receiver", e2);
            }
            this.f11243v = null;
        }
    }

    public int gv() {
        if (v5.j5.y >= 28) {
            return this.f11240gv.getStreamMinVolume(this.f11238a);
        }
        return 0;
    }

    public void s(int i) {
        if (this.f11238a == i) {
            return;
        }
        this.f11238a = i;
        c5();
        this.f11244zn.zn(i);
    }

    public int zn() {
        return this.f11240gv.getStreamMaxVolume(this.f11238a);
    }
}
