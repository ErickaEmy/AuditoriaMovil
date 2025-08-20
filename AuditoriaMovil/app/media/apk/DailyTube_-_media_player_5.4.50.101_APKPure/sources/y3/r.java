package y3;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: gv  reason: collision with root package name */
    public byte[] f15124gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f15125n3;

    /* renamed from: v  reason: collision with root package name */
    public int f15126v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f15127zn;

    public r(int i, int i5) {
        this.y = i;
        byte[] bArr = new byte[i5 + 3];
        this.f15124gv = bArr;
        bArr[2] = 1;
    }

    public void gv() {
        this.f15125n3 = false;
        this.f15127zn = false;
    }

    public boolean n3(int i) {
        if (!this.f15125n3) {
            return false;
        }
        this.f15126v -= i;
        this.f15125n3 = false;
        this.f15127zn = true;
        return true;
    }

    public void v(int i) {
        boolean z2 = true;
        v5.y.fb(!this.f15125n3);
        if (i != this.y) {
            z2 = false;
        }
        this.f15125n3 = z2;
        if (z2) {
            this.f15126v = 3;
            this.f15127zn = false;
        }
    }

    public void y(byte[] bArr, int i, int i5) {
        if (!this.f15125n3) {
            return;
        }
        int i6 = i5 - i;
        byte[] bArr2 = this.f15124gv;
        int length = bArr2.length;
        int i8 = this.f15126v;
        if (length < i8 + i6) {
            this.f15124gv = Arrays.copyOf(bArr2, (i8 + i6) * 2);
        }
        System.arraycopy(bArr, i, this.f15124gv, this.f15126v, i6);
        this.f15126v += i6;
    }

    public boolean zn() {
        return this.f15127zn;
    }
}
