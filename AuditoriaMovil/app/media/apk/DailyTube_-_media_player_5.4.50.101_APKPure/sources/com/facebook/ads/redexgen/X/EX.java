package com.facebook.ads.redexgen.X;

import com.facebook.ads.MediaViewVideoRenderer;
/* loaded from: assets/audience_network.dex */
public class EX extends O7 {
    public final /* synthetic */ C04005h A00;

    public EX(C04005h c04005h) {
        this.A00 = c04005h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A00 */
    public final void A03(O8 o8) {
        MediaViewVideoRenderer mediaViewVideoRenderer;
        if (this.A00.A08 != null) {
            V2.A0L(this.A00.A08.getInternalNativeAd()).A1c(true, true);
        }
        mediaViewVideoRenderer = this.A00.A00;
        mediaViewVideoRenderer.onPlayed();
    }
}
