package n0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import j0.zn;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import k0.gv;
/* loaded from: classes.dex */
public final class en extends gv {
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public static en f11795i9;

    /* renamed from: c5  reason: collision with root package name */
    public final Set f11796c5;

    /* renamed from: fb  reason: collision with root package name */
    public final Handler f11797fb;

    /* renamed from: s  reason: collision with root package name */
    public final ud f11798s;

    public en(Context context, ud udVar) {
        super(new zn("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f11797fb = new Handler(Looper.getMainLooper());
        this.f11796c5 = new LinkedHashSet();
        this.f11798s = udVar;
    }

    public static synchronized en s(Context context) {
        en enVar;
        synchronized (en.class) {
            try {
                if (f11795i9 == null) {
                    f11795i9 = new en(context, j5.INSTANCE);
                }
                enVar = f11795i9;
            } catch (Throwable th) {
                throw th;
            }
        }
        return enVar;
    }

    public final synchronized void i9(a aVar) {
        try {
            Iterator it = new LinkedHashSet(this.f11796c5).iterator();
            while (it.hasNext()) {
                ((fb) it.next()).y(aVar);
            }
            super.v(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // k0.gv
    public final void y(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra == null) {
            return;
        }
        a wz2 = a.wz(bundleExtra);
        this.y.y("ListenerRegistryBroadcastReceiver.onReceive: %s", wz2);
        a8 zza = this.f11798s.zza();
        if (wz2.c5() == 3 && zza != null) {
            zza.y(wz2.tl(), new k(this, wz2, intent, context));
        } else {
            i9(wz2);
        }
    }
}
