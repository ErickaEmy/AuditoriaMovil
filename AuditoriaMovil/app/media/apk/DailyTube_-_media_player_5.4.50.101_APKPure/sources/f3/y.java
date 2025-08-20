package f3;

import f3.n3;
import java.util.Arrays;
/* loaded from: classes.dex */
public class y implements n3.y {

    /* renamed from: t  reason: collision with root package name */
    public static float f7843t = 0.001f;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7846f;

    /* renamed from: n3  reason: collision with root package name */
    public final n3 f7850n3;

    /* renamed from: v  reason: collision with root package name */
    public c5 f7852v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public final zn f7853zn;

    /* renamed from: gv  reason: collision with root package name */
    public int f7848gv = 8;

    /* renamed from: a  reason: collision with root package name */
    public int[] f7844a = new int[8];

    /* renamed from: fb  reason: collision with root package name */
    public int[] f7847fb = new int[8];

    /* renamed from: s  reason: collision with root package name */
    public float[] f7851s = new float[8];

    /* renamed from: c5  reason: collision with root package name */
    public int f7845c5 = -1;

    /* renamed from: i9  reason: collision with root package name */
    public int f7849i9 = -1;

    public y(n3 n3Var, zn znVar) {
        this.f7850n3 = n3Var;
        this.f7853zn = znVar;
    }

    @Override // f3.n3.y
    public boolean a(c5 c5Var) {
        int i = this.f7845c5;
        if (i == -1) {
            return false;
        }
        for (int i5 = 0; i != -1 && i5 < this.y; i5++) {
            if (this.f7844a[i] == c5Var.f7785zn) {
                return true;
            }
            i = this.f7847fb[i];
        }
        return false;
    }

    @Override // f3.n3.y
    public float c5(int i) {
        int i5 = this.f7845c5;
        for (int i6 = 0; i5 != -1 && i6 < this.y; i6++) {
            if (i6 == i) {
                return this.f7851s[i5];
            }
            i5 = this.f7847fb[i5];
        }
        return 0.0f;
    }

    @Override // f3.n3.y
    public final void clear() {
        int i = this.f7845c5;
        for (int i5 = 0; i != -1 && i5 < this.y; i5++) {
            c5 c5Var = this.f7853zn.f7854gv[this.f7844a[i]];
            if (c5Var != null) {
                c5Var.zn(this.f7850n3);
            }
            i = this.f7847fb[i];
        }
        this.f7845c5 = -1;
        this.f7849i9 = -1;
        this.f7846f = false;
        this.y = 0;
    }

