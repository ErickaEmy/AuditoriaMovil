package androidx.compose.material.ripple;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Ripple.kt */
/* loaded from: classes.dex */
public abstract class Ripple implements Indication {
    private final boolean bounded;
    private final State color;
    private final float radius;

    public /* synthetic */ Ripple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    /* renamed from: rememberUpdatedRippleInstance-942rkJo */
    public abstract RippleIndicationInstance mo586rememberUpdatedRippleInstance942rkJo(InteractionSource interactionSource, boolean z, float f, State state, State state2, Composer composer, int i);

    private Ripple(boolean z, float f, State color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.bounded = z;
        this.radius = f;
        this.color = color;
    }

    @Override // androidx.compose.foundation.Indication
    public final IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer composer, int i) {
        long mo505defaultColorWaAFU9c;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(988743187);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(988743187, i, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:113)");
        }
        RippleTheme rippleTheme = (RippleTheme) composer.consume(RippleThemeKt.getLocalRippleTheme());
        composer.startReplaceableGroup(-1524341038);
        if (((Color) this.color.getValue()).m859unboximpl() != Color.Companion.m864getUnspecified0d7_KjU()) {
            mo505defaultColorWaAFU9c = ((Color) this.color.getValue()).m859unboximpl();
        } else {
            mo505defaultColorWaAFU9c = rippleTheme.mo505defaultColorWaAFU9c(composer, 0);
        }
        composer.endReplaceableGroup();
        RippleIndicationInstance mo586rememberUpdatedRippleInstance942rkJo = mo586rememberUpdatedRippleInstance942rkJo(interactionSource, this.bounded, this.radius, SnapshotStateKt.rememberUpdatedState(Color.m841boximpl(mo505defaultColorWaAFU9c), composer, 0), SnapshotStateKt.rememberUpdatedState(rippleTheme.rippleAlpha(composer, 0), composer, 0), composer, (i & 14) | ((i << 12) & 458752));
        EffectsKt.LaunchedEffect(mo586rememberUpdatedRippleInstance942rkJo, interactionSource, new Ripple$rememberUpdatedInstance$1(interactionSource, mo586rememberUpdatedRippleInstance942rkJo, null), composer, ((i << 3) & 112) | 520);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mo586rememberUpdatedRippleInstance942rkJo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ripple) {
            Ripple ripple = (Ripple) obj;
            return this.bounded == ripple.bounded && Dp.m1899equalsimpl0(this.radius, ripple.radius) && Intrinsics.areEqual(this.color, ripple.color);
        }
        return false;
    }

    public int hashCode() {
        return (((ClickableElement$$ExternalSyntheticBackport0.m(this.bounded) * 31) + Dp.m1900hashCodeimpl(this.radius)) * 31) + this.color.hashCode();
    }
}
