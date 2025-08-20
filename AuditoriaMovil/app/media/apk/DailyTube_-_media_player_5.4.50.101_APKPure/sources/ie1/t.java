package ie1;

import java.io.IOException;
import kc1.d0;
import kc1.mg;
import kc1.rz;
import kc1.v;
import zc1.ta;
/* loaded from: classes.dex */
public final class t<T> implements ie1.n3<T> {

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f9245f;

    /* renamed from: fb  reason: collision with root package name */
    public final v.y f9246fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f9247p;

    /* renamed from: s  reason: collision with root package name */
    public final a<mg, T> f9248s;

    /* renamed from: t  reason: collision with root package name */
    public kc1.v f9249t;

    /* renamed from: v  reason: collision with root package name */
    public final Object[] f9250v;

    /* renamed from: w  reason: collision with root package name */
    public Throwable f9251w;
    public final p y;

    /* loaded from: classes.dex */
    public static final class n3 extends mg {

        /* renamed from: fb  reason: collision with root package name */
        public IOException f9252fb;

        /* renamed from: v  reason: collision with root package name */
        public final zc1.fb f9253v;
        public final mg y;

        /* loaded from: classes.dex */
        public class y extends zc1.f {
            public y(ta taVar) {
                super(taVar);
            }

            public long read(zc1.v vVar, long j2) throws IOException {
                try {
                    return super.read(vVar, j2);
                } catch (IOException e2) {
                    n3.this.f9252fb = e2;
                    throw e2;
                }
            }
        }

        public n3(mg mgVar) {
            this.y = mgVar;
            this.f9253v = zc1.p.gv(new y(mgVar.source()));
        }

        @Override // kc1.mg, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.y.close();
        }

        @Override // kc1.mg
        public long contentLength() {
            return this.y.contentLength();
        }

        @Override // kc1.mg
        public kc1.i4 contentType() {
            return this.y.contentType();
        }

