package u4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import hw.i4;
/* loaded from: classes.dex */
public abstract class y<V extends View> extends zn<V> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14040a;

    /* renamed from: c5  reason: collision with root package name */
    public int f14041c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f14042fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public Runnable f14043gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public VelocityTracker f14044i9;

    /* renamed from: s  reason: collision with root package name */
    public int f14045s;

    /* renamed from: v  reason: collision with root package name */
    public OverScroller f14046v;

    /* renamed from: u4.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0226y implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final V f14048v;
        public final CoordinatorLayout y;

        public RunnableC0226y(CoordinatorLayout coordinatorLayout, V v2) {
            this.y = coordinatorLayout;
            this.f14048v = v2;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f14048v != null && (overScroller = y.this.f14046v) != null) {
                if (overScroller.computeScrollOffset()) {
                    y yVar = y.this;
                    yVar.hw(this.y, this.f14048v, yVar.f14046v.getCurrY());
                    i4.nf(this.f14048v, this);
                    return;
                }
                y.this.yt(this.y, this.f14048v);
            }
        }
    }

    public y() {
        this.f14042fb = -1;
        this.f14041c5 = -1;
    }

    public final boolean a8(CoordinatorLayout coordinatorLayout, @NonNull V v2, int i, int i5, float f4) {
        Runnable runnable = this.f14043gv;
        if (runnable != null) {
            v2.removeCallbacks(runnable);
            this.f14043gv = null;
        }
        if (this.f14046v == null) {
            this.f14046v = new OverScroller(v2.getContext());
        }
        this.f14046v.fling(0, ta(), 0, Math.round(f4), 0, 0, i, i5);
        if (this.f14046v.computeScrollOffset()) {
            RunnableC0226y runnableC0226y = new RunnableC0226y(coordinatorLayout, v2);
            this.f14043gv = runnableC0226y;
            i4.nf(v2, runnableC0226y);
            return true;
        }
        yt(coordinatorLayout, v2);
        return false;
    }

    public int b(@NonNull V v2) {
        return v2.getHeight();
    }

    public boolean ej(V v2) {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        boolean z2;
        int findPointerIndex;
        if (this.f14041c5 < 0) {
            this.f14041c5 = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f14040a) {
            int i = this.f14042fb;
            if (i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f14045s) > this.f14041c5) {
                this.f14045s = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f14042fb = -1;
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (ej(v2) && coordinatorLayout.fh(v2, x2, y2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f14040a = z2;
            if (z2) {
                this.f14045s = y2;
                this.f14042fb = motionEvent.getPointerId(0);
                ud();
                OverScroller overScroller = this.f14046v;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f14046v.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f14044i9;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public int hw(CoordinatorLayout coordinatorLayout, V v2, int i) {
        return j5(coordinatorLayout, v2, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int j5(CoordinatorLayout coordinatorLayout, V v2, int i, int i5, int i6) {
        int n32;
        int ta2 = ta();
        if (i5 != 0 && ta2 >= i5 && ta2 <= i6 && ta2 != (n32 = a8.y.n3(i, i5, i6))) {
            z6(n32);
            return ta2 - n32;
        }
        return 0;
    }

    public int k5() {
        return ta();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mg(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f14042fb = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f14045s = r12
            goto L4c
        L2d:
            int r0 = r11.f14042fb
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f14045s
            int r7 = r1 - r0
            r11.f14045s = r0
            int r8 = r11.x(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.vl(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f14044i9
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f14044i9
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f14044i9
            int r4 = r11.f14042fb
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.b(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a8(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f14040a = r3
            r11.f14042fb = r1
            android.view.VelocityTracker r13 = r11.f14044i9
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f14044i9 = r13
        L81:
            android.view.VelocityTracker r13 = r11.f14044i9
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f14040a
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.y.mg(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public final void ud() {
        if (this.f14044i9 == null) {
            this.f14044i9 = VelocityTracker.obtain();
        }
    }

    public final int vl(CoordinatorLayout coordinatorLayout, V v2, int i, int i5, int i6) {
        return j5(coordinatorLayout, v2, k5() - i, i5, i6);
    }

    public int x(@NonNull V v2) {
        return -v2.getHeight();
    }

    public y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14042fb = -1;
        this.f14041c5 = -1;
    }

    public void yt(CoordinatorLayout coordinatorLayout, V v2) {
    }
}
