package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
/* compiled from: Elevation.kt */
/* loaded from: classes.dex */
public abstract class ElevationKt {
    private static final TweenSpec DefaultIncomingSpec = new TweenSpec(120, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final TweenSpec DefaultOutgoingSpec = new TweenSpec(150, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, null);
    private static final TweenSpec HoveredOutgoingSpec = new TweenSpec(120, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, null);

    /* renamed from: animateElevation-rAjV9yQ  reason: not valid java name */
    public static final Object m488animateElevationrAjV9yQ(Animatable animatable, float f, Interaction interaction, Interaction interaction2, Continuation continuation) {
        AnimationSpec outgoingAnimationSpecForInteraction;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (interaction2 != null) {
            outgoingAnimationSpecForInteraction = ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(interaction2);
        } else {
            outgoingAnimationSpecForInteraction = interaction != null ? ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(interaction) : null;
        }
        AnimationSpec animationSpec = outgoingAnimationSpecForInteraction;
        if (animationSpec != null) {
            Object animateTo$default = Animatable.animateTo$default(animatable, Dp.m1895boximpl(f), animationSpec, null, null, continuation, 12, null);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return animateTo$default == coroutine_suspended2 ? animateTo$default : Unit.INSTANCE;
        }
        Object snapTo = animatable.snapTo(Dp.m1895boximpl(f), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return snapTo == coroutine_suspended ? snapTo : Unit.INSTANCE;
    }
}
