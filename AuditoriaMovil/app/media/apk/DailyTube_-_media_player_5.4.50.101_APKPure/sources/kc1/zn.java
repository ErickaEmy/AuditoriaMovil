package kc1;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kc1.d0;
import kc1.rz;
import kc1.z;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import nc1.gv;
import uc1.s;
import zc1.s;
/* loaded from: classes.dex */
public final class zn implements Closeable, Flushable {

    /* renamed from: w  reason: collision with root package name */
    public static final n3 f9959w = new n3(null);

    /* renamed from: f  reason: collision with root package name */
    public int f9960f;

    /* renamed from: fb  reason: collision with root package name */
    public int f9961fb;

    /* renamed from: s  reason: collision with root package name */
    public int f9962s;

    /* renamed from: t  reason: collision with root package name */
    public int f9963t;

    /* renamed from: v  reason: collision with root package name */
    public int f9964v;
    public final nc1.gv y;

    /* loaded from: classes.dex */
    public final class gv implements nc1.n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final gv.n3 f9965gv;

        /* renamed from: n3  reason: collision with root package name */
        public final zc1.rz f9966n3;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ zn f9967v;
        public final zc1.rz y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f9968zn;

        /* loaded from: classes.dex */
        public static final class y extends zc1.i9 {
            public y(zc1.rz rzVar) {
                super(rzVar);
            }

            public void close() throws IOException {
                synchronized (gv.this.f9967v) {
                    if (gv.this.gv()) {
                        return;
                    }
                    gv.this.v(true);
                    zn znVar = gv.this.f9967v;
                    znVar.x4(znVar.p() + 1);
                    super.close();
                    gv.this.f9965gv.n3();
                }
            }
        }

        public gv(zn znVar, gv.n3 editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            this.f9967v = znVar;
            this.f9965gv = editor;
            zc1.rz a2 = editor.a(1);
            this.y = a2;
            this.f9966n3 = new y(a2);
        }

        public final boolean gv() {
            return this.f9968zn;
        }

        @Override // nc1.n3
        public zc1.rz n3() {
            return this.f9966n3;
        }

        public final void v(boolean z2) {
            this.f9968zn = z2;
        }