        @Override // kc1.mg
        public zc1.fb source() {
            return this.f9253v;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.f9252fb;
            if (iOException == null) {
                return;
            }
            throw iOException;
        }
    }

    /* loaded from: classes.dex */
    public class y implements kc1.a {
        public final /* synthetic */ gv y;

        public y(gv gvVar) {
            this.y = gvVar;
        }

        @Override // kc1.a
        public void onFailure(kc1.v vVar, IOException iOException) {
            y(iOException);
        }

        @Override // kc1.a
        public void onResponse(kc1.v vVar, rz rzVar) {
            try {
                try {
                    this.y.y(t.this, t.this.gv(rzVar));
                } catch (Throwable th) {
                    i4.z(th);
                }
            } catch (Throwable th2) {
                i4.z(th2);
                y(th2);
            }
        }

        public final void y(Throwable th) {
            try {
                this.y.n3(t.this, th);
            } catch (Throwable th2) {
                i4.z(th2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends mg {

        /* renamed from: v  reason: collision with root package name */
        public final long f9255v;
        public final kc1.i4 y;

        public zn(kc1.i4 i4Var, long j2) {
            this.y = i4Var;
            this.f9255v = j2;
        }

        @Override // kc1.mg
        public long contentLength() {
            return this.f9255v;
        }

        @Override // kc1.mg
        public kc1.i4 contentType() {
            return this.y;
        }

        @Override // kc1.mg
        public zc1.fb source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public t(p pVar, Object[] objArr, v.y yVar, a<mg, T> aVar) {
        this.y = pVar;
        this.f9250v = objArr;
        this.f9246fb = yVar;
        this.f9248s = aVar;
    }

    @Override // ie1.n3
    public void cancel() {
        kc1.v vVar;
        this.f9245f = true;
        synchronized (this) {
            vVar = this.f9249t;
        }
        if (vVar != null) {
            vVar.cancel();
        }
    }

    @Override // ie1.n3
    public mt<T> execute() throws IOException {
        kc1.v vVar;
        synchronized (this) {
            try {
                if (!this.f9247p) {
                    this.f9247p = true;
                    Throwable th = this.f9251w;
                    if (th != null) {
                        if (!(th instanceof IOException)) {
                            if (th instanceof RuntimeException) {
                                throw ((RuntimeException) th);
                            }
                            throw ((Error) th);
                        }
                        throw ((IOException) th);
                    }
                    vVar = this.f9249t;
                    if (vVar == null) {
                        try {
                            vVar = zn();
                            this.f9249t = vVar;
                        } catch (IOException | Error | RuntimeException e2) {
                            i4.z(e2);
                            this.f9251w = e2;
                            throw e2;
                        }
                    }
                } else {
                    throw new IllegalStateException("Already executed.");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (this.f9245f) {
            vVar.cancel();
        }
        return gv(vVar.execute());
    }

    public mt<T> gv(rz rzVar) throws IOException {
        mg y2 = rzVar.y();
        rz zn2 = rzVar.j5().n3(new zn(y2.contentType(), y2.contentLength())).zn();
        int mt2 = zn2.mt();
        if (mt2 >= 200 && mt2 < 300) {
            if (mt2 != 204 && mt2 != 205) {
                n3 n3Var = new n3(y2);
                try {
                    return mt.a(this.f9248s.convert(n3Var), zn2);
                } catch (RuntimeException e2) {
                    n3Var.throwIfCaught();
                    throw e2;
                }
            }
            y2.close();
            return mt.a(null, zn2);
        }
        try {
            return mt.zn(i4.y(y2), zn2);
        } finally {
            y2.close();
        }
    }

    @Override // ie1.n3
    /* renamed from: n3 */
    public t<T> m26clone() {
        return new t<>(this.y, this.f9250v, this.f9246fb, this.f9248s);
    }

    @Override // ie1.n3
    public void r(gv<T> gvVar) {
        kc1.v vVar;
        Throwable th;
        i4.n3(gvVar, "callback == null");
        synchronized (this) {
            try {
                if (!this.f9247p) {
                    this.f9247p = true;
                    vVar = this.f9249t;
                    th = this.f9251w;
                    if (vVar == null && th == null) {
                        kc1.v zn2 = zn();
                        this.f9249t = zn2;
                        vVar = zn2;
                    }
                } else {
                    throw new IllegalStateException("Already executed.");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (th != null) {
            gvVar.n3(this, th);
            return;
        }
        if (this.f9245f) {
            vVar.cancel();
        }
        vVar.cy(new y(gvVar));
    }

    @Override // ie1.n3
    public boolean v() {
        boolean z2 = true;
        if (this.f9245f) {
            return true;
        }
        synchronized (this) {
            try {
                kc1.v vVar = this.f9249t;
                if (vVar == null || !vVar.v()) {
                    z2 = false;
                }
            } finally {
            }
        }
        return z2;
    }

    @Override // ie1.n3
    public synchronized d0 y() {
        kc1.v vVar = this.f9249t;
        if (vVar != null) {
            return vVar.y();
        }
        Throwable th = this.f9251w;
        if (th != null) {
            if (!(th instanceof IOException)) {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw ((Error) th);
            }
            throw new RuntimeException("Unable to create request.", this.f9251w);
        }
        try {
            kc1.v zn2 = zn();
            this.f9249t = zn2;
            return zn2.y();
        } catch (IOException e2) {
            this.f9251w = e2;
            throw new RuntimeException("Unable to create request.", e2);
        } catch (Error e3) {
            e = e3;
            i4.z(e);
            this.f9251w = e;
            throw e;
        } catch (RuntimeException e5) {
            e = e5;
            i4.z(e);
            this.f9251w = e;
            throw e;
        }
    }

    public final kc1.v zn() throws IOException {
        kc1.v n32 = this.f9246fb.n3(this.y.y(this.f9250v));
        if (n32 != null) {
            return n32;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }
}
