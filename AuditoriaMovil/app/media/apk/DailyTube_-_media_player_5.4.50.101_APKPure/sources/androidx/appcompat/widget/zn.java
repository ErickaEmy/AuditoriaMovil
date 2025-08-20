package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.c5;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.Toolbar;
import hw.d;
import hw.i4;
import hw.mg;
import wz.f3;
import wz.hw;
/* loaded from: classes.dex */
public class zn implements f3 {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f1545a;

    /* renamed from: c5  reason: collision with root package name */
    public CharSequence f1546c5;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f1547f;

    /* renamed from: fb  reason: collision with root package name */
    public Drawable f1548fb;

    /* renamed from: gv  reason: collision with root package name */
    public View f1549gv;

    /* renamed from: i9  reason: collision with root package name */
    public CharSequence f1550i9;

    /* renamed from: n3  reason: collision with root package name */
    public int f1551n3;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f1552p;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1553s;

    /* renamed from: t  reason: collision with root package name */
    public Window.Callback f1554t;

    /* renamed from: tl  reason: collision with root package name */
    public boolean f1555tl;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f1556v;

    /* renamed from: w  reason: collision with root package name */
    public int f1557w;

    /* renamed from: wz  reason: collision with root package name */
    public androidx.appcompat.widget.y f1558wz;

    /* renamed from: xc  reason: collision with root package name */
    public int f1559xc;
    public Toolbar y;

    /* renamed from: zn  reason: collision with root package name */
    public View f1560zn;

    /* loaded from: classes.dex */
    public class n3 extends d {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ int f1561n3;
        public boolean y;

        public n3(int i) {
            this.f1561n3 = i;
        }

        @Override // hw.ta
        public void n3(View view) {
            if (!this.y) {
                zn.this.y.setVisibility(this.f1561n3);
            }
        }

        @Override // hw.d, hw.ta
        public void y(View view) {
            this.y = true;
        }

