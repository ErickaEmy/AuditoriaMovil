package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import ch.qos.logback.core.CoreConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public final class LayoutNodeSubcompositionsState {
    private final String NoIntrinsicsMessage;
    private CompositionContext compositionContext;
    private int currentIndex;
    private Function2 intermediateMeasurePolicy;
    private final IntermediateMeasureScopeImpl intermediateMeasureScope;
    private final Map nodeToNodeState;
    private final Map precomposeMap;
    private int precomposedCount;
    private int reusableCount;
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet;
    private final LayoutNode root;
    private final Scope scope;
    private final Map slotIdToNode;
    private SubcomposeSlotReusePolicy slotReusePolicy;

    public final Function2 getIntermediateMeasurePolicy$ui_release() {
        return this.intermediateMeasurePolicy;
    }

    public final void setCompositionContext(CompositionContext compositionContext) {
        this.compositionContext = compositionContext;
    }

    public final void setIntermediateMeasurePolicy$ui_release(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.intermediateMeasurePolicy = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public static final class NodeState {
        private final MutableState active$delegate;
        private Composition composition;
        private Function2 content;
        private boolean forceRecompose;
        private Object slotId;

        public final Composition getComposition() {
            return this.composition;
        }

        public final Function2 getContent() {
            return this.content;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setComposition(Composition composition) {
            this.composition = composition;
        }

        public final void setContent(Function2 function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.content = function2;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final boolean getActive() {
            return ((Boolean) this.active$delegate.getValue()).booleanValue();
        }

        public NodeState(Object obj, Function2 content, Composition composition) {
            MutableState mutableStateOf$default;
            Intrinsics.checkNotNullParameter(content, "content");
            this.slotId = obj;
            this.content = content;
            this.composition = composition;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            this.active$delegate = mutableStateOf$default;
        }

        public /* synthetic */ NodeState(Object obj, Function2 function2, Composition composition, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : composition);
        }

        public final void setActive(boolean z) {
            this.active$delegate.setValue(Boolean.valueOf(z));
        }
    }

    public final void forceRecomposeChildren() {
        for (Map.Entry entry : this.nodeToNodeState.entrySet()) {
            ((NodeState) entry.getValue()).setForceRecompose(true);
        }
        if (this.root.getMeasurePending$ui_release()) {
            return;
        }
        LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, 3, null);
    }

    public LayoutNodeSubcompositionsState(LayoutNode root, SubcomposeSlotReusePolicy slotReusePolicy) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(slotReusePolicy, "slotReusePolicy");
        this.root = root;
        this.slotReusePolicy = slotReusePolicy;
        this.nodeToNodeState = new LinkedHashMap();
        this.slotIdToNode = new LinkedHashMap();
        this.scope = new Scope();
        this.intermediateMeasureScope = new IntermediateMeasureScopeImpl();
        this.intermediateMeasurePolicy = new Function2() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return m1262invoke0kLqBqw((SubcomposeIntermediateMeasureScope) obj, ((Constraints) obj2).m1877unboximpl());
            }

            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
            public final MeasureResult m1262invoke0kLqBqw(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, long j) {
                Intrinsics.checkNotNullParameter(subcomposeIntermediateMeasureScope, "$this$null");
                return (MeasureResult) subcomposeIntermediateMeasureScope.getLookaheadMeasurePolicy().invoke(subcomposeIntermediateMeasureScope, Constraints.m1860boximpl(j));
            }
        };
        this.precomposeMap = new LinkedHashMap();
        this.reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet(null, 1, null);
        this.NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing,, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.slotReusePolicy != value) {
            this.slotReusePolicy = value;
            disposeOrReuseStartingFromIndex(0);
        }
    }

    public final List subcompose(Object obj, Function2 content) {
        Intrinsics.checkNotNullParameter(content, "content");
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState$ui_release = this.root.getLayoutState$ui_release();
        LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Measuring;
        if (layoutState$ui_release != layoutState && layoutState$ui_release != LayoutNode.LayoutState.LayingOut && layoutState$ui_release != LayoutNode.LayoutState.LookaheadMeasuring && layoutState$ui_release != LayoutNode.LayoutState.LookaheadLayingOut) {
            throw new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
        }
        Map map = this.slotIdToNode;
        Object obj2 = map.get(obj);
        if (obj2 == null) {
            obj2 = (LayoutNode) this.precomposeMap.remove(obj);
            if (obj2 != null) {
                int i = this.precomposedCount;
                if (i <= 0) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                this.precomposedCount = i - 1;
            } else {
                obj2 = takeNodeFromReusables(obj);
                if (obj2 == null) {
                    obj2 = createNodeAt(this.currentIndex);
                }
            }
            map.put(obj, obj2);
        }
        LayoutNode layoutNode = (LayoutNode) obj2;
        int indexOf = this.root.getFoldedChildren$ui_release().indexOf(layoutNode);
        int i2 = this.currentIndex;
        if (indexOf < i2) {
            throw new IllegalArgumentException(("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
        }
        if (i2 != indexOf) {
            move$default(this, indexOf, i2, 0, 4, null);
        }
        this.currentIndex++;
        subcompose(layoutNode, obj, content);
        if (layoutState$ui_release == layoutState || layoutState$ui_release == LayoutNode.LayoutState.LayingOut) {
            return layoutNode.getChildMeasurables$ui_release();
        }
        return layoutNode.getChildLookaheadMeasurables$ui_release();
    }

    private final void subcompose(LayoutNode layoutNode, final NodeState nodeState) {
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            LayoutNode layoutNode2 = this.root;
            layoutNode2.ignoreRemeasureRequests = true;
            final Function2 content = nodeState.getContent();
            Composition composition = nodeState.getComposition();
            CompositionContext compositionContext = this.compositionContext;
            if (compositionContext != null) {
                nodeState.setComposition(subcomposeInto(composition, layoutNode, compositionContext, ComposableLambdaKt.composableLambdaInstance(-34810602, true, new Function2() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        if ((i & 11) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-34810602, i, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:700)");
                        }
                        boolean active = LayoutNodeSubcompositionsState.NodeState.this.getActive();
                        Function2 function2 = content;
                        composer.startReusableGroup(207, Boolean.valueOf(active));
                        boolean changed = composer.changed(active);
                        if (active) {
                            function2.invoke(composer, 0);
                        } else {
                            composer.deactivateToEndGroup(changed);
                        }
                        composer.endReusableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                })));
                layoutNode2.ignoreRemeasureRequests = false;
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                return;
            }
            throw new IllegalStateException("parent composition reference not set".toString());
        } finally {
            createNonObservableSnapshot.dispose();
        }
    }

    private final Composition subcomposeInto(Composition composition, LayoutNode layoutNode, CompositionContext compositionContext, Function2 function2) {
        if (composition == null || composition.isDisposed()) {
            composition = Wrapper_androidKt.createSubcomposition(layoutNode, compositionContext);
        }
        composition.setContent(function2);
        return composition;
    }

    private final Object getSlotIdAtIndex(int i) {
        Object obj = this.nodeToNodeState.get((LayoutNode) this.root.getFoldedChildren$ui_release().get(i));
        Intrinsics.checkNotNull(obj);
        return ((NodeState) obj).getSlotId();
    }

    public final void disposeOrReuseStartingFromIndex(int i) {
        this.reusableCount = 0;
        int size = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - 1;
        if (i <= size) {
            this.reusableSlotIdsSet.clear();
            if (i <= size) {
                int i2 = i;
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(i2));
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                boolean z = false;
                while (size >= i) {
                    LayoutNode layoutNode = (LayoutNode) this.root.getFoldedChildren$ui_release().get(size);
                    Object obj = this.nodeToNodeState.get(layoutNode);
                    Intrinsics.checkNotNull(obj);
                    NodeState nodeState = (NodeState) obj;
                    Object slotId = nodeState.getSlotId();
                    if (!this.reusableSlotIdsSet.contains(slotId)) {
                        LayoutNode layoutNode2 = this.root;
                        layoutNode2.ignoreRemeasureRequests = true;
                        this.nodeToNodeState.remove(layoutNode);
                        Composition composition = nodeState.getComposition();
                        if (composition != null) {
                            composition.dispose();
                        }
                        this.root.removeAt$ui_release(size, 1);
                        layoutNode2.ignoreRemeasureRequests = false;
                    } else {
                        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
                        LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
                        measurePassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
                        if (lookaheadPassDelegate$ui_release != null) {
                            lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(usageByParent);
                        }
                        this.reusableCount++;
                        if (nodeState.getActive()) {
                            nodeState.setActive(false);
                            z = true;
                        }
                    }
                    this.slotIdToNode.remove(slotId);
                    size--;
                }
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                if (z) {
                    Snapshot.Companion.sendApplyNotifications();
                }
            } finally {
                createNonObservableSnapshot.dispose();
            }
        }
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        if (this.nodeToNodeState.size() != this.root.getFoldedChildren$ui_release().size()) {
            throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.size() + ") and the children count on the SubcomposeLayout (" + this.root.getFoldedChildren$ui_release().size() + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
        } else if ((this.root.getFoldedChildren$ui_release().size() - this.reusableCount) - this.precomposedCount < 0) {
            throw new IllegalArgumentException(("Incorrect state. Total children " + this.root.getFoldedChildren$ui_release().size() + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount).toString());
        } else if (this.precomposeMap.size() == this.precomposedCount) {
        } else {
            throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.size()).toString());
        }
    }

    private final LayoutNode takeNodeFromReusables(Object obj) {
        int i;
        if (this.reusableCount == 0) {
            return null;
        }
        int size = this.root.getFoldedChildren$ui_release().size() - this.precomposedCount;
        int i2 = size - this.reusableCount;
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            if (i4 < i2) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(getSlotIdAtIndex(i4), obj)) {
                i = i4;
                break;
            } else {
                i4--;
            }
        }
        if (i == -1) {
            while (true) {
                if (i3 < i2) {
                    i4 = i3;
                    break;
                }
                Object obj2 = this.nodeToNodeState.get((LayoutNode) this.root.getFoldedChildren$ui_release().get(i3));
                Intrinsics.checkNotNull(obj2);
                NodeState nodeState = (NodeState) obj2;
                if (this.slotReusePolicy.areCompatible(obj, nodeState.getSlotId())) {
                    nodeState.setSlotId(obj);
                    i4 = i3;
                    i = i4;
                    break;
                }
                i3--;
            }
        }
        if (i == -1) {
            return null;
        }
        if (i4 != i2) {
            move(i4, i2, 1);
        }
        this.reusableCount--;
        LayoutNode layoutNode = (LayoutNode) this.root.getFoldedChildren$ui_release().get(i2);
        Object obj3 = this.nodeToNodeState.get(layoutNode);
        Intrinsics.checkNotNull(obj3);
        NodeState nodeState2 = (NodeState) obj3;
        nodeState2.setActive(true);
        nodeState2.setForceRecompose(true);
        Snapshot.Companion.sendApplyNotifications();
        return layoutNode;
    }

    public final MeasurePolicy createMeasurePolicy(final Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.intermediateMeasureScope.setLookaheadMeasurePolicy(block);
        final String str = this.NoIntrinsicsMessage;
        return new LayoutNode.NoIntrinsicsMeasurePolicy(str) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
            /* JADX WARN: Code restructure failed: missing block: B:5:0x004b, code lost:
                if (r3.getLayoutState$ui_release() == androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut) goto L8;
             */
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public androidx.compose.ui.layout.MeasureResult mo13measure3p2s80s(androidx.compose.ui.layout.MeasureScope r3, java.util.List r4, long r5) {
                /*
                    r2 = this;
                    java.lang.String r0 = "$this$measure"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    java.lang.String r0 = "measurables"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getScope$p(r4)
                    androidx.compose.ui.unit.LayoutDirection r0 = r3.getLayoutDirection()
                    r4.setLayoutDirection(r0)
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getScope$p(r4)
                    float r0 = r3.getDensity()
                    r4.setDensity(r0)
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getScope$p(r4)
                    float r3 = r3.getFontScale()
                    r4.setFontScale(r3)
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.node.LayoutNode r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getRoot$p(r3)
                    androidx.compose.ui.node.LayoutNode$LayoutState r3 = r3.getLayoutState$ui_release()
                    androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
                    if (r3 == r4) goto L4d
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.node.LayoutNode r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getRoot$p(r3)
                    androidx.compose.ui.node.LayoutNode$LayoutState r3 = r3.getLayoutState$ui_release()
                    androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut
                    if (r3 != r4) goto L70
                L4d:
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.node.LayoutNode r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getRoot$p(r3)
                    androidx.compose.ui.node.LayoutNode r3 = r3.getLookaheadRoot$ui_release()
                    if (r3 == 0) goto L70
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    kotlin.jvm.functions.Function2 r3 = r3.getIntermediateMeasurePolicy$ui_release()
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState$IntermediateMeasureScopeImpl r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getIntermediateMeasureScope$p(r4)
                    androidx.compose.ui.unit.Constraints r5 = androidx.compose.ui.unit.Constraints.m1860boximpl(r5)
                    java.lang.Object r3 = r3.invoke(r4, r5)
                    androidx.compose.ui.layout.MeasureResult r3 = (androidx.compose.ui.layout.MeasureResult) r3
                    return r3
                L70:
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    r4 = 0
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$setCurrentIndex$p(r3, r4)
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState$IntermediateMeasureScopeImpl r3 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getIntermediateMeasureScope$p(r3)
                    r3.m1260setLookaheadConstraintsBRTryo0(r5)
                    kotlin.jvm.functions.Function2 r3 = r2
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getScope$p(r4)
                    androidx.compose.ui.unit.Constraints r5 = androidx.compose.ui.unit.Constraints.m1860boximpl(r5)
                    java.lang.Object r3 = r3.invoke(r4, r5)
                    androidx.compose.ui.layout.MeasureResult r3 = (androidx.compose.ui.layout.MeasureResult) r3
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    int r4 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getCurrentIndex$p(r4)
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r5 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState$IntermediateMeasureScopeImpl r5 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.access$getIntermediateMeasureScope$p(r5)
                    int r6 = r3.getWidth()
                    int r0 = r3.getHeight()
                    long r0 = androidx.compose.ui.unit.IntSizeKt.IntSize(r6, r0)
                    r5.m1261setLookaheadSizeozmzZPI(r0)
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1 r5 = new androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1
                    androidx.compose.ui.layout.LayoutNodeSubcompositionsState r6 = androidx.compose.ui.layout.LayoutNodeSubcompositionsState.this
                    r5.<init>()
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.mo13measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
            }
        };
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(final Object obj, Function2 content) {
        Intrinsics.checkNotNullParameter(content, "content");
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(obj)) {
            Map map = this.precomposeMap;
            Object obj2 = map.get(obj);
            Object obj3 = obj2;
            if (obj2 == null) {
                LayoutNode takeNodeFromReusables = takeNodeFromReusables(obj);
                if (takeNodeFromReusables != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(takeNodeFromReusables), this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                } else {
                    takeNodeFromReusables = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    this.precomposedCount++;
                }
                map.put(obj, takeNodeFromReusables);
                obj3 = takeNodeFromReusables;
            }
            subcompose((LayoutNode) obj3, obj, content);
        }
        return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$precompose$1
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void dispose() {
                Map map2;
                int i;
                LayoutNode layoutNode;
                LayoutNode layoutNode2;
                int i2;
                int i3;
                int i4;
                LayoutNode layoutNode3;
                int i5;
                int i6;
                LayoutNodeSubcompositionsState.this.makeSureStateIsConsistent();
                map2 = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode4 = (LayoutNode) map2.remove(obj);
                if (layoutNode4 != null) {
                    i = LayoutNodeSubcompositionsState.this.precomposedCount;
                    if (i > 0) {
                        layoutNode = LayoutNodeSubcompositionsState.this.root;
                        int indexOf = layoutNode.getFoldedChildren$ui_release().indexOf(layoutNode4);
                        layoutNode2 = LayoutNodeSubcompositionsState.this.root;
                        int size = layoutNode2.getFoldedChildren$ui_release().size();
                        i2 = LayoutNodeSubcompositionsState.this.precomposedCount;
                        if (indexOf >= size - i2) {
                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                            i3 = layoutNodeSubcompositionsState.reusableCount;
                            layoutNodeSubcompositionsState.reusableCount = i3 + 1;
                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = LayoutNodeSubcompositionsState.this;
                            i4 = layoutNodeSubcompositionsState2.precomposedCount;
                            layoutNodeSubcompositionsState2.precomposedCount = i4 - 1;
                            layoutNode3 = LayoutNodeSubcompositionsState.this.root;
                            int size2 = layoutNode3.getFoldedChildren$ui_release().size();
                            i5 = LayoutNodeSubcompositionsState.this.precomposedCount;
                            int i7 = size2 - i5;
                            i6 = LayoutNodeSubcompositionsState.this.reusableCount;
                            int i8 = i7 - i6;
                            LayoutNodeSubcompositionsState.this.move(indexOf, i8, 1);
                            LayoutNodeSubcompositionsState.this.disposeOrReuseStartingFromIndex(i8);
                            return;
                        }
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public int getPlaceablesCount() {
                Map map2;
                List children$ui_release;
                map2 = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode = (LayoutNode) map2.get(obj);
                if (layoutNode == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
                    return 0;
                }
                return children$ui_release.size();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: premeasure-0kLqBqw  reason: not valid java name */
            public void mo1263premeasure0kLqBqw(int i, long j) {
                Map map2;
                LayoutNode layoutNode;
                map2 = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode2 = (LayoutNode) map2.get(obj);
                if (layoutNode2 == null || !layoutNode2.isAttached()) {
                    return;
                }
                int size = layoutNode2.getChildren$ui_release().size();
                if (i < 0 || i >= size) {
                    throw new IndexOutOfBoundsException("Index (" + i + ") is out of bound of [0, " + size + CoreConstants.RIGHT_PARENTHESIS_CHAR);
                } else if (!layoutNode2.isPlaced()) {
                    layoutNode = LayoutNodeSubcompositionsState.this.root;
                    layoutNode.ignoreRemeasureRequests = true;
                    LayoutNodeKt.requireOwner(layoutNode2).mo1395measureAndLayout0kLqBqw((LayoutNode) layoutNode2.getChildren$ui_release().get(i), j);
                    layoutNode.ignoreRemeasureRequests = false;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        };
    }

    private final LayoutNode createNodeAt(int i) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, null);
        LayoutNode layoutNode2 = this.root;
        layoutNode2.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(i, layoutNode);
        layoutNode2.ignoreRemeasureRequests = false;
        return layoutNode;
    }

    static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            return this.fontScale;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public /* synthetic */ MeasureResult layout(int i, int i2, Map map, Function1 function1) {
            return MeasureScope.CC.$default$layout(this, i, i2, map, function1);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public /* synthetic */ int mo150roundToPx0680j_4(float f) {
            return Density.CC.m1887$default$roundToPx0680j_4(this, f);
        }

        public void setDensity(float f) {
            this.density = f;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
            this.layoutDirection = layoutDirection;
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo151toDpu2uoSUM(float f) {
            float m1897constructorimpl;
            m1897constructorimpl = Dp.m1897constructorimpl(f / getDensity());
            return m1897constructorimpl;
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo152toDpu2uoSUM(int i) {
            float m1897constructorimpl;
            m1897constructorimpl = Dp.m1897constructorimpl(i / getDensity());
            return m1897constructorimpl;
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public /* synthetic */ long mo153toDpSizekrfVVM(long j) {
            return Density.CC.m1890$default$toDpSizekrfVVM(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public /* synthetic */ float mo154toPxR2X_6o(long j) {
            return Density.CC.m1891$default$toPxR2X_6o(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public /* synthetic */ float mo155toPx0680j_4(float f) {
            return Density.CC.m1892$default$toPx0680j_4(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public /* synthetic */ long mo156toSizeXkaWNTQ(long j) {
            return Density.CC.m1893$default$toSizeXkaWNTQ(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo157toSpkPz2Gy4(float f) {
            long sp;
            sp = TextUnitKt.getSp(f / (getFontScale() * getDensity()));
            return sp;
        }

        public Scope() {
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List subcompose(Object obj, Function2 content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return LayoutNodeSubcompositionsState.this.subcompose(obj, content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public final class IntermediateMeasureScopeImpl implements SubcomposeIntermediateMeasureScope, MeasureScope {
        private final /* synthetic */ Scope $$delegate_0;
        public Function2 lookaheadMeasurePolicy;
        private long lookaheadSize = IntSize.Companion.m1955getZeroYbymL2g();
        private long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int i, int i2, Map alignmentLines, Function1 placementBlock) {
            Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
            Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
            return this.$$delegate_0.layout(i, i2, alignmentLines, placementBlock);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo150roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo150roundToPx0680j_4(f);
        }

        /* renamed from: setLookaheadConstraints-BRTryo0  reason: not valid java name */
        public void m1260setLookaheadConstraintsBRTryo0(long j) {
            this.lookaheadConstraints = j;
        }

        public void setLookaheadMeasurePolicy(Function2 function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.lookaheadMeasurePolicy = function2;
        }

        /* renamed from: setLookaheadSize-ozmzZPI  reason: not valid java name */
        public void m1261setLookaheadSizeozmzZPI(long j) {
            this.lookaheadSize = j;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public /* synthetic */ List subcompose(Object obj, Function2 function2) {
            return SubcomposeIntermediateMeasureScope.CC.$default$subcompose(this, obj, function2);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo151toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo151toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo152toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo152toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo153toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo153toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo154toPxR2X_6o(long j) {
            return this.$$delegate_0.mo154toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo155toPx0680j_4(float f) {
            return this.$$delegate_0.mo155toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo156toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo156toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo157toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo157toSpkPz2Gy4(f);
        }

        public IntermediateMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        @Override // androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope
        public List measurablesForSlot(Object obj) {
            List emptyList;
            List childMeasurables$ui_release;
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.slotIdToNode.get(obj);
            if (layoutNode == null || (childMeasurables$ui_release = layoutNode.getChildMeasurables$ui_release()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return childMeasurables$ui_release;
        }

        @Override // androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope
        public Function2 getLookaheadMeasurePolicy() {
            Function2 function2 = this.lookaheadMeasurePolicy;
            if (function2 != null) {
                return function2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("lookaheadMeasurePolicy");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void move(int i, int i2, int i3) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        this.root.move$ui_release(i, i2, i3);
        layoutNode.ignoreRemeasureRequests = false;
    }

    public final void disposeCurrentNodes() {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        for (NodeState nodeState : this.nodeToNodeState.values()) {
            Composition composition = nodeState.getComposition();
            if (composition != null) {
                composition.dispose();
            }
        }
        this.root.removeAll$ui_release();
        layoutNode.ignoreRemeasureRequests = false;
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    private final void subcompose(LayoutNode layoutNode, Object obj, Function2 function2) {
        Map map = this.nodeToNodeState;
        Object obj2 = map.get(layoutNode);
        if (obj2 == null) {
            obj2 = new NodeState(obj, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.m1241getLambda1$ui_release(), null, 4, null);
            map.put(layoutNode, obj2);
        }
        NodeState nodeState = (NodeState) obj2;
        Composition composition = nodeState.getComposition();
        boolean hasInvalidations = composition != null ? composition.getHasInvalidations() : true;
        if (nodeState.getContent() != function2 || hasInvalidations || nodeState.getForceRecompose()) {
            nodeState.setContent(function2);
            subcompose(layoutNode, nodeState);
            nodeState.setForceRecompose(false);
        }
    }
}
