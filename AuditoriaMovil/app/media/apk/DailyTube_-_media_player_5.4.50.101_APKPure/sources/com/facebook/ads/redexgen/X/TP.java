package com.facebook.ads.redexgen.X;

import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class TP extends RD {
    public final /* synthetic */ B3 A00;

    public TP(B3 b3) {
        this.A00 = b3;
    }

    @Override // com.facebook.ads.redexgen.X.RD
    public final void A03() {
        C0775Lg c0775Lg;
        C0775Lg c0775Lg2;
        RE re;
        C0775Lg c0775Lg3;
        J2 j2;
        AbstractC1219b5 abstractC1219b5;
        AbstractC1219b5 abstractC1219b52;
        C1116Yn c1116Yn;
        C1116Yn c1116Yn2;
        AbstractC1219b5 abstractC1219b53;
        MC mc2;
        MC mc3;
        InterfaceC0804Mj interfaceC0804Mj;
        c0775Lg = this.A00.A0B;
        if (!c0775Lg.A07()) {
            c0775Lg2 = this.A00.A0B;
            c0775Lg2.A05();
            C0829Ni c0829Ni = new C0829Ni();
            re = this.A00.A0H;
            C0829Ni A03 = c0829Ni.A03(re);
            c0775Lg3 = this.A00.A0B;
            Map<String, String> A05 = A03.A02(c0775Lg3).A05();
            j2 = this.A00.A08;
            abstractC1219b5 = this.A00.A06;
            j2.A9g(abstractC1219b5.A12(), A05);
            abstractC1219b52 = this.A00.A06;
            C1U A0y = abstractC1219b52.A0y();
            c1116Yn = this.A00.A07;
            C1U.A07(A0y, c1116Yn);
            c1116Yn2 = this.A00.A07;
            c1116Yn2.A0E().A2k();
            abstractC1219b53 = this.A00.A06;
            C2O.A00(abstractC1219b53.A0N());
            mc2 = this.A00.A0C;
            if (mc2 != null) {
                mc3 = this.A00.A0C;
                interfaceC0804Mj = this.A00.A0D;
                mc3.A43(interfaceC0804Mj.A7B());
            }
        }
    }
}
