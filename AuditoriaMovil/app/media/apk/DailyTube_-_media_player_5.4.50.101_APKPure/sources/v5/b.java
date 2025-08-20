package v5;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b<V> {

    /* renamed from: gv  reason: collision with root package name */
    public int f14304gv;

    /* renamed from: n3  reason: collision with root package name */
    public V[] f14305n3;
    public long[] y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14306zn;

    public b() {
        this(10);
    }

    public static <V> V[] a(int i) {
        return (V[]) new Object[i];
    }

    @Nullable
    public synchronized V c5() {
        V f4;
        if (this.f14304gv == 0) {
            f4 = null;
        } else {
            f4 = f();
        }
        return f4;
    }

    @Nullable
    public final V f() {
        boolean z2;
        if (this.f14304gv > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        y.fb(z2);
        V[] vArr = this.f14305n3;
        int i = this.f14306zn;
        V v2 = vArr[i];
        vArr[i] = null;
        this.f14306zn = (i + 1) % vArr.length;
        this.f14304gv--;
        return v2;
    }

    @Nullable
    public synchronized V fb(long j2) {
        return s(j2, false);
    }

    public final void gv(long j2) {
        int i = this.f14304gv;
        if (i > 0) {
            if (j2 <= this.y[((this.f14306zn + i) - 1) % this.f14305n3.length]) {
                zn();
            }
        }
    }

    @Nullable
    public synchronized V i9(long j2) {
        return s(j2, true);
    }

    public final void n3(long j2, V v2) {
        int i = this.f14306zn;
        int i5 = this.f14304gv;
        V[] vArr = this.f14305n3;
        int length = (i + i5) % vArr.length;
        this.y[length] = j2;
        vArr[length] = v2;
        this.f14304gv = i5 + 1;
    }

    @Nullable
    public final V s(long j2, boolean z2) {
        V v2 = null;
        long j4 = Long.MAX_VALUE;
        while (this.f14304gv > 0) {
            long j6 = j2 - this.y[this.f14306zn];
            if (j6 < 0 && (z2 || (-j6) >= j4)) {
                break;
            }
            v2 = f();
            j4 = j6;
        }
        return v2;
    }

    public synchronized int t() {
        return this.f14304gv;
    }

    public final void v() {
        int length = this.f14305n3.length;
        if (this.f14304gv < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        V[] vArr = (V[]) a(i);
        int i5 = this.f14306zn;
        int i6 = length - i5;
        System.arraycopy(this.y, i5, jArr, 0, i6);
        System.arraycopy(this.f14305n3, this.f14306zn, vArr, 0, i6);
        int i8 = this.f14306zn;
        if (i8 > 0) {
            System.arraycopy(this.y, 0, jArr, i6, i8);
            System.arraycopy(this.f14305n3, 0, vArr, i6, this.f14306zn);
        }
        this.y = jArr;
        this.f14305n3 = vArr;
        this.f14306zn = 0;
    }

    public synchronized void y(long j2, V v2) {
        gv(j2);
        v();
        n3(j2, v2);
    }

    public synchronized void zn() {
        this.f14306zn = 0;
        this.f14304gv = 0;
        Arrays.fill(this.f14305n3, (Object) null);
    }

    public b(int i) {
        this.y = new long[i];
        this.f14305n3 = (V[]) a(i);
    }
}
