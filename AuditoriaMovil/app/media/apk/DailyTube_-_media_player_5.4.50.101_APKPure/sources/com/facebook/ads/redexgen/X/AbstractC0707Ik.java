package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Ik  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0707Ik {
    public static byte[] A00;
    public static final AtomicBoolean A01;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 102);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{5, 8, 18, 27, 3, 22, 22, 3, 5, 8, 3, 22, 9, 21, 25, 9, 23, 24, 3, 24, 13, 17, 9, 19, 25, 24, -42, -39, -29, -20, -44, -25, -25, -44, -38, -29, -42, -41, -31, -38, -39, -23, -20, -10, -1, -25, -6, -6, -25, -18, -21, -25, -19, 0, -8, -15, -6, -23, -4, -15, -9, -10, -25, -4, -15, -11, -19, -9, -3, -4, 58, 61, 71, 80, 56, 75, 75, 56, 65, 58, 71, 61, 76, 65, 58, 68, 62, 56, 62, 71, 58, 59, 69, 62, 61, 22, 25, 35, 44, 20, 39, 39, 20, 29, 22, 35, 25, 40, 29, 22, 32, 26, 20, 41, 30, 34, 26, 36, 42, 41, -55, -52, -42, -33, -57, -38, -38, -57, -47, -42, -36, -57, -51, -42, -55, -54, -44, -51, -52, -16, -13, -3, 6, -18, 1, 1, -18, 1, 5, -18, -12, -3, -16, -15, -5, -12, -13, 2, 5, 15, 24, 0, 19, 19, 0, 20, 6, 15, 5, 0, 3, 21, 0, 6, 25, 21, 19, 2, 20, 42, 54, 52, -11, 45, 40, 42, 44, 41, 54, 54, 50, -11, 50, 40, 59, 40, 53, 40, 40, 52, 50, -13, 43, 38, 40, 42, 39, 52, 52, 48, -13, 60, 38, 48, 46, 63, 38, 56, 45, 46};
    }

    static {
        A05();
        A01 = new AtomicBoolean(false);
    }

    public static int A00(Context context) {
        return C0705Ih.A0R(context).A2T(A03(0, 26, 62), 10000);
    }

    public static int A01(Context context) {
        return C0705Ih.A0R(context).A2T(A03(95, 25, 79), 30000);
    }

    public static long A02(Context context) {
        return C0705Ih.A0R(context).A2U(A03(41, 29, 34), 86400000L);
    }

    public static String A04(boolean z2) {
        return z2 ? A03(198, 22, 95) : A03(179, 19, 97);
    }

    public static void A06(Context context) {
        C0705Ih.A0R(context).A2W(A03(26, 15, 15));
    }

    public static boolean A07(Context context) {
        return A01.get() || A0E(context);
    }

    public static boolean A08(Context context) {
        return C0705Ih.A0R(context).A2Z(A03(120, 19, 2), true);
    }

    public static boolean A09(Context context) {
        return C0705Ih.A0R(context).A2Z(A03(139, 18, 41), true);
    }

    public static boolean A0A(Context context) {
        return A01.get() || A0C(context);
    }

    public static boolean A0B(Context context) {
        return C0705Ih.A0R(context).A2Z(A03(157, 22, 59), false);
    }

    public static boolean A0C(Context context) {
        return A0E(context) && C0705Ih.A0R(context).A2Z(A03(70, 25, R.styleable.AppCompatTheme_tooltipFrameBackground), false);
    }

    public static boolean A0D(Context context) {
        return A09(context) || A08(context);
    }

    public static boolean A0E(Context context) {
        return Build.VERSION.SDK_INT >= 21 && C0705Ih.A0R(context).A2Z(A03(26, 15, 15), false) && A0D(context) && !A0F(context, A02(context));
    }

    public static boolean A0F(Context context, long j2) {
        long lastUpdateTime = System.currentTimeMillis();
        long currentTime = C0705Ih.A0Q(context);
        return lastUpdateTime - currentTime > j2;
    }
}
