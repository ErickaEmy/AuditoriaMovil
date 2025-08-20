package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.v;
import y5.co;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements a {
    public final zn y;

    public SingleGeneratedAdapterObserver(zn znVar) {
        this.y = znVar;
    }

    @Override // androidx.lifecycle.a
    public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
        this.y.y(coVar, n3Var, false, null);
        this.y.y(coVar, n3Var, true, null);
    }
}
