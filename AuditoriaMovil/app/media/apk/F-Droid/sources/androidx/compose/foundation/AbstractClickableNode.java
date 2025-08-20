package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.semantics.Role;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode {
    private boolean enabled;
    private final InteractionData interactionData;
    private MutableInteractionSource interactionSource;
    private Function0 onClick;
    private String onClickLabel;
    private Role role;

    /* compiled from: Clickable.kt */
    /* loaded from: classes.dex */
    public static final class InteractionData {
        private PressInteraction$Press pressInteraction;
        private final Map currentKeyPressInteractions = new LinkedHashMap();
        private long centreOffset = Offset.Companion.m721getZeroF1C5BW0();

        /* renamed from: getCentreOffset-F1C5BW0  reason: not valid java name */
        public final long m63getCentreOffsetF1C5BW0() {
            return this.centreOffset;
        }

        public final Map getCurrentKeyPressInteractions() {
            return this.currentKeyPressInteractions;
        }

        public final PressInteraction$Press getPressInteraction() {
            return this.pressInteraction;
        }

        /* renamed from: setCentreOffset-k-4lQ0M  reason: not valid java name */
        public final void m64setCentreOffsetk4lQ0M(long j) {
            this.centreOffset = j;
        }

        public final void setPressInteraction(PressInteraction$Press pressInteraction$Press) {
            this.pressInteraction = pressInteraction$Press;
        }
    }

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, role, function0);
    }

    public abstract AbstractClickablePointerInputNode getClickablePointerInputNode();

    /* JADX INFO: Access modifiers changed from: protected */
    public final InteractionData getInteractionData() {
        return this.interactionData;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onDensityChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean mo61onPreKeyEventZmokQxo(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    private AbstractClickableNode(MutableInteractionSource interactionSource, boolean z, String str, Role role, Function0 onClick) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.interactionSource = interactionSource;
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = onClick;
        this.interactionData = new InteractionData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: updateCommon-XHw0xAI  reason: not valid java name */
    public final void m62updateCommonXHw0xAI(MutableInteractionSource interactionSource, boolean z, String str, Role role, Function0 onClick) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.enabled != z) {
            if (!z) {
                disposeInteractionSource();
            }
            this.enabled = z;
        }
        this.onClickLabel = str;
        this.role = role;
        this.onClick = onClick;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeInteractionSource();
    }

    protected final void disposeInteractionSource() {
        PressInteraction$Press pressInteraction = this.interactionData.getPressInteraction();
        if (pressInteraction != null) {
            this.interactionSource.tryEmit(new PressInteraction$Cancel(pressInteraction));
        }
        for (PressInteraction$Press pressInteraction$Press : this.interactionData.getCurrentKeyPressInteractions().values()) {
            this.interactionSource.tryEmit(new PressInteraction$Cancel(pressInteraction$Press));
        }
        this.interactionData.setPressInteraction(null);
        this.interactionData.getCurrentKeyPressInteractions().clear();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void mo60onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long j) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        getClickablePointerInputNode().mo60onPointerEventH0pRuoY(pointerEvent, pass, j);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        getClickablePointerInputNode().onCancelPointerInput();
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean mo59onKeyEventZmokQxo(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.enabled && Clickable_androidKt.m103isPressZmokQxo(event)) {
            if (this.interactionData.getCurrentKeyPressInteractions().containsKey(Key.m1115boximpl(KeyEvent_androidKt.m1143getKeyZmokQxo(event)))) {
                return false;
            }
            PressInteraction$Press pressInteraction$Press = new PressInteraction$Press(this.interactionData.m63getCentreOffsetF1C5BW0(), null);
            this.interactionData.getCurrentKeyPressInteractions().put(Key.m1115boximpl(KeyEvent_androidKt.m1143getKeyZmokQxo(event)), pressInteraction$Press);
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, pressInteraction$Press, null), 3, null);
        } else if (!this.enabled || !Clickable_androidKt.m101isClickZmokQxo(event)) {
            return false;
        } else {
            PressInteraction$Press pressInteraction$Press2 = (PressInteraction$Press) this.interactionData.getCurrentKeyPressInteractions().remove(Key.m1115boximpl(KeyEvent_androidKt.m1143getKeyZmokQxo(event)));
            if (pressInteraction$Press2 != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2$1(this, pressInteraction$Press2, null), 3, null);
            }
            this.onClick.invoke();
        }
        return true;
    }
}
