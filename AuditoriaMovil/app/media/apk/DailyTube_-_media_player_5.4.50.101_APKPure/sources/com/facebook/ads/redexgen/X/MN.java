package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.api.AdNativeComponentView;
/* loaded from: assets/audience_network.dex */
public final class MN extends AdNativeComponentView {
    public static final int A01 = (int) (LD.A02 * 1.0f);
    public final ImageView A00;

    public MN(C1116Yn c1116Yn) {
        super(c1116Yn);
        MZ mz = new MZ(c1116Yn);
        this.A00 = mz;
        mz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LI.A04(mz, LI.A0A);
        addView(mz, new ViewGroup.LayoutParams(-1, -1));
        AbstractC0783Lo.A0M(mz, -2130706433);
        int i = A01;
        setPadding(i, i, i, i);
    }

    public View getAdContentsView() {
        return this.A00;
    }

    public ImageView getImageCardView() {
        return this.A00;
    }
}
