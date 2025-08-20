package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
/* loaded from: assets/audience_network.dex */
public class U3 implements NT {
    public final /* synthetic */ NJ A00;

    public U3(NJ nj2) {
        this.A00 = nj2;
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final void AAv(boolean z2) {
        boolean z3;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        z3 = this.A00.A08;
        if (z3) {
            imageView = this.A00.A00;
            if (imageView != null) {
                imageView2 = this.A00.A00;
                imageView2.setEnabled(z2);
                imageView3 = this.A00.A00;
                imageView3.setAlpha(z2 ? 1.0f : 0.3f);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final void ABZ(boolean z2) {
        boolean z3;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        z3 = this.A00.A08;
        if (z3) {
            imageView = this.A00.A02;
            if (imageView != null) {
                imageView2 = this.A00.A02;
                imageView2.setEnabled(z2);
                imageView3 = this.A00.A02;
                imageView3.setAlpha(z2 ? 1.0f : 0.3f);
            }
        }
    }
}
