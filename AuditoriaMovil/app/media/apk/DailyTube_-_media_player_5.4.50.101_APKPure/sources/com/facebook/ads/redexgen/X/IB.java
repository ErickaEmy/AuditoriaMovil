package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class IB {
    public long A00;
    public long A01;
    public volatile long A02 = -9223372036854775807L;

    public IB(long j2) {
        A02(j2);
    }

    public static long A00(long j2) {
        return (1000000 * j2) / 90000;
    }

    public static long A01(long j2) {
        return (90000 * j2) / 1000000;
    }

    private final synchronized void A02(long j2) {
        AbstractC0672Ha.A04(this.A02 == -9223372036854775807L);
        this.A00 = j2;
    }

    public final long A03() {
        return this.A00;
    }

    public final long A04() {
        if (this.A02 != -9223372036854775807L) {
            return this.A01 + this.A02;
        }
        long j2 = this.A00;
        if (j2 != Long.MAX_VALUE) {
            return j2;
        }
        return -9223372036854775807L;
    }

    public final long A05() {
        if (this.A00 == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.A02 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.A01;
    }

    public final long A06(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 != -9223372036854775807L) {
            this.A02 = j2;
        } else {
            long j4 = this.A00;
            if (j4 != Long.MAX_VALUE) {
                this.A01 = j4 - j2;
            }
            synchronized (this) {
                this.A02 = j2;
                notifyAll();
            }
        }
        return this.A01 + j2;
    }

    public final long A07(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 != -9223372036854775807L) {
            long A01 = A01(this.A02);
            long closestWrapCount = (4294967296L + A01) / 8589934592L;
            long j4 = ((closestWrapCount - 1) * 8589934592L) + j2;
            long j6 = (8589934592L * closestWrapCount) + j2;
            long lastPts = j4 - A01;
            long abs = Math.abs(lastPts);
            long lastPts2 = j6 - A01;
            if (abs >= Math.abs(lastPts2)) {
                j4 = j6;
            }
            j2 = j4;
        }
        long lastPts3 = A00(j2);
        return A06(lastPts3);
    }

    public final void A08() {
        this.A02 = -9223372036854775807L;
    }
}
