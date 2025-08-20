package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
/* renamed from: com.facebook.ads.redexgen.X.Vd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1031Vd implements InterfaceC0675Hd {
    @Override // com.facebook.ads.redexgen.X.InterfaceC0675Hd
    public final C1030Vc A4c(Looper looper, Handler.Callback callback) {
        return new C1030Vc(new Handler(looper, callback));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0675Hd
    public final long A5T() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0675Hd
    public final long AGs() {
        return SystemClock.uptimeMillis();
    }
}
