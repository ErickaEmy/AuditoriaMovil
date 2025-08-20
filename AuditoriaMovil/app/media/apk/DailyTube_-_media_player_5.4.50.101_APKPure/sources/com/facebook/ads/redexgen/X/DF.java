package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.uv.v7.R;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class DF {
    public static byte[] A00;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1062Wl A00(InterfaceC0555Bt interfaceC0555Bt) throws IOException, InterruptedException {
        AbstractC0672Ha.A01(interfaceC0555Bt);
        C0697Hz c0697Hz = new C0697Hz(16);
        if (DE.A00(interfaceC0555Bt, c0697Hz).A00 != IF.A08(A01(R.styleable.AppCompatTheme_textColorSearchUrl, 4, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle))) {
            return null;
        }
        int i = 0;
        interfaceC0555Bt.ADv(c0697Hz.A00, 0, 4);
        c0697Hz.A0Y(0);
        int A08 = c0697Hz.A08();
        int A082 = IF.A08(A01(195, 4, 13));
        String A01 = A01(199, 15, 13);
        if (A08 != A082) {
            Log.e(A01, A01(R.styleable.AppCompatTheme_tooltipFrameBackground, 25, 27) + A08);
            return null;
        }
        DE A002 = DE.A00(interfaceC0555Bt, c0697Hz);
        while (A002.A00 != IF.A08(A01(218, 4, 32))) {
            interfaceC0555Bt.A3W((int) A002.A01);
            A002 = DE.A00(interfaceC0555Bt, c0697Hz);
        }
        AbstractC0672Ha.A04(A002.A01 >= 16);
        interfaceC0555Bt.ADv(c0697Hz.A00, 0, 16);
        c0697Hz.A0Y(0);
        int A0C = c0697Hz.A0C();
        int A0C2 = c0697Hz.A0C();
        int A0B = c0697Hz.A0B();
        int A0B2 = c0697Hz.A0B();
        int A0C3 = c0697Hz.A0C();
        int A0C4 = c0697Hz.A0C();
        int i5 = (A0C2 * A0C4) / 8;
        if (A0C3 == i5) {
            switch (A0C) {
                case 1:
                case 65534:
                    i = IF.A02(A0C4);
                    break;
                case 3:
                    if (A0C4 == 32) {
                        i = 4;
                        break;
                    }
                    break;
                default:
                    Log.e(A01, A01(166, 29, 30) + A0C);
                    return null;
            }
            if (i == 0) {
                Log.e(A01, A01(140, 26, 101) + A0C4 + A01(0, 10, 35) + A0C);
                return null;
            }
            interfaceC0555Bt.A3W(((int) A002.A01) - 16);
            return new C1062Wl(A0C2, A0B, A0B2, A0C3, A0C4, i);
        }
        throw new C05059v(A01(57, 26, 48) + i5 + A01(10, 7, 62) + A0C3);
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 36);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{39, 97, 104, 117, 39, 115, 126, 119, 98, 39, 33, 58, 125, 117, 110, 32, 58, 123, 80, 77, 86, 83, 24, 81, 75, 24, 76, 87, 87, 24, 84, 89, 74, 95, 93, 24, 16, 70, 10, Byte.MAX_VALUE, 122, 19, 17, 24, 76, 87, 24, 75, 83, 81, 72, 3, 24, 81, 92, 2, 24, 81, 108, 100, 113, 119, 96, 113, 112, 52, 118, 120, 123, 119, Byte.MAX_VALUE, 52, 117, 120, 125, 115, 122, 121, 113, 122, 96, 46, 52, 103, 73, 64, 65, 92, 71, 64, 73, 14, 91, 64, 69, 64, 65, 89, 64, 14, 121, 111, 120, 14, 77, 70, 91, 64, 69, 20, 14, 6, 29, 18, 18, 106, 81, 76, 74, 79, 79, 80, 77, 75, 90, 91, 31, 109, 118, 121, 121, 31, 89, 80, 77, 82, 94, 75, 5, 31, 20, 47, 50, 52, 49, 49, 46, 51, 53, 36, 37, 97, 22, 0, 23, 97, 35, 40, 53, 97, 37, 36, 49, 53, 41, 97, 111, 84, 73, 79, 74, 74, 85, 72, 78, 95, 94, 26, 109, 123, 108, 26, 92, 85, 72, 87, 91, 78, 26, 78, 67, 74, 95, 0, 26, 126, 104, Byte.MAX_VALUE, 108, 126, 72, 95, 97, 76, 72, 77, 76, 91, 123, 76, 72, 77, 76, 91, 10, 15, 26, 15, 98, 105, 112, 36};
    }

    public static void A03(InterfaceC0555Bt interfaceC0555Bt, C1062Wl c1062Wl) throws IOException, InterruptedException {
        AbstractC0672Ha.A01(interfaceC0555Bt);
        AbstractC0672Ha.A01(c1062Wl);
        interfaceC0555Bt.AFM();
        C0697Hz c0697Hz = new C0697Hz(8);
        DE A002 = DE.A00(interfaceC0555Bt, c0697Hz);
        while (A002.A00 != IF.A08(A01(214, 4, 74))) {
            Log.w(A01(199, 15, 13), A01(83, 28, 10) + A002.A00);
            long j2 = A002.A01 + 8;
            if (A002.A00 == IF.A08(A01(R.styleable.AppCompatTheme_textColorSearchUrl, 4, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle))) {
                j2 = 12;
            }
            if (j2 <= 2147483647L) {
                interfaceC0555Bt.AGP((int) j2);
                A002 = DE.A00(interfaceC0555Bt, c0697Hz);
            } else {
                throw new C05059v(A01(17, 40, 28) + A002.A00);
            }
        }
        interfaceC0555Bt.AGP(8);
        c1062Wl.A06(interfaceC0555Bt.A7i(), A002.A01);
    }
}
