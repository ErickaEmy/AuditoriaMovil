package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum QO {
    A04(A00(147, 33, 28)),
    A05(A00(180, 36, 56)),
    A06(A00(216, 29, 15)),
    A03(A00(78, 32, 93)),
    A07(A00(R.styleable.AppCompatTheme_textColorAlertDialogListItem, 37, 32));
    
    public static byte[] A01;
    public String A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 71);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{79, 64, 85, 72, 87, 68, 94, 64, 69, 94, 66, 77, 72, 66, 74, 45, 34, 55, 42, 53, 38, 60, 32, 44, 46, 51, 47, 38, 55, 38, 113, 126, 107, 118, 105, 122, 96, 122, 113, 123, 96, 126, 124, 107, 118, 105, 118, 107, 102, 60, 51, 38, 59, 36, 55, 45, 55, 32, 32, 61, 32, 121, 118, 99, 126, 97, 114, 104, 126, 122, 103, 101, 114, 100, 100, 126, 120, 121, 121, 117, 119, 52, 124, 123, 121, Byte.MAX_VALUE, 120, 117, 117, 113, 52, 123, 126, 105, 52, 116, 123, 110, 115, 108, Byte.MAX_VALUE, 52, 123, 126, 69, 121, 118, 115, 121, 113, 4, 8, 10, 73, 1, 6, 4, 2, 5, 8, 8, 12, 73, 6, 3, 20, 73, 9, 6, 19, 14, 17, 2, 73, 6, 3, 56, 14, 10, 23, 21, 2, 20, 20, 14, 8, 9, 56, 52, 54, 117, 61, 58, 56, 62, 57, 52, 52, 48, 117, 58, 63, 40, 117, 53, 58, 47, 50, 45, 62, 117, 56, 52, 54, 43, 55, 62, 47, 62, 63, 28, 16, 18, 81, 25, 30, 28, 26, 29, 16, 16, 20, 81, 30, 27, 12, 81, 17, 30, 11, 22, 9, 26, 81, 26, 17, 27, 32, 30, 28, 11, 22, 9, 22, 11, 6, 43, 39, 37, 102, 46, 41, 43, 45, 42, 39, 39, 35, 102, 41, 44, 59, 102, 38, 41, 60, 33, 62, 45, 102, 45, 58, 58, 39, 58};
    }

    static {
        A01();
    }

    QO(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
