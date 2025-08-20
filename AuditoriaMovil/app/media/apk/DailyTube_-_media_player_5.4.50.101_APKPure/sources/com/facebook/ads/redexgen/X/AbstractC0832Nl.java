package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Nl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0832Nl {
    public static void A00(View view, boolean z2, View.OnClickListener onClickListener) {
        if (!z2) {
            view.setOnClickListener(onClickListener);
        } else if (!z2) {
        } else {
            View$OnClickListenerC0831Nk view$OnClickListenerC0831Nk = new View$OnClickListenerC0831Nk(onClickListener);
            view.setOnClickListener(view$OnClickListenerC0831Nk);
            view.setOnTouchListener(new View$OnTouchListenerC0830Nj(view$OnClickListenerC0831Nk));
        }
    }
}
