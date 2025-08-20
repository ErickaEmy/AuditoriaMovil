package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class BP extends MV {
    public final /* synthetic */ BK A00;

    public BP(BK bk2) {
        this.A00 = bk2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A00 */
    public final void A03(MW mw) {
        if (this.A00.getVideoView() != null) {
            this.A00.A07.A0P().setVolume(this.A00.getVideoView().getVolume());
        }
    }
}
