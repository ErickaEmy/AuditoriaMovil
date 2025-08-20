package s;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import hw.d;
import hw.i4;
import hw.mg;
import hw.ta;
import hw.z6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import s.y;
import t.n3;
import wz.f3;
/* loaded from: classes.dex */
public class wz extends s.y implements ActionBarOverlayLayout.gv {

    /* renamed from: a  reason: collision with root package name */
    public f3 f13489a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13490c;

    /* renamed from: c5  reason: collision with root package name */
    public androidx.appcompat.widget.n3 f13491c5;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f13493d0;

    /* renamed from: fb  reason: collision with root package name */
    public ActionBarContextView f13496fb;

    /* renamed from: gv  reason: collision with root package name */
    public ActionBarOverlayLayout f13498gv;

    /* renamed from: i4  reason: collision with root package name */
    public boolean f13499i4;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f13502mt;

    /* renamed from: n  reason: collision with root package name */
    public t.s f13503n;

    /* renamed from: n3  reason: collision with root package name */
    public Context f13504n3;

    /* renamed from: r  reason: collision with root package name */
    public boolean f13506r;

    /* renamed from: s  reason: collision with root package name */
    public View f13508s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f13509t;

    /* renamed from: tl  reason: collision with root package name */
    public gv f13510tl;

    /* renamed from: v  reason: collision with root package name */
    public ActionBarContainer f13511v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f13512w;

    /* renamed from: wz  reason: collision with root package name */
    public t.n3 f13513wz;

    /* renamed from: x4  reason: collision with root package name */
    public boolean f13514x4;

    /* renamed from: xc  reason: collision with root package name */
    public n3.y f13515xc;
    public Context y;

    /* renamed from: zn  reason: collision with root package name */
    public Activity f13517zn;

    /* renamed from: ta  reason: collision with root package name */
    public static final Interpolator f13488ta = new AccelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public static final Interpolator f13487d = new DecelerateInterpolator();

    /* renamed from: i9  reason: collision with root package name */
    public ArrayList<Object> f13500i9 = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public int f13494f = -1;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<y.n3> f13505p = new ArrayList<>();

    /* renamed from: co  reason: collision with root package name */
    public int f13492co = 0;

    /* renamed from: z  reason: collision with root package name */
    public boolean f13516z = true;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f13495f3 = true;

    /* renamed from: fh  reason: collision with root package name */
    public final ta f13497fh = new y();

    /* renamed from: rz  reason: collision with root package name */
    public final ta f13507rz = new n3();

    /* renamed from: mg  reason: collision with root package name */
    public final z6 f13501mg = new zn();

    /* loaded from: classes.dex */
    public class gv extends t.n3 implements v.y {

        /* renamed from: f  reason: collision with root package name */
        public n3.y f13518f;

        /* renamed from: fb  reason: collision with root package name */
        public final Context f13519fb;

        /* renamed from: s  reason: collision with root package name */
        public final androidx.appcompat.view.menu.v f13520s;

        /* renamed from: t  reason: collision with root package name */
        public WeakReference<View> f13521t;

        public gv(Context context, n3.y yVar) {
            this.f13519fb = context;
            this.f13518f = yVar;
            androidx.appcompat.view.menu.v o2 = new androidx.appcompat.view.menu.v(context).o(1);
            this.f13520s = o2;
            o2.qn(this);
        }

        @Override // t.n3
        public MenuInflater a() {
            return new t.fb(this.f13519fb);
        }

        @Override // t.n3
        public CharSequence c5() {
            return wz.this.f13496fb.getTitle();
        }

        @Override // t.n3
        public void co(boolean z2) {
            super.co(z2);
            wz.this.f13496fb.setTitleOptional(z2);
        }

        @Override // t.n3
        public void f() {
            if (wz.this.f13510tl != this) {
                return;
            }
            this.f13520s.xg();
            try {
                this.f13518f.y(this, this.f13520s);
            } finally {
                this.f13520s.y5();
            }
        }

        @Override // t.n3
        public CharSequence fb() {
            return wz.this.f13496fb.getSubtitle();
        }

