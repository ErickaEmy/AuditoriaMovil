package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.w implements RecyclerView.d0.n3 {

    /* renamed from: b  reason: collision with root package name */
    public zn f3049b;

    /* renamed from: en  reason: collision with root package name */
    public SavedState f3050en;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f3051f7;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3052j;

    /* renamed from: j5  reason: collision with root package name */
    public f f3053j5;

    /* renamed from: jz  reason: collision with root package name */
    public final y f3054jz;

    /* renamed from: k  reason: collision with root package name */
    public int f3055k;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3056o;

    /* renamed from: oz  reason: collision with root package name */
    public boolean f3057oz;

    /* renamed from: q9  reason: collision with root package name */
    public int f3058q9;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f3059qn;

    /* renamed from: u  reason: collision with root package name */
    public final n3 f3060u;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f3061ut;

    /* renamed from: x  reason: collision with root package name */
    public int f3062x;

    /* renamed from: xg  reason: collision with root package name */
    public int[] f3063xg;

    /* renamed from: y5  reason: collision with root package name */
    public int f3064y5;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public boolean f3065fb;

        /* renamed from: v  reason: collision with root package name */
        public int f3066v;
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

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void n3() {
            this.y = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.y);
            parcel.writeInt(this.f3066v);
            parcel.writeInt(this.f3065fb ? 1 : 0);
        }

        public boolean y() {
            if (this.y >= 0) {
                return true;
            }
            return false;
        }

        public SavedState(Parcel parcel) {
            this.y = parcel.readInt();
            this.f3066v = parcel.readInt();
            this.f3065fb = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.y = savedState.y;
            this.f3066v = savedState.f3066v;
            this.f3065fb = savedState.f3065fb;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f3067gv;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f3068n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f3069zn;

        public void y() {
            this.y = 0;
            this.f3068n3 = false;
            this.f3069zn = false;
            this.f3067gv = false;
        }
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f3070gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3071n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f3072v;
        public f y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3073zn;

        public y() {
            v();
        }

        public boolean gv(View view, RecyclerView.fh fhVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (!pVar.zn() && pVar.y() >= 0 && pVar.y() < fhVar.n3()) {
                return true;
            }
            return false;
        }

        public void n3(View view, int i) {
            if (this.f3070gv) {
                this.f3073zn = this.y.gv(view) + this.y.xc();
            } else {
                this.f3073zn = this.y.fb(view);
            }
            this.f3071n3 = i;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3071n3 + ", mCoordinate=" + this.f3073zn + ", mLayoutFromEnd=" + this.f3070gv + ", mValid=" + this.f3072v + '}';
        }

        public void v() {
            this.f3071n3 = -1;
            this.f3073zn = Integer.MIN_VALUE;
            this.f3070gv = false;
            this.f3072v = false;
        }

        public void y() {
            int tl2;
            if (this.f3070gv) {
                tl2 = this.y.c5();
            } else {
                tl2 = this.y.tl();
            }
            this.f3073zn = tl2;
        }

        public void zn(View view, int i) {
            int xc2 = this.y.xc();
            if (xc2 >= 0) {
                n3(view, i);
                return;
            }
            this.f3071n3 = i;
            if (this.f3070gv) {
                int c52 = (this.y.c5() - xc2) - this.y.gv(view);
                this.f3073zn = this.y.c5() - c52;
                if (c52 > 0) {
                    int v2 = this.f3073zn - this.y.v(view);
                    int tl2 = this.y.tl();
                    int min = v2 - (tl2 + Math.min(this.y.fb(view) - tl2, 0));
                    if (min < 0) {
                        this.f3073zn += Math.min(c52, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int fb2 = this.y.fb(view);
            int tl3 = fb2 - this.y.tl();
            this.f3073zn = fb2;
            if (tl3 > 0) {
                int c53 = (this.y.c5() - Math.min(0, (this.y.c5() - xc2) - this.y.gv(view))) - (fb2 + this.y.v(view));
                if (c53 < 0) {
                    this.f3073zn -= Math.min(tl3, -c53);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: a  reason: collision with root package name */
        public int f3074a;

        /* renamed from: c5  reason: collision with root package name */
        public int f3075c5;

        /* renamed from: f  reason: collision with root package name */
        public int f3076f;

        /* renamed from: fb  reason: collision with root package name */
        public int f3077fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f3078gv;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f3079i9;

        /* renamed from: n3  reason: collision with root package name */
        public int f3080n3;

        /* renamed from: s  reason: collision with root package name */
        public int f3081s;

        /* renamed from: t  reason: collision with root package name */
        public List<RecyclerView.ta> f3082t;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f3083tl;

        /* renamed from: v  reason: collision with root package name */
        public int f3084v;
        public boolean y = true;

        /* renamed from: zn  reason: collision with root package name */
        public int f3085zn;

        public View a(View view) {
            int y;
            int size = this.f3082t.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < size; i5++) {
                View view3 = this.f3082t.get(i5).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.zn() && (y = (pVar.y() - this.f3078gv) * this.f3084v) >= 0 && y < i) {
                    view2 = view3;
                    if (y == 0) {
                        break;
                    }
                    i = y;
                }
            }
            return view2;
        }

        public View gv(RecyclerView.i4 i4Var) {
            if (this.f3082t != null) {
                return v();
            }
            View xc2 = i4Var.xc(this.f3078gv);
            this.f3078gv += this.f3084v;
            return xc2;
        }

        public void n3(View view) {
            View a2 = a(view);
            if (a2 == null) {
                this.f3078gv = -1;
            } else {
                this.f3078gv = ((RecyclerView.p) a2.getLayoutParams()).y();
            }
        }

        public final View v() {
            int size = this.f3082t.size();
            for (int i = 0; i < size; i++) {
                View view = this.f3082t.get(i).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.zn() && this.f3078gv == pVar.y()) {
                    n3(view);
                    return view;
                }
            }
            return null;
        }

        public void y() {
            n3(null);
        }

        public boolean zn(RecyclerView.fh fhVar) {
            int i = this.f3078gv;
            if (i >= 0 && i < fhVar.n3()) {
                return true;
            }
            return false;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private View ez() {
        int i;
        if (this.f3052j) {
            i = oz() - 1;
        } else {
            i = 0;
        }
        return j(i);
    }

    private int ks(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        sh();
        return wz.zn(fhVar, this.f3053j5, l3(!this.f3061ut, true), vi(!this.f3061ut, true), this, this.f3061ut);
    }

    private int mq(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar, boolean z2) {
        int c52;
        int c53 = this.f3053j5.c5() - i;
        if (c53 > 0) {
            int i5 = -cp(-c53, i4Var, fhVar);
            int i6 = i + i5;
            if (z2 && (c52 = this.f3053j5.c5() - i6) > 0) {
                this.f3053j5.mt(c52);
                return c52 + i5;
            }
            return i5;
        }
        return 0;
    }

    private int rt(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        sh();
        return wz.n3(fhVar, this.f3053j5, l3(!this.f3061ut, true), vi(!this.f3061ut, true), this, this.f3061ut, this.f3052j);
    }

    private int t5(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        sh();
        return wz.y(fhVar, this.f3053j5, l3(!this.f3061ut, true), vi(!this.f3061ut, true), this, this.f3061ut);
    }

    private int x0(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar, boolean z2) {
        int tl2;
        int tl3 = i - this.f3053j5.tl();
        if (tl3 > 0) {
            int i5 = -cp(tl3, i4Var, fhVar);
            int i6 = i + i5;
            if (z2 && (tl2 = i6 - this.f3053j5.tl()) > 0) {
                this.f3053j5.mt(-tl2);
                return i5 - tl2;
            }
            return i5;
        }
        return 0;
    }

    private void xh(RecyclerView.i4 i4Var, int i, int i5) {
        if (i == i5) {
            return;
        }
        if (i5 > i) {
            for (int i6 = i5 - 1; i6 >= i; i6--) {
                gn(i6, i4Var);
            }
            return;
        }
        while (i > i5) {
            gn(i, i4Var);
            i--;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void bv(RecyclerView.fh fhVar) {
        super.bv(fhVar);
        this.f3050en = null;
        this.f3058q9 = -1;
        this.f3055k = Integer.MIN_VALUE;
        this.f3054jz.v();
    }

    public boolean bx() {
        if (this.f3053j5.f() == 0 && this.f3053j5.s() == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void c(int i, RecyclerView.w.zn znVar) {
        boolean z2;
        int i5;
        SavedState savedState = this.f3050en;
        int i6 = -1;
        if (savedState != null && savedState.y()) {
            SavedState savedState2 = this.f3050en;
            z2 = savedState2.f3065fb;
            i5 = savedState2.y;
        } else {
            ja();
            z2 = this.f3052j;
            i5 = this.f3058q9;
            if (i5 == -1) {
                i5 = z2 ? i - 1 : 0;
            }
        }
        if (!z2) {
            i6 = 1;
        }
        for (int i8 = 0; i8 < this.f3064y5 && i5 >= 0 && i5 < i; i8++) {
            znVar.y(i5, 0);
            i5 += i6;
        }
    }

    public int cp(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        int i5;
        if (oz() == 0 || i == 0) {
            return 0;
        }
        sh();
        this.f3049b.y = true;
        if (i > 0) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        int abs = Math.abs(i);
        jf(i5, abs, true, fhVar);
        zn znVar = this.f3049b;
        int hf = znVar.f3077fb + hf(i4Var, znVar, fhVar, false);
        if (hf < 0) {
            return 0;
        }
        if (abs > hf) {
            i = i5 * hf;
        }
        this.f3053j5.mt(-i);
        this.f3049b.f3076f = i;
        return i;
    }

    public final void cw(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, int i, int i5) {
        boolean z2;
        if (fhVar.fb() && oz() != 0 && !fhVar.v() && sx()) {
            List<RecyclerView.ta> f4 = i4Var.f();
            int size = f4.size();
            int ap2 = ap(j(0));
            int i6 = 0;
            int i8 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                RecyclerView.ta taVar = f4.get(i10);
                if (!taVar.isRemoved()) {
                    if (taVar.getLayoutPosition() < ap2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != this.f3052j) {
                        i6 += this.f3053j5.v(taVar.itemView);
                    } else {
                        i8 += this.f3053j5.v(taVar.itemView);
                    }
                }
            }
            this.f3049b.f3082t = f4;
            if (i6 > 0) {
                fm(ap(ez()), i);
                zn znVar = this.f3049b;
                znVar.f3081s = i6;
                znVar.f3085zn = 0;
                znVar.y();
                hf(i4Var, this.f3049b, fhVar, false);
            }
            if (i8 > 0) {
                x2(ap(mc()), i5);
                zn znVar2 = this.f3049b;
                znVar2.f3081s = i8;
                znVar2.f3085zn = 0;
                znVar2.y();
                hf(i4Var, this.f3049b, fhVar, false);
            }
            this.f3049b.f3082t = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int d(RecyclerView.fh fhVar) {
        return ks(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int d0(RecyclerView.fh fhVar) {
        return t5(fhVar);
    }

    public int e5() {
        View xu = xu(0, oz(), false, true);
        if (xu == null) {
            return -1;
        }
        return ap(xu);
    }

    public View eu(int i, int i5) {
        int i6;
        int i8;
        sh();
        if (i5 > i || i5 < i) {
            if (this.f3053j5.fb(j(i)) < this.f3053j5.tl()) {
                i6 = 16644;
                i8 = 16388;
            } else {
                i6 = 4161;
                i8 = 4097;
            }
            if (this.f3062x == 0) {
                return this.f3148f.y(i, i5, i6, i8);
            }
            return this.f3156t.y(i, i5, i6, i8);
        }
        return j(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int fh(RecyclerView.fh fhVar) {
        return rt(fhVar);
    }

    public final void fm(int i, int i5) {
        int i6;
        this.f3049b.f3085zn = i5 - this.f3053j5.tl();
        zn znVar = this.f3049b;
        znVar.f3078gv = i;
        if (this.f3052j) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        znVar.f3084v = i6;
        znVar.f3074a = -1;
        znVar.f3080n3 = i5;
        znVar.f3077fb = Integer.MIN_VALUE;
    }

    public int fp(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i == 130 && this.f3062x == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.f3062x == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.f3062x == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f3062x == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f3062x != 1 && t7()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.f3062x == 1 || !t7()) {
            return -1;
        } else {
            return 1;
        }
    }

    public void gd(int i, int i5) {
        this.f3058q9 = i;
        this.f3055k = i5;
        SavedState savedState = this.f3050en;
        if (savedState != null) {
            savedState.n3();
        }
        hr();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void gf(RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        int i;
        int i5;
        int i6;
        int i8;
        int i10;
        int mq;
        int i11;
        View yt2;
        int fb2;
        int i12;
        int i13 = -1;
        if ((this.f3050en != null || this.f3058q9 != -1) && fhVar.n3() == 0) {
            hk(i4Var);
            return;
        }
        SavedState savedState = this.f3050en;
        if (savedState != null && savedState.y()) {
            this.f3058q9 = this.f3050en.y;
        }
        sh();
        this.f3049b.y = false;
        ja();
        View o42 = o4();
        y yVar = this.f3054jz;
        if (yVar.f3072v && this.f3058q9 == -1 && this.f3050en == null) {
            if (o42 != null && (this.f3053j5.fb(o42) >= this.f3053j5.c5() || this.f3053j5.gv(o42) <= this.f3053j5.tl())) {
                this.f3054jz.zn(o42, ap(o42));
            }
        } else {
            yVar.v();
            y yVar2 = this.f3054jz;
            yVar2.f3070gv = this.f3052j ^ this.f3057oz;
            gm(i4Var, fhVar, yVar2);
            this.f3054jz.f3072v = true;
        }
        zn znVar = this.f3049b;
        if (znVar.f3076f >= 0) {
            i = 1;
        } else {
            i = -1;
        }
        znVar.f3074a = i;
        int[] iArr = this.f3063xg;
        iArr[0] = 0;
        iArr[1] = 0;
        ux(fhVar, iArr);
        int max = Math.max(0, this.f3063xg[0]) + this.f3053j5.tl();
        int max2 = Math.max(0, this.f3063xg[1]) + this.f3053j5.i9();
        if (fhVar.v() && (i11 = this.f3058q9) != -1 && this.f3055k != Integer.MIN_VALUE && (yt2 = yt(i11)) != null) {
            if (this.f3052j) {
                i12 = this.f3053j5.c5() - this.f3053j5.gv(yt2);
                fb2 = this.f3055k;
            } else {
                fb2 = this.f3053j5.fb(yt2) - this.f3053j5.tl();
                i12 = this.f3055k;
            }
            int i14 = i12 - fb2;
            if (i14 > 0) {
                max += i14;
            } else {
                max2 -= i14;
            }
        }
        y yVar3 = this.f3054jz;
        if (!yVar3.f3070gv ? !this.f3052j : this.f3052j) {
            i13 = 1;
        }
        nz(i4Var, fhVar, yVar3, i13);
        z6(i4Var);
        this.f3049b.f3083tl = bx();
        this.f3049b.f3079i9 = fhVar.v();
        this.f3049b.f3075c5 = 0;
        y yVar4 = this.f3054jz;
        if (yVar4.f3070gv) {
            w5(yVar4);
            zn znVar2 = this.f3049b;
            znVar2.f3081s = max;
            hf(i4Var, znVar2, fhVar, false);
            zn znVar3 = this.f3049b;
            i6 = znVar3.f3080n3;
            int i15 = znVar3.f3078gv;
            int i16 = znVar3.f3085zn;
            if (i16 > 0) {
                max2 += i16;
            }
            mf(this.f3054jz);
            zn znVar4 = this.f3049b;
            znVar4.f3081s = max2;
            znVar4.f3078gv += znVar4.f3084v;
            hf(i4Var, znVar4, fhVar, false);
            zn znVar5 = this.f3049b;
            i5 = znVar5.f3080n3;
            int i17 = znVar5.f3085zn;
            if (i17 > 0) {
                fm(i15, i6);
                zn znVar6 = this.f3049b;
                znVar6.f3081s = i17;
                hf(i4Var, znVar6, fhVar, false);
                i6 = this.f3049b.f3080n3;
            }
        } else {
            mf(yVar4);
            zn znVar7 = this.f3049b;
            znVar7.f3081s = max2;
            hf(i4Var, znVar7, fhVar, false);
            zn znVar8 = this.f3049b;
            i5 = znVar8.f3080n3;
            int i18 = znVar8.f3078gv;
            int i19 = znVar8.f3085zn;
            if (i19 > 0) {
                max += i19;
            }
            w5(this.f3054jz);
            zn znVar9 = this.f3049b;
            znVar9.f3081s = max;
            znVar9.f3078gv += znVar9.f3084v;
            hf(i4Var, znVar9, fhVar, false);
            zn znVar10 = this.f3049b;
            i6 = znVar10.f3080n3;
            int i20 = znVar10.f3085zn;
            if (i20 > 0) {
                x2(i18, i5);
                zn znVar11 = this.f3049b;
                znVar11.f3081s = i20;
                hf(i4Var, znVar11, fhVar, false);
                i5 = this.f3049b.f3080n3;
            }
        }
        if (oz() > 0) {
            if (this.f3052j ^ this.f3057oz) {
                int mq2 = mq(i5, i4Var, fhVar, true);
                i8 = i6 + mq2;
                i10 = i5 + mq2;
                mq = x0(i8, i4Var, fhVar, false);
            } else {
                int x0 = x0(i6, i4Var, fhVar, true);
                i8 = i6 + x0;
                i10 = i5 + x0;
                mq = mq(i10, i4Var, fhVar, false);
            }
            i6 = i8 + mq;
            i5 = i10 + mq;
        }
        cw(i4Var, fhVar, i6, i5);
        if (!fhVar.v()) {
            this.f3053j5.co();
        } else {
            this.f3054jz.v();
        }
        this.f3059qn = this.f3057oz;
    }

    public final void gm(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, y yVar) {
        int i;
        if (op(fhVar, yVar) || m5(i4Var, fhVar, yVar)) {
            return;
        }
        yVar.y();
        if (this.f3057oz) {
            i = fhVar.n3() - 1;
        } else {
            i = 0;
        }
        yVar.f3071n3 = i;
    }

    public int hf(RecyclerView.i4 i4Var, zn znVar, RecyclerView.fh fhVar, boolean z2) {
        int i = znVar.f3085zn;
        int i5 = znVar.f3077fb;
        if (i5 != Integer.MIN_VALUE) {
            if (i < 0) {
                znVar.f3077fb = i5 + i;
            }
            l8(i4Var, znVar);
        }
        int i6 = znVar.f3085zn + znVar.f3081s;
        n3 n3Var = this.f3060u;
        while (true) {
            if ((!znVar.f3083tl && i6 <= 0) || !znVar.zn(fhVar)) {
                break;
            }
            n3Var.y();
            iu(i4Var, fhVar, znVar, n3Var);
            if (!n3Var.f3068n3) {
                znVar.f3080n3 += n3Var.y * znVar.f3074a;
                if (!n3Var.f3069zn || znVar.f3082t != null || !fhVar.v()) {
                    int i8 = znVar.f3085zn;
                    int i10 = n3Var.y;
                    znVar.f3085zn = i8 - i10;
                    i6 -= i10;
                }
                int i11 = znVar.f3077fb;
                if (i11 != Integer.MIN_VALUE) {
                    int i12 = i11 + n3Var.y;
                    znVar.f3077fb = i12;
                    int i13 = znVar.f3085zn;
                    if (i13 < 0) {
                        znVar.f3077fb = i12 + i13;
                    }
                    l8(i4Var, znVar);
                }
                if (z2 && n3Var.f3067gv) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - znVar.f3085zn;
    }

    public zn hj() {
        return new zn();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int hy(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        if (this.f3062x == 1) {
            return 0;
        }
        return cp(i, i4Var, fhVar);
    }

    public int i1() {
        View xu = xu(oz() - 1, -1, false, true);
        if (xu == null) {
            return -1;
        }
        return ap(xu);
    }

    public final View ih() {
        if (this.f3052j) {
            return nh();
        }
        return ou();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void im(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f3050en = savedState;
            if (this.f3058q9 != -1) {
                savedState.n3();
            }
            hr();
        }
    }

    public void iu(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, zn znVar, n3 n3Var) {
        boolean z2;
        int i;
        int i5;
        int i6;
        int i8;
        int a2;
        boolean z3;
        View gv2 = znVar.gv(i4Var);
        if (gv2 == null) {
            n3Var.f3068n3 = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) gv2.getLayoutParams();
        if (znVar.f3082t == null) {
            boolean z4 = this.f3052j;
            if (znVar.f3074a == -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z4 == z3) {
                wz(gv2);
            } else {
                xc(gv2, 0);
            }
        } else {
            boolean z5 = this.f3052j;
            if (znVar.f3074a == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z5 == z2) {
                t(gv2);
            } else {
                tl(gv2, 0);
            }
        }
        qj(gv2, 0, 0);
        n3Var.y = this.f3053j5.v(gv2);
        if (this.f3062x == 1) {
            if (t7()) {
                a2 = g() - getPaddingRight();
                i8 = a2 - this.f3053j5.a(gv2);
            } else {
                i8 = getPaddingLeft();
                a2 = this.f3053j5.a(gv2) + i8;
            }
            if (znVar.f3074a == -1) {
                int i10 = znVar.f3080n3;
                i6 = i10;
                i5 = a2;
                i = i10 - n3Var.y;
            } else {
                int i11 = znVar.f3080n3;
                i = i11;
                i5 = a2;
                i6 = n3Var.y + i11;
            }
        } else {
            int paddingTop = getPaddingTop();
            int a3 = this.f3053j5.a(gv2) + paddingTop;
            if (znVar.f3074a == -1) {
                int i12 = znVar.f3080n3;
                i5 = i12;
                i = paddingTop;
                i6 = a3;
                i8 = i12 - n3Var.y;
            } else {
                int i13 = znVar.f3080n3;
                i = paddingTop;
                i5 = n3Var.y + i13;
                i6 = a3;
                i8 = i13;
            }
        }
        qk(gv2, i8, i, i5, i6);
        if (pVar.zn() || pVar.n3()) {
            n3Var.f3069zn = true;
        }
        n3Var.f3067gv = gv2.hasFocusable();
    }

    public int j4() {
        return this.f3062x;
    }

    public final void ja() {
        if (this.f3062x != 1 && t7()) {
            this.f3052j = !this.f3056o;
        } else {
            this.f3052j = this.f3056o;
        }
    }

    public final void jf(int i, int i5, boolean z2, RecyclerView.fh fhVar) {
        int i6;
        int tl2;
        this.f3049b.f3083tl = bx();
        this.f3049b.f3074a = i;
        int[] iArr = this.f3063xg;
        boolean z3 = false;
        iArr[0] = 0;
        int i8 = 1;
        iArr[1] = 0;
        ux(fhVar, iArr);
        int max = Math.max(0, this.f3063xg[0]);
        int max2 = Math.max(0, this.f3063xg[1]);
        if (i == 1) {
            z3 = true;
        }
        zn znVar = this.f3049b;
        if (z3) {
            i6 = max2;
        } else {
            i6 = max;
        }
        znVar.f3081s = i6;
        if (!z3) {
            max = max2;
        }
        znVar.f3075c5 = max;
        if (z3) {
            znVar.f3081s = i6 + this.f3053j5.i9();
            View mc2 = mc();
            zn znVar2 = this.f3049b;
            if (this.f3052j) {
                i8 = -1;
            }
            znVar2.f3084v = i8;
            int ap2 = ap(mc2);
            zn znVar3 = this.f3049b;
            znVar2.f3078gv = ap2 + znVar3.f3084v;
            znVar3.f3080n3 = this.f3053j5.gv(mc2);
            tl2 = this.f3053j5.gv(mc2) - this.f3053j5.c5();
        } else {
            View ez = ez();
            this.f3049b.f3081s += this.f3053j5.tl();
            zn znVar4 = this.f3049b;
            if (!this.f3052j) {
                i8 = -1;
            }
            znVar4.f3084v = i8;
            int ap3 = ap(ez);
            zn znVar5 = this.f3049b;
            znVar4.f3078gv = ap3 + znVar5.f3084v;
            znVar5.f3080n3 = this.f3053j5.fb(ez);
            tl2 = (-this.f3053j5.fb(ez)) + this.f3053j5.tl();
        }
        zn znVar6 = this.f3049b;
        znVar6.f3085zn = i5;
        if (z2) {
            znVar6.f3085zn = i5 - tl2;
        }
        znVar6.f3077fb = tl2;
    }

    public View jm(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, boolean z2, boolean z3) {
        int i;
        int i5;
        int i6;
        boolean z4;
        boolean z5;
        sh();
        int oz2 = oz();
        if (z3) {
            i5 = oz() - 1;
            i = -1;
            i6 = -1;
        } else {
            i = oz2;
            i5 = 0;
            i6 = 1;
        }
        int n32 = fhVar.n3();
        int tl2 = this.f3053j5.tl();
        int c52 = this.f3053j5.c5();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i5 != i) {
            View j2 = j(i5);
            int ap2 = ap(j2);
            int fb2 = this.f3053j5.fb(j2);
            int gv2 = this.f3053j5.gv(j2);
            if (ap2 >= 0 && ap2 < n32) {
                if (((RecyclerView.p) j2.getLayoutParams()).zn()) {
                    if (view3 == null) {
                        view3 = j2;
                    }
                } else {
                    if (gv2 <= tl2 && fb2 < tl2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (fb2 >= c52 && gv2 > c52) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z4 && !z5) {
                        return j2;
                    }
                    if (z2) {
                        if (!z5) {
                            if (view != null) {
                            }
                            view = j2;
                        }
                        view2 = j2;
                    } else {
                        if (!z4) {
                            if (view != null) {
                            }
                            view = j2;
                        }
                        view2 = j2;
                    }
                }
            }
            i5 += i6;
        }
        if (view == null) {
            if (view2 != null) {
                return view2;
            }
            return view3;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int jt(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        if (this.f3062x == 0) {
            return 0;
        }
        return cp(i, i4Var, fhVar);
    }

    public View l3(boolean z2, boolean z3) {
        if (this.f3052j) {
            return xu(oz() - 1, -1, z2, z3);
        }
        return xu(0, oz(), z2, z3);
    }

    public final void l8(RecyclerView.i4 i4Var, zn znVar) {
        if (znVar.y && !znVar.f3083tl) {
            int i = znVar.f3077fb;
            int i5 = znVar.f3075c5;
            if (znVar.f3074a == -1) {
                wv(i4Var, i, i5);
            } else {
                rk(i4Var, i, i5);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void le(AccessibilityEvent accessibilityEvent) {
        super.le(accessibilityEvent);
        if (oz() > 0) {
            accessibilityEvent.setFromIndex(e5());
            accessibilityEvent.setToIndex(i1());
        }
    }

    public final boolean m5(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, y yVar) {
        View jm;
        boolean z2;
        boolean z3 = false;
        if (oz() == 0) {
            return false;
        }
        View o42 = o4();
        if (o42 != null && yVar.gv(o42, fhVar)) {
            yVar.zn(o42, ap(o42));
            return true;
        }
        boolean z4 = this.f3059qn;
        boolean z5 = this.f3057oz;
        if (z4 != z5 || (jm = jm(i4Var, fhVar, yVar.f3070gv, z5)) == null) {
            return false;
        }
        yVar.n3(jm, ap(jm));
        if (!fhVar.v() && sx()) {
            int fb2 = this.f3053j5.fb(jm);
            int gv2 = this.f3053j5.gv(jm);
            int tl2 = this.f3053j5.tl();
            int c52 = this.f3053j5.c5();
            if (gv2 <= tl2 && fb2 < tl2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (fb2 >= c52 && gv2 > c52) {
                z3 = true;
            }
            if (z2 || z3) {
                if (yVar.f3070gv) {
                    tl2 = c52;
                }
                yVar.f3073zn = tl2;
            }
        }
        return true;
    }

    public final View mc() {
        int oz2;
        if (this.f3052j) {
            oz2 = 0;
        } else {
            oz2 = oz() - 1;
        }
        return j(oz2);
    }

    public final void mf(y yVar) {
        x2(yVar.f3071n3, yVar.f3073zn);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int mg(RecyclerView.fh fhVar) {
        return t5(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public Parcelable mh() {
        if (this.f3050en != null) {
            return new SavedState(this.f3050en);
        }
        SavedState savedState = new SavedState();
        if (oz() > 0) {
            sh();
            boolean z2 = this.f3059qn ^ this.f3052j;
            savedState.f3065fb = z2;
            if (z2) {
                View mc2 = mc();
                savedState.f3066v = this.f3053j5.c5() - this.f3053j5.gv(mc2);
                savedState.y = ap(mc2);
            } else {
                View ez = ez();
                savedState.y = ap(ez);
                savedState.f3066v = this.f3053j5.fb(ez) - this.f3053j5.tl();
            }
        } else {
            savedState.n3();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public View mp(View view, int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        int fp;
        View z8;
        View mc2;
        ja();
        if (oz() == 0 || (fp = fp(i)) == Integer.MIN_VALUE) {
            return null;
        }
        sh();
        jf(fp, (int) (this.f3053j5.wz() * 0.33333334f), false, fhVar);
        zn znVar = this.f3049b;
        znVar.f3077fb = Integer.MIN_VALUE;
        znVar.y = false;
        hf(i4Var, znVar, fhVar, true);
        if (fp == -1) {
            z8 = ih();
        } else {
            z8 = z8();
        }
        if (fp == -1) {
            mc2 = ez();
        } else {
            mc2 = mc();
        }
        if (mc2.hasFocusable()) {
            if (z8 == null) {
                return null;
            }
            return mc2;
        }
        return z8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void n(int i, int i5, RecyclerView.fh fhVar, RecyclerView.w.zn znVar) {
        int i6;
        if (this.f3062x != 0) {
            i = i5;
        }
        if (oz() != 0 && i != 0) {
            sh();
            if (i > 0) {
                i6 = 1;
            } else {
                i6 = -1;
            }
            jf(i6, Math.abs(i), true, fhVar);
            vd(fhVar, this.f3049b, znVar);
        }
    }

    public void ng(int i) {
        this.f3064y5 = i;
    }

    public final View nh() {
        return eu(oz() - 1, -1);
    }

    public void nz(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, y yVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void ob(RecyclerView recyclerView, RecyclerView.fh fhVar, int i) {
        s sVar = new s(recyclerView.getContext());
        sVar.w(i);
        vb(sVar);
    }

    public final boolean op(RecyclerView.fh fhVar, y yVar) {
        int i;
        boolean z2;
        int fb2;
        boolean z3 = false;
        if (!fhVar.v() && (i = this.f3058q9) != -1) {
            if (i >= 0 && i < fhVar.n3()) {
                yVar.f3071n3 = this.f3058q9;
                SavedState savedState = this.f3050en;
                if (savedState != null && savedState.y()) {
                    boolean z4 = this.f3050en.f3065fb;
                    yVar.f3070gv = z4;
                    if (z4) {
                        yVar.f3073zn = this.f3053j5.c5() - this.f3050en.f3066v;
                    } else {
                        yVar.f3073zn = this.f3053j5.tl() + this.f3050en.f3066v;
                    }
                    return true;
                } else if (this.f3055k == Integer.MIN_VALUE) {
                    View yt2 = yt(this.f3058q9);
                    if (yt2 != null) {
                        if (this.f3053j5.v(yt2) > this.f3053j5.wz()) {
                            yVar.y();
                            return true;
                        } else if (this.f3053j5.fb(yt2) - this.f3053j5.tl() < 0) {
                            yVar.f3073zn = this.f3053j5.tl();
                            yVar.f3070gv = false;
                            return true;
                        } else if (this.f3053j5.c5() - this.f3053j5.gv(yt2) < 0) {
                            yVar.f3073zn = this.f3053j5.c5();
                            yVar.f3070gv = true;
                            return true;
                        } else {
                            if (yVar.f3070gv) {
                                fb2 = this.f3053j5.gv(yt2) + this.f3053j5.xc();
                            } else {
                                fb2 = this.f3053j5.fb(yt2);
                            }
                            yVar.f3073zn = fb2;
                        }
                    } else {
                        if (oz() > 0) {
                            if (this.f3058q9 < ap(j(0))) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2 == this.f3052j) {
                                z3 = true;
                            }
                            yVar.f3070gv = z3;
                        }
                        yVar.y();
                    }
                    return true;
                } else {
                    boolean z5 = this.f3052j;
                    yVar.f3070gv = z5;
                    if (z5) {
                        yVar.f3073zn = this.f3053j5.c5() - this.f3055k;
                    } else {
                        yVar.f3073zn = this.f3053j5.tl() + this.f3055k;
                    }
                    return true;
                }
            }
            this.f3058q9 = -1;
            this.f3055k = Integer.MIN_VALUE;
        }
        return false;
    }

    public final View ou() {
        return eu(0, oz());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void p(String str) {
        if (this.f3050en == null) {
            super.p(str);
        }
    }

    public boolean p2() {
        return this.f3061ut;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void q5(RecyclerView recyclerView, RecyclerView.i4 i4Var) {
        super.q5(recyclerView, i4Var);
        if (this.f3051f7) {
            hk(i4Var);
            i4Var.zn();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean r() {
        if (this.f3062x == 0) {
            return true;
        }
        return false;
    }

    public final void rk(RecyclerView.i4 i4Var, int i, int i5) {
        if (i < 0) {
            return;
        }
        int i6 = i - i5;
        int oz2 = oz();
        if (this.f3052j) {
            int i8 = oz2 - 1;
            for (int i10 = i8; i10 >= 0; i10--) {
                View j2 = j(i10);
                if (this.f3053j5.gv(j2) > i6 || this.f3053j5.w(j2) > i6) {
                    xh(i4Var, i8, i10);
                    return;
                }
            }
            return;
        }
        for (int i11 = 0; i11 < oz2; i11++) {
            View j4 = j(i11);
            if (this.f3053j5.gv(j4) > i6 || this.f3053j5.w(j4) > i6) {
                xh(i4Var, 0, i11);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int rz(RecyclerView.fh fhVar) {
        return ks(fhVar);
    }

    public void sh() {
        if (this.f3049b == null) {
            this.f3049b = hj();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean sx() {
        if (this.f3050en == null && this.f3059qn == this.f3057oz) {
            return true;
        }
        return false;
    }

    public void t3(boolean z2) {
        p(null);
        if (this.f3057oz == z2) {
            return;
        }
        this.f3057oz = z2;
        hr();
    }

    public void t6(boolean z2) {
        p(null);
        if (z2 == this.f3056o) {
            return;
        }
        this.f3056o = z2;
        hr();
    }

    public boolean t7() {
        if (nf() == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int ta(RecyclerView.fh fhVar) {
        return rt(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean tg() {
        return true;
    }

    public void ux(@NonNull RecyclerView.fh fhVar, @NonNull int[] iArr) {
        int i;
        int wb = wb(fhVar);
        if (this.f3049b.f3074a == -1) {
            i = 0;
        } else {
            i = wb;
            wb = 0;
        }
        iArr[0] = wb;
        iArr[1] = i;
    }

    public void vd(RecyclerView.fh fhVar, zn znVar, RecyclerView.w.zn znVar2) {
        int i = znVar.f3078gv;
        if (i >= 0 && i < fhVar.n3()) {
            znVar2.y(i, Math.max(0, znVar.f3077fb));
        }
    }

    public View vi(boolean z2, boolean z3) {
        if (this.f3052j) {
            return xu(0, oz(), z2, z3);
        }
        return xu(oz() - 1, -1, z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p vl() {
        return new RecyclerView.p(-2, -2);
    }

    public final void w5(y yVar) {
        fm(yVar.f3071n3, yVar.f3073zn);
    }

    public int w7() {
        View xu = xu(0, oz(), true, false);
        if (xu == null) {
            return -1;
        }
        return ap(xu);
    }

    @Deprecated
    public int wb(RecyclerView.fh fhVar) {
        if (fhVar.gv()) {
            return this.f3053j5.wz();
        }
        return 0;
    }

    public final void wv(RecyclerView.i4 i4Var, int i, int i5) {
        int oz2 = oz();
        if (i < 0) {
            return;
        }
        int s2 = (this.f3053j5.s() - i) + i5;
        if (this.f3052j) {
            for (int i6 = 0; i6 < oz2; i6++) {
                View j2 = j(i6);
                if (this.f3053j5.fb(j2) < s2 || this.f3053j5.p(j2) < s2) {
                    xh(i4Var, 0, i6);
                    return;
                }
            }
            return;
        }
        int i8 = oz2 - 1;
        for (int i10 = i8; i10 >= 0; i10--) {
            View j4 = j(i10);
            if (this.f3053j5.fb(j4) < s2 || this.f3053j5.p(j4) < s2) {
                xh(i4Var, i8, i10);
                return;
            }
        }
    }

    public final void x2(int i, int i5) {
        int i6;
        this.f3049b.f3085zn = this.f3053j5.c5() - i5;
        zn znVar = this.f3049b;
        if (this.f3052j) {
            i6 = -1;
        } else {
            i6 = 1;
        }
        znVar.f3084v = i6;
        znVar.f3078gv = i;
        znVar.f3074a = 1;
        znVar.f3080n3 = i5;
        znVar.f3077fb = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean x4() {
        if (this.f3062x == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void xq(int i) {
        this.f3058q9 = i;
        this.f3055k = Integer.MIN_VALUE;
        SavedState savedState = this.f3050en;
        if (savedState != null) {
            savedState.n3();
        }
        hr();
    }

    public View xu(int i, int i5, boolean z2, boolean z3) {
        int i6;
        sh();
        int i8 = 320;
        if (z2) {
            i6 = 24579;
        } else {
            i6 = 320;
        }
        if (!z3) {
            i8 = 0;
        }
        if (this.f3062x == 0) {
            return this.f3148f.y(i, i5, i6, i8);
        }
        return this.f3156t.y(i, i5, i6, i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d0.n3
    public PointF y(int i) {
        if (oz() == 0) {
            return null;
        }
        boolean z2 = false;
        int i5 = 1;
        if (i < ap(j(0))) {
            z2 = true;
        }
        if (z2 != this.f3052j) {
            i5 = -1;
        }
        if (this.f3062x == 0) {
            return new PointF(i5, 0.0f);
        }
        return new PointF(0.0f, i5);
    }

    public void y0(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        p(null);
        if (i != this.f3062x || this.f3053j5 == null) {
            f n32 = f.n3(this, i);
            this.f3053j5 = n32;
            this.f3054jz.y = n32;
            this.f3062x = i;
            hr();
        }
    }

    public int yh() {
        View xu = xu(oz() - 1, -1, true, false);
        if (xu == null) {
            return -1;
        }
        return ap(xu);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public View yt(int i) {
        int oz2 = oz();
        if (oz2 == 0) {
            return null;
        }
        int ap2 = i - ap(j(0));
        if (ap2 >= 0 && ap2 < oz2) {
            View j2 = j(ap2);
            if (ap(j2) == i) {
                return j2;
            }
        }
        return super.yt(i);
    }

    public final View z8() {
        if (this.f3052j) {
            return ou();
        }
        return nh();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean zh() {
        if (eb() != 1073741824 && u0() != 1073741824 && bk()) {
            return true;
        }
        return false;
    }

    public LinearLayoutManager(Context context, int i, boolean z2) {
        this.f3062x = 1;
        this.f3061ut = true;
        this.f3058q9 = -1;
        this.f3055k = Integer.MIN_VALUE;
        this.f3054jz = new y();
        this.f3060u = new n3();
        this.f3064y5 = 2;
        this.f3063xg = new int[2];
        y0(i);
        t6(z2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i5) {
        this.f3062x = 1;
        this.f3061ut = true;
        this.f3058q9 = -1;
        this.f3055k = Integer.MIN_VALUE;
        this.f3054jz = new y();
        this.f3060u = new n3();
        this.f3064y5 = 2;
        this.f3063xg = new int[2];
        RecyclerView.w.gv yg2 = RecyclerView.w.yg(context, attributeSet, i, i5);
        y0(yg2.y);
        t6(yg2.f3162zn);
        t3(yg2.f3160gv);
    }
}
