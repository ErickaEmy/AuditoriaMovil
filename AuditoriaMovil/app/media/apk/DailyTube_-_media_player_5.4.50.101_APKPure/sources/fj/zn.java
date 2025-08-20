package fj;

import af.mg;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.List;
import m1.br;
import m1.gf;
import m1.hy;
import m1.o0;
import m1.qk;
import m1.uo;
import m1.v1;
/* loaded from: classes.dex */
public interface zn {

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final SparseArray<y> f8165n3;
        public final v5.wz y;

        public n3(v5.wz wzVar, SparseArray<y> sparseArray) {
            this.y = wzVar;
            SparseArray<y> sparseArray2 = new SparseArray<>(wzVar.gv());
            for (int i = 0; i < wzVar.gv(); i++) {
                int zn2 = wzVar.zn(i);
                sparseArray2.append(zn2, (y) v5.y.v(sparseArray.get(zn2)));
            }
            this.f8165n3 = sparseArray2;
        }

        public int gv() {
            return this.y.gv();
        }

        public int n3(int i) {
            return this.y.zn(i);
        }

        public boolean y(int i) {
            return this.y.y(i);
        }

        public y zn(int i) {
            return (y) v5.y.v(this.f8165n3.get(i));
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public final hy f8166a;

        /* renamed from: c5  reason: collision with root package name */
        public final long f8167c5;

        /* renamed from: fb  reason: collision with root package name */
        public final int f8168fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final mg.n3 f8169gv;

        /* renamed from: i9  reason: collision with root package name */
        public final long f8170i9;

        /* renamed from: n3  reason: collision with root package name */
        public final hy f8171n3;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public final mg.n3 f8172s;

        /* renamed from: v  reason: collision with root package name */
        public final long f8173v;
        public final long y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f8174zn;

        public y(long j2, hy hyVar, int i, @Nullable mg.n3 n3Var, long j4, hy hyVar2, int i5, @Nullable mg.n3 n3Var2, long j6, long j7) {
            this.y = j2;
            this.f8171n3 = hyVar;
            this.f8174zn = i;
            this.f8169gv = n3Var;
            this.f8173v = j4;
            this.f8166a = hyVar2;
            this.f8168fb = i5;
            this.f8172s = n3Var2;
            this.f8167c5 = j6;
            this.f8170i9 = j7;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || y.class != obj.getClass()) {
                return false;
            }
            y yVar = (y) obj;
            if (this.y == yVar.y && this.f8174zn == yVar.f8174zn && this.f8173v == yVar.f8173v && this.f8168fb == yVar.f8168fb && this.f8167c5 == yVar.f8167c5 && this.f8170i9 == yVar.f8170i9 && w0.f.y(this.f8171n3, yVar.f8171n3) && w0.f.y(this.f8169gv, yVar.f8169gv) && w0.f.y(this.f8166a, yVar.f8166a) && w0.f.y(this.f8172s, yVar.f8172s)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return w0.f.n3(Long.valueOf(this.y), this.f8171n3, Integer.valueOf(this.f8174zn), this.f8169gv, Long.valueOf(this.f8173v), this.f8166a, Integer.valueOf(this.f8168fb), this.f8172s, Long.valueOf(this.f8167c5), Long.valueOf(this.f8170i9));
        }
    }

    void a8(y yVar);

    void ap(y yVar, qh.a aVar);

    void b(y yVar, Object obj, long j2);

    @Deprecated
    void bk(y yVar);

    void c(y yVar, af.i4 i4Var, af.c cVar, IOException iOException, boolean z2);

    void c5(y yVar, boolean z2);

    void co(y yVar, v1 v1Var);

    @Deprecated
    void ct(y yVar, int i, m1.m mVar);

    void d(y yVar, uo.n3 n3Var);

    void dm(y yVar, String str);

    @Deprecated
    void eb(y yVar, int i, a9.v vVar);

    @Deprecated
    void ej(y yVar, String str, long j2);

    void en(y yVar, boolean z2);

    @Deprecated
    void f(y yVar, int i);

    @Deprecated
    void f3(y yVar);

    @Deprecated
    void f7(y yVar, boolean z2);

    void fb(y yVar, Exception exc);

    void fh(y yVar, Exception exc);

    void g(y yVar, af.c cVar);

    void g3(y yVar, int i, long j2);

    @Deprecated
    void gv(y yVar, String str, long j2);

    void hw(y yVar);

    @Deprecated
    void i4(y yVar, int i, int i5, int i6, float f4);

    void i9(y yVar);

    void j5(y yVar, String str, long j2, long j4);

    void jz(y yVar, int i);

    void k(y yVar, int i, int i5);

    void k5(y yVar, int i);

    void kp(y yVar, boolean z2, int i);

    void lc(y yVar, Metadata metadata);

    void m(y yVar, @Nullable o0 o0Var, int i);

    void mg(y yVar, boolean z2);

    void mt(y yVar, wn.d0 d0Var);

    void n(y yVar, int i);

    @Deprecated
    void n3(y yVar, int i, a9.v vVar);

    void nf(y yVar, uo.v vVar, uo.v vVar2, int i);

    void o(y yVar, int i, boolean z2);

    void o4(y yVar, int i, long j2, long j4);

    void oz(y yVar, Exception exc);

    void p(y yVar, af.c cVar);

    void q9(y yVar, a9.v vVar);

    void qn(y yVar, String str, long j2, long j4);

    void r(y yVar, af.i4 i4Var, af.c cVar);

    void ra(y yVar, long j2);

    void rb(uo uoVar, n3 n3Var);

    void rs(y yVar, String str);

    @Deprecated
    void rz(y yVar, m1.m mVar);

    @Deprecated
    void s(y yVar, List<qh.n3> list);

    @Deprecated
    void s8(y yVar, int i, String str, long j2);

    void t(y yVar, zo.c cVar);

    void ta(y yVar, m1.m mVar, @Nullable a9.c5 c5Var);

    void tg(y yVar, a9.v vVar);

    void tl(y yVar, boolean z2);

    void u(y yVar, qk qkVar);

    void u0(y yVar, af.i4 i4Var, af.c cVar);

    @Deprecated
    void ud(y yVar, m1.m mVar);

    void ut(y yVar, a9.v vVar);

    @Deprecated
    void v(y yVar);

    void vl(y yVar, a9.v vVar);

    void w(y yVar, float f4);

    void wz(y yVar, long j2, int i);

    void x(y yVar, m1.m mVar, @Nullable a9.c5 c5Var);

    void x4(y yVar, Exception exc);

    void xc(y yVar, m1.xc xcVar);

    void xg(y yVar);

    void y(y yVar);

    void y4(y yVar, gf gfVar);

    void y5(y yVar, int i);

    void yc(y yVar, int i);

    void yg(y yVar, int i, long j2, long j4);

    void yt(y yVar, br brVar);

    void z(y yVar, af.i4 i4Var, af.c cVar);

    void z6(y yVar, @Nullable gf gfVar);

    @Deprecated
    void zn(y yVar, boolean z2, int i);
}
