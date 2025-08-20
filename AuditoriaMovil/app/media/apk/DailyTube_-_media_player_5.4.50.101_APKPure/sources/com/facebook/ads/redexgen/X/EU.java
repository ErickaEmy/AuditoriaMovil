package com.facebook.ads.redexgen.X;

import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.VideoStartReason;
/* loaded from: assets/audience_network.dex */
public class EU extends AbstractC0893Pu {
    public final /* synthetic */ C04005h A00;

    public EU(C04005h c04005h) {
        this.A00 = c04005h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC04788s
    /* renamed from: A00 */
    public final void A03(C9H c9h) {
        MediaViewVideoRenderer mediaViewVideoRenderer;
        MediaViewVideoRenderer mediaViewVideoRenderer2;
        MediaViewVideoRenderer mediaViewVideoRenderer3;
        mediaViewVideoRenderer = this.A00.A00;
        mediaViewVideoRenderer.onCompleted();
        mediaViewVideoRenderer2 = this.A00.A00;
        if (C0705Ih.A1H(mediaViewVideoRenderer2.getContext())) {
            mediaViewVideoRenderer3 = this.A00.A00;
            mediaViewVideoRenderer3.play(VideoStartReason.AUTO_STARTED);
        }
    }
}
