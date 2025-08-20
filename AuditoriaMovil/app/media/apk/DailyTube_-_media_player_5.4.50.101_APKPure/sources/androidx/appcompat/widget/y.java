package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.c5;
import androidx.appcompat.view.menu.fb;
import androidx.appcompat.view.menu.i9;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.widget.ActionMenuView;
import hw.n3;
import java.util.ArrayList;
import wz.fh;
import wz.j5;
/* loaded from: classes.dex */
public class y extends androidx.appcompat.view.menu.y implements n3.y {

    /* renamed from: b  reason: collision with root package name */
    public boolean f1520b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1521c;

    /* renamed from: d  reason: collision with root package name */
    public int f1522d;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f1523d0;

    /* renamed from: ej  reason: collision with root package name */
    public int f1524ej;

    /* renamed from: en  reason: collision with root package name */
    public int f1525en;

    /* renamed from: f3  reason: collision with root package name */
    public Drawable f1526f3;

    /* renamed from: f7  reason: collision with root package name */
    public final a f1527f7;

    /* renamed from: fh  reason: collision with root package name */
    public int f1528fh;

    /* renamed from: j  reason: collision with root package name */
    public final SparseBooleanArray f1529j;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f1530j5;

    /* renamed from: k  reason: collision with root package name */
    public n3 f1531k;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1532n;

    /* renamed from: o  reason: collision with root package name */
    public int f1533o;

    /* renamed from: oz  reason: collision with root package name */
    public v f1534oz;

    /* renamed from: q9  reason: collision with root package name */
    public zn f1535q9;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f1536qn;

    /* renamed from: r  reason: collision with root package name */
    public gv f1537r;

    /* renamed from: ut  reason: collision with root package name */
    public C0015y f1538ut;

    /* renamed from: x  reason: collision with root package name */
    public boolean f1539x;

    /* loaded from: classes.dex */
    public class a implements c5.y {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar, boolean z2) {
            if (vVar instanceof t) {
                vVar.mg().v(false);
            }
            c5.y tl2 = y.this.tl();
            if (tl2 != null) {
                tl2.n3(vVar, z2);
            }
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public boolean zn(@NonNull androidx.appcompat.view.menu.v vVar) {
            if (vVar == y.this.f1218fb) {
                return false;
            }
            y.this.f1525en = ((t) vVar).getItem().getItemId();
            c5.y tl2 = y.this.tl();
            if (tl2 == null) {
                return false;
            }
            return tl2.zn(vVar);
        }
    }

    /* loaded from: classes.dex */
    public class gv extends AppCompatImageView implements ActionMenuView.y {

        /* renamed from: androidx.appcompat.widget.y$gv$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0014y extends fh {

            /* renamed from: z  reason: collision with root package name */
            public final /* synthetic */ y f1541z;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0014y(View view, y yVar) {
                super(view);
                this.f1541z = yVar;
            }

            @Override // wz.fh
            public boolean gv() {
                y yVar = y.this;
                if (yVar.f1535q9 != null) {
                    return false;
                }
                yVar.fh();
                return true;
            }

            @Override // wz.fh
            public tl.a n3() {
                v vVar = y.this.f1534oz;
                if (vVar == null) {
                    return null;
                }
                return vVar.zn();
            }

            @Override // wz.fh
            public boolean zn() {
                y.this.x();
                return true;
            }
        }

