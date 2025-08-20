package f5;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import hd.a;
import hd.gv;
import java.nio.ByteBuffer;
import java.util.Arrays;
import v5.rz;
/* loaded from: classes.dex */
public final class y extends a {
    @Override // hd.a
    public Metadata n3(gv gvVar, ByteBuffer byteBuffer) {
        return new Metadata(zn(new rz(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage zn(rz rzVar) {
        return new EventMessage((String) v5.y.v(rzVar.fh()), (String) v5.y.v(rzVar.fh()), rzVar.d0(), rzVar.d0(), Arrays.copyOfRange(rzVar.v(), rzVar.a(), rzVar.fb()));
    }
}
