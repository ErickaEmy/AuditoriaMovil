package androidx.compose.animation.core;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public abstract class AnimationSpecKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationVector convert(TwoWayConverter twoWayConverter, Object obj) {
        if (obj == null) {
            return null;
        }
        return (AnimationVector) twoWayConverter.getConvertToVector().invoke(obj);
    }

    public static /* synthetic */ TweenSpec tween$default(int i, int i2, Easing easing, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 300;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            easing = EasingKt.getFastOutSlowInEasing();
        }
        return tween(i, i2, easing);
    }

    public static final TweenSpec tween(int i, int i2, Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        return new TweenSpec(i, i2, easing);
    }

    public static /* synthetic */ SpringSpec spring$default(float f, float f2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1500.0f;
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        return spring(f, f2, obj);
    }

    public static final SpringSpec spring(float f, float f2, Object obj) {
        return new SpringSpec(f, f2, obj);
    }

    public static final KeyframesSpec keyframes(Function1 init) {
        Intrinsics.checkNotNullParameter(init, "init");
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        init.invoke(keyframesSpecConfig);
        return new KeyframesSpec(keyframesSpecConfig);
    }

    /* renamed from: infiniteRepeatable-9IiC70o$default  reason: not valid java name */
    public static /* synthetic */ InfiniteRepeatableSpec m31infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i & 4) != 0) {
            j = StartOffset.m40constructorimpl$default(0, 0, 2, null);
        }
        return m30infiniteRepeatable9IiC70o(durationBasedAnimationSpec, repeatMode, j);
    }

    /* renamed from: infiniteRepeatable-9IiC70o  reason: not valid java name */
    public static final InfiniteRepeatableSpec m30infiniteRepeatable9IiC70o(DurationBasedAnimationSpec animation, RepeatMode repeatMode, long j) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(repeatMode, "repeatMode");
        return new InfiniteRepeatableSpec(animation, repeatMode, j, null);
    }
}
