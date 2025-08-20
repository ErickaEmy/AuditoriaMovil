package ut;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import hw.i4;
import j5.gv;
import j5.v;
import java.util.ArrayList;
import java.util.List;
import ut.n3;
import z.c5;
/* loaded from: classes.dex */
public abstract class y extends hw.y {

    /* renamed from: c5  reason: collision with root package name */
    public final View f14269c5;

    /* renamed from: i9  reason: collision with root package name */
    public zn f14273i9;

    /* renamed from: s  reason: collision with root package name */
    public final AccessibilityManager f14274s;

    /* renamed from: wz  reason: collision with root package name */
    public static final Rect f14266wz = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: xc  reason: collision with root package name */
    public static final n3.y<j5.zn> f14267xc = new C0234y();

    /* renamed from: w  reason: collision with root package name */
    public static final n3.InterfaceC0233n3<c5<j5.zn>, j5.zn> f14265w = new n3();

    /* renamed from: gv  reason: collision with root package name */
    public final Rect f14272gv = new Rect();

    /* renamed from: v  reason: collision with root package name */
    public final Rect f14277v = new Rect();

    /* renamed from: a  reason: collision with root package name */
    public final Rect f14268a = new Rect();

    /* renamed from: fb  reason: collision with root package name */
    public final int[] f14271fb = new int[2];

    /* renamed from: f  reason: collision with root package name */
    public int f14270f = Integer.MIN_VALUE;

    /* renamed from: t  reason: collision with root package name */
    public int f14275t = Integer.MIN_VALUE;

    /* renamed from: tl  reason: collision with root package name */
    public int f14276tl = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public class n3 implements n3.InterfaceC0233n3<c5<j5.zn>, j5.zn> {
        @Override // ut.n3.InterfaceC0233n3
        /* renamed from: gv */
        public int n3(c5<j5.zn> c5Var) {
            return c5Var.tl();
        }

        @Override // ut.n3.InterfaceC0233n3
        /* renamed from: zn */
        public j5.zn y(c5<j5.zn> c5Var, int i) {
            return c5Var.wz(i);
        }
    }

