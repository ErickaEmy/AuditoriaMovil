package rc1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kc1.d0;
import kc1.n;
import kc1.r;
import kc1.rz;
import kc1.wz;
import kc1.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qc1.c5;
import qc1.f;
import zc1.d;
import zc1.rz;
import zc1.t;
import zc1.ta;
/* loaded from: classes.dex */
public final class n3 implements qc1.gv {

    /* renamed from: s  reason: collision with root package name */
    public static final gv f13295s = new gv(null);

    /* renamed from: a  reason: collision with root package name */
    public final zc1.fb f13296a;

    /* renamed from: fb  reason: collision with root package name */
    public final zc1.a f13297fb;

    /* renamed from: gv  reason: collision with root package name */
    public final n f13298gv;

    /* renamed from: n3  reason: collision with root package name */
    public final rc1.y f13299n3;

    /* renamed from: v  reason: collision with root package name */
    public final pc1.a f13300v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public z f13301zn;

    /* loaded from: classes.dex */
    public final class a implements rz {

        /* renamed from: v  reason: collision with root package name */
        public boolean f13303v;
        public final t y;

        public a() {
            this.y = new t(n3.this.f13297fb.timeout());
        }

        public void close() {
            if (this.f13303v) {
                return;
            }
            this.f13303v = true;
            n3.this.mt(this.y);
            n3.this.y = 3;
        }

        public void flush() {
            if (this.f13303v) {
                return;
            }
            n3.this.f13297fb.flush();
        }

        public d timeout() {
            return this.y;
        }

