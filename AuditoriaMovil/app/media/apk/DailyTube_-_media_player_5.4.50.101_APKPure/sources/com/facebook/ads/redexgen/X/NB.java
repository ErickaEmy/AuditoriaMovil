package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NB implements View.OnClickListener {
    public final /* synthetic */ U4 A00;

    public NB(U4 u42) {
        this.A00 = u42;
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
