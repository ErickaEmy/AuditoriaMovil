package d9;

import d9.fb;
import java.nio.ByteBuffer;
import v5.j5;
/* loaded from: classes.dex */
public final class vl extends c {

    /* renamed from: c5  reason: collision with root package name */
    public int f7215c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7216f;

    /* renamed from: i9  reason: collision with root package name */
    public int f7217i9;

    /* renamed from: t  reason: collision with root package name */
    public int f7218t;

    /* renamed from: tl  reason: collision with root package name */
    public byte[] f7219tl = j5.f14357a;

    /* renamed from: wz  reason: collision with root package name */
    public int f7220wz;

    /* renamed from: xc  reason: collision with root package name */
    public long f7221xc;

    @Override // d9.c, d9.fb
    public boolean a() {
        if (super.a() && this.f7220wz == 0) {
            return true;
        }
        return false;
    }

    @Override // d9.fb
    public void c5(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i == 0) {
            return;
        }
        int min = Math.min(i, this.f7218t);
        this.f7221xc += min / this.f6983n3.f7037gv;
        this.f7218t -= min;
        byteBuffer.position(position + min);
        if (this.f7218t > 0) {
            return;
        }
        int i5 = i - min;
        int length = (this.f7220wz + i5) - this.f7219tl.length;
        ByteBuffer t2 = t(length);
        int p2 = j5.p(length, 0, this.f7220wz);
        t2.put(this.f7219tl, 0, p2);
        int p3 = j5.p(length - p2, 0, i5);
        byteBuffer.limit(byteBuffer.position() + p3);
        t2.put(byteBuffer);
        byteBuffer.limit(limit);
        int i6 = i5 - p3;
        int i8 = this.f7220wz - p2;
        this.f7220wz = i8;
        byte[] bArr = this.f7219tl;
        System.arraycopy(bArr, p2, bArr, 0, i8);
        byteBuffer.get(this.f7219tl, this.f7220wz, i6);
        this.f7220wz += i6;
        t2.flip();
    }

    @Override // d9.c
    public void f() {
        this.f7219tl = j5.f14357a;
    }

    @Override // d9.c, d9.fb
    public ByteBuffer fb() {
        int i;
        if (super.a() && (i = this.f7220wz) > 0) {
            t(i).put(this.f7219tl, 0, this.f7220wz).flip();
            this.f7220wz = 0;
        }
        return super.fb();
    }

    @Override // d9.c
    public void gv() {
        if (this.f7216f) {
            this.f7216f = false;
            int i = this.f7217i9;
            int i5 = this.f6983n3.f7037gv;
            this.f7219tl = new byte[i * i5];
            this.f7218t = this.f7215c5 * i5;
        }
        this.f7220wz = 0;
    }

    public long tl() {
        return this.f7221xc;
    }

    @Override // d9.c
    public void v() {
        int i;
        if (this.f7216f) {
            if (this.f7220wz > 0) {
                this.f7221xc += i / this.f6983n3.f7037gv;
            }
            this.f7220wz = 0;
        }
    }

    public void wz() {
        this.f7221xc = 0L;
    }

    public void xc(int i, int i5) {
        this.f7215c5 = i;
        this.f7217i9 = i5;
    }

    @Override // d9.c
    public fb.y zn(fb.y yVar) throws fb.n3 {
        if (yVar.f7039zn == 2) {
            this.f7216f = true;
            if (this.f7215c5 == 0 && this.f7217i9 == 0) {
                return fb.y.f7036v;
            }
            return yVar;
        }
        throw new fb.n3(yVar);
    }
}
