package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
abstract class ViewOffsetBehavior extends CoordinatorLayout.Behavior {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        layoutChild(coordinatorLayout, view, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(view);
        }
        this.viewOffsetHelper.onViewLayout();
        this.viewOffsetHelper.applyOffsets();
        int i2 = this.tempTopBottomOffset;
        if (i2 != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(i2);
            this.tempTopBottomOffset = 0;
        }
        int i3 = this.tempLeftRightOffset;
        if (i3 != 0) {
            this.viewOffsetHelper.setLeftAndRightOffset(i3);
            this.tempLeftRightOffset = 0;
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.onLayoutChild(view, i);
    }

    public boolean setTopAndBottomOffset(int i) {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.setTopAndBottomOffset(i);
        }
        this.tempTopBottomOffset = i;
        return false;
    }

    public boolean setLeftAndRightOffset(int i) {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.setLeftAndRightOffset(i);
        }
        this.tempLeftRightOffset = i;
        return false;
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.getTopAndBottomOffset();
        }
        return 0;
    }

    public int getLeftAndRightOffset() {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.getLeftAndRightOffset();
        }
        return 0;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.setVerticalOffsetEnabled(z);
        }
    }

    public boolean isVerticalOffsetEnabled() {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        return viewOffsetHelper != null && viewOffsetHelper.isVerticalOffsetEnabled();
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.setHorizontalOffsetEnabled(z);
        }
    }

    public boolean isHorizontalOffsetEnabled() {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        return viewOffsetHelper != null && viewOffsetHelper.isHorizontalOffsetEnabled();
    }
}
