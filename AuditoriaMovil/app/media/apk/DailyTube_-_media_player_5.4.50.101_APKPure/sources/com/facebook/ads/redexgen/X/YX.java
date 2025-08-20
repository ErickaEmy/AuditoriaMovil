package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class YX implements KJ {
    @Override // com.facebook.ads.redexgen.X.KJ
    public final void AFC(Throwable th, Object obj) {
        if (obj instanceof InterfaceC04407b) {
            C1116Yn adContext = ((InterfaceC04407b) obj).A5t();
            if (adContext != null) {
                adContext.A0O(th);
            }
        } else if (!(obj instanceof View)) {
        } else {
            Context context = ((View) obj).getContext();
            if (!(context instanceof C1116Yn)) {
                return;
            }
            ((C1116Yn) context).A0O(th);
        }
    }
}
