package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Mk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0805Mk implements View.OnClickListener {
    public final /* synthetic */ C0808Mn A00;

    public View$OnClickListenerC0805Mk(C0808Mn c0808Mn) {
        this.A00 = c0808Mn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z2;
        InterfaceC0811Mq interfaceC0811Mq;
        InterfaceC0811Mq interfaceC0811Mq2;
        if (KL.A02(this)) {
            return;
        }
        try {
            z2 = this.A00.A05;
            if (z2) {
                interfaceC0811Mq2 = this.A00.A04;
                interfaceC0811Mq2.A4L();
                return;
            }
            interfaceC0811Mq = this.A00.A04;
            interfaceC0811Mq.A4M();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
