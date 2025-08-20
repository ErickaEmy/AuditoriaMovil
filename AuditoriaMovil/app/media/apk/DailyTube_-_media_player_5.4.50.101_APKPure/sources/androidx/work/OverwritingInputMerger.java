package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.n3;
import java.util.HashMap;
import java.util.List;
import l.c5;
/* loaded from: classes.dex */
public final class OverwritingInputMerger extends c5 {
    @Override // l.c5
    @NonNull
    public n3 n3(@NonNull List<n3> list) {
        n3.y yVar = new n3.y();
        HashMap hashMap = new HashMap();
        for (n3 n3Var : list) {
            hashMap.putAll(n3Var.s());
        }
        yVar.gv(hashMap);
        return yVar.y();
    }
}
