package com.facebook.ads.redexgen.X;

import com.facebook.ads.AudienceNetworkAds;
/* renamed from: com.facebook.ads.redexgen.X.8X  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C8X implements AudienceNetworkAds.InitResult {
    public final String A00;
    public final boolean A01;

    public C8X(boolean z2, String str) {
        this.A01 = z2;
        this.A00 = str;
    }

    public final String getMessage() {
        return this.A00;
    }

    public final boolean isSuccess() {
        return this.A01;
    }
}
