package a7;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public abstract class tl implements v, fb {
    public final n3 y = new n3();

    /* loaded from: classes.dex */
    public static class n3 {
        public final List<fb> y;

        public n3() {
            this.y = new ArrayList();
        }

        public void a(v vVar, int i, int i5) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                this.y.get(size).wz(vVar, i, i5);
            }
        }

        public void c5(fb fbVar) {
            synchronized (this.y) {
                this.y.remove(this.y.indexOf(fbVar));
            }
        }

        public void fb(v vVar, int i, int i5) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                this.y.get(size).f(vVar, i, i5);
            }
        }

        public void gv(v vVar, int i, int i5) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                this.y.get(size).s(vVar, i, i5);
            }
        }

        public void n3(v vVar, int i) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                this.y.get(size).a(vVar, i);
            }
        }

        public void s(fb fbVar) {
            synchronized (this.y) {
                try {
                    if (!this.y.contains(fbVar)) {
                        this.y.add(fbVar);
                    } else {
                        throw new IllegalStateException("Observer " + fbVar + " is already registered.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void v(v vVar, int i, int i5, Object obj) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                this.y.get(size).i9(vVar, i, i5, obj);
            }
        }

        public void y() {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                this.y.get(size).c5();
            }
        }

        public void zn(v vVar, int i, Object obj) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                this.y.get(size).xc(vVar, i, obj);
            }
        }
    }

    @Override // a7.fb
    public void a(@NonNull v vVar, int i) {
        this.y.n3(this, c(vVar) + i);
    }

    public void a8(@NonNull v vVar) {
        vVar.co(this);
    }

    public void b(@NonNull Collection<? extends v> collection) {
        for (int i42 = i4() - 1; i42 >= 0; i42--) {
            z(i42).co(this);
        }
        for (v vVar : collection) {
            vVar.n3(this);
        }
    }

    public int c(@NonNull v vVar) {
        return f3(d0(vVar));
    }

    @Override // a7.fb
    public void c5() {
        this.y.y();
    }

    @Override // a7.v
    public void co(@NonNull fb fbVar) {
        this.y.c5(fbVar);
    }

    public void d(int i, int i5, Object obj) {
        this.y.v(this, i, i5, obj);
    }

    public abstract int d0(@NonNull v vVar);

    @Override // a7.v
    public final int ej(@NonNull t tVar) {
        int i = 0;
        for (int i5 = 0; i5 < i4(); i5++) {
            v z2 = z(i5);
            int ej2 = z2.ej(tVar);
            if (ej2 >= 0) {
                return ej2 + i;
            }
            i += z2.r();
        }
        return -1;
    }

    @Override // a7.fb
    public void f(@NonNull v vVar, int i, int i5) {
        this.y.fb(this, c(vVar) + i, i5);
    }

    public int f3(int i) {
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            i5 += z(i6).r();
        }
        return i5;
    }

    public void fh() {
        this.y.y();
    }

    @Override // a7.v
    @NonNull
    public t getItem(int i) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4()) {
            v z2 = z(i5);
            int r2 = z2.r() + i6;
            if (r2 > i) {
                return z2.getItem(i - i6);
            }
            i5++;
            i6 = r2;
        }
        throw new IndexOutOfBoundsException("Wanted item at " + i + " but there are only " + r() + " items");
    }

    public abstract int i4();

    @Override // a7.fb
    public void i9(@NonNull v vVar, int i, int i5, Object obj) {
        this.y.v(this, c(vVar) + i, i5, obj);
    }

    public void mt(@NonNull Collection<? extends v> collection) {
        for (v vVar : collection) {
            vVar.n3(this);
        }
    }

    @Override // a7.v
    public final void n3(@NonNull fb fbVar) {
        this.y.s(fbVar);
    }

    public void p(@NonNull v vVar) {
        vVar.n3(this);
    }

    @Override // a7.v
    public int r() {
        int i = 0;
        for (int i5 = 0; i5 < i4(); i5++) {
            i += z(i5).r();
        }
        return i;
    }

    public void rz(int i, int i5) {
        this.y.gv(this, i, i5);
    }

    @Override // a7.fb
    public void s(@NonNull v vVar, int i, int i5) {
        int c2 = c(vVar);
        this.y.gv(this, i + c2, c2 + i5);
    }

    public void ud(int i, int i5) {
        this.y.fb(this, i, i5);
    }

    @Override // a7.fb
    public void wz(@NonNull v vVar, int i, int i5) {
        this.y.a(this, c(vVar) + i, i5);
    }

    public void x(@NonNull Collection<? extends v> collection) {
        for (v vVar : collection) {
            vVar.co(this);
        }
    }

    @Override // a7.fb
    public void xc(@NonNull v vVar, int i, Object obj) {
        this.y.zn(this, c(vVar) + i, obj);
    }

    @NonNull
    public abstract v z(int i);

    public void z6(int i, int i5) {
        this.y.a(this, i, i5);
    }
}
