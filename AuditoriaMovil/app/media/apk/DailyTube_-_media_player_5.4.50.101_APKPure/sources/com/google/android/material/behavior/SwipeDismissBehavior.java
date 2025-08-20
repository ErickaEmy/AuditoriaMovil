package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import hw.i4;
import j5.a;
import j5.zn;
import ut.zn;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.zn<V> {

    /* renamed from: gv  reason: collision with root package name */
    public float f5403gv;

    /* renamed from: n3  reason: collision with root package name */
    public zn f5405n3;

    /* renamed from: s  reason: collision with root package name */
    public float f5406s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f5407v;
    public ut.zn y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f5408zn;

    /* renamed from: a  reason: collision with root package name */
    public int f5400a = 2;

    /* renamed from: fb  reason: collision with root package name */
    public float f5402fb = 0.5f;

    /* renamed from: c5  reason: collision with root package name */
    public float f5401c5 = 0.5f;

    /* renamed from: i9  reason: collision with root package name */
    public final zn.AbstractC0235zn f5404i9 = new y();

    /* loaded from: classes.dex */
    public class gv implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final boolean f5410v;
        public final View y;

        public gv(View view, boolean z2) {
            this.y = view;
            this.f5410v = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            zn znVar;
            ut.zn znVar2 = SwipeDismissBehavior.this.y;
            if (znVar2 != null && znVar2.tl(true)) {
                i4.nf(this.y, this);
            } else if (this.f5410v && (znVar = SwipeDismissBehavior.this.f5405n3) != null) {
                znVar.y(this.y);
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements a {
        public n3() {
        }

        @Override // j5.a
        public boolean y(@NonNull View view, @Nullable a.y yVar) {
            int width;
            boolean z2 = false;
            if (!SwipeDismissBehavior.this.ta(view)) {
                return false;
            }
            if (i4.ta(view) == 1) {
                z2 = true;
            }
            int i = SwipeDismissBehavior.this.f5400a;
            if ((i == 0 && z2) || (i == 1 && !z2)) {
                width = -view.getWidth();
            } else {
                width = view.getWidth();
            }
            i4.y5(view, width);
            view.setAlpha(0.0f);
            zn znVar = SwipeDismissBehavior.this.f5405n3;
            if (znVar != null) {
                znVar.y(view);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class y extends zn.AbstractC0235zn {

        /* renamed from: n3  reason: collision with root package name */
        public int f5411n3 = -1;
        public int y;

        public y() {
        }

        @Override // ut.zn.AbstractC0235zn
        public void c5(@NonNull View view, int i) {
            this.f5411n3 = i;
            this.y = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // ut.zn.AbstractC0235zn
        public void f(@NonNull View view, int i, int i5, int i6, int i8) {
            float width = this.y + (view.getWidth() * SwipeDismissBehavior.this.f5406s);
            float width2 = this.y + (view.getWidth() * SwipeDismissBehavior.this.f5401c5);
            float f4 = i;
            if (f4 <= width) {
                view.setAlpha(1.0f);
            } else if (f4 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.d(0.0f, 1.0f - SwipeDismissBehavior.ud(width, width2, f4), 1.0f));
            }
        }

        @Override // ut.zn.AbstractC0235zn
        public int gv(@NonNull View view) {
            return view.getWidth();
        }

        @Override // ut.zn.AbstractC0235zn
        public void i9(int i) {
            zn znVar = SwipeDismissBehavior.this.f5405n3;
            if (znVar != null) {
                znVar.n3(i);
            }
        }

        @Override // ut.zn.AbstractC0235zn
        public int n3(@NonNull View view, int i, int i5) {
            return view.getTop();
        }

        @Override // ut.zn.AbstractC0235zn
        public void t(@NonNull View view, float f4, float f6) {
            int i;
            boolean z2;
            zn znVar;
            this.f5411n3 = -1;
            int width = view.getWidth();
            if (wz(view, f4)) {
                int left = view.getLeft();
                int i5 = this.y;
                if (left < i5) {
                    i = i5 - width;
                } else {
                    i = i5 + width;
                }
                z2 = true;
            } else {
                i = this.y;
                z2 = false;
            }
            if (SwipeDismissBehavior.this.y.vl(i, view.getTop())) {
                i4.nf(view, new gv(view, z2));
            } else if (z2 && (znVar = SwipeDismissBehavior.this.f5405n3) != null) {
                znVar.y(view);
            }
        }

        @Override // ut.zn.AbstractC0235zn
        public boolean tl(View view, int i) {
            int i5 = this.f5411n3;
            if ((i5 == -1 || i5 == i) && SwipeDismissBehavior.this.ta(view)) {
                return true;
            }
            return false;
        }

        public final boolean wz(@NonNull View view, float f4) {
            boolean z2;
            int i = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
            if (i != 0) {
                if (i4.ta(view) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i5 = SwipeDismissBehavior.this.f5400a;
                if (i5 == 2) {
                    return true;
                }
                if (i5 == 0) {
                    if (z2) {
                        if (f4 >= 0.0f) {
                            return false;
                        }
                    } else if (i <= 0) {
                        return false;
                    }
                    return true;
                } else if (i5 != 1) {
                    return false;
                } else {
                    if (z2) {
                        if (i <= 0) {
                            return false;
                        }
                    } else if (f4 >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            }
            int left = view.getLeft() - this.y;
            if (Math.abs(left) < Math.round(view.getWidth() * SwipeDismissBehavior.this.f5402fb)) {
                return false;
            }
            return true;
        }

        @Override // ut.zn.AbstractC0235zn
        public int y(@NonNull View view, int i, int i5) {
            boolean z2;
            int width;
            int width2;
            int width3;
            if (i4.ta(view) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i6 = SwipeDismissBehavior.this.f5400a;
            if (i6 == 0) {
                if (z2) {
                    width = this.y - view.getWidth();
                    width2 = this.y;
                } else {
                    width = this.y;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i6 == 1) {
                if (z2) {
                    width = this.y;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width = this.y - view.getWidth();
                    width2 = this.y;
                }
            } else {
                width = this.y - view.getWidth();
                width2 = view.getWidth() + this.y;
            }
            return SwipeDismissBehavior.z6(width, i, width2);
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void n3(int i);

        void y(View view);
    }

    public static float d(float f4, float f6, float f9) {
        return Math.min(Math.max(f4, f6), f9);
    }

    public static float ud(float f4, float f6, float f9) {
        return (f9 - f4) / (f6 - f4);
    }

    public static int z6(int i, int i5, int i6) {
        return Math.min(Math.max(i, i5), i6);
    }

    public void a8(float f4) {
        this.f5401c5 = d(0.0f, f4, 1.0f);
    }

    public void b(float f4) {
        this.f5406s = d(0.0f, f4, 1.0f);
    }

    public final void ej(ViewGroup viewGroup) {
        ut.zn xc2;
        if (this.y == null) {
            if (this.f5407v) {
                xc2 = ut.zn.wz(viewGroup, this.f5403gv, this.f5404i9);
            } else {
                xc2 = ut.zn.xc(viewGroup, this.f5404i9);
            }
            this.y = xc2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        boolean z2 = this.f5408zn;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f5408zn = false;
            }
        } else {
            z2 = coordinatorLayout.fh(v2, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f5408zn = z2;
        }
        if (!z2) {
            return false;
        }
        ej(coordinatorLayout);
        return this.y.hw(motionEvent);
    }

    public void k5(int i) {
        this.f5400a = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean mg(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        ut.zn znVar = this.y;
        if (znVar != null) {
            znVar.d(motionEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i) {
        boolean t2 = super.t(coordinatorLayout, v2, i);
        if (i4.rz(v2) == 0) {
            i4.o0(v2, 1);
            yt(v2);
        }
        return t2;
    }

    public boolean ta(@NonNull View view) {
        return true;
    }

    public void x(@Nullable zn znVar) {
        this.f5405n3 = znVar;
    }

    public final void yt(View view) {
        i4.e(view, 1048576);
        if (ta(view)) {
            i4.ap(view, zn.y.f9398n, null, new n3());
        }
    }
}
