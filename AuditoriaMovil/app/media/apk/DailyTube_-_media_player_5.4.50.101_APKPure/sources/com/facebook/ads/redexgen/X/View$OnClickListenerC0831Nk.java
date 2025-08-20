package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Nk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC0831Nk implements View.OnClickListener {
    public static String[] A03 = {"5NPsaGxTntAZUh5vvPpYLifVDwpYE9gO", "yAdF8jFrPkVudWekKgJT40sKzU7M", "P84QernMh58Oht", "HVjKxCVNtxzSBN1ofjZs3kMRuF4TzLwS", "c9t8G7uI59pglLVDHXf1Cg7BVtBq", "zkFcC9XFE44gS7Ii7sdayH8FvB1qc1Nx", "mQLKSBYKXRgBaCP29rEHxwq0", "ifKB8OntsRJFcWFaLpGEPIeHfTRm85bo"};
    public float A00;
    public float A01;
    public View.OnClickListener A02;

    public View$OnClickListenerC0831Nk(View.OnClickListener onClickListener) {
        this.A02 = onClickListener;
    }

    public final void A00(float f4, float f6) {
        this.A00 = f4;
        this.A01 = f6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r7 > r8) goto L18;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onClick(android.view.View r10) {
        /*
            r9 = this;
            boolean r0 = com.facebook.ads.redexgen.X.KL.A02(r9)
            if (r0 == 0) goto L7
            return
        L7:
            r5 = r9
            int r6 = r10.getWidth()     // Catch: java.lang.Throwable -> L88
            int r4 = r10.getHeight()     // Catch: java.lang.Throwable -> L88
            int r0 = r6 - r4
            int r0 = java.lang.Math.abs(r0)     // Catch: java.lang.Throwable -> L88
            int r3 = r0 / 2
            if (r6 == r4) goto L82
            if (r6 <= r4) goto L4e
            float r7 = r5.A00     // Catch: java.lang.Throwable -> L88
            float r0 = (float) r3     // Catch: java.lang.Throwable -> L88
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 < 0) goto L4e
            int r8 = r6 - r3
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.View$OnClickListenerC0831Nk.A03
            r0 = 1
            r1 = r2[r0]
            r0 = 4
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L3d
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3d:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.View$OnClickListenerC0831Nk.A03
            java.lang.String r1 = "IaFg43gDfmav4cpS3tfI5ukrEyaV"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "YCQU4nAsEaYrX5eT9av2YKK9p1Sz"
            r0 = 4
            r2[r0] = r1
            float r0 = (float) r8
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 <= 0) goto L82
        L4e:
            if (r4 <= r6) goto L87
            float r6 = r5.A01     // Catch: java.lang.Throwable -> L88
            float r0 = (float) r3
            int r7 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.View$OnClickListenerC0831Nk.A03
            r0 = 5
            r1 = r1[r0]
            r0 = 3
            char r1 = r1.charAt(r0)
            r0 = 66
            if (r1 == r0) goto L73
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.View$OnClickListenerC0831Nk.A03
            java.lang.String r1 = "DOfOMptgN0kFoREvgd3Bxl9Eys2o9Nt4"
            r0 = 0
            r2[r0] = r1
            if (r7 < 0) goto L87
        L6c:
            int r4 = r4 - r3
            float r0 = (float) r4
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 > 0) goto L87
            goto L82
        L73:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.View$OnClickListenerC0831Nk.A03
            java.lang.String r1 = "SME7OxnBFewA4wdZ4tQVNxKrxX7o"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "dj4w34xtzstsWLpNapZgfCztNtRS"
            r0 = 4
            r2[r0] = r1
            if (r7 < 0) goto L87
            goto L6c
        L82:
            android.view.View$OnClickListener r0 = r5.A02     // Catch: java.lang.Throwable -> L88
            r0.onClick(r10)     // Catch: java.lang.Throwable -> L88
        L87:
            return
        L88:
            r0 = move-exception
            com.facebook.ads.redexgen.X.KL.A00(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.View$OnClickListenerC0831Nk.onClick(android.view.View):void");
    }
}
