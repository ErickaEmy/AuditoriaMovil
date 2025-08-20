package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OwnerSnapshotObserver.kt */
/* loaded from: classes.dex */
public final class OwnerSnapshotObserver {
    private final SnapshotStateObserver observer;
    private final Function1 onCommitAffectingLayout;
    private final Function1 onCommitAffectingLayoutModifier;
    private final Function1 onCommitAffectingLayoutModifierInLookahead;
    private final Function1 onCommitAffectingLookaheadLayout;
    private final Function1 onCommitAffectingLookaheadMeasure;
    private final Function1 onCommitAffectingMeasure;
    private final Function1 onCommitAffectingSemantics;

    public OwnerSnapshotObserver(Function1 onChangedExecutor) {
        Intrinsics.checkNotNullParameter(onChangedExecutor, "onChangedExecutor");
        this.observer = new SnapshotStateObserver(onChangedExecutor);
        this.onCommitAffectingLookaheadMeasure = new Function1() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValidOwnerScope()) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, false, false, 3, null);
                }
            }
        };
        this.onCommitAffectingMeasure = new Function1() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingMeasure$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValidOwnerScope()) {
                    LayoutNode.requestRemeasure$ui_release$default(layoutNode, false, false, 3, null);
                }
            }
        };
        this.onCommitAffectingSemantics = new Function1() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingSemantics$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValidOwnerScope()) {
                    layoutNode.invalidateSemantics$ui_release();
                }
            }
        };
        this.onCommitAffectingLayout = new Function1() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValidOwnerScope()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
        this.onCommitAffectingLayoutModifier = new Function1() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValidOwnerScope()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
        this.onCommitAffectingLayoutModifierInLookahead = new Function1() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValidOwnerScope()) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
        this.onCommitAffectingLookaheadLayout = new Function1() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookaheadLayout$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValidOwnerScope()) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
    }

    public static /* synthetic */ void observeLayoutSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeLayoutSnapshotReads$ui_release(layoutNode, z, function0);
    }

    public final void observeLayoutSnapshotReads$ui_release(LayoutNode node, boolean z, Function0 block) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(block, "block");
        if (z && node.getLookaheadRoot$ui_release() != null) {
            observeReads$ui_release(node, this.onCommitAffectingLookaheadLayout, block);
        } else {
            observeReads$ui_release(node, this.onCommitAffectingLayout, block);
        }
    }

    public static /* synthetic */ void observeLayoutModifierSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release(layoutNode, z, function0);
    }

    public final void observeLayoutModifierSnapshotReads$ui_release(LayoutNode node, boolean z, Function0 block) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(block, "block");
        if (z && node.getLookaheadRoot$ui_release() != null) {
            observeReads$ui_release(node, this.onCommitAffectingLayoutModifierInLookahead, block);
        } else {
            observeReads$ui_release(node, this.onCommitAffectingLayoutModifier, block);
        }
    }

    public static /* synthetic */ void observeMeasureSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeMeasureSnapshotReads$ui_release(layoutNode, z, function0);
    }

    public final void observeMeasureSnapshotReads$ui_release(LayoutNode node, boolean z, Function0 block) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(block, "block");
        if (z && node.getLookaheadRoot$ui_release() != null) {
            observeReads$ui_release(node, this.onCommitAffectingLookaheadMeasure, block);
        } else {
            observeReads$ui_release(node, this.onCommitAffectingMeasure, block);
        }
    }

    public final void observeSemanticsReads$ui_release(LayoutNode node, Function0 block) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(block, "block");
        observeReads$ui_release(node, this.onCommitAffectingSemantics, block);
    }

    public final void observeReads$ui_release(OwnerScope target, Function1 onChanged, Function0 block) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        Intrinsics.checkNotNullParameter(block, "block");
        this.observer.observeReads(target, onChanged, block);
    }

    public final void clearInvalidObservations$ui_release() {
        this.observer.clearIf(new Function1() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$clearInvalidObservations$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!((OwnerScope) it).isValidOwnerScope());
            }
        });
    }

    public final void startObserving$ui_release() {
        this.observer.start();
    }

    public final void stopObserving$ui_release() {
        this.observer.stop();
        this.observer.clear();
    }
}
