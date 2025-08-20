package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SnapshotState.kt */
/* loaded from: classes.dex */
public abstract /* synthetic */ class SnapshotStateKt__SnapshotStateKt {
    public static /* synthetic */ MutableState mutableStateOf$default(Object obj, SnapshotMutationPolicy snapshotMutationPolicy, int i, Object obj2) {
        if ((i & 2) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return SnapshotStateKt.mutableStateOf(obj, snapshotMutationPolicy);
    }

    public static final MutableState mutableStateOf(Object obj, SnapshotMutationPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        return ActualAndroid_androidKt.createSnapshotMutableState(obj, policy);
    }

    public static final SnapshotStateList mutableStateListOf() {
        return new SnapshotStateList();
    }

    public static final SnapshotStateMap mutableStateMapOf() {
        return new SnapshotStateMap();
    }

    public static final State rememberUpdatedState(Object obj, Composer composer, int i) {
        composer.startReplaceableGroup(-1058319986);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1058319986, i, -1, "androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:303)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = mutableStateOf$default(obj, null, 2, null);
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
