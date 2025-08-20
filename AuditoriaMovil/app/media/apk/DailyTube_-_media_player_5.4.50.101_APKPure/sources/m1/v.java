package m1;

import androidx.annotation.Nullable;
import java.util.List;
import m1.hy;
/* loaded from: classes.dex */
public abstract class v implements uo {
    public final hy.gv y = new hy.gv();

    @Override // m1.uo
    public final boolean a8() {
        hy b2 = b();
        if (!b2.r() && b2.mt(kp(), this.y).f10806co) {
            return true;
        }
        return false;
    }

    public final void ad(int i) {
        int i42 = i4();
        if (i42 == -1) {
            return;
        }
        if (i42 == kp()) {
            o4(i);
        } else {
            wf(i42, i);
        }
    }

    @Override // m1.uo
    public final boolean ap() {
        hy b2 = b();
        if (!b2.r() && b2.mt(kp(), this.y).f10814p) {
            return true;
        }
        return false;
    }

    public final int c() {
        hy b2 = b();
        if (b2.r()) {
            return -1;
        }
        return b2.w(kp(), ud(), u0());
    }

    public final long co() {
        hy b2 = b();
        if (b2.r()) {
            return -9223372036854775807L;
        }
        return b2.mt(kp(), this.y).a();
    }

    @Override // m1.uo
    public final boolean cr() {
        hy b2 = b();
        if (!b2.r() && b2.mt(kp(), this.y).s()) {
            return true;
        }
        return false;
    }

    @Override // m1.uo
    public final void ct(o0 o0Var) {
        qj(z0.x4.o(o0Var));
    }

    public final void cy(long j2, int i) {
        long currentPosition = getCurrentPosition() + j2;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        xb(Math.max(currentPosition, 0L), i);
    }

    @Override // m1.uo
    public final void f3() {
        if (!b().r() && !i9()) {
            boolean y52 = y5();
            if (cr() && !ap()) {
                if (y52) {
                    qk(7);
                }
            } else if (y52 && getCurrentPosition() <= f7()) {
                qk(7);
            } else {
                xb(0L, 7);
            }
        }
    }

    @Override // m1.uo
    public final void fb(long j2) {
        xb(j2, 5);
    }

    public final int i4() {
        hy b2 = b();
        if (b2.r()) {
            return -1;
        }
        return b2.c5(kp(), ud(), u0());
    }

    @Override // m1.uo
    public final boolean isPlaying() {
        if (n3() == 3 && oz() && x() == 0) {
            return true;
        }
        return false;
    }

    @Override // m1.uo
    public final void lc(int i) {
        wf(i, 10);
    }

    @Override // m1.uo
    @Deprecated
    public final boolean m() {
        return cr();
    }

    @Override // m1.uo
    public final void o(int i, long j2) {
        o0(i, j2, 10, false);
    }

    public abstract void o0(int i, long j2, int i5, boolean z2);

    public final void o4(int i) {
        o0(kp(), -9223372036854775807L, i, true);
    }

    @Override // m1.uo
    public final void pause() {
        n(false);
    }

    @Override // m1.uo
    public final void play() {
        n(true);
    }

    public final void qj(List<o0> list) {
        w(list, true);
    }

    public final void qk(int i) {
        int c2 = c();
        if (c2 == -1) {
            return;
        }
        if (c2 == kp()) {
            o4(i);
        } else {
            wf(c2, i);
        }
    }

    @Override // m1.uo
    public final boolean rz() {
        if (i4() != -1) {
            return true;
        }
        return false;
    }

    @Override // m1.uo
    public final void t() {
        r(0, Integer.MAX_VALUE);
    }

    @Override // m1.uo
    public final void tg() {
        cy(-pq(), 11);
    }

    @Override // m1.uo
    @Nullable
    public final o0 tl() {
        hy b2 = b();
        if (b2.r()) {
            return null;
        }
        return b2.mt(kp(), this.y).f10811fb;
    }

    public final int ud() {
        int c52 = c5();
        if (c52 == 1) {
            return 0;
        }
        return c52;
    }

    @Override // m1.uo
    public final void vl() {
        if (!b().r() && !i9()) {
            if (rz()) {
                ad(9);
            } else if (cr() && a8()) {
                wf(kp(), 9);
            }
        }
    }

    public final void wf(int i, int i5) {
        o0(i, -9223372036854775807L, i5, false);
    }

    @Override // m1.uo
    @Deprecated
    public final int x4() {
        return kp();
    }

    public final void xb(long j2, int i) {
        o0(kp(), j2, i, false);
    }

    @Override // m1.uo
    public final void xc() {
        wf(kp(), 4);
    }

    @Override // m1.uo
    public final void y4() {
        cy(nf(), 12);
    }

    @Override // m1.uo
    public final boolean y5() {
        if (c() != -1) {
            return true;
        }
        return false;
    }

    @Override // m1.uo
    public final int z() {
        return b().z();
    }

    @Override // m1.uo
    public final boolean z6(int i) {
        return j().zn(i);
    }
}
