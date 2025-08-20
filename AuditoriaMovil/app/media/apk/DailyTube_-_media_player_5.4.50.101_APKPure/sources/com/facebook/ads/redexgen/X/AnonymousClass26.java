package com.facebook.ads.redexgen.X;

import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
/* renamed from: com.facebook.ads.redexgen.X.26  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass26 {
    public long A00;
    public InterstitialAd A01;
    public InterstitialAdListener A02;
    public RewardData A03;
    public RewardedAdListener A04;
    public String A05;
    public String A06;
    public String A07;
    public EnumSet<CacheFlag> A08;
    public final C8Z A09;
    public final C1116Yn A0A;
    public final String A0B;
    public final WeakReference<InterstitialAd> A0C;

    public AnonymousClass26(C1116Yn c1116Yn, InterstitialAd interstitialAd, String str) {
        this(c1116Yn, interstitialAd, str, new C1187aZ());
    }

    public AnonymousClass26(C1116Yn c1116Yn, InterstitialAd interstitialAd, String str, C8Z c8z) {
        this.A0A = c1116Yn;
        this.A0B = str;
        this.A01 = interstitialAd;
        this.A0C = new WeakReference<>(interstitialAd);
        this.A00 = -1L;
        c1116Yn.A0M(this);
        this.A09 = c8z;
    }

    public final long A00() {
        return this.A00;
    }

    public final InterstitialAd A01() {
        InterstitialAd interstitialAd = this.A01;
        return interstitialAd != null ? interstitialAd : this.A0C.get();
    }

    public final InterstitialAdListener A02() {
        return this.A02;
    }

    public final RewardData A03() {
        return this.A03;
    }

    public final RewardedAdListener A04() {
        return this.A04;
    }

    public final C1116Yn A05() {
        return this.A0A;
    }

    public final C8Z A06() {
        return this.A09;
    }

    public final String A07() {
        return this.A05;
    }

    public final String A08() {
        return this.A06;
    }

    public final String A09() {
        return this.A07;
    }

    public final String A0A() {
        return this.A0B;
    }

    public final EnumSet<CacheFlag> A0B() {
        return this.A08;
    }

    public final void A0C(long j2) {
        this.A00 = j2;
    }

    public final void A0D(InterstitialAd interstitialAd) {
        if (interstitialAd == null && !C0705Ih.A0p(this.A0A)) {
            return;
        }
        this.A01 = interstitialAd;
    }

    public final void A0E(InterstitialAdListener interstitialAdListener) {
        this.A02 = interstitialAdListener;
    }

    public final void A0F(RewardData rewardData) {
        this.A03 = rewardData;
    }

    public final void A0G(RewardedAdListener rewardedAdListener) {
        this.A04 = rewardedAdListener;
    }

    public final void A0H(String str) {
        this.A05 = str;
    }

    public final void A0I(String str) {
        this.A06 = str;
    }

    public final void A0J(String str) {
        this.A07 = str;
    }

    public final void A0K(EnumSet<CacheFlag> flags) {
        this.A08 = flags;
    }
}
