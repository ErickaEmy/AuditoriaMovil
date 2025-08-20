package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import hw.i4;
/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: fb  reason: collision with root package name */
    public int f1334fb;

    /* renamed from: v  reason: collision with root package name */
    public int f1335v;
    public boolean y;

    public ButtonBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1335v = -1;
        int[] iArr = R$styleable.f913w9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        i4.kp(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.y = obtainStyledAttributes.getBoolean(R$styleable.f912w2, true);
        obtainStyledAttributes.recycle();
    }

    private void setStacked(boolean z2) {
        int i;
        int i5;
        setOrientation(z2 ? 1 : 0);
        if (z2) {
            i = 8388613;
        } else {
            i = 80;
        }
        setGravity(i);
        View findViewById = findViewById(R$id.f769z6);
        if (findViewById != null) {
            if (z2) {
                i5 = 8;
            } else {
                i5 = 4;
            }
            findViewById.setVisibility(i5);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f1334fb, super.getMinimumHeight());
    }

    public final boolean n3() {
        if (getOrientation() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i5) {
        int i6;
        boolean z2;
        int size = View.MeasureSpec.getSize(i);
        int i8 = 0;
        if (this.y) {
            if (size > this.f1335v && n3()) {
                setStacked(false);
            }
            this.f1335v = size;
        }
        if (!n3() && View.MeasureSpec.getMode(i) == 1073741824) {
            i6 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z2 = true;
        } else {
            i6 = i;
            z2 = false;
        }
        super.onMeasure(i6, i5);
        if (this.y && !n3() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z2 = true;
        }
        if (z2) {
            super.onMeasure(i, i5);
        }
        int y = y(0);
        if (y >= 0) {
            View childAt = getChildAt(y);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (n3()) {
                int y2 = y(y + 1);
                if (y2 >= 0) {
                    paddingTop += getChildAt(y2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i8 = paddingTop;
            } else {
                i8 = paddingTop + getPaddingBottom();
            }
        }
        if (i4.d(this) != i8) {
            setMinimumHeight(i8);
        }
    }

    public void setAllowStacking(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
            if (!z2 && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    public final int y(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
