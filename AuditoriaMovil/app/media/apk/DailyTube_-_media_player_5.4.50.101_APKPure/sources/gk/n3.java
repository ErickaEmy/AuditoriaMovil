package gk;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import m1.hk;
import m1.m;
import m1.p;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class n3 extends m1.a {

    /* renamed from: c  reason: collision with root package name */
    public final a9.fb f8304c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public y f8305d;

    /* renamed from: d0  reason: collision with root package name */
    public final rz f8306d0;

    /* renamed from: ej  reason: collision with root package name */
    public long f8307ej;

    /* renamed from: fh  reason: collision with root package name */
    public long f8308fh;

    public n3() {
        super(6);
        this.f8304c = new a9.fb(1);
        this.f8306d0 = new rz();
    }

    @Override // m1.zq
    public boolean a() {
        return c5();
    }

    @Override // m1.a
    public void b(m[] mVarArr, long j2, long j4) {
        this.f8308fh = j4;
    }

    @Override // m1.a
    public void d() {
        j5();
    }

    @Override // m1.a
    public void ej(long j2, boolean z2) {
        this.f8307ej = Long.MIN_VALUE;
        j5();
    }

    @Override // m1.zq, m1.k3
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Nullable
    public final float[] hw(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f8306d0.o(byteBuffer.array(), byteBuffer.limit());
        this.f8306d0.oz(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.f8306d0.r());
        }
        return fArr;
    }

    @Override // m1.zq
    public boolean isReady() {
        return true;
    }

    public final void j5() {
        y yVar = this.f8305d;
        if (yVar != null) {
            yVar.zn();
        }
    }

    @Override // m1.k3
    public int n3(m mVar) {
        if ("application/x-camera-motion".equals(mVar.f10948f3)) {
            return hk.y(4);
        }
        return hk.y(0);
    }

    @Override // m1.a, m1.c8.n3
    public void tl(int i, @Nullable Object obj) throws p {
        if (i == 8) {
            this.f8305d = (y) obj;
        } else {
            super.tl(i, obj);
        }
    }

    @Override // m1.zq
    public void z(long j2, long j4) {
        while (!c5() && this.f8307ej < 100000 + j2) {
            this.f8304c.a();
            if (k5(d0(), this.f8304c, 0) == -4 && !this.f8304c.t()) {
                a9.fb fbVar = this.f8304c;
                this.f8307ej = fbVar.f55f;
                if (this.f8305d != null && !fbVar.f()) {
                    this.f8304c.co();
                    float[] hw2 = hw((ByteBuffer) j5.i9(this.f8304c.f56fb));
                    if (hw2 != null) {
                        ((y) j5.i9(this.f8305d)).n3(this.f8307ej - this.f8308fh, hw2);
                    }
                }
            } else {
                return;
            }
        }
    }
}
