package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InfiniteTransition.kt */
/* loaded from: classes.dex */
public final class InfiniteTransition {
    public static final int $stable = 8;
    private final MutableVector _animations;
    private final MutableState isRunning$delegate;
    private final String label;
    private final MutableState refreshChildNeeded$delegate;
    private long startTimeNanos;

    public InfiniteTransition(String label) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this._animations = new MutableVector(new TransitionAnimationState[16], 0);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.refreshChildNeeded$delegate = mutableStateOf$default;
        this.startTimeNanos = Long.MIN_VALUE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.isRunning$delegate = mutableStateOf$default2;
    }

    /* compiled from: InfiniteTransition.kt */
    /* loaded from: classes.dex */
    public final class TransitionAnimationState implements State {
        private TargetBasedAnimation animation;
        private AnimationSpec animationSpec;
        private Object initialValue;
        private boolean isFinished;
        private final String label;
        private long playTimeNanosOffset;
        private boolean startOnTheNextFrame;
        private Object targetValue;
        final /* synthetic */ InfiniteTransition this$0;
        private final TwoWayConverter typeConverter;
        private final MutableState value$delegate;

        public final Object getInitialValue$animation_core_release() {
            return this.initialValue;
        }

        public final Object getTargetValue$animation_core_release() {
            return this.targetValue;
        }

        public final boolean isFinished$animation_core_release() {
            return this.isFinished;
        }

        public final void reset$animation_core_release() {
            this.startOnTheNextFrame = true;
        }

        public TransitionAnimationState(InfiniteTransition infiniteTransition, Object obj, Object obj2, TwoWayConverter typeConverter, AnimationSpec animationSpec, String label) {
            MutableState mutableStateOf$default;
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(label, "label");
            this.this$0 = infiniteTransition;
            this.initialValue = obj;
            this.targetValue = obj2;
            this.typeConverter = typeConverter;
            this.label = label;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
            this.value$delegate = mutableStateOf$default;
            this.animationSpec = animationSpec;
            this.animation = new TargetBasedAnimation(this.animationSpec, typeConverter, this.initialValue, this.targetValue, null, 16, null);
        }

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.value$delegate.getValue();
        }

        public void setValue$animation_core_release(Object obj) {
            this.value$delegate.setValue(obj);
        }

        public final void updateValues$animation_core_release(Object obj, Object obj2, AnimationSpec animationSpec) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            this.initialValue = obj;
            this.targetValue = obj2;
            this.animationSpec = animationSpec;
            this.animation = new TargetBasedAnimation(animationSpec, this.typeConverter, obj, obj2, null, 16, null);
            this.this$0.setRefreshChildNeeded(true);
            this.isFinished = false;
            this.startOnTheNextFrame = true;
        }

        public final void onPlayTimeChanged$animation_core_release(long j) {
            this.this$0.setRefreshChildNeeded(false);
            if (this.startOnTheNextFrame) {
                this.startOnTheNextFrame = false;
                this.playTimeNanosOffset = j;
            }
            long j2 = j - this.playTimeNanosOffset;
            setValue$animation_core_release(this.animation.getValueFromNanos(j2));
            this.isFinished = this.animation.isFinishedFromNanos(j2);
        }

        public final void skipToEnd$animation_core_release() {
            setValue$animation_core_release(this.animation.getTargetValue());
            this.startOnTheNextFrame = true;
        }
    }

    private final boolean getRefreshChildNeeded() {
        return ((Boolean) this.refreshChildNeeded$delegate.getValue()).booleanValue();
    }

    private final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRefreshChildNeeded(boolean z) {
        this.refreshChildNeeded$delegate.setValue(Boolean.valueOf(z));
    }

    private final void setRunning(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }

    public final void addAnimation$animation_core_release(TransitionAnimationState animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this._animations.add(animation);
        setRefreshChildNeeded(true);
    }

    public final void removeAnimation$animation_core_release(TransitionAnimationState animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this._animations.remove(animation);
    }

    public final void run$animation_core_release(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-318043801);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-318043801, i, -1, "androidx.compose.animation.core.InfiniteTransition.run (InfiniteTransition.kt:171)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        if (isRunning() || getRefreshChildNeeded()) {
            EffectsKt.LaunchedEffect(this, new InfiniteTransition$run$1(mutableState, this, null), startRestartGroup, 72);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.animation.core.InfiniteTransition$run$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                InfiniteTransition.this.run$animation_core_release(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFrame(long j) {
        boolean z;
        MutableVector mutableVector = this._animations;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            z = true;
            int i = 0;
            do {
                TransitionAnimationState transitionAnimationState = (TransitionAnimationState) content[i];
                if (!transitionAnimationState.isFinished$animation_core_release()) {
                    transitionAnimationState.onPlayTimeChanged$animation_core_release(j);
                }
                if (!transitionAnimationState.isFinished$animation_core_release()) {
                    z = false;
                }
                i++;
            } while (i < size);
        } else {
            z = true;
        }
        setRunning(!z);
    }
}
