package pc1;

import java.io.IOException;
import kc1.rz;
import kc1.x4;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y implements x4 {
    public static final y y = new y();

    @Override // kc1.x4
    public rz intercept(x4.y chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        qc1.fb fbVar = (qc1.fb) chain;
        return qc1.fb.v(fbVar, 0, fbVar.a().co(fbVar), null, 0, 0, 0, 61, null).n3(fbVar.i9());
    }
}
