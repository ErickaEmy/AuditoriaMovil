package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.foundation.interaction.PressInteraction$Release;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: Button.kt */
/* loaded from: classes.dex */
final class DefaultButtonElevation$elevation$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ SnapshotStateList $interactions;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultButtonElevation$elevation$1$1(InteractionSource interactionSource, SnapshotStateList snapshotStateList, Continuation continuation) {
        super(2, continuation);
        this.$interactionSource = interactionSource;
        this.$interactions = snapshotStateList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultButtonElevation$elevation$1$1(this.$interactionSource, this.$interactions, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DefaultButtonElevation$elevation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow interactions = this.$interactionSource.getInteractions();
            final SnapshotStateList snapshotStateList = this.$interactions;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material.DefaultButtonElevation$elevation$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Interaction interaction, Continuation continuation) {
                    if (interaction instanceof HoverInteraction$Enter) {
                        SnapshotStateList.this.add(interaction);
                    } else if (interaction instanceof HoverInteraction$Exit) {
                        SnapshotStateList.this.remove(((HoverInteraction$Exit) interaction).getEnter());
                    } else if (interaction instanceof FocusInteraction$Focus) {
                        SnapshotStateList.this.add(interaction);
                    } else if (interaction instanceof FocusInteraction$Unfocus) {
                        SnapshotStateList.this.remove(((FocusInteraction$Unfocus) interaction).getFocus());
                    } else if (interaction instanceof PressInteraction$Press) {
                        SnapshotStateList.this.add(interaction);
                    } else if (interaction instanceof PressInteraction$Release) {
                        SnapshotStateList.this.remove(((PressInteraction$Release) interaction).getPress());
                    } else if (interaction instanceof PressInteraction$Cancel) {
                        SnapshotStateList.this.remove(((PressInteraction$Cancel) interaction).getPress());
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (interactions.collect(flowCollector, this) == coroutine_suspended) {
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
