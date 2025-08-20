package com.facebook.ads.redexgen.X;

import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import java.util.EnumSet;
/* renamed from: com.facebook.ads.redexgen.X.5f  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C03985f implements InterstitialAd.InterstitialAdLoadConfigBuilder, InterstitialAd.InterstitialLoadAdConfig {
    public C03975e A00;
    public String A01;
    public EnumSet<CacheFlag> A02;

    public C03985f(C03975e c03975e) {
        this.A00 = c03975e;
    }

    public final void A00() {
        if (this.A02 == null) {
            this.A02 = CacheFlag.ALL;
        }
        this.A00.A05(this.A02, this.A01);
    }

    public final InterstitialAd.InterstitialLoadAdConfig build() {
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withAdListener(InterstitialAdListener interstitialAdListener) {
        this.A00.A02(interstitialAdListener);
        if (interstitialAdListener instanceof InterstitialAdExtendedListener) {
            this.A00.A04((InterstitialAdExtendedListener) interstitialAdListener);
        }
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withBid(String str) {
        this.A01 = str;
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withCacheFlags(EnumSet<CacheFlag> cacheFlags) {
        this.A02 = cacheFlags;
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData) {
        this.A00.A03(rewardData);
        return this;
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder withRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.A00.A04(rewardedAdListener);
        return this;
    }
}
