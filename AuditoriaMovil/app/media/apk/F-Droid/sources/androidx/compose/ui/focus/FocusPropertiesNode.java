package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusProperties.kt */
/* loaded from: classes.dex */
final class FocusPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    private Function1 focusPropertiesScope;

    public final void setFocusPropertiesScope(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.focusPropertiesScope = function1;
    }

    public FocusPropertiesNode(Function1 focusPropertiesScope) {
        Intrinsics.checkNotNullParameter(focusPropertiesScope, "focusPropertiesScope");
        this.focusPropertiesScope = focusPropertiesScope;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "focusProperties");
        this.focusPropertiesScope.invoke(focusProperties);
    }
}
