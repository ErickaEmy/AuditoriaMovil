package gq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.R$bool;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.y;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import l.f;
import l.r;
import l.w;
import l.wz;
import l.x4;
/* loaded from: classes.dex */
public class c5 extends r {

    /* renamed from: a  reason: collision with root package name */
    public gv f8349a;

    /* renamed from: c5  reason: collision with root package name */
    public BroadcastReceiver.PendingResult f8350c5;

    /* renamed from: fb  reason: collision with root package name */
    public cs.v f8351fb;

    /* renamed from: gv  reason: collision with root package name */
    public ix.y f8352gv;

    /* renamed from: n3  reason: collision with root package name */
    public androidx.work.y f8353n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f8354s;

    /* renamed from: v  reason: collision with root package name */
    public List<v> f8355v;
    public Context y;

    /* renamed from: zn  reason: collision with root package name */
    public WorkDatabase f8356zn;

    /* renamed from: i9  reason: collision with root package name */
    public static final String f8346i9 = f.a("WorkManagerImpl");

    /* renamed from: f  reason: collision with root package name */
    public static c5 f8345f = null;

    /* renamed from: t  reason: collision with root package name */
    public static c5 f8347t = null;

    /* renamed from: tl  reason: collision with root package name */
    public static final Object f8348tl = new Object();

