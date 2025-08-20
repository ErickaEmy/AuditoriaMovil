package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import gq.c5;
import l.f;
/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final String y = f.a("ConstrntProxyUpdtRecvr");

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f3696fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Context f3698v;
        public final /* synthetic */ Intent y;

        public y(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.y = intent;
            this.f3698v = context;
            this.f3696fb = pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean booleanExtra = this.y.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.y.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.y.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.y.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                f.zn().y(ConstraintProxyUpdateReceiver.y, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                cs.gv.y(this.f3698v, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                cs.gv.y(this.f3698v, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                cs.gv.y(this.f3698v, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                cs.gv.y(this.f3698v, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f3696fb.finish();
            }
        }
    }

    public static Intent y(Context context, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z2).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z3).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z4).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z5);
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(str)) {
            f.zn().y(y, String.format("Ignoring unknown action %s", str), new Throwable[0]);
        } else {
            c5.xc(context).z().n3(new y(intent, context, goAsync()));
        }
    }
}
