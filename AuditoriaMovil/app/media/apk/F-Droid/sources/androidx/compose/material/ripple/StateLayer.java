package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Ripple.kt */
/* loaded from: classes.dex */
public final class StateLayer {
    private final Animatable animatedAlpha;
    private final boolean bounded;
    private Interaction currentInteraction;
    private final List interactions;
    private final State rippleAlpha;

    /* renamed from: drawStateLayer-H2RKhps  reason: not valid java name */
    public final void m597drawStateLayerH2RKhps(DrawScope drawStateLayer, float f, long j) {
        float mo155toPx0680j_4;
        Intrinsics.checkNotNullParameter(drawStateLayer, "$this$drawStateLayer");
        if (Float.isNaN(f)) {
            mo155toPx0680j_4 = RippleAnimationKt.m588getRippleEndRadiuscSwnlzA(drawStateLayer, this.bounded, drawStateLayer.mo1040getSizeNHjbRc());
        } else {
            mo155toPx0680j_4 = drawStateLayer.mo155toPx0680j_4(f);
        }
        float f2 = mo155toPx0680j_4;
        float floatValue = ((Number) this.animatedAlpha.getValue()).floatValue();
        if (floatValue > 0.0f) {
            long m849copywmQWz5c$default = Color.m849copywmQWz5c$default(j, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
            if (this.bounded) {
                float m745getWidthimpl = Size.m745getWidthimpl(drawStateLayer.mo1040getSizeNHjbRc());
                float m743getHeightimpl = Size.m743getHeightimpl(drawStateLayer.mo1040getSizeNHjbRc());
                int m840getIntersectrtfAjoo = ClipOp.Companion.m840getIntersectrtfAjoo();
                DrawContext drawContext = drawStateLayer.getDrawContext();
                long mo1044getSizeNHjbRc = drawContext.mo1044getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo1047clipRectN_I0leg(0.0f, 0.0f, m745getWidthimpl, m743getHeightimpl, m840getIntersectrtfAjoo);
                DrawScope.CC.m1056drawCircleVaOC9Bg$default(drawStateLayer, m849copywmQWz5c$default, f2, 0L, 0.0f, null, null, 0, 124, null);
                drawContext.getCanvas().restore();
                drawContext.mo1045setSizeuvyYCjk(mo1044getSizeNHjbRc);
                return;
            }
            DrawScope.CC.m1056drawCircleVaOC9Bg$default(drawStateLayer, m849copywmQWz5c$default, f2, 0L, 0.0f, null, null, 0, 124, null);
        }
    }

    public StateLayer(boolean z, State rippleAlpha) {
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        this.bounded = z;
        this.rippleAlpha = rippleAlpha;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.interactions = new ArrayList();
    }

    public final void handleInteraction(Interaction interaction, CoroutineScope scope) {
        Object lastOrNull;
        float draggedAlpha;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        boolean z = interaction instanceof HoverInteraction$Enter;
        if (z) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction$Exit) {
            this.interactions.remove(((HoverInteraction$Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction$Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction$Unfocus) {
            this.interactions.remove(((FocusInteraction$Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction$Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction$Stop) {
            this.interactions.remove(((DragInteraction$Stop) interaction).getStart());
        } else if (!(interaction instanceof DragInteraction$Cancel)) {
            return;
        } else {
            this.interactions.remove(((DragInteraction$Cancel) interaction).getStart());
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull(this.interactions);
        Interaction interaction2 = (Interaction) lastOrNull;
        if (Intrinsics.areEqual(this.currentInteraction, interaction2)) {
            return;
        }
        if (interaction2 != null) {
            if (z) {
                draggedAlpha = ((RippleAlpha) this.rippleAlpha.getValue()).getHoveredAlpha();
            } else if (interaction instanceof FocusInteraction$Focus) {
                draggedAlpha = ((RippleAlpha) this.rippleAlpha.getValue()).getFocusedAlpha();
            } else {
                draggedAlpha = interaction instanceof DragInteraction$Start ? ((RippleAlpha) this.rippleAlpha.getValue()).getDraggedAlpha() : 0.0f;
            }
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new StateLayer$handleInteraction$1(this, draggedAlpha, RippleKt.access$incomingStateLayerAnimationSpecFor(interaction2), null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new StateLayer$handleInteraction$2(this, RippleKt.access$outgoingStateLayerAnimationSpecFor(this.currentInteraction), null), 3, null);
        }
        this.currentInteraction = interaction2;
    }
}
