package ha;

import v5.j5;
/* loaded from: classes.dex */
public final class mt {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f8846a;

    /* renamed from: fb  reason: collision with root package name */
    public final int[] f8847fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int[] f8848gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f8849n3;

    /* renamed from: s  reason: collision with root package name */
    public final long f8850s;

    /* renamed from: v  reason: collision with root package name */
    public final int f8851v;
    public final xc y;

    /* renamed from: zn  reason: collision with root package name */
    public final long[] f8852zn;

    public mt(xc xcVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j2) {
        boolean z2;
        boolean z3;
        if (iArr.length == jArr2.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (jArr.length == jArr2.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        v5.y.y(z3);
        v5.y.y(iArr2.length == jArr2.length);
        this.y = xcVar;
        this.f8852zn = jArr;
        this.f8848gv = iArr;
        this.f8851v = i;
        this.f8846a = jArr2;
        this.f8847fb = iArr2;
        this.f8850s = j2;
        this.f8849n3 = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int n3(long j2) {
        for (int v2 = j5.v(this.f8846a, j2, true, false); v2 < this.f8846a.length; v2++) {
            if ((this.f8847fb[v2] & 1) != 0) {
                return v2;
            }
        }
        return -1;
    }

    public int y(long j2) {
        for (int c52 = j5.c5(this.f8846a, j2, true, false); c52 >= 0; c52--) {
            if ((this.f8847fb[c52] & 1) != 0) {
                return c52;
            }
        }
        return -1;
    }
}
