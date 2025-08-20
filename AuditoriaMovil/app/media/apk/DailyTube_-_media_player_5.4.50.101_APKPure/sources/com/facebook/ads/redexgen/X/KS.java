package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public abstract class KS extends RelativeLayout {
    public static final AtomicBoolean A00 = new AtomicBoolean();
    public static final AtomicReference<KJ> A01 = new AtomicReference<>();

    public static void A00(boolean z2, KJ kj) {
        A00.set(z2);
        A01.set(kj);
    }
}
