package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class BaselineLayout extends ViewGroup {
    public int y;

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.y = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int i10;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i6 - i) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                if (this.y != -1 && childAt.getBaseline() != -1) {
                    i10 = (this.y + paddingTop) - childAt.getBaseline();
                } else {
                    i10 = paddingTop;
                }
                childAt.layout(i12, i10, measuredWidth + i12, measuredHeight + i10);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        int i8 = 0;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i5);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i11 = Math.max(i11, baseline);
                    i12 = Math.max(i12, childAt.getMeasuredHeight() - baseline);
                }
                i8 = Math.max(i8, childAt.getMeasuredWidth());
                i6 = Math.max(i6, childAt.getMeasuredHeight());
                i10 = View.combineMeasuredStates(i10, childAt.getMeasuredState());
            }
        }
        if (i11 != -1) {
            i6 = Math.max(i6, Math.max(i12, getPaddingBottom()) + i11);
            this.y = i11;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i8, getSuggestedMinimumWidth()), i, i10), View.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i5, i10 << 16));
    }
}
