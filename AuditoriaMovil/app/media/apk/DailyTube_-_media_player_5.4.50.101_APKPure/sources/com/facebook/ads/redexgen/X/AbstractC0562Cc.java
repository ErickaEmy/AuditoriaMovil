package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Cc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0562Cc {
    public static byte[] A00;
    public static String[] A01 = {"bdaFL9zMZ", "I63pCoSBBbO7fDlHhIa7BrZ6Ava1cIF3", "x5nJfB3W8HSDeHix", "yyLZDQNtNFC811gZWNvs8tiPSoT", "kE4kWLsRx96QKHczqOKboI9lp", "rJUZcTDeN", "z735Hr0viTdtcy9jRTmcNapxWooAX9zU", "rl5X7GmnpjWHRCYLou0FtooQfFV"};
    public static final int[] A02;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[0].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[3] = "MWn";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 122);
            if (A01[7].length() == 12) {
                throw new RuntimeException();
            }
            A01[7] = "KMAr4";
            i8++;
        }
    }

    public static void A01() {
        A00 = new byte[]{-44, 8, -45, 2, 25, 77, 24, 72, -8, 44, 42, -5, 22, 74, 74, 25, -49, 3, 12, -20, 32, 43, -17, 14, 66, 78, 17, -42, -67, -54, -87, 63, 38, 72, 18, 63, 38, 72, 66, -41, -35, -40, -32, 4, 25, 6, -44, 19, -31, 35, -51, 27, 24, 41, -28, 12, 26, 7, -43, 23, 33, 29, -32, 55, 65, 61, 1, 62, 72, 68, 9, -9, 1, -3, -61, 9, 19, 15, -42, 40, 50, 46, 44, 14, 7, 7, 12, 24, 27, -33, -36, 97, 100, 40, 38, -10, -7, -91, -91};
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d1, code lost:
        if (r3 == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00df, code lost:
        if (com.facebook.ads.redexgen.X.AbstractC0562Cc.A01[7].length() == 12) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e1, code lost:
        com.facebook.ads.redexgen.X.AbstractC0562Cc.A01[7] = "X5YHVW4uSpKOduvkf9RISQBbBxib";
        r9.A0Z(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ee, code lost:
        if (r3 == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f9, code lost:
        if (A02(r9.A08()) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fb, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fc, code lost:
        if (r14 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fe, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0131, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0139, code lost:
        if (r14 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013d, code lost:
        if (r17 != r11) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x013f, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:?, code lost:
        return r0;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A05(com.facebook.ads.redexgen.X.InterfaceC0555Bt r16, boolean r17) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0562Cc.A05(com.facebook.ads.redexgen.X.Bt, boolean):boolean");
    }

    static {
        A01();
        A02 = new int[]{IF.A08(A00(79, 4, 69)), IF.A08(A00(59, 4, 52)), IF.A08(A00(63, 4, 84)), IF.A08(A00(67, 4, 91)), IF.A08(A00(71, 4, 20)), IF.A08(A00(75, 4, 38)), IF.A08(A00(43, 4, 41)), IF.A08(A00(55, 4, 42)), IF.A08(A00(51, 4, 57)), IF.A08(A00(87, 4, 49)), IF.A08(A00(91, 4, 122)), IF.A08(A00(0, 4, 39)), IF.A08(A00(4, 4, 108)), IF.A08(A00(19, 4, 63)), IF.A08(A00(23, 4, 97)), IF.A08(A00(8, 4, 75)), IF.A08(A00(12, 4, 105)), IF.A08(A00(31, 4, 120)), IF.A08(A00(27, 4, 15)), IF.A08(A00(47, 4, 51)), IF.A08(A00(83, 4, 41)), IF.A08(A00(35, 4, 120)), IF.A08(A00(95, 4, 11)), IF.A08(A00(39, 4, 16))};
    }

    public static boolean A02(int i) {
        if ((i >>> 8) == IF.A08(A00(16, 3, 34))) {
            return true;
        }
        for (int i5 : A02) {
            if (i5 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean A03(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        return A05(interfaceC0555Bt, true);
    }

    public static boolean A04(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        return A05(interfaceC0555Bt, false);
    }
}
