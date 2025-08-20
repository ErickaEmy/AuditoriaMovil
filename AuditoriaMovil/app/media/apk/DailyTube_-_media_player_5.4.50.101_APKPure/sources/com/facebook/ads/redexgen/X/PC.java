package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public abstract class PC {
    public static final Map<String, WeakReference<PB>> A00 = new HashMap();

    public static int A00() {
        return A00.size();
    }

    public static PB A01(C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5, int i, P9 p9) {
        PB pb = new PB(c1116Yn, abstractC1219b5, c1116Yn.A01().A09(), i);
        pb.A0b(p9);
        pb.A0X();
        A00.put(abstractC1219b5.A0S(), new WeakReference<>(pb));
        return pb;
    }

    public static PB A02(String str) {
        WeakReference<PB> weakReference = A00.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC1219b5 abstractC1219b5, PB pb) {
        A00.put(abstractC1219b5.A0S(), new WeakReference<>(pb));
    }

    public static void A04(String str) {
        A00.remove(str);
    }
}
