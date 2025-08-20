package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class FW extends AbstractC1220b6 {
    public final C1116Yn A00;

    public FW(C3C c3c, List<V2> list, C1116Yn c1116Yn) {
        super(c3c, list, c1116Yn);
        this.A00 = c1116Yn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A01 */
    public final UR A0C(ViewGroup viewGroup, int i) {
        return new UR(new MN(this.A00));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.facebook.ads.redexgen.X.MN, com.facebook.ads.internal.api.AdNativeComponentView, android.view.View] */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A0H */
    public final void A0D(UR ur2, int i) {
        super.A0H(ur2, i);
        ?? r3 = (MN) ur2.A0j();
        MZ imageView = (MZ) r3.getImageCardView();
        imageView.setImageDrawable(null);
        A0F(imageView, i);
        V2 childAd = ((AbstractC1220b6) this).A01.get(i);
        childAd.A11().A0K(this.A00);
        childAd.A1N(r3, r3);
    }
}
