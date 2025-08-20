package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class U9 implements InterfaceC0804Mj {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ R.styleable.AppCompatTheme_tooltipFrameBackground);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{50, 62, 60, Byte.MAX_VALUE, 55, 48, 50, 52, 51, 62, 62, 58, Byte.MAX_VALUE, 48, 53, 34, Byte.MAX_VALUE, 56, 63, 37, 52, 35, 34, 37, 56, 37, 56, 48, 61, Byte.MAX_VALUE, 50, 61, 56, 50, 58, 52, 53, 103, 107, 105, 42, 98, 101, 103, 97, 102, 107, 107, 111, 42, 101, 96, 119, 42, 109, 106, 112, 97, 118, 119, 112, 109, 112, 109, 101, 104, 42, 97, 118, 118, 107, 118, 54, 58, 56, 123, 51, 52, 54, 48, 55, 58, 58, 62, 123, 52, 49, 38, 123, 60, 59, 33, 48, 39, 38, 33, 60, 33, 60, 52, 57, 123, 51, 60, 59, 60, 38, 61, 10, 52, 54, 33, 60, 35, 60, 33, 44, 66, 78, 76, 15, 71, 64, 66, 68, 67, 78, 78, 74, 15, 64, 69, 82, 15, 72, 79, 85, 68, 83, 82, 85, 72, 85, 72, 64, 77, 15, 72, 76, 81, 83, 68, 82, 82, 72, 78, 79, 15, 77, 78, 70, 70, 68, 69, 29, 17, 19, 80, 24, 31, 29, 27, 28, 17, 17, 21, 80, 31, 26, 13, 80, 23, 16, 10, 27, 12, 13, 10, 23, 10, 23, 31, 18, 80, 12, 27, 9, 31, 12, 26, 32, 44, 46, 109, 37, 34, 32, 38, 33, 44, 44, 40, 109, 34, 39, 48, 109, 42, 45, 55, 38, 49, 48, 55, 42, 55, 42, 34, 47, 109, 49, 38, 52, 34, 49, 39, 28, 48, 38, 49, 53, 38, 49, 28, 37, 34, 42, 47, 54, 49, 38, 10, 6, 4, 71, 15, 8, 10, 12, 11, 6, 6, 2, 71, 8, 13, 26, 71, 0, 7, 29, 12, 27, 26, 29, 0, 29, 0, 8, 5, 71, 27, 12, 30, 8, 27, 13, 54, 26, 12, 27, 31, 12, 27, 54, 26, 28, 10, 10, 12, 26, 26};
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0804Mj
    public final String A5s() {
        return A00(164, 36, 13);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0804Mj
    public final String A6R() {
        return A00(0, 37, 34);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0804Mj
    public final String A6u() {
        return A00(72, 45, 38);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0804Mj
    public final String A6y() {
        return A00(37, 35, 119);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0804Mj
    public final String A7B() {
        return A00(117, 47, 82);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0804Mj
    public final String A7f() {
        return AdPlacementType.INTERSTITIAL.toString();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0804Mj
    public final String A7w() {
        return A00(200, 51, 48);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0804Mj
    public final String A7x() {
        return A00(251, 51, 26);
    }
}
