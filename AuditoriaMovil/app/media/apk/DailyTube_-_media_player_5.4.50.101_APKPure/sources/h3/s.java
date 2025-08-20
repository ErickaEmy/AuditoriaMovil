package h3;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class s extends a9.fb {

    /* renamed from: co  reason: collision with root package name */
    public long f8446co;

    /* renamed from: r  reason: collision with root package name */
    public int f8447r;

    /* renamed from: z  reason: collision with root package name */
    public int f8448z;

    public s() {
        super(2);
        this.f8447r = 32;
    }

    @Override // a9.fb, a9.y
    public void a() {
        super.a();
        this.f8448z = 0;
    }

    public long c() {
        return this.f8446co;
    }

    public int d0() {
        return this.f8448z;
    }

    public final boolean f3(a9.fb fbVar) {
        ByteBuffer byteBuffer;
        if (!fh()) {
            return true;
        }
        if (this.f8448z >= this.f8447r || fbVar.f() != f()) {
            return false;
        }
        ByteBuffer byteBuffer2 = fbVar.f56fb;
        if (byteBuffer2 == null || (byteBuffer = this.f56fb) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000) {
            return true;
        }
        return false;
    }

    public boolean fh() {
        if (this.f8448z > 0) {
            return true;
        }
        return false;
    }

    public boolean i4(a9.fb fbVar) {
        v5.y.y(!fbVar.z());
        v5.y.y(!fbVar.c5());
        v5.y.y(!fbVar.t());
        if (!f3(fbVar)) {
            return false;
        }
        int i = this.f8448z;
        this.f8448z = i + 1;
        if (i == 0) {
            this.f55f = fbVar.f55f;
            if (fbVar.wz()) {
                w(1);
            }
        }
        if (fbVar.f()) {
            w(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = fbVar.f56fb;
        if (byteBuffer != null) {
            mt(byteBuffer.remaining());
            this.f56fb.put(byteBuffer);
        }
        this.f8446co = fbVar.f55f;
        return true;
    }

    public long n() {
        return this.f55f;
    }

    public void rz(int i) {
        boolean z2;
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f8447r = i;
    }
}
