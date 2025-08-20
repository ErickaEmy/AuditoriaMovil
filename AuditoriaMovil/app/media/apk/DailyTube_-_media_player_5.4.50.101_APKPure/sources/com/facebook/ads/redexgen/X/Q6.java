package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class Q6 implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ SM A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{21, 30, 20, 19, 17, 34, 20, 35};
    }

    public Q6(SM sm) {
        this.A00 = sm;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl;
        View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl2;
        if (KL.A02(this)) {
            return;
        }
        try {
            view$OnClickListenerC0988Tl = this.A00.A02;
            if (view$OnClickListenerC0988Tl == null) {
                return;
            }
            view$OnClickListenerC0988Tl2 = this.A00.A02;
            view$OnClickListenerC0988Tl2.A09(A00(0, 8, 65));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
