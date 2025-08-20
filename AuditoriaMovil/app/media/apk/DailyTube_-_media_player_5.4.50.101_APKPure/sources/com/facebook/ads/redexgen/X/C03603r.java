package com.facebook.ads.redexgen.X;

import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.3r  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C03603r extends C0599Eb {
    public C03603r(C1116Yn c1116Yn) {
        super(c1116Yn);
        setCarouselLayoutManager(c1116Yn);
    }

    public AbstractC0951Sa getFullscreenCarouselRecyclerViewAdapter() {
        getAdapter();
        if (0 != 0) {
            getAdapter();
            return null;
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C0599Eb
    public C1142Zo getLayoutManager() {
        return (C1142Zo) super.getLayoutManager();
    }

    public AbstractC03874t getOnScrollListener() {
        return new US(this);
    }

    private void setCarouselLayoutManager(C1116Yn c1116Yn) {
        C1142Zo c1142Zo = new C1142Zo(c1116Yn, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            c1142Zo.A1R(true);
        }
        super.setLayoutManager(c1142Zo);
    }

    @Override // com.facebook.ads.redexgen.X.C0599Eb
    public void setLayoutManager(AbstractC03824o abstractC03824o) {
    }
}
