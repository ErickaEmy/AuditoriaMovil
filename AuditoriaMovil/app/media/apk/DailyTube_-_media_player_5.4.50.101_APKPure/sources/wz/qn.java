package wz;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
/* loaded from: classes.dex */
public class qn implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: r  reason: collision with root package name */
    public static qn f14744r;

    /* renamed from: z  reason: collision with root package name */
    public static qn f14745z;

    /* renamed from: co  reason: collision with root package name */
    public boolean f14746co;

    /* renamed from: fb  reason: collision with root package name */
    public final int f14748fb;

    /* renamed from: p  reason: collision with root package name */
    public o f14749p;

    /* renamed from: t  reason: collision with root package name */
    public int f14751t;

    /* renamed from: v  reason: collision with root package name */
    public final CharSequence f14752v;

    /* renamed from: w  reason: collision with root package name */
    public int f14753w;
    public final View y;

    /* renamed from: s  reason: collision with root package name */
    public final Runnable f14750s = new y();

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f14747f = new n3();

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qn.this.zn();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qn.this.fb(false);
        }
    }

    public qn(View view, CharSequence charSequence) {
        this.y = view;
        this.f14752v = charSequence;
        this.f14748fb = hw.n.gv(ViewConfiguration.get(view.getContext()));
        n3();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        qn qnVar = f14745z;
        if (qnVar != null && qnVar.y == view) {
            v(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            qn qnVar2 = f14744r;
            if (qnVar2 != null && qnVar2.y == view) {
                qnVar2.zn();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new qn(view, charSequence);
    }

    public static void v(qn qnVar) {
        qn qnVar2 = f14745z;
        if (qnVar2 != null) {
            qnVar2.y();
        }
        f14745z = qnVar;
        if (qnVar != null) {
            qnVar.gv();
        }
    }

    public void fb(boolean z2) {
        long longPressTimeout;
        long j2;
        long j4;
        if (!hw.i4.ut(this.y)) {
            return;
        }
        v(null);
        qn qnVar = f14744r;
        if (qnVar != null) {
            qnVar.zn();
        }
        f14744r = this;
        this.f14746co = z2;
        o oVar = new o(this.y.getContext());
        this.f14749p = oVar;
        oVar.v(this.y, this.f14751t, this.f14753w, this.f14746co, this.f14752v);
        this.y.addOnAttachStateChangeListener(this);
        if (this.f14746co) {
            j4 = 2500;
        } else {
            if ((hw.i4.hw(this.y) & 1) == 1) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j2 = 3000;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j2 = 15000;
            }
            j4 = j2 - longPressTimeout;
        }
        this.y.removeCallbacks(this.f14747f);
        this.y.postDelayed(this.f14747f, j4);
    }

    public final void gv() {
        this.y.postDelayed(this.f14750s, ViewConfiguration.getLongPressTimeout());
    }

    public final void n3() {
        this.f14751t = Integer.MAX_VALUE;
        this.f14753w = Integer.MAX_VALUE;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f14749p != null && this.f14746co) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.y.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                n3();
                zn();
            }
        } else if (this.y.isEnabled() && this.f14749p == null && s(motionEvent)) {
            v(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f14751t = view.getWidth() / 2;
        this.f14753w = view.getHeight() / 2;
        fb(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        zn();
    }

    public final boolean s(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (Math.abs(x2 - this.f14751t) <= this.f14748fb && Math.abs(y2 - this.f14753w) <= this.f14748fb) {
            return false;
        }
        this.f14751t = x2;
        this.f14753w = y2;
        return true;
    }

    public final void y() {
        this.y.removeCallbacks(this.f14750s);
    }

    public void zn() {
        if (f14744r == this) {
            f14744r = null;
            o oVar = this.f14749p;
            if (oVar != null) {
                oVar.zn();
                this.f14749p = null;
                n3();
                this.y.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f14745z == this) {
            v(null);
        }
        this.y.removeCallbacks(this.f14747f);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
