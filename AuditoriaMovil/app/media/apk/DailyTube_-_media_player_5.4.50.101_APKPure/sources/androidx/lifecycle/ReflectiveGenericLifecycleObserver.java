package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.n3;
import androidx.lifecycle.v;
import y5.co;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements a {

    /* renamed from: v  reason: collision with root package name */
    public final n3.y f2601v;
    public final Object y;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.y = obj;
        this.f2601v = n3.f2638zn.zn(obj.getClass());
    }

    @Override // androidx.lifecycle.a
    public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
        this.f2601v.y(coVar, n3Var, this.y);
    }
}
