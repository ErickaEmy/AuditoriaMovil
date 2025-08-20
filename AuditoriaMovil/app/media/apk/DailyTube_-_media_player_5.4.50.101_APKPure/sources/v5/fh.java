package v5;

import androidx.core.app.NotificationCompat;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class fh {

    /* renamed from: gv  reason: collision with root package name */
    public int f14351gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f14352n3;
    public byte[] y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14353zn;

    public fh() {
        this.y = j5.f14357a;
    }

    public void a(int i, int i5) {
        if (i5 < 32) {
            i &= (1 << i5) - 1;
        }
        int min = Math.min(8 - this.f14353zn, i5);
        int i6 = this.f14353zn;
        int i8 = (8 - i6) - min;
        byte[] bArr = this.y;
        int i10 = this.f14352n3;
        byte b2 = (byte) (((65280 >> i6) | ((1 << i8) - 1)) & bArr[i10]);
        bArr[i10] = b2;
        int i11 = i5 - min;
        bArr[i10] = (byte) (b2 | ((i >>> i11) << i8));
        int i12 = i10 + 1;
        while (i11 > 8) {
            this.y[i12] = (byte) (i >>> (i11 - 8));
            i11 -= 8;
            i12++;
        }
        int i13 = 8 - i11;
        byte[] bArr2 = this.y;
        byte b3 = (byte) (bArr2[i12] & ((1 << i13) - 1));
        bArr2[i12] = b3;
        bArr2[i12] = (byte) (((i & ((1 << i11) - 1)) << i13) | b3);
        mt(i5);
        y();
    }

    public void c5(byte[] bArr, int i, int i5) {
        int i6 = (i5 >> 3) + i;
        while (i < i6) {
            byte[] bArr2 = this.y;
            int i8 = this.f14352n3;
            int i10 = i8 + 1;
            this.f14352n3 = i10;
            byte b2 = bArr2[i8];
            int i11 = this.f14353zn;
            byte b3 = (byte) (b2 << i11);
            bArr[i] = b3;
            bArr[i] = (byte) (((255 & bArr2[i10]) >> (8 - i11)) | b3);
            i++;
        }
        int i12 = i5 & 7;
        if (i12 == 0) {
            return;
        }
        byte b4 = (byte) (bArr[i6] & (255 >> i12));
        bArr[i6] = b4;
        int i13 = this.f14353zn;
        if (i13 + i12 > 8) {
            byte[] bArr3 = this.y;
            int i14 = this.f14352n3;
            this.f14352n3 = i14 + 1;
            bArr[i6] = (byte) (b4 | ((bArr3[i14] & 255) << i13));
            this.f14353zn = i13 - 8;
        }
        int i15 = this.f14353zn + i12;
        this.f14353zn = i15;
        byte[] bArr4 = this.y;
        int i16 = this.f14352n3;
        bArr[i6] = (byte) (((byte) (((255 & bArr4[i16]) >> (8 - i15)) << (8 - i12))) | bArr[i6]);
        if (i15 == 8) {
            this.f14353zn = 0;
            this.f14352n3 = i16 + 1;
        }
        y();
    }

    public void co(int i) {
        boolean z2;
        if (this.f14353zn == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        y.fb(z2);
        this.f14352n3 += i;
        y();
    }

    public void f(byte[] bArr, int i, int i5) {
        boolean z2;
        if (this.f14353zn == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        y.fb(z2);
        System.arraycopy(this.y, this.f14352n3, bArr, i, i5);
        this.f14352n3 += i5;
        y();
    }

    public boolean fb() {
        boolean z2;
        if ((this.y[this.f14352n3] & (NotificationCompat.FLAG_HIGH_PRIORITY >> this.f14353zn)) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        p();
        return z2;
    }

    public int gv() {
        boolean z2;
        if (this.f14353zn == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        y.fb(z2);
        return this.f14352n3;
    }

    public long i9(int i) {
        if (i <= 32) {
            return j5.q(s(i));
        }
        return j5.ne(s(i - 32), s(32));
    }

    public void mt(int i) {
        int i5 = i / 8;
        int i6 = this.f14352n3 + i5;
        this.f14352n3 = i6;
        int i8 = this.f14353zn + (i - (i5 * 8));
        this.f14353zn = i8;
        if (i8 > 7) {
            this.f14352n3 = i6 + 1;
            this.f14353zn = i8 - 8;
        }
        y();
    }

    public int n3() {
        return ((this.f14351gv - this.f14352n3) * 8) - this.f14353zn;
    }

    public void p() {
        int i = this.f14353zn + 1;
        this.f14353zn = i;
        if (i == 8) {
            this.f14353zn = 0;
            this.f14352n3++;
        }
        y();
    }

    public int s(int i) {
        int i5;
        if (i == 0) {
            return 0;
        }
        this.f14353zn += i;
        int i6 = 0;
        while (true) {
            i5 = this.f14353zn;
            if (i5 <= 8) {
                break;
            }
            int i8 = i5 - 8;
            this.f14353zn = i8;
            byte[] bArr = this.y;
            int i10 = this.f14352n3;
            this.f14352n3 = i10 + 1;
            i6 |= (bArr[i10] & 255) << i8;
        }
        byte[] bArr2 = this.y;
        int i11 = this.f14352n3;
        int i12 = ((-1) >>> (32 - i)) & (i6 | ((bArr2[i11] & 255) >> (8 - i5)));
        if (i5 == 8) {
            this.f14353zn = 0;
            this.f14352n3 = i11 + 1;
        }
        y();
        return i12;
    }

    public String t(int i, Charset charset) {
        byte[] bArr = new byte[i];
        f(bArr, 0, i);
        return new String(bArr, charset);
    }

    public void tl(rz rzVar) {
        xc(rzVar.v(), rzVar.fb());
        w(rzVar.a() * 8);
    }

    public int v() {
        return (this.f14352n3 * 8) + this.f14353zn;
    }

    public void w(int i) {
        int i5 = i / 8;
        this.f14352n3 = i5;
        this.f14353zn = i - (i5 * 8);
        y();
    }

    public void wz(byte[] bArr) {
        xc(bArr, bArr.length);
    }

    public void xc(byte[] bArr, int i) {
        this.y = bArr;
        this.f14352n3 = 0;
        this.f14353zn = 0;
        this.f14351gv = i;
    }

    public final void y() {
        boolean z2;
        int i;
        int i5 = this.f14352n3;
        if (i5 >= 0 && (i5 < (i = this.f14351gv) || (i5 == i && this.f14353zn == 0))) {
            z2 = true;
        } else {
            z2 = false;
        }
        y.fb(z2);
    }

    public void zn() {
        if (this.f14353zn == 0) {
            return;
        }
        this.f14353zn = 0;
        this.f14352n3++;
        y();
    }

    public fh(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public fh(byte[] bArr, int i) {
        this.y = bArr;
        this.f14351gv = i;
    }
}
