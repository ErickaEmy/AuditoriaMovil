package androidx.compose.ui;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
/* compiled from: Modifier.kt */
/* loaded from: classes.dex */
public interface Modifier {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Modifier.kt */
    /* loaded from: classes.dex */
    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Override // androidx.compose.ui.Modifier
        public boolean all(Function1 predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            return true;
        }

        @Override // androidx.compose.ui.Modifier
        public Object foldIn(Object obj, Function2 operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return obj;
        }

        @Override // androidx.compose.ui.Modifier
        public Modifier then(Modifier other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return other;
        }

        public String toString() {
            return "Modifier";
        }
    }

    boolean all(Function1 function1);

    Object foldIn(Object obj, Function2 function2);

    Modifier then(Modifier modifier);

    /* compiled from: Modifier.kt */
    /* renamed from: androidx.compose.ui.Modifier$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static Modifier $default$then(Modifier modifier, Modifier other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return other == Modifier.Companion ? modifier : new CombinedModifier(modifier, other);
        }
    }

    /* compiled from: Modifier.kt */
    /* loaded from: classes.dex */
    public interface Element extends Modifier {

        /* compiled from: Modifier.kt */
        /* renamed from: androidx.compose.ui.Modifier$Element$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public abstract /* synthetic */ class CC {
            public static Object $default$foldIn(Element element, Object obj, Function2 operation) {
                Intrinsics.checkNotNullParameter(operation, "operation");
                return operation.invoke(obj, element);
            }

            public static boolean $default$all(Element element, Function1 predicate) {
                Intrinsics.checkNotNullParameter(predicate, "predicate");
                return ((Boolean) predicate.invoke(element)).booleanValue();
            }
        }
    }

    /* compiled from: Modifier.kt */
    /* loaded from: classes.dex */
    public static abstract class Node implements DelegatableNode {
        private Node child;
        private NodeCoordinator coordinator;
        private boolean insertedNodeAwaitingAttachForInvalidation;
        private boolean isAttached;
        private int kindSet;
        private boolean onAttachRunExpected;
        private boolean onDetachRunExpected;
        private ObserverNodeOwnerScope ownerScope;
        private Node parent;
        private CoroutineScope scope;
        private boolean updatedNodeAwaitingAttachForInvalidation;
        private Node node = this;
        private int aggregateChildKindSet = -1;

        public final int getAggregateChildKindSet$ui_release() {
            return this.aggregateChildKindSet;
        }

        public final Node getChild$ui_release() {
            return this.child;
        }

        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        public final boolean getInsertedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.insertedNodeAwaitingAttachForInvalidation;
        }

        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final Node getNode() {
            return this.node;
        }

        public final ObserverNodeOwnerScope getOwnerScope$ui_release() {
            return this.ownerScope;
        }

        public final Node getParent$ui_release() {
            return this.parent;
        }

        public boolean getShouldAutoInvalidate() {
            return true;
        }

        public final boolean getUpdatedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.updatedNodeAwaitingAttachForInvalidation;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public void onReset() {
        }

        public final void setAggregateChildKindSet$ui_release(int i) {
            this.aggregateChildKindSet = i;
        }

        public final void setAsDelegateTo$ui_release(Node owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.node = owner;
        }

        public final void setChild$ui_release(Node node) {
            this.child = node;
        }

        public final void setInsertedNodeAwaitingAttachForInvalidation$ui_release(boolean z) {
            this.insertedNodeAwaitingAttachForInvalidation = z;
        }

        public final void setKindSet$ui_release(int i) {
            this.kindSet = i;
        }

        public final void setOwnerScope$ui_release(ObserverNodeOwnerScope observerNodeOwnerScope) {
            this.ownerScope = observerNodeOwnerScope;
        }

        public final void setParent$ui_release(Node node) {
            this.parent = node;
        }

        public final void setUpdatedNodeAwaitingAttachForInvalidation$ui_release(boolean z) {
            this.updatedNodeAwaitingAttachForInvalidation = z;
        }

        public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }

        public final CoroutineScope getCoroutineScope() {
            CoroutineScope coroutineScope = this.scope;
            if (coroutineScope == null) {
                CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(DelegatableNodeKt.requireOwner(this).getCoroutineContext().plus(JobKt.Job((Job) DelegatableNodeKt.requireOwner(this).getCoroutineContext().get(Job.Key))));
                this.scope = CoroutineScope;
                return CoroutineScope;
            }
            return coroutineScope;
        }

        public void markAsAttached$ui_release() {
            if (!(!this.isAttached)) {
                throw new IllegalStateException("node attached multiple times".toString());
            }
            if (this.coordinator == null) {
                throw new IllegalStateException("attach invoked on a node without a coordinator".toString());
            }
            this.isAttached = true;
            this.onAttachRunExpected = true;
        }

        public void runAttachLifecycle$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("Must run markAsAttached() prior to runAttachLifecycle".toString());
            }
            if (!this.onAttachRunExpected) {
                throw new IllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()".toString());
            }
            this.onAttachRunExpected = false;
            onAttach();
            this.onDetachRunExpected = true;
        }

        public void runDetachLifecycle$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("node detached multiple times".toString());
            }
            if (this.coordinator == null) {
                throw new IllegalStateException("detach invoked on a node without a coordinator".toString());
            }
            if (!this.onDetachRunExpected) {
                throw new IllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()".toString());
            }
            this.onDetachRunExpected = false;
            onDetach();
        }

        public void markAsDetached$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("Cannot detach a node that is not attached".toString());
            }
            if (!(!this.onAttachRunExpected)) {
                throw new IllegalStateException("Must run runAttachLifecycle() before markAsDetached()".toString());
            }
            if (!(!this.onDetachRunExpected)) {
                throw new IllegalStateException("Must run runDetachLifecycle() before markAsDetached()".toString());
            }
            this.isAttached = false;
            CoroutineScope coroutineScope = this.scope;
            if (coroutineScope != null) {
                CoroutineScopeKt.cancel(coroutineScope, new ModifierNodeDetachedCancellationException());
                this.scope = null;
            }
        }

        public void reset$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("Check failed.".toString());
            }
            onReset();
        }

        public final void sideEffect(Function0 effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(effect);
        }
    }
}
