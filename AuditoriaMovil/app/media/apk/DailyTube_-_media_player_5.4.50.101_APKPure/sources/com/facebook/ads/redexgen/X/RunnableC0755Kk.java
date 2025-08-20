package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Kk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0755Kk implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C1116Yn A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{97, 122, 125, 98, 97, 99, 104, 99, 116, 111, 101};
    }

    public RunnableC0755Kk(C1116Yn c1116Yn) {
        this.A00 = c1116Yn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (KL.A02(this)) {
            return;
        }
        try {
            C8B otsl = new C8B(A00(0, 4, 88));
            otsl.A05(1);
            otsl.A06(1);
            otsl.A0A(false);
            this.A00.A07().A9b(A00(4, 7, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), C8A.A1Y, otsl);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
