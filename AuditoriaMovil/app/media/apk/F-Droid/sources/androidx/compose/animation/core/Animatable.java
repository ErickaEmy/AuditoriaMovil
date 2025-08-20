package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Animatable.kt */
/* loaded from: classes.dex */
public final class Animatable {
    private final SpringSpec defaultSpringSpec;
    private final AnimationState internalState;
    private final MutableState isRunning$delegate;
    private final String label;
    private AnimationVector lowerBoundVector;
    private final MutatorMutex mutatorMutex;
    private final AnimationVector negativeInfinityBounds;
    private final AnimationVector positiveInfinityBounds;
    private final MutableState targetValue$delegate;
    private final TwoWayConverter typeConverter;
    private AnimationVector upperBoundVector;
    private final Object visibilityThreshold;

    public final State asState() {
        return this.internalState;
    }

    public final AnimationState getInternalState$animation_core_release() {
        return this.internalState;
    }

    public final TwoWayConverter getTypeConverter() {
        return this.typeConverter;
    }

    public Animatable(Object obj, TwoWayConverter typeConverter, Object obj2, String label) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(label, "label");
        this.typeConverter = typeConverter;
        this.visibilityThreshold = obj2;
        this.label = label;
        this.internalState = new AnimationState(typeConverter, obj, null, 0L, 0L, false, 60, null);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isRunning$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.targetValue$delegate = mutableStateOf$default2;
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec(0.0f, 0.0f, obj2, 3, null);
        AnimationVector createVector = createVector(obj, Float.NEGATIVE_INFINITY);
        this.negativeInfinityBounds = createVector;
        AnimationVector createVector2 = createVector(obj, Float.POSITIVE_INFINITY);
        this.positiveInfinityBounds = createVector2;
        this.lowerBoundVector = createVector;
        this.upperBoundVector = createVector2;
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, twoWayConverter, (i & 4) != 0 ? null : obj2, (i & 8) != 0 ? "Animatable" : str);
    }

    public final Object getValue() {
        return this.internalState.getValue();
    }

    public final Object getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final AnimationVector getVelocityVector() {
        return this.internalState.getVelocityVector();
    }

    public final Object getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRunning(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTargetValue(Object obj) {
        this.targetValue$delegate.setValue(obj);
    }

    private final AnimationVector createVector(Object obj, float f) {
        AnimationVector animationVector = (AnimationVector) this.typeConverter.getConvertToVector().invoke(obj);
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            animationVector.set$animation_core_release(i, f);
        }
        return animationVector;
    }

    public static /* synthetic */ Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, Object obj2, Function1 function1, Continuation continuation, int i, Object obj3) {
        if ((i & 2) != 0) {
            animationSpec = animatable.defaultSpringSpec;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            obj2 = animatable.getVelocity();
        }
        Object obj4 = obj2;
        if ((i & 8) != 0) {
            function1 = null;
        }
        return animatable.animateTo(obj, animationSpec2, obj4, function1, continuation);
    }

    public final Object animateTo(Object obj, AnimationSpec animationSpec, Object obj2, Function1 function1, Continuation continuation) {
        return runAnimation(AnimationKt.TargetBasedAnimation(animationSpec, this.typeConverter, getValue(), obj, obj2), obj2, function1, continuation);
    }

    private final Object runAnimation(Animation animation, Object obj, Function1 function1, Continuation continuation) {
        return MutatorMutex.mutate$default(this.mutatorMutex, null, new Animatable$runAnimation$2(this, obj, animation, this.internalState.getLastFrameTimeNanos(), function1, null), continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object clampToBounds(Object obj) {
        float coerceIn;
        if (Intrinsics.areEqual(this.lowerBoundVector, this.negativeInfinityBounds) && Intrinsics.areEqual(this.upperBoundVector, this.positiveInfinityBounds)) {
            return obj;
        }
        AnimationVector animationVector = (AnimationVector) this.typeConverter.getConvertToVector().invoke(obj);
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        boolean z = false;
        for (int i = 0; i < size$animation_core_release; i++) {
            if (animationVector.get$animation_core_release(i) < this.lowerBoundVector.get$animation_core_release(i) || animationVector.get$animation_core_release(i) > this.upperBoundVector.get$animation_core_release(i)) {
                coerceIn = RangesKt___RangesKt.coerceIn(animationVector.get$animation_core_release(i), this.lowerBoundVector.get$animation_core_release(i), this.upperBoundVector.get$animation_core_release(i));
                animationVector.set$animation_core_release(i, coerceIn);
                z = true;
            }
        }
        return z ? this.typeConverter.getConvertFromVector().invoke(animationVector) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAnimation() {
        AnimationState animationState = this.internalState;
        animationState.getVelocityVector().reset$animation_core_release();
        animationState.setLastFrameTimeNanos$animation_core_release(Long.MIN_VALUE);
        setRunning(false);
    }

    public final Object snapTo(Object obj, Continuation continuation) {
        Object coroutine_suspended;
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new Animatable$snapTo$2(this, obj, null), continuation, 1, null);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return mutate$default == coroutine_suspended ? mutate$default : Unit.INSTANCE;
    }
}
