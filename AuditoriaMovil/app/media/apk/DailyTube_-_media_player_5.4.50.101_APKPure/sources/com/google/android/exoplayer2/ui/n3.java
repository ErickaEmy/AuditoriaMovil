package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.v;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import v5.j5;
/* loaded from: classes.dex */
public class n3 extends View implements v {

    /* renamed from: b  reason: collision with root package name */
    public final int f4840b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4841c;

    /* renamed from: co  reason: collision with root package name */
    public final Paint f4842co;

    /* renamed from: ct  reason: collision with root package name */
    public long f4843ct;

    /* renamed from: d  reason: collision with root package name */
    public final int f4844d;

    /* renamed from: d0  reason: collision with root package name */
    public final int f4845d0;

    /* renamed from: dm  reason: collision with root package name */
    public long f4846dm;

    /* renamed from: eb  reason: collision with root package name */
    public int f4847eb;

    /* renamed from: ej  reason: collision with root package name */
    public final int f4848ej;

    /* renamed from: en  reason: collision with root package name */
    public Rect f4849en;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f4850f;

    /* renamed from: f3  reason: collision with root package name */
    public final int f4851f3;

    /* renamed from: f7  reason: collision with root package name */
    public int f4852f7;

    /* renamed from: fb  reason: collision with root package name */
    public final Rect f4853fb;

    /* renamed from: fh  reason: collision with root package name */
    public final int f4854fh;

    /* renamed from: j  reason: collision with root package name */
    public final CopyOnWriteArraySet<v.y> f4855j;

    /* renamed from: j5  reason: collision with root package name */
    public final StringBuilder f4856j5;

    /* renamed from: jz  reason: collision with root package name */
    public ValueAnimator f4857jz;

    /* renamed from: k  reason: collision with root package name */
    public long f4858k;
    @Nullable

    /* renamed from: lc  reason: collision with root package name */
    public long[] f4859lc;

    /* renamed from: n  reason: collision with root package name */
    public final int f4860n;
    @Nullable

    /* renamed from: nf  reason: collision with root package name */
    public boolean[] f4861nf;

    /* renamed from: o  reason: collision with root package name */
    public final Runnable f4862o;

    /* renamed from: o4  reason: collision with root package name */
    public long f4863o4;

    /* renamed from: oz  reason: collision with root package name */
    public final Point f4864oz;

    /* renamed from: p  reason: collision with root package name */
    public final Paint f4865p;

    /* renamed from: q9  reason: collision with root package name */
    public int f4866q9;

    /* renamed from: qn  reason: collision with root package name */
    public final Formatter f4867qn;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public final Drawable f4868r;

    /* renamed from: rs  reason: collision with root package name */
    public long f4869rs;

    /* renamed from: s  reason: collision with root package name */
    public final Rect f4870s;

    /* renamed from: t  reason: collision with root package name */
    public final Paint f4871t;

    /* renamed from: u  reason: collision with root package name */
    public float f4872u;

    /* renamed from: ut  reason: collision with root package name */
    public final float f4873ut;

    /* renamed from: v  reason: collision with root package name */
    public final Rect f4874v;

    /* renamed from: w  reason: collision with root package name */
    public final Paint f4875w;

    /* renamed from: x  reason: collision with root package name */
    public final int f4876x;

    /* renamed from: xg  reason: collision with root package name */
    public boolean f4877xg;
    public final Rect y;

    /* renamed from: y5  reason: collision with root package name */
    public boolean f4878y5;

    /* renamed from: z  reason: collision with root package name */
    public final Paint f4879z;

