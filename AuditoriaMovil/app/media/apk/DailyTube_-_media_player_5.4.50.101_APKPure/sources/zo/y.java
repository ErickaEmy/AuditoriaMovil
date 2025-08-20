package zo;

import af.mg;
import af.rs;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import m1.hy;
import m1.m;
import v5.j5;
import z0.ej;
import z0.x4;
import z0.z6;
import zo.co;
/* loaded from: classes.dex */
public class y extends zn {

    /* renamed from: c5  reason: collision with root package name */
    public final long f15890c5;

    /* renamed from: co  reason: collision with root package name */
    public int f15891co;

    /* renamed from: f  reason: collision with root package name */
    public final long f15892f;

    /* renamed from: i9  reason: collision with root package name */
    public final long f15893i9;

    /* renamed from: mt  reason: collision with root package name */
    public float f15894mt;

    /* renamed from: p  reason: collision with root package name */
    public final v5.v f15895p;

    /* renamed from: r  reason: collision with root package name */
    public long f15896r;

    /* renamed from: s  reason: collision with root package name */
    public final kx.a f15897s;

    /* renamed from: t  reason: collision with root package name */
    public final int f15898t;

    /* renamed from: tl  reason: collision with root package name */
    public final int f15899tl;

    /* renamed from: w  reason: collision with root package name */
    public final z0.x4<C0265y> f15900w;

    /* renamed from: wz  reason: collision with root package name */
    public final float f15901wz;
    @Nullable

    /* renamed from: x4  reason: collision with root package name */
    public p7.wz f15902x4;

    /* renamed from: xc  reason: collision with root package name */
    public final float f15903xc;

    /* renamed from: z  reason: collision with root package name */
    public int f15904z;

    /* loaded from: classes.dex */
    public static class n3 implements co.n3 {

        /* renamed from: a  reason: collision with root package name */
        public final float f15905a;

        /* renamed from: fb  reason: collision with root package name */
        public final float f15906fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f15907gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f15908n3;

        /* renamed from: s  reason: collision with root package name */
        public final v5.v f15909s;

        /* renamed from: v  reason: collision with root package name */
        public final int f15910v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f15911zn;

        public n3() {
            this(10000, 25000, 25000, 0.7f);
        }

        public y n3(rs rsVar, int[] iArr, int i, kx.a aVar, z0.x4<C0265y> x4Var) {
            return new y(rsVar, iArr, i, aVar, this.y, this.f15908n3, this.f15911zn, this.f15907gv, this.f15910v, this.f15905a, this.f15906fb, x4Var, this.f15909s);
        }

        @Override // zo.co.n3
        public final co[] y(co.y[] yVarArr, kx.a aVar, mg.n3 n3Var, hy hyVar) {
            co n32;
            z0.x4 fh2 = y.fh(yVarArr);
            co[] coVarArr = new co[yVarArr.length];
            for (int i = 0; i < yVarArr.length; i++) {
                co.y yVar = yVarArr[i];
                if (yVar != null) {
                    int[] iArr = yVar.f15756n3;
                    if (iArr.length != 0) {
                        if (iArr.length == 1) {
                            n32 = new z(yVar.y, iArr[0], yVar.f15757zn);
                        } else {
                            n32 = n3(yVar.y, iArr, yVar.f15757zn, aVar, (z0.x4) fh2.get(i));
                        }
                        coVarArr[i] = n32;
                    }
                }
            }
            return coVarArr;
        }

        public n3(int i, int i5, int i6, float f4) {
            this(i, i5, i6, 1279, 719, f4, 0.75f, v5.v.y);
        }

        public n3(int i, int i5, int i6, int i8, int i10, float f4, float f6, v5.v vVar) {
            this.y = i;
            this.f15908n3 = i5;
            this.f15911zn = i6;
            this.f15907gv = i8;
            this.f15910v = i10;
            this.f15905a = f4;
            this.f15906fb = f6;
            this.f15909s = vVar;
        }
    }

