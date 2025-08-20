package d9;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import v5.j5;
/* loaded from: classes.dex */
public final class f3 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public i4 f7004a;

    /* renamed from: c  reason: collision with root package name */
    public long f7005c;

    /* renamed from: c5  reason: collision with root package name */
    public long f7006c5;

    /* renamed from: co  reason: collision with root package name */
    public long f7007co;

    /* renamed from: d  reason: collision with root package name */
    public long f7008d;

    /* renamed from: d0  reason: collision with root package name */
    public long f7009d0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7010f;

    /* renamed from: f3  reason: collision with root package name */
    public int f7011f3;

    /* renamed from: fb  reason: collision with root package name */
    public int f7012fb;

    /* renamed from: fh  reason: collision with root package name */
    public long f7013fh;

    /* renamed from: gv  reason: collision with root package name */
    public int f7014gv;

    /* renamed from: i4  reason: collision with root package name */
    public int f7015i4;

    /* renamed from: i9  reason: collision with root package name */
    public float f7016i9;

    /* renamed from: mg  reason: collision with root package name */
    public long f7017mg;

    /* renamed from: mt  reason: collision with root package name */
    public long f7018mt;

    /* renamed from: n  reason: collision with root package name */
    public long f7019n;

    /* renamed from: n3  reason: collision with root package name */
    public final long[] f7020n3;

    /* renamed from: p  reason: collision with root package name */
    public boolean f7021p;

    /* renamed from: r  reason: collision with root package name */
    public long f7022r;

    /* renamed from: rz  reason: collision with root package name */
    public long f7023rz;

    /* renamed from: s  reason: collision with root package name */
    public boolean f7024s;

    /* renamed from: t  reason: collision with root package name */
    public long f7025t;

    /* renamed from: ta  reason: collision with root package name */
    public boolean f7026ta;

    /* renamed from: tl  reason: collision with root package name */
    public long f7027tl;

    /* renamed from: v  reason: collision with root package name */
    public int f7028v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f7029w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public Method f7030wz;

    /* renamed from: x4  reason: collision with root package name */
    public long f7031x4;

    /* renamed from: xc  reason: collision with root package name */
    public long f7032xc;
    public final y y;

    /* renamed from: z  reason: collision with root package name */
    public long f7033z;

    /* renamed from: z6  reason: collision with root package name */
    public long f7034z6;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public AudioTrack f7035zn;

    /* loaded from: classes.dex */
    public interface y {
        void fb(long j2);

        void gv(long j2, long j4, long j6, long j7);

        void n3(long j2);

        void y(int i, long j2);

        void zn(long j2, long j4, long j6, long j7);
    }

    public f3(y yVar) {
        this.y = (y) v5.y.v(yVar);
        if (j5.y >= 18) {
            try {
                this.f7030wz = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f7020n3 = new long[10];
    }

    public static boolean xc(int i) {
        if (j5.y < 23 && (i == 5 || i == 6)) {
            return true;
        }
        return false;
    }

    public final long a() {
        return n3(v());
    }

    public boolean c5() {
        if (((AudioTrack) v5.y.v(this.f7035zn)).getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public void co(AudioTrack audioTrack, boolean z2, int i, int i5, int i6) {
        boolean z3;
        long j2;
        this.f7035zn = audioTrack;
        this.f7014gv = i5;
        this.f7028v = i6;
        this.f7004a = new i4(audioTrack);
        this.f7012fb = audioTrack.getSampleRate();
        if (z2 && xc(i)) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f7024s = z3;
        boolean u02 = j5.u0(i);
        this.f7021p = u02;
        if (u02) {
            j2 = n3(i6 / i5);
        } else {
            j2 = -9223372036854775807L;
        }
        this.f7006c5 = j2;
        this.f7033z = 0L;
        this.f7022r = 0L;
        this.f7031x4 = 0L;
        this.f7029w = false;
        this.f7019n = -9223372036854775807L;
        this.f7005c = -9223372036854775807L;
        this.f7018mt = 0L;
        this.f7032xc = 0L;
        this.f7016i9 = 1.0f;
    }

    public boolean f(long j2) {
        int playState = ((AudioTrack) v5.y.v(this.f7035zn)).getPlayState();
        if (this.f7024s) {
            if (playState == 2) {
                this.f7029w = false;
                return false;
            } else if (playState == 1 && v() == 0) {
                return false;
            }
        }
        boolean z2 = this.f7029w;
        boolean s2 = s(j2);
        this.f7029w = s2;
        if (z2 && !s2 && playState != 1) {
            this.y.y(this.f7028v, j5.gf(this.f7006c5));
        }
        return true;
    }

    public void fb(long j2) {
        this.f7009d0 = v();
        this.f7019n = SystemClock.elapsedRealtime() * 1000;
        this.f7013fh = j2;
    }

    public long gv(boolean z2) {
        long u2;
        if (((AudioTrack) v5.y.v(this.f7035zn)).getPlayState() == 3) {
            tl();
        }
        long nanoTime = System.nanoTime() / 1000;
        i4 i4Var = (i4) v5.y.v(this.f7004a);
        boolean gv2 = i4Var.gv();
        if (gv2) {
            u2 = n3(i4Var.n3()) + j5.u(nanoTime - i4Var.zn(), this.f7016i9);
        } else {
            if (this.f7011f3 == 0) {
                u2 = a();
            } else {
                u2 = j5.u(this.f7025t + nanoTime, this.f7016i9);
            }
            if (!z2) {
                u2 = Math.max(0L, u2 - this.f7032xc);
            }
        }
        if (this.f7026ta != gv2) {
            this.f7034z6 = this.f7017mg;
            this.f7008d = this.f7023rz;
        }
        long j2 = nanoTime - this.f7034z6;
        if (j2 < 1000000) {
            long j4 = (j2 * 1000) / 1000000;
            u2 = ((u2 * j4) + ((1000 - j4) * (this.f7008d + j5.u(j2, this.f7016i9)))) / 1000;
        }
        if (!this.f7010f) {
            long j6 = this.f7023rz;
            if (u2 > j6) {
                this.f7010f = true;
                this.y.fb(System.currentTimeMillis() - j5.gf(j5.o4(j5.gf(u2 - j6), this.f7016i9)));
            }
        }
        this.f7017mg = nanoTime;
        this.f7023rz = u2;
        this.f7026ta = gv2;
        return u2;
    }

    public boolean i9(long j2) {
        if (this.f7005c != -9223372036854775807L && j2 > 0 && SystemClock.elapsedRealtime() - this.f7005c >= 200) {
            return true;
        }
        return false;
    }

    public final void mt() {
        this.f7025t = 0L;
        this.f7011f3 = 0;
        this.f7015i4 = 0;
        this.f7027tl = 0L;
        this.f7017mg = 0L;
        this.f7034z6 = 0L;
        this.f7010f = false;
    }

    public final long n3(long j2) {
        return (j2 * 1000000) / this.f7012fb;
    }

    public void p() {
        mt();
        this.f7035zn = null;
        this.f7004a = null;
    }

    public void r() {
        ((i4) v5.y.v(this.f7004a)).fb();
    }

    public boolean s(long j2) {
        if (j2 <= v() && !y()) {
            return false;
        }
        return true;
    }

    public final void t(long j2) {
        i4 i4Var = (i4) v5.y.v(this.f7004a);
        if (!i4Var.v(j2)) {
            return;
        }
        long zn2 = i4Var.zn();
        long n32 = i4Var.n3();
        long a2 = a();
        if (Math.abs(zn2 - j2) > 5000000) {
            this.y.gv(n32, zn2, j2, a2);
            i4Var.a();
        } else if (Math.abs(n3(n32) - a2) > 5000000) {
            this.y.zn(n32, zn2, j2, a2);
            i4Var.a();
        } else {
            i4Var.y();
        }
    }

    public final void tl() {
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.f7027tl >= 30000) {
            long a2 = a();
            if (a2 == 0) {
                return;
            }
            this.f7020n3[this.f7015i4] = j5.o4(a2, this.f7016i9) - nanoTime;
            this.f7015i4 = (this.f7015i4 + 1) % 10;
            int i = this.f7011f3;
            if (i < 10) {
                this.f7011f3 = i + 1;
            }
            this.f7027tl = nanoTime;
            this.f7025t = 0L;
            int i5 = 0;
            while (true) {
                int i6 = this.f7011f3;
                if (i5 >= i6) {
                    break;
                }
                this.f7025t += this.f7020n3[i5] / i6;
                i5++;
            }
        }
        if (this.f7024s) {
            return;
        }
        t(nanoTime);
        wz(nanoTime);
    }

    public final long v() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f7019n;
        if (j2 != -9223372036854775807L) {
            return Math.min(this.f7013fh, this.f7009d0 + ((j5.u((elapsedRealtime * 1000) - j2, this.f7016i9) * this.f7012fb) / 1000000));
        }
        if (elapsedRealtime - this.f7007co >= 5) {
            x4(elapsedRealtime);
            this.f7007co = elapsedRealtime;
        }
        return this.f7033z + (this.f7022r << 32);
    }

    public boolean w() {
        mt();
        if (this.f7019n == -9223372036854775807L) {
            ((i4) v5.y.v(this.f7004a)).fb();
            return true;
        }
        return false;
    }

    public final void wz(long j2) {
        Method method;
        if (this.f7021p && (method = this.f7030wz) != null && j2 - this.f7018mt >= 500000) {
            try {
                long intValue = (((Integer) j5.i9((Integer) method.invoke(v5.y.v(this.f7035zn), null))).intValue() * 1000) - this.f7006c5;
                this.f7032xc = intValue;
                long max = Math.max(intValue, 0L);
                this.f7032xc = max;
                if (max > 5000000) {
                    this.y.n3(max);
                    this.f7032xc = 0L;
                }
            } catch (Exception unused) {
                this.f7030wz = null;
            }
            this.f7018mt = j2;
        }
    }

    public final void x4(long j2) {
        AudioTrack audioTrack;
        int playState = ((AudioTrack) v5.y.v(this.f7035zn)).getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.f7024s) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f7031x4 = this.f7033z;
            }
            playbackHeadPosition += this.f7031x4;
        }
        if (j5.y <= 29) {
            if (playbackHeadPosition == 0 && this.f7033z > 0 && playState == 3) {
                if (this.f7005c == -9223372036854775807L) {
                    this.f7005c = j2;
                    return;
                }
                return;
            }
            this.f7005c = -9223372036854775807L;
        }
        if (this.f7033z > playbackHeadPosition) {
            this.f7022r++;
        }
        this.f7033z = playbackHeadPosition;
    }

    public final boolean y() {
        if (this.f7024s && ((AudioTrack) v5.y.v(this.f7035zn)).getPlayState() == 2 && v() == 0) {
            return true;
        }
        return false;
    }

    public void z(float f4) {
        this.f7016i9 = f4;
        i4 i4Var = this.f7004a;
        if (i4Var != null) {
            i4Var.fb();
        }
        mt();
    }

    public int zn(long j2) {
        return this.f7028v - ((int) (j2 - (v() * this.f7014gv)));
    }
}
