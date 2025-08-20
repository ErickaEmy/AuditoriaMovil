package m1;

import android.os.SystemClock;
import m1.o0;
/* loaded from: classes.dex */
public final class i9 implements pz {

    /* renamed from: a  reason: collision with root package name */
    public final long f10849a;

    /* renamed from: c5  reason: collision with root package name */
    public long f10850c5;

    /* renamed from: co  reason: collision with root package name */
    public long f10851co;

    /* renamed from: f  reason: collision with root package name */
    public long f10852f;

    /* renamed from: fb  reason: collision with root package name */
    public final float f10853fb;

    /* renamed from: gv  reason: collision with root package name */
    public final float f10854gv;

    /* renamed from: i9  reason: collision with root package name */
    public long f10855i9;

    /* renamed from: mt  reason: collision with root package name */
    public long f10856mt;

    /* renamed from: n3  reason: collision with root package name */
    public final float f10857n3;

    /* renamed from: p  reason: collision with root package name */
    public long f10858p;

    /* renamed from: s  reason: collision with root package name */
    public long f10859s;

    /* renamed from: t  reason: collision with root package name */
    public long f10860t;

    /* renamed from: tl  reason: collision with root package name */
    public long f10861tl;

    /* renamed from: v  reason: collision with root package name */
    public final long f10862v;

    /* renamed from: w  reason: collision with root package name */
    public float f10863w;

    /* renamed from: wz  reason: collision with root package name */
    public float f10864wz;

    /* renamed from: xc  reason: collision with root package name */
    public float f10865xc;
    public final float y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f10866zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        public float y = 0.97f;

        /* renamed from: n3  reason: collision with root package name */
        public float f10870n3 = 1.03f;

        /* renamed from: zn  reason: collision with root package name */
        public long f10872zn = 1000;

        /* renamed from: gv  reason: collision with root package name */
        public float f10869gv = 1.0E-7f;

        /* renamed from: v  reason: collision with root package name */
        public long f10871v = v5.j5.xb(20);

        /* renamed from: a  reason: collision with root package name */
        public long f10867a = v5.j5.xb(500);

        /* renamed from: fb  reason: collision with root package name */
        public float f10868fb = 0.999f;

        public i9 y() {
            return new i9(this.y, this.f10870n3, this.f10872zn, this.f10869gv, this.f10871v, this.f10867a, this.f10868fb);
        }
    }

    public static long s(long j2, long j4, float f4) {
        return (((float) j2) * f4) + ((1.0f - f4) * ((float) j4));
    }

    public final void a(long j2) {
        long j4 = this.f10856mt + (this.f10851co * 3);
        if (this.f10861tl > j4) {
            float xb2 = (float) v5.j5.xb(this.f10866zn);
            this.f10861tl = d1.s.gv(j4, this.f10855i9, this.f10861tl - (((this.f10863w - 1.0f) * xb2) + ((this.f10864wz - 1.0f) * xb2)));
            return;
        }
        long mt2 = v5.j5.mt(j2 - (Math.max(0.0f, this.f10863w - 1.0f) / this.f10854gv), this.f10861tl, j4);
        this.f10861tl = mt2;
        long j6 = this.f10860t;
        if (j6 != -9223372036854775807L && mt2 > j6) {
            this.f10861tl = j6;
        }
    }

    public final void c5(long j2, long j4) {
        long j6 = j2 - j4;
        long j7 = this.f10856mt;
        if (j7 == -9223372036854775807L) {
            this.f10856mt = j6;
            this.f10851co = 0L;
            return;
        }
        long max = Math.max(j6, s(j7, j6, this.f10853fb));
        this.f10856mt = max;
        this.f10851co = s(this.f10851co, Math.abs(j6 - max), this.f10853fb);
    }

    public final void fb() {
        long j2 = this.f10859s;
        if (j2 != -9223372036854775807L) {
            long j4 = this.f10850c5;
            if (j4 != -9223372036854775807L) {
                j2 = j4;
            }
            long j6 = this.f10852f;
            if (j6 != -9223372036854775807L && j2 < j6) {
                j2 = j6;
            }
            long j7 = this.f10860t;
            if (j7 != -9223372036854775807L && j2 > j7) {
                j2 = j7;
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.f10855i9 == j2) {
            return;
        }
        this.f10855i9 = j2;
        this.f10861tl = j2;
        this.f10856mt = -9223372036854775807L;
        this.f10851co = -9223372036854775807L;
        this.f10858p = -9223372036854775807L;
    }

    @Override // m1.pz
    public void gv() {
        long j2 = this.f10861tl;
        if (j2 == -9223372036854775807L) {
            return;
        }
        long j4 = j2 + this.f10849a;
        this.f10861tl = j4;
        long j6 = this.f10860t;
        if (j6 != -9223372036854775807L && j4 > j6) {
            this.f10861tl = j6;
        }
        this.f10858p = -9223372036854775807L;
    }

    @Override // m1.pz
    public float n3(long j2, long j4) {
        if (this.f10859s == -9223372036854775807L) {
            return 1.0f;
        }
        c5(j2, j4);
        if (this.f10858p != -9223372036854775807L && SystemClock.elapsedRealtime() - this.f10858p < this.f10866zn) {
            return this.f10863w;
        }
        this.f10858p = SystemClock.elapsedRealtime();
        a(j2);
        long j6 = j2 - this.f10861tl;
        if (Math.abs(j6) < this.f10862v) {
            this.f10863w = 1.0f;
        } else {
            this.f10863w = v5.j5.w((this.f10854gv * ((float) j6)) + 1.0f, this.f10865xc, this.f10864wz);
        }
        return this.f10863w;
    }

    @Override // m1.pz
    public void v(long j2) {
        this.f10850c5 = j2;
        fb();
    }

    @Override // m1.pz
    public void y(o0.fb fbVar) {
        this.f10859s = v5.j5.xb(fbVar.y);
        this.f10852f = v5.j5.xb(fbVar.f11051v);
        this.f10860t = v5.j5.xb(fbVar.f11049fb);
        float f4 = fbVar.f11050s;
        if (f4 == -3.4028235E38f) {
            f4 = this.y;
        }
        this.f10865xc = f4;
        float f6 = fbVar.f11048f;
        if (f6 == -3.4028235E38f) {
            f6 = this.f10857n3;
        }
        this.f10864wz = f6;
        if (f4 == 1.0f && f6 == 1.0f) {
            this.f10859s = -9223372036854775807L;
        }
        fb();
    }

    @Override // m1.pz
    public long zn() {
        return this.f10861tl;
    }

    public i9(float f4, float f6, long j2, float f9, long j4, long j6, float f10) {
        this.y = f4;
        this.f10857n3 = f6;
        this.f10866zn = j2;
        this.f10854gv = f9;
        this.f10862v = j4;
        this.f10849a = j6;
        this.f10853fb = f10;
        this.f10859s = -9223372036854775807L;
        this.f10850c5 = -9223372036854775807L;
        this.f10852f = -9223372036854775807L;
        this.f10860t = -9223372036854775807L;
        this.f10865xc = f4;
        this.f10864wz = f6;
        this.f10863w = 1.0f;
        this.f10858p = -9223372036854775807L;
        this.f10855i9 = -9223372036854775807L;
        this.f10861tl = -9223372036854775807L;
        this.f10856mt = -9223372036854775807L;
        this.f10851co = -9223372036854775807L;
    }
}
