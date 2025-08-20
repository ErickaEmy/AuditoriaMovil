package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class FX extends AbstractC1220b6 {
    public final C1116Yn A00;
    public final JR A01;

    public FX(C1116Yn c1116Yn, C3C c3c, List<V2> list, JR jr) {
        super(c3c, list, c1116Yn);
        this.A00 = c1116Yn;
        this.A01 = jr == null ? new JR() : jr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A01 */
    public final UR A0C(ViewGroup viewGroup, int i) {
        return new UR(new MI(this.A00, this.A01));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.facebook.ads.internal.api.AdNativeComponentView, com.facebook.ads.redexgen.X.MI, android.view.View, java.lang.Object] */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A0H */
    public final void A0D(UR ur2, int i) {
        super.A0H(ur2, i);
        ?? r2 = (MI) ur2.A0j();
        A0F(r2.getImageCardView(), i);
        if (((AbstractC1220b6) this).A01.get(i) != null) {
            r2.setTitle(((AbstractC1220b6) this).A01.get(i).getAdHeadline());
            r2.setSubtitle(((AbstractC1220b6) this).A01.get(i).getAdLinkDescription());
            r2.setButtonText(((AbstractC1220b6) this).A01.get(i).getAdCallToAction());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(r2);
        ((AbstractC1220b6) this).A01.get(i).A1O(r2, r2, arrayList);
    }
}
