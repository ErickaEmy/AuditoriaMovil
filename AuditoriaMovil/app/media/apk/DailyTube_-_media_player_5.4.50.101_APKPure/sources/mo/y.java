package mo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$style;
import com.google.android.material.chip.Chip;
import j5.zn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends ur.zn {

    /* renamed from: r  reason: collision with root package name */
    public static final int f11517r = R$style.on;

    /* renamed from: co  reason: collision with root package name */
    public int f11518co;

    /* renamed from: f  reason: collision with root package name */
    public int f11519f;

    /* renamed from: p  reason: collision with root package name */
    public boolean f11520p;

    /* renamed from: t  reason: collision with root package name */
    public int f11521t;

    /* renamed from: w  reason: collision with root package name */
    public boolean f11522w;

    /* renamed from: z  reason: collision with root package name */
    public boolean f11523z;

    /* loaded from: classes.dex */
    public interface n3 {
    }

    /* renamed from: mo.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0155y extends ViewGroup.MarginLayoutParams {
        public C0155y(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0155y(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0155y(int i, int i5) {
            super(i, i5);
        }
    }

    /* loaded from: classes.dex */
    public class zn implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ ViewGroup.OnHierarchyChangeListener y(zn znVar, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
            throw null;
        }
    }

    private int getChipCount() {
        int i = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    private void setCheckedId(int i) {
        fb(i, true);
    }

    public boolean a() {
        return this.f11522w;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i5 = this.f11518co;
                if (i5 != -1 && this.f11522w) {
                    s(i5, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0155y)) {
            return true;
        }
        return false;
    }

    public final void fb(int i, boolean z2) {
        this.f11518co = i;
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0155y(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0155y(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.f11522w) {
            return this.f11518co;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f11522w) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.f11519f;
    }

    public int getChipSpacingVertical() {
        return this.f11521t;
    }

    public void gv() {
        this.f11523z = true;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f11523z = false;
        setCheckedId(-1);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f11518co;
        if (i != -1) {
            s(i, true);
            setCheckedId(this.f11518co);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        int i5;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        j5.zn w22 = j5.zn.w2(accessibilityNodeInfo);
        if (zn()) {
            i = getChipCount();
        } else {
            i = -1;
        }
        int rowCount = getRowCount();
        if (a()) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        w22.ap(zn.a.y(rowCount, i, false, i5));
    }

    public final void s(int i, boolean z2) {
        View findViewById = findViewById(i);
        if (findViewById instanceof Chip) {
            this.f11523z = true;
            ((Chip) findViewById).setChecked(z2);
            this.f11523z = false;
        }
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.f11519f != i) {
            this.f11519f = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.f11521t != i) {
            this.f11521t = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        zn.y(null, onHierarchyChangeListener);
    }

    public void setSelectionRequired(boolean z2) {
        this.f11520p = z2;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // ur.zn
    public void setSingleLine(boolean z2) {
        super.setSingleLine(z2);
    }

    public void setSingleSelection(boolean z2) {
        if (this.f11522w != z2) {
            this.f11522w = z2;
            gv();
        }
    }

    public int v(@Nullable View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) instanceof Chip) {
                if (((Chip) getChildAt(i5)) == view) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override // ur.zn
    public boolean zn() {
        return super.zn();
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0155y(layoutParams);
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setOnCheckedChangeListener(n3 n3Var) {
    }
}
