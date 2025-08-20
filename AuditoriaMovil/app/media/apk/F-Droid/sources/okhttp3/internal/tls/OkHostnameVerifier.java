package okhttp3.internal.tls;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import ch.qos.logback.core.CoreConstants;
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
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
/* compiled from: OkHostnameVerifier.kt */
/* loaded from: classes2.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        Certificate certificate;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (isAscii(host)) {
            try {
                certificate = session.getPeerCertificates()[0];
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            } catch (SSLException unused) {
                return false;
            }
        }
        return verify(host, (X509Certificate) certificate);
    }

    public final boolean verify(String host, X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (Intrinsics.areEqual(canonicalHost, HostnamesKt.toCanonicalHost(str2))) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (INSTANCE.verifyHostname(asciiToLowercase, str2)) {
                return true;
            }
        }
        return false;
    }

    private final String asciiToLowercase(String str) {
        if (isAscii(str)) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        return str;
    }

    private final boolean isAscii(String str) {
        return str.length() == ((int) Utf8.size$default(str, 0, 0, 3, null));
    }

    private final boolean verifyHostname(String str, String str2) {
        boolean startsWith$default;
        boolean endsWith$default;
        boolean startsWith$default2;
        boolean endsWith$default2;
        boolean endsWith$default3;
        boolean endsWith$default4;
        boolean contains$default;
        boolean startsWith$default3;
        int indexOf$default;
        boolean endsWith$default5;
        int lastIndexOf$default;
        if (str != null && str.length() != 0) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, ".", false, 2, null);
            if (!startsWith$default) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, CallerDataConverter.DEFAULT_RANGE_DELIMITER, false, 2, null);
                if (!endsWith$default && str2 != null && str2.length() != 0) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str2, ".", false, 2, null);
                    if (!startsWith$default2) {
                        endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str2, CallerDataConverter.DEFAULT_RANGE_DELIMITER, false, 2, null);
                        if (!endsWith$default2) {
                            endsWith$default3 = StringsKt__StringsJVMKt.endsWith$default(str, ".", false, 2, null);
                            if (!endsWith$default3) {
                                str = str + CoreConstants.DOT;
                            }
                            String str3 = str;
                            endsWith$default4 = StringsKt__StringsJVMKt.endsWith$default(str2, ".", false, 2, null);
                            if (!endsWith$default4) {
                                str2 = str2 + CoreConstants.DOT;
                            }
                            String asciiToLowercase = asciiToLowercase(str2);
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) asciiToLowercase, (CharSequence) "*", false, 2, (Object) null);
                            if (!contains$default) {
                                return Intrinsics.areEqual(str3, asciiToLowercase);
                            }
                            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(asciiToLowercase, "*.", false, 2, null);
                            if (startsWith$default3) {
                                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) asciiToLowercase, '*', 1, false, 4, (Object) null);
                                if (indexOf$default == -1 && str3.length() >= asciiToLowercase.length() && !Intrinsics.areEqual("*.", asciiToLowercase)) {
                                    String substring = asciiToLowercase.substring(1);
                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                    endsWith$default5 = StringsKt__StringsJVMKt.endsWith$default(str3, substring, false, 2, null);
                                    if (endsWith$default5) {
                                        int length = str3.length() - substring.length();
                                        if (length > 0) {
                                            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str3, (char) CoreConstants.DOT, length - 1, false, 4, (Object) null);
                                            if (lastIndexOf$default != -1) {
                                                return false;
                                            }
                                        }
                                        return true;
                                    }
                                    return false;
                                }
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final List allSubjectAltNames(X509Certificate certificate) {
        List plus;
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        plus = CollectionsKt___CollectionsKt.plus((Collection) getSubjectAltNames(certificate, 7), (Iterable) getSubjectAltNames(certificate, 2));
        return plus;
    }

    private final List getSubjectAltNames(X509Certificate x509Certificate, int i) {
        List emptyList;
        Object obj;
        List emptyList2;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }
}
