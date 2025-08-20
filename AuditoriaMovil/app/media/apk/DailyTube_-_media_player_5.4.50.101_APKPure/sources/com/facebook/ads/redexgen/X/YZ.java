package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
/* loaded from: assets/audience_network.dex */
public class YZ extends KT {
    public final /* synthetic */ C1115Ym A00;

    public YZ(C1115Ym c1115Ym) {
        this.A00 = c1115Ym;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        if (dynamicLoader != null) {
            dynamicLoader.createBidderTokenProviderApi().getBidderToken(this.A00);
        }
    }
}
