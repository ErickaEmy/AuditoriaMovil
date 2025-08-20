package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.c5;
import androidx.appcompat.view.menu.fb;
import androidx.appcompat.view.menu.i9;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.LinearLayoutCompat;
import wz.oz;
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements v.n3, i9 {

    /* renamed from: b  reason: collision with root package name */
    public androidx.appcompat.widget.y f1287b;

    /* renamed from: d  reason: collision with root package name */
    public Context f1288d;

    /* renamed from: ej  reason: collision with root package name */
    public int f1289ej;

    /* renamed from: fh  reason: collision with root package name */
    public androidx.appcompat.view.menu.v f1290fh;

    /* renamed from: j  reason: collision with root package name */
    public int f1291j;

    /* renamed from: j5  reason: collision with root package name */
    public c5.y f1292j5;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1293o;

    /* renamed from: oz  reason: collision with root package name */
    public int f1294oz;

    /* renamed from: q9  reason: collision with root package name */
    public v f1295q9;

    /* renamed from: qn  reason: collision with root package name */
    public v.y f1296qn;

    /* renamed from: ut  reason: collision with root package name */
    public int f1297ut;

    /* renamed from: x  reason: collision with root package name */
    public boolean f1298x;

    /* loaded from: classes.dex */
    public class gv implements v.y {
        public gv() {
        }

        @Override // androidx.appcompat.view.menu.v.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar) {
            v.y yVar = ActionMenuView.this.f1296qn;
            if (yVar != null) {
                yVar.n3(vVar);
            }
        }

        @Override // androidx.appcompat.view.menu.v.y
        public boolean y(@NonNull androidx.appcompat.view.menu.v vVar, @NonNull MenuItem menuItem) {
            v vVar2 = ActionMenuView.this.f1295q9;
            if (vVar2 != null && vVar2.onMenuItemClick(menuItem)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 implements c5.y {
        @Override // androidx.appcompat.view.menu.c5.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public boolean zn(@NonNull androidx.appcompat.view.menu.v vVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface y {
        boolean n3();

        boolean y();
    }

    /* loaded from: classes.dex */
    public static class zn extends LinearLayoutCompat.y {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1299a;
        @ViewDebug.ExportedProperty

        /* renamed from: gv  reason: collision with root package name */
        public boolean f1300gv;
        @ViewDebug.ExportedProperty

        /* renamed from: n3  reason: collision with root package name */
        public int f1301n3;
        @ViewDebug.ExportedProperty

        /* renamed from: v  reason: collision with root package name */
        public boolean f1302v;
        @ViewDebug.ExportedProperty
        public boolean y;
        @ViewDebug.ExportedProperty

        /* renamed from: zn  reason: collision with root package name */
        public int f1303zn;

        public zn(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public zn(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public zn(zn znVar) {
            super(znVar);
            this.y = znVar.y;
        }

        public zn(int i, int i5) {
            super(i, i5);
        }
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, null);
    }

    public static int b(View view, int i, int i5, int i6, int i8) {
        ActionMenuItemView actionMenuItemView;
        boolean z2;
        int i10;
        zn znVar = (zn) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6) - i8, View.MeasureSpec.getMode(i6));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z3 = false;
        if (actionMenuItemView != null && actionMenuItemView.a()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i5 > 0) {
            i10 = 2;
            if (!z2 || i5 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i5 * i, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i11 = measuredWidth / i;
                if (measuredWidth % i != 0) {
                    i11++;
                }
                if (!z2 || i11 >= 2) {
                    i10 = i11;
                }
                if (!znVar.y && z2) {
                    z3 = true;
                }
                znVar.f1300gv = z3;
                znVar.f1301n3 = i10;
                view.measure(View.MeasureSpec.makeMeasureSpec(i * i10, 1073741824), makeMeasureSpec);
                return i10;
            }
        }
        i10 = 0;
        if (!znVar.y) {
            z3 = true;
        }
        znVar.f1300gv = z3;
        znVar.f1301n3 = i10;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i10, 1073741824), makeMeasureSpec);
        return i10;
    }

    public boolean a8() {
        androidx.appcompat.widget.y yVar = this.f1287b;
        if (yVar != null && yVar.ta()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof zn;
    }

    public zn d() {
        zn tl2 = tl();
        tl2.y = true;
        return tl2;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean ej() {
        androidx.appcompat.widget.y yVar = this.f1287b;
        if (yVar != null && yVar.fh()) {
            return true;
        }
        return false;
    }

    public void fh() {
        androidx.appcompat.widget.y yVar = this.f1287b;
        if (yVar != null) {
            yVar.n();
        }
    }

    public Menu getMenu() {
        if (this.f1290fh == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.v vVar = new androidx.appcompat.view.menu.v(context);
            this.f1290fh = vVar;
            vVar.qn(new gv());
            androidx.appcompat.widget.y yVar = new androidx.appcompat.widget.y(context);
            this.f1287b = yVar;
            yVar.a8(true);
            androidx.appcompat.widget.y yVar2 = this.f1287b;
            c5.y yVar3 = this.f1292j5;
            if (yVar3 == null) {
                yVar3 = new n3();
            }
            yVar2.gv(yVar3);
            this.f1290fh.zn(this.f1287b, this.f1288d);
            this.f1287b.ej(this);
        }
        return this.f1290fh;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1287b.d0();
    }

    public int getPopupTheme() {
        return this.f1289ej;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.v.n3
    public boolean gv(fb fbVar) {
        return this.f1290fh.b(fbVar, 0);
    }

    public boolean hw() {
        androidx.appcompat.widget.y yVar = this.f1287b;
        if (yVar != null && yVar.x()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    public final void k5(int i, int i5) {
        boolean z2;
        int i6;
        int i8;
        boolean z3;
        int i10;
        boolean z4;
        boolean z5;
        int i11;
        int i12;
        boolean z7;
        int i13;
        ?? r14;
        boolean z8;
        int i14;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i5);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, paddingTop, -2);
        int i15 = size - paddingLeft;
        int i16 = this.f1294oz;
        int i17 = i15 / i16;
        int i18 = i15 % i16;
        if (i17 == 0) {
            setMeasuredDimension(i15, 0);
            return;
        }
        int i19 = i16 + (i18 / i17);
        int childCount = getChildCount();
        int i20 = 0;
        int i21 = 0;
        boolean z9 = false;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        long j2 = 0;
        while (i21 < childCount) {
            View childAt = getChildAt(i21);
            int i25 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z10 = childAt instanceof ActionMenuItemView;
                int i26 = i22 + 1;
                if (z10) {
                    int i27 = this.f1297ut;
                    i13 = i26;
                    r14 = 0;
                    childAt.setPadding(i27, 0, i27, 0);
                } else {
                    i13 = i26;
                    r14 = 0;
                }
                zn znVar = (zn) childAt.getLayoutParams();
                znVar.f1299a = r14;
                znVar.f1303zn = r14;
                znVar.f1301n3 = r14;
                znVar.f1300gv = r14;
                ((LinearLayout.LayoutParams) znVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) znVar).rightMargin = r14;
                if (z10 && ((ActionMenuItemView) childAt).a()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                znVar.f1302v = z8;
                if (znVar.y) {
                    i14 = 1;
                } else {
                    i14 = i17;
                }
                int b2 = b(childAt, i19, i14, childMeasureSpec, paddingTop);
                i23 = Math.max(i23, b2);
                if (znVar.f1300gv) {
                    i24++;
                }
                if (znVar.y) {
                    z9 = true;
                }
                i17 -= b2;
                i20 = Math.max(i20, childAt.getMeasuredHeight());
                if (b2 == 1) {
                    j2 |= 1 << i21;
                    i20 = i20;
                }
                i22 = i13;
            }
            i21++;
            size2 = i25;
        }
        int i28 = size2;
        if (z9 && i22 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z11 = false;
        while (i24 > 0 && i17 > 0) {
            int i29 = 0;
            int i30 = 0;
            int i31 = Integer.MAX_VALUE;
            long j4 = 0;
            while (i30 < childCount) {
                boolean z12 = z11;
                zn znVar2 = (zn) getChildAt(i30).getLayoutParams();
                int i32 = i20;
                if (znVar2.f1300gv) {
                    int i33 = znVar2.f1301n3;
                    if (i33 < i31) {
                        j4 = 1 << i30;
                        i31 = i33;
                        i29 = 1;
                    } else if (i33 == i31) {
                        i29++;
                        j4 |= 1 << i30;
                    }
                }
                i30++;
                i20 = i32;
                z11 = z12;
            }
            z3 = z11;
            i10 = i20;
            j2 |= j4;
            if (i29 > i17) {
                i6 = mode;
                i8 = i15;
                break;
            }
            int i34 = i31 + 1;
            int i35 = 0;
            while (i35 < childCount) {
                View childAt2 = getChildAt(i35);
                zn znVar3 = (zn) childAt2.getLayoutParams();
                int i36 = i15;
                int i37 = mode;
                long j6 = 1 << i35;
                if ((j4 & j6) == 0) {
                    if (znVar3.f1301n3 == i34) {
                        j2 |= j6;
                    }
                    z7 = z2;
                } else {
                    if (z2 && znVar3.f1302v && i17 == 1) {
                        int i38 = this.f1297ut;
                        z7 = z2;
                        childAt2.setPadding(i38 + i19, 0, i38, 0);
                    } else {
                        z7 = z2;
                    }
                    znVar3.f1301n3++;
                    znVar3.f1299a = true;
                    i17--;
                }
                i35++;
                mode = i37;
                i15 = i36;
                z2 = z7;
            }
            i20 = i10;
            z11 = true;
        }
        i6 = mode;
        i8 = i15;
        z3 = z11;
        i10 = i20;
        if (!z9 && i22 == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (i17 > 0 && j2 != 0 && (i17 < i22 - 1 || z4 || i23 > 1)) {
            float bitCount = Long.bitCount(j2);
            if (!z4) {
                if ((j2 & 1) != 0 && !((zn) getChildAt(0).getLayoutParams()).f1302v) {
                    bitCount -= 0.5f;
                }
                int i39 = childCount - 1;
                if ((j2 & (1 << i39)) != 0 && !((zn) getChildAt(i39).getLayoutParams()).f1302v) {
                    bitCount -= 0.5f;
                }
            }
            if (bitCount > 0.0f) {
                i12 = (int) ((i17 * i19) / bitCount);
            } else {
                i12 = 0;
            }
            z5 = z3;
            for (int i40 = 0; i40 < childCount; i40++) {
                if ((j2 & (1 << i40)) != 0) {
                    View childAt3 = getChildAt(i40);
                    zn znVar4 = (zn) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        znVar4.f1303zn = i12;
                        znVar4.f1299a = true;
                        if (i40 == 0 && !znVar4.f1302v) {
                            ((LinearLayout.LayoutParams) znVar4).leftMargin = (-i12) / 2;
                        }
                    } else if (znVar4.y) {
                        znVar4.f1303zn = i12;
                        znVar4.f1299a = true;
                        ((LinearLayout.LayoutParams) znVar4).rightMargin = (-i12) / 2;
                    } else {
                        if (i40 != 0) {
                            ((LinearLayout.LayoutParams) znVar4).leftMargin = i12 / 2;
                        }
                        if (i40 != childCount - 1) {
                            ((LinearLayout.LayoutParams) znVar4).rightMargin = i12 / 2;
                        }
                    }
                    z5 = true;
                }
            }
        } else {
            z5 = z3;
        }
        if (z5) {
            for (int i41 = 0; i41 < childCount; i41++) {
                View childAt4 = getChildAt(i41);
                zn znVar5 = (zn) childAt4.getLayoutParams();
                if (znVar5.f1299a) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((znVar5.f1301n3 * i19) + znVar5.f1303zn, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i6 != 1073741824) {
            i11 = i10;
        } else {
            i11 = i28;
        }
        setMeasuredDimension(i8, i11);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: mg */
    public zn wz(AttributeSet attributeSet) {
        return new zn(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.y yVar = this.f1287b;
        if (yVar != null) {
            yVar.a(false);
            if (this.f1287b.ta()) {
                this.f1287b.fh();
                this.f1287b.x();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fh();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int i10;
        int width;
        int i11;
        if (!this.f1293o) {
            super.onLayout(z2, i, i5, i6, i8);
            return;
        }
        int childCount = getChildCount();
        int i12 = (i8 - i5) / 2;
        int dividerWidth = getDividerWidth();
        int i13 = i6 - i;
        int paddingRight = (i13 - getPaddingRight()) - getPaddingLeft();
        boolean n32 = oz.n3(this);
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                zn znVar = (zn) childAt.getLayoutParams();
                if (znVar.y) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (z6(i16)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (n32) {
                        i11 = getPaddingLeft() + ((LinearLayout.LayoutParams) znVar).leftMargin;
                        width = i11 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) znVar).rightMargin;
                        i11 = width - measuredWidth;
                    }
                    int i17 = i12 - (measuredHeight / 2);
                    childAt.layout(i11, i17, width, measuredHeight + i17);
                    paddingRight -= measuredWidth;
                    i14 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) znVar).leftMargin) + ((LinearLayout.LayoutParams) znVar).rightMargin;
                    z6(i16);
                    i15++;
                }
            }
        }
        if (childCount == 1 && i14 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i18 = (i13 / 2) - (measuredWidth2 / 2);
            int i19 = i12 - (measuredHeight2 / 2);
            childAt2.layout(i18, i19, measuredWidth2 + i18, measuredHeight2 + i19);
            return;
        }
        int i20 = i15 - (i14 ^ 1);
        if (i20 > 0) {
            i10 = paddingRight / i20;
        } else {
            i10 = 0;
        }
        int max = Math.max(0, i10);
        if (n32) {
            int width2 = getWidth() - getPaddingRight();
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt3 = getChildAt(i21);
                zn znVar2 = (zn) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !znVar2.y) {
                    int i22 = width2 - ((LinearLayout.LayoutParams) znVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i23 = i12 - (measuredHeight3 / 2);
                    childAt3.layout(i22 - measuredWidth3, i23, i22, measuredHeight3 + i23);
                    width2 = i22 - ((measuredWidth3 + ((LinearLayout.LayoutParams) znVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i24 = 0; i24 < childCount; i24++) {
            View childAt4 = getChildAt(i24);
            zn znVar3 = (zn) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !znVar3.y) {
                int i25 = paddingLeft + ((LinearLayout.LayoutParams) znVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i26 = i12 - (measuredHeight4 / 2);
                childAt4.layout(i25, i26, i25 + measuredWidth4, measuredHeight4 + i26);
                paddingLeft = i25 + measuredWidth4 + ((LinearLayout.LayoutParams) znVar3).rightMargin + max;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i5) {
        boolean z2;
        androidx.appcompat.view.menu.v vVar;
        boolean z3 = this.f1293o;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f1293o = z2;
        if (z3 != z2) {
            this.f1291j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f1293o && (vVar = this.f1290fh) != null && size != this.f1291j) {
            this.f1291j = size;
            vVar.x(true);
        }
        int childCount = getChildCount();
        if (this.f1293o && childCount > 0) {
            k5(i, i5);
            return;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            zn znVar = (zn) getChildAt(i6).getLayoutParams();
            ((LinearLayout.LayoutParams) znVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) znVar).leftMargin = 0;
        }
        super.onMeasure(i, i5);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: rz */
    public zn tl() {
        zn znVar = new zn(-2, -2);
        ((LinearLayout.LayoutParams) znVar).gravity = 16;
        return znVar;
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.f1287b.z6(z2);
    }

    public void setOnMenuItemClickListener(v vVar) {
        this.f1295q9 = vVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.f1287b.ud(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.f1298x = z2;
    }

    public void setPopupTheme(int i) {
        if (this.f1289ej != i) {
            this.f1289ej = i;
            if (i == 0) {
                this.f1288d = getContext();
            } else {
                this.f1288d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.y yVar) {
        this.f1287b = yVar;
        yVar.ej(this);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: ta */
    public zn xc(ViewGroup.LayoutParams layoutParams) {
        zn znVar;
        if (layoutParams != null) {
            if (layoutParams instanceof zn) {
                znVar = new zn((zn) layoutParams);
            } else {
                znVar = new zn(layoutParams);
            }
            if (((LinearLayout.LayoutParams) znVar).gravity <= 0) {
                ((LinearLayout.LayoutParams) znVar).gravity = 16;
            }
            return znVar;
        }
        return tl();
    }

    public boolean ud() {
        androidx.appcompat.widget.y yVar = this.f1287b;
        if (yVar != null && yVar.mg()) {
            return true;
        }
        return false;
    }

    public void vl(c5.y yVar, v.y yVar2) {
        this.f1292j5 = yVar;
        this.f1296qn = yVar2;
    }

    public boolean x() {
        return this.f1298x;
    }

    @Override // androidx.appcompat.view.menu.i9
    public void y(androidx.appcompat.view.menu.v vVar) {
        this.f1290fh = vVar;
    }

    public androidx.appcompat.view.menu.v yt() {
        return this.f1290fh;
    }

    public boolean z6(int i) {
        boolean z2 = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof y)) {
            z2 = ((y) childAt).y();
        }
        if (i > 0 && (childAt2 instanceof y)) {
            return z2 | ((y) childAt2).n3();
        }
        return z2;
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f1294oz = (int) (56.0f * f4);
        this.f1297ut = (int) (f4 * 4.0f);
        this.f1288d = context;
        this.f1289ej = 0;
    }
}
