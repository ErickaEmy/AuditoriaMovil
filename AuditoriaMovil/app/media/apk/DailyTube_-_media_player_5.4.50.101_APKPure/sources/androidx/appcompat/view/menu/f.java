package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.c5;
import hw.i4;
import wz.ta;
/* loaded from: classes.dex */
public final class f extends tl.gv implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, c5, View.OnKeyListener {

    /* renamed from: qn  reason: collision with root package name */
    public static final int f1089qn = R$layout.f783tl;

    /* renamed from: c  reason: collision with root package name */
    public View f1091c;

    /* renamed from: co  reason: collision with root package name */
    public final ta f1092co;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1093d;

    /* renamed from: d0  reason: collision with root package name */
    public c5.y f1094d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f1095ej;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1096f;

    /* renamed from: f3  reason: collision with root package name */
    public PopupWindow.OnDismissListener f1097f3;

    /* renamed from: fb  reason: collision with root package name */
    public final v f1098fb;

    /* renamed from: fh  reason: collision with root package name */
    public ViewTreeObserver f1099fh;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f1100j5;

    /* renamed from: n  reason: collision with root package name */
    public View f1101n;

    /* renamed from: p  reason: collision with root package name */
    public final int f1102p;

    /* renamed from: s  reason: collision with root package name */
    public final gv f1104s;

    /* renamed from: t  reason: collision with root package name */
    public final int f1105t;

    /* renamed from: v  reason: collision with root package name */
    public final Context f1106v;

    /* renamed from: w  reason: collision with root package name */
    public final int f1107w;

    /* renamed from: x  reason: collision with root package name */
    public int f1108x;

    /* renamed from: z  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1109z = new y();

    /* renamed from: r  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1103r = new n3();

    /* renamed from: b  reason: collision with root package name */
    public int f1090b = 0;

    /* loaded from: classes.dex */
    public class n3 implements View.OnAttachStateChangeListener {
        public n3() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = f.this.f1099fh;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    f.this.f1099fh = view.getViewTreeObserver();
                }
                f fVar = f.this;
                fVar.f1099fh.removeGlobalOnLayoutListener(fVar.f1109z);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    public class y implements ViewTreeObserver.OnGlobalLayoutListener {
        public y() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (f.this.y() && !f.this.f1092co.d0()) {
                View view = f.this.f1091c;
                if (view != null && view.isShown()) {
                    f.this.f1092co.show();
                } else {
                    f.this.dismiss();
                }
            }
        }
    }

    public f(Context context, v vVar, View view, int i, int i5, boolean z2) {
        this.f1106v = context;
        this.f1098fb = vVar;
        this.f1096f = z2;
        this.f1104s = new gv(vVar, LayoutInflater.from(context), z2, f1089qn);
        this.f1107w = i;
        this.f1102p = i5;
        Resources resources = context.getResources();
        this.f1105t = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.f676gv));
        this.f1101n = view;
        this.f1092co = new ta(context, null, i, i5);
        vVar.zn(this, context);
    }

    @Override // androidx.appcompat.view.menu.c5
    public void a(boolean z2) {
        this.f1095ej = false;
        gv gvVar = this.f1104s;
        if (gvVar != null) {
            gvVar.notifyDataSetChanged();
        }
    }

    @Override // tl.gv
    public void co(int i) {
        this.f1092co.v(i);
    }

    @Override // tl.a
    public void dismiss() {
        if (y()) {
            this.f1092co.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean fb() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.c5
    public void gv(c5.y yVar) {
        this.f1094d0 = yVar;
    }

    @Override // tl.gv
    public void i9(v vVar) {
    }

    @Override // tl.gv
    public void mt(int i) {
        this.f1090b = i;
    }

    public final boolean n() {
        View view;
        boolean z2;
        if (y()) {
            return true;
        }
        if (this.f1093d || (view = this.f1101n) == null) {
            return false;
        }
        this.f1091c = view;
        this.f1092co.a8(this);
        this.f1092co.x(this);
        this.f1092co.ud(true);
        View view2 = this.f1091c;
        if (this.f1099fh == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1099fh = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1109z);
        }
        view2.addOnAttachStateChangeListener(this.f1103r);
        this.f1092co.rz(view2);
        this.f1092co.d(this.f1090b);
        if (!this.f1095ej) {
            this.f1108x = tl.gv.tl(this.f1104s, null, this.f1106v, this.f1105t);
            this.f1095ej = true;
        }
        this.f1092co.ta(this.f1108x);
        this.f1092co.ej(2);
        this.f1092co.z6(t());
        this.f1092co.show();
        ListView xc2 = this.f1092co.xc();
        xc2.setOnKeyListener(this);
        if (this.f1100j5 && this.f1098fb.f3() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1106v).inflate(R$layout.f782t, (ViewGroup) xc2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1098fb.f3());
            }
            frameLayout.setEnabled(false);
            xc2.addHeaderView(frameLayout, null, false);
        }
        this.f1092co.tl(this.f1104s);
        this.f1092co.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.c5
    public void n3(v vVar, boolean z2) {
        if (vVar != this.f1098fb) {
            return;
        }
        dismiss();
        c5.y yVar = this.f1094d0;
        if (yVar != null) {
            yVar.n3(vVar, z2);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1093d = true;
        this.f1098fb.close();
        ViewTreeObserver viewTreeObserver = this.f1099fh;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1099fh = this.f1091c.getViewTreeObserver();
            }
            this.f1099fh.removeGlobalOnLayoutListener(this.f1109z);
            this.f1099fh = null;
        }
        this.f1091c.removeOnAttachStateChangeListener(this.f1103r);
        PopupWindow.OnDismissListener onDismissListener = this.f1097f3;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // tl.gv
    public void p(boolean z2) {
        this.f1104s.gv(z2);
    }

    @Override // tl.gv
    public void r(boolean z2) {
        this.f1100j5 = z2;
    }

    @Override // tl.a
    public void show() {
        if (n()) {
            return;
        }
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean v(t tVar) {
        if (tVar.hasVisibleItems()) {
            s sVar = new s(this.f1106v, tVar, this.f1091c, this.f1096f, this.f1107w, this.f1102p);
            sVar.i9(this.f1094d0);
            sVar.fb(tl.gv.i4(tVar));
            sVar.c5(this.f1097f3);
            this.f1097f3 = null;
            this.f1098fb.v(false);
            int zn2 = this.f1092co.zn();
            int t2 = this.f1092co.t();
            if ((Gravity.getAbsoluteGravity(this.f1090b, i4.ta(this.f1101n)) & 7) == 5) {
                zn2 += this.f1101n.getWidth();
            }
            if (sVar.wz(zn2, t2)) {
                c5.y yVar = this.f1094d0;
                if (yVar != null) {
                    yVar.zn(tVar);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // tl.gv
    public void wz(View view) {
        this.f1101n = view;
    }

    @Override // tl.gv
    public void x4(int i) {
        this.f1092co.c5(i);
    }

    @Override // tl.a
    public ListView xc() {
        return this.f1092co.xc();
    }

    @Override // tl.a
    public boolean y() {
        if (!this.f1093d && this.f1092co.y()) {
            return true;
        }
        return false;
    }

    @Override // tl.gv
    public void z(PopupWindow.OnDismissListener onDismissListener) {
        this.f1097f3 = onDismissListener;
    }
}
