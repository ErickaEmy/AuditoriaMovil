package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.Constraints;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MeasureAndLayoutDelegate.kt */
/* loaded from: classes.dex */
public final class MeasureAndLayoutDelegate {
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringMeasureLayout;
    private long measureIteration;
    private final MutableVector onLayoutCompletedListeners;
    private final OnPositionedDispatcher onPositionedDispatcher;
    private final MutableVector postponedMeasureRequests;
    private final DepthSortedSetsForDifferentPasses relayoutNodes;
    private final LayoutNode root;
    private Constraints rootConstraints;

    /* compiled from: MeasureAndLayoutDelegate.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        Owner.Companion companion = Owner.Companion;
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = new DepthSortedSetsForDifferentPasses(companion.getEnableExtraAssertions());
        this.relayoutNodes = depthSortedSetsForDifferentPasses;
        this.onPositionedDispatcher = new OnPositionedDispatcher();
        this.onLayoutCompletedListeners = new MutableVector(new Owner.OnLayoutCompletedListener[16], 0);
        this.measureIteration = 1L;
        MutableVector mutableVector = new MutableVector(new PostponedRequest[16], 0);
        this.postponedMeasureRequests = mutableVector;
        this.consistencyChecker = companion.getEnableExtraAssertions() ? new LayoutTreeConsistencyChecker(root, depthSortedSetsForDifferentPasses, mutableVector.asMutableList()) : null;
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return this.relayoutNodes.isNotEmpty();
    }

    public final boolean getHasPendingOnPositionedCallbacks() {
        return this.onPositionedDispatcher.isNotEmpty();
    }

    public final long getMeasureIteration() {
        if (this.duringMeasureLayout) {
            return this.measureIteration;
        }
        throw new IllegalArgumentException("measureIteration should be only used during the measure/layout pass".toString());
    }

    /* renamed from: updateRootConstraints-BRTryo0 */
    public final void m1348updateRootConstraintsBRTryo0(long j) {
        Constraints constraints = this.rootConstraints;
        if (constraints != null && Constraints.m1865equalsimpl0(constraints.m1877unboximpl(), j)) {
            return;
        }
        if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.rootConstraints = Constraints.m1860boximpl(j);
        if (this.root.getLookaheadRoot$ui_release() != null) {
            this.root.markLookaheadMeasurePending$ui_release();
        }
        this.root.markMeasurePending$ui_release();
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
        LayoutNode layoutNode = this.root;
        depthSortedSetsForDifferentPasses.add(layoutNode, layoutNode.getLookaheadRoot$ui_release() != null);
    }

