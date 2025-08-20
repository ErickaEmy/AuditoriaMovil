package kc1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final c5[] f9913a;

    /* renamed from: c5  reason: collision with root package name */
    public static final t f9914c5;

    /* renamed from: f  reason: collision with root package name */
    public static final n3 f9915f = new n3(null);

    /* renamed from: fb  reason: collision with root package name */
    public static final t f9916fb;

    /* renamed from: i9  reason: collision with root package name */
    public static final t f9917i9;

    /* renamed from: s  reason: collision with root package name */
    public static final t f9918s;

    /* renamed from: v  reason: collision with root package name */
    public static final c5[] f9919v;

    /* renamed from: gv  reason: collision with root package name */
    public final String[] f9920gv;

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f9921n3;
    public final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final String[] f9922zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f9923gv;

        /* renamed from: n3  reason: collision with root package name */
        public String[] f9924n3;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public String[] f9925zn;

        public y(boolean z2) {
            this.y = z2;
        }

        public final y a(d... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (this.y) {
                ArrayList arrayList = new ArrayList(tlsVersions.length);
                for (d dVar : tlsVersions) {
                    arrayList.add(dVar.y());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    return v((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }

        public final y gv(boolean z2) {
            if (this.y) {
                this.f9923gv = z2;
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }

        public final y n3(String... cipherSuites) {
            boolean z2;
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (this.y) {
                if (cipherSuites.length == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    Object clone = cipherSuites.clone();
                    if (clone != null) {
                        this.f9924n3 = (String[]) clone;
                        return this;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }

        public final y v(String... tlsVersions) {
            boolean z2;
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (this.y) {
                if (tlsVersions.length == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    Object clone = tlsVersions.clone();
                    if (clone != null) {
                        this.f9925zn = (String[]) clone;
                        return this;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }

        public final t y() {
            return new t(this.y, this.f9923gv, this.f9924n3, this.f9925zn);
        }

        public final y zn(c5... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (this.y) {
                ArrayList arrayList = new ArrayList(cipherSuites.length);
                for (c5 c5Var : cipherSuites) {
                    arrayList.add(c5Var.zn());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    return n3((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }

        public y(t connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.y = connectionSpec.a();
            this.f9924n3 = connectionSpec.f9922zn;
            this.f9925zn = connectionSpec.f9920gv;
            this.f9923gv = connectionSpec.s();
        }
    }

    static {
        c5 c5Var = c5.n7;
        c5 c5Var2 = c5.c8;
        c5 c5Var3 = c5.h;
        c5 c5Var4 = c5.f9641i3;
        c5 c5Var5 = c5.f9672q;
        c5 c5Var6 = c5.f9697vn;
        c5 c5Var7 = c5.f9703wm;
        c5 c5Var8 = c5.f9693uo;
        c5 c5Var9 = c5.f9614br;
        c5[] c5VarArr = {c5Var, c5Var2, c5Var3, c5Var4, c5Var5, c5Var6, c5Var7, c5Var8, c5Var9};
        f9919v = c5VarArr;
        c5[] c5VarArr2 = {c5Var, c5Var2, c5Var3, c5Var4, c5Var5, c5Var6, c5Var7, c5Var8, c5Var9, c5.f9652l, c5.f9637gq, c5.f9627eb, c5.f9653lc, c5.f9718z6, c5.f9705x, c5.f9630f};
        f9913a = c5VarArr2;
        y zn2 = new y(true).zn((c5[]) Arrays.copyOf(c5VarArr, c5VarArr.length));
        d dVar = d.TLS_1_3;
        d dVar2 = d.TLS_1_2;
        f9916fb = zn2.a(dVar, dVar2).gv(true).y();
        f9918s = new y(true).zn((c5[]) Arrays.copyOf(c5VarArr2, c5VarArr2.length)).a(dVar, dVar2).gv(true).y();
        f9914c5 = new y(true).zn((c5[]) Arrays.copyOf(c5VarArr2, c5VarArr2.length)).a(dVar, dVar2, d.TLS_1_1, d.TLS_1_0).gv(true).y();
        f9917i9 = new y(false).y();
    }

    public t(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.y = z2;
        this.f9921n3 = z3;
        this.f9922zn = strArr;
        this.f9920gv = strArr2;
    }

    public final boolean a() {
        return this.y;
    }

    public final List<d> c5() {
        String[] strArr = this.f9920gv;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(d.f9729w.y(str));
            }
            return CollectionsKt.toList(arrayList);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z2 = this.y;
        t tVar = (t) obj;
        if (z2 != tVar.y) {
            return false;
        }
        if (z2 && (!Arrays.equals(this.f9922zn, tVar.f9922zn) || !Arrays.equals(this.f9920gv, tVar.f9920gv) || this.f9921n3 != tVar.f9921n3)) {
            return false;
        }
        return true;
    }

    public final t fb(SSLSocket sSLSocket, boolean z2) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        if (this.f9922zn != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = lc1.n3.fh(enabledCipherSuites, this.f9922zn, c5.jr.zn());
        } else {
            cipherSuitesIntersection = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f9920gv != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = lc1.n3.fh(enabledProtocols, this.f9920gv, ComparisonsKt.naturalOrder());
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        int r2 = lc1.n3.r(supportedCipherSuites, "TLS_FALLBACK_SCSV", c5.jr.zn());
        if (z2 && r2 != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[r2];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = lc1.n3.t(cipherSuitesIntersection, str);
        }
        y yVar = new y(this);
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        y n32 = yVar.n3((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        return n32.v((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).y();
    }

    public final List<c5> gv() {
        String[] strArr = this.f9922zn;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(c5.jr.n3(str));
            }
            return CollectionsKt.toList(arrayList);
        }
        return null;
    }

    public int hashCode() {
        int i;
        if (this.y) {
            String[] strArr = this.f9922zn;
            int i5 = 0;
            if (strArr != null) {
                i = Arrays.hashCode(strArr);
            } else {
                i = 0;
            }
            int i6 = (527 + i) * 31;
            String[] strArr2 = this.f9920gv;
            if (strArr2 != null) {
                i5 = Arrays.hashCode(strArr2);
            }
            return ((i6 + i5) * 31) + (!this.f9921n3 ? 1 : 0);
        }
        return 17;
    }

    public final boolean s() {
        return this.f9921n3;
    }

    public String toString() {
        if (!this.y) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(gv(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c5(), "[all enabled]") + ", supportsTlsExtensions=" + this.f9921n3 + ')';
    }

    public final boolean v(SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.y) {
            return false;
        }
        String[] strArr = this.f9920gv;
        if (strArr != null && !lc1.n3.mt(strArr, socket.getEnabledProtocols(), ComparisonsKt.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.f9922zn;
        if (strArr2 != null && !lc1.n3.mt(strArr2, socket.getEnabledCipherSuites(), c5.jr.zn())) {
            return false;
        }
        return true;
    }

    public final void zn(SSLSocket sslSocket, boolean z2) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        t fb2 = fb(sslSocket, z2);
        if (fb2.c5() != null) {
            sslSocket.setEnabledProtocols(fb2.f9920gv);
        }
        if (fb2.gv() != null) {
            sslSocket.setEnabledCipherSuites(fb2.f9922zn);
        }
    }
}
