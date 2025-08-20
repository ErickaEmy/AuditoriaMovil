package d9;

import d9.fb;
import java.nio.ByteBuffer;
import v5.j5;
/* loaded from: classes.dex */
public final class d extends c {

    /* renamed from: c5  reason: collision with root package name */
    public static final int f6988c5 = Float.floatToIntBits(Float.NaN);

    public static void tl(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i * 4.656612875245797E-10d));
        if (floatToIntBits == f6988c5) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // d9.fb
    public void c5(ByteBuffer byteBuffer) {
        ByteBuffer t2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i5 = this.f6983n3.f7039zn;
        if (i5 != 536870912) {
            if (i5 == 805306368) {
                t2 = t(i);
                while (position < limit) {
                    tl((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), t2);
                    position += 4;
                }
            } else {
                throw new IllegalStateException();
            }
        } else {
            t2 = t((i / 3) * 4);
            while (position < limit) {
                tl(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), t2);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        t2.flip();
    }

    @Override // d9.c
    public fb.y zn(fb.y yVar) throws fb.n3 {
        int i = yVar.f7039zn;
        if (j5.g(i)) {
            if (i != 4) {
                return new fb.y(yVar.y, yVar.f7038n3, 4);
            }
            return fb.y.f7036v;
        }
        throw new fb.n3(yVar);
    }
}
