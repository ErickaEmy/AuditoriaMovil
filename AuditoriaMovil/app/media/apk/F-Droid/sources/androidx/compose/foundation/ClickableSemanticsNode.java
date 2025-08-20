package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
final class ClickableSemanticsNode extends Modifier.Node implements SemanticsModifierNode {
    private boolean enabled;
    private Function0 onClick;
    private String onClickLabel;
    private Function0 onLongClick;
    private String onLongClickLabel;
    private Role role;

    public /* synthetic */ ClickableSemanticsNode(boolean z, String str, Role role, Function0 function0, String str2, Function0 function02, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, role, function0, str2, function02);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    /* renamed from: update-UMe6uN4  reason: not valid java name */
    public final void m100updateUMe6uN4(boolean z, String str, Role role, Function0 onClick, String str2, Function0 function0) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = onClick;
        this.onLongClickLabel = str2;
        this.onLongClick = function0;
    }

    private ClickableSemanticsNode(boolean z, String str, Role role, Function0 onClick, String str2, Function0 function0) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = onClick;
        this.onLongClickLabel = str2;
        this.onLongClick = function0;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Role role = this.role;
        if (role != null) {
            Intrinsics.checkNotNull(role);
            SemanticsPropertiesKt.m1495setRolekuIjeqM(semanticsPropertyReceiver, role.m1481unboximpl());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.onClickLabel, new Function0() { // from class: androidx.compose.foundation.ClickableSemanticsNode$applySemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Function0 function0;
                function0 = ClickableSemanticsNode.this.onClick;
                function0.invoke();
                return Boolean.TRUE;
            }
        });
        if (this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.onLongClickLabel, new Function0() { // from class: androidx.compose.foundation.ClickableSemanticsNode$applySemantics$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    Function0 function0;
                    function0 = ClickableSemanticsNode.this.onLongClick;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return Boolean.TRUE;
                }
            });
        }
        if (this.enabled) {
            return;
        }
        SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
    }
}
