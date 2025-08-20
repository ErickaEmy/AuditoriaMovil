package androidx.compose.runtime.saveable;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
/* compiled from: RememberSaveable.kt */
/* loaded from: classes.dex */
public abstract class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    public static final Object rememberSaveable(Object[] inputs, Saver saver, final String str, Function0 init, Composer composer, int i, int i2) {
        int checkRadix;
        Object consumeRestored;
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        Intrinsics.checkNotNullParameter(init, "init");
        composer.startReplaceableGroup(441892779);
        if ((i2 & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        Object obj = null;
        if ((i2 & 4) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441892779, i, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:65)");
        }
        composer.startReplaceableGroup(1059366469);
        if (str == null || str.length() == 0) {
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            checkRadix = CharsKt__CharJVMKt.checkRadix(MaxSupportedRadix);
            str = Integer.toString(currentCompositeKeyHash, checkRadix);
            Intrinsics.checkNotNullExpressionValue(str, "toString(this, checkRadix(radix))");
        }
        composer.endReplaceableGroup();
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        Object[] copyOf = Arrays.copyOf(inputs, inputs.length);
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (Object obj2 : copyOf) {
            z |= composer.changed(obj2);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            if (saveableStateRegistry != null && (consumeRestored = saveableStateRegistry.consumeRestored(str)) != null) {
                obj = saver.restore(consumeRestored);
            }
            rememberedValue = obj == null ? init.invoke() : obj;
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        if (saveableStateRegistry != null) {
            final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(saver, composer, 0);
            final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(rememberedValue, composer, 0);
            EffectsKt.DisposableEffect(saveableStateRegistry, str, new Function1() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final State state = rememberUpdatedState;
                    final State state2 = rememberUpdatedState2;
                    final SaveableStateRegistry saveableStateRegistry2 = SaveableStateRegistry.this;
                    Function0 function0 = new Function0() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$valueProvider$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Object value = State.this.getValue();
                            State state3 = state2;
                            final SaveableStateRegistry saveableStateRegistry3 = saveableStateRegistry2;
                            return ((Saver) value).save(new SaverScope() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1
                                @Override // androidx.compose.runtime.saveable.SaverScope
                                public final boolean canBeSaved(Object it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return SaveableStateRegistry.this.canBeSaved(it);
                                }
                            }, state3.getValue());
                        }
                    };
                    RememberSaveableKt.requireCanBeSaved(SaveableStateRegistry.this, function0.invoke());
                    final SaveableStateRegistry.Entry registerProvider = SaveableStateRegistry.this.registerProvider(str, function0);
                    return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            SaveableStateRegistry.Entry.this.unregister();
                        }
                    };
                }
            }, composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberedValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry saveableStateRegistry, Object obj) {
        String str;
        if (obj == null || saveableStateRegistry.canBeSaved(obj)) {
            return;
        }
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.getPolicy() == SnapshotStateKt.neverEqualPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.structuralEqualityPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                str = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
            } else {
                str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
            }
        } else {
            str = obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
        }
        throw new IllegalArgumentException(str);
    }
}
