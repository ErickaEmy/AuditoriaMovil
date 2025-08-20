package lc1;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zc1.v;
/* loaded from: classes.dex */
public final class y {
    public static final String gv(byte[] bArr) {
        int i = -1;
        int i5 = 0;
        int i6 = 0;
        int i8 = 0;
        while (i6 < bArr.length) {
            int i10 = i6;
            while (i10 < 16 && bArr[i10] == 0 && bArr[i10 + 1] == 0) {
                i10 += 2;
            }
            int i11 = i10 - i6;
            if (i11 > i8 && i11 >= 4) {
                i = i6;
                i8 = i11;
            }
            i6 = i10 + 2;
        }
        v vVar = new v();
        while (i5 < bArr.length) {
            if (i5 == i) {
                vVar.w2(58);
                i5 += i8;
                if (i5 == 16) {
                    vVar.w2(58);
                }
            } else {
                if (i5 > 0) {
                    vVar.w2(58);
                }
                vVar.cs((n3.n3(bArr[i5], 255) << 8) | n3.n3(bArr[i5 + 1], 255));
                i5 += 2;
            }
        }
        return vVar.wf();
    }

    public static final boolean n3(String str, int i, int i5, byte[] bArr, int i6) {
        int i8 = i6;
        while (i < i5) {
            if (i8 == bArr.length) {
                return false;
            }
            if (i8 != i6) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i10 = i;
            int i11 = 0;
            while (i10 < i5) {
                char charAt = str.charAt(i10);
                if (Intrinsics.compare((int) charAt, 48) < 0 || Intrinsics.compare((int) charAt, 57) > 0) {
                    break;
                } else if ((i11 == 0 && i != i10) || (i11 = ((i11 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i10++;
                }
            }
            if (i10 - i == 0) {
                return false;
            }
            bArr[i8] = (byte) i11;
            i8++;
            i = i10;
        }
        if (i8 != i6 + 4) {
            return false;
        }
        return true;
    }

    public static final String v(String toCanonicalHost) {
        InetAddress zn2;
        Intrinsics.checkNotNullParameter(toCanonicalHost, "$this$toCanonicalHost");
        if (StringsKt.contains$default((CharSequence) toCanonicalHost, (CharSequence) ":", false, 2, (Object) null)) {
            if (StringsKt.startsWith$default(toCanonicalHost, "[", false, 2, (Object) null) && StringsKt.endsWith$default(toCanonicalHost, "]", false, 2, (Object) null)) {
                zn2 = zn(toCanonicalHost, 1, toCanonicalHost.length() - 1);
            } else {
                zn2 = zn(toCanonicalHost, 0, toCanonicalHost.length());
            }
            if (zn2 == null) {
                return null;
            }
            byte[] address = zn2.getAddress();
            if (address.length == 16) {
                Intrinsics.checkNotNullExpressionValue(address, "address");
                return gv(address);
            } else if (address.length == 4) {
                return zn2.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
            }
        }
        try {
            String ascii = IDN.toASCII(toCanonicalHost);
            Intrinsics.checkNotNullExpressionValue(ascii, "IDN.toASCII(host)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (ascii != null) {
                String lowerCase = ascii.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() != 0 && !y(lowerCase)) {
                    return lowerCase;
                }
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final boolean y(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0 || StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
        if (r13 == 16) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
        if (r14 != (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ae, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.net.InetAddress zn(java.lang.String r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 175
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lc1.y.zn(java.lang.String, int, int):java.net.InetAddress");
    }
}
