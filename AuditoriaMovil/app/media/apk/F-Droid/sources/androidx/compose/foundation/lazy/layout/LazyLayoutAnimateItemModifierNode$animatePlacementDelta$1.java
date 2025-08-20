package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutAnimateItemModifierNode.kt */
/* loaded from: classes.dex */
public final class LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimateItemModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimateItemModifierNode;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this.this$0, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Animatable animatable;
        FiniteAnimationSpec placementAnimationSpec;
        FiniteAnimationSpec finiteAnimationSpec;
        Animatable animatable2;
        Animatable animatable3;
        Animatable animatable4;
        Animatable animatable5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            animatable = this.this$0.placementDeltaAnimation;
            if (animatable.isRunning()) {
                if (this.this$0.getPlacementAnimationSpec() instanceof SpringSpec) {
                    placementAnimationSpec = this.this$0.getPlacementAnimationSpec();
                } else {
                    placementAnimationSpec = LazyLayoutAnimateItemModifierNodeKt.InterruptionSpec;
                }
            } else {
                placementAnimationSpec = this.this$0.getPlacementAnimationSpec();
            }
            finiteAnimationSpec = placementAnimationSpec;
            animatable2 = this.this$0.placementDeltaAnimation;
            if (!animatable2.isRunning()) {
                animatable3 = this.this$0.placementDeltaAnimation;
                IntOffset m1929boximpl = IntOffset.m1929boximpl(this.$totalDelta);
                this.L$0 = finiteAnimationSpec;
                this.label = 1;
                if (animatable3.snapTo(m1929boximpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                this.this$0.setAnimationInProgress(false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpec;
        animatable4 = this.this$0.placementDeltaAnimation;
        long m1941unboximpl = ((IntOffset) animatable4.getValue()).m1941unboximpl();
        long j = this.$totalDelta;
        final long IntOffset = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m1941unboximpl) - IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(m1941unboximpl) - IntOffset.m1938getYimpl(j));
        animatable5 = this.this$0.placementDeltaAnimation;
        IntOffset m1929boximpl2 = IntOffset.m1929boximpl(IntOffset);
        final LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = this.this$0;
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((Animatable) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Animatable animateTo) {
                Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode2 = LazyLayoutAnimateItemModifierNode.this;
                long m1941unboximpl2 = ((IntOffset) animateTo.getValue()).m1941unboximpl();
                long j2 = IntOffset;
                lazyLayoutAnimateItemModifierNode2.m253setPlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m1941unboximpl2) - IntOffset.m1937getXimpl(j2), IntOffset.m1938getYimpl(m1941unboximpl2) - IntOffset.m1938getYimpl(j2)));
            }
        };
        this.L$0 = null;
        this.label = 2;
        if (Animatable.animateTo$default(animatable5, m1929boximpl2, finiteAnimationSpec2, null, function1, this, 4, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.setAnimationInProgress(false);
        return Unit.INSTANCE;
    }
}
