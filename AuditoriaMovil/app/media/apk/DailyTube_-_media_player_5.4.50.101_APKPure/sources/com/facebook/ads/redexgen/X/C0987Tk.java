package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Tk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0987Tk extends KT {
    public final /* synthetic */ AbstractC0842Nv A00;

    public C0987Tk(AbstractC0842Nv abstractC0842Nv) {
        this.A00 = abstractC0842Nv;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        Runnable runnable;
        int i;
        if (this.A00.isPressed()) {
            AbstractC0842Nv abstractC0842Nv = this.A00;
            i = abstractC0842Nv.A07;
            abstractC0842Nv.postDelayed(this, i);
            return;
        }
        this.A00.setPressed(true);
        AbstractC0842Nv abstractC0842Nv2 = this.A00;
        runnable = abstractC0842Nv2.A09;
        abstractC0842Nv2.postOnAnimationDelayed(runnable, 250L);
    }
}
