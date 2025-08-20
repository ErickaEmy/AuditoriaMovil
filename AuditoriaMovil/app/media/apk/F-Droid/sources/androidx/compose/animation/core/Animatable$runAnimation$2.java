package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Animatable.kt */
/* loaded from: classes.dex */
public final class Animatable$runAnimation$2 extends SuspendLambda implements Function1 {
    final /* synthetic */ Animation $animation;
    final /* synthetic */ Function1 $block;
    final /* synthetic */ Object $initialVelocity;
    final /* synthetic */ long $startTime;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Animatable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Animatable$runAnimation$2(Animatable animatable, Object obj, Animation animation, long j, Function1 function1, Continuation continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$initialVelocity = obj;
        this.$animation = animation;
        this.$startTime = j;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new Animatable$runAnimation$2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((Animatable$runAnimation$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        AnimationState animationState;
        Ref$BooleanRef ref$BooleanRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.getInternalState$animation_core_release().setVelocityVector$animation_core_release((AnimationVector) this.this$0.getTypeConverter().getConvertToVector().invoke(this.$initialVelocity));
                this.this$0.setTargetValue(this.$animation.getTargetValue());
                this.this$0.setRunning(true);
                final AnimationState copy$default = AnimationStateKt.copy$default(this.this$0.getInternalState$animation_core_release(), null, null, 0L, Long.MIN_VALUE, false, 23, null);
                final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                Animation animation = this.$animation;
                long j = this.$startTime;
                final Animatable animatable = this.this$0;
                final Function1 function1 = this.$block;
                Function1 function12 = new Function1() { // from class: androidx.compose.animation.core.Animatable$runAnimation$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((AnimationScope) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimationScope animate) {
                        Object clampToBounds;
                        Intrinsics.checkNotNullParameter(animate, "$this$animate");
                        SuspendAnimationKt.updateState(animate, Animatable.this.getInternalState$animation_core_release());
                        clampToBounds = Animatable.this.clampToBounds(animate.getValue());
                        if (Intrinsics.areEqual(clampToBounds, animate.getValue())) {
                            Function1 function13 = function1;
                            if (function13 != null) {
                                function13.invoke(Animatable.this);
                                return;
                            }
                            return;
                        }
                        Animatable.this.getInternalState$animation_core_release().setValue$animation_core_release(clampToBounds);
                        copy$default.setValue$animation_core_release(clampToBounds);
                        Function1 function14 = function1;
                        if (function14 != null) {
                            function14.invoke(Animatable.this);
                        }
                        animate.cancelAnimation();
                        ref$BooleanRef2.element = true;
                    }
                };
                this.L$0 = copy$default;
                this.L$1 = ref$BooleanRef2;
                this.label = 1;
                if (SuspendAnimationKt.animate(copy$default, animation, j, function12, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                animationState = copy$default;
                ref$BooleanRef = ref$BooleanRef2;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ref$BooleanRef = (Ref$BooleanRef) this.L$1;
                animationState = (AnimationState) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            AnimationEndReason animationEndReason = ref$BooleanRef.element ? AnimationEndReason.BoundReached : AnimationEndReason.Finished;
            this.this$0.endAnimation();
            return new AnimationResult(animationState, animationEndReason);
        } catch (CancellationException e) {
            this.this$0.endAnimation();
            throw e;
        }
    }
}
