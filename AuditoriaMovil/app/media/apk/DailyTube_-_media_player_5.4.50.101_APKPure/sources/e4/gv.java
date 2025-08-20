package e4;

import e4.fh;
import java.util.Arrays;
import v5.j5;
/* loaded from: classes.dex */
public final class gv implements fh {

    /* renamed from: a  reason: collision with root package name */
    public final long f7505a;

    /* renamed from: gv  reason: collision with root package name */
    public final long[] f7506gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int[] f7507n3;

    /* renamed from: v  reason: collision with root package name */
    public final long[] f7508v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final long[] f7509zn;

    public gv(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f7507n3 = iArr;
        this.f7509zn = jArr;
        this.f7506gv = jArr2;
        this.f7508v = jArr3;
        int length = iArr.length;
        this.y = length;
        if (length > 0) {
            this.f7505a = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f7505a = 0L;
        }
    }

    @Override // e4.fh
    public long c5() {
        return this.f7505a;
    }

    @Override // e4.fh
    public fh.y gv(long j2) {
        int y = y(j2);
        rz rzVar = new rz(this.f7508v[y], this.f7509zn[y]);
        if (rzVar.y < j2 && y != this.y - 1) {
            int i = y + 1;
            return new fh.y(rzVar, new rz(this.f7508v[i], this.f7509zn[i]));
        }
        return new fh.y(rzVar);
    }

    @Override // e4.fh
    public boolean s() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.y + ", sizes=" + Arrays.toString(this.f7507n3) + ", offsets=" + Arrays.toString(this.f7509zn) + ", timeUs=" + Arrays.toString(this.f7508v) + ", durationsUs=" + Arrays.toString(this.f7506gv) + ")";
    }

    public int y(long j2) {
        return j5.c5(this.f7508v, j2, true, true);
    }
}
