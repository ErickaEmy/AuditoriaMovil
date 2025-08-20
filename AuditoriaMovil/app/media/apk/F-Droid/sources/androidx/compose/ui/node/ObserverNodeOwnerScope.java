package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ObserverModifierNode.kt */
/* loaded from: classes.dex */
public final class ObserverNodeOwnerScope implements OwnerScope {
    public static final Companion Companion = new Companion(null);
    private static final Function1 OnObserveReadsChanged = new Function1() { // from class: androidx.compose.ui.node.ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ObserverNodeOwnerScope) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(ObserverNodeOwnerScope it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.isValidOwnerScope()) {
                it.getObserverNode$ui_release().onObservedReadsChanged();
            }
        }
    };
    private final ObserverModifierNode observerNode;

    public final ObserverModifierNode getObserverNode$ui_release() {
        return this.observerNode;
    }

    public ObserverNodeOwnerScope(ObserverModifierNode observerNode) {
        Intrinsics.checkNotNullParameter(observerNode, "observerNode");
        this.observerNode = observerNode;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.observerNode.getNode().isAttached();
    }

    /* compiled from: ObserverModifierNode.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function1 getOnObserveReadsChanged$ui_release() {
            return ObserverNodeOwnerScope.OnObserveReadsChanged;
        }
    }
}
