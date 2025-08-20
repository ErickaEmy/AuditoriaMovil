package kc1;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes.dex */
public final class co {

    /* renamed from: v  reason: collision with root package name */
    public static final y f9720v = new y(null);

    /* renamed from: gv  reason: collision with root package name */
    public final List<Certificate> f9721gv;

    /* renamed from: n3  reason: collision with root package name */
    public final d f9722n3;
    public final Lazy y;

    /* renamed from: zn  reason: collision with root package name */
    public final c5 f9723zn;

    /* loaded from: classes.dex */
    public static final class n3 extends Lambda implements Function0<List<? extends Certificate>> {
        final /* synthetic */ Function0 $peerCertificatesFn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n3(Function0 function0) {
            super(0);
            this.$peerCertificatesFn = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Certificate> invoke() {
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return CollectionsKt.emptyList();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* loaded from: classes.dex */
        public static final class n3 extends Lambda implements Function0<List<? extends Certificate>> {
            final /* synthetic */ List $peerCertificatesCopy;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public n3(List list) {
                super(0);
                this.$peerCertificatesCopy = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Certificate> invoke() {
                return this.$peerCertificatesCopy;
            }
        }

        /* renamed from: kc1.co$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0132y extends Lambda implements Function0<List<? extends Certificate>> {
            final /* synthetic */ List $peerCertificatesCopy;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0132y(List list) {
                super(0);
                this.$peerCertificatesCopy = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Certificate> invoke() {
                return this.$peerCertificatesCopy;
            }
        }

        public y() {
        }

        public final co n3(d tlsVersion, c5 cipherSuite, List<? extends Certificate> peerCertificates, List<? extends Certificate> localCertificates) {
            Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
            Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
            Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
            Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
            return new co(tlsVersion, cipherSuite, lc1.n3.j5(localCertificates), new C0132y(lc1.n3.j5(peerCertificates)));
        }

        public final co y(SSLSession handshake) throws IOException {
            List<Certificate> emptyList;
            Intrinsics.checkNotNullParameter(handshake, "$this$handshake");
            String cipherSuite = handshake.getCipherSuite();
            if (cipherSuite != null) {
                int hashCode = cipherSuite.hashCode();
                if (hashCode == 1019404634 ? !cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : !(hashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL"))) {
                    c5 n32 = c5.jr.n3(cipherSuite);
                    String protocol = handshake.getProtocol();
                    if (protocol != null) {
                        if (!Intrinsics.areEqual("NONE", protocol)) {
                            d y = d.f9729w.y(protocol);
                            try {
                                emptyList = zn(handshake.getPeerCertificates());
                            } catch (SSLPeerUnverifiedException unused) {
                                emptyList = CollectionsKt.emptyList();
                            }
                            return new co(y, n32, zn(handshake.getLocalCertificates()), new n3(emptyList));
                        }
                        throw new IOException("tlsVersion == NONE");
                    }
                    throw new IllegalStateException("tlsVersion == null");
                }
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            throw new IllegalStateException("cipherSuite == null");
        }

        public final List<Certificate> zn(Certificate[] certificateArr) {
            if (certificateArr != null) {
                return lc1.n3.z((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length));
            }
            return CollectionsKt.emptyList();
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public co(d tlsVersion, c5 cipherSuite, List<? extends Certificate> localCertificates, Function0<? extends List<? extends Certificate>> peerCertificatesFn) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
        Intrinsics.checkNotNullParameter(peerCertificatesFn, "peerCertificatesFn");
        this.f9722n3 = tlsVersion;
        this.f9723zn = cipherSuite;
        this.f9721gv = localCertificates;
        this.y = LazyKt.lazy(new n3(peerCertificatesFn));
    }

    public final Principal a() {
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) v());
        if (!(firstOrNull instanceof X509Certificate)) {
            firstOrNull = null;
        }
        X509Certificate x509Certificate = (X509Certificate) firstOrNull;
        if (x509Certificate == null) {
            return null;
        }
        return x509Certificate.getSubjectX500Principal();
    }

    public boolean equals(Object obj) {
        if (obj instanceof co) {
            co coVar = (co) obj;
            if (coVar.f9722n3 == this.f9722n3 && Intrinsics.areEqual(coVar.f9723zn, this.f9723zn) && Intrinsics.areEqual(coVar.v(), v()) && Intrinsics.areEqual(coVar.f9721gv, this.f9721gv)) {
                return true;
            }
        }
        return false;
    }

    public final d fb() {
        return this.f9722n3;
    }

    public final Principal gv() {
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) this.f9721gv);
        if (!(firstOrNull instanceof X509Certificate)) {
            firstOrNull = null;
        }
        X509Certificate x509Certificate = (X509Certificate) firstOrNull;
        if (x509Certificate == null) {
            return null;
        }
        return x509Certificate.getSubjectX500Principal();
    }

    public int hashCode() {
        return ((((((527 + this.f9722n3.hashCode()) * 31) + this.f9723zn.hashCode()) * 31) + v().hashCode()) * 31) + this.f9721gv.hashCode();
    }

    public final String n3(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        return type;
    }

    public String toString() {
        List<Certificate> v2 = v();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(v2, 10));
        for (Certificate certificate : v2) {
            arrayList.add(n3(certificate));
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{");
        sb.append("tlsVersion=");
        sb.append(this.f9722n3);
        sb.append(' ');
        sb.append("cipherSuite=");
        sb.append(this.f9723zn);
        sb.append(' ');
        sb.append("peerCertificates=");
        sb.append(obj);
        sb.append(' ');
        sb.append("localCertificates=");
        List<Certificate> list = this.f9721gv;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Certificate certificate2 : list) {
            arrayList2.add(n3(certificate2));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    public final List<Certificate> v() {
        return (List) this.y.getValue();
    }

    public final c5 y() {
        return this.f9723zn;
    }

    public final List<Certificate> zn() {
        return this.f9721gv;
    }
}
