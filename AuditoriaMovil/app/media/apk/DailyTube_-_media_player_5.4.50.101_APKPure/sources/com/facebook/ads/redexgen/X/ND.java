package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class ND implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                i = NJ.A0H;
                AbstractC0783Lo.A0M(view, i);
                break;
            case 1:
                AbstractC0783Lo.A0M(view, 0);
                break;
        }
        return false;
    }
}
