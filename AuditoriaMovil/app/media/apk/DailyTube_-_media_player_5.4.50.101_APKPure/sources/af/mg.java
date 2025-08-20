package af;

import android.os.Handler;
import androidx.annotation.Nullable;
import fj.u0;
import java.io.IOException;
import m1.hy;
import m1.o0;
/* loaded from: classes.dex */
public interface mg {

    /* loaded from: classes.dex */
    public static final class n3 extends fh {
        public n3(Object obj) {
            super(obj);
        }

        public n3 zn(Object obj) {
            return new n3(super.y(obj));
        }

        public n3(Object obj, long j2) {
            super(obj, j2);
        }

        public n3(Object obj, long j2, int i) {
            super(obj, j2, i);
        }

        public n3(Object obj, int i, int i5, long j2) {
            super(obj, i, i5, j2);
        }

        public n3(fh fhVar) {
            super(fhVar);
        }
    }

    /* loaded from: classes.dex */
    public interface y {
        mg n3(o0 o0Var);

        y y(kx.mg mgVar);

        y zn(f8.r rVar);
    }

    /* loaded from: classes.dex */
    public interface zn {
        void y(mg mgVar, hy hyVar);
    }

    o0 c();

    d0 f7(n3 n3Var, kx.n3 n3Var2, long j2);

    void hw(zn znVar);

    void j(com.google.android.exoplayer2.drm.v vVar);

    void jz(b bVar);

    @Nullable
    hy k();

    void mt(zn znVar, @Nullable kx.o oVar, u0 u0Var);

    void o(Handler handler, com.google.android.exoplayer2.drm.v vVar);

    boolean q9();

    void u(d0 d0Var);

    void ut() throws IOException;

    void vl(zn znVar);

    void y5(Handler handler, b bVar);

    void z6(zn znVar);
}
