package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class OH implements View.OnClickListener {
    public final /* synthetic */ View$OnClickListenerC0988Tl A00;
    public final /* synthetic */ String A01;

    public OH(View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl, String str) {
        this.A00 = view$OnClickListenerC0988Tl;
        this.A01 = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A09(this.A01);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
