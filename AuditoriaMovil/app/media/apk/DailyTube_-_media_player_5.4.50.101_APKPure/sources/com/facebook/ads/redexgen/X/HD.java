package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: assets/audience_network.dex */
public class HD implements InterfaceC1296cV {
    public final /* synthetic */ C1295cU A00;

    public HD(C1295cU c1295cU) {
        this.A00 = c1295cU;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1296cV
    public final void AD2() {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        ArrayList<Runnable> arrayList;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        InterfaceC1296cV interfaceC1296cV;
        InterfaceC1296cV interfaceC1296cV2;
        linkedHashMap = this.A00.A05;
        synchronized (linkedHashMap) {
            linkedHashMap2 = this.A00.A05;
            arrayList = new ArrayList(linkedHashMap2.size());
            linkedHashMap3 = this.A00.A05;
            for (Runnable runnable : linkedHashMap3.values()) {
                if (runnable != null) {
                    arrayList.add(runnable);
                }
            }
            linkedHashMap4 = this.A00.A05;
            linkedHashMap4.clear();
        }
        for (Runnable runnable2 : arrayList) {
            runnable2.run();
        }
        interfaceC1296cV = this.A00.A00;
        if (interfaceC1296cV == null) {
            return;
        }
        interfaceC1296cV2 = this.A00.A00;
        interfaceC1296cV2.AD2();
    }
}
