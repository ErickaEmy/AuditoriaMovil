package androidx.compose.animation.core;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Animatable.kt */
/* loaded from: classes.dex */
public final class AnimationResult {
    private final AnimationEndReason endReason;
    private final AnimationState endState;

    public AnimationResult(AnimationState endState, AnimationEndReason endReason) {
        Intrinsics.checkNotNullParameter(endState, "endState");
        Intrinsics.checkNotNullParameter(endReason, "endReason");
        this.endState = endState;
        this.endReason = endReason;
    }

    public String toString() {
        return "AnimationResult(endReason=" + this.endReason + ", endState=" + this.endState + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
