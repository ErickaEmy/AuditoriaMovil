package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.38  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass38 extends C03603r {
    public BQ A00;
    public List<C0888Pp> A01;

    public AnonymousClass38(C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A00 = new BQ(this, 1, null, null, null);
    }

    public final void A1y(RE re) {
        BQ bq = this.A00;
        if (bq != null) {
            bq.A0c(re);
        }
    }

    public BQ getCarouselCardBehaviorHelper() {
        return this.A00;
    }

    public void setCardsInfo(ArrayList arrayList) {
        this.A01 = arrayList;
        this.A00.A0d(arrayList);
    }
}
