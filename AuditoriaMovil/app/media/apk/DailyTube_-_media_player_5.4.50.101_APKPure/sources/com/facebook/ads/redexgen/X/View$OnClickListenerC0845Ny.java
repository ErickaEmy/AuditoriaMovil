package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Ny  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0845Ny implements View.OnClickListener {
    public final /* synthetic */ O1 A00;

    public View$OnClickListenerC0845Ny(O1 o1) {
        this.A00 = o1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        O0 o02;
        MB mb;
        View[] viewArr;
        SA sa;
        SA sa2;
        SA sa3;
        MB mb2;
        if (KL.A02(this)) {
            return;
        }
        try {
            o02 = this.A00.A04;
            o02.ACB();
            mb = this.A00.A00;
            if (mb != null) {
                mb2 = this.A00.A00;
                AbstractC0783Lo.A0L(mb2);
            }
            viewArr = this.A00.A06;
            for (View view2 : viewArr) {
                AbstractC0783Lo.A0N(view2, 0);
            }
            AbstractC0783Lo.A0J(this.A00);
            sa = this.A00.A05;
            if (sa == null) {
                return;
            }
            sa2 = this.A00.A05;
            AbstractC0783Lo.A0N(sa2, 0);
            sa3 = this.A00.A05;
            sa3.A0b(QM.A02, 14);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