    public static /* synthetic */ boolean requestLookaheadRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z);
    }

    public final boolean requestLookaheadRemeasure(LayoutNode layoutNode, boolean z) {
        LayoutNode parent$ui_release;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (layoutNode.getLookaheadRoot$ui_release() != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
            if (i != 1) {
                if (i == 2 || i == 3 || i == 4) {
                    this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, true, z));
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                        return false;
                    }
                    return false;
                } else if (i == 5) {
                    if (!layoutNode.getLookaheadMeasurePending$ui_release() || z) {
                        layoutNode.markLookaheadMeasurePending$ui_release();
                        layoutNode.markMeasurePending$ui_release();
                        if ((Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || getCanAffectParentInLookahead(layoutNode)) && ((parent$ui_release = layoutNode.getParent$ui_release()) == null || !parent$ui_release.getLookaheadMeasurePending$ui_release())) {
                            this.relayoutNodes.add(layoutNode, true);
                        }
                        return !this.duringMeasureLayout;
                    }
                    return false;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return false;
        }
        throw new IllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadLayout".toString());
    }

    public static /* synthetic */ boolean requestRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRemeasure(layoutNode, z);
    }

    public final boolean requestRemeasure(LayoutNode layoutNode, boolean z) {
        LayoutNode parent$ui_release;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3 || i == 4) {
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, false, z));
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } else if (i == 5) {
                if (!layoutNode.getMeasurePending$ui_release() || z) {
                    layoutNode.markMeasurePending$ui_release();
                    if ((layoutNode.isPlaced() || getCanAffectParent(layoutNode)) && ((parent$ui_release = layoutNode.getParent$ui_release()) == null || !parent$ui_release.getMeasurePending$ui_release())) {
                        this.relayoutNodes.add(layoutNode, false);
                    }
                    if (!this.duringMeasureLayout) {
                        return true;
                    }
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return false;
    }

    public static /* synthetic */ boolean requestLookaheadRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z);
    }

    public final boolean requestLookaheadRelayout(LayoutNode layoutNode, boolean z) {
        LayoutNode parent$ui_release;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 && i != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if ((layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getLookaheadLayoutPending$ui_release()) && !z) {
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                    return false;
                }
                return false;
            }
            layoutNode.markLookaheadLayoutPending$ui_release();
            layoutNode.markLayoutPending$ui_release();
            if (Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) && (((parent$ui_release = layoutNode.getParent$ui_release()) == null || !parent$ui_release.getLookaheadMeasurePending$ui_release()) && (parent$ui_release == null || !parent$ui_release.getLookaheadLayoutPending$ui_release()))) {
                this.relayoutNodes.add(layoutNode, true);
            }
            return !this.duringMeasureLayout;
        }
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
        if (layoutTreeConsistencyChecker2 != null) {
            layoutTreeConsistencyChecker2.assertConsistent();
            return false;
        }
        return false;
    }

    public static /* synthetic */ boolean requestRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRelayout(layoutNode, z);
    }

    public final boolean requestRelayout(LayoutNode layoutNode, boolean z) {
        LayoutNode parent$ui_release;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.assertConsistent();
                return false;
            }
            return false;
        } else if (i == 5) {
            if (!z && (layoutNode.getMeasurePending$ui_release() || layoutNode.getLayoutPending$ui_release())) {
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
                if (layoutTreeConsistencyChecker2 != null) {
                    layoutTreeConsistencyChecker2.assertConsistent();
                    return false;
                }
                return false;
            }
            layoutNode.markLayoutPending$ui_release();
            if (layoutNode.isPlaced() && (((parent$ui_release = layoutNode.getParent$ui_release()) == null || !parent$ui_release.getLayoutPending$ui_release()) && (parent$ui_release == null || !parent$ui_release.getMeasurePending$ui_release()))) {
                this.relayoutNodes.add(layoutNode, false);
            }
            return !this.duringMeasureLayout;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void requestOnPositionedCallback(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.onPositionedDispatcher.onNodePositioned(layoutNode);
    }

    /* renamed from: doLookaheadRemeasure-sdFAvZA */
    private final boolean m1345doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean m1308lookaheadRemeasure_Sx5XlM$ui_release$default;
        if (layoutNode.getLookaheadRoot$ui_release() == null) {
            return false;
        }
        if (constraints != null) {
            m1308lookaheadRemeasure_Sx5XlM$ui_release$default = layoutNode.m1312lookaheadRemeasure_Sx5XlM$ui_release(constraints);
        } else {
            m1308lookaheadRemeasure_Sx5XlM$ui_release$default = LayoutNode.m1308lookaheadRemeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (m1308lookaheadRemeasure_Sx5XlM$ui_release$default && parent$ui_release != null) {
            if (parent$ui_release.getLookaheadRoot$ui_release() == null) {
                requestRemeasure$default(this, parent$ui_release, false, 2, null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestLookaheadRemeasure$default(this, parent$ui_release, false, 2, null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestLookaheadRelayout$default(this, parent$ui_release, false, 2, null);
            }
        }
        return m1308lookaheadRemeasure_Sx5XlM$ui_release$default;
    }

    /* renamed from: doRemeasure-sdFAvZA */
    private final boolean m1346doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean m1309remeasure_Sx5XlM$ui_release$default;
        if (constraints != null) {
            m1309remeasure_Sx5XlM$ui_release$default = layoutNode.m1313remeasure_Sx5XlM$ui_release(constraints);
        } else {
            m1309remeasure_Sx5XlM$ui_release$default = LayoutNode.m1309remeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (m1309remeasure_Sx5XlM$ui_release$default && parent$ui_release != null) {
            if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestRemeasure$default(this, parent$ui_release, false, 2, null);
            } else if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestRelayout$default(this, parent$ui_release, false, 2, null);
            }
        }
        return m1309remeasure_Sx5XlM$ui_release$default;
    }

    private final void recurseRemeasure(LayoutNode layoutNode) {
        remeasureOnly(layoutNode);
        MutableVector mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size <= 0) {
            remeasureOnly(layoutNode);
        }
        Object[] content = mutableVector.getContent();
        int i = 0;
        do {
            LayoutNode layoutNode2 = (LayoutNode) content[i];
            if (getMeasureAffectsParent(layoutNode2)) {
                recurseRemeasure(layoutNode2);
            }
            i++;
        } while (i < size);
        remeasureOnly(layoutNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0075  */
    /* renamed from: measureAndLayout-0kLqBqw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1347measureAndLayout0kLqBqw(androidx.compose.ui.node.LayoutNode r4, long r5) {
        /*
            r3 = this;
            java.lang.String r0 = "layoutNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.compose.ui.node.LayoutNode r0 = r3.root
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "Failed requirement."
            if (r0 == 0) goto L9e
            androidx.compose.ui.node.LayoutNode r0 = r3.root
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L94
            androidx.compose.ui.node.LayoutNode r0 = r3.root
            boolean r0 = r0.isPlaced()
            if (r0 == 0) goto L8a
            boolean r0 = r3.duringMeasureLayout
            r0 = r0 ^ r1
            if (r0 == 0) goto L80
            androidx.compose.ui.unit.Constraints r0 = r3.rootConstraints
            if (r0 == 0) goto L7c
            r3.duringMeasureLayout = r1
            r0 = 0
            androidx.compose.ui.node.DepthSortedSetsForDifferentPasses r1 = r3.relayoutNodes     // Catch: java.lang.Throwable -> L4a
            r1.remove(r4)     // Catch: java.lang.Throwable -> L4a
            androidx.compose.ui.unit.Constraints r1 = androidx.compose.ui.unit.Constraints.m1860boximpl(r5)     // Catch: java.lang.Throwable -> L4a
            boolean r1 = r3.m1345doLookaheadRemeasuresdFAvZA(r4, r1)     // Catch: java.lang.Throwable -> L4a
            androidx.compose.ui.unit.Constraints r5 = androidx.compose.ui.unit.Constraints.m1860boximpl(r5)     // Catch: java.lang.Throwable -> L4a
            r3.m1346doRemeasuresdFAvZA(r4, r5)     // Catch: java.lang.Throwable -> L4a
            if (r1 != 0) goto L4c
            boolean r5 = r4.getLookaheadLayoutPending$ui_release()     // Catch: java.lang.Throwable -> L4a
            if (r5 == 0) goto L5b
            goto L4c
        L4a:
            r4 = move-exception
            goto L79
        L4c:
            java.lang.Boolean r5 = r4.isPlacedInLookahead()     // Catch: java.lang.Throwable -> L4a
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L4a
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)     // Catch: java.lang.Throwable -> L4a
            if (r5 == 0) goto L5b
            r4.lookaheadReplace$ui_release()     // Catch: java.lang.Throwable -> L4a
        L5b:
            boolean r5 = r4.getLayoutPending$ui_release()     // Catch: java.lang.Throwable -> L4a
            if (r5 == 0) goto L6f
            boolean r5 = r4.isPlaced()     // Catch: java.lang.Throwable -> L4a
            if (r5 == 0) goto L6f
            r4.replace$ui_release()     // Catch: java.lang.Throwable -> L4a
            androidx.compose.ui.node.OnPositionedDispatcher r5 = r3.onPositionedDispatcher     // Catch: java.lang.Throwable -> L4a
            r5.onNodePositioned(r4)     // Catch: java.lang.Throwable -> L4a
        L6f:
            r3.duringMeasureLayout = r0
            androidx.compose.ui.node.LayoutTreeConsistencyChecker r4 = r3.consistencyChecker
            if (r4 == 0) goto L7c
            r4.assertConsistent()
            goto L7c
        L79:
            r3.duringMeasureLayout = r0
            throw r4
        L7c:
            r3.callOnLayoutCompletedListeners()
            return
        L80:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r2.toString()
            r4.<init>(r5)
            throw r4
        L8a:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r2.toString()
            r4.<init>(r5)
            throw r4
        L94:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r2.toString()
            r4.<init>(r5)
            throw r4
        L9e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r2.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MeasureAndLayoutDelegate.m1347measureAndLayout0kLqBqw(androidx.compose.ui.node.LayoutNode, long):void");
    }

    public final boolean measureAndLayout(Function0 function0) {
        boolean z;
        DepthSortedSet depthSortedSet;
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.root.isPlaced()) {
            if (!this.duringMeasureLayout) {
                boolean z2 = false;
                if (this.rootConstraints != null) {
                    this.duringMeasureLayout = true;
                    try {
                        if (this.relayoutNodes.isNotEmpty()) {
                            DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.relayoutNodes;
                            z = false;
                            while (depthSortedSetsForDifferentPasses.isNotEmpty()) {
                                depthSortedSet = depthSortedSetsForDifferentPasses.lookaheadSet;
                                boolean z3 = !depthSortedSet.isEmpty();
                                LayoutNode pop = (z3 ? depthSortedSetsForDifferentPasses.lookaheadSet : depthSortedSetsForDifferentPasses.set).pop();
                                boolean remeasureAndRelayoutIfNeeded = remeasureAndRelayoutIfNeeded(pop, z3);
                                if (pop == this.root && remeasureAndRelayoutIfNeeded) {
                                    z = true;
                                }
                            }
                            if (function0 != null) {
                                function0.invoke();
                            }
                        } else {
                            z = false;
                        }
                        this.duringMeasureLayout = false;
                        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                        if (layoutTreeConsistencyChecker != null) {
                            layoutTreeConsistencyChecker.assertConsistent();
                        }
                        z2 = z;
                    } catch (Throwable th) {
                        this.duringMeasureLayout = false;
                        throw th;
                    }
                }
                callOnLayoutCompletedListeners();
                return z2;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void measureOnly() {
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                recurseRemeasure(this.root);
                this.duringMeasureLayout = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                throw th;
            }
        }
    }

    static /* synthetic */ boolean remeasureAndRelayoutIfNeeded$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return measureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(layoutNode, z);
    }

    public final boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode, boolean z) {
        Constraints constraints;
        boolean m1345doLookaheadRemeasuresdFAvZA;
        boolean m1346doRemeasuresdFAvZA;
        int i = 0;
        if (layoutNode.isPlaced() || getCanAffectParent(layoutNode) || Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) || getCanAffectParentInLookahead(layoutNode) || layoutNode.getAlignmentLinesRequired$ui_release()) {
            if (layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getMeasurePending$ui_release()) {
                if (layoutNode == this.root) {
                    constraints = this.rootConstraints;
                    Intrinsics.checkNotNull(constraints);
                } else {
                    constraints = null;
                }
                m1345doLookaheadRemeasuresdFAvZA = (layoutNode.getLookaheadMeasurePending$ui_release() && z) ? m1345doLookaheadRemeasuresdFAvZA(layoutNode, constraints) : false;
                m1346doRemeasuresdFAvZA = m1346doRemeasuresdFAvZA(layoutNode, constraints);
            } else {
                m1346doRemeasuresdFAvZA = false;
                m1345doLookaheadRemeasuresdFAvZA = false;
            }
            if ((m1345doLookaheadRemeasuresdFAvZA || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual(layoutNode.isPlacedInLookahead(), Boolean.TRUE) && z) {
                layoutNode.lookaheadReplace$ui_release();
            }
            if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                if (layoutNode == this.root) {
                    layoutNode.place$ui_release(0, 0);
                } else {
                    layoutNode.replace$ui_release();
                }
                this.onPositionedDispatcher.onNodePositioned(layoutNode);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            }
            if (this.postponedMeasureRequests.isNotEmpty()) {
                MutableVector mutableVector = this.postponedMeasureRequests;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    do {
                        PostponedRequest postponedRequest = (PostponedRequest) content[i];
                        if (postponedRequest.getNode().isAttached()) {
                            if (!postponedRequest.isLookahead()) {
                                requestRemeasure(postponedRequest.getNode(), postponedRequest.isForced());
                            } else {
                                requestLookaheadRemeasure(postponedRequest.getNode(), postponedRequest.isForced());
                            }
                        }
                        i++;
                    } while (i < size);
                    this.postponedMeasureRequests.clear();
                } else {
                    this.postponedMeasureRequests.clear();
                }
            }
            return m1346doRemeasuresdFAvZA;
        }
        return false;
    }

    private final void callOnLayoutCompletedListeners() {
        MutableVector mutableVector = this.onLayoutCompletedListeners;
        int size = mutableVector.getSize();
        if (size <= 0) {
            this.onLayoutCompletedListeners.clear();
        }
        Object[] content = mutableVector.getContent();
        int i = 0;
        do {
            ((Owner.OnLayoutCompletedListener) content[i]).onLayoutComplete();
            i++;
        } while (i < size);
        this.onLayoutCompletedListeners.clear();
    }

    private final void remeasureOnly(LayoutNode layoutNode) {
        Constraints constraints;
        if (layoutNode.getMeasurePending$ui_release() || layoutNode.getLookaheadMeasurePending$ui_release()) {
            if (layoutNode == this.root) {
                constraints = this.rootConstraints;
                Intrinsics.checkNotNull(constraints);
            } else {
                constraints = null;
            }
            if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                m1345doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
            }
            m1346doRemeasuresdFAvZA(layoutNode, constraints);
        }
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode, final boolean z) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (this.relayoutNodes.isEmpty()) {
            return;
        }
        if (!this.duringMeasureLayout) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Function1 function1 = new Function1() { // from class: androidx.compose.ui.node.MeasureAndLayoutDelegate$forceMeasureTheSubtree$pending$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode it) {
                boolean measurePending$ui_release;
                Intrinsics.checkNotNullParameter(it, "it");
                if (z) {
                    measurePending$ui_release = it.getLookaheadMeasurePending$ui_release();
                } else {
                    measurePending$ui_release = it.getMeasurePending$ui_release();
                }
                return Boolean.valueOf(measurePending$ui_release);
            }
        };
        if (!((Boolean) function1.invoke(layoutNode)).booleanValue()) {
            MutableVector mutableVector = layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode2 = (LayoutNode) content[i];
                    if (((Boolean) function1.invoke(layoutNode2)).booleanValue() && this.relayoutNodes.remove(layoutNode2, z)) {
                        remeasureAndRelayoutIfNeeded(layoutNode2, z);
                    }
                    if (!((Boolean) function1.invoke(layoutNode2)).booleanValue()) {
                        forceMeasureTheSubtree(layoutNode2, z);
                    }
                    i++;
                } while (i < size);
                if (((Boolean) function1.invoke(layoutNode)).booleanValue() || !this.relayoutNodes.remove(layoutNode, z)) {
                    return;
                }
                remeasureAndRelayoutIfNeeded$default(this, layoutNode, false, 2, null);
                return;
            } else if (((Boolean) function1.invoke(layoutNode)).booleanValue()) {
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static /* synthetic */ void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public final void dispatchOnPositionedCallbacks(boolean z) {
        if (z) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void onNodeDetached(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.relayoutNodes.remove(node);
    }

    private final boolean getMeasureAffectsParent(LayoutNode layoutNode) {
        return layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode.getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release();
    }

    private final boolean getCanAffectParent(LayoutNode layoutNode) {
        return layoutNode.getMeasurePending$ui_release() && getMeasureAffectsParent(layoutNode);
    }

    private final boolean getCanAffectParentInLookahead(LayoutNode layoutNode) {
        AlignmentLines alignmentLines;
        if (layoutNode.getLookaheadMeasurePending$ui_release()) {
            if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                return true;
            }
            AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
            if (lookaheadAlignmentLinesOwner$ui_release != null && (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) != null && alignmentLines.getRequired$ui_release()) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: MeasureAndLayoutDelegate.kt */
    /* loaded from: classes.dex */
    public static final class PostponedRequest {
        private final boolean isForced;
        private final boolean isLookahead;
        private final LayoutNode node;

        public final LayoutNode getNode() {
            return this.node;
        }

        public final boolean isForced() {
            return this.isForced;
        }

        public final boolean isLookahead() {
            return this.isLookahead;
        }

        public PostponedRequest(LayoutNode node, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.isLookahead = z;
            this.isForced = z2;
        }
    }

    public final void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onLayoutCompletedListeners.add(listener);
    }
}
