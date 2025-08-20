package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.v;
import java.util.Iterator;
import java.util.Map;
import y5.co;
import y5.fh;
/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f2585f = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile Object f2586a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f2587c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f2588fb;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f2589gv;

    /* renamed from: i9  reason: collision with root package name */
    public final Runnable f2590i9;

    /* renamed from: n3  reason: collision with root package name */
    public w.n3<fh<? super T>, LiveData<T>.zn> f2591n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f2592s;

    /* renamed from: v  reason: collision with root package name */
    public volatile Object f2593v;
    public final Object y;

    /* renamed from: zn  reason: collision with root package name */
    public int f2594zn;

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.zn implements a {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        public final co f2595f;

        public LifecycleBoundObserver(@NonNull co coVar, fh<? super T> fhVar) {
            super(fhVar);
            this.f2595f = coVar;
        }

        @Override // androidx.lifecycle.LiveData.zn
        public boolean gv() {
            return this.f2595f.getLifecycle().n3().y(v.zn.STARTED);
        }

        @Override // androidx.lifecycle.LiveData.zn
        public void n3() {
            this.f2595f.getLifecycle().zn(this);
        }

        @Override // androidx.lifecycle.a
        public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
            v.zn n32 = this.f2595f.getLifecycle().n3();
            if (n32 == v.zn.DESTROYED) {
                LiveData.this.tl(this.y);
                return;
            }
            v.zn znVar = null;
            while (znVar != n32) {
                y(gv());
                znVar = n32;
                n32 = this.f2595f.getLifecycle().n3();
            }
        }

        @Override // androidx.lifecycle.LiveData.zn
        public boolean zn(co coVar) {
            if (this.f2595f == coVar) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends LiveData<T>.zn {
        public n3(fh<? super T> fhVar) {
            super(fhVar);
        }

        @Override // androidx.lifecycle.LiveData.zn
        public boolean gv() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.y) {
                obj = LiveData.this.f2586a;
                LiveData.this.f2586a = LiveData.f2585f;
            }
            LiveData.this.xc(obj);
        }
    }

    /* loaded from: classes.dex */
    public abstract class zn {

        /* renamed from: fb  reason: collision with root package name */
        public int f2598fb = -1;

        /* renamed from: v  reason: collision with root package name */
        public boolean f2600v;
        public final fh<? super T> y;

        public zn(fh<? super T> fhVar) {
            this.y = fhVar;
        }

        public abstract boolean gv();

        public void n3() {
        }

        public void y(boolean z2) {
            int i;
            if (z2 == this.f2600v) {
                return;
            }
            this.f2600v = z2;
            LiveData liveData = LiveData.this;
            if (z2) {
                i = 1;
            } else {
                i = -1;
            }
            liveData.n3(i);
            if (this.f2600v) {
                LiveData.this.gv(this);
            }
        }

        public boolean zn(co coVar) {
            return false;
        }
    }

    public LiveData(T t2) {
        this.y = new Object();
        this.f2591n3 = new w.n3<>();
        this.f2594zn = 0;
        this.f2586a = f2585f;
        this.f2590i9 = new y();
        this.f2593v = t2;
        this.f2588fb = 0;
    }

    public static void y(String str) {
        if (xc.y.a().zn()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public int a() {
        return this.f2588fb;
    }

    public void c5(@NonNull fh<? super T> fhVar) {
        y("observeForever");
        n3 n3Var = new n3(fhVar);
        LiveData<T>.zn a2 = this.f2591n3.a(fhVar, n3Var);
        if (!(a2 instanceof LifecycleBoundObserver)) {
            if (a2 != null) {
                return;
            }
            n3Var.y(true);
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void f() {
    }

    public boolean fb() {
        if (this.f2594zn > 0) {
            return true;
        }
        return false;
    }

    public void gv(@Nullable LiveData<T>.zn znVar) {
        if (this.f2592s) {
            this.f2587c5 = true;
            return;
        }
        this.f2592s = true;
        do {
            this.f2587c5 = false;
            if (znVar != null) {
                zn(znVar);
                znVar = null;
            } else {
                w.n3<fh<? super T>, LiveData<T>.zn>.gv zn2 = this.f2591n3.zn();
                while (zn2.hasNext()) {
                    zn((zn) zn2.next().getValue());
                    if (this.f2587c5) {
                        break;
                    }
                }
            }
        } while (this.f2587c5);
        this.f2592s = false;
    }

    public void i9() {
    }

    public void n3(int i) {
        boolean z2;
        boolean z3;
        int i5 = this.f2594zn;
        this.f2594zn = i + i5;
        if (this.f2589gv) {
            return;
        }
        this.f2589gv = true;
        while (true) {
            try {
                int i6 = this.f2594zn;
                if (i5 != i6) {
                    if (i5 == 0 && i6 > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (i5 > 0 && i6 == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2) {
                        i9();
                    } else if (z3) {
                        f();
                    }
                    i5 = i6;
                } else {
                    this.f2589gv = false;
                    return;
                }
            } catch (Throwable th) {
                this.f2589gv = false;
                throw th;
            }
        }
    }

    public void s(@NonNull co coVar, @NonNull fh<? super T> fhVar) {
        y("observe");
        if (coVar.getLifecycle().n3() == v.zn.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(coVar, fhVar);
        LiveData<T>.zn a2 = this.f2591n3.a(fhVar, lifecycleBoundObserver);
        if (a2 != null && !a2.zn(coVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (a2 != null) {
            return;
        }
        coVar.getLifecycle().y(lifecycleBoundObserver);
    }

    public void t(T t2) {
        boolean z2;
        synchronized (this.y) {
            if (this.f2586a == f2585f) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f2586a = t2;
        }
        if (!z2) {
            return;
        }
        xc.y.a().gv(this.f2590i9);
    }

    public void tl(@NonNull fh<? super T> fhVar) {
        y("removeObserver");
        LiveData<T>.zn fb2 = this.f2591n3.fb(fhVar);
        if (fb2 == null) {
            return;
        }
        fb2.n3();
        fb2.y(false);
    }

    @Nullable
    public T v() {
        T t2 = (T) this.f2593v;
        if (t2 != f2585f) {
            return t2;
        }
        return null;
    }

    public void wz(@NonNull co coVar) {
        y("removeObservers");
        Iterator<Map.Entry<fh<? super T>, LiveData<T>.zn>> it = this.f2591n3.iterator();
        while (it.hasNext()) {
            Map.Entry<fh<? super T>, LiveData<T>.zn> next = it.next();
            if (next.getValue().zn(coVar)) {
                tl(next.getKey());
            }
        }
    }

    public void xc(T t2) {
        y("setValue");
        this.f2588fb++;
        this.f2593v = t2;
        gv(null);
    }

    public final void zn(LiveData<T>.zn znVar) {
        if (!znVar.f2600v) {
            return;
        }
        if (!znVar.gv()) {
            znVar.y(false);
            return;
        }
        int i = znVar.f2598fb;
        int i5 = this.f2588fb;
        if (i >= i5) {
            return;
        }
        znVar.f2598fb = i5;
        znVar.y.onChanged((Object) this.f2593v);
    }

    public LiveData() {
        this.y = new Object();
        this.f2591n3 = new w.n3<>();
        this.f2594zn = 0;
        Object obj = f2585f;
        this.f2586a = obj;
        this.f2590i9 = new y();
        this.f2593v = obj;
        this.f2588fb = -1;
    }
}
