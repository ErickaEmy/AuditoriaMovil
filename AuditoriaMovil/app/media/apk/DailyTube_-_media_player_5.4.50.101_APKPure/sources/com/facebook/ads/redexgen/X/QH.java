package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum QH {
    A06(101),
    A09(102),
    A0A(103),
    A07(104),
    A08(105),
    A05(R.styleable.AppCompatTheme_textAppearancePopupMenuHeader),
    A04(107),
    A03(108);
    
    public static byte[] A01;
    public final int A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{9, 30, 1, 18, 5, 20, 15, 31, 4, 9, 18, 2, 3, 18, 9, 8, 30, 25, 31, 2, 20, 8, 31, 0, 19, 4, 21, 14, 30, 5, 8, 19, 31, 7, 5, 28, 38, 53, 44, 44, 51, 35, 50, 37, 37, 46, 63, 54, 41, 36, 37, 47, 63, 54, 41, 37, 55, 63, 47, 46, 63, 36, 37, 51, 52, 50, 47, 57, 89, 94, 68, 85, 66, 67, 68, 89, 68, 89, 81, 92, 79, 70, 89, 84, 85, 95, 79, 70, 89, 85, 71, 79, 84, 85, 67, 68, 66, 95, 73, 23, 28, 14, 6, 15, 16, 29, 28, 22, 6, 16, 23, 13, 28, 11, 10, 13, 16, 13, 16, 24, 21, 6, 23, 30, 13, 6, 27, 12, 13, 13, 22, 23, 80, 91, 73, 65, 72, 87, 90, 91, 81, 65, 87, 80, 74, 91, 76, 77, 74, 87, 74, 87, 95, 82, 65, 74, 81, 81, 82, 92, 95, 76, 65, 93, 82, 81, 77, 91, 65, 93, 82, 87, 93, 85, 91, 90, 86, 65, 83, 69, 86, 64, 65, 64, 91, 82, 77, 64, 65, 75, 91, 80, 75, 75, 72, 70, 69, 86, 91, 71, 72, 75, 87, 65, 91, 71, 72, 77, 71, 79, 65, 64, 40, 48, 50, 43, 36, 43, 55, 46, 60, 50, 53};
    }

    static {
        A01();
    }

    QH(int i) {
        this.A00 = i;
    }

    public final int A02() {
        return this.A00;
    }
}
