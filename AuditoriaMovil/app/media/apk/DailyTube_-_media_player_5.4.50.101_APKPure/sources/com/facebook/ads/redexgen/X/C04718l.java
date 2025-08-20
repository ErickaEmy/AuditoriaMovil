package com.facebook.ads.redexgen.X;

import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.8l  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04718l {
    public static C04718l A00 = new C04718l();

    public static C04718l A00() {
        return A00;
    }

    public final YI A01(C04447f c04447f, boolean z2) {
        return new YI(c04447f, z2, new C6S());
    }

    public final Map<String, String> A02(C04447f c04447f) {
        try {
            return A01(c04447f, false).A05();
        } catch (Throwable th) {
            c04447f.A07().A3c(th);
            return C04638d.A01(c04447f);
        }
    }
}
