package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class T0 extends KT {
    public static byte[] A01;
    public final /* synthetic */ C0974Sx A00;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 126);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{35, 54, 49, 50, 60, -19, 68, 46, 64, -19, 59, 50, 67, 50, 63, -19, 61, 63, 50, 61, 46, 63, 50, 49};
    }

    public T0(C0974Sx c0974Sx) {
        this.A00 = c0974Sx;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        boolean z2;
        InterfaceC0876Pd interfaceC0876Pd;
        z2 = this.A00.A0S;
        if (!z2) {
            interfaceC0876Pd = this.A00.A0X;
            interfaceC0876Pd.ADX(A00(0, 24, 79));
        }
    }
}
