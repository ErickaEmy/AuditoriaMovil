package v5;

import androidx.core.app.NotificationCompat;
/* loaded from: classes.dex */
public final class mg {

    /* renamed from: gv  reason: collision with root package name */
    public int f14374gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f14375n3;
    public byte[] y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14376zn;

    public mg(byte[] bArr, int i, int i5) {
        c5(bArr, i, i5);
    }

    public final int a() {
        int i = 0;
        int i5 = 0;
        while (!gv()) {
            i5++;
        }
        int i6 = (1 << i5) - 1;
        if (i5 > 0) {
            i = v(i5);
        }
        return i6 + i;
    }

    public void c5(byte[] bArr, int i, int i5) {
        this.y = bArr;
        this.f14376zn = i;
        this.f14375n3 = i5;
        this.f14374gv = 0;
        y();
    }

    public void f() {
        int i = 1;
        int i5 = this.f14374gv + 1;
        this.f14374gv = i5;
        if (i5 == 8) {
            this.f14374gv = 0;
            int i6 = this.f14376zn;
            if (i9(i6 + 1)) {
                i = 2;
            }
            this.f14376zn = i6 + i;
        }
        y();
    }

    public int fb() {
        int i;
        int a2 = a();
        if (a2 % 2 == 0) {
            i = -1;
        } else {
            i = 1;
        }
        return i * ((a2 + 1) / 2);
    }

    public boolean gv() {
        boolean z2;
        if ((this.y[this.f14376zn] & (NotificationCompat.FLAG_HIGH_PRIORITY >> this.f14374gv)) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        f();
        return z2;
    }

    public final boolean i9(int i) {
        if (2 <= i && i < this.f14375n3) {
            byte[] bArr = this.y;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean n3(int i) {
        int i5 = this.f14376zn;
        int i6 = i / 8;
        int i8 = i5 + i6;
        int i10 = (this.f14374gv + i) - (i6 * 8);
        if (i10 > 7) {
            i8++;
            i10 -= 8;
        }
        while (true) {
            i5++;
            if (i5 > i8 || i8 >= this.f14375n3) {
                break;
            } else if (i9(i5)) {
                i8++;
                i5 += 2;
            }
        }
        int i11 = this.f14375n3;
        if (i8 < i11) {
            return true;
        }
        if (i8 == i11 && i10 == 0) {
            return true;
        }
        return false;
    }

    public int s() {
        return a();
    }

    public void t(int i) {
        int i5 = this.f14376zn;
        int i6 = i / 8;
        int i8 = i5 + i6;
        this.f14376zn = i8;
        int i10 = this.f14374gv + (i - (i6 * 8));
        this.f14374gv = i10;
        if (i10 > 7) {
            this.f14376zn = i8 + 1;
            this.f14374gv = i10 - 8;
        }
        while (true) {
            i5++;
            if (i5 <= this.f14376zn) {
                if (i9(i5)) {
                    this.f14376zn++;
                    i5 += 2;
                }
            } else {
                y();
                return;
            }
        }
    }

    public int v(int i) {
        int i5;
        int i6;
        this.f14374gv += i;
        int i8 = 0;
        while (true) {
            i5 = this.f14374gv;
            i6 = 2;
            if (i5 <= 8) {
                break;
            }
            int i10 = i5 - 8;
            this.f14374gv = i10;
            byte[] bArr = this.y;
            int i11 = this.f14376zn;
            i8 |= (bArr[i11] & 255) << i10;
            if (!i9(i11 + 1)) {
                i6 = 1;
            }
            this.f14376zn = i11 + i6;
        }
        byte[] bArr2 = this.y;
        int i12 = this.f14376zn;
        int i13 = ((-1) >>> (32 - i)) & (i8 | ((bArr2[i12] & 255) >> (8 - i5)));
        if (i5 == 8) {
            this.f14374gv = 0;
            if (!i9(i12 + 1)) {
                i6 = 1;
            }
            this.f14376zn = i12 + i6;
        }
        y();
        return i13;
    }

    public final void y() {
        boolean z2;
        int i;
        int i5 = this.f14376zn;
        if (i5 >= 0 && (i5 < (i = this.f14375n3) || (i5 == i && this.f14374gv == 0))) {
            z2 = true;
        } else {
            z2 = false;
        }
        y.fb(z2);
    }

    public boolean zn() {
        boolean z2;
        int i = this.f14376zn;
        int i5 = this.f14374gv;
        int i6 = 0;
        while (this.f14376zn < this.f14375n3 && !gv()) {
            i6++;
        }
        if (this.f14376zn == this.f14375n3) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f14376zn = i;
        this.f14374gv = i5;
        if (z2 || !n3((i6 * 2) + 1)) {
            return false;
        }
        return true;
    }
}
