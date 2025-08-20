package androidx.compose.ui.node;

import androidx.compose.runtime.AbstractApplier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UiApplier.android.kt */
/* loaded from: classes.dex */
public final class UiApplier extends AbstractApplier {
    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i, LayoutNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UiApplier(LayoutNode root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i, LayoutNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        ((LayoutNode) getCurrent()).insertAt$ui_release(i, instance);
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i, int i2) {
        ((LayoutNode) getCurrent()).removeAt$ui_release(i, i2);
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i, int i2, int i3) {
        ((LayoutNode) getCurrent()).move$ui_release(i, i2, i3);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void onClear() {
        ((LayoutNode) getRoot()).removeAll$ui_release();
    }

    @Override // androidx.compose.runtime.AbstractApplier, androidx.compose.runtime.Applier
    public void onEndChanges() {
        super.onEndChanges();
        Owner owner$ui_release = ((LayoutNode) getRoot()).getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onEndApplyChanges();
        }
    }
}
