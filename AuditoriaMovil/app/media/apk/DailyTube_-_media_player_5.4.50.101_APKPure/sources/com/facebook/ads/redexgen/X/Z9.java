package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* loaded from: assets/audience_network.dex */
public class Z9 implements InterfaceC04075o {
    public final /* synthetic */ ImageView A00;
    public final /* synthetic */ C04095q A01;
    public final /* synthetic */ V2 A02;

    public Z9(C04095q c04095q, ImageView imageView, V2 v2) {
        this.A01 = c04095q;
        this.A00 = imageView;
        this.A02 = v2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04075o
    public final void ABi(Drawable drawable) {
        V2.A0e(drawable, this.A00);
        this.A02.A1J(drawable);
    }
}
