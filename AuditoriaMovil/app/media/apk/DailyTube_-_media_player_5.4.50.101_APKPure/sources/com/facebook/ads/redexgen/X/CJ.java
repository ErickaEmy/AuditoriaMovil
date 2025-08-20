package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class CJ {
    public static byte[] A01;
    public static String[] A02 = {"2XyxPCiilzljguSsu4pGvmSFqHuWkoJe", "g", "wMW4OPeJECh2ZkwoYiApXMXnqUEtQuPd", "GR", "EhJM0Q80CeiIJrlXNLqbcFQzRLxkFlf7", "fAR2mqBd5uVx168qVX1Rgp4rBcKV4sud", "wZX2QCQ2RNkLqVcCCrLrgFB2S", "I3UDOxEYE9hNMyKmBrAakA4JcdpMHPAe"};
    public static final int A03;
    public static final int A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public static final int A0L;
    public static final int A0M;
    public static final int A0N;
    public static final int A0O;
    public static final int A0P;
    public static final int A0Q;
    public static final int A0R;
    public static final int A0S;
    public static final int A0T;
    public static final int A0U;
    public static final int A0V;
    public static final int A0W;
    public static final int A0X;
    public static final int A0Y;
    public static final int A0Z;
    public static final int A0a;
    public static final int A0b;
    public static final int A0c;
    public static final int A0d;
    public static final int A0e;
    public static final int A0f;
    public static final int A0g;
    public static final int A0h;
    public static final int A0i;
    public static final int A0j;
    public static final int A0k;
    public static final int A0l;
    public static final int A0m;
    public static final int A0n;
    public static final int A0o;
    public static final int A0p;
    public static final int A0q;
    public static final int A0r;
    public static final int A0s;
    public static final int A0t;
    public static final int A0u;
    public static final int A0v;
    public static final int A0w;
    public static final int A0x;
    public static final int A0y;
    public static final int A0z;
    public static final int A10;
    public static final int A11;
    public static final int A12;
    public static final int A13;
    public static final int A14;
    public static final int A15;
    public static final int A16;
    public static final int A17;
    public static final int A18;
    public static final int A19;
    public static final int A1A;
    public static final int A1B;
    public static final int A1C;
    public static final int A1D;
    public static final int A1E;
    public static final int A1F;
    public static final int A1G;
    public static final int A1H;
    public static final int A1I;
    public static final int A1J;
    public static final int A1K;
    public static final int A1L;
    public static final int A1M;
    public static final int A1N;
    public static final int A1O;
    public static final int A1P;
    public static final int A1Q;
    public static final int A1R;
    public static final int A1S;
    public static final int A1T;
    public static final int A1U;
    public static final int A1V;
    public static final int A1W;
    public static final int A1X;
    public final int A00;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 48);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        byte[] bArr = {74, 9, 20, 87, 15, 15, 22, 23, 32, 34, 108, 114, 0, 13, 0, 2, 115, 100, 113, 35, 76, 91, 78, 30, 54, 33, 52, 20, 101, 48, 54, 62, 49, 51, 63, 63, 88, 84, 13, 15, 65, 86, 86, 81, 14, 88, 92, 89, 63, 58, 56, 104, 46, 43, 62, 43, 59, 59, 43, 44, 41, 40, 46, 126, 23, 7, 0, 16, 47, 63, 56, 46, 67, 83, 84, 79, 80, 64, 71, 88, 115, 117, 59, 37, 82, 83, 67, 68, 106, 99, 124, 123, 73, 65, 95, 75, 102, 109, 96, 98, 47, 36, 41, 60, 75, 93, 74, 93, 17, 5, 26, 22, 62, 44, 33, 40, 76, 64, 72, 86, 1, 12, 31, 88, 104, 118, 99, 49, 118, 104, 125, 93, 37, 32, 63, 56, 118, 106, 121, 119, 57, 48, 53, 32, 74, 67, 79, 67, 51, 58, 55, 63, 75, 67, 71, 72, 22, 30, 19, 31, 61, 53, 36, 49, 72, 76, 75, 67, 84, 86, 86, 95, 122, 120, 120, 97, 18, 15, 75, 30, 13, 16, 84, 22, 54, 45, 62, 35, 114, 105, 119, 123, 125, 114, 126, 118, 117, 100, 118, 117, 85, 87, 74, 79, 18, 17, 17, 10, 58, 123, Byte.MAX_VALUE, 122, 109, Byte.MAX_VALUE, 119, 113, 0, 18, 26, 9, 75, 89, 85, 74, 113, 99, 117, 96, 118, 103, 98, 117, 16, 0, 11, 10, 100, 116, Byte.MAX_VALUE, 122, 0, 22, 29, 16, 89, 77, 90, 78, 25, 3, 14, 18, 70, 92, 91, 83, 10, 22, 14, 13, 28, 27, 92, 11, 52, 51, 37, 43, 43, 44, 59, 55, 5, 2, 6, 6, 31, 24, 31, 15, 87, 80, 87, 64, 41, 46, 41, 41, 7, 0, 7, 14, 110, 105, 105, 110, 7, 0, 14, 70, 38, 35, 102, 49, 40, 57, 50, 63, 122, 104, 106, 122, 90, 72, 70, 74, 55, 40, 43, 39, 114, 116, 103, 96, 48, 54, 37, 47, 113, 119, 96, 125, 20, 18, 21, 14, 60, 48, 123, 47, 13, 28, 12, 25, 3, 3, 31, 18, 67, 88, 93, 81, 113, 119, 55, 63, 94, 88, 24, 17, 112, 118, 101, 69, 66, 84, 67, 80, Byte.MAX_VALUE, 126, 124, 124};
        if (A02[1].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[0] = "9urlqVBgzNu2lPEtqyYfCO2dhYlEYkJ4";
        strArr[5] = "Fy8yYmAF0GIgc5OhzJupzMhc6ob0RfIG";
        A01 = bArr;
    }

    static {
        A04();
        A0V = IF.A08(A03(R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, 4, 104));
        A07 = IF.A08(A03(16, 4, 34));
        A08 = IF.A08(A03(20, 4, 29));
        A0Y = IF.A08(A03(124, 4, 48));
        A0X = IF.A08(A03(120, 4, 89));
        A0t = IF.A08(A03(208, 4, 121));
        A0E = IF.A08(A03(44, 4, 90));
        A0c = IF.A08(A03(140, 4, 100));
        A0l = IF.A08(A03(176, 4, 79));
        A04 = IF.A08(A03(0, 4, 84));
        A1W = IF.A08(A03(364, 4, 5));
        A0b = IF.A08(A03(136, 4, 42));
        A15 = IF.A08(A03(256, 4, 73));
        A05 = IF.A08(A03(8, 4, R.styleable.AppCompatTheme_toolbarStyle));
        A0F = IF.A08(A03(48, 4, 107));
        A0N = IF.A08(A03(80, 4, 38));
        A0I = IF.A08(A03(60, 4, 125));
        A0J = IF.A08(A03(64, 4, 67));
        A0L = IF.A08(A03(72, 4, 23));
        A0M = IF.A08(A03(76, 4, 4));
        A0K = IF.A08(A03(68, 4, 123));
        A0H = IF.A08(A03(56, 4, R.styleable.AppCompatTheme_textColorSearchUrl));
        A1I = IF.A08(A03(308, 4, 62));
        A1J = IF.A08(A03(312, 4, 30));
        A1N = IF.A08(A03(328, 4, 53));
        A1O = IF.A08(A03(332, 4, 80));
        A13 = IF.A08(A03(248, 4, 90));
        A0k = IF.A08(A03(172, 4, 39));
        A0o = IF.A08(A03(188, 4, 47));
        A1M = IF.A08(A03(324, 4, 116));
        A0e = IF.A08(A03(148, 4, R.styleable.AppCompatTheme_textColorAlertDialogListItem));
        A0i = IF.A08(A03(164, 4, 21));
        A17 = IF.A08(A03(264, 4, 119));
        A09 = IF.A08(A03(24, 4, 103));
        A0Z = IF.A08(A03(NotificationCompat.FLAG_HIGH_PRIORITY, 4, 46));
        A0T = IF.A08(A03(104, 4, 30));
        A0j = IF.A08(A03(168, 4, 9));
        A1L = IF.A08(A03(320, 4, 54));
        A0n = IF.A08(A03(184, 4, 107));
        A0g = IF.A08(A03(156, 4, 75));
        A1K = IF.A08(A03(316, 4, R.styleable.AppCompatTheme_tooltipFrameBackground));
        A0O = IF.A08(A03(84, 4, 7));
        A0P = IF.A08(A03(88, 4, 63));
        A0d = IF.A08(A03(144, 4, 23));
        A0W = IF.A08(A03(116, 4, 20));
        A1B = IF.A08(A03(280, 4, 20));
        A0s = IF.A08(A03(204, 4, 82));
        A14 = IF.A08(A03(252, 4, 5));
        A10 = IF.A08(A03(236, 4, 39));
        A0z = IF.A08(A03(232, 4, 83));
        A1H = IF.A08(A03(304, 4, 108));
        A0S = IF.A08(A03(100, 4, 122));
        A0R = IF.A08(A03(96, 4, 51));
        A0U = IF.A08(A03(108, 4, 71));
        A0v = IF.A08(A03(216, 4, 67));
        A0u = IF.A08(A03(212, 4, 46));
        A0y = IF.A08(A03(228, 4, 53));
        A12 = IF.A08(A03(244, 4, 26));
        A1R = IF.A08(A03(344, 4, 70));
        A11 = IF.A08(A03(240, 4, 67));
        A0q = IF.A08(A03(196, 4, 53));
        A03 = IF.A08(A03(4, 4, 107));
        A1S = IF.A08(A03(348, 4, 5));
        A0m = IF.A08(A03(180, 4, 80));
        A1E = IF.A08(A03(292, 4, 45));
        A1C = IF.A08(A03(284, 4, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader));
        A0D = IF.A08(A03(40, 4, 18));
        A1A = IF.A08(A03(276, 4, 92));
        A1D = IF.A08(A03(288, 4, 68));
        A1F = IF.A08(A03(296, 4, 68));
        A18 = IF.A08(A03(268, 4, 104));
        A0C = IF.A08(A03(36, 4, 11));
        A1P = IF.A08(A03(336, 4, 120));
        A1X = IF.A08(A03(368, 4, 56));
        A19 = IF.A08(A03(272, 4, 70));
        A0A = IF.A08(A03(28, 4, 54));
        A0w = IF.A08(A03(220, 4, 8));
        A0x = IF.A08(A03(224, 4, 50));
        A1Q = IF.A08(A03(340, 4, 72));
        A0h = IF.A08(A03(160, 4, 96));
        A0a = IF.A08(A03(132, 4, 124));
        A0f = IF.A08(A03(152, 4, 22));
        A0p = IF.A08(A03(192, 4, 35));
        A0G = IF.A08(A03(52, 4, 122));
        A0Q = IF.A08(A03(92, 4, 28));
        A16 = IF.A08(A03(260, 4, 95));
        A1G = IF.A08(A03(300, 4, 101));
        A0r = IF.A08(A03(200, 4, 21));
        A1T = IF.A08(A03(352, 4, 55));
        A1U = IF.A08(A03(356, 4, 24));
        A1V = IF.A08(A03(360, 4, 54));
        A0B = IF.A08(A03(32, 4, 98));
        A06 = IF.A08(A03(12, 4, 81));
    }

    public CJ(int i) {
        this.A00 = i;
    }

    public static int A00(int i) {
        return 16777215 & i;
    }

    public static int A01(int i) {
        return (i >> 24) & 255;
    }

    public static String A02(int i) {
        return A03(0, 0, 81) + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public String toString() {
        return A02(this.A00);
    }
}
