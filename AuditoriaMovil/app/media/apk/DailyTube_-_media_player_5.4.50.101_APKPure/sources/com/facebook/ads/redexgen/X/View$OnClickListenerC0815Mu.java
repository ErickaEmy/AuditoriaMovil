package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Mu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0815Mu implements View.OnClickListener {
    public final /* synthetic */ U6 A00;

    public View$OnClickListenerC0815Mu(U6 u62) {
        this.A00 = u62;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0B.ACI(C2U.A03);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
