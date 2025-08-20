package pc1;

import java.io.IOException;
import java.net.ProtocolException;
import kc1.d0;
import kc1.fh;
import kc1.mg;
import kc1.p;
import kc1.rz;
import kotlin.jvm.internal.Intrinsics;
import zc1.rz;
import zc1.ta;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: a  reason: collision with root package name */
    public final qc1.gv f12582a;

    /* renamed from: gv  reason: collision with root package name */
    public final p f12583gv;

    /* renamed from: n3  reason: collision with root package name */
    public final a f12584n3;

    /* renamed from: v  reason: collision with root package name */
    public final gv f12585v;
    public boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final v f12586zn;

    /* loaded from: classes.dex */
    public final class n3 extends zc1.f {

        /* renamed from: f  reason: collision with root package name */
        public final long f12587f;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f12588fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f12589s;

        /* renamed from: t  reason: collision with root package name */
        public final /* synthetic */ zn f12590t;

        /* renamed from: v  reason: collision with root package name */
        public boolean f12591v;
        public long y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(zn znVar, ta delegate, long j2) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f12590t = znVar;
            this.f12587f = j2;
            this.f12591v = true;
            if (j2 == 0) {
                y(null);
            }
        }

        public void close() throws IOException {
            if (this.f12589s) {
                return;
            }
            this.f12589s = true;
            try {
                super.close();
                y(null);
            } catch (IOException e2) {
                throw y(e2);
            }
        }

        public long read(zc1.v sink, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!this.f12589s) {
                try {
                    long read = delegate().read(sink, j2);
                    if (this.f12591v) {
                        this.f12591v = false;
                        this.f12590t.c5().i4(this.f12590t.fb());
                    }
                    if (read == -1) {
                        y(null);
                        return -1L;
                    }
                    long j4 = this.y + read;
                    long j6 = this.f12587f;
                    if (j6 != -1 && j4 > j6) {
                        throw new ProtocolException("expected " + this.f12587f + " bytes but received " + j4);
                    }
                    this.y = j4;
                    if (j4 == j6) {
                        y(null);
                    }
                    return read;
                } catch (IOException e2) {
                    throw y(e2);
                }
            }
            throw new IllegalStateException("closed");
        }

        public final <E extends IOException> E y(E e2) {
            if (this.f12588fb) {
                return e2;
            }
            this.f12588fb = true;
            if (e2 == null && this.f12591v) {
                this.f12591v = false;
                this.f12590t.c5().i4(this.f12590t.fb());
            }
            return (E) this.f12590t.y(this.y, true, false, e2);
        }
    }

    /* loaded from: classes.dex */
    public final class y extends zc1.i9 {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ zn f12592f;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f12593fb;

        /* renamed from: s  reason: collision with root package name */
        public final long f12594s;

        /* renamed from: v  reason: collision with root package name */
        public long f12595v;
        public boolean y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(zn znVar, rz delegate, long j2) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f12592f = znVar;
            this.f12594s = j2;
        }

        private final <E extends IOException> E y(E e2) {
            if (this.y) {
                return e2;
            }
            this.y = true;
            return (E) this.f12592f.y(this.f12595v, false, true, e2);
        }

        public void close() throws IOException {
            if (this.f12593fb) {
                return;
            }
            this.f12593fb = true;
            long j2 = this.f12594s;
            if (j2 != -1 && this.f12595v != j2) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                y(null);
            } catch (IOException e2) {
                throw y(e2);
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e2) {
                throw y(e2);
            }
        }

        public void write(zc1.v source, long j2) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!this.f12593fb) {
                long j4 = this.f12594s;
                if (j4 != -1 && this.f12595v + j2 > j4) {
                    throw new ProtocolException("expected " + this.f12594s + " bytes but received " + (this.f12595v + j2));
                }
                try {
                    super.write(source, j2);
                    this.f12595v += j2;
                    return;
                } catch (IOException e2) {
                    throw y(e2);
                }
            }
            throw new IllegalStateException("closed");
        }
    }

    public zn(v call, p eventListener, gv finder, qc1.gv codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.f12586zn = call;
        this.f12583gv = eventListener;
        this.f12585v = finder;
        this.f12582a = codec;
        this.f12584n3 = codec.n3();
    }

    public final void a() throws IOException {
        try {
            this.f12582a.s();
        } catch (IOException e2) {
            this.f12583gv.co(this.f12586zn, e2);
            co(e2);
            throw e2;
        }
    }

    public final p c5() {
        return this.f12583gv;
    }

    public final void co(IOException iOException) {
        this.f12585v.s(iOException);
        this.f12582a.n3().ej(this.f12586zn, iOException);
    }

    public final boolean f() {
        return !Intrinsics.areEqual(this.f12585v.gv().t().f(), this.f12584n3.n3().y().t().f());
    }

    public final v fb() {
        return this.f12586zn;
    }

    public final void gv() {
        this.f12582a.cancel();
        this.f12586zn.z(this, true, true, null);
    }

    public final gv i9() {
        return this.f12585v;
    }

    public final void mt() {
        this.f12583gv.c(this.f12586zn);
    }

    public final void n3() {
        this.f12582a.cancel();
    }

    public final void p(kc1.rz response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.f12583gv.n(this.f12586zn, response);
    }

    public final a s() {
        return this.f12584n3;
    }

    public final boolean t() {
        return this.y;
    }

    public final void tl() {
        this.f12582a.n3().d0();
    }

    public final void v() throws IOException {
        try {
            this.f12582a.y();
        } catch (IOException e2) {
            this.f12583gv.co(this.f12586zn, e2);
            co(e2);
            throw e2;
        }
    }

    public final rz.y w(boolean z2) throws IOException {
        try {
            rz.y v2 = this.f12582a.v(z2);
            if (v2 != null) {
                v2.t(this);
            }
            return v2;
        } catch (IOException e2) {
            this.f12583gv.f3(this.f12586zn, e2);
            co(e2);
            throw e2;
        }
    }

    public final void wz() {
        this.f12586zn.z(this, true, false, null);
    }

    public final mg xc(kc1.rz response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String d2 = kc1.rz.d(response, "Content-Type", null, 2, null);
            long gv2 = this.f12582a.gv(response);
            return new qc1.s(d2, gv2, zc1.p.gv(new n3(this, this.f12582a.zn(response), gv2)));
        } catch (IOException e2) {
            this.f12583gv.f3(this.f12586zn, e2);
            co(e2);
            throw e2;
        }
    }

    public final <E extends IOException> E y(long j2, boolean z2, boolean z3, E e2) {
        if (e2 != null) {
            co(e2);
        }
        if (z3) {
            if (e2 != null) {
                this.f12583gv.co(this.f12586zn, e2);
            } else {
                this.f12583gv.p(this.f12586zn, j2);
            }
        }
        if (z2) {
            if (e2 != null) {
                this.f12583gv.f3(this.f12586zn, e2);
            } else {
                this.f12583gv.x4(this.f12586zn, j2);
            }
        }
        return (E) this.f12586zn.z(this, z3, z2, e2);
    }

    public final void z(d0 request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            this.f12583gv.r(this.f12586zn);
            this.f12582a.a(request);
            this.f12583gv.z(this.f12586zn, request);
        } catch (IOException e2) {
            this.f12583gv.co(this.f12586zn, e2);
            co(e2);
            throw e2;
        }
    }

    public final zc1.rz zn(d0 request, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.y = z2;
        fh y2 = request.y();
        Intrinsics.checkNotNull(y2);
        long contentLength = y2.contentLength();
        this.f12583gv.mt(this.f12586zn);
        return new y(this, this.f12582a.fb(request, contentLength), contentLength);
    }
}
