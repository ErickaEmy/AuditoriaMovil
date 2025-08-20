package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Oz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnTouchListenerC0872Oz implements View.OnTouchListener {
    public final /* synthetic */ B3 A00;

    public View$OnTouchListenerC0872Oz(B3 b3) {
        this.A00 = b3;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        P3 p3;
        p3 = this.A00.A0E;
        p3.dispatchTouchEvent(MotionEvent.obtain(motionEvent));
        return false;
    }
}
