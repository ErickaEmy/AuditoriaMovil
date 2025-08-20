package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Pq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0889Pq implements View.OnClickListener {
    public final /* synthetic */ C0890Pr A00;

    public View$OnClickListenerC0889Pq(C0890Pr c0890Pr) {
        this.A00 = c0890Pr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C7C c7c;
        if (KL.A02(this)) {
            return;
        }
        try {
            c7c = this.A00.A05;
            c7c.performClick();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
