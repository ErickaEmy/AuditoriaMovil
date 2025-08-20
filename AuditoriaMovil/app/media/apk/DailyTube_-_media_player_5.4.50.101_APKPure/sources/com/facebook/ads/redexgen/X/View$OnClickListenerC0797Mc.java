package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Mc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0797Mc implements View.OnClickListener {
    public final /* synthetic */ UA A00;

    public View$OnClickListenerC0797Mc(UA ua2) {
        this.A00 = ua2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC0799Me interfaceC0799Me;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0799Me = this.A00.A07;
            interfaceC0799Me.ABX();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
