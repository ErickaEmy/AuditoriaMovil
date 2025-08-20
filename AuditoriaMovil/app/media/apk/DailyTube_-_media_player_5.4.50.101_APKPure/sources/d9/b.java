package d9;

import d9.fb;
import java.nio.ByteBuffer;
import v5.j5;
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: c5  reason: collision with root package name */
    public final long f6968c5;

    /* renamed from: co  reason: collision with root package name */
    public boolean f6969co;

    /* renamed from: f  reason: collision with root package name */
    public final short f6970f;

    /* renamed from: i9  reason: collision with root package name */
    public final long f6971i9;

    /* renamed from: mt  reason: collision with root package name */
    public int f6972mt;

    /* renamed from: p  reason: collision with root package name */
    public int f6973p;

    /* renamed from: t  reason: collision with root package name */
    public int f6974t;

    /* renamed from: tl  reason: collision with root package name */
    public boolean f6975tl;

    /* renamed from: w  reason: collision with root package name */
    public int f6976w;

    /* renamed from: wz  reason: collision with root package name */
    public byte[] f6977wz;

    /* renamed from: xc  reason: collision with root package name */
    public byte[] f6978xc;

    /* renamed from: z  reason: collision with root package name */
    public long f6979z;

    public b() {
        this(150000L, 20000L, (short) 1024);
    }

    @Override // d9.fb
    public void c5(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !n3()) {
            int i = this.f6976w;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        r(byteBuffer);
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    co(byteBuffer);
                }
            } else {
                z(byteBuffer);
            }
        }
    }

    public final void co(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int xc2 = xc(byteBuffer);
        int position = xc2 - byteBuffer.position();
        byte[] bArr = this.f6977wz;
        int length = bArr.length;
        int i = this.f6973p;
        int i5 = length - i;
        if (xc2 < limit && position < i5) {
            mt(bArr, i);
            this.f6973p = 0;
            this.f6976w = 0;
            return;
        }
        int min = Math.min(position, i5);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.f6977wz, this.f6973p, min);
        int i6 = this.f6973p + min;
        this.f6973p = i6;
        byte[] bArr2 = this.f6977wz;
        if (i6 == bArr2.length) {
            if (this.f6969co) {
                mt(bArr2, this.f6972mt);
                this.f6979z += (this.f6973p - (this.f6972mt * 2)) / this.f6974t;
            } else {
                this.f6979z += (i6 - this.f6972mt) / this.f6974t;
            }
            i4(byteBuffer, this.f6977wz, this.f6973p);
            this.f6973p = 0;
            this.f6976w = 2;
        }
        byteBuffer.limit(limit);
    }

    @Override // d9.c
    public void f() {
        this.f6975tl = false;
        this.f6972mt = 0;
        byte[] bArr = j5.f14357a;
        this.f6977wz = bArr;
        this.f6978xc = bArr;
    }

    @Override // d9.c
    public void gv() {
        if (this.f6975tl) {
            this.f6974t = this.f6983n3.f7037gv;
            int tl2 = tl(this.f6968c5) * this.f6974t;
            if (this.f6977wz.length != tl2) {
                this.f6977wz = new byte[tl2];
            }
            int tl3 = tl(this.f6971i9) * this.f6974t;
            this.f6972mt = tl3;
            if (this.f6978xc.length != tl3) {
                this.f6978xc = new byte[tl3];
            }
        }
        this.f6976w = 0;
        this.f6979z = 0L;
        this.f6973p = 0;
        this.f6969co = false;
    }

    public final void i4(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.f6972mt);
        int i5 = this.f6972mt - min;
        System.arraycopy(bArr, i - i5, this.f6978xc, 0, i5);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f6978xc, i5, min);
    }

    @Override // d9.c, d9.fb
    public boolean isActive() {
        return this.f6975tl;
    }

    public final void mt(byte[] bArr, int i) {
        t(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.f6969co = true;
        }
    }

    public final void p(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        t(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.f6969co = true;
        }
    }

    public final void r(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int xc2 = xc(byteBuffer);
        byteBuffer.limit(xc2);
        this.f6979z += byteBuffer.remaining() / this.f6974t;
        i4(byteBuffer, this.f6978xc, this.f6972mt);
        if (xc2 < limit) {
            mt(this.f6978xc, this.f6972mt);
            this.f6976w = 0;
            byteBuffer.limit(limit);
        }
    }

    public final int tl(long j2) {
        return (int) ((j2 * this.f6983n3.y) / 1000000);
    }

    @Override // d9.c
    public void v() {
        int i = this.f6973p;
        if (i > 0) {
            mt(this.f6977wz, i);
        }
        if (!this.f6969co) {
            this.f6979z += this.f6972mt / this.f6974t;
        }
    }

    public long w() {
        return this.f6979z;
    }

    public final int wz(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        while (true) {
            limit -= 2;
            if (limit >= byteBuffer.position()) {
                if (Math.abs((int) byteBuffer.getShort(limit)) > this.f6970f) {
                    int i = this.f6974t;
                    return ((limit / i) * i) + i;
                }
            } else {
                return byteBuffer.position();
            }
        }
    }

    public void x4(boolean z2) {
        this.f6975tl = z2;
    }

    public final int xc(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > this.f6970f) {
                int i = this.f6974t;
                return i * (position / i);
            }
        }
        return byteBuffer.limit();
    }

    public final void z(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f6977wz.length));
        int wz2 = wz(byteBuffer);
        if (wz2 == byteBuffer.position()) {
            this.f6976w = 1;
        } else {
            byteBuffer.limit(wz2);
            p(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    @Override // d9.c
    public fb.y zn(fb.y yVar) throws fb.n3 {
        if (yVar.f7039zn == 2) {
            if (!this.f6975tl) {
                return fb.y.f7036v;
            }
            return yVar;
        }
        throw new fb.n3(yVar);
    }

    public b(long j2, long j4, short s2) {
        v5.y.y(j4 <= j2);
        this.f6968c5 = j2;
        this.f6971i9 = j4;
        this.f6970f = s2;
        byte[] bArr = j5.f14357a;
        this.f6977wz = bArr;
        this.f6978xc = bArr;
    }
}
