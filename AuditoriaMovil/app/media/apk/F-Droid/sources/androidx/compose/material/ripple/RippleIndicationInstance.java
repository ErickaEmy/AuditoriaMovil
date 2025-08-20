package androidx.compose.material.ripple;

import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: Ripple.kt */
/* loaded from: classes.dex */
public abstract class RippleIndicationInstance implements IndicationInstance {
    private final StateLayer stateLayer;

    public abstract void addRipple(PressInteraction$Press pressInteraction$Press, CoroutineScope coroutineScope);

    public abstract void removeRipple(PressInteraction$Press pressInteraction$Press);

    public RippleIndicationInstance(boolean z, State rippleAlpha) {
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        this.stateLayer = new StateLayer(z, rippleAlpha);
    }

    public final void updateStateLayer$material_ripple_release(Interaction interaction, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.stateLayer.handleInteraction(interaction, scope);
    }

    /* renamed from: drawStateLayer-H2RKhps  reason: not valid java name */
    public final void m593drawStateLayerH2RKhps(DrawScope drawStateLayer, float f, long j) {
        Intrinsics.checkNotNullParameter(drawStateLayer, "$this$drawStateLayer");
        this.stateLayer.m597drawStateLayerH2RKhps(drawStateLayer, f, j);
    }
}
