package a9;

import a9.a;
import a9.fb;
import a9.s;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
/* loaded from: classes.dex */
public abstract class i9<I extends fb, O extends s, E extends a> implements gv<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    public final O[] f62a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public I f63c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64f;

    /* renamed from: fb  reason: collision with root package name */
    public int f65fb;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public E f67i9;

    /* renamed from: s  reason: collision with root package name */
    public int f69s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f70t;

    /* renamed from: tl  reason: collision with root package name */
    public int f71tl;

    /* renamed from: v  reason: collision with root package name */
    public final I[] f72v;
    public final Thread y;

    /* renamed from: n3  reason: collision with root package name */
    public final Object f68n3 = new Object();

    /* renamed from: zn  reason: collision with root package name */
    public final ArrayDeque<I> f73zn = new ArrayDeque<>();

    /* renamed from: gv  reason: collision with root package name */
    public final ArrayDeque<O> f66gv = new ArrayDeque<>();

    /* loaded from: classes.dex */
    public class y extends Thread {
        public y(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            i9.this.z();
        }
    }

    public i9(I[] iArr, O[] oArr) {
        this.f72v = iArr;
        this.f65fb = iArr.length;
        for (int i = 0; i < this.f65fb; i++) {
            this.f72v[i] = fb();
        }
        this.f62a = oArr;
        this.f69s = oArr.length;
        for (int i5 = 0; i5 < this.f69s; i5++) {
            this.f62a[i5] = s();
        }
        y yVar = new y("ExoPlayer:SimpleDecoder");
        this.y = yVar;
        yVar.start();
    }

    public final boolean a() {
        if (!this.f73zn.isEmpty() && this.f69s > 0) {
            return true;
        }
        return false;
    }

    public abstract E c5(Throwable th);

    public final void co(O o2) {
        o2.a();
        O[] oArr = this.f62a;
        int i = this.f69s;
        this.f69s = i + 1;
        oArr[i] = o2;
    }

    public final boolean f() throws InterruptedException {
        E c52;
        synchronized (this.f68n3) {
            while (!this.f70t && !a()) {
                try {
                    this.f68n3.wait();
                } finally {
                }
            }
            if (this.f70t) {
                return false;
            }
            I removeFirst = this.f73zn.removeFirst();
            O[] oArr = this.f62a;
            int i = this.f69s - 1;
            this.f69s = i;
            O o2 = oArr[i];
            boolean z2 = this.f64f;
            this.f64f = false;
            if (removeFirst.t()) {
                o2.v(4);
            } else {
                if (removeFirst.f()) {
                    o2.v(Integer.MIN_VALUE);
                }
                if (removeFirst.tl()) {
                    o2.v(134217728);
                }
                try {
                    c52 = i9(removeFirst, o2, z2);
                } catch (OutOfMemoryError e2) {
                    c52 = c5(e2);
                } catch (RuntimeException e3) {
                    c52 = c5(e3);
                }
                if (c52 != null) {
                    synchronized (this.f68n3) {
                        this.f67i9 = c52;
                    }
                    return false;
                }
            }
            synchronized (this.f68n3) {
                try {
                    if (this.f64f) {
                        o2.p();
                    } else if (o2.f()) {
                        this.f71tl++;
                        o2.p();
                    } else {
                        o2.f74fb = this.f71tl;
                        this.f71tl = 0;
                        this.f66gv.addLast(o2);
                    }
                    p(removeFirst);
                } finally {
                }
            }
            return true;
        }
    }

    public abstract I fb();

    @Override // a9.gv
    public final void flush() {
        synchronized (this.f68n3) {
            try {
                this.f64f = true;
                this.f71tl = 0;
                I i = this.f63c5;
                if (i != null) {
                    p(i);
                    this.f63c5 = null;
                }
                while (!this.f73zn.isEmpty()) {
                    p(this.f73zn.removeFirst());
                }
                while (!this.f66gv.isEmpty()) {
                    this.f66gv.removeFirst().p();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public abstract E i9(I i, O o2, boolean z2);

    public void mt(O o2) {
        synchronized (this.f68n3) {
            co(o2);
            wz();
        }
    }

    public final void p(I i) {
        i.a();
        I[] iArr = this.f72v;
        int i5 = this.f65fb;
        this.f65fb = i5 + 1;
        iArr[i5] = i;
    }

    public final void r(int i) {
        boolean z2;
        if (this.f65fb == this.f72v.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        for (I i5 : this.f72v) {
            i5.mt(i);
        }
    }

    @Override // a9.gv
    public void release() {
        synchronized (this.f68n3) {
            this.f70t = true;
            this.f68n3.notify();
        }
        try {
            this.y.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public abstract O s();

    @Override // a9.gv
    @Nullable
    /* renamed from: t */
    public final I gv() throws a {
        boolean z2;
        I i;
        synchronized (this.f68n3) {
            xc();
            if (this.f63c5 == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            int i5 = this.f65fb;
            if (i5 == 0) {
                i = null;
            } else {
                I[] iArr = this.f72v;
                int i6 = i5 - 1;
                this.f65fb = i6;
                i = iArr[i6];
            }
            this.f63c5 = i;
        }
        return i;
    }

    @Override // a9.gv
    @Nullable
    /* renamed from: tl */
    public final O n3() throws a {
        synchronized (this.f68n3) {
            try {
                xc();
                if (this.f66gv.isEmpty()) {
                    return null;
                }
                return this.f66gv.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a9.gv
    /* renamed from: w */
    public final void zn(I i) throws a {
        boolean z2;
        synchronized (this.f68n3) {
            xc();
            if (i == this.f63c5) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            this.f73zn.addLast(i);
            wz();
            this.f63c5 = null;
        }
    }

    public final void wz() {
        if (a()) {
            this.f68n3.notify();
        }
    }

    public final void xc() throws a {
        E e2 = this.f67i9;
        if (e2 == null) {
            return;
        }
        throw e2;
    }

    public final void z() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (f());
    }
}
