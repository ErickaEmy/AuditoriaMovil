package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyItemScopeImpl.kt */
/* loaded from: classes.dex */
public final class AnimateItemPlacementNode extends DelegatingNode implements ParentDataModifierNode {
    private final LazyLayoutAnimateItemModifierNode delegatingNode;

    public final LazyLayoutAnimateItemModifierNode getDelegatingNode() {
        return this.delegatingNode;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public Object modifyParentData(Density density, Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return this.delegatingNode;
    }

    public AnimateItemPlacementNode(FiniteAnimationSpec animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.delegatingNode = (LazyLayoutAnimateItemModifierNode) delegate(new LazyLayoutAnimateItemModifierNode(animationSpec));
    }
}
