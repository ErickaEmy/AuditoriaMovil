package com.facebook.ads.redexgen.X;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public abstract class HN implements S1 {
    public final C0694Hw A00;
    public final S6 A01;

    public HN(C0694Hw c0694Hw, S6 s62) {
        this.A00 = c0694Hw;
        this.A01 = s62;
    }

    @Override // com.facebook.ads.redexgen.X.S1
    public void A3Z(Map<InterfaceC0934Rj, S6> map, Map<SyncModifiableBundle, EnumC0944Rt> map2) {
        map.put(this.A00, this.A01);
    }
}