    public c5(@NonNull Context context, @NonNull androidx.work.y yVar, @NonNull ix.y yVar2) {
        this(context, yVar, yVar2, context.getResources().getBoolean(R$bool.y));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
        if (gq.c5.f8347t != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
        gq.c5.f8347t = new gq.c5(r4, r5, new ix.n3(r5.t()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        gq.c5.f8345f = gq.c5.f8347t;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void s(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.NonNull androidx.work.y r5) {
        /*
            java.lang.Object r0 = gq.c5.f8348tl
            monitor-enter(r0)
            gq.c5 r1 = gq.c5.f8345f     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L16
            gq.c5 r2 = gq.c5.f8347t     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto Lc
            goto L16
        Lc:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            java.lang.String r5 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L14
            throw r4     // Catch: java.lang.Throwable -> L14
        L14:
            r4 = move-exception
            goto L36
        L16:
            if (r1 != 0) goto L34
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L14
            gq.c5 r1 = gq.c5.f8347t     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L30
            gq.c5 r1 = new gq.c5     // Catch: java.lang.Throwable -> L14
            ix.n3 r2 = new ix.n3     // Catch: java.lang.Throwable -> L14
            java.util.concurrent.Executor r3 = r5.t()     // Catch: java.lang.Throwable -> L14
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L14
            r1.<init>(r4, r5, r2)     // Catch: java.lang.Throwable -> L14
            gq.c5.f8347t = r1     // Catch: java.lang.Throwable -> L14
        L30:
            gq.c5 r4 = gq.c5.f8347t     // Catch: java.lang.Throwable -> L14
            gq.c5.f8345f = r4     // Catch: java.lang.Throwable -> L14
        L34:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L36:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: gq.c5.s(android.content.Context, androidx.work.y):void");
    }

    @Nullable
    @Deprecated
    public static c5 wz() {
        synchronized (f8348tl) {
            try {
                c5 c5Var = f8345f;
                if (c5Var != null) {
                    return c5Var;
                }
                return f8347t;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static c5 xc(@NonNull Context context) {
        c5 wz2;
        synchronized (f8348tl) {
            try {
                wz2 = wz();
                if (wz2 == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext instanceof y.zn) {
                        s(applicationContext, ((y.zn) applicationContext).y());
                        wz2 = xc(applicationContext);
                    } else {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return wz2;
    }

    public void c(@NonNull String str, @Nullable WorkerParameters.y yVar) {
        this.f8352gv.n3(new cs.s(this, str, yVar));
    }

    @NonNull
    public wz c5(@NonNull UUID uuid) {
        cs.y n32 = cs.y.n3(uuid, this);
        this.f8352gv.n3(n32);
        return n32.v();
    }

    @NonNull
    public WorkDatabase co() {
        return this.f8356zn;
    }

    public void d0(@NonNull String str) {
        this.f8352gv.n3(new cs.c5(this, str, true));
    }

    @NonNull
    public fb f(@NonNull String str, @NonNull l.gv gvVar, @NonNull w wVar) {
        l.v vVar;
        if (gvVar == l.gv.KEEP) {
            vVar = l.v.KEEP;
        } else {
            vVar = l.v.REPLACE;
        }
        return new fb(this, str, vVar, Collections.singletonList(wVar));
    }

    public void f3(@NonNull BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f8348tl) {
            try {
                this.f8350c5 = pendingResult;
                if (this.f8354s) {
                    pendingResult.finish();
                    this.f8350c5 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void fh(@NonNull String str) {
        this.f8352gv.n3(new cs.c5(this, str, false));
    }

    public void i4() {
        if (Build.VERSION.SDK_INT >= 23) {
            w9.n3.n3(t());
        }
        co().f().f();
        a.n3(tl(), co(), mt());
    }

    @NonNull
    public List<v> i9(@NonNull Context context, @NonNull androidx.work.y yVar, @NonNull ix.y yVar2) {
        return Arrays.asList(a.y(context, this), new vp.n3(context, yVar, yVar2, this));
    }

    @NonNull
    public List<v> mt() {
        return this.f8355v;
    }

    public void n(@NonNull String str) {
        c(str, null);
    }

    @Override // l.r
    @NonNull
    public wz n3(@NonNull String str) {
        cs.y zn2 = cs.y.zn(str, this, true);
        this.f8352gv.n3(zn2);
        return zn2.v();
    }

    @NonNull
    public gv p() {
        return this.f8349a;
    }

    public final void r(@NonNull Context context, @NonNull androidx.work.y yVar, @NonNull ix.y yVar2, @NonNull WorkDatabase workDatabase, @NonNull List<v> list, @NonNull gv gvVar) {
        Context applicationContext = context.getApplicationContext();
        this.y = applicationContext;
        this.f8353n3 = yVar;
        this.f8352gv = yVar2;
        this.f8356zn = workDatabase;
        this.f8355v = list;
        this.f8349a = gvVar;
        this.f8351fb = new cs.v(workDatabase);
        this.f8354s = false;
        if (Build.VERSION.SDK_INT >= 24 && applicationContext.isDeviceProtectedStorage()) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.f8352gv.n3(new ForceStopRunnable(applicationContext, this));
    }

    @NonNull
    public Context t() {
        return this.y;
    }

    @NonNull
    public androidx.work.y tl() {
        return this.f8353n3;
    }

    @Override // l.r
    @NonNull
    public wz v(@NonNull String str, @NonNull l.gv gvVar, @NonNull w wVar) {
        return f(str, gvVar, wVar).y();
    }

    @NonNull
    public cs.v w() {
        return this.f8351fb;
    }

    public void x4() {
        synchronized (f8348tl) {
            try {
                this.f8354s = true;
                BroadcastReceiver.PendingResult pendingResult = this.f8350c5;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f8350c5 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // l.r
    @NonNull
    public wz y(@NonNull String str) {
        cs.y gv2 = cs.y.gv(str, this);
        this.f8352gv.n3(gv2);
        return gv2.v();
    }

    @NonNull
    public ix.y z() {
        return this.f8352gv;
    }

    @Override // l.r
    @NonNull
    public wz zn(@NonNull List<? extends x4> list) {
        if (!list.isEmpty()) {
            return new fb(this, list).y();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public c5(@NonNull Context context, @NonNull androidx.work.y yVar, @NonNull ix.y yVar2, boolean z2) {
        this(context, yVar, yVar2, WorkDatabase.y(context.getApplicationContext(), yVar2.getBackgroundExecutor(), z2));
    }

    public c5(@NonNull Context context, @NonNull androidx.work.y yVar, @NonNull ix.y yVar2, @NonNull WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        f.v(new f.y(yVar.i9()));
        List<v> i92 = i9(applicationContext, yVar, yVar2);
        r(context, yVar, yVar2, workDatabase, i92, new gv(context, yVar, yVar2, workDatabase, i92));
    }
}
