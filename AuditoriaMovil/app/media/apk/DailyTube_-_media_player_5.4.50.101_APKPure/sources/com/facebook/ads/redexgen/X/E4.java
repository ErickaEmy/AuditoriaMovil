package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class E4 implements XV {
    public static byte[] A05;
    public static String[] A06 = {"ilqNaxLa84KwPxLclQkuXaDAjXKjVBay", "YYRGnxFlW9XodSzMr5d0AgWnEUGN8SAb", "TFjL0s25LaCBEteV0vZTEC31LOIwZtzx", "GUmZTVO9tTTKl3Mpcsedxo5lbewk1Lj3", "rxyeYW6RMQKKTnfalukPqNZ2KBfsB6S5", "mDRU4t7MoPNm7z5QI5KjgmazMAxk28NE", "eki8tF0EBXj6l5GM9f5RfEnwS82fHKRK", "1REkWmsZMDj0bgzORsQu3VEtsLn99tZ6"};
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long[] A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static E4 A01(long j2, long j4, By by, C0697Hz c0697Hz) {
        int A0H;
        int i = by.A04;
        int i5 = by.A03;
        int A08 = c0697Hz.A08();
        if ((A08 & 1) != 1 || (A0H = c0697Hz.A0H()) == 0) {
            return null;
        }
        long A0F = IF.A0F(A0H, i * 1000000, i5);
        if ((A08 & 6) != 6) {
            return new E4(j4, by.A02, A0F);
        }
        long A0H2 = c0697Hz.A0H();
        long[] jArr = new long[100];
        for (int i6 = 0; i6 < 100; i6++) {
            jArr[i6] = c0697Hz.A0E();
        }
        if (j2 != -1 && j2 != j4 + A0H2) {
            Log.w(A02(27, 10, 25), A02(2, 25, 119) + j2 + A02(0, 2, 77) + (j4 + A0H2));
        }
        return new E4(j4, by.A02, A0F, A0H2, jArr);
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-24, -36, 62, 47, 52, 45, 6, 74, 71, 90, 71, 6, 89, 79, 96, 75, 6, 83, 79, 89, 83, 71, 90, 73, 78, 32, 6, -32, -15, -10, -17, -37, -19, -19, -13, -19, -6};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.XV
    public final long A88(long j2) {
        long j4 = j2 - this.A02;
        if (A9I()) {
            int i = this.A00;
            String[] strArr = A06;
            if (strArr[5].charAt(8) != strArr[2].charAt(8)) {
                String[] strArr2 = A06;
                strArr2[5] = "W8nk4dNFk5UYs2ixe7nvUw2jVo0XpVlf";
                strArr2[2] = "94Ku6bJ3HPlMD7WZMvisRyq3A9jYmrd2";
                if (j4 <= i) {
                    return 0L;
                }
                double d2 = (j4 * 256.0d) / this.A01;
                int A0B = IF.A0B(this.A04, (long) d2, true, true);
                long A00 = A00(A0B);
                long j6 = this.A04[A0B];
                long A002 = A00(A0B + 1);
                long j7 = A0B == 99 ? 256L : this.A04[A0B + 1];
                return Math.round((A002 - A00) * (j6 == j7 ? 0.0d : (d2 - j6) / (j7 - j6))) + A00;
            }
            throw new RuntimeException();
        }
        return 0L;
    }

    static {
        A03();
    }

    public E4(long j2, int i, long j4) {
        this(j2, i, j4, -1L, null);
    }

    public E4(long j2, int i, long j4, long j6, long[] jArr) {
        this.A02 = j2;
        this.A00 = i;
        this.A03 = j4;
        this.A01 = j6;
        this.A04 = jArr;
    }

    private long A00(int i) {
        return (this.A03 * i) / 100;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final long A6r() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final C0 A7t(long j2) {
        long[] jArr;
        double scaledPosition;
        if (!A9I()) {
            return new C0(new C2(0L, this.A02 + this.A00));
        }
        long A0E = IF.A0E(j2, 0L, this.A03);
        double d2 = (A0E * 100.0d) / this.A03;
        if (d2 <= 0.0d) {
            scaledPosition = 0.0d;
        } else if (d2 >= 100.0d) {
            scaledPosition = 256.0d;
        } else {
            int i = (int) d2;
            double prevScaledPosition = this.A04[i];
            double d3 = i == 99 ? 256.0d : jArr[i + 1];
            double d4 = i;
            String[] strArr = A06;
            if (strArr[1].charAt(15) != strArr[6].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[5] = "OMtgh7AGIO6dejZGwnLWpymQ4IFINQQk";
            strArr2[2] = "IsjlGA9bpSadN6h09kE1zH4HNrdroVjr";
            scaledPosition = ((d3 - prevScaledPosition) * (d2 - d4)) + prevScaledPosition;
        }
        long round = Math.round((scaledPosition / 256.0d) * this.A01);
        long positionOffset = this.A00;
        return new C0(new C2(A0E, this.A02 + IF.A0E(round, positionOffset, this.A01 - 1)));
    }

    @Override // com.facebook.ads.redexgen.X.C1
    public final boolean A9I() {
        return this.A04 != null;
    }
}
