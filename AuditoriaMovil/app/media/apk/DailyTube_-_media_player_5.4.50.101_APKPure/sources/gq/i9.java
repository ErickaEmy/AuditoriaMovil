package gq;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import cs.t;
import cs.tl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import l.f;
import l.z;
import le.p;
import le.w;
import le.z;
/* loaded from: classes.dex */
public class i9 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public static final String f8379b = f.a("WorkerWrapper");

    /* renamed from: c  reason: collision with root package name */
    public z f8380c;

    /* renamed from: co  reason: collision with root package name */
    public androidx.work.y f8381co;

    /* renamed from: d0  reason: collision with root package name */
    public List<String> f8383d0;

    /* renamed from: f  reason: collision with root package name */
    public w f8385f;

    /* renamed from: f3  reason: collision with root package name */
    public p f8386f3;

    /* renamed from: fb  reason: collision with root package name */
    public List<v> f8387fb;

    /* renamed from: fh  reason: collision with root package name */
    public String f8388fh;

    /* renamed from: n  reason: collision with root package name */
    public le.n3 f8389n;

    /* renamed from: r  reason: collision with root package name */
    public WorkDatabase f8391r;

    /* renamed from: s  reason: collision with root package name */
    public WorkerParameters.y f8392s;

    /* renamed from: t  reason: collision with root package name */
    public ListenableWorker f8393t;

    /* renamed from: v  reason: collision with root package name */
    public String f8394v;

    /* renamed from: w  reason: collision with root package name */
    public ix.y f8395w;

    /* renamed from: x  reason: collision with root package name */
    public volatile boolean f8396x;
    public Context y;

    /* renamed from: z  reason: collision with root package name */
    public mp.y f8397z;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public ListenableWorker.y f8390p = ListenableWorker.y.y();
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public ro.zn<Boolean> f8382d = ro.zn.co();
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public f1.zn<ListenableWorker.y> f8384ej = null;

    /* loaded from: classes.dex */
    public class n3 implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ String f8399v;
        public final /* synthetic */ ro.zn y;

        public n3(ro.zn znVar, String str) {
            this.y = znVar;
            this.f8399v = str;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            try {
                try {
                    ListenableWorker.y yVar = (ListenableWorker.y) this.y.get();
                    if (yVar == null) {
                        f.zn().n3(i9.f8379b, String.format("%s returned a null result. Treating it as a failure.", i9.this.f8385f.f10347zn), new Throwable[0]);
                    } else {
                        f.zn().y(i9.f8379b, String.format("%s returned a %s result.", i9.this.f8385f.f10347zn, yVar), new Throwable[0]);
                        i9.this.f8390p = yVar;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    f.zn().n3(i9.f8379b, String.format("%s failed because it threw an exception/error", this.f8399v), e);
                } catch (CancellationException e3) {
                    f.zn().gv(i9.f8379b, String.format("%s was cancelled", this.f8399v), e3);
                } catch (ExecutionException e5) {
                    e = e5;
                    f.zn().n3(i9.f8379b, String.format("%s failed because it threw an exception/error", this.f8399v), e);
                }
                i9.this.a();
            } catch (Throwable th) {
                i9.this.a();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ ro.zn f8401v;
        public final /* synthetic */ f1.zn y;

        public y(f1.zn znVar, ro.zn znVar2) {
            this.y = znVar;
            this.f8401v = znVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.y.get();
                f.zn().y(i9.f8379b, String.format("Starting work for %s", i9.this.f8385f.f10347zn), new Throwable[0]);
                i9 i9Var = i9.this;
                i9Var.f8384ej = i9Var.f8393t.startWork();
                this.f8401v.p(i9.this.f8384ej);
            } catch (Throwable th) {
                this.f8401v.w(th);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public WorkDatabase f8402a;
        @NonNull

        /* renamed from: c5  reason: collision with root package name */
        public WorkerParameters.y f8403c5 = new WorkerParameters.y();
        @NonNull

        /* renamed from: fb  reason: collision with root package name */
        public String f8404fb;
        @NonNull

        /* renamed from: gv  reason: collision with root package name */
        public ix.y f8405gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public ListenableWorker f8406n3;

        /* renamed from: s  reason: collision with root package name */
        public List<v> f8407s;
        @NonNull

        /* renamed from: v  reason: collision with root package name */
        public androidx.work.y f8408v;
        @NonNull
        public Context y;
        @NonNull

        /* renamed from: zn  reason: collision with root package name */
        public mp.y f8409zn;

        public zn(@NonNull Context context, @NonNull androidx.work.y yVar, @NonNull ix.y yVar2, @NonNull mp.y yVar3, @NonNull WorkDatabase workDatabase, @NonNull String str) {
            this.y = context.getApplicationContext();
            this.f8405gv = yVar2;
            this.f8409zn = yVar3;
            this.f8408v = yVar;
            this.f8402a = workDatabase;
            this.f8404fb = str;
        }

        @NonNull
        public zn n3(@Nullable WorkerParameters.y yVar) {
            if (yVar != null) {
                this.f8403c5 = yVar;
            }
            return this;
        }

        @NonNull
        public i9 y() {
            return new i9(this);
        }

        @NonNull
        public zn zn(@NonNull List<v> list) {
            this.f8407s = list;
            return this;
        }
    }

    public i9(@NonNull zn znVar) {
        this.y = znVar.y;
        this.f8395w = znVar.f8405gv;
        this.f8397z = znVar.f8409zn;
        this.f8394v = znVar.f8404fb;
        this.f8387fb = znVar.f8407s;
        this.f8392s = znVar.f8403c5;
        this.f8393t = znVar.f8406n3;
        this.f8381co = znVar.f8408v;
        WorkDatabase workDatabase = znVar.f8402a;
        this.f8391r = workDatabase;
        this.f8386f3 = workDatabase.f();
        this.f8389n = this.f8391r.n3();
        this.f8380c = this.f8391r.t();
    }

    public void a() {
        if (!wz()) {
            this.f8391r.beginTransaction();
            try {
                z.y v2 = this.f8386f3.v(this.f8394v);
                this.f8391r.i9().delete(this.f8394v);
                if (v2 == null) {
                    c5(false);
                } else if (v2 == z.y.RUNNING) {
                    zn(this.f8390p);
                } else if (!v2.y()) {
                    fb();
                }
                this.f8391r.setTransactionSuccessful();
                this.f8391r.endTransaction();
            } catch (Throwable th) {
                this.f8391r.endTransaction();
                throw th;
            }
        }
        List<v> list = this.f8387fb;
        if (list != null) {
            for (v vVar : list) {
                vVar.cancel(this.f8394v);
            }
            a.n3(this.f8381co, this.f8391r, this.f8387fb);
        }
    }

    public final void c5(boolean z2) {
        ListenableWorker listenableWorker;
        this.f8391r.beginTransaction();
        try {
            if (!this.f8391r.f().p()) {
                cs.gv.y(this.y, RescheduleReceiver.class, false);
            }
            if (z2) {
                this.f8386f3.fb(z.y.ENQUEUED, this.f8394v);
                this.f8386f3.t(this.f8394v, -1L);
            }
            if (this.f8385f != null && (listenableWorker = this.f8393t) != null && listenableWorker.isRunInForeground()) {
                this.f8397z.y(this.f8394v);
            }
            this.f8391r.setTransactionSuccessful();
            this.f8391r.endTransaction();
            this.f8382d.xc(Boolean.valueOf(z2));
        } catch (Throwable th) {
            this.f8391r.endTransaction();
            throw th;
        }
    }

    public final void f() {
        androidx.work.n3 n32;
        if (wz()) {
            return;
        }
        this.f8391r.beginTransaction();
        try {
            w a2 = this.f8386f3.a(this.f8394v);
            this.f8385f = a2;
            if (a2 == null) {
                f.zn().n3(f8379b, String.format("Didn't find WorkSpec for id %s", this.f8394v), new Throwable[0]);
                c5(false);
                this.f8391r.setTransactionSuccessful();
            } else if (a2.f10338n3 != z.y.ENQUEUED) {
                i9();
                this.f8391r.setTransactionSuccessful();
                f.zn().y(f8379b, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f8385f.f10347zn), new Throwable[0]);
            } else {
                if (a2.gv() || this.f8385f.zn()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    w wVar = this.f8385f;
                    if (wVar.f10345wz != 0 && currentTimeMillis < wVar.y()) {
                        f.zn().y(f8379b, String.format("Delaying execution for %s because it is being executed before schedule.", this.f8385f.f10347zn), new Throwable[0]);
                        c5(true);
                        this.f8391r.setTransactionSuccessful();
                        return;
                    }
                }
                this.f8391r.setTransactionSuccessful();
                this.f8391r.endTransaction();
                if (this.f8385f.gv()) {
                    n32 = this.f8385f.f10343v;
                } else {
                    l.c5 n33 = this.f8381co.a().n3(this.f8385f.f10335gv);
                    if (n33 == null) {
                        f.zn().n3(f8379b, String.format("Could not create Input Merger %s", this.f8385f.f10335gv), new Throwable[0]);
                        t();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f8385f.f10343v);
                    arrayList.addAll(this.f8386f3.c5(this.f8394v));
                    n32 = n33.n3(arrayList);
                }
                WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f8394v), n32, this.f8383d0, this.f8392s, this.f8385f.f10333f, this.f8381co.v(), this.f8395w, this.f8381co.tl(), new tl(this.f8391r, this.f8395w), new t(this.f8391r, this.f8397z, this.f8395w));
                if (this.f8393t == null) {
                    this.f8393t = this.f8381co.tl().n3(this.y, this.f8385f.f10347zn, workerParameters);
                }
                ListenableWorker listenableWorker = this.f8393t;
                if (listenableWorker == null) {
                    f.zn().n3(f8379b, String.format("Could not create Worker %s", this.f8385f.f10347zn), new Throwable[0]);
                    t();
                } else if (listenableWorker.isUsed()) {
                    f.zn().n3(f8379b, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f8385f.f10347zn), new Throwable[0]);
                    t();
                } else {
                    this.f8393t.setUsed();
                    if (xc()) {
                        if (wz()) {
                            return;
                        }
                        ro.zn co2 = ro.zn.co();
                        cs.f fVar = new cs.f(this.y, this.f8385f, this.f8393t, workerParameters.n3(), this.f8395w);
                        this.f8395w.y().execute(fVar);
                        f1.zn<Void> y2 = fVar.y();
                        y2.addListener(new y(y2, co2), this.f8395w.y());
                        co2.addListener(new n3(co2, this.f8388fh), this.f8395w.getBackgroundExecutor());
                        return;
                    }
                    i9();
                }
            }
        } finally {
            this.f8391r.endTransaction();
        }
    }

    public final void fb() {
        this.f8391r.beginTransaction();
        try {
            this.f8386f3.fb(z.y.ENQUEUED, this.f8394v);
            this.f8386f3.z(this.f8394v, System.currentTimeMillis());
            this.f8386f3.t(this.f8394v, -1L);
            this.f8391r.setTransactionSuccessful();
        } finally {
            this.f8391r.endTransaction();
            c5(true);
        }
    }

    public void gv() {
        boolean z2;
        this.f8396x = true;
        wz();
        f1.zn<ListenableWorker.y> znVar = this.f8384ej;
        if (znVar != null) {
            z2 = znVar.isDone();
            this.f8384ej.cancel(true);
        } else {
            z2 = false;
        }
        ListenableWorker listenableWorker = this.f8393t;
        if (listenableWorker != null && !z2) {
            listenableWorker.stop();
        } else {
            f.zn().y(f8379b, String.format("WorkSpec %s is already done. Not interrupting.", this.f8385f), new Throwable[0]);
        }
    }

    public final void i9() {
        z.y v2 = this.f8386f3.v(this.f8394v);
        if (v2 == z.y.RUNNING) {
            f.zn().y(f8379b, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f8394v), new Throwable[0]);
            c5(true);
            return;
        }
        f.zn().y(f8379b, String.format("Status for %s is %s; not doing any work", this.f8394v, v2), new Throwable[0]);
        c5(false);
    }

    @NonNull
    public f1.zn<Boolean> n3() {
        return this.f8382d;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> y2 = this.f8380c.y(this.f8394v);
        this.f8383d0 = y2;
        this.f8388fh = y(y2);
        f();
    }

    public final void s() {
        this.f8391r.beginTransaction();
        try {
            this.f8386f3.z(this.f8394v, System.currentTimeMillis());
            this.f8386f3.fb(z.y.ENQUEUED, this.f8394v);
            this.f8386f3.mt(this.f8394v);
            this.f8386f3.t(this.f8394v, -1L);
            this.f8391r.setTransactionSuccessful();
        } finally {
            this.f8391r.endTransaction();
            c5(false);
        }
    }

    public void t() {
        this.f8391r.beginTransaction();
        try {
            v(this.f8394v);
            this.f8386f3.xc(this.f8394v, ((ListenableWorker.y.C0028y) this.f8390p).v());
            this.f8391r.setTransactionSuccessful();
        } finally {
            this.f8391r.endTransaction();
            c5(false);
        }
    }

    public final void tl() {
        this.f8391r.beginTransaction();
        try {
            this.f8386f3.fb(z.y.SUCCEEDED, this.f8394v);
            this.f8386f3.xc(this.f8394v, ((ListenableWorker.y.zn) this.f8390p).v());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.f8389n.y(this.f8394v)) {
                if (this.f8386f3.v(str) == z.y.BLOCKED && this.f8389n.n3(str)) {
                    f.zn().gv(f8379b, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.f8386f3.fb(z.y.ENQUEUED, str);
                    this.f8386f3.z(str, currentTimeMillis);
                }
            }
            this.f8391r.setTransactionSuccessful();
            this.f8391r.endTransaction();
            c5(false);
        } catch (Throwable th) {
            this.f8391r.endTransaction();
            c5(false);
            throw th;
        }
    }

    public final void v(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f8386f3.v(str2) != z.y.CANCELLED) {
                this.f8386f3.fb(z.y.FAILED, str2);
            }
            linkedList.addAll(this.f8389n.y(str2));
        }
    }

    public final boolean wz() {
        if (!this.f8396x) {
            return false;
        }
        f.zn().y(f8379b, String.format("Work interrupted for %s", this.f8388fh), new Throwable[0]);
        z.y v2 = this.f8386f3.v(this.f8394v);
        if (v2 == null) {
            c5(false);
        } else {
            c5(!v2.y());
        }
        return true;
    }

    public final boolean xc() {
        boolean z2;
        this.f8391r.beginTransaction();
        try {
            if (this.f8386f3.v(this.f8394v) == z.y.ENQUEUED) {
                this.f8386f3.fb(z.y.RUNNING, this.f8394v);
                this.f8386f3.co(this.f8394v);
                z2 = true;
            } else {
                z2 = false;
            }
            this.f8391r.setTransactionSuccessful();
            this.f8391r.endTransaction();
            return z2;
        } catch (Throwable th) {
            this.f8391r.endTransaction();
            throw th;
        }
    }

    public final String y(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f8394v);
        sb.append(", tags={ ");
        boolean z2 = true;
        for (String str : list) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    public final void zn(ListenableWorker.y yVar) {
        if (yVar instanceof ListenableWorker.y.zn) {
            f.zn().gv(f8379b, String.format("Worker result SUCCESS for %s", this.f8388fh), new Throwable[0]);
            if (this.f8385f.gv()) {
                s();
            } else {
                tl();
            }
        } else if (yVar instanceof ListenableWorker.y.n3) {
            f.zn().gv(f8379b, String.format("Worker result RETRY for %s", this.f8388fh), new Throwable[0]);
            fb();
        } else {
            f.zn().gv(f8379b, String.format("Worker result FAILURE for %s", this.f8388fh), new Throwable[0]);
            if (this.f8385f.gv()) {
                s();
            } else {
                t();
            }
        }
    }
}
