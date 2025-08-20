package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class M5 {
    public static byte[] A00;
    public static final String A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 23);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{100, -105, -126, -124, -113, -109, -120, -114, -115, 63, -120, -115, 63, -110, -126, -111, -124, -124, -115, 63, -120, -115, -109, -124, -111, Byte.MIN_VALUE, -126, -109, -120, -107, -124, 63, -126, -121, -124, -126, -118, 75, 63, Byte.MIN_VALUE, -110, -110, -108, -116, -120, -115, -122, 63, -120, -115, -109, -124, -111, Byte.MIN_VALUE, -126, -109, -120, -107, -124, 77, -103, -104, -96, -114, -101, -46, -55, -45, -53, -39};
    }

    static {
        A01();
        A01 = M5.class.getSimpleName();
    }

    public static boolean A02(C1116Yn c1116Yn) {
        return A03(c1116Yn) && M6.A03(c1116Yn);
    }

    public static boolean A03(C1116Yn c1116Yn) {
        if (c1116Yn == null) {
            return true;
        }
        try {
            PowerManager powerManager = (PowerManager) c1116Yn.getSystemService(A00(60, 5, 18));
            if (Build.VERSION.SDK_INT >= 20) {
                return powerManager.isInteractive();
            }
            return powerManager.isScreenOn();
        } catch (Exception e2) {
            Log.e(A01, A00(0, 60, 8), e2);
            c1116Yn.A07().A9a(A00(65, 5, 73), C8A.A2S, new C8B(e2));
            return true;
        }
    }
}
