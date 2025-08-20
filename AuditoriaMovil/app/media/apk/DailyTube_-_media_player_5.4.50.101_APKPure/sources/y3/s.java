package y3;

import android.net.Uri;
import e4.fh;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import m1.ne;
import y3.ud;
/* loaded from: classes.dex */
public final class s implements e4.t {

    /* renamed from: tl  reason: collision with root package name */
    public static final e4.mt f15133tl = new e4.mt() { // from class: y3.fb
        @Override // e4.mt
        public final e4.t[] createExtractors() {
            e4.t[] c52;
            c52 = s.c5();
            return c52;
        }

        @Override // e4.mt
        public /* synthetic */ e4.t[] y(Uri uri, Map map) {
            return e4.p.y(this, uri, map);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public e4.wz f15134a;

    /* renamed from: c5  reason: collision with root package name */
    public int f15135c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15136f;

    /* renamed from: fb  reason: collision with root package name */
    public long f15137fb;

    /* renamed from: gv  reason: collision with root package name */
    public final v5.rz f15138gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f15139i9;

    /* renamed from: n3  reason: collision with root package name */
    public final c5 f15140n3;

    /* renamed from: s  reason: collision with root package name */
    public long f15141s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f15142t;

    /* renamed from: v  reason: collision with root package name */
    public final v5.fh f15143v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final v5.rz f15144zn;

    public s() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e4.t[] c5() {
        return new e4.t[]{new s()};
    }

    private static int fb(int i, long j2) {
        return (int) ((i * 8000000) / j2);
    }

    private e4.fh s(long j2, boolean z2) {
        return new e4.v(j2, this.f15141s, fb(this.f15135c5, this.f15140n3.f()), this.f15135c5, z2);
    }

    @Override // e4.t
    public boolean a(e4.tl tlVar) throws IOException {
        int f4 = f(tlVar);
        int i = f4;
        int i5 = 0;
        int i6 = 0;
        do {
            tlVar.z(this.f15138gv.v(), 0, 2);
            this.f15138gv.oz(0);
            if (!c5.tl(this.f15138gv.yt())) {
                i++;
                tlVar.s();
                tlVar.wz(i);
            } else {
                i5++;
                if (i5 >= 4 && i6 > 188) {
                    return true;
                }
                tlVar.z(this.f15138gv.v(), 0, 4);
                this.f15143v.w(14);
                int s2 = this.f15143v.s(13);
                if (s2 <= 6) {
                    i++;
                    tlVar.s();
                    tlVar.wz(i);
                } else {
                    tlVar.wz(s2 - 6);
                    i6 += s2;
                }
            }
            i5 = 0;
            i6 = 0;
        } while (i - f4 < 8192);
        return false;
    }

    public final int f(e4.tl tlVar) throws IOException {
        int i = 0;
        while (true) {
            tlVar.z(this.f15138gv.v(), 0, 10);
            this.f15138gv.oz(0);
            if (this.f15138gv.x() != 4801587) {
                break;
            }
            this.f15138gv.ut(3);
            int z62 = this.f15138gv.z6();
            i += z62 + 10;
            tlVar.wz(z62);
        }
        tlVar.s();
        tlVar.wz(i);
        if (this.f15141s == -1) {
            this.f15141s = i;
        }
        return i;
    }

    public final void gv(e4.tl tlVar) throws IOException {
        int s2;
        if (this.f15139i9) {
            return;
        }
        this.f15135c5 = -1;
        tlVar.s();
        long j2 = 0;
        if (tlVar.getPosition() == 0) {
            f(tlVar);
        }
        int i = 0;
        int i5 = 0;
        do {
            try {
                if (!tlVar.v(this.f15138gv.v(), 0, 2, true)) {
                    break;
                }
                this.f15138gv.oz(0);
                if (!c5.tl(this.f15138gv.yt())) {
                    break;
                } else if (!tlVar.v(this.f15138gv.v(), 0, 4, true)) {
                    break;
                } else {
                    this.f15143v.w(14);
                    s2 = this.f15143v.s(13);
                    if (s2 > 6) {
                        j2 += s2;
                        i5++;
                        if (i5 == 1000) {
                            break;
                        }
                    } else {
                        this.f15139i9 = true;
                        throw ne.y("Malformed ADTS stream", null);
                    }
                }
            } catch (EOFException unused) {
            }
        } while (tlVar.co(s2 - 6, true));
        i = i5;
        tlVar.s();
        if (i > 0) {
            this.f15135c5 = (int) (j2 / i);
        } else {
            this.f15135c5 = -1;
        }
        this.f15139i9 = true;
    }

    public final void i9(long j2, boolean z2) {
        boolean z3;
        if (this.f15142t) {
            return;
        }
        boolean z4 = false;
        if ((this.y & 1) != 0 && this.f15135c5 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && this.f15140n3.f() == -9223372036854775807L && !z2) {
            return;
        }
        if (z3 && this.f15140n3.f() != -9223372036854775807L) {
            e4.wz wzVar = this.f15134a;
            if ((this.y & 2) != 0) {
                z4 = true;
            }
            wzVar.t(s(j2, z4));
        } else {
            this.f15134a.t(new fh.n3(-9223372036854775807L));
        }
        this.f15142t = true;
    }

    @Override // e4.t
    public int v(e4.tl tlVar, e4.d0 d0Var) throws IOException {
        boolean z2;
        v5.y.c5(this.f15134a);
        long length = tlVar.getLength();
        int i = this.y;
        if ((i & 2) != 0 || ((i & 1) != 0 && length != -1)) {
            gv(tlVar);
        }
        int read = tlVar.read(this.f15144zn.v(), 0, 2048);
        if (read == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        i9(length, z2);
        if (z2) {
            return -1;
        }
        this.f15144zn.oz(0);
        this.f15144zn.j(read);
        if (!this.f15136f) {
            this.f15140n3.a(this.f15137fb, 4);
            this.f15136f = true;
        }
        this.f15140n3.n3(this.f15144zn);
        return 0;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        this.f15136f = false;
        this.f15140n3.zn();
        this.f15137fb = j4;
    }

    @Override // e4.t
    public void zn(e4.wz wzVar) {
        this.f15134a = wzVar;
        this.f15140n3.v(wzVar, new ud.gv(0, 1));
        wzVar.xc();
    }

    public s(int i) {
        this.y = (i & 2) != 0 ? i | 1 : i;
        this.f15140n3 = new c5(true);
        this.f15144zn = new v5.rz(2048);
        this.f15135c5 = -1;
        this.f15141s = -1L;
        v5.rz rzVar = new v5.rz(10);
        this.f15138gv = rzVar;
        this.f15143v = new v5.fh(rzVar.v());
    }

    @Override // e4.t
    public void release() {
    }
}
