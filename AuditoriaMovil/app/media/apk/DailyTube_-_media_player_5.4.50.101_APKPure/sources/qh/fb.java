package qh;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import z0.x4;
/* loaded from: classes.dex */
public final class fb implements i9 {

    /* renamed from: gv  reason: collision with root package name */
    public int f12838gv;

    /* renamed from: v  reason: collision with root package name */
    public boolean f12840v;
    public final zn y = new zn();

    /* renamed from: n3  reason: collision with root package name */
    public final wz f12839n3 = new wz();

    /* renamed from: zn  reason: collision with root package name */
    public final Deque<xc> f12841zn = new ArrayDeque();

    /* loaded from: classes.dex */
    public static final class n3 implements c5 {

        /* renamed from: v  reason: collision with root package name */
        public final x4<qh.n3> f12842v;
        public final long y;

        public n3(long j2, x4<qh.n3> x4Var) {
            this.y = j2;
            this.f12842v = x4Var;
        }

        @Override // qh.c5
        public int gv() {
            return 1;
        }

        @Override // qh.c5
        public List<qh.n3> n3(long j2) {
            if (j2 >= this.y) {
                return this.f12842v;
            }
            return x4.j5();
        }

        @Override // qh.c5
        public int y(long j2) {
            if (this.y > j2) {
                return 0;
            }
            return -1;
        }

        @Override // qh.c5
        public long zn(int i) {
            boolean z2;
            if (i == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public class y extends xc {
        public y() {
        }

        @Override // a9.s
        public void p() {
            fb.this.c5(this);
        }
    }

    public fb() {
        for (int i = 0; i < 2; i++) {
            this.f12841zn.addFirst(new y());
        }
        this.f12838gv = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c5(xc xcVar) {
        boolean z2;
        if (this.f12841zn.size() < 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        v5.y.y(!this.f12841zn.contains(xcVar));
        xcVar.a();
        this.f12841zn.addFirst(xcVar);
    }

    @Override // a9.gv
    @Nullable
    /* renamed from: a */
    public wz gv() throws f {
        v5.y.fb(!this.f12840v);
        if (this.f12838gv != 0) {
            return null;
        }
        this.f12838gv = 1;
        return this.f12839n3;
    }

    @Override // a9.gv
    @Nullable
    /* renamed from: fb */
    public xc n3() throws f {
        v5.y.fb(!this.f12840v);
        if (this.f12838gv == 2 && !this.f12841zn.isEmpty()) {
            xc removeFirst = this.f12841zn.removeFirst();
            if (this.f12839n3.t()) {
                removeFirst.v(4);
            } else {
                wz wzVar = this.f12839n3;
                removeFirst.mt(this.f12839n3.f55f, new n3(wzVar.f55f, this.y.y(((ByteBuffer) v5.y.v(wzVar.f56fb)).array())), 0L);
            }
            this.f12839n3.a();
            this.f12838gv = 0;
            return removeFirst;
        }
        return null;
    }

    @Override // a9.gv
    public void flush() {
        v5.y.fb(!this.f12840v);
        this.f12839n3.a();
        this.f12838gv = 0;
    }

    @Override // a9.gv
    public void release() {
        this.f12840v = true;
    }

    @Override // a9.gv
    /* renamed from: s */
    public void zn(wz wzVar) throws f {
        boolean z2;
        boolean z3 = true;
        v5.y.fb(!this.f12840v);
        if (this.f12838gv == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (this.f12839n3 != wzVar) {
            z3 = false;
        }
        v5.y.y(z3);
        this.f12838gv = 2;
    }

    @Override // qh.i9
    public void y(long j2) {
    }
}
