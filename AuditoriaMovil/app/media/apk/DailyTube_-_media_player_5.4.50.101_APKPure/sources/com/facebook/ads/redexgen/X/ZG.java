package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
/* loaded from: assets/audience_network.dex */
public class ZG extends C03935a implements NativeAdLayoutApi {
    public View A02;
    public NativeAdLayout A03;
    public int A01 = 0;
    public int A00 = 0;

    public final void A02() {
        AbstractC0783Lo.A0T(this.A03);
        this.A03.removeView(this.A02);
        this.A02 = null;
    }

    public final void A03(AbstractC0809Mo abstractC0809Mo) {
        this.A02 = abstractC0809Mo;
        abstractC0809Mo.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AbstractC0783Lo.A0T(this.A03);
        this.A03.addView(this.A02);
    }

    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    public final void initialize(NativeAdLayout nativeAdLayout) {
        this.A03 = nativeAdLayout;
    }

    @Override // com.facebook.ads.redexgen.X.C03935a
    public final void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        if (this.A00 > 0) {
            int measuredWidth = this.A03.getMeasuredWidth();
            int i6 = this.A00;
            if (measuredWidth > i6) {
                setMeasuredDimension(i6, this.A03.getMeasuredHeight());
                return;
            }
        }
        int measuredWidth2 = this.A03.getMeasuredWidth();
        int i8 = this.A01;
        if (measuredWidth2 >= i8) {
            return;
        }
        setMeasuredDimension(i8, this.A03.getMeasuredHeight());
    }

    public final void setMaxWidth(int i) {
        this.A00 = i;
    }

    public final void setMinWidth(int i) {
        this.A01 = i;
    }
}
