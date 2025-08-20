package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.b6  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1220b6 extends AbstractC03704c<UR> {
    public static final int A05 = (int) (LD.A02 * 4.0f);
    public C1B A00;
    public final List<V2> A01;
    public final int A02;
    public final C1116Yn A03;
    public final RD A04 = new C1222b8(this);

    public AbstractC1220b6(C3C c3c, List<V2> list, C1116Yn c1116Yn) {
        this.A03 = c1116Yn;
        this.A02 = c3c.getChildSpacing();
        this.A01 = list;
    }

    private ViewGroup.MarginLayoutParams A02(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i5 = this.A02;
        if (i == 0) {
            i5 *= 2;
        }
        marginLayoutParams.setMargins(i5, 0, i >= this.A01.size() + (-1) ? this.A02 * 2 : this.A02, 0);
        return marginLayoutParams;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    public final int A0E() {
        return this.A01.size();
    }

    public final void A0F(ImageView imageView, int i) {
        V2 v2 = this.A01.get(i);
        JP adCoverImage = v2.getAdCoverImage();
        if (adCoverImage != null) {
            AsyncTaskC0993Tq A04 = new AsyncTaskC0993Tq(imageView, this.A03).A04();
            A04.A06(new C1221b7(this, i, v2));
            A04.A07(adCoverImage.getUrl());
        }
    }

    public final void A0G(C1B c1b) {
        this.A00 = c1b;
    }

    public void A0H(UR ur2, int i) {
        ur2.A0j().setLayoutParams(A02(i));
    }
}
