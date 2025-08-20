package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InfiniteTransition.kt */
/* loaded from: classes.dex */
public abstract class InfiniteTransitionKt {
    public static final InfiniteTransition rememberInfiniteTransition(String str, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1013651573);
        if ((i2 & 1) != 0) {
            str = "InfiniteTransition";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1013651573, i, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new InfiniteTransition(str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        InfiniteTransition infiniteTransition = (InfiniteTransition) rememberedValue;
        infiniteTransition.run$animation_core_release(composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return infiniteTransition;
    }

    public static final State animateValue(final InfiniteTransition infiniteTransition, final Object obj, final Object obj2, TwoWayConverter typeConverter, final InfiniteRepeatableSpec animationSpec, String str, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(infiniteTransition, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        composer.startReplaceableGroup(-1062847727);
        String str2 = (i2 & 16) != 0 ? "ValueAnimation" : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1062847727, i, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:254)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Object obj3 = rememberedValue;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            InfiniteTransition.TransitionAnimationState transitionAnimationState = new InfiniteTransition.TransitionAnimationState(infiniteTransition, obj, obj2, typeConverter, animationSpec, str2);
            composer.updateRememberedValue(transitionAnimationState);
            obj3 = transitionAnimationState;
        }
        composer.endReplaceableGroup();
        final InfiniteTransition.TransitionAnimationState transitionAnimationState2 = (InfiniteTransition.TransitionAnimationState) obj3;
        EffectsKt.SideEffect(new Function0() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m33invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m33invoke() {
                if (Intrinsics.areEqual(obj, transitionAnimationState2.getInitialValue$animation_core_release()) && Intrinsics.areEqual(obj2, transitionAnimationState2.getTargetValue$animation_core_release())) {
                    return;
                }
                transitionAnimationState2.updateValues$animation_core_release(obj, obj2, animationSpec);
            }
        }, composer, 0);
        EffectsKt.DisposableEffect(transitionAnimationState2, new Function1() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                InfiniteTransition.this.addAnimation$animation_core_release(transitionAnimationState2);
                final InfiniteTransition infiniteTransition2 = InfiniteTransition.this;
                final InfiniteTransition.TransitionAnimationState transitionAnimationState3 = transitionAnimationState2;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        InfiniteTransition.this.removeAnimation$animation_core_release(transitionAnimationState3);
                    }
                };
            }
        }, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transitionAnimationState2;
    }

    public static final State animateFloat(InfiniteTransition infiniteTransition, float f, float f2, InfiniteRepeatableSpec animationSpec, String str, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(infiniteTransition, "<this>");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        composer.startReplaceableGroup(-644770905);
        String str2 = (i2 & 8) != 0 ? "FloatAnimation" : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-644770905, i, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:310)");
        }
        int i3 = i << 3;
        State animateValue = animateValue(infiniteTransition, Float.valueOf(f), Float.valueOf(f2), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), animationSpec, str2, composer, (i & 112) | 8 | (i & 896) | (57344 & i3) | (i3 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValue;
    }
}
