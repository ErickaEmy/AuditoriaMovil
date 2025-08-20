package wz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class c extends ListView {

    /* renamed from: c  reason: collision with root package name */
    public n3 f14683c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f14684co;

    /* renamed from: f  reason: collision with root package name */
    public int f14685f;

    /* renamed from: f3  reason: collision with root package name */
    public hw.mg f14686f3;

    /* renamed from: fb  reason: collision with root package name */
    public int f14687fb;

    /* renamed from: n  reason: collision with root package name */
    public j.i9 f14688n;

    /* renamed from: p  reason: collision with root package name */
    public y f14689p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f14690r;

    /* renamed from: s  reason: collision with root package name */
    public int f14691s;

    /* renamed from: t  reason: collision with root package name */
    public int f14692t;

    /* renamed from: v  reason: collision with root package name */
    public int f14693v;

    /* renamed from: w  reason: collision with root package name */
    public Field f14694w;
    public final Rect y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f14695z;

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        public void n3() {
            c.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f14683c = null;
            cVar.drawableStateChanged();
        }

        public void y() {
            c cVar = c.this;
            cVar.f14683c = null;
            cVar.removeCallbacks(this);
        }
    }

    /* loaded from: classes.dex */
    public static class y extends i9.zn {

        /* renamed from: v  reason: collision with root package name */
        public boolean f14696v;

        public y(Drawable drawable) {
            super(drawable);
            this.f14696v = true;
        }

        @Override // i9.zn, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f14696v) {
                super.draw(canvas);
            }
        }

        @Override // i9.zn, android.graphics.drawable.Drawable
        public void setHotspot(float f4, float f6) {
            if (this.f14696v) {
                super.setHotspot(f4, f6);
            }
        }

        @Override // i9.zn, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i5, int i6, int i8) {
            if (this.f14696v) {
                super.setHotspotBounds(i, i5, i6, i8);
            }
        }

        @Override // i9.zn, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f14696v) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // i9.zn, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z2, boolean z3) {
            if (this.f14696v) {
                return super.setVisible(z2, z3);
            }
            return false;
        }

        public void zn(boolean z2) {
            this.f14696v = z2;
        }
    }

    public c(@NonNull Context context, boolean z2) {
        super(context, null, R$attr.f628c);
        this.y = new Rect();
        this.f14693v = 0;
        this.f14687fb = 0;
        this.f14691s = 0;
        this.f14685f = 0;
        this.f14695z = z2;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f14694w = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z2) {
        y yVar = this.f14689p;
        if (yVar != null) {
            yVar.zn(z2);
        }
    }

    public final void a(int i, View view) {
        Rect rect = this.y;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f14693v;
        rect.top -= this.f14687fb;
        rect.right += this.f14691s;
        rect.bottom += this.f14685f;
        try {
            boolean z2 = this.f14694w.getBoolean(this);
            if (view.isEnabled() != z2) {
                this.f14694w.set(this, Boolean.valueOf(!z2));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public final void c5(View view, int i, float f4, float f6) {
        View childAt;
        this.f14690r = true;
        drawableHotspotChanged(f4, f6);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i5 = this.f14692t;
        if (i5 != -1 && (childAt = getChildAt(i5 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f14692t = i;
        view.drawableHotspotChanged(f4 - view.getLeft(), f6 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        s(i, view, f4, f6);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        zn(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f14683c != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        f();
    }

    public final void f() {
        Drawable selector = getSelector();
        if (selector != null && i9() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public final void fb(int i, View view) {
        boolean z2;
        Drawable selector = getSelector();
        boolean z3 = true;
        if (selector != null && i != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            selector.setVisible(false, false);
        }
        a(i, view);
        if (z2) {
            Rect rect = this.y;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z3 = false;
            }
            selector.setVisible(z3, false);
            ej.y.f(selector, exactCenterX, exactCenterY);
        }
    }

    public int gv(int i, int i5, int i6, int i8, int i10) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i11 = listPaddingTop + listPaddingBottom;
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        View view = null;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < count; i14++) {
            int itemViewType = adapter.getItemViewType(i14);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            view = adapter.getView(i14, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i15 = layoutParams.height;
            if (i15 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, makeMeasureSpec);
            view.forceLayout();
            if (i14 > 0) {
                i11 += dividerHeight;
            }
            i11 += view.getMeasuredHeight();
            if (i11 >= i8) {
                if (i10 >= 0 && i14 > i10 && i13 > 0 && i11 != i8) {
                    return i13;
                }
                return i8;
            }
            if (i10 >= 0 && i14 >= i10) {
                i13 = i11;
            }
        }
        return i11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (!this.f14695z && !super.hasFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (!this.f14695z && !super.hasWindowFocus()) {
            return false;
        }
        return true;
    }

    public final boolean i9() {
        return this.f14690r;
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (!this.f14695z && !super.isFocused()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if ((this.f14695z && this.f14684co) || super.isInTouchMode()) {
            return true;
        }
        return false;
    }

    public final void n3(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f14683c = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f14683c == null) {
            n3 n3Var = new n3();
            this.f14683c = n3Var;
            n3Var.n3();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                f();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f14692t = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        n3 n3Var = this.f14683c;
        if (n3Var != null) {
            n3Var.y();
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void s(int i, View view, float f4, float f6) {
        fb(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            ej.y.f(selector, f4, f6);
        }
    }

    public void setListSelectionHidden(boolean z2) {
        this.f14684co = z2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        y yVar;
        if (drawable != null) {
            yVar = new y(drawable);
        } else {
            yVar = null;
        }
        this.f14689p = yVar;
        super.setSelector(yVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f14693v = rect.left;
        this.f14687fb = rect.top;
        this.f14691s = rect.right;
        this.f14685f = rect.bottom;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r0 != 3) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean v(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.c5(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.n3(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.y()
        L4d:
            if (r3 == 0) goto L65
            j.i9 r9 = r7.f14688n
            if (r9 != 0) goto L5a
            j.i9 r9 = new j.i9
            r9.<init>(r7)
            r7.f14688n = r9
        L5a:
            j.i9 r9 = r7.f14688n
            r9.tl(r1)
            j.i9 r9 = r7.f14688n
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            j.i9 r8 = r7.f14688n
            if (r8 == 0) goto L6c
            r8.tl(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: wz.c.v(android.view.MotionEvent, int):boolean");
    }

    public final void y() {
        this.f14690r = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f14692t - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        hw.mg mgVar = this.f14686f3;
        if (mgVar != null) {
            mgVar.zn();
            this.f14686f3 = null;
        }
    }

    public final void zn(Canvas canvas) {
        Drawable selector;
        if (!this.y.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.y);
            selector.draw(canvas);
        }
    }
}
