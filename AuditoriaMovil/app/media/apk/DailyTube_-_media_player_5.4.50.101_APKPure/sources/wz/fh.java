package wz;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
/* loaded from: classes.dex */
public abstract class fh implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: co  reason: collision with root package name */
    public final int[] f14713co = new int[2];

    /* renamed from: f  reason: collision with root package name */
    public Runnable f14714f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f14715fb;

    /* renamed from: p  reason: collision with root package name */
    public int f14716p;

    /* renamed from: s  reason: collision with root package name */
    public final View f14717s;

    /* renamed from: t  reason: collision with root package name */
    public Runnable f14718t;

    /* renamed from: v  reason: collision with root package name */
    public final int f14719v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f14720w;
    public final float y;

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fh.this.v();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = fh.this.f14717s.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public fh(View view) {
        this.f14717s = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.y = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f14719v = tapTimeout;
        this.f14715fb = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean s(View view, float f4, float f6, float f9) {
        float f10 = -f9;
        if (f4 >= f10 && f6 >= f10 && f4 < (view.getRight() - view.getLeft()) + f9 && f6 < (view.getBottom() - view.getTop()) + f9) {
            return true;
        }
        return false;
    }

    public final boolean a(MotionEvent motionEvent) {
        c cVar;
        boolean z2;
        View view = this.f14717s;
        tl.a n32 = n3();
        if (n32 == null || !n32.y() || (cVar = (c) n32.xc()) == null || !cVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        c5(view, obtainNoHistory);
        i9(cVar, obtainNoHistory);
        boolean v2 = cVar.v(obtainNoHistory, this.f14716p);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!v2 || !z2) {
            return false;
        }
        return true;
    }

    public final boolean c5(View view, MotionEvent motionEvent) {
        int[] iArr = this.f14713co;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean fb(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f14717s
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f14716p
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.y
            boolean r6 = s(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.y()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.y()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f14716p = r6
            java.lang.Runnable r6 = r5.f14714f
            if (r6 != 0) goto L52
            wz.fh$y r6 = new wz.fh$y
            r6.<init>()
            r5.f14714f = r6
        L52:
            java.lang.Runnable r6 = r5.f14714f
            int r1 = r5.f14719v
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f14718t
            if (r6 != 0) goto L65
            wz.fh$n3 r6 = new wz.fh$n3
            r6.<init>()
            r5.f14718t = r6
        L65:
            java.lang.Runnable r6 = r5.f14718t
            int r1 = r5.f14715fb
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: wz.fh.fb(android.view.MotionEvent):boolean");
    }

    public boolean gv() {
        tl.a n32 = n3();
        if (n32 != null && n32.y()) {
            n32.dismiss();
            return true;
        }
        return true;
    }

    public final boolean i9(View view, MotionEvent motionEvent) {
        int[] iArr = this.f14713co;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract tl.a n3();

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = this.f14720w;
        if (z3) {
            if (!a(motionEvent) && gv()) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            if (fb(motionEvent) && zn()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f14717s.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f14720w = z2;
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f14720w = false;
        this.f14716p = -1;
        Runnable runnable = this.f14714f;
        if (runnable != null) {
            this.f14717s.removeCallbacks(runnable);
        }
    }

    public void v() {
        y();
        View view = this.f14717s;
        if (!view.isEnabled() || view.isLongClickable() || !zn()) {
            return;
        }
        view.getParent().requestDisallowInterceptTouchEvent(true);
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        view.onTouchEvent(obtain);
        obtain.recycle();
        this.f14720w = true;
    }

    public final void y() {
        Runnable runnable = this.f14718t;
        if (runnable != null) {
            this.f14717s.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f14714f;
        if (runnable2 != null) {
            this.f14717s.removeCallbacks(runnable2);
        }
    }

    public abstract boolean zn();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
