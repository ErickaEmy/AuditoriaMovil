package sc;

import e4.tl;
import java.io.IOException;
/* loaded from: classes.dex */
public final class fb {

    /* renamed from: gv  reason: collision with root package name */
    public static final long[] f13525gv = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: n3  reason: collision with root package name */
    public int f13526n3;
    public final byte[] y = new byte[8];

    /* renamed from: zn  reason: collision with root package name */
    public int f13527zn;

    public static long y(byte[] bArr, int i, boolean z2) {
        long j2 = bArr[0] & 255;
        if (z2) {
            j2 &= ~f13525gv[i - 1];
        }
        for (int i5 = 1; i5 < i; i5++) {
            j2 = (j2 << 8) | (bArr[i5] & 255);
        }
        return j2;
    }

    public static int zn(int i) {
        int i5 = 0;
        while (true) {
            long[] jArr = f13525gv;
            if (i5 < jArr.length) {
                if ((jArr[i5] & i) != 0) {
                    return i5 + 1;
                }
                i5++;
            } else {
                return -1;
            }
        }
    }

    public long gv(tl tlVar, boolean z2, boolean z3, int i) throws IOException {
        if (this.f13526n3 == 0) {
            if (!tlVar.f(this.y, 0, 1, z2)) {
                return -1L;
            }
            int zn2 = zn(this.y[0] & 255);
            this.f13527zn = zn2;
            if (zn2 != -1) {
                this.f13526n3 = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i5 = this.f13527zn;
        if (i5 > i) {
            this.f13526n3 = 0;
            return -2L;
        }
        if (i5 != 1) {
            tlVar.readFully(this.y, 1, i5 - 1);
        }
        this.f13526n3 = 0;
        return y(this.y, this.f13527zn, z3);
    }

    public int n3() {
        return this.f13527zn;
    }

    public void v() {
        this.f13526n3 = 0;
        this.f13527zn = 0;
    }
}
