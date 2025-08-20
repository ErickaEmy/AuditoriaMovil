package kc1;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import zc1.s;
/* loaded from: classes.dex */
public final class fb {

    /* renamed from: gv  reason: collision with root package name */
    public static final n3 f9756gv = new n3(null);

    /* renamed from: zn  reason: collision with root package name */
    public static final fb f9757zn = new y().y();

    /* renamed from: n3  reason: collision with root package name */
    public final xc1.zn f9758n3;
    public final Set<zn> y;

    /* loaded from: classes.dex */
    public static final class gv extends Lambda implements Function0<List<? extends X509Certificate>> {
        final /* synthetic */ String $hostname;
        final /* synthetic */ List $peerCertificates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public gv(List list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends X509Certificate> invoke() {
            List<Certificate> list;
            xc1.zn gv2 = fb.this.gv();
            if (gv2 == null || (list = gv2.y(this.$peerCertificates, this.$hostname)) == null) {
                list = this.$peerCertificates;
            }
            List<Certificate> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Certificate certificate : list2) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public final zc1.s n3(X509Certificate sha1Hash) {
            Intrinsics.checkNotNullParameter(sha1Hash, "$this$sha1Hash");
            s.y yVar = zc1.s.fb;
            PublicKey publicKey = sha1Hash.getPublicKey();
            Intrinsics.checkNotNullExpressionValue(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return s.y.a(yVar, encoded, 0, 0, 3, (Object) null).j5();
        }

        public final String y(Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + zn((X509Certificate) certificate).y();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }

        public final zc1.s zn(X509Certificate sha256Hash) {
            Intrinsics.checkNotNullParameter(sha256Hash, "$this$sha256Hash");
            s.y yVar = zc1.s.fb;
            PublicKey publicKey = sha256Hash.getPublicKey();
            Intrinsics.checkNotNullExpressionValue(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return s.y.a(yVar, encoded, 0, 0, 3, (Object) null).o();
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public final List<zn> y = new ArrayList();

        public final fb y() {
            return new fb(CollectionsKt.toSet(this.y), null, 2, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final String f9759n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final zc1.s f9760zn;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zn)) {
                return false;
            }
            zn znVar = (zn) obj;
            if (Intrinsics.areEqual(this.y, znVar.y) && Intrinsics.areEqual(this.f9759n3, znVar.f9759n3) && Intrinsics.areEqual(this.f9760zn, znVar.f9760zn)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.y.hashCode() * 31) + this.f9759n3.hashCode()) * 31) + this.f9760zn.hashCode();
        }

        public final String n3() {
            return this.f9759n3;
        }

        public String toString() {
            return this.f9759n3 + '/' + this.f9760zn.y();
        }

        public final zc1.s y() {
            return this.f9760zn;
        }

        public final boolean zn(String hostname) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            if (StringsKt.startsWith$default(this.y, "**.", false, 2, (Object) null)) {
                int length = this.y.length() - 3;
                int length2 = hostname.length() - length;
                if (!StringsKt.regionMatches$default(hostname, hostname.length() - length, this.y, 3, length, false, 16, null)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else if (StringsKt.startsWith$default(this.y, "*.", false, 2, (Object) null)) {
                int length3 = this.y.length() - 1;
                int length4 = hostname.length() - length3;
                if (!StringsKt.regionMatches$default(hostname, hostname.length() - length3, this.y, 1, length3, false, 16, null) || StringsKt.lastIndexOf$default((CharSequence) hostname, '.', length4 - 1, false, 4, (Object) null) != -1) {
                    return false;
                }
            } else {
                return Intrinsics.areEqual(hostname, this.y);
            }
            return true;
        }
    }

    public fb(Set<zn> pins, xc1.zn znVar) {
        Intrinsics.checkNotNullParameter(pins, "pins");
        this.y = pins;
        this.f9758n3 = znVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof fb) {
            fb fbVar = (fb) obj;
            if (Intrinsics.areEqual(fbVar.y, this.y) && Intrinsics.areEqual(fbVar.f9758n3, this.f9758n3)) {
                return true;
            }
        }
        return false;
    }

    public final xc1.zn gv() {
        return this.f9758n3;
    }

    public int hashCode() {
        int i;
        int hashCode = (1517 + this.y.hashCode()) * 41;
        xc1.zn znVar = this.f9758n3;
        if (znVar != null) {
            i = znVar.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public final void n3(String hostname, Function0<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<zn> zn2 = zn(hostname);
        if (zn2.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> invoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : invoke) {
            zc1.s sVar = null;
            zc1.s sVar2 = null;
            for (zn znVar : zn2) {
                String n32 = znVar.n3();
                int hashCode = n32.hashCode();
                if (hashCode != -903629273) {
                    if (hashCode == 3528965 && n32.equals("sha1")) {
                        if (sVar2 == null) {
                            sVar2 = f9756gv.n3(x509Certificate);
                        }
                        if (Intrinsics.areEqual(znVar.y(), sVar2)) {
                            return;
                        }
                    }
                    throw new AssertionError("unsupported hashAlgorithm: " + znVar.n3());
                } else if (n32.equals("sha256")) {
                    if (sVar == null) {
                        sVar = f9756gv.zn(x509Certificate);
                    }
                    if (Intrinsics.areEqual(znVar.y(), sVar)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + znVar.n3());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : invoke) {
            sb.append("\n    ");
            sb.append(f9756gv.y(x509Certificate2));
            sb.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            Intrinsics.checkNotNullExpressionValue(subjectDN, "element.subjectDN");
            sb.append(subjectDN.getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (zn znVar2 : zn2) {
            sb.append("\n    ");
            sb.append(znVar2);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb2);
    }

    public final fb v(xc1.zn certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
        if (Intrinsics.areEqual(this.f9758n3, certificateChainCleaner)) {
            return this;
        }
        return new fb(this.y, certificateChainCleaner);
    }

    public final void y(String hostname, List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
        n3(hostname, new gv(peerCertificates, hostname));
    }

    public final List<zn> zn(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        List<zn> emptyList = CollectionsKt.emptyList();
        for (Object obj : this.y) {
            if (((zn) obj).zn(hostname)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                TypeIntrinsics.asMutableList(emptyList).add(obj);
            }
        }
        return emptyList;
    }

    public /* synthetic */ fb(Set set, xc1.zn znVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i & 2) != 0 ? null : znVar);
    }
}
