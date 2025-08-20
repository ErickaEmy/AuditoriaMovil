package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Zg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1134Zg implements AnonymousClass59 {
    public final /* synthetic */ AbstractC03824o A00;

    public C1134Zg(AbstractC03824o abstractC03824o) {
        this.A00 = abstractC03824o;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final View A6M(int i) {
        return this.A00.A0t(i);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final int A6O(View view) {
        return this.A00.A0n(view) + ((C03834p) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final int A6P(View view) {
        return this.A00.A0k(view) - ((C03834p) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final int A7a() {
        return this.A00.A0h() - this.A00.A0f();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final int A7b() {
        return this.A00.A0e();
    }
}
