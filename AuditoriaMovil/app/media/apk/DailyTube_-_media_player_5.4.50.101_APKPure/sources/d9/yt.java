package d9;

import androidx.annotation.Nullable;
import d9.fb;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import v5.j5;
/* loaded from: classes.dex */
public final class yt implements fb {

    /* renamed from: a  reason: collision with root package name */
    public fb.y f7228a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f7229c5;

    /* renamed from: f  reason: collision with root package name */
    public ByteBuffer f7230f;

    /* renamed from: fb  reason: collision with root package name */
    public fb.y f7231fb;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public k5 f7233i9;

    /* renamed from: n3  reason: collision with root package name */
    public int f7234n3;

    /* renamed from: s  reason: collision with root package name */
    public fb.y f7235s;

    /* renamed from: t  reason: collision with root package name */
    public ShortBuffer f7236t;

    /* renamed from: tl  reason: collision with root package name */
    public ByteBuffer f7237tl;

    /* renamed from: v  reason: collision with root package name */
    public fb.y f7238v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f7239w;

    /* renamed from: wz  reason: collision with root package name */
    public long f7240wz;

    /* renamed from: xc  reason: collision with root package name */
    public long f7241xc;

    /* renamed from: zn  reason: collision with root package name */
    public float f7242zn = 1.0f;

    /* renamed from: gv  reason: collision with root package name */
    public float f7232gv = 1.0f;

    public yt() {
        fb.y yVar = fb.y.f7036v;
        this.f7238v = yVar;
        this.f7228a = yVar;
        this.f7231fb = yVar;
        this.f7235s = yVar;
        ByteBuffer byteBuffer = fb.y;
        this.f7230f = byteBuffer;
        this.f7236t = byteBuffer.asShortBuffer();
        this.f7237tl = byteBuffer;
        this.f7234n3 = -1;
    }

    @Override // d9.fb
    public boolean a() {
        k5 k5Var;
        if (this.f7239w && ((k5Var = this.f7233i9) == null || k5Var.f() == 0)) {
            return true;
        }
        return false;
    }

    @Override // d9.fb
    public void c5(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
        int remaining = byteBuffer.remaining();
        this.f7240wz += remaining;
        ((k5) v5.y.v(this.f7233i9)).z(asShortBuffer);
        byteBuffer.position(byteBuffer.position() + remaining);
    }

    @Override // d9.fb
    public ByteBuffer fb() {
        int f4;
        k5 k5Var = this.f7233i9;
        if (k5Var != null && (f4 = k5Var.f()) > 0) {
            if (this.f7230f.capacity() < f4) {
                ByteBuffer order = ByteBuffer.allocateDirect(f4).order(ByteOrder.nativeOrder());
                this.f7230f = order;
                this.f7236t = order.asShortBuffer();
            } else {
                this.f7230f.clear();
                this.f7236t.clear();
            }
            k5Var.i9(this.f7236t);
            this.f7241xc += f4;
            this.f7230f.limit(f4);
            this.f7237tl = this.f7230f;
        }
        ByteBuffer byteBuffer = this.f7237tl;
        this.f7237tl = fb.y;
        return byteBuffer;
    }

    @Override // d9.fb
    public void flush() {
        if (isActive()) {
            fb.y yVar = this.f7238v;
            this.f7231fb = yVar;
            fb.y yVar2 = this.f7228a;
            this.f7235s = yVar2;
            if (this.f7229c5) {
                this.f7233i9 = new k5(yVar.y, yVar.f7038n3, this.f7242zn, this.f7232gv, yVar2.y);
            } else {
                k5 k5Var = this.f7233i9;
                if (k5Var != null) {
                    k5Var.c5();
                }
            }
        }
        this.f7237tl = fb.y;
        this.f7240wz = 0L;
        this.f7241xc = 0L;
        this.f7239w = false;
    }

    public void gv(float f4) {
        if (this.f7242zn != f4) {
            this.f7242zn = f4;
            this.f7229c5 = true;
        }
    }

    @Override // d9.fb
    public void i9() {
        k5 k5Var = this.f7233i9;
        if (k5Var != null) {
            k5Var.co();
        }
        this.f7239w = true;
    }

    @Override // d9.fb
    public boolean isActive() {
        if (this.f7228a.y != -1 && (Math.abs(this.f7242zn - 1.0f) >= 1.0E-4f || Math.abs(this.f7232gv - 1.0f) >= 1.0E-4f || this.f7228a.y != this.f7238v.y)) {
            return true;
        }
        return false;
    }

    public long n3(long j2) {
        if (this.f7241xc >= 1024) {
            long t2 = this.f7240wz - ((k5) v5.y.v(this.f7233i9)).t();
            int i = this.f7235s.y;
            int i5 = this.f7231fb.y;
            if (i == i5) {
                return j5.x5(j2, t2, this.f7241xc);
            }
            return j5.x5(j2, t2 * i, this.f7241xc * i5);
        }
        return (long) (this.f7242zn * j2);
    }

    @Override // d9.fb
    public fb.y s(fb.y yVar) throws fb.n3 {
        if (yVar.f7039zn == 2) {
            int i = this.f7234n3;
            if (i == -1) {
                i = yVar.y;
            }
            this.f7238v = yVar;
            fb.y yVar2 = new fb.y(i, yVar.f7038n3, 2);
            this.f7228a = yVar2;
            this.f7229c5 = true;
            return yVar2;
        }
        throw new fb.n3(yVar);
    }

    @Override // d9.fb
    public void y() {
        this.f7242zn = 1.0f;
        this.f7232gv = 1.0f;
        fb.y yVar = fb.y.f7036v;
        this.f7238v = yVar;
        this.f7228a = yVar;
        this.f7231fb = yVar;
        this.f7235s = yVar;
        ByteBuffer byteBuffer = fb.y;
        this.f7230f = byteBuffer;
        this.f7236t = byteBuffer.asShortBuffer();
        this.f7237tl = byteBuffer;
        this.f7234n3 = -1;
        this.f7229c5 = false;
        this.f7233i9 = null;
        this.f7240wz = 0L;
        this.f7241xc = 0L;
        this.f7239w = false;
    }

    public void zn(float f4) {
        if (this.f7232gv != f4) {
            this.f7232gv = f4;
            this.f7229c5 = true;
        }
    }
}
