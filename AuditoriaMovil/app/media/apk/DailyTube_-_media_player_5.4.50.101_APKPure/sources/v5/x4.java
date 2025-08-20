package v5;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class x4 {

    /* renamed from: n3  reason: collision with root package name */
    public long[] f14405n3;
    public int y;

    public x4() {
        this(32);
    }

    public long[] gv() {
        return Arrays.copyOf(this.f14405n3, this.y);
    }

    public long n3(int i) {
        if (i >= 0 && i < this.y) {
            return this.f14405n3[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.y);
    }

    public void y(long j2) {
        int i = this.y;
        long[] jArr = this.f14405n3;
        if (i == jArr.length) {
            this.f14405n3 = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f14405n3;
        int i5 = this.y;
        this.y = i5 + 1;
        jArr2[i5] = j2;
    }

    public int zn() {
        return this.y;
    }

    public x4(int i) {
        this.f14405n3 = new long[i];
    }
}
