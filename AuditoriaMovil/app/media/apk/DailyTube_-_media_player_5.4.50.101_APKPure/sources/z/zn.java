package z;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: gv  reason: collision with root package name */
    public int f15550gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f15551n3;
    public int[] y;

    /* renamed from: zn  reason: collision with root package name */
    public int f15552zn;

    public zn() {
        this(8);
    }

    public boolean gv() {
        if (this.f15551n3 == this.f15552zn) {
            return true;
        }
        return false;
    }

    public void n3() {
        this.f15552zn = this.f15551n3;
    }

    public int v() {
        int i = this.f15551n3;
        if (i != this.f15552zn) {
            int i5 = this.y[i];
            this.f15551n3 = (i + 1) & this.f15550gv;
            return i5;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void y(int i) {
        int[] iArr = this.y;
        int i5 = this.f15552zn;
        iArr[i5] = i;
        int i6 = this.f15550gv & (i5 + 1);
        this.f15552zn = i6;
        if (i6 == this.f15551n3) {
            zn();
        }
    }

    public final void zn() {
        int[] iArr = this.y;
        int length = iArr.length;
        int i = this.f15551n3;
        int i5 = length - i;
        int i6 = length << 1;
        if (i6 >= 0) {
            int[] iArr2 = new int[i6];
            System.arraycopy(iArr, i, iArr2, 0, i5);
            System.arraycopy(this.y, 0, iArr2, i5, this.f15551n3);
            this.y = iArr2;
            this.f15551n3 = 0;
            this.f15552zn = length;
            this.f15550gv = i6 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public zn(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.f15550gv = i - 1;
            this.y = new int[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
