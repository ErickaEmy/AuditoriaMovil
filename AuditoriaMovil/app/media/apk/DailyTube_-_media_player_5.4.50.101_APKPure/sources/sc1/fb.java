package sc1;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kc1.c;
import kc1.d0;
import kc1.n;
import kc1.rz;
import kc1.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qc1.f;
import zc1.ta;
/* loaded from: classes.dex */
public final class fb implements qc1.gv {

    /* renamed from: c5  reason: collision with root package name */
    public static final y f13779c5 = new y(null);

    /* renamed from: fb  reason: collision with root package name */
    public static final List<String> f13780fb = lc1.n3.z("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: s  reason: collision with root package name */
    public static final List<String> f13781s = lc1.n3.z("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    public final a f13782a;

    /* renamed from: gv  reason: collision with root package name */
    public final pc1.a f13783gv;

    /* renamed from: n3  reason: collision with root package name */
    public final c f13784n3;

    /* renamed from: v  reason: collision with root package name */
    public final qc1.fb f13785v;
    public volatile c5 y;

    /* renamed from: zn  reason: collision with root package name */
    public volatile boolean f13786zn;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final rz.y n3(z headerBlock, c protocol) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            z.y yVar = new z.y();
            int size = headerBlock.size();
            qc1.f fVar = null;
            for (int i = 0; i < size; i++) {
                String zn2 = headerBlock.zn(i);
                String c52 = headerBlock.c5(i);
                if (Intrinsics.areEqual(zn2, ":status")) {
                    f.y yVar2 = qc1.f.f12789gv;
                    fVar = yVar2.y("HTTP/1.1 " + c52);
                } else if (!fb.f13781s.contains(zn2)) {
                    yVar.gv(zn2, c52);
                }
            }
            if (fVar != null) {
                return new rz.y().w(protocol).fb(fVar.f12790n3).tl(fVar.f12791zn).f(yVar.a());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        public final List<zn> y(d0 request) {
            Intrinsics.checkNotNullParameter(request, "request");
            z a2 = request.a();
            ArrayList arrayList = new ArrayList(a2.size() + 4);
            arrayList.add(new zn(zn.f13844a, request.s()));
            arrayList.add(new zn(zn.f13846fb, qc1.c5.y.zn(request.t())));
            String gv2 = request.gv("Host");
            if (gv2 != null) {
                arrayList.add(new zn(zn.f13845c5, gv2));
            }
            arrayList.add(new zn(zn.f13849s, request.t().x4()));
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                String zn2 = a2.zn(i);
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                if (zn2 != null) {
                    String lowerCase = zn2.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (!fb.f13780fb.contains(lowerCase) || (Intrinsics.areEqual(lowerCase, "te") && Intrinsics.areEqual(a2.c5(i), "trailers"))) {
                        arrayList.add(new zn(lowerCase, a2.c5(i)));
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return arrayList;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public fb(n client, pc1.a connection, qc1.fb chain, a http2Connection) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.f13783gv = connection;
        this.f13785v = chain;
        this.f13782a = http2Connection;
        List<c> rz2 = client.rz();
        c cVar = c.H2_PRIOR_KNOWLEDGE;
        this.f13784n3 = rz2.contains(cVar) ? cVar : c.HTTP_2;
    }

    @Override // qc1.gv
    public void a(d0 request) {
        boolean z2;
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.y != null) {
            return;
        }
        if (request.y() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.y = this.f13782a.cs(f13779c5.y(request), z2);
        if (!this.f13786zn) {
            c5 c5Var = this.y;
            Intrinsics.checkNotNull(c5Var);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            c5Var.x4().s(this.f13785v.c5(), timeUnit);
            c5 c5Var2 = this.y;
            Intrinsics.checkNotNull(c5Var2);
            c5Var2.ta().s(this.f13785v.f(), timeUnit);
            return;
        }
        c5 c5Var3 = this.y;
        Intrinsics.checkNotNull(c5Var3);
        c5Var3.a(n3.CANCEL);
        throw new IOException("Canceled");
    }

    @Override // qc1.gv
    public void cancel() {
        this.f13786zn = true;
        c5 c5Var = this.y;
        if (c5Var != null) {
            c5Var.a(n3.CANCEL);
        }
    }

    @Override // qc1.gv
    public zc1.rz fb(d0 request, long j2) {
        Intrinsics.checkNotNullParameter(request, "request");
        c5 c5Var = this.y;
        Intrinsics.checkNotNull(c5Var);
        return c5Var.wz();
    }

    @Override // qc1.gv
    public long gv(rz response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!qc1.v.zn(response)) {
            return 0L;
        }
        return lc1.n3.co(response);
    }

    @Override // qc1.gv
    public pc1.a n3() {
        return this.f13783gv;
    }

    @Override // qc1.gv
    public void s() {
        this.f13782a.flush();
    }

    @Override // qc1.gv
    public rz.y v(boolean z2) {
        c5 c5Var = this.y;
        Intrinsics.checkNotNull(c5Var);
        rz.y n32 = f13779c5.n3(c5Var.rz(), this.f13784n3);
        if (z2 && n32.s() == 100) {
            return null;
        }
        return n32;
    }

    @Override // qc1.gv
    public void y() {
        c5 c5Var = this.y;
        Intrinsics.checkNotNull(c5Var);
        c5Var.wz().close();
    }

    @Override // qc1.gv
    public ta zn(rz response) {
        Intrinsics.checkNotNullParameter(response, "response");
        c5 c5Var = this.y;
        Intrinsics.checkNotNull(c5Var);
        return c5Var.w();
    }
}
