package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CreationExtras.kt */
/* loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this(null, 1, null);
    }

    public MutableCreationExtras(CreationExtras initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(initialExtras.getMap$lifecycle_viewmodel_release());
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    public final void set(CreationExtras.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        getMap$lifecycle_viewmodel_release().put(key, obj);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    public Object get(CreationExtras.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getMap$lifecycle_viewmodel_release().get(key);
    }
}
