package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
/* loaded from: assets/audience_network.dex */
public class VI implements JM {
    public final /* synthetic */ MediaViewVideoRendererApi A00;
    public final /* synthetic */ VE A01;

    public VI(VE ve, MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        this.A01 = ve;
        this.A00 = mediaViewVideoRendererApi;
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void AG3() {
        this.A00.setVolume(0.0f);
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void AG8(NativeAd nativeAd) {
        this.A01.A0I(V2.A0L(nativeAd.getInternalNativeAd()), null);
    }

    @Override // com.facebook.ads.redexgen.X.JM
    public final void AGn() {
        this.A01.A0D();
    }
}
