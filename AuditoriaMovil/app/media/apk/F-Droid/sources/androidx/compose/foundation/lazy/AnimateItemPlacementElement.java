package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyItemScopeImpl.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0018\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/AnimateItemPlacementElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/AnimateItemPlacementNode;", "create", "node", "", "update", "", "other", "", "equals", "", "hashCode", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "<init>", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "foundation_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
final class AnimateItemPlacementElement extends ModifierNodeElement {
    private final FiniteAnimationSpec animationSpec;

    public AnimateItemPlacementElement(FiniteAnimationSpec animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.animationSpec = animationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public AnimateItemPlacementNode create() {
        return new AnimateItemPlacementNode(this.animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(AnimateItemPlacementNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.getDelegatingNode().setPlacementAnimationSpec(this.animationSpec);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnimateItemPlacementElement) {
            return !Intrinsics.areEqual(this.animationSpec, ((AnimateItemPlacementElement) obj).animationSpec);
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.animationSpec.hashCode();
    }
}
