package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: CommonRipple.kt */
/* loaded from: classes.dex */
public final class CommonRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;
    private final State color;
    private final float radius;
    private final State rippleAlpha;
    private final SnapshotStateMap ripples;

    public /* synthetic */ CommonRippleIndicationInstance(boolean z, float f, State state, State state2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state, state2);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private CommonRippleIndicationInstance(boolean z, float f, State color, State rippleAlpha) {
        super(z, rippleAlpha);
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        this.bounded = z;
        this.radius = f;
        this.color = color;
        this.rippleAlpha = rippleAlpha;
        this.ripples = SnapshotStateKt.mutableStateMapOf();
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long m859unboximpl = ((Color) this.color.getValue()).m859unboximpl();
        contentDrawScope.drawContent();
        m593drawStateLayerH2RKhps(contentDrawScope, this.radius, m859unboximpl);
        m585drawRipples4WTKRHQ(contentDrawScope, m859unboximpl);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(PressInteraction$Press interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        RippleAnimation rippleAnimation = (RippleAnimation) this.ripples.get(interaction);
        if (rippleAnimation != null) {
            rippleAnimation.finish();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.ripples.clear();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        this.ripples.clear();
    }

    /* renamed from: drawRipples-4WTKRHQ  reason: not valid java name */
    private final void m585drawRipples4WTKRHQ(DrawScope drawScope, long j) {
        for (Map.Entry entry : this.ripples.entrySet()) {
            RippleAnimation rippleAnimation = (RippleAnimation) entry.getValue();
            float pressedAlpha = ((RippleAlpha) this.rippleAlpha.getValue()).getPressedAlpha();
            if (pressedAlpha != 0.0f) {
                rippleAnimation.m587draw4WTKRHQ(drawScope, Color.m849copywmQWz5c$default(j, pressedAlpha, 0.0f, 0.0f, 0.0f, 14, null));
            }
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(PressInteraction$Press interaction, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        for (Map.Entry entry : this.ripples.entrySet()) {
            ((RippleAnimation) entry.getValue()).finish();
        }
        RippleAnimation rippleAnimation = new RippleAnimation(this.bounded ? Offset.m698boximpl(interaction.m179getPressPositionF1C5BW0()) : null, this.radius, this.bounded, null);
        this.ripples.put(interaction, rippleAnimation);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new CommonRippleIndicationInstance$addRipple$2(rippleAnimation, this, interaction, null), 3, null);
    }
}
