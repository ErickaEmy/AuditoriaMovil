package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.button.MaterialButton;
import hw.i4;
import hw.s;
import hx.f;
import j5.zn;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import ur.f;
/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: f3  reason: collision with root package name */
    public static final int f5526f3 = R$style.ws;

    /* renamed from: r  reason: collision with root package name */
    public static final String f5527r = "MaterialButtonToggleGroup";

    /* renamed from: co  reason: collision with root package name */
    public boolean f5528co;

    /* renamed from: f  reason: collision with root package name */
    public final Comparator<MaterialButton> f5529f;

    /* renamed from: fb  reason: collision with root package name */
    public final a f5530fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5531p;

    /* renamed from: s  reason: collision with root package name */
    public final LinkedHashSet<v> f5532s;

    /* renamed from: t  reason: collision with root package name */
    public Integer[] f5533t;

    /* renamed from: v  reason: collision with root package name */
    public final zn f5534v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f5535w;
    public final List<gv> y;

    /* renamed from: z  reason: collision with root package name */
    public int f5536z;

    /* loaded from: classes.dex */
    public class a implements MaterialButton.n3 {
        public a() {
        }

        @Override // com.google.android.material.button.MaterialButton.n3
        public void y(@NonNull MaterialButton materialButton, boolean z2) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ a(MaterialButtonToggleGroup materialButtonToggleGroup, y yVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class gv {

        /* renamed from: v  reason: collision with root package name */
        public static final hx.zn f5537v = new hx.y(0.0f);

        /* renamed from: gv  reason: collision with root package name */
        public hx.zn f5538gv;

        /* renamed from: n3  reason: collision with root package name */
        public hx.zn f5539n3;
        public hx.zn y;

        /* renamed from: zn  reason: collision with root package name */
        public hx.zn f5540zn;

        public gv(hx.zn znVar, hx.zn znVar2, hx.zn znVar3, hx.zn znVar4) {
            this.y = znVar;
            this.f5539n3 = znVar3;
            this.f5540zn = znVar4;
            this.f5538gv = znVar2;
        }

        public static gv a(gv gvVar) {
            hx.zn znVar = gvVar.y;
            hx.zn znVar2 = f5537v;
            return new gv(znVar, znVar2, gvVar.f5539n3, znVar2);
        }

        public static gv gv(gv gvVar) {
            hx.zn znVar = f5537v;
            return new gv(znVar, znVar, gvVar.f5539n3, gvVar.f5540zn);
        }

        public static gv n3(gv gvVar, View view) {
            if (f.gv(view)) {
                return zn(gvVar);
            }
            return gv(gvVar);
        }

        public static gv v(gv gvVar, View view) {
            if (f.gv(view)) {
                return gv(gvVar);
            }
            return zn(gvVar);
        }

        public static gv y(gv gvVar) {
            hx.zn znVar = f5537v;
            return new gv(znVar, gvVar.f5538gv, znVar, gvVar.f5540zn);
        }

        public static gv zn(gv gvVar) {
            hx.zn znVar = gvVar.y;
            hx.zn znVar2 = gvVar.f5538gv;
            hx.zn znVar3 = f5537v;
            return new gv(znVar, znVar2, znVar3, znVar3);
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends hw.y {
        public n3() {
        }

        @Override // hw.y
        public void fb(View view, @NonNull j5.zn znVar) {
            super.fb(view, znVar);
            znVar.yg(zn.fb.y(0, 1, MaterialButtonToggleGroup.this.wz(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void y(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2);
    }

    /* loaded from: classes.dex */
    public class y implements Comparator<MaterialButton> {
        public y() {
        }

        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            if (compareTo2 != 0) {
                return compareTo2;
            }
            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* loaded from: classes.dex */
    public class zn implements MaterialButton.y {
        public zn() {
        }

        @Override // com.google.android.material.button.MaterialButton.y
        public void y(@NonNull MaterialButton materialButton, boolean z2) {
            int i;
            if (MaterialButtonToggleGroup.this.f5535w) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f5531p) {
                MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                if (z2) {
                    i = materialButton.getId();
                } else {
                    i = -1;
                }
                materialButtonToggleGroup.f5536z = i;
            }
            if (MaterialButtonToggleGroup.this.r(materialButton.getId(), z2)) {
                MaterialButtonToggleGroup.this.t(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ zn(MaterialButtonToggleGroup materialButtonToggleGroup, y yVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.frl);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (w(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (w(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if ((getChildAt(i5) instanceof MaterialButton) && w(i5)) {
                i++;
            }
        }
        return i;
    }

    private void setCheckedId(int i) {
        this.f5536z = i;
        t(i, true);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(i4.tl());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.y(this.f5534v);
        materialButton.setOnPressedChangeListenerInternal(this.f5530fb);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public static void z(f.n3 n3Var, @Nullable gv gvVar) {
        if (gvVar == null) {
            n3Var.xc(0.0f);
        } else {
            n3Var.rz(gvVar.y).r(gvVar.f5538gv).z6(gvVar.f5539n3).n(gvVar.f5540zn);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f5527r, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            r(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        hx.f shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.y.add(new gv(shapeAppearanceModel.mt(), shapeAppearanceModel.i9(), shapeAppearanceModel.z(), shapeAppearanceModel.t()));
        i4.g3(materialButton, new n3());
    }

    @NonNull
    public final LinearLayout.LayoutParams c5(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    public final void co(int i, boolean z2) {
        View findViewById = findViewById(i);
        if (findViewById instanceof MaterialButton) {
            this.f5535w = true;
            ((MaterialButton) findViewById).setChecked(z2);
            this.f5535w = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        x4();
        super.dispatchDraw(canvas);
    }

    public void f() {
        this.f5535w = true;
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton tl2 = tl(i);
            tl2.setChecked(false);
            t(tl2.getId(), false);
        }
        this.f5535w = false;
        setCheckedId(-1);
    }

    public void fb(@NonNull v vVar) {
        this.f5532s.add(vVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.f5531p) {
            return this.f5536z;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton tl2 = tl(i);
            if (tl2.isChecked()) {
                arrayList.add(Integer.valueOf(tl2.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i5) {
        Integer[] numArr = this.f5533t;
        if (numArr != null && i5 < numArr.length) {
            return numArr[i5].intValue();
        }
        Log.w(f5527r, "Child order wasn't updated");
        return i5;
    }

    public void i4() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton tl2 = tl(i);
            if (tl2.getVisibility() != 8) {
                f.n3 x42 = tl2.getShapeAppearanceModel().x4();
                z(x42, xc(i, firstVisibleChildIndex, lastVisibleChildIndex));
                tl2.setShapeAppearanceModel(x42.tl());
            }
        }
    }

    public final void i9(int i) {
        co(i, true);
        r(i, true);
        setCheckedId(i);
    }

    public final void mt(int i) {
        if (getChildCount() != 0 && i != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tl(i).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            s.zn(layoutParams, 0);
            s.gv(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f5536z;
        if (i != -1) {
            i9(i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        j5.zn w22 = j5.zn.w2(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (p()) {
            i = 1;
        } else {
            i = 2;
        }
        w22.ap(zn.a.y(1, visibleButtonCount, false, i));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i5) {
        i4();
        s();
        super.onMeasure(i, i5);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.s(this.f5534v);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.y.remove(indexOfChild);
        }
        i4();
        s();
    }

    public boolean p() {
        return this.f5531p;
    }

    public final boolean r(int i, boolean z2) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.f5528co && checkedButtonIds.isEmpty()) {
            co(i, true);
            this.f5536z = i;
            return false;
        }
        if (z2 && this.f5531p) {
            checkedButtonIds.remove(Integer.valueOf(i));
            for (Integer num : checkedButtonIds) {
                int intValue = num.intValue();
                co(intValue, false);
                t(intValue, false);
            }
        }
        return true;
    }

    public final void s() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton tl2 = tl(i);
            int min = Math.min(tl2.getStrokeWidth(), tl(i - 1).getStrokeWidth());
            LinearLayout.LayoutParams c52 = c5(tl2);
            if (getOrientation() == 0) {
                s.zn(c52, 0);
                s.gv(c52, -min);
                c52.topMargin = 0;
            } else {
                c52.bottomMargin = 0;
                c52.topMargin = -min;
                s.gv(c52, 0);
            }
            tl2.setLayoutParams(c52);
        }
        mt(firstVisibleChildIndex);
    }

    public void setSelectionRequired(boolean z2) {
        this.f5528co = z2;
    }

    public void setSingleSelection(boolean z2) {
        if (this.f5531p != z2) {
            this.f5531p = z2;
            f();
        }
    }

    public final void t(int i, boolean z2) {
        Iterator<v> it = this.f5532s.iterator();
        while (it.hasNext()) {
            it.next().y(this, i, z2);
        }
    }

    public final MaterialButton tl(int i) {
        return (MaterialButton) getChildAt(i);
    }

    public final boolean w(int i) {
        if (getChildAt(i).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    public final int wz(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) == view) {
                return i;
            }
            if ((getChildAt(i5) instanceof MaterialButton) && w(i5)) {
                i++;
            }
        }
        return -1;
    }

    public final void x4() {
        TreeMap treeMap = new TreeMap(this.f5529f);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(tl(i), Integer.valueOf(i));
        }
        this.f5533t = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    @Nullable
    public final gv xc(int i, int i5, int i6) {
        boolean z2;
        gv gvVar = this.y.get(i);
        if (i5 == i6) {
            return gvVar;
        }
        if (getOrientation() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i == i5) {
            if (z2) {
                return gv.v(gvVar, this);
            }
            return gv.a(gvVar);
        } else if (i == i6) {
            if (z2) {
                return gv.n3(gvVar, this);
            }
            return gv.y(gvVar);
        } else {
            return null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f5526f3
            android.content.Context r7 = c0.y.zn(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.y = r7
            com.google.android.material.button.MaterialButtonToggleGroup$zn r7 = new com.google.android.material.button.MaterialButtonToggleGroup$zn
            r0 = 0
            r7.<init>(r6, r0)
            r6.f5534v = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>(r6, r0)
            r6.f5530fb = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f5532s = r7
            com.google.android.material.button.MaterialButtonToggleGroup$y r7 = new com.google.android.material.button.MaterialButtonToggleGroup$y
            r7.<init>()
            r6.f5529f = r7
            r7 = 0
            r6.f5535w = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.t6
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = ur.i9.s(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.op
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R$styleable.t3
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f5536z = r9
            int r9 = com.google.android.material.R$styleable.m5
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f5528co = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            hw.i4.o0(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
