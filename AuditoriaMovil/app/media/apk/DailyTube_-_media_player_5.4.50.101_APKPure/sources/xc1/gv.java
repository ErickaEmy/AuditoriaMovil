package xc1;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zc1.z6;
/* loaded from: classes.dex */
public final class gv implements HostnameVerifier {
    public static final gv y = new gv();

    public final boolean a(String str, String str2) {
        if (str != null && str.length() != 0 && !StringsKt.startsWith$default(str, ".", false, 2, (Object) null) && !StringsKt.endsWith$default(str, "..", false, 2, (Object) null) && str2 != null && str2.length() != 0 && !StringsKt.startsWith$default(str2, ".", false, 2, (Object) null) && !StringsKt.endsWith$default(str2, "..", false, 2, (Object) null)) {
            if (!StringsKt.endsWith$default(str, ".", false, 2, (Object) null)) {
                str = str + ".";
            }
            String str3 = str;
            if (!StringsKt.endsWith$default(str2, ".", false, 2, (Object) null)) {
                str2 = str2 + ".";
            }
            String n32 = n3(str2);
            if (!StringsKt.contains$default((CharSequence) n32, (CharSequence) "*", false, 2, (Object) null)) {
                return Intrinsics.areEqual(str3, n32);
            }
            if (!StringsKt.startsWith$default(n32, "*.", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) n32, '*', 1, false, 4, (Object) null) != -1 || str3.length() < n32.length() || Intrinsics.areEqual("*.", n32)) {
                return false;
            }
            String substring = n32.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            if (!StringsKt.endsWith$default(str3, substring, false, 2, (Object) null)) {
                return false;
            }
            int length = str3.length() - substring.length();
            if (length > 0 && StringsKt.lastIndexOf$default((CharSequence) str3, '.', length - 1, false, 4, (Object) null) != -1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean fb(String str, X509Certificate x509Certificate) {
        String n32 = n3(str);
        List<String> zn2 = zn(x509Certificate, 2);
        if ((zn2 instanceof Collection) && zn2.isEmpty()) {
            return false;
        }
        for (String str2 : zn2) {
            if (y.a(n32, str2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean gv(String str) {
        if (str.length() != ((int) z6.n3(str, 0, 0, 3, (Object) null))) {
            return false;
        }
        return true;
    }

    public final String n3(String str) {
        if (gv(str)) {
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (str != null) {
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return str;
    }

    public final boolean s(String str, X509Certificate x509Certificate) {
        String v2 = lc1.y.v(str);
        List<String> zn2 = zn(x509Certificate, 7);
        if ((zn2 instanceof Collection) && zn2.isEmpty()) {
            return false;
        }
        for (String str2 : zn2) {
            if (Intrinsics.areEqual(v2, lc1.y.v(str2))) {
                return true;
            }
        }
        return false;
    }

    public final boolean v(String host, X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        if (lc1.n3.a(host)) {
            return s(host, certificate);
        }
        return fb(host, certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        Certificate certificate;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (gv(host)) {
            try {
                certificate = session.getPeerCertificates()[0];
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
            } catch (SSLException unused) {
                return false;
            }
        }
        return v(host, (X509Certificate) certificate);
    }

    public final List<String> y(X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return CollectionsKt.plus((Collection) zn(certificate, 7), (Iterable) zn(certificate, 2));
    }

    public final List<String> zn(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        } catch (CertificateParsingException unused) {
            return CollectionsKt.emptyList();
        }
    }
}
