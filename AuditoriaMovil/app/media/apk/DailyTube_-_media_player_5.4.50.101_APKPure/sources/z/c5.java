package z;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class c5<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f15513f = new Object();

    /* renamed from: fb  reason: collision with root package name */
    public Object[] f15514fb;

    /* renamed from: s  reason: collision with root package name */
    public int f15515s;

    /* renamed from: v  reason: collision with root package name */
    public int[] f15516v;
    public boolean y;

    public c5() {
        this(10);
    }

    public final void a() {
        int i = this.f15515s;
        int[] iArr = this.f15516v;
        Object[] objArr = this.f15514fb;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = objArr[i6];
            if (obj != f15513f) {
                if (i6 != i5) {
                    iArr[i5] = iArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.y = false;
        this.f15515s = i5;
    }

    public int c5(E e2) {
        if (this.y) {
            a();
        }
        for (int i = 0; i < this.f15515s; i++) {
            if (this.f15514fb[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public void f(int i, E e2) {
        int y = gv.y(this.f15516v, this.f15515s, i);
        if (y >= 0) {
            this.f15514fb[y] = e2;
            return;
        }
        int i5 = ~y;
        int i6 = this.f15515s;
        if (i5 < i6) {
            Object[] objArr = this.f15514fb;
            if (objArr[i5] == f15513f) {
                this.f15516v[i5] = i;
                objArr[i5] = e2;
                return;
            }
        }
        if (this.y && i6 >= this.f15516v.length) {
            a();
            i5 = ~gv.y(this.f15516v, this.f15515s, i);
        }
        int i8 = this.f15515s;
        if (i8 >= this.f15516v.length) {
            int v2 = gv.v(i8 + 1);
            int[] iArr = new int[v2];
            Object[] objArr2 = new Object[v2];
            int[] iArr2 = this.f15516v;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f15514fb;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15516v = iArr;
            this.f15514fb = objArr2;
        }
        int i10 = this.f15515s;
        if (i10 - i5 != 0) {
            int[] iArr3 = this.f15516v;
            int i11 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i11, i10 - i5);
            Object[] objArr4 = this.f15514fb;
            System.arraycopy(objArr4, i5, objArr4, i11, this.f15515s - i5);
        }
        this.f15516v[i5] = i;
        this.f15514fb[i5] = e2;
        this.f15515s++;
    }

    @Nullable
    public E fb(int i) {
        return s(i, null);
    }

    /* renamed from: gv */
    public c5<E> clone() {
        try {
            c5<E> c5Var = (c5) super.clone();
            c5Var.f15516v = (int[]) this.f15516v.clone();
            c5Var.f15514fb = (Object[]) this.f15514fb.clone();
            return c5Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public int i9(int i) {
        if (this.y) {
            a();
        }
        return this.f15516v[i];
    }

    public void n3(int i, E e2) {
        int i5 = this.f15515s;
        if (i5 != 0 && i <= this.f15516v[i5 - 1]) {
            f(i, e2);
            return;
        }
        if (this.y && i5 >= this.f15516v.length) {
            a();
        }
        int i6 = this.f15515s;
        if (i6 >= this.f15516v.length) {
            int v2 = gv.v(i6 + 1);
            int[] iArr = new int[v2];
            Object[] objArr = new Object[v2];
            int[] iArr2 = this.f15516v;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f15514fb;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f15516v = iArr;
            this.f15514fb = objArr;
        }
        this.f15516v[i6] = i;
        this.f15514fb[i6] = e2;
        this.f15515s = i6 + 1;
    }

    public E s(int i, E e2) {
        E e3;
        int y = gv.y(this.f15516v, this.f15515s, i);
        if (y >= 0 && (e3 = (E) this.f15514fb[y]) != f15513f) {
            return e3;
        }
        return e2;
    }

    public void t(int i) {
        Object[] objArr = this.f15514fb;
        Object obj = objArr[i];
        Object obj2 = f15513f;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.y = true;
        }
    }

    public int tl() {
        if (this.y) {
            a();
        }
        return this.f15515s;
    }

    public String toString() {
        if (tl() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15515s * 28);
        sb.append('{');
        for (int i = 0; i < this.f15515s; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(i9(i));
            sb.append('=');
            E wz2 = wz(i);
            if (wz2 != this) {
                sb.append(wz2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E wz(int i) {
        if (this.y) {
            a();
        }
        return (E) this.f15514fb[i];
    }

    public void zn() {
        int i = this.f15515s;
        Object[] objArr = this.f15514fb;
        for (int i5 = 0; i5 < i; i5++) {
            objArr[i5] = null;
        }
        this.f15515s = 0;
        this.y = false;
    }

    public c5(int i) {
        if (i == 0) {
            this.f15516v = gv.y;
            this.f15514fb = gv.f15527zn;
            return;
        }
        int v2 = gv.v(i);
        this.f15516v = new int[v2];
        this.f15514fb = new Object[v2];
    }
}