    /* renamed from: ut.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0234y implements n3.y<j5.zn> {
        @Override // ut.n3.y
        /* renamed from: n3 */
        public void y(j5.zn znVar, Rect rect) {
            znVar.tl(rect);
        }
    }

    /* loaded from: classes.dex */
    public class zn extends gv {
        public zn() {
        }

        @Override // j5.gv
        public boolean a(int i, int i5, Bundle bundle) {
            return y.this.hw(i, i5, bundle);
        }

        @Override // j5.gv
        public j5.zn gv(int i) {
            int i5;
            if (i == 2) {
                i5 = y.this.f14270f;
            } else {
                i5 = y.this.f14275t;
            }
            if (i5 == Integer.MIN_VALUE) {
                return null;
            }
            return n3(i5);
        }

        @Override // j5.gv
        public j5.zn n3(int i) {
            return j5.zn.u(y.this.ej(i));
        }
    }

    public y(@NonNull View view) {
        if (view != null) {
            this.f14269c5 = view;
            this.f14274s = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (i4.rz(view) == 0) {
                i4.o0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public static int d(int i) {
        if (i != 19) {
            if (i != 21) {
                if (i != 22) {
                    return 130;
                }
                return 66;
            }
            return 17;
        }
        return 33;
    }

    public static Rect mg(@NonNull View view, int i, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        rect.set(0, -1, width, -1);
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect.set(-1, 0, -1, height);
                }
            } else {
                rect.set(0, height, width, height);
            }
        } else {
            rect.set(width, 0, width, height);
        }
        return rect;
    }

    @Override // hw.y
    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        x(accessibilityEvent);
    }

    public abstract boolean a8(int i, int i5, @Nullable Bundle bundle);

    public final void c(int i, Rect rect) {
        ej(i).tl(rect);
    }

    public final AccessibilityEvent co(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.f14269c5.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    public final int d0() {
        return this.f14275t;
    }

    @NonNull
    public j5.zn ej(int i) {
        if (i == -1) {
            return r();
        }
        return z(i);
    }

    public final int f3() {
        return this.f14270f;
    }

    @Override // hw.y
    public void fb(View view, j5.zn znVar) {
        super.fb(view, znVar);
        k5(znVar);
    }

    public abstract int fh(float f4, float f6);

    public boolean hw(int i, int i5, Bundle bundle) {
        if (i != -1) {
            return j5(i, i5, bundle);
        }
        return qn(i5, bundle);
    }

    public final boolean i4(@NonNull KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int d2 = d(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z2 = false;
                        while (i < repeatCount && z6(d2, null)) {
                            i++;
                            z2 = true;
                        }
                        return z2;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            w();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return z6(2, null);
        } else {
            if (!keyEvent.hasModifiers(1)) {
                return false;
            }
            return z6(1, null);
        }
    }

    public final boolean j(int i) {
        int i5;
        if ((!this.f14269c5.isFocused() && !this.f14269c5.requestFocus()) || (i5 = this.f14275t) == i) {
            return false;
        }
        if (i5 != Integer.MIN_VALUE) {
            xc(i5);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.f14275t = i;
        vl(i, true);
        oz(i, 8);
        return true;
    }

    public final boolean j5(int i, int i5, Bundle bundle) {
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 64) {
                    if (i5 != 128) {
                        return a8(i, i5, bundle);
                    }
                    return wz(i);
                }
                return o(i);
            }
            return xc(i);
        }
        return j(i);
    }

    public final AccessibilityEvent mt(int i, int i5) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i5);
        j5.zn ej2 = ej(i);
        obtain.getText().add(ej2.fh());
        obtain.setContentDescription(ej2.z());
        obtain.setScrollable(ej2.oz());
        obtain.setPassword(ej2.j());
        obtain.setEnabled(ej2.yt());
        obtain.setChecked(ej2.x());
        b(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(ej2.p());
        v.zn(obtain, this.f14269c5, i);
        obtain.setPackageName(this.f14269c5.getContext().getPackageName());
        return obtain;
    }

    public final c5<j5.zn> n() {
        ArrayList arrayList = new ArrayList();
        rz(arrayList);
        c5<j5.zn> c5Var = new c5<>();
        for (int i = 0; i < arrayList.size(); i++) {
            c5Var.f(arrayList.get(i).intValue(), z(arrayList.get(i).intValue()));
        }
        return c5Var;
    }

    @Override // hw.y
    public gv n3(View view) {
        if (this.f14273i9 == null) {
            this.f14273i9 = new zn();
        }
        return this.f14273i9;
    }

    public final boolean o(int i) {
        int i5;
        if (!this.f14274s.isEnabled() || !this.f14274s.isTouchExplorationEnabled() || (i5 = this.f14270f) == i) {
            return false;
        }
        if (i5 != Integer.MIN_VALUE) {
            wz(i5);
        }
        this.f14270f = i;
        this.f14269c5.invalidate();
        oz(i, 32768);
        return true;
    }

    public final boolean oz(int i, int i5) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f14274s.isEnabled() || (parent = this.f14269c5.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f14269c5, p(i, i5));
    }

    public final AccessibilityEvent p(int i, int i5) {
        if (i != -1) {
            return mt(i, i5);
        }
        return co(i5);
    }

    public final boolean qn(int i, Bundle bundle) {
        return i4.rs(this.f14269c5, i, bundle);
    }

    @NonNull
    public final j5.zn r() {
        j5.zn jz2 = j5.zn.jz(this.f14269c5);
        i4.ct(this.f14269c5, jz2);
        ArrayList arrayList = new ArrayList();
        rz(arrayList);
        if (jz2.w() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            jz2.gv(this.f14269c5, ((Integer) arrayList.get(i)).intValue());
        }
        return jz2;
    }

    public abstract void rz(List<Integer> list);

    public final boolean ta(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f14269c5.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f14269c5.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null) {
            return false;
        }
        return true;
    }

    public final void ud(boolean z2, int i, @Nullable Rect rect) {
        int i5 = this.f14275t;
        if (i5 != Integer.MIN_VALUE) {
            xc(i5);
        }
        if (z2) {
            z6(i, rect);
        }
    }

    public final void ut(int i) {
        int i5 = this.f14276tl;
        if (i5 == i) {
            return;
        }
        this.f14276tl = i;
        oz(i, NotificationCompat.FLAG_HIGH_PRIORITY);
        oz(i5, 256);
    }

    public final boolean w() {
        int i = this.f14275t;
        if (i != Integer.MIN_VALUE && a8(i, 16, null)) {
            return true;
        }
        return false;
    }

    public final boolean wz(int i) {
        if (this.f14270f == i) {
            this.f14270f = Integer.MIN_VALUE;
            this.f14269c5.invalidate();
            oz(i, 65536);
            return true;
        }
        return false;
    }

    public final boolean x4(@NonNull MotionEvent motionEvent) {
        if (!this.f14274s.isEnabled() || !this.f14274s.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.f14276tl == Integer.MIN_VALUE) {
                return false;
            }
            ut(Integer.MIN_VALUE);
            return true;
        }
        int fh2 = fh(motionEvent.getX(), motionEvent.getY());
        ut(fh2);
        if (fh2 == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public final boolean xc(int i) {
        if (this.f14275t != i) {
            return false;
        }
        this.f14275t = Integer.MIN_VALUE;
        vl(i, false);
        oz(i, 8);
        return true;
    }

    public abstract void yt(int i, @NonNull j5.zn znVar);

    @NonNull
    public final j5.zn z(int i) {
        boolean z2;
        j5.zn en2 = j5.zn.en();
        en2.rb(true);
        en2.m(true);
        en2.e("android.view.View");
        Rect rect = f14266wz;
        en2.eb(rect);
        en2.lc(rect);
        en2.pq(this.f14269c5);
        yt(i, en2);
        if (en2.fh() == null && en2.z() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        en2.tl(this.f14277v);
        if (!this.f14277v.equals(rect)) {
            int f4 = en2.f();
            if ((f4 & 64) == 0) {
                if ((f4 & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                    en2.tg(this.f14269c5.getContext().getPackageName());
                    en2.qj(this.f14269c5, i);
                    if (this.f14270f == i) {
                        en2.o4(true);
                        en2.y(NotificationCompat.FLAG_HIGH_PRIORITY);
                    } else {
                        en2.o4(false);
                        en2.y(64);
                    }
                    if (this.f14275t == i) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        en2.y(2);
                    } else if (en2.vl()) {
                        en2.y(1);
                    }
                    en2.g(z2);
                    this.f14269c5.getLocationOnScreen(this.f14271fb);
                    en2.wz(this.f14272gv);
                    if (this.f14272gv.equals(rect)) {
                        en2.tl(this.f14272gv);
                        if (en2.f9375n3 != -1) {
                            j5.zn en3 = j5.zn.en();
                            for (int i5 = en2.f9375n3; i5 != -1; i5 = en3.f9375n3) {
                                en3.cr(this.f14269c5, -1);
                                en3.eb(f14266wz);
                                yt(i5, en3);
                                en3.tl(this.f14277v);
                                Rect rect2 = this.f14272gv;
                                Rect rect3 = this.f14277v;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            en3.xg();
                        }
                        this.f14272gv.offset(this.f14271fb[0] - this.f14269c5.getScrollX(), this.f14271fb[1] - this.f14269c5.getScrollY());
                    }
                    if (this.f14269c5.getLocalVisibleRect(this.f14268a)) {
                        this.f14268a.offset(this.f14271fb[0] - this.f14269c5.getScrollX(), this.f14271fb[1] - this.f14269c5.getScrollY());
                        if (this.f14272gv.intersect(this.f14268a)) {
                            en2.lc(this.f14272gv);
                            if (ta(this.f14272gv)) {
                                en2.oa(true);
                            }
                        }
                    }
                    return en2;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    public final boolean z6(int i, @Nullable Rect rect) {
        j5.zn fb2;
        boolean z2;
        j5.zn znVar;
        c5<j5.zn> n2 = n();
        int i5 = this.f14275t;
        int i6 = Integer.MIN_VALUE;
        if (i5 == Integer.MIN_VALUE) {
            fb2 = null;
        } else {
            fb2 = n2.fb(i5);
        }
        j5.zn znVar2 = fb2;
        if (i != 1 && i != 2) {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i8 = this.f14275t;
            if (i8 != Integer.MIN_VALUE) {
                c(i8, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                mg(this.f14269c5, i, rect2);
            }
            znVar = (j5.zn) ut.n3.zn(n2, f14265w, f14267xc, znVar2, rect2, i);
        } else {
            if (i4.ta(this.f14269c5) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            znVar = (j5.zn) ut.n3.gv(n2, f14265w, f14267xc, znVar2, i, z2, false);
        }
        if (znVar != null) {
            i6 = n2.i9(n2.c5(znVar));
        }
        return j(i6);
    }

    public void k5(@NonNull j5.zn znVar) {
    }

    public void x(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void b(int i, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void vl(int i, boolean z2) {
    }
}
