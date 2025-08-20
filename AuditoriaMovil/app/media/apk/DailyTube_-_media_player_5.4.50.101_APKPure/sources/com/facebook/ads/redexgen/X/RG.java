package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public abstract class RG {
    public static boolean A00(View view) {
        return view.getBackground() == null || (Build.VERSION.SDK_INT >= 19 && view.getBackground().getAlpha() <= 0);
    }
}
