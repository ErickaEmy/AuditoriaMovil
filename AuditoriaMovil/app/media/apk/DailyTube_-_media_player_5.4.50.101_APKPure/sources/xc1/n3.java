package xc1;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 implements v {
    public final Map<X500Principal, Set<X509Certificate>> y;

    public n3(X509Certificate... caCerts) {
        Intrinsics.checkNotNullParameter(caCerts, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : caCerts) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Intrinsics.checkNotNullExpressionValue(subjectX500Principal, "caCert.subjectX500Principal");
            Object obj = linkedHashMap.get(subjectX500Principal);
            if (obj == null) {
                obj = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, obj);
            }
            ((Set) obj).add(x509Certificate);
        }
        this.y = linkedHashMap;
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof n3) || !Intrinsics.areEqual(((n3) obj).y, this.y))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    @Override // xc1.v
    public X509Certificate y(X509Certificate cert) {
        Intrinsics.checkNotNullParameter(cert, "cert");
        Set<X509Certificate> set = this.y.get(cert.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            try {
                cert.verify(((X509Certificate) next).getPublicKey());
                obj = next;
                break;
            } catch (Exception unused) {
            }
        }
        return (X509Certificate) obj;
    }
}
