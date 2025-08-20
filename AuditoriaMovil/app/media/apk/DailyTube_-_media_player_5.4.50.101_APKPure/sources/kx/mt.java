package kx;

import androidx.annotation.Nullable;
import java.util.Arrays;
import kx.n3;
/* loaded from: classes.dex */
public final class mt implements n3 {

    /* renamed from: a  reason: collision with root package name */
    public int f10062a;

    /* renamed from: fb  reason: collision with root package name */
    public y[] f10063fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f10064gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f10065n3;

    /* renamed from: v  reason: collision with root package name */
    public int f10066v;
    public final boolean y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final byte[] f10067zn;

    public mt(boolean z2, int i) {
        this(z2, i, 0);
    }

    public synchronized int a() {
        return this.f10066v * this.f10065n3;
    }

    public synchronized void fb() {
        if (this.y) {
            s(0);
        }
    }

    @Override // kx.n3
    public synchronized void gv() {
        try {
            int i = 0;
            int max = Math.max(0, v5.j5.t(this.f10064gv, this.f10065n3) - this.f10066v);
            int i5 = this.f10062a;
            if (max >= i5) {
                return;
            }
            if (this.f10067zn != null) {
                int i6 = i5 - 1;
                while (i <= i6) {
                    y yVar = (y) v5.y.v(this.f10063fb[i]);
                    if (yVar.y == this.f10067zn) {
                        i++;
                    } else {
                        y yVar2 = (y) v5.y.v(this.f10063fb[i6]);
                        if (yVar2.y != this.f10067zn) {
                            i6--;
                        } else {
                            y[] yVarArr = this.f10063fb;
                            yVarArr[i] = yVar2;
                            yVarArr[i6] = yVar;
                            i6--;
                            i++;
                        }
                    }
                }
                max = Math.max(max, i);
                if (max >= this.f10062a) {
                    return;
                }
            }
            Arrays.fill(this.f10063fb, max, this.f10062a, (Object) null);
            this.f10062a = max;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // kx.n3
    public synchronized y n3() {
        y yVar;
        try {
            this.f10066v++;
            int i = this.f10062a;
            if (i > 0) {
                y[] yVarArr = this.f10063fb;
                int i5 = i - 1;
                this.f10062a = i5;
                yVar = (y) v5.y.v(yVarArr[i5]);
                this.f10063fb[this.f10062a] = null;
            } else {
                yVar = new y(new byte[this.f10065n3], 0);
                int i6 = this.f10066v;
                y[] yVarArr2 = this.f10063fb;
                if (i6 > yVarArr2.length) {
                    this.f10063fb = (y[]) Arrays.copyOf(yVarArr2, yVarArr2.length * 2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return yVar;
    }

    public synchronized void s(int i) {
        boolean z2;
        if (i < this.f10064gv) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f10064gv = i;
        if (z2) {
            gv();
        }
    }

    @Override // kx.n3
    public int v() {
        return this.f10065n3;
    }

    @Override // kx.n3
    public synchronized void y(@Nullable n3.y yVar) {
        while (yVar != null) {
            try {
                y[] yVarArr = this.f10063fb;
                int i = this.f10062a;
                this.f10062a = i + 1;
                yVarArr[i] = yVar.y();
                this.f10066v--;
                yVar = yVar.next();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    @Override // kx.n3
    public synchronized void zn(y yVar) {
        y[] yVarArr = this.f10063fb;
        int i = this.f10062a;
        this.f10062a = i + 1;
        yVarArr[i] = yVar;
        this.f10066v--;
        notifyAll();
    }

    public mt(boolean z2, int i, int i5) {
        v5.y.y(i > 0);
        v5.y.y(i5 >= 0);
        this.y = z2;
        this.f10065n3 = i;
        this.f10062a = i5;
        this.f10063fb = new y[i5 + 100];
        if (i5 > 0) {
            this.f10067zn = new byte[i5 * i];
            for (int i6 = 0; i6 < i5; i6++) {
                this.f10063fb[i6] = new y(this.f10067zn, i6 * i);
            }
            return;
        }
        this.f10067zn = null;
    }
}