        @Override // hw.d, hw.ta
        public void zn(View view) {
            zn.this.y.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public class y implements View.OnClickListener {
        public final tl.y y;

        public y() {
            this.y = new tl.y(zn.this.y.getContext(), 0, 16908332, 0, 0, zn.this.f1546c5);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn znVar = zn.this;
            Window.Callback callback = znVar.f1554t;
            if (callback != null && znVar.f1555tl) {
                callback.onMenuItemSelected(0, this.y);
            }
        }
    }

    public zn(Toolbar toolbar, boolean z2) {
        this(toolbar, z2, R$string.y, R$drawable.f722wz);
    }

    @Override // wz.f3
    public void a() {
        this.f1555tl = true;
    }

    public void c(int i) {
        if (i == this.f1557w) {
            return;
        }
        this.f1557w = i;
        if (TextUtils.isEmpty(this.y.getNavigationContentDescription())) {
            fh(this.f1557w);
        }
    }

    @Override // wz.f3
    public void c5(int i) {
        View view;
        int i5 = this.f1551n3 ^ i;
        this.f1551n3 = i;
        if (i5 != 0) {
            if ((i5 & 4) != 0) {
                if ((i & 4) != 0) {
                    d();
                }
                z6();
            }
            if ((i5 & 3) != 0) {
                ej();
            }
            if ((i5 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.y.setTitle(this.f1546c5);
                    this.y.setSubtitle(this.f1550i9);
                } else {
                    this.y.setTitle((CharSequence) null);
                    this.y.setSubtitle((CharSequence) null);
                }
            }
            if ((i5 & 16) != 0 && (view = this.f1549gv) != null) {
                if ((i & 16) != 0) {
                    this.y.addView(view);
                } else {
                    this.y.removeView(view);
                }
            }
        }
    }

    @Override // wz.f3
    public void co(androidx.appcompat.widget.n3 n3Var) {
        View view = this.f1560zn;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.y;
            if (parent == toolbar) {
                toolbar.removeView(this.f1560zn);
            }
        }
        this.f1560zn = n3Var;
        if (n3Var != null && this.f1559xc == 2) {
            this.y.addView(n3Var, 0);
            Toolbar.v vVar = (Toolbar.v) this.f1560zn.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) vVar).width = -2;
            ((ViewGroup.MarginLayoutParams) vVar).height = -2;
            vVar.y = 8388691;
            n3Var.setAllowCollapse(true);
        }
    }

    @Override // wz.f3
    public void collapseActionView() {
        this.y.v();
    }

    public final void d() {
        if ((this.f1551n3 & 4) != 0) {
            if (TextUtils.isEmpty(this.f1547f)) {
                this.y.setNavigationContentDescription(this.f1557w);
            } else {
                this.y.setNavigationContentDescription(this.f1547f);
            }
        }
    }

    public void d0(Drawable drawable) {
        this.f1545a = drawable;
        ej();
    }

    public final void ej() {
        Drawable drawable;
        int i = this.f1551n3;
        if ((i & 2) != 0) {
            if ((i & 1) != 0) {
                drawable = this.f1545a;
                if (drawable == null) {
                    drawable = this.f1556v;
                }
            } else {
                drawable = this.f1556v;
            }
        } else {
            drawable = null;
        }
        this.y.setLogo(drawable);
    }

    @Override // wz.f3
    public Menu f() {
        return this.y.getMenu();
    }

    public final int f3() {
        if (this.y.getNavigationIcon() != null) {
            this.f1552p = this.y.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    @Override // wz.f3
    public boolean fb() {
        return this.y.c();
    }

    public void fh(int i) {
        String string;
        if (i == 0) {
            string = null;
        } else {
            string = getContext().getString(i);
        }
        rz(string);
    }

    @Override // wz.f3
    public Context getContext() {
        return this.y.getContext();
    }

    @Override // wz.f3
    public CharSequence getTitle() {
        return this.y.getTitle();
    }

    @Override // wz.f3
    public void gv(Menu menu, c5.y yVar) {
        if (this.f1558wz == null) {
            androidx.appcompat.widget.y yVar2 = new androidx.appcompat.widget.y(this.y.getContext());
            this.f1558wz = yVar2;
            yVar2.w(R$id.f741fb);
        }
        this.f1558wz.gv(yVar);
        this.y.ud((v) menu, this.f1558wz);
    }

    @Override // wz.f3
    public void i4() {
    }

    @Override // wz.f3
    public void i9(CharSequence charSequence) {
        this.f1550i9 = charSequence;
        if ((this.f1551n3 & 8) != 0) {
            this.y.setSubtitle(charSequence);
        }
    }

    public void mg(Drawable drawable) {
        this.f1548fb = drawable;
        z6();
    }

    @Override // wz.f3
    public void mt() {
        this.y.a();
    }

    public void n(View view) {
        View view2 = this.f1549gv;
        if (view2 != null && (this.f1551n3 & 16) != 0) {
            this.y.removeView(view2);
        }
        this.f1549gv = view;
        if (view != null && (this.f1551n3 & 16) != 0) {
            this.y.addView(view);
        }
    }

    @Override // wz.f3
    public boolean n3() {
        return this.y.i4();
    }

    @Override // wz.f3
    public void p(boolean z2) {
        this.y.setCollapsible(z2);
    }

    @Override // wz.f3
    public void r(c5.y yVar, v.y yVar2) {
        this.y.a8(yVar, yVar2);
    }

    public void rz(CharSequence charSequence) {
        this.f1547f = charSequence;
        d();
    }

    @Override // wz.f3
    public boolean s() {
        return this.y.x4();
    }

    @Override // wz.f3
    public void setIcon(int i) {
        setIcon(i != 0 ? c5.y.gv(getContext(), i) : null);
    }

    @Override // wz.f3
    public void setTitle(CharSequence charSequence) {
        this.f1553s = true;
        ta(charSequence);
    }

    @Override // wz.f3
    public void setVisibility(int i) {
        this.y.setVisibility(i);
    }

    @Override // wz.f3
    public void setWindowCallback(Window.Callback callback) {
        this.f1554t = callback;
    }

    @Override // wz.f3
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1553s) {
            ta(charSequence);
        }
    }

    @Override // wz.f3
    public int t() {
        return this.f1559xc;
    }

    public final void ta(CharSequence charSequence) {
        this.f1546c5 = charSequence;
        if ((this.f1551n3 & 8) != 0) {
            this.y.setTitle(charSequence);
        }
    }

    @Override // wz.f3
    public mg tl(int i, long j2) {
        float f4;
        mg v2 = i4.v(this.y);
        if (i == 0) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        return v2.n3(f4).a(j2).s(new n3(i));
    }

    @Override // wz.f3
    public boolean v() {
        return this.y.d0();
    }

    @Override // wz.f3
    public void w() {
    }

    @Override // wz.f3
    public ViewGroup wz() {
        return this.y;
    }

    @Override // wz.f3
    public int x4() {
        return this.f1551n3;
    }

    @Override // wz.f3
    public void xc(boolean z2) {
    }

    @Override // wz.f3
    public boolean y() {
        return this.y.gv();
    }

    @Override // wz.f3
    public void z(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = c5.y.gv(getContext(), i);
        } else {
            drawable = null;
        }
        d0(drawable);
    }

    public final void z6() {
        if ((this.f1551n3 & 4) != 0) {
            Toolbar toolbar = this.y;
            Drawable drawable = this.f1548fb;
            if (drawable == null) {
                drawable = this.f1552p;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.y.setNavigationIcon((Drawable) null);
    }

    @Override // wz.f3
    public boolean zn() {
        return this.y.vl();
    }

    public zn(Toolbar toolbar, boolean z2, int i, int i5) {
        Drawable drawable;
        this.y = toolbar;
        this.f1546c5 = toolbar.getTitle();
        this.f1550i9 = toolbar.getSubtitle();
        this.f1553s = this.f1546c5 != null;
        this.f1548fb = toolbar.getNavigationIcon();
        hw x42 = hw.x4(toolbar.getContext(), null, R$styleable.y, R$attr.f664zn, 0);
        this.f1552p = x42.fb(R$styleable.f897t);
        if (z2) {
            CharSequence w4 = x42.w(R$styleable.f869mt);
            if (!TextUtils.isEmpty(w4)) {
                setTitle(w4);
            }
            CharSequence w5 = x42.w(R$styleable.f911w);
            if (!TextUtils.isEmpty(w5)) {
                i9(w5);
            }
            Drawable fb2 = x42.fb(R$styleable.f916wz);
            if (fb2 != null) {
                d0(fb2);
            }
            Drawable fb3 = x42.fb(R$styleable.f900tl);
            if (fb3 != null) {
                setIcon(fb3);
            }
            if (this.f1548fb == null && (drawable = this.f1552p) != null) {
                mg(drawable);
            }
            c5(x42.f(R$styleable.f895s, 0));
            int wz2 = x42.wz(R$styleable.f838fb, 0);
            if (wz2 != 0) {
                n(LayoutInflater.from(this.y.getContext()).inflate(wz2, (ViewGroup) this.y, false));
                c5(this.f1551n3 | 16);
            }
            int tl2 = x42.tl(R$styleable.f849i9, 0);
            if (tl2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
                layoutParams.height = tl2;
                this.y.setLayoutParams(layoutParams);
            }
            int v2 = x42.v(R$styleable.f806a, -1);
            int v3 = x42.v(R$styleable.f907v, -1);
            if (v2 >= 0 || v3 >= 0) {
                this.y.ej(Math.max(v2, 0), Math.max(v3, 0));
            }
            int wz3 = x42.wz(R$styleable.f817co, 0);
            if (wz3 != 0) {
                Toolbar toolbar2 = this.y;
                toolbar2.b(toolbar2.getContext(), wz3);
            }
            int wz4 = x42.wz(R$styleable.f880p, 0);
            if (wz4 != 0) {
                Toolbar toolbar3 = this.y;
                toolbar3.x(toolbar3.getContext(), wz4);
            }
            int wz5 = x42.wz(R$styleable.f921xc, 0);
            if (wz5 != 0) {
                this.y.setPopupTheme(wz5);
            }
        } else {
            this.f1551n3 = f3();
        }
        x42.i4();
        c(i);
        this.f1547f = this.y.getNavigationContentDescription();
        this.y.setNavigationOnClickListener(new y());
    }

    @Override // wz.f3
    public void setIcon(Drawable drawable) {
        this.f1556v = drawable;
        ej();
    }
}