        @Override // t.n3
        public View gv() {
            WeakReference<View> weakReference = this.f13521t;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // t.n3
        public void mt(CharSequence charSequence) {
            wz.this.f13496fb.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.menu.v.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar) {
            if (this.f13518f == null) {
                return;
            }
            f();
            wz.this.f13496fb.t();
        }

        @Override // t.n3
        public void p(int i) {
            mt(wz.this.y.getResources().getString(i));
        }

        @Override // t.n3
        public boolean t() {
            return wz.this.f13496fb.i9();
        }

        @Override // t.n3
        public void tl(View view) {
            wz.this.f13496fb.setCustomView(view);
            this.f13521t = new WeakReference<>(view);
        }

        @Override // t.n3
        public Menu v() {
            return this.f13520s;
        }

        @Override // t.n3
        public void wz(int i) {
            xc(wz.this.y.getResources().getString(i));
        }

        @Override // t.n3
        public void xc(CharSequence charSequence) {
            wz.this.f13496fb.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.menu.v.y
        public boolean y(@NonNull androidx.appcompat.view.menu.v vVar, @NonNull MenuItem menuItem) {
            n3.y yVar = this.f13518f;
            if (yVar != null) {
                return yVar.gv(this, menuItem);
            }
            return false;
        }

        public boolean z() {
            this.f13520s.xg();
            try {
                return this.f13518f.n3(this, this.f13520s);
            } finally {
                this.f13520s.y5();
            }
        }

        @Override // t.n3
        public void zn() {
            wz wzVar = wz.this;
            if (wzVar.f13510tl != this) {
                return;
            }
            if (!wz.n(wzVar.f13506r, wzVar.f13514x4, false)) {
                wz wzVar2 = wz.this;
                wzVar2.f13513wz = this;
                wzVar2.f13515xc = this.f13518f;
            } else {
                this.f13518f.zn(this);
            }
            this.f13518f = null;
            wz.this.f3(false);
            wz.this.f13496fb.fb();
            wz.this.f13489a.wz().sendAccessibilityEvent(32);
            wz wzVar3 = wz.this;
            wzVar3.f13498gv.setHideOnContentScrollEnabled(wzVar3.f13493d0);
            wz.this.f13510tl = null;
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends d {
        public n3() {
        }

        @Override // hw.ta
        public void n3(View view) {
            wz wzVar = wz.this;
            wzVar.f13503n = null;
            wzVar.f13511v.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class y extends d {
        public y() {
        }

        @Override // hw.ta
        public void n3(View view) {
            View view2;
            wz wzVar = wz.this;
            if (wzVar.f13516z && (view2 = wzVar.f13508s) != null) {
                view2.setTranslationY(0.0f);
                wz.this.f13511v.setTranslationY(0.0f);
            }
            wz.this.f13511v.setVisibility(8);
            wz.this.f13511v.setTransitioning(false);
            wz wzVar2 = wz.this;
            wzVar2.f13503n = null;
            wzVar2.c();
            ActionBarOverlayLayout actionBarOverlayLayout = wz.this.f13498gv;
            if (actionBarOverlayLayout != null) {
                i4.yg(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn implements z6 {
        public zn() {
        }

        @Override // hw.z6
        public void y(View view) {
            ((View) wz.this.f13511v.getParent()).invalidate();
        }
    }

    public wz(Activity activity, boolean z2) {
        this.f13517zn = activity;
        View decorView = activity.getWindow().getDecorView();
        d(decorView);
        if (z2) {
            return;
        }
        this.f13508s = decorView.findViewById(16908290);
    }

    public static boolean n(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        if (!z2 && !z3) {
            return true;
        }
        return false;
    }

    public void a8(boolean z2) {
        if (z2 && !this.f13498gv.i4()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f13493d0 = z2;
        this.f13498gv.setHideOnContentScrollEnabled(z2);
    }

    public void b(CharSequence charSequence) {
        this.f13489a.i9(charSequence);
    }

    public void c() {
        n3.y yVar = this.f13515xc;
        if (yVar != null) {
            yVar.zn(this.f13513wz);
            this.f13513wz = null;
            this.f13515xc = null;
        }
    }

    @Override // s.y
    public int c5() {
        return this.f13489a.x4();
    }

    @Override // s.y
    public void co(boolean z2) {
        t.s sVar;
        this.f13490c = z2;
        if (!z2 && (sVar = this.f13503n) != null) {
            sVar.y();
        }
    }

    public final void d(View view) {
        boolean z2;
        boolean z3;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.f762w);
        this.f13498gv = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f13489a = rz(view.findViewById(R$id.y));
        this.f13496fb = (ActionBarContextView) view.findViewById(R$id.f730a);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.f770zn);
        this.f13511v = actionBarContainer;
        f3 f3Var = this.f13489a;
        if (f3Var != null && this.f13496fb != null && actionBarContainer != null) {
            this.y = f3Var.getContext();
            if ((this.f13489a.x4() & 4) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f13509t = true;
            }
            t.y n32 = t.y.n3(this.y);
            if (!n32.y() && !z2) {
                z3 = false;
            } else {
                z3 = true;
            }
            x(z3);
            ud(n32.fb());
            TypedArray obtainStyledAttributes = this.y.obtainStyledAttributes(null, R$styleable.y, R$attr.f664zn, 0);
            if (obtainStyledAttributes.getBoolean(R$styleable.f834f, false)) {
                a8(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f816c5, 0);
            if (dimensionPixelSize != 0) {
                ej(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    public void d0(boolean z2) {
        View view;
        int[] iArr;
        t.s sVar = this.f13503n;
        if (sVar != null) {
            sVar.y();
        }
        if (this.f13492co == 0 && (this.f13490c || z2)) {
            this.f13511v.setAlpha(1.0f);
            this.f13511v.setTransitioning(true);
            t.s sVar2 = new t.s();
            float f4 = -this.f13511v.getHeight();
            if (z2) {
                this.f13511v.getLocationInWindow(new int[]{0, 0});
                f4 -= iArr[1];
            }
            mg tl2 = i4.v(this.f13511v).tl(f4);
            tl2.f(this.f13501mg);
            sVar2.zn(tl2);
            if (this.f13516z && (view = this.f13508s) != null) {
                sVar2.zn(i4.v(view).tl(f4));
            }
            sVar2.a(f13488ta);
            sVar2.v(250L);
            sVar2.fb(this.f13497fh);
            this.f13503n = sVar2;
            sVar2.s();
            return;
        }
        this.f13497fh.n3(null);
    }

    public void ej(float f4) {
        i4.pz(this.f13511v, f4);
    }

    public void f3(boolean z2) {
        mg tl2;
        mg a2;
        if (z2) {
            vl();
        } else {
            ta();
        }
        if (yt()) {
            if (z2) {
                a2 = this.f13489a.tl(4, 100L);
                tl2 = this.f13496fb.a(0, 200L);
            } else {
                tl2 = this.f13489a.tl(0, 200L);
                a2 = this.f13496fb.a(8, 100L);
            }
            t.s sVar = new t.s();
            sVar.gv(a2, tl2);
            sVar.s();
        } else if (z2) {
            this.f13489a.setVisibility(4);
            this.f13496fb.setVisibility(0);
        } else {
            this.f13489a.setVisibility(0);
            this.f13496fb.setVisibility(8);
        }
    }

    @Override // s.y
    public boolean fb() {
        f3 f3Var = this.f13489a;
        if (f3Var != null && f3Var.s()) {
            this.f13489a.collapseActionView();
            return true;
        }
        return false;
    }

    public void fh(boolean z2) {
        View view;
        View view2;
        int[] iArr;
        t.s sVar = this.f13503n;
        if (sVar != null) {
            sVar.y();
        }
        this.f13511v.setVisibility(0);
        if (this.f13492co == 0 && (this.f13490c || z2)) {
            this.f13511v.setTranslationY(0.0f);
            float f4 = -this.f13511v.getHeight();
            if (z2) {
                this.f13511v.getLocationInWindow(new int[]{0, 0});
                f4 -= iArr[1];
            }
            this.f13511v.setTranslationY(f4);
            t.s sVar2 = new t.s();
            mg tl2 = i4.v(this.f13511v).tl(0.0f);
            tl2.f(this.f13501mg);
            sVar2.zn(tl2);
            if (this.f13516z && (view2 = this.f13508s) != null) {
                view2.setTranslationY(f4);
                sVar2.zn(i4.v(this.f13508s).tl(0.0f));
            }
            sVar2.a(f13487d);
            sVar2.v(250L);
            sVar2.fb(this.f13507rz);
            this.f13503n = sVar2;
            sVar2.s();
        } else {
            this.f13511v.setAlpha(1.0f);
            this.f13511v.setTranslationY(0.0f);
            if (this.f13516z && (view = this.f13508s) != null) {
                view.setTranslationY(0.0f);
            }
            this.f13507rz.n3(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f13498gv;
        if (actionBarOverlayLayout != null) {
            i4.yg(actionBarOverlayLayout);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.gv
    public void gv() {
        if (!this.f13514x4) {
            this.f13514x4 = true;
            hw(true);
        }
    }

    public final void hw(boolean z2) {
        if (n(this.f13506r, this.f13514x4, this.f13499i4)) {
            if (!this.f13495f3) {
                this.f13495f3 = true;
                fh(z2);
            }
        } else if (this.f13495f3) {
            this.f13495f3 = false;
            d0(z2);
        }
    }

    @Override // s.y
    public t.n3 i4(n3.y yVar) {
        gv gvVar = this.f13510tl;
        if (gvVar != null) {
            gvVar.zn();
        }
        this.f13498gv.setHideOnContentScrollEnabled(false);
        this.f13496fb.f();
        gv gvVar2 = new gv(this.f13496fb.getContext(), yVar);
        if (gvVar2.z()) {
            this.f13510tl = gvVar2;
            gvVar2.f();
            this.f13496fb.s(gvVar2);
            f3(true);
            this.f13496fb.sendAccessibilityEvent(32);
            return gvVar2;
        }
        return null;
    }

    @Override // s.y
    public Context i9() {
        if (this.f13504n3 == null) {
            TypedValue typedValue = new TypedValue();
            this.y.getTheme().resolveAttribute(R$attr.f636fb, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f13504n3 = new ContextThemeWrapper(this.y, i);
            } else {
                this.f13504n3 = this.y;
            }
        }
        return this.f13504n3;
    }

    public void k5(CharSequence charSequence) {
        this.f13489a.setTitle(charSequence);
    }

    public int mg() {
        return this.f13489a.t();
    }

    @Override // s.y
    public void mt(boolean z2) {
        int i;
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        z6(i, 4);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.gv
    public void onWindowVisibilityChanged(int i) {
        this.f13492co = i;
    }

    @Override // s.y
    public void p(boolean z2) {
        if (!this.f13509t) {
            mt(z2);
        }
    }

    @Override // s.y
    public void r(int i) {
        k5(this.y.getString(i));
    }

    public final f3 rz(View view) {
        String str;
        if (view instanceof f3) {
            return (f3) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        if (view != null) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    @Override // s.y
    public void s(boolean z2) {
        if (z2 == this.f13512w) {
            return;
        }
        this.f13512w = z2;
        int size = this.f13505p.size();
        for (int i = 0; i < size; i++) {
            this.f13505p.get(i).y(z2);
        }
    }

    @Override // s.y
    public void t(Configuration configuration) {
        ud(t.y.n3(this.y).fb());
    }

    public final void ta() {
        if (this.f13499i4) {
            this.f13499i4 = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f13498gv;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            hw(false);
        }
    }

    public final void ud(boolean z2) {
        boolean z3;
        boolean z4;
        this.f13502mt = z2;
        if (!z2) {
            this.f13489a.co(null);
            this.f13511v.setTabContainer(this.f13491c5);
        } else {
            this.f13511v.setTabContainer(null);
            this.f13489a.co(this.f13491c5);
        }
        boolean z5 = true;
        if (mg() == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        androidx.appcompat.widget.n3 n3Var = this.f13491c5;
        if (n3Var != null) {
            if (z3) {
                n3Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f13498gv;
                if (actionBarOverlayLayout != null) {
                    i4.yg(actionBarOverlayLayout);
                }
            } else {
                n3Var.setVisibility(8);
            }
        }
        f3 f3Var = this.f13489a;
        if (!this.f13502mt && z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        f3Var.p(z4);
        this.f13498gv.setHasNonEmbeddedTabs((this.f13502mt || !z3) ? false : false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.gv
    public void v() {
        t.s sVar = this.f13503n;
        if (sVar != null) {
            sVar.y();
            this.f13503n = null;
        }
    }

    public final void vl() {
        if (!this.f13499i4) {
            this.f13499i4 = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f13498gv;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            hw(false);
        }
    }

    @Override // s.y
    public boolean wz(int i, KeyEvent keyEvent) {
        Menu v2;
        int i5;
        gv gvVar = this.f13510tl;
        if (gvVar == null || (v2 = gvVar.v()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i5 = keyEvent.getDeviceId();
        } else {
            i5 = -1;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(i5).getKeyboardType() == 1) {
            z2 = false;
        }
        v2.setQwertyMode(z2);
        return v2.performShortcut(i, keyEvent, 0);
    }

    public void x(boolean z2) {
        this.f13489a.xc(z2);
    }

    @Override // s.y
    public void x4(CharSequence charSequence) {
        this.f13489a.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.gv
    public void y() {
        if (this.f13514x4) {
            this.f13514x4 = false;
            hw(true);
        }
    }

    public final boolean yt() {
        return i4.q9(this.f13511v);
    }

    @Override // s.y
    public void z(int i) {
        b(this.y.getString(i));
    }

    public void z6(int i, int i5) {
        int x42 = this.f13489a.x4();
        if ((i5 & 4) != 0) {
            this.f13509t = true;
        }
        this.f13489a.c5((i & i5) | ((~i5) & x42));
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.gv
    public void zn(boolean z2) {
        this.f13516z = z2;
    }

    public wz(Dialog dialog) {
        d(dialog.getWindow().getDecorView());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.gv
    public void n3() {
    }
}
