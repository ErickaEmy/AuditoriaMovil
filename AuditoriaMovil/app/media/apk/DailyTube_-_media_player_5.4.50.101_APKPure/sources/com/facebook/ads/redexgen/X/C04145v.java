package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedInterstitialAd;
import com.facebook.ads.RewardedInterstitialAdListener;
/* renamed from: com.facebook.ads.redexgen.X.5v  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04145v implements RewardedInterstitialAd.RewardedInterstitialAdLoadConfigBuilder, RewardedInterstitialAd.RewardedInterstitialLoadAdConfig {
    public final C04175y A00;

    public C04145v(C04175y c04175y) {
        this.A00 = c04175y;
        c04175y.withAdExperience(AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL);
    }

    public final void A00() {
        this.A00.A00();
    }

    public final RewardedInterstitialAd.RewardedInterstitialLoadAdConfig build() {
        return this;
    }

    public final RewardedInterstitialAd.RewardedInterstitialAdLoadConfigBuilder withAdListener(RewardedInterstitialAdListener rewardedInterstitialAdListener) {
        this.A00.withAdListener(new C04135u(rewardedInterstitialAdListener));
        return this;
    }

    public final RewardedInterstitialAd.RewardedInterstitialAdLoadConfigBuilder withBid(String str) {
        this.A00.withBid(str);
        return this;
    }

    public final RewardedInterstitialAd.RewardedInterstitialAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z2) {
        this.A00.withFailOnCacheFailureEnabled(z2);
        return this;
    }

    public final RewardedInterstitialAd.RewardedInterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData) {
        this.A00.withRewardData(rewardData);
        return this;
    }
}
