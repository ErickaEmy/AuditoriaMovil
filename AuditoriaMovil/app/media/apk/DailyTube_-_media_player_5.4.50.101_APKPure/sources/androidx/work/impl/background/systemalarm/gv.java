package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cs.fb;
import cs.i9;
import cs.wz;
import gq.c5;
import java.util.ArrayList;
import java.util.List;
import l.f;
/* loaded from: classes.dex */
public class gv implements gq.n3 {

    /* renamed from: r  reason: collision with root package name */
    public static final String f3702r = f.a("SystemAlarmDispatcher");

    /* renamed from: co  reason: collision with root package name */
    public Intent f3703co;

    /* renamed from: f  reason: collision with root package name */
    public final c5 f3704f;

    /* renamed from: fb  reason: collision with root package name */
    public final wz f3705fb;

    /* renamed from: p  reason: collision with root package name */
    public final List<Intent> f3706p;

    /* renamed from: s  reason: collision with root package name */
    public final gq.gv f3707s;

    /* renamed from: t  reason: collision with root package name */
    public final androidx.work.impl.background.systemalarm.y f3708t;

    /* renamed from: v  reason: collision with root package name */
    public final ix.y f3709v;

    /* renamed from: w  reason: collision with root package name */
    public final Handler f3710w;
    public final Context y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public zn f3711z;

    /* renamed from: androidx.work.impl.background.systemalarm.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0029gv implements Runnable {
        public final gv y;

        public RunnableC0029gv(@NonNull gv gvVar) {
            this.y = gvVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.zn();
        }
    }

    /* loaded from: classes.dex */
    public static class n3 implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final int f3712fb;

        /* renamed from: v  reason: collision with root package name */
        public final Intent f3713v;
        public final gv y;

        public n3(@NonNull gv gvVar, @NonNull Intent intent, int i) {
            this.y = gvVar;
            this.f3713v = intent;
            this.f3712fb = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.y(this.f3713v, this.f3712fb);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gv gvVar;
            RunnableC0029gv runnableC0029gv;
            synchronized (gv.this.f3706p) {
                gv gvVar2 = gv.this;
                gvVar2.f3703co = gvVar2.f3706p.get(0);
            }
            Intent intent = gv.this.f3703co;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = gv.this.f3703co.getIntExtra("KEY_START_ID", 0);
                f zn2 = f.zn();
                String str = gv.f3702r;
                zn2.y(str, String.format("Processing command %s, %s", gv.this.f3703co, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock n32 = i9.n3(gv.this.y, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    f.zn().y(str, String.format("Acquiring operation wake lock (%s) %s", action, n32), new Throwable[0]);
                    n32.acquire();
                    gv gvVar3 = gv.this;
                    gvVar3.f3708t.w(gvVar3.f3703co, intExtra, gvVar3);
                    f.zn().y(str, String.format("Releasing operation wake lock (%s) %s", action, n32), new Throwable[0]);
                    n32.release();
                    gvVar = gv.this;
                    runnableC0029gv = new RunnableC0029gv(gvVar);
                } catch (Throwable th) {
                    try {
                        f zn3 = f.zn();
                        String str2 = gv.f3702r;
                        zn3.n3(str2, "Unexpected error in onHandleIntent", th);
                        f.zn().y(str2, String.format("Releasing operation wake lock (%s) %s", action, n32), new Throwable[0]);
                        n32.release();
                        gvVar = gv.this;
                        runnableC0029gv = new RunnableC0029gv(gvVar);
                    } catch (Throwable th2) {
                        f.zn().y(gv.f3702r, String.format("Releasing operation wake lock (%s) %s", action, n32), new Throwable[0]);
                        n32.release();
                        gv gvVar4 = gv.this;
                        gvVar4.f(new RunnableC0029gv(gvVar4));
                        throw th2;
                    }
                }
                gvVar.f(runnableC0029gv);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void n3();
    }

    public gv(@NonNull Context context) {
        this(context, null, null);
    }

    public ix.y a() {
        return this.f3709v;
    }

    public final boolean c5(@NonNull String str) {
        n3();
        synchronized (this.f3706p) {
            try {
                for (Intent intent : this.f3706p) {
                    if (str.equals(intent.getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(@NonNull Runnable runnable) {
        this.f3710w.post(runnable);
    }

    public c5 fb() {
        return this.f3704f;
    }

    @Override // gq.n3
    public void gv(@NonNull String str, boolean z2) {
        f(new n3(this, androidx.work.impl.background.systemalarm.y.zn(this.y, str, z2), 0));
    }

    public void i9() {
        f.zn().y(f3702r, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f3707s.c5(this);
        this.f3705fb.y();
        this.f3711z = null;
    }

    public final void n3() {
        if (this.f3710w.getLooper().getThread() == Thread.currentThread()) {
            return;
        }
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }

    public wz s() {
        return this.f3705fb;
    }

    public final void t() {
        n3();
        PowerManager.WakeLock n32 = i9.n3(this.y, "ProcessCommand");
        try {
            n32.acquire();
            this.f3704f.z().n3(new y());
        } finally {
            n32.release();
        }
    }

    public void tl(@NonNull zn znVar) {
        if (this.f3711z != null) {
            f.zn().n3(f3702r, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f3711z = znVar;
        }
    }

    public gq.gv v() {
        return this.f3707s;
    }

    public boolean y(@NonNull Intent intent, int i) {
        f zn2 = f.zn();
        String str = f3702r;
        zn2.y(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i)), new Throwable[0]);
        n3();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            f.zn().s(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && c5("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i);
            synchronized (this.f3706p) {
                try {
                    boolean isEmpty = this.f3706p.isEmpty();
                    this.f3706p.add(intent);
                    if (isEmpty) {
                        t();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    }

    public void zn() {
        f zn2 = f.zn();
        String str = f3702r;
        zn2.y(str, "Checking if commands are complete.", new Throwable[0]);
        n3();
        synchronized (this.f3706p) {
            try {
                if (this.f3703co != null) {
                    f.zn().y(str, String.format("Removing command %s", this.f3703co), new Throwable[0]);
                    if (this.f3706p.remove(0).equals(this.f3703co)) {
                        this.f3703co = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                fb backgroundExecutor = this.f3709v.getBackgroundExecutor();
                if (!this.f3708t.xc() && this.f3706p.isEmpty() && !backgroundExecutor.y()) {
                    f.zn().y(str, "No more commands & intents.", new Throwable[0]);
                    zn znVar = this.f3711z;
                    if (znVar != null) {
                        znVar.n3();
                    }
                } else if (!this.f3706p.isEmpty()) {
                    t();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public gv(@NonNull Context context, @Nullable gq.gv gvVar, @Nullable c5 c5Var) {
        Context applicationContext = context.getApplicationContext();
        this.y = applicationContext;
        this.f3708t = new androidx.work.impl.background.systemalarm.y(applicationContext);
        this.f3705fb = new wz();
        c5Var = c5Var == null ? c5.xc(context) : c5Var;
        this.f3704f = c5Var;
        gvVar = gvVar == null ? c5Var.p() : gvVar;
        this.f3707s = gvVar;
        this.f3709v = c5Var.z();
        gvVar.zn(this);
        this.f3706p = new ArrayList();
        this.f3703co = null;
        this.f3710w = new Handler(Looper.getMainLooper());
    }
}
