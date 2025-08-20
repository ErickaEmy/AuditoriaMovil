package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.5U  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C5U implements View.OnLongClickListener {
    public final /* synthetic */ C5V A00;

    public C5U(C5V c5v) {
        this.A00 = c5v;
    }

    public /* synthetic */ C5U(C5V c5v, C5R c5r) {
        this(c5v);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (C5V.A03(this.A00) != null && C5V.A01(this.A00) != null) {
            C5V.A03(this.A00).setBounds(0, 0, C5V.A01(this.A00).getWidth(), C5V.A01(this.A00).getHeight());
            C5V.A03(this.A00).A0D(!C5V.A03(this.A00).A0E());
        }
        return true;
    }
}
