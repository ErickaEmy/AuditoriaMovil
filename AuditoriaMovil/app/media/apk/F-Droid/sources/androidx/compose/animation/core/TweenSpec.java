package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class TweenSpec implements DurationBasedAnimationSpec {
    private final int delay;
    private final int durationMillis;
    private final Easing easing;

    public TweenSpec(int i, int i2, Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.durationMillis = i;
        this.delay = i2;
        this.easing = easing;
    }

    public /* synthetic */ TweenSpec(int i, int i2, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public VectorizedTweenSpec vectorize(TwoWayConverter converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        return new VectorizedTweenSpec(this.durationMillis, this.delay, this.easing);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TweenSpec) {
            TweenSpec tweenSpec = (TweenSpec) obj;
            return tweenSpec.durationMillis == this.durationMillis && tweenSpec.delay == this.delay && Intrinsics.areEqual(tweenSpec.easing, this.easing);
        }
        return false;
    }

    public int hashCode() {
        return (((this.durationMillis * 31) + this.easing.hashCode()) * 31) + this.delay;
    }
}
