package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
/* renamed from: com.facebook.ads.redexgen.X.aC  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1164aC implements C2Y {
    public final SharedPreferences A00;

    public C1164aC(SharedPreferences sharedPreferences) {
        this.A00 = sharedPreferences;
    }

    @Override // com.facebook.ads.redexgen.X.C2Y
    public final C1165aD A5S() {
        return new C1165aD(this.A00.edit());
    }

    @Override // com.facebook.ads.redexgen.X.C2Y
    public final long A7K(String str, long j2) {
        return this.A00.getLong(str, j2);
    }

    @Override // com.facebook.ads.redexgen.X.C2Y
    public final String A85(String str, String str2) {
        return this.A00.getString(str, str2);
    }
}
