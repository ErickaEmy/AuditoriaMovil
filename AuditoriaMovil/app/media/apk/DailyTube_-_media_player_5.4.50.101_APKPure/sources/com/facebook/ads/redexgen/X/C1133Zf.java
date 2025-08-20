package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Zf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1133Zf implements AnonymousClass59 {
    public final /* synthetic */ AbstractC03824o A00;

    public C1133Zf(AbstractC03824o abstractC03824o) {
        this.A00 = abstractC03824o;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final View A6M(int i) {
        return this.A00.A0t(i);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final int A6O(View view) {
        return this.A00.A0j(view) + ((C03834p) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final int A6P(View view) {
        return this.A00.A0o(view) - ((C03834p) view.getLayoutParams()).topMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final int A7a() {
        return this.A00.A0X() - this.A00.A0d();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass59
    public final int A7b() {
        return this.A00.A0g();
    }
}
