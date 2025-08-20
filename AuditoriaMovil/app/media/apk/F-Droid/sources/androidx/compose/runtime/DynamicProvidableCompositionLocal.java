package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public final class DynamicProvidableCompositionLocal extends ProvidableCompositionLocal {
    private final SnapshotMutationPolicy policy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicProvidableCompositionLocal(SnapshotMutationPolicy policy, Function0 defaultFactory) {
        super(defaultFactory);
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        this.policy = policy;
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public State provided$runtime_release(Object obj, Composer composer, int i) {
        composer.startReplaceableGroup(-84026900);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-84026900, i, -1, "androidx.compose.runtime.DynamicProvidableCompositionLocal.provided (CompositionLocal.kt:125)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf(obj, this.policy);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        mutableState.setValue(obj);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
