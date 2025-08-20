package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Sz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0976Sz extends KT {
    public static byte[] A02;
    public final /* synthetic */ C0974Sx A00;
    public final /* synthetic */ AnonymousClass93 A01;

    static {
        A02();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 18);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{Byte.MAX_VALUE, -78, -93, -93, -94, -81, -90, -85, -92, 93, -90, -85, -95, -94, -93, -90, -85, -90, -79, -94, -87, -74};
    }

    public C0976Sz(C0974Sx c0974Sx, AnonymousClass93 anonymousClass93) {
        this.A00 = c0974Sx;
        this.A01 = anonymousClass93;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        SA sa;
        SA sa2;
        InterfaceC0876Pd interfaceC0876Pd;
        sa = this.A00.A0Z;
        if (sa.getState() == RB.A02) {
            sa2 = this.A00.A0Z;
            if (sa2.getCurrentPositionInMillis() == A00()) {
                interfaceC0876Pd = this.A00.A0X;
                interfaceC0876Pd.ADX(A00(0, 22, 43));
            }
        }
    }
}
