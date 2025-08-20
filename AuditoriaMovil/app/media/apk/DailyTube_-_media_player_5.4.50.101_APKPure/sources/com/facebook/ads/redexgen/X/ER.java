package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
/* loaded from: assets/audience_network.dex */
public final class ER extends ZG {
    public QB A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A04(NativeAdLayout nativeAdLayout, C1116Yn c1116Yn, NativeAd nativeAd, JR jr) {
        O3 o3 = new O3(c1116Yn);
        MediaView mediaView = new MediaView(c1116Yn);
        AdOptionsView adOptionsView = new AdOptionsView(c1116Yn, nativeAd, nativeAdLayout);
        jr.A09(adOptionsView, 28);
        this.A00 = new SH(c1116Yn, nativeAd, jr, V2.A0L(nativeAd.getInternalNativeAd()).A17(), o3, mediaView, adOptionsView);
        AbstractC0783Lo.A0M(nativeAdLayout, jr.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, o3, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.C03935a
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
