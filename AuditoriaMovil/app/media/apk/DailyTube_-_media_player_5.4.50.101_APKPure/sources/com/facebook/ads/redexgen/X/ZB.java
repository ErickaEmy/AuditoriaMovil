package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAd;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public class ZB implements C6U {
    public final List<C1234bK> A00;
    public final /* synthetic */ ZA A01;

    public ZB(ZA za, List<C1234bK> list) {
        this.A01 = za;
        this.A00 = list;
    }

    private void A00() {
        C04055m c04055m;
        C04055m c04055m2;
        C04055m c04055m3;
        C1116Yn c1116Yn;
        C04055m c04055m4;
        C04055m c04055m5;
        C1116Yn c1116Yn2;
        c04055m = this.A01.A00;
        c04055m.A05(true);
        c04055m2 = this.A01.A00;
        c04055m2.A02();
        c04055m3 = this.A01.A00;
        c04055m3.A03(0);
        for (C1234bK c1234bK : this.A00) {
            c1116Yn = this.A01.A01;
            V5 A0K = V2.A0K();
            c04055m4 = this.A01.A00;
            V2 v2 = new V2(c1116Yn, c1234bK, null, A0K, c04055m4.A01());
            if (v2.A0y() != null && v2.A0y().A0F() != null) {
                ((AbstractC1195ah) v2.A0y().A0F()).A00(v2);
            }
            c04055m5 = this.A01.A00;
            c1116Yn2 = this.A01.A01;
            c04055m5.A04(new NativeAd(c1116Yn2, v2));
        }
        KK.A00(new ZC(this));
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void AB2() {
        A00();
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void ABB() {
        A00();
    }
}
