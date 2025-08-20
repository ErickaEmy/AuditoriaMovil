package f3;

import java.util.Arrays;
/* loaded from: classes.dex */
public class c5 {

    /* renamed from: p  reason: collision with root package name */
    public static int f7770p = 1;

    /* renamed from: a  reason: collision with root package name */
    public float f7771a;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f7774fb;

    /* renamed from: i9  reason: collision with root package name */
    public y f7776i9;

    /* renamed from: n3  reason: collision with root package name */
    public String f7777n3;

    /* renamed from: t  reason: collision with root package name */
    public int f7779t;

    /* renamed from: tl  reason: collision with root package name */
    public int f7780tl;

    /* renamed from: v  reason: collision with root package name */
    public int f7781v;

    /* renamed from: w  reason: collision with root package name */
    public float f7782w;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f7783wz;
    public boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public int f7785zn = -1;

    /* renamed from: gv  reason: collision with root package name */
    public int f7775gv = -1;

    /* renamed from: s  reason: collision with root package name */
    public float[] f7778s = new float[9];

    /* renamed from: c5  reason: collision with root package name */
    public float[] f7772c5 = new float[9];

    /* renamed from: f  reason: collision with root package name */
    public n3[] f7773f = new n3[16];

    /* renamed from: xc  reason: collision with root package name */
    public int f7784xc = -1;

    /* loaded from: classes.dex */
    public enum y {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public c5(y yVar, String str) {
        this.f7776i9 = yVar;
    }

    public static void n3() {
        f7770p++;
    }

    public void a(y yVar, String str) {
        this.f7776i9 = yVar;
    }

    public final void fb(gv gvVar, n3 n3Var) {
        int i = this.f7779t;
        for (int i5 = 0; i5 < i; i5++) {
            this.f7773f[i5].fh(gvVar, n3Var, false);
        }
        this.f7779t = 0;
    }

    public void gv() {
        this.f7777n3 = null;
        this.f7776i9 = y.UNKNOWN;
        this.f7781v = 0;
        this.f7785zn = -1;
        this.f7775gv = -1;
        this.f7771a = 0.0f;
        this.f7774fb = false;
        this.f7783wz = false;
        this.f7784xc = -1;
        this.f7782w = 0.0f;
        int i = this.f7779t;
        for (int i5 = 0; i5 < i; i5++) {
            this.f7773f[i5] = null;
        }
        this.f7779t = 0;
        this.f7780tl = 0;
        this.y = false;
        Arrays.fill(this.f7772c5, 0.0f);
    }

    public String toString() {
        if (this.f7777n3 != null) {
            return "" + this.f7777n3;
        }
        return "" + this.f7785zn;
    }

    public void v(gv gvVar, float f4) {
        this.f7771a = f4;
        this.f7774fb = true;
        this.f7783wz = false;
        this.f7784xc = -1;
        this.f7782w = 0.0f;
        int i = this.f7779t;
        this.f7775gv = -1;
        for (int i5 = 0; i5 < i; i5++) {
            this.f7773f[i5].d0(gvVar, this, false);
        }
        this.f7779t = 0;
    }

    public final void y(n3 n3Var) {
        int i = 0;
        while (true) {
            int i5 = this.f7779t;
            if (i < i5) {
                if (this.f7773f[i] == n3Var) {
                    return;
                }
                i++;
            } else {
                n3[] n3VarArr = this.f7773f;
                if (i5 >= n3VarArr.length) {
                    this.f7773f = (n3[]) Arrays.copyOf(n3VarArr, n3VarArr.length * 2);
                }
                n3[] n3VarArr2 = this.f7773f;
                int i6 = this.f7779t;
                n3VarArr2[i6] = n3Var;
                this.f7779t = i6 + 1;
                return;
            }
        }
    }

    public final void zn(n3 n3Var) {
        int i = this.f7779t;
        int i5 = 0;
        while (i5 < i) {
            if (this.f7773f[i5] == n3Var) {
                while (i5 < i - 1) {
                    n3[] n3VarArr = this.f7773f;
                    int i6 = i5 + 1;
                    n3VarArr[i5] = n3VarArr[i6];
                    i5 = i6;
                }
                this.f7779t--;
                return;
            }
            i5++;
        }
    }
}
