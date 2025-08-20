package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class PW implements View.OnTouchListener {
    public final /* synthetic */ C0974Sx A00;

    public PW(C0974Sx c0974Sx) {
        this.A00 = c0974Sx;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float f4;
        int action = motionEvent.getActionMasked();
        switch (action) {
            case 0:
                this.A00.A00 = motionEvent.getY();
                return true;
            case 1:
                float browserFinalY = motionEvent.getY();
                f4 = this.A00.A00;
                int action2 = (f4 > browserFinalY ? 1 : (f4 == browserFinalY ? 0 : -1));
                if (action2 >= 0) {
                    return true;
                }
                this.A00.A0k(false);
                return true;
            default:
                return true;
        }
    }
}
