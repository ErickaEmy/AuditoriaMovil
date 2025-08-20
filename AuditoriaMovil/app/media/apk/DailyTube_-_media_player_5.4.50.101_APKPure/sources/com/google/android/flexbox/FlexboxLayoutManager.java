package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.s;
import com.google.android.flexbox.n3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FlexboxLayoutManager extends RecyclerView.w implements zf.y, RecyclerView.d0.n3 {

    /* renamed from: ap  reason: collision with root package name */
    public static final Rect f4970ap = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public int f4971b;

    /* renamed from: ct  reason: collision with root package name */
    public int f4972ct;

    /* renamed from: dm  reason: collision with root package name */
    public int f4973dm;

    /* renamed from: e  reason: collision with root package name */
    public int f4974e;

    /* renamed from: eb  reason: collision with root package name */
    public boolean f4975eb;

    /* renamed from: en  reason: collision with root package name */
    public zn f4976en;

    /* renamed from: f7  reason: collision with root package name */
    public RecyclerView.fh f4977f7;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4978j;

    /* renamed from: j5  reason: collision with root package name */
    public int f4979j5;

    /* renamed from: jz  reason: collision with root package name */
    public n3 f4980jz;

    /* renamed from: k  reason: collision with root package name */
    public RecyclerView.i4 f4981k;

    /* renamed from: lc  reason: collision with root package name */
    public SparseArray<View> f4982lc;

    /* renamed from: nf  reason: collision with root package name */
    public final Context f4983nf;

    /* renamed from: o  reason: collision with root package name */
    public int f4984o;

    /* renamed from: o4  reason: collision with root package name */
    public int f4985o4;

    /* renamed from: oz  reason: collision with root package name */
    public boolean f4986oz;

    /* renamed from: q9  reason: collision with root package name */
    public final com.google.android.flexbox.n3 f4987q9;

    /* renamed from: qn  reason: collision with root package name */
    public int f4988qn;

    /* renamed from: ra  reason: collision with root package name */
    public View f4989ra;

    /* renamed from: rs  reason: collision with root package name */
    public int f4990rs;

    /* renamed from: s8  reason: collision with root package name */
    public n3.C0056n3 f4991s8;

    /* renamed from: u  reason: collision with root package name */
    public f f4992u;

    /* renamed from: ut  reason: collision with root package name */
    public List<com.google.android.flexbox.y> f4993ut;

    /* renamed from: x  reason: collision with root package name */
    public int f4994x;

    /* renamed from: xg  reason: collision with root package name */
    public SavedState f4995xg;

    /* renamed from: y5  reason: collision with root package name */
    public f f4996y5;

    /* loaded from: classes.dex */
    public class n3 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5007a;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f5008fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f5009gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f5010n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f5012v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f5013zn;

        public n3() {
        }

        public static /* synthetic */ int t(n3 n3Var, int i) {
            int i5 = n3Var.f5009gv + i;
            n3Var.f5009gv = i5;
            return i5;
        }

        public final void co(View view) {
            f fVar = FlexboxLayoutManager.this.f4971b == 0 ? FlexboxLayoutManager.this.f4996y5 : FlexboxLayoutManager.this.f4992u;
            if (!FlexboxLayoutManager.this.f() && FlexboxLayoutManager.this.f4978j) {
                if (this.f5012v) {
                    this.f5013zn = fVar.fb(view) + fVar.xc();
                } else {
                    this.f5013zn = fVar.gv(view);
                }
            } else if (this.f5012v) {
                this.f5013zn = fVar.gv(view) + fVar.xc();
            } else {
                this.f5013zn = fVar.fb(view);
            }
            this.y = FlexboxLayoutManager.this.ap(view);
            int i = 0;
            this.f5008fb = false;
            int[] iArr = FlexboxLayoutManager.this.f4987q9.f5055zn;
            int i5 = this.y;
            if (i5 == -1) {
                i5 = 0;
            }
            int i6 = iArr[i5];
            if (i6 != -1) {
                i = i6;
            }
            this.f5010n3 = i;
            if (FlexboxLayoutManager.this.f4993ut.size() > this.f5010n3) {
                this.y = ((com.google.android.flexbox.y) FlexboxLayoutManager.this.f4993ut.get(this.f5010n3)).f5073xc;
            }
        }

        public final void mt() {
            int tl2;
            int g2;
            if (!FlexboxLayoutManager.this.f() && FlexboxLayoutManager.this.f4978j) {
                if (this.f5012v) {
                    g2 = FlexboxLayoutManager.this.f4992u.c5();
                } else {
                    g2 = FlexboxLayoutManager.this.g() - FlexboxLayoutManager.this.f4992u.tl();
                }
                this.f5013zn = g2;
                return;
            }
            if (this.f5012v) {
                tl2 = FlexboxLayoutManager.this.f4992u.c5();
            } else {
                tl2 = FlexboxLayoutManager.this.f4992u.tl();
            }
            this.f5013zn = tl2;
        }

        @NonNull
        public String toString() {
            return "AnchorInfo{mPosition=" + this.y + ", mFlexLinePosition=" + this.f5010n3 + ", mCoordinate=" + this.f5013zn + ", mPerpendicularCoordinate=" + this.f5009gv + ", mLayoutFromEnd=" + this.f5012v + ", mValid=" + this.f5007a + ", mAssignedFromSavedState=" + this.f5008fb + '}';
        }

        public final void z() {
            this.y = -1;
            this.f5010n3 = -1;
            this.f5013zn = Integer.MIN_VALUE;
            boolean z2 = false;
            this.f5007a = false;
            this.f5008fb = false;
            if (FlexboxLayoutManager.this.f()) {
                if (FlexboxLayoutManager.this.f4971b == 0) {
                    if (FlexboxLayoutManager.this.f4994x == 1) {
                        z2 = true;
                    }
                    this.f5012v = z2;
                    return;
                }
                if (FlexboxLayoutManager.this.f4971b == 2) {
                    z2 = true;
                }
                this.f5012v = z2;
            } else if (FlexboxLayoutManager.this.f4971b == 0) {
                if (FlexboxLayoutManager.this.f4994x == 3) {
                    z2 = true;
                }
                this.f5012v = z2;
            } else {
                if (FlexboxLayoutManager.this.f4971b == 2) {
                    z2 = true;
                }
                this.f5012v = z2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: a  reason: collision with root package name */
        public int f5014a;

        /* renamed from: c5  reason: collision with root package name */
        public int f5015c5;

        /* renamed from: fb  reason: collision with root package name */
        public int f5016fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f5017gv;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f5018i9;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f5019n3;

        /* renamed from: s  reason: collision with root package name */
        public int f5020s;

        /* renamed from: v  reason: collision with root package name */
        public int f5021v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f5022zn;

        public zn() {
            this.f5020s = 1;
            this.f5015c5 = 1;
        }

        public static /* synthetic */ int c5(zn znVar, int i) {
            int i5 = znVar.y - i;
            znVar.y = i5;
            return i5;
        }

        public static /* synthetic */ int gv(zn znVar, int i) {
            int i5 = znVar.f5021v - i;
            znVar.f5021v = i5;
            return i5;
        }

        public static /* synthetic */ int p(zn znVar, int i) {
            int i5 = znVar.f5014a + i;
            znVar.f5014a = i5;
            return i5;
        }

        public static /* synthetic */ int r(zn znVar, int i) {
            int i5 = znVar.f5017gv + i;
            znVar.f5017gv = i5;
            return i5;
        }

        public static /* synthetic */ int t(zn znVar) {
            int i = znVar.f5022zn;
            znVar.f5022zn = i + 1;
            return i;
        }

        public static /* synthetic */ int tl(zn znVar) {
            int i = znVar.f5022zn;
            znVar.f5022zn = i - 1;
            return i;
        }

        public static /* synthetic */ int wz(zn znVar, int i) {
            int i5 = znVar.f5022zn + i;
            znVar.f5022zn = i5;
            return i5;
        }

        public static /* synthetic */ int x4(zn znVar, int i) {
            int i5 = znVar.f5017gv - i;
            znVar.f5017gv = i5;
            return i5;
        }

        public static /* synthetic */ int zn(zn znVar, int i) {
            int i5 = znVar.f5021v + i;
            znVar.f5021v = i5;
            return i5;
        }

        public final boolean mg(RecyclerView.fh fhVar, List<com.google.android.flexbox.y> list) {
            int i;
            int i5 = this.f5017gv;
            if (i5 >= 0 && i5 < fhVar.n3() && (i = this.f5022zn) >= 0 && i < list.size()) {
                return true;
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "LayoutState{mAvailable=" + this.y + ", mFlexLinePosition=" + this.f5022zn + ", mPosition=" + this.f5017gv + ", mOffset=" + this.f5021v + ", mScrollingOffset=" + this.f5014a + ", mLastScrollDelta=" + this.f5016fb + ", mItemDirection=" + this.f5020s + ", mLayoutDirection=" + this.f5015c5 + '}';
        }
    }

    public FlexboxLayoutManager(Context context, int i) {
        this(context, i, 1);
    }

    private void e5() {
        if (this.f4976en == null) {
            this.f4976en = new zn();
        }
    }

    private boolean wo(View view, int i, int i5, RecyclerView.p pVar) {
        if (!view.isLayoutRequested() && o0() && xb(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && xb(view.getHeight(), i5, ((ViewGroup.MarginLayoutParams) pVar).height)) {
            return false;
        }
        return true;
    }

    public static boolean xb(int i, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (i6 > 0 && i != i6) {
            return false;
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return true;
            }
            if (mode != 1073741824 || size != i) {
                return false;
            }
            return true;
        } else if (size < i) {
            return false;
        } else {
            return true;
        }
    }

    @Override // zf.y
    public int a(View view) {
        int ra2;
        int yc2;
        if (f()) {
            ra2 = g3(view);
            yc2 = o(view);
        } else {
            ra2 = ra(view);
            yc2 = yc(view);
        }
        return ra2 + yc2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void bv(RecyclerView.fh fhVar) {
        super.bv(fhVar);
        this.f4995xg = null;
        this.f4973dm = -1;
        this.f4972ct = Integer.MIN_VALUE;
        this.f4974e = -1;
        this.f4980jz.z();
        this.f4982lc.clear();
    }

    public final void bx(RecyclerView.i4 i4Var, zn znVar) {
        if (!znVar.f5018i9) {
            return;
        }
        if (znVar.f5015c5 == -1) {
            cp(i4Var, znVar);
        } else {
            gd(i4Var, znVar);
        }
    }

    @Override // zf.y
    public void c5(int i, View view) {
        this.f4982lc.put(i, view);
    }

    public final void cp(RecyclerView.i4 i4Var, zn znVar) {
        int oz2;
        int i;
        View j2;
        int i5;
        if (znVar.f5014a < 0 || (oz2 = oz()) == 0 || (j2 = j(oz2 - 1)) == null || (i5 = this.f4987q9.f5055zn[ap(j2)]) == -1) {
            return;
        }
        com.google.android.flexbox.y yVar = this.f4993ut.get(i5);
        int i6 = i;
        while (true) {
            if (i6 < 0) {
                break;
            }
            View j4 = j(i6);
            if (j4 != null) {
                if (!sh(j4, znVar.f5014a)) {
                    break;
                } else if (yVar.f5073xc != ap(j4)) {
                    continue;
                } else if (i5 <= 0) {
                    oz2 = i6;
                    break;
                } else {
                    i5 += znVar.f5015c5;
                    yVar = this.f4993ut.get(i5);
                    oz2 = i6;
                }
            }
            i6--;
        }
        ja(i4Var, oz2, i);
    }

    public final int cw(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        boolean z2;
        if (oz() == 0 || i == 0) {
            return 0;
        }
        yh();
        int i5 = 1;
        this.f4976en.f5018i9 = true;
        if (!f() && this.f4978j) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 ? i <= 0 : i >= 0) {
            i5 = -1;
        }
        int abs = Math.abs(i);
        w5(i5, abs);
        int nh = this.f4976en.f5014a + nh(i4Var, fhVar, this.f4976en);
        if (nh < 0) {
            return 0;
        }
        if (z2) {
            if (abs > nh) {
                i = (-i5) * nh;
            }
        } else if (abs > nh) {
            i = i5 * nh;
        }
        this.f4992u.mt(-i);
        this.f4976en.f5016fb = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int d(@NonNull RecyclerView.fh fhVar) {
        return l3(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int d0(@NonNull RecyclerView.fh fhVar) {
        return ou(fhVar);
    }

    public final View eu(View view, com.google.android.flexbox.y yVar) {
        boolean f4 = f();
        int i = yVar.f5067s;
        for (int i5 = 1; i5 < i; i5++) {
            View j2 = j(i5);
            if (j2 != null && j2.getVisibility() != 8) {
                if (this.f4978j && !f4) {
                    if (this.f4992u.gv(view) >= this.f4992u.gv(j2)) {
                    }
                    view = j2;
                } else {
                    if (this.f4992u.fb(view) <= this.f4992u.fb(j2)) {
                    }
                    view = j2;
                }
            }
        }
        return view;
    }

    public final int ez(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar, boolean z2) {
        int i5;
        int tl2;
        if (!f() && this.f4978j) {
            int c52 = this.f4992u.c5() - i;
            if (c52 <= 0) {
                return 0;
            }
            i5 = cw(-c52, i4Var, fhVar);
        } else {
            int tl3 = i - this.f4992u.tl();
            if (tl3 <= 0) {
                return 0;
            }
            i5 = -cw(tl3, i4Var, fhVar);
        }
        int i6 = i + i5;
        if (z2 && (tl2 = i6 - this.f4992u.tl()) > 0) {
            this.f4992u.mt(-tl2);
            return i5 - tl2;
        }
        return i5;
    }

    @Override // zf.y
    public boolean f() {
        int i = this.f4994x;
        if (i == 0 || i == 1) {
            return true;
        }
        return false;
    }

    @Override // zf.y
    public void fb(com.google.android.flexbox.y yVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int fh(@NonNull RecyclerView.fh fhVar) {
        return vi(fhVar);
    }

    public final void fm(int i) {
        int i5;
        int i6;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(g(), u0());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(rs(), eb());
        int g2 = g();
        int rs2 = rs();
        boolean z2 = false;
        if (f()) {
            int i8 = this.f4985o4;
            if (i8 != Integer.MIN_VALUE && i8 != g2) {
                z2 = true;
            }
            i5 = this.f4976en.f5019n3 ? this.f4983nf.getResources().getDisplayMetrics().heightPixels : this.f4976en.y;
        } else {
            int i10 = this.f4990rs;
            if (i10 != Integer.MIN_VALUE && i10 != rs2) {
                z2 = true;
            }
            if (!this.f4976en.f5019n3) {
                i5 = this.f4976en.y;
            } else {
                i5 = this.f4983nf.getResources().getDisplayMetrics().widthPixels;
            }
        }
        int i11 = i5;
        this.f4985o4 = g2;
        this.f4990rs = rs2;
        int i12 = this.f4974e;
        if (i12 == -1 && (this.f4973dm != -1 || z2)) {
            if (this.f4980jz.f5012v) {
                return;
            }
            this.f4993ut.clear();
            this.f4991s8.y();
            if (f()) {
                this.f4987q9.v(this.f4991s8, makeMeasureSpec, makeMeasureSpec2, i11, this.f4980jz.y, this.f4993ut);
            } else {
                this.f4987q9.s(this.f4991s8, makeMeasureSpec, makeMeasureSpec2, i11, this.f4980jz.y, this.f4993ut);
            }
            this.f4993ut = this.f4991s8.y;
            this.f4987q9.w(makeMeasureSpec, makeMeasureSpec2);
            this.f4987q9.k();
            n3 n3Var = this.f4980jz;
            n3Var.f5010n3 = this.f4987q9.f5055zn[n3Var.y];
            this.f4976en.f5022zn = this.f4980jz.f5010n3;
            return;
        }
        if (i12 == -1) {
            i6 = this.f4980jz.y;
        } else {
            i6 = Math.min(i12, this.f4980jz.y);
        }
        int i13 = i6;
        this.f4991s8.y();
        if (f()) {
            if (this.f4993ut.size() > 0) {
                this.f4987q9.i9(this.f4993ut, i13);
                this.f4987q9.n3(this.f4991s8, makeMeasureSpec, makeMeasureSpec2, i11, i13, this.f4980jz.y, this.f4993ut);
            } else {
                this.f4987q9.co(i);
                this.f4987q9.gv(this.f4991s8, makeMeasureSpec, makeMeasureSpec2, i11, 0, this.f4993ut);
            }
        } else if (this.f4993ut.size() > 0) {
            this.f4987q9.i9(this.f4993ut, i13);
            this.f4987q9.n3(this.f4991s8, makeMeasureSpec2, makeMeasureSpec, i11, i13, this.f4980jz.y, this.f4993ut);
        } else {
            this.f4987q9.co(i);
            this.f4987q9.fb(this.f4991s8, makeMeasureSpec, makeMeasureSpec2, i11, 0, this.f4993ut);
        }
        this.f4993ut = this.f4991s8.y;
        this.f4987q9.p(makeMeasureSpec, makeMeasureSpec2, i13);
        this.f4987q9.f7(i13);
    }

    public final void gd(RecyclerView.i4 i4Var, zn znVar) {
        int oz2;
        View j2;
        if (znVar.f5014a < 0 || (oz2 = oz()) == 0 || (j2 = j(0)) == null) {
            return;
        }
        int i = this.f4987q9.f5055zn[ap(j2)];
        int i5 = -1;
        if (i == -1) {
            return;
        }
        com.google.android.flexbox.y yVar = this.f4993ut.get(i);
        int i6 = 0;
        while (true) {
            if (i6 >= oz2) {
                break;
            }
            View j4 = j(i6);
            if (j4 != null) {
                if (!hf(j4, znVar.f5014a)) {
                    break;
                } else if (yVar.f5071w != ap(j4)) {
                    continue;
                } else if (i >= this.f4993ut.size() - 1) {
                    i5 = i6;
                    break;
                } else {
                    i += znVar.f5015c5;
                    yVar = this.f4993ut.get(i);
                    i5 = i6;
                }
            }
            i6++;
        }
        ja(i4Var, 0, i5);
    }

    @Override // zf.y
    public int getAlignContent() {
        return 5;
    }

    @Override // zf.y
    public int getAlignItems() {
        return this.f4988qn;
    }

    @Override // zf.y
    public int getFlexDirection() {
        return this.f4994x;
    }

    @Override // zf.y
    public int getFlexItemCount() {
        return this.f4977f7.n3();
    }

    @Override // zf.y
    public List<com.google.android.flexbox.y> getFlexLinesInternal() {
        return this.f4993ut;
    }

    @Override // zf.y
    public int getFlexWrap() {
        return this.f4971b;
    }

    @Override // zf.y
    public int getLargestMainSize() {
        if (this.f4993ut.size() == 0) {
            return 0;
        }
        int size = this.f4993ut.size();
        int i = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < size; i5++) {
            i = Math.max(i, this.f4993ut.get(i5).f5070v);
        }
        return i;
    }

    @Override // zf.y
    public int getMaxLine() {
        return this.f4984o;
    }

    @Override // zf.y
    public int getSumOfCrossSize() {
        int size = this.f4993ut.size();
        int i = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i += this.f4993ut.get(i5).f5061fb;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void gf(RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        int i;
        int i5;
        this.f4981k = i4Var;
        this.f4977f7 = fhVar;
        int n32 = fhVar.n3();
        if (n32 == 0 && fhVar.v()) {
            return;
        }
        y0();
        yh();
        e5();
        this.f4987q9.z(n32);
        this.f4987q9.r(n32);
        this.f4987q9.co(n32);
        this.f4976en.f5018i9 = false;
        SavedState savedState = this.f4995xg;
        if (savedState != null && savedState.fb(n32)) {
            this.f4973dm = this.f4995xg.y;
        }
        if (!this.f4980jz.f5007a || this.f4973dm != -1 || this.f4995xg != null) {
            this.f4980jz.z();
            x2(fhVar, this.f4980jz);
            this.f4980jz.f5007a = true;
        }
        z6(i4Var);
        if (this.f4980jz.f5012v) {
            ik(this.f4980jz, false, true);
        } else {
            p4(this.f4980jz, false, true);
        }
        fm(n32);
        nh(i4Var, fhVar, this.f4976en);
        if (this.f4980jz.f5012v) {
            i5 = this.f4976en.f5021v;
            p4(this.f4980jz, true, false);
            nh(i4Var, fhVar, this.f4976en);
            i = this.f4976en.f5021v;
        } else {
            i = this.f4976en.f5021v;
            ik(this.f4980jz, true, false);
            nh(i4Var, fhVar, this.f4976en);
            i5 = this.f4976en.f5021v;
        }
        if (oz() > 0) {
            if (this.f4980jz.f5012v) {
                ez(i5 + mc(i, i4Var, fhVar, true), i4Var, fhVar, false);
            } else {
                mc(i + ez(i5, i4Var, fhVar, true), i4Var, fhVar, false);
            }
        }
    }

    public final boolean gm(RecyclerView.fh fhVar, n3 n3Var) {
        View i1;
        int tl2;
        if (oz() == 0) {
            return false;
        }
        if (n3Var.f5012v) {
            i1 = z8(fhVar.n3());
        } else {
            i1 = i1(fhVar.n3());
        }
        if (i1 != null) {
            n3Var.co(i1);
            if (!fhVar.v() && sx()) {
                if (this.f4992u.fb(i1) >= this.f4992u.c5() || this.f4992u.gv(i1) < this.f4992u.tl()) {
                    if (n3Var.f5012v) {
                        tl2 = this.f4992u.c5();
                    } else {
                        tl2 = this.f4992u.tl();
                    }
                    n3Var.f5013zn = tl2;
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // zf.y
    public View gv(int i) {
        View view = this.f4982lc.get(i);
        if (view != null) {
            return view;
        }
        return this.f4981k.xc(i);
    }

    public final boolean hf(View view, int i) {
        if (!f() && this.f4978j) {
            if (this.f4992u.s() - this.f4992u.fb(view) > i) {
                return false;
            }
            return true;
        } else if (this.f4992u.gv(view) > i) {
            return false;
        } else {
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p hw(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int hy(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        if (f() && this.f4971b != 0) {
            int nz = nz(i);
            n3.t(this.f4980jz, nz);
            this.f4996y5.mt(-nz);
            return nz;
        }
        int cw = cw(i, i4Var, fhVar);
        this.f4982lc.clear();
        return cw;
    }

    public final View i1(int i) {
        View x0 = x0(0, oz(), i);
        if (x0 == null) {
            return null;
        }
        int i5 = this.f4987q9.f5055zn[ap(x0)];
        if (i5 == -1) {
            return null;
        }
        return eu(x0, this.f4993ut.get(i5));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean i4(RecyclerView.p pVar) {
        return pVar instanceof LayoutParams;
    }

    @Override // zf.y
    public int i9(View view, int i, int i5) {
        int g32;
        int o2;
        if (f()) {
            g32 = ra(view);
            o2 = yc(view);
        } else {
            g32 = g3(view);
            o2 = o(view);
        }
        return g32 + o2;
    }

    public final View ih(View view, com.google.android.flexbox.y yVar) {
        boolean f4 = f();
        int oz2 = (oz() - yVar.f5067s) - 1;
        for (int oz3 = oz() - 2; oz3 > oz2; oz3--) {
            View j2 = j(oz3);
            if (j2 != null && j2.getVisibility() != 8) {
                if (this.f4978j && !f4) {
                    if (this.f4992u.fb(view) <= this.f4992u.fb(j2)) {
                    }
                    view = j2;
                } else {
                    if (this.f4992u.gv(view) >= this.f4992u.gv(j2)) {
                    }
                    view = j2;
                }
            }
        }
        return view;
    }

    public final void ik(n3 n3Var, boolean z2, boolean z3) {
        if (!z3) {
            this.f4976en.f5019n3 = false;
        } else {
            ng();
        }
        if (!f() && this.f4978j) {
            this.f4976en.y = (this.f4989ra.getWidth() - n3Var.f5013zn) - this.f4992u.tl();
        } else {
            this.f4976en.y = n3Var.f5013zn - this.f4992u.tl();
        }
        this.f4976en.f5017gv = n3Var.y;
        this.f4976en.f5020s = 1;
        this.f4976en.f5015c5 = -1;
        this.f4976en.f5021v = n3Var.f5013zn;
        this.f4976en.f5014a = Integer.MIN_VALUE;
        this.f4976en.f5022zn = n3Var.f5010n3;
        if (z2 && n3Var.f5010n3 > 0 && this.f4993ut.size() > n3Var.f5010n3) {
            zn.tl(this.f4976en);
            zn.x4(this.f4976en, this.f4993ut.get(n3Var.f5010n3).n3());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void im(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f4995xg = (SavedState) parcelable;
            hr();
        }
    }

    public final int iu(View view) {
        return ct(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }

    public final View j4() {
        return j(0);
    }

    public final void ja(RecyclerView.i4 i4Var, int i, int i5) {
        while (i5 >= i) {
            gn(i5, i4Var);
            i5--;
        }
    }

    public final boolean jf(RecyclerView.fh fhVar, n3 n3Var, SavedState savedState) {
        int i;
        View j2;
        int fb2;
        boolean z2 = false;
        if (!fhVar.v() && (i = this.f4973dm) != -1) {
            if (i >= 0 && i < fhVar.n3()) {
                n3Var.y = this.f4973dm;
                n3Var.f5010n3 = this.f4987q9.f5055zn[n3Var.y];
                SavedState savedState2 = this.f4995xg;
                if (savedState2 != null && savedState2.fb(fhVar.n3())) {
                    n3Var.f5013zn = this.f4992u.tl() + savedState.f5006v;
                    n3Var.f5008fb = true;
                    n3Var.f5010n3 = -1;
                    return true;
                } else if (this.f4972ct == Integer.MIN_VALUE) {
                    View yt2 = yt(this.f4973dm);
                    if (yt2 != null) {
                        if (this.f4992u.v(yt2) > this.f4992u.wz()) {
                            n3Var.mt();
                            return true;
                        } else if (this.f4992u.fb(yt2) - this.f4992u.tl() < 0) {
                            n3Var.f5013zn = this.f4992u.tl();
                            n3Var.f5012v = false;
                            return true;
                        } else if (this.f4992u.c5() - this.f4992u.gv(yt2) < 0) {
                            n3Var.f5013zn = this.f4992u.c5();
                            n3Var.f5012v = true;
                            return true;
                        } else {
                            if (n3Var.f5012v) {
                                fb2 = this.f4992u.gv(yt2) + this.f4992u.xc();
                            } else {
                                fb2 = this.f4992u.fb(yt2);
                            }
                            n3Var.f5013zn = fb2;
                        }
                    } else {
                        if (oz() > 0 && (j2 = j(0)) != null) {
                            if (this.f4973dm < ap(j2)) {
                                z2 = true;
                            }
                            n3Var.f5012v = z2;
                        }
                        n3Var.mt();
                    }
                    return true;
                } else {
                    if (f() || !this.f4978j) {
                        n3Var.f5013zn = this.f4992u.tl() + this.f4972ct;
                    } else {
                        n3Var.f5013zn = this.f4972ct - this.f4992u.i9();
                    }
                    return true;
                }
            }
            this.f4973dm = -1;
            this.f4972ct = Integer.MIN_VALUE;
        }
        return false;
    }

    public int jm() {
        View mq = mq(oz() - 1, -1, false);
        if (mq == null) {
            return -1;
        }
        return ap(mq);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int jt(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        if (!f() && (this.f4971b != 0 || f())) {
            int nz = nz(i);
            n3.t(this.f4980jz, nz);
            this.f4996y5.mt(-nz);
            return nz;
        }
        int cw = cw(i, i4Var, fhVar);
        this.f4982lc.clear();
        return cw;
    }

    public final int l3(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        int n32 = fhVar.n3();
        View i1 = i1(n32);
        View z8 = z8(n32);
        if (fhVar.n3() == 0 || i1 == null || z8 == null) {
            return 0;
        }
        int xu = xu();
        return (int) ((Math.abs(this.f4992u.gv(z8) - this.f4992u.fb(i1)) / ((jm() - xu) + 1)) * fhVar.n3());
    }

    public final boolean l8(View view, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int g2 = g() - getPaddingRight();
        int rs2 = rs() - getPaddingBottom();
        int t7 = t7(view);
        int iu = iu(view);
        int p2 = p2(view);
        int wb = wb(view);
        if (paddingLeft <= t7 && g2 >= p2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (t7 < g2 && p2 < paddingLeft) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (paddingTop <= iu && rs2 >= wb) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (iu < rs2 && wb < paddingTop) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z2) {
            if (z3 && z5) {
                return true;
            }
            return false;
        } else if (z4 && z7) {
            return true;
        } else {
            return false;
        }
    }

    public void m5(int i) {
        if (i != 2) {
            int i5 = this.f4971b;
            if (i5 != i) {
                if (i5 == 0 || i == 0) {
                    zq();
                    w7();
                }
                this.f4971b = i;
                this.f4992u = null;
                this.f4996y5 = null;
                hr();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    public final int mc(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar, boolean z2) {
        int i5;
        int c52;
        if (!f() && this.f4978j) {
            int tl2 = i - this.f4992u.tl();
            if (tl2 <= 0) {
                return 0;
            }
            i5 = cw(tl2, i4Var, fhVar);
        } else {
            int c53 = this.f4992u.c5() - i;
            if (c53 <= 0) {
                return 0;
            }
            i5 = -cw(-c53, i4Var, fhVar);
        }
        int i6 = i + i5;
        if (z2 && (c52 = this.f4992u.c5() - i6) > 0) {
            this.f4992u.mt(c52);
            return c52 + i5;
        }
        return i5;
    }

    public final void mf(int i) {
        if (i >= jm()) {
            return;
        }
        int oz2 = oz();
        this.f4987q9.z(oz2);
        this.f4987q9.r(oz2);
        this.f4987q9.co(oz2);
        if (i >= this.f4987q9.f5055zn.length) {
            return;
        }
        this.f4974e = i;
        View j4 = j4();
        if (j4 == null) {
            return;
        }
        this.f4973dm = ap(j4);
        if (!f() && this.f4978j) {
            this.f4972ct = this.f4992u.gv(j4) + this.f4992u.i9();
        } else {
            this.f4972ct = this.f4992u.fb(j4) - this.f4992u.tl();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int mg(@NonNull RecyclerView.fh fhVar) {
        return ou(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public Parcelable mh() {
        if (this.f4995xg != null) {
            return new SavedState(this.f4995xg);
        }
        SavedState savedState = new SavedState();
        if (oz() <= 0) {
            savedState.s();
        } else {
            View j4 = j4();
            savedState.y = ap(j4);
            savedState.f5006v = this.f4992u.fb(j4) - this.f4992u.tl();
        }
        return savedState;
    }

    public final View mq(int i, int i5, boolean z2) {
        int i6;
        if (i5 > i) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        while (i != i5) {
            View j2 = j(i);
            if (l8(j2, z2)) {
                return j2;
            }
            i += i6;
        }
        return null;
    }

    @Override // zf.y
    public void n3(View view, int i, int i5, com.google.android.flexbox.y yVar) {
        z(view, f4970ap);
        if (f()) {
            int ra2 = ra(view) + yc(view);
            yVar.f5070v += ra2;
            yVar.f5058a += ra2;
            return;
        }
        int g32 = g3(view) + o(view);
        yVar.f5070v += g32;
        yVar.f5058a += g32;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void nd(@NonNull RecyclerView recyclerView, int i, int i5, Object obj) {
        super.nd(recyclerView, i, i5, obj);
        mf(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void ne(@NonNull RecyclerView recyclerView, int i, int i5, int i6) {
        super.ne(recyclerView, i, i5, i6);
        mf(Math.min(i, i5));
    }

    public final void ng() {
        int u02;
        boolean z2;
        if (f()) {
            u02 = eb();
        } else {
            u02 = u0();
        }
        zn znVar = this.f4976en;
        if (u02 != 0 && u02 != Integer.MIN_VALUE) {
            z2 = false;
        } else {
            z2 = true;
        }
        znVar.f5019n3 = z2;
    }

    public final int nh(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, zn znVar) {
        if (znVar.f5014a != Integer.MIN_VALUE) {
            if (znVar.y < 0) {
                zn.p(znVar, znVar.y);
            }
            bx(i4Var, znVar);
        }
        int i = znVar.y;
        int i5 = znVar.y;
        boolean f4 = f();
        int i6 = 0;
        while (true) {
            if ((i5 > 0 || this.f4976en.f5019n3) && znVar.mg(fhVar, this.f4993ut)) {
                com.google.android.flexbox.y yVar = this.f4993ut.get(znVar.f5022zn);
                znVar.f5017gv = yVar.f5073xc;
                i6 += xh(yVar, znVar);
                if (!f4 && this.f4978j) {
                    zn.gv(znVar, yVar.y() * znVar.f5015c5);
                } else {
                    zn.zn(znVar, yVar.y() * znVar.f5015c5);
                }
                i5 -= yVar.y();
            }
        }
        zn.c5(znVar, i6);
        if (znVar.f5014a != Integer.MIN_VALUE) {
            zn.p(znVar, i6);
            if (znVar.y < 0) {
                zn.p(znVar, znVar.y);
            }
            bx(i4Var, znVar);
        }
        return i - znVar.y;
    }

    public final int nz(int i) {
        int height;
        int rs2;
        int i5;
        if (oz() != 0 && i != 0) {
            yh();
            boolean f4 = f();
            View view = this.f4989ra;
            if (f4) {
                height = view.getWidth();
            } else {
                height = view.getHeight();
            }
            if (f4) {
                rs2 = g();
            } else {
                rs2 = rs();
            }
            if (nf() == 1) {
                int abs = Math.abs(i);
                if (i < 0) {
                    i5 = Math.min((rs2 + this.f4980jz.f5009gv) - height, abs);
                } else if (this.f4980jz.f5009gv + i > 0) {
                    i5 = this.f4980jz.f5009gv;
                } else {
                    return i;
                }
            } else if (i > 0) {
                return Math.min((rs2 - this.f4980jz.f5009gv) - height, i);
            } else {
                if (this.f4980jz.f5009gv + i < 0) {
                    i5 = this.f4980jz.f5009gv;
                } else {
                    return i;
                }
            }
            return -i5;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void oa(RecyclerView.s sVar, RecyclerView.s sVar2) {
        zq();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void ob(RecyclerView recyclerView, RecyclerView.fh fhVar, int i) {
        s sVar = new s(recyclerView.getContext());
        sVar.w(i);
        vb(sVar);
    }

    public void op(int i) {
        if (this.f4979j5 != i) {
            this.f4979j5 = i;
            hr();
        }
    }

    public final int ou(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        int n32 = fhVar.n3();
        yh();
        View i1 = i1(n32);
        View z8 = z8(n32);
        if (fhVar.n3() == 0 || i1 == null || z8 == null) {
            return 0;
        }
        return Math.min(this.f4992u.wz(), this.f4992u.gv(z8) - this.f4992u.fb(i1));
    }

    public final int p2(View view) {
        return dm(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
    }

    public final void p4(n3 n3Var, boolean z2, boolean z3) {
        if (!z3) {
            this.f4976en.f5019n3 = false;
        } else {
            ng();
        }
        if (!f() && this.f4978j) {
            this.f4976en.y = n3Var.f5013zn - getPaddingRight();
        } else {
            this.f4976en.y = this.f4992u.c5() - n3Var.f5013zn;
        }
        this.f4976en.f5017gv = n3Var.y;
        this.f4976en.f5020s = 1;
        this.f4976en.f5015c5 = 1;
        this.f4976en.f5021v = n3Var.f5013zn;
        this.f4976en.f5014a = Integer.MIN_VALUE;
        this.f4976en.f5022zn = n3Var.f5010n3;
        if (z2 && this.f4993ut.size() > 1 && n3Var.f5010n3 >= 0 && n3Var.f5010n3 < this.f4993ut.size() - 1) {
            zn.t(this.f4976en);
            zn.r(this.f4976en, this.f4993ut.get(n3Var.f5010n3).n3());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void q(@NonNull RecyclerView recyclerView, int i, int i5) {
        super.q(recyclerView, i, i5);
        mf(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void q5(RecyclerView recyclerView, RecyclerView.i4 i4Var) {
        super.q5(recyclerView, i4Var);
        if (this.f4975eb) {
            hk(i4Var);
            i4Var.zn();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean r() {
        int i;
        if (this.f4971b == 0) {
            return f();
        }
        if (f()) {
            int g2 = g();
            View view = this.f4989ra;
            if (view != null) {
                i = view.getWidth();
            } else {
                i = 0;
            }
            if (g2 <= i) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int rk(com.google.android.flexbox.y r26, com.google.android.flexbox.FlexboxLayoutManager.zn r27) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.rk(com.google.android.flexbox.y, com.google.android.flexbox.FlexboxLayoutManager$zn):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int rz(@NonNull RecyclerView.fh fhVar) {
        return l3(fhVar);
    }

    @Override // zf.y
    public View s(int i) {
        return gv(i);
    }

    @Override // zf.y
    public void setFlexLines(List<com.google.android.flexbox.y> list) {
        this.f4993ut = list;
    }

    public final boolean sh(View view, int i) {
        if (!f() && this.f4978j) {
            if (this.f4992u.gv(view) > i) {
                return false;
            }
            return true;
        } else if (this.f4992u.fb(view) < this.f4992u.s() - i) {
            return false;
        } else {
            return true;
        }
    }

    public void t3(int i) {
        if (this.f4994x != i) {
            zq();
            this.f4994x = i;
            this.f4992u = null;
            this.f4996y5 = null;
            w7();
            hr();
        }
    }

    public void t6(int i) {
        int i5 = this.f4988qn;
        if (i5 != i) {
            if (i5 == 4 || i == 4) {
                zq();
                w7();
            }
            this.f4988qn = i;
            hr();
        }
    }

    public final int t7(View view) {
        return u(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int ta(@NonNull RecyclerView.fh fhVar) {
        return vi(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean tg() {
        return true;
    }

    @Override // zf.y
    public int v(int i, int i5, int i6) {
        return RecyclerView.w.ut(rs(), eb(), i5, i6, x4());
    }

    public final int vi(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        int n32 = fhVar.n3();
        View i1 = i1(n32);
        View z8 = z8(n32);
        if (fhVar.n3() != 0 && i1 != null && z8 != null) {
            int ap2 = ap(i1);
            int ap3 = ap(z8);
            int abs = Math.abs(this.f4992u.gv(z8) - this.f4992u.fb(i1));
            int[] iArr = this.f4987q9.f5055zn;
            int i = iArr[ap2];
            if (i != 0 && i != -1) {
                return Math.round((i * (abs / ((iArr[ap3] - i) + 1))) + (this.f4992u.tl() - this.f4992u.fb(i1)));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p vl() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void vn(@NonNull RecyclerView recyclerView, int i, int i5) {
        super.vn(recyclerView, i, i5);
        mf(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void w2(RecyclerView recyclerView) {
        super.w2(recyclerView);
        this.f4989ra = (View) recyclerView.getParent();
    }

    public final void w5(int i, int i5) {
        boolean z2;
        int i6;
        this.f4976en.f5015c5 = i;
        boolean f4 = f();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(g(), u0());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(rs(), eb());
        if (!f4 && this.f4978j) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i == 1) {
            View j2 = j(oz() - 1);
            if (j2 == null) {
                return;
            }
            this.f4976en.f5021v = this.f4992u.gv(j2);
            int ap2 = ap(j2);
            View ih = ih(j2, this.f4993ut.get(this.f4987q9.f5055zn[ap2]));
            this.f4976en.f5020s = 1;
            zn znVar = this.f4976en;
            znVar.f5017gv = ap2 + znVar.f5020s;
            if (this.f4987q9.f5055zn.length <= this.f4976en.f5017gv) {
                this.f4976en.f5022zn = -1;
            } else {
                zn znVar2 = this.f4976en;
                znVar2.f5022zn = this.f4987q9.f5055zn[znVar2.f5017gv];
            }
            if (z2) {
                this.f4976en.f5021v = this.f4992u.fb(ih);
                this.f4976en.f5014a = (-this.f4992u.fb(ih)) + this.f4992u.tl();
                zn znVar3 = this.f4976en;
                znVar3.f5014a = Math.max(znVar3.f5014a, 0);
            } else {
                this.f4976en.f5021v = this.f4992u.gv(ih);
                this.f4976en.f5014a = this.f4992u.gv(ih) - this.f4992u.c5();
            }
            if ((this.f4976en.f5022zn == -1 || this.f4976en.f5022zn > this.f4993ut.size() - 1) && this.f4976en.f5017gv <= getFlexItemCount()) {
                int i8 = i5 - this.f4976en.f5014a;
                this.f4991s8.y();
                if (i8 > 0) {
                    if (f4) {
                        this.f4987q9.gv(this.f4991s8, makeMeasureSpec, makeMeasureSpec2, i8, this.f4976en.f5017gv, this.f4993ut);
                    } else {
                        this.f4987q9.fb(this.f4991s8, makeMeasureSpec, makeMeasureSpec2, i8, this.f4976en.f5017gv, this.f4993ut);
                    }
                    this.f4987q9.p(makeMeasureSpec, makeMeasureSpec2, this.f4976en.f5017gv);
                    this.f4987q9.f7(this.f4976en.f5017gv);
                }
            }
        } else {
            View j4 = j(0);
            if (j4 == null) {
                return;
            }
            this.f4976en.f5021v = this.f4992u.fb(j4);
            int ap3 = ap(j4);
            View eu = eu(j4, this.f4993ut.get(this.f4987q9.f5055zn[ap3]));
            this.f4976en.f5020s = 1;
            int i10 = this.f4987q9.f5055zn[ap3];
            if (i10 == -1) {
                i10 = 0;
            }
            if (i10 <= 0) {
                this.f4976en.f5017gv = -1;
            } else {
                this.f4976en.f5017gv = ap3 - this.f4993ut.get(i10 - 1).n3();
            }
            zn znVar4 = this.f4976en;
            if (i10 > 0) {
                i6 = i10 - 1;
            } else {
                i6 = 0;
            }
            znVar4.f5022zn = i6;
            if (z2) {
                this.f4976en.f5021v = this.f4992u.gv(eu);
                this.f4976en.f5014a = this.f4992u.gv(eu) - this.f4992u.c5();
                zn znVar5 = this.f4976en;
                znVar5.f5014a = Math.max(znVar5.f5014a, 0);
            } else {
                this.f4976en.f5021v = this.f4992u.fb(eu);
                this.f4976en.f5014a = (-this.f4992u.fb(eu)) + this.f4992u.tl();
            }
        }
        zn znVar6 = this.f4976en;
        znVar6.y = i5 - znVar6.f5014a;
    }

    public final void w7() {
        this.f4993ut.clear();
        this.f4980jz.z();
        this.f4980jz.f5009gv = 0;
    }

    public final int wb(View view) {
        return en(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void wm(@NonNull RecyclerView recyclerView, int i, int i5) {
        super.wm(recyclerView, i, i5);
        mf(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int wv(com.google.android.flexbox.y r22, com.google.android.flexbox.FlexboxLayoutManager.zn r23) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.wv(com.google.android.flexbox.y, com.google.android.flexbox.FlexboxLayoutManager$zn):int");
    }

    public final View x0(int i, int i5, int i6) {
        int i8;
        int ap2;
        yh();
        e5();
        int tl2 = this.f4992u.tl();
        int c52 = this.f4992u.c5();
        if (i5 > i) {
            i8 = 1;
        } else {
            i8 = -1;
        }
        View view = null;
        View view2 = null;
        while (i != i5) {
            View j2 = j(i);
            if (j2 != null && (ap2 = ap(j2)) >= 0 && ap2 < i6) {
                if (((RecyclerView.p) j2.getLayoutParams()).zn()) {
                    if (view2 == null) {
                        view2 = j2;
                    }
                } else if (this.f4992u.fb(j2) >= tl2 && this.f4992u.gv(j2) <= c52) {
                    return j2;
                } else {
                    if (view == null) {
                        view = j2;
                    }
                }
            }
            i += i8;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    public final void x2(RecyclerView.fh fhVar, n3 n3Var) {
        if (!jf(fhVar, n3Var, this.f4995xg) && !gm(fhVar, n3Var)) {
            n3Var.mt();
            n3Var.y = 0;
            n3Var.f5010n3 = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean x4() {
        int i;
        if (this.f4971b == 0) {
            return !f();
        }
        if (f()) {
            return true;
        }
        int rs2 = rs();
        View view = this.f4989ra;
        if (view != null) {
            i = view.getHeight();
        } else {
            i = 0;
        }
        if (rs2 > i) {
            return true;
        }
        return false;
    }

    public final int xh(com.google.android.flexbox.y yVar, zn znVar) {
        if (f()) {
            return wv(yVar, znVar);
        }
        return rk(yVar, znVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void xq(int i) {
        this.f4973dm = i;
        this.f4972ct = Integer.MIN_VALUE;
        SavedState savedState = this.f4995xg;
        if (savedState != null) {
            savedState.s();
        }
        hr();
    }

    public int xu() {
        View mq = mq(0, oz(), false);
        if (mq == null) {
            return -1;
        }
        return ap(mq);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d0.n3
    public PointF y(int i) {
        View j2;
        int i5;
        if (oz() == 0 || (j2 = j(0)) == null) {
            return null;
        }
        if (i < ap(j2)) {
            i5 = -1;
        } else {
            i5 = 1;
        }
        if (f()) {
            return new PointF(0.0f, i5);
        }
        return new PointF(i5, 0.0f);
    }

    public final void y0() {
        boolean z2;
        boolean z3;
        boolean z4;
        int nf2 = nf();
        int i = this.f4994x;
        boolean z5 = false;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        this.f4978j = false;
                        this.f4986oz = false;
                        return;
                    }
                    if (nf2 == 1) {
                        z5 = true;
                    }
                    this.f4978j = z5;
                    if (this.f4971b == 2) {
                        this.f4978j = !z5;
                    }
                    this.f4986oz = true;
                    return;
                }
                if (nf2 == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.f4978j = z4;
                if (this.f4971b == 2) {
                    this.f4978j = !z4;
                }
                this.f4986oz = false;
                return;
            }
            if (nf2 != 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f4978j = z3;
            if (this.f4971b == 2) {
                z5 = true;
            }
            this.f4986oz = z5;
            return;
        }
        if (nf2 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f4978j = z2;
        if (this.f4971b == 2) {
            z5 = true;
        }
        this.f4986oz = z5;
    }

    public final void yh() {
        if (this.f4992u != null) {
            return;
        }
        if (f()) {
            if (this.f4971b == 0) {
                this.f4992u = f.y(this);
                this.f4996y5 = f.zn(this);
                return;
            }
            this.f4992u = f.zn(this);
            this.f4996y5 = f.y(this);
        } else if (this.f4971b == 0) {
            this.f4992u = f.zn(this);
            this.f4996y5 = f.y(this);
        } else {
            this.f4992u = f.y(this);
            this.f4996y5 = f.zn(this);
        }
    }

    public final View z8(int i) {
        View x0 = x0(oz() - 1, -1, i);
        if (x0 == null) {
            return null;
        }
        return ih(x0, this.f4993ut.get(this.f4987q9.f5055zn[ap(x0)]));
    }

    @Override // zf.y
    public int zn(int i, int i5, int i6) {
        return RecyclerView.w.ut(g(), u0(), i5, i6, r());
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: v  reason: collision with root package name */
        public int f5006v;
        public int y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean fb(int i) {
            int i5 = this.y;
            if (i5 >= 0 && i5 < i) {
                return true;
            }
            return false;
        }

        public final void s() {
            this.y = -1;
        }

        @NonNull
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.y + ", mAnchorOffset=" + this.f5006v + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.y);
            parcel.writeInt(this.f5006v);
        }

        public SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.y = parcel.readInt();
            this.f5006v = parcel.readInt();
        }

        public SavedState(SavedState savedState) {
            this.y = savedState.y;
            this.f5006v = savedState.f5006v;
        }
    }

    public FlexboxLayoutManager(Context context, int i, int i5) {
        this.f4984o = -1;
        this.f4993ut = new ArrayList();
        this.f4987q9 = new com.google.android.flexbox.n3(this);
        this.f4980jz = new n3();
        this.f4973dm = -1;
        this.f4972ct = Integer.MIN_VALUE;
        this.f4985o4 = Integer.MIN_VALUE;
        this.f4990rs = Integer.MIN_VALUE;
        this.f4982lc = new SparseArray<>();
        this.f4974e = -1;
        this.f4991s8 = new n3.C0056n3();
        t3(i);
        m5(i5);
        t6(4);
        this.f4983nf = context;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.p implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new y();

        /* renamed from: co  reason: collision with root package name */
        public int f4997co;

        /* renamed from: f  reason: collision with root package name */
        public float f4998f;

        /* renamed from: f3  reason: collision with root package name */
        public int f4999f3;

        /* renamed from: n  reason: collision with root package name */
        public boolean f5000n;

        /* renamed from: p  reason: collision with root package name */
        public float f5001p;

        /* renamed from: r  reason: collision with root package name */
        public int f5002r;

        /* renamed from: t  reason: collision with root package name */
        public float f5003t;

        /* renamed from: w  reason: collision with root package name */
        public int f5004w;

        /* renamed from: z  reason: collision with root package name */
        public int f5005z;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5003t = 1.0f;
            this.f5004w = -1;
            this.f5001p = -1.0f;
            this.f5002r = 16777215;
            this.f4999f3 = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int ap() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void d(int i) {
            this.f5005z = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean j() {
            return this.f5000n;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int jz() {
            return this.f5002r;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int l() {
            return this.f5005z;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float mt() {
            return this.f5003t;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int p() {
            return this.f5004w;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int qk() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i) {
            this.f4997co = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int ta() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float ud() {
            return this.f4998f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int vp() {
            return this.f4999f3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.f4998f);
            parcel.writeFloat(this.f5003t);
            parcel.writeInt(this.f5004w);
            parcel.writeFloat(this.f5001p);
            parcel.writeInt(this.f4997co);
            parcel.writeInt(this.f5005z);
            parcel.writeInt(this.f5002r);
            parcel.writeInt(this.f4999f3);
            parcel.writeByte(this.f5000n ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int x4() {
            return this.f4997co;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int yc() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float yt() {
            return this.f5001p;
        }

        public LayoutParams(int i, int i5) {
            super(i, i5);
            this.f5003t = 1.0f;
            this.f5004w = -1;
            this.f5001p = -1.0f;
            this.f5002r = 16777215;
            this.f4999f3 = 16777215;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f5003t = 1.0f;
            this.f5004w = -1;
            this.f5001p = -1.0f;
            this.f5002r = 16777215;
            this.f4999f3 = 16777215;
            this.f4998f = parcel.readFloat();
            this.f5003t = parcel.readFloat();
            this.f5004w = parcel.readInt();
            this.f5001p = parcel.readFloat();
            this.f4997co = parcel.readInt();
            this.f5005z = parcel.readInt();
            this.f5002r = parcel.readInt();
            this.f4999f3 = parcel.readInt();
            this.f5000n = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i5) {
        this.f4984o = -1;
        this.f4993ut = new ArrayList();
        this.f4987q9 = new com.google.android.flexbox.n3(this);
        this.f4980jz = new n3();
        this.f4973dm = -1;
        this.f4972ct = Integer.MIN_VALUE;
        this.f4985o4 = Integer.MIN_VALUE;
        this.f4990rs = Integer.MIN_VALUE;
        this.f4982lc = new SparseArray<>();
        this.f4974e = -1;
        this.f4991s8 = new n3.C0056n3();
        RecyclerView.w.gv yg2 = RecyclerView.w.yg(context, attributeSet, i, i5);
        int i6 = yg2.y;
        if (i6 != 0) {
            if (i6 == 1) {
                if (yg2.f3162zn) {
                    t3(3);
                } else {
                    t3(2);
                }
            }
        } else if (yg2.f3162zn) {
            t3(1);
        } else {
            t3(0);
        }
        m5(1);
        t6(4);
        this.f4983nf = context;
    }
}
