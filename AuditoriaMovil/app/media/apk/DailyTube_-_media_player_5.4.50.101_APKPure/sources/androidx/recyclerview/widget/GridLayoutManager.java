package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import j5.zn;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: ct  reason: collision with root package name */
    public int f3035ct;

    /* renamed from: dm  reason: collision with root package name */
    public boolean f3036dm;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3037e;

    /* renamed from: eb  reason: collision with root package name */
    public final SparseIntArray f3038eb;

    /* renamed from: lc  reason: collision with root package name */
    public final SparseIntArray f3039lc;

    /* renamed from: nf  reason: collision with root package name */
    public zn f3040nf;

    /* renamed from: o4  reason: collision with root package name */
    public int[] f3041o4;

    /* renamed from: ra  reason: collision with root package name */
    public final Rect f3042ra;

    /* renamed from: rs  reason: collision with root package name */
    public View[] f3043rs;

    /* loaded from: classes.dex */
    public static final class y extends zn {
        @Override // androidx.recyclerview.widget.GridLayoutManager.zn
        public int a(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.zn
        public int v(int i, int i5) {
            return i % i5;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zn {
        public final SparseIntArray y = new SparseIntArray();

        /* renamed from: n3  reason: collision with root package name */
        public final SparseIntArray f3047n3 = new SparseIntArray();

        /* renamed from: zn  reason: collision with root package name */
        public boolean f3048zn = false;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f3046gv = false;

        public static int y(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i5 = 0;
            while (i5 <= size) {
                int i6 = (i5 + size) >>> 1;
                if (sparseIntArray.keyAt(i6) < i) {
                    i5 = i6 + 1;
                } else {
                    size = i6 - 1;
                }
            }
            int i8 = i5 - 1;
            if (i8 >= 0 && i8 < sparseIntArray.size()) {
                return sparseIntArray.keyAt(i8);
            }
            return -1;
        }

        public abstract int a(int i);

        public void fb() {
            this.f3047n3.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int gv(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.f3046gv
                r1 = 0
                if (r0 == 0) goto L25
                android.util.SparseIntArray r0 = r6.f3047n3
                int r0 = y(r0, r7)
                r2 = -1
                if (r0 == r2) goto L25
                android.util.SparseIntArray r2 = r6.f3047n3
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.zn(r0, r8)
                int r0 = r6.a(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L28
                int r2 = r2 + 1
            L23:
                r4 = 0
                goto L28
            L25:
                r2 = 0
                r3 = 0
                goto L23
            L28:
                int r0 = r6.a(r7)
            L2c:
                if (r3 >= r7) goto L41
                int r5 = r6.a(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L39
                int r2 = r2 + 1
                r4 = 0
                goto L3e
            L39:
                if (r4 <= r8) goto L3e
                int r2 = r2 + 1
                r4 = r5
            L3e:
                int r3 = r3 + 1
                goto L2c
            L41:
                int r4 = r4 + r0
                if (r4 <= r8) goto L46
                int r2 = r2 + 1
            L46:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.zn.gv(int, int):int");
        }

        public int n3(int i, int i5) {
            if (!this.f3046gv) {
                return gv(i, i5);
            }
            int i6 = this.f3047n3.get(i, -1);
            if (i6 != -1) {
                return i6;
            }
            int gv2 = gv(i, i5);
            this.f3047n3.put(i, gv2);
            return gv2;
        }

        public void s() {
            this.y.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int v(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.a(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f3048zn
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.y
                int r2 = y(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.y
                int r3 = r3.get(r2)
                int r4 = r5.a(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = 0
                r3 = 0
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.a(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = 0
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.zn.v(int, int):int");
        }

        public int zn(int i, int i5) {
            if (!this.f3048zn) {
                return v(i, i5);
            }
            int i6 = this.y.get(i, -1);
            if (i6 != -1) {
                return i6;
            }
            int v2 = v(i, i5);
            this.y.put(i, v2);
            return v2;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i5) {
        super(context, attributeSet, i, i5);
        this.f3035ct = -1;
        this.f3038eb = new SparseIntArray();
        this.f3039lc = new SparseIntArray();
        this.f3040nf = new y();
        this.f3042ra = new Rect();
        zv(RecyclerView.w.yg(context, attributeSet, i, i5).f3161n3);
    }

    public static int[] r3(int[] iArr, int i, int i5) {
        int i6;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i5) {
            iArr = new int[i + 1];
        }
        int i8 = 0;
        iArr[0] = 0;
        int i10 = i5 / i;
        int i11 = i5 % i;
        int i12 = 0;
        for (int i13 = 1; i13 <= i; i13++) {
            i8 += i11;
            if (i8 > 0 && i - i8 < i11) {
                i6 = i10 + 1;
                i8 -= i;
            } else {
                i6 = i10;
            }
            i12 += i6;
            iArr[i13] = i12;
        }
        return iArr;
    }

    public final void ah(View view, int i, int i5, boolean z2) {
        boolean wo;
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z2) {
            wo = hb(view, i, i5, pVar);
        } else {
            wo = wo(view, i, i5, pVar);
        }
        if (wo) {
            view.measure(i, i5);
        }
    }

    public final void aj(View view, int i, boolean z2) {
        int i5;
        int i6;
        n3 n3Var = (n3) view.getLayoutParams();
        Rect rect = n3Var.f3131v;
        int i8 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) n3Var).topMargin + ((ViewGroup.MarginLayoutParams) n3Var).bottomMargin;
        int i10 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) n3Var).leftMargin + ((ViewGroup.MarginLayoutParams) n3Var).rightMargin;
        int oj = oj(n3Var.f3044f, n3Var.f3045t);
        if (this.f3062x == 1) {
            i6 = RecyclerView.w.ut(oj, i, i10, ((ViewGroup.MarginLayoutParams) n3Var).width, false);
            i5 = RecyclerView.w.ut(this.f3053j5.wz(), eb(), i8, ((ViewGroup.MarginLayoutParams) n3Var).height, true);
        } else {
            int ut2 = RecyclerView.w.ut(oj, i, i8, ((ViewGroup.MarginLayoutParams) n3Var).height, false);
            int ut3 = RecyclerView.w.ut(this.f3053j5.wz(), u0(), i10, ((ViewGroup.MarginLayoutParams) n3Var).width, true);
            i5 = ut2;
            i6 = ut3;
        }
        ah(view, i6, i5, z2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public void bv(RecyclerView.fh fhVar) {
        super.bv(fhVar);
        this.f3036dm = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public int d(RecyclerView.fh fhVar) {
        if (this.f3037e) {
            return g6(fhVar);
        }
        return super.d(fhVar);
    }

    public final int el(RecyclerView.fh fhVar) {
        int max;
        if (oz() != 0 && fhVar.n3() != 0) {
            sh();
            boolean p2 = p2();
            View l3 = l3(!p2, true);
            View vi = vi(!p2, true);
            if (l3 != null && vi != null) {
                int n32 = this.f3040nf.n3(ap(l3), this.f3035ct);
                int n33 = this.f3040nf.n3(ap(vi), this.f3035ct);
                int min = Math.min(n32, n33);
                int max2 = Math.max(n32, n33);
                int n34 = this.f3040nf.n3(fhVar.n3() - 1, this.f3035ct) + 1;
                if (this.f3052j) {
                    max = Math.max(0, (n34 - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (!p2) {
                    return max;
                }
                return Math.round((max * (Math.abs(this.f3053j5.gv(vi) - this.f3053j5.fb(l3)) / ((this.f3040nf.n3(ap(vi), this.f3035ct) - this.f3040nf.n3(ap(l3), this.f3035ct)) + 1))) + (this.f3053j5.tl() - this.f3053j5.fb(l3)));
            }
        }
        return 0;
    }

    public final void ex() {
        int rs2;
        int paddingTop;
        if (j4() == 1) {
            rs2 = g() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            rs2 = rs() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        ni(rs2 - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int f7(RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        if (this.f3062x == 1) {
            return this.f3035ct;
        }
        if (fhVar.n3() < 1) {
            return 0;
        }
        return xd(i4Var, fhVar, fhVar.n3() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public int fh(RecyclerView.fh fhVar) {
        if (this.f3037e) {
            return el(fhVar);
        }
        return super.fh(fhVar);
    }

    public final int g6(RecyclerView.fh fhVar) {
        if (oz() != 0 && fhVar.n3() != 0) {
            sh();
            View l3 = l3(!p2(), true);
            View vi = vi(!p2(), true);
            if (l3 != null && vi != null) {
                if (!p2()) {
                    return this.f3040nf.n3(fhVar.n3() - 1, this.f3035ct) + 1;
                }
                int gv2 = this.f3053j5.gv(vi) - this.f3053j5.fb(l3);
                int n32 = this.f3040nf.n3(ap(l3), this.f3035ct);
                return (int) ((gv2 / ((this.f3040nf.n3(ap(vi), this.f3035ct) - n32) + 1)) * (this.f3040nf.n3(fhVar.n3() - 1, this.f3035ct) + 1));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public void gf(RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        if (fhVar.v()) {
            ik();
        }
        super.gf(i4Var, fhVar);
        st();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void gi(Rect rect, int i, int i5) {
        int f32;
        int f33;
        if (this.f3041o4 == null) {
            super.gi(rect, i, i5);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f3062x == 1) {
            f33 = RecyclerView.w.f3(i5, rect.height() + paddingTop, e());
            int[] iArr = this.f3041o4;
            f32 = RecyclerView.w.f3(i, iArr[iArr.length - 1] + paddingLeft, s8());
        } else {
            f32 = RecyclerView.w.f3(i, rect.width() + paddingLeft, s8());
            int[] iArr2 = this.f3041o4;
            f33 = RecyclerView.w.f3(i5, iArr2[iArr2.length - 1] + paddingTop, e());
        }
        v1(f32, f33);
    }

    public zn gy() {
        return this.f3040nf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p hw(Context context, AttributeSet attributeSet) {
        return new n3(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public int hy(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        ex();
        yz();
        return super.hy(i, i4Var, fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void i2(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, View view, j5.zn znVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof n3)) {
            super.yk(view, znVar);
            return;
        }
        n3 n3Var = (n3) layoutParams;
        int xd = xd(i4Var, fhVar, n3Var.y());
        if (this.f3062x == 0) {
            znVar.yg(zn.fb.y(n3Var.v(), n3Var.fb(), xd, 1, false, false));
        } else {
            znVar.yg(zn.fb.y(xd, 1, n3Var.v(), n3Var.fb(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public boolean i4(RecyclerView.p pVar) {
        return pVar instanceof n3;
    }

    public final void ik() {
        int oz2 = oz();
        for (int i = 0; i < oz2; i++) {
            n3 n3Var = (n3) j(i).getLayoutParams();
            int y2 = n3Var.y();
            this.f3038eb.put(y2, n3Var.fb());
            this.f3039lc.put(y2, n3Var.v());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        r21.f3068n3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void iu(androidx.recyclerview.widget.RecyclerView.i4 r18, androidx.recyclerview.widget.RecyclerView.fh r19, androidx.recyclerview.widget.LinearLayoutManager.zn r20, androidx.recyclerview.widget.LinearLayoutManager.n3 r21) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.iu(androidx.recyclerview.widget.RecyclerView$i4, androidx.recyclerview.widget.RecyclerView$fh, androidx.recyclerview.widget.LinearLayoutManager$zn, androidx.recyclerview.widget.LinearLayoutManager$n3):void");
    }

    public int iv() {
        return this.f3035ct;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void j3(RecyclerView recyclerView) {
        this.f3040nf.s();
        this.f3040nf.fb();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p j5(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new n3((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new n3(layoutParams);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View jm(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, boolean z2, boolean z3) {
        int i;
        int i5;
        int oz2 = oz();
        int i6 = 1;
        if (z3) {
            i5 = oz() - 1;
            i = -1;
            i6 = -1;
        } else {
            i = oz2;
            i5 = 0;
        }
        int n32 = fhVar.n3();
        sh();
        int tl2 = this.f3053j5.tl();
        int c52 = this.f3053j5.c5();
        View view = null;
        View view2 = null;
        while (i5 != i) {
            View j2 = j(i5);
            int ap2 = ap(j2);
            if (ap2 >= 0 && ap2 < n32 && r5(i4Var, fhVar, ap2) == 0) {
                if (((RecyclerView.p) j2.getLayoutParams()).zn()) {
                    if (view2 == null) {
                        view2 = j2;
                    }
                } else if (this.f3053j5.fb(j2) < c52 && this.f3053j5.gv(j2) >= tl2) {
                    return j2;
                } else {
                    if (view == null) {
                        view = j2;
                    }
                }
            }
            i5 += i6;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public int jt(int i, RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        ex();
        yz();
        return super.jt(i, i4Var, fhVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public int kp(RecyclerView.i4 i4Var, RecyclerView.fh fhVar) {
        if (this.f3062x == 0) {
            return this.f3035ct;
        }
        if (fhVar.n3() < 1) {
            return 0;
        }
        return xd(i4Var, fhVar, fhVar.n3() - 1) + 1;
    }

    public final void ky(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, LinearLayoutManager.y yVar, int i) {
        boolean z2;
        if (i == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int r5 = r5(i4Var, fhVar, yVar.f3071n3);
        if (z2) {
            while (r5 > 0) {
                int i5 = yVar.f3071n3;
                if (i5 > 0) {
                    int i6 = i5 - 1;
                    yVar.f3071n3 = i6;
                    r5 = r5(i4Var, fhVar, i6);
                } else {
                    return;
                }
            }
            return;
        }
        int n32 = fhVar.n3() - 1;
        int i8 = yVar.f3071n3;
        while (i8 < n32) {
            int i10 = i8 + 1;
            int r52 = r5(i4Var, fhVar, i10);
            if (r52 <= r5) {
                break;
            }
            i8 = i10;
            r5 = r52;
        }
        yVar.f3071n3 = i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
        if (r13 == r7) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f1, code lost:
        if (r13 == r10) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View mp(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.i4 r26, androidx.recyclerview.widget.RecyclerView.fh r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.mp(android.view.View, int, androidx.recyclerview.widget.RecyclerView$i4, androidx.recyclerview.widget.RecyclerView$fh):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void nd(RecyclerView recyclerView, int i, int i5, Object obj) {
        this.f3040nf.s();
        this.f3040nf.fb();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void ne(RecyclerView recyclerView, int i, int i5, int i6) {
        this.f3040nf.s();
        this.f3040nf.fb();
    }

    public final void ni(int i) {
        this.f3041o4 = r3(this.f3041o4, this.f3035ct, i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void nz(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, LinearLayoutManager.y yVar, int i) {
        super.nz(i4Var, fhVar, yVar, i);
        ex();
        if (fhVar.n3() > 0 && !fhVar.v()) {
            ky(i4Var, fhVar, yVar, i);
        }
        yz();
    }

    public int oj(int i, int i5) {
        if (this.f3062x == 1 && t7()) {
            int[] iArr = this.f3041o4;
            int i6 = this.f3035ct;
            return iArr[i6 - i] - iArr[(i6 - i) - i5];
        }
        int[] iArr2 = this.f3041o4;
        return iArr2[i5 + i] - iArr2[i];
    }

    public final void p4(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, int i, boolean z2) {
        int i5;
        int i6;
        int i8;
        int i10 = 0;
        if (z2) {
            i6 = i;
            i5 = 0;
            i8 = 1;
        } else {
            i5 = i - 1;
            i6 = -1;
            i8 = -1;
        }
        while (i5 != i6) {
            View view = this.f3043rs[i5];
            n3 n3Var = (n3) view.getLayoutParams();
            int pk = pk(i4Var, fhVar, ap(view));
            n3Var.f3045t = pk;
            n3Var.f3044f = i10;
            i10 += pk;
            i5 += i8;
        }
    }

    public final int pk(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, int i) {
        if (!fhVar.v()) {
            return this.f3040nf.a(i);
        }
        int i5 = this.f3038eb.get(i, -1);
        if (i5 != -1) {
            return i5;
        }
        int a2 = i4Var.a(i);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.f3040nf.a(a2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void q(RecyclerView recyclerView, int i, int i5) {
        this.f3040nf.s();
        this.f3040nf.fb();
    }

    public final int r5(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, int i) {
        if (!fhVar.v()) {
            return this.f3040nf.zn(i, this.f3035ct);
        }
        int i5 = this.f3039lc.get(i, -1);
        if (i5 != -1) {
            return i5;
        }
        int a2 = i4Var.a(i);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.f3040nf.zn(a2, this.f3035ct);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public int rz(RecyclerView.fh fhVar) {
        if (this.f3037e) {
            return g6(fhVar);
        }
        return super.rz(fhVar);
    }

    public final void s0(float f4, int i) {
        ni(Math.max(Math.round(f4 * this.f3035ct), i));
    }

    public final void st() {
        this.f3038eb.clear();
        this.f3039lc.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public boolean sx() {
        if (this.f3050en == null && !this.f3036dm) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void t3(boolean z2) {
        if (!z2) {
            super.t3(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public int ta(RecyclerView.fh fhVar) {
        if (this.f3037e) {
            return el(fhVar);
        }
        return super.ta(fhVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void vd(RecyclerView.fh fhVar, LinearLayoutManager.zn znVar, RecyclerView.w.zn znVar2) {
        int i = this.f3035ct;
        for (int i5 = 0; i5 < this.f3035ct && znVar.zn(fhVar) && i > 0; i5++) {
            int i6 = znVar.f3078gv;
            znVar2.y(i6, Math.max(0, znVar.f3077fb));
            i -= this.f3040nf.a(i6);
            znVar.f3078gv += znVar.f3084v;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.w
    public RecyclerView.p vl() {
        if (this.f3062x == 0) {
            return new n3(-2, -1);
        }
        return new n3(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void vn(RecyclerView recyclerView, int i, int i5) {
        this.f3040nf.s();
        this.f3040nf.fb();
    }

    public final int xd(RecyclerView.i4 i4Var, RecyclerView.fh fhVar, int i) {
        if (!fhVar.v()) {
            return this.f3040nf.n3(i, this.f3035ct);
        }
        int a2 = i4Var.a(i);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.f3040nf.n3(a2, this.f3035ct);
    }

    public void xe(zn znVar) {
        this.f3040nf = znVar;
    }

    public final void yz() {
        View[] viewArr = this.f3043rs;
        if (viewArr == null || viewArr.length != this.f3035ct) {
            this.f3043rs = new View[this.f3035ct];
        }
    }

    public void zv(int i) {
        if (i == this.f3035ct) {
            return;
        }
        this.f3036dm = true;
        if (i >= 1) {
            this.f3035ct = i;
            this.f3040nf.s();
            hr();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
    }

    /* loaded from: classes.dex */
    public static class n3 extends RecyclerView.p {

        /* renamed from: f  reason: collision with root package name */
        public int f3044f;

        /* renamed from: t  reason: collision with root package name */
        public int f3045t;

        public n3(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3044f = -1;
        }

        public int fb() {
            return this.f3045t;
        }

        public int v() {
            return this.f3044f;
        }

        public n3(int i, int i5) {
            super(i, i5);
            this.f3044f = -1;
        }

        public n3(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3044f = -1;
        }

        public n3(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3044f = -1;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f3035ct = -1;
        this.f3038eb = new SparseIntArray();
        this.f3039lc = new SparseIntArray();
        this.f3040nf = new y();
        this.f3042ra = new Rect();
        zv(i);
    }

    public GridLayoutManager(Context context, int i, int i5, boolean z2) {
        super(context, i5, z2);
        this.f3035ct = -1;
        this.f3038eb = new SparseIntArray();
        this.f3039lc = new SparseIntArray();
        this.f3040nf = new y();
        this.f3042ra = new Rect();
        zv(i);
    }
}
