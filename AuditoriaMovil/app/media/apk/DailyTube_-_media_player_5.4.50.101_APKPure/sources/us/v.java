package us;

import a9.s;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import qh.c5;
import qh.f;
import qh.i9;
import qh.wz;
import qh.xc;
import us.v;
import v5.j5;
/* loaded from: classes.dex */
public abstract class v implements i9 {

    /* renamed from: a  reason: collision with root package name */
    public long f14172a;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public n3 f14173gv;

    /* renamed from: n3  reason: collision with root package name */
    public final ArrayDeque<xc> f14174n3;

    /* renamed from: v  reason: collision with root package name */
    public long f14175v;
    public final ArrayDeque<n3> y = new ArrayDeque<>();

    /* renamed from: zn  reason: collision with root package name */
    public final PriorityQueue<n3> f14176zn;

    /* loaded from: classes.dex */
    public static final class n3 extends wz implements Comparable<n3> {

        /* renamed from: z  reason: collision with root package name */
        public long f14177z;

        public n3() {
        }

        @Override // java.lang.Comparable
        /* renamed from: f3 */
        public int compareTo(n3 n3Var) {
            if (t() != n3Var.t()) {
                if (!t()) {
                    return -1;
                }
                return 1;
            }
            long j2 = this.f55f - n3Var.f55f;
            if (j2 == 0) {
                j2 = this.f14177z - n3Var.f14177z;
                if (j2 == 0) {
                    return 0;
                }
            }
            if (j2 <= 0) {
                return -1;
            }
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends xc {

        /* renamed from: t  reason: collision with root package name */
        public s.y<zn> f14178t;

        public zn(s.y<zn> yVar) {
            this.f14178t = yVar;
        }

        @Override // a9.s
        public final void p() {
            this.f14178t.y(this);
        }
    }

    public v() {
        for (int i = 0; i < 10; i++) {
            this.y.add(new n3());
        }
        this.f14174n3 = new ArrayDeque<>();
        for (int i5 = 0; i5 < 2; i5++) {
            this.f14174n3.add(new zn(new s.y() { // from class: us.gv
                @Override // a9.s.y
                public final void y(s sVar) {
                    v.this.wz((v.zn) sVar);
                }
            }));
        }
        this.f14176zn = new PriorityQueue<>();
    }

    public abstract void a(wz wzVar);

    @Nullable
    public final xc c5() {
        return this.f14174n3.pollFirst();
    }

    public abstract boolean f();

    @Override // a9.gv
    @Nullable
    /* renamed from: fb */
    public wz gv() throws f {
        boolean z2;
        if (this.f14173gv == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (this.y.isEmpty()) {
            return null;
        }
        n3 pollFirst = this.y.pollFirst();
        this.f14173gv = pollFirst;
        return pollFirst;
    }

    @Override // a9.gv
    public void flush() {
        this.f14172a = 0L;
        this.f14175v = 0L;
        while (!this.f14176zn.isEmpty()) {
            tl((n3) j5.i9(this.f14176zn.poll()));
        }
        n3 n3Var = this.f14173gv;
        if (n3Var != null) {
            tl(n3Var);
            this.f14173gv = null;
        }
    }

    public final long i9() {
        return this.f14175v;
    }

    @Override // a9.gv
    @Nullable
    /* renamed from: s */
    public xc n3() throws f {
        if (this.f14174n3.isEmpty()) {
            return null;
        }
        while (!this.f14176zn.isEmpty() && ((n3) j5.i9(this.f14176zn.peek())).f55f <= this.f14175v) {
            n3 n3Var = (n3) j5.i9(this.f14176zn.poll());
            if (n3Var.t()) {
                xc xcVar = (xc) j5.i9(this.f14174n3.pollFirst());
                xcVar.v(4);
                tl(n3Var);
                return xcVar;
            }
            a(n3Var);
            if (f()) {
                c5 v2 = v();
                xc xcVar2 = (xc) j5.i9(this.f14174n3.pollFirst());
                xcVar2.mt(n3Var.f55f, v2, Long.MAX_VALUE);
                tl(n3Var);
                return xcVar2;
            }
            tl(n3Var);
        }
        return null;
    }

    @Override // a9.gv
    /* renamed from: t */
    public void zn(wz wzVar) throws f {
        boolean z2;
        if (wzVar == this.f14173gv) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        n3 n3Var = (n3) wzVar;
        if (n3Var.f()) {
            tl(n3Var);
        } else {
            long j2 = this.f14172a;
            this.f14172a = 1 + j2;
            n3Var.f14177z = j2;
            this.f14176zn.add(n3Var);
        }
        this.f14173gv = null;
    }

    public final void tl(n3 n3Var) {
        n3Var.a();
        this.y.add(n3Var);
    }

    public abstract c5 v();

    public void wz(xc xcVar) {
        xcVar.a();
        this.f14174n3.add(xcVar);
    }

    @Override // qh.i9
    public void y(long j2) {
        this.f14175v = j2;
    }

    @Override // a9.gv
    public void release() {
    }
}
