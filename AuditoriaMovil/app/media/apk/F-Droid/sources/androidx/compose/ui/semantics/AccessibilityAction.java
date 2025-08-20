package androidx.compose.ui.semantics;

import ch.qos.logback.core.CoreConstants;
import kotlin.Function;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class AccessibilityAction {
    private final Function action;
    private final String label;

    public final Function getAction() {
        return this.action;
    }

    public final String getLabel() {
        return this.label;
    }

    public AccessibilityAction(String str, Function function) {
        this.label = str;
        this.action = function;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityAction) {
            AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
            return Intrinsics.areEqual(this.label, accessibilityAction.label) && Intrinsics.areEqual(this.action, accessibilityAction.action);
        }
        return false;
    }

    public int hashCode() {
        String str = this.label;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Function function = this.action;
        return hashCode + (function != null ? function.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityAction(label=" + this.label + ", action=" + this.action + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
