package androidx.compose.ui.modifier;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModifierLocalModifierNode.kt */
/* loaded from: classes.dex */
public final class BackwardsCompatLocalMap extends ModifierLocalMap {
    private ModifierLocalProvider element;

    public final void setElement(ModifierLocalProvider modifierLocalProvider) {
        Intrinsics.checkNotNullParameter(modifierLocalProvider, "<set-?>");
        this.element = modifierLocalProvider;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackwardsCompatLocalMap(ModifierLocalProvider element) {
        super(null);
        Intrinsics.checkNotNullParameter(element, "element");
        this.element = element;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public Object get$ui_release(ModifierLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key != this.element.getKey()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return this.element.getValue();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(ModifierLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key == this.element.getKey();
    }
}
