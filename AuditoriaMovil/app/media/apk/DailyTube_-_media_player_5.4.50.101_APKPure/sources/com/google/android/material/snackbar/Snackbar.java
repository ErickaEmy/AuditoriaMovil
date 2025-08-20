package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {

    /* renamed from: d0  reason: collision with root package name */
    public static final int[] f5863d0;

    /* renamed from: fh  reason: collision with root package name */
    public static final int[] f5864fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5865c;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public final AccessibilityManager f5866n;

    /* loaded from: classes.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.i4 {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i5) {
            super.onMeasure(i, i5);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i4, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i4, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i4, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i4, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i4, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        int i = R$attr.fgd;
        f5863d0 = new int[]{i};
        f5864fh = new int[]{i, R$attr.fgi};
    }

    public Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull jn.y yVar) {
        super(context, viewGroup, view, yVar);
        this.f5866n = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static boolean en(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f5864fh);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1 || resourceId2 == -1) {
            return false;
        }
        return true;
    }

    @Nullable
    public static ViewGroup f7(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    @NonNull
    public static Snackbar jz(@NonNull View view, int i, int i5) {
        return u(view, view.getResources().getText(i), i5);
    }

    @NonNull
    public static Snackbar u(@NonNull View view, @NonNull CharSequence charSequence, int i) {
        return y5(null, view, charSequence, i);
    }

    @NonNull
    public static Snackbar y5(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i) {
        int i5;
        ViewGroup f72 = f7(view);
        if (f72 != null) {
            if (context == null) {
                context = f72.getContext();
            }
            LayoutInflater from = LayoutInflater.from(context);
            if (en(context)) {
                i5 = R$layout.wi;
            } else {
                i5 = R$layout.s3;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(i5, f72, false);
            Snackbar snackbar = new Snackbar(context, f72, snackbarContentLayout, snackbarContentLayout);
            snackbar.xg(charSequence);
            snackbar.k5(i);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void j5() {
        super.j5();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int n() {
        int i;
        int n2 = super.n();
        if (n2 == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.f5865c) {
                i = 4;
            } else {
                i = 0;
            }
            return this.f5866n.getRecommendedTimeoutMillis(n2, i | 3);
        } else if (this.f5865c && this.f5866n.isTouchExplorationEnabled()) {
            return -2;
        } else {
            return n2;
        }
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void x4() {
        super.x4();
    }

    @NonNull
    public Snackbar xg(@NonNull CharSequence charSequence) {
        ((SnackbarContentLayout) this.f5848zn.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }
}
