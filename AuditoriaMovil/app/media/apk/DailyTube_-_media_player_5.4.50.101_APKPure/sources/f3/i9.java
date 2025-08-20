package f3;

import f3.n3;
import java.util.Arrays;
/* loaded from: classes.dex */
public class i9 implements n3.y {

    /* renamed from: wz  reason: collision with root package name */
    public static float f7817wz = 0.001f;

    /* renamed from: i9  reason: collision with root package name */
    public int f7823i9;

    /* renamed from: t  reason: collision with root package name */
    public final n3 f7826t;

    /* renamed from: tl  reason: collision with root package name */
    public final zn f7827tl;
    public final int y = -1;

    /* renamed from: n3  reason: collision with root package name */
    public int f7824n3 = 16;

    /* renamed from: zn  reason: collision with root package name */
    public int f7829zn = 16;

    /* renamed from: gv  reason: collision with root package name */
    public int[] f7822gv = new int[16];

    /* renamed from: v  reason: collision with root package name */
    public int[] f7828v = new int[16];

    /* renamed from: a  reason: collision with root package name */
    public int[] f7818a = new int[16];

    /* renamed from: fb  reason: collision with root package name */
    public float[] f7821fb = new float[16];

    /* renamed from: s  reason: collision with root package name */
    public int[] f7825s = new int[16];

    /* renamed from: c5  reason: collision with root package name */
    public int[] f7819c5 = new int[16];

    /* renamed from: f  reason: collision with root package name */
    public int f7820f = -1;

    public i9(n3 n3Var, zn znVar) {
        this.f7826t = n3Var;
        this.f7827tl = znVar;
        clear();
    }

    @Override // f3.n3.y
    public boolean a(c5 c5Var) {
        if (w(c5Var) != -1) {
            return true;
        }
        return false;
    }

