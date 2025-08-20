package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class MF implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ View$OnClickListenerC0544Bi A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 54);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{62, 56, 46, 57, 20, 41, 62, 45, 45, 46, 57, 46, 47, 20, 40, 39, 34, 40, 32, 20, 42, 45, 63, 46, 57, 20, 47, 46, 39, 42, 50};
    }

    public MF(View$OnClickListenerC0544Bi view$OnClickListenerC0544Bi) {
        this.A00 = view$OnClickListenerC0544Bi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0H(A00(0, 31, 125));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
