package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Pb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0874Pb implements View.OnClickListener {
    public final /* synthetic */ C0974Sx A00;

    public View$OnClickListenerC0874Pb(C0974Sx c0974Sx) {
        this.A00 = c0974Sx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z2;
        boolean z3;
        AbstractC02730h abstractC02730h;
        Handler handler;
        Runnable runnable;
        if (KL.A02(this)) {
            return;
        }
        try {
            z2 = this.A00.A0K;
            if (!z2) {
                this.A00.A0L = true;
                C0974Sx c0974Sx = this.A00;
                abstractC02730h = c0974Sx.A0T;
                c0974Sx.A0h(((C0629Ff) abstractC02730h).A0G().toString());
                if (((PQ) this.A00).A05.A0H() >= 0) {
                    handler = this.A00.A08;
                    runnable = this.A00.A0j;
                    handler.postDelayed(runnable, ((PQ) this.A00).A05.A0H());
                }
            }
            C0974Sx c0974Sx2 = this.A00;
            z3 = c0974Sx2.A0K;
            c0974Sx2.A0k(z3 ? false : true);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
