package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: FloatingActionButton.kt */
/* loaded from: classes.dex */
final class DefaultFloatingActionButtonElevation$elevation$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ Animatable $animatable;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ DefaultFloatingActionButtonElevation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFloatingActionButtonElevation$elevation$2(Animatable animatable, DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation, float f, Interaction interaction, Continuation continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.this$0 = defaultFloatingActionButtonElevation;
        this.$target = f;
        this.$interaction = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultFloatingActionButtonElevation$elevation$2(this.$animatable, this.this$0, this.$target, this.$interaction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DefaultFloatingActionButtonElevation$elevation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        float f;
        float f2;
        float f3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float m1903unboximpl = ((Dp) this.$animatable.getTargetValue()).m1903unboximpl();
            f = this.this$0.pressedElevation;
            Interaction interaction = null;
            if (Dp.m1899equalsimpl0(m1903unboximpl, f)) {
                interaction = new PressInteraction$Press(Offset.Companion.m721getZeroF1C5BW0(), null);
            } else {
                f2 = this.this$0.hoveredElevation;
                if (Dp.m1899equalsimpl0(m1903unboximpl, f2)) {
                    interaction = new HoverInteraction$Enter();
                } else {
                    f3 = this.this$0.focusedElevation;
                    if (Dp.m1899equalsimpl0(m1903unboximpl, f3)) {
                        interaction = new FocusInteraction$Focus();
                    }
                }
            }
            Animatable animatable = this.$animatable;
            float f4 = this.$target;
            Interaction interaction2 = this.$interaction;
            this.label = 1;
            if (ElevationKt.m488animateElevationrAjV9yQ(animatable, f4, interaction, interaction2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
