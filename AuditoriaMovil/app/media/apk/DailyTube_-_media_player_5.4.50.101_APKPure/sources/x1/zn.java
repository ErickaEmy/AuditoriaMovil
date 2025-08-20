package x1;

import android.util.Pair;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import e4.fh;
import e4.rz;
import v5.j5;
/* loaded from: classes.dex */
public final class zn implements fb {

    /* renamed from: n3  reason: collision with root package name */
    public final long[] f14914n3;
    public final long[] y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f14915zn;

    public zn(long[] jArr, long[] jArr2, long j2) {
        this.y = jArr;
        this.f14914n3 = jArr2;
        this.f14915zn = j2 == -9223372036854775807L ? j5.xb(jArr2[jArr2.length - 1]) : j2;
    }

    public static zn y(long j2, MlltFrame mlltFrame, long j4) {
        int length = mlltFrame.f4268f.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j2;
        long j6 = 0;
        jArr2[0] = 0;
        for (int i5 = 1; i5 <= length; i5++) {
            int i6 = i5 - 1;
            j2 += mlltFrame.f4269fb + mlltFrame.f4268f[i6];
            j6 += mlltFrame.f4270s + mlltFrame.f4271t[i6];
            jArr[i5] = j2;
            jArr2[i5] = j6;
        }
        return new zn(jArr, jArr2, j4);
    }

    public static Pair<Long, Long> zn(long j2, long[] jArr, long[] jArr2) {
        double d2;
        int c52 = j5.c5(jArr, j2, true, true);
        long j4 = jArr[c52];
        long j6 = jArr2[c52];
        int i = c52 + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j4), Long.valueOf(j6));
        }
        long j7 = jArr[i];
        long j8 = jArr2[i];
        if (j7 == j4) {
            d2 = 0.0d;
        } else {
            d2 = (j2 - j4) / (j7 - j4);
        }
        return Pair.create(Long.valueOf(j2), Long.valueOf(((long) (d2 * (j8 - j6))) + j6));
    }

    @Override // e4.fh
    public long c5() {
        return this.f14915zn;
    }

    @Override // x1.fb
    public long fb() {
        return -1L;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        Pair<Long, Long> zn2 = zn(j5.gf(j5.mt(j2, 0L, this.f14915zn)), this.f14914n3, this.y);
        return new fh.y(new rz(j5.xb(((Long) zn2.first).longValue()), ((Long) zn2.second).longValue()));
    }

    @Override // x1.fb
    public long n3(long j2) {
        return j5.xb(((Long) zn(j2, this.y, this.f14914n3).second).longValue());
    }

    @Override // e4.fh
    public boolean s() {
        return true;
    }
}
