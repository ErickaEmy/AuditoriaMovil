package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedAdListener;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.UUID;
/* renamed from: com.facebook.ads.redexgen.X.5e  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C03975e implements InterstitialAdApi, Repairable {
    public static byte[] A04;
    public static String[] A05 = {"S822El9zG6GuADGrtluuLX363osWhxiG", "ZFI3hp6NIHNPBZ8p7tKJKM6DxTur89gU", "rKe2xKovfMLHVnc2kJBHIfRtW7KI2joW", "CTsEdbmp9bu3ZhSS7yZH02ALmjP1FNtP", "mPYAOoIIU9PuPwOlU3lFT13mhy9mIxzC", "", "", "HqZNdyzgU2LJRhG9zHJvoyCPzWSUAGCn"};
    public final InterstitialAd A00;
    public final AnonymousClass26 A01;
    public final FF A02;
    public final C1116Yn A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = copyOfRange[i8] - i6;
            if (A05[0].charAt(22) != '3') {
                throw new RuntimeException();
            }
            A05[4] = "dLq0XFJawohP2A9uDPm8W8ZKhW9iXRhW";
            copyOfRange[i8] = (byte) (i10 - 126);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-32, -31, 17, 19, -31, -25, -29, -32, -71, -21, -26, -67, -66, -73, -24, -25, 37, 81, 32, 35, 40, 34, 81, 38, -49, -12, -6, -21, -8, -12, -25, -14, -90, -21, -8, -8, -11, -8, -76, -112, -29, 8, 14, -1, 12, 13, 14, 3, 14, 3, -5, 6, -70, -5, -2, -70, -2, -1, 13, 14, 12, 9, 19, -1, -2, -56, -19, -13, -28, -15, -14, -13, -24, -13, -24, -32, -21, -97, -32, -29, -97, -21, -18, -32, -29, -97, -15, -28, -16, -12, -28, -14, -13, -28, -29, -18, 19, 25, 10, 23, 24, 25, 14, 25, 14, 6, 17, -59, 6, 9, -59, 24, 13, 20, 28, -59, 8, 6, 17, 17, 10, 9, -10, -9, 5, 6, 4, 1, 11, -28, -17, -52, -17, -31, -28, -63, -28, 49, 38, 45, 53};
    }

    static {
        A01();
    }

    public C03975e(Context context, String str, InterstitialAd interstitialAd) {
        this.A00 = interstitialAd;
        String uuid = UUID.randomUUID().toString();
        C1116Yn A06 = C03955c.A06(context, uuid);
        this.A03 = A06;
        C0S A0E = A06.A0E();
        String adId = AdPlacementType.INTERSTITIAL.toString();
        A0E.A2s(adId, str);
        AnonymousClass26 anonymousClass26 = new AnonymousClass26(A06, interstitialAd, str);
        this.A01 = anonymousClass26;
        A06.A0L(this);
        this.A02 = new FF(anonymousClass26, uuid);
    }

    public final void A02(InterstitialAdListener interstitialAdListener) {
        this.A03.A0E().A2l(interstitialAdListener != null);
        this.A01.A0E(interstitialAdListener);
        if (A05[0].charAt(22) != '3') {
            throw new RuntimeException();
        }
        A05[4] = "rYQ6gTbtajntBm3fXVm84HcfyQ9ACN8J";
    }

    public final void A03(RewardData rewardData) {
        this.A02.A0E(rewardData);
    }

    public final void A04(RewardedAdListener rewardedAdListener) {
        this.A01.A0G(rewardedAdListener);
    }

    public final void A05(EnumSet<CacheFlag> enumSet, String str) {
        AbstractC0735Jp.A05(A00(129, 8, 2), A00(65, 30, 1), A00(16, 8, R.styleable.AppCompatTheme_toolbarStyle));
        if (str == null) {
            this.A03.A0E().A2p();
        } else {
            this.A03.A0E().A2o();
        }
        this.A02.A0D(this.A00, enumSet, str);
        this.A03.A0E().A2n();
    }

    public final InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return new C03985f(this);
    }

    public final InterstitialAd.InterstitialAdShowConfigBuilder buildShowAdConfig() {
        return new C03995g();
    }

    public final void destroy() {
        AbstractC0735Jp.A05(A00(122, 7, 20), A00(40, 25, 28), A00(0, 8, 49));
        if (C0705Ih.A1s(this.A03)) {
            return;
        }
        this.A02.A08();
        this.A03.A0E().A2t();
    }

    public final void finalize() {
        this.A02.A07();
    }

    public final String getPlacementId() {
        return this.A01.A0A();
    }

    public final boolean isAdInvalidated() {
        boolean A0F = this.A02.A0F();
        this.A03.A0E().A4s(A0F);
        return A0F;
    }

    public final boolean isAdLoaded() {
        return this.A02.A0G();
    }

    public final void loadAd() {
        A05(CacheFlag.ALL, null);
    }

    public final void loadAd(InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig) {
        ((C03985f) interstitialLoadAdConfig).A00();
    }

    public final void repair(Throwable th) {
        if (this.A01.A02() != null) {
            this.A01.A02().onError(this.A00, new AdError(2001, A00(24, 16, 8) + LW.A03(this.A03, th)));
        }
    }

    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A01.A0I(extraHints.getHints());
        this.A01.A0J(extraHints.getMediationData());
    }

    public final boolean show() {
        AbstractC0735Jp.A05(A00(137, 4, 64), A00(95, 27, 39), A00(8, 8, 7));
        this.A03.A0E().A2y();
        boolean A0H = this.A02.A0H(this.A00, new C03995g());
        this.A03.A0E().A2x(A0H);
        return A0H;
    }

    public final boolean show(InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        this.A03.A0E().A2y();
        boolean A0H = this.A02.A0H(this.A00, interstitialShowAdConfig);
        this.A03.A0E().A2x(A0H);
        return A0H;
    }
}
