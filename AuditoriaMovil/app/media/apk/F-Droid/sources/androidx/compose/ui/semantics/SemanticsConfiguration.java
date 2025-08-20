package androidx.compose.ui.semantics;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: SemanticsConfiguration.kt */
/* loaded from: classes.dex */
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable, KMappedMarker {
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;
    private final Map props = new LinkedHashMap();

    public final boolean isClearingSemantics() {
        return this.isClearingSemantics;
    }

    public final boolean isMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    public final void setClearingSemantics(boolean z) {
        this.isClearingSemantics = z;
    }

    public final void setMergingSemanticsOfDescendants(boolean z) {
        this.isMergingSemanticsOfDescendants = z;
    }

    public final Object get(SemanticsPropertyKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.props.get(key);
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException("Key not present: " + key + " - consider getOrElse or getOrNull");
    }

    public final Object getOrElse(SemanticsPropertyKey key, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object obj = this.props.get(key);
        return obj == null ? defaultValue.invoke() : obj;
    }

    public final Object getOrElseNullable(SemanticsPropertyKey key, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object obj = this.props.get(key);
        return obj == null ? defaultValue.invoke() : obj;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.props.entrySet().iterator();
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public void set(SemanticsPropertyKey key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        if ((obj instanceof AccessibilityAction) && contains(key)) {
            Object obj2 = this.props.get(key);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            AccessibilityAction accessibilityAction = (AccessibilityAction) obj2;
            Map map = this.props;
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
            String label = accessibilityAction2.getLabel();
            if (label == null) {
                label = accessibilityAction.getLabel();
            }
            Function action = accessibilityAction2.getAction();
            if (action == null) {
                action = accessibilityAction.getAction();
            }
            map.put(key, new AccessibilityAction(label, action));
            return;
        }
        this.props.put(key, obj);
    }

    public final boolean contains(SemanticsPropertyKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.props.containsKey(key);
    }

    public final void mergeChild$ui_release(SemanticsConfiguration child) {
        Intrinsics.checkNotNullParameter(child, "child");
        for (Map.Entry entry : child.props.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
            Object value = entry.getValue();
            Object obj = this.props.get(semanticsPropertyKey);
            Intrinsics.checkNotNull(semanticsPropertyKey, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
            Object merge = semanticsPropertyKey.merge(obj, value);
            if (merge != null) {
                this.props.put(semanticsPropertyKey, merge);
            }
        }
    }

    public final void collapsePeer$ui_release(SemanticsConfiguration peer) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        if (peer.isMergingSemanticsOfDescendants) {
            this.isMergingSemanticsOfDescendants = true;
        }
        if (peer.isClearingSemantics) {
            this.isClearingSemantics = true;
        }
        for (Map.Entry entry : peer.props.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
            Object value = entry.getValue();
            if (!this.props.containsKey(semanticsPropertyKey)) {
                this.props.put(semanticsPropertyKey, value);
            } else if (value instanceof AccessibilityAction) {
                Object obj = this.props.get(semanticsPropertyKey);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                Map map = this.props;
                String label = accessibilityAction.getLabel();
                if (label == null) {
                    label = ((AccessibilityAction) value).getLabel();
                }
                Function action = accessibilityAction.getAction();
                if (action == null) {
                    action = ((AccessibilityAction) value).getAction();
                }
                map.put(semanticsPropertyKey, new AccessibilityAction(label, action));
            }
        }
    }

    public final SemanticsConfiguration copy() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        semanticsConfiguration.isClearingSemantics = this.isClearingSemantics;
        semanticsConfiguration.props.putAll(this.props);
        return semanticsConfiguration;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SemanticsConfiguration) {
            SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) obj;
            return Intrinsics.areEqual(this.props, semanticsConfiguration.props) && this.isMergingSemanticsOfDescendants == semanticsConfiguration.isMergingSemanticsOfDescendants && this.isClearingSemantics == semanticsConfiguration.isClearingSemantics;
        }
        return false;
    }

    public int hashCode() {
        return (((this.props.hashCode() * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.isMergingSemanticsOfDescendants)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.isClearingSemantics);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (this.isMergingSemanticsOfDescendants) {
            sb.append("");
            sb.append("mergeDescendants=true");
            str = ", ";
        }
        if (this.isClearingSemantics) {
            sb.append(str);
            sb.append("isClearingSemantics=true");
            str = ", ";
        }
        for (Map.Entry entry : this.props.entrySet()) {
            Object value = entry.getValue();
            sb.append(str);
            sb.append(((SemanticsPropertyKey) entry.getKey()).getName());
            sb.append(" : ");
            sb.append(value);
            str = ", ";
        }
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + "{ " + ((Object) sb) + " }";
    }
}
