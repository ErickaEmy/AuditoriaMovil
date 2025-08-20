package ut;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hw.i4;
import java.util.Arrays;
/* loaded from: classes.dex */
public class zn {

    /* renamed from: f3  reason: collision with root package name */
    public static final Interpolator f14279f3 = new y();

    /* renamed from: a  reason: collision with root package name */
    public float[] f14280a;

    /* renamed from: c5  reason: collision with root package name */
    public int[] f14281c5;

    /* renamed from: co  reason: collision with root package name */
    public final AbstractC0235zn f14282co;

    /* renamed from: f  reason: collision with root package name */
    public int f14283f;

    /* renamed from: fb  reason: collision with root package name */
    public float[] f14284fb;

    /* renamed from: gv  reason: collision with root package name */
    public float[] f14285gv;

    /* renamed from: i9  reason: collision with root package name */
    public int[] f14287i9;

    /* renamed from: mt  reason: collision with root package name */
    public OverScroller f14288mt;

    /* renamed from: n3  reason: collision with root package name */
    public int f14289n3;

    /* renamed from: p  reason: collision with root package name */
    public int f14290p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f14291r;

    /* renamed from: s  reason: collision with root package name */
    public int[] f14292s;

    /* renamed from: t  reason: collision with root package name */
    public VelocityTracker f14293t;

    /* renamed from: tl  reason: collision with root package name */
    public float f14294tl;

    /* renamed from: v  reason: collision with root package name */
    public float[] f14295v;

    /* renamed from: w  reason: collision with root package name */
    public final int f14296w;

    /* renamed from: wz  reason: collision with root package name */
    public float f14297wz;

    /* renamed from: x4  reason: collision with root package name */
    public final ViewGroup f14298x4;

    /* renamed from: xc  reason: collision with root package name */
    public int f14299xc;
    public int y;

    /* renamed from: z  reason: collision with root package name */
    public View f14300z;

    /* renamed from: zn  reason: collision with root package name */
    public int f14301zn = -1;

