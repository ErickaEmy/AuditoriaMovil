package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Nz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0846Nz implements View.OnClickListener {
    public final /* synthetic */ O1 A00;

    public View$OnClickListenerC0846Nz(O1 o1) {
        this.A00 = o1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A04();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
