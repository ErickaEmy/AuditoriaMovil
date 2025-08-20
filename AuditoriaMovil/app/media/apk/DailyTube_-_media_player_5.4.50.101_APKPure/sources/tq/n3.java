package tq;

import e4.co;
import e4.tl;
import e4.x4;
import e4.y;
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes.dex */
public final class n3 extends e4.y {

    /* renamed from: tq.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0222n3 implements y.a {

        /* renamed from: n3  reason: collision with root package name */
        public final int f14016n3;
        public final x4 y;

        /* renamed from: zn  reason: collision with root package name */
        public final co.y f14017zn;

        @Override // e4.y.a
        public /* synthetic */ void n3() {
            e4.n3.y(this);
        }

        @Override // e4.y.a
        public y.v y(tl tlVar, long j2) throws IOException {
            long position = tlVar.getPosition();
            long zn2 = zn(tlVar);
            long t2 = tlVar.t();
            tlVar.wz(Math.max(6, this.y.f7533zn));
            long zn3 = zn(tlVar);
            long t3 = tlVar.t();
            if (zn2 <= j2 && zn3 > j2) {
                return y.v.v(t2);
            }
            if (zn3 <= j2) {
                return y.v.a(zn3, t3);
            }
            return y.v.gv(zn2, position);
        }

        public final long zn(tl tlVar) throws IOException {
            while (tlVar.t() < tlVar.getLength() - 6 && !co.s(tlVar, this.y, this.f14016n3, this.f14017zn)) {
                tlVar.wz(1);
            }
            if (tlVar.t() >= tlVar.getLength() - 6) {
                tlVar.wz((int) (tlVar.getLength() - tlVar.t()));
                return this.y.f7528i9;
            }
            return this.f14017zn.y;
        }

        public C0222n3(x4 x4Var, int i) {
            this.y = x4Var;
            this.f14016n3 = i;
            this.f14017zn = new co.y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n3(final x4 x4Var, int i, long j2, long j4) {
        super(new y.gv() { // from class: tq.y
            @Override // e4.y.gv
            public final long timeUsToTargetTime(long j6) {
                return x4.this.c5(j6);
            }
        }, new C0222n3(x4Var, i), x4Var.a(), 0L, x4Var.f7528i9, j2, j4, x4Var.gv(), Math.max(6, x4Var.f7533zn));
        Objects.requireNonNull(x4Var);
    }
}
