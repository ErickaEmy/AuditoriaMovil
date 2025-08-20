package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardedVideoAd;
/* renamed from: com.facebook.ads.redexgen.X.5z  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04185z implements RewardedVideoAd.RewardedVideoAdShowConfigBuilder, RewardedVideoAd.RewardedVideoShowAdConfig {
    public int A00 = -1;
    public long A01;

    public final int A00() {
        return this.A00;
    }

    public final long A01() {
        return this.A01;
    }

    public final C04185z A02(long j2) {
        this.A01 = j2;
        return this;
    }

    public final RewardedVideoAd.RewardedVideoShowAdConfig build() {
        return this;
    }

    public final RewardedVideoAd.RewardedVideoAdShowConfigBuilder withAppOrientation(int i) {
        this.A00 = i;
        return this;
    }
}
