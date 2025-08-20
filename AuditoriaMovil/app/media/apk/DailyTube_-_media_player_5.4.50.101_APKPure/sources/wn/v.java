package wn;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public int f14631a;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f14632gv;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f14635zn;
    public y y = new y();

    /* renamed from: n3  reason: collision with root package name */
    public y f14633n3 = new y();

    /* renamed from: v  reason: collision with root package name */
    public long f14634v = -9223372036854775807L;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public long f14636a;

        /* renamed from: fb  reason: collision with root package name */
        public final boolean[] f14637fb = new boolean[15];

        /* renamed from: gv  reason: collision with root package name */
        public long f14638gv;

        /* renamed from: n3  reason: collision with root package name */
        public long f14639n3;

        /* renamed from: s  reason: collision with root package name */
        public int f14640s;

        /* renamed from: v  reason: collision with root package name */
        public long f14641v;
        public long y;

        /* renamed from: zn  reason: collision with root package name */
        public long f14642zn;

        public static int zn(long j2) {
            return (int) (j2 % 15);
        }

        public void a(long j2) {
            long j4 = this.f14638gv;
            if (j4 == 0) {
                this.y = j2;
            } else if (j4 == 1) {
                long j6 = j2 - this.y;
                this.f14639n3 = j6;
                this.f14636a = j6;
                this.f14641v = 1L;
            } else {
                long j7 = j2 - this.f14642zn;
                int zn2 = zn(j4);
                if (Math.abs(j7 - this.f14639n3) <= 1000000) {
                    this.f14641v++;
                    this.f14636a += j7;
                    boolean[] zArr = this.f14637fb;
                    if (zArr[zn2]) {
                        zArr[zn2] = false;
                        this.f14640s--;
                    }
                } else {
                    boolean[] zArr2 = this.f14637fb;
                    if (!zArr2[zn2]) {
                        zArr2[zn2] = true;
                        this.f14640s++;
                    }
                }
            }
            this.f14638gv++;
            this.f14642zn = j2;
        }

        public void fb() {
            this.f14638gv = 0L;
            this.f14641v = 0L;
            this.f14636a = 0L;
            this.f14640s = 0;
            Arrays.fill(this.f14637fb, false);
        }

        public boolean gv() {
            long j2 = this.f14638gv;
            if (j2 == 0) {
                return false;
            }
            return this.f14637fb[zn(j2 - 1)];
        }

        public long n3() {
            return this.f14636a;
        }

        public boolean v() {
            if (this.f14638gv > 15 && this.f14640s == 0) {
                return true;
            }
            return false;
        }

        public long y() {
            long j2 = this.f14641v;
            if (j2 == 0) {
                return 0L;
            }
            return this.f14636a / j2;
        }
    }

    public void a(long j2) {
        this.y.a(j2);
        int i = 0;
        if (this.y.v() && !this.f14632gv) {
            this.f14635zn = false;
        } else if (this.f14634v != -9223372036854775807L) {
            if (!this.f14635zn || this.f14633n3.gv()) {
                this.f14633n3.fb();
                this.f14633n3.a(this.f14634v);
            }
            this.f14635zn = true;
            this.f14633n3.a(j2);
        }
        if (this.f14635zn && this.f14633n3.v()) {
            y yVar = this.y;
            this.y = this.f14633n3;
            this.f14633n3 = yVar;
            this.f14635zn = false;
            this.f14632gv = false;
        }
        this.f14634v = j2;
        if (!this.y.v()) {
            i = this.f14631a + 1;
        }
        this.f14631a = i;
    }

    public void fb() {
        this.y.fb();
        this.f14633n3.fb();
        this.f14635zn = false;
        this.f14634v = -9223372036854775807L;
        this.f14631a = 0;
    }

    public long gv() {
        if (v()) {
            return this.y.n3();
        }
        return -9223372036854775807L;
    }

    public float n3() {
        if (v()) {
            return (float) (1.0E9d / this.y.y());
        }
        return -1.0f;
    }

    public boolean v() {
        return this.y.v();
    }

    public long y() {
        if (v()) {
            return this.y.y();
        }
        return -9223372036854775807L;
    }

    public int zn() {
        return this.f14631a;
    }
}
