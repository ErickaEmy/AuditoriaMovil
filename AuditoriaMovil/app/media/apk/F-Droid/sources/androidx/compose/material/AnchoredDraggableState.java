package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.material.AnchoredDragScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public final class AnchoredDraggableState {
    public static final Companion Companion = new Companion(null);
    private final AnchoredDragScope anchoredDragScope;
    private final MutableState anchors$delegate;
    private final AnimationSpec animationSpec;
    private final MutableState animationTarget$delegate;
    private final State closestValue$delegate;
    private final Function1 confirmValueChange;
    private final MutableState currentValue$delegate;
    private final InternalMutatorMutex dragMutex;
    private final DraggableState draggableState;
    private final MutableFloatState lastVelocity$delegate;
    private final State maxOffset$delegate;
    private final State minOffset$delegate;
    private final MutableState offset$delegate;
    private final Function1 positionalThreshold;
    private final State progress$delegate;
    private final State targetValue$delegate;
    private final Function0 velocityThreshold;

    /* compiled from: AnchoredDraggable.kt */
    /* loaded from: classes.dex */
    public interface AnchorChangedCallback {
        void onAnchorsChanged(Object obj, Map map, Map map2);
    }

    /* compiled from: AnchoredDraggable.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final AnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function1 getConfirmValueChange$material_release() {
        return this.confirmValueChange;
    }

    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    public final Object getAnimationTarget() {
        return this.animationTarget$delegate.getValue();
    }

    public final Map getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final Object getClosestValue$material_release() {
        return this.closestValue$delegate.getValue();
    }

    public final Object getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final float getMaxOffset() {
        return ((Number) this.maxOffset$delegate.getValue()).floatValue();
    }

    public final float getMinOffset() {
        return ((Number) this.minOffset$delegate.getValue()).floatValue();
    }

    public final float getOffset() {
        return ((Number) this.offset$delegate.getValue()).floatValue();
    }

    public final Object getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final void setAnimationTarget(Object obj) {
        this.animationTarget$delegate.setValue(obj);
    }

    public final void setCurrentValue(Object obj) {
        this.currentValue$delegate.setValue(obj);
    }

    public final void setAnchors$material_release(Map map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setFloatValue(f);
    }

    public AnchoredDraggableState(Object obj, Function1 positionalThreshold, Function0 velocityThreshold, AnimationSpec animationSpec, Function1 confirmValueChange) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        Map emptyMap;
        MutableState mutableStateOf$default4;
        Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
        Intrinsics.checkNotNullParameter(velocityThreshold, "velocityThreshold");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        this.positionalThreshold = positionalThreshold;
        this.velocityThreshold = velocityThreshold;
        this.animationSpec = animationSpec;
        this.confirmValueChange = confirmValueChange;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.currentValue$delegate = mutableStateOf$default;
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.AnchoredDraggableState$targetValue$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object animationTarget;
                Object computeTarget;
                animationTarget = AnchoredDraggableState.this.getAnimationTarget();
                if (animationTarget == null) {
                    AnchoredDraggableState anchoredDraggableState = AnchoredDraggableState.this;
                    float offset = anchoredDraggableState.getOffset();
                    if (!Float.isNaN(offset)) {
                        computeTarget = anchoredDraggableState.computeTarget(offset, anchoredDraggableState.getCurrentValue(), 0.0f);
                        return computeTarget;
                    }
                    return anchoredDraggableState.getCurrentValue();
                }
                return animationTarget;
            }
        });
        this.closestValue$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.AnchoredDraggableState$closestValue$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object animationTarget;
                Object computeTargetWithoutThresholds;
                animationTarget = AnchoredDraggableState.this.getAnimationTarget();
                if (animationTarget == null) {
                    AnchoredDraggableState anchoredDraggableState = AnchoredDraggableState.this;
                    float offset = anchoredDraggableState.getOffset();
                    if (!Float.isNaN(offset)) {
                        computeTargetWithoutThresholds = anchoredDraggableState.computeTargetWithoutThresholds(offset, anchoredDraggableState.getCurrentValue());
                        return computeTargetWithoutThresholds;
                    }
                    return anchoredDraggableState.getCurrentValue();
                }
                return animationTarget;
            }
        });
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(Float.NaN), null, 2, null);
        this.offset$delegate = mutableStateOf$default2;
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material.AnchoredDraggableState$progress$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float f = (Float) AnchoredDraggableState.this.getAnchors$material_release().get(AnchoredDraggableState.this.getCurrentValue());
                float f2 = 0.0f;
                float floatValue = f != null ? f.floatValue() : 0.0f;
                Float f3 = (Float) AnchoredDraggableState.this.getAnchors$material_release().get(AnchoredDraggableState.this.getClosestValue$material_release());
                float floatValue2 = (f3 != null ? f3.floatValue() : 0.0f) - floatValue;
                if (Math.abs(floatValue2) > 1.0E-6f) {
                    float requireOffset = (AnchoredDraggableState.this.requireOffset() - floatValue) / floatValue2;
                    if (requireOffset >= 1.0E-6f) {
                        if (requireOffset <= 0.999999f) {
                            f2 = requireOffset;
                        }
                    }
                    return Float.valueOf(f2);
                }
                f2 = 1.0f;
                return Float.valueOf(f2);
            }
        });
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.minOffset$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.AnchoredDraggableState$minOffset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float minOrNull;
                minOrNull = AnchoredDraggableKt.minOrNull(AnchoredDraggableState.this.getAnchors$material_release());
                return Float.valueOf(minOrNull != null ? minOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxOffset$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.AnchoredDraggableState$maxOffset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float maxOrNull;
                maxOrNull = AnchoredDraggableKt.maxOrNull(AnchoredDraggableState.this.getAnchors$material_release());
                return Float.valueOf(maxOrNull != null ? maxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animationTarget$delegate = mutableStateOf$default3;
        emptyMap = MapsKt__MapsKt.emptyMap();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(emptyMap, null, 2, null);
        this.anchors$delegate = mutableStateOf$default4;
        this.anchoredDragScope = new AnchoredDragScope() { // from class: androidx.compose.material.AnchoredDraggableState$anchoredDragScope$1
            @Override // androidx.compose.material.AnchoredDragScope
            public void dragTo(float f, float f2) {
                AnchoredDraggableState.this.setOffset(f);
                AnchoredDraggableState.this.setLastVelocity(f2);
            }
        };
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, Function1 function1, Function0 function0, AnimationSpec animationSpec, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function1, function0, (i & 8) != 0 ? AnchoredDraggableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 16) != 0 ? new Function1() { // from class: androidx.compose.material.AnchoredDraggableState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj2) {
                return Boolean.TRUE;
            }
        } : function12);
    }

    public final void setOffset(float f) {
        this.offset$delegate.setValue(Float.valueOf(f));
    }

    public final float requireOffset() {
        if (!(!Float.isNaN(getOffset()))) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
        }
        return getOffset();
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    public static /* synthetic */ void updateAnchors$material_release$default(AnchoredDraggableState anchoredDraggableState, Map map, AnchorChangedCallback anchorChangedCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            anchorChangedCallback = null;
        }
        anchoredDraggableState.updateAnchors$material_release(map, anchorChangedCallback);
    }

    public final void updateAnchors$material_release(Map newAnchors, AnchorChangedCallback anchorChangedCallback) {
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        if (Intrinsics.areEqual(getAnchors$material_release(), newAnchors)) {
            return;
        }
        Map anchors$material_release = getAnchors$material_release();
        Object targetValue = getTargetValue();
        boolean isEmpty = getAnchors$material_release().isEmpty();
        setAnchors$material_release(newAnchors);
        boolean z = getAnchors$material_release().get(getCurrentValue()) != null;
        if (isEmpty && z) {
            trySnapTo$material_release(getCurrentValue());
        } else if (anchorChangedCallback != null) {
            anchorChangedCallback.onAnchorsChanged(targetValue, anchors$material_release, newAnchors);
        }
    }

    public final Object settle(float f, Continuation continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object currentValue = getCurrentValue();
        Object computeTarget = computeTarget(requireOffset(), currentValue, f);
        if (((Boolean) this.confirmValueChange.invoke(computeTarget)).booleanValue()) {
            Object animateTo = AnchoredDraggableKt.animateTo(this, computeTarget, f, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return animateTo == coroutine_suspended2 ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = AnchoredDraggableKt.animateTo(this, currentValue, f, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return animateTo2 == coroutine_suspended ? animateTo2 : Unit.INSTANCE;
    }

    public final Object computeTarget(float f, Object obj, float f2) {
        Object closestAnchor;
        Object value;
        Object closestAnchor2;
        Object value2;
        Object closestAnchor3;
        Map anchors$material_release = getAnchors$material_release();
        Float f3 = (Float) anchors$material_release.get(obj);
        float floatValue = ((Number) this.velocityThreshold.invoke()).floatValue();
        if (Intrinsics.areEqual(f3, f) || f3 == null) {
            return obj;
        }
        if (f3.floatValue() < f) {
            if (f2 >= floatValue) {
                closestAnchor3 = AnchoredDraggableKt.closestAnchor(anchors$material_release, f, true);
                return closestAnchor3;
            }
            closestAnchor = AnchoredDraggableKt.closestAnchor(anchors$material_release, f, true);
            value2 = MapsKt__MapsKt.getValue(anchors$material_release, closestAnchor);
            if (f < Math.abs(f3.floatValue() + Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(Math.abs(((Number) value2).floatValue() - f3.floatValue())))).floatValue()))) {
                return obj;
            }
        } else if (f2 <= (-floatValue)) {
            closestAnchor2 = AnchoredDraggableKt.closestAnchor(anchors$material_release, f, false);
            return closestAnchor2;
        } else {
            closestAnchor = AnchoredDraggableKt.closestAnchor(anchors$material_release, f, false);
            float floatValue2 = f3.floatValue();
            value = MapsKt__MapsKt.getValue(anchors$material_release, closestAnchor);
            float abs = Math.abs(f3.floatValue() - Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(Math.abs(floatValue2 - ((Number) value).floatValue())))).floatValue()));
            if (f < 0.0f) {
                if (Math.abs(f) < abs) {
                    return obj;
                }
            } else if (f > abs) {
                return obj;
            }
        }
        return closestAnchor;
    }

    public final Object computeTargetWithoutThresholds(float f, Object obj) {
        Object closestAnchor;
        Object closestAnchor2;
        Map anchors$material_release = getAnchors$material_release();
        Float f2 = (Float) anchors$material_release.get(obj);
        if (Intrinsics.areEqual(f2, f) || f2 == null) {
            return obj;
        }
        if (f2.floatValue() < f) {
            closestAnchor2 = AnchoredDraggableKt.closestAnchor(anchors$material_release, f, true);
            return closestAnchor2;
        }
        closestAnchor = AnchoredDraggableKt.closestAnchor(anchors$material_release, f, false);
        return closestAnchor;
    }

    public final Object anchoredDrag(MutatePriority mutatePriority, Function3 function3, Continuation continuation) {
        Object coroutine_suspended;
        Object doAnchoredDrag = doAnchoredDrag(null, mutatePriority, function3, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return doAnchoredDrag == coroutine_suspended ? doAnchoredDrag : Unit.INSTANCE;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function3, continuation);
    }

    public final Object anchoredDrag(Object obj, MutatePriority mutatePriority, Function3 function3, Continuation continuation) {
        Object coroutine_suspended;
        Object doAnchoredDrag = doAnchoredDrag(obj, mutatePriority, function3, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return doAnchoredDrag == coroutine_suspended ? doAnchoredDrag : Unit.INSTANCE;
    }

    private final Object doAnchoredDrag(Object obj, MutatePriority mutatePriority, Function3 function3, Continuation continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnchoredDraggableState$doAnchoredDrag$2(obj, this, mutatePriority, function3, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    public final float newOffsetForDelta$material_release(float f) {
        float coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + f, getMinOffset(), getMaxOffset());
        return coerceIn;
    }

    public final boolean trySnapTo$material_release(final Object obj) {
        return this.dragMutex.tryMutate(new Function0() { // from class: androidx.compose.material.AnchoredDraggableState$trySnapTo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m426invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m426invoke() {
                AnchoredDragScope anchoredDragScope;
                anchoredDragScope = AnchoredDraggableState.this.anchoredDragScope;
                AnchoredDraggableState anchoredDraggableState = AnchoredDraggableState.this;
                Object obj2 = obj;
                Float f = (Float) anchoredDraggableState.getAnchors$material_release().get(obj2);
                if (f != null) {
                    AnchoredDragScope.CC.dragTo$default(anchoredDragScope, f.floatValue(), 0.0f, 2, null);
                    anchoredDraggableState.setAnimationTarget(null);
                }
                anchoredDraggableState.setCurrentValue(obj2);
            }
        });
    }
}
