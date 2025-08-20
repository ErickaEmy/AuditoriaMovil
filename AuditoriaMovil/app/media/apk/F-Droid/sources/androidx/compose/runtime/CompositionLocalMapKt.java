package androidx.compose.runtime;

import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionLocalMap.kt */
/* loaded from: classes.dex */
public abstract class CompositionLocalMapKt {
    public static final boolean contains(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal key) {
        Intrinsics.checkNotNullParameter(persistentCompositionLocalMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return persistentCompositionLocalMap.containsKey(key);
    }

    public static final Object getValueOf(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal key) {
        Intrinsics.checkNotNullParameter(persistentCompositionLocalMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        State state = (State) persistentCompositionLocalMap.get((Object) key);
        if (state != null) {
            return state.getValue();
        }
        return null;
    }

    public static final Object read(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal key) {
        Intrinsics.checkNotNullParameter(persistentCompositionLocalMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (contains(persistentCompositionLocalMap, key)) {
            return getValueOf(persistentCompositionLocalMap, key);
        }
        return key.getDefaultValueHolder$runtime_release().getValue();
    }

    public static final PersistentCompositionLocalMap compositionLocalMapOf(ProvidedValue[] values, PersistentCompositionLocalMap parentScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        composer.startReplaceableGroup(-300354947);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-300354947, i, -1, "androidx.compose.runtime.compositionLocalMapOf (CompositionLocalMap.kt:91)");
        }
        PersistentCompositionLocalMap.Builder builder = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf().builder();
        for (ProvidedValue providedValue : values) {
            composer.startReplaceableGroup(680845765);
            if (providedValue.getCanOverride() || !contains(parentScope, providedValue.getCompositionLocal())) {
                CompositionLocal compositionLocal = providedValue.getCompositionLocal();
                Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
                builder.put(compositionLocal, providedValue.getCompositionLocal().provided$runtime_release(providedValue.getValue(), composer, 8));
            }
            composer.endReplaceableGroup();
        }
        PersistentCompositionLocalMap build = builder.build();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return build;
    }
}
