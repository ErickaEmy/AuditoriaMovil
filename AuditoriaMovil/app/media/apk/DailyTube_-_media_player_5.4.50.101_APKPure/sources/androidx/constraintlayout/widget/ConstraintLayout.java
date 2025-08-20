package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.n3;
import java.util.ArrayList;
import java.util.HashMap;
import n.a;
import n.f;
import n.fb;
import n.gv;
import n.i9;
import n.v;
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<n.v> f1610b;

    /* renamed from: c  reason: collision with root package name */
    public int f1611c;

    /* renamed from: co  reason: collision with root package name */
    public int f1612co;

    /* renamed from: d  reason: collision with root package name */
    public int f1613d;

    /* renamed from: d0  reason: collision with root package name */
    public int f1614d0;

    /* renamed from: ej  reason: collision with root package name */
    public int f1615ej;

    /* renamed from: f  reason: collision with root package name */
    public int f1616f;

    /* renamed from: f3  reason: collision with root package name */
    public int f1617f3;

    /* renamed from: fb  reason: collision with root package name */
    public a f1618fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f1619fh;

    /* renamed from: j5  reason: collision with root package name */
    public zn f1620j5;

    /* renamed from: n  reason: collision with root package name */
    public HashMap<String, Integer> f1621n;

    /* renamed from: o  reason: collision with root package name */
    public int f1622o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1623p;

    /* renamed from: qn  reason: collision with root package name */
    public int f1624qn;

    /* renamed from: r  reason: collision with root package name */
    public d0.y f1625r;

    /* renamed from: s  reason: collision with root package name */
    public int f1626s;

    /* renamed from: t  reason: collision with root package name */
    public int f1627t;

    /* renamed from: v  reason: collision with root package name */
    public ArrayList<androidx.constraintlayout.widget.n3> f1628v;

    /* renamed from: w  reason: collision with root package name */
    public int f1629w;

    /* renamed from: x  reason: collision with root package name */
    public int f1630x;
    public SparseArray<View> y;

    /* renamed from: z  reason: collision with root package name */
    public androidx.constraintlayout.widget.zn f1631z;

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[v.n3.values().length];
            y = iArr;
            try {
                iArr[v.n3.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[v.n3.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[v.n3.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[v.n3.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn implements n3.InterfaceC0040n3 {

        /* renamed from: a  reason: collision with root package name */
        public int f1698a;

        /* renamed from: fb  reason: collision with root package name */
        public int f1699fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f1700gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f1701n3;

        /* renamed from: v  reason: collision with root package name */
        public int f1703v;
        public ConstraintLayout y;

        /* renamed from: zn  reason: collision with root package name */
        public int f1704zn;

        public zn(ConstraintLayout constraintLayout) {
            this.y = constraintLayout;
        }

        public final boolean gv(int i, int i5, int i6) {
            if (i == i5) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i5);
            int size = View.MeasureSpec.getSize(i5);
            if (mode2 == 1073741824) {
                if ((mode == Integer.MIN_VALUE || mode == 0) && i6 == size) {
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // c.n3.InterfaceC0040n3
        @SuppressLint({"WrongCall"})
        public final void n3(n.v vVar, n3.y yVar) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z7;
            boolean z8;
            int baseline;
            int i;
            int i5;
            int i6;
            int i8;
            int i10;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            if (vVar == null) {
                return;
            }
            if (vVar.j5() == 8 && !vVar.jz()) {
                yVar.f3923v = 0;
                yVar.f3916a = 0;
                yVar.f3918fb = 0;
            } else if (vVar.ud() == null) {
            } else {
                v.n3 n3Var = yVar.y;
                v.n3 n3Var2 = yVar.f3921n3;
                int i11 = yVar.f3924zn;
                int i12 = yVar.f3919gv;
                int i13 = this.f1701n3 + this.f1704zn;
                int i14 = this.f1700gv;
                View view = (View) vVar.p();
                int[] iArr = y.y;
                int i15 = iArr[n3Var.ordinal()];
                if (i15 != 1) {
                    if (i15 != 2) {
                        if (i15 != 3) {
                            if (i15 != 4) {
                                makeMeasureSpec = 0;
                            } else {
                                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1698a, i14, -2);
                                if (vVar.f11751w == 1) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                int i16 = yVar.f3920i9;
                                if (i16 == n3.y.f3914t || i16 == n3.y.f3915tl) {
                                    if (view.getMeasuredHeight() == vVar.x4()) {
                                        z14 = true;
                                    } else {
                                        z14 = false;
                                    }
                                    if (yVar.f3920i9 == n3.y.f3915tl || !z13 || ((z13 && z14) || (view instanceof v) || vVar.dm())) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(vVar.qn(), 1073741824);
                                    }
                                }
                            }
                        } else {
                            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1698a, i14 + vVar.c(), -1);
                        }
                    } else {
                        makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1698a, i14, -2);
                    }
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
                }
                int i17 = iArr[n3Var2.ordinal()];
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            if (i17 != 4) {
                                makeMeasureSpec2 = 0;
                            } else {
                                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1699fb, i13, -2);
                                if (vVar.f11729p == 1) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                int i18 = yVar.f3920i9;
                                if (i18 == n3.y.f3914t || i18 == n3.y.f3915tl) {
                                    if (view.getMeasuredWidth() == vVar.qn()) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (yVar.f3920i9 == n3.y.f3915tl || !z11 || ((z11 && z12) || (view instanceof v) || vVar.ct())) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(vVar.x4(), 1073741824);
                                    }
                                }
                            }
                        } else {
                            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1699fb, i13 + vVar.hw(), -1);
                        }
                    } else {
                        makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1699fb, i13, -2);
                    }
                } else {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                }
                a aVar = (a) vVar.ud();
                if (aVar != null && i9.n3(ConstraintLayout.this.f1612co, 256) && view.getMeasuredWidth() == vVar.qn() && view.getMeasuredWidth() < aVar.qn() && view.getMeasuredHeight() == vVar.x4() && view.getMeasuredHeight() < aVar.x4() && view.getBaseline() == vVar.wz() && !vVar.xg() && gv(vVar.d0(), makeMeasureSpec, vVar.qn()) && gv(vVar.fh(), makeMeasureSpec2, vVar.x4())) {
                    yVar.f3923v = vVar.qn();
                    yVar.f3916a = vVar.x4();
                    yVar.f3918fb = vVar.wz();
                    return;
                }
                v.n3 n3Var3 = v.n3.MATCH_CONSTRAINT;
                if (n3Var == n3Var3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (n3Var2 == n3Var3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                v.n3 n3Var4 = v.n3.MATCH_PARENT;
                if (n3Var2 != n3Var4 && n3Var2 != v.n3.FIXED) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (n3Var != n3Var4 && n3Var != v.n3.FIXED) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (z2 && vVar.f11732q9 > 0.0f) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z3 && vVar.f11732q9 > 0.0f) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (view == null) {
                    return;
                }
                n3 n3Var5 = (n3) view.getLayoutParams();
                int i19 = yVar.f3920i9;
                if (i19 != n3.y.f3914t && i19 != n3.y.f3915tl && z2 && vVar.f11751w == 0 && z3 && vVar.f11729p == 0) {
                    i10 = -1;
                    i6 = 0;
                    baseline = 0;
                    i = 0;
                } else {
                    if ((view instanceof d0.zn) && (vVar instanceof f)) {
                        ((d0.zn) view).xc((f) vVar, makeMeasureSpec, makeMeasureSpec2);
                    } else {
                        view.measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                    vVar.wf(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    int i20 = vVar.f11693co;
                    if (i20 > 0) {
                        i = Math.max(i20, measuredWidth);
                    } else {
                        i = measuredWidth;
                    }
                    int i21 = vVar.f11762z;
                    if (i21 > 0) {
                        i = Math.min(i21, i);
                    }
                    int i22 = vVar.f11754x4;
                    if (i22 > 0) {
                        i6 = Math.max(i22, measuredHeight);
                        i5 = makeMeasureSpec;
                    } else {
                        i5 = makeMeasureSpec;
                        i6 = measuredHeight;
                    }
                    int i23 = vVar.f11711i4;
                    if (i23 > 0) {
                        i6 = Math.min(i23, i6);
                    }
                    if (!i9.n3(ConstraintLayout.this.f1612co, 1)) {
                        if (z7 && z4) {
                            i = (int) ((i6 * vVar.f11732q9) + 0.5f);
                        } else if (z8 && z5) {
                            i6 = (int) ((i / vVar.f11732q9) + 0.5f);
                        }
                    }
                    if (measuredWidth != i || measuredHeight != i6) {
                        if (measuredWidth != i) {
                            i8 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                        } else {
                            i8 = i5;
                        }
                        if (measuredHeight != i6) {
                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                        }
                        view.measure(i8, makeMeasureSpec2);
                        vVar.wf(i8, makeMeasureSpec2);
                        i = view.getMeasuredWidth();
                        i6 = view.getMeasuredHeight();
                        baseline = view.getBaseline();
                    }
                    i10 = -1;
                }
                if (baseline != i10) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (i == yVar.f3924zn && i6 == yVar.f3919gv) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                yVar.f3917c5 = z10;
                if (n3Var5.f1649f7) {
                    z9 = true;
                }
                if (z9 && baseline != -1 && vVar.wz() != baseline) {
                    yVar.f3917c5 = true;
                }
                yVar.f3923v = i;
                yVar.f3916a = i6;
                yVar.f3922s = z9;
                yVar.f3918fb = baseline;
            }
        }

        @Override // c.n3.InterfaceC0040n3
        public final void y() {
            int childCount = this.y.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.y.getChildAt(i);
                if (childAt instanceof v) {
                    ((v) childAt).y(this.y);
                }
            }
            int size = this.y.f1628v.size();
            if (size > 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    ((androidx.constraintlayout.widget.n3) this.y.f1628v.get(i5)).f(this.y);
                }
            }
        }

        public void zn(int i, int i5, int i6, int i8, int i10, int i11) {
            this.f1701n3 = i6;
            this.f1704zn = i8;
            this.f1700gv = i10;
            this.f1703v = i11;
            this.f1698a = i;
            this.f1699fb = i5;
        }
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new SparseArray<>();
        this.f1628v = new ArrayList<>(4);
        this.f1618fb = new a();
        this.f1626s = 0;
        this.f1616f = 0;
        this.f1627t = Integer.MAX_VALUE;
        this.f1629w = Integer.MAX_VALUE;
        this.f1623p = true;
        this.f1612co = 257;
        this.f1631z = null;
        this.f1625r = null;
        this.f1617f3 = -1;
        this.f1621n = new HashMap<>();
        this.f1611c = -1;
        this.f1614d0 = -1;
        this.f1619fh = -1;
        this.f1613d = -1;
        this.f1615ej = 0;
        this.f1630x = 0;
        this.f1610b = new SparseArray<>();
        this.f1620j5 = new zn(this);
        this.f1624qn = 0;
        this.f1622o = 0;
        f(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public n3 generateLayoutParams(AttributeSet attributeSet) {
        return new n3(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    public View c5(int i) {
        return this.y.get(i);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof n3;
    }

    public void co(a aVar, int i, int i5, int i6, int i8) {
        v.n3 n3Var;
        zn znVar = this.f1620j5;
        int i10 = znVar.f1703v;
        int i11 = znVar.f1700gv;
        v.n3 n3Var2 = v.n3.FIXED;
        int childCount = getChildCount();
        if (i != Integer.MIN_VALUE) {
            if (i != 0) {
                if (i != 1073741824) {
                    n3Var = n3Var2;
                    i5 = 0;
                } else {
                    i5 = Math.min(this.f1627t - i11, i5);
                    n3Var = n3Var2;
                }
            } else {
                n3Var = v.n3.WRAP_CONTENT;
                if (childCount == 0) {
                    i5 = Math.max(0, this.f1626s);
                }
                i5 = 0;
            }
        } else {
            n3Var = v.n3.WRAP_CONTENT;
            if (childCount == 0) {
                i5 = Math.max(0, this.f1626s);
            }
        }
        if (i6 != Integer.MIN_VALUE) {
            if (i6 != 0) {
                if (i6 == 1073741824) {
                    i8 = Math.min(this.f1629w - i10, i8);
                }
                i8 = 0;
            } else {
                n3Var2 = v.n3.WRAP_CONTENT;
                if (childCount == 0) {
                    i8 = Math.max(0, this.f1616f);
                }
                i8 = 0;
            }
        } else {
            n3Var2 = v.n3.WRAP_CONTENT;
            if (childCount == 0) {
                i8 = Math.max(0, this.f1616f);
            }
        }
        if (i5 != aVar.qn() || i8 != aVar.x4()) {
            aVar.k3();
        }
        aVar.ro(0);
        aVar.ix(0);
        aVar.cy(this.f1627t - i11);
        aVar.ad(this.f1629w - i10);
        aVar.l(0);
        aVar.qj(0);
        aVar.tg(n3Var);
        aVar.cs(i5);
        aVar.x5(n3Var2);
        aVar.g(i8);
        aVar.l(this.f1626s - i11);
        aVar.qj(this.f1616f - i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.n3> arrayList = this.f1628v;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.f1628v.get(i).t(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i6 = (int) ((parseInt / 1080.0f) * width);
                        int i8 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f4 = i6;
                        float f6 = i8;
                        float f9 = i6 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f4, f6, f9, f6, paint);
                        float parseInt4 = i8 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f9, f6, f9, parseInt4, paint);
                        canvas.drawLine(f9, parseInt4, f4, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f4, f6, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f4, f6, f9, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f9, f6, paint);
                    }
                }
            }
        }
    }

    public final void f(AttributeSet attributeSet, int i, int i5) {
        this.f1618fb.ra(this);
        this.f1618fb.hr(this.f1620j5);
        this.y.put(getId(), this);
        this.f1631z = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1867vn, i, i5);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                if (index == R$styleable.f1804nd) {
                    this.f1626s = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1626s);
                } else if (index == R$styleable.gf) {
                    this.f1616f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1616f);
                } else if (index == R$styleable.f1825q) {
                    this.f1627t = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1627t);
                } else if (index == R$styleable.f1874wm) {
                    this.f1629w = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1629w);
                } else if (index == R$styleable.eu) {
                    this.f1612co = obtainStyledAttributes.getInt(index, this.f1612co);
                } else if (index == R$styleable.c8) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            wz(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1625r = null;
                        }
                    }
                } else if (index == R$styleable.im) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.zn znVar = new androidx.constraintlayout.widget.zn();
                        this.f1631z = znVar;
                        znVar.xc(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1631z = null;
                    }
                    this.f1617f3 = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1618fb.cx(this.f1612co);
    }

    public Object fb(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.f1621n;
            if (hashMap != null && hashMap.containsKey(str)) {
                return this.f1621n.get(str);
            }
            return null;
        }
        return null;
    }

    @Override // android.view.View
    public void forceLayout() {
        tl();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.f1629w;
    }

    public int getMaxWidth() {
        return this.f1627t;
    }

    public int getMinHeight() {
        return this.f1616f;
    }

    public int getMinWidth() {
        return this.f1626s;
    }

    public int getOptimizationLevel() {
        return this.f1618fb.jr();
    }

    public void gv(boolean z2, View view, n.v vVar, n3 n3Var, SparseArray<n.v> sparseArray) {
        float f4;
        n.v vVar2;
        n.v vVar3;
        n.v vVar4;
        n.v vVar5;
        int i;
        n3Var.y();
        n3Var.f1634ap = false;
        vVar.le(view.getVisibility());
        if (n3Var.f1682u) {
            vVar.o0(true);
            vVar.le(8);
        }
        vVar.ra(view);
        if (view instanceof androidx.constraintlayout.widget.n3) {
            ((androidx.constraintlayout.widget.n3) view).c5(vVar, this.f1618fb.gn());
        }
        if (n3Var.f1646en) {
            fb fbVar = (fb) vVar;
            int i5 = n3Var.f1666nf;
            int i6 = n3Var.f1674ra;
            float f6 = n3Var.f1643e;
            if (f6 != -1.0f) {
                fbVar.fc(f6);
                return;
            } else if (i5 != -1) {
                fbVar.gf(i5);
                return;
            } else if (i6 != -1) {
                fbVar.bv(i6);
                return;
            } else {
                return;
            }
        }
        int i8 = n3Var.f1692xg;
        int i10 = n3Var.f1642dm;
        int i11 = n3Var.f1639ct;
        int i12 = n3Var.f1668o4;
        int i13 = n3Var.f1675rs;
        int i14 = n3Var.f1644eb;
        float f9 = n3Var.f1661lc;
        int i15 = n3Var.f1681tl;
        if (i15 != -1) {
            n.v vVar6 = sparseArray.get(i15);
            if (vVar6 != null) {
                vVar.i9(vVar6, n3Var.f1691xc, n3Var.f1688wz);
            }
        } else {
            if (i8 != -1) {
                n.v vVar7 = sparseArray.get(i8);
                if (vVar7 != null) {
                    gv.n3 n3Var2 = gv.n3.LEFT;
                    f4 = f9;
                    vVar.k(n3Var2, vVar7, n3Var2, ((ViewGroup.MarginLayoutParams) n3Var).leftMargin, i13);
                } else {
                    f4 = f9;
                }
            } else {
                f4 = f9;
                if (i10 != -1 && (vVar2 = sparseArray.get(i10)) != null) {
                    vVar.k(gv.n3.LEFT, vVar2, gv.n3.RIGHT, ((ViewGroup.MarginLayoutParams) n3Var).leftMargin, i13);
                }
            }
            if (i11 != -1) {
                n.v vVar8 = sparseArray.get(i11);
                if (vVar8 != null) {
                    vVar.k(gv.n3.RIGHT, vVar8, gv.n3.LEFT, ((ViewGroup.MarginLayoutParams) n3Var).rightMargin, i14);
                }
            } else if (i12 != -1 && (vVar3 = sparseArray.get(i12)) != null) {
                gv.n3 n3Var3 = gv.n3.RIGHT;
                vVar.k(n3Var3, vVar3, n3Var3, ((ViewGroup.MarginLayoutParams) n3Var).rightMargin, i14);
            }
            int i16 = n3Var.f1677s;
            if (i16 != -1) {
                n.v vVar9 = sparseArray.get(i16);
                if (vVar9 != null) {
                    gv.n3 n3Var4 = gv.n3.TOP;
                    vVar.k(n3Var4, vVar9, n3Var4, ((ViewGroup.MarginLayoutParams) n3Var).topMargin, n3Var.f1673r);
                }
            } else {
                int i17 = n3Var.f1637c5;
                if (i17 != -1 && (vVar4 = sparseArray.get(i17)) != null) {
                    vVar.k(gv.n3.TOP, vVar4, gv.n3.BOTTOM, ((ViewGroup.MarginLayoutParams) n3Var).topMargin, n3Var.f1673r);
                }
            }
            int i18 = n3Var.f1655i9;
            if (i18 != -1) {
                n.v vVar10 = sparseArray.get(i18);
                if (vVar10 != null) {
                    vVar.k(gv.n3.BOTTOM, vVar10, gv.n3.TOP, ((ViewGroup.MarginLayoutParams) n3Var).bottomMargin, n3Var.f1654i4);
                }
            } else {
                int i19 = n3Var.f1647f;
                if (i19 != -1 && (vVar5 = sparseArray.get(i19)) != null) {
                    gv.n3 n3Var5 = gv.n3.BOTTOM;
                    vVar.k(n3Var5, vVar5, n3Var5, ((ViewGroup.MarginLayoutParams) n3Var).bottomMargin, n3Var.f1654i4);
                }
            }
            int i20 = n3Var.f1679t;
            if (i20 != -1) {
                View view2 = this.y.get(i20);
                n.v vVar11 = sparseArray.get(n3Var.f1679t);
                if (vVar11 != null && view2 != null && (view2.getLayoutParams() instanceof n3)) {
                    n3 n3Var6 = (n3) view2.getLayoutParams();
                    n3Var.f1649f7 = true;
                    n3Var6.f1649f7 = true;
                    gv.n3 n3Var7 = gv.n3.BASELINE;
                    vVar.tl(n3Var7).y(vVar11.tl(n3Var7), 0, -1, true);
                    vVar.m(true);
                    n3Var6.f1678s8.m(true);
                    vVar.tl(gv.n3.TOP).w();
                    vVar.tl(gv.n3.BOTTOM).w();
                }
            }
            float f10 = f4;
            if (f10 >= 0.0f) {
                vVar.u0(f10);
            }
            float f11 = n3Var.f1641d0;
            if (f11 >= 0.0f) {
                vVar.oa(f11);
            }
        }
        if (z2 && ((i = n3Var.f1657j5) != -1 || n3Var.f1672qn != -1)) {
            vVar.gq(i, n3Var.f1672qn);
        }
        if (!n3Var.f1671q9) {
            if (((ViewGroup.MarginLayoutParams) n3Var).width == -1) {
                if (n3Var.f1656j) {
                    vVar.tg(v.n3.MATCH_CONSTRAINT);
                } else {
                    vVar.tg(v.n3.MATCH_PARENT);
                }
                vVar.tl(gv.n3.LEFT).f11669fb = ((ViewGroup.MarginLayoutParams) n3Var).leftMargin;
                vVar.tl(gv.n3.RIGHT).f11669fb = ((ViewGroup.MarginLayoutParams) n3Var).rightMargin;
            } else {
                vVar.tg(v.n3.MATCH_CONSTRAINT);
                vVar.cs(0);
            }
        } else {
            vVar.tg(v.n3.FIXED);
            vVar.cs(((ViewGroup.MarginLayoutParams) n3Var).width);
            if (((ViewGroup.MarginLayoutParams) n3Var).width == -2) {
                vVar.tg(v.n3.WRAP_CONTENT);
            }
        }
        if (!n3Var.f1659k) {
            if (((ViewGroup.MarginLayoutParams) n3Var).height == -1) {
                if (n3Var.f1669oz) {
                    vVar.x5(v.n3.MATCH_CONSTRAINT);
                } else {
                    vVar.x5(v.n3.MATCH_PARENT);
                }
                vVar.tl(gv.n3.TOP).f11669fb = ((ViewGroup.MarginLayoutParams) n3Var).topMargin;
                vVar.tl(gv.n3.BOTTOM).f11669fb = ((ViewGroup.MarginLayoutParams) n3Var).bottomMargin;
            } else {
                vVar.x5(v.n3.MATCH_CONSTRAINT);
                vVar.g(0);
            }
        } else {
            vVar.x5(v.n3.FIXED);
            vVar.g(((ViewGroup.MarginLayoutParams) n3Var).height);
            if (((ViewGroup.MarginLayoutParams) n3Var).height == -2) {
                vVar.x5(v.n3.WRAP_CONTENT);
            }
        }
        vVar.s8(n3Var.f1651fh);
        vVar.pq(n3Var.f1680ta);
        vVar.mp(n3Var.f1640d);
        vVar.bk(n3Var.f1696z6);
        vVar.w9(n3Var.f1645ej);
        vVar.pz(n3Var.f1683ud, n3Var.f1689x, n3Var.f1660k5, n3Var.f1686vl);
        vVar.q5(n3Var.f1633a8, n3Var.f1635b, n3Var.f1694yt, n3Var.f1653hw);
    }

    public final n.v i9(View view) {
        if (view == this) {
            return this.f1618fb;
        }
        if (view == null) {
            return null;
        }
        return ((n3) view.getLayoutParams()).f1678s8;
    }

    public void mt(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1621n == null) {
                this.f1621n = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f1621n.put(str, num);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            n3 n3Var = (n3) childAt.getLayoutParams();
            n.v vVar = n3Var.f1678s8;
            if ((childAt.getVisibility() != 8 || n3Var.f1646en || n3Var.f1658jz || n3Var.f1693y5 || isInEditMode) && !n3Var.f1682u) {
                int o2 = vVar.o();
                int j2 = vVar.j();
                int qn2 = vVar.qn() + o2;
                int x42 = vVar.x4() + j2;
                childAt.layout(o2, j2, qn2, x42);
                if ((childAt instanceof v) && (content = ((v) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(o2, j2, qn2, x42);
                }
            }
        }
        int size = this.f1628v.size();
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                this.f1628v.get(i11).i9(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        if (!this.f1623p) {
            int childCount = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                } else if (getChildAt(i6).isLayoutRequested()) {
                    this.f1623p = true;
                    break;
                } else {
                    i6++;
                }
            }
        }
        if (!this.f1623p) {
            int i8 = this.f1624qn;
            if (i8 == i && this.f1622o == i5) {
                xc(i, i5, this.f1618fb.qn(), this.f1618fb.x4(), this.f1618fb.vc(), this.f1618fb.ic());
                return;
            } else if (i8 == i && View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.f1622o) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i5) >= this.f1618fb.x4()) {
                this.f1624qn = i;
                this.f1622o = i5;
                xc(i, i5, this.f1618fb.qn(), this.f1618fb.x4(), this.f1618fb.vc(), this.f1618fb.ic());
                return;
            }
        }
        this.f1624qn = i;
        this.f1622o = i5;
        this.f1618fb.vh(t());
        if (this.f1623p) {
            this.f1623p = false;
            if (z()) {
                this.f1618fb.xq();
            }
        }
        w(this.f1618fb, this.f1612co, i, i5);
        xc(i, i5, this.f1618fb.qn(), this.f1618fb.x4(), this.f1618fb.vc(), this.f1618fb.ic());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        n.v i92 = i9(view);
        if ((view instanceof Guideline) && !(i92 instanceof fb)) {
            n3 n3Var = (n3) view.getLayoutParams();
            fb fbVar = new fb();
            n3Var.f1678s8 = fbVar;
            n3Var.f1646en = true;
            fbVar.br(n3Var.f1667o);
        }
        if (view instanceof androidx.constraintlayout.widget.n3) {
            androidx.constraintlayout.widget.n3 n3Var2 = (androidx.constraintlayout.widget.n3) view;
            n3Var2.wz();
            ((n3) view.getLayoutParams()).f1658jz = true;
            if (!this.f1628v.contains(n3Var2)) {
                this.f1628v.add(n3Var2);
            }
        }
        this.y.put(view.getId(), view);
        this.f1623p = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.y.remove(view.getId());
        this.f1618fb.ne(i9(view));
        this.f1628v.remove(view);
        this.f1623p = true;
    }

    public final void p() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            n.v i92 = i9(getChildAt(i));
            if (i92 != null) {
                i92.rs();
            }
        }
        if (isInEditMode) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    mt(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    s(childAt.getId()).e(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f1617f3 != -1) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt2 = getChildAt(i6);
                if (childAt2.getId() == this.f1617f3 && (childAt2 instanceof gv)) {
                    this.f1631z = ((gv) childAt2).getConstraintSet();
                }
            }
        }
        androidx.constraintlayout.widget.zn znVar = this.f1631z;
        if (znVar != null) {
            znVar.gv(this, true);
        }
        this.f1618fb.q();
        int size = this.f1628v.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f1628v.get(i8).tl(this);
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt3 = getChildAt(i10);
            if (childAt3 instanceof v) {
                ((v) childAt3).n3(this);
            }
        }
        this.f1610b.clear();
        this.f1610b.put(0, this.f1618fb);
        this.f1610b.put(getId(), this.f1618fb);
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt4 = getChildAt(i11);
            this.f1610b.put(childAt4.getId(), i9(childAt4));
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt5 = getChildAt(i12);
            n.v i93 = i9(childAt5);
            if (i93 != null) {
                n3 n3Var = (n3) childAt5.getLayoutParams();
                this.f1618fb.n3(i93);
                gv(isInEditMode, childAt5, i93, n3Var, this.f1610b);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        tl();
        super.requestLayout();
    }

    public final n.v s(int i) {
        if (i == 0) {
            return this.f1618fb;
        }
        View view = this.y.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1618fb;
        }
        if (view == null) {
            return null;
        }
        return ((n3) view.getLayoutParams()).f1678s8;
    }

    public void setConstraintSet(androidx.constraintlayout.widget.zn znVar) {
        this.f1631z = znVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.y.remove(getId());
        super.setId(i);
        this.y.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.f1629w) {
            return;
        }
        this.f1629w = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f1627t) {
            return;
        }
        this.f1627t = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f1616f) {
            return;
        }
        this.f1616f = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f1626s) {
            return;
        }
        this.f1626s = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(d0.n3 n3Var) {
        d0.y yVar = this.f1625r;
        if (yVar != null) {
            yVar.zn(n3Var);
        }
    }

    public void setOptimizationLevel(int i) {
        this.f1612co = i;
        this.f1618fb.cx(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean t() {
        if ((getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection()) {
            return true;
        }
        return false;
    }

    public final void tl() {
        this.f1623p = true;
        this.f1611c = -1;
        this.f1614d0 = -1;
        this.f1619fh = -1;
        this.f1613d = -1;
        this.f1615ej = 0;
        this.f1630x = 0;
    }

    @Override // android.view.ViewGroup
    /* renamed from: v */
    public n3 generateDefaultLayoutParams() {
        return new n3(-2, -2);
    }

    public void w(a aVar, int i, int i5, int i6) {
        int i8;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i10 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.f1620j5.zn(i5, i6, max, max2, paddingWidth, i10);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            i8 = Math.max(0, getPaddingLeft());
        } else if (t()) {
            i8 = max4;
        } else {
            i8 = max3;
        }
        int i11 = size - paddingWidth;
        int i12 = size2 - i10;
        co(aVar, mode, i11, mode2, i12);
        aVar.p1(i, mode, i11, mode2, i12, this.f1611c, this.f1614d0, i8, max);
    }

    public void wz(int i) {
        this.f1625r = new d0.y(getContext(), this, i);
    }

    public void xc(int i, int i5, int i6, int i8, boolean z2, boolean z3) {
        zn znVar = this.f1620j5;
        int i10 = znVar.f1703v;
        int resolveSizeAndState = View.resolveSizeAndState(i6 + znVar.f1700gv, i, 0);
        int min = Math.min(this.f1627t, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f1629w, View.resolveSizeAndState(i8 + i10, i5, 0) & 16777215);
        if (z2) {
            min |= 16777216;
        }
        if (z3) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.f1611c = min;
        this.f1614d0 = min2;
    }

    public final boolean z() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z2 = true;
                break;
            } else {
                i++;
            }
        }
        if (z2) {
            p();
        }
        return z2;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new n3(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = new SparseArray<>();
        this.f1628v = new ArrayList<>(4);
        this.f1618fb = new a();
        this.f1626s = 0;
        this.f1616f = 0;
        this.f1627t = Integer.MAX_VALUE;
        this.f1629w = Integer.MAX_VALUE;
        this.f1623p = true;
        this.f1612co = 257;
        this.f1631z = null;
        this.f1625r = null;
        this.f1617f3 = -1;
        this.f1621n = new HashMap<>();
        this.f1611c = -1;
        this.f1614d0 = -1;
        this.f1619fh = -1;
        this.f1613d = -1;
        this.f1615ej = 0;
        this.f1630x = 0;
        this.f1610b = new SparseArray<>();
        this.f1620j5 = new zn(this);
        this.f1624qn = 0;
        this.f1622o = 0;
        f(attributeSet, i, 0);
    }

    /* loaded from: classes.dex */
    public static class n3 extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f1632a;

        /* renamed from: a8  reason: collision with root package name */
        public int f1633a8;

        /* renamed from: ap  reason: collision with root package name */
        public boolean f1634ap;

        /* renamed from: b  reason: collision with root package name */
        public int f1635b;

        /* renamed from: c  reason: collision with root package name */
        public float f1636c;

        /* renamed from: c5  reason: collision with root package name */
        public int f1637c5;

        /* renamed from: co  reason: collision with root package name */
        public int f1638co;

        /* renamed from: ct  reason: collision with root package name */
        public int f1639ct;

        /* renamed from: d  reason: collision with root package name */
        public float f1640d;

        /* renamed from: d0  reason: collision with root package name */
        public float f1641d0;

        /* renamed from: dm  reason: collision with root package name */
        public int f1642dm;

        /* renamed from: e  reason: collision with root package name */
        public float f1643e;

        /* renamed from: eb  reason: collision with root package name */
        public int f1644eb;

        /* renamed from: ej  reason: collision with root package name */
        public int f1645ej;

        /* renamed from: en  reason: collision with root package name */
        public boolean f1646en;

        /* renamed from: f  reason: collision with root package name */
        public int f1647f;

        /* renamed from: f3  reason: collision with root package name */
        public int f1648f3;

        /* renamed from: f7  reason: collision with root package name */
        public boolean f1649f7;

        /* renamed from: fb  reason: collision with root package name */
        public int f1650fb;

        /* renamed from: fh  reason: collision with root package name */
        public String f1651fh;

        /* renamed from: gv  reason: collision with root package name */
        public int f1652gv;

        /* renamed from: hw  reason: collision with root package name */
        public float f1653hw;

        /* renamed from: i4  reason: collision with root package name */
        public int f1654i4;

        /* renamed from: i9  reason: collision with root package name */
        public int f1655i9;

        /* renamed from: j  reason: collision with root package name */
        public boolean f1656j;

        /* renamed from: j5  reason: collision with root package name */
        public int f1657j5;

        /* renamed from: jz  reason: collision with root package name */
        public boolean f1658jz;

        /* renamed from: k  reason: collision with root package name */
        public boolean f1659k;

        /* renamed from: k5  reason: collision with root package name */
        public int f1660k5;

        /* renamed from: lc  reason: collision with root package name */
        public float f1661lc;

        /* renamed from: mg  reason: collision with root package name */
        public int f1662mg;

        /* renamed from: mt  reason: collision with root package name */
        public int f1663mt;

        /* renamed from: n  reason: collision with root package name */
        public int f1664n;

        /* renamed from: n3  reason: collision with root package name */
        public int f1665n3;

        /* renamed from: nf  reason: collision with root package name */
        public int f1666nf;

        /* renamed from: o  reason: collision with root package name */
        public int f1667o;

        /* renamed from: o4  reason: collision with root package name */
        public int f1668o4;

        /* renamed from: oz  reason: collision with root package name */
        public boolean f1669oz;

        /* renamed from: p  reason: collision with root package name */
        public int f1670p;

        /* renamed from: q9  reason: collision with root package name */
        public boolean f1671q9;

        /* renamed from: qn  reason: collision with root package name */
        public int f1672qn;

        /* renamed from: r  reason: collision with root package name */
        public int f1673r;

        /* renamed from: ra  reason: collision with root package name */
        public int f1674ra;

        /* renamed from: rs  reason: collision with root package name */
        public int f1675rs;

        /* renamed from: rz  reason: collision with root package name */
        public float f1676rz;

        /* renamed from: s  reason: collision with root package name */
        public int f1677s;

        /* renamed from: s8  reason: collision with root package name */
        public n.v f1678s8;

        /* renamed from: t  reason: collision with root package name */
        public int f1679t;

        /* renamed from: ta  reason: collision with root package name */
        public float f1680ta;

        /* renamed from: tl  reason: collision with root package name */
        public int f1681tl;

        /* renamed from: u  reason: collision with root package name */
        public boolean f1682u;

        /* renamed from: ud  reason: collision with root package name */
        public int f1683ud;

        /* renamed from: ut  reason: collision with root package name */
        public String f1684ut;

        /* renamed from: v  reason: collision with root package name */
        public int f1685v;

        /* renamed from: vl  reason: collision with root package name */
        public float f1686vl;

        /* renamed from: w  reason: collision with root package name */
        public int f1687w;

        /* renamed from: wz  reason: collision with root package name */
        public int f1688wz;

        /* renamed from: x  reason: collision with root package name */
        public int f1689x;

        /* renamed from: x4  reason: collision with root package name */
        public int f1690x4;

        /* renamed from: xc  reason: collision with root package name */
        public float f1691xc;

        /* renamed from: xg  reason: collision with root package name */
        public int f1692xg;
        public int y;

        /* renamed from: y5  reason: collision with root package name */
        public boolean f1693y5;

        /* renamed from: yt  reason: collision with root package name */
        public int f1694yt;

        /* renamed from: z  reason: collision with root package name */
        public int f1695z;

        /* renamed from: z6  reason: collision with root package name */
        public int f1696z6;

        /* renamed from: zn  reason: collision with root package name */
        public float f1697zn;

        /* loaded from: classes.dex */
        public static class y {
            public static final SparseIntArray y;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                y = sparseIntArray;
                sparseIntArray.append(R$styleable.zx, 8);
                sparseIntArray.append(R$styleable.l0, 9);
                sparseIntArray.append(R$styleable.zh, 10);
                sparseIntArray.append(R$styleable.hb, 11);
                sparseIntArray.append(R$styleable.vd, 12);
                sparseIntArray.append(R$styleable.ux, 13);
                sparseIntArray.append(R$styleable.k3, 14);
                sparseIntArray.append(R$styleable.hk, 15);
                sparseIntArray.append(R$styleable.jr, 16);
                sparseIntArray.append(R$styleable.ic, 2);
                sparseIntArray.append(R$styleable.vc, 3);
                sparseIntArray.append(R$styleable.gn, 4);
                sparseIntArray.append(R$styleable.w7, 49);
                sparseIntArray.append(R$styleable.ou, 50);
                sparseIntArray.append(R$styleable.dp, 5);
                sparseIntArray.append(R$styleable.hr, 6);
                sparseIntArray.append(R$styleable.cx, 7);
                sparseIntArray.append(R$styleable.f1772j3, 1);
                sparseIntArray.append(R$styleable.ob, 17);
                sparseIntArray.append(R$styleable.vb, 18);
                sparseIntArray.append(R$styleable.rv, 19);
                sparseIntArray.append(R$styleable.i, 20);
                sparseIntArray.append(R$styleable.e5, 21);
                sparseIntArray.append(R$styleable.i1, 22);
                sparseIntArray.append(R$styleable.yh, 23);
                sparseIntArray.append(R$styleable.vi, 24);
                sparseIntArray.append(R$styleable.nh, 25);
                sparseIntArray.append(R$styleable.l3, 26);
                sparseIntArray.append(R$styleable.jb, 29);
                sparseIntArray.append(R$styleable.t5, 30);
                sparseIntArray.append(R$styleable.p1, 44);
                sparseIntArray.append(R$styleable.v1, 45);
                sparseIntArray.append(R$styleable.ks, 46);
                sparseIntArray.append(R$styleable.sw, 47);
                sparseIntArray.append(R$styleable.rt, 48);
                sparseIntArray.append(R$styleable.ia, 27);
                sparseIntArray.append(R$styleable.h, 28);
                sparseIntArray.append(R$styleable.fp, 31);
                sparseIntArray.append(R$styleable.vh, 32);
                sparseIntArray.append(R$styleable.sh, 33);
                sparseIntArray.append(R$styleable.hj, 34);
                sparseIntArray.append(R$styleable.hf, 35);
                sparseIntArray.append(R$styleable.xq, 36);
                sparseIntArray.append(R$styleable.hy, 37);
                sparseIntArray.append(R$styleable.jt, 38);
                sparseIntArray.append(R$styleable.gi, 39);
                sparseIntArray.append(R$styleable.sx, 40);
                sparseIntArray.append(R$styleable.wo, 41);
                sparseIntArray.append(R$styleable.zq, 42);
                sparseIntArray.append(R$styleable.r6, 43);
                sparseIntArray.append(R$styleable.fq, 51);
            }
        }

        public n3(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            this.y = -1;
            this.f1665n3 = -1;
            this.f1697zn = -1.0f;
            this.f1652gv = -1;
            this.f1685v = -1;
            this.f1632a = -1;
            this.f1650fb = -1;
            this.f1677s = -1;
            this.f1637c5 = -1;
            this.f1655i9 = -1;
            this.f1647f = -1;
            this.f1679t = -1;
            this.f1681tl = -1;
            this.f1687w = -1;
            this.f1670p = -1;
            this.f1663mt = -1;
            this.f1638co = -1;
            this.f1695z = -1;
            this.f1673r = -1;
            this.f1690x4 = -1;
            this.f1654i4 = -1;
            this.f1648f3 = -1;
            this.f1664n = -1;
            this.f1636c = 0.5f;
            this.f1641d0 = 0.5f;
            this.f1662mg = 1;
            this.f1680ta = -1.0f;
            this.f1640d = -1.0f;
            this.f1686vl = 1.0f;
            this.f1653hw = 1.0f;
            this.f1657j5 = -1;
            this.f1672qn = -1;
            this.f1667o = -1;
            this.f1671q9 = true;
            this.f1659k = true;
            this.f1692xg = -1;
            this.f1642dm = -1;
            this.f1639ct = -1;
            this.f1668o4 = -1;
            this.f1675rs = -1;
            this.f1644eb = -1;
            this.f1661lc = 0.5f;
            this.f1678s8 = new n.v();
            this.f1634ap = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1867vn);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                int i6 = y.y.get(index);
                switch (i6) {
                    case 1:
                        this.f1667o = obtainStyledAttributes.getInt(index, this.f1667o);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1681tl);
                        this.f1681tl = resourceId;
                        if (resourceId == -1) {
                            this.f1681tl = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f1688wz = obtainStyledAttributes.getDimensionPixelSize(index, this.f1688wz);
                        break;
                    case 4:
                        float f4 = obtainStyledAttributes.getFloat(index, this.f1691xc) % 360.0f;
                        this.f1691xc = f4;
                        if (f4 < 0.0f) {
                            this.f1691xc = (360.0f - f4) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.y = obtainStyledAttributes.getDimensionPixelOffset(index, this.y);
                        break;
                    case 6:
                        this.f1665n3 = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1665n3);
                        break;
                    case 7:
                        this.f1697zn = obtainStyledAttributes.getFloat(index, this.f1697zn);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1652gv);
                        this.f1652gv = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1652gv = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1685v);
                        this.f1685v = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1685v = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1632a);
                        this.f1632a = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1632a = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1650fb);
                        this.f1650fb = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1650fb = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1677s);
                        this.f1677s = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1677s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1637c5);
                        this.f1637c5 = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1637c5 = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1655i9);
                        this.f1655i9 = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1655i9 = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1647f);
                        this.f1647f = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1647f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f1679t);
                        this.f1679t = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1679t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f1687w);
                        this.f1687w = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1687w = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1670p);
                        this.f1670p = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1670p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f1663mt);
                        this.f1663mt = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1663mt = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f1638co);
                        this.f1638co = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1638co = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f1695z = obtainStyledAttributes.getDimensionPixelSize(index, this.f1695z);
                        break;
                    case 22:
                        this.f1673r = obtainStyledAttributes.getDimensionPixelSize(index, this.f1673r);
                        break;
                    case 23:
                        this.f1690x4 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1690x4);
                        break;
                    case 24:
                        this.f1654i4 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1654i4);
                        break;
                    case 25:
                        this.f1648f3 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1648f3);
                        break;
                    case 26:
                        this.f1664n = obtainStyledAttributes.getDimensionPixelSize(index, this.f1664n);
                        break;
                    case 27:
                        this.f1656j = obtainStyledAttributes.getBoolean(index, this.f1656j);
                        break;
                    case 28:
                        this.f1669oz = obtainStyledAttributes.getBoolean(index, this.f1669oz);
                        break;
                    case 29:
                        this.f1636c = obtainStyledAttributes.getFloat(index, this.f1636c);
                        break;
                    case 30:
                        this.f1641d0 = obtainStyledAttributes.getFloat(index, this.f1641d0);
                        break;
                    case 31:
                        int i8 = obtainStyledAttributes.getInt(index, 0);
                        this.f1683ud = i8;
                        if (i8 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i10 = obtainStyledAttributes.getInt(index, 0);
                        this.f1633a8 = i10;
                        if (i10 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f1689x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1689x);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.f1689x) == -2) {
                                this.f1689x = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f1660k5 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1660k5);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.f1660k5) == -2) {
                                this.f1660k5 = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f1686vl = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f1686vl));
                        this.f1683ud = 2;
                        break;
                    case 36:
                        try {
                            this.f1635b = obtainStyledAttributes.getDimensionPixelSize(index, this.f1635b);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.f1635b) == -2) {
                                this.f1635b = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f1694yt = obtainStyledAttributes.getDimensionPixelSize(index, this.f1694yt);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.f1694yt) == -2) {
                                this.f1694yt = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f1653hw = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f1653hw));
                        this.f1633a8 = 2;
                        break;
                    default:
                        switch (i6) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.f1651fh = string;
                                this.f1676rz = Float.NaN;
                                this.f1662mg = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.f1651fh.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String substring = this.f1651fh.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.f1662mg = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.f1662mg = 1;
                                        }
                                        i = indexOf + 1;
                                    }
                                    int indexOf2 = this.f1651fh.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.f1651fh.substring(i, indexOf2);
                                        String substring3 = this.f1651fh.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.f1662mg == 1) {
                                                        this.f1676rz = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        this.f1676rz = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.f1651fh.substring(i);
                                        if (substring4.length() > 0) {
                                            this.f1676rz = Float.parseFloat(substring4);
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.f1680ta = obtainStyledAttributes.getFloat(index, this.f1680ta);
                                continue;
                            case 46:
                                this.f1640d = obtainStyledAttributes.getFloat(index, this.f1640d);
                                continue;
                            case 47:
                                this.f1696z6 = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.f1645ej = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.f1657j5 = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1657j5);
                                continue;
                            case 50:
                                this.f1672qn = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1672qn);
                                continue;
                            case 51:
                                this.f1684ut = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            y();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r10) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.n3.resolveLayoutDirection(int):void");
        }

        public void y() {
            this.f1646en = false;
            this.f1671q9 = true;
            this.f1659k = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.f1656j) {
                this.f1671q9 = false;
                if (this.f1683ud == 0) {
                    this.f1683ud = 1;
                }
            }
            int i5 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i5 == -2 && this.f1669oz) {
                this.f1659k = false;
                if (this.f1633a8 == 0) {
                    this.f1633a8 = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.f1671q9 = false;
                if (i == 0 && this.f1683ud == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f1656j = true;
                }
            }
            if (i5 == 0 || i5 == -1) {
                this.f1659k = false;
                if (i5 == 0 && this.f1633a8 == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f1669oz = true;
                }
            }
            if (this.f1697zn != -1.0f || this.y != -1 || this.f1665n3 != -1) {
                this.f1646en = true;
                this.f1671q9 = true;
                this.f1659k = true;
                if (!(this.f1678s8 instanceof fb)) {
                    this.f1678s8 = new fb();
                }
                ((fb) this.f1678s8).br(this.f1667o);
            }
        }

        public n3(int i, int i5) {
            super(i, i5);
            this.y = -1;
            this.f1665n3 = -1;
            this.f1697zn = -1.0f;
            this.f1652gv = -1;
            this.f1685v = -1;
            this.f1632a = -1;
            this.f1650fb = -1;
            this.f1677s = -1;
            this.f1637c5 = -1;
            this.f1655i9 = -1;
            this.f1647f = -1;
            this.f1679t = -1;
            this.f1681tl = -1;
            this.f1687w = -1;
            this.f1670p = -1;
            this.f1663mt = -1;
            this.f1638co = -1;
            this.f1695z = -1;
            this.f1673r = -1;
            this.f1690x4 = -1;
            this.f1654i4 = -1;
            this.f1648f3 = -1;
            this.f1664n = -1;
            this.f1636c = 0.5f;
            this.f1641d0 = 0.5f;
            this.f1662mg = 1;
            this.f1680ta = -1.0f;
            this.f1640d = -1.0f;
            this.f1686vl = 1.0f;
            this.f1653hw = 1.0f;
            this.f1657j5 = -1;
            this.f1672qn = -1;
            this.f1667o = -1;
            this.f1671q9 = true;
            this.f1659k = true;
            this.f1692xg = -1;
            this.f1642dm = -1;
            this.f1639ct = -1;
            this.f1668o4 = -1;
            this.f1675rs = -1;
            this.f1644eb = -1;
            this.f1661lc = 0.5f;
            this.f1678s8 = new n.v();
            this.f1634ap = false;
        }

        public n3(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.y = -1;
            this.f1665n3 = -1;
            this.f1697zn = -1.0f;
            this.f1652gv = -1;
            this.f1685v = -1;
            this.f1632a = -1;
            this.f1650fb = -1;
            this.f1677s = -1;
            this.f1637c5 = -1;
            this.f1655i9 = -1;
            this.f1647f = -1;
            this.f1679t = -1;
            this.f1681tl = -1;
            this.f1687w = -1;
            this.f1670p = -1;
            this.f1663mt = -1;
            this.f1638co = -1;
            this.f1695z = -1;
            this.f1673r = -1;
            this.f1690x4 = -1;
            this.f1654i4 = -1;
            this.f1648f3 = -1;
            this.f1664n = -1;
            this.f1636c = 0.5f;
            this.f1641d0 = 0.5f;
            this.f1662mg = 1;
            this.f1680ta = -1.0f;
            this.f1640d = -1.0f;
            this.f1686vl = 1.0f;
            this.f1653hw = 1.0f;
            this.f1657j5 = -1;
            this.f1672qn = -1;
            this.f1667o = -1;
            this.f1671q9 = true;
            this.f1659k = true;
            this.f1692xg = -1;
            this.f1642dm = -1;
            this.f1639ct = -1;
            this.f1668o4 = -1;
            this.f1675rs = -1;
            this.f1644eb = -1;
            this.f1661lc = 0.5f;
            this.f1678s8 = new n.v();
            this.f1634ap = false;
        }
    }
}
