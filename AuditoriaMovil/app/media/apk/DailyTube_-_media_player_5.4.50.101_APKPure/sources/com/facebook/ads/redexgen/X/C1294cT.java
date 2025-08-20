package com.facebook.ads.redexgen.X;

import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
/* renamed from: com.facebook.ads.redexgen.X.cT  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1294cT {
    public final Map<InterfaceC1281cG, C1300ca> A00 = new WeakHashMap();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized C1300ca A00(InterfaceC1281cG interfaceC1281cG) {
        C1300ca c1300ca = this.A00.get(interfaceC1281cG);
        if (c1300ca == null) {
            return C1300ca.A08;
        }
        return c1300ca;
    }

    public final synchronized void A01(InterfaceC1281cG interfaceC1281cG) {
        this.A00.remove(interfaceC1281cG);
    }

    public final synchronized void A02(InterfaceC1281cG interfaceC1281cG, C1300ca c1300ca) {
        this.A00.put(interfaceC1281cG, c1300ca);
    }

    public final synchronized void A03(Collection<InterfaceC1281cG> collection) {
        for (InterfaceC1281cG interfaceC1281cG : this.A00.keySet()) {
            collection.add(interfaceC1281cG);
        }
    }
}
