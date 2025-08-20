package q5;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import l.f;
/* loaded from: classes.dex */
public class n3 extends zn<Boolean> {

    /* renamed from: c5  reason: collision with root package name */
    public static final String f12766c5 = f.a("BatteryNotLowTracker");

    public n3(@NonNull Context context, @NonNull ix.y yVar) {
        super(context, yVar);
    }

    @Override // q5.gv
    /* renamed from: c5 */
    public Boolean n3() {
        Intent registerReceiver = this.f12762n3.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z2 = false;
        if (registerReceiver == null) {
            f.zn().n3(f12766c5, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return Boolean.valueOf((registerReceiver.getIntExtra("status", -1) == 1 || ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)) > 0.15f) ? true : true);
    }

    @Override // q5.zn
    public IntentFilter fb() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // q5.zn
    public void s(Context context, @NonNull Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        f.zn().y(f12766c5, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (!action.equals("android.intent.action.BATTERY_OKAY")) {
            if (action.equals("android.intent.action.BATTERY_LOW")) {
                gv(Boolean.FALSE);
                return;
            }
            return;
        }
        gv(Boolean.TRUE);
    }
}
