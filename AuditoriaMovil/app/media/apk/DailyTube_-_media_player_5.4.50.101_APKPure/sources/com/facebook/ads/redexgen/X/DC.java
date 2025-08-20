package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class DC {
    public static byte[] A05;
    public int A00;
    public String A01;
    public final int A02;
    public final int A03;
    public final String A04;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 60);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{12, 24, 26, 17, 26, 13, 30, 11, 26, 49, 26, 8, 54, 27, 87, 86, 95, 18, 10, 12, 11, 95, 29, 26, 95, 28, 30, 19, 19, 26, 27, 95, 29, 26, 25, 16, 13, 26, 95, 13, 26, 11, 13, 22, 26, 9, 22, 17, 24, 95, 22, 27, 12, 81};
    }

    public DC(int i, int i5) {
        this(Integer.MIN_VALUE, i, i5);
    }

    public DC(int i, int i5, int i6) {
        this.A04 = i != Integer.MIN_VALUE ? i + A00(0, 1, 31) : A00(0, 0, 77);
        this.A02 = i5;
        this.A03 = i6;
        this.A00 = Integer.MIN_VALUE;
    }

    private void A01() {
        if (this.A00 != Integer.MIN_VALUE) {
            return;
        }
        throw new IllegalStateException(A00(1, 53, 67));
    }

    public final int A03() {
        A01();
        return this.A00;
    }

    public final String A04() {
        A01();
        return this.A01;
    }

    public final void A05() {
        int i = this.A00;
        this.A00 = i == Integer.MIN_VALUE ? this.A02 : i + this.A03;
        this.A01 = this.A04 + this.A00;
    }
}
