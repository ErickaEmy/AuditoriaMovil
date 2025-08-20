package d9;

import d9.rz;
import java.math.RoundingMode;
import v5.j5;
/* loaded from: classes.dex */
public class mg implements rz.a {

    /* renamed from: a  reason: collision with root package name */
    public final int f7072a;

    /* renamed from: fb  reason: collision with root package name */
    public final int f7073fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f7074gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f7075n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f7076v;

    /* renamed from: zn  reason: collision with root package name */
    public final int f7077zn;

    /* loaded from: classes.dex */
    public static class y {
        public int y = 250000;

        /* renamed from: n3  reason: collision with root package name */
        public int f7080n3 = 750000;

        /* renamed from: zn  reason: collision with root package name */
        public int f7082zn = 4;

        /* renamed from: gv  reason: collision with root package name */
        public int f7079gv = 250000;

        /* renamed from: v  reason: collision with root package name */
        public int f7081v = 50000000;

        /* renamed from: a  reason: collision with root package name */
        public int f7078a = 2;

        public mg fb() {
            return new mg(this);
        }
    }

    public mg(y yVar) {
        this.f7075n3 = yVar.y;
        this.f7077zn = yVar.f7080n3;
        this.f7074gv = yVar.f7082zn;
        this.f7076v = yVar.f7079gv;
        this.f7072a = yVar.f7081v;
        this.f7073fb = yVar.f7078a;
    }

    public static int gv(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
        }
    }

    public static int n3(int i, int i5, int i6) {
        return d1.a.gv(((i * i5) * i6) / 1000000);
    }

    public int a(int i, int i5) {
        int gv2;
        int i6 = this.f7076v;
        if (i == 5) {
            i6 *= this.f7073fb;
        }
        if (i5 != -1) {
            gv2 = c1.n3.y(i5, 8, RoundingMode.CEILING);
        } else {
            gv2 = gv(i);
        }
        return d1.a.gv((i6 * gv2) / 1000000);
    }

    public int fb(int i, int i5, int i6) {
        return j5.p(i * this.f7074gv, n3(this.f7075n3, i5, i6), n3(this.f7077zn, i5, i6));
    }

    public int v(int i) {
        return d1.a.gv((this.f7072a * gv(i)) / 1000000);
    }

    @Override // d9.rz.a
    public int y(int i, int i5, int i6, int i8, int i10, int i11, double d2) {
        return (((Math.max(i, (int) (zn(i, i5, i6, i8, i10, i11) * d2)) + i8) - 1) / i8) * i8;
    }

    public int zn(int i, int i5, int i6, int i8, int i10, int i11) {
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return a(i5, i11);
                }
                throw new IllegalArgumentException();
            }
            return v(i5);
        }
        return fb(i, i10, i8);
    }
}
