package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.c5;
import androidx.appcompat.view.menu.fb;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import com.uv.v7.R;
import hw.i4;
import hw.s;
import java.util.ArrayList;
import java.util.List;
import s.y;
import wz.f3;
import wz.hw;
import wz.oz;
import wz.ud;
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public ud f1457b;

    /* renamed from: c  reason: collision with root package name */
    public int f1458c;

    /* renamed from: co  reason: collision with root package name */
    public View f1459co;

    /* renamed from: ct  reason: collision with root package name */
    public androidx.appcompat.widget.y f1460ct;

    /* renamed from: d  reason: collision with root package name */
    public int f1461d;

    /* renamed from: d0  reason: collision with root package name */
    public int f1462d0;

    /* renamed from: dm  reason: collision with root package name */
    public androidx.appcompat.widget.zn f1463dm;

    /* renamed from: eb  reason: collision with root package name */
    public v.y f1464eb;

    /* renamed from: ej  reason: collision with root package name */
    public int f1465ej;

    /* renamed from: en  reason: collision with root package name */
    public final ArrayList<View> f1466en;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f1467f;

    /* renamed from: f3  reason: collision with root package name */
    public int f1468f3;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f1469f7;

    /* renamed from: fb  reason: collision with root package name */
    public TextView f1470fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f1471fh;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f1472j;

    /* renamed from: j5  reason: collision with root package name */
    public int f1473j5;

    /* renamed from: jz  reason: collision with root package name */
    public final ArrayList<View> f1474jz;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1475k;

    /* renamed from: lc  reason: collision with root package name */
    public boolean f1476lc;

    /* renamed from: n  reason: collision with root package name */
    public int f1477n;

    /* renamed from: nf  reason: collision with root package name */
    public final Runnable f1478nf;

    /* renamed from: o  reason: collision with root package name */
    public int f1479o;

    /* renamed from: o4  reason: collision with root package name */
    public gv f1480o4;

    /* renamed from: oz  reason: collision with root package name */
    public CharSequence f1481oz;

    /* renamed from: p  reason: collision with root package name */
    public ImageButton f1482p;

    /* renamed from: q9  reason: collision with root package name */
    public ColorStateList f1483q9;

    /* renamed from: qn  reason: collision with root package name */
    public int f1484qn;

    /* renamed from: r  reason: collision with root package name */
    public int f1485r;

    /* renamed from: rs  reason: collision with root package name */
    public c5.y f1486rs;

    /* renamed from: s  reason: collision with root package name */
    public ImageButton f1487s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f1488t;

    /* renamed from: u  reason: collision with root package name */
    public final int[] f1489u;

    /* renamed from: ut  reason: collision with root package name */
    public ColorStateList f1490ut;

    /* renamed from: v  reason: collision with root package name */
    public TextView f1491v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f1492w;

    /* renamed from: x  reason: collision with root package name */
    public int f1493x;

    /* renamed from: xg  reason: collision with root package name */
    public final ActionMenuView.v f1494xg;
    public ActionMenuView y;

    /* renamed from: y5  reason: collision with root package name */
    public a f1495y5;

    /* renamed from: z  reason: collision with root package name */
    public Context f1496z;

    /* loaded from: classes.dex */
    public interface a {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public class gv implements c5 {

        /* renamed from: v  reason: collision with root package name */
        public fb f1500v;
        public androidx.appcompat.view.menu.v y;

        public gv() {
        }

        @Override // androidx.appcompat.view.menu.c5
        public void a(boolean z2) {
            if (this.f1500v != null) {
                androidx.appcompat.view.menu.v vVar = this.y;
                if (vVar != null) {
                    int size = vVar.size();
                    for (int i = 0; i < size; i++) {
                        if (this.y.getItem(i) == this.f1500v) {
                            return;
                        }
                    }
                }
                s(this.y, this.f1500v);
            }
        }

        @Override // androidx.appcompat.view.menu.c5
        public void c5(Context context, androidx.appcompat.view.menu.v vVar) {
            fb fbVar;
            androidx.appcompat.view.menu.v vVar2 = this.y;
            if (vVar2 != null && (fbVar = this.f1500v) != null) {
                vVar2.a(fbVar);
            }
            this.y = vVar;
        }

        @Override // androidx.appcompat.view.menu.c5
        public boolean fb() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.c5
        public void n3(androidx.appcompat.view.menu.v vVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.c5
        public boolean s(androidx.appcompat.view.menu.v vVar, fb fbVar) {
            View view = Toolbar.this.f1459co;
            if (view instanceof t.zn) {
                ((t.zn) view).a();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1459co);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1482p);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1459co = null;
            toolbar3.y();
            this.f1500v = null;
            Toolbar.this.requestLayout();
            fbVar.mt(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.c5
        public boolean v(t tVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.c5
        public boolean zn(androidx.appcompat.view.menu.v vVar, fb fbVar) {
            Toolbar.this.fb();
            ViewParent parent = Toolbar.this.f1482p.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1482p);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1482p);
            }
            Toolbar.this.f1459co = fbVar.getActionView();
            this.f1500v = fbVar;
            ViewParent parent2 = Toolbar.this.f1459co.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1459co);
                }
                v generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.y = (toolbar4.f1458c & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 8388611;
                generateDefaultLayoutParams.f1501n3 = 2;
                toolbar4.f1459co.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1459co);
            }
            Toolbar.this.z6();
            Toolbar.this.requestLayout();
            fbVar.mt(true);
            View view = Toolbar.this.f1459co;
            if (view instanceof t.zn) {
                ((t.zn) view).n3();
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.vl();
        }
    }

    /* loaded from: classes.dex */
    public static class v extends y.C0211y {

        /* renamed from: n3  reason: collision with root package name */
        public int f1501n3;

        public v(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void y(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public v(int i, int i5) {
            super(i, i5);
            this.y = 8388627;
        }

        public v(v vVar) {
            super((y.C0211y) vVar);
            this.f1501n3 = vVar.f1501n3;
        }

        public v(y.C0211y c0211y) {
            super(c0211y);
        }

        public v(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            y(marginLayoutParams);
        }

        public v(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public class y implements ActionMenuView.v {
        public y() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.v
        public boolean onMenuItemClick(MenuItem menuItem) {
            a aVar = Toolbar.this.f1495y5;
            if (aVar != null) {
                return aVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class zn implements View.OnClickListener {
        public zn() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.v();
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f655vl);
    }

    private MenuInflater getMenuInflater() {
        return new t.fb(getContext());
    }

    public void a() {
        ActionMenuView actionMenuView = this.y;
        if (actionMenuView != null) {
            actionMenuView.fh();
        }
    }

    public void a8(c5.y yVar, v.y yVar2) {
        this.f1486rs = yVar;
        this.f1464eb = yVar2;
        ActionMenuView actionMenuView = this.y;
        if (actionMenuView != null) {
            actionMenuView.vl(yVar, yVar2);
        }
    }

    public void b(Context context, int i) {
        this.f1468f3 = i;
        TextView textView = this.f1491v;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public boolean c() {
        ActionMenuView actionMenuView = this.y;
        if (actionMenuView != null && actionMenuView.ud()) {
            return true;
        }
        return false;
    }

    public final void c5() {
        if (this.f1467f == null) {
            this.f1467f = new AppCompatImageView(getContext());
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof v)) {
            return true;
        }
        return false;
    }

    public final int co(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return s.n3(marginLayoutParams) + s.y(marginLayoutParams);
    }

    public final void d() {
        removeCallbacks(this.f1478nf);
        post(this.f1478nf);
    }

    public boolean d0() {
        ActionMenuView actionMenuView = this.y;
        if (actionMenuView != null && actionMenuView.a8()) {
            return true;
        }
        return false;
    }

    public void ej(int i, int i5) {
        s();
        this.f1457b.fb(i, i5);
    }

    public final void f() {
        if (this.y == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.y = actionMenuView;
            actionMenuView.setPopupTheme(this.f1485r);
            this.y.setOnMenuItemClickListener(this.f1494xg);
            this.y.vl(this.f1486rs, this.f1464eb);
            v generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.y = (this.f1458c & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 8388613;
            this.y.setLayoutParams(generateDefaultLayoutParams);
            zn(this.y, false);
        }
    }

    public void f3(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void fb() {
        if (this.f1482p == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.f661yt);
            this.f1482p = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1488t);
            this.f1482p.setContentDescription(this.f1492w);
            v generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.y = (this.f1458c & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 8388611;
            generateDefaultLayoutParams.f1501n3 = 2;
            this.f1482p.setLayoutParams(generateDefaultLayoutParams);
            this.f1482p.setOnClickListener(new zn());
        }
    }

    public final int fh(View view, int i, int[] iArr, int i5) {
        v vVar = (v) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) vVar).leftMargin - iArr[0];
        int max = i + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        int p2 = p(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, p2, max + measuredWidth, view.getMeasuredHeight() + p2);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) vVar).rightMargin;
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1482p;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1482p;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        ud udVar = this.f1457b;
        if (udVar != null) {
            return udVar.y();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.f1484qn;
        if (i == Integer.MIN_VALUE) {
            return getContentInsetEnd();
        }
        return i;
    }

    public int getContentInsetLeft() {
        ud udVar = this.f1457b;
        if (udVar != null) {
            return udVar.n3();
        }
        return 0;
    }

    public int getContentInsetRight() {
        ud udVar = this.f1457b;
        if (udVar != null) {
            return udVar.zn();
        }
        return 0;
    }

    public int getContentInsetStart() {
        ud udVar = this.f1457b;
        if (udVar != null) {
            return udVar.gv();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.f1473j5;
        if (i == Integer.MIN_VALUE) {
            return getContentInsetStart();
        }
        return i;
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.v yt2;
        ActionMenuView actionMenuView = this.y;
        if (actionMenuView != null && (yt2 = actionMenuView.yt()) != null && yt2.hasVisibleItems()) {
            return Math.max(getContentInsetEnd(), Math.max(this.f1484qn, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (i4.ta(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (i4.ta(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f1473j5, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1467f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1467f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        i9();
        return this.y.getMenu();
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1487s;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1487s;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public androidx.appcompat.widget.y getOuterActionMenuPresenter() {
        return this.f1460ct;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        i9();
        return this.y.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f1496z;
    }

    public int getPopupTheme() {
        return this.f1485r;
    }

    public CharSequence getSubtitle() {
        return this.f1481oz;
    }

    @Nullable
    public final TextView getSubtitleTextView() {
        return this.f1470fb;
    }

    public CharSequence getTitle() {
        return this.f1472j;
    }

    public int getTitleMarginBottom() {
        return this.f1493x;
    }

    public int getTitleMarginEnd() {
        return this.f1461d;
    }

    public int getTitleMarginStart() {
        return this.f1471fh;
    }

    public int getTitleMarginTop() {
        return this.f1465ej;
    }

    @Nullable
    public final TextView getTitleTextView() {
        return this.f1491v;
    }

    public f3 getWrapper() {
        if (this.f1463dm == null) {
            this.f1463dm = new androidx.appcompat.widget.zn(this, true);
        }
        return this.f1463dm;
    }

    public boolean gv() {
        ActionMenuView actionMenuView;
        if (getVisibility() == 0 && (actionMenuView = this.y) != null && actionMenuView.x()) {
            return true;
        }
        return false;
    }

    public boolean i4() {
        ActionMenuView actionMenuView = this.y;
        if (actionMenuView != null && actionMenuView.ej()) {
            return true;
        }
        return false;
    }

    public final void i9() {
        f();
        if (this.y.yt() == null) {
            androidx.appcompat.view.menu.v vVar = (androidx.appcompat.view.menu.v) this.y.getMenu();
            if (this.f1480o4 == null) {
                this.f1480o4 = new gv();
            }
            this.y.setExpandedActionViewsExclusive(true);
            vVar.zn(this.f1480o4, this.f1496z);
        }
    }

    public final boolean k5() {
        if (!this.f1476lc) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (yt(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final int mg(View view, int i, int i5, int i6, int i8, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i10 = marginLayoutParams.leftMargin - iArr[0];
        int i11 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i10) + Math.max(0, i11);
        iArr[0] = Math.max(0, -i10);
        iArr[1] = Math.max(0, -i11);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i5, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final int mt(int i) {
        int i5 = i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        if (i5 != 16 && i5 != 48 && i5 != 80) {
            return this.f1479o & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        }
        return i5;
    }

    public final boolean n(View view) {
        if (view.getParent() != this && !this.f1474jz.contains(view)) {
            return false;
        }
        return true;
    }

    public final void n3(List<View> list, int i) {
        boolean z2;
        if (i4.ta(this) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int childCount = getChildCount();
        int n32 = hw.v.n3(i, i4.ta(this));
        list.clear();
        if (z2) {
            for (int i5 = childCount - 1; i5 >= 0; i5--) {
                View childAt = getChildAt(i5);
                v vVar = (v) childAt.getLayoutParams();
                if (vVar.f1501n3 == 0 && yt(childAt) && w(vVar.y) == n32) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            v vVar2 = (v) childAt2.getLayoutParams();
            if (vVar2.f1501n3 == 0 && yt(childAt2) && w(vVar2.y) == n32) {
                list.add(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1478nf);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1469f7 = false;
        }
        if (!this.f1469f7) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1469f7 = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1469f7 = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        int i6;
        int i8;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.f1489u;
        boolean n32 = oz.n3(this);
        int i15 = 0;
        int i16 = !n32 ? 1 : 0;
        if (yt(this.f1487s)) {
            ta(this.f1487s, i, 0, i5, 0, this.f1462d0);
            i6 = this.f1487s.getMeasuredWidth() + co(this.f1487s);
            i8 = Math.max(0, this.f1487s.getMeasuredHeight() + z(this.f1487s));
            i10 = View.combineMeasuredStates(0, this.f1487s.getMeasuredState());
        } else {
            i6 = 0;
            i8 = 0;
            i10 = 0;
        }
        if (yt(this.f1482p)) {
            ta(this.f1482p, i, 0, i5, 0, this.f1462d0);
            i6 = this.f1482p.getMeasuredWidth() + co(this.f1482p);
            i8 = Math.max(i8, this.f1482p.getMeasuredHeight() + z(this.f1482p));
            i10 = View.combineMeasuredStates(i10, this.f1482p.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i6);
        iArr[n32 ? 1 : 0] = Math.max(0, currentContentInsetStart - i6);
        if (yt(this.y)) {
            ta(this.y, i, max, i5, 0, this.f1462d0);
            i11 = this.y.getMeasuredWidth() + co(this.y);
            i8 = Math.max(i8, this.y.getMeasuredHeight() + z(this.y));
            i10 = View.combineMeasuredStates(i10, this.y.getMeasuredState());
        } else {
            i11 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i11);
        iArr[i16] = Math.max(0, currentContentInsetEnd - i11);
        if (yt(this.f1459co)) {
            max2 += mg(this.f1459co, i, max2, i5, 0, iArr);
            i8 = Math.max(i8, this.f1459co.getMeasuredHeight() + z(this.f1459co));
            i10 = View.combineMeasuredStates(i10, this.f1459co.getMeasuredState());
        }
        if (yt(this.f1467f)) {
            max2 += mg(this.f1467f, i, max2, i5, 0, iArr);
            i8 = Math.max(i8, this.f1467f.getMeasuredHeight() + z(this.f1467f));
            i10 = View.combineMeasuredStates(i10, this.f1467f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (((v) childAt.getLayoutParams()).f1501n3 == 0 && yt(childAt)) {
                max2 += mg(childAt, i, max2, i5, 0, iArr);
                i8 = Math.max(i8, childAt.getMeasuredHeight() + z(childAt));
                i10 = View.combineMeasuredStates(i10, childAt.getMeasuredState());
            }
        }
        int i18 = this.f1465ej + this.f1493x;
        int i19 = this.f1471fh + this.f1461d;
        if (yt(this.f1491v)) {
            mg(this.f1491v, i, max2 + i19, i5, i18, iArr);
            int measuredWidth = this.f1491v.getMeasuredWidth() + co(this.f1491v);
            i14 = this.f1491v.getMeasuredHeight() + z(this.f1491v);
            i12 = View.combineMeasuredStates(i10, this.f1491v.getMeasuredState());
            i13 = measuredWidth;
        } else {
            i12 = i10;
            i13 = 0;
            i14 = 0;
        }
        if (yt(this.f1470fb)) {
            i13 = Math.max(i13, mg(this.f1470fb, i, max2 + i19, i5, i14 + i18, iArr));
            i14 += this.f1470fb.getMeasuredHeight() + z(this.f1470fb);
            i12 = View.combineMeasuredStates(i12, this.f1470fb.getMeasuredState());
        }
        int max3 = Math.max(i8, i14);
        int paddingLeft = max2 + i13 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i12);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i5, i12 << 16);
        if (!k5()) {
            i15 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i15);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        androidx.appcompat.view.menu.v vVar;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        ActionMenuView actionMenuView = this.y;
        if (actionMenuView != null) {
            vVar = actionMenuView.yt();
        } else {
            vVar = null;
        }
        int i = savedState.f1497fb;
        if (i != 0 && this.f1480o4 != null && vVar != null && (findItem = vVar.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (savedState.f1498s) {
            d();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        s();
        ud udVar = this.f1457b;
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        udVar.a(z2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        fb fbVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        gv gvVar = this.f1480o4;
        if (gvVar != null && (fbVar = gvVar.f1500v) != null) {
            savedState.f1497fb = fbVar.getItemId();
        }
        savedState.f1498s = d0();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1475k = false;
        }
        if (!this.f1475k) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1475k = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1475k = false;
        }
        return true;
    }

    public final int p(View view, int i) {
        int i5;
        v vVar = (v) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i > 0) {
            i5 = (measuredHeight - i) / 2;
        } else {
            i5 = 0;
        }
        int mt2 = mt(vVar.y);
        if (mt2 != 48) {
            if (mt2 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i6 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i8 = ((ViewGroup.MarginLayoutParams) vVar).topMargin;
                if (i6 < i8) {
                    i6 = i8;
                } else {
                    int i10 = (((height - paddingBottom) - measuredHeight) - i6) - paddingTop;
                    int i11 = ((ViewGroup.MarginLayoutParams) vVar).bottomMargin;
                    if (i10 < i11) {
                        i6 = Math.max(0, i6 - (i11 - i10));
                    }
                }
                return paddingTop + i6;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) vVar).bottomMargin) - i5;
        }
        return getPaddingTop() - i5;
    }

    public final int r(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i5 = iArr[1];
        int size = list.size();
        int i6 = 0;
        int i8 = 0;
        while (i6 < size) {
            View view = list.get(i6);
            v vVar = (v) view.getLayoutParams();
            int i10 = ((ViewGroup.MarginLayoutParams) vVar).leftMargin - i;
            int i11 = ((ViewGroup.MarginLayoutParams) vVar).rightMargin - i5;
            int max = Math.max(0, i10);
            int max2 = Math.max(0, i11);
            int max3 = Math.max(0, -i10);
            int max4 = Math.max(0, -i11);
            i8 += max + view.getMeasuredWidth() + max2;
            i6++;
            i5 = max4;
            i = max3;
        }
        return i8;
    }

    public final int rz(View view, int i, int[] iArr, int i5) {
        v vVar = (v) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) vVar).rightMargin - iArr[1];
        int max = i - Math.max(0, i6);
        iArr[1] = Math.max(0, -i6);
        int p2 = p(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, p2, max, view.getMeasuredHeight() + p2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) vVar).leftMargin);
    }

    public final void s() {
        if (this.f1457b == null) {
            this.f1457b = new ud();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(c5.y.gv(getContext(), i));
    }

    public void setCollapsible(boolean z2) {
        this.f1476lc = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1484qn) {
            this.f1484qn = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1473j5) {
            this.f1473j5 = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(c5.y.gv(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(c5.y.gv(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        t();
        this.f1487s.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(a aVar) {
        this.f1495y5 = aVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        i9();
        this.y.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f1485r != i) {
            this.f1485r = i;
            if (i == 0) {
                this.f1496z = getContext();
            } else {
                this.f1496z = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.f1493x = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f1461d = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f1471fh = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f1465ej = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public final void t() {
        if (this.f1487s == null) {
            this.f1487s = new AppCompatImageButton(getContext(), null, R$attr.f661yt);
            v generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.y = (this.f1458c & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 8388611;
            this.f1487s.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    public final void ta(View view, int i, int i5, int i6, int i8, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i10 >= 0) {
            if (mode != 0) {
                i10 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i10);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: tl */
    public v generateDefaultLayoutParams() {
        return new v(-2, -2);
    }

    public void ud(androidx.appcompat.view.menu.v vVar, androidx.appcompat.widget.y yVar) {
        if (vVar == null && this.y == null) {
            return;
        }
        f();
        androidx.appcompat.view.menu.v yt2 = this.y.yt();
        if (yt2 == vVar) {
            return;
        }
        if (yt2 != null) {
            yt2.vl(this.f1460ct);
            yt2.vl(this.f1480o4);
        }
        if (this.f1480o4 == null) {
            this.f1480o4 = new gv();
        }
        yVar.z6(true);
        if (vVar != null) {
            vVar.zn(yVar, this.f1496z);
            vVar.zn(this.f1480o4, this.f1496z);
        } else {
            yVar.c5(this.f1496z, null);
            this.f1480o4.c5(this.f1496z, null);
            yVar.a(true);
            this.f1480o4.a(true);
        }
        this.y.setPopupTheme(this.f1485r);
        this.y.setPresenter(yVar);
        this.f1460ct = yVar;
    }

    public void v() {
        fb fbVar;
        gv gvVar = this.f1480o4;
        if (gvVar == null) {
            fbVar = null;
        } else {
            fbVar = gvVar.f1500v;
        }
        if (fbVar != null) {
            fbVar.collapseActionView();
        }
    }

    public boolean vl() {
        ActionMenuView actionMenuView = this.y;
        if (actionMenuView != null && actionMenuView.hw()) {
            return true;
        }
        return false;
    }

    public final int w(int i) {
        int ta2 = i4.ta(this);
        int n32 = hw.v.n3(i, ta2) & 7;
        if (n32 != 1 && n32 != 3 && n32 != 5) {
            if (ta2 != 1) {
                return 3;
            }
            return 5;
        }
        return n32;
    }

    @Override // android.view.ViewGroup
    /* renamed from: wz */
    public v generateLayoutParams(AttributeSet attributeSet) {
        return new v(getContext(), attributeSet);
    }

    public void x(Context context, int i) {
        this.f1477n = i;
        TextView textView = this.f1470fb;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public boolean x4() {
        gv gvVar = this.f1480o4;
        if (gvVar != null && gvVar.f1500v != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    /* renamed from: xc */
    public v generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof v) {
            return new v((v) layoutParams);
        }
        if (layoutParams instanceof y.C0211y) {
            return new v((y.C0211y) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new v((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new v(layoutParams);
    }

    public void y() {
        for (int size = this.f1474jz.size() - 1; size >= 0; size--) {
            addView(this.f1474jz.get(size));
        }
        this.f1474jz.clear();
    }

    public final boolean yt(View view) {
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    public final int z(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public void z6() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((v) childAt.getLayoutParams()).f1501n3 != 2 && childAt != this.y) {
                removeViewAt(childCount);
                this.f1474jz.add(childAt);
            }
        }
    }

    public final void zn(View view, boolean z2) {
        v vVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            vVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            vVar = generateLayoutParams(layoutParams);
        } else {
            vVar = (v) layoutParams;
        }
        vVar.f1501n3 = 1;
        if (z2 && this.f1459co != null) {
            view.setLayoutParams(vVar);
            this.f1474jz.add(view);
            return;
        }
        addView(view, vVar);
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1479o = 8388627;
        this.f1466en = new ArrayList<>();
        this.f1474jz = new ArrayList<>();
        this.f1489u = new int[2];
        this.f1494xg = new y();
        this.f1478nf = new n3();
        Context context2 = getContext();
        int[] iArr = R$styleable.pk;
        hw x42 = hw.x4(context2, attributeSet, iArr, i, 0);
        i4.kp(this, context, iArr, attributeSet, x42.mt(), i, 0);
        this.f1468f3 = x42.wz(R$styleable.b8, 0);
        this.f1477n = x42.wz(R$styleable.ki, 0);
        this.f1479o = x42.t(R$styleable.gy, this.f1479o);
        this.f1458c = x42.t(R$styleable.s0, 48);
        int v2 = x42.v(R$styleable.bu, 0);
        int i5 = R$styleable.km;
        v2 = x42.co(i5) ? x42.v(i5, v2) : v2;
        this.f1493x = v2;
        this.f1465ej = v2;
        this.f1461d = v2;
        this.f1471fh = v2;
        int v3 = x42.v(R$styleable.fa, -1);
        if (v3 >= 0) {
            this.f1471fh = v3;
        }
        int v4 = x42.v(R$styleable.yx, -1);
        if (v4 >= 0) {
            this.f1461d = v4;
        }
        int v6 = x42.v(R$styleable.ar, -1);
        if (v6 >= 0) {
            this.f1465ej = v6;
        }
        int v7 = x42.v(R$styleable.jg, -1);
        if (v7 >= 0) {
            this.f1493x = v7;
        }
        this.f1462d0 = x42.a(R$styleable.nw, -1);
        int v8 = x42.v(R$styleable.lm, Integer.MIN_VALUE);
        int v9 = x42.v(R$styleable.zv, Integer.MIN_VALUE);
        int a2 = x42.a(R$styleable.ex, 0);
        int a3 = x42.a(R$styleable.sg, 0);
        s();
        this.f1457b.v(a2, a3);
        if (v8 != Integer.MIN_VALUE || v9 != Integer.MIN_VALUE) {
            this.f1457b.fb(v8, v9);
        }
        this.f1473j5 = x42.v(R$styleable.q4, Integer.MIN_VALUE);
        this.f1484qn = x42.v(R$styleable.xe, Integer.MIN_VALUE);
        this.f1488t = x42.fb(R$styleable.ah);
        this.f1492w = x42.w(R$styleable.aj);
        CharSequence w4 = x42.w(R$styleable.nb);
        if (!TextUtils.isEmpty(w4)) {
            setTitle(w4);
        }
        CharSequence w5 = x42.w(R$styleable.lq);
        if (!TextUtils.isEmpty(w5)) {
            setSubtitle(w5);
        }
        this.f1496z = getContext();
        setPopupTheme(x42.wz(R$styleable.mk, 0));
        Drawable fb2 = x42.fb(R$styleable.yb);
        if (fb2 != null) {
            setNavigationIcon(fb2);
        }
        CharSequence w6 = x42.w(R$styleable.gp);
        if (!TextUtils.isEmpty(w6)) {
            setNavigationContentDescription(w6);
        }
        Drawable fb3 = x42.fb(R$styleable.or);
        if (fb3 != null) {
            setLogo(fb3);
        }
        CharSequence w7 = x42.w(R$styleable.i5);
        if (!TextUtils.isEmpty(w7)) {
            setLogoDescription(w7);
        }
        int i6 = R$styleable.f865m1;
        if (x42.co(i6)) {
            setTitleTextColor(x42.zn(i6));
        }
        int i8 = R$styleable.ns;
        if (x42.co(i8)) {
            setSubtitleTextColor(x42.zn(i8));
        }
        int i10 = R$styleable.a0;
        if (x42.co(i10)) {
            f3(x42.wz(i10, 0));
        }
        x42.i4();
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            fb();
        }
        ImageButton imageButton = this.f1482p;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            fb();
            this.f1482p.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f1482p;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f1488t);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            c5();
            if (!n(this.f1467f)) {
                zn(this.f1467f, true);
            }
        } else {
            ImageView imageView = this.f1467f;
            if (imageView != null && n(imageView)) {
                removeView(this.f1467f);
                this.f1474jz.remove(this.f1467f);
            }
        }
        ImageView imageView2 = this.f1467f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c5();
        }
        ImageView imageView = this.f1467f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            t();
        }
        ImageButton imageButton = this.f1487s;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            t();
            if (!n(this.f1487s)) {
                zn(this.f1487s, true);
            }
        } else {
            ImageButton imageButton = this.f1487s;
            if (imageButton != null && n(imageButton)) {
                removeView(this.f1487s);
                this.f1474jz.remove(this.f1487s);
            }
        }
        ImageButton imageButton2 = this.f1487s;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1470fb == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1470fb = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1470fb.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f1477n;
                if (i != 0) {
                    this.f1470fb.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f1483q9;
                if (colorStateList != null) {
                    this.f1470fb.setTextColor(colorStateList);
                }
            }
            if (!n(this.f1470fb)) {
                zn(this.f1470fb, true);
            }
        } else {
            TextView textView = this.f1470fb;
            if (textView != null && n(textView)) {
                removeView(this.f1470fb);
                this.f1474jz.remove(this.f1470fb);
            }
        }
        TextView textView2 = this.f1470fb;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1481oz = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f1483q9 = colorStateList;
        TextView textView = this.f1470fb;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1491v == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1491v = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1491v.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f1468f3;
                if (i != 0) {
                    this.f1491v.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f1490ut;
                if (colorStateList != null) {
                    this.f1491v.setTextColor(colorStateList);
                }
            }
            if (!n(this.f1491v)) {
                zn(this.f1491v, true);
            }
        } else {
            TextView textView = this.f1491v;
            if (textView != null && n(textView)) {
                removeView(this.f1491v);
                this.f1474jz.remove(this.f1491v);
            }
        }
        TextView textView2 = this.f1491v;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1472j = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f1490ut = colorStateList;
        TextView textView = this.f1491v;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public int f1497fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f1498s;

        /* loaded from: classes.dex */
        public class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: n3 */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1497fb = parcel.readInt();
            this.f1498s = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1497fb);
            parcel.writeInt(this.f1498s ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
