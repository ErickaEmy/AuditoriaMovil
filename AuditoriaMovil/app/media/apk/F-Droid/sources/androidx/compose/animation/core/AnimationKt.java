package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Animation.kt */
/* loaded from: classes.dex */
public abstract class AnimationKt {
    public static final long getDurationMillis(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "<this>");
        return animation.getDurationNanos() / 1000000;
    }

    public static final TargetBasedAnimation TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter typeConverter, Object obj, Object obj2, Object obj3) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        return new TargetBasedAnimation(animationSpec, typeConverter, obj, obj2, (AnimationVector) typeConverter.getConvertToVector().invoke(obj3));
    }
}
