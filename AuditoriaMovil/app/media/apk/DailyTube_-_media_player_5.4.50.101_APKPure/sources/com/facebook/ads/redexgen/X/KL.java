package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public abstract class KL {
    public static final Set<Object> A00 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicBoolean A01 = new AtomicBoolean(true);
    public static final AtomicReference<KJ> A02 = new AtomicReference<>();

    public static void A00(Throwable th, Object obj) throws Throwable {
        if (A01.get()) {
            A00.add(obj);
            AbstractC0746Ka.A00().A9S(3306, th);
            KJ contextRepairHelper = A02.get();
            if (contextRepairHelper != null) {
                contextRepairHelper.AFC(th, obj);
                return;
            }
            return;
        }
        throw th;
    }

    public static void A01(boolean z2, KJ kj) {
        A01.set(z2);
        A02.set(kj);
    }

    public static boolean A02(Object obj) {
        return A00.contains(obj);
    }
}
