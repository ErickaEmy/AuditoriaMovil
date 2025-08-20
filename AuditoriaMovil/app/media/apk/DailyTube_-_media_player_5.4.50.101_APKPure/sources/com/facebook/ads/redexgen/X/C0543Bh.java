package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Bh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0543Bh extends C1141Zn {
    public final /* synthetic */ C0542Bg A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.C1141Zn
    public final int A0O(View view, int i) {
        int i5;
        AbstractC03824o A08 = A08();
        if (A08.A20()) {
            C03834p c03834p = (C03834p) view.getLayoutParams();
            int A0N = A0N(A08.A0k(view) - c03834p.leftMargin, A08.A0n(view) + c03834p.rightMargin, A08.A0e(), A08.A0h() - A08.A0f(), i);
            i5 = this.A00.A02;
            return A0N + i5;
        }
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0543Bh(C0542Bg c0542Bg, C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A00 = c0542Bg;
    }

    @Override // com.facebook.ads.redexgen.X.C1141Zn
    public final float A0J(DisplayMetrics displayMetrics) {
        float f4;
        f4 = this.A00.A00;
        return f4 / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.X.C1141Zn
    public final int A0K() {
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.C1141Zn
    public final PointF A0P(int i) {
        return this.A00.A4O(i);
    }
}
