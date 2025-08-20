package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class s extends RecyclerView.d0 {

    /* renamed from: f  reason: collision with root package name */
    public PointF f3272f;

    /* renamed from: t  reason: collision with root package name */
    public final DisplayMetrics f3274t;

    /* renamed from: wz  reason: collision with root package name */
    public float f3277wz;

    /* renamed from: c5  reason: collision with root package name */
    public final LinearInterpolator f3271c5 = new LinearInterpolator();

    /* renamed from: i9  reason: collision with root package name */
    public final DecelerateInterpolator f3273i9 = new DecelerateInterpolator();

    /* renamed from: tl  reason: collision with root package name */
    public boolean f3275tl = false;

    /* renamed from: xc  reason: collision with root package name */
    public int f3278xc = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f3276w = 0;

    public s(Context context) {
        this.f3274t = context.getResources().getDisplayMetrics();
    }

    public int c() {
        PointF pointF = this.f3272f;
        if (pointF != null) {
            float f4 = pointF.x;
            if (f4 != 0.0f) {
                if (f4 > 0.0f) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }

    public int co(int i, int i5, int i6, int i8, int i10) {
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 == 1) {
                    return i8 - i5;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i11 = i6 - i;
            if (i11 > 0) {
                return i11;
            }
            int i12 = i8 - i5;
            if (i12 < 0) {
                return i12;
            }
            return 0;
        }
        return i6 - i;
    }

    public final float d0() {
        if (!this.f3275tl) {
            this.f3277wz = x4(this.f3274t);
            this.f3275tl = true;
        }
        return this.f3277wz;
    }

    public int f3(int i) {
        return (int) Math.ceil(Math.abs(i) * d0());
    }

    public int fh() {
        PointF pointF = this.f3272f;
        if (pointF != null) {
            float f4 = pointF.y;
            if (f4 != 0.0f) {
                if (f4 > 0.0f) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }

    public int i4(int i) {
        return (int) Math.ceil(f3(i) / 0.3356d);
    }

    public final int n(int i, int i5) {
        int i6 = i - i5;
        if (i * i6 <= 0) {
            return 0;
        }
        return i6;
    }

    public int r(View view, int i) {
        RecyclerView.w v2 = v();
        if (v2 != null && v2.x4()) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return co(v2.ct(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, v2.en(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, v2.getPaddingTop(), v2.rs() - v2.getPaddingBottom(), i);
        }
        return 0;
    }

    public void rz(RecyclerView.d0.y yVar) {
        PointF y = y(a());
        if (y != null && (y.x != 0.0f || y.y != 0.0f)) {
            c5(y);
            this.f3272f = y;
            this.f3278xc = (int) (y.x * 10000.0f);
            this.f3276w = (int) (y.y * 10000.0f);
            yVar.gv((int) (this.f3278xc * 1.2f), (int) (this.f3276w * 1.2f), (int) (f3(10000) * 1.2f), this.f3271c5);
            return;
        }
        yVar.n3(a());
        mt();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d0
    public void t(int i, int i5, RecyclerView.fh fhVar, RecyclerView.d0.y yVar) {
        if (zn() == 0) {
            mt();
            return;
        }
        this.f3278xc = n(this.f3278xc, i);
        int n2 = n(this.f3276w, i5);
        this.f3276w = n2;
        if (this.f3278xc == 0 && n2 == 0) {
            rz(yVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d0
    public void tl() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d0
    public void wz() {
        this.f3276w = 0;
        this.f3278xc = 0;
        this.f3272f = null;
    }

    public float x4(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d0
    public void xc(View view, RecyclerView.fh fhVar, RecyclerView.d0.y yVar) {
        int z2 = z(view, c());
        int r2 = r(view, fh());
        int i42 = i4((int) Math.sqrt((z2 * z2) + (r2 * r2)));
        if (i42 > 0) {
            yVar.gv(-z2, -r2, i42, this.f3273i9);
        }
    }

    public int z(View view, int i) {
        RecyclerView.w v2 = v();
        if (v2 != null && v2.r()) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return co(v2.u(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, v2.dm(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, v2.getPaddingLeft(), v2.g() - v2.getPaddingRight(), i);
        }
        return 0;
    }
}
