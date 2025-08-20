package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class SM extends AbstractC03704c<SK> {
    public final int A00;
    public final C1116Yn A01;
    public final View$OnClickListenerC0988Tl A02;
    public final List<String> A03;

    public SM(C1116Yn c1116Yn, List<String> screenshotUrls, int i, View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl) {
        this.A03 = screenshotUrls;
        this.A00 = i;
        this.A01 = c1116Yn;
        this.A02 = view$OnClickListenerC0988Tl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A02 */
    public final SK A0C(ViewGroup viewGroup, int i) {
        SL sl = new SL(this.A01);
        if (C0705Ih.A12(this.A01)) {
            sl.setOnClickListener(new Q6(this));
        }
        return new SK(sl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A03 */
    public final void A0D(SK sk, int i) {
        String str = this.A03.get(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int leftMargin = this.A00;
        int i5 = leftMargin * 4;
        if (i == 0) {
            leftMargin = i5;
        }
        marginLayoutParams.setMargins(leftMargin, 0, i >= A0E() + (-1) ? this.A00 * 4 : this.A00, 0);
        sk.A0j().setLayoutParams(marginLayoutParams);
        sk.A0j().A00(str);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    public final int A0E() {
        return this.A03.size();
    }
}
