package q5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import l.f;
/* loaded from: classes.dex */
public abstract class zn<T> extends gv<T> {

    /* renamed from: s  reason: collision with root package name */
    public static final String f12772s = f.a("BrdcstRcvrCnstrntTrckr");

    /* renamed from: fb  reason: collision with root package name */
    public final BroadcastReceiver f12773fb;

    /* loaded from: classes.dex */
    public class y extends BroadcastReceiver {
        public y() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                zn.this.s(context, intent);
            }
        }
    }

    public zn(@NonNull Context context, @NonNull ix.y yVar) {
        super(context, yVar);
        this.f12773fb = new y();
    }

    @Override // q5.gv
    public void a() {
        f.zn().y(f12772s, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f12762n3.unregisterReceiver(this.f12773fb);
    }

    public abstract IntentFilter fb();

    public abstract void s(Context context, @NonNull Intent intent);

    @Override // q5.gv
    public void v() {
        f.zn().y(f12772s, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f12762n3.registerReceiver(this.f12773fb, fb());
    }
}
