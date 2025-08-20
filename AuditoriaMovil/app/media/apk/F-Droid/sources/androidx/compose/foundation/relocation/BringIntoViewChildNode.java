package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.EmptyMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BringIntoView.kt */
/* loaded from: classes.dex */
public abstract class BringIntoViewChildNode extends Modifier.Node implements ModifierLocalModifierNode, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {
    private final BringIntoViewParent defaultParent = BringIntoViewResponder_androidKt.defaultBringIntoViewParent(this);
    private LayoutCoordinates layoutCoordinates;

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public /* synthetic */ ModifierLocalMap getProvidedValues() {
        ModifierLocalMap modifierLocalMap;
        modifierLocalMap = EmptyMap.INSTANCE;
        return modifierLocalMap;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.layoutCoordinates = coordinates;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public /* synthetic */ void mo105onRemeasuredozmzZPI(long j) {
        LayoutAwareModifierNode.CC.m1303$default$onRemeasuredozmzZPI(this, j);
    }

    private final BringIntoViewParent getLocalParent() {
        return (BringIntoViewParent) getCurrent(BringIntoViewKt.getModifierLocalBringIntoViewParent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BringIntoViewParent getParent() {
        BringIntoViewParent localParent = getLocalParent();
        return localParent == null ? this.defaultParent : localParent;
    }
}
