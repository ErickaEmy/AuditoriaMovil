package k0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import j0.o4;
import j0.y5;
import j0.zn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class gv {

    /* renamed from: n3  reason: collision with root package name */
    public final IntentFilter f9568n3;
    public final zn y;

    /* renamed from: zn  reason: collision with root package name */
    public final Context f9570zn;

    /* renamed from: gv  reason: collision with root package name */
    public final Set f9567gv = new HashSet();
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public zn f9569v = null;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f9566a = false;

    public gv(zn znVar, IntentFilter intentFilter, Context context) {
        this.y = znVar;
        this.f9568n3 = intentFilter;
        this.f9570zn = y5.y(context);
    }

    public final synchronized boolean a() {
        if (this.f9569v != null) {
            return true;
        }
        return false;
    }

    public final synchronized void gv(boolean z2) {
        this.f9566a = z2;
        n3();
    }

    public final void n3() {
        BroadcastReceiver broadcastReceiver;
        if ((this.f9566a || !this.f9567gv.isEmpty()) && this.f9569v == null) {
            BroadcastReceiver znVar = new zn(this, (n3) null);
            this.f9569v = znVar;
            this.f9570zn.registerReceiver(znVar, this.f9568n3);
        }
        if (!this.f9566a && this.f9567gv.isEmpty() && (broadcastReceiver = this.f9569v) != null) {
            this.f9570zn.unregisterReceiver(broadcastReceiver);
            this.f9569v = null;
        }
    }

    public final synchronized void v(Object obj) {
        Iterator it = new HashSet(this.f9567gv).iterator();
        while (it.hasNext()) {
            ((y) it.next()).y(obj);
        }
    }

    public abstract void y(Context context, Intent intent);

    public final synchronized void zn(y yVar) {
        this.y.gv("registerListener", new Object[0]);
        o4.y(yVar, "Registered Play Core listener should not be null.");
        this.f9567gv.add(yVar);
        n3();
    }
}
