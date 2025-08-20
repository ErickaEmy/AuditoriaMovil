package qh;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class s extends a9.i9<wz, xc, f> implements i9 {

    /* renamed from: wz  reason: collision with root package name */
    public final String f12912wz;

    /* loaded from: classes.dex */
    public class y extends xc {
        public y() {
        }

        @Override // a9.s
        public void p() {
            s.this.mt(this);
        }
    }

    public s(String str) {
        super(new wz[2], new xc[2]);
        this.f12912wz = str;
        r(1024);
    }

    public abstract c5 c(byte[] bArr, int i, boolean z2) throws f;

    @Override // a9.i9
    @Nullable
    /* renamed from: d0 */
    public final f i9(wz wzVar, xc xcVar, boolean z2) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) v5.y.v(wzVar.f56fb);
            xcVar.mt(wzVar.f55f, c(byteBuffer.array(), byteBuffer.limit(), z2), wzVar.f12924co);
            xcVar.fb(Integer.MIN_VALUE);
            return null;
        } catch (f e2) {
            return e2;
        }
    }

    @Override // a9.i9
    /* renamed from: f3 */
    public final xc s() {
        return new y();
    }

    @Override // a9.i9
    /* renamed from: i4 */
    public final wz fb() {
        return new wz();
    }

    @Override // a9.i9
    /* renamed from: n */
    public final f c5(Throwable th) {
        return new f("Unexpected decode error", th);
    }

    @Override // qh.i9
    public void y(long j2) {
    }
}
