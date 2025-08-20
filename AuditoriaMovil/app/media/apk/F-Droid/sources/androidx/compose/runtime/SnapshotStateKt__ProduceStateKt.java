package androidx.compose.runtime;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProduceState.kt */
/* loaded from: classes.dex */
public abstract /* synthetic */ class SnapshotStateKt__ProduceStateKt {
    public static final State produceState(Object obj, Object obj2, Object obj3, Function2 producer, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(producer, "producer");
        composer.startReplaceableGroup(-1703169085);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1703169085, i, -1, "androidx.compose.runtime.produceState (ProduceState.kt:141)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect(obj2, obj3, new SnapshotStateKt__ProduceStateKt$produceState$3(producer, mutableState, null), composer, 584);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
