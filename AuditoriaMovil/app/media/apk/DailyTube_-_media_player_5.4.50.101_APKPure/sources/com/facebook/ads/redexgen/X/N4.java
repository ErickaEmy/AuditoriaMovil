package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class N4 implements View.OnClickListener {
    public final /* synthetic */ N6 A00;

    public N4(N6 n62) {
        this.A00 = n62;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC0811Mq interfaceC0811Mq;
        if (KL.A02(this)) {
            return;
        }
        try {
            interfaceC0811Mq = this.A00.A02;
            interfaceC0811Mq.A8P();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
