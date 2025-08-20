package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Al  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0521Al extends Exception {
    public static byte[] A01;
    public static String[] A02 = {"LLL1AZ8LOai", "2B7qWnr6lboK1kzNzncdoP0B0brMv5Si", "Q6PB2WDRc4LRgt1IrB9ncLf4ycwP07EY", "7CWVV5CGm74gAvba93StX50LTK78ikzM", "ynv3Ef9TkO7iFkFcQiaLVAQ", "TH7Ylqo7zGIsqo5phZR", "ycuhnMWtVGGkzzPjnxpnYEgK0npEXwg2", "tZyIzHWr5GKf5F95sWHTJWAqY8lomPh4"};
    public final int A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[0].length() == 27) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "6WQS05Wn9adH8q8wYpq1YrK9XoQHj10A";
            strArr[3] = "Vk4pv7cTpcIIvcYbjBZcz8uea28NHwOt";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 95);
            i8++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-91, -49, -61, -100, -112, -77, -33, -34, -42, -39, -41, -104, -50, 2, -15, -10, -4, -31, -1, -18, -16, -8, -83, -10, -5, -10, 1, -83, -13, -18, -10, -7, -14, -15, -57, -83};
    }

    static {
        A01();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0521Al(int r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 12
            r1 = 24
            r0 = 46
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r5)
            r2 = 3
            r1 = 9
            r0 = 17
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r6)
            r2 = 1
            r1 = 2
            r0 = 68
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r3 = r0.append(r8)
            r2 = 0
            r1 = 1
            r0 = 29
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            r4.A00 = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0521Al.<init>(int, int, int, int):void");
    }
}
