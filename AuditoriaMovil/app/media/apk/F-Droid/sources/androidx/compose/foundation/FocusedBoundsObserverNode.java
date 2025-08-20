package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusedBounds.kt */
/* loaded from: classes.dex */
final class FocusedBoundsObserverNode extends Modifier.Node implements ModifierLocalModifierNode, Function1 {
    private Function1 onPositioned;
    private final ModifierLocalMap providedValues;

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    public final void setOnPositioned(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onPositioned = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public FocusedBoundsObserverNode(Function1 onPositioned) {
        Intrinsics.checkNotNullParameter(onPositioned, "onPositioned");
        this.onPositioned = onPositioned;
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver(), this));
    }

    private final Function1 getParent() {
        if (isAttached()) {
            return (Function1) getCurrent(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver());
        }
        return null;
    }

    public void invoke(LayoutCoordinates layoutCoordinates) {
        if (isAttached()) {
            this.onPositioned.invoke(layoutCoordinates);
            Function1 parent = getParent();
            if (parent != null) {
                parent.invoke(layoutCoordinates);
            }
        }
    }
}
