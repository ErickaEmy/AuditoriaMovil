package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
/* loaded from: assets/audience_network.dex */
public final class NC extends ViewGroup {
    public static final int A01 = (int) (LD.A02 * 8.0f);
    public int A00;

    public NC(C1116Yn c1116Yn) {
        super(c1116Yn);
        setMotionEventSplittingEnabled(false);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000e */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            int r12 = r12 - r10
            int r7 = r8.getPaddingLeft()
            int r6 = r8.getPaddingTop()
            r5 = 0
        La:
            int r0 = r8.getChildCount()
            if (r5 >= r0) goto L35
            android.view.View r4 = r8.getChildAt(r5)
            int r3 = r4.getMeasuredWidth()
            int r2 = r4.getMeasuredHeight()
            int r0 = r7 + r3
            if (r0 <= r12) goto L27
            int r7 = r8.getPaddingLeft()
            int r0 = r8.A00
            int r6 = r6 + r0
        L27:
            int r1 = r7 + r3
            int r0 = r6 + r2
            r4.layout(r7, r6, r1, r0)
            int r0 = com.facebook.ads.redexgen.X.NC.A01
            int r0 = r0 + r3
            int r7 = r7 + r0
            int r5 = r5 + 1
            goto La
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NC.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0033 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            int r8 = android.view.View.MeasureSpec.getSize(r11)
            int r0 = r10.getPaddingLeft()
            int r8 = r8 - r0
            int r0 = r10.getPaddingRight()
            int r8 = r8 - r0
            int r1 = android.view.View.MeasureSpec.getSize(r12)
            int r0 = r10.getPaddingTop()
            int r1 = r1 - r0
            int r0 = r10.getPaddingBottom()
            int r1 = r1 - r0
            int r9 = r10.getPaddingLeft()
            r7 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r6)
            int r0 = r10.getChildCount()
            if (r0 <= 0) goto L5e
            r4 = 1
        L2e:
            r3 = 0
        L2f:
            int r0 = r10.getChildCount()
            if (r3 >= r0) goto L60
            android.view.View r1 = r10.getChildAt(r3)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            r1.measure(r0, r5)
            int r2 = r1.getMeasuredWidth()
            int r0 = r1.getMeasuredHeight()
            int r1 = com.facebook.ads.redexgen.X.NC.A01
            int r0 = r0 + r1
            int r7 = java.lang.Math.max(r7, r0)
            int r0 = r9 + r2
            if (r0 <= r8) goto L59
            int r4 = r4 + 1
            int r9 = r10.getPaddingLeft()
        L59:
            int r1 = r1 + r2
            int r9 = r9 + r1
            int r3 = r3 + 1
            goto L2f
        L5e:
            r4 = 0
            goto L2e
        L60:
            r10.A00 = r7
            int r4 = r4 * r7
            int r0 = com.facebook.ads.redexgen.X.NC.A01
            int r4 = r4 + r0
            r10.setMeasuredDimension(r8, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NC.onMeasure(int, int):void");
    }
}
