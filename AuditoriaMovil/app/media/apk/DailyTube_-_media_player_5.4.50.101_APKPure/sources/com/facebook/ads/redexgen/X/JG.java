package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
/* loaded from: assets/audience_network.dex */
public final class JG implements AdView.AdViewLoadConfigBuilder, AdView.AdViewLoadConfig {
    public String A00;
    public final C5P A01;

    public JG(C5P c5p) {
        this.A01 = c5p;
    }

    public final String A00() {
        return this.A00;
    }

    public final AdView.AdViewLoadConfig build() {
        return this;
    }

    public final AdView.AdViewLoadConfigBuilder withAdListener(AdListener adListener) {
        this.A01.A0C(adListener);
        return this;
    }

    public final AdView.AdViewLoadConfigBuilder withBid(String str) {
        this.A00 = str;
        return this;
    }
}
