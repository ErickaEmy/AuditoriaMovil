package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
/* renamed from: com.facebook.ads.redexgen.X.Pj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0882Pj {
    public final int[] A00(View view, int i, int i5) {
        C03834p c03834p = (C03834p) view.getLayoutParams();
        int childHeightSpec = ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), c03834p.width);
        int childWidthSpec = view.getPaddingTop();
        view.measure(childHeightSpec, ViewGroup.getChildMeasureSpec(i5, childWidthSpec + view.getPaddingBottom(), c03834p.height));
        int childWidthSpec2 = view.getMeasuredWidth();
        int childWidthSpec3 = view.getMeasuredHeight();
        return new int[]{childWidthSpec2 + c03834p.leftMargin + c03834p.rightMargin, childWidthSpec3 + c03834p.bottomMargin + c03834p.topMargin};
    }
}
