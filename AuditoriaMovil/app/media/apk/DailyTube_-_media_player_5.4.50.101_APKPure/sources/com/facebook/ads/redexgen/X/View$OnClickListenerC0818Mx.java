package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Mx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0818Mx implements View.OnClickListener {
    public final /* synthetic */ U5 A00;

    public View$OnClickListenerC0818Mx(U5 u5) {
        this.A00 = u5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.A8P();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
