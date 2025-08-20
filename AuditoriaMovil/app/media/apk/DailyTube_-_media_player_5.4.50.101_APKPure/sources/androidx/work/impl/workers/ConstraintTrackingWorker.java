package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import gq.c5;
import java.util.Collections;
import java.util.List;
import l.f;
import le.w;
import w2.gv;
import w2.zn;
/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements zn {

    /* renamed from: t  reason: collision with root package name */
    public static final String f3760t = f.a("ConstraintTrkngWrkr");
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public ListenableWorker f3761f;

    /* renamed from: fb  reason: collision with root package name */
    public volatile boolean f3762fb;

    /* renamed from: s  reason: collision with root package name */
    public ro.zn<ListenableWorker.y> f3763s;

    /* renamed from: v  reason: collision with root package name */
    public final Object f3764v;
    public WorkerParameters y;

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public final /* synthetic */ f1.zn y;

        public n3(f1.zn znVar) {
            this.y = znVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.f3764v) {
                try {
                    if (ConstraintTrackingWorker.this.f3762fb) {
                        ConstraintTrackingWorker.this.gv();
                    } else {
                        ConstraintTrackingWorker.this.f3763s.p(this.y);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.a();
        }
    }

    public ConstraintTrackingWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.y = workerParameters;
        this.f3764v = new Object();
        this.f3762fb = false;
        this.f3763s = ro.zn.co();
    }

    public void a() {
        String c52 = getInputData().c5("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(c52)) {
            f.zn().n3(f3760t, "No worker to delegate to.", new Throwable[0]);
            zn();
            return;
        }
        ListenableWorker n32 = getWorkerFactory().n3(getApplicationContext(), c52, this.y);
        this.f3761f = n32;
        if (n32 == null) {
            f.zn().y(f3760t, "No worker to delegate to.", new Throwable[0]);
            zn();
            return;
        }
        w a2 = y().f().a(getId().toString());
        if (a2 == null) {
            zn();
            return;
        }
        gv gvVar = new gv(getApplicationContext(), getTaskExecutor(), this);
        gvVar.gv(Collections.singletonList(a2));
        if (gvVar.zn(getId().toString())) {
            f.zn().y(f3760t, String.format("Constraints met for delegate %s", c52), new Throwable[0]);
            try {
                f1.zn<ListenableWorker.y> startWork = this.f3761f.startWork();
                startWork.addListener(new n3(startWork), getBackgroundExecutor());
                return;
            } catch (Throwable th) {
                f zn2 = f.zn();
                String str = f3760t;
                zn2.y(str, String.format("Delegated worker %s threw exception in startWork.", c52), th);
                synchronized (this.f3764v) {
                    try {
                        if (this.f3762fb) {
                            f.zn().y(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                            gv();
                        } else {
                            zn();
                        }
                        return;
                    } finally {
                    }
                }
            }
        }
        f.zn().y(f3760t, String.format("Constraints not met for delegate %s. Requesting retry.", c52), new Throwable[0]);
        gv();
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public ix.y getTaskExecutor() {
        return c5.xc(getApplicationContext()).z();
    }

    public void gv() {
        this.f3763s.xc(ListenableWorker.y.n3());
    }

    @Override // androidx.work.ListenableWorker
    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.f3761f;
        if (listenableWorker != null && listenableWorker.isRunInForeground()) {
            return true;
        }
        return false;
    }

    @Override // w2.zn
    public void n3(@NonNull List<String> list) {
        f.zn().y(f3760t, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f3764v) {
            this.f3762fb = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f3761f;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.f3761f.stop();
        }
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public f1.zn<ListenableWorker.y> startWork() {
        getBackgroundExecutor().execute(new y());
        return this.f3763s;
    }

    @Override // w2.zn
    public void v(@NonNull List<String> list) {
    }

    @NonNull
    public WorkDatabase y() {
        return c5.xc(getApplicationContext()).co();
    }

    public void zn() {
        this.f3763s.xc(ListenableWorker.y.y());
    }
}
