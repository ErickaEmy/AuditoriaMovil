package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class SS extends RD {
    public final /* synthetic */ C9P A00;

    public SS(C9P c9p) {
        this.A00 = c9p;
    }

    @Override // com.facebook.ads.redexgen.X.RD
    public final void A03() {
        C0775Lg c0775Lg;
        C0775Lg c0775Lg2;
        String str;
        RE re;
        C0775Lg c0775Lg3;
        AbstractC1219b5 abstractC1219b5;
        J2 j2;
        String str2;
        AbstractC1219b5 abstractC1219b52;
        C1116Yn c1116Yn;
        C1116Yn c1116Yn2;
        AbstractC1219b5 abstractC1219b53;
        c0775Lg = this.A00.A0E;
        if (!c0775Lg.A07()) {
            C9P c9p = this.A00;
            c0775Lg2 = c9p.A0E;
            c9p.setImpressionRecordingFlag(c0775Lg2);
            str = this.A00.A0A;
            if (!TextUtils.isEmpty(str)) {
                C0829Ni c0829Ni = new C0829Ni();
                re = this.A00.A09;
                C0829Ni A03 = c0829Ni.A03(re);
                c0775Lg3 = this.A00.A0E;
                C0829Ni A02 = A03.A02(c0775Lg3);
                abstractC1219b5 = ((UL) this.A00).A0A;
                Map<String, String> A05 = A02.A04(abstractC1219b5.A0O()).A05();
                j2 = ((UL) this.A00).A0C;
                str2 = this.A00.A0A;
                j2.A9g(str2, A05);
                abstractC1219b52 = ((UL) this.A00).A0A;
                C1U A0y = abstractC1219b52.A0y();
                c1116Yn = this.A00.A0D;
                C1U.A07(A0y, c1116Yn);
                c1116Yn2 = this.A00.A0D;
                c1116Yn2.A0E().A2k();
                abstractC1219b53 = this.A00.A03;
                C2O.A00(abstractC1219b53.A0N());
            }
        }
    }
}
