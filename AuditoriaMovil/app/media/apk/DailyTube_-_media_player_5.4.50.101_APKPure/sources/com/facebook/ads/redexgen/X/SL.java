package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: assets/audience_network.dex */
public final class SL extends O4 {
    public final ImageView A00;
    public final C1116Yn A01;

    public SL(C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A01 = c1116Yn;
        ImageView imageView = new ImageView(c1116Yn);
        this.A00 = imageView;
        imageView.setAdjustViewBounds(true);
        addView(imageView, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final void A00(String str) {
        AsyncTaskC0993Tq downloadImageTask = new AsyncTaskC0993Tq(this.A00, this.A01);
        downloadImageTask.A04();
        downloadImageTask.A07(str);
    }
}
