package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadLocal<a> f3217f = new ThreadLocal<>();

    /* renamed from: t  reason: collision with root package name */
    public static Comparator<zn> f3218t = new y();

    /* renamed from: fb  reason: collision with root package name */
    public long f3219fb;

    /* renamed from: v  reason: collision with root package name */
    public long f3221v;
    public ArrayList<RecyclerView> y = new ArrayList<>();

    /* renamed from: s  reason: collision with root package name */
    public ArrayList<zn> f3220s = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class n3 implements RecyclerView.w.zn {

        /* renamed from: gv  reason: collision with root package name */
        public int f3222gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3223n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int[] f3224zn;

        public boolean gv(int i) {
            if (this.f3224zn != null) {
                int i5 = this.f3222gv * 2;
                for (int i6 = 0; i6 < i5; i6 += 2) {
                    if (this.f3224zn[i6] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void n3() {
            int[] iArr = this.f3224zn;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3222gv = 0;
        }

        public void v(int i, int i5) {
            this.y = i;
            this.f3223n3 = i5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.w.zn
        public void y(int i, int i5) {
            if (i >= 0) {
                if (i5 >= 0) {
                    int i6 = this.f3222gv;
                    int i8 = i6 * 2;
                    int[] iArr = this.f3224zn;
                    if (iArr == null) {
                        int[] iArr2 = new int[4];
                        this.f3224zn = iArr2;
                        Arrays.fill(iArr2, -1);
                    } else if (i8 >= iArr.length) {
                        int[] iArr3 = new int[i6 * 4];
                        this.f3224zn = iArr3;
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    }
                    int[] iArr4 = this.f3224zn;
                    iArr4[i8] = i;
                    iArr4[i8 + 1] = i5;
                    this.f3222gv++;
                    return;
                }
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public void zn(RecyclerView recyclerView, boolean z2) {
            this.f3222gv = 0;
            int[] iArr = this.f3224zn;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.w wVar = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && wVar != null && wVar.pq()) {
                if (z2) {
                    if (!recyclerView.mAdapterHelper.w()) {
                        wVar.c(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    wVar.n(this.y, this.f3223n3, recyclerView.mState, this);
                }
                int i = this.f3222gv;
                if (i > wVar.f3152n) {
                    wVar.f3152n = i;
                    wVar.f3143c = z2;
                    recyclerView.mRecycler.x();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements Comparator<zn> {
        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(zn znVar, zn znVar2) {
            boolean z2;
            boolean z3;
            RecyclerView recyclerView = znVar.f3225gv;
            if (recyclerView == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (znVar2.f3225gv == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                if (recyclerView == null) {
                    return 1;
                }
                return -1;
            }
            boolean z4 = znVar.y;
            if (z4 != znVar2.y) {
                if (!z4) {
                    return 1;
                }
                return -1;
            }
            int i = znVar2.f3226n3 - znVar.f3226n3;
            if (i != 0) {
                return i;
            }
            int i5 = znVar.f3228zn - znVar2.f3228zn;
            if (i5 == 0) {
                return 0;
            }
            return i5;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: gv  reason: collision with root package name */
        public RecyclerView f3225gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3226n3;

        /* renamed from: v  reason: collision with root package name */
        public int f3227v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3228zn;

        public void y() {
            this.y = false;
            this.f3226n3 = 0;
            this.f3228zn = 0;
            this.f3225gv = null;
            this.f3227v = 0;
        }
    }

    public static boolean v(RecyclerView recyclerView, int i) {
        int i92 = recyclerView.mChildHelper.i9();
        for (int i5 = 0; i5 < i92; i5++) {
            RecyclerView.ta childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.c5(i5));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView, int i, int i5) {
        if (recyclerView.isAttachedToWindow() && this.f3221v == 0) {
            this.f3221v = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.v(i, i5);
    }

    public final RecyclerView.ta c5(RecyclerView recyclerView, int i, long j2) {
        if (v(recyclerView, i)) {
            return null;
        }
        RecyclerView.i4 i4Var = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ta ud2 = i4Var.ud(i, false, j2);
            if (ud2 != null) {
                if (ud2.isBound() && !ud2.isInvalid()) {
                    i4Var.fh(ud2.itemView);
                } else {
                    i4Var.y(ud2, false);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return ud2;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th;
        }
    }

    public void fb(long j2) {
        n3();
        gv(j2);
    }

    public final void gv(long j2) {
        for (int i = 0; i < this.f3220s.size(); i++) {
            zn znVar = this.f3220s.get(i);
            if (znVar.f3225gv != null) {
                zn(znVar, j2);
                znVar.y();
            } else {
                return;
            }
        }
    }

    public void i9(RecyclerView recyclerView) {
        this.y.remove(recyclerView);
    }

    public final void n3() {
        zn znVar;
        boolean z2;
        int size = this.y.size();
        int i = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView = this.y.get(i5);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.zn(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.f3222gv;
            }
        }
        this.f3220s.ensureCapacity(i);
        int i6 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView recyclerView2 = this.y.get(i8);
            if (recyclerView2.getWindowVisibility() == 0) {
                n3 n3Var = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(n3Var.y) + Math.abs(n3Var.f3223n3);
                for (int i10 = 0; i10 < n3Var.f3222gv * 2; i10 += 2) {
                    if (i6 >= this.f3220s.size()) {
                        znVar = new zn();
                        this.f3220s.add(znVar);
                    } else {
                        znVar = this.f3220s.get(i6);
                    }
                    int[] iArr = n3Var.f3224zn;
                    int i11 = iArr[i10 + 1];
                    if (i11 <= abs) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    znVar.y = z2;
                    znVar.f3226n3 = abs;
                    znVar.f3228zn = i11;
                    znVar.f3225gv = recyclerView2;
                    znVar.f3227v = iArr[i10];
                    i6++;
                }
            }
        }
        Collections.sort(this.f3220s, f3218t);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.xc.y("RV Prefetch");
            if (!this.y.isEmpty()) {
                int size = this.y.size();
                long j2 = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.y.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    fb(TimeUnit.MILLISECONDS.toNanos(j2) + this.f3219fb);
                    this.f3221v = 0L;
                    b.xc.n3();
                }
            }
        } finally {
            this.f3221v = 0L;
            b.xc.n3();
        }
    }

    public final void s(@Nullable RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.i9() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        n3 n3Var = recyclerView.mPrefetchRegistry;
        n3Var.zn(recyclerView, true);
        if (n3Var.f3222gv != 0) {
            try {
                b.xc.y("RV Nested Prefetch");
                recyclerView.mState.a(recyclerView.mAdapter);
                for (int i = 0; i < n3Var.f3222gv * 2; i += 2) {
                    c5(recyclerView, n3Var.f3224zn[i], j2);
                }
            } finally {
                b.xc.n3();
            }
        }
    }

    public void y(RecyclerView recyclerView) {
        this.y.add(recyclerView);
    }

    public final void zn(zn znVar, long j2) {
        long j4;
        if (znVar.y) {
            j4 = Long.MAX_VALUE;
        } else {
            j4 = j2;
        }
        RecyclerView.ta c52 = c5(znVar.f3225gv, znVar.f3227v, j4);
        if (c52 != null && c52.mNestedRecyclerView != null && c52.isBound() && !c52.isInvalid()) {
            s(c52.mNestedRecyclerView.get(), j2);
        }
    }
}
