package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class N5 implements View.OnClickListener {
    public final /* synthetic */ C2W A00;
    public final /* synthetic */ C0813Ms A01;
    public final /* synthetic */ N6 A02;

    public N5(N6 n62, C0813Ms c0813Ms, C2W c2w) {
        this.A02 = n62;
        this.A01 = c0813Ms;
        this.A00 = c2w;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC0811Mq interfaceC0811Mq;
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            interfaceC0811Mq = this.A02.A02;
            interfaceC0811Mq.ACS(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
