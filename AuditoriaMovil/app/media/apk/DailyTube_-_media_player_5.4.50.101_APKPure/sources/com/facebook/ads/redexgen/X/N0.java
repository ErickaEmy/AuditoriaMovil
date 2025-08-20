package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class N0 implements View.OnClickListener {
    public final /* synthetic */ C0813Ms A00;
    public final /* synthetic */ U5 A01;

    public N0(U5 u5, C0813Ms c0813Ms) {
        this.A01 = u5;
        this.A00 = c0813Ms;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0B.A9O();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
