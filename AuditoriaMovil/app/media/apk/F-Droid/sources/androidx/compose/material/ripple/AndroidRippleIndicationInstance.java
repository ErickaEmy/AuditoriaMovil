package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: Ripple.android.kt */
/* loaded from: classes.dex */
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;
    private final State color;
    private final MutableState invalidateTick$delegate;
    private final Function0 onInvalidateRipple;
    private final float radius;
    private final State rippleAlpha;
    private final RippleContainer rippleContainer;
    private final MutableState rippleHostView$delegate;
    private int rippleRadius;
    private long rippleSize;

    public /* synthetic */ AndroidRippleIndicationInstance(boolean z, float f, State state, State state2, RippleContainer rippleContainer, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state, state2, rippleContainer);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getInvalidateTick() {
        return ((Boolean) this.invalidateTick$delegate.getValue()).booleanValue();
    }

    private final RippleHostView getRippleHostView() {
        return (RippleHostView) this.rippleHostView$delegate.getValue();
    }

    private final void setRippleHostView(RippleHostView rippleHostView) {
        this.rippleHostView$delegate.setValue(rippleHostView);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AndroidRippleIndicationInstance(boolean z, float f, State color, State rippleAlpha, RippleContainer rippleContainer) {
        super(z, rippleAlpha);
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        Intrinsics.checkNotNullParameter(rippleContainer, "rippleContainer");
        this.bounded = z;
        this.radius = f;
        this.color = color;
        this.rippleAlpha = rippleAlpha;
        this.rippleContainer = rippleContainer;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.rippleHostView$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.invalidateTick$delegate = mutableStateOf$default2;
        this.rippleSize = Size.Companion.m751getZeroNHjbRc();
        this.rippleRadius = -1;
        this.onInvalidateRipple = new Function0() { // from class: androidx.compose.material.ripple.AndroidRippleIndicationInstance$onInvalidateRipple$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m584invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m584invoke() {
                boolean invalidateTick;
                AndroidRippleIndicationInstance androidRippleIndicationInstance = AndroidRippleIndicationInstance.this;
                invalidateTick = androidRippleIndicationInstance.getInvalidateTick();
                androidRippleIndicationInstance.setInvalidateTick(!invalidateTick);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInvalidateTick(boolean z) {
        this.invalidateTick$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(ContentDrawScope contentDrawScope) {
        int mo150roundToPx0680j_4;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        this.rippleSize = contentDrawScope.mo1040getSizeNHjbRc();
        if (Float.isNaN(this.radius)) {
            mo150roundToPx0680j_4 = MathKt__MathJVMKt.roundToInt(RippleAnimationKt.m588getRippleEndRadiuscSwnlzA(contentDrawScope, this.bounded, contentDrawScope.mo1040getSizeNHjbRc()));
        } else {
            mo150roundToPx0680j_4 = contentDrawScope.mo150roundToPx0680j_4(this.radius);
        }
        this.rippleRadius = mo150roundToPx0680j_4;
        long m859unboximpl = ((Color) this.color.getValue()).m859unboximpl();
        float pressedAlpha = ((RippleAlpha) this.rippleAlpha.getValue()).getPressedAlpha();
        contentDrawScope.drawContent();
        m593drawStateLayerH2RKhps(contentDrawScope, this.radius, m859unboximpl);
        Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        getInvalidateTick();
        RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            rippleHostView.m592updateRipplePropertiesbiQXAtU(contentDrawScope.mo1040getSizeNHjbRc(), this.rippleRadius, m859unboximpl, pressedAlpha);
            rippleHostView.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(PressInteraction$Press interaction, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        RippleHostView rippleHostView = this.rippleContainer.getRippleHostView(this);
        rippleHostView.m591addRippleKOepWvA(interaction, this.bounded, this.rippleSize, this.rippleRadius, ((Color) this.color.getValue()).m859unboximpl(), ((RippleAlpha) this.rippleAlpha.getValue()).getPressedAlpha(), this.onInvalidateRipple);
        setRippleHostView(rippleHostView);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(PressInteraction$Press interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            rippleHostView.removeRipple();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        dispose();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        dispose();
    }

    private final void dispose() {
        this.rippleContainer.disposeRippleIfNeeded(this);
    }

    public final void resetHostView() {
        setRippleHostView(null);
    }
}
