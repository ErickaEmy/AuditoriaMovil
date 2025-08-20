package f3;

import androidx.core.app.NotificationCompat;
import f3.n3;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes.dex */
public class s extends f3.n3 {

    /* renamed from: c5  reason: collision with root package name */
    public c5[] f7835c5;

    /* renamed from: f  reason: collision with root package name */
    public n3 f7836f;

    /* renamed from: fb  reason: collision with root package name */
    public int f7837fb;

    /* renamed from: i9  reason: collision with root package name */
    public int f7838i9;

    /* renamed from: s  reason: collision with root package name */
    public c5[] f7839s;

    /* renamed from: t  reason: collision with root package name */
    public zn f7840t;

    /* loaded from: classes.dex */
    public class n3 implements Comparable {

        /* renamed from: v  reason: collision with root package name */
        public s f7842v;
        public c5 y;

        public n3(s sVar) {
            this.f7842v = sVar;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.y.f7785zn - ((c5) obj).f7785zn;
        }

        public final boolean gv(c5 c5Var) {
            int i = 8;
            while (true) {
                if (i < 0) {
                    break;
                }
                float f4 = c5Var.f7772c5[i];
                float f6 = this.y.f7772c5[i];
                if (f6 == f4) {
                    i--;
                } else if (f6 < f4) {
                    return true;
                }
            }
            return false;
        }

        public void n3(c5 c5Var) {
            this.y = c5Var;
        }

        public String toString() {
            String str = "[ ";
            if (this.y != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.y.f7772c5[i] + " ";
                }
            }
            return str + "] " + this.y;
        }

        public void v() {
            Arrays.fill(this.y.f7772c5, 0.0f);
        }

        public boolean y(c5 c5Var, float f4) {
            boolean z2 = true;
            if (this.y.y) {
                for (int i = 0; i < 9; i++) {
                    float[] fArr = this.y.f7772c5;
                    float f6 = fArr[i] + (c5Var.f7772c5[i] * f4);
                    fArr[i] = f6;
                    if (Math.abs(f6) < 1.0E-4f) {
                        this.y.f7772c5[i] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    s.this.z6(this.y);
                }
                return false;
            }
            for (int i5 = 0; i5 < 9; i5++) {
                float f9 = c5Var.f7772c5[i5];
                if (f9 != 0.0f) {
                    float f10 = f9 * f4;
                    if (Math.abs(f10) < 1.0E-4f) {
                        f10 = 0.0f;
                    }
                    this.y.f7772c5[i5] = f10;
                } else {
                    this.y.f7772c5[i5] = 0.0f;
                }
            }
            return true;
        }

        public final boolean zn() {
            for (int i = 8; i >= 0; i--) {
                float f4 = this.y.f7772c5[i];
                if (f4 > 0.0f) {
                    return false;
                }
                if (f4 < 0.0f) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Comparator<c5> {
        public y() {
        }

        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(c5 c5Var, c5 c5Var2) {
            return c5Var.f7785zn - c5Var2.f7785zn;
        }
    }

    public s(zn znVar) {
        super(znVar);
        this.f7837fb = NotificationCompat.FLAG_HIGH_PRIORITY;
        this.f7839s = new c5[NotificationCompat.FLAG_HIGH_PRIORITY];
        this.f7835c5 = new c5[NotificationCompat.FLAG_HIGH_PRIORITY];
        this.f7836f = new n3(this);
        this.f7840t = znVar;
    }

    @Override // f3.n3, f3.gv.y
    public void clear() {
        this.f7838i9 = 0;
        this.f7832n3 = 0.0f;
    }

    public final void d(c5 c5Var) {
        int i;
        int i5 = this.f7838i9 + 1;
        c5[] c5VarArr = this.f7839s;
        if (i5 > c5VarArr.length) {
            c5[] c5VarArr2 = (c5[]) Arrays.copyOf(c5VarArr, c5VarArr.length * 2);
            this.f7839s = c5VarArr2;
            this.f7835c5 = (c5[]) Arrays.copyOf(c5VarArr2, c5VarArr2.length * 2);
        }
        c5[] c5VarArr3 = this.f7839s;
        int i6 = this.f7838i9;
        c5VarArr3[i6] = c5Var;
        int i8 = i6 + 1;
        this.f7838i9 = i8;
        if (i8 > 1 && c5VarArr3[i6].f7785zn > c5Var.f7785zn) {
            int i10 = 0;
            while (true) {
                i = this.f7838i9;
                if (i10 >= i) {
                    break;
                }
                this.f7835c5[i10] = this.f7839s[i10];
                i10++;
            }
            Arrays.sort(this.f7835c5, 0, i, new y());
            for (int i11 = 0; i11 < this.f7838i9; i11++) {
                this.f7839s[i11] = this.f7835c5[i11];
            }
        }
        c5Var.y = true;
        c5Var.y(this);
    }

    @Override // f3.n3
    public void fh(gv gvVar, f3.n3 n3Var, boolean z2) {
        c5 c5Var = n3Var.y;
        if (c5Var == null) {
            return;
        }
        n3.y yVar = n3Var.f7833v;
        int gv2 = yVar.gv();
        for (int i = 0; i < gv2; i++) {
            c5 v2 = yVar.v(i);
            float c52 = yVar.c5(i);
            this.f7836f.n3(v2);
            if (this.f7836f.y(c5Var, c52)) {
                d(v2);
            }
            this.f7832n3 += n3Var.f7832n3 * c52;
        }
        z6(c5Var);
    }

    @Override // f3.n3, f3.gv.y
    public boolean isEmpty() {
        if (this.f7838i9 == 0) {
            return true;
        }
        return false;
    }

    @Override // f3.n3, f3.gv.y
    public void n3(c5 c5Var) {
        this.f7836f.n3(c5Var);
        this.f7836f.v();
        c5Var.f7772c5[c5Var.f7781v] = 1.0f;
        d(c5Var);
    }

    @Override // f3.n3
    public String toString() {
        String str = " goal -> (" + this.f7832n3 + ") : ";
        for (int i = 0; i < this.f7838i9; i++) {
            this.f7836f.n3(this.f7839s[i]);
            str = str + this.f7836f + " ";
        }
        return str;
    }

    public final void z6(c5 c5Var) {
        int i = 0;
        while (i < this.f7838i9) {
            if (this.f7839s[i] == c5Var) {
                while (true) {
                    int i5 = this.f7838i9;
                    if (i < i5 - 1) {
                        c5[] c5VarArr = this.f7839s;
                        int i6 = i + 1;
                        c5VarArr[i] = c5VarArr[i6];
                        i = i6;
                    } else {
                        this.f7838i9 = i5 - 1;
                        c5Var.y = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // f3.n3, f3.gv.y
    public c5 zn(gv gvVar, boolean[] zArr) {
        int i = -1;
        for (int i5 = 0; i5 < this.f7838i9; i5++) {
            c5 c5Var = this.f7839s[i5];
            if (!zArr[c5Var.f7785zn]) {
                this.f7836f.n3(c5Var);
                if (i == -1) {
                    if (!this.f7836f.zn()) {
                    }
                    i = i5;
                } else {
                    if (!this.f7836f.gv(this.f7839s[i])) {
                    }
                    i = i5;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f7839s[i];
    }
}
