package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposeUiNode.kt */
/* loaded from: classes.dex */
public interface ComposeUiNode {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: ComposeUiNode.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Function0 Constructor = LayoutNode.Companion.getConstructor$ui_release();
        private static final Function0 VirtualConstructor = new Function0() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$VirtualConstructor$1
            @Override // kotlin.jvm.functions.Function0
            public final LayoutNode invoke() {
                return new LayoutNode(true, 0, 2, null);
            }
        };
        private static final Function2 SetModifier = new Function2() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ComposeUiNode) obj, (Modifier) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(ComposeUiNode composeUiNode, Modifier it) {
                Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                composeUiNode.setModifier(it);
            }
        };
        private static final Function2 SetDensity = new Function2() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetDensity$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ComposeUiNode) obj, (Density) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(ComposeUiNode composeUiNode, Density it) {
                Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                composeUiNode.setDensity(it);
            }
        };
        private static final Function2 SetResolvedCompositionLocals = new Function2() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ComposeUiNode) obj, (CompositionLocalMap) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(ComposeUiNode composeUiNode, CompositionLocalMap it) {
                Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                composeUiNode.setCompositionLocalMap(it);
            }
        };
        private static final Function2 SetMeasurePolicy = new Function2() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ComposeUiNode) obj, (MeasurePolicy) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(ComposeUiNode composeUiNode, MeasurePolicy it) {
                Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                composeUiNode.setMeasurePolicy(it);
            }
        };
        private static final Function2 SetLayoutDirection = new Function2() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetLayoutDirection$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ComposeUiNode) obj, (LayoutDirection) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(ComposeUiNode composeUiNode, LayoutDirection it) {
                Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                composeUiNode.setLayoutDirection(it);
            }
        };
        private static final Function2 SetViewConfiguration = new Function2() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetViewConfiguration$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ComposeUiNode) obj, (ViewConfiguration) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(ComposeUiNode composeUiNode, ViewConfiguration it) {
                Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
                Intrinsics.checkNotNullParameter(it, "it");
                composeUiNode.setViewConfiguration(it);
            }
        };
        private static final Function2 SetCompositeKeyHash = new Function2() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((ComposeUiNode) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ComposeUiNode composeUiNode, int i) {
                Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
                composeUiNode.setCompositeKeyHash(i);
            }
        };

        private Companion() {
        }

        public final Function0 getConstructor() {
            return Constructor;
        }

        public final Function2 getSetCompositeKeyHash() {
            return SetCompositeKeyHash;
        }

        public final Function2 getSetDensity() {
            return SetDensity;
        }

        public final Function2 getSetLayoutDirection() {
            return SetLayoutDirection;
        }

        public final Function2 getSetMeasurePolicy() {
            return SetMeasurePolicy;
        }

        public final Function2 getSetModifier() {
            return SetModifier;
        }

        public final Function2 getSetResolvedCompositionLocals() {
            return SetResolvedCompositionLocals;
        }

        public final Function2 getSetViewConfiguration() {
            return SetViewConfiguration;
        }
    }

    void setCompositeKeyHash(int i);

    void setCompositionLocalMap(CompositionLocalMap compositionLocalMap);

    void setDensity(Density density);

    void setLayoutDirection(LayoutDirection layoutDirection);

    void setMeasurePolicy(MeasurePolicy measurePolicy);

    void setModifier(Modifier modifier);

    void setViewConfiguration(ViewConfiguration viewConfiguration);
}
