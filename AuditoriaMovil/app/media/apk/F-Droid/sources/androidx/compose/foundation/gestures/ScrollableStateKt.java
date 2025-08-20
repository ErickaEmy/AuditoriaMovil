package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ScrollableState.kt */
/* loaded from: classes.dex */
public abstract class ScrollableStateKt {
    public static final ScrollableState ScrollableState(Function1 consumeScrollDelta) {
        Intrinsics.checkNotNullParameter(consumeScrollDelta, "consumeScrollDelta");
        return new DefaultScrollableState(consumeScrollDelta);
    }

    public static final ScrollableState rememberScrollableState(Function1 consumeScrollDelta, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(consumeScrollDelta, "consumeScrollDelta");
        composer.startReplaceableGroup(-180460798);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-180460798, i, -1, "androidx.compose.foundation.gestures.rememberScrollableState (ScrollableState.kt:143)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(consumeScrollDelta, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = ScrollableState(new Function1() { // from class: androidx.compose.foundation.gestures.ScrollableStateKt$rememberScrollableState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final Float invoke(float f) {
                    return (Float) ((Function1) State.this.getValue()).invoke(Float.valueOf(f));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).floatValue());
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ScrollableState scrollableState = (ScrollableState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scrollableState;
    }
}
