package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.bQ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1240bQ implements P0 {
    public final /* synthetic */ C1237bN A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.P0
    public final void A9L() {
        FV fv;
        EQ eq;
        fv = this.A00.A03;
        String A00 = fv.A10().A00();
        if (TextUtils.isEmpty(A00)) {
            return;
        }
        C0764Kv c0764Kv = new C0764Kv();
        eq = this.A00.A04;
        C0764Kv.A0M(c0764Kv, eq, AbstractC0767Ky.A00(A00), this.A00.A6T());
    }

    public C1240bQ(C1237bN c1237bN) {
        this.A00 = c1237bN;
    }

    @Override // com.facebook.ads.redexgen.X.P0
    public final void ABO(B0 b02) {
        new Handler(Looper.getMainLooper()).postDelayed(new C1241bR(this, b02), 1L);
    }

    @Override // com.facebook.ads.redexgen.X.P0
    public final void ABd() {
    }

    @Override // com.facebook.ads.redexgen.X.P0
    public final void ADL(View view, MotionEvent motionEvent) {
    }
}
