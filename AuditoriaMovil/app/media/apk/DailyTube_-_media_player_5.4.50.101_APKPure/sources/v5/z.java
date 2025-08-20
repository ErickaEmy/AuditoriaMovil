package v5;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import v5.wz;
/* loaded from: classes.dex */
public final class z<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque<Runnable> f14415a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f14416c5;

    /* renamed from: fb  reason: collision with root package name */
    public final Object f14417fb;

    /* renamed from: gv  reason: collision with root package name */
    public final CopyOnWriteArraySet<zn<T>> f14418gv;

    /* renamed from: n3  reason: collision with root package name */
    public final p f14419n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f14420s;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayDeque<Runnable> f14421v;
    public final v y;

    /* renamed from: zn  reason: collision with root package name */
    public final n3<T> f14422zn;

    /* loaded from: classes.dex */
    public interface n3<T> {
        void y(T t2, wz wzVar);
    }

    /* loaded from: classes.dex */
    public interface y<T> {
        void invoke(T t2);
    }

    /* loaded from: classes.dex */
    public static final class zn<T> {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f14423gv;

        /* renamed from: n3  reason: collision with root package name */
        public wz.n3 f14424n3 = new wz.n3();
        public final T y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f14425zn;

        public zn(T t2) {
            this.y = t2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && zn.class == obj.getClass()) {
                return this.y.equals(((zn) obj).y);
            }
            return false;
        }

        public int hashCode() {
            return this.y.hashCode();
        }

        public void n3(n3<T> n3Var) {
            if (!this.f14423gv && this.f14425zn) {
                wz v2 = this.f14424n3.v();
                this.f14424n3 = new wz.n3();
                this.f14425zn = false;
                n3Var.y(this.y, v2);
            }
        }

        public void y(int i, y<T> yVar) {
            if (!this.f14423gv) {
                if (i != -1) {
                    this.f14424n3.y(i);
                }
                this.f14425zn = true;
                yVar.invoke(this.y);
            }
        }

        public void zn(n3<T> n3Var) {
            this.f14423gv = true;
            if (this.f14425zn) {
                this.f14425zn = false;
                n3Var.y(this.y, this.f14424n3.v());
            }
        }
    }

    public z(Looper looper, v vVar, n3<T> n3Var) {
        this(new CopyOnWriteArraySet(), looper, vVar, n3Var);
    }

    public static /* synthetic */ void s(CopyOnWriteArraySet copyOnWriteArraySet, int i, y yVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((zn) it.next()).y(i, yVar);
        }
    }

    public void a() {
        tl();
        if (this.f14415a.isEmpty()) {
            return;
        }
        if (!this.f14419n3.n3(0)) {
            p pVar = this.f14419n3;
            pVar.s(pVar.y(0));
        }
        boolean isEmpty = this.f14421v.isEmpty();
        this.f14421v.addAll(this.f14415a);
        this.f14415a.clear();
        if (!isEmpty) {
            return;
        }
        while (!this.f14421v.isEmpty()) {
            this.f14421v.peekFirst().run();
            this.f14421v.removeFirst();
        }
    }

    public void c5(final int i, final y<T> yVar) {
        tl();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f14418gv);
        this.f14415a.add(new Runnable() { // from class: v5.mt
            @Override // java.lang.Runnable
            public final void run() {
                z.s(copyOnWriteArraySet, i, yVar);
            }
        });
    }

    public void f(T t2) {
        tl();
        Iterator<zn<T>> it = this.f14418gv.iterator();
        while (it.hasNext()) {
            zn<T> next = it.next();
            if (next.y.equals(t2)) {
                next.zn(this.f14422zn);
                this.f14418gv.remove(next);
            }
        }
    }

    public final boolean fb(Message message) {
        Iterator<zn<T>> it = this.f14418gv.iterator();
        while (it.hasNext()) {
            it.next().n3(this.f14422zn);
            if (this.f14419n3.n3(0)) {
                return true;
            }
        }
        return true;
    }

    @CheckResult
    public z<T> gv(Looper looper, v vVar, n3<T> n3Var) {
        return new z<>(this.f14418gv, looper, vVar, n3Var);
    }

    public void i9() {
        tl();
        synchronized (this.f14417fb) {
            this.f14420s = true;
        }
        Iterator<zn<T>> it = this.f14418gv.iterator();
        while (it.hasNext()) {
            it.next().zn(this.f14422zn);
        }
        this.f14418gv.clear();
    }

    public void t(int i, y<T> yVar) {
        c5(i, yVar);
        a();
    }

    public final void tl() {
        boolean z2;
        if (!this.f14416c5) {
            return;
        }
        if (Thread.currentThread() == this.f14419n3.a().getThread()) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
    }

    @CheckResult
    public z<T> v(Looper looper, n3<T> n3Var) {
        return gv(looper, this.y, n3Var);
    }

    public void zn(T t2) {
        v5.y.v(t2);
        synchronized (this.f14417fb) {
            try {
                if (this.f14420s) {
                    return;
                }
                this.f14418gv.add(new zn<>(t2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public z(CopyOnWriteArraySet<zn<T>> copyOnWriteArraySet, Looper looper, v vVar, n3<T> n3Var) {
        this.y = vVar;
        this.f14418gv = copyOnWriteArraySet;
        this.f14422zn = n3Var;
        this.f14417fb = new Object();
        this.f14421v = new ArrayDeque<>();
        this.f14415a = new ArrayDeque<>();
        this.f14419n3 = vVar.n3(looper, new Handler.Callback() { // from class: v5.co
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean fb2;
                fb2 = z.this.fb(message);
                return fb2;
            }
        });
        this.f14416c5 = true;
    }
}
