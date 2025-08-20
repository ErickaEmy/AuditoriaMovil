package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class t extends w {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public f f3279gv;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public f f3280v;

    /* loaded from: classes.dex */
    public class y extends s {
        public y(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.s
        public int f3(int i) {
            return Math.min(100, super.f3(i));
        }

        @Override // androidx.recyclerview.widget.s
        public float x4(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.s, androidx.recyclerview.widget.RecyclerView.d0
        public void xc(View view, RecyclerView.fh fhVar, RecyclerView.d0.y yVar) {
            t tVar = t.this;
            int[] zn2 = tVar.zn(tVar.y.getLayoutManager(), view);
            int i = zn2[0];
            int i5 = zn2[1];
            int i42 = i4(Math.max(Math.abs(i), Math.abs(i5)));
            if (i42 > 0) {
                yVar.gv(i, i5, i42, this.f3273i9);
            }
        }
    }

    private int t(@NonNull View view, f fVar) {
        return (fVar.fb(view) + (fVar.v(view) / 2)) - (fVar.tl() + (fVar.wz() / 2));
    }

    @Nullable
    private View tl(RecyclerView.w wVar, f fVar) {
        int oz2 = wVar.oz();
        View view = null;
        if (oz2 == 0) {
            return null;
        }
        int tl2 = fVar.tl() + (fVar.wz() / 2);
        int i = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < oz2; i5++) {
            View j2 = wVar.j(i5);
            int abs = Math.abs((fVar.fb(j2) + (fVar.v(j2) / 2)) - tl2);
            if (abs < i) {
                view = j2;
                i = abs;
            }
        }
        return view;
    }

    @NonNull
    private f w(@NonNull RecyclerView.w wVar) {
        f fVar = this.f3279gv;
        if (fVar == null || fVar.y != wVar) {
            this.f3279gv = f.zn(wVar);
        }
        return this.f3279gv;
    }

    @NonNull
    private f wz(@NonNull RecyclerView.w wVar) {
        f fVar = this.f3280v;
        if (fVar == null || fVar.y != wVar) {
            this.f3280v = f.y(wVar);
        }
        return this.f3280v;
    }

    @Override // androidx.recyclerview.widget.w
    @Nullable
    public View fb(RecyclerView.w wVar) {
        if (wVar.x4()) {
            return tl(wVar, w(wVar));
        }
        if (wVar.r()) {
            return tl(wVar, wz(wVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.w
    @Nullable
    public RecyclerView.d0 gv(@NonNull RecyclerView.w wVar) {
        if (!(wVar instanceof RecyclerView.d0.n3)) {
            return null;
        }
        return new y(this.y.getContext());
    }

    public final boolean mt(RecyclerView.w wVar) {
        PointF y2;
        int lc2 = wVar.lc();
        if (!(wVar instanceof RecyclerView.d0.n3) || (y2 = ((RecyclerView.d0.n3) wVar).y(lc2 - 1)) == null) {
            return false;
        }
        if (y2.x >= 0.0f && y2.y >= 0.0f) {
            return false;
        }
        return true;
    }

    public final boolean p(RecyclerView.w wVar, int i, int i5) {
        if (wVar.r()) {
            if (i <= 0) {
                return false;
            }
            return true;
        } else if (i5 <= 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.w
    public int s(RecyclerView.w wVar, int i, int i5) {
        f xc2;
        int i6;
        int lc2 = wVar.lc();
        if (lc2 == 0 || (xc2 = xc(wVar)) == null) {
            return -1;
        }
        int oz2 = wVar.oz();
        View view = null;
        View view2 = null;
        int i8 = Integer.MIN_VALUE;
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < oz2; i11++) {
            View j2 = wVar.j(i11);
            if (j2 != null) {
                int t2 = t(j2, xc2);
                if (t2 <= 0 && t2 > i8) {
                    view2 = j2;
                    i8 = t2;
                }
                if (t2 >= 0 && t2 < i10) {
                    view = j2;
                    i10 = t2;
                }
            }
        }
        boolean p2 = p(wVar, i, i5);
        if (p2 && view != null) {
            return wVar.ap(view);
        }
        if (!p2 && view2 != null) {
            return wVar.ap(view2);
        }
        if (p2) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int ap2 = wVar.ap(view);
        if (mt(wVar) == p2) {
            i6 = -1;
        } else {
            i6 = 1;
        }
        int i12 = ap2 + i6;
        if (i12 < 0 || i12 >= lc2) {
            return -1;
        }
        return i12;
    }

    @Nullable
    public final f xc(RecyclerView.w wVar) {
        if (wVar.x4()) {
            return w(wVar);
        }
        if (wVar.r()) {
            return wz(wVar);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.w
    @Nullable
    public int[] zn(@NonNull RecyclerView.w wVar, @NonNull View view) {
        int[] iArr = new int[2];
        if (wVar.r()) {
            iArr[0] = t(view, wz(wVar));
        } else {
            iArr[0] = 0;
        }
        if (wVar.x4()) {
            iArr[1] = t(view, w(wVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
