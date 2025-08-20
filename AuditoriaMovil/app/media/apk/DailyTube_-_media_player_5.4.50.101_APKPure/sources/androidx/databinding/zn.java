package androidx.databinding;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class zn<C, T, A> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public final y<C, T, A> f2471f;

    /* renamed from: fb  reason: collision with root package name */
    public long[] f2472fb;

    /* renamed from: s  reason: collision with root package name */
    public int f2473s;
    public List<C> y = new ArrayList();

    /* renamed from: v  reason: collision with root package name */
    public long f2474v = 0;

    /* loaded from: classes.dex */
    public static abstract class y<C, T, A> {
        public abstract void y(C c2, T t2, int i, A a2);
    }

    public zn(y<C, T, A> yVar) {
        this.f2471f = yVar;
    }

    public synchronized void a(T t2, int i, A a2) {
        try {
            this.f2473s++;
            c5(t2, i, a2);
            int i5 = this.f2473s - 1;
            this.f2473s = i5;
            if (i5 == 0) {
                long[] jArr = this.f2472fb;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j2 = this.f2472fb[length];
                        if (j2 != 0) {
                            t((length + 1) * 64, j2);
                            this.f2472fb[length] = 0;
                        }
                    }
                }
                long j4 = this.f2474v;
                if (j4 != 0) {
                    t(0, j4);
                    this.f2474v = 0L;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c5(T t2, int i, A a2) {
        int length;
        int size = this.y.size();
        long[] jArr = this.f2472fb;
        if (jArr == null) {
            length = -1;
        } else {
            length = jArr.length - 1;
        }
        i9(t2, i, a2, length);
        fb(t2, i, a2, (length + 2) * 64, size, 0L);
    }

    public synchronized void f(C c2) {
        try {
            if (this.f2473s == 0) {
                this.y.remove(c2);
            } else {
                int lastIndexOf = this.y.lastIndexOf(c2);
                if (lastIndexOf >= 0) {
                    tl(lastIndexOf);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void fb(T t2, int i, A a2, int i5, int i6, long j2) {
        long j4 = 1;
        while (i5 < i6) {
            if ((j2 & j4) == 0) {
                this.f2471f.y(this.y.get(i5), t2, i, a2);
            }
            j4 <<= 1;
            i5++;
        }
    }

    public final boolean gv(int i) {
        int i5;
        if (i < 64) {
            if (((1 << i) & this.f2474v) != 0) {
                return true;
            }
            return false;
        }
        long[] jArr = this.f2472fb;
        if (jArr == null || (i5 = (i / 64) - 1) >= jArr.length) {
            return false;
        }
        if (((1 << (i % 64)) & jArr[i5]) != 0) {
            return true;
        }
        return false;
    }

    public final void i9(T t2, int i, A a2, int i5) {
        if (i5 < 0) {
            s(t2, i, a2);
            return;
        }
        long j2 = this.f2472fb[i5];
        int i6 = (i5 + 1) * 64;
        int min = Math.min(this.y.size(), i6 + 64);
        i9(t2, i, a2, i5 - 1);
        fb(t2, i, a2, i6, min, j2);
    }

    public synchronized void n3(C c2) {
        try {
            if (c2 != null) {
                int lastIndexOf = this.y.lastIndexOf(c2);
                if (lastIndexOf >= 0) {
                    if (gv(lastIndexOf)) {
                    }
                }
                this.y.add(c2);
            } else {
                throw new IllegalArgumentException("callback cannot be null");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void s(T t2, int i, A a2) {
        fb(t2, i, a2, 0, Math.min(64, this.y.size()), this.f2474v);
    }

    public final void t(int i, long j2) {
        long j4 = Long.MIN_VALUE;
        for (int i5 = i + 63; i5 >= i; i5--) {
            if ((j2 & j4) != 0) {
                this.y.remove(i5);
            }
            j4 >>>= 1;
        }
    }

    public final void tl(int i) {
        if (i < 64) {
            this.f2474v = (1 << i) | this.f2474v;
            return;
        }
        int i5 = (i / 64) - 1;
        long[] jArr = this.f2472fb;
        if (jArr == null) {
            this.f2472fb = new long[this.y.size() / 64];
        } else if (jArr.length <= i5) {
            long[] jArr2 = new long[this.y.size() / 64];
            long[] jArr3 = this.f2472fb;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f2472fb = jArr2;
        }
        long j2 = 1 << (i % 64);
        long[] jArr4 = this.f2472fb;
        jArr4[i5] = j2 | jArr4[i5];
    }

    /* renamed from: zn */
    public synchronized zn<C, T, A> clone() {
        zn<C, T, A> znVar;
        CloneNotSupportedException e2;
        try {
            znVar = (zn) super.clone();
        } catch (CloneNotSupportedException e3) {
            znVar = null;
            e2 = e3;
        }
        try {
            znVar.f2474v = 0L;
            znVar.f2472fb = null;
            znVar.f2473s = 0;
            znVar.y = new ArrayList();
            int size = this.y.size();
            for (int i = 0; i < size; i++) {
                if (!gv(i)) {
                    znVar.y.add(this.y.get(i));
                }
            }
        } catch (CloneNotSupportedException e5) {
            e2 = e5;
            e2.printStackTrace();
            return znVar;
        }
        return znVar;
    }
}
