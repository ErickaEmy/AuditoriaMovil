package androidx.compose.ui;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposedModifier.kt */
/* loaded from: classes.dex */
public final class CompositionLocalMapInjectionNode extends Modifier.Node {
    private CompositionLocalMap map;

    public CompositionLocalMapInjectionNode(CompositionLocalMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    public final void setMap(CompositionLocalMap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.map = value;
        DelegatableNodeKt.requireLayoutNode(this).setCompositionLocalMap(value);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        DelegatableNodeKt.requireLayoutNode(this).setCompositionLocalMap(this.map);
    }
}
