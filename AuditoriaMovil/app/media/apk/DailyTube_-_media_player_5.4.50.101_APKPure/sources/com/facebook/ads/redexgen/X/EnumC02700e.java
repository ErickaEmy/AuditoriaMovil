package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.0e  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC02700e {
    A0C(A00(169, 5, 108)),
    A0A(A00(156, 5, 19)),
    A03(A00(87, 8, 102)),
    A0B(A00(161, 8, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle)),
    A07(A00(NotificationCompat.FLAG_HIGH_PRIORITY, 10, 80)),
    A09(A00(147, 9, 122)),
    A08(A00(138, 9, 102)),
    A04(A00(95, 7, 74)),
    A05(A00(102, 13, 13)),
    A06(A00(R.styleable.AppCompatTheme_tooltipFrameBackground, 13, 27));
    
    public static byte[] A01;
    public final String A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 50);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{19, 17, 2, 31, 5, 3, 21, 28, 16, 27, 18, 26, 29, 22, 23, 115, 120, 113, 121, 126, 117, 116, 111, 121, 125, 113, 119, 117, 17, 26, 19, 27, 28, 23, 22, 13, 4, 27, 22, 23, 29, 104, Byte.MAX_VALUE, 96, 115, 100, 117, 110, 126, 101, 104, 90, 77, 82, 65, 87, 83, 95, 89, 91, 78, 89, 70, 85, 92, 67, 78, 79, 69, 109, 105, 101, 99, 97, 9, 21, 24, 0, 24, 27, 21, 28, 92, 67, 78, 79, 69, 55, 53, 38, 59, 33, 39, 49, 56, 27, 16, 25, 17, 22, 29, 28, 92, 87, 94, 86, 81, 90, 91, 96, 86, 82, 94, 88, 90, 74, 65, 72, 64, 71, 76, 77, 118, 95, 64, 77, 76, 70, 6, 17, 14, 61, 10, 27, 0, 16, 11, 6, 48, 39, 56, 11, 61, 57, 53, 51, 49, 44, 59, 36, 23, 62, 33, 44, 45, 39, 72, 76, 64, 70, 68, 50, 46, 35, 59, 35, 32, 46, 39, 40, 55, 58, 59, 49};
    }

    static {
        A01();
    }

    EnumC02700e(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
