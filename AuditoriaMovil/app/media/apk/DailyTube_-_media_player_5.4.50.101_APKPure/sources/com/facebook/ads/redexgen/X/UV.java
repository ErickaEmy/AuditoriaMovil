package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class UV implements NI {
    public static byte[] A01;
    public final /* synthetic */ UT A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 27);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-62, -64, -78, -65, -84, -81, -62, -77, -77, -78, -65, -78, -79, -84, -80, -71, -74, -80, -72, -84, -74, -82, -81, -84, -78, -59, -63, -78, -65, -69, -82, -71, -84, -69, -82, -61, -74, -76, -82, -63, -74, -68, -69};
    }

    public UV(UT ut2) {
        this.A00 = ut2;
    }

    @Override // com.facebook.ads.redexgen.X.NI
    public final void AB6() {
        this.A00.A0G();
    }

    @Override // com.facebook.ads.redexgen.X.NI
    public final void ACR() {
        this.A00.A0H(A00(0, 43, 50));
    }
}
