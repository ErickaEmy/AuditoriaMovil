package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
/* renamed from: com.facebook.ads.redexgen.X.al  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1199al extends KT {
    public final /* synthetic */ C1236bM A00;
    public final /* synthetic */ C03121v A01;
    public final /* synthetic */ FQ A02;

    public C1199al(FQ fq, C03121v c03121v, C1236bM c1236bM) {
        this.A02 = fq;
        this.A01 = c03121v;
        this.A00 = c1236bM;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        this.A02.A0Q(this.A01);
        this.A02.A0N(this.A00);
        this.A02.A00 = null;
        C0722Jb A00 = C0722Jb.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0E().A4t(A00.A03().getErrorCode(), A00.A04());
        this.A02.A06.A0G(A00);
    }
}
