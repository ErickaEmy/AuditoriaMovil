package com.facebook.ads.redexgen.X;

import android.os.Trace;
/* loaded from: assets/audience_network.dex */
public abstract class IC {
    public static void A00() {
        if (IF.A02 >= 18) {
            A01();
        }
    }

    public static void A01() {
        Trace.endSection();
    }

    public static void A02(String str) {
        if (IF.A02 >= 18) {
            A03(str);
        }
    }

    public static void A03(String str) {
        Trace.beginSection(str);
    }
}
