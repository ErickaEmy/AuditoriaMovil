package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Oj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0856Oj implements View.OnClickListener {
    public final /* synthetic */ TT A00;

    public View$OnClickListenerC0856Oj(TT tt) {
        this.A00 = tt;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z2;
        boolean z3;
        AbstractC02730h abstractC02730h;
        AbstractC1219b5 abstractC1219b5;
        Handler handler;
        Runnable runnable;
        AbstractC1219b5 abstractC1219b52;
        if (KL.A02(this)) {
            return;
        }
        try {
            z2 = this.A00.A0O;
            if (!z2) {
                this.A00.A0P = true;
                TT tt = this.A00;
                abstractC02730h = tt.A0c;
                tt.A0d(((C0629Ff) abstractC02730h).A0G().toString());
                abstractC1219b5 = this.A00.A0G;
                if (abstractC1219b5.A0H() >= 0) {
                    handler = this.A00.A09;
                    runnable = this.A00.A0i;
                    abstractC1219b52 = this.A00.A0G;
                    handler.postDelayed(runnable, abstractC1219b52.A0H());
                }
            }
            TT tt2 = this.A00;
            z3 = tt2.A0O;
            tt2.A0g(z3 ? false : true);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
