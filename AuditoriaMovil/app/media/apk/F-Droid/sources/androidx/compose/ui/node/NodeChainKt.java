package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ActualKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: NodeChain.kt */
/* loaded from: classes.dex */
public abstract class NodeChainKt {
    private static final NodeChainKt$SentinelHead$1 SentinelHead;

    public static final /* synthetic */ MutableVector access$fillVector(Modifier modifier, MutableVector mutableVector) {
        return fillVector(modifier, mutableVector);
    }

    public static final /* synthetic */ NodeChainKt$SentinelHead$1 access$getSentinelHead$p() {
        return SentinelHead;
    }

    public static final /* synthetic */ void access$updateUnsafe(ModifierNodeElement modifierNodeElement, Modifier.Node node) {
        updateUnsafe(modifierNodeElement, node);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.Modifier$Node, androidx.compose.ui.node.NodeChainKt$SentinelHead$1] */
    static {
        ?? r0 = new Modifier.Node() { // from class: androidx.compose.ui.node.NodeChainKt$SentinelHead$1
            public String toString() {
                return "<Head>";
            }
        };
        r0.setAggregateChildKindSet$ui_release(-1);
        SentinelHead = r0;
    }

    public static final int actionForModifiers(Modifier.Element prev, Modifier.Element next) {
        Intrinsics.checkNotNullParameter(prev, "prev");
        Intrinsics.checkNotNullParameter(next, "next");
        if (Intrinsics.areEqual(prev, next)) {
            return 2;
        }
        return (ActualKt.areObjectsOfSameType(prev, next) || ((prev instanceof ForceUpdateElement) && ActualKt.areObjectsOfSameType(((ForceUpdateElement) prev).getOriginal(), next))) ? 1 : 0;
    }

    public static final void updateUnsafe(ModifierNodeElement modifierNodeElement, Modifier.Node node) {
        Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        modifierNodeElement.update(node);
    }

    public static final MutableVector fillVector(Modifier modifier, final MutableVector mutableVector) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mutableVector.getSize(), 16);
        MutableVector mutableVector2 = new MutableVector(new Modifier[coerceAtLeast], 0);
        mutableVector2.add(modifier);
        while (mutableVector2.isNotEmpty()) {
            Modifier modifier2 = (Modifier) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if (modifier2 instanceof CombinedModifier) {
                CombinedModifier combinedModifier = (CombinedModifier) modifier2;
                mutableVector2.add(combinedModifier.getInner$ui_release());
                mutableVector2.add(combinedModifier.getOuter$ui_release());
            } else if (modifier2 instanceof Modifier.Element) {
                mutableVector.add(modifier2);
            } else {
                modifier2.all(new Function1() { // from class: androidx.compose.ui.node.NodeChainKt$fillVector$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Modifier.Element it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        MutableVector.this.add(it);
                        return Boolean.TRUE;
                    }
                });
            }
        }
        return mutableVector;
    }
}
