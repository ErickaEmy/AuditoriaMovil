package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Ed  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0601Ed extends C1141Zn {
    public final /* synthetic */ C0600Ec A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0601Ed(C0600Ec c0600Ec, Context context) {
        super(context);
        this.A00 = c0600Ec;
    }

    @Override // com.facebook.ads.redexgen.X.C1141Zn, com.facebook.ads.redexgen.X.AnonymousClass51
    public final void A0I(View view, AnonymousClass53 anonymousClass53, C03924z c03924z) {
        C0600Ec c0600Ec = this.A00;
        int[] A0H = c0600Ec.A0H(((ZY) c0600Ec).A00.getLayoutManager(), view);
        int time = A0H[0];
        int dy = A0H[1];
        int dx2 = A0M(Math.max(Math.abs(time), Math.abs(dy)));
        if (dx2 > 0) {
            c03924z.A04(time, dy, dx2, ((C1141Zn) this).A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1141Zn
    public final float A0J(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.X.C1141Zn
    public final int A0L(int i) {
        return Math.min(100, super.A0L(i));
    }
}
