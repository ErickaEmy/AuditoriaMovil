package d9;

import androidx.annotation.Nullable;
import d9.fb;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class d0 extends c {
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public int[] f6989c5;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public int[] f6990i9;

    @Override // d9.fb
    public void c5(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) v5.y.v(this.f6990i9);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer t2 = t(((limit - position) / this.f6983n3.f7037gv) * this.f6986zn.f7037gv);
        while (position < limit) {
            for (int i : iArr) {
                t2.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.f6983n3.f7037gv;
        }
        byteBuffer.position(limit);
        t2.flip();
    }

    @Override // d9.c
    public void f() {
        this.f6990i9 = null;
        this.f6989c5 = null;
    }

    @Override // d9.c
    public void gv() {
        this.f6990i9 = this.f6989c5;
    }

    public void tl(@Nullable int[] iArr) {
        this.f6989c5 = iArr;
    }

    @Override // d9.c
    public fb.y zn(fb.y yVar) throws fb.n3 {
        boolean z2;
        boolean z3;
        int[] iArr = this.f6989c5;
        if (iArr == null) {
            return fb.y.f7036v;
        }
        if (yVar.f7039zn == 2) {
            if (yVar.f7038n3 != iArr.length) {
                z2 = true;
            } else {
                z2 = false;
            }
            for (int i = 0; i < iArr.length; i++) {
                int i5 = iArr[i];
                if (i5 < yVar.f7038n3) {
                    if (i5 != i) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z2 |= z3;
                } else {
                    throw new fb.n3(yVar);
                }
            }
            if (z2) {
                return new fb.y(yVar.y, iArr.length, 2);
            }
            return fb.y.f7036v;
        }
        throw new fb.n3(yVar);
    }
}
