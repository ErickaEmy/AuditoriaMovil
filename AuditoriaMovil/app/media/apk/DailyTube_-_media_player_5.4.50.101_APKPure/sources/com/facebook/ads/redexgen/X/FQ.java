package com.facebook.ads.redexgen.X;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;
/* loaded from: assets/audience_network.dex */
public final class FQ extends AbstractC1200am {
    public static String[] A00 = {"Ze8NKKgwBfy46YDq5I0lzRS5nG7yrU8J", "E1ojaS3uTXsRavQORrTdUhX9c7MV5aHd", "ItCt9Q9mXWs9PIywah58uBD5YWxogfVc", "TvzxiXVOv8ol3X69Q34742hsr7pKLonV", "WogP6aaFjSX27EG5W88ejxN6ir7ZffIG", "o9NxBVrFd1YzPTzVCo2rgQ7Rf3HS8hqa", "2XopQN6Gw1", "j82AvX7B8A16DzVk8Gq1uvpNrrFgPLHx"};

    public FQ(C1116Yn c1116Yn, C03111u c03111u) {
        super(c1116Yn, c03111u);
    }

    private C1198ak A00(Runnable runnable) {
        return new C1198ak(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final C1F A0G() {
        C1236bM successfullyLoadedAdapter = (C1236bM) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final void A0M() {
        C1236bM interstitialAdapter = (C1236bM) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final void A0O(InterfaceC02800p interfaceC02800p, C8S c8s, C8Q c8q, C03121v c03121v) {
        C1236bM c1236bM = (C1236bM) interfaceC02800p;
        C1199al c1199al = new C1199al(this, c03121v, c1236bM);
        A0F().postDelayed(c1199al, c8s.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A07.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
            if (A00[7].charAt(1) == 'D') {
                throw new RuntimeException();
            }
            A00[5] = "sZ24rCHUkfT3uSPodHZqWzeJet0EqBqU";
        }
        c1236bM.A0A(this.A0B, A00(c1199al), c03121v, enumSet, this.A07.A04, this.A07.A05, this.A07.A02);
    }
}
