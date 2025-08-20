package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: DecayAnimationSpec.kt */
/* loaded from: classes.dex */
final class DecayAnimationSpecImpl implements DecayAnimationSpec {
    private final FloatDecayAnimationSpec floatDecaySpec;

    public DecayAnimationSpecImpl(FloatDecayAnimationSpec floatDecaySpec) {
        Intrinsics.checkNotNullParameter(floatDecaySpec, "floatDecaySpec");
        this.floatDecaySpec = floatDecaySpec;
    }

    @Override // androidx.compose.animation.core.DecayAnimationSpec
    public VectorizedDecayAnimationSpec vectorize(TwoWayConverter typeConverter) {
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        return new VectorizedFloatDecaySpec(this.floatDecaySpec);
    }
}
