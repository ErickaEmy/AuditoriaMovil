package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.AbstractApplier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VectorCompose.kt */
/* loaded from: classes.dex */
public final class VectorApplier extends AbstractApplier {
    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i, VNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorApplier(VNode root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i, VNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        asGroup((VNode) getCurrent()).insertAt(i, instance);
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i, int i2) {
        asGroup((VNode) getCurrent()).remove(i, i2);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void onClear() {
        GroupComponent asGroup = asGroup((VNode) getRoot());
        asGroup.remove(0, asGroup.getNumChildren());
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i, int i2, int i3) {
        asGroup((VNode) getCurrent()).move(i, i2, i3);
    }

    private final GroupComponent asGroup(VNode vNode) {
        if (vNode instanceof GroupComponent) {
            return (GroupComponent) vNode;
        }
        throw new IllegalStateException("Cannot only insert VNode into Group".toString());
    }
}
