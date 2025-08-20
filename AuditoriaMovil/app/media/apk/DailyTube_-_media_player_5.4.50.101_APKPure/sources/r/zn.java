package r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class zn {

    /* loaded from: classes.dex */
    public static final class gv<T> implements f1.zn<T> {

        /* renamed from: v  reason: collision with root package name */
        public final r.y<T> f13040v = new y();
        public final WeakReference<y<T>> y;

        /* loaded from: classes.dex */
        public class y extends r.y<T> {
            public y() {
            }

            @Override // r.y
            public String t() {
                y<T> yVar = gv.this.y.get();
                if (yVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + yVar.y + "]";
            }
        }

        public gv(y<T> yVar) {
            this.y = new WeakReference<>(yVar);
        }

        @Override // f1.zn
        public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.f13040v.addListener(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            y<T> yVar = this.y.get();
            boolean cancel = this.f13040v.cancel(z2);
            if (cancel && yVar != null) {
                yVar.y();
            }
            return cancel;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.f13040v.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f13040v.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f13040v.isDone();
        }

        public boolean n3(T t2) {
            return this.f13040v.xc(t2);
        }

        public String toString() {
            return this.f13040v.toString();
        }

        public boolean y(boolean z2) {
            return this.f13040v.cancel(z2);
        }

        public boolean zn(Throwable th) {
            return this.f13040v.w(th);
        }

        @Override // java.util.concurrent.Future
        public T get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.f13040v.get(j2, timeUnit);
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends Throwable {
        public n3(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class y<T> {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f13042gv;

        /* renamed from: n3  reason: collision with root package name */
        public gv<T> f13043n3;
        public Object y;

        /* renamed from: zn  reason: collision with root package name */
        public r.gv<Void> f13044zn = r.gv.mt();

        public void finalize() {
            r.gv<Void> gvVar;
            gv<T> gvVar2 = this.f13043n3;
            if (gvVar2 != null && !gvVar2.isDone()) {
                gvVar2.zn(new n3("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.y));
            }
            if (!this.f13042gv && (gvVar = this.f13044zn) != null) {
                gvVar.xc(null);
            }
        }

        public final void gv() {
            this.y = null;
            this.f13043n3 = null;
            this.f13044zn = null;
        }

        public boolean n3(T t2) {
            boolean z2 = true;
            this.f13042gv = true;
            gv<T> gvVar = this.f13043n3;
            z2 = (gvVar == null || !gvVar.n3(t2)) ? false : false;
            if (z2) {
                gv();
            }
            return z2;
        }

        public boolean v(@NonNull Throwable th) {
            boolean z2 = true;
            this.f13042gv = true;
            gv<T> gvVar = this.f13043n3;
            z2 = (gvVar == null || !gvVar.zn(th)) ? false : false;
            if (z2) {
                gv();
            }
            return z2;
        }

        public void y() {
            this.y = null;
            this.f13043n3 = null;
            this.f13044zn.xc(null);
        }

        public boolean zn() {
            boolean z2 = true;
            this.f13042gv = true;
            gv<T> gvVar = this.f13043n3;
            z2 = (gvVar == null || !gvVar.y(true)) ? false : false;
            if (z2) {
                gv();
            }
            return z2;
        }
    }

    /* renamed from: r.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0192zn<T> {
        @Nullable
        Object y(@NonNull y<T> yVar) throws Exception;
    }

    @NonNull
    public static <T> f1.zn<T> y(@NonNull InterfaceC0192zn<T> interfaceC0192zn) {
        y<T> yVar = new y<>();
        gv<T> gvVar = new gv<>(yVar);
        yVar.f13043n3 = gvVar;
        yVar.y = interfaceC0192zn.getClass();
        try {
            Object y2 = interfaceC0192zn.y(yVar);
            if (y2 != null) {
                yVar.y = y2;
            }
        } catch (Exception e2) {
            gvVar.zn(e2);
        }
        return gvVar;
    }
}
