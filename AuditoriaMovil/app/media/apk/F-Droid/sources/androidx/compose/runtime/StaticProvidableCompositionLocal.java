package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public final class StaticProvidableCompositionLocal extends ProvidableCompositionLocal {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticProvidableCompositionLocal(Function0 defaultFactory) {
        super(defaultFactory);
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public State provided$runtime_release(Object obj, Composer composer, int i) {
        composer.startReplaceableGroup(-1121811719);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1121811719, i, -1, "androidx.compose.runtime.StaticProvidableCompositionLocal.provided (CompositionLocal.kt:139)");
        }
        StaticValueHolder staticValueHolder = new StaticValueHolder(obj);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return staticValueHolder;
    }
}
