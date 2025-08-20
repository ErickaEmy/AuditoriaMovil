package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Oh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0854Oh implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ TT A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 74);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-6, -19, -24, -23, -13};
    }

    public View$OnClickListenerC0854Oh(TT tt) {
        this.A00 = tt;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z2;
        C0861Oo c0861Oo;
        if (KL.A02(this)) {
            return;
        }
        try {
            z2 = this.A00.A0O;
            if (z2) {
                return;
            }
            c0861Oo = this.A00.A0M;
            c0861Oo.A02(A00(0, 5, 58));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
