package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: assets/audience_network.dex */
public abstract class OA {
    public static final int A00 = AbstractC0783Lo.A00();

    public static void A00(C1116Yn c1116Yn, ViewGroup viewGroup, String str) {
        new AsyncTaskC0993Tq(viewGroup, c1116Yn).A07(str);
        View view = new View(c1116Yn);
        view.setId(A00);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AbstractC0783Lo.A0R(view, c1116Yn);
        viewGroup.addView(view, 0);
    }
}
