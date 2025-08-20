package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class SpringSpec implements FiniteAnimationSpec {
    private final float dampingRatio;
    private final float stiffness;
    private final Object visibilityThreshold;

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public final Object getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    public SpringSpec(float f, float f2, Object obj) {
        this.dampingRatio = f;
        this.stiffness = f2;
        this.visibilityThreshold = obj;
    }

    public /* synthetic */ SpringSpec(float f, float f2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1500.0f : f2, (i & 4) != 0 ? null : obj);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public VectorizedSpringSpec vectorize(TwoWayConverter converter) {
        AnimationVector convert;
        Intrinsics.checkNotNullParameter(converter, "converter");
        float f = this.dampingRatio;
        float f2 = this.stiffness;
        convert = AnimationSpecKt.convert(converter, this.visibilityThreshold);
        return new VectorizedSpringSpec(f, f2, convert);
    }

    public boolean equals(Object obj) {
        if (obj instanceof SpringSpec) {
            SpringSpec springSpec = (SpringSpec) obj;
            return springSpec.dampingRatio == this.dampingRatio && springSpec.stiffness == this.stiffness && Intrinsics.areEqual(springSpec.visibilityThreshold, this.visibilityThreshold);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.visibilityThreshold;
        return ((((obj != null ? obj.hashCode() : 0) * 31) + Float.floatToIntBits(this.dampingRatio)) * 31) + Float.floatToIntBits(this.stiffness);
    }
}
