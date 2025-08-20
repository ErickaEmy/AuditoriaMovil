package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: com.facebook.ads.redexgen.X.Bw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0558Bw {
    public static byte[] A02;
    public static String[] A03 = {"I7u5SMwnia1LjR8q2dDSZ1ZxyvAUDNjZ", "lA52iG6YY0NJNsRtQCweAmt1bj2X", "2qXiYNq9KlAFUySgaSTQYzQ4aWQihc1C", "j3GaPat5F4JzB2k2u38FDmanRSccFQ7x", "Rgx4knYMi3WRjmVXMYvkXYj", "jdUpLioS3ej7GnR7zzwjeYlHhGFO", "z8YFUav71iIZ039OmPtsZmkN2j2dK8kW", "CjGTtkLliNi5lySdeHdx4jpczrbS9nvg"};
    public static final InterfaceC0587Di A04;
    public static final Pattern A05;
    public int A00 = -1;
    public int A01 = -1;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 38);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{87, 41, 82, 57, 36, 48, 104, 36, 111, 72, 36, 79, 84, 114, 49, 116, 41, 33, 82, 57, 36, 48, 104, 36, 111, 72, 36, 79, 84, 114, 49, 116, 32, 41, 33, 82, 57, 36, 48, 104, 36, 111, 72, 36, 79, 84, 114, 49, 116, 32, 74, 70, 68, 7, 72, 89, 89, 69, 76, 7, 64, 125, 92, 71, 76, 90, 43, 22, 55, 44, 17, 15, 18, 0};
    }

    static {
        A01();
        A04 = new C1087Xk();
        A05 = Pattern.compile(A00(0, 50, 47));
    }

    private boolean A02(String str) {
        Matcher matcher = A05.matcher(str);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.A00 = parseInt;
                    this.A01 = parseInt2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public final boolean A03() {
        return (this.A00 == -1 || this.A01 == -1) ? false : true;
    }

    public final boolean A04(int i) {
        int encoderPadding = i >> 12;
        int encoderDelay = i & 4095;
        if (encoderPadding > 0 || encoderDelay > 0) {
            this.A00 = encoderPadding;
            this.A01 = encoderDelay;
            return true;
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A05(com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata r9) {
        /*
            r8 = this;
            r3 = 0
        L1:
            int r0 = r9.A00()
            if (r3 >= r0) goto L7a
            com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata$Entry r4 = r9.A01(r3)
            boolean r7 = r4 instanceof com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.CommentFrame
            r2 = 66
            r1 = 8
            r0 = 100
            java.lang.String r5 = A00(r2, r1, r0)
            r6 = 1
            if (r7 == 0) goto L4e
            com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.CommentFrame r4 = (com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.CommentFrame) r4
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0558Bw.A03
            r0 = 6
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 21
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L36
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L36:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0558Bw.A03
            java.lang.String r1 = "qNstZA7UFnX3Ahz0Wj5J3oCW9XwBWpVm"
            r0 = 2
            r2[r0] = r1
            java.lang.String r0 = r4.A00
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L77
            java.lang.String r0 = r4.A02
            boolean r0 = r8.A02(r0)
            if (r0 == 0) goto L77
            return r6
        L4e:
            boolean r0 = r4 instanceof com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.InternalFrame
            if (r0 == 0) goto L77
            com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.InternalFrame r4 = (com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.InternalFrame) r4
            r2 = 50
            r1 = 16
            r0 = 15
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.String r0 = r4.A01
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L77
            java.lang.String r0 = r4.A00
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L77
            java.lang.String r0 = r4.A02
            boolean r0 = r8.A02(r0)
            if (r0 == 0) goto L77
            return r6
        L77:
            int r3 = r3 + 1
            goto L1
        L7a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0558Bw.A05(com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata):boolean");
    }
}