        public gv(Context context) {
            super(context, null, R$attr.f634f);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            j5.y(this, getContentDescription());
            setOnTouchListener(new C0014y(this, y.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.y
        public boolean n3() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            y.this.x();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i5, int i6, int i8) {
            boolean frame = super.setFrame(i, i5, i6, i8);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                ej.y.t(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.y
        public boolean y() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends ActionMenuItemView.n3 {
        public n3() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.n3
        public tl.a y() {
            C0015y c0015y = y.this.f1538ut;
            if (c0015y != null) {
                return c0015y.zn();
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class v extends s {
        public v(Context context, androidx.appcompat.view.menu.v vVar, View view, boolean z2) {
            super(context, vVar, view, z2, R$attr.f650t);
            s(8388613);
            i9(y.this.f1527f7);
        }

        @Override // androidx.appcompat.view.menu.s
        public void v() {
            if (y.this.f1218fb != null) {
                y.this.f1218fb.close();
            }
            y.this.f1534oz = null;
            super.v();
        }
    }

    /* renamed from: androidx.appcompat.widget.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0015y extends s {
        public C0015y(Context context, t tVar, View view) {
            super(context, tVar, view, false, R$attr.f650t);
            if (!((fb) tVar.getItem()).t()) {
                View view2 = y.this.f1537r;
                a(view2 == null ? (View) y.this.f1216co : view2);
            }
            i9(y.this.f1527f7);
        }

        @Override // androidx.appcompat.view.menu.s
        public void v() {
            y yVar = y.this;
            yVar.f1538ut = null;
            yVar.f1525en = 0;
            super.v();
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {
        public v y;

        public zn(v vVar) {
            this.y = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y.this.f1218fb != null) {
                y.this.f1218fb.gv();
            }
            View view = (View) y.this.f1216co;
            if (view != null && view.getWindowToken() != null && this.y.tl()) {
                y.this.f1534oz = this.y;
            }
            y.this.f1535q9 = null;
        }
    }

    public y(Context context) {
        super(context, R$layout.f789zn, R$layout.f779n3);
        this.f1529j = new SparseBooleanArray();
        this.f1527f7 = new a();
    }

    @Override // androidx.appcompat.view.menu.y, androidx.appcompat.view.menu.c5
    public void a(boolean z2) {
        ArrayList<fb> arrayList;
        super.a(z2);
        ((View) this.f1216co).requestLayout();
        androidx.appcompat.view.menu.v vVar = this.f1218fb;
        boolean z3 = false;
        if (vVar != null) {
            ArrayList<fb> co2 = vVar.co();
            int size = co2.size();
            for (int i = 0; i < size; i++) {
                hw.n3 n32 = co2.get(i).n3();
                if (n32 != null) {
                    n32.c5(this);
                }
            }
        }
        androidx.appcompat.view.menu.v vVar2 = this.f1218fb;
        if (vVar2 != null) {
            arrayList = vVar2.c();
        } else {
            arrayList = null;
        }
        if (this.f1521c && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z3 = !arrayList.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f1537r == null) {
                this.f1537r = new gv(this.y);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1537r.getParent();
            if (viewGroup != this.f1216co) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1537r);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1216co;
                actionMenuView.addView(this.f1537r, actionMenuView.d());
            }
        } else {
            gv gvVar = this.f1537r;
            if (gvVar != null) {
                ViewParent parent = gvVar.getParent();
                i9 i9Var = this.f1216co;
                if (parent == i9Var) {
                    ((ViewGroup) i9Var).removeView(this.f1537r);
                }
            }
        }
        ((ActionMenuView) this.f1216co).setOverflowReserved(this.f1521c);
    }

    public void a8(boolean z2) {
        this.f1521c = z2;
        this.f1523d0 = true;
    }

    public final View c(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1216co;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof i9.y) && ((i9.y) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.y, androidx.appcompat.view.menu.c5
    public void c5(@NonNull Context context, @Nullable androidx.appcompat.view.menu.v vVar) {
        super.c5(context, vVar);
        Resources resources = context.getResources();
        t.y n32 = t.y.n3(context);
        if (!this.f1523d0) {
            this.f1521c = n32.s();
        }
        if (!this.f1530j5) {
            this.f1528fh = n32.zn();
        }
        if (!this.f1539x) {
            this.f1524ej = n32.gv();
        }
        int i = this.f1528fh;
        if (this.f1521c) {
            if (this.f1537r == null) {
                gv gvVar = new gv(this.y);
                this.f1537r = gvVar;
                if (this.f1532n) {
                    gvVar.setImageDrawable(this.f1526f3);
                    this.f1526f3 = null;
                    this.f1532n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1537r.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1537r.getMeasuredWidth();
        } else {
            this.f1537r = null;
        }
        this.f1522d = i;
        this.f1533o = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void d(Configuration configuration) {
        if (!this.f1539x) {
            this.f1524ej = t.y.n3(this.f1222v).gv();
        }
        androidx.appcompat.view.menu.v vVar = this.f1218fb;
        if (vVar != null) {
            vVar.x(true);
        }
    }

    public Drawable d0() {
        gv gvVar = this.f1537r;
        if (gvVar != null) {
            return gvVar.getDrawable();
        }
        if (this.f1532n) {
            return this.f1526f3;
        }
        return null;
    }

    public void ej(ActionMenuView actionMenuView) {
        this.f1216co = actionMenuView;
        actionMenuView.y(this.f1218fb);
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean fb() {
        ArrayList<fb> arrayList;
        int i;
        int i5;
        int i6;
        int i8;
        boolean z2;
        boolean z3;
        y yVar = this;
        androidx.appcompat.view.menu.v vVar = yVar.f1218fb;
        View view = null;
        int i10 = 0;
        if (vVar != null) {
            arrayList = vVar.ta();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i11 = yVar.f1524ej;
        int i12 = yVar.f1522d;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) yVar.f1216co;
        boolean z4 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i; i15++) {
            fb fbVar = arrayList.get(i15);
            if (fbVar.xc()) {
                i13++;
            } else if (fbVar.wz()) {
                i14++;
            } else {
                z4 = true;
            }
            if (yVar.f1536qn && fbVar.isActionViewExpanded()) {
                i11 = 0;
            }
        }
        if (yVar.f1521c && (z4 || i14 + i13 > i11)) {
            i11--;
        }
        int i16 = i11 - i13;
        SparseBooleanArray sparseBooleanArray = yVar.f1529j;
        sparseBooleanArray.clear();
        if (yVar.f1520b) {
            int i17 = yVar.f1533o;
            i6 = i12 / i17;
            i5 = i17 + ((i12 % i17) / i6);
        } else {
            i5 = 0;
            i6 = 0;
        }
        int i18 = 0;
        int i19 = 0;
        while (i18 < i) {
            fb fbVar2 = arrayList.get(i18);
            if (fbVar2.xc()) {
                View wz2 = yVar.wz(fbVar2, view, viewGroup);
                if (yVar.f1520b) {
                    i6 -= ActionMenuView.b(wz2, i5, i6, makeMeasureSpec, i10);
                } else {
                    wz2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = wz2.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i19 == 0) {
                    i19 = measuredWidth;
                }
                int groupId = fbVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                fbVar2.r(true);
                i8 = i;
            } else if (fbVar2.wz()) {
                int groupId2 = fbVar2.getGroupId();
                boolean z5 = sparseBooleanArray.get(groupId2);
                if ((i16 > 0 || z5) && i12 > 0 && (!yVar.f1520b || i6 > 0)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z7 = z2;
                i8 = i;
                if (z2) {
                    View wz3 = yVar.wz(fbVar2, null, viewGroup);
                    if (yVar.f1520b) {
                        int b2 = ActionMenuView.b(wz3, i5, i6, makeMeasureSpec, 0);
                        i6 -= b2;
                        if (b2 == 0) {
                            z7 = false;
                        }
                    } else {
                        wz3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z8 = z7;
                    int measuredWidth2 = wz3.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i19 == 0) {
                        i19 = measuredWidth2;
                    }
                    if (!yVar.f1520b ? i12 + i19 > 0 : i12 >= 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z2 = z8 & z3;
                }
                if (z2 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z5) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i20 = 0; i20 < i18; i20++) {
                        fb fbVar3 = arrayList.get(i20);
                        if (fbVar3.getGroupId() == groupId2) {
                            if (fbVar3.t()) {
                                i16++;
                            }
                            fbVar3.r(false);
                        }
                    }
                }
                if (z2) {
                    i16--;
                }
                fbVar2.r(z2);
            } else {
                i8 = i;
                fbVar2.r(false);
                i18++;
                view = null;
                yVar = this;
                i = i8;
                i10 = 0;
            }
            i18++;
            view = null;
            yVar = this;
            i = i8;
            i10 = 0;
        }
        return true;
    }

    public boolean fh() {
        i9 i9Var;
        zn znVar = this.f1535q9;
        if (znVar != null && (i9Var = this.f1216co) != null) {
            ((View) i9Var).removeCallbacks(znVar);
            this.f1535q9 = null;
            return true;
        }
        v vVar = this.f1534oz;
        if (vVar != null) {
            vVar.n3();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.y
    public void i9(fb fbVar, i9.y yVar) {
        yVar.zn(fbVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) yVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1216co);
        if (this.f1531k == null) {
            this.f1531k = new n3();
        }
        actionMenuItemView.setPopupCallback(this.f1531k);
    }

    public boolean mg() {
        if (this.f1535q9 == null && !ta()) {
            return false;
        }
        return true;
    }

    public boolean n() {
        return fh() | rz();
    }

    @Override // androidx.appcompat.view.menu.y, androidx.appcompat.view.menu.c5
    public void n3(androidx.appcompat.view.menu.v vVar, boolean z2) {
        n();
        super.n3(vVar, z2);
    }

    @Override // androidx.appcompat.view.menu.y
    public boolean p(int i, fb fbVar) {
        return fbVar.t();
    }

    public boolean rz() {
        C0015y c0015y = this.f1538ut;
        if (c0015y != null) {
            c0015y.n3();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.y
    public boolean t(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1537r) {
            return false;
        }
        return super.t(viewGroup, i);
    }

    public boolean ta() {
        v vVar = this.f1534oz;
        if (vVar != null && vVar.gv()) {
            return true;
        }
        return false;
    }

    public void ud(Drawable drawable) {
        gv gvVar = this.f1537r;
        if (gvVar != null) {
            gvVar.setImageDrawable(drawable);
            return;
        }
        this.f1532n = true;
        this.f1526f3 = drawable;
    }

    @Override // androidx.appcompat.view.menu.y, androidx.appcompat.view.menu.c5
    public boolean v(t tVar) {
        boolean z2 = false;
        if (!tVar.hasVisibleItems()) {
            return false;
        }
        t tVar2 = tVar;
        while (tVar2.dm() != this.f1218fb) {
            tVar2 = (t) tVar2.dm();
        }
        View c2 = c(tVar2.getItem());
        if (c2 == null) {
            return false;
        }
        this.f1525en = tVar.getItem().getItemId();
        int size = tVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = tVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i++;
        }
        C0015y c0015y = new C0015y(this.f1222v, tVar, c2);
        this.f1538ut = c0015y;
        c0015y.fb(z2);
        this.f1538ut.f();
        super.v(tVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.y
    public View wz(fb fbVar, View view, ViewGroup viewGroup) {
        int i;
        View actionView = fbVar.getActionView();
        if (actionView == null || fbVar.i9()) {
            actionView = super.wz(fbVar, view, viewGroup);
        }
        if (fbVar.isActionViewExpanded()) {
            i = 8;
        } else {
            i = 0;
        }
        actionView.setVisibility(i);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.xc(layoutParams));
        }
        return actionView;
    }

    public boolean x() {
        androidx.appcompat.view.menu.v vVar;
        if (this.f1521c && !ta() && (vVar = this.f1218fb) != null && this.f1216co != null && this.f1535q9 == null && !vVar.c().isEmpty()) {
            zn znVar = new zn(new v(this.f1222v, this.f1218fb, this.f1537r, true));
            this.f1535q9 = znVar;
            ((View) this.f1216co).post(znVar);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.y
    public i9 xc(ViewGroup viewGroup) {
        i9 i9Var = this.f1216co;
        i9 xc2 = super.xc(viewGroup);
        if (i9Var != xc2) {
            ((ActionMenuView) xc2).setPresenter(this);
        }
        return xc2;
    }

    public void z6(boolean z2) {
        this.f1536qn = z2;
    }
}
