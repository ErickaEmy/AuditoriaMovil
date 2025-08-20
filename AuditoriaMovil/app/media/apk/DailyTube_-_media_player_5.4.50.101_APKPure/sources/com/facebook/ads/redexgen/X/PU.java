package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class PU implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C0974Sx A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 33);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{41, 50, 50, 49, 63, 60, 47};
    }

    public PU(C0974Sx c0974Sx) {
        this.A00 = c0974Sx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z2;
        C0861Oo c0861Oo;
        if (KL.A02(this)) {
            return;
        }
        try {
            z2 = this.A00.A0K;
            if (z2) {
                return;
            }
            c0861Oo = this.A00.A0H;
            c0861Oo.A02(A00(0, 7, 124));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
