package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public final class SubcomposeLayoutState {
    public static final int $stable = 8;
    private LayoutNodeSubcompositionsState _state;
    private final Function2 setCompositionContext;
    private final Function2 setIntermediateMeasurePolicy;
    private final Function2 setMeasurePolicy;
    private final Function2 setRoot;
    private final SubcomposeSlotReusePolicy slotReusePolicy;

    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public interface PrecomposedSlotHandle {
        void dispose();

        int getPlaceablesCount();

        /* renamed from: premeasure-0kLqBqw */
        void mo1263premeasure0kLqBqw(int i, long j);
    }

    public final Function2 getSetCompositionContext$ui_release() {
        return this.setCompositionContext;
    }

    public final Function2 getSetIntermediateMeasurePolicy$ui_release() {
        return this.setIntermediateMeasurePolicy;
    }

    public final Function2 getSetMeasurePolicy$ui_release() {
        return this.setMeasurePolicy;
    }

    public final Function2 getSetRoot$ui_release() {
        return this.setRoot;
    }

    public SubcomposeLayoutState(SubcomposeSlotReusePolicy slotReusePolicy) {
        Intrinsics.checkNotNullParameter(slotReusePolicy, "slotReusePolicy");
        this.slotReusePolicy = slotReusePolicy;
        this.setRoot = new Function2() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (SubcomposeLayoutState) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode, SubcomposeLayoutState it) {
                LayoutNodeSubcompositionsState state;
                LayoutNodeSubcompositionsState state2;
                SubcomposeSlotReusePolicy subcomposeSlotReusePolicy;
                SubcomposeSlotReusePolicy subcomposeSlotReusePolicy2;
                Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                SubcomposeLayoutState subcomposeLayoutState = SubcomposeLayoutState.this;
                LayoutNodeSubcompositionsState subcompositionsState$ui_release = layoutNode.getSubcompositionsState$ui_release();
                if (subcompositionsState$ui_release == null) {
                    subcomposeSlotReusePolicy2 = SubcomposeLayoutState.this.slotReusePolicy;
                    subcompositionsState$ui_release = new LayoutNodeSubcompositionsState(layoutNode, subcomposeSlotReusePolicy2);
                    layoutNode.setSubcompositionsState$ui_release(subcompositionsState$ui_release);
                }
                subcomposeLayoutState._state = subcompositionsState$ui_release;
                state = SubcomposeLayoutState.this.getState();
                state.makeSureStateIsConsistent();
                state2 = SubcomposeLayoutState.this.getState();
                subcomposeSlotReusePolicy = SubcomposeLayoutState.this.slotReusePolicy;
                state2.setSlotReusePolicy(subcomposeSlotReusePolicy);
            }
        };
        this.setCompositionContext = new Function2() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setCompositionContext$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (CompositionContext) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode, CompositionContext it) {
                LayoutNodeSubcompositionsState state;
                Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                state = SubcomposeLayoutState.this.getState();
                state.setCompositionContext(it);
            }
        };
        this.setMeasurePolicy = new Function2() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setMeasurePolicy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (Function2) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode, Function2 it) {
                LayoutNodeSubcompositionsState state;
                Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                state = SubcomposeLayoutState.this.getState();
                layoutNode.setMeasurePolicy(state.createMeasurePolicy(it));
            }
        };
        this.setIntermediateMeasurePolicy = new Function2() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setIntermediateMeasurePolicy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((LayoutNode) obj, (Function2) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutNode layoutNode, Function2 it) {
                LayoutNodeSubcompositionsState state;
                Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                state = SubcomposeLayoutState.this.getState();
                state.setIntermediateMeasurePolicy$ui_release(it);
            }
        };
    }

    public SubcomposeLayoutState() {
        this(NoOpSubcomposeSlotReusePolicy.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this._state;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout".toString());
    }

    public final PrecomposedSlotHandle precompose(Object obj, Function2 content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return getState().precompose(obj, content);
    }

    public final void forceRecomposeChildren$ui_release() {
        getState().forceRecomposeChildren();
    }

    public final void disposeCurrentNodes$ui_release() {
        getState().disposeCurrentNodes();
    }
}
