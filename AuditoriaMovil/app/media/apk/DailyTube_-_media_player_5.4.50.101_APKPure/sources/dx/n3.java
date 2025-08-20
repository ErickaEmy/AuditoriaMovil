package dx;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import kx.d0;
import kx.o;
import kx.p;
import kx.x4;
import m71.wz;
import org.chromium.net.CronetEngine;
import q81.zn;
import timber.log.Timber;
import w0.w;
/* loaded from: classes.dex */
public class n3 extends wz {

    /* loaded from: classes.dex */
    public static final class y implements d0.n3 {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public w<String> f7431a;
        @Nullable

        /* renamed from: c5  reason: collision with root package name */
        public zn f7432c5;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public o f7434fb;

        /* renamed from: n3  reason: collision with root package name */
        public final Executor f7437n3;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public String f7438s;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f7440tl;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public d0.n3 f7441v;

        /* renamed from: wz  reason: collision with root package name */
        public boolean f7442wz;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f7443xc;
        @Nullable
        public final CronetEngine y;

        /* renamed from: zn  reason: collision with root package name */
        public final d0.a f7444zn = new d0.a();
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final x4.n3 f7435gv = null;

        /* renamed from: i9  reason: collision with root package name */
        public int f7436i9 = 3;

        /* renamed from: f  reason: collision with root package name */
        public int f7433f = 8000;

        /* renamed from: t  reason: collision with root package name */
        public int f7439t = 8000;

        public y(CronetEngine cronetEngine, Executor executor) {
            this.y = (CronetEngine) v5.y.v(cronetEngine);
            this.f7437n3 = executor;
        }

        public y gv(@Nullable String str) {
            this.f7438s = str;
            x4.n3 n3Var = this.f7435gv;
            if (n3Var != null) {
                n3Var.v(str);
            }
            return this;
        }

        public y n3(int i) {
            this.f7433f = i;
            x4.n3 n3Var = this.f7435gv;
            if (n3Var != null) {
                n3Var.zn(i);
            }
            return this;
        }

        public y v(@Nullable zn znVar) {
            this.f7432c5 = znVar;
            return this;
        }

        public y zn(int i) {
            this.f7439t = i;
            x4.n3 n3Var = this.f7435gv;
            if (n3Var != null) {
                n3Var.gv(i);
            }
            return this;
        }

        @Override // kx.tl.y
        public d0 y() {
            if (this.y == null) {
                d0.n3 n3Var = this.f7441v;
                if (n3Var != null) {
                    return n3Var.y();
                }
                return ((x4.n3) v5.y.v(this.f7435gv)).y();
            }
            wz n3Var2 = new n3(this.y, this.f7437n3, this.f7436i9, this.f7433f, this.f7439t, this.f7440tl, this.f7442wz, this.f7438s, this.f7444zn, this.f7431a, this.f7443xc, this.f7432c5);
            o oVar = this.f7434fb;
            if (oVar != null) {
                n3Var2.i9(oVar);
            }
            return n3Var2;
        }
    }

    public n3(CronetEngine cronetEngine, Executor executor, int i, int i5, int i6, boolean z2, boolean z3, @Nullable String str, @Nullable d0.a aVar, @Nullable w<String> wVar, boolean z4, @Nullable zn znVar) {
        super(cronetEngine, executor, i, i5, i6, z2, z3, str, aVar, wVar, z4, znVar);
    }

    public long y(p pVar) throws d0.zn {
        try {
            long y2 = super.y(pVar);
            a8();
            return y2;
        } catch (d0.zn e2) {
            Timber.tag("MyCronetDS").w(e2, "fail to request %s", pVar.y);
            throw e2;
        }
    }
}
