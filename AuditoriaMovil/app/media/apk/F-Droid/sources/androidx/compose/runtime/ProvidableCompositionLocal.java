package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public abstract class ProvidableCompositionLocal extends CompositionLocal {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableCompositionLocal(Function0 defaultFactory) {
        super(defaultFactory, null);
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
    }

    public final ProvidedValue provides(Object obj) {
        return new ProvidedValue(this, obj, true);
    }

    public final ProvidedValue providesDefault(Object obj) {
        return new ProvidedValue(this, obj, false);
    }
}