        public void write(zc1.v source, long j2) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!this.f13303v) {
                lc1.n3.c5(source.m(), 0L, j2);
                n3.this.f13297fb.write(source, j2);
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    /* loaded from: classes.dex */
    public final class fb extends y {

        /* renamed from: s  reason: collision with root package name */
        public boolean f13305s;

        public fb() {
            super();
        }

        public void close() {
            if (y()) {
                return;
            }
            if (!this.f13305s) {
                v();
            }
            s(true);
        }

        @Override // rc1.n3.y
        public long read(zc1.v sink, long j2) {
            boolean z2;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (!y()) {
                    if (this.f13305s) {
                        return -1L;
                    }
                    long read = super.read(sink, j2);
                    if (read == -1) {
                        this.f13305s = true;
                        v();
                        return -1L;
                    }
                    return read;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {
        public gv() {
        }

        public /* synthetic */ gv(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: rc1.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0204n3 implements rz {

        /* renamed from: v  reason: collision with root package name */
        public boolean f13307v;
        public final t y;

        public C0204n3() {
            this.y = new t(n3.this.f13297fb.timeout());
        }

        public synchronized void close() {
            if (this.f13307v) {
                return;
            }
            this.f13307v = true;
            n3.this.f13297fb.n("0\r\n\r\n");
            n3.this.mt(this.y);
            n3.this.y = 3;
        }

        public synchronized void flush() {
            if (this.f13307v) {
                return;
            }
            n3.this.f13297fb.flush();
        }

        public d timeout() {
            return this.y;
        }

        public void write(zc1.v source, long j2) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!this.f13307v) {
                if (j2 == 0) {
                    return;
                }
                n3.this.f13297fb.u0(j2);
                n3.this.f13297fb.n("\r\n");
                n3.this.f13297fb.write(source, j2);
                n3.this.f13297fb.n("\r\n");
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    /* loaded from: classes.dex */
    public final class v extends y {

        /* renamed from: s  reason: collision with root package name */
        public long f13309s;

        public v(long j2) {
            super();
            this.f13309s = j2;
            if (j2 == 0) {
                v();
            }
        }

        public void close() {
            if (y()) {
                return;
            }
            if (this.f13309s != 0 && !lc1.n3.w(this, 100, TimeUnit.MILLISECONDS)) {
                n3.this.n3().d0();
                v();
            }
            s(true);
        }

        @Override // rc1.n3.y
        public long read(zc1.v sink, long j2) {
            boolean z2;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (!y()) {
                    long j4 = this.f13309s;
                    if (j4 == 0) {
                        return -1L;
                    }
                    long read = super.read(sink, Math.min(j4, j2));
                    if (read != -1) {
                        long j6 = this.f13309s - read;
                        this.f13309s = j6;
                        if (j6 == 0) {
                            v();
                        }
                        return read;
                    }
                    n3.this.n3().d0();
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    v();
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
    }

    /* loaded from: classes.dex */
    public abstract class y implements ta {

        /* renamed from: v  reason: collision with root package name */
        public boolean f13311v;
        public final t y;

        public y() {
            this.y = new t(n3.this.f13296a.timeout());
        }

        public long read(zc1.v sink, long j2) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return n3.this.f13296a.read(sink, j2);
            } catch (IOException e2) {
                n3.this.n3().d0();
                v();
                throw e2;
            }
        }

        public final void s(boolean z2) {
            this.f13311v = z2;
        }

        public d timeout() {
            return this.y;
        }

        public final void v() {
            if (n3.this.y == 6) {
                return;
            }
            if (n3.this.y == 5) {
                n3.this.mt(this.y);
                n3.this.y = 6;
                return;
            }
            throw new IllegalStateException("state: " + n3.this.y);
        }

        public final boolean y() {
            return this.f13311v;
        }
    }

    /* loaded from: classes.dex */
    public final class zn extends y {

        /* renamed from: f  reason: collision with root package name */
        public boolean f13312f;

        /* renamed from: s  reason: collision with root package name */
        public long f13313s;

        /* renamed from: t  reason: collision with root package name */
        public final r f13314t;

        /* renamed from: w  reason: collision with root package name */
        public final /* synthetic */ n3 f13315w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public zn(n3 n3Var, r url) {
            super();
            Intrinsics.checkNotNullParameter(url, "url");
            this.f13315w = n3Var;
            this.f13314t = url;
            this.f13313s = -1L;
            this.f13312f = true;
        }

        public void close() {
            if (y()) {
                return;
            }
            if (this.f13312f && !lc1.n3.w(this, 100, TimeUnit.MILLISECONDS)) {
                this.f13315w.n3().d0();
                v();
            }
            s(true);
        }

        public final void p() {
            if (this.f13313s != -1) {
                this.f13315w.f13296a.vl();
            }
            try {
                this.f13313s = this.f13315w.f13296a.mp();
                String vl2 = this.f13315w.f13296a.vl();
                if (vl2 != null) {
                    String obj = StringsKt.trim(vl2).toString();
                    if (this.f13313s >= 0 && (obj.length() <= 0 || StringsKt.startsWith$default(obj, ";", false, 2, (Object) null))) {
                        if (this.f13313s == 0) {
                            this.f13312f = false;
                            n3 n3Var = this.f13315w;
                            n3Var.f13301zn = n3Var.f13299n3.y();
                            n nVar = this.f13315w.f13298gv;
                            Intrinsics.checkNotNull(nVar);
                            wz xc2 = nVar.xc();
                            r rVar = this.f13314t;
                            z zVar = this.f13315w.f13301zn;
                            Intrinsics.checkNotNull(zVar);
                            qc1.v.fb(xc2, rVar, zVar);
                            v();
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f13313s + obj + '\"');
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // rc1.n3.y
        public long read(zc1.v sink, long j2) {
            boolean z2;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (!y()) {
                    if (!this.f13312f) {
                        return -1L;
                    }
                    long j4 = this.f13313s;
                    if (j4 == 0 || j4 == -1) {
                        p();
                        if (!this.f13312f) {
                            return -1L;
                        }
                    }
                    long read = super.read(sink, Math.min(j2, this.f13313s));
                    if (read != -1) {
                        this.f13313s -= read;
                        return read;
                    }
                    this.f13315w.n3().d0();
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    v();
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
    }

    public n3(n nVar, pc1.a connection, zc1.fb source, zc1.a sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f13298gv = nVar;
        this.f13300v = connection;
        this.f13296a = source;
        this.f13297fb = sink;
        this.f13299n3 = new rc1.y(source);
    }

    @Override // qc1.gv
    public void a(d0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        c5 c5Var = c5.y;
        Proxy.Type type = n3().n3().n3().type();
        Intrinsics.checkNotNullExpressionValue(type, "connection.route().proxy.type()");
        d0(request.a(), c5Var.y(request, type));
    }

    public final void c(kc1.rz response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long co2 = lc1.n3.co(response);
        if (co2 == -1) {
            return;
        }
        ta i42 = i4(co2);
        lc1.n3.x(i42, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        i42.close();
    }

    @Override // qc1.gv
    public void cancel() {
        n3().fb();
    }

    public final boolean co(d0 d0Var) {
        return StringsKt.equals("chunked", d0Var.gv("Transfer-Encoding"), true);
    }

    public final void d0(z headers, String requestLine) {
        boolean z2;
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (this.y == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f13297fb.n(requestLine).n("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.f13297fb.n(headers.zn(i)).n(": ").n(headers.c5(i)).n("\r\n");
            }
            this.f13297fb.n("\r\n");
            this.y = 1;
            return;
        }
        throw new IllegalStateException(("state: " + this.y).toString());
    }

    public final rz f3() {
        boolean z2 = true;
        if (this.y != 1) {
            z2 = false;
        }
        if (z2) {
            this.y = 2;
            return new a();
        }
        throw new IllegalStateException(("state: " + this.y).toString());
    }

    @Override // qc1.gv
    public rz fb(d0 request, long j2) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.y() != null && request.y().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (co(request)) {
            return r();
        }
        if (j2 != -1) {
            return f3();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // qc1.gv
    public long gv(kc1.rz response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!qc1.v.zn(response)) {
            return 0L;
        }
        if (z(response)) {
            return -1L;
        }
        return lc1.n3.co(response);
    }

    public final ta i4(long j2) {
        boolean z2;
        if (this.y == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.y = 5;
            return new v(j2);
        }
        throw new IllegalStateException(("state: " + this.y).toString());
    }

    public final void mt(t tVar) {
        d i92 = tVar.i9();
        tVar.f(d.a);
        i92.n3();
        i92.zn();
    }

    public final ta n() {
        boolean z2;
        if (this.y == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.y = 5;
            n3().d0();
            return new fb();
        }
        throw new IllegalStateException(("state: " + this.y).toString());
    }

    @Override // qc1.gv
    public pc1.a n3() {
        return this.f13300v;
    }

    public final rz r() {
        boolean z2 = true;
        if (this.y != 1) {
            z2 = false;
        }
        if (z2) {
            this.y = 2;
            return new C0204n3();
        }
        throw new IllegalStateException(("state: " + this.y).toString());
    }

    @Override // qc1.gv
    public void s() {
        this.f13297fb.flush();
    }

    @Override // qc1.gv
    public rz.y v(boolean z2) {
        int i = this.y;
        boolean z3 = true;
        if (i != 1 && i != 3) {
            z3 = false;
        }
        if (z3) {
            try {
                f y2 = f.f12789gv.y(this.f13299n3.n3());
                rz.y f4 = new rz.y().w(y2.y).fb(y2.f12790n3).tl(y2.f12791zn).f(this.f13299n3.y());
                if (z2 && y2.f12790n3 == 100) {
                    return null;
                }
                if (y2.f12790n3 == 100) {
                    this.y = 3;
                    return f4;
                }
                this.y = 4;
                return f4;
            } catch (EOFException e2) {
                String z4 = n3().n3().y().t().z();
                throw new IOException("unexpected end of stream on " + z4, e2);
            }
        }
        throw new IllegalStateException(("state: " + this.y).toString());
    }

    public final ta x4(r rVar) {
        boolean z2;
        if (this.y == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.y = 5;
            return new zn(this, rVar);
        }
        throw new IllegalStateException(("state: " + this.y).toString());
    }

    @Override // qc1.gv
    public void y() {
        this.f13297fb.flush();
    }

    public final boolean z(kc1.rz rzVar) {
        return StringsKt.equals("chunked", kc1.rz.d(rzVar, "Transfer-Encoding", null, 2, null), true);
    }

    @Override // qc1.gv
    public ta zn(kc1.rz response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!qc1.v.zn(response)) {
            return i4(0L);
        }
        if (z(response)) {
            return x4(response.o4().t());
        }
        long co2 = lc1.n3.co(response);
        if (co2 != -1) {
            return i4(co2);
        }
        return n();
    }
}
