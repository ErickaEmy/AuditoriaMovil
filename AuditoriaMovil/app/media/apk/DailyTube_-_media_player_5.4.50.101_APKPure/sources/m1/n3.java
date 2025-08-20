package m1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final y f11006n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f11007zn;

    /* renamed from: m1.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0153n3 {
        void fb();
    }

    /* loaded from: classes.dex */
    public final class y extends BroadcastReceiver implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final Handler f11009v;
        public final InterfaceC0153n3 y;

        public y(Handler handler, InterfaceC0153n3 interfaceC0153n3) {
            this.f11009v = handler;
            this.y = interfaceC0153n3;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f11009v.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n3.this.f11007zn) {
                this.y.fb();
            }
        }
    }

    public n3(Context context, Handler handler, InterfaceC0153n3 interfaceC0153n3) {
        this.y = context.getApplicationContext();
        this.f11006n3 = new y(handler, interfaceC0153n3);
    }

    public void n3(boolean z2) {
        if (z2 && !this.f11007zn) {
            this.y.registerReceiver(this.f11006n3, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f11007zn = true;
        } else if (!z2 && this.f11007zn) {
            this.y.unregisterReceiver(this.f11006n3);
            this.f11007zn = false;
        }
    }
}
