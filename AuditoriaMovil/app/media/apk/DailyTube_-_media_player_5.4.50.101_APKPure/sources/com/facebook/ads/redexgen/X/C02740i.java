package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.0i  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02740i {
    public static byte[] A00;
    public static String[] A01 = {"88AoqknPZ4rnlocmRSd1iIvU160OI6Up", "Xa", "c0t0ITAkOrWkNbi2AOUUle7x7Lv9c02n", "B7XNNyfmW5R2wceLmJkXAkDES3fZG3Pt", "MUV", "NALjFYAH0tlSEiNw3RaQSfKZY5jyxbRm", "XF7p93xq3OHri6co5HggQunfVTz3vEaG", "n2FdIZz9zx79PfKUryB9rXi8CBHMM9xX"};
    public static final String A02;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 33);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{111, 84, 91, 88, 86, 95, 26, 78, 85, 26, 74, 91, 72, 73, 95, 26, 80, 73, 85, 84, 26, 94, 91, 78, 91, 26, 83, 84, 26, 123, 94, 123, 89, 78, 83, 85, 84, 124, 91, 89, 78, 85, 72, 67, 20, 19, 22, 3, 22, 82, 83, 78, 84, 73, 88, 65, 94, 75, 64, 113, 66, 71, 64, 69, 98, 115, 96, 97, 123, 124, 117, 27, 10, 24, 24, 31, 3, 25, 4, 30, 12, 3, 39, 32, 59, 38, 49, 40, 47, 52, 41, 62, 4, 46, 41, 55, 4, 44, 62, 57, 4, 61, 58, 55, 55, 57, 58, 56, 48, 49, 55, 48, 32, 123, 100, 105, 104, 98, 82, 120, Byte.MAX_VALUE, 97};
    }

    static {
        A03();
        A02 = C02740i.class.getSimpleName();
    }

    public static AbstractC02730h A00(C1116Yn c1116Yn, J2 j2, String str, Uri uri, Map<String, String> map, C1U c1u) {
        return A01(c1116Yn, j2, str, uri, map, true, false, c1u);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.X.AbstractC02730h A01(com.facebook.ads.redexgen.X.C1116Yn r14, com.facebook.ads.redexgen.X.J2 r15, java.lang.String r16, android.net.Uri r17, java.util.Map<java.lang.String, java.lang.String> r18, boolean r19, boolean r20, com.facebook.ads.redexgen.X.C1U r21) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02740i.A01(com.facebook.ads.redexgen.X.Yn, com.facebook.ads.redexgen.X.J2, java.lang.String, android.net.Uri, java.util.Map, boolean, boolean, com.facebook.ads.redexgen.X.1U):com.facebook.ads.redexgen.X.0h");
    }

    public static boolean A04(String str) {
        return A02(82, 5, 117).equalsIgnoreCase(str) || A02(55, 9, 15).equalsIgnoreCase(str);
    }
}