        @Override // nc1.n3
        public void y() {
            synchronized (this.f9967v) {
                if (this.f9968zn) {
                    return;
                }
                this.f9968zn = true;
                zn znVar = this.f9967v;
                znVar.r(znVar.s() + 1);
                lc1.n3.i9(this.y);
                try {
                    this.f9965gv.y();
                } catch (IOException unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public final z a(rz varyHeaders) {
            Intrinsics.checkNotNullParameter(varyHeaders, "$this$varyHeaders");
            rz yt2 = varyHeaders.yt();
            Intrinsics.checkNotNull(yt2);
            return v(yt2.o4().a(), varyHeaders.b());
        }

        public final boolean fb(rz cachedResponse, z cachedRequest, d0 newRequest) {
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
            Intrinsics.checkNotNullParameter(cachedRequest, "cachedRequest");
            Intrinsics.checkNotNullParameter(newRequest, "newRequest");
            Set<String> gv2 = gv(cachedResponse.b());
            if ((gv2 instanceof Collection) && gv2.isEmpty()) {
                return true;
            }
            for (String str : gv2) {
                if (!Intrinsics.areEqual(cachedRequest.i9(str), newRequest.v(str))) {
                    return false;
                }
            }
            return true;
        }

        public final Set<String> gv(z zVar) {
            int size = zVar.size();
            TreeSet treeSet = null;
            for (int i = 0; i < size; i++) {
                if (StringsKt.equals("Vary", zVar.zn(i), true)) {
                    String c52 = zVar.c5(i);
                    if (treeSet == null) {
                        treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                    }
                    for (String str : StringsKt.split$default((CharSequence) c52, new char[]{','}, false, 0, 6, (Object) null)) {
                        if (str != null) {
                            treeSet.add(StringsKt.trim(str).toString());
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                    continue;
                }
            }
            if (treeSet == null) {
                return SetsKt.emptySet();
            }
            return treeSet;
        }

        public final String n3(r url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return zc1.s.fb.gv(url.toString()).d().r();
        }

        public final z v(z zVar, z zVar2) {
            Set<String> gv2 = gv(zVar2);
            if (gv2.isEmpty()) {
                return lc1.n3.f10305n3;
            }
            z.y yVar = new z.y();
            int size = zVar.size();
            for (int i = 0; i < size; i++) {
                String zn2 = zVar.zn(i);
                if (gv2.contains(zn2)) {
                    yVar.y(zn2, zVar.c5(i));
                }
            }
            return yVar.a();
        }

        public final boolean y(rz hasVaryAll) {
            Intrinsics.checkNotNullParameter(hasVaryAll, "$this$hasVaryAll");
            return gv(hasVaryAll.b()).contains("*");
        }

        public final int zn(zc1.fb source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            try {
                long s82 = source.s8();
                String vl2 = source.vl();
                if (s82 >= 0 && s82 <= Integer.MAX_VALUE && vl2.length() <= 0) {
                    return (int) s82;
                }
                throw new IOException("expected an int but was \"" + s82 + vl2 + '\"');
            } catch (NumberFormatException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends mg {

        /* renamed from: fb  reason: collision with root package name */
        public final String f9969fb;

        /* renamed from: s  reason: collision with root package name */
        public final String f9970s;

        /* renamed from: v  reason: collision with root package name */
        public final gv.C0164gv f9971v;
        public final zc1.fb y;

        /* renamed from: kc1.zn$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0137y extends zc1.f {

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ zc1.ta f9972v;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0137y(zc1.ta taVar, zc1.ta taVar2) {
                super(taVar2);
                this.f9972v = taVar;
            }

            public void close() throws IOException {
                y.this.y().close();
                super.close();
            }
        }

        public y(gv.C0164gv snapshot, String str, String str2) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.f9971v = snapshot;
            this.f9969fb = str;
            this.f9970s = str2;
            zc1.ta v2 = snapshot.v(1);
            this.y = zc1.p.gv(new C0137y(v2, v2));
        }

        @Override // kc1.mg
        public long contentLength() {
            String str = this.f9970s;
            if (str == null) {
                return -1L;
            }
            return lc1.n3.o(str, -1L);
        }

        @Override // kc1.mg
        public i4 contentType() {
            String str = this.f9969fb;
            if (str != null) {
                return i4.f9789fb.n3(str);
            }
            return null;
        }

        @Override // kc1.mg
        public zc1.fb source() {
            return this.y;
        }

        public final gv.C0164gv y() {
            return this.f9971v;
        }
    }

    public zn(File directory, long j2, tc1.y fileSystem) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.y = new nc1.gv(fileSystem, directory, 201105, 2, j2, oc1.v.f12249s);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.y.close();
    }

    public final void co(d0 request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.y.ad(f9959w.n3(request.t()));
    }

    public final synchronized void d(nc1.zn cacheStrategy) {
        try {
            Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
            this.f9963t++;
            if (cacheStrategy.n3() != null) {
                this.f9962s++;
            } else if (cacheStrategy.y() != null) {
                this.f9960f++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.y.flush();
    }

    public final nc1.n3 mt(rz response) {
        gv.n3 n3Var;
        Intrinsics.checkNotNullParameter(response, "response");
        String s2 = response.o4().s();
        if (qc1.a.y.y(response.o4().s())) {
            try {
                co(response.o4());
            } catch (IOException unused) {
            }
            return null;
        } else if (!Intrinsics.areEqual(s2, "GET")) {
            return null;
        } else {
            n3 n3Var2 = f9959w;
            if (n3Var2.y(response)) {
                return null;
            }
            C0138zn c0138zn = new C0138zn(response);
            try {
                n3Var = nc1.gv.k5(this.y, n3Var2.n3(response.o4().t()), 0L, 2, null);
                if (n3Var == null) {
                    return null;
                }
                try {
                    c0138zn.a(n3Var);
                    return new gv(this, n3Var);
                } catch (IOException unused2) {
                    y(n3Var);
                    return null;
                }
            } catch (IOException unused3) {
                n3Var = null;
            }
        }
    }

    public final int p() {
        return this.f9964v;
    }

    public final void r(int i) {
        this.f9961fb = i;
    }

    public final int s() {
        return this.f9961fb;
    }

    public final synchronized void ta() {
        this.f9960f++;
    }

    public final void ud(rz cached, rz network) {
        gv.n3 n3Var;
        Intrinsics.checkNotNullParameter(cached, "cached");
        Intrinsics.checkNotNullParameter(network, "network");
        C0138zn c0138zn = new C0138zn(network);
        mg y2 = cached.y();
        if (y2 != null) {
            try {
                n3Var = ((y) y2).y().y();
                if (n3Var != null) {
                    try {
                        c0138zn.a(n3Var);
                        n3Var.n3();
                    } catch (IOException unused) {
                        y(n3Var);
                    }
                }
            } catch (IOException unused2) {
                n3Var = null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
    }

    public final rz v(d0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            gv.C0164gv yt2 = this.y.yt(f9959w.n3(request.t()));
            if (yt2 != null) {
                try {
                    C0138zn c0138zn = new C0138zn(yt2.v(0));
                    rz gv2 = c0138zn.gv(yt2);
                    if (!c0138zn.n3(request, gv2)) {
                        mg y2 = gv2.y();
                        if (y2 != null) {
                            lc1.n3.i9(y2);
                        }
                        return null;
                    }
                    return gv2;
                } catch (IOException unused) {
                    lc1.n3.i9(yt2);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    public final void x4(int i) {
        this.f9964v = i;
    }

    public final void y(gv.n3 n3Var) {
        if (n3Var != null) {
            try {
                n3Var.y();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zn(File directory, long j2) {
        this(directory, j2, tc1.y.y);
        Intrinsics.checkNotNullParameter(directory, "directory");
    }

    /* renamed from: kc1.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0138zn {

        /* renamed from: f  reason: collision with root package name */
        public static final String f9973f;

        /* renamed from: t  reason: collision with root package name */
        public static final String f9974t;

        /* renamed from: tl  reason: collision with root package name */
        public static final y f9975tl = new y(null);

        /* renamed from: a  reason: collision with root package name */
        public final String f9976a;

        /* renamed from: c5  reason: collision with root package name */
        public final long f9977c5;

        /* renamed from: fb  reason: collision with root package name */
        public final z f9978fb;

        /* renamed from: gv  reason: collision with root package name */
        public final c f9979gv;

        /* renamed from: i9  reason: collision with root package name */
        public final long f9980i9;

        /* renamed from: n3  reason: collision with root package name */
        public final z f9981n3;

        /* renamed from: s  reason: collision with root package name */
        public final co f9982s;

        /* renamed from: v  reason: collision with root package name */
        public final int f9983v;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f9984zn;

        /* renamed from: kc1.zn$zn$y */
        /* loaded from: classes.dex */
        public static final class y {
            public y() {
            }

            public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            s.y yVar;
            StringBuilder sb = new StringBuilder();
            sb.append(uc1.s.f14065zn.fb().fb());
            sb.append("-Sent-Millis");
            f9973f = sb.toString();
            f9974t = yVar.fb().fb() + "-Received-Millis";
        }

        public C0138zn(zc1.ta rawSource) throws IOException {
            d dVar;
            Intrinsics.checkNotNullParameter(rawSource, "rawSource");
            try {
                zc1.fb gv2 = zc1.p.gv(rawSource);
                this.y = gv2.vl();
                this.f9984zn = gv2.vl();
                z.y yVar = new z.y();
                int zn2 = zn.f9959w.zn(gv2);
                for (int i = 0; i < zn2; i++) {
                    yVar.zn(gv2.vl());
                }
                this.f9981n3 = yVar.a();
                qc1.f y2 = qc1.f.f12789gv.y(gv2.vl());
                this.f9979gv = y2.y;
                this.f9983v = y2.f12790n3;
                this.f9976a = y2.f12791zn;
                z.y yVar2 = new z.y();
                int zn3 = zn.f9959w.zn(gv2);
                for (int i5 = 0; i5 < zn3; i5++) {
                    yVar2.zn(gv2.vl());
                }
                String str = f9973f;
                String fb2 = yVar2.fb(str);
                String str2 = f9974t;
                String fb3 = yVar2.fb(str2);
                yVar2.c5(str);
                yVar2.c5(str2);
                this.f9977c5 = fb2 != null ? Long.parseLong(fb2) : 0L;
                this.f9980i9 = fb3 != null ? Long.parseLong(fb3) : 0L;
                this.f9978fb = yVar2.a();
                if (y()) {
                    String vl2 = gv2.vl();
                    if (vl2.length() <= 0) {
                        c5 n32 = c5.jr.n3(gv2.vl());
                        List<Certificate> zn4 = zn(gv2);
                        List<Certificate> zn5 = zn(gv2);
                        if (!gv2.nf()) {
                            dVar = d.f9729w.y(gv2.vl());
                        } else {
                            dVar = d.SSL_3_0;
                        }
                        this.f9982s = co.f9720v.n3(dVar, n32, zn4, zn5);
                    } else {
                        throw new IOException("expected \"\" but was \"" + vl2 + '\"');
                    }
                } else {
                    this.f9982s = null;
                }
                rawSource.close();
            } catch (Throwable th) {
                rawSource.close();
                throw th;
            }
        }

        public final void a(gv.n3 editor) throws IOException {
            Intrinsics.checkNotNullParameter(editor, "editor");
            zc1.a zn2 = zc1.p.zn(editor.a(0));
            try {
                zn2.n(this.y).writeByte(10);
                zn2.n(this.f9984zn).writeByte(10);
                zn2.f7(this.f9981n3.size()).writeByte(10);
                int size = this.f9981n3.size();
                for (int i = 0; i < size; i++) {
                    zn2.n(this.f9981n3.zn(i)).n(": ").n(this.f9981n3.c5(i)).writeByte(10);
                }
                zn2.n(new qc1.f(this.f9979gv, this.f9983v, this.f9976a).toString()).writeByte(10);
                zn2.f7(this.f9978fb.size() + 2).writeByte(10);
                int size2 = this.f9978fb.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    zn2.n(this.f9978fb.zn(i5)).n(": ").n(this.f9978fb.c5(i5)).writeByte(10);
                }
                zn2.n(f9973f).n(": ").f7(this.f9977c5).writeByte(10);
                zn2.n(f9974t).n(": ").f7(this.f9980i9).writeByte(10);
                if (y()) {
                    zn2.writeByte(10);
                    co coVar = this.f9982s;
                    Intrinsics.checkNotNull(coVar);
                    zn2.n(coVar.y().zn()).writeByte(10);
                    v(zn2, this.f9982s.v());
                    v(zn2, this.f9982s.zn());
                    zn2.n(this.f9982s.fb().y()).writeByte(10);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(zn2, null);
            } finally {
            }
        }

        public final rz gv(gv.C0164gv snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            String y2 = this.f9978fb.y("Content-Type");
            String y7 = this.f9978fb.y("Content-Length");
            return new rz.y().co(new d0.y().w(this.y).c5(this.f9984zn, null).s(this.f9981n3).n3()).w(this.f9979gv).fb(this.f9983v).tl(this.f9976a).f(this.f9978fb).n3(new y(snapshot, y2, y7)).c5(this.f9982s).z(this.f9977c5).p(this.f9980i9).zn();
        }

        public final boolean n3(d0 request, rz response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            if (Intrinsics.areEqual(this.y, request.t().toString()) && Intrinsics.areEqual(this.f9984zn, request.s()) && zn.f9959w.fb(response, this.f9981n3, request)) {
                return true;
            }
            return false;
        }

        public final void v(zc1.a aVar, List<? extends Certificate> list) throws IOException {
            try {
                aVar.f7(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    byte[] bytes = list.get(i).getEncoded();
                    s.y yVar = zc1.s.fb;
                    Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
                    aVar.n(s.y.a(yVar, bytes, 0, 0, 3, (Object) null).y()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public final boolean y() {
            return StringsKt.startsWith$default(this.y, "https://", false, 2, (Object) null);
        }

        public final List<Certificate> zn(zc1.fb fbVar) throws IOException {
            int zn2 = zn.f9959w.zn(fbVar);
            if (zn2 == -1) {
                return CollectionsKt.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(zn2);
                for (int i = 0; i < zn2; i++) {
                    String vl2 = fbVar.vl();
                    zc1.v vVar = new zc1.v();
                    zc1.s y2 = zc1.s.fb.y(vl2);
                    Intrinsics.checkNotNull(y2);
                    vVar.qk(y2);
                    arrayList.add(certificateFactory.generateCertificate(vVar.le()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public C0138zn(rz response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.y = response.o4().t().toString();
            this.f9981n3 = zn.f9959w.a(response);
            this.f9984zn = response.o4().s();
            this.f9979gv = response.dm();
            this.f9983v = response.mt();
            this.f9976a = response.k5();
            this.f9978fb = response.b();
            this.f9982s = response.r();
            this.f9977c5 = response.ap();
            this.f9980i9 = response.ct();
        }
    }
}
