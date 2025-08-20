package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.v;
import y5.c;
import y5.co;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements a {
    public final zn[] y;

    public CompositeGeneratedAdaptersObserver(zn[] znVarArr) {
        this.y = znVarArr;
    }

    @Override // androidx.lifecycle.a
    public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
        c cVar = new c();
        for (zn znVar : this.y) {
            znVar.y(coVar, n3Var, false, cVar);
        }
        for (zn znVar2 : this.y) {
            znVar2.y(coVar, n3Var, true, cVar);
        }
    }
}
