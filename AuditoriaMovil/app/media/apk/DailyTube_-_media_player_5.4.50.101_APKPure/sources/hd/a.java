package hd;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class a implements n3 {
    @Nullable
    public abstract Metadata n3(gv gvVar, ByteBuffer byteBuffer);

    @Override // hd.n3
    @Nullable
    public final Metadata y(gv gvVar) {
        boolean z2;
        ByteBuffer byteBuffer = (ByteBuffer) v5.y.v(gvVar.f56fb);
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (gvVar.f()) {
            return null;
        }
        return n3(gvVar, byteBuffer);
    }
}
