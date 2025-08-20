package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusableInteractionNode extends Modifier.Node {
    private FocusInteraction$Focus focusedInteraction;
    private MutableInteractionSource interactionSource;

    public FocusableInteractionNode(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    public final void setFocus(boolean z) {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            if (!z) {
                FocusInteraction$Focus focusInteraction$Focus = this.focusedInteraction;
                if (focusInteraction$Focus != null) {
                    emitWithFallback(mutableInteractionSource, new FocusInteraction$Unfocus(focusInteraction$Focus));
                    this.focusedInteraction = null;
                    return;
                }
                return;
            }
            FocusInteraction$Focus focusInteraction$Focus2 = this.focusedInteraction;
            if (focusInteraction$Focus2 != null) {
                emitWithFallback(mutableInteractionSource, new FocusInteraction$Unfocus(focusInteraction$Focus2));
                this.focusedInteraction = null;
            }
            FocusInteraction$Focus focusInteraction$Focus3 = new FocusInteraction$Focus();
            emitWithFallback(mutableInteractionSource, focusInteraction$Focus3);
            this.focusedInteraction = focusInteraction$Focus3;
        }
    }

    public final void update(MutableInteractionSource mutableInteractionSource) {
        if (Intrinsics.areEqual(this.interactionSource, mutableInteractionSource)) {
            return;
        }
        disposeInteractionSource();
        this.interactionSource = mutableInteractionSource;
    }

    private final void disposeInteractionSource() {
        FocusInteraction$Focus focusInteraction$Focus;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null && (focusInteraction$Focus = this.focusedInteraction) != null) {
            mutableInteractionSource.tryEmit(new FocusInteraction$Unfocus(focusInteraction$Focus));
        }
        this.focusedInteraction = null;
    }

    private final void emitWithFallback(MutableInteractionSource mutableInteractionSource, Interaction interaction) {
        if (isAttached()) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new FocusableInteractionNode$emitWithFallback$1(mutableInteractionSource, interaction, null), 3, null);
        } else {
            mutableInteractionSource.tryEmit(interaction);
        }
    }
}
