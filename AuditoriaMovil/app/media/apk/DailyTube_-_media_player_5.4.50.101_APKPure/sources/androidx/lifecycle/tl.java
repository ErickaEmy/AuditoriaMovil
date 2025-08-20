package androidx.lifecycle;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.v;
import y5.co;
/* loaded from: classes.dex */
public class tl {

    /* renamed from: n3  reason: collision with root package name */
    public final Handler f2649n3 = new Handler();
    public final fb y;

    /* renamed from: zn  reason: collision with root package name */
    public y f2650zn;

    /* loaded from: classes.dex */
    public static class y implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public boolean f2651fb;

        /* renamed from: v  reason: collision with root package name */
        public final v.n3 f2652v;
        public final fb y;

        public y(@NonNull fb fbVar, v.n3 n3Var) {
            this.y = fbVar;
            this.f2652v = n3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f2651fb) {
                this.y.s(this.f2652v);
                this.f2651fb = true;
            }
        }
    }

    public tl(@NonNull co coVar) {
        this.y = new fb(coVar);
    }

    public final void a(v.n3 n3Var) {
        y yVar = this.f2650zn;
        if (yVar != null) {
            yVar.run();
        }
        y yVar2 = new y(this.y, n3Var);
        this.f2650zn = yVar2;
        this.f2649n3.postAtFrontOfQueue(yVar2);
    }

    public void gv() {
        a(v.n3.ON_STOP);
        a(v.n3.ON_DESTROY);
    }

    public void n3() {
        a(v.n3.ON_START);
    }

    public void v() {
        a(v.n3.ON_START);
    }

    @NonNull
    public v y() {
        return this.y;
    }

    public void zn() {
        a(v.n3.ON_CREATE);
    }
}