    /* renamed from: i4  reason: collision with root package name */
    public final Runnable f14286i4 = new n3();

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zn.this.x(0);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f6 = f4 - 1.0f;
            return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    }

    public zn(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull AbstractC0235zn abstractC0235zn) {
        if (viewGroup != null) {
            if (abstractC0235zn != null) {
                this.f14298x4 = viewGroup;
                this.f14282co = abstractC0235zn;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.f14296w = i;
                this.f14299xc = i;
                this.f14289n3 = viewConfiguration.getScaledTouchSlop();
                this.f14294tl = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f14297wz = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f14288mt = new OverScroller(context, f14279f3);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public static zn wz(@NonNull ViewGroup viewGroup, float f4, @NonNull AbstractC0235zn abstractC0235zn) {
        zn xc2 = xc(viewGroup, abstractC0235zn);
        xc2.f14289n3 = (int) (xc2.f14289n3 * (1.0f / f4));
        return xc2;
    }

    public static zn xc(@NonNull ViewGroup viewGroup, @NonNull AbstractC0235zn abstractC0235zn) {
        return new zn(viewGroup.getContext(), viewGroup, abstractC0235zn);
    }

    public final boolean a(View view, float f4, float f6) {
        boolean z2;
        boolean z3;
        if (view == null) {
            return false;
        }
        if (this.f14282co.gv(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f14282co.v(view) > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && z3) {
            int i = this.f14289n3;
            if ((f4 * f4) + (f6 * f6) <= i * i) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f4) <= this.f14289n3) {
                return false;
            }
            return true;
        } else if (!z3 || Math.abs(f6) <= this.f14289n3) {
            return false;
        } else {
            return true;
        }
    }

    public final void a8(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (mg(pointerId)) {
                float x2 = motionEvent.getX(i);
                float y2 = motionEvent.getY(i);
                this.f14280a[pointerId] = x2;
                this.f14284fb[pointerId] = y2;
            }
        }
    }

    public void b(int i) {
        this.f14299xc = i;
    }

    public int c() {
        return this.f14289n3;
    }

    public final void c5() {
        float[] fArr = this.f14285gv;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f14295v, 0.0f);
        Arrays.fill(this.f14280a, 0.0f);
        Arrays.fill(this.f14284fb, 0.0f);
        Arrays.fill(this.f14292s, 0);
        Arrays.fill(this.f14281c5, 0);
        Arrays.fill(this.f14287i9, 0);
        this.f14283f = 0;
    }

    public final void co(int i) {
        float[] fArr = this.f14285gv;
        if (fArr == null || fArr.length <= i) {
            int i5 = i + 1;
            float[] fArr2 = new float[i5];
            float[] fArr3 = new float[i5];
            float[] fArr4 = new float[i5];
            float[] fArr5 = new float[i5];
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f14295v;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f14280a;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f14284fb;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f14292s;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f14281c5;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f14287i9;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f14285gv = fArr2;
            this.f14295v = fArr3;
            this.f14280a = fArr4;
            this.f14284fb = fArr5;
            this.f14292s = iArr;
            this.f14281c5 = iArr2;
            this.f14287i9 = iArr3;
        }
    }

    public void d(@NonNull MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            y();
        }
        if (this.f14293t == null) {
            this.f14293t = VelocityTracker.obtain();
        }
        this.f14293t.addMovement(motionEvent);
        int i5 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                if (this.y == 1 && pointerId == this.f14301zn) {
                                    int pointerCount = motionEvent.getPointerCount();
                                    while (true) {
                                        if (i5 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(i5);
                                            if (pointerId2 != this.f14301zn) {
                                                View z2 = z((int) motionEvent.getX(i5), (int) motionEvent.getY(i5));
                                                View view = this.f14300z;
                                                if (z2 == view && qn(view, pointerId2)) {
                                                    i = this.f14301zn;
                                                    break;
                                                }
                                            }
                                            i5++;
                                        } else {
                                            i = -1;
                                            break;
                                        }
                                    }
                                    if (i == -1) {
                                        z6();
                                    }
                                }
                                i9(pointerId);
                                return;
                            }
                            return;
                        }
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        float x2 = motionEvent.getX(actionIndex);
                        float y2 = motionEvent.getY(actionIndex);
                        ud(x2, y2, pointerId3);
                        if (this.y == 0) {
                            qn(z((int) x2, (int) y2), pointerId3);
                            int i6 = this.f14292s[pointerId3];
                            int i8 = this.f14290p;
                            if ((i6 & i8) != 0) {
                                this.f14282co.s(i6 & i8, pointerId3);
                                return;
                            }
                            return;
                        } else if (fh((int) x2, (int) y2)) {
                            qn(this.f14300z, pointerId3);
                            return;
                        } else {
                            return;
                        }
                    }
                    if (this.y == 1) {
                        w(0.0f, 0.0f);
                    }
                    y();
                    return;
                } else if (this.y == 1) {
                    if (mg(this.f14301zn)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f14301zn);
                        float x3 = motionEvent.getX(findPointerIndex);
                        float y7 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f14280a;
                        int i10 = this.f14301zn;
                        int i11 = (int) (x3 - fArr[i10]);
                        int i12 = (int) (y7 - this.f14284fb[i10]);
                        mt(this.f14300z.getLeft() + i11, this.f14300z.getTop() + i12, i11, i12);
                        a8(motionEvent);
                        return;
                    }
                    return;
                } else {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (i5 < pointerCount2) {
                        int pointerId4 = motionEvent.getPointerId(i5);
                        if (mg(pointerId4)) {
                            float x6 = motionEvent.getX(i5);
                            float y8 = motionEvent.getY(i5);
                            float f4 = x6 - this.f14285gv[pointerId4];
                            float f6 = y8 - this.f14295v[pointerId4];
                            ej(f4, f6, pointerId4);
                            if (this.y != 1) {
                                View z3 = z((int) x6, (int) y8);
                                if (a(z3, f4, f6) && qn(z3, pointerId4)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i5++;
                    }
                    a8(motionEvent);
                    return;
                }
            }
            if (this.y == 1) {
                z6();
            }
            y();
            return;
        }
        float x7 = motionEvent.getX();
        float y9 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View z4 = z((int) x7, (int) y9);
        ud(x7, y9, pointerId5);
        qn(z4, pointerId5);
        int i13 = this.f14292s[pointerId5];
        int i14 = this.f14290p;
        if ((i13 & i14) != 0) {
            this.f14282co.s(i13 & i14, pointerId5);
        }
    }

    public int d0() {
        return this.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [ut.zn$zn] */
    public final void ej(float f4, float f6, int i) {
        boolean zn2 = zn(f4, f6, i, 1);
        boolean z2 = zn2;
        if (zn(f6, f4, i, 4)) {
            z2 = zn2 | true;
        }
        boolean z3 = z2;
        if (zn(f4, f6, i, 2)) {
            z3 = (z2 ? 1 : 0) | true;
        }
        ?? r0 = z3;
        if (zn(f6, f4, i, 8)) {
            r0 = (z3 ? 1 : 0) | true;
        }
        if (r0 != 0) {
            int[] iArr = this.f14281c5;
            iArr[i] = iArr[i] | r0;
            this.f14282co.a(r0, i);
        }
    }

    public final int f(int i, int i5, int i6) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.f14298x4.getWidth();
        float f4 = width / 2;
        float p2 = f4 + (p(Math.min(1.0f, Math.abs(i) / width)) * f4);
        int abs2 = Math.abs(i5);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(p2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i6) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    public int f3() {
        return this.f14299xc;
    }

    public final float fb(float f4, float f6, float f9) {
        float abs = Math.abs(f4);
        if (abs < f6) {
            return 0.0f;
        }
        if (abs > f9) {
            if (f4 <= 0.0f) {
                return -f9;
            }
            return f9;
        }
        return f4;
    }

    public boolean fh(int i, int i5) {
        return ta(this.f14300z, i, i5);
    }

    public boolean gv(int i) {
        int length = this.f14285gv.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (v(i, i5)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean hw(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ut.zn.hw(android.view.MotionEvent):boolean");
    }

    public int i4() {
        return this.f14296w;
    }

    public final void i9(int i) {
        if (this.f14285gv != null && rz(i)) {
            this.f14285gv[i] = 0.0f;
            this.f14295v[i] = 0.0f;
            this.f14280a[i] = 0.0f;
            this.f14284fb[i] = 0.0f;
            this.f14292s[i] = 0;
            this.f14281c5[i] = 0;
            this.f14287i9[i] = 0;
            this.f14283f = (~(1 << i)) & this.f14283f;
        }
    }

    public boolean j5(@NonNull View view, int i, int i5) {
        this.f14300z = view;
        this.f14301zn = -1;
        boolean r2 = r(i, i5, 0, 0);
        if (!r2 && this.y == 0 && this.f14300z != null) {
            this.f14300z = null;
        }
        return r2;
    }

    public void k5(int i) {
        this.f14290p = i;
    }

    public final boolean mg(int i) {
        if (!rz(i)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }

    public final void mt(int i, int i5, int i6, int i8) {
        int left = this.f14300z.getLeft();
        int top = this.f14300z.getTop();
        if (i6 != 0) {
            i = this.f14282co.y(this.f14300z, i, i6);
            i4.y5(this.f14300z, i - left);
        }
        int i10 = i;
        if (i8 != 0) {
            i5 = this.f14282co.n3(this.f14300z, i5, i8);
            i4.xg(this.f14300z, i5 - top);
        }
        int i11 = i5;
        if (i6 != 0 || i8 != 0) {
            this.f14282co.f(this.f14300z, i10, i11, i10 - left, i11 - top);
        }
    }

    public final int n(int i, int i5) {
        int i6;
        if (i < this.f14298x4.getLeft() + this.f14299xc) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (i5 < this.f14298x4.getTop() + this.f14299xc) {
            i6 |= 4;
        }
        if (i > this.f14298x4.getRight() - this.f14299xc) {
            i6 |= 2;
        }
        if (i5 > this.f14298x4.getBottom() - this.f14299xc) {
            return i6 | 8;
        }
        return i6;
    }

    public void n3(@NonNull View view, int i) {
        if (view.getParent() == this.f14298x4) {
            this.f14300z = view;
            this.f14301zn = i;
            this.f14282co.c5(view, i);
            x(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f14298x4 + ")");
    }

    public final float p(float f4) {
        return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
    }

    public boolean qn(View view, int i) {
        if (view == this.f14300z && this.f14301zn == i) {
            return true;
        }
        if (view != null && this.f14282co.tl(view, i)) {
            this.f14301zn = i;
            n3(view, i);
            return true;
        }
        return false;
    }

    public final boolean r(int i, int i5, int i6, int i8) {
        int left = this.f14300z.getLeft();
        int top = this.f14300z.getTop();
        int i10 = i - left;
        int i11 = i5 - top;
        if (i10 == 0 && i11 == 0) {
            this.f14288mt.abortAnimation();
            x(0);
            return false;
        }
        this.f14288mt.startScroll(left, top, i10, i11, t(this.f14300z, i10, i11, i6, i8));
        x(2);
        return true;
    }

    public boolean rz(int i) {
        if (((1 << i) & this.f14283f) != 0) {
            return true;
        }
        return false;
    }

    public final int s(int i, int i5, int i6) {
        int abs = Math.abs(i);
        if (abs < i5) {
            return 0;
        }
        if (abs > i6) {
            if (i <= 0) {
                return -i6;
            }
            return i6;
        }
        return i;
    }

    public final int t(View view, int i, int i5, int i6, int i8) {
        float f4;
        float f6;
        float f9;
        float f10;
        int s2 = s(i6, (int) this.f14297wz, (int) this.f14294tl);
        int s3 = s(i8, (int) this.f14297wz, (int) this.f14294tl);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i5);
        int abs3 = Math.abs(s2);
        int abs4 = Math.abs(s3);
        int i10 = abs3 + abs4;
        int i11 = abs + abs2;
        if (s2 != 0) {
            f4 = abs3;
            f6 = i10;
        } else {
            f4 = abs;
            f6 = i11;
        }
        float f11 = f4 / f6;
        if (s3 != 0) {
            f9 = abs4;
            f10 = i10;
        } else {
            f9 = abs2;
            f10 = i11;
        }
        return (int) ((f(i, s2, this.f14282co.gv(view)) * f11) + (f(i5, s3, this.f14282co.v(view)) * (f9 / f10)));
    }

    public boolean ta(@Nullable View view, int i, int i5) {
        if (view == null || i < view.getLeft() || i >= view.getRight() || i5 < view.getTop() || i5 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    public boolean tl(boolean z2) {
        if (this.y == 2) {
            boolean computeScrollOffset = this.f14288mt.computeScrollOffset();
            int currX = this.f14288mt.getCurrX();
            int currY = this.f14288mt.getCurrY();
            int left = currX - this.f14300z.getLeft();
            int top = currY - this.f14300z.getTop();
            if (left != 0) {
                i4.y5(this.f14300z, left);
            }
            if (top != 0) {
                i4.xg(this.f14300z, top);
            }
            if (left != 0 || top != 0) {
                this.f14282co.f(this.f14300z, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f14288mt.getFinalX() && currY == this.f14288mt.getFinalY()) {
                this.f14288mt.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z2) {
                    this.f14298x4.post(this.f14286i4);
                } else {
                    x(0);
                }
            }
        }
        if (this.y != 2) {
            return false;
        }
        return true;
    }

    public final void ud(float f4, float f6, int i) {
        co(i);
        float[] fArr = this.f14285gv;
        this.f14280a[i] = f4;
        fArr[i] = f4;
        float[] fArr2 = this.f14295v;
        this.f14284fb[i] = f6;
        fArr2[i] = f6;
        this.f14292s[i] = n((int) f4, (int) f6);
        this.f14283f |= 1 << i;
    }

    public boolean v(int i, int i5) {
        boolean z2;
        boolean z3;
        if (!rz(i5)) {
            return false;
        }
        if ((i & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((i & 2) == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        float f4 = this.f14280a[i5] - this.f14285gv[i5];
        float f6 = this.f14284fb[i5] - this.f14295v[i5];
        if (z2 && z3) {
            int i6 = this.f14289n3;
            if ((f4 * f4) + (f6 * f6) <= i6 * i6) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f4) <= this.f14289n3) {
                return false;
            }
            return true;
        } else if (!z3 || Math.abs(f6) <= this.f14289n3) {
            return false;
        } else {
            return true;
        }
    }

    public boolean vl(int i, int i5) {
        if (this.f14291r) {
            return r(i, i5, (int) this.f14293t.getXVelocity(this.f14301zn), (int) this.f14293t.getYVelocity(this.f14301zn));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public final void w(float f4, float f6) {
        this.f14291r = true;
        this.f14282co.t(this.f14300z, f4, f6);
        this.f14291r = false;
        if (this.y == 1) {
            x(0);
        }
    }

    public void x(int i) {
        this.f14298x4.removeCallbacks(this.f14286i4);
        if (this.y != i) {
            this.y = i;
            this.f14282co.i9(i);
            if (this.y == 0) {
                this.f14300z = null;
            }
        }
    }

    @Nullable
    public View x4() {
        return this.f14300z;
    }

    public void y() {
        this.f14301zn = -1;
        c5();
        VelocityTracker velocityTracker = this.f14293t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f14293t = null;
        }
    }

    public void yt(float f4) {
        this.f14297wz = f4;
    }

    @Nullable
    public View z(int i, int i5) {
        for (int childCount = this.f14298x4.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f14298x4.getChildAt(this.f14282co.zn(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final void z6() {
        this.f14293t.computeCurrentVelocity(1000, this.f14294tl);
        w(fb(this.f14293t.getXVelocity(this.f14301zn), this.f14297wz, this.f14294tl), fb(this.f14293t.getYVelocity(this.f14301zn), this.f14297wz, this.f14294tl));
    }

    public final boolean zn(float f4, float f6, int i, int i5) {
        float abs = Math.abs(f4);
        float abs2 = Math.abs(f6);
        if ((this.f14292s[i] & i5) != i5 || (this.f14290p & i5) == 0 || (this.f14287i9[i] & i5) == i5 || (this.f14281c5[i] & i5) == i5) {
            return false;
        }
        int i6 = this.f14289n3;
        if (abs <= i6 && abs2 <= i6) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f14282co.fb(i5)) {
            int[] iArr = this.f14287i9;
            iArr[i] = iArr[i] | i5;
            return false;
        } else if ((this.f14281c5[i] & i5) != 0 || abs <= this.f14289n3) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: ut.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0235zn {
        public abstract void f(@NonNull View view, int i, int i5, int i6, int i8);

        public boolean fb(int i) {
            return false;
        }

        public int gv(@NonNull View view) {
            return 0;
        }

        public abstract void i9(int i);

        public abstract int n3(@NonNull View view, int i, int i5);

        public abstract void t(@NonNull View view, float f4, float f6);

        public abstract boolean tl(@NonNull View view, int i);

        public int v(@NonNull View view) {
            return 0;
        }

        public abstract int y(@NonNull View view, int i, int i5);

        public int zn(int i) {
            return i;
        }

        public void a(int i, int i5) {
        }

        public void c5(@NonNull View view, int i) {
        }

        public void s(int i, int i5) {
        }
    }
}
