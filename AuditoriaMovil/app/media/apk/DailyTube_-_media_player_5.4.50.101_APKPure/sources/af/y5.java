package af;

import android.net.Uri;
import androidx.annotation.Nullable;
import m1.hy;
import m1.o0;
/* loaded from: classes.dex */
public final class y5 extends hy {

    /* renamed from: c  reason: collision with root package name */
    public final boolean f438c;

    /* renamed from: co  reason: collision with root package name */
    public final long f439co;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final o0 f440d;

    /* renamed from: d0  reason: collision with root package name */
    public final boolean f441d0;
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public final o0.fb f442ej;

    /* renamed from: f3  reason: collision with root package name */
    public final long f443f3;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public final Object f444fh;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f445n;

    /* renamed from: p  reason: collision with root package name */
    public final long f446p;

    /* renamed from: r  reason: collision with root package name */
    public final long f447r;

    /* renamed from: t  reason: collision with root package name */
    public final long f448t;

    /* renamed from: w  reason: collision with root package name */
    public final long f449w;

    /* renamed from: z  reason: collision with root package name */
    public final long f450z;

    /* renamed from: x  reason: collision with root package name */
    public static final Object f437x = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final o0 f436b = new o0.zn().gv("SinglePeriodTimeline").s(Uri.EMPTY).y();

    public y5(long j2, boolean z2, boolean z3, boolean z4, @Nullable Object obj, o0 o0Var) {
        this(j2, j2, 0L, 0L, z2, z3, z4, obj, o0Var);
    }

    @Override // m1.hy
    public int a(Object obj) {
        if (f437x.equals(obj)) {
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r1 > r3) goto L9;
     */
    @Override // m1.hy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m1.hy.gv co(int r25, m1.hy.gv r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            v5.y.zn(r3, r1, r2)
            long r1 = r0.f443f3
            boolean r14 = r0.f438c
            if (r14 == 0) goto L2e
            boolean r3 = r0.f441d0
            if (r3 != 0) goto L2e
            r3 = 0
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 == 0) goto L2e
            long r3 = r0.f450z
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L27
        L24:
            r16 = r5
            goto L30
        L27:
            long r1 = r1 + r27
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L2e
            goto L24
        L2e:
            r16 = r1
        L30:
            java.lang.Object r4 = m1.hy.gv.f10789ej
            m1.o0 r5 = r0.f440d
            java.lang.Object r6 = r0.f444fh
            long r7 = r0.f448t
            long r9 = r0.f449w
            long r11 = r0.f446p
            boolean r13 = r0.f445n
            m1.o0$fb r15 = r0.f442ej
            long r1 = r0.f450z
            r18 = r1
            r21 = 0
            long r1 = r0.f447r
            r22 = r1
            r20 = 0
            r3 = r26
            m1.hy$gv r1 = r3.c5(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: af.y5.co(int, m1.hy$gv, long):m1.hy$gv");
    }

    @Override // m1.hy
    public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
        Object obj;
        v5.y.zn(i, 0, 1);
        if (z2) {
            obj = f437x;
        } else {
            obj = null;
        }
        return n3Var.r(null, obj, 0, this.f439co, -this.f447r);
    }

    @Override // m1.hy
    public Object p(int i) {
        v5.y.zn(i, 0, 1);
        return f437x;
    }

    @Override // m1.hy
    public int tl() {
        return 1;
    }

    @Override // m1.hy
    public int z() {
        return 1;
    }

    public y5(long j2, long j4, long j6, long j7, boolean z2, boolean z3, boolean z4, @Nullable Object obj, o0 o0Var) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j2, j4, j6, j7, z2, z3, false, obj, o0Var, z4 ? o0Var.f11020s : null);
    }

    public y5(long j2, long j4, long j6, long j7, long j8, long j9, long j10, boolean z2, boolean z3, boolean z4, @Nullable Object obj, o0 o0Var, @Nullable o0.fb fbVar) {
        this.f448t = j2;
        this.f449w = j4;
        this.f446p = j6;
        this.f439co = j7;
        this.f450z = j8;
        this.f447r = j9;
        this.f443f3 = j10;
        this.f445n = z2;
        this.f438c = z3;
        this.f441d0 = z4;
        this.f444fh = obj;
        this.f440d = (o0) v5.y.v(o0Var);
        this.f442ej = fbVar;
    }
}
