package m1;

import af.mg;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
/* loaded from: classes.dex */
public final class bv {

    /* renamed from: co  reason: collision with root package name */
    public static final mg.n3 f10586co = new mg.n3(new Object());
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final p f10587a;

    /* renamed from: c5  reason: collision with root package name */
    public final zo.rz f10588c5;

    /* renamed from: f  reason: collision with root package name */
    public final mg.n3 f10589f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f10590fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f10591gv;

    /* renamed from: i9  reason: collision with root package name */
    public final List<Metadata> f10592i9;

    /* renamed from: mt  reason: collision with root package name */
    public volatile long f10593mt;

    /* renamed from: n3  reason: collision with root package name */
    public final mg.n3 f10594n3;

    /* renamed from: p  reason: collision with root package name */
    public volatile long f10595p;

    /* renamed from: s  reason: collision with root package name */
    public final af.lc f10596s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f10597t;

    /* renamed from: tl  reason: collision with root package name */
    public final int f10598tl;

    /* renamed from: v  reason: collision with root package name */
    public final int f10599v;

    /* renamed from: w  reason: collision with root package name */
    public volatile long f10600w;

    /* renamed from: wz  reason: collision with root package name */
    public final br f10601wz;

    /* renamed from: xc  reason: collision with root package name */
    public final boolean f10602xc;
    public final hy y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f10603zn;

    public bv(hy hyVar, mg.n3 n3Var, long j2, long j4, int i, @Nullable p pVar, boolean z2, af.lc lcVar, zo.rz rzVar, List<Metadata> list, mg.n3 n3Var2, boolean z3, int i5, br brVar, long j6, long j7, long j8, boolean z4) {
        this.y = hyVar;
        this.f10594n3 = n3Var;
        this.f10603zn = j2;
        this.f10591gv = j4;
        this.f10599v = i;
        this.f10587a = pVar;
        this.f10590fb = z2;
        this.f10596s = lcVar;
        this.f10588c5 = rzVar;
        this.f10592i9 = list;
        this.f10589f = n3Var2;
        this.f10597t = z3;
        this.f10598tl = i5;
        this.f10601wz = brVar;
        this.f10600w = j6;
        this.f10595p = j7;
        this.f10593mt = j8;
        this.f10602xc = z4;
    }

    public static mg.n3 f() {
        return f10586co;
    }

    public static bv i9(zo.rz rzVar) {
        hy hyVar = hy.y;
        mg.n3 n3Var = f10586co;
        return new bv(hyVar, n3Var, -9223372036854775807L, 0L, 1, null, false, af.lc.f327s, rzVar, z0.x4.j5(), n3Var, false, 0, br.f10581s, 0L, 0L, 0L, false);
    }

    @CheckResult
    public bv a(br brVar) {
        return new bv(this.y, this.f10594n3, this.f10603zn, this.f10591gv, this.f10599v, this.f10587a, this.f10590fb, this.f10596s, this.f10588c5, this.f10592i9, this.f10589f, this.f10597t, this.f10598tl, brVar, this.f10600w, this.f10595p, this.f10593mt, this.f10602xc);
    }

    @CheckResult
    public bv c5(hy hyVar) {
        return new bv(hyVar, this.f10594n3, this.f10603zn, this.f10591gv, this.f10599v, this.f10587a, this.f10590fb, this.f10596s, this.f10588c5, this.f10592i9, this.f10589f, this.f10597t, this.f10598tl, this.f10601wz, this.f10600w, this.f10595p, this.f10593mt, this.f10602xc);
    }

    @CheckResult
    public bv fb(int i) {
        return new bv(this.y, this.f10594n3, this.f10603zn, this.f10591gv, i, this.f10587a, this.f10590fb, this.f10596s, this.f10588c5, this.f10592i9, this.f10589f, this.f10597t, this.f10598tl, this.f10601wz, this.f10600w, this.f10595p, this.f10593mt, this.f10602xc);
    }

    @CheckResult
    public bv gv(boolean z2, int i) {
        return new bv(this.y, this.f10594n3, this.f10603zn, this.f10591gv, this.f10599v, this.f10587a, this.f10590fb, this.f10596s, this.f10588c5, this.f10592i9, this.f10589f, z2, i, this.f10601wz, this.f10600w, this.f10595p, this.f10593mt, this.f10602xc);
    }

    @CheckResult
    public bv n3(mg.n3 n3Var) {
        return new bv(this.y, this.f10594n3, this.f10603zn, this.f10591gv, this.f10599v, this.f10587a, this.f10590fb, this.f10596s, this.f10588c5, this.f10592i9, n3Var, this.f10597t, this.f10598tl, this.f10601wz, this.f10600w, this.f10595p, this.f10593mt, this.f10602xc);
    }

    @CheckResult
    public bv s(boolean z2) {
        return new bv(this.y, this.f10594n3, this.f10603zn, this.f10591gv, this.f10599v, this.f10587a, this.f10590fb, this.f10596s, this.f10588c5, this.f10592i9, this.f10589f, this.f10597t, this.f10598tl, this.f10601wz, this.f10600w, this.f10595p, this.f10593mt, z2);
    }

    @CheckResult
    public bv v(@Nullable p pVar) {
        return new bv(this.y, this.f10594n3, this.f10603zn, this.f10591gv, this.f10599v, pVar, this.f10590fb, this.f10596s, this.f10588c5, this.f10592i9, this.f10589f, this.f10597t, this.f10598tl, this.f10601wz, this.f10600w, this.f10595p, this.f10593mt, this.f10602xc);
    }

    @CheckResult
    public bv y(boolean z2) {
        return new bv(this.y, this.f10594n3, this.f10603zn, this.f10591gv, this.f10599v, this.f10587a, z2, this.f10596s, this.f10588c5, this.f10592i9, this.f10589f, this.f10597t, this.f10598tl, this.f10601wz, this.f10600w, this.f10595p, this.f10593mt, this.f10602xc);
    }

    @CheckResult
    public bv zn(mg.n3 n3Var, long j2, long j4, long j6, long j7, af.lc lcVar, zo.rz rzVar, List<Metadata> list) {
        return new bv(this.y, n3Var, j4, j6, this.f10599v, this.f10587a, this.f10590fb, lcVar, rzVar, list, this.f10589f, this.f10597t, this.f10598tl, this.f10601wz, this.f10600w, j7, j2, this.f10602xc);
    }
}
