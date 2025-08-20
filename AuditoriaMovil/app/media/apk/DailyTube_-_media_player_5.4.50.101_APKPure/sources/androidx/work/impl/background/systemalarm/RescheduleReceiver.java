package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import gq.c5;
import l.f;
/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    public static final String y = f.a("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f.zn().y(y, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                c5.xc(context).f3(goAsync());
                return;
            } catch (IllegalStateException e2) {
                f.zn().n3(y, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
                return;
            }
        }
        context.startService(y.v(context));
    }
}
