package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.List;
import l.f;
import l.t;
import le.w;
/* loaded from: classes.dex */
public abstract class ConstraintProxy extends BroadcastReceiver {
    public static final String y = f.a("ConstraintProxy");

    /* loaded from: classes.dex */
    public static class BatteryChargingProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    /* loaded from: classes.dex */
    public static class BatteryNotLowProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    /* loaded from: classes.dex */
    public static class NetworkStateProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    /* loaded from: classes.dex */
    public static class StorageNotLowProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static void y(Context context, List<w> list) {
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z7 = false;
        for (w wVar : list) {
            l.n3 n3Var = wVar.f10336i9;
            z3 |= n3Var.a();
            z4 |= n3Var.fb();
            z5 |= n3Var.c5();
            if (n3Var.n3() != t.NOT_REQUIRED) {
                z2 = true;
            } else {
                z2 = false;
            }
            z7 |= z2;
            if (z3 && z4 && z5 && z7) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.y(context, z3, z4, z5, z7));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f.zn().y(y, String.format("onReceive : %s", intent), new Throwable[0]);
        context.startService(y.y(context));
    }
}
