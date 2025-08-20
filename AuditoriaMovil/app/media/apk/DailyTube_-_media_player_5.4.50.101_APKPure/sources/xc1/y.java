package xc1;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y extends zn {

    /* renamed from: zn  reason: collision with root package name */
    public static final C0249y f14942zn = new C0249y(null);

    /* renamed from: n3  reason: collision with root package name */
    public final v f14943n3;

    /* renamed from: xc1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0249y {
        public C0249y() {
        }

        public /* synthetic */ C0249y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public y(v trustRootIndex) {
        Intrinsics.checkNotNullParameter(trustRootIndex, "trustRootIndex");
        this.f14943n3 = trustRootIndex;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof y) && Intrinsics.areEqual(((y) obj).f14943n3, this.f14943n3)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f14943n3.hashCode();
    }

    public final boolean n3(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!Intrinsics.areEqual(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // xc1.zn
    public List<Certificate> y(List<? extends Certificate> chain, String hostname) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        Intrinsics.checkNotNullExpressionValue(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        boolean z2 = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj != null) {
                X509Certificate x509Certificate = (X509Certificate) obj;
                X509Certificate y = this.f14943n3.y(x509Certificate);
                if (y != null) {
                    if (arrayList.size() > 1 || !Intrinsics.areEqual(x509Certificate, y)) {
                        arrayList.add(y);
                    }
                    if (n3(y, y)) {
                        return arrayList;
                    }
                    z2 = true;
                } else {
                    Iterator it = arrayDeque.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "queue.iterator()");
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next != null) {
                            X509Certificate x509Certificate2 = (X509Certificate) next;
                            if (n3(x509Certificate, x509Certificate2)) {
                                it.remove();
                                arrayList.add(x509Certificate2);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                        }
                    }
                    if (z2) {
                        return arrayList;
                    }
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }
}
