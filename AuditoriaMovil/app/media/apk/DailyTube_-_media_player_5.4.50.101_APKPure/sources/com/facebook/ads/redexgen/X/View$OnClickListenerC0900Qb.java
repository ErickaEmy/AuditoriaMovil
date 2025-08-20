package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Qb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0900Qb implements View.OnClickListener {
    public final /* synthetic */ C0765Kw A00;

    public View$OnClickListenerC0900Qb(C0765Kw c0765Kw) {
        this.A00 = c0765Kw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JA ja;
        C1116Yn c1116Yn;
        SA sa;
        boolean A07;
        SA sa2;
        SA sa3;
        if (KL.A02(this)) {
            return;
        }
        try {
            ja = this.A00.A03;
            ja.A04(J9.A0d, null);
            c1116Yn = this.A00.A02;
            c1116Yn.A0E().A3B();
            sa = this.A00.A00;
            if (sa != null) {
                A07 = this.A00.A07();
                if (A07) {
                    sa3 = this.A00.A00;
                    sa3.setVolume(1.0f);
                } else {
                    sa2 = this.A00.A00;
                    sa2.setVolume(0.0f);
                }
                this.A00.A09();
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
