package kx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kx.hw;
/* loaded from: classes.dex */
public class hw {

    /* renamed from: a  reason: collision with root package name */
    public int f10031a;

    /* renamed from: fb  reason: collision with root package name */
    public int f10032fb;

    /* renamed from: v  reason: collision with root package name */
    public int f10035v;
    public final int y;

    /* renamed from: s  reason: collision with root package name */
    public static final Comparator<n3> f10030s = new Comparator() { // from class: kx.yt
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int fb2;
            fb2 = hw.fb((hw.n3) obj, (hw.n3) obj2);
            return fb2;
        }
    };

    /* renamed from: c5  reason: collision with root package name */
    public static final Comparator<n3> f10029c5 = new Comparator() { // from class: kx.vl
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int s2;
            s2 = hw.s((hw.n3) obj, (hw.n3) obj2);
            return s2;
        }
    };

    /* renamed from: zn  reason: collision with root package name */
    public final n3[] f10036zn = new n3[5];

    /* renamed from: n3  reason: collision with root package name */
    public final ArrayList<n3> f10034n3 = new ArrayList<>();

    /* renamed from: gv  reason: collision with root package name */
    public int f10033gv = -1;

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public int f10037n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public float f10038zn;

        public n3() {
        }
    }

    public hw(int i) {
        this.y = i;
    }

    public static /* synthetic */ int fb(n3 n3Var, n3 n3Var2) {
        return n3Var.y - n3Var2.y;
    }

    public static /* synthetic */ int s(n3 n3Var, n3 n3Var2) {
        return Float.compare(n3Var.f10038zn, n3Var2.f10038zn);
    }

    public float a(float f4) {
        v();
        float f6 = f4 * this.f10031a;
        int i = 0;
        for (int i5 = 0; i5 < this.f10034n3.size(); i5++) {
            n3 n3Var = this.f10034n3.get(i5);
            i += n3Var.f10037n3;
            if (i >= f6) {
                return n3Var.f10038zn;
            }
        }
        if (this.f10034n3.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<n3> arrayList = this.f10034n3;
        return arrayList.get(arrayList.size() - 1).f10038zn;
    }

    public void c5() {
        this.f10034n3.clear();
        this.f10033gv = -1;
        this.f10035v = 0;
        this.f10031a = 0;
    }

    public final void gv() {
        if (this.f10033gv != 1) {
            Collections.sort(this.f10034n3, f10030s);
            this.f10033gv = 1;
        }
    }

    public final void v() {
        if (this.f10033gv != 0) {
            Collections.sort(this.f10034n3, f10029c5);
            this.f10033gv = 0;
        }
    }

    public void zn(int i, float f4) {
        n3 n3Var;
        gv();
        int i5 = this.f10032fb;
        if (i5 > 0) {
            n3[] n3VarArr = this.f10036zn;
            int i6 = i5 - 1;
            this.f10032fb = i6;
            n3Var = n3VarArr[i6];
        } else {
            n3Var = new n3();
        }
        int i8 = this.f10035v;
        this.f10035v = i8 + 1;
        n3Var.y = i8;
        n3Var.f10037n3 = i;
        n3Var.f10038zn = f4;
        this.f10034n3.add(n3Var);
        this.f10031a += i;
        while (true) {
            int i10 = this.f10031a;
            int i11 = this.y;
            if (i10 > i11) {
                int i12 = i10 - i11;
                n3 n3Var2 = this.f10034n3.get(0);
                int i13 = n3Var2.f10037n3;
                if (i13 <= i12) {
                    this.f10031a -= i13;
                    this.f10034n3.remove(0);
                    int i14 = this.f10032fb;
                    if (i14 < 5) {
                        n3[] n3VarArr2 = this.f10036zn;
                        this.f10032fb = i14 + 1;
                        n3VarArr2[i14] = n3Var2;
                    }
                } else {
                    n3Var2.f10037n3 = i13 - i12;
                    this.f10031a -= i12;
                }
            } else {
                return;
            }
        }
    }
}
