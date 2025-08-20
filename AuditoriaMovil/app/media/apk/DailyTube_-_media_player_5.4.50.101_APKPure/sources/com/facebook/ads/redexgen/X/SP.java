package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class SP extends RD {
    public final /* synthetic */ J2 A00;
    public final /* synthetic */ C0775Lg A01;
    public final /* synthetic */ C0888Pp A02;
    public final /* synthetic */ SN A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public SP(SN sn, String str, C0888Pp c0888Pp, J2 j2, Map map, C0775Lg c0775Lg) {
        this.A03 = sn;
        this.A04 = str;
        this.A02 = c0888Pp;
        this.A00 = j2;
        this.A05 = map;
        this.A01 = c0775Lg;
    }

    @Override // com.facebook.ads.redexgen.X.RD
    public final void A03() {
        RE re;
        SparseBooleanArray sparseBooleanArray;
        RE re2;
        C1U c1u;
        C1116Yn c1116Yn;
        SparseBooleanArray sparseBooleanArray2;
        re = this.A03.A02;
        if (!re.A0Z() && !TextUtils.isEmpty(this.A04)) {
            sparseBooleanArray = this.A03.A08;
            if (!sparseBooleanArray.get(this.A02.A02())) {
                J2 j2 = this.A00;
                String str = this.A04;
                C0829Ni c0829Ni = new C0829Ni(this.A05);
                re2 = this.A03.A03;
                j2.A9g(str, c0829Ni.A03(re2).A02(this.A01).A05());
                c1u = this.A03.A00;
                c1116Yn = this.A03.A09;
                C1U.A07(c1u, c1116Yn);
                sparseBooleanArray2 = this.A03.A08;
                sparseBooleanArray2.put(this.A02.A02(), true);
            }
        }
    }
}
