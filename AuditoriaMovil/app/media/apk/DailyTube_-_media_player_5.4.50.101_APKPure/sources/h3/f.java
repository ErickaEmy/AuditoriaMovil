package h3;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: gv  reason: collision with root package name */
    public int[] f8417gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f8418n3 = -1;

    /* renamed from: v  reason: collision with root package name */
    public int f8419v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public int f8420zn;

    public f() {
        int[] iArr = new int[16];
        this.f8417gv = iArr;
        this.f8419v = iArr.length - 1;
    }

    public boolean gv() {
        if (this.f8420zn == 0) {
            return true;
        }
        return false;
    }

    public void n3() {
        this.y = 0;
        this.f8418n3 = -1;
        this.f8420zn = 0;
    }

    public int v() {
        int i = this.f8420zn;
        if (i != 0) {
            int[] iArr = this.f8417gv;
            int i5 = this.y;
            int i6 = iArr[i5];
            this.y = (i5 + 1) & this.f8419v;
            this.f8420zn = i - 1;
            return i6;
        }
        throw new NoSuchElementException();
    }

    public void y(int i) {
        if (this.f8420zn == this.f8417gv.length) {
            zn();
        }
        int i5 = (this.f8418n3 + 1) & this.f8419v;
        this.f8418n3 = i5;
        this.f8417gv[i5] = i;
        this.f8420zn++;
    }

    public final void zn() {
        int[] iArr = this.f8417gv;
        int length = iArr.length << 1;
        if (length >= 0) {
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i = this.y;
            int i5 = length2 - i;
            System.arraycopy(iArr, i, iArr2, 0, i5);
            System.arraycopy(this.f8417gv, 0, iArr2, i5, i);
            this.y = 0;
            this.f8418n3 = this.f8420zn - 1;
            this.f8417gv = iArr2;
            this.f8419v = iArr2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }
}
