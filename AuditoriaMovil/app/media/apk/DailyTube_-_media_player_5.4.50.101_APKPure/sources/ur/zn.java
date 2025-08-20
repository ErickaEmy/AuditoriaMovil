package ur;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R$id;
import hw.i4;
/* loaded from: classes.dex */
public class zn extends ViewGroup {

    /* renamed from: fb  reason: collision with root package name */
    public boolean f14169fb;

    /* renamed from: s  reason: collision with root package name */
    public int f14170s;

    /* renamed from: v  reason: collision with root package name */
    public int f14171v;
    public int y;

    public static int y(int i, int i5, int i6) {
        if (i5 != Integer.MIN_VALUE) {
            if (i5 != 1073741824) {
                return i6;
            }
            return i;
        }
        return Math.min(i6, i);
    }

    public int getItemSpacing() {
        return this.f14171v;
    }

    public int getLineSpacing() {
        return this.y;
    }

    public int getRowCount() {
        return this.f14170s;
    }

    public int n3(@NonNull View view) {
        Object tag = view.getTag(R$id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        boolean z3;
        int paddingLeft;
        int paddingRight;
        int i10;
        int i11;
        if (getChildCount() == 0) {
            this.f14170s = 0;
            return;
        }
        this.f14170s = 1;
        if (i4.ta(this) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (z3) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i12 = (i6 - i) - paddingRight;
        int i13 = paddingLeft;
        int i14 = paddingTop;
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R$id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i11 = hw.s.n3(marginLayoutParams);
                    i10 = hw.s.y(marginLayoutParams);
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                int measuredWidth = i13 + i11 + childAt.getMeasuredWidth();
                if (!this.f14169fb && measuredWidth > i12) {
                    i14 = this.y + paddingTop;
                    this.f14170s++;
                    i13 = paddingLeft;
                }
                childAt.setTag(R$id.row_index_key, Integer.valueOf(this.f14170s - 1));
                int i16 = i13 + i11;
                int measuredWidth2 = childAt.getMeasuredWidth() + i16;
                int measuredHeight = childAt.getMeasuredHeight() + i14;
                if (z3) {
                    childAt.layout(i12 - measuredWidth2, i14, (i12 - i13) - i11, measuredHeight);
                } else {
                    childAt.layout(i16, i14, measuredWidth2, measuredHeight);
                }
                i13 += i11 + i10 + childAt.getMeasuredWidth() + this.f14171v;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        int i6;
        int i8;
        int i10;
        int i11;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            i6 = Integer.MAX_VALUE;
        } else {
            i6 = size;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i12 = paddingTop;
        int i13 = 0;
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i5);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i8 = marginLayoutParams.leftMargin;
                    i10 = marginLayoutParams.rightMargin;
                } else {
                    i8 = 0;
                    i10 = 0;
                }
                int i15 = paddingLeft;
                if (paddingLeft + i8 + childAt.getMeasuredWidth() > paddingRight && !zn()) {
                    i11 = getPaddingLeft();
                    i12 = this.y + paddingTop;
                } else {
                    i11 = i15;
                }
                int measuredWidth = i11 + i8 + childAt.getMeasuredWidth();
                int measuredHeight = i12 + childAt.getMeasuredHeight();
                if (measuredWidth > i13) {
                    i13 = measuredWidth;
                }
                paddingLeft = i11 + i8 + i10 + childAt.getMeasuredWidth() + this.f14171v;
                if (i14 == getChildCount() - 1) {
                    i13 += i10;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(y(size, mode, i13 + getPaddingRight()), y(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i) {
        this.f14171v = i;
    }

    public void setLineSpacing(int i) {
        this.y = i;
    }

    public void setSingleLine(boolean z2) {
        this.f14169fb = z2;
    }

    public boolean zn() {
        return this.f14169fb;
    }
}
