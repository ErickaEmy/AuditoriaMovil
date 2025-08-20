package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;
/* renamed from: com.facebook.ads.redexgen.X.0u  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02850u {
    public static InterfaceC02800p A00;

    public final InterfaceC02800p A00(C1116Yn c1116Yn, AdPlacementType adPlacementType) {
        InterfaceC02800p interfaceC02800p = A00;
        if (interfaceC02800p != null) {
            return interfaceC02800p;
        }
        switch (C02840t.A00[adPlacementType.ordinal()]) {
            case 1:
                return new C1237bN();
            case 2:
                return new C1236bM();
            case 3:
                return new C1234bK(c1116Yn);
            case 4:
                return new C0625Fb(c1116Yn);
            case 5:
                return new FY();
            default:
                return null;
        }
    }
}
