package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.AdSettings;
/* renamed from: com.facebook.ads.redexgen.X.aZ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1187aZ implements C8Z {
    @Override // com.facebook.ads.redexgen.X.C8Z
    public final String A6E() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C8Z
    public final String A6S() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C8Z
    public final C04547t A6k(C04447f c04447f) {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C8Z
    public final String A7Q() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C8Z
    public final String A87() {
        if (AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT) {
            return AdSettings.getTestAdType().getAdTypeString();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C8Z
    public final boolean A99() {
        return AdSettings.isMixedAudience();
    }

    @Override // com.facebook.ads.redexgen.X.C8Z
    public final boolean A9E() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C8Z
    public final Boolean A9J() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C8Z
    public final boolean isTestMode(Context context) {
        return AdSettings.isTestMode(context);
    }
}
