package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.RewardData;
import java.util.EnumSet;
/* loaded from: assets/audience_network.dex */
public final class FF extends AbstractC1188aa {
    public static String[] A02 = {"Wdifh5HSN4RyvogFUrIVqQJQULlKdEei", "S34yOHPbjBOZXrhEKXqsFwPvtnd1qciy", "vu9eRI", "x0OqZ", "VYF0eZRg0jpnLcLhIoRoBnoO3djZf6SI", "33GTCt01Ki3rQT8tpwoWMPFpMqFvVQrj", "pa13jV0ykdfTm6Oo414mEZE7qu5xzGka", "tj8XsVszyFe6dIsjKXzcwTwgC3z6jHVp"};
    public static final AnonymousClass27 A03 = new C1176aO();
    public C1181aT A00;
    public final AnonymousClass26 A01;

    public FF(AnonymousClass26 anonymousClass26, String str) {
        super(anonymousClass26.A05(), str, A03.A4h(anonymousClass26));
        this.A01 = anonymousClass26;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1188aa
    public final void A08() {
        C1181aT c1181aT = this.A00;
        if (c1181aT != null) {
            c1181aT.destroy();
        }
        AnonymousClass21 anonymousClass21 = super.A00;
        AnonymousClass20 anonymousClass20 = AnonymousClass20.A04;
        if (A02[1].charAt(8) == 'f') {
            throw new RuntimeException();
        }
        A02[4] = "bjBCaQy28rNQq0pISHtZZouKJ3cbndZJ";
        anonymousClass21.AFw(anonymousClass20);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1188aa
    public final void A09() {
        C1181aT c1181aT = new C1181aT(this.A01, this, A04());
        this.A00 = c1181aT;
        c1181aT.A0G(this.A01.A0B(), this.A01.A07());
    }

    public final void A0D(InterstitialAd interstitialAd, EnumSet<CacheFlag> cacheFlags, String str) {
        if (super.A00.A5d()) {
            return;
        }
        this.A01.A0D(interstitialAd);
        C1181aT c1181aT = this.A00;
        if (c1181aT != null) {
            c1181aT.A0G(cacheFlags, str);
            return;
        }
        this.A01.A0K(cacheFlags);
        this.A01.A0H(str);
        if (AbstractC0707Ik.A07(this.A02) && AbstractC0707Ik.A08(this.A02)) {
            A05();
        } else {
            A09();
        }
    }

    public final void A0E(RewardData rewardData) {
        this.A01.A0F(rewardData);
        if (super.A01.A01) {
            super.A01.A0F(1013, C2M.A00(new Bundle(), rewardData));
        }
    }

    public final boolean A0F() {
        C1181aT c1181aT = this.A00;
        if (c1181aT != null) {
            return c1181aT.A0H();
        }
        if (this.A01.A00() > 0) {
            int i = (C0774Lf.A00() > this.A01.A00() ? 1 : (C0774Lf.A00() == this.A01.A00() ? 0 : -1));
            if (A02[0].charAt(6) == 'y') {
                throw new RuntimeException();
            }
            A02[4] = "spPOKGUnJm6foAMMjUQWH3rPbfiGZlB3";
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0G() {
        C1181aT c1181aT = this.A00;
        if (c1181aT != null) {
            return c1181aT.A0I();
        }
        return super.A00.A5v() == AnonymousClass20.A06;
    }

    public final boolean A0H(InterstitialAd interstitialAd, InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        if (super.A00.A5e()) {
            return false;
        }
        this.A01.A0D(interstitialAd);
        if (super.A01.A01) {
            A0A(-1);
            return true;
        }
        C1181aT c1181aT = this.A00;
        if (c1181aT != null) {
            return c1181aT.A0J();
        }
        C1181aT c1181aT2 = new C1181aT(this.A01, this, A04());
        this.A00 = c1181aT2;
        c1181aT2.A0J();
        return false;
    }
}
