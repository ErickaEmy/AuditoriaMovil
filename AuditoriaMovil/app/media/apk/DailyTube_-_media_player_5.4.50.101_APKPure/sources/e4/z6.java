package e4;
/* loaded from: classes.dex */
public final class z6 {

    /* renamed from: gv  reason: collision with root package name */
    public int f7554gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f7555n3;
    public final byte[] y;

    /* renamed from: zn  reason: collision with root package name */
    public int f7556zn;

    public z6(byte[] bArr) {
        this.y = bArr;
        this.f7555n3 = bArr.length;
    }

    public int gv(int i) {
        int i5 = this.f7556zn;
        int min = Math.min(i, 8 - this.f7554gv);
        int i6 = i5 + 1;
        int i8 = ((this.y[i5] & 255) >> this.f7554gv) & (255 >> (8 - min));
        while (min < i) {
            i8 |= (this.y[i6] & 255) << min;
            min += 8;
            i6++;
        }
        int i10 = i8 & ((-1) >>> (32 - i));
        v(i);
        return i10;
    }

    public int n3() {
        return (this.f7556zn * 8) + this.f7554gv;
    }

    public void v(int i) {
        int i5 = i / 8;
        int i6 = this.f7556zn + i5;
        this.f7556zn = i6;
        int i8 = this.f7554gv + (i - (i5 * 8));
        this.f7554gv = i8;
        if (i8 > 7) {
            this.f7556zn = i6 + 1;
            this.f7554gv = i8 - 8;
        }
        y();
    }

    public final void y() {
        boolean z2;
        int i;
        int i5 = this.f7556zn;
        if (i5 >= 0 && (i5 < (i = this.f7555n3) || (i5 == i && this.f7554gv == 0))) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
    }

    public boolean zn() {
        boolean z2;
        if ((((this.y[this.f7556zn] & 255) >> this.f7554gv) & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v(1);
        return z2;
    }
}
