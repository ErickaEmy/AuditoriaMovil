package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
/* renamed from: com.facebook.ads.redexgen.X.cH  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1282cH {
    public static C1282cH A02 = null;
    public final C1294cT A00;
    public final C1292cR A01;

    public C1282cH(AbstractC1298cY abstractC1298cY, C1292cR c1292cR, C1294cT c1294cT) {
        this.A00 = c1294cT;
        this.A01 = c1292cR;
        abstractC1298cY.A02(new H2(c1292cR));
    }

    public static C1282cH A00(AbstractC1298cY abstractC1298cY, InterfaceC1302cc interfaceC1302cc, HB hb) {
        C1282cH localsTestInstance = A02;
        if (localsTestInstance != null) {
            return localsTestInstance;
        }
        C1294cT c1294cT = new C1294cT();
        return new C1282cH(abstractC1298cY, new C1292cR(interfaceC1302cc, new HL(), hb, c1294cT, new Handler(Looper.getMainLooper())), c1294cT);
    }

    public final void A01(cX cXVar) {
        this.A01.A09(cXVar);
    }

    public final void A02(InterfaceC1296cV interfaceC1296cV) {
        this.A01.A0A(interfaceC1296cV);
    }

    public final void A03(InterfaceC1281cG interfaceC1281cG) {
        this.A00.A01(interfaceC1281cG);
    }

    public final void A04(InterfaceC1281cG interfaceC1281cG, C1300ca c1300ca) {
        this.A00.A02(interfaceC1281cG, c1300ca);
    }
}
