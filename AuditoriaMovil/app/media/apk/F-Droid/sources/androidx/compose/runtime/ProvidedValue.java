package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class ProvidedValue {
    private final boolean canOverride;
    private final CompositionLocal compositionLocal;
    private final Object value;

    public final boolean getCanOverride() {
        return this.canOverride;
    }

    public final CompositionLocal getCompositionLocal() {
        return this.compositionLocal;
    }

    public final Object getValue() {
        return this.value;
    }

    public ProvidedValue(CompositionLocal compositionLocal, Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(compositionLocal, "compositionLocal");
        this.compositionLocal = compositionLocal;
        this.value = obj;
        this.canOverride = z;
    }
}
