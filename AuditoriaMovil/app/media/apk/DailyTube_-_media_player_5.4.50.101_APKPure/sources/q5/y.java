package q5;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.NonNull;
import l.f;
/* loaded from: classes.dex */
public class y extends zn<Boolean> {

    /* renamed from: c5  reason: collision with root package name */
    public static final String f12771c5 = f.a("BatteryChrgTracker");

    public y(@NonNull Context context, @NonNull ix.y yVar) {
        super(context, yVar);
    }

    @Override // q5.gv
    /* renamed from: c5 */
    public Boolean n3() {
        Intent registerReceiver = this.f12762n3.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            f.zn().n3(f12771c5, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return Boolean.valueOf(i9(registerReceiver));
    }

    @Override // q5.zn
    public IntentFilter fb() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    public final boolean i9(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r7.equals("android.os.action.DISCHARGING") == false) goto L7;
     */
    @Override // q5.zn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(android.content.Context r6, @androidx.annotation.NonNull android.content.Intent r7) {
        /*
            r5 = this;
            r6 = 1
            r0 = 0
            java.lang.String r7 = r7.getAction()
            if (r7 != 0) goto L9
            return
        L9:
            l.f r1 = l.f.zn()
            java.lang.String r2 = q5.y.f12771c5
            java.lang.String r3 = "Received %s"
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r0] = r7
            java.lang.String r3 = java.lang.String.format(r3, r4)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r0]
            r1.y(r2, r3, r4)
            r1 = -1
            int r2 = r7.hashCode()
            switch(r2) {
                case -1886648615: goto L47;
                case -54942926: goto L3e;
                case 948344062: goto L33;
                case 1019184907: goto L28;
                default: goto L26;
            }
        L26:
            r6 = -1
            goto L51
        L28:
            java.lang.String r6 = "android.intent.action.ACTION_POWER_CONNECTED"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L31
            goto L26
        L31:
            r6 = 3
            goto L51
        L33:
            java.lang.String r6 = "android.os.action.CHARGING"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L3c
            goto L26
        L3c:
            r6 = 2
            goto L51
        L3e:
            java.lang.String r0 = "android.os.action.DISCHARGING"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L51
            goto L26
        L47:
            java.lang.String r6 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L50
            goto L26
        L50:
            r6 = 0
        L51:
            switch(r6) {
                case 0: goto L67;
                case 1: goto L61;
                case 2: goto L5b;
                case 3: goto L55;
                default: goto L54;
            }
        L54:
            goto L6c
        L55:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.gv(r6)
            goto L6c
        L5b:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.gv(r6)
            goto L6c
        L61:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.gv(r6)
            goto L6c
        L67:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.gv(r6)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.y.s(android.content.Context, android.content.Intent):void");
    }
}
