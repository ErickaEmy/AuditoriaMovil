package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Fy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0646Fy {
    public static byte[] A00;
    public static String[] A01 = {"UAa0Z", "y84zlLC7EVblAi9s6IjzDwtWlv", "hWSmc3nAoC6lO20JdXQ8UQAJh4", "HAxIJdFwG2BHjJ6kBVBijNmfixc4v4eM", "sMFPtSIIwmEBUNkX5nfAspCddytOxG7k", "XuEZcwrwjFPAmN9wFCdffjeuCf3K5K0k", "0bJFkLVdjL4ExnLkyIfxNw93FYOhEgu9", "GtmYUKm65Uny9K5bn1TkELKUpeSnjSJ3"};
    public static final int A02;
    public static final int A03;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 55);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{56, 30, 26, 46, 15, 18, 23, 37, 53, 38, 80, 40, 46, 86, 91, 108, 84, 86, 79, 79, 86, 81, 88, 31, 77, 90, 82, 94, 86, 81, 91, 90, 77, 31, 80, 89, 31, 82, 94, 83, 89, 80, 77, 82, 90, 91, 31, 108, 122, 118, 31, 113, 126, 115, 31, 74, 81, 86, 75, 17};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A03(long j2, C0697Hz c0697Hz, C4[] c4Arr) {
        while (c0697Hz.A04() > 1) {
            int A002 = A00(c0697Hz);
            int A003 = A00(c0697Hz);
            int A06 = c0697Hz.A06();
            if (A01[3].charAt(16) != 'B') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "sJRWMhzWyXWsYNwcYdMxu9waYeZJW4nD";
            strArr[5] = "JDck5DNLGL8VXNpOftdo1S17ghv9bSuy";
            int i = A06 + A003;
            if (A003 == -1 || A003 > c0697Hz.A04()) {
                Log.w(A01(0, 7, 76), A01(15, 45, 8));
                i = c0697Hz.A07();
            } else if (A002 == 4 && A003 >= 8) {
                int A0E = c0697Hz.A0E();
                int A0I = c0697Hz.A0I();
                int A08 = A0I == 49 ? c0697Hz.A08() : 0;
                int A0E2 = c0697Hz.A0E();
                if (A0I == 47) {
                    c0697Hz.A0Z(1);
                }
                boolean z2 = A0E == 181 && (A0I == 49 || A0I == 47) && A0E2 == 3;
                if (A0I == 49) {
                    z2 &= A08 == A03 || A08 == A02;
                }
                if (z2) {
                    c0697Hz.A0Z(1);
                    int A0E3 = (c0697Hz.A0E() & 31) * 3;
                    int A062 = c0697Hz.A06();
                    for (C4 c4 : c4Arr) {
                        c0697Hz.A0Y(A062);
                        c4.AFR(c0697Hz, A0E3);
                        c4.AFS(j2, 1, A0E3, 0, null);
                    }
                }
            }
            c0697Hz.A0Y(i);
        }
    }

    static {
        A02();
        A03 = IF.A08(A01(11, 4, 88));
        A02 = IF.A08(A01(7, 4, 86));
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A00(com.facebook.ads.redexgen.X.C0697Hz r3) {
        /*
            r2 = 0
        L1:
            int r0 = r3.A04()
            if (r0 != 0) goto L1a
            r3 = -1
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AbstractC0646Fy.A01
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 5
            if (r1 == r0) goto L24
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1a:
            int r1 = r3.A0E()
            int r2 = r2 + r1
            r0 = 255(0xff, float:3.57E-43)
            if (r1 == r0) goto L1
            return r2
        L24:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AbstractC0646Fy.A01
            java.lang.String r1 = "XY7JbweA6fzPXsut6MPl2wkiFN"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "9Cope1RtGoIRUkWui2tRq11YR8"
            r0 = 1
            r2[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0646Fy.A00(com.facebook.ads.redexgen.X.Hz):int");
    }
}
