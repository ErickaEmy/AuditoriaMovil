package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Ml  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0806Ml implements View.OnClickListener {
    public final /* synthetic */ C0808Mn A00;

    public View$OnClickListenerC0806Ml(C0808Mn c0808Mn) {
        this.A00 = c0808Mn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC0811Mq interfaceC0811Mq;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0811Mq = this.A00.A04;
            interfaceC0811Mq.A9N();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
