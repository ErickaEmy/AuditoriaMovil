package q5;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import l.f;
/* loaded from: classes.dex */
public class a extends zn<Boolean> {

    /* renamed from: c5  reason: collision with root package name */
    public static final String f12755c5 = f.a("StorageNotLowTracker");

    public a(@NonNull Context context, @NonNull ix.y yVar) {
        super(context, yVar);
    }

    @Override // q5.gv
    /* renamed from: c5 */
    public Boolean n3() {
        Intent registerReceiver = this.f12762n3.registerReceiver(null, fb());
        if (registerReceiver != null && registerReceiver.getAction() != null) {
            String action = registerReceiver.getAction();
            action.hashCode();
            if (!action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                if (!action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                    return null;
                }
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // q5.zn
    public IntentFilter fb() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // q5.zn
    public void s(Context context, @NonNull Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        f.zn().y(f12755c5, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (!action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                gv(Boolean.TRUE);
                return;
            }
            return;
        }
        gv(Boolean.FALSE);
    }
}
