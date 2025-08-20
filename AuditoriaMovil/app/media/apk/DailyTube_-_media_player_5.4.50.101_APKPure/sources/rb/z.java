package rb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import rb.p;
import rb.t;
import rb.tl;
import rb.z;
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public p.zn f13271a;

    /* renamed from: c5  reason: collision with root package name */
    public final AtomicBoolean f13272c5;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f13273f;

    /* renamed from: fb  reason: collision with root package name */
    public tl f13274fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Context f13275gv;

    /* renamed from: i9  reason: collision with root package name */
    public final ServiceConnection f13276i9;

    /* renamed from: n3  reason: collision with root package name */
    public final p f13277n3;

    /* renamed from: s  reason: collision with root package name */
    public final t f13278s;

    /* renamed from: t  reason: collision with root package name */
    public final Runnable f13279t;

    /* renamed from: v  reason: collision with root package name */
    public int f13280v;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final Executor f13281zn;

    /* loaded from: classes.dex */
    public static final class n3 extends t.y {
        public n3() {
        }

        public static final void vn(z this$0, String[] tables) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tables, "$tables");
            this$0.v().t((String[]) Arrays.copyOf(tables, tables.length));
        }

        @Override // rb.t
        public void co(final String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            Executor gv2 = z.this.gv();
            final z zVar = z.this;
            gv2.execute(new Runnable() { // from class: rb.r
                @Override // java.lang.Runnable
                public final void run() {
                    z.n3.vn(z.this, tables);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends p.zn {
        public y(String[] strArr) {
            super(strArr);
        }

        @Override // rb.p.zn
        public boolean n3() {
            return true;
        }

        @Override // rb.p.zn
        public void zn(Set<String> tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            if (z.this.i9().get()) {
                return;
            }
            try {
                tl s2 = z.this.s();
                if (s2 != null) {
                    int zn2 = z.this.zn();
                    Object[] array = tables.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    s2.eb(zn2, (String[]) array);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot broadcast invalidation", e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements ServiceConnection {
        public zn() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(service, "service");
            z.this.tl(tl.y.mt(service));
            z.this.gv().execute(z.this.c5());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            z.this.gv().execute(z.this.fb());
            z.this.tl(null);
        }
    }

    public z(Context context, String name, Intent serviceIntent, p invalidationTracker, Executor executor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceIntent, "serviceIntent");
        Intrinsics.checkNotNullParameter(invalidationTracker, "invalidationTracker");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.y = name;
        this.f13277n3 = invalidationTracker;
        this.f13281zn = executor;
        Context applicationContext = context.getApplicationContext();
        this.f13275gv = applicationContext;
        this.f13278s = new n3();
        this.f13272c5 = new AtomicBoolean(false);
        zn znVar = new zn();
        this.f13276i9 = znVar;
        this.f13273f = new Runnable() { // from class: rb.mt
            @Override // java.lang.Runnable
            public final void run() {
                z.wz(z.this);
            }
        };
        this.f13279t = new Runnable() { // from class: rb.co
            @Override // java.lang.Runnable
            public final void run() {
                z.f(z.this);
            }
        };
        Object[] array = invalidationTracker.i9().keySet().toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        t(new y((String[]) array));
        applicationContext.bindService(serviceIntent, znVar, 1);
    }

    public static final void f(z this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f13277n3.xc(this$0.a());
    }

    public static final void wz(z this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            tl tlVar = this$0.f13274fb;
            if (tlVar != null) {
                this$0.f13280v = tlVar.a(this$0.f13278s, this$0.y);
                this$0.f13277n3.n3(this$0.a());
            }
        } catch (RemoteException e2) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e2);
        }
    }

    public final p.zn a() {
        p.zn znVar = this.f13271a;
        if (znVar != null) {
            return znVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        return null;
    }

    public final Runnable c5() {
        return this.f13273f;
    }

    public final Runnable fb() {
        return this.f13279t;
    }

    public final Executor gv() {
        return this.f13281zn;
    }

    public final AtomicBoolean i9() {
        return this.f13272c5;
    }

    public final tl s() {
        return this.f13274fb;
    }

    public final void t(p.zn znVar) {
        Intrinsics.checkNotNullParameter(znVar, "<set-?>");
        this.f13271a = znVar;
    }

    public final void tl(tl tlVar) {
        this.f13274fb = tlVar;
    }

    public final p v() {
        return this.f13277n3;
    }

    public final void xc() {
        if (this.f13272c5.compareAndSet(false, true)) {
            this.f13277n3.xc(a());
            try {
                tl tlVar = this.f13274fb;
                if (tlVar != null) {
                    tlVar.o(this.f13278s, this.f13280v);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e2);
            }
            this.f13275gv.unbindService(this.f13276i9);
        }
    }

    public final int zn() {
        return this.f13280v;
    }
}
