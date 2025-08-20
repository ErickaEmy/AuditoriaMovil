package zo;

import af.lc;
import af.mg;
import af.rs;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import m1.hk;
import m1.hy;
import m1.ic;
import m1.k3;
import v5.j5;
/* loaded from: classes.dex */
public abstract class r extends fh {
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public y f15764zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public final int[][][] f15765a;

        /* renamed from: fb  reason: collision with root package name */
        public final lc f15766fb;

        /* renamed from: gv  reason: collision with root package name */
        public final lc[] f15767gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String[] f15768n3;

        /* renamed from: v  reason: collision with root package name */
        public final int[] f15769v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int[] f15770zn;

        public y(String[] strArr, int[] iArr, lc[] lcVarArr, int[] iArr2, int[][][] iArr3, lc lcVar) {
            this.f15768n3 = strArr;
            this.f15770zn = iArr;
            this.f15767gv = lcVarArr;
            this.f15765a = iArr3;
            this.f15769v = iArr2;
            this.f15766fb = lcVar;
            this.y = iArr.length;
        }

        public lc a(int i) {
            return this.f15767gv[i];
        }

        public int fb(int i, int i5, int i6) {
            return hk.a(zn(i, i5, i6));
        }

        public int gv() {
            return this.y;
        }

        public int n3(int i, int i5, int[] iArr) {
            int i6 = 0;
            String str = null;
            boolean z2 = false;
            int i8 = 0;
            int i10 = 16;
            while (i6 < iArr.length) {
                String str2 = this.f15767gv[i].n3(i5).zn(iArr[i6]).f10948f3;
                int i11 = i8 + 1;
                if (i8 == 0) {
                    str = str2;
                } else {
                    z2 |= !j5.zn(str, str2);
                }
                i10 = Math.min(i10, hk.gv(this.f15765a[i][i5][i6]));
                i6++;
                i8 = i11;
            }
            if (z2) {
                return Math.min(i10, this.f15769v[i]);
            }
            return i10;
        }

        public lc s() {
            return this.f15766fb;
        }

        public int v(int i) {
            return this.f15770zn[i];
        }

        public int y(int i, int i5, boolean z2) {
            int i6 = this.f15767gv[i].n3(i5).y;
            int[] iArr = new int[i6];
            int i8 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int fb2 = fb(i, i5, i10);
                if (fb2 == 4 || (z2 && fb2 == 3)) {
                    iArr[i8] = i10;
                    i8++;
                }
            }
            return n3(i, i5, Arrays.copyOf(iArr, i8));
        }

        public int zn(int i, int i5, int i6) {
            return this.f15765a[i][i5][i6];
        }
    }

    public static int[] p(k3[] k3VarArr) throws m1.p {
        int length = k3VarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = k3VarArr[i].co();
        }
        return iArr;
    }

    public static int[] w(k3 k3Var, rs rsVar) throws m1.p {
        int[] iArr = new int[rsVar.y];
        for (int i = 0; i < rsVar.y; i++) {
            iArr[i] = k3Var.n3(rsVar.zn(i));
        }
        return iArr;
    }

    public static int wz(k3[] k3VarArr, rs rsVar, int[] iArr, boolean z2) throws m1.p {
        boolean z3;
        int length = k3VarArr.length;
        int i = 0;
        boolean z4 = true;
        for (int i5 = 0; i5 < k3VarArr.length; i5++) {
            k3 k3Var = k3VarArr[i5];
            int i6 = 0;
            for (int i8 = 0; i8 < rsVar.y; i8++) {
                i6 = Math.max(i6, hk.a(k3Var.n3(rsVar.zn(i8))));
            }
            if (iArr[i5] == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (i6 > i || (i6 == i && z2 && !z4 && z3)) {
                length = i5;
                z4 = z3;
                i = i6;
            }
        }
        return length;
    }

    @Override // zo.fh
    public final void c5(@Nullable Object obj) {
        this.f15764zn = (y) obj;
    }

    @Override // zo.fh
    public final rz f(k3[] k3VarArr, lc lcVar, mg.n3 n3Var, hy hyVar) throws m1.p {
        boolean z2;
        int[] w4;
        int[] iArr = new int[k3VarArr.length + 1];
        int length = k3VarArr.length + 1;
        rs[][] rsVarArr = new rs[length];
        int[][][] iArr2 = new int[k3VarArr.length + 1][];
        for (int i = 0; i < length; i++) {
            int i5 = lcVar.y;
            rsVarArr[i] = new rs[i5];
            iArr2[i] = new int[i5];
        }
        int[] p2 = p(k3VarArr);
        for (int i6 = 0; i6 < lcVar.y; i6++) {
            rs n32 = lcVar.n3(i6);
            if (n32.f379fb == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            int wz2 = wz(k3VarArr, n32, iArr, z2);
            if (wz2 == k3VarArr.length) {
                w4 = new int[n32.y];
            } else {
                w4 = w(k3VarArr[wz2], n32);
            }
            int i8 = iArr[wz2];
            rsVarArr[wz2][i8] = n32;
            iArr2[wz2][i8] = w4;
            iArr[wz2] = i8 + 1;
        }
        lc[] lcVarArr = new lc[k3VarArr.length];
        String[] strArr = new String[k3VarArr.length];
        int[] iArr3 = new int[k3VarArr.length];
        for (int i10 = 0; i10 < k3VarArr.length; i10++) {
            int i11 = iArr[i10];
            lcVarArr[i10] = new lc((rs[]) j5.qj(rsVarArr[i10], i11));
            iArr2[i10] = (int[][]) j5.qj(iArr2[i10], i11);
            strArr[i10] = k3VarArr[i10].getName();
            iArr3[i10] = k3VarArr[i10].s();
        }
        y yVar = new y(strArr, iArr3, lcVarArr, p2, iArr2, new lc((rs[]) j5.qj(rsVarArr[k3VarArr.length], iArr[k3VarArr.length])));
        Pair<ic[], co[]> mt2 = mt(yVar, iArr2, p2, n3Var, hyVar);
        return new rz((ic[]) mt2.first, (co[]) mt2.second, d0.n3(yVar, (x4[]) mt2.second), yVar);
    }

    public abstract Pair<ic[], co[]> mt(y yVar, int[][][] iArr, int[] iArr2, mg.n3 n3Var, hy hyVar) throws m1.p;

    @Nullable
    public final y xc() {
        return this.f15764zn;
    }
}