    /* renamed from: zo.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0265y {

        /* renamed from: n3  reason: collision with root package name */
        public final long f15912n3;
        public final long y;

        public C0265y(long j2, long j4) {
            this.y = j2;
            this.f15912n3 = j4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0265y)) {
                return false;
            }
            C0265y c0265y = (C0265y) obj;
            if (this.y == c0265y.y && this.f15912n3 == c0265y.f15912n3) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.y) * 31) + ((int) this.f15912n3);
        }
    }

    public y(rs rsVar, int[] iArr, int i, kx.a aVar, long j2, long j4, long j6, int i5, int i6, float f4, float f6, List<C0265y> list, v5.v vVar) {
        super(rsVar, iArr, i);
        kx.a aVar2;
        long j7;
        if (j6 < j2) {
            v5.r.c5("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            aVar2 = aVar;
            j7 = j2;
        } else {
            aVar2 = aVar;
            j7 = j6;
        }
        this.f15897s = aVar2;
        this.f15890c5 = j2 * 1000;
        this.f15893i9 = j4 * 1000;
        this.f15892f = j7 * 1000;
        this.f15898t = i5;
        this.f15899tl = i6;
        this.f15901wz = f4;
        this.f15903xc = f6;
        this.f15900w = z0.x4.d(list);
        this.f15895p = vVar;
        this.f15894mt = 1.0f;
        this.f15904z = 0;
        this.f15896r = -9223372036854775807L;
    }

    private static z0.x4<Integer> ej(long[][] jArr) {
        double d2;
        z6 v2 = ej.zn().y().v();
        for (int i = 0; i < jArr.length; i++) {
            long[] jArr2 = jArr[i];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i5 = 0;
                while (true) {
                    long[] jArr3 = jArr[i];
                    double d3 = 0.0d;
                    if (i5 >= jArr3.length) {
                        break;
                    }
                    long j2 = jArr3[i5];
                    if (j2 != -1) {
                        d3 = Math.log(j2);
                    }
                    dArr[i5] = d3;
                    i5++;
                }
                int i6 = length - 1;
                double d4 = dArr[i6] - dArr[0];
                int i8 = 0;
                while (i8 < i6) {
                    double d5 = dArr[i8];
                    i8++;
                    double d6 = (d5 + dArr[i8]) * 0.5d;
                    if (d4 == 0.0d) {
                        d2 = 1.0d;
                    } else {
                        d2 = (d6 - dArr[0]) / d4;
                    }
                    v2.put(Double.valueOf(d2), Integer.valueOf(i));
                }
            }
        }
        return z0.x4.d(v2.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static z0.x4<z0.x4<C0265y>> fh(co.y[] yVarArr) {
        z0.x4 s2;
        long j2;
        ArrayList arrayList = new ArrayList();
        for (co.y yVar : yVarArr) {
            if (yVar != null && yVar.f15756n3.length > 1) {
                x4.y x42 = z0.x4.x4();
                x42.y(new C0265y(0L, 0L));
                arrayList.add(x42);
            } else {
                arrayList.add(null);
            }
        }
        long[][] z62 = z6(yVarArr);
        int[] iArr = new int[z62.length];
        long[] jArr = new long[z62.length];
        for (int i = 0; i < z62.length; i++) {
            long[] jArr2 = z62[i];
            if (jArr2.length == 0) {
                j2 = 0;
            } else {
                j2 = jArr2[0];
            }
            jArr[i] = j2;
        }
        n(arrayList, jArr);
        z0.x4<Integer> ej2 = ej(z62);
        for (int i5 = 0; i5 < ej2.size(); i5++) {
            int intValue = ej2.get(i5).intValue();
            int i6 = iArr[intValue] + 1;
            iArr[intValue] = i6;
            jArr[intValue] = z62[intValue][i6];
            n(arrayList, jArr);
        }
        for (int i8 = 0; i8 < yVarArr.length; i8++) {
            if (arrayList.get(i8) != null) {
                jArr[i8] = jArr[i8] * 2;
            }
        }
        n(arrayList, jArr);
        x4.y x43 = z0.x4.x4();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            x4.y yVar2 = (x4.y) arrayList.get(i10);
            if (yVar2 == null) {
                s2 = z0.x4.j5();
            } else {
                s2 = yVar2.s();
            }
            x43.y(s2);
        }
        return x43.s();
    }

    private static void n(List<x4.y<C0265y>> list, long[] jArr) {
        long j2 = 0;
        for (long j4 : jArr) {
            j2 += j4;
        }
        for (int i = 0; i < list.size(); i++) {
            x4.y<C0265y> yVar = list.get(i);
            if (yVar != null) {
                yVar.y(new C0265y(j2, jArr[i]));
            }
        }
    }

    private static long[][] z6(co.y[] yVarArr) {
        long[][] jArr = new long[yVarArr.length];
        for (int i = 0; i < yVarArr.length; i++) {
            co.y yVar = yVarArr[i];
            if (yVar == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[yVar.f15756n3.length];
                int i5 = 0;
                while (true) {
                    int[] iArr = yVar.f15756n3;
                    if (i5 >= iArr.length) {
                        break;
                    }
                    long j2 = yVar.y.zn(iArr[i5]).f10959p;
                    long[] jArr2 = jArr[i];
                    if (j2 == -1) {
                        j2 = 0;
                    }
                    jArr2[i5] = j2;
                    i5++;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    public final long a8(long j2, long j4) {
        if (j2 == -9223372036854775807L) {
            return this.f15890c5;
        }
        if (j4 != -9223372036854775807L) {
            j2 -= j4;
        }
        return Math.min(((float) j2) * this.f15903xc, this.f15890c5);
    }

    public boolean c(m mVar, int i, long j2) {
        if (i <= j2) {
            return true;
        }
        return false;
    }

    public final long d(p7.xc[] xcVarArr, List<? extends p7.wz> list) {
        int i = this.f15891co;
        if (i < xcVarArr.length && xcVarArr[i].next()) {
            p7.xc xcVar = xcVarArr[this.f15891co];
            return xcVar.n3() - xcVar.y();
        }
        for (p7.xc xcVar2 : xcVarArr) {
            if (xcVar2.next()) {
                return xcVar2.n3() - xcVar2.y();
            }
        }
        return mg(list);
    }

    public final int d0(long j2, long j4) {
        long rz2 = rz(j4);
        int i = 0;
        for (int i5 = 0; i5 < this.f15918n3; i5++) {
            if (j2 == Long.MIN_VALUE || !v(i5, j2)) {
                m a2 = a(i5);
                if (c(a2, a2.f10959p, rz2)) {
                    return i5;
                }
                i = i5;
            }
        }
        return i;
    }

    @Override // zo.co
    @Nullable
    public Object f() {
        return null;
    }

    @Override // zo.zn, zo.co
    public void fb() {
        this.f15902x4 = null;
    }

    @Override // zo.zn, zo.co
    public void i9(float f4) {
        this.f15894mt = f4;
    }

    public final long mg(List<? extends p7.wz> list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        p7.wz wzVar = (p7.wz) z0.d0.v(list);
        long j2 = wzVar.f12443fb;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j4 = wzVar.f12446s;
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j4 - j2;
    }

    @Override // zo.co
    public void n3(long j2, long j4, long j6, List<? extends p7.wz> list, p7.xc[] xcVarArr) {
        int wz2;
        long elapsedRealtime = this.f15895p.elapsedRealtime();
        long d2 = d(xcVarArr, list);
        int i = this.f15904z;
        if (i == 0) {
            this.f15904z = 1;
            this.f15891co = d0(elapsedRealtime, d2);
            return;
        }
        int i5 = this.f15891co;
        if (list.isEmpty()) {
            wz2 = -1;
        } else {
            wz2 = wz(((p7.wz) z0.d0.v(list)).f12444gv);
        }
        if (wz2 != -1) {
            i = ((p7.wz) z0.d0.v(list)).f12447v;
            i5 = wz2;
        }
        int d02 = d0(elapsedRealtime, d2);
        if (!v(i5, elapsedRealtime)) {
            m a2 = a(i5);
            m a3 = a(d02);
            long a82 = a8(j6, d2);
            int i6 = a3.f10959p;
            int i8 = a2.f10959p;
            if ((i6 > i8 && j4 < a82) || (i6 < i8 && j4 >= this.f15893i9)) {
                d02 = i5;
            }
        }
        if (d02 != i5) {
            i = 3;
        }
        this.f15904z = i;
        this.f15891co = d02;
    }

    @Override // zo.zn, zo.co
    public int p(long j2, List<? extends p7.wz> list) {
        p7.wz wzVar;
        int i;
        int i5;
        long elapsedRealtime = this.f15895p.elapsedRealtime();
        if (!x(elapsedRealtime, list)) {
            return list.size();
        }
        this.f15896r = elapsedRealtime;
        if (list.isEmpty()) {
            wzVar = null;
        } else {
            wzVar = (p7.wz) z0.d0.v(list);
        }
        this.f15902x4 = wzVar;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long o42 = j5.o4(list.get(size - 1).f12443fb - j2, this.f15894mt);
        long ta2 = ta();
        if (o42 < ta2) {
            return size;
        }
        m a2 = a(d0(elapsedRealtime, mg(list)));
        for (int i6 = 0; i6 < size; i6++) {
            p7.wz wzVar2 = list.get(i6);
            m mVar = wzVar2.f12444gv;
            if (j5.o4(wzVar2.f12443fb - j2, this.f15894mt) >= ta2 && mVar.f10959p < a2.f10959p && (i = mVar.f10945ej) != -1 && i <= this.f15899tl && (i5 = mVar.f10943d) != -1 && i5 <= this.f15898t && i < a2.f10945ej) {
                return i6;
            }
        }
        return size;
    }

    public final long rz(long j2) {
        long ud2 = ud(j2);
        if (this.f15900w.isEmpty()) {
            return ud2;
        }
        int i = 1;
        while (i < this.f15900w.size() - 1 && this.f15900w.get(i).y < ud2) {
            i++;
        }
        C0265y c0265y = this.f15900w.get(i - 1);
        C0265y c0265y2 = this.f15900w.get(i);
        long j4 = c0265y.y;
        long j6 = c0265y.f15912n3;
        return j6 + ((((float) (ud2 - j4)) / ((float) (c0265y2.y - j4))) * ((float) (c0265y2.f15912n3 - j6)));
    }

    public long ta() {
        return this.f15892f;
    }

    public final long ud(long j2) {
        long n32;
        long a2 = ((float) this.f15897s.a()) * this.f15901wz;
        if (this.f15897s.n3() != -9223372036854775807L && j2 != -9223372036854775807L) {
            float f4 = (float) j2;
            return (((float) a2) * Math.max((f4 / this.f15894mt) - ((float) n32), 0.0f)) / f4;
        }
        return ((float) a2) / this.f15894mt;
    }

    public boolean x(long j2, List<? extends p7.wz> list) {
        long j4 = this.f15896r;
        if (j4 != -9223372036854775807L && j2 - j4 < 1000 && (list.isEmpty() || ((p7.wz) z0.d0.v(list)).equals(this.f15902x4))) {
            return false;
        }
        return true;
    }

    @Override // zo.zn, zo.co
    public void y() {
        this.f15896r = -9223372036854775807L;
        this.f15902x4 = null;
    }

    @Override // zo.co
    public int z() {
        return this.f15904z;
    }

    @Override // zo.co
    public int zn() {
        return this.f15891co;
    }
}
