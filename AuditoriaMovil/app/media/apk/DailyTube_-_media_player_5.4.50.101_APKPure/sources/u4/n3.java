package u4;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import hw.ej;
import hw.i4;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n3 extends zn<View> {

    /* renamed from: a  reason: collision with root package name */
    public int f14036a;

    /* renamed from: fb  reason: collision with root package name */
    public int f14037fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Rect f14038gv;

    /* renamed from: v  reason: collision with root package name */
    public final Rect f14039v;

    public n3() {
        this.f14038gv = new Rect();
        this.f14039v = new Rect();
        this.f14036a = 0;
    }

    public static int yt(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    public float a8(View view) {
        return 1.0f;
    }

    public int b(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    @Override // u4.zn
    public void d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        View ej2 = ej(coordinatorLayout.mt(view));
        if (ej2 != null) {
            CoordinatorLayout.a aVar = (CoordinatorLayout.a) view.getLayoutParams();
            Rect rect = this.f14038gv;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aVar).leftMargin, ej2.getBottom() + ((ViewGroup.MarginLayoutParams) aVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) aVar).rightMargin, ((coordinatorLayout.getHeight() + ej2.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin);
            ej lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && i4.fh(coordinatorLayout) && !i4.fh(view)) {
                rect.left += lastWindowInsets.f();
                rect.right -= lastWindowInsets.t();
            }
            Rect rect2 = this.f14039v;
            hw.v.y(yt(aVar.f2088zn), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int ud2 = ud(ej2);
            view.layout(rect2.left, rect2.top - ud2, rect2.right, rect2.bottom - ud2);
            this.f14036a = rect2.top - ej2.getBottom();
            return;
        }
        super.d(coordinatorLayout, view, i);
        this.f14036a = 0;
    }

    @Nullable
    public abstract View ej(List<View> list);

    public boolean hw() {
        return false;
    }

    public final int k5() {
        return this.f14036a;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean tl(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i5, int i6, int i8) {
        View ej2;
        int i10;
        ej lastWindowInsets;
        int i11 = view.getLayoutParams().height;
        if ((i11 == -1 || i11 == -2) && (ej2 = ej(coordinatorLayout.mt(view))) != null) {
            int size = View.MeasureSpec.getSize(i6);
            if (size > 0) {
                if (i4.fh(ej2) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.tl() + lastWindowInsets.i9();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int b2 = size + b(ej2);
            int measuredHeight = ej2.getMeasuredHeight();
            if (hw()) {
                view.setTranslationY(-measuredHeight);
            } else {
                b2 -= measuredHeight;
            }
            if (i11 == -1) {
                i10 = 1073741824;
            } else {
                i10 = Integer.MIN_VALUE;
            }
            coordinatorLayout.a8(view, i, i5, View.MeasureSpec.makeMeasureSpec(b2, i10), i8);
            return true;
        }
        return false;
    }

    public final int ud(View view) {
        if (this.f14037fb == 0) {
            return 0;
        }
        float a82 = a8(view);
        int i = this.f14037fb;
        return a8.y.n3((int) (a82 * i), 0, i);
    }

    public final void vl(int i) {
        this.f14037fb = i;
    }

    public final int x() {
        return this.f14037fb;
    }

    public n3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14038gv = new Rect();
        this.f14039v = new Rect();
        this.f14036a = 0;
    }
}