    @Override // f3.n3.y
    public final void f(c5 c5Var, float f4) {
        if (f4 == 0.0f) {
            t(c5Var, true);
            return;
        }
        int i = this.f7845c5;
        if (i == -1) {
            this.f7845c5 = 0;
            this.f7851s[0] = f4;
            this.f7844a[0] = c5Var.f7785zn;
            this.f7847fb[0] = -1;
            c5Var.f7780tl++;
            c5Var.y(this.f7850n3);
            this.y++;
            if (!this.f7846f) {
                int i5 = this.f7849i9 + 1;
                this.f7849i9 = i5;
                int[] iArr = this.f7844a;
                if (i5 >= iArr.length) {
                    this.f7846f = true;
                    this.f7849i9 = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i6 = -1;
        for (int i8 = 0; i != -1 && i8 < this.y; i8++) {
            int i10 = this.f7844a[i];
            int i11 = c5Var.f7785zn;
            if (i10 == i11) {
                this.f7851s[i] = f4;
                return;
            }
            if (i10 < i11) {
                i6 = i;
            }
            i = this.f7847fb[i];
        }
        int i12 = this.f7849i9;
        int i13 = i12 + 1;
        if (this.f7846f) {
            int[] iArr2 = this.f7844a;
            if (iArr2[i12] != -1) {
                i12 = iArr2.length;
            }
        } else {
            i12 = i13;
        }
        int[] iArr3 = this.f7844a;
        if (i12 >= iArr3.length && this.y < iArr3.length) {
            int i14 = 0;
            while (true) {
                int[] iArr4 = this.f7844a;
                if (i14 >= iArr4.length) {
                    break;
                } else if (iArr4[i14] == -1) {
                    i12 = i14;
                    break;
                } else {
                    i14++;
                }
            }
        }
        int[] iArr5 = this.f7844a;
        if (i12 >= iArr5.length) {
            i12 = iArr5.length;
            int i15 = this.f7848gv * 2;
            this.f7848gv = i15;
            this.f7846f = false;
            this.f7849i9 = i12 - 1;
            this.f7851s = Arrays.copyOf(this.f7851s, i15);
            this.f7844a = Arrays.copyOf(this.f7844a, this.f7848gv);
            this.f7847fb = Arrays.copyOf(this.f7847fb, this.f7848gv);
        }
        this.f7844a[i12] = c5Var.f7785zn;
        this.f7851s[i12] = f4;
        if (i6 != -1) {
            int[] iArr6 = this.f7847fb;
            iArr6[i12] = iArr6[i6];
            iArr6[i6] = i12;
        } else {
            this.f7847fb[i12] = this.f7845c5;
            this.f7845c5 = i12;
        }
        c5Var.f7780tl++;
        c5Var.y(this.f7850n3);
        int i16 = this.y + 1;
        this.y = i16;
        if (!this.f7846f) {
            this.f7849i9++;
        }
        int[] iArr7 = this.f7844a;
        if (i16 >= iArr7.length) {
            this.f7846f = true;
        }
        if (this.f7849i9 >= iArr7.length) {
            this.f7846f = true;
            this.f7849i9 = iArr7.length - 1;
        }
    }

    @Override // f3.n3.y
    public void fb() {
        int i = this.f7845c5;
        for (int i5 = 0; i != -1 && i5 < this.y; i5++) {
            float[] fArr = this.f7851s;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f7847fb[i];
        }
    }

    @Override // f3.n3.y
    public int gv() {
        return this.y;
    }

    @Override // f3.n3.y
    public void i9(c5 c5Var, float f4, boolean z2) {
        float f6 = f7843t;
        if (f4 > (-f6) && f4 < f6) {
            return;
        }
        int i = this.f7845c5;
        if (i == -1) {
            this.f7845c5 = 0;
            this.f7851s[0] = f4;
            this.f7844a[0] = c5Var.f7785zn;
            this.f7847fb[0] = -1;
            c5Var.f7780tl++;
            c5Var.y(this.f7850n3);
            this.y++;
            if (!this.f7846f) {
                int i5 = this.f7849i9 + 1;
                this.f7849i9 = i5;
                int[] iArr = this.f7844a;
                if (i5 >= iArr.length) {
                    this.f7846f = true;
                    this.f7849i9 = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i6 = -1;
        for (int i8 = 0; i != -1 && i8 < this.y; i8++) {
            int i10 = this.f7844a[i];
            int i11 = c5Var.f7785zn;
            if (i10 == i11) {
                float[] fArr = this.f7851s;
                float f9 = fArr[i] + f4;
                float f10 = f7843t;
                if (f9 > (-f10) && f9 < f10) {
                    f9 = 0.0f;
                }
                fArr[i] = f9;
                if (f9 == 0.0f) {
                    if (i == this.f7845c5) {
                        this.f7845c5 = this.f7847fb[i];
                    } else {
                        int[] iArr2 = this.f7847fb;
                        iArr2[i6] = iArr2[i];
                    }
                    if (z2) {
                        c5Var.zn(this.f7850n3);
                    }
                    if (this.f7846f) {
                        this.f7849i9 = i;
                    }
                    c5Var.f7780tl--;
                    this.y--;
                    return;
                }
                return;
            }
            if (i10 < i11) {
                i6 = i;
            }
            i = this.f7847fb[i];
        }
        int i12 = this.f7849i9;
        int i13 = i12 + 1;
        if (this.f7846f) {
            int[] iArr3 = this.f7844a;
            if (iArr3[i12] != -1) {
                i12 = iArr3.length;
            }
        } else {
            i12 = i13;
        }
        int[] iArr4 = this.f7844a;
        if (i12 >= iArr4.length && this.y < iArr4.length) {
            int i14 = 0;
            while (true) {
                int[] iArr5 = this.f7844a;
                if (i14 >= iArr5.length) {
                    break;
                } else if (iArr5[i14] == -1) {
                    i12 = i14;
                    break;
                } else {
                    i14++;
                }
            }
        }
        int[] iArr6 = this.f7844a;
        if (i12 >= iArr6.length) {
            i12 = iArr6.length;
            int i15 = this.f7848gv * 2;
            this.f7848gv = i15;
            this.f7846f = false;
            this.f7849i9 = i12 - 1;
            this.f7851s = Arrays.copyOf(this.f7851s, i15);
            this.f7844a = Arrays.copyOf(this.f7844a, this.f7848gv);
            this.f7847fb = Arrays.copyOf(this.f7847fb, this.f7848gv);
        }
        this.f7844a[i12] = c5Var.f7785zn;
        this.f7851s[i12] = f4;
        if (i6 != -1) {
            int[] iArr7 = this.f7847fb;
            iArr7[i12] = iArr7[i6];
            iArr7[i6] = i12;
        } else {
            this.f7847fb[i12] = this.f7845c5;
            this.f7845c5 = i12;
        }
        c5Var.f7780tl++;
        c5Var.y(this.f7850n3);
        this.y++;
        if (!this.f7846f) {
            this.f7849i9++;
        }
        int i16 = this.f7849i9;
        int[] iArr8 = this.f7844a;
        if (i16 >= iArr8.length) {
            this.f7846f = true;
            this.f7849i9 = iArr8.length - 1;
        }
    }

    @Override // f3.n3.y
    public float s(n3 n3Var, boolean z2) {
        float tl2 = tl(n3Var.y);
        t(n3Var.y, z2);
        n3.y yVar = n3Var.f7833v;
        int gv2 = yVar.gv();
        for (int i = 0; i < gv2; i++) {
            c5 v2 = yVar.v(i);
            i9(v2, yVar.tl(v2) * tl2, z2);
        }
        return tl2;
    }

    @Override // f3.n3.y
    public final float t(c5 c5Var, boolean z2) {
        if (this.f7852v == c5Var) {
            this.f7852v = null;
        }
        int i = this.f7845c5;
        if (i == -1) {
            return 0.0f;
        }
        int i5 = 0;
        int i6 = -1;
        while (i != -1 && i5 < this.y) {
            if (this.f7844a[i] == c5Var.f7785zn) {
                if (i == this.f7845c5) {
                    this.f7845c5 = this.f7847fb[i];
                } else {
                    int[] iArr = this.f7847fb;
                    iArr[i6] = iArr[i];
                }
                if (z2) {
                    c5Var.zn(this.f7850n3);
                }
                c5Var.f7780tl--;
                this.y--;
                this.f7844a[i] = -1;
                if (this.f7846f) {
                    this.f7849i9 = i;
                }
                return this.f7851s[i];
            }
            i5++;
            i6 = i;
            i = this.f7847fb[i];
        }
        return 0.0f;
    }

    @Override // f3.n3.y
    public final float tl(c5 c5Var) {
        int i = this.f7845c5;
        for (int i5 = 0; i != -1 && i5 < this.y; i5++) {
            if (this.f7844a[i] == c5Var.f7785zn) {
                return this.f7851s[i];
            }
            i = this.f7847fb[i];
        }
        return 0.0f;
    }

    public String toString() {
        int i = this.f7845c5;
        String str = "";
        for (int i5 = 0; i != -1 && i5 < this.y; i5++) {
            str = ((str + " -> ") + this.f7851s[i] + " : ") + this.f7853zn.f7854gv[this.f7844a[i]];
            i = this.f7847fb[i];
        }
        return str;
    }

    @Override // f3.n3.y
    public c5 v(int i) {
        int i5 = this.f7845c5;
        for (int i6 = 0; i5 != -1 && i6 < this.y; i6++) {
            if (i6 == i) {
                return this.f7853zn.f7854gv[this.f7844a[i5]];
            }
            i5 = this.f7847fb[i5];
        }
        return null;
    }

    @Override // f3.n3.y
    public void wz(float f4) {
        int i = this.f7845c5;
        for (int i5 = 0; i != -1 && i5 < this.y; i5++) {
            float[] fArr = this.f7851s;
            fArr[i] = fArr[i] / f4;
            i = this.f7847fb[i];
        }
    }
}
