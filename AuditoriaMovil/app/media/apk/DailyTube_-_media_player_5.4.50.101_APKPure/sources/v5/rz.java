package v5;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class rz {

    /* renamed from: n3  reason: collision with root package name */
    public int f14391n3;
    public byte[] y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14392zn;

    /* renamed from: gv  reason: collision with root package name */
    public static final char[] f14389gv = {'\r', '\n'};

    /* renamed from: v  reason: collision with root package name */
    public static final char[] f14390v = {'\n'};

    /* renamed from: a  reason: collision with root package name */
    public static final z0.c<Charset> f14388a = z0.c.j(w0.v.y, w0.v.f14523zn, w0.v.f14519a, w0.v.f14520gv, w0.v.f14522v);

    public rz() {
        this.y = j5.f14357a;
    }

    public int a() {
        return this.f14391n3;
    }

    public long a8() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        int i6 = i + 2;
        this.f14391n3 = i6;
        int i8 = i + 3;
        this.f14391n3 = i8;
        this.f14391n3 = i + 4;
        return (bArr[i8] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8);
    }

    public int b() {
        int p2 = p();
        if (p2 >= 0) {
            return p2;
        }
        throw new IllegalStateException("Top bit not zero: " + p2);
    }

    public int c() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        this.f14391n3 = i + 2;
        return ((bArr[i5] & 255) << 8) | (bArr[i] & 255);
    }

    public final int c5(Charset charset) {
        byte y;
        char zn2;
        int i = 1;
        if ((charset.equals(w0.v.f14523zn) || charset.equals(w0.v.y)) && y() >= 1) {
            y = (byte) d1.zn.y(d1.c5.y(this.y[this.f14391n3]));
        } else {
            if ((charset.equals(w0.v.f14519a) || charset.equals(w0.v.f14520gv)) && y() >= 2) {
                byte[] bArr = this.y;
                int i5 = this.f14391n3;
                zn2 = d1.zn.zn(bArr[i5], bArr[i5 + 1]);
            } else if (charset.equals(w0.v.f14522v) && y() >= 2) {
                byte[] bArr2 = this.y;
                int i6 = this.f14391n3;
                zn2 = d1.zn.zn(bArr2[i6 + 1], bArr2[i6]);
            } else {
                return 0;
            }
            y = (byte) zn2;
            i = 2;
        }
        return (d1.zn.y(y) << 16) + i;
    }

    @Nullable
    public String co() {
        return z(w0.v.f14523zn);
    }

    public String d(int i, Charset charset) {
        String str = new String(this.y, this.f14391n3, i, charset);
        this.f14391n3 += i;
        return str;
    }

    public long d0() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        int i6 = i + 2;
        this.f14391n3 = i6;
        int i8 = i + 3;
        this.f14391n3 = i8;
        long j2 = ((bArr[i] & 255) << 56) | ((bArr[i5] & 255) << 48) | ((bArr[i6] & 255) << 40);
        int i10 = i + 4;
        this.f14391n3 = i10;
        int i11 = i + 5;
        this.f14391n3 = i11;
        long j4 = j2 | ((bArr[i8] & 255) << 32) | ((bArr[i10] & 255) << 24);
        int i12 = i + 6;
        this.f14391n3 = i12;
        int i13 = i + 7;
        this.f14391n3 = i13;
        this.f14391n3 = i + 8;
        return (bArr[i13] & 255) | j4 | ((bArr[i11] & 255) << 16) | ((bArr[i12] & 255) << 8);
    }

    public int ej() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        this.f14391n3 = i + 1;
        return bArr[i] & 255;
    }

    public void f(fh fhVar, int i) {
        t(fhVar.y, 0, i);
        fhVar.w(0);
    }

    public long f3() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        int i6 = i + 2;
        this.f14391n3 = i6;
        int i8 = i + 3;
        this.f14391n3 = i8;
        this.f14391n3 = i + 4;
        return ((bArr[i8] & 255) << 24) | (bArr[i] & 255) | ((bArr[i5] & 255) << 8) | ((bArr[i6] & 255) << 16);
    }

    public int fb() {
        return this.f14392zn;
    }

    @Nullable
    public String fh() {
        return wz((char) 0);
    }

    public final int gv(Charset charset) {
        int i;
        if (!charset.equals(w0.v.f14523zn) && !charset.equals(w0.v.y)) {
            if (!charset.equals(w0.v.f14519a) && !charset.equals(w0.v.f14522v) && !charset.equals(w0.v.f14520gv)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i = 2;
        } else {
            i = 1;
        }
        int i5 = this.f14391n3;
        while (true) {
            int i6 = this.f14392zn;
            if (i5 < i6 - (i - 1)) {
                if ((charset.equals(w0.v.f14523zn) || charset.equals(w0.v.y)) && j5.bk(this.y[i5])) {
                    return i5;
                }
                if (charset.equals(w0.v.f14519a) || charset.equals(w0.v.f14520gv)) {
                    byte[] bArr = this.y;
                    if (bArr[i5] == 0 && j5.bk(bArr[i5 + 1])) {
                        return i5;
                    }
                }
                if (charset.equals(w0.v.f14522v)) {
                    byte[] bArr2 = this.y;
                    if (bArr2[i5 + 1] == 0 && j5.bk(bArr2[i5])) {
                        return i5;
                    }
                }
                i5 += i;
            } else {
                return i6;
            }
        }
    }

    @Nullable
    public Charset hw() {
        if (y() >= 3) {
            byte[] bArr = this.y;
            int i = this.f14391n3;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.f14391n3 = i + 3;
                return w0.v.f14523zn;
            }
        }
        if (y() >= 2) {
            byte[] bArr2 = this.y;
            int i5 = this.f14391n3;
            byte b2 = bArr2[i5];
            if (b2 == -2 && bArr2[i5 + 1] == -1) {
                this.f14391n3 = i5 + 2;
                return w0.v.f14520gv;
            } else if (b2 == -1 && bArr2[i5 + 1] == -2) {
                this.f14391n3 = i5 + 2;
                return w0.v.f14522v;
            } else {
                return null;
            }
        }
        return null;
    }

    public short i4() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        this.f14391n3 = i + 2;
        return (short) (((bArr[i5] & 255) << 8) | (bArr[i] & 255));
    }

    public int i9() {
        return this.y[this.f14391n3] & 255;
    }

    public void j(int i) {
        boolean z2;
        if (i >= 0 && i <= this.y.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        y.y(z2);
        this.f14392zn = i;
    }

    public void j5(int i) {
        byte[] bArr;
        if (n3() < i) {
            bArr = new byte[i];
        } else {
            bArr = this.y;
        }
        o(bArr, i);
    }

    public long k5() {
        long d02 = d0();
        if (d02 >= 0) {
            return d02;
        }
        throw new IllegalStateException("Top bit not zero: " + d02);
    }

    public short mg() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        this.f14391n3 = i + 2;
        return (short) ((bArr[i5] & 255) | ((bArr[i] & 255) << 8));
    }

    public int mt() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        int i6 = i + 2;
        this.f14391n3 = i6;
        int i8 = (bArr[i5] & 255) << 8;
        this.f14391n3 = i + 3;
        return (bArr[i6] & 255) | i8 | (((bArr[i] & 255) << 24) >> 8);
    }

    public int n() {
        int r2 = r();
        if (r2 >= 0) {
            return r2;
        }
        throw new IllegalStateException("Top bit not zero: " + r2);
    }

    public int n3() {
        return this.y.length;
    }

    public void o(byte[] bArr, int i) {
        this.y = bArr;
        this.f14392zn = i;
        this.f14391n3 = 0;
    }

    public void oz(int i) {
        boolean z2;
        if (i >= 0 && i <= this.f14392zn) {
            z2 = true;
        } else {
            z2 = false;
        }
        y.y(z2);
        this.f14391n3 = i;
    }

    public int p() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        int i6 = i + 2;
        this.f14391n3 = i6;
        int i8 = ((bArr[i5] & 255) << 16) | ((bArr[i] & 255) << 24);
        int i10 = i + 3;
        this.f14391n3 = i10;
        this.f14391n3 = i + 4;
        return (bArr[i10] & 255) | i8 | ((bArr[i6] & 255) << 8);
    }

    public final void q9(Charset charset) {
        if (tl(charset, f14389gv) == '\r') {
            tl(charset, f14390v);
        }
    }

    public void qn(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public int r() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        int i6 = i + 2;
        this.f14391n3 = i6;
        int i8 = ((bArr[i5] & 255) << 8) | (bArr[i] & 255);
        int i10 = i + 3;
        this.f14391n3 = i10;
        this.f14391n3 = i + 4;
        return ((bArr[i10] & 255) << 24) | i8 | ((bArr[i6] & 255) << 16);
    }

    public String rz(int i) {
        int i5;
        if (i == 0) {
            return "";
        }
        int i6 = this.f14391n3;
        int i8 = (i6 + i) - 1;
        if (i8 < this.f14392zn && this.y[i8] == 0) {
            i5 = i - 1;
        } else {
            i5 = i;
        }
        String ta2 = j5.ta(this.y, i6, i5);
        this.f14391n3 += i;
        return ta2;
    }

    public char s(Charset charset) {
        boolean contains = f14388a.contains(charset);
        y.n3(contains, "Unsupported charset: " + charset);
        return (char) (c5(charset) >> 16);
    }

    public void t(byte[] bArr, int i, int i5) {
        System.arraycopy(this.y, this.f14391n3, bArr, i, i5);
        this.f14391n3 += i5;
    }

    public String ta(int i) {
        return d(i, w0.v.f14523zn);
    }

    public final char tl(Charset charset, char[] cArr) {
        int c52 = c5(charset);
        if (c52 != 0) {
            char c2 = (char) (c52 >> 16);
            if (d1.zn.n3(cArr, c2)) {
                this.f14391n3 += c52 & 65535;
                return c2;
            }
            return (char) 0;
        }
        return (char) 0;
    }

    public int ud() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        this.f14391n3 = i + 2;
        int i6 = (bArr[i5] & 255) | ((bArr[i] & 255) << 8);
        this.f14391n3 = i + 4;
        return i6;
    }

    public void ut(int i) {
        oz(this.f14391n3 + i);
    }

    public byte[] v() {
        return this.y;
    }

    public long vl() {
        int i;
        int i5;
        byte b2;
        int i6;
        long j2 = this.y[this.f14391n3];
        int i8 = 7;
        while (true) {
            if (i8 < 0) {
                break;
            }
            if (((1 << i8) & j2) != 0) {
                i8--;
            } else if (i8 < 6) {
                j2 &= i6 - 1;
                i5 = 7 - i8;
            } else if (i8 == 7) {
                i5 = 1;
            }
        }
        i5 = 0;
        if (i5 != 0) {
            for (i = 1; i < i5; i++) {
                if ((this.y[this.f14391n3 + i] & 192) == 128) {
                    j2 = (j2 << 6) | (b2 & 63);
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                }
            }
            this.f14391n3 += i5;
            return j2;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
    }

    public float w() {
        return Float.intBitsToFloat(p());
    }

    @Nullable
    public String wz(char c2) {
        if (y() == 0) {
            return null;
        }
        int i = this.f14391n3;
        while (i < this.f14392zn && this.y[i] != c2) {
            i++;
        }
        byte[] bArr = this.y;
        int i5 = this.f14391n3;
        String ta2 = j5.ta(bArr, i5, i - i5);
        this.f14391n3 = i;
        if (i < this.f14392zn) {
            this.f14391n3 = i + 1;
        }
        return ta2;
    }

    public int x() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        int i6 = i + 2;
        this.f14391n3 = i6;
        int i8 = (bArr[i5] & 255) << 8;
        this.f14391n3 = i + 3;
        return (bArr[i6] & 255) | i8 | ((bArr[i] & 255) << 16);
    }

    public long x4() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        int i6 = i + 2;
        this.f14391n3 = i6;
        long j2 = (bArr[i] & 255) | ((bArr[i5] & 255) << 8);
        int i8 = i + 3;
        this.f14391n3 = i8;
        int i10 = i + 4;
        this.f14391n3 = i10;
        long j4 = j2 | ((bArr[i6] & 255) << 16) | ((bArr[i8] & 255) << 24);
        int i11 = i + 5;
        this.f14391n3 = i11;
        int i12 = i + 6;
        this.f14391n3 = i12;
        long j6 = j4 | ((bArr[i10] & 255) << 32) | ((bArr[i11] & 255) << 40);
        int i13 = i + 7;
        this.f14391n3 = i13;
        this.f14391n3 = i + 8;
        return ((bArr[i13] & 255) << 56) | j6 | ((bArr[i12] & 255) << 48);
    }

    public double xc() {
        return Double.longBitsToDouble(d0());
    }

    public int y() {
        return this.f14392zn - this.f14391n3;
    }

    public int yt() {
        byte[] bArr = this.y;
        int i = this.f14391n3;
        int i5 = i + 1;
        this.f14391n3 = i5;
        this.f14391n3 = i + 2;
        return (bArr[i5] & 255) | ((bArr[i] & 255) << 8);
    }

    @Nullable
    public String z(Charset charset) {
        boolean contains = f14388a.contains(charset);
        y.n3(contains, "Unsupported charset: " + charset);
        if (y() == 0) {
            return null;
        }
        if (!charset.equals(w0.v.y)) {
            hw();
        }
        String d2 = d(gv(charset) - this.f14391n3, charset);
        if (this.f14391n3 == this.f14392zn) {
            return d2;
        }
        q9(charset);
        return d2;
    }

    public int z6() {
        return (ej() << 21) | (ej() << 14) | (ej() << 7) | ej();
    }

    public void zn(int i) {
        if (i > n3()) {
            this.y = Arrays.copyOf(this.y, i);
        }
    }

    public rz(int i) {
        this.y = new byte[i];
        this.f14392zn = i;
    }

    public rz(byte[] bArr) {
        this.y = bArr;
        this.f14392zn = bArr.length;
    }

    public rz(byte[] bArr, int i) {
        this.y = bArr;
        this.f14392zn = i;
    }
}
