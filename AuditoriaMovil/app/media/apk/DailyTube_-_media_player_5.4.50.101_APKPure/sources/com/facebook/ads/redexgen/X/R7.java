package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
/* loaded from: assets/audience_network.dex */
public class R7 implements View.OnTouchListener {
    public final /* synthetic */ TextureView$SurfaceTextureListenerC0740Ju A00;

    public R7(TextureView$SurfaceTextureListenerC0740Ju textureView$SurfaceTextureListenerC0740Ju) {
        this.A00 = textureView$SurfaceTextureListenerC0740Ju;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        MediaController mediaController;
        MediaController mediaController2;
        MediaController mediaController3;
        MediaController mediaController4;
        z2 = this.A00.A0G;
        if (z2) {
            return true;
        }
        mediaController = this.A00.A0A;
        if (mediaController != null && motionEvent.getAction() == 1) {
            mediaController2 = this.A00.A0A;
            if (mediaController2.isShowing()) {
                mediaController4 = this.A00.A0A;
                mediaController4.hide();
            } else {
                mediaController3 = this.A00.A0A;
                mediaController3.show();
            }
        }
        return true;
    }
}
