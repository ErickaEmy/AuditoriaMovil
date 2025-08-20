package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.fb;
import androidx.appcompat.view.menu.i9;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import d.s;
import hw.i4;
import j.tl;
import j5.zn;
import ur.gv;
import wz.j5;
/* loaded from: classes.dex */
public class NavigationMenuItemView extends gv implements i9.y {

    /* renamed from: u  reason: collision with root package name */
    public static final int[] f5799u = {16842912};

    /* renamed from: en  reason: collision with root package name */
    public Drawable f5800en;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f5801f7;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5802j;

    /* renamed from: jz  reason: collision with root package name */
    public final hw.y f5803jz;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f5804k;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5805o;

    /* renamed from: oz  reason: collision with root package name */
    public final CheckedTextView f5806oz;

    /* renamed from: q9  reason: collision with root package name */
    public fb f5807q9;

    /* renamed from: qn  reason: collision with root package name */
    public int f5808qn;

    /* renamed from: ut  reason: collision with root package name */
    public FrameLayout f5809ut;

    /* loaded from: classes.dex */
    public class y extends hw.y {
        public y() {
        }

        @Override // hw.y
        public void fb(View view, @NonNull zn znVar) {
            super.fb(view, znVar);
            znVar.nf(NavigationMenuItemView.this.f5802j);
        }
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.f5809ut == null) {
                this.f5809ut = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.f5809ut.removeAllViews();
            this.f5809ut.addView(view);
        }
    }

    public final void fh() {
        if (mg()) {
            this.f5806oz.setVisibility(8);
            FrameLayout frameLayout = this.f5809ut;
            if (frameLayout != null) {
                LinearLayoutCompat.y yVar = (LinearLayoutCompat.y) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) yVar).width = -1;
                this.f5809ut.setLayoutParams(yVar);
                return;
            }
            return;
        }
        this.f5806oz.setVisibility(0);
        FrameLayout frameLayout2 = this.f5809ut;
        if (frameLayout2 != null) {
            LinearLayoutCompat.y yVar2 = (LinearLayoutCompat.y) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) yVar2).width = -2;
            this.f5809ut.setLayoutParams(yVar2);
        }
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public fb getItemData() {
        return this.f5807q9;
    }

    public final boolean mg() {
        if (this.f5807q9.getTitle() == null && this.f5807q9.getIcon() == null && this.f5807q9.getActionView() != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        fb fbVar = this.f5807q9;
        if (fbVar != null && fbVar.isCheckable() && this.f5807q9.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f5799u);
        }
        return onCreateDrawableState;
    }

    @Nullable
    public final StateListDrawable rz() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(R$attr.f659x4, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(f5799u, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.f5802j != z2) {
            this.f5802j = z2;
            this.f5803jz.t(this.f5806oz, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.f5806oz.setChecked(z2);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.f5801f7) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = ej.y.mt(drawable).mutate();
                ej.y.xc(drawable, this.f5804k);
            }
            int i = this.f5808qn;
            drawable.setBounds(0, 0, i, i);
        } else if (this.f5805o) {
            if (this.f5800en == null) {
                Drawable v2 = s.v(getResources(), R$drawable.fgl, getContext().getTheme());
                this.f5800en = v2;
                if (v2 != null) {
                    int i5 = this.f5808qn;
                    v2.setBounds(0, 0, i5, i5);
                }
            }
            drawable = this.f5800en;
        }
        tl.i9(this.f5806oz, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.f5806oz.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.f5808qn = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        boolean z2;
        this.f5804k = colorStateList;
        if (colorStateList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f5801f7 = z2;
        fb fbVar = this.f5807q9;
        if (fbVar != null) {
            setIcon(fbVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.f5806oz.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.f5805o = z2;
    }

    public void setTextAppearance(int i) {
        tl.xc(this.f5806oz, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f5806oz.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f5806oz.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public boolean v() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public void zn(@NonNull fb fbVar, int i) {
        int i5;
        this.f5807q9 = fbVar;
        if (fbVar.getItemId() > 0) {
            setId(fbVar.getItemId());
        }
        if (fbVar.isVisible()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        setVisibility(i5);
        if (getBackground() == null) {
            i4.u0(this, rz());
        }
        setCheckable(fbVar.isCheckable());
        setChecked(fbVar.isChecked());
        setEnabled(fbVar.isEnabled());
        setTitle(fbVar.getTitle());
        setIcon(fbVar.getIcon());
        setActionView(fbVar.getActionView());
        setContentDescription(fbVar.getContentDescription());
        j5.y(this, fbVar.getTooltipText());
        fh();
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        y yVar = new y();
        this.f5803jz = yVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.as, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.k1));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.f5806oz = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        i4.g3(checkedTextView, yVar);
    }
}
