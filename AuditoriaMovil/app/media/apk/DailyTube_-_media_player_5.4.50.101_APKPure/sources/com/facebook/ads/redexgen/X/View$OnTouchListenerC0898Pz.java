package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Pz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnTouchListenerC0898Pz implements View.OnTouchListener {
    public final /* synthetic */ Q0 A00;

    public View$OnTouchListenerC0898Pz(Q0 q0) {
        this.A00 = q0;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        J2 j2;
        AbstractC1219b5 abstractC1219b5;
        if (motionEvent.getAction() == 1) {
            this.A00.A01 = System.currentTimeMillis();
            Q0.A00(this.A00);
            j2 = this.A00.A06;
            abstractC1219b5 = this.A00.A03;
            j2.A9u(abstractC1219b5.A12(), new C0829Ni().A03(this.A00.getViewabilityChecker()).A02(this.A00.getTouchDataRecorder()).A05());
            return false;
        }
        return false;
    }
}