    public n3(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    private long getPositionIncrement() {
        long j2 = this.f4858k;
        if (j2 == -9223372036854775807L) {
            long j4 = this.f4843ct;
            if (j4 == -9223372036854775807L) {
                return 0L;
            }
            return j4 / this.f4866q9;
        }
        return j2;
    }

    private String getProgressText() {
        return j5.eb(this.f4856j5, this.f4867qn, this.f4863o4);
    }

    private long getScrubberPosition() {
        if (this.f4874v.width() > 0 && this.f4843ct != -9223372036854775807L) {
            return (this.f4870s.width() * this.f4843ct) / this.f4874v.width();
        }
        return 0L;
    }

    public static int t(float f4, int i) {
        return (int) (i / f4);
    }

    public static int v(float f4, int i) {
        return (int) ((i * f4) + 0.5f);
    }

    public static boolean w(Drawable drawable, int i) {
        if (j5.y >= 23 && drawable.setLayoutDirection(i)) {
            return true;
        }
        return false;
    }

    public final void a(Canvas canvas) {
        int i;
        if (this.f4843ct <= 0) {
            return;
        }
        Rect rect = this.f4870s;
        int p2 = j5.p(rect.right, rect.left, this.f4874v.right);
        int centerY = this.f4870s.centerY();
        Drawable drawable = this.f4868r;
        if (drawable == null) {
            if (!this.f4877xg && !isFocused()) {
                if (isEnabled()) {
                    i = this.f4854fh;
                } else {
                    i = this.f4844d;
                }
            } else {
                i = this.f4848ej;
            }
            canvas.drawCircle(p2, centerY, (int) ((i * this.f4872u) / 2.0f), this.f4879z);
            return;
        }
        int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.f4872u)) / 2;
        int intrinsicHeight = ((int) (this.f4868r.getIntrinsicHeight() * this.f4872u)) / 2;
        this.f4868r.setBounds(p2 - intrinsicWidth, centerY - intrinsicHeight, p2 + intrinsicWidth, centerY + intrinsicHeight);
        this.f4868r.draw(canvas);
    }

    public final /* synthetic */ void c5() {
        co(false);
    }

    public final void co(boolean z2) {
        removeCallbacks(this.f4862o);
        this.f4877xg = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<v.y> it = this.f4855j.iterator();
        while (it.hasNext()) {
            it.next().zn(this, this.f4846dm, z2);
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r();
    }

    public final void f(float f4) {
        Rect rect = this.f4870s;
        Rect rect2 = this.f4874v;
        rect.right = j5.p((int) f4, rect2.left, rect2.right);
    }

    public final void fb(Canvas canvas) {
        Paint paint;
        int height = this.f4874v.height();
        int centerY = this.f4874v.centerY() - (height / 2);
        int i = height + centerY;
        if (this.f4843ct <= 0) {
            Rect rect = this.f4874v;
            canvas.drawRect(rect.left, centerY, rect.right, i, this.f4875w);
            return;
        }
        Rect rect2 = this.f4853fb;
        int i5 = rect2.left;
        int i6 = rect2.right;
        int max = Math.max(Math.max(this.f4874v.left, i6), this.f4870s.right);
        int i8 = this.f4874v.right;
        if (max < i8) {
            canvas.drawRect(max, centerY, i8, i, this.f4875w);
        }
        int max2 = Math.max(i5, this.f4870s.right);
        if (i6 > max2) {
            canvas.drawRect(max2, centerY, i6, i, this.f4871t);
        }
        if (this.f4870s.width() > 0) {
            Rect rect3 = this.f4870s;
            canvas.drawRect(rect3.left, centerY, rect3.right, i, this.f4850f);
        }
        if (this.f4847eb == 0) {
            return;
        }
        long[] jArr = (long[]) v5.y.v(this.f4859lc);
        boolean[] zArr = (boolean[]) v5.y.v(this.f4861nf);
        int i10 = this.f4845d0 / 2;
        for (int i11 = 0; i11 < this.f4847eb; i11++) {
            long mt2 = j5.mt(jArr[i11], 0L, this.f4843ct);
            Rect rect4 = this.f4874v;
            int min = rect4.left + Math.min(rect4.width() - this.f4845d0, Math.max(0, ((int) ((this.f4874v.width() * mt2) / this.f4843ct)) - i10));
            if (zArr[i11]) {
                paint = this.f4842co;
            } else {
                paint = this.f4865p;
            }
            canvas.drawRect(min, centerY, min + this.f4845d0, i, paint);
        }
    }

    @Override // com.google.android.exoplayer2.ui.v
    public long getPreferredUpdateDelay() {
        int t2 = t(this.f4873ut, this.f4874v.width());
        if (t2 != 0) {
            long j2 = this.f4843ct;
            if (j2 != 0 && j2 != -9223372036854775807L) {
                return j2 / t2;
            }
        }
        return Long.MAX_VALUE;
    }

    public final /* synthetic */ void i9(ValueAnimator valueAnimator) {
        this.f4872u = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.y);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4868r;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final void mt(long j2) {
        this.f4846dm = j2;
        this.f4877xg = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<v.y> it = this.f4855j.iterator();
        while (it.hasNext()) {
            it.next().fb(this, j2);
        }
    }

    @Override // com.google.android.exoplayer2.ui.v
    public void n3(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        boolean z2;
        if (i != 0 && (jArr == null || zArr == null)) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.y(z2);
        this.f4847eb = i;
        this.f4859lc = jArr;
        this.f4861nf = zArr;
        z();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        fb(canvas);
        a(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z2, int i, @Nullable Rect rect) {
        super.onFocusChanged(z2, i, rect);
        if (this.f4877xg && !z2) {
            co(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.f4843ct <= 0) {
            return;
        }
        if (j5.y >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            return;
        }
        accessibilityNodeInfo.addAction(4096);
        accessibilityNodeInfo.addAction(8192);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.wz(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.f4862o
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f4862o
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.f4877xg
            if (r0 == 0) goto L30
            r5 = 0
            r4.co(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.n3.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int i10;
        int i11;
        int i12;
        int i13 = i6 - i;
        int i14 = i8 - i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i13 - getPaddingRight();
        if (this.f4878y5) {
            i10 = 0;
        } else {
            i10 = this.f4876x;
        }
        if (this.f4841c == 1) {
            i11 = (i14 - getPaddingBottom()) - this.f4860n;
            int i15 = this.f4851f3;
            i12 = ((i14 - getPaddingBottom()) - i15) - Math.max(i10 - (i15 / 2), 0);
        } else {
            i11 = (i14 - this.f4860n) / 2;
            i12 = (i14 - this.f4851f3) / 2;
        }
        this.y.set(paddingLeft, i11, paddingRight, this.f4860n + i11);
        Rect rect = this.f4874v;
        Rect rect2 = this.y;
        rect.set(rect2.left + i10, i12, rect2.right - i10, this.f4851f3 + i12);
        if (j5.y >= 29) {
            p(i13, i14);
        }
        z();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (mode == 0) {
            size = this.f4860n;
        } else if (mode != 1073741824) {
            size = Math.min(this.f4860n, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        r();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.f4868r;
        if (drawable != null && w(drawable, i)) {
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r3 != 3) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L76
            long r2 = r7.f4843ct
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L76
        L10:
            android.graphics.Point r0 = r7.tl(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5d
            r5 = 3
            if (r3 == r4) goto L4e
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4e
            goto L76
        L28:
            boolean r8 = r7.f4877xg
            if (r8 == 0) goto L76
            int r8 = r7.f4840b
            if (r0 >= r8) goto L3a
            int r8 = r7.f4852f7
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.f(r8)
            goto L40
        L3a:
            r7.f4852f7 = r2
            float r8 = (float) r2
            r7.f(r8)
        L40:
            long r0 = r7.getScrubberPosition()
            r7.x4(r0)
            r7.z()
            r7.invalidate()
            return r4
        L4e:
            boolean r0 = r7.f4877xg
            if (r0 == 0) goto L76
            int r8 = r8.getAction()
            if (r8 != r5) goto L59
            r1 = 1
        L59:
            r7.co(r1)
            return r4
        L5d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.s(r8, r0)
            if (r0 == 0) goto L76
            r7.f(r8)
            long r0 = r7.getScrubberPosition()
            r7.mt(r0)
            r7.z()
            r7.invalidate()
            return r4
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.n3.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i, int i5) {
        Rect rect = this.f4849en;
        if (rect != null && rect.width() == i && this.f4849en.height() == i5) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i, i5);
        this.f4849en = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.f4843ct <= 0) {
            return false;
        }
        if (i == 8192) {
            if (wz(-getPositionIncrement())) {
                co(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (wz(getPositionIncrement())) {
                co(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public final void r() {
        Drawable drawable = this.f4868r;
        if (drawable != null && drawable.isStateful() && this.f4868r.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final boolean s(float f4, float f6) {
        return this.y.contains((int) f4, (int) f6);
    }

    public void setAdMarkerColor(int i) {
        this.f4865p.setColor(i);
        invalidate(this.y);
    }

    public void setBufferedColor(int i) {
        this.f4871t.setColor(i);
        invalidate(this.y);
    }

    @Override // com.google.android.exoplayer2.ui.v
    public void setBufferedPosition(long j2) {
        if (this.f4869rs == j2) {
            return;
        }
        this.f4869rs = j2;
        z();
    }

    @Override // com.google.android.exoplayer2.ui.v
    public void setDuration(long j2) {
        if (this.f4843ct == j2) {
            return;
        }
        this.f4843ct = j2;
        if (this.f4877xg && j2 == -9223372036854775807L) {
            co(true);
        }
        z();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.v
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (this.f4877xg && !z2) {
            co(true);
        }
    }

    public void setKeyCountIncrement(int i) {
        boolean z2;
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f4866q9 = i;
        this.f4858k = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j2) {
        boolean z2;
        if (j2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f4866q9 = -1;
        this.f4858k = j2;
    }

    public void setPlayedAdMarkerColor(int i) {
        this.f4842co.setColor(i);
        invalidate(this.y);
    }

    public void setPlayedColor(int i) {
        this.f4850f.setColor(i);
        invalidate(this.y);
    }

    @Override // com.google.android.exoplayer2.ui.v
    public void setPosition(long j2) {
        if (this.f4863o4 == j2) {
            return;
        }
        this.f4863o4 = j2;
        setContentDescription(getProgressText());
        z();
    }

    public void setScrubberColor(int i) {
        this.f4879z.setColor(i);
        invalidate(this.y);
    }

    public void setUnplayedColor(int i) {
        this.f4875w.setColor(i);
        invalidate(this.y);
    }

    public final Point tl(MotionEvent motionEvent) {
        this.f4864oz.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f4864oz;
    }

    public final boolean wz(long j2) {
        long j4;
        long j6 = this.f4843ct;
        if (j6 <= 0) {
            return false;
        }
        if (this.f4877xg) {
            j4 = this.f4846dm;
        } else {
            j4 = this.f4863o4;
        }
        long j7 = j4;
        long mt2 = j5.mt(j7 + j2, 0L, j6);
        if (mt2 == j7) {
            return false;
        }
        if (!this.f4877xg) {
            mt(mt2);
        } else {
            x4(mt2);
        }
        z();
        return true;
    }

    public final void x4(long j2) {
        if (this.f4846dm == j2) {
            return;
        }
        this.f4846dm = j2;
        Iterator<v.y> it = this.f4855j.iterator();
        while (it.hasNext()) {
            it.next().y(this, j2);
        }
    }

    public final boolean xc(Drawable drawable) {
        if (j5.y >= 23 && w(drawable, getLayoutDirection())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.ui.v
    public void y(v.y yVar) {
        v5.y.v(yVar);
        this.f4855j.add(yVar);
    }

    public final void z() {
        long j2;
        this.f4853fb.set(this.f4874v);
        this.f4870s.set(this.f4874v);
        if (this.f4877xg) {
            j2 = this.f4846dm;
        } else {
            j2 = this.f4863o4;
        }
        if (this.f4843ct > 0) {
            int width = (int) ((this.f4874v.width() * this.f4869rs) / this.f4843ct);
            Rect rect = this.f4853fb;
            Rect rect2 = this.f4874v;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((this.f4874v.width() * j2) / this.f4843ct);
            Rect rect3 = this.f4870s;
            Rect rect4 = this.f4874v;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.f4853fb;
            int i = this.f4874v.left;
            rect5.right = i;
            this.f4870s.right = i;
        }
        invalidate(this.y);
    }

    public n3(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2, int i5) {
        super(context, attributeSet, i);
        this.y = new Rect();
        this.f4874v = new Rect();
        this.f4853fb = new Rect();
        this.f4870s = new Rect();
        Paint paint = new Paint();
        this.f4850f = paint;
        Paint paint2 = new Paint();
        this.f4871t = paint2;
        Paint paint3 = new Paint();
        this.f4875w = paint3;
        Paint paint4 = new Paint();
        this.f4865p = paint4;
        Paint paint5 = new Paint();
        this.f4842co = paint5;
        Paint paint6 = new Paint();
        this.f4879z = paint6;
        paint6.setAntiAlias(true);
        this.f4855j = new CopyOnWriteArraySet<>();
        this.f4864oz = new Point();
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f4873ut = f4;
        this.f4840b = v(f4, -50);
        int v2 = v(f4, 4);
        int v3 = v(f4, 26);
        int v4 = v(f4, 4);
        int v6 = v(f4, 12);
        int v7 = v(f4, 0);
        int v8 = v(f4, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.f4794v, i, i5);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f4796w);
                this.f4868r = drawable;
                if (drawable != null) {
                    xc(drawable);
                    v3 = Math.max(drawable.getMinimumHeight(), v3);
                }
                this.f4851f3 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4760c5, v2);
                this.f4860n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4778mt, v3);
                this.f4841c = obtainStyledAttributes.getInt(R$styleable.f4788s, 0);
                this.f4845d0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4767fb, v4);
                this.f4854fh = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4783p, v6);
                this.f4844d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4797wz, v7);
                this.f4848ej = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4800xc, v8);
                int i6 = obtainStyledAttributes.getInt(R$styleable.f4789t, -1);
                int i8 = obtainStyledAttributes.getInt(R$styleable.f4791tl, -1);
                int i10 = obtainStyledAttributes.getInt(R$styleable.f4772i9, -855638017);
                int i11 = obtainStyledAttributes.getInt(R$styleable.f4761co, 872415231);
                int i12 = obtainStyledAttributes.getInt(R$styleable.f4756a, -1291845888);
                int i13 = obtainStyledAttributes.getInt(R$styleable.f4765f, 872414976);
                paint.setColor(i6);
                paint6.setColor(i8);
                paint2.setColor(i10);
                paint3.setColor(i11);
                paint4.setColor(i12);
                paint5.setColor(i13);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.f4851f3 = v2;
            this.f4860n = v3;
            this.f4841c = 0;
            this.f4845d0 = v4;
            this.f4854fh = v6;
            this.f4844d = v7;
            this.f4848ej = v8;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f4868r = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f4856j5 = sb;
        this.f4867qn = new Formatter(sb, Locale.getDefault());
        this.f4862o = new Runnable() { // from class: mn.zn
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.exoplayer2.ui.n3.this.c5();
            }
        };
        Drawable drawable2 = this.f4868r;
        if (drawable2 != null) {
            this.f4876x = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f4876x = (Math.max(this.f4844d, Math.max(this.f4854fh, this.f4848ej)) + 1) / 2;
        }
        this.f4872u = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f4857jz = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mn.gv
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                com.google.android.exoplayer2.ui.n3.this.i9(valueAnimator2);
            }
        });
        this.f4843ct = -9223372036854775807L;
        this.f4858k = -9223372036854775807L;
        this.f4866q9 = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
