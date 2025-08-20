package com.facebook.ads.redexgen.X;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public abstract class HT implements S1 {
    public final EnumC0944Rt A00;
    public final AnonymousClass74 A01;

    public HT(AnonymousClass74 anonymousClass74, EnumC0944Rt enumC0944Rt) {
        this.A01 = anonymousClass74;
        this.A00 = enumC0944Rt;
    }

    @Override // com.facebook.ads.redexgen.X.S1
    public void A3Z(Map<InterfaceC0934Rj, S6> map, Map<SyncModifiableBundle, EnumC0944Rt> map2) {
        map2.put(null, this.A00);
    }
}
