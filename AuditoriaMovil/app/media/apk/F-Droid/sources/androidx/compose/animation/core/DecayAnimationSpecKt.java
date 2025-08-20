package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: DecayAnimationSpec.kt */
/* loaded from: classes.dex */
public abstract class DecayAnimationSpecKt {
    public static final DecayAnimationSpec generateDecayAnimationSpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        Intrinsics.checkNotNullParameter(floatDecayAnimationSpec, "<this>");
        return new DecayAnimationSpecImpl(floatDecayAnimationSpec);
    }
}
