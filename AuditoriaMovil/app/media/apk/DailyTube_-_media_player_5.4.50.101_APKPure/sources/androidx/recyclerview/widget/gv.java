package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class gv {
    public static final Comparator<C0024gv> y = new y();

    /* loaded from: classes.dex */
    public static abstract class a<T> {
        public abstract boolean n3(@NonNull T t2, @NonNull T t3);

        public abstract boolean y(@NonNull T t2, @NonNull T t3);

        @Nullable
        public Object zn(@NonNull T t2, @NonNull T t3) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class c5 {

        /* renamed from: gv  reason: collision with root package name */
        public int f3241gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3242n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f3243v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3244zn;

        @NonNull
        public C0024gv gv() {
            if (n3()) {
                if (this.f3243v) {
                    return new C0024gv(this.y, this.f3242n3, y());
                }
                if (zn()) {
                    return new C0024gv(this.y, this.f3242n3 + 1, y());
                }
                return new C0024gv(this.y + 1, this.f3242n3, y());
            }
            int i = this.y;
            return new C0024gv(i, this.f3242n3, this.f3244zn - i);
        }

        public boolean n3() {
            if (this.f3241gv - this.f3242n3 != this.f3244zn - this.y) {
                return true;
            }
            return false;
        }

        public int y() {
            return Math.min(this.f3244zn - this.y, this.f3241gv - this.f3242n3);
        }

        public boolean zn() {
            if (this.f3241gv - this.f3242n3 > this.f3244zn - this.y) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class fb {

        /* renamed from: n3  reason: collision with root package name */
        public int f3245n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f3246zn;

        public fb(int i, int i5, boolean z2) {
            this.y = i;
            this.f3245n3 = i5;
            this.f3246zn = z2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0024gv {

        /* renamed from: n3  reason: collision with root package name */
        public final int f3247n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f3248zn;

        public C0024gv(int i, int i5, int i6) {
            this.y = i;
            this.f3247n3 = i5;
            this.f3248zn = i6;
        }

        public int n3() {
            return this.f3247n3 + this.f3248zn;
        }

        public int y() {
            return this.y + this.f3248zn;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n3 {
        public abstract int gv();

        public abstract boolean n3(int i, int i5);

        public abstract int v();

        public abstract boolean y(int i, int i5);

        @Nullable
        public Object zn(int i, int i5) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class s {

        /* renamed from: gv  reason: collision with root package name */
        public int f3249gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3250n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3251zn;

        public s() {
        }

        public int n3() {
            return this.f3250n3 - this.y;
        }

        public int y() {
            return this.f3249gv - this.f3251zn;
        }

        public s(int i, int i5, int i6, int i8) {
            this.y = i;
            this.f3250n3 = i5;
            this.f3251zn = i6;
            this.f3249gv = i8;
        }
    }

    /* loaded from: classes.dex */
    public static class v {

        /* renamed from: a  reason: collision with root package name */
        public final int f3252a;

        /* renamed from: fb  reason: collision with root package name */
        public final boolean f3253fb;

        /* renamed from: gv  reason: collision with root package name */
        public final n3 f3254gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int[] f3255n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f3256v;
        public final List<C0024gv> y;

        /* renamed from: zn  reason: collision with root package name */
        public final int[] f3257zn;

        public v(n3 n3Var, List<C0024gv> list, int[] iArr, int[] iArr2, boolean z2) {
            this.y = list;
            this.f3255n3 = iArr;
            this.f3257zn = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f3254gv = n3Var;
            this.f3256v = n3Var.v();
            this.f3252a = n3Var.gv();
            this.f3253fb = z2;
            y();
            gv();
        }

        @Nullable
        public static fb a(Collection<fb> collection, int i, boolean z2) {
            fb fbVar;
            Iterator<fb> it = collection.iterator();
            while (true) {
                if (it.hasNext()) {
                    fbVar = it.next();
                    if (fbVar.y == i && fbVar.f3246zn == z2) {
                        it.remove();
                        break;
                    }
                } else {
                    fbVar = null;
                    break;
                }
            }
            while (it.hasNext()) {
                fb next = it.next();
                if (z2) {
                    next.f3245n3--;
                } else {
                    next.f3245n3++;
                }
            }
            return fbVar;
        }

        public final void gv() {
            int i;
            for (C0024gv c0024gv : this.y) {
                for (int i5 = 0; i5 < c0024gv.f3248zn; i5++) {
                    int i6 = c0024gv.y + i5;
                    int i8 = c0024gv.f3247n3 + i5;
                    if (this.f3254gv.y(i6, i8)) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    this.f3255n3[i6] = (i8 << 4) | i;
                    this.f3257zn[i8] = (i6 << 4) | i;
                }
            }
            if (this.f3253fb) {
                v();
            }
        }

        public void n3(@NonNull kp.n3 n3Var) {
            kp.y yVar;
            int i;
            if (n3Var instanceof kp.y) {
                yVar = (kp.y) n3Var;
            } else {
                yVar = new kp.y(n3Var);
            }
            int i5 = this.f3256v;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i6 = this.f3256v;
            int i8 = this.f3252a;
            for (int size = this.y.size() - 1; size >= 0; size--) {
                C0024gv c0024gv = this.y.get(size);
                int y = c0024gv.y();
                int n32 = c0024gv.n3();
                while (true) {
                    if (i6 <= y) {
                        break;
                    }
                    i6--;
                    int i10 = this.f3255n3[i6];
                    if ((i10 & 12) != 0) {
                        int i11 = i10 >> 4;
                        fb a2 = a(arrayDeque, i11, false);
                        if (a2 != null) {
                            int i12 = (i5 - a2.f3245n3) - 1;
                            yVar.gv(i6, i12);
                            if ((i10 & 4) != 0) {
                                yVar.zn(i12, 1, this.f3254gv.zn(i6, i11));
                            }
                        } else {
                            arrayDeque.add(new fb(i6, (i5 - i6) - 1, true));
                        }
                    } else {
                        yVar.n3(i6, 1);
                        i5--;
                    }
                }
                while (i8 > n32) {
                    i8--;
                    int i13 = this.f3257zn[i8];
                    if ((i13 & 12) != 0) {
                        int i14 = i13 >> 4;
                        fb a3 = a(arrayDeque, i14, true);
                        if (a3 == null) {
                            arrayDeque.add(new fb(i8, i5 - i6, false));
                        } else {
                            yVar.gv((i5 - a3.f3245n3) - 1, i6);
                            if ((i13 & 4) != 0) {
                                yVar.zn(i6, 1, this.f3254gv.zn(i14, i8));
                            }
                        }
                    } else {
                        yVar.y(i6, 1);
                        i5++;
                    }
                }
                int i15 = c0024gv.y;
                int i16 = c0024gv.f3247n3;
                for (i = 0; i < c0024gv.f3248zn; i++) {
                    if ((this.f3255n3[i15] & 15) == 2) {
                        yVar.zn(i15, 1, this.f3254gv.zn(i15, i16));
                    }
                    i15++;
                    i16++;
                }
                i6 = c0024gv.y;
                i8 = c0024gv.f3247n3;
            }
            yVar.v();
        }

        public final void v() {
            int i = 0;
            for (C0024gv c0024gv : this.y) {
                while (i < c0024gv.y) {
                    if (this.f3255n3[i] == 0) {
                        zn(i);
                    }
                    i++;
                }
                i = c0024gv.y();
            }
        }

        public final void y() {
            C0024gv c0024gv;
            if (this.y.isEmpty()) {
                c0024gv = null;
            } else {
                c0024gv = this.y.get(0);
            }
            if (c0024gv == null || c0024gv.y != 0 || c0024gv.f3247n3 != 0) {
                this.y.add(0, new C0024gv(0, 0, 0));
            }
            this.y.add(new C0024gv(this.f3256v, this.f3252a, 0));
        }

        public final void zn(int i) {
            int i5;
            int size = this.y.size();
            int i6 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                C0024gv c0024gv = this.y.get(i8);
                while (i6 < c0024gv.f3247n3) {
                    if (this.f3257zn[i6] == 0 && this.f3254gv.n3(i, i6)) {
                        if (this.f3254gv.y(i, i6)) {
                            i5 = 8;
                        } else {
                            i5 = 4;
                        }
                        this.f3255n3[i] = (i6 << 4) | i5;
                        this.f3257zn[i6] = (i << 4) | i5;
                        return;
                    }
                    i6++;
                }
                i6 = c0024gv.n3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements Comparator<C0024gv> {
        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(C0024gv c0024gv, C0024gv c0024gv2) {
            return c0024gv.y - c0024gv2.y;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final int f3258n3;
        public final int[] y;

        public zn(int i) {
            int[] iArr = new int[i];
            this.y = iArr;
            this.f3258n3 = iArr.length / 2;
        }

        public int n3(int i) {
            return this.y[i + this.f3258n3];
        }

        public int[] y() {
            return this.y;
        }

        public void zn(int i, int i5) {
            this.y[i + this.f3258n3] = i5;
        }
    }

    @Nullable
    public static c5 gv(s sVar, n3 n3Var, zn znVar, zn znVar2, int i) {
        int n32;
        int i5;
        int i6;
        boolean z2 = true;
        if (Math.abs(sVar.n3() - sVar.y()) % 2 != 1) {
            z2 = false;
        }
        int n33 = sVar.n3() - sVar.y();
        int i8 = -i;
        for (int i10 = i8; i10 <= i; i10 += 2) {
            if (i10 != i8 && (i10 == i || znVar.n3(i10 + 1) <= znVar.n3(i10 - 1))) {
                n32 = znVar.n3(i10 - 1);
                i5 = n32 + 1;
            } else {
                n32 = znVar.n3(i10 + 1);
                i5 = n32;
            }
            int i11 = (sVar.f3251zn + (i5 - sVar.y)) - i10;
            int i12 = (i != 0 && i5 == n32) ? i11 - 1 : i11;
            while (i5 < sVar.f3250n3 && i11 < sVar.f3249gv && n3Var.n3(i5, i11)) {
                i5++;
                i11++;
            }
            znVar.zn(i10, i5);
            if (z2 && (i6 = n33 - i10) >= i8 + 1 && i6 <= i - 1 && znVar2.n3(i6) <= i5) {
                c5 c5Var = new c5();
                c5Var.y = n32;
                c5Var.f3242n3 = i12;
                c5Var.f3244zn = i5;
                c5Var.f3241gv = i11;
                c5Var.f3243v = false;
                return c5Var;
            }
        }
        return null;
    }

    @NonNull
    public static v n3(@NonNull n3 n3Var) {
        return zn(n3Var, true);
    }

    @Nullable
    public static c5 v(s sVar, n3 n3Var, zn znVar, zn znVar2) {
        if (sVar.n3() >= 1 && sVar.y() >= 1) {
            int n32 = ((sVar.n3() + sVar.y()) + 1) / 2;
            znVar.zn(1, sVar.y);
            znVar2.zn(1, sVar.f3250n3);
            for (int i = 0; i < n32; i++) {
                c5 gv2 = gv(sVar, n3Var, znVar, znVar2, i);
                if (gv2 != null) {
                    return gv2;
                }
                c5 y2 = y(sVar, n3Var, znVar, znVar2, i);
                if (y2 != null) {
                    return y2;
                }
            }
        }
        return null;
    }

    @Nullable
    public static c5 y(s sVar, n3 n3Var, zn znVar, zn znVar2, int i) {
        boolean z2;
        int n32;
        int i5;
        int i6;
        int i8;
        if ((sVar.n3() - sVar.y()) % 2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int n33 = sVar.n3() - sVar.y();
        int i10 = -i;
        for (int i11 = i10; i11 <= i; i11 += 2) {
            if (i11 != i10 && (i11 == i || znVar2.n3(i11 + 1) >= znVar2.n3(i11 - 1))) {
                n32 = znVar2.n3(i11 - 1);
                i5 = n32 - 1;
            } else {
                n32 = znVar2.n3(i11 + 1);
                i5 = n32;
            }
            int i12 = sVar.f3249gv - ((sVar.f3250n3 - i5) - i11);
            if (i != 0 && i5 == n32) {
                i6 = i12 + 1;
            } else {
                i6 = i12;
            }
            while (i5 > sVar.y && i12 > sVar.f3251zn && n3Var.n3(i5 - 1, i12 - 1)) {
                i5--;
                i12--;
            }
            znVar2.zn(i11, i5);
            if (z2 && (i8 = n33 - i11) >= i10 && i8 <= i && znVar.n3(i8) >= i5) {
                c5 c5Var = new c5();
                c5Var.y = i5;
                c5Var.f3242n3 = i12;
                c5Var.f3244zn = n32;
                c5Var.f3241gv = i6;
                c5Var.f3243v = true;
                return c5Var;
            }
        }
        return null;
    }

    @NonNull
    public static v zn(@NonNull n3 n3Var, boolean z2) {
        s sVar;
        int v2 = n3Var.v();
        int gv2 = n3Var.gv();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new s(0, v2, 0, gv2));
        int i = ((((v2 + gv2) + 1) / 2) * 2) + 1;
        zn znVar = new zn(i);
        zn znVar2 = new zn(i);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            s sVar2 = (s) arrayList2.remove(arrayList2.size() - 1);
            c5 v3 = v(sVar2, n3Var, znVar, znVar2);
            if (v3 != null) {
                if (v3.y() > 0) {
                    arrayList.add(v3.gv());
                }
                if (arrayList3.isEmpty()) {
                    sVar = new s();
                } else {
                    sVar = (s) arrayList3.remove(arrayList3.size() - 1);
                }
                sVar.y = sVar2.y;
                sVar.f3251zn = sVar2.f3251zn;
                sVar.f3250n3 = v3.y;
                sVar.f3249gv = v3.f3242n3;
                arrayList2.add(sVar);
                sVar2.f3250n3 = sVar2.f3250n3;
                sVar2.f3249gv = sVar2.f3249gv;
                sVar2.y = v3.f3244zn;
                sVar2.f3251zn = v3.f3241gv;
                arrayList2.add(sVar2);
            } else {
                arrayList3.add(sVar2);
            }
        }
        Collections.sort(arrayList, y);
        return new v(n3Var, arrayList, znVar.y(), znVar2.y(), z2);
    }
}
