package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class Transition {
    private final SnapshotStateList _animations;
    private final SnapshotStateList _transitions;
    private final MutableState isSeeking$delegate;
    private final String label;
    private long lastSeekedTimeNanos;
    private final MutableLongState playTimeNanos$delegate;
    private final MutableState segment$delegate;
    private final MutableLongState startTimeNanos$delegate;
    private final MutableState targetState$delegate;
    private final State totalDurationNanos$delegate;
    private final MutableTransitionState transitionState;
    private final MutableState updateChildrenNeeded$delegate;

    public final String getLabel() {
        return this.label;
    }

    public final long getLastSeekedTimeNanos$animation_core_release() {
        return this.lastSeekedTimeNanos;
    }

    /* compiled from: Transition.kt */
    /* loaded from: classes.dex */
    public final class TransitionAnimationState implements State {
        private final MutableState animation$delegate;
        private final MutableState animationSpec$delegate;
        private final FiniteAnimationSpec interruptionSpec;
        private final MutableState isFinished$delegate;
        private final String label;
        private final MutableState needsReset$delegate;
        private final MutableLongState offsetTimeNanos$delegate;
        private final MutableState targetValue$delegate;
        final /* synthetic */ Transition this$0;
        private final TwoWayConverter typeConverter;
        private final MutableState value$delegate;
        private AnimationVector velocityVector;

        private final long getOffsetTimeNanos() {
            return this.offsetTimeNanos$delegate.getLongValue();
        }

        private final boolean getNeedsReset() {
            return ((Boolean) this.needsReset$delegate.getValue()).booleanValue();
        }

        private final Object getTargetValue() {
            return this.targetValue$delegate.getValue();
        }

        public final TargetBasedAnimation getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        public final FiniteAnimationSpec getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec$delegate.getValue();
        }

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.value$delegate.getValue();
        }

        public final boolean isFinished$animation_core_release() {
            return ((Boolean) this.isFinished$delegate.getValue()).booleanValue();
        }

        private final void setAnimation(TargetBasedAnimation targetBasedAnimation) {
            this.animation$delegate.setValue(targetBasedAnimation);
        }

        private final void setAnimationSpec(FiniteAnimationSpec finiteAnimationSpec) {
            this.animationSpec$delegate.setValue(finiteAnimationSpec);
        }

        private final void setTargetValue(Object obj) {
            this.targetValue$delegate.setValue(obj);
        }

        public void setValue$animation_core_release(Object obj) {
            this.value$delegate.setValue(obj);
        }

        private final void setOffsetTimeNanos(long j) {
            this.offsetTimeNanos$delegate.setLongValue(j);
        }

        public TransitionAnimationState(Transition transition, Object obj, AnimationVector initialVelocityVector, TwoWayConverter typeConverter, String label) {
            MutableState mutableStateOf$default;
            MutableState mutableStateOf$default2;
            MutableState mutableStateOf$default3;
            MutableState mutableStateOf$default4;
            MutableState mutableStateOf$default5;
            MutableState mutableStateOf$default6;
            Object obj2;
            Intrinsics.checkNotNullParameter(initialVelocityVector, "initialVelocityVector");
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(label, "label");
            this.this$0 = transition;
            this.typeConverter = typeConverter;
            this.label = label;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
            this.targetValue$delegate = mutableStateOf$default;
            mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), null, 2, null);
            this.animationSpec$delegate = mutableStateOf$default2;
            mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), typeConverter, obj, getTargetValue(), initialVelocityVector), null, 2, null);
            this.animation$delegate = mutableStateOf$default3;
            mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            this.isFinished$delegate = mutableStateOf$default4;
            this.offsetTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(0L);
            mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            this.needsReset$delegate = mutableStateOf$default5;
            mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
            this.value$delegate = mutableStateOf$default6;
            this.velocityVector = initialVelocityVector;
            Float f = (Float) VisibilityThresholdsKt.getVisibilityThresholdMap().get(typeConverter);
            if (f != null) {
                float floatValue = f.floatValue();
                AnimationVector animationVector = (AnimationVector) typeConverter.getConvertToVector().invoke(obj);
                int size$animation_core_release = animationVector.getSize$animation_core_release();
                for (int i = 0; i < size$animation_core_release; i++) {
                    animationVector.set$animation_core_release(i, floatValue);
                }
                obj2 = this.typeConverter.getConvertFromVector().invoke(animationVector);
            } else {
                obj2 = null;
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, obj2, 3, null);
        }

        public final void setFinished$animation_core_release(boolean z) {
            this.isFinished$delegate.setValue(Boolean.valueOf(z));
        }

        private final void setNeedsReset(boolean z) {
            this.needsReset$delegate.setValue(Boolean.valueOf(z));
        }

        public final long getDurationNanos$animation_core_release() {
            return getAnimation().getDurationNanos();
        }

        public final void onPlayTimeChanged$animation_core_release(long j, float f) {
            long durationNanos;
            if (f > 0.0f) {
                float offsetTimeNanos = ((float) (j - getOffsetTimeNanos())) / f;
                if (!(!Float.isNaN(offsetTimeNanos))) {
                    throw new IllegalStateException(("Duration scale adjusted time is NaN. Duration scale: " + f + ",playTimeNanos: " + j + ", offsetTimeNanos: " + getOffsetTimeNanos()).toString());
                }
                durationNanos = offsetTimeNanos;
            } else {
                durationNanos = getAnimation().getDurationNanos();
            }
            setValue$animation_core_release(getAnimation().getValueFromNanos(durationNanos));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(durationNanos);
            if (getAnimation().isFinishedFromNanos(durationNanos)) {
                setFinished$animation_core_release(true);
                setOffsetTimeNanos(0L);
            }
        }

        public final void seekTo$animation_core_release(long j) {
            setValue$animation_core_release(getAnimation().getValueFromNanos(j));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(j);
        }

        static /* synthetic */ void updateAnimation$default(TransitionAnimationState transitionAnimationState, Object obj, boolean z, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i & 2) != 0) {
                z = false;
            }
            transitionAnimationState.updateAnimation(obj, z);
        }

        private final void updateAnimation(Object obj, boolean z) {
            FiniteAnimationSpec animationSpec;
            if (z) {
                animationSpec = getAnimationSpec() instanceof SpringSpec ? getAnimationSpec() : this.interruptionSpec;
            } else {
                animationSpec = getAnimationSpec();
            }
            setAnimation(new TargetBasedAnimation(animationSpec, this.typeConverter, obj, getTargetValue(), this.velocityVector));
            this.this$0.onChildAnimationUpdated();
        }

        public final void resetAnimation$animation_core_release() {
            setNeedsReset(true);
        }

        public final void updateTargetValue$animation_core_release(Object obj, FiniteAnimationSpec animationSpec) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            if (!Intrinsics.areEqual(getTargetValue(), obj) || getNeedsReset()) {
                setTargetValue(obj);
                setAnimationSpec(animationSpec);
                updateAnimation$default(this, null, !isFinished$animation_core_release(), 1, null);
                setFinished$animation_core_release(false);
                setOffsetTimeNanos(this.this$0.getPlayTimeNanos());
                setNeedsReset(false);
            }
        }

        public final void updateInitialAndTargetValue$animation_core_release(Object obj, Object obj2, FiniteAnimationSpec animationSpec) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            setTargetValue(obj2);
            setAnimationSpec(animationSpec);
            if (Intrinsics.areEqual(getAnimation().getInitialValue(), obj) && Intrinsics.areEqual(getAnimation().getTargetValue(), obj2)) {
                return;
            }
            updateAnimation$default(this, obj, false, 2, null);
        }
    }

    private final long getStartTimeNanos() {
        return this.startTimeNanos$delegate.getLongValue();
    }

    public final long getPlayTimeNanos() {
        return this.playTimeNanos$delegate.getLongValue();
    }

    /* compiled from: Transition.kt */
    /* loaded from: classes.dex */
    public final class DeferredAnimation {
        private final MutableState data$delegate;
        private final String label;
        final /* synthetic */ Transition this$0;
        private final TwoWayConverter typeConverter;

        public final DeferredAnimationData getData$animation_core_release() {
            return (DeferredAnimationData) this.data$delegate.getValue();
        }

        public final void setData$animation_core_release(DeferredAnimationData deferredAnimationData) {
            this.data$delegate.setValue(deferredAnimationData);
        }

        public DeferredAnimation(Transition transition, TwoWayConverter typeConverter, String label) {
            MutableState mutableStateOf$default;
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(label, "label");
            this.this$0 = transition;
            this.typeConverter = typeConverter;
            this.label = label;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            this.data$delegate = mutableStateOf$default;
        }

        /* compiled from: Transition.kt */
        /* loaded from: classes.dex */
        public final class DeferredAnimationData implements State {
            private final TransitionAnimationState animation;
            private Function1 targetValueByState;
            final /* synthetic */ DeferredAnimation this$0;
            private Function1 transitionSpec;

            public final TransitionAnimationState getAnimation() {
                return this.animation;
            }

            public final Function1 getTargetValueByState() {
                return this.targetValueByState;
            }

            public final Function1 getTransitionSpec() {
                return this.transitionSpec;
            }

            public final void setTargetValueByState(Function1 function1) {
                Intrinsics.checkNotNullParameter(function1, "<set-?>");
                this.targetValueByState = function1;
            }

            public final void setTransitionSpec(Function1 function1) {
                Intrinsics.checkNotNullParameter(function1, "<set-?>");
                this.transitionSpec = function1;
            }

            public DeferredAnimationData(DeferredAnimation deferredAnimation, TransitionAnimationState animation, Function1 transitionSpec, Function1 targetValueByState) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Intrinsics.checkNotNullParameter(transitionSpec, "transitionSpec");
                Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
                this.this$0 = deferredAnimation;
                this.animation = animation;
                this.transitionSpec = transitionSpec;
                this.targetValueByState = targetValueByState;
            }

            public final void updateAnimationStates(Segment segment) {
                Intrinsics.checkNotNullParameter(segment, "segment");
                Object invoke = this.targetValueByState.invoke(segment.getTargetState());
                if (this.this$0.this$0.isSeeking()) {
                    this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), invoke, (FiniteAnimationSpec) this.transitionSpec.invoke(segment));
                    return;
                }
                this.animation.updateTargetValue$animation_core_release(invoke, (FiniteAnimationSpec) this.transitionSpec.invoke(segment));
            }

            @Override // androidx.compose.runtime.State
            public Object getValue() {
                updateAnimationStates(this.this$0.this$0.getSegment());
                return this.animation.getValue();
            }
        }

        public final State animate(Function1 transitionSpec, Function1 targetValueByState) {
            Intrinsics.checkNotNullParameter(transitionSpec, "transitionSpec");
            Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
            DeferredAnimationData data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release == null) {
                Transition transition = this.this$0;
                data$animation_core_release = new DeferredAnimationData(this, new TransitionAnimationState(transition, targetValueByState.invoke(transition.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, targetValueByState.invoke(this.this$0.getCurrentState())), this.typeConverter, this.label), transitionSpec, targetValueByState);
                Transition transition2 = this.this$0;
                setData$animation_core_release(data$animation_core_release);
                transition2.addAnimation$animation_core_release(data$animation_core_release.getAnimation());
            }
            Transition transition3 = this.this$0;
            data$animation_core_release.setTargetValueByState(targetValueByState);
            data$animation_core_release.setTransitionSpec(transitionSpec);
            data$animation_core_release.updateAnimationStates(transition3.getSegment());
            return data$animation_core_release;
        }

        public final void setupSeeking$animation_core_release() {
            DeferredAnimationData data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release != null) {
                Transition transition = this.this$0;
                data$animation_core_release.getAnimation().updateInitialAndTargetValue$animation_core_release(data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getInitialState()), data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getTargetState()), (FiniteAnimationSpec) data$animation_core_release.getTransitionSpec().invoke(transition.getSegment()));
            }
        }
    }

    public final Segment getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos$delegate.getValue()).longValue();
    }

    public final boolean getUpdateChildrenNeeded$animation_core_release() {
        return ((Boolean) this.updateChildrenNeeded$delegate.getValue()).booleanValue();
    }

    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    private final void setSegment(Segment segment) {
        this.segment$delegate.setValue(segment);
    }

    public final void setTargetState$animation_core_release(Object obj) {
        this.targetState$delegate.setValue(obj);
    }

    private final void setStartTimeNanos(long j) {
        this.startTimeNanos$delegate.setLongValue(j);
    }

    public final void setPlayTimeNanos(long j) {
        this.playTimeNanos$delegate.setLongValue(j);
    }

    public Transition(MutableTransitionState transitionState, String str) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        Intrinsics.checkNotNullParameter(transitionState, "transitionState");
        this.transitionState = transitionState;
        this.label = str;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getCurrentState(), null, 2, null);
        this.targetState$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), null, 2, null);
        this.segment$delegate = mutableStateOf$default2;
        this.playTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.startTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(Long.MIN_VALUE);
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.updateChildrenNeeded$delegate = mutableStateOf$default3;
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isSeeking$delegate = mutableStateOf$default4;
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.animation.core.Transition$totalDurationNanos$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                SnapshotStateList<Transition.TransitionAnimationState> snapshotStateList;
                SnapshotStateList<Transition> snapshotStateList2;
                snapshotStateList = Transition.this._animations;
                long j = 0;
                for (Transition.TransitionAnimationState transitionAnimationState : snapshotStateList) {
                    j = Math.max(j, transitionAnimationState.getDurationNanos$animation_core_release());
                }
                snapshotStateList2 = Transition.this._transitions;
                for (Transition transition : snapshotStateList2) {
                    j = Math.max(j, transition.getTotalDurationNanos());
                }
                return Long.valueOf(j);
            }
        });
    }

    public Transition(Object obj, String str) {
        this(new MutableTransitionState(obj), str);
    }

    public final Object getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    public final void setCurrentState$animation_core_release(Object obj) {
        this.transitionState.setCurrentState$animation_core_release(obj);
    }

    public final boolean isRunning() {
        return getStartTimeNanos() != Long.MIN_VALUE;
    }

    public final void setUpdateChildrenNeeded$animation_core_release(boolean z) {
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setSeeking$animation_core_release(boolean z) {
        this.isSeeking$delegate.setValue(Boolean.valueOf(z));
    }

    public final void onFrame$animation_core_release(long j, float f) {
        if (getStartTimeNanos() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(j);
        }
        setUpdateChildrenNeeded$animation_core_release(false);
        setPlayTimeNanos(j - getStartTimeNanos());
        boolean z = true;
        for (TransitionAnimationState transitionAnimationState : this._animations) {
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                transitionAnimationState.onPlayTimeChanged$animation_core_release(getPlayTimeNanos(), f);
            }
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                z = false;
            }
        }
        for (Transition transition : this._transitions) {
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.onFrame$animation_core_release(getPlayTimeNanos(), f);
            }
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                z = false;
            }
        }
        if (z) {
            onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionStart$animation_core_release(long j) {
        setStartTimeNanos(j);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void onTransitionEnd$animation_core_release() {
        setStartTimeNanos(Long.MIN_VALUE);
        setCurrentState$animation_core_release(getTargetState());
        setPlayTimeNanos(0L);
        this.transitionState.setRunning$animation_core_release(false);
    }

    public final void seek(Object obj, Object obj2, long j) {
        setStartTimeNanos(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (!isSeeking() || !Intrinsics.areEqual(getCurrentState(), obj) || !Intrinsics.areEqual(getTargetState(), obj2)) {
            setCurrentState$animation_core_release(obj);
            setTargetState$animation_core_release(obj2);
            setSeeking$animation_core_release(true);
            setSegment(new SegmentImpl(obj, obj2));
        }
        for (Transition transition : this._transitions) {
            Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (transition.isSeeking()) {
                transition.seek(transition.getCurrentState(), transition.getTargetState(), j);
            }
        }
        for (TransitionAnimationState transitionAnimationState : this._animations) {
            transitionAnimationState.seekTo$animation_core_release(j);
        }
        this.lastSeekedTimeNanos = j;
    }

    public final boolean addTransition$animation_core_release(Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        return this._transitions.add(transition);
    }

    public final boolean removeTransition$animation_core_release(Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        return this._transitions.remove(transition);
    }

    public final boolean addAnimation$animation_core_release(TransitionAnimationState animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        return this._animations.add(animation);
    }

    public final void removeAnimation$animation_core_release(TransitionAnimationState animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this._animations.remove(animation);
    }

    public final void updateTarget$animation_core_release(final Object obj, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-583974681);
        int i2 = (i & 14) == 0 ? (startRestartGroup.changed(obj) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-583974681, i, -1, "androidx.compose.animation.core.Transition.updateTarget (Transition.kt:400)");
            }
            if (!isSeeking() && !Intrinsics.areEqual(getTargetState(), obj)) {
                setSegment(new SegmentImpl(getTargetState(), obj));
                setCurrentState$animation_core_release(getTargetState());
                setTargetState$animation_core_release(obj);
                if (!isRunning()) {
                    setUpdateChildrenNeeded$animation_core_release(true);
                }
                for (TransitionAnimationState transitionAnimationState : this._animations) {
                    transitionAnimationState.resetAnimation$animation_core_release();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.core.Transition$updateTarget$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                Transition.this.updateTarget$animation_core_release(obj, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public final void animateTo$animation_core_release(final Object obj, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1493585151);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493585151, i2, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:425)");
            }
            if (!isSeeking()) {
                updateTarget$animation_core_release(obj, startRestartGroup, (i2 & 14) | (i2 & 112));
                if (!Intrinsics.areEqual(obj, getCurrentState()) || isRunning() || getUpdateChildrenNeeded$animation_core_release()) {
                    int i3 = (i2 >> 3) & 14;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed(this);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Transition$animateTo$1$1(this, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(this, (Function2) rememberedValue, startRestartGroup, i3 | 64);
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.core.Transition$animateTo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                Transition.this.animateTo$animation_core_release(obj, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded$animation_core_release(true);
        if (isSeeking()) {
            long j = 0;
            for (TransitionAnimationState transitionAnimationState : this._animations) {
                j = Math.max(j, transitionAnimationState.getDurationNanos$animation_core_release());
                transitionAnimationState.seekTo$animation_core_release(this.lastSeekedTimeNanos);
            }
            setUpdateChildrenNeeded$animation_core_release(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Transition.kt */
    /* loaded from: classes.dex */
    public static final class SegmentImpl implements Segment {
        private final Object initialState;
        private final Object targetState;

        @Override // androidx.compose.animation.core.Transition.Segment
        public Object getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public Object getTargetState() {
            return this.targetState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public /* synthetic */ boolean isTransitioningTo(Object obj, Object obj2) {
            return Segment.CC.$default$isTransitioningTo(this, obj, obj2);
        }

        public SegmentImpl(Object obj, Object obj2) {
            this.initialState = obj;
            this.targetState = obj2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Segment) {
                Segment segment = (Segment) obj;
                if (Intrinsics.areEqual(getInitialState(), segment.getInitialState()) && Intrinsics.areEqual(getTargetState(), segment.getTargetState())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object initialState = getInitialState();
            int hashCode = (initialState != null ? initialState.hashCode() : 0) * 31;
            Object targetState = getTargetState();
            return hashCode + (targetState != null ? targetState.hashCode() : 0);
        }
    }

    /* compiled from: Transition.kt */
    /* loaded from: classes.dex */
    public interface Segment {
        Object getInitialState();

        Object getTargetState();

        boolean isTransitioningTo(Object obj, Object obj2);

        /* compiled from: Transition.kt */
        /* renamed from: androidx.compose.animation.core.Transition$Segment$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public abstract /* synthetic */ class CC {
            public static boolean $default$isTransitioningTo(Segment segment, Object obj, Object obj2) {
                return Intrinsics.areEqual(obj, segment.getInitialState()) && Intrinsics.areEqual(obj2, segment.getTargetState());
            }
        }
    }

    public final void removeAnimation$animation_core_release(DeferredAnimation deferredAnimation) {
        TransitionAnimationState animation;
        Intrinsics.checkNotNullParameter(deferredAnimation, "deferredAnimation");
        DeferredAnimation.DeferredAnimationData data$animation_core_release = deferredAnimation.getData$animation_core_release();
        if (data$animation_core_release == null || (animation = data$animation_core_release.getAnimation()) == null) {
            return;
        }
        removeAnimation$animation_core_release(animation);
    }
}
