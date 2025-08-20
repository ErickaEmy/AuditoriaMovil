package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
/* loaded from: assets/audience_network.dex */
public final class UB extends O3 {
    public static String[] A01 = {"ApYQLHiJfFoQxPLev3v1RnZtjL3Htxrs", "bo2sqrskjgNWasJuJCrp16cZ2XBNeh8X", "emwWE4rUfgFwy6LExYmEfzkDvXYAedhg", "bPVrpfjvf63ND9vhKC9W9DFqAg6wIvw3", "k6ukfOYu7hE0QQIPVs49Kdk3IYXWEofH", "fvCBaRVGvF6m5ZfwhdbeNg6rR0MmpiyE", "HEJk8ccdn4XKVem16EvPwrOEFwPjrKpO", "Ip6ocVLC"};
    public ImageView.ScaleType A00;

    public UB(C1116Yn c1116Yn) {
        super(c1116Yn);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            int r3 = android.view.View.MeasureSpec.getSize(r6)
            int r2 = android.view.View.MeasureSpec.getSize(r5)
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 != r1) goto L3b
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            if (r0 != r1) goto L3b
            int r0 = java.lang.Math.min(r2, r3)
            r4.setMeasuredDimension(r0, r0)
        L1d:
            android.widget.ImageView$ScaleType r3 = r4.A00
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.UB.A01
            r0 = 5
            r1 = r1[r0]
            r0 = 24
            char r1 = r1.charAt(r0)
            r0 = 121(0x79, float:1.7E-43)
            if (r1 == r0) goto L5f
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.UB.A01
            java.lang.String r1 = "60jXKIpbxaQwCHoxf9ChBAtjlKdb11wg"
            r0 = 1
            r2[r0] = r1
            if (r3 == 0) goto L3a
            super.setScaleType(r3)
        L3a:
            return
        L3b:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L4b
            if (r3 <= 0) goto L47
            int r2 = java.lang.Math.min(r2, r3)
        L47:
            r4.setMeasuredDimension(r2, r2)
            goto L1d
        L4b:
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            if (r0 != r1) goto L5b
            if (r2 <= 0) goto L57
            int r3 = java.lang.Math.min(r2, r3)
        L57:
            r4.setMeasuredDimension(r3, r3)
            goto L1d
        L5b:
            super.onMeasure(r5, r6)
            goto L1d
        L5f:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.UB.onMeasure(int, int):void");
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        this.A00 = scaleType;
    }
}
