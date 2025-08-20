package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Tj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0986Tj extends KT {
    public final /* synthetic */ AbstractC0842Nv A00;

    public C0986Tj(AbstractC0842Nv abstractC0842Nv) {
        this.A00 = abstractC0842Nv;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        Runnable runnable;
        int i;
        this.A00.setPressed(false);
        AbstractC0842Nv abstractC0842Nv = this.A00;
        runnable = abstractC0842Nv.A08;
        i = this.A00.A07;
        abstractC0842Nv.postOnAnimationDelayed(runnable, i);
    }
}
