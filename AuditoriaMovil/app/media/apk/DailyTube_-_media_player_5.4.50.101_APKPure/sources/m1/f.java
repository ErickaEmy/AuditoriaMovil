package m1;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class f implements pq {

    /* renamed from: a  reason: collision with root package name */
    public final int f10736a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f10737c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10738f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f10739fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f10740gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f10741i9;

    /* renamed from: n3  reason: collision with root package name */
    public final long f10742n3;

    /* renamed from: s  reason: collision with root package name */
    public final long f10743s;

    /* renamed from: v  reason: collision with root package name */
    public final long f10744v;
    public final kx.mt y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f10745zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: c5  reason: collision with root package name */
        public boolean f10747c5;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f10748fb;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f10750i9;

        /* renamed from: s  reason: collision with root package name */
        public int f10752s;
        @Nullable
        public kx.mt y;

        /* renamed from: n3  reason: collision with root package name */
        public int f10751n3 = 50000;

        /* renamed from: zn  reason: collision with root package name */
        public int f10754zn = 50000;

        /* renamed from: gv  reason: collision with root package name */
        public int f10749gv = 2500;

        /* renamed from: v  reason: collision with root package name */
        public int f10753v = 5000;

        /* renamed from: a  reason: collision with root package name */
        public int f10746a = -1;

        public y n3(int i, int i5, int i6, int i8) {
            v5.y.fb(!this.f10750i9);
            f.i9(i6, 0, "bufferForPlaybackMs", "0");
            f.i9(i8, 0, "bufferForPlaybackAfterRebufferMs", "0");
            f.i9(i, i6, "minBufferMs", "bufferForPlaybackMs");
            f.i9(i, i8, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            f.i9(i5, i, "maxBufferMs", "minBufferMs");
            this.f10751n3 = i;
            this.f10754zn = i5;
            this.f10749gv = i6;
            this.f10753v = i8;
            return this;
        }

        public f y() {
            v5.y.fb(!this.f10750i9);
            this.f10750i9 = true;
            if (this.y == null) {
                this.y = new kx.mt(true, 65536);
            }
            return new f(this.y, this.f10751n3, this.f10754zn, this.f10749gv, this.f10753v, this.f10746a, this.f10748fb, this.f10752s, this.f10747c5);
        }
    }

    public f() {
        this(new kx.mt(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    public static void i9(int i, int i5, String str, String str2) {
        boolean z2;
        if (i >= i5) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.n3(z2, str + " cannot be less than " + str2);
    }

    public static int t(int i) {
        switch (i) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    @Override // m1.pq
    public void a() {
        tl(true);
    }

    public int f(zq[] zqVarArr, zo.co[] coVarArr) {
        int i = 0;
        for (int i5 = 0; i5 < zqVarArr.length; i5++) {
            if (coVarArr[i5] != null) {
                i += t(zqVarArr[i5].s());
            }
        }
        return Math.max(13107200, i);
    }

    @Override // m1.pq
    public void fb() {
        tl(true);
    }

    @Override // m1.pq
    public boolean gv(long j2, float f4, boolean z2, long j4) {
        long j6;
        long o42 = v5.j5.o4(j2, f4);
        if (z2) {
            j6 = this.f10744v;
        } else {
            j6 = this.f10740gv;
        }
        if (j4 != -9223372036854775807L) {
            j6 = Math.min(j4 / 2, j6);
        }
        if (j6 > 0 && o42 < j6 && (this.f10739fb || this.y.a() < this.f10741i9)) {
            return false;
        }
        return true;
    }

    @Override // m1.pq
    public long n3() {
        return this.f10743s;
    }

    @Override // m1.pq
    public void onPrepared() {
        tl(false);
    }

    @Override // m1.pq
    public boolean s(long j2, long j4, float f4) {
        boolean z2;
        boolean z3 = true;
        if (this.y.a() >= this.f10741i9) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j6 = this.f10742n3;
        if (f4 > 1.0f) {
            j6 = Math.min(v5.j5.u(j6, f4), this.f10745zn);
        }
        if (j4 < Math.max(j6, 500000L)) {
            if (!this.f10739fb && z2) {
                z3 = false;
            }
            this.f10738f = z3;
            if (!z3 && j4 < 500000) {
                v5.r.c5("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j4 >= this.f10745zn || z2) {
            this.f10738f = false;
        }
        return this.f10738f;
    }

    public final void tl(boolean z2) {
        int i = this.f10736a;
        if (i == -1) {
            i = 13107200;
        }
        this.f10741i9 = i;
        this.f10738f = false;
        if (z2) {
            this.y.fb();
        }
    }

    @Override // m1.pq
    public kx.n3 v() {
        return this.y;
    }

    @Override // m1.pq
    public boolean y() {
        return this.f10737c5;
    }

    @Override // m1.pq
    public void zn(zq[] zqVarArr, af.lc lcVar, zo.co[] coVarArr) {
        int i = this.f10736a;
        if (i == -1) {
            i = f(zqVarArr, coVarArr);
        }
        this.f10741i9 = i;
        this.y.s(i);
    }

    public f(kx.mt mtVar, int i, int i5, int i6, int i8, int i10, boolean z2, int i11, boolean z3) {
        i9(i6, 0, "bufferForPlaybackMs", "0");
        i9(i8, 0, "bufferForPlaybackAfterRebufferMs", "0");
        i9(i, i6, "minBufferMs", "bufferForPlaybackMs");
        i9(i, i8, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        i9(i5, i, "maxBufferMs", "minBufferMs");
        i9(i11, 0, "backBufferDurationMs", "0");
        this.y = mtVar;
        this.f10742n3 = v5.j5.xb(i);
        this.f10745zn = v5.j5.xb(i5);
        this.f10740gv = v5.j5.xb(i6);
        this.f10744v = v5.j5.xb(i8);
        this.f10736a = i10;
        this.f10741i9 = i10 == -1 ? 13107200 : i10;
        this.f10739fb = z2;
        this.f10743s = v5.j5.xb(i11);
        this.f10737c5 = z3;
    }
}
