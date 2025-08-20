package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class TX extends KT {
    public static String[] A02 = {"rNojiCX4xbNIivpzxAZD5CGLpZSsB0cf", "gTQMgTVmh4ndJptIt2sMORjeQpSXRBHW", "eFvAsOcf4OUvtKLZ0zJ9A4a6xINuf65M", "zedo6J0UAAprXKggsrFcNuadwxMeMHbQ", "7", "DS8lWC61Mxa3ewGRcwm3azNk9qEARxSc", "rDtiV9g6xH5YbmosdU0JJzpAD7mTk2Ku", "p7bHcfGz1j3c8F8Ipm9kGqYxxb8HylgU"};
    public final /* synthetic */ TT A00;
    public final /* synthetic */ boolean A01;

    public TX(TT tt, boolean z2) {
        this.A00 = tt;
        this.A01 = z2;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        OP op;
        op = this.A00.A0L;
        MB A08 = op.A08();
        if (A08 != null) {
            A08.setPageDetailsVisible((this.A01 || A08.A07()) ? false : true);
            int closeButtonStyle = this.A00.getCloseButtonStyle();
            String[] strArr = A02;
            if (strArr[2].charAt(24) != strArr[7].charAt(24)) {
                throw new RuntimeException();
            }
            A02[5] = "wL2nmppPftTmZMu9Z6aXcUYY8F6iliST";
            A08.setToolbarActionMode(closeButtonStyle);
        }
    }
}
