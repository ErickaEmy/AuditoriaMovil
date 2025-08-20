package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class I2 extends IOException {
    public static byte[] A00;
    public static String[] A01 = {"9oUH6IggskzJ9KRnNq9fhlyXZqfLC7qm", "O", "6vBLsFlXvIsZh7TCn1R3IT4lCv45HTaK", "MDpcepjwzWMs517m4Ih6aUQSJk", "3hrQycwauA7dGDeH7qJo", "b1qkSdZDeqb", "rPde78X67wgfjzgLBIP3X6whAm", "c"};

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[4].length() != 20) {
                throw new RuntimeException();
            }
            A01[5] = "xrQk8FQC87O";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 60);
            i8++;
        }
    }

    public static void A01() {
        A00 = new byte[]{102, 106, 34, 35, 45, 34, 47, 57, 62, 119, 51, 17, 10, 12, 17, 10, 23, 26, 67, 23, 12, 12, 67, 15, 12, 20, 67, 56, 19, 17, 10, 12, 17, 10, 23, 26, 94, 62};
    }

    static {
        A01();
    }

    public I2(int i, int i5) {
        super(A00(10, 27, 95) + i + A00(0, 10, 118) + i5 + A00(37, 1, 95));
    }
}
