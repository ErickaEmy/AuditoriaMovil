package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class QD implements View.OnTouchListener {
    public final /* synthetic */ SA A00;

    public QD(SA sa) {
        this.A00 = sa;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C04778r c04778r;
        c04778r = this.A00.A0B;
        c04778r.A02(new MY(view, motionEvent));
        return false;
    }
}
