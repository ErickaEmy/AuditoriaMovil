package androidx.compose.runtime;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValueHolders.kt */
/* loaded from: classes.dex */
public final class LazyValueHolder implements State {
    private final Lazy current$delegate;

    public LazyValueHolder(Function0 valueProducer) {
        Intrinsics.checkNotNullParameter(valueProducer, "valueProducer");
        this.current$delegate = LazyKt.lazy(valueProducer);
    }

    private final Object getCurrent() {
        return this.current$delegate.getValue();
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return getCurrent();
    }
}
