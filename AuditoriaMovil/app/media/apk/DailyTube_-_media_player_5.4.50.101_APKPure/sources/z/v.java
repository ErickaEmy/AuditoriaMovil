package z;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class v<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f15544f = new Object();

    /* renamed from: fb  reason: collision with root package name */
    public Object[] f15545fb;

    /* renamed from: s  reason: collision with root package name */
    public int f15546s;

    /* renamed from: v  reason: collision with root package name */
    public long[] f15547v;
    public boolean y;

    public v() {
        this(10);
    }

    public boolean a(long j2) {
        if (i9(j2) >= 0) {
            return true;
        }
        return false;
    }

    public E c5(long j2, E e2) {
        E e3;
        int n32 = gv.n3(this.f15547v, this.f15546s, j2);
        if (n32 >= 0 && (e3 = (E) this.f15545fb[n32]) != f15544f) {
            return e3;
        }
        return e2;
    }

    public boolean f() {
        if (w() == 0) {
            return true;
        }
        return false;
    }

    public final void fb() {
        int i = this.f15546s;
        long[] jArr = this.f15547v;
        Object[] objArr = this.f15545fb;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = objArr[i6];
            if (obj != f15544f) {
                if (i6 != i5) {
                    jArr[i5] = jArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.y = false;
        this.f15546s = i5;
    }

    /* renamed from: gv */
    public v<E> clone() {
        try {
            v<E> vVar = (v) super.clone();
            vVar.f15547v = (long[]) this.f15547v.clone();
            vVar.f15545fb = (Object[]) this.f15545fb.clone();
            return vVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public int i9(long j2) {
        if (this.y) {
            fb();
        }
        return gv.n3(this.f15547v, this.f15546s, j2);
    }

    public void n3(long j2, E e2) {
        int i = this.f15546s;
        if (i != 0 && j2 <= this.f15547v[i - 1]) {
            tl(j2, e2);
            return;
        }
        if (this.y && i >= this.f15547v.length) {
            fb();
        }
        int i5 = this.f15546s;
        if (i5 >= this.f15547v.length) {
            int a2 = gv.a(i5 + 1);
            long[] jArr = new long[a2];
            Object[] objArr = new Object[a2];
            long[] jArr2 = this.f15547v;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f15545fb;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f15547v = jArr;
            this.f15545fb = objArr;
        }
        this.f15547v[i5] = j2;
        this.f15545fb[i5] = e2;
        this.f15546s = i5 + 1;
    }

    public E p(int i) {
        if (this.y) {
            fb();
        }
        return (E) this.f15545fb[i];
    }

    @Nullable
    public E s(long j2) {
        return c5(j2, null);
    }

    public long t(int i) {
        if (this.y) {
            fb();
        }
        return this.f15547v[i];
    }

    public void tl(long j2, E e2) {
        int n32 = gv.n3(this.f15547v, this.f15546s, j2);
        if (n32 >= 0) {
            this.f15545fb[n32] = e2;
            return;
        }
        int i = ~n32;
        int i5 = this.f15546s;
        if (i < i5) {
            Object[] objArr = this.f15545fb;
            if (objArr[i] == f15544f) {
                this.f15547v[i] = j2;
                objArr[i] = e2;
                return;
            }
        }
        if (this.y && i5 >= this.f15547v.length) {
            fb();
            i = ~gv.n3(this.f15547v, this.f15546s, j2);
        }
        int i6 = this.f15546s;
        if (i6 >= this.f15547v.length) {
            int a2 = gv.a(i6 + 1);
            long[] jArr = new long[a2];
            Object[] objArr2 = new Object[a2];
            long[] jArr2 = this.f15547v;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f15545fb;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15547v = jArr;
            this.f15545fb = objArr2;
        }
        int i8 = this.f15546s;
        if (i8 - i != 0) {
            long[] jArr3 = this.f15547v;
            int i10 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i10, i8 - i);
            Object[] objArr4 = this.f15545fb;
            System.arraycopy(objArr4, i, objArr4, i10, this.f15546s - i);
        }
        this.f15547v[i] = j2;
        this.f15545fb[i] = e2;
        this.f15546s++;
    }

    public String toString() {
        if (w() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15546s * 28);
        sb.append('{');
        for (int i = 0; i < this.f15546s; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(t(i));
            sb.append('=');
            E p2 = p(i);
            if (p2 != this) {
                sb.append(p2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public int w() {
        if (this.y) {
            fb();
        }
        return this.f15546s;
    }

    public void wz(long j2) {
        int n32 = gv.n3(this.f15547v, this.f15546s, j2);
        if (n32 >= 0) {
            Object[] objArr = this.f15545fb;
            Object obj = objArr[n32];
            Object obj2 = f15544f;
            if (obj != obj2) {
                objArr[n32] = obj2;
                this.y = true;
            }
        }
    }

    public void xc(int i) {
        Object[] objArr = this.f15545fb;
        Object obj = objArr[i];
        Object obj2 = f15544f;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.y = true;
        }
    }

    public void zn() {
        int i = this.f15546s;
        Object[] objArr = this.f15545fb;
        for (int i5 = 0; i5 < i; i5++) {
            objArr[i5] = null;
        }
        this.f15546s = 0;
        this.y = false;
    }

    public v(int i) {
        if (i == 0) {
            this.f15547v = gv.f15526n3;
            this.f15545fb = gv.f15527zn;
            return;
        }
        int a2 = gv.a(i);
        this.f15547v = new long[a2];
        this.f15545fb = new Object[a2];
    }
}
