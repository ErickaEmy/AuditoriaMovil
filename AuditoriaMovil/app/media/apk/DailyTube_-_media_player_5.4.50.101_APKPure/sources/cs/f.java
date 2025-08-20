package cs;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import le.w;
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: w  reason: collision with root package name */
    public static final String f6853w = l.f.a("WorkForegroundRunnable");

    /* renamed from: f  reason: collision with root package name */
    public final l.fb f6854f;

    /* renamed from: fb  reason: collision with root package name */
    public final w f6855fb;

    /* renamed from: s  reason: collision with root package name */
    public final ListenableWorker f6856s;

    /* renamed from: t  reason: collision with root package name */
    public final ix.y f6857t;

    /* renamed from: v  reason: collision with root package name */
    public final Context f6858v;
    public final ro.zn<Void> y = ro.zn.co();

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public final /* synthetic */ ro.zn y;

        public n3(ro.zn znVar) {
            this.y = znVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                l.a aVar = (l.a) this.y.get();
                if (aVar != null) {
                    l.f.zn().y(f.f6853w, String.format("Updating notification for %s", f.this.f6855fb.f10347zn), new Throwable[0]);
                    f.this.f6856s.setRunInForeground(true);
                    f fVar = f.this;
                    fVar.y.p(fVar.f6854f.y(fVar.f6858v, fVar.f6856s.getId(), aVar));
                    return;
                }
                throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", f.this.f6855fb.f10347zn));
            } catch (Throwable th) {
                f.this.y.w(th);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public final /* synthetic */ ro.zn y;

        public y(ro.zn znVar) {
            this.y = znVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.p(f.this.f6856s.getForegroundInfoAsync());
        }
    }

    @SuppressLint({"LambdaLast"})
    public f(@NonNull Context context, @NonNull w wVar, @NonNull ListenableWorker listenableWorker, @NonNull l.fb fbVar, @NonNull ix.y yVar) {
        this.f6858v = context;
        this.f6855fb = wVar;
        this.f6856s = listenableWorker;
        this.f6854f = fbVar;
        this.f6857t = yVar;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (this.f6855fb.f10339p && !b.y.n3()) {
            ro.zn co2 = ro.zn.co();
            this.f6857t.y().execute(new y(co2));
            co2.addListener(new n3(co2), this.f6857t.y());
            return;
        }
        this.y.xc(null);
    }

    @NonNull
    public f1.zn<Void> y() {
        return this.y;
    }
}
