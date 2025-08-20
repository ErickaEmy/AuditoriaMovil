package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class CK {
    public static byte[] A09;
    public static String[] A0A = {"WDcyaL9oeoAbLzImXLrrdZNjVRrzcxRy", "ME9PFK50DMSVlKN2bxn", "gAphC5qX8pzOC3bbBnmZFpQJv5fhqgvp", "JPEMy1g84hpaqLtC7n4l8lpeHeJzlyM", "bln1Uon0G", "FjG6mf5q9yXvdNgXZQEHKWlpLPgsZNOr", "dYpTLYsEmL6RycpaLs1UjMTFbai8", "KiONmpfliC6BX3IrEZz"};
    public int A00;
    public int A01;
    public long A02;
    public int A03;
    public int A04;
    public final int A05;
    public final C0697Hz A06;
    public final C0697Hz A07;
    public final boolean A08;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 43);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {109, 98, 121, 120, Byte.MAX_VALUE, 84, 104, 99, 126, 101, 96, 43, 102, 126, 120, Byte.MAX_VALUE, 43, 105, 110, 43, 58};
        String[] strArr = A0A;
        if (strArr[1].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[3] = "zNoXMjNr5peo3NkCnCQ1IuM2DM0yQ7k";
        strArr2[6] = "1lOT5Wh9g7SFemsLLNpHXLUAtLi5";
        A09 = bArr;
    }

    static {
        A01();
    }

    public CK(C0697Hz c0697Hz, C0697Hz c0697Hz2, boolean z2) {
        this.A07 = c0697Hz;
        this.A06 = c0697Hz2;
        this.A08 = z2;
        c0697Hz2.A0Y(12);
        this.A05 = c0697Hz2.A0H();
        c0697Hz.A0Y(12);
        this.A04 = c0697Hz.A0H();
        AbstractC0672Ha.A06(c0697Hz.A08() == 1, A00(0, 21, 32));
        this.A00 = -1;
    }

    public final boolean A02() {
        long A0M;
        int i;
        int i5 = this.A00 + 1;
        this.A00 = i5;
        if (i5 == this.A05) {
            return false;
        }
        if (this.A08) {
            A0M = this.A06.A0N();
        } else {
            A0M = this.A06.A0M();
        }
        this.A02 = A0M;
        if (this.A00 == this.A03) {
            this.A01 = this.A07.A0H();
            this.A07.A0Z(4);
            int i6 = this.A04 - 1;
            this.A04 = i6;
            if (i6 > 0) {
                int A0H = this.A07.A0H();
                if (A0A[5].charAt(17) != 'Q') {
                    throw new RuntimeException();
                }
                A0A[4] = "w3cW";
                i = A0H - 1;
            } else {
                i = -1;
            }
            this.A03 = i;
        }
        return true;
    }
}
