package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
/* loaded from: assets/audience_network.dex */
public final class JV implements NativeAdBase.NativeAdLoadConfigBuilder, NativeAdBase.NativeLoadAdConfig {
    public NativeAdBase.MediaCacheFlag A02;
    public String A03;
    public boolean A04;
    public final NativeAdBase A05;
    public final V2 A06;
    public int A01 = -1;
    public int A00 = -1;

    public JV(V2 v2, NativeAdBase nativeAdBase) {
        this.A06 = v2;
        this.A05 = nativeAdBase;
    }

    public final void A00() {
        if (this.A02 == null) {
            this.A02 = NativeAdBase.MediaCacheFlag.ALL;
        }
        this.A06.A1V(JL.A00(this.A02), this.A03, new C6i(this.A04, this.A01, this.A00));
    }

    public final NativeAdBase.NativeLoadAdConfig build() {
        return this;
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder withAdListener(NativeAdListener nativeAdListener) {
        this.A06.A1R(this.A05, nativeAdListener);
        return this;
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder withBid(String str) {
        this.A03 = str;
        return this;
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder withMediaCacheFlag(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A02 = mediaCacheFlag;
        return this;
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder withPreloadedIconView(int i, int i5) {
        this.A04 = true;
        this.A01 = i;
        this.A00 = i5;
        return this;
    }
}
