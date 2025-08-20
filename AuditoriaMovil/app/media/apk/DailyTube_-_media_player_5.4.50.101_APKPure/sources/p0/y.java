package p0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import e4.d0;
import e4.fh;
import e4.t;
import e4.tl;
import e4.wz;
import ha.f;
import java.io.IOException;
import m1.m;
import v5.rz;
/* loaded from: classes.dex */
public final class y implements t {

    /* renamed from: c5  reason: collision with root package name */
    public zn f12377c5;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public MotionPhotoMetadata f12378fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f12379gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public f f12380i9;

    /* renamed from: n3  reason: collision with root package name */
    public wz f12381n3;

    /* renamed from: s  reason: collision with root package name */
    public tl f12382s;

    /* renamed from: v  reason: collision with root package name */
    public int f12383v;

    /* renamed from: zn  reason: collision with root package name */
    public int f12384zn;
    public final rz y = new rz(6);

    /* renamed from: a  reason: collision with root package name */
    public long f12376a = -1;

    @Nullable
    public static MotionPhotoMetadata fb(String str, long j2) throws IOException {
        n3 y;
        if (j2 == -1 || (y = v.y(str)) == null) {
            return null;
        }
        return y.y(j2);
    }

    @Override // e4.t
    public boolean a(tl tlVar) throws IOException {
        if (c5(tlVar) != 65496) {
            return false;
        }
        int c52 = c5(tlVar);
        this.f12379gv = c52;
        if (c52 == 65504) {
            n3(tlVar);
            this.f12379gv = c5(tlVar);
        }
        if (this.f12379gv != 65505) {
            return false;
        }
        tlVar.wz(2);
        this.y.j5(6);
        tlVar.z(this.y.v(), 0, 6);
        if (this.y.a8() != 1165519206 || this.y.yt() != 0) {
            return false;
        }
        return true;
    }

    public final int c5(tl tlVar) throws IOException {
        this.y.j5(2);
        tlVar.z(this.y.v(), 0, 2);
        return this.y.yt();
    }

    public final void f(tl tlVar) throws IOException {
        String fh2;
        if (this.f12379gv == 65505) {
            rz rzVar = new rz(this.f12383v);
            tlVar.readFully(rzVar.v(), 0, this.f12383v);
            if (this.f12378fb == null && "http://ns.adobe.com/xap/1.0/".equals(rzVar.fh()) && (fh2 = rzVar.fh()) != null) {
                MotionPhotoMetadata fb2 = fb(fh2, tlVar.getLength());
                this.f12378fb = fb2;
                if (fb2 != null) {
                    this.f12376a = fb2.f4285s;
                }
            }
        } else {
            tlVar.p(this.f12383v);
        }
        this.f12384zn = 0;
    }

    public final void gv() {
        s(new Metadata.Entry[0]);
        ((wz) v5.y.v(this.f12381n3)).xc();
        this.f12381n3.t(new fh.n3(-9223372036854775807L));
        this.f12384zn = 6;
    }

    public final void i9(tl tlVar) throws IOException {
        this.y.j5(2);
        tlVar.readFully(this.y.v(), 0, 2);
        int yt2 = this.y.yt();
        this.f12379gv = yt2;
        if (yt2 == 65498) {
            if (this.f12376a != -1) {
                this.f12384zn = 4;
            } else {
                gv();
            }
        } else if ((yt2 < 65488 || yt2 > 65497) && yt2 != 65281) {
            this.f12384zn = 1;
        }
    }

    public final void n3(tl tlVar) throws IOException {
        this.y.j5(2);
        tlVar.z(this.y.v(), 0, 2);
        tlVar.wz(this.y.yt() - 2);
    }

    @Override // e4.t
    public void release() {
        f fVar = this.f12380i9;
        if (fVar != null) {
            fVar.release();
        }
    }

    public final void s(Metadata.Entry... entryArr) {
        ((wz) v5.y.v(this.f12381n3)).a(1024, 4).v(new m.n3().k5("image/jpeg").en(new Metadata(entryArr)).z6());
    }

    public final void t(tl tlVar) throws IOException {
        this.y.j5(2);
        tlVar.readFully(this.y.v(), 0, 2);
        this.f12383v = this.y.yt() - 2;
        this.f12384zn = 2;
    }

    public final void tl(tl tlVar) throws IOException {
        if (!tlVar.v(this.y.v(), 0, 1, true)) {
            gv();
            return;
        }
        tlVar.s();
        if (this.f12380i9 == null) {
            this.f12380i9 = new f();
        }
        zn znVar = new zn(tlVar, this.f12376a);
        this.f12377c5 = znVar;
        if (this.f12380i9.a(znVar)) {
            this.f12380i9.zn(new gv(this.f12376a, (wz) v5.y.v(this.f12381n3)));
            wz();
            return;
        }
        gv();
    }

    @Override // e4.t
    public int v(tl tlVar, d0 d0Var) throws IOException {
        int i = this.f12384zn;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i == 6) {
                                return -1;
                            }
                            throw new IllegalStateException();
                        }
                        if (this.f12377c5 == null || tlVar != this.f12382s) {
                            this.f12382s = tlVar;
                            this.f12377c5 = new zn(tlVar, this.f12376a);
                        }
                        int v2 = ((f) v5.y.v(this.f12380i9)).v(this.f12377c5, d0Var);
                        if (v2 == 1) {
                            d0Var.y += this.f12376a;
                        }
                        return v2;
                    }
                    long position = tlVar.getPosition();
                    long j2 = this.f12376a;
                    if (position != j2) {
                        d0Var.y = j2;
                        return 1;
                    }
                    tl(tlVar);
                    return 0;
                }
                f(tlVar);
                return 0;
            }
            t(tlVar);
            return 0;
        }
        i9(tlVar);
        return 0;
    }

    public final void wz() {
        s((Metadata.Entry) v5.y.v(this.f12378fb));
        this.f12384zn = 5;
    }

    @Override // e4.t
    public void y(long j2, long j4) {
        if (j2 == 0) {
            this.f12384zn = 0;
            this.f12380i9 = null;
        } else if (this.f12384zn == 5) {
            ((f) v5.y.v(this.f12380i9)).y(j2, j4);
        }
    }

    @Override // e4.t
    public void zn(wz wzVar) {
        this.f12381n3 = wzVar;
    }
}
