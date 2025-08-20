package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.w implements RecyclerView.d0.n3 {

    /* renamed from: b  reason: collision with root package name */
    public gv[] f3167b;

    /* renamed from: ct  reason: collision with root package name */
    public int f3168ct;

    /* renamed from: dm  reason: collision with root package name */
    public SavedState f3169dm;

    /* renamed from: j  reason: collision with root package name */
    public int f3173j;
    @NonNull

    /* renamed from: j5  reason: collision with root package name */
    public f f3174j5;

    /* renamed from: k  reason: collision with root package name */
    public BitSet f3176k;

    /* renamed from: nf  reason: collision with root package name */
    public int[] f3178nf;

    /* renamed from: o  reason: collision with root package name */
    public int f3179o;
    @NonNull

    /* renamed from: oz  reason: collision with root package name */
    public final fb f3181oz;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f3182q9;
    @NonNull

    /* renamed from: qn  reason: collision with root package name */
    public f f3183qn;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f3187ut;

    /* renamed from: xg  reason: collision with root package name */
    public boolean f3189xg;

    /* renamed from: y5  reason: collision with root package name */
    public boolean f3190y5;

    /* renamed from: x  reason: collision with root package name */
    public int f3188x = -1;

    /* renamed from: f7  reason: collision with root package name */
    public int f3172f7 = -1;

    /* renamed from: en  reason: collision with root package name */
    public int f3171en = Integer.MIN_VALUE;

    /* renamed from: jz  reason: collision with root package name */
    public LazySpanLookup f3175jz = new LazySpanLookup();

    /* renamed from: u  reason: collision with root package name */
    public int f3186u = 2;

    /* renamed from: o4  reason: collision with root package name */
    public final Rect f3180o4 = new Rect();

    /* renamed from: rs  reason: collision with root package name */
    public final n3 f3185rs = new n3();

    /* renamed from: eb  reason: collision with root package name */
    public boolean f3170eb = false;

    /* renamed from: lc  reason: collision with root package name */
    public boolean f3177lc = true;

    /* renamed from: ra  reason: collision with root package name */
    public final Runnable f3184ra = new y();

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: co  reason: collision with root package name */
        public boolean f3195co;

        /* renamed from: f  reason: collision with root package name */
        public int f3196f;

        /* renamed from: fb  reason: collision with root package name */
        public int f3197fb;

        /* renamed from: p  reason: collision with root package name */
        public boolean f3198p;

        /* renamed from: s  reason: collision with root package name */
        public int[] f3199s;

        /* renamed from: t  reason: collision with root package name */
        public int[] f3200t;

        /* renamed from: v  reason: collision with root package name */
        public int f3201v;

        /* renamed from: w  reason: collision with root package name */
        public List<LazySpanLookup.FullSpanItem> f3202w;
        public int y;

        /* renamed from: z  reason: collision with root package name */
        public boolean f3203z;

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
            this.f3199s = null;
            this.f3197fb = 0;
            this.f3196f = 0;
            this.f3200t = null;
            this.f3202w = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.y);
            parcel.writeInt(this.f3201v);
            parcel.writeInt(this.f3197fb);
            if (this.f3197fb > 0) {
                parcel.writeIntArray(this.f3199s);
            }
            parcel.writeInt(this.f3196f);
            if (this.f3196f > 0) {
                parcel.writeIntArray(this.f3200t);
            }
            parcel.writeInt(this.f3198p ? 1 : 0);
            parcel.writeInt(this.f3195co ? 1 : 0);
            parcel.writeInt(this.f3203z ? 1 : 0);
            parcel.writeList(this.f3202w);
        }

        public void y() {
            this.f3199s = null;
            this.f3197fb = 0;
            this.y = -1;
            this.f3201v = -1;
        }

        public SavedState(Parcel parcel) {
            this.y = parcel.readInt();
            this.f3201v = parcel.readInt();
            int readInt = parcel.readInt();
            this.f3197fb = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f3199s = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f3196f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f3200t = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f3198p = parcel.readInt() == 1;
            this.f3195co = parcel.readInt() == 1;
            this.f3203z = parcel.readInt() == 1;
            this.f3202w = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3197fb = savedState.f3197fb;
            this.y = savedState.y;
            this.f3201v = savedState.f3201v;
            this.f3199s = savedState.f3199s;
            this.f3196f = savedState.f3196f;
            this.f3200t = savedState.f3200t;
            this.f3198p = savedState.f3198p;
            this.f3195co = savedState.f3195co;
            this.f3203z = savedState.f3203z;
            this.f3202w = savedState.f3202w;
        }
    }

    /* loaded from: classes.dex */
    public class gv {

        /* renamed from: v  reason: collision with root package name */
        public final int f3207v;
        public ArrayList<View> y = new ArrayList<>();

        /* renamed from: n3  reason: collision with root package name */
        public int f3206n3 = Integer.MIN_VALUE;

        /* renamed from: zn  reason: collision with root package name */
        public int f3208zn = Integer.MIN_VALUE;

        /* renamed from: gv  reason: collision with root package name */
        public int f3205gv = 0;

        public gv(int i) {
            this.f3207v = i;
        }

        public int a() {
            if (StaggeredGridLayoutManager.this.f3187ut) {
                return i9(this.y.size() - 1, -1, true);
            }
            return i9(0, this.y.size(), true);
        }

        public int c5(int i, int i5, boolean z2, boolean z3, boolean z4) {
            int i6;
            boolean z5;
            int tl2 = StaggeredGridLayoutManager.this.f3174j5.tl();
            int c52 = StaggeredGridLayoutManager.this.f3174j5.c5();
            if (i5 > i) {
                i6 = 1;
            } else {
                i6 = -1;
            }
            while (i != i5) {
                View view = this.y.get(i);
                int fb2 = StaggeredGridLayoutManager.this.f3174j5.fb(view);
                int gv2 = StaggeredGridLayoutManager.this.f3174j5.gv(view);
                boolean z7 = false;
                if (!z4 ? fb2 < c52 : fb2 <= c52) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!z4 ? gv2 > tl2 : gv2 >= tl2) {
                    z7 = true;
                }
                if (z5 && z7) {
                    if (z2 && z3) {
                        if (fb2 >= tl2 && gv2 <= c52) {
                            return StaggeredGridLayoutManager.this.ap(view);
                        }
                    } else if (z3) {
                        return StaggeredGridLayoutManager.this.ap(view);
                    } else {
                        if (fb2 < tl2 || gv2 > c52) {
                            return StaggeredGridLayoutManager.this.ap(view);
                        }
                    }
                }
                i += i6;
            }
            return -1;
        }

        public void co() {
            this.f3206n3 = Integer.MIN_VALUE;
            this.f3208zn = Integer.MIN_VALUE;
        }

        public int f(int i, int i5, boolean z2) {
            return c5(i, i5, z2, true, false);
        }

        public void f3(int i) {
            this.f3206n3 = i;
            this.f3208zn = i;
        }

        public int fb() {
            if (StaggeredGridLayoutManager.this.f3187ut) {
                return f(0, this.y.size(), true);
            }
            return f(this.y.size() - 1, -1, true);
        }

        public void gv() {
            LazySpanLookup.FullSpanItem a2;
            View view = this.y.get(0);
            zn w4 = w(view);
            this.f3206n3 = StaggeredGridLayoutManager.this.f3174j5.fb(view);
            if (w4.f3216t && (a2 = StaggeredGridLayoutManager.this.f3175jz.a(w4.y())) != null && a2.f3194v == -1) {
                this.f3206n3 -= a2.y(this.f3207v);
            }
        }

        public void i4(View view) {
            zn w4 = w(view);
            w4.f3215f = this;
            this.y.add(0, view);
            this.f3206n3 = Integer.MIN_VALUE;
            if (this.y.size() == 1) {
                this.f3208zn = Integer.MIN_VALUE;
            }
            if (w4.zn() || w4.n3()) {
                this.f3205gv += StaggeredGridLayoutManager.this.f3174j5.v(view);
            }
        }

        public int i9(int i, int i5, boolean z2) {
            return c5(i, i5, false, false, z2);
        }

        public int mt(int i) {
            int i5 = this.f3206n3;
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            if (this.y.size() == 0) {
                return i;
            }
            gv();
            return this.f3206n3;
        }

        public void n3(boolean z2, int i) {
            int mt2;
            if (z2) {
                mt2 = wz(Integer.MIN_VALUE);
            } else {
                mt2 = mt(Integer.MIN_VALUE);
            }
            v();
            if (mt2 == Integer.MIN_VALUE) {
                return;
            }
            if (!z2 || mt2 >= StaggeredGridLayoutManager.this.f3174j5.c5()) {
                if (!z2 && mt2 > StaggeredGridLayoutManager.this.f3174j5.tl()) {
                    return;
                }
                if (i != Integer.MIN_VALUE) {
                    mt2 += i;
                }
                this.f3208zn = mt2;
                this.f3206n3 = mt2;
            }
        }

        public int p() {
            int i = this.f3206n3;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            gv();
            return this.f3206n3;
        }

        public void r() {
            int size = this.y.size();
            View remove = this.y.remove(size - 1);
            zn w4 = w(remove);
            w4.f3215f = null;
            if (w4.zn() || w4.n3()) {
                this.f3205gv -= StaggeredGridLayoutManager.this.f3174j5.v(remove);
            }
            if (size == 1) {
                this.f3206n3 = Integer.MIN_VALUE;
            }
            this.f3208zn = Integer.MIN_VALUE;
        }

        public int s() {
            if (StaggeredGridLayoutManager.this.f3187ut) {
                return i9(0, this.y.size(), true);
            }
            return i9(this.y.size() - 1, -1, true);
        }

        public int t() {
            return this.f3205gv;
        }

        public int tl() {
            int i = this.f3208zn;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            zn();
            return this.f3208zn;
        }

        public void v() {
            this.y.clear();
            co();
            this.f3205gv = 0;
        }

        public zn w(View view) {
            return (zn) view.getLayoutParams();
        }

        public int wz(int i) {
            int i5 = this.f3208zn;
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            if (this.y.size() == 0) {
                return i;
            }
            zn();
            return this.f3208zn;
        }

        public void x4() {
            View remove = this.y.remove(0);
            zn w4 = w(remove);
            w4.f3215f = null;
            if (this.y.size() == 0) {
                this.f3208zn = Integer.MIN_VALUE;
            }
            if (w4.zn() || w4.n3()) {
                this.f3205gv -= StaggeredGridLayoutManager.this.f3174j5.v(remove);
            }
            this.f3206n3 = Integer.MIN_VALUE;
        }

        public View xc(int i, int i5) {
            View view = null;
            if (i5 == -1) {
                int size = this.y.size();
                int i6 = 0;
                while (i6 < size) {
                    View view2 = this.y.get(i6);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f3187ut && staggeredGridLayoutManager.ap(view2) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f3187ut && staggeredGridLayoutManager2.ap(view2) >= i) || !view2.hasFocusable()) {
                        break;
                    }
                    i6++;
                    view = view2;
                }
            } else {
                int size2 = this.y.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.y.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f3187ut && staggeredGridLayoutManager3.ap(view3) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f3187ut && staggeredGridLayoutManager4.ap(view3) <= i) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        public void y(View view) {
            zn w4 = w(view);
            w4.f3215f = this;
            this.y.add(view);
            this.f3208zn = Integer.MIN_VALUE;
            if (this.y.size() == 1) {
                this.f3206n3 = Integer.MIN_VALUE;
            }
            if (w4.zn() || w4.n3()) {
                this.f3205gv += StaggeredGridLayoutManager.this.f3174j5.v(view);
            }
        }

        public void z(int i) {
            int i5 = this.f3206n3;
            if (i5 != Integer.MIN_VALUE) {
                this.f3206n3 = i5 + i;
            }
            int i6 = this.f3208zn;
            if (i6 != Integer.MIN_VALUE) {
                this.f3208zn = i6 + i;
            }
        }

        public void zn() {
            LazySpanLookup.FullSpanItem a2;
            ArrayList<View> arrayList = this.y;
            View view = arrayList.get(arrayList.size() - 1);
            zn w4 = w(view);
            this.f3208zn = StaggeredGridLayoutManager.this.f3174j5.gv(view);
            if (w4.f3216t && (a2 = StaggeredGridLayoutManager.this.f3175jz.a(w4.y())) != null && a2.f3194v == 1) {
                this.f3208zn += a2.y(this.f3207v);
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 {

        /* renamed from: a  reason: collision with root package name */
        public int[] f3209a;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f3211gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3212n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f3213v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f3214zn;

        public n3() {
            zn();
        }

        public void gv(gv[] gvVarArr) {
            int length = gvVarArr.length;
            int[] iArr = this.f3209a;
            if (iArr == null || iArr.length < length) {
                this.f3209a = new int[StaggeredGridLayoutManager.this.f3167b.length];
            }
            for (int i = 0; i < length; i++) {
                this.f3209a[i] = gvVarArr[i].mt(Integer.MIN_VALUE);
            }
        }

        public void n3(int i) {
            if (this.f3214zn) {
                this.f3212n3 = StaggeredGridLayoutManager.this.f3174j5.c5() - i;
            } else {
                this.f3212n3 = StaggeredGridLayoutManager.this.f3174j5.tl() + i;
            }
        }

        public void y() {
            int tl2;
            if (this.f3214zn) {
                tl2 = StaggeredGridLayoutManager.this.f3174j5.c5();
            } else {
                tl2 = StaggeredGridLayoutManager.this.f3174j5.tl();
            }
            this.f3212n3 = tl2;
        }

        public void zn() {
            this.y = -1;
            this.f3212n3 = Integer.MIN_VALUE;
            this.f3214zn = false;
            this.f3211gv = false;
            this.f3213v = false;
            int[] iArr = this.f3209a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.hj();
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends RecyclerView.p {

        /* renamed from: f  reason: collision with root package name */
        public gv f3215f;

        /* renamed from: t  reason: collision with root package name */
        public boolean f3216t;

        public zn(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void a(boolean z2) {
            this.f3216t = z2;
        }

        public boolean v() {
            return this.f3216t;
        }

        public zn(int i, int i5) {
            super(i, i5);
        }

        public zn(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public zn(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i5) {
        RecyclerView.w.gv yg2 = RecyclerView.w.yg(context, attributeSet, i, i5);
        x2(yg2.y);
        fm(yg2.f3161n3);
        mf(yg2.f3162zn);
        this.f3181oz = new fb();
        yh();
    }

    private int hf(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        return wz.y(fhVar, this.f3174j5, xu(!this.f3177lc), eu(!this.f3177lc), this, this.f3177lc);
    }

    private void op() {
        if (this.f3179o != 1 && wv()) {
            this.f3182q9 = !this.f3187ut;
        } else {
            this.f3182q9 = this.f3187ut;
        }
    }

    private int ou(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        return wz.zn(fhVar, this.f3174j5, xu(!this.f3177lc), eu(!this.f3177lc), this, this.f3177lc);
    }

    private void rk(View view, int i, int i5, boolean z2) {
        boolean wo;
        z(view, this.f3180o4);
        zn znVar = (zn) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) znVar).leftMargin;
        Rect rect = this.f3180o4;
        int g6 = g6(i, i6 + rect.left, ((ViewGroup.MarginLayoutParams) znVar).rightMargin + rect.right);
        int i8 = ((ViewGroup.MarginLayoutParams) znVar).topMargin;
        Rect rect2 = this.f3180o4;
        int g62 = g6(i5, i8 + rect2.top, ((ViewGroup.MarginLayoutParams) znVar).bottomMargin + rect2.bottom);
        if (z2) {
            wo = hb(view, g6, g62, znVar);
        } else {
            wo = wo(view, g6, g62, znVar);
        }
        if (wo) {
            view.measure(g6, g62);
        }
    }

    private int vi(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i == 130 && this.f3179o == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.f3179o == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.f3179o == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f3179o == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f3179o != 1 && wv()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.f3179o == 1 || !wv()) {
            return -1;
        } else {
            return 1;
        }
    }

    private int w7(RecyclerView.fh fhVar) {
        if (oz() == 0) {
            return 0;
        }
        return wz.n3(fhVar, this.f3174j5, xu(!this.f3177lc), eu(!this.f3177lc), this, this.f3177lc, this.f3182q9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void bv(RecyclerView.fh fhVar) {
        super.bv(fhVar);
        this.f3172f7 = -1;
        this.f3171en = Integer.MIN_VALUE;
        this.f3169dm = null;
        this.f3185rs.zn();
    }

    public final void bx(View view, zn znVar, boolean z2) {
        if (znVar.f3216t) {
            if (this.f3179o == 1) {
                rk(view, this.f3168ct, RecyclerView.w.ut(rs(), eb(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) znVar).height, true), z2);
            } else {
                rk(view, RecyclerView.w.ut(g(), u0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) znVar).width, true), this.f3168ct, z2);
            }
        } else if (this.f3179o == 1) {
            rk(view, RecyclerView.w.ut(this.f3173j, u0(), 0, ((ViewGroup.MarginLayoutParams) znVar).width, false), RecyclerView.w.ut(rs(), eb(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) znVar).height, true), z2);
        } else {
            rk(view, RecyclerView.w.ut(g(), u0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) znVar).width, true), RecyclerView.w.ut(this.f3173j, eb(), 0, ((ViewGroup.MarginLayoutParams) znVar).height, false), z2);
        }
    }

    public final boolean cp(int i) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.f3179o == 0) {
            if (i == -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4 == this.f3182q9) {
                return false;
            }
            return true;
        }
        if (i == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 == this.f3182q9) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 != wv()) {
            return false;
        }
        return true;
    }

    public int cw() {
        return this.f3188x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int d(RecyclerView.fh fhVar) {
        return ou(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int d0(RecyclerView.fh fhVar) {
        return hf(fhVar);
    }

    public final LazySpanLookup.FullSpanItem e5(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3192fb = new int[this.f3188x];
        for (int i5 = 0; i5 < this.f3188x; i5++) {
            fullSpanItem.f3192fb[i5] = this.f3167b[i5].mt(i) - i;
        }
        return fullSpanItem;
    }

    public final void el(gv gvVar, int i, int i5) {
        int t2 = gvVar.t();
        if (i == -1) {
            if (gvVar.p() + t2 <= i5) {
                this.f3176k.set(gvVar.f3207v, false);
            }
        } else if (gvVar.tl() - t2 >= i5) {
            this.f3176k.set(gvVar.f3207v, false);
        }
    }

    public View eu(boolean z2) {
        int tl2 = this.f3174j5.tl();
        int c52 = this.f3174j5.c5();
        View view = null;
        for (int oz2 = oz() - 1; oz2 >= 0; oz2--) {
            View j2 = j(oz2);
            int fb2 = this.f3174j5.fb(j2);
            int gv2 = this.f3174j5.gv(j2);
            if (gv2 > tl2 && fb2 < c52) {
                if (gv2 > c52 && z2) {
                    if (view == null) {
                        view = j2;
                    }
                } else {
                    return j2;
                }
            }
        }
        return view;
    }

    public int ez() {
        int oz2 = oz();
        if (oz2 == 0) {
            return 0;
        }
        return ap(j(oz2 - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int fh(RecyclerView.fh fhVar) {
        return w7(fhVar);
    }

    public void fm(int i) {
        p(null);
        if (i != this.f3188x) {
            xh();
            this.f3188x = i;
            this.f3176k = new BitSet(this.f3188x);
            this.f3167b = new gv[this.f3188x];
            for (int i5 = 0; i5 < this.f3188x; i5++) {
                this.f3167b[i5] = new gv(i5);
            }
            hr();
        }
    }

    public final int fp(int i) {
        boolean z2;
        if (oz() == 0) {
            if (!this.f3182q9) {
                return -1;
            }
            return 1;
        }
        if (i < mc()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != this.f3182q9) {
            return -1;
        }
        return 1;
    }

    public final int g6(int i, int i5, int i6) {
        if (i5 == 0 && i6 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i5) - i6), mode);
    }

    public void gd(int i, RecyclerView.fh fhVar) {
        int mc2;
        int i5;
        if (i > 0) {
            mc2 = ez();
            i5 = 1;
        } else {
            mc2 = mc();
            i5 = -1;
        }
        this.f3181oz.y = true;
        r3(mc2, fhVar);
        jf(i5);
        fb fbVar = this.f3181oz;
        fbVar.f3240zn = mc2 + fbVar.f3236gv;
        fbVar.f3237n3 = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void gf(RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        ja(i4Var, fhVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void gi(Rect rect, int i, int i5) {
        int f32;
        int f33;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f3179o == 1) {
            f33 = RecyclerView.w.f3(i5, rect.height() + paddingTop, e());
            f32 = RecyclerView.w.f3(i, (this.f3173j * this.f3188x) + paddingLeft, s8());
        } else {
            f32 = RecyclerView.w.f3(i, rect.width() + paddingLeft, s8());
            f33 = RecyclerView.w.f3(i5, (this.f3173j * this.f3188x) + paddingTop, e());
        }
        v1(f32, f33);
    }

    public int gm(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        if (oz() == 0 || i == 0) {
            return 0;
        }
        gd(i, fhVar);
        int nh = nh(i4Var, this.f3181oz, fhVar);
        if (this.f3181oz.f3237n3 >= nh) {
            if (i < 0) {
                i = -nh;
            } else {
                i = nh;
            }
        }
        this.f3174j5.mt(-i);
        this.f3190y5 = this.f3182q9;
        fb fbVar = this.f3181oz;
        fbVar.f3237n3 = 0;
        y0(i4Var, fbVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void gq(int i) {
        super.gq(i);
        for (int i5 = 0; i5 < this.f3188x; i5++) {
            this.f3167b[i5].z(i);
        }
    }

    public boolean hj() {
        int mc2;
        int ez;
        int i;
        if (oz() == 0 || this.f3186u == 0 || !y4()) {
            return false;
        }
        if (this.f3182q9) {
            mc2 = ez();
            ez = mc();
        } else {
            mc2 = mc();
            ez = ez();
        }
        if (mc2 == 0 && l8() != null) {
            this.f3175jz.n3();
            cx();
            hr();
            return true;
        } else if (!this.f3170eb) {
            return false;
        } else {
            if (this.f3182q9) {
                i = -1;
            } else {
                i = 1;
            }
            int i5 = ez + 1;
            LazySpanLookup.FullSpanItem v2 = this.f3175jz.v(mc2, i5, i, true);
            if (v2 == null) {
                this.f3170eb = false;
                this.f3175jz.gv(i5);
                return false;
            }
            LazySpanLookup.FullSpanItem v3 = this.f3175jz.v(mc2, v2.y, i * (-1), true);
            if (v3 == null) {
                this.f3175jz.gv(v2.y);
            } else {
                this.f3175jz.gv(v3.y + 1);
            }
            cx();
            hr();
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p hw(Context context, AttributeSet attributeSet) {
        return new zn(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int hy(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        return gm(i, i4Var, fhVar);
    }

    public final int i1(int i) {
        int oz2 = oz();
        for (int i5 = 0; i5 < oz2; i5++) {
            int ap2 = ap(j(i5));
            if (ap2 >= 0 && ap2 < i) {
                return ap2;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean i4(RecyclerView.p pVar) {
        return pVar instanceof zn;
    }

    public int[] ih(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3188x];
        } else if (iArr.length < this.f3188x) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3188x + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f3188x; i++) {
            iArr[i] = this.f3167b[i].fb();
        }
        return iArr;
    }

    public boolean ik(RecyclerView.fh fhVar, n3 n3Var) {
        int i;
        int mc2;
        int tl2;
        boolean z2 = false;
        if (!fhVar.v() && (i = this.f3172f7) != -1) {
            if (i >= 0 && i < fhVar.n3()) {
                SavedState savedState = this.f3169dm;
                if (savedState != null && savedState.y != -1 && savedState.f3197fb >= 1) {
                    n3Var.f3212n3 = Integer.MIN_VALUE;
                    n3Var.y = this.f3172f7;
                } else {
                    View yt2 = yt(this.f3172f7);
                    if (yt2 != null) {
                        if (this.f3182q9) {
                            mc2 = ez();
                        } else {
                            mc2 = mc();
                        }
                        n3Var.y = mc2;
                        if (this.f3171en != Integer.MIN_VALUE) {
                            if (n3Var.f3214zn) {
                                n3Var.f3212n3 = (this.f3174j5.c5() - this.f3171en) - this.f3174j5.gv(yt2);
                            } else {
                                n3Var.f3212n3 = (this.f3174j5.tl() + this.f3171en) - this.f3174j5.fb(yt2);
                            }
                            return true;
                        } else if (this.f3174j5.v(yt2) > this.f3174j5.wz()) {
                            if (n3Var.f3214zn) {
                                tl2 = this.f3174j5.c5();
                            } else {
                                tl2 = this.f3174j5.tl();
                            }
                            n3Var.f3212n3 = tl2;
                            return true;
                        } else {
                            int fb2 = this.f3174j5.fb(yt2) - this.f3174j5.tl();
                            if (fb2 < 0) {
                                n3Var.f3212n3 = -fb2;
                                return true;
                            }
                            int c52 = this.f3174j5.c5() - this.f3174j5.gv(yt2);
                            if (c52 < 0) {
                                n3Var.f3212n3 = c52;
                                return true;
                            }
                            n3Var.f3212n3 = Integer.MIN_VALUE;
                        }
                    } else {
                        int i5 = this.f3172f7;
                        n3Var.y = i5;
                        int i6 = this.f3171en;
                        if (i6 == Integer.MIN_VALUE) {
                            if (fp(i5) == 1) {
                                z2 = true;
                            }
                            n3Var.f3214zn = z2;
                            n3Var.y();
                        } else {
                            n3Var.n3(i6);
                        }
                        n3Var.f3211gv = true;
                    }
                }
                return true;
            }
            this.f3172f7 = -1;
            this.f3171en = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void im(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f3169dm = savedState;
            if (this.f3172f7 != -1) {
                savedState.y();
                this.f3169dm.n3();
            }
            hr();
        }
    }

    public final gv iu(fb fbVar) {
        int i;
        int i5;
        int i6;
        if (cp(fbVar.f3239v)) {
            i5 = this.f3188x - 1;
            i = -1;
            i6 = -1;
        } else {
            i = this.f3188x;
            i5 = 0;
            i6 = 1;
        }
        gv gvVar = null;
        if (fbVar.f3239v == 1) {
            int tl2 = this.f3174j5.tl();
            int i8 = Integer.MAX_VALUE;
            while (i5 != i) {
                gv gvVar2 = this.f3167b[i5];
                int wz2 = gvVar2.wz(tl2);
                if (wz2 < i8) {
                    gvVar = gvVar2;
                    i8 = wz2;
                }
                i5 += i6;
            }
            return gvVar;
        }
        int c52 = this.f3174j5.c5();
        int i10 = Integer.MIN_VALUE;
        while (i5 != i) {
            gv gvVar3 = this.f3167b[i5];
            int mt2 = gvVar3.mt(c52);
            if (mt2 > i10) {
                gvVar = gvVar3;
                i10 = mt2;
            }
            i5 += i6;
        }
        return gvVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void j3(RecyclerView recyclerView) {
        this.f3175jz.n3();
        hr();
    }

    public final int j4(int i) {
        int mt2 = this.f3167b[0].mt(i);
        for (int i5 = 1; i5 < this.f3188x; i5++) {
            int mt3 = this.f3167b[i5].mt(i);
            if (mt3 > mt2) {
                mt2 = mt3;
            }
        }
        return mt2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p j5(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new zn((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new zn(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0152, code lost:
        if (hj() != false) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ja(androidx.recyclerview.widget.RecyclerView.i4 r9, androidx.recyclerview.widget.RecyclerView.fh r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.ja(androidx.recyclerview.widget.RecyclerView$i4, androidx.recyclerview.widget.RecyclerView$fh, boolean):void");
    }

    public final void jf(int i) {
        boolean z2;
        fb fbVar = this.f3181oz;
        fbVar.f3239v = i;
        boolean z3 = this.f3182q9;
        int i5 = 1;
        if (i == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z3 != z2) {
            i5 = -1;
        }
        fbVar.f3236gv = i5;
    }

    public final int jm(int i) {
        for (int oz2 = oz() - 1; oz2 >= 0; oz2--) {
            int ap2 = ap(j(oz2));
            if (ap2 >= 0 && ap2 < i) {
                return ap2;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int jt(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        return gm(i, i4Var, fhVar);
    }

    public final void ks(View view, zn znVar, fb fbVar) {
        if (fbVar.f3239v == 1) {
            if (znVar.f3216t) {
                ux(view);
            } else {
                znVar.f3215f.y(view);
            }
        } else if (znVar.f3216t) {
            ng(view);
        } else {
            znVar.f3215f.i4(view);
        }
    }

    public final LazySpanLookup.FullSpanItem l3(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3192fb = new int[this.f3188x];
        for (int i5 = 0; i5 < this.f3188x; i5++) {
            fullSpanItem.f3192fb[i5] = i - this.f3167b[i5].wz(i);
        }
        return fullSpanItem;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View l8() {
        /*
            r12 = this;
            int r0 = r12.oz()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f3188x
            r2.<init>(r3)
            int r3 = r12.f3188x
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f3179o
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.wv()
            if (r3 == 0) goto L21
            r3 = 1
            goto L22
        L21:
            r3 = -1
        L22:
            boolean r7 = r12.f3182q9
            if (r7 == 0) goto L28
            r0 = -1
            goto L29
        L28:
            r1 = 0
        L29:
            if (r1 >= r0) goto L2c
            r6 = 1
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.j(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$zn r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.zn) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$gv r9 = r8.f3215f
            int r9 = r9.f3207v
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$gv r9 = r8.f3215f
            boolean r9 = r12.sh(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$gv r9 = r8.f3215f
            int r9 = r9.f3207v
            r2.clear(r9)
        L52:
            boolean r9 = r8.f3216t
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.j(r9)
            boolean r10 = r12.f3182q9
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.f r10 = r12.f3174j5
            int r10 = r10.gv(r7)
            androidx.recyclerview.widget.f r11 = r12.f3174j5
            int r11 = r11.gv(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.f r10 = r12.f3174j5
            int r10 = r10.fb(r7)
            androidx.recyclerview.widget.f r11 = r12.f3174j5
            int r11 = r11.fb(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$zn r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.zn) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$gv r8 = r8.f3215f
            int r8 = r8.f3207v
            androidx.recyclerview.widget.StaggeredGridLayoutManager$gv r9 = r9.f3215f
            int r9 = r9.f3207v
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = 1
            goto L9a
        L99:
            r8 = 0
        L9a:
            if (r3 >= 0) goto L9e
            r9 = 1
            goto L9f
        L9e:
            r9 = 0
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.l8():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void le(AccessibilityEvent accessibilityEvent) {
        super.le(accessibilityEvent);
        if (oz() > 0) {
            View xu = xu(false);
            View eu = eu(false);
            if (xu != null && eu != null) {
                int ap2 = ap(xu);
                int ap3 = ap(eu);
                if (ap2 < ap3) {
                    accessibilityEvent.setFromIndex(ap2);
                    accessibilityEvent.setToIndex(ap3);
                    return;
                }
                accessibilityEvent.setFromIndex(ap3);
                accessibilityEvent.setToIndex(ap2);
            }
        }
    }

    public final void m5() {
        if (this.f3183qn.f() == 1073741824) {
            return;
        }
        int oz2 = oz();
        float f4 = 0.0f;
        for (int i = 0; i < oz2; i++) {
            View j2 = j(i);
            float v2 = this.f3183qn.v(j2);
            if (v2 >= f4) {
                if (((zn) j2.getLayoutParams()).v()) {
                    v2 = (v2 * 1.0f) / this.f3188x;
                }
                f4 = Math.max(f4, v2);
            }
        }
        int i5 = this.f3173j;
        int round = Math.round(f4 * this.f3188x);
        if (this.f3183qn.f() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f3183qn.wz());
        }
        st(round);
        if (this.f3173j == i5) {
            return;
        }
        for (int i6 = 0; i6 < oz2; i6++) {
            View j4 = j(i6);
            zn znVar = (zn) j4.getLayoutParams();
            if (!znVar.f3216t) {
                if (wv() && this.f3179o == 1) {
                    int i8 = this.f3188x;
                    int i10 = znVar.f3215f.f3207v;
                    j4.offsetLeftAndRight(((-((i8 - 1) - i10)) * this.f3173j) - ((-((i8 - 1) - i10)) * i5));
                } else {
                    int i11 = znVar.f3215f.f3207v;
                    int i12 = this.f3173j * i11;
                    int i13 = i11 * i5;
                    if (this.f3179o == 1) {
                        j4.offsetLeftAndRight(i12 - i13);
                    } else {
                        j4.offsetTopAndBottom(i12 - i13);
                    }
                }
            }
        }
    }

    public int mc() {
        if (oz() == 0) {
            return 0;
        }
        return ap(j(0));
    }

    public void mf(boolean z2) {
        p(null);
        SavedState savedState = this.f3169dm;
        if (savedState != null && savedState.f3198p != z2) {
            savedState.f3198p = z2;
        }
        this.f3187ut = z2;
        hr();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int mg(RecyclerView.fh fhVar) {
        return hf(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public Parcelable mh() {
        int mc2;
        int mt2;
        int tl2;
        int[] iArr;
        if (this.f3169dm != null) {
            return new SavedState(this.f3169dm);
        }
        SavedState savedState = new SavedState();
        savedState.f3198p = this.f3187ut;
        savedState.f3195co = this.f3190y5;
        savedState.f3203z = this.f3189xg;
        LazySpanLookup lazySpanLookup = this.f3175jz;
        if (lazySpanLookup != null && (iArr = lazySpanLookup.y) != null) {
            savedState.f3200t = iArr;
            savedState.f3196f = iArr.length;
            savedState.f3202w = lazySpanLookup.f3191n3;
        } else {
            savedState.f3196f = 0;
        }
        if (oz() > 0) {
            if (this.f3190y5) {
                mc2 = ez();
            } else {
                mc2 = mc();
            }
            savedState.y = mc2;
            savedState.f3201v = z8();
            int i = this.f3188x;
            savedState.f3197fb = i;
            savedState.f3199s = new int[i];
            for (int i5 = 0; i5 < this.f3188x; i5++) {
                if (this.f3190y5) {
                    mt2 = this.f3167b[i5].wz(Integer.MIN_VALUE);
                    if (mt2 != Integer.MIN_VALUE) {
                        tl2 = this.f3174j5.c5();
                        mt2 -= tl2;
                        savedState.f3199s[i5] = mt2;
                    } else {
                        savedState.f3199s[i5] = mt2;
                    }
                } else {
                    mt2 = this.f3167b[i5].mt(Integer.MIN_VALUE);
                    if (mt2 != Integer.MIN_VALUE) {
                        tl2 = this.f3174j5.tl();
                        mt2 -= tl2;
                        savedState.f3199s[i5] = mt2;
                    } else {
                        savedState.f3199s[i5] = mt2;
                    }
                }
            }
        } else {
            savedState.y = -1;
            savedState.f3201v = -1;
            savedState.f3197fb = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    @Nullable
    public View mp(View view, int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        View k52;
        int mc2;
        boolean z2;
        boolean z3;
        int s2;
        int s3;
        int s4;
        View xc2;
        if (oz() == 0 || (k52 = k5(view)) == null) {
            return null;
        }
        op();
        int vi = vi(i);
        if (vi == Integer.MIN_VALUE) {
            return null;
        }
        zn znVar = (zn) k52.getLayoutParams();
        boolean z4 = znVar.f3216t;
        gv gvVar = znVar.f3215f;
        if (vi == 1) {
            mc2 = ez();
        } else {
            mc2 = mc();
        }
        r3(mc2, fhVar);
        jf(vi);
        fb fbVar = this.f3181oz;
        fbVar.f3240zn = fbVar.f3236gv + mc2;
        fbVar.f3237n3 = (int) (this.f3174j5.wz() * 0.33333334f);
        fb fbVar2 = this.f3181oz;
        fbVar2.f3238s = true;
        fbVar2.y = false;
        nh(i4Var, fbVar2, fhVar);
        this.f3190y5 = this.f3182q9;
        if (!z4 && (xc2 = gvVar.xc(mc2, vi)) != null && xc2 != k52) {
            return xc2;
        }
        if (cp(vi)) {
            for (int i5 = this.f3188x - 1; i5 >= 0; i5--) {
                View xc3 = this.f3167b[i5].xc(mc2, vi);
                if (xc3 != null && xc3 != k52) {
                    return xc3;
                }
            }
        } else {
            for (int i6 = 0; i6 < this.f3188x; i6++) {
                View xc4 = this.f3167b[i6].xc(mc2, vi);
                if (xc4 != null && xc4 != k52) {
                    return xc4;
                }
            }
        }
        boolean z5 = !this.f3187ut;
        if (vi == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z5 == z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z4) {
            if (z3) {
                s4 = gvVar.a();
            } else {
                s4 = gvVar.s();
            }
            View yt2 = yt(s4);
            if (yt2 != null && yt2 != k52) {
                return yt2;
            }
        }
        if (cp(vi)) {
            for (int i8 = this.f3188x - 1; i8 >= 0; i8--) {
                if (i8 != gvVar.f3207v) {
                    if (z3) {
                        s3 = this.f3167b[i8].a();
                    } else {
                        s3 = this.f3167b[i8].s();
                    }
                    View yt3 = yt(s3);
                    if (yt3 != null && yt3 != k52) {
                        return yt3;
                    }
                }
            }
        } else {
            for (int i10 = 0; i10 < this.f3188x; i10++) {
                if (z3) {
                    s2 = this.f3167b[i10].a();
                } else {
                    s2 = this.f3167b[i10].s();
                }
                View yt4 = yt(s2);
                if (yt4 != null && yt4 != k52) {
                    return yt4;
                }
            }
        }
        return null;
    }

    public final void mq(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, boolean z2) {
        int c52;
        int wb = wb(Integer.MIN_VALUE);
        if (wb != Integer.MIN_VALUE && (c52 = this.f3174j5.c5() - wb) > 0) {
            int i = c52 - (-gm(-c52, i4Var, fhVar));
            if (z2 && i > 0) {
                this.f3174j5.mt(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void n(int i, int i5, RecyclerView.fh fhVar, RecyclerView.w.zn znVar) {
        int wz2;
        int i6;
        if (this.f3179o != 0) {
            i = i5;
        }
        if (oz() != 0 && i != 0) {
            gd(i, fhVar);
            int[] iArr = this.f3178nf;
            if (iArr == null || iArr.length < this.f3188x) {
                this.f3178nf = new int[this.f3188x];
            }
            int i8 = 0;
            for (int i10 = 0; i10 < this.f3188x; i10++) {
                fb fbVar = this.f3181oz;
                if (fbVar.f3236gv == -1) {
                    wz2 = fbVar.f3233a;
                    i6 = this.f3167b[i10].mt(wz2);
                } else {
                    wz2 = this.f3167b[i10].wz(fbVar.f3235fb);
                    i6 = this.f3181oz.f3235fb;
                }
                int i11 = wz2 - i6;
                if (i11 >= 0) {
                    this.f3178nf[i8] = i11;
                    i8++;
                }
            }
            Arrays.sort(this.f3178nf, 0, i8);
            for (int i12 = 0; i12 < i8 && this.f3181oz.y(fhVar); i12++) {
                znVar.y(this.f3181oz.f3240zn, this.f3178nf[i12]);
                fb fbVar2 = this.f3181oz;
                fbVar2.f3240zn += fbVar2.f3236gv;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void n7(int i) {
        if (i == 0) {
            hj();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void nd(RecyclerView recyclerView, int i, int i5, Object obj) {
        nz(i, i5, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void ne(RecyclerView recyclerView, int i, int i5, int i6) {
        nz(i, i5, 8);
    }

    public final void ng(View view) {
        for (int i = this.f3188x - 1; i >= 0; i--) {
            this.f3167b[i].i4(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final int nh(RecyclerView.i4 i4Var, fb fbVar, RecyclerView.fh fhVar) {
        int i;
        int i5;
        int tl2;
        int wb;
        boolean z2;
        gv gvVar;
        int mt2;
        int v2;
        int i6;
        int tl3;
        int i8;
        int v3;
        int c52;
        boolean rt;
        int wz2;
        ?? r9 = 0;
        this.f3176k.set(0, this.f3188x, true);
        if (this.f3181oz.f3234c5) {
            if (fbVar.f3239v == 1) {
                i5 = Integer.MAX_VALUE;
            } else {
                i5 = Integer.MIN_VALUE;
            }
        } else {
            if (fbVar.f3239v == 1) {
                i = fbVar.f3235fb + fbVar.f3237n3;
            } else {
                i = fbVar.f3233a - fbVar.f3237n3;
            }
            i5 = i;
        }
        w5(fbVar.f3239v, i5);
        if (this.f3182q9) {
            tl2 = this.f3174j5.c5();
        } else {
            tl2 = this.f3174j5.tl();
        }
        int i10 = tl2;
        boolean z3 = false;
        while (fbVar.y(fhVar) && (this.f3181oz.f3234c5 || !this.f3176k.isEmpty())) {
            View n32 = fbVar.n3(i4Var);
            zn znVar = (zn) n32.getLayoutParams();
            int y2 = znVar.y();
            int fb2 = this.f3175jz.fb(y2);
            if (fb2 == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (znVar.f3216t) {
                    gvVar = this.f3167b[r9];
                } else {
                    gvVar = iu(fbVar);
                }
                this.f3175jz.wz(y2, gvVar);
            } else {
                gvVar = this.f3167b[fb2];
            }
            gv gvVar2 = gvVar;
            znVar.f3215f = gvVar2;
            if (fbVar.f3239v == 1) {
                wz(n32);
            } else {
                xc(n32, r9);
            }
            bx(n32, znVar, r9);
            if (fbVar.f3239v == 1) {
                if (znVar.f3216t) {
                    wz2 = wb(i10);
                } else {
                    wz2 = gvVar2.wz(i10);
                }
                int v4 = this.f3174j5.v(n32) + wz2;
                if (z2 && znVar.f3216t) {
                    LazySpanLookup.FullSpanItem l3 = l3(wz2);
                    l3.f3194v = -1;
                    l3.y = y2;
                    this.f3175jz.y(l3);
                }
                i6 = v4;
                v2 = wz2;
            } else {
                if (znVar.f3216t) {
                    mt2 = p2(i10);
                } else {
                    mt2 = gvVar2.mt(i10);
                }
                v2 = mt2 - this.f3174j5.v(n32);
                if (z2 && znVar.f3216t) {
                    LazySpanLookup.FullSpanItem e5 = e5(mt2);
                    e5.f3194v = 1;
                    e5.y = y2;
                    this.f3175jz.y(e5);
                }
                i6 = mt2;
            }
            if (znVar.f3216t && fbVar.f3236gv == -1) {
                if (z2) {
                    this.f3170eb = true;
                } else {
                    if (fbVar.f3239v == 1) {
                        rt = t5();
                    } else {
                        rt = rt();
                    }
                    if (!rt) {
                        LazySpanLookup.FullSpanItem a2 = this.f3175jz.a(y2);
                        if (a2 != null) {
                            a2.f3193s = true;
                        }
                        this.f3170eb = true;
                    }
                }
            }
            ks(n32, znVar, fbVar);
            if (wv() && this.f3179o == 1) {
                if (znVar.f3216t) {
                    c52 = this.f3183qn.c5();
                } else {
                    c52 = this.f3183qn.c5() - (((this.f3188x - 1) - gvVar2.f3207v) * this.f3173j);
                }
                v3 = c52;
                i8 = c52 - this.f3183qn.v(n32);
            } else {
                if (znVar.f3216t) {
                    tl3 = this.f3183qn.tl();
                } else {
                    tl3 = (gvVar2.f3207v * this.f3173j) + this.f3183qn.tl();
                }
                i8 = tl3;
                v3 = this.f3183qn.v(n32) + tl3;
            }
            if (this.f3179o == 1) {
                qk(n32, i8, v2, v3, i6);
            } else {
                qk(n32, v2, i8, i6, v3);
            }
            if (znVar.f3216t) {
                w5(this.f3181oz.f3239v, i5);
            } else {
                el(gvVar2, this.f3181oz.f3239v, i5);
            }
            y0(i4Var, this.f3181oz);
            if (this.f3181oz.f3238s && n32.hasFocusable()) {
                if (znVar.f3216t) {
                    this.f3176k.clear();
                } else {
                    this.f3176k.set(gvVar2.f3207v, false);
                    z3 = true;
                    r9 = 0;
                }
            }
            z3 = true;
            r9 = 0;
        }
        if (!z3) {
            y0(i4Var, this.f3181oz);
        }
        if (this.f3181oz.f3239v == -1) {
            wb = this.f3174j5.tl() - p2(this.f3174j5.tl());
        } else {
            wb = wb(this.f3174j5.c5()) - this.f3174j5.c5();
        }
        if (wb > 0) {
            return Math.min(fbVar.f3237n3, wb);
        }
        return 0;
    }

    public void ni(RecyclerView.fh fhVar, n3 n3Var) {
        if (ik(fhVar, n3Var) || p4(fhVar, n3Var)) {
            return;
        }
        n3Var.y();
        n3Var.y = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void nz(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f3182q9
            if (r0 == 0) goto L9
            int r0 = r6.ez()
            goto Ld
        L9:
            int r0 = r6.mc()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f3175jz
            r4.s(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f3175jz
            r9.f(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f3175jz
            r7.i9(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f3175jz
            r9.f(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f3175jz
            r9.i9(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.f3182q9
            if (r7 == 0) goto L4e
            int r7 = r6.mc()
            goto L52
        L4e:
            int r7 = r6.ez()
        L52:
            if (r3 > r7) goto L57
            r6.hr()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.nz(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void oa(@Nullable RecyclerView.s sVar, @Nullable RecyclerView.s sVar2) {
        this.f3175jz.n3();
        for (int i = 0; i < this.f3188x; i++) {
            this.f3167b[i].v();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void ob(RecyclerView recyclerView, RecyclerView.fh fhVar, int i) {
        s sVar = new s(recyclerView.getContext());
        sVar.w(i);
        vb(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void p(String str) {
        if (this.f3169dm == null) {
            super.p(str);
        }
    }

    public final int p2(int i) {
        int mt2 = this.f3167b[0].mt(i);
        for (int i5 = 1; i5 < this.f3188x; i5++) {
            int mt3 = this.f3167b[i5].mt(i);
            if (mt3 < mt2) {
                mt2 = mt3;
            }
        }
        return mt2;
    }

    public final boolean p4(RecyclerView.fh fhVar, n3 n3Var) {
        int i1;
        if (this.f3190y5) {
            i1 = jm(fhVar.n3());
        } else {
            i1 = i1(fhVar.n3());
        }
        n3Var.y = i1;
        n3Var.f3212n3 = Integer.MIN_VALUE;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void q(RecyclerView recyclerView, int i, int i5) {
        nz(i, i5, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void q5(RecyclerView recyclerView, RecyclerView.i4 i4Var) {
        super.q5(recyclerView, i4Var);
        vc(this.f3184ra);
        for (int i = 0; i < this.f3188x; i++) {
            this.f3167b[i].v();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean r() {
        if (this.f3179o == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r3(int r5, androidx.recyclerview.widget.RecyclerView.fh r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.fb r0 = r4.f3181oz
            r1 = 0
            r0.f3237n3 = r1
            r0.f3240zn = r5
            boolean r0 = r4.wf()
            r2 = 1
            if (r0 == 0) goto L2f
            int r6 = r6.zn()
            r0 = -1
            if (r6 == r0) goto L2f
            boolean r0 = r4.f3182q9
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L26
            androidx.recyclerview.widget.f r5 = r4.f3174j5
            int r5 = r5.wz()
        L24:
            r6 = 0
            goto L31
        L26:
            androidx.recyclerview.widget.f r5 = r4.f3174j5
            int r5 = r5.wz()
            r6 = r5
            r5 = 0
            goto L31
        L2f:
            r5 = 0
            goto L24
        L31:
            boolean r0 = r4.k()
            if (r0 == 0) goto L4e
            androidx.recyclerview.widget.fb r0 = r4.f3181oz
            androidx.recyclerview.widget.f r3 = r4.f3174j5
            int r3 = r3.tl()
            int r3 = r3 - r6
            r0.f3233a = r3
            androidx.recyclerview.widget.fb r6 = r4.f3181oz
            androidx.recyclerview.widget.f r0 = r4.f3174j5
            int r0 = r0.c5()
            int r0 = r0 + r5
            r6.f3235fb = r0
            goto L5e
        L4e:
            androidx.recyclerview.widget.fb r0 = r4.f3181oz
            androidx.recyclerview.widget.f r3 = r4.f3174j5
            int r3 = r3.s()
            int r3 = r3 + r5
            r0.f3235fb = r3
            androidx.recyclerview.widget.fb r5 = r4.f3181oz
            int r6 = -r6
            r5.f3233a = r6
        L5e:
            androidx.recyclerview.widget.fb r5 = r4.f3181oz
            r5.f3238s = r1
            r5.y = r2
            androidx.recyclerview.widget.f r6 = r4.f3174j5
            int r6 = r6.f()
            if (r6 != 0) goto L75
            androidx.recyclerview.widget.f r6 = r4.f3174j5
            int r6 = r6.s()
            if (r6 != 0) goto L75
            r1 = 1
        L75:
            r5.f3234c5 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.r3(int, androidx.recyclerview.widget.RecyclerView$fh):void");
    }

    public boolean rt() {
        int mt2 = this.f3167b[0].mt(Integer.MIN_VALUE);
        for (int i = 1; i < this.f3188x; i++) {
            if (this.f3167b[i].mt(Integer.MIN_VALUE) != mt2) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int rz(RecyclerView.fh fhVar) {
        return ou(fhVar);
    }

    public final boolean sh(gv gvVar) {
        if (this.f3182q9) {
            if (gvVar.tl() < this.f3174j5.c5()) {
                ArrayList<View> arrayList = gvVar.y;
                return !gvVar.w(arrayList.get(arrayList.size() - 1)).f3216t;
            }
        } else if (gvVar.p() > this.f3174j5.tl()) {
            return !gvVar.w(gvVar.y.get(0)).f3216t;
        }
        return false;
    }

    public void st(int i) {
        this.f3173j = i / this.f3188x;
        this.f3168ct = View.MeasureSpec.makeMeasureSpec(i, this.f3183qn.f());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean sx() {
        if (this.f3169dm == null) {
            return true;
        }
        return false;
    }

    public final void t3(RecyclerView.i4 i4Var, int i) {
        while (oz() > 0) {
            View j2 = j(0);
            if (this.f3174j5.gv(j2) <= i && this.f3174j5.w(j2) <= i) {
                zn znVar = (zn) j2.getLayoutParams();
                if (znVar.f3216t) {
                    for (int i5 = 0; i5 < this.f3188x; i5++) {
                        if (this.f3167b[i5].y.size() == 1) {
                            return;
                        }
                    }
                    for (int i6 = 0; i6 < this.f3188x; i6++) {
                        this.f3167b[i6].x4();
                    }
                } else if (znVar.f3215f.y.size() == 1) {
                    return;
                } else {
                    znVar.f3215f.x4();
                }
                ic(j2, i4Var);
            } else {
                return;
            }
        }
    }

    public boolean t5() {
        int wz2 = this.f3167b[0].wz(Integer.MIN_VALUE);
        for (int i = 1; i < this.f3188x; i++) {
            if (this.f3167b[i].wz(Integer.MIN_VALUE) != wz2) {
                return false;
            }
        }
        return true;
    }

    public final void t6(RecyclerView.i4 i4Var, int i) {
        for (int oz2 = oz() - 1; oz2 >= 0; oz2--) {
            View j2 = j(oz2);
            if (this.f3174j5.fb(j2) >= i && this.f3174j5.p(j2) >= i) {
                zn znVar = (zn) j2.getLayoutParams();
                if (znVar.f3216t) {
                    for (int i5 = 0; i5 < this.f3188x; i5++) {
                        if (this.f3167b[i5].y.size() == 1) {
                            return;
                        }
                    }
                    for (int i6 = 0; i6 < this.f3188x; i6++) {
                        this.f3167b[i6].r();
                    }
                } else if (znVar.f3215f.y.size() == 1) {
                    return;
                } else {
                    znVar.f3215f.r();
                }
                ic(j2, i4Var);
            } else {
                return;
            }
        }
    }

    public final int t7(int i) {
        int wz2 = this.f3167b[0].wz(i);
        for (int i5 = 1; i5 < this.f3188x; i5++) {
            int wz3 = this.f3167b[i5].wz(i);
            if (wz3 < wz2) {
                wz2 = wz3;
            }
        }
        return wz2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int ta(RecyclerView.fh fhVar) {
        return w7(fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean tg() {
        if (this.f3186u != 0) {
            return true;
        }
        return false;
    }

    public final void ux(View view) {
        for (int i = this.f3188x - 1; i >= 0; i--) {
            this.f3167b[i].y(view);
        }
    }

    public final void vd(n3 n3Var) {
        int tl2;
        SavedState savedState = this.f3169dm;
        int i = savedState.f3197fb;
        if (i > 0) {
            if (i == this.f3188x) {
                for (int i5 = 0; i5 < this.f3188x; i5++) {
                    this.f3167b[i5].v();
                    SavedState savedState2 = this.f3169dm;
                    int i6 = savedState2.f3199s[i5];
                    if (i6 != Integer.MIN_VALUE) {
                        if (savedState2.f3195co) {
                            tl2 = this.f3174j5.c5();
                        } else {
                            tl2 = this.f3174j5.tl();
                        }
                        i6 += tl2;
                    }
                    this.f3167b[i5].f3(i6);
                }
            } else {
                savedState.n3();
                SavedState savedState3 = this.f3169dm;
                savedState3.y = savedState3.f3201v;
            }
        }
        SavedState savedState4 = this.f3169dm;
        this.f3189xg = savedState4.f3203z;
        mf(savedState4.f3198p);
        op();
        SavedState savedState5 = this.f3169dm;
        int i8 = savedState5.y;
        if (i8 != -1) {
            this.f3172f7 = i8;
            n3Var.f3214zn = savedState5.f3195co;
        } else {
            n3Var.f3214zn = this.f3182q9;
        }
        if (savedState5.f3196f > 1) {
            LazySpanLookup lazySpanLookup = this.f3175jz;
            lazySpanLookup.y = savedState5.f3200t;
            lazySpanLookup.f3191n3 = savedState5.f3202w;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p vl() {
        if (this.f3179o == 0) {
            return new zn(-2, -1);
        }
        return new zn(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void vn(RecyclerView recyclerView, int i, int i5) {
        nz(i, i5, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void vp(int i) {
        super.vp(i);
        for (int i5 = 0; i5 < this.f3188x; i5++) {
            this.f3167b[i5].z(i);
        }
    }

    public final void w5(int i, int i5) {
        for (int i6 = 0; i6 < this.f3188x; i6++) {
            if (!this.f3167b[i6].y.isEmpty()) {
                el(this.f3167b[i6], i, i5);
            }
        }
    }

    public final int wb(int i) {
        int wz2 = this.f3167b[0].wz(i);
        for (int i5 = 1; i5 < this.f3188x; i5++) {
            int wz3 = this.f3167b[i5].wz(i);
            if (wz3 > wz2) {
                wz2 = wz3;
            }
        }
        return wz2;
    }

    public boolean wv() {
        if (nf() == 1) {
            return true;
        }
        return false;
    }

    public final void x0(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, boolean z2) {
        int tl2;
        int p2 = p2(Integer.MAX_VALUE);
        if (p2 != Integer.MAX_VALUE && (tl2 = p2 - this.f3174j5.tl()) > 0) {
            int gm = tl2 - gm(tl2, i4Var, fhVar);
            if (z2 && gm > 0) {
                this.f3174j5.mt(-gm);
            }
        }
    }

    public void x2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        p(null);
        if (i == this.f3179o) {
            return;
        }
        this.f3179o = i;
        f fVar = this.f3174j5;
        this.f3174j5 = this.f3183qn;
        this.f3183qn = fVar;
        hr();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean x4() {
        if (this.f3179o == 1) {
            return true;
        }
        return false;
    }

    public void xh() {
        this.f3175jz.n3();
        hr();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void xq(int i) {
        SavedState savedState = this.f3169dm;
        if (savedState != null && savedState.y != i) {
            savedState.y();
        }
        this.f3172f7 = i;
        this.f3171en = Integer.MIN_VALUE;
        hr();
    }

    public View xu(boolean z2) {
        int tl2 = this.f3174j5.tl();
        int c52 = this.f3174j5.c5();
        int oz2 = oz();
        View view = null;
        for (int i = 0; i < oz2; i++) {
            View j2 = j(i);
            int fb2 = this.f3174j5.fb(j2);
            if (this.f3174j5.gv(j2) > tl2 && fb2 < c52) {
                if (fb2 < tl2 && z2) {
                    if (view == null) {
                        view = j2;
                    }
                } else {
                    return j2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d0.n3
    public PointF y(int i) {
        int fp = fp(i);
        PointF pointF = new PointF();
        if (fp == 0) {
            return null;
        }
        if (this.f3179o == 0) {
            pointF.x = fp;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = fp;
        }
        return pointF;
    }

    public final void y0(RecyclerView.i4 i4Var, fb fbVar) {
        int min;
        int min2;
        if (fbVar.y && !fbVar.f3234c5) {
            if (fbVar.f3237n3 == 0) {
                if (fbVar.f3239v == -1) {
                    t6(i4Var, fbVar.f3235fb);
                } else {
                    t3(i4Var, fbVar.f3233a);
                }
            } else if (fbVar.f3239v == -1) {
                int i = fbVar.f3233a;
                int j4 = i - j4(i);
                if (j4 < 0) {
                    min2 = fbVar.f3235fb;
                } else {
                    min2 = fbVar.f3235fb - Math.min(j4, fbVar.f3237n3);
                }
                t6(i4Var, min2);
            } else {
                int t7 = t7(fbVar.f3235fb) - fbVar.f3235fb;
                if (t7 < 0) {
                    min = fbVar.f3233a;
                } else {
                    min = Math.min(t7, fbVar.f3237n3) + fbVar.f3233a;
                }
                t3(i4Var, min);
            }
        }
    }

    public final void yh() {
        this.f3174j5 = f.n3(this, this.f3179o);
        this.f3183qn = f.n3(this, 1 - this.f3179o);
    }

    public int z8() {
        View xu;
        if (this.f3182q9) {
            xu = eu(true);
        } else {
            xu = xu(true);
        }
        if (xu == null) {
            return -1;
        }
        return ap(xu);
    }

    /* loaded from: classes.dex */
    public static class LazySpanLookup {

        /* renamed from: n3  reason: collision with root package name */
        public List<FullSpanItem> f3191n3;
        public int[] y;

        public FullSpanItem a(int i) {
            List<FullSpanItem> list = this.f3191n3;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3191n3.get(size);
                if (fullSpanItem.y == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final int c5(int i) {
            if (this.f3191n3 == null) {
                return -1;
            }
            FullSpanItem a2 = a(i);
            if (a2 != null) {
                this.f3191n3.remove(a2);
            }
            int size = this.f3191n3.size();
            int i5 = 0;
            while (true) {
                if (i5 < size) {
                    if (this.f3191n3.get(i5).y >= i) {
                        break;
                    }
                    i5++;
                } else {
                    i5 = -1;
                    break;
                }
            }
            if (i5 == -1) {
                return -1;
            }
            this.f3191n3.remove(i5);
            return this.f3191n3.get(i5).y;
        }

        public void f(int i, int i5) {
            int[] iArr = this.y;
            if (iArr != null && i < iArr.length) {
                int i6 = i + i5;
                zn(i6);
                int[] iArr2 = this.y;
                System.arraycopy(iArr2, i6, iArr2, i, (iArr2.length - i) - i5);
                int[] iArr3 = this.y;
                Arrays.fill(iArr3, iArr3.length - i5, iArr3.length, -1);
                tl(i, i5);
            }
        }

        public int fb(int i) {
            int[] iArr = this.y;
            if (iArr != null && i < iArr.length) {
                return iArr[i];
            }
            return -1;
        }

        public int gv(int i) {
            List<FullSpanItem> list = this.f3191n3;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f3191n3.get(size).y >= i) {
                        this.f3191n3.remove(size);
                    }
                }
            }
            return s(i);
        }

        public void i9(int i, int i5) {
            int[] iArr = this.y;
            if (iArr != null && i < iArr.length) {
                int i6 = i + i5;
                zn(i6);
                int[] iArr2 = this.y;
                System.arraycopy(iArr2, i, iArr2, i6, (iArr2.length - i) - i5);
                Arrays.fill(this.y, i, i6, -1);
                t(i, i5);
            }
        }

        public void n3() {
            int[] iArr = this.y;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3191n3 = null;
        }

        public int s(int i) {
            int[] iArr = this.y;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int c52 = c5(i);
            if (c52 == -1) {
                int[] iArr2 = this.y;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.y.length;
            }
            int min = Math.min(c52 + 1, this.y.length);
            Arrays.fill(this.y, i, min, -1);
            return min;
        }

        public final void t(int i, int i5) {
            List<FullSpanItem> list = this.f3191n3;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3191n3.get(size);
                int i6 = fullSpanItem.y;
                if (i6 >= i) {
                    fullSpanItem.y = i6 + i5;
                }
            }
        }

        public final void tl(int i, int i5) {
            List<FullSpanItem> list = this.f3191n3;
            if (list == null) {
                return;
            }
            int i6 = i + i5;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3191n3.get(size);
                int i8 = fullSpanItem.y;
                if (i8 >= i) {
                    if (i8 < i6) {
                        this.f3191n3.remove(size);
                    } else {
                        fullSpanItem.y = i8 - i5;
                    }
                }
            }
        }

        public FullSpanItem v(int i, int i5, int i6, boolean z2) {
            List<FullSpanItem> list = this.f3191n3;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                FullSpanItem fullSpanItem = this.f3191n3.get(i8);
                int i10 = fullSpanItem.y;
                if (i10 >= i5) {
                    return null;
                }
                if (i10 >= i && (i6 == 0 || fullSpanItem.f3194v == i6 || (z2 && fullSpanItem.f3193s))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public void wz(int i, gv gvVar) {
            zn(i);
            this.y[i] = gvVar.f3207v;
        }

        public int xc(int i) {
            int length = this.y.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        public void y(FullSpanItem fullSpanItem) {
            if (this.f3191n3 == null) {
                this.f3191n3 = new ArrayList();
            }
            int size = this.f3191n3.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f3191n3.get(i);
                if (fullSpanItem2.y == fullSpanItem.y) {
                    this.f3191n3.remove(i);
                }
                if (fullSpanItem2.y >= fullSpanItem.y) {
                    this.f3191n3.add(i, fullSpanItem);
                    return;
                }
            }
            this.f3191n3.add(fullSpanItem);
        }

        public void zn(int i) {
            int[] iArr = this.y;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.y = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[xc(i)];
                this.y = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.y;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new y();

            /* renamed from: fb  reason: collision with root package name */
            public int[] f3192fb;

            /* renamed from: s  reason: collision with root package name */
            public boolean f3193s;

            /* renamed from: v  reason: collision with root package name */
            public int f3194v;
            public int y;

            /* loaded from: classes.dex */
            public class y implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: n3 */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: y */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.y = parcel.readInt();
                this.f3194v = parcel.readInt();
                this.f3193s = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f3192fb = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.y + ", mGapDir=" + this.f3194v + ", mHasUnwantedGapAfter=" + this.f3193s + ", mGapPerSpan=" + Arrays.toString(this.f3192fb) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.y);
                parcel.writeInt(this.f3194v);
                parcel.writeInt(this.f3193s ? 1 : 0);
                int[] iArr = this.f3192fb;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f3192fb);
                    return;
                }
                parcel.writeInt(0);
            }

            public int y(int i) {
                int[] iArr = this.f3192fb;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public FullSpanItem() {
            }
        }
    }
}
