package kx;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kx.a;
/* loaded from: classes.dex */
public interface a {

    /* loaded from: classes.dex */
    public interface y {

        /* renamed from: kx.a$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0143y {
            public final CopyOnWriteArrayList<C0144y> y = new CopyOnWriteArrayList<>();

            /* renamed from: kx.a$y$y$y  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0144y {

                /* renamed from: n3  reason: collision with root package name */
                public final y f10013n3;
                public final Handler y;

                /* renamed from: zn  reason: collision with root package name */
                public boolean f10014zn;

                public C0144y(Handler handler, y yVar) {
                    this.y = handler;
                    this.f10013n3 = yVar;
                }

                public void gv() {
                    this.f10014zn = true;
                }
            }

            public static /* synthetic */ void gv(C0144y c0144y, int i, long j2, long j4) {
                c0144y.f10013n3.c(i, j2, j4);
            }

            public void n3(Handler handler, y yVar) {
                v5.y.v(handler);
                v5.y.v(yVar);
                v(yVar);
                this.y.add(new C0144y(handler, yVar));
            }

            public void v(y yVar) {
                Iterator<C0144y> it = this.y.iterator();
                while (it.hasNext()) {
                    C0144y next = it.next();
                    if (next.f10013n3 == yVar) {
                        next.gv();
                        this.y.remove(next);
                    }
                }
            }

            public void zn(final int i, final long j2, final long j4) {
                Iterator<C0144y> it = this.y.iterator();
                while (it.hasNext()) {
                    final C0144y next = it.next();
                    if (!next.f10014zn) {
                        next.y.post(new Runnable() { // from class: kx.v
                            @Override // java.lang.Runnable
                            public final void run() {
                                a.y.C0143y.gv(a.y.C0143y.C0144y.this, i, j2, j4);
                            }
                        });
                    }
                }
            }
        }

        void c(int i, long j2, long j4);
    }

    long a();

    void c5(Handler handler, y yVar);

    long n3();

    void s(y yVar);

    @Nullable
    o zn();
}
