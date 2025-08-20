package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.bR  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1241bR extends KT {
    public final /* synthetic */ C1240bQ A00;
    public final /* synthetic */ B0 A01;

    public C1241bR(C1240bQ c1240bQ, B0 b02) {
        this.A00 = c1240bQ;
        this.A01 = b02;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        RE re;
        RE re2;
        RE re3;
        this.A00.A00.A0A();
        re = this.A00.A00.A0B;
        if (re != null) {
            B0 b02 = this.A01;
            re2 = this.A00.A00.A0B;
            b02.setAdViewabilityChecker(re2);
            re3 = this.A00.A00.A0B;
            re3.A0U();
        }
    }
}
