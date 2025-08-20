package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardedInterstitialAd;
/* renamed from: com.facebook.ads.redexgen.X.5w  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04155w implements RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder, RewardedInterstitialAd.RewardedInterstitialShowAdConfig {
    public final C04185z A00;

    public C04155w(C04185z c04185z) {
        this.A00 = c04185z;
    }

    public final C04185z A00() {
        return this.A00;
    }

    public final RewardedInterstitialAd.RewardedInterstitialShowAdConfig build() {
        return this;
    }

    public final RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder withAppOrientation(int i) {
        this.A00.withAppOrientation(i);
        return this;
    }
}
