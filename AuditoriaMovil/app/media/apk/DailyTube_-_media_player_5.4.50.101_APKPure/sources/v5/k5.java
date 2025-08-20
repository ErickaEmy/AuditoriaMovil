package v5;
/* loaded from: classes.dex */
public final class k5 {

    /* renamed from: gv  reason: collision with root package name */
    public final ThreadLocal<Long> f14371gv = new ThreadLocal<>();

    /* renamed from: n3  reason: collision with root package name */
    public long f14372n3;
    public long y;

    /* renamed from: zn  reason: collision with root package name */
    public long f14373zn;

    public k5(long j2) {
        fb(j2);
    }

    public static long a(long j2) {
        return (j2 * 1000000) / 90000;
    }

    public static long c5(long j2) {
        return (j2 * 90000) / 1000000;
    }

    public static long i9(long j2) {
        return c5(j2) % 8589934592L;
    }

    public synchronized void fb(long j2) {
        long j4;
        this.y = j2;
        if (j2 == Long.MAX_VALUE) {
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        this.f14372n3 = j4;
        this.f14373zn = -9223372036854775807L;
    }

    public synchronized long gv() {
        long zn2;
        try {
            long j2 = this.f14373zn;
            if (j2 != -9223372036854775807L) {
                zn2 = j2 + this.f14372n3;
            } else {
                zn2 = zn();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zn2;
    }

    public synchronized long n3(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j4 = this.f14373zn;
            if (j4 != -9223372036854775807L) {
                long c52 = c5(j4);
                long j6 = (4294967296L + c52) / 8589934592L;
                long j7 = ((j6 - 1) * 8589934592L) + j2;
                j2 += j6 * 8589934592L;
                if (Math.abs(j7 - c52) < Math.abs(j2 - c52)) {
                    j2 = j7;
                }
            }
            return y(a(j2));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(boolean z2, long j2) throws InterruptedException {
        boolean z3;
        try {
            if (this.y == 9223372036854775806L) {
                z3 = true;
            } else {
                z3 = false;
            }
            y.fb(z3);
            if (this.f14372n3 != -9223372036854775807L) {
                return;
            }
            if (z2) {
                this.f14371gv.set(Long.valueOf(j2));
            } else {
                while (this.f14372n3 == -9223372036854775807L) {
                    wait();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long v() {
        return this.f14372n3;
    }

    public synchronized long y(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (this.f14372n3 == -9223372036854775807L) {
                long j4 = this.y;
                if (j4 == 9223372036854775806L) {
                    j4 = ((Long) y.v(this.f14371gv.get())).longValue();
                }
                this.f14372n3 = j4 - j2;
                notifyAll();
            }
            this.f14373zn = j2;
            return j2 + this.f14372n3;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long zn() {
        long j2;
        j2 = this.y;
        return (j2 == Long.MAX_VALUE || j2 == 9223372036854775806L) ? -9223372036854775807L : -9223372036854775807L;
    }
}