    @Override // f3.n3.y
    public float c5(int i) {
        int i5 = this.f7823i9;
        int i6 = this.f7820f;
        for (int i8 = 0; i8 < i5; i8++) {
            if (i8 == i) {
                return this.f7821fb[i6];
            }
            i6 = this.f7819c5[i6];
            if (i6 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // f3.n3.y
    public void clear() {
        int i = this.f7823i9;
        for (int i5 = 0; i5 < i; i5++) {
            c5 v2 = v(i5);
            if (v2 != null) {
                v2.zn(this.f7826t);
            }
        }
        for (int i6 = 0; i6 < this.f7824n3; i6++) {
            this.f7818a[i6] = -1;
            this.f7828v[i6] = -1;
        }
        for (int i8 = 0; i8 < this.f7829zn; i8++) {
            this.f7822gv[i8] = -1;
        }
        this.f7823i9 = 0;
        this.f7820f = -1;
    }

    @Override // f3.n3.y
    public void f(c5 c5Var, float f4) {
        float f6 = f7817wz;
        if (f4 > (-f6) && f4 < f6) {
            t(c5Var, true);
            return;
        }
        if (this.f7823i9 == 0) {
            n3(0, c5Var, f4);
            y(c5Var, 0);
            this.f7820f = 0;
            return;
        }
        int w4 = w(c5Var);
        if (w4 != -1) {
            this.f7821fb[w4] = f4;
            return;
        }
        if (this.f7823i9 + 1 >= this.f7824n3) {
            xc();
        }
        int i = this.f7823i9;
        int i5 = this.f7820f;
        int i6 = -1;
        for (int i8 = 0; i8 < i; i8++) {
            int i10 = this.f7818a[i5];
            int i11 = c5Var.f7785zn;
            if (i10 == i11) {
                this.f7821fb[i5] = f4;
                return;
            }
            if (i10 < i11) {
                i6 = i5;
            }
            i5 = this.f7819c5[i5];
            if (i5 == -1) {
                break;
            }
        }
        p(i6, c5Var, f4);
    }

    @Override // f3.n3.y
    public void fb() {
        int i = this.f7823i9;
        int i5 = this.f7820f;
        for (int i6 = 0; i6 < i; i6++) {
            float[] fArr = this.f7821fb;
            fArr[i5] = fArr[i5] * (-1.0f);
            i5 = this.f7819c5[i5];
            if (i5 == -1) {
                return;
            }
        }
    }

    @Override // f3.n3.y
    public int gv() {
        return this.f7823i9;
    }

    @Override // f3.n3.y
    public void i9(c5 c5Var, float f4, boolean z2) {
        float f6 = f7817wz;
        if (f4 > (-f6) && f4 < f6) {
            return;
        }
        int w4 = w(c5Var);
        if (w4 == -1) {
            f(c5Var, f4);
            return;
        }
        float[] fArr = this.f7821fb;
        float f9 = fArr[w4] + f4;
        fArr[w4] = f9;
        float f10 = f7817wz;
        if (f9 > (-f10) && f9 < f10) {
            fArr[w4] = 0.0f;
            t(c5Var, z2);
        }
    }

    public final void mt(c5 c5Var) {
        int[] iArr;
        int i;
        int i5 = c5Var.f7785zn;
        int i6 = i5 % this.f7829zn;
        int[] iArr2 = this.f7822gv;
        int i8 = iArr2[i6];
        if (i8 == -1) {
            return;
        }
        if (this.f7818a[i8] == i5) {
            int[] iArr3 = this.f7828v;
            iArr2[i6] = iArr3[i8];
            iArr3[i8] = -1;
            return;
        }
        while (true) {
            iArr = this.f7828v;
            i = iArr[i8];
            if (i == -1 || this.f7818a[i] == i5) {
                break;
            }
            i8 = i;
        }
        if (i != -1 && this.f7818a[i] == i5) {
            iArr[i8] = iArr[i];
            iArr[i] = -1;
        }
    }

    public final void n3(int i, c5 c5Var, float f4) {
        this.f7818a[i] = c5Var.f7785zn;
        this.f7821fb[i] = f4;
        this.f7825s[i] = -1;
        this.f7819c5[i] = -1;
        c5Var.y(this.f7826t);
        c5Var.f7780tl++;
        this.f7823i9++;
    }

    public final void p(int i, c5 c5Var, float f4) {
        int zn2 = zn();
        n3(zn2, c5Var, f4);
        if (i != -1) {
            this.f7825s[zn2] = i;
            int[] iArr = this.f7819c5;
            iArr[zn2] = iArr[i];
            iArr[i] = zn2;
        } else {
            this.f7825s[zn2] = -1;
            if (this.f7823i9 > 0) {
                this.f7819c5[zn2] = this.f7820f;
                this.f7820f = zn2;
            } else {
                this.f7819c5[zn2] = -1;
            }
        }
        int i5 = this.f7819c5[zn2];
        if (i5 != -1) {
            this.f7825s[i5] = zn2;
        }
        y(c5Var, zn2);
    }

    @Override // f3.n3.y
    public float s(n3 n3Var, boolean z2) {
        float tl2 = tl(n3Var.y);
        t(n3Var.y, z2);
        i9 i9Var = (i9) n3Var.f7833v;
        int gv2 = i9Var.gv();
        int i = 0;
        int i5 = 0;
        while (i < gv2) {
            int i6 = i9Var.f7818a[i5];
            if (i6 != -1) {
                i9(this.f7827tl.f7854gv[i6], i9Var.f7821fb[i5] * tl2, z2);
                i++;
            }
            i5++;
        }
        return tl2;
    }

    @Override // f3.n3.y
    public float t(c5 c5Var, boolean z2) {
        int w4 = w(c5Var);
        if (w4 == -1) {
            return 0.0f;
        }
        mt(c5Var);
        float f4 = this.f7821fb[w4];
        if (this.f7820f == w4) {
            this.f7820f = this.f7819c5[w4];
        }
        this.f7818a[w4] = -1;
        int[] iArr = this.f7825s;
        int i = iArr[w4];
        if (i != -1) {
            int[] iArr2 = this.f7819c5;
            iArr2[i] = iArr2[w4];
        }
        int i5 = this.f7819c5[w4];
        if (i5 != -1) {
            iArr[i5] = iArr[w4];
        }
        this.f7823i9--;
        c5Var.f7780tl--;
        if (z2) {
            c5Var.zn(this.f7826t);
        }
        return f4;
    }

    @Override // f3.n3.y
    public float tl(c5 c5Var) {
        int w4 = w(c5Var);
        if (w4 != -1) {
            return this.f7821fb[w4];
        }
        return 0.0f;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i = this.f7823i9;
        for (int i5 = 0; i5 < i; i5++) {
            c5 v2 = v(i5);
            if (v2 != null) {
                String str4 = str3 + v2 + " = " + c5(i5) + " ";
                int w4 = w(v2);
                String str5 = str4 + "[p: ";
                if (this.f7825s[w4] != -1) {
                    str = str5 + this.f7827tl.f7854gv[this.f7818a[this.f7825s[w4]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f7819c5[w4] != -1) {
                    str2 = str6 + this.f7827tl.f7854gv[this.f7818a[this.f7819c5[w4]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    @Override // f3.n3.y
    public c5 v(int i) {
        int i5 = this.f7823i9;
        if (i5 == 0) {
            return null;
        }
        int i6 = this.f7820f;
        for (int i8 = 0; i8 < i5; i8++) {
            if (i8 == i && i6 != -1) {
                return this.f7827tl.f7854gv[this.f7818a[i6]];
            }
            i6 = this.f7819c5[i6];
            if (i6 == -1) {
                break;
            }
        }
        return null;
    }

    public int w(c5 c5Var) {
        if (this.f7823i9 != 0 && c5Var != null) {
            int i = c5Var.f7785zn;
            int i5 = this.f7822gv[i % this.f7829zn];
            if (i5 == -1) {
                return -1;
            }
            if (this.f7818a[i5] == i) {
                return i5;
            }
            do {
                i5 = this.f7828v[i5];
                if (i5 == -1) {
                    break;
                }
            } while (this.f7818a[i5] != i);
            if (i5 != -1 && this.f7818a[i5] == i) {
                return i5;
            }
        }
        return -1;
    }

    @Override // f3.n3.y
    public void wz(float f4) {
        int i = this.f7823i9;
        int i5 = this.f7820f;
        for (int i6 = 0; i6 < i; i6++) {
            float[] fArr = this.f7821fb;
            fArr[i5] = fArr[i5] / f4;
            i5 = this.f7819c5[i5];
            if (i5 == -1) {
                return;
            }
        }
    }

    public final void xc() {
        int i = this.f7824n3 * 2;
        this.f7818a = Arrays.copyOf(this.f7818a, i);
        this.f7821fb = Arrays.copyOf(this.f7821fb, i);
        this.f7825s = Arrays.copyOf(this.f7825s, i);
        this.f7819c5 = Arrays.copyOf(this.f7819c5, i);
        this.f7828v = Arrays.copyOf(this.f7828v, i);
        for (int i5 = this.f7824n3; i5 < i; i5++) {
            this.f7818a[i5] = -1;
            this.f7828v[i5] = -1;
        }
        this.f7824n3 = i;
    }

    public final void y(c5 c5Var, int i) {
        int[] iArr;
        int i5 = c5Var.f7785zn % this.f7829zn;
        int[] iArr2 = this.f7822gv;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            iArr2[i5] = i;
        } else {
            while (true) {
                iArr = this.f7828v;
                int i8 = iArr[i6];
                if (i8 == -1) {
                    break;
                }
                i6 = i8;
            }
            iArr[i6] = i;
        }
        this.f7828v[i] = -1;
    }

    public final int zn() {
        for (int i = 0; i < this.f7824n3; i++) {
            if (this.f7818a[i] == -1) {
                return i;
            }
        }
        return -1;
    }
}
