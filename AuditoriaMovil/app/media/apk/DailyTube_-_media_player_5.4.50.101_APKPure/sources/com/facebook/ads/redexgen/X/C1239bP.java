package com.facebook.ads.redexgen.X;

import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.bP  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1239bP extends RD {
    public final /* synthetic */ C1237bN A00;

    public C1239bP(C1237bN c1237bN) {
        this.A00 = c1237bN;
    }

    @Override // com.facebook.ads.redexgen.X.RD
    public final void A03() {
        C0775Lg c0775Lg;
        C0775Lg c0775Lg2;
        EQ eq;
        C1225bB c1225bB;
        EQ eq2;
        FV fv;
        RE re;
        C0775Lg c0775Lg3;
        FV fv2;
        J2 j2;
        FV fv3;
        FV fv4;
        FV fv5;
        C1U A0y;
        EQ eq3;
        RE re2;
        c0775Lg = this.A00.A06;
        if (!c0775Lg.A07()) {
            c0775Lg2 = this.A00.A06;
            c0775Lg2.A05();
            eq = this.A00.A04;
            InterfaceC1256bg A0E = eq.A0E();
            c1225bB = this.A00.A02;
            A0E.A3k(c1225bB != null);
            eq2 = this.A00.A04;
            eq2.A0E().A2k();
            fv = this.A00.A03;
            C2O.A00(fv.A0N());
            C0829Ni c0829Ni = new C0829Ni();
            re = this.A00.A0B;
            C0829Ni A03 = c0829Ni.A03(re);
            c0775Lg3 = this.A00.A06;
            C0829Ni A02 = A03.A02(c0775Lg3);
            fv2 = this.A00.A03;
            Map<String, String> A05 = A02.A04(fv2.A0O()).A05();
            j2 = this.A00.A05;
            fv3 = this.A00.A03;
            j2.A9g(fv3.A12(), A05);
            fv4 = this.A00.A03;
            if (fv4 == null) {
                A0y = null;
            } else {
                fv5 = this.A00.A03;
                A0y = fv5.A0y();
            }
            eq3 = this.A00.A04;
            C1U.A07(A0y, eq3);
            re2 = this.A00.A0B;
            re2.A0V();
        }
    }
}
